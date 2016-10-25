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
public class ZTWHDRVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String twdno;
	
	private String twtyp;
	
	private String twsrc;
	
	private BigDecimal twlin;
	
	private String twus1;
	
	private String twdp1;
	
	private BigDecimal twdt1;
	
	private BigDecimal twtm1;
	
	private String createdTime;
	
	private String ostat;
	
	private String cmmt;
	
	private BigDecimal plant;
	
	private List<ZTWDTLVO> itemList;

	public String getTwdno() {
		return twdno;
	}

	public void setTwdno(String twdno) {
		this.twdno = twdno;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getTwtyp() {
		return twtyp;
	}

	public void setTwtyp(String twtyp) {
		this.twtyp = twtyp;
	}

	public String getTwsrc() {
		return twsrc;
	}

	public void setTwsrc(String twsrc) {
		this.twsrc = twsrc;
	}

	public BigDecimal getTwlin() {
		return twlin;
	}

	public void setTwlin(BigDecimal twlin) {
		this.twlin = twlin;
	}

	public String getTwus1() {
		return twus1;
	}

	public void setTwus1(String twus1) {
		this.twus1 = twus1;
	}

	public String getTwdp1() {
		return twdp1;
	}

	public void setTwdp1(String twdp1) {
		this.twdp1 = twdp1;
	}

	public BigDecimal getTwdt1() {
		return twdt1;
	}

	public void setTwdt1(BigDecimal twdt1) {
		this.twdt1 = twdt1;
	}

	public BigDecimal getTwtm1() {
		return twtm1;
	}

	public void setTwtm1(BigDecimal twtm1) {
		this.twtm1 = twtm1;
	}

	public String getOstat() {
		return ostat;
	}

	public void setOstat(String ostat) {
		this.ostat = ostat;
	}

	public String getCmmt() {
		return cmmt;
	}

	public void setCmmt(String cmmt) {
		this.cmmt = cmmt;
	}

	public BigDecimal getPlant() {
		return plant;
	}

	public void setPlant(BigDecimal plant) {
		this.plant = plant;
	}

	public List<ZTWDTLVO> getItemList() {
		return itemList;
	}

	public void setItemList(List<ZTWDTLVO> itemList) {
		this.itemList = itemList;
	}
	
	
  
}