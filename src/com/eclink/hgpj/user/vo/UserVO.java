package com.eclink.hgpj.user.vo;

import java.util.Date;
import java.util.List;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.dictionary.DictCache;

/**
 * UserVO.java
 *
 * @Title: 用户值对象类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.

 * @version 1.0
 * @date May 16, 2013 10:55:49 AM
 *
 */
public class UserVO extends BaseVO {
	
	private static final long serialVersionUID = 1L;

	/** 用户ID */
	private Integer userId;
	
	/** 域用户名 */
	private String userName;
	
	/** 真实姓名 */
	private String realName;
	
	/** 工号 */
	private String employeeNumber;
	
	/** 职务 */
	private String position;
	
	/** 用户状态：NORMAL-正常、DELETED-已删除 */
	private String status;
	
	/** 性别：U-未知、M-男、F-女 */
	private String sex;
	
	/** 联系电话 */
	private String telephone;
	
	/** 手机号码 */
	private String mobile;
	
	/** 邮箱地址 */
	private String email;
	
	/** 数据访问权限：A-总关级、P-分关级、O-科室级、N-无 */
	private String dataAccessPerm;
	
	/** 是否可评价：Y-是、N-否 */
	private String isEvaluated;
	
	/** 照片地址 */
	private String photo;
	
	/** 所属关区 */
	private Integer customsId;
	
	/** 所属关区名称 */
	private String customsName;
	
	/** 所属科室 */
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
	
	/** 是否可评价中文别名 */
	private String isEvaluatedAlias;
	
	/** 是否可评价数据字典列表 */
	private List isEvaluatedList;
	
	/** 性别别名 */
	private String sexAlias;
	
	/** 性别数据字典列表 */
	private List sexList;
	
	/** 数据访问权限别名 */
	private String dataAccessPermAlias;
	
	/** 数据访问权限数据字典列表 */
	private List dataAccessPermList;
	
	/** 用户状态数据字典列表 */
	private List statusList;
	
	/** 用户状态别名 */
	private String statusAlias;
	
	/** 用户所属机构及下级机构ID */
	private String orgIds;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataAccessPerm() {
		return dataAccessPerm;
	}

	public void setDataAccessPerm(String dataAccessPerm) {
		this.dataAccessPerm = dataAccessPerm;
	}

	public String getIsEvaluated() {
		return isEvaluated;
	}

	public void setIsEvaluated(String isEvaluated) {
		this.isEvaluated = isEvaluated;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public String getIsEvaluatedAlias() {
		return DictCache.getInstance().getAlias(HGPJConstant.DICT_IS_EVALUATED, isEvaluated);
	}

	public List getIsEvaluatedList() {
		return DictCache.getInstance().getValidDictList(HGPJConstant.DICT_IS_EVALUATED);
	}

	public String getSexAlias() {
		return DictCache.getInstance().getAlias(HGPJConstant.DICT_SEX, sex);
	}

	public List getSexList() {
		return DictCache.getInstance().getValidDictList(HGPJConstant.DICT_SEX);
	}

	public String getDataAccessPermAlias() {
		return DictCache.getInstance().getAlias(HGPJConstant.DICT_DATA_ACCESS_PERM, dataAccessPerm);
	}

//	public List getDataAccessPermList() {
//		return DictCache.getInstance().getValidDictList(HGPJConstant.DICT_DATA_ACCESS_PERM);
//	}

	public List getStatusList() {
		return DictCache.getInstance().getValidDictList(HGPJConstant.DICT_USER_STATUS);
	}

	public String getStatusAlias() {
		return DictCache.getInstance().getAlias(HGPJConstant.DICT_USER_STATUS, status);
	}

	public List getDataAccessPermList() {
		return dataAccessPermList;
	}

	public void setDataAccessPermList(List dataAccessPermList) {
		this.dataAccessPermList = dataAccessPermList;
	}

	public String getOrgIds() {
		return orgIds;
	}

	public void setOrgIds(String orgIds) {
		this.orgIds = orgIds;
	}
	
}
