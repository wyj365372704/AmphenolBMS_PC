package com.eclink.hgpj.role.vo;

import com.eclink.hgpj.base.BaseVO;

/**
 * RoleResourceVO.java
 *
 * @Title: 角色资源VO类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 23, 2013 2:21:41 PM
 *
 */
public class RoleResourceVO extends BaseVO {
	/**
     *　操作key
     */
    private String operKey;

    /**
     * 组织ID
     */
    private Integer orgId;

    /**
     * 资源ID
     */
    private Integer menuId;

    /**
     * 角色ID
     */
    private Integer roleId;

	public String getOperKey() {
		return operKey;
	}

	public void setOperKey(String operKey) {
		this.operKey = operKey;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
