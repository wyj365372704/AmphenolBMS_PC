package com.eclink.hgpj.dictionary.vo;

import com.eclink.hgpj.base.BaseVO;

/**
 * Dictionary.java
 *
 * @Title: 数据字典VO类
 * @Description: 
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date Nov 9, 2011 7:26:20 PM
 *
 */
public class DictionaryVO extends BaseVO {
	
	private static final long serialVersionUID = 1L;	
	
	/** 是否有效可见标识：有效 */
	public static final String VALID_FLAG_YES = "1";
	
	/** 是否有效可见标识：无效 */
	public static final String VALID_FLAG_NO = "0";

	/** 类型码 */
	private String codeType;
	
	/** 类型码描述 */
	private String typeDesc;
	
	/** 数据键 */
	private String key;
	
	/** 数据值 */
	private String value;
	
	/** 是否有效或可见：1-是、0-否 */
	private String isValid;
	
	/** 排序 */
	private Integer orderId;

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
}
