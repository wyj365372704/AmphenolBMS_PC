package com.eclink.hgpj.setting.vo;

import java.util.Date;

import com.eclink.hgpj.base.BaseVO;

/**
 * 业务设置VO
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
public class ServiceVO extends BaseVO{

	private Integer	id;
	private String	name;// 业务名
	private String	status;// 状态， 0-已删除、1-正常
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

	/**
	 * override toString
	 */
	public String toString()
	{
	    final String TAB = ",";
	
	    StringBuilder retValue = new StringBuilder();
	    
	    retValue.append("ServiceVO[")
	        .append("id = ").append(this.id).append(TAB)
	        .append("name = ").append(this.name).append(TAB)
	        .append("status = ").append(this.status).append(TAB)
	        .append("createUser = ").append(this.createUser).append(TAB)
	        .append("createDate = ").append(this.createDate).append(TAB)
	        .append("lastUpdateUser = ").append(this.lastUpdateUser).append(TAB)
	        .append("lastUpdateDate = ").append(this.lastUpdateDate).append(TAB)
	        .append("]");
	    
	    return retValue.toString();
	}
}