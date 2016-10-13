package com.eclink.hgpj.organization.vo;

import java.util.Date;
import java.util.List;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.dictionary.DictCache;

/**
 * OrgVO.java
 *
 * @Title:组织机构值对象类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 16, 2013 11:38:37 AM
 *
 */
public class OrgVO extends BaseVO {
	
	private static final long serialVersionUID = 1L;

	/** 组织ID */
	private Integer orgId;
	
	/** 组织名称 */
    private String orgName;

    /** 组织描述 */
    private String orgDesc;
    
    /** 组织类型：Z-总关、F-分关、K-科室 */
    private String orgType;

    /** 父组织ID */
    private Integer parentOrg;
    
    /** 父组织名称 */
    private String parentOrgName;
    
    /** 组织状态 */
    private String orgStatus;
    
    /** 创建用户 */
    private String createUser;

    /** 创建时间 */
    private Date createDate;
    
    /** 最后修改用户 */
	private String lastUpdateUser;
	
	/** 最后修改时间 */
	private Date lastUpdateDate;
	
	/** 组织类型别名 */
	private String orgTypeAlias;
	
	/** 组织类型数据字典列表 */
	private List orgTypeList;
	
	/** 历史组织名称 */
	private String oldOrgName;

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

	public String getOrgDesc() {
		return orgDesc;
	}

	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public Integer getParentOrg() {
		if (parentOrg == null)
			return -1;
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

	public String getOrgStatus() {
		return orgStatus;
	}

	public void setOrgStatus(String orgStatus) {
		this.orgStatus = orgStatus;
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

	public String getOrgTypeAlias() {
		return DictCache.getInstance().getAlias(HGPJConstant.DICT_ORG_TYPE, orgType);
	}

	public List getOrgTypeList() {
		return DictCache.getInstance().getValidDictList(HGPJConstant.DICT_ORG_TYPE);
	}

	public String getOldOrgName() {
		return oldOrgName;
	}

	public void setOldOrgName(String oldOrgName) {
		this.oldOrgName = oldOrgName;
	}
	
}
