package com.eclink.hgpj.setting.action;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.eclink.dfcm.paginator.common.PaginatorUtil;
import com.eclink.dfcm.paginator.tag.PageVO;
import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.organization.biz.OrgService;
import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.setting.biz.KeyEvaluatorService;
import com.eclink.hgpj.setting.biz.WindowService;
import com.eclink.hgpj.setting.vo.KeyEvaluatorVO;
import com.eclink.hgpj.setting.vo.WindowVO;

/**
 * 按键式设置Action
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
public class WindowAction extends BaseAction {
	private static final Logger log = Logger.getLogger(WindowAction.class);
	private WindowVO window = new WindowVO();
	private List<WindowVO> windows;
	private WindowService windowService;
	private KeyEvaluatorService keyEvaluatorService;
	private OrgService orgService;
	private String messageData;
	
	private void setBase(WindowVO t) {
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
			window.setParentOrg(getCustomsOfLoginUser().getOrgId());
		}
		
		getRequest().setAttribute("orgs", orgs);
	}
	/**
	 * 根据科室ID获得所有窗口列表
	 * @return
	 * @throws Exception
	 */
	public String getChildWindow() throws Exception{
		windows = windowService.queryList(window);
		StringBuilder sb = new StringBuilder();
		if(windows != null && windows.size() > 0){
			sb.append("{data:[");
			for (int i = 0,len = windows.size(); i < len; i++) {
				WindowVO win = windows.get(i);
				sb.append("{\"label\":\"");
				sb.append(win.getName());
				sb.append("\",\"value\":");
				sb.append(win.getId());
				sb.append("}");
				if (i<len-1) {
					sb.append(",");
				}
			}
			sb.append("]}");
			messageData = sb.toString();
		}
		return "messageData";
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
			setPagination(window,page);
			
			// 初始化，所属关区
			init();
			if(window.getParentOrg() != null){
				List<OrgVO> orgVos = orgService.queryChildOrgByOrgId(window.getParentOrg());
				StringBuilder sb = new StringBuilder();
				for (OrgVO vo : orgVos) {
					sb.append(vo.getOrgId()).append(",");
				}
				sb.append(window.getParentOrg());
//				String ids = sb.toString().replaceAll(",$", "");
				window.setOrgIds(sb.toString());
			}
			// 查询总记录数
			if (page.isQueryTotal()) {
				page.setTotalRecord(windowService.queryListCount(window));
			}
			// 调用业务方法查询列表
			windows = windowService.queryList(window);
			if(windows.size() > 0){
				for (WindowVO win : windows) {
					OrgVO vo = orgService.queryParentOrgById(win.getOrgId());
					win.setParentOrg(vo.getOrgId());
					win.setParentOrgName(vo.getOrgName());
				}
			}
			
			// 分页对象保存至request
			getRequest().setAttribute(HGPJConstant.PAGE_KEY, page);
		} catch (Exception e) {
			log.error("query window error." ,e);
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
			window = windowService.queryById(window.getId());
		} catch (Exception e) {
			log.error("view window error." ,e);
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
			log.error("toInsert window error." ,e);
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
			WindowVO params = new WindowVO();
			params.setName(window.getName());
			params.setOrgId(window.getOrgId());
			List<WindowVO> lists = windowService.queryList(params);
			
			if(lists != null && lists.size() > 0){
				setErrorMsg("窗口名称["+window.getName()+"]已存在，请重新输入！");
				return "error";
			}
			
			setBase(window);
			windowService.insert(window);
		} catch (Exception e) {
			log.error("insert window error." ,e);
			return ERROR;
		}
		
		setBackUrl("/setting/window!list.action");
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
			window = windowService.queryById(window.getId());
			OrgVO vo = orgService.queryParentOrgById(window.getOrgId());
			window.setParentOrg(vo.getOrgId());
			window.setParentOrgName(vo.getOrgName());
		} catch (Exception e) {
			log.error("toModify window error." ,e);
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
			WindowVO params = new WindowVO();
			params.setName(window.getName());
			params.setId(window.getId());
			params.setOrgId(window.getOrgId());
			List<WindowVO> lists = windowService.queryList(params);
			
			if(lists != null && lists.size() > 0){
				setErrorMsg("窗口名称["+window.getName()+"]已存在，请重新输入！");
				return "error";
			}
			
			setBase(window);
			windowService.modify(window);
		}catch(Exception e){
			log.error("modify window error." ,e);
			return ERROR;
		}
		setBackUrl("/setting/window!list.action");
		return "info";
	}
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		if(window != null && window.getId() != null){
			KeyEvaluatorVO param = new KeyEvaluatorVO();
			param.setWindowId(window.getId());
			List<KeyEvaluatorVO> vos = keyEvaluatorService.queryList(param);
			if(vos != null && vos.size() > 0){
				setErrorMsg("该窗口已被按键式评价器引用，不能删除！");
				return ERROR;
			}
			windowService.delete(window);
		}
		setBackUrl("/setting/window!list.action");
		return "info";
	}

	public WindowVO getWindow() {
		return window;
	}

	public void setWindow(WindowVO window) {
		this.window = window;
	}

	public List<WindowVO> getWindows() {
		return windows;
	}

	public void setWindows(List<WindowVO> windows) {
		this.windows = windows;
	}
	public void setWindowService(WindowService windowService) {
		this.windowService = windowService;
	}
	public OrgService getOrgService() {
		return orgService;
	}
	public void setOrgService(OrgService orgService) {
		this.orgService = orgService;
	}
	public String getMessageData() {
		return messageData;
	}
	public void setMessageData(String messageData) {
		this.messageData = messageData;
	}
	public void setKeyEvaluatorService(KeyEvaluatorService keyEvaluatorService) {
		this.keyEvaluatorService = keyEvaluatorService;
	}
	
	
}
