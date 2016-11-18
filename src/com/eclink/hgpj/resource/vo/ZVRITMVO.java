package com.eclink.hgpj.resource.vo;

import java.math.BigDecimal;

import com.eclink.hgpj.base.BaseVO;

/**
 * @Title: 资源值对象类  
 * @Description: 

 * @version 1.0
 * 
 */
public class ZVRITMVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String vrdno;
	
	private BigDecimal vrdln;

	private String vndnr;
	
	private String house;

	private String ordno;

	private BigDecimal poisq;

//	private String blcod;

	private BigDecimal blksq;
	
	private String lstat;

	private String itnbr;

	private String blcf;

	private String stkum;

	private String sctkji;

	private String plloc;

	private BigDecimal plnvq;

	public String getVrdno() {
		return vrdno;
	}

	public void setVrdno(String vrdno) {
		this.vrdno = vrdno;
	}

	public BigDecimal getVrdln() {
		return vrdln;
	}

	public void setVrdln(BigDecimal vrdln) {
		this.vrdln = vrdln;
	}

	public String getVndnr() {
		return vndnr;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public void setVndnr(String vndnr) {
		this.vndnr = vndnr;
	}

	public String getOrdno() {
		return ordno;
	}

	public void setOrdno(String ordno) {
		this.ordno = ordno;
	}

	public BigDecimal getPoisq() {
		return poisq;
	}

	public void setPoisq(BigDecimal poisq) {
		this.poisq = poisq;
	}

//	public String getBlcod() {
//		return blcod;
//	}
//
//	public void setBlcod(String blcod) {
//		this.blcod = blcod;
//	}

	public BigDecimal getBlksq() {
		return blksq;
	}

	public void setBlksq(BigDecimal blksq) {
		this.blksq = blksq;
	}

	public String getLstat() {
		return lstat;
	}

	public void setLstat(String lstat) {
		this.lstat = lstat;
	}

	public String getItnbr() {
		return itnbr;
	}

	public void setItnbr(String itnbr) {
		this.itnbr = itnbr;
	}


	public String getBlcf() {
		return blcf;
	}

	public void setBlcf(String blcf) {
		this.blcf = blcf;
	}

	public String getStkum() {
		return stkum;
	}

	public void setStkum(String stkum) {
		this.stkum = stkum;
	}

	public String getSctkji() {
		return sctkji;
	}

	public void setSctkji(String sctkji) {
		this.sctkji = sctkji;
	}

	public String getPlloc() {
		return plloc;
	}

	public void setPlloc(String plloc) {
		this.plloc = plloc;
	}

	public BigDecimal getPlnvq() {
		return plnvq;
	}

	public void setPlnvq(BigDecimal plnvq) {
		this.plnvq = plnvq;
	}
	
	
}