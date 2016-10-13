package com.eclink.hgpj.setting.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.organization.biz.OrgService;
import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.setting.biz.CustomsServiceService;
import com.eclink.hgpj.setting.biz.EvaluationService;
import com.eclink.hgpj.setting.biz.ParameterService;
import com.eclink.hgpj.setting.biz.TouchEvaluatorService;
import com.eclink.hgpj.setting.biz.WindowService;
import com.eclink.hgpj.setting.vo.CustomsServiceVO;
import com.eclink.hgpj.setting.vo.EvaluationVO;
import com.eclink.hgpj.setting.vo.ParameterVO;
import com.eclink.hgpj.setting.vo.TouchEvaluatorVO;
import com.eclink.hgpj.setting.vo.WindowVO;
import com.eclink.hgpj.user.biz.UserService;
import com.eclink.hgpj.user.vo.UserVO;
import com.eclink.hgpj.util.Utils;

/**
 * 前台触摸式评价Action
 *
 * @Title:
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 周灵舟
 * @version 1.0
 * @date May 16, 2013 11:00:40 AM
 *
 */
public class EvaluationAction extends BaseAction {
	private static final Logger log = Logger.getLogger(EvaluationAction.class);
	private EvaluationService evaluationService;
	private WindowService windowService;
	private ParameterService parameterService;
	private CustomsServiceService customsServiceService;
	private UserService userService;
	private TouchEvaluatorService touchEvaluatorService;
	private OrgService orgService;
	
	/**
	 * 评价实体
	 */
	private EvaluationVO evaluation = new EvaluationVO();
	/**
	 * 窗口ID
	 */
	private Integer windowId;
	/**
	 * 关员ID
	 */
	private Integer userId;
	/**
	 * 业务ID
	 */
	private Integer serviceId;
	/**
	 * 关区ID
	 */
	private Integer orgId;
	
	/**
	 * 进入身份验证页面
	 *  
	 * @return
	 * @throws Exception
	 */
	public String toLogin() throws Exception {
		return "login";
	}
	
