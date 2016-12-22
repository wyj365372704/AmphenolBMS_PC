package com.eclink.hgpj.resource.vo;

import java.math.BigDecimal;
import java.util.List;

import com.eclink.hgpj.base.BaseVO;

/**
 * @Title: 资源值对象类  
 * @Description: 

 * @version 1.0
 * 
 */
public class MBBMCPPVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private BigDecimal bmaenb;
	
	private String bmdccd;
	
	private String bmcvnb;
	
	private String bmcbtx;

	public BigDecimal getBmaenb() {
		return bmaenb;
	}

	public void setBmaenb(BigDecimal bmaenb) {
		this.bmaenb = bmaenb;
	}

	public String getBmdccd() {
		return bmdccd;
	}

	public void setBmdccd(String bmdccd) {
		this.bmdccd = bmdccd;
	}

	public String getBmcvnb() {
		return bmcvnb;
	}

	public void setBmcvnb(String bmcvnb) {
		this.bmcvnb = bmcvnb;
	}

	public String getBmcbtx() {
		return bmcbtx;
	}

	public void setBmcbtx(String bmcbtx) {
		this.bmcbtx = bmcbtx;
	}

	
}