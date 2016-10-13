package com.eclink.hgpj.setting.vo;

import java.util.Date;

import com.eclink.hgpj.base.BaseVO;
/**
 * 窗口设置VO
 * 
 * @Title:
 * @Description:
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司
 * @author 周灵舟
 * @version 1.0
 * @date May 16, 2013 11:12:33 AM
 * 
 */
public class WindowVO extends BaseVO {
	private Integer	id;
	private String	name;// 窗口名
	private String	status;// 状态
	private Integer	orgId;// 所属科室
	private String	orgIds;// 所属科室ID，逗号隔开，查询用
	private String	orgName;// 科室名
	private Integer	parentOrg;// 关口
	private String	parentOrgName;// 关口名
	private String	createUser;
	private Date	createDate;
	private String	lastUpdateUser;
	private Date	lastUpdateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
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

	public Integer getParentOrg() {
		return parentOrg;
	}

	public void setParentOrg(Integer parentOrg) {
		this.parentOrg = parentOrg;
	}

	public String getParentOrgName() {
		return parentOrgName;
	}

	public void setParentOrgName(String parentOrgName) {
		this.parentOrgName = parentOrgName;
	}

	public String getOrgIds() {
		return orgIds;
	}

	public void setOrgIds(String orgIds) {
		this.orgIds = orgIds;
	}

	/**
	 * override toString
	 */
	public String toString()
	{
	    final String TAB = ",";
	
	    StringBuilder retValue = new StringBuilder();
	    
	    retValue.append("WindowVO[")
	        .append("id = ").append(this.id).append(TAB)
	        .append("name = ").append(this.name).append(TAB)
	        .append("status = ").append(this.status).append(TAB)
	        .append("orgId = ").append(this.orgId).append(TAB)
	        .append("createUser = ").append(this.createUser).append(TAB)
	        .append("createDate = ").append(this.createDate).append(TAB)
	        .append("lastUpdateUser = ").append(this.lastUpdateUser).append(TAB)
	        .append("lastUpdateDate = ").append(this.lastUpdateDate).append(TAB)
	        .append("]");
	    
	    return retValue.toString();
	}
}