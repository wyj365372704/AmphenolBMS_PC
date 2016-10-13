package com.eclink.hgpj.resource.vo;

import com.eclink.hgpj.base.BaseVO;

/**
 * AddressVO.java
 *
 * @Title: 操作URL地址VO类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date Mar 8, 2012 4:30:24 PM
 *
 */
public class AddressVO extends BaseVO {
	/**
     * 地址ID
     */
    private Integer addressId;

    /**
     * 菜单资源ID
     */
    private Integer menuId;

    /**
     * 操作KEY
     */
    private String operKey;

    /**
     * 地址URL
     */
    private String addressUrl;

    /**
     * 地址名称
     */
    private String addressName;

    /**
     * 参数名1
     */
    private String paraName1;

    /**
     * 参数值1
     */
    private String paraValue1;

    /**
     * 参数名2
     */
    private String paraName2;

    /**
     * 参数值2
     */
    private String paraValue2;

    /**
     * 参数名3
     */
    private String paraName3;

    /**
     * 参数值3
     */
    private String paraValue3;
    
    /**
     * 修改前操作KEY
     */
    private String oldOperKey;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getOperKey() {
		return operKey;
	}

	public void setOperKey(String operKey) {
		this.operKey = operKey;
	}

	public String getAddressUrl() {
		return addressUrl;
	}

	public void setAddressUrl(String addressUrl) {
		this.addressUrl = addressUrl;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getParaName1() {
		return paraName1;
	}

	public void setParaName1(String paraName1) {
		this.paraName1 = paraName1;
	}

	public String getParaValue1() {
		return paraValue1;
	}

	public void setParaValue1(String paraValue1) {
		this.paraValue1 = paraValue1;
	}

	public String getParaName2() {
		return paraName2;
	}

	public void setParaName2(String paraName2) {
		this.paraName2 = paraName2;
	}

	public String getParaValue2() {
		return paraValue2;
	}

	public void setParaValue2(String paraValue2) {
		this.paraValue2 = paraValue2;
	}

	public String getParaName3() {
		return paraName3;
	}

	public void setParaName3(String paraName3) {
		this.paraName3 = paraName3;
	}

	public String getParaValue3() {
		return paraValue3;
	}

	public void setParaValue3(String paraValue3) {
		this.paraValue3 = paraValue3;
	}

	public String getOldOperKey() {
		return oldOperKey;
	}

	public void setOldOperKey(String oldOperKey) {
		this.oldOperKey = oldOperKey;
	}
}
