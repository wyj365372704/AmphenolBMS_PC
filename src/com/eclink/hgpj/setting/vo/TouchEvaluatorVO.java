package com.eclink.hgpj.setting.vo;

import java.util.Date;

import com.eclink.hgpj.base.BaseVO;

/**
 * 触摸式评价VO
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
public class TouchEvaluatorVO extends BaseVO {
    private Integer id;
    private String touchNo;
    private Integer orgId;
    private String orgName;
    private String createUser;
    private Date createDate;
    private String lastUpdateUser;
    private Date lastUpdateDate;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTouchNo() {
		return touchNo;
	}
	public void setTouchNo(String touchNo) {
		this.touchNo = touchNo;
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
	/**
	 * override toString
	 */
	public String toString()
	{
	    final String TAB = ",";
	
	    StringBuilder retValue = new StringBuilder();
	    
	    retValue.append("TouchEvaluatorVO[")
	        .append("id = ").append(this.id).append(TAB)
	        .append("touchNo = ").append(this.touchNo).append(TAB)
	        .append("orgId = ").append(this.orgId).append(TAB)
	        .append("createUser = ").append(this.createUser).append(TAB)
	        .append("createDate = ").append(this.createDate).append(TAB)
	        .append("lastUpdateUser = ").append(this.lastUpdateUser).append(TAB)
	        .append("lastUpdateDate = ").append(this.lastUpdateDate).append(TAB)
	        .append("]");
	    
	    return retValue.toString();
	}
}
