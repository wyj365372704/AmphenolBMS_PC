package com.eclink.hgpj.setting.vo;

import java.util.Date;

import com.eclink.hgpj.base.BaseVO;

/**
 * 参数设置VO
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
public class ParameterVO extends BaseVO{

	private Integer	id;
	private String	paraName;// 参数名
	private String	paraValue;// 参数值
	private String	paraDesc;// 描述
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

	public String getParaName() {
		return paraName;
	}

	public void setParaName(String paraName) {
		this.paraName = paraName;
	}

	public String getParaValue() {
		return paraValue;
	}

	public void setParaValue(String paraValue) {
		this.paraValue = paraValue;
	}

	public String getParaDesc() {
		return paraDesc;
	}

	public void setParaDesc(String paraDesc) {
		this.paraDesc = paraDesc;
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
	    
	    retValue.append("ParameterVO[")
	        .append("id = ").append(this.id).append(TAB)
	        .append("paraName = ").append(this.paraName).append(TAB)
	        .append("paraValue = ").append(this.paraValue).append(TAB)
	        .append("paraDesc = ").append(this.paraDesc).append(TAB)
	        .append("createUser = ").append(this.createUser).append(TAB)
	        .append("createDate = ").append(this.createDate).append(TAB)
	        .append("lastUpdateUser = ").append(this.lastUpdateUser).append(TAB)
	        .append("lastUpdateDate = ").append(this.lastUpdateDate).append(TAB)
	        .append("]");
	    
	    return retValue.toString();
	}
}