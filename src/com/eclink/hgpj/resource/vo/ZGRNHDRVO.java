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
public class ZGRNHDRVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String grnno;
	
	private String shpno;
	
	private String vndnr;
	
	private String lgwno;
	
	private String ostat;
	
	private BigDecimal grdte;
	
	private BigDecimal grdtm;
	
	private String gremp;
	
	private String crus;
	
	private BigDecimal crdt;
	
	private String scrdt;
	
	private BigDecimal crtm;
	
	private String chus;
	
	private BigDecimal chdt;
	
	private BigDecimal chtm;
	
	private List<ZGRNITMVO> itemsList;

	public String getShpno() {
		return shpno;
	}

	public void setShpno(String shpno) {
		this.shpno = shpno;
	}

	public String getVndnr() {
		return vndnr;
	}

	public String getScrdt() {
		return scrdt;
	}

	public void setScrdt(String scrdt) {
		this.scrdt = scrdt;
	}

	public void setVndnr(String vndnr) {
		this.vndnr = vndnr;
	}

	public String getLgwno() {
		return lgwno;
	}

	public void setLgwno(String lgwno) {
		this.lgwno = lgwno;
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

	public List<ZGRNITMVO> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ZGRNITMVO> itemsList) {
		this.itemsList = itemsList;
	}


	public String getGrnno() {
		return grnno;
	}

	public void setGrnno(String grnno) {
		this.grnno = grnno;
	}

	public String getGremp() {
		return gremp;
	}

	public void setGremp(String gremp) {
		this.gremp = gremp;
	}

	public BigDecimal getGrdte() {
		return grdte;
	}

	public void setGrdte(BigDecimal grdte) {
		this.grdte = grdte;
	}

	public BigDecimal getGrdtm() {
		return grdtm;
	}

	public void setGrdtm(BigDecimal grdtm) {
		this.grdtm = grdtm;
	}
	
	
  
}