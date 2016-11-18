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
public class ZVRHDRVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String vrdno;
	
	private String house;
	
	private String vndnr;
	
	private String ostat;
	
	private String crus;

	private BigDecimal crdt;
	
	private BigDecimal crtm;
	
	private String chus;
	
	private BigDecimal chdt;
	
	private BigDecimal chtm;
	
	private String StartDate;
	
	private String endDate;

	public String getVrdno() {
		return vrdno;
	}

	public void setVrdno(String vrdno) {
		this.vrdno = vrdno;
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

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setVndnr(String vndnr) {
		this.vndnr = vndnr;
	}

	public String getOstat() {
		return ostat;
	}

	public void setOstat(String ostat) {
		this.ostat = ostat;
	}

	public String getCrus() {
		return crus;
	}

	public void setCrus(String crus) {
		this.crus = crus;
	}

	public BigDecimal getCrdt() {
		return crdt;
	}

	public void setCrdt(BigDecimal crdt) {
		this.crdt = crdt;
	}

	public BigDecimal getCrtm() {
		return crtm;
	}

	public void setCrtm(BigDecimal crtm) {
		this.crtm = crtm;
	}

	public String getChus() {
		return chus;
	}

	public void setChus(String chus) {
		this.chus = chus;
	}

	public BigDecimal getChdt() {
		return chdt;
	}

	public void setChdt(BigDecimal chdt) {
		this.chdt = chdt;
	}

	public BigDecimal getChtm() {
		return chtm;
	}

	public void setChtm(BigDecimal chtm) {
		this.chtm = chtm;
	}

	
}