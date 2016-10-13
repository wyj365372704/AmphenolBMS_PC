package com.eclink.hgpj.common;

import java.io.Serializable;
import java.util.Map;

import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.user.vo.UserVO;

/**
 * UserLoginInfo.java
 *
 * @Title: 登录用户的所有信息类
 * @Description: 用于保存已经登录系统的用户相关信息,包括用户对象,用户所属组织对象等
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date Nov 16, 2011 9:52:49 AM
 *
 */
public class UserLoginInfo implements Serializable{
	
	/**
	 * 登录用户对象
	 */
	private UserVO user;
	
	/**
	 * 登录用户所属组织对象
	 */
	private OrgVO org;
	
	/**
	 * 登录用户所属海关对象
	 */
	private OrgVO customs;
	
	/**
	 * 登录用户拥有的菜单资源操作[key=menuKey|operKey]
	 */
	private Map<String, Object> resourceOpers;
	
	/**
	 * 登录用户可以访问的URL地址[key=url]
	 */
	private Map<String, Object> urls;

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}
	
	public OrgVO getOrg() {
		return org;
	}

	public void setOrg(OrgVO org) {
		this.org = org;
	}
	
	public OrgVO getCustoms() {
		return customs;
	}

	public void setCustoms(OrgVO customs) {
		this.customs = customs;
	}

	public Map<String, Object> getResourceOpers() {
		return resourceOpers;
	}

	public void setResourceOpers(Map<String, Object> resourceOpers) {
		this.resourceOpers = resourceOpers;
	}

	public Map<String, Object> getUrls() {
		return urls;
	}

	public void setUrls(Map<String, Object> urls) {
		this.urls = urls;
	}
}
