package com.eclink.hgpj.resource.vo;

import java.math.BigDecimal;

import com.eclink.hgpj.base.BaseVO;

/**
 * @Title: 资源值对象类  
 * @Description: 

 * @version 1.0
 * 
 */
public class ZVRTRNVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String vrdno;
	
	private BigDecimal vrdln;

	private BigDecimal vrdtx;
	
	private String vndnr;
	
	private String house;

	private String ordno;

	private BigDecimal poisq;

	private BigDecimal blksq;

	private String itnbr;

	private String stkum;

	private String vrloc;
	
	private BigDecimal actvq;

	private String lbhno;

	private BigDecimal vrdte;
	
	private BigDecimal vrdtm;
	
	private String vremp;

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

	public BigDecimal getVrdtx() {
		return vrdtx;
	}

	public void setVrdtx(BigDecimal vrdtx) {
		this.vrdtx = vrdtx;
	}

	public String getVndnr() {
		return vndnr;
	}

	public void setVndnr(String vndnr) {
		this.vndnr = vndnr;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
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

	public BigDecimal getBlksq() {
		return blksq;
	}

	public void setBlksq(BigDecimal blksq) {
		this.blksq = blksq;
	}

	public String getItnbr() {
		return itnbr;
	}

	public void setItnbr(String itnbr) {
		this.itnbr = itnbr;
	}

	public String getStkum() {
		return stkum;
	}

	public void setStkum(String stkum) {
		this.stkum = stkum;
	}

	public String getVrloc() {
		return vrloc;
	}

	public void setVrloc(String vrloc) {
		this.vrloc = vrloc;
	}

	public BigDecimal getActvq() {
		return actvq;
	}

	public void setActvq(BigDecimal actvq) {
		this.actvq = actvq;
	}

	public String getLbhno() {
		return lbhno;
	}

	public void setLbhno(String lbhno) {
		this.lbhno = lbhno;
	}

	public BigDecimal getVrdte() {
		return vrdte;
	}

	public void setVrdte(BigDecimal vrdte) {
		this.vrdte = vrdte;
	}

	public BigDecimal getVrdtm() {
		return vrdtm;
	}

	public void setVrdtm(BigDecimal vrdtm) {
		this.vrdtm = vrdtm;
	}

	public String getVremp() {
		return vremp;
	}

	public void setVremp(String vremp) {
		this.vremp = vremp;
	}

	
}