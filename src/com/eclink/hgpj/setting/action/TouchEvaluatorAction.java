package com.eclink.hgpj.setting.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.eclink.dfcm.paginator.common.PaginatorUtil;
import com.eclink.dfcm.paginator.tag.PageVO;
import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.organization.biz.OrgService;
import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.setting.biz.TouchEvaluatorService;
import com.eclink.hgpj.setting.vo.TouchEvaluatorVO;

/**
 * 触摸式设置Action
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
public class TouchEvaluatorAction extends BaseAction {
	private static final Logger log = Logger.getLogger(TouchEvaluatorAction.class);
	private TouchEvaluatorVO touchEvaluator = new TouchEvaluatorVO();
	private List<TouchEvaluatorVO> touchEvaluators;
	private TouchEvaluatorService touchEvaluatorService;
	private OrgService orgService;
	
	private void setBase(TouchEvaluatorVO t) {
		Date now = new Date();
		t.setCreateDate(now);
		t.setLastUpdateDate(now);
		if(getLoginUser() != null){
			t.setCreateUser(getLoginUser().getUserName());
			t.setLastUpdateUser(getLoginUser().getUserName());
		}else{
			t.setCreateUser("");
			t.setLastUpdateUser("");
		}
	}
	private void init() throws Exception {
		// 根据当前用户权限取出能设置的所属关区
		List<OrgVO> orgs = orgService.queryCustomsOrg();
		// 判断用户类型，总关查询所有数据，分关只能查询本关数据
		if (!isHeadUser()) {
			touchEvaluator.setOrgId(getCustomsOfLoginUser().getOrgId());
		}
		
		getRequest().setAttribute("orgs", orgs);
	}
	
	/**
	 * 列表查询
	 *  
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {

		try {
			// 获取分页信息
			PageVO page = PaginatorUtil.getPaginator(getRequest());
			setPagination(touchEvaluator,page);
			
			// 初始化，所属关区
			init();
			// 查询总记录数
			if (page.isQueryTotal()) {
				page.setTotalRecord(touchEvaluatorService.queryListCount(touchEvaluator));
			}
			
			// 调用业务方法查询列表
			touchEvaluators = touchEvaluatorService.queryList(touchEvaluator);
			
			// 分页对象保存至request
			getRequest().setAttribute(HGPJConstant.PAGE_KEY, page);
		} catch (Exception e) {
			log.error("query touchEvaluator error." ,e);
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 查看
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception{
		try {
			touchEvaluator = touchEvaluatorService.queryById(touchEvaluator.getId());
		} catch (Exception e) {
			log.error("view touchEvaluator error." ,e);
			return ERROR;
		}
		return "view";
	}
	/**
	 * 进入新增页面
	 * @return
	 * @throws Exception
	 */
	public String toInsert() throws Exception{
		try {
			// 初始化，所属关区
			init();
		} catch (Exception e) {
			log.error("toInsert touchEvaluator error." ,e);
			return ERROR;
		}
		return "new";
	}
	/**
	 * 增加
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception{
		
		try {
			TouchEvaluatorVO params = new TouchEvaluatorVO();
			params.setTouchNo(touchEvaluator.getTouchNo());
			List<TouchEvaluatorVO> lists = touchEvaluatorService.queryList(params);
			
			if(lists != null && lists.size() > 0){
				setErrorMsg("评价器编号["+touchEvaluator.getTouchNo()+"]已存在，请重新输入");
				return "error";
			}
			
			setBase(touchEvaluator);
			touchEvaluatorService.insert(touchEvaluator);
		} catch (Exception e) {
			log.error("insert touchEvaluator error." ,e);
			return ERROR;
		}
		
		setBackUrl("/setting/touchEvaluator!list.action");
		return "info";
	}
	/**
	 * 进入修改页面
	 * @return
	 * @throws Exception
	 */
	public String toModify() throws Exception{
		try {
			// 初始化，所属关区
			init();
			touchEvaluator = touchEvaluatorService.queryById(touchEvaluator.getId());
		} catch (Exception e) {
			log.error("toModify touchEvaluator error." ,e);
			return ERROR;
		}
		return "modify";
	}
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	public String modify() throws Exception{
		try{
			TouchEvaluatorVO params = new TouchEvaluatorVO();
			params.setTouchNo(touchEvaluator.getTouchNo());
			params.setId(touchEvaluator.getId());
			List<TouchEvaluatorVO> lists = touchEvaluatorService.queryList(params);
			
			if(lists != null && lists.size() > 0){
				setErrorMsg("评价器编号["+touchEvaluator.getTouchNo()+"]已存在，请重新输入");
				return "error";
			}
			
			setBase(touchEvaluator);
			touchEvaluatorService.modify(touchEvaluator);
		}catch(Exception e){
			log.error("modify touchEvaluator error." ,e);
			return ERROR;
		}
		setBackUrl("/setting/touchEvaluator!list.action");
		return "info";
	}
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		if(touchEvaluator != null && touchEvaluator.getId() != null){
			touchEvaluatorService.delete(touchEvaluator);
		}
		setBackUrl("/setting/touchEvaluator!list.action");
		return "info";
	}

	public TouchEvaluatorVO getTouchEvaluator() {
		return touchEvaluator;
	}

	public void setTouchEvaluator(TouchEvaluatorVO touchEvaluator) {
		this.touchEvaluator = touchEvaluator;
	}

	public List<TouchEvaluatorVO> getTouchEvaluators() {
		return touchEvaluators;
	}

	public void setTouchEvaluators(List<TouchEvaluatorVO> touchEvaluators) {
		this.touchEvaluators = touchEvaluators;
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
