package com.eclink.hgpj.role.vo;

import java.util.Date;

import com.eclink.hgpj.base.BaseVO;

/**
 * RoleVO.java
 *
 * @Title:角色值对象类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 16, 2013 11:22:18 AM 
 *
 */
public class RoleVO extends BaseVO{

	private static final long serialVersionUID = 1L;

	/** 角色ID */
    private Integer roleId;

    /** 角色名称 */
    private String roleName;

    /** 角色描述 */
    private String roleDesc;
    
    /** 所属关区ID */
	private Integer customsId;
	
	/** 所属关区名称 */
	private String customsName;
	
	/** 所属科室ID */
	private Integer orgId;
	
	/** 所属科室名称 */
	private String orgName;

    /** 创建用户 */
    private String createUser;

    /** 创建时间 */
    private Date createDate;
    
    /** 最后修改用户 */
	private String lastUpdateUser;
	
	/** 最后修改时间 */
	private Date lastUpdateDate;
	
	/** 历史角色名称 */
	private String oldRoleName;
	
	/** 是否选中 */
	private String isSelected; 
	
	private String orgIds;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Integer getCustomsId() {
		return customsId;
	}

	public void setCustomsId(Integer customsId) {
		this.customsId = customsId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getCustomsName() {
		return customsName;
	}

	public void setCustomsName(String customsName) {
		this.customsName = customsName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOldRoleName() {
		return oldRoleName;
	}

	public void setOldRoleName(String oldRoleName) {
		this.oldRoleName = oldRoleName;
	}

	public String getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(String isSelected) {
		this.isSelected = isSelected;
	}
	
	public String getOrgIds() {
		return orgIds;
	}

	public void setOrgIds(String orgIds) {
		this.orgIds = orgIds;
	}

	@Override
	public boolean equals(Object obj) {
		return this.roleId.equals(((RoleVO) obj).getRoleId());
	}
}