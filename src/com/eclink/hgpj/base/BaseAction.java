package com.eclink.hgpj.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.eclink.dfcm.paginator.config.PaginatorConfig;
import com.eclink.dfcm.paginator.tag.PageVO;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.common.UserLoginInfo;
import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.user.vo.UserVO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * BaseAction.java
 *
 * @Title: Action基类
 * @Description: 所有业务Action继承此基类，提供基础服务
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.

 * @version 1.0
 * @date Nov 8, 2011 11:50:57 PM
 *
 */
public class BaseAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	/** 
	 * 当前页码 
	 */
	private int goPage = 1;
	
	/** 
	 * 分页大小 
	 */
	private int pageSize = PaginatorConfig.pageSize;
	
	/** 
	 * 是否分页标签提交表单,用于解决用户重新输入查询条件无法获取记录问题 
	 */
	private String isPageSubmit = "false";
	
	/**
	 * 错误提示信息
	 */
	private String errorMsg = "系统错误，请联系系统管理员！";
	
	/**
	 * 操作提示信息
	 */
	private String infoMsg = "操作成功！";
	
	/**
	 * 进入提示信息页面的回退url地址,默认返回上一页
	 */
	private String backUrl = "back";
		
	/**
	 * 设置分页信息，从第几条记录到第几条记录
	 *  
	 * @param baseVO
	 */
	public void setPagination(BaseVO base,PageVO page) {
		// 分页标签提交表单，按实际提交页码与页大小查询
		if ("true".equals(isPageSubmit)) {
			base.setFrom((getGoPage() - 1) * getPageSize());
			base.setPageSize(getPageSize());
		} else { // 查询按钮提交表单，从第1页开始查询，同时将PageVO的当前页也设置为1
			base.setFrom(0);
			base.setPageSize(getPageSize());
			page.setCurrentPageNo(1);
		}
	}
	
	/**
	 * 获取当前登录用户所有信息(包括用户、用户所属组织、用户所属海关等信息)
	 * 
	 * @return 登录用户所有信息
	 */
	public UserLoginInfo getUserLoginInfo() {
		return (UserLoginInfo) getSession().getAttribute(
				HGPJConstant.SESSION_USER_KEY);
	}
	
	/**
	 * 获取当前登录用户信息
	 * 
	 * @return 用户信息对象
	 */
	public UserVO getLoginUser() {
		UserLoginInfo userLoginInfo = getUserLoginInfo();
		if (userLoginInfo != null) {
			return userLoginInfo.getUser();
		}
		return null;
	}

	/**
	 * 获取当前登录用户所属组织信息
	 * 
	 * @return 组织信息对象
	 */
	public OrgVO getOrgOfLoginUser() {
		UserLoginInfo userLoginInfo = getUserLoginInfo();
		if (userLoginInfo != null) {
			return userLoginInfo.getOrg();
		}
		return null;
	}
	
	/**
	 * 获取当前登录用户所属海关信息
	 * 
	 * @return 组织信息对象
	 */
	public OrgVO getCustomsOfLoginUser() {
		UserLoginInfo userLoginInfo = getUserLoginInfo();
		if (userLoginInfo != null) {
			return userLoginInfo.getCustoms();
		}
		return null;
	}
	
	/**
	 * 当前登录用户是否为总关用户
	 * true代表是，false代表否（即为分关用户）
	 * @return
	 */
	public boolean isHeadUser() {
		return HGPJConstant.SYSTEM_ROOT_ORG_ID == getLoginUser().getCustomsId();
	}
	
	/**
	 * 获取HttpServletRequest
	 * 
	 * @return HttpServletRequest
	 */
	public final HttpServletRequest getRequest() {
        HttpServletRequest request = ServletActionContext.getRequest();
        return request;
	}
	
	/**
     * 获取HttpSession
     * 
     * @return HttpSession
     */
    public final HttpSession getSession() {
        HttpServletRequest request = ServletActionContext.getRequest();
        return request.getSession();
    }
    
    /**
     * 注销时获取HttpSession
     * 
     * @return HttpSession
     */
    public final HttpSession logoutGetSession() {
    	HttpServletRequest request = ServletActionContext.getRequest();
    	return request.getSession(false);
    }
    
    /**
	 * 获取HttpServletResponse
	 * 
	 * @return HttpServletResponse
	 */
	public final HttpServletResponse getResponse() {
	    HttpServletResponse response = ServletActionContext.getResponse();
        return response;
	}

	public int getGoPage() {
		return goPage;
	}

	public void setGoPage(int goPage) {
		this.goPage = goPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getIsPageSubmit() {
		return isPageSubmit;
	}

	public void setIsPageSubmit(String isPageSubmit) {
		this.isPageSubmit = isPageSubmit;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getInfoMsg() {
		return infoMsg;
	}

	public void setInfoMsg(String infoMsg) {
		this.infoMsg = infoMsg;
	}

	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}	
}
