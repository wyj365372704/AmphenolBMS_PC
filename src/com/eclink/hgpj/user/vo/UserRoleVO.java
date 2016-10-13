package com.eclink.hgpj.user.vo;

import com.eclink.hgpj.base.BaseVO;

/**
 * UserRoleVO.java
 *
 * @Title: 用户角色VO类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 23, 2013 2:46:04 PM
 *
 */
public class UserRoleVO extends BaseVO {
	/** 用户ID */
	private Integer userId;
	
	/** 角色ID */
	private Integer roleId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
