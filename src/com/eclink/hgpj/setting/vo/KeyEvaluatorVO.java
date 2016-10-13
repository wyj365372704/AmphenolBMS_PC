package com.eclink.hgpj.setting.vo;

import java.util.Date;

import com.eclink.hgpj.base.BaseVO;

/**
 * 按键式评价VO
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
public class KeyEvaluatorVO extends BaseVO {
	private Integer	id;
	private String	keyNo;// 按键器评价器编号
	private Integer	windowId;// 所属窗口
	private String windowName;// 窗口名
	private Integer	orgId;// 所属科室
	private String	orgIds;// 所属科室, 逗号隔开，查询用
	private String orgName;// 科室名
	private Integer	customsId;// 所属关区
	private String customsName;// 关区名
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

	public String getKeyNo() {
		return keyNo;
	}

	public void setKeyNo(String keyNo) {
		this.keyNo = keyNo;
	}

	public Integer getWindowId() {
		return windowId;
	}

	public void setWindowId(Integer windowId) {
		this.windowId = windowId;
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

	public String getWindowName() {
		return windowName;
	}

	public void setWindowName(String windowName) {
		this.windowName = windowName;
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

	public Integer getCustomsId() {
		return customsId;
	}

	public void setCustomsId(Integer customsId) {
		this.customsId = customsId;
	}

	public String getCustomsName() {
		return customsName;
	}

	public void setCustomsName(String customsName) {
		this.customsName = customsName;
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
	    
	    retValue.append("KeyEvaluatorVO[")
	        .append("id = ").append(this.id).append(TAB)
	        .append("keyNo = ").append(this.keyNo).append(TAB)
	        .append("windowId = ").append(this.windowId).append(TAB)
	        .append("createUser = ").append(this.createUser).append(TAB)
	        .append("createDate = ").append(this.createDate).append(TAB)
	        .append("lastUpdateUser = ").append(this.lastUpdateUser).append(TAB)
	        .append("lastUpdateDate = ").append(this.lastUpdateDate).append(TAB)
	        .append("]");
	    
	    return retValue.toString();
	}
}