	/**
	 * 退出评价
	 *  
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception {
		// 清空会话信息
		getSession().removeAttribute("userMap");
		getSession().removeAttribute("loginTimeMillis");
		getSession().removeAttribute("evaluatorOrgId");
		getSession().invalidate();
		return "login";
	}
	
	/**
	 * 继续评价
	 *  
	 * @return
	 * @throws Exception
	 */
	public String keepon() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 身份验证,保存身份证信息
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		try {
			// 保存身份证信息在session中
			String name = getRequest().getParameter("name");
			String sex = getRequest().getParameter("sex");
			String idCardNo = getRequest().getParameter("idCardNo");
			if (log.isDebugEnabled()) {
				log.debug("触摸式评价器用户身份证识别，身份信息：");
				log.debug("姓名=" + name);
				log.debug("性别=" + sex);
				log.debug("身份证号码=" + idCardNo);
			}
			
			ParameterVO param = parameterService.queryByName(HGPJConstant.PARAMETER_ID_TIME);
			String paraValue = param.getParaValue();
			if(paraValue != null && !"".equals(paraValue)){
				long times = (Integer.parseInt(paraValue) * 60 * 1000);
				EvaluationVO vo = new EvaluationVO();
				vo.setIdCardNo(idCardNo);
				List<EvaluationVO> vos = evaluationService.queryList(vo);
				if(vos != null && vos.size() > 0){
					Date evalTime = vos.get(0).getEvalTime();
					long time = evalTime.getTime();
					if(System.currentTimeMillis() - time < times){
						getRequest().setAttribute("tipMsg", "身份识别间隔时间不能低于 "+paraValue+" 分钟");
						return "login";
					}
				}
			}
			// 根据评价器编号得到所属关区
			String ip = Utils.getIpAddr(getRequest());
			if (log.isDebugEnabled()) {
				log.debug("触摸式评价器IP：" + ip);
			}
			TouchEvaluatorVO touchEvaluatorVO = touchEvaluatorService.queryByTouchNo(ip);
			
			Map<String, String> userMap = new HashMap<String, String>();
			userMap.put("name", name);
			userMap.put("sex", sex);
			userMap.put("idCardNo", idCardNo);
			// 记录身份信息和登录时间
			getSession().setAttribute("userMap", userMap);
			if(touchEvaluatorVO != null){
				getSession().setAttribute("evaluatorOrgId", touchEvaluatorVO.getOrgId());
			} else {
				log.error("触摸式评价器IP【" + Utils.getIpAddr(getRequest())
						+ "】，匹配海关关区失败，请检查触摸式评价器设置！");
			}
			getSession().setAttribute("loginTimeMillis", System.currentTimeMillis());
		} catch (Exception e) {
			log.error("触摸式评价器用户身份证识别登录错误.", e);
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 取出所属关区
	 * @return
	 */
	private Integer getSessionOrgId(){
		Object evaluatorOrgId = getSession().getAttribute("evaluatorOrgId");
		if(evaluatorOrgId != null){
			return Integer.parseInt(evaluatorOrgId.toString());
		}
		log.info("根据评价器IP["+Utils.getIpAddr(getRequest())+"]没有找到对应的关区，或者用户信息失效，请刷卡重新登录！");
		return null;
	}
	
	/**
	 * 窗口列表
	 *  
	 * @return
	 * @throws Exception
	 */
	public String listWindow() throws Exception {
		try {
			String checkMsg = checkTimeOut();
			if(checkMsg != null){
				setErrorMsg(checkMsg);
				return ERROR;
			}
			Integer evaluatorOrgId = getSessionOrgId();
			if(evaluatorOrgId != null){
				List<OrgVO> orgVos = orgService.queryChildOrgByOrgId(evaluatorOrgId);
				StringBuilder sb = new StringBuilder();
				for (OrgVO vo : orgVos) {
					sb.append(vo.getOrgId()).append(",");
				}
				String ids = sb.toString().replaceAll(",$", "");
				WindowVO vo = new WindowVO();
				vo.setStatus("1");
				vo.setOrgIds(ids);
				List<WindowVO> windows = windowService.queryList(vo);
				getRequest().setAttribute("windows", windows);
			}
		} catch (RuntimeException e) {
			log.error("触摸式评价器获取可评价窗口列表错误.", e);
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 业务列表
	 *  
	 * @return
	 * @throws Exception
	 */
	public String listService() throws Exception {
		try {
			String checkMsg = checkTimeOut();
			if(checkMsg != null){
				setErrorMsg(checkMsg);
				return ERROR;
			}
			Integer evaluatorOrgId = getSessionOrgId();
			if(evaluatorOrgId != null){
				List<CustomsServiceVO> services = customsServiceService.queryEvaluationList(evaluatorOrgId);
				getRequest().setAttribute("services", services);
			}
		} catch (RuntimeException e) {
			log.error("触摸式评价器获取可评价的业务列表错误.", e);
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 关员列表
	 *  
	 * @return
	 * @throws Exception
	 */
	public String listUser() throws Exception {
		try {
			String checkMsg = checkTimeOut();
			if(checkMsg != null){
				setErrorMsg(checkMsg);
				return ERROR;
			}
			Integer evaluatorOrgId = getSessionOrgId();
			if(evaluatorOrgId != null){
				UserVO vo = new UserVO();
				vo.setIsEvaluated("Y");// 去除可评价的用户列表
				vo.setCustomsId(evaluatorOrgId);
				List<UserVO> users = userService.queryUserList(vo);
				getRequest().setAttribute("users", users);
			}
		} catch (Exception e) {
			log.error("触摸式评价器获取可评价的用户列表错误.", e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 进入评价页面
	 * @return
	 * @throws Exception
	 */
	public String toInsert() throws Exception{
		try {
			String checkMsg = checkTimeOut();
			if(checkMsg != null){
				setErrorMsg(checkMsg);
				return ERROR;
			}
			if(windowId != null){
				// 窗口
				WindowVO window = windowService.queryById(windowId);
				getRequest().setAttribute("window", window);
			}else if(userId != null){
				// 关员
				UserVO user = userService.queryUserById(userId);
				getRequest().setAttribute("user", user);
			}else if(serviceId != null && orgId != null){
				// 业务
				CustomsServiceVO vo = new CustomsServiceVO();
				vo.setServiceId(serviceId);
				vo.setOrgId(orgId);
				CustomsServiceVO service = customsServiceService.queryEvaluationByOrgIdAndServiceId(vo);
				getRequest().setAttribute("service", service);
			}
		} catch (Exception e) {
			log.error("toInsert evaluation error." ,e);
			return ERROR;
		}
		return "input";
	}
	/**
	 * 保存评价
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception{
		try {
			String checkMsg = checkTimeOut();
			if(checkMsg != null){
				setErrorMsg(checkMsg);
				return ERROR;
			}
			// 设置评价器编号为触摸屏IP
			evaluation.setEvalNo(Utils.getIpAddr(getRequest()));
			evaluation.setEvalTime(new Date());
			// 窗口评价时获取窗口所属关区
			if ("W".equals(evaluation.getTouchEvalType())) {
				OrgVO customs = orgService.queryParentOrgById(evaluation.getOrgId());
				evaluation.setCustomsId(customs.getOrgId());
			}
			Map<String,String> userMap = (Map)getSession().getAttribute("userMap");
			if(userMap != null){
				evaluation.setName(userMap.get("name"));
				evaluation.setSex(userMap.get("sex"));
				evaluation.setIdCardNo(userMap.get("idCardNo"));
			}else{
				setErrorMsg("评价人的用户信息获取失败，请重新刷卡！");
				setBackUrl("/eval/evaluation!toLogin.action");
				return ERROR;
			}
			checkMsg = check();
			// 如果检查通过，才可以评价，否则提示信息
			if(checkMsg == null){
				evaluationService.insert(evaluation);
				// 刷新登录时间
				getSession().setAttribute("loginTimeMillis", System.currentTimeMillis());
			}else{
				setErrorMsg(checkMsg);
				return ERROR;
			}
		} catch (Exception e) {
			log.error("insert evaluation error." ,e);
			return ERROR;
		}
		
		return "result";
	}
	
	/**
	 * 检测评价超时时间
	 * @return
	 * @throws Exception
	 */
	private String checkTimeOut() throws Exception{
		// 检查用户是否刷身份证登录
		Object loginTimeMillis = getSession().getAttribute("loginTimeMillis");
		if (null == loginTimeMillis) {
			setBackUrl("/eval/evaluation!toLogin.action");
			return "您的会话已超时, 请重新刷身份证登录！";
		}
		// 检查评价超时
		long millis = System.currentTimeMillis() - (Long)loginTimeMillis;
		ParameterVO param = parameterService.queryByName(HGPJConstant.PARAMETER_TIMEOUT_TIME);
		String paraValue = param.getParaValue();
		if(paraValue != null && !"".equals(paraValue)){
			long times = (Integer.parseInt(paraValue) * 60 * 1000);
			if(millis > times){
				setBackUrl("/eval/evaluation!toLogin.action");
				return "您的评价已超时, 请重新刷身份证登录！";
			}
		}
		return null;
	}
	/**
	 *  检查评价次数等参数限制
	 * @return
	 * @throws Exception 
	 */
	private String check() throws Exception{
		ParameterVO param = null;
		String paraValue = null;
		
		if(evaluation.getWindowId() != null){
			// 检查窗口
			param = parameterService.queryByName(HGPJConstant.PARAMETER_WINDOW_COUNT);
			paraValue = param.getParaValue();
			if(paraValue != null && !"".equals(paraValue)){
				int count = evaluationService.queryListCount(evaluation);
				if(count >= Integer.parseInt(paraValue)){
					return "每人每天窗口评价次数不能超过 "+paraValue+" 次";
				}
			}
		}else if(evaluation.getUserName() != null){
			// 检查关员
			param = parameterService.queryByName(HGPJConstant.PARAMETER_PERSON_COUNT);
			paraValue = param.getParaValue();
			if(paraValue != null && !"".equals(paraValue)){
				int count = evaluationService.queryListCount(evaluation);
				if(count >= Integer.parseInt(paraValue)){
					return "每人每天关员评价次数不能超过 "+paraValue+" 次";
				}
			}
		}else if(evaluation.getServiceId() != null){
			// 检查业务
			param = parameterService.queryByName(HGPJConstant.PARAMETER_SERVICE_COUNT);
			paraValue = param.getParaValue();
			if(paraValue != null && !"".equals(paraValue)){
				int count = evaluationService.queryListCount(evaluation);
				if(count >= Integer.parseInt(paraValue)){
					return "每人每天业务评价次数不能超过 "+paraValue+" 次";
				}
			}
		}
		return null;
	}

	public EvaluationVO getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(EvaluationVO evaluation) {
		this.evaluation = evaluation;
	}

	public void setEvaluationService(EvaluationService evaluationService) {
		this.evaluationService = evaluationService;
	}
	public WindowService getWindowService() {
		return windowService;
	}
	public void setWindowService(WindowService windowService) {
		this.windowService = windowService;
	}

	public void setParameterService(ParameterService parameterService) {
		this.parameterService = parameterService;
	}

	public void setCustomsServiceService(CustomsServiceService customsServiceService) {
		this.customsServiceService = customsServiceService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Integer getWindowId() {
		return windowId;
	}

	public void setWindowId(Integer windowId) {
		this.windowId = windowId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public void setTouchEvaluatorService(TouchEvaluatorService touchEvaluatorService) {
		this.touchEvaluatorService = touchEvaluatorService;
	}

	public OrgService getOrgService() {
		return orgService;
	}

	public void setOrgService(OrgService orgService) {
		this.orgService = orgService;
	}
	
}
