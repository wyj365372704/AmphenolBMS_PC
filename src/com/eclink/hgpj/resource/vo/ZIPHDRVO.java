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
public class ZIPHDRVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String ipdno;
	
	private String house;
	
	private String ordno;
	
	private String iptyp;
	
	private String dept;
	
	private String fitem;
	
	private String ostat;
	
	private String lprt;
	
	private String aprst;
	
	private String aprus;
	
	private String aprdp;
	
	private BigDecimal aprdt;
	
	private BigDecimal aprtm;
	
	private String ipus1;
	
	private String ipdp1;
	
	private String cmmt;
	
	private String bmstyp;
	
	private BigDecimal ipdt1;
	
	private BigDecimal iptm1;
	
	private String sipdt1;
	
	private String siptm1;
	
	private String saprdt;
	
	private String saprtm;
	
	private String bmsrsn;
	
	private String fapr;

	private List<ZIPDTLVO> itemList;
	
	public String getIpdno() {
		return ipdno;
	}

	public void setIpdno(String ipdno) {
		this.ipdno = ipdno;
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

	public String getIptyp() {
		return iptyp;
	}

	public void setIptyp(String iptyp) {
		this.iptyp = iptyp;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getFitem() {
		return fitem;
	}

	public void setFitem(String fitem) {
		this.fitem = fitem;
	}

	public String getOstat() {
		return ostat;
	}

	public void setOstat(String ostat) {
		this.ostat = ostat;
	}

	public String getLprt() {
		return lprt;
	}

	public void setLprt(String lprt) {
		this.lprt = lprt;
	}



	public String getAprst() {
		return aprst;
	}

	public void setAprst(String aprst) {
		this.aprst = aprst;
	}

	public String getAprus() {
		return aprus;
	}

	public void setAprus(String aprus) {
		this.aprus = aprus;
	}

	public String getAprdp() {
		return aprdp;
	}

	public void setAprdp(String aprdp) {
		this.aprdp = aprdp;
	}

	public BigDecimal getAprdt() {
		return aprdt;
	}

	public void setAprdt(BigDecimal aprdt) {
		this.aprdt = aprdt;
	}

	public BigDecimal getAprtm() {
		return aprtm;
	}

	public void setAprtm(BigDecimal aprtm) {
		this.aprtm = aprtm;
	}

	public String getIpus1() {
		return ipus1;
	}

	public void setIpus1(String ipus1) {
		this.ipus1 = ipus1;
	}

	public String getIpdp1() {
		return ipdp1;
	}

	public void setIpdp1(String ipdp1) {
		this.ipdp1 = ipdp1;
	}

	public String getCmmt() {
		return cmmt;
	}

	public void setCmmt(String cmmt) {
		this.cmmt = cmmt;
	}

	public String getBmstyp() {
		return bmstyp;
	}

	public void setBmstyp(String bmstyp) {
		this.bmstyp = bmstyp;
	}

	public BigDecimal getIpdt1() {
		return ipdt1;
	}

	public void setIpdt1(BigDecimal ipdt1) {
		this.ipdt1 = ipdt1;
	}

	public BigDecimal getIptm1() {
		return iptm1;
	}

	public void setIptm1(BigDecimal iptm1) {
		this.iptm1 = iptm1;
	}

	public String getBmsrsn() {
		return bmsrsn;
	}

	public void setBmsrsn(String bmsrsn) {
		this.bmsrsn = bmsrsn;
	}

	public String getFapr() {
		return fapr;
	}

	public void setFapr(String fapr) {
		this.fapr = fapr;
	}

	public List<ZIPDTLVO> getItemList() {
		return itemList;
	}

	public void setItemList(List<ZIPDTLVO> itemList) {
		this.itemList = itemList;
	}

	public String getSipdt1() {
		return sipdt1;
	}

	public void setSipdt1(String sipdt1) {
		this.sipdt1 = sipdt1;
	}

	public String getSiptm1() {
		return siptm1;
	}

	public void setSiptm1(String siptm1) {
		this.siptm1 = siptm1;
	}

	public String getSaprdt() {
		return saprdt;
	}

	public void setSaprdt(String saprdt) {
		this.saprdt = saprdt;
	}

	public String getSaprtm() {
		return saprtm;
	}

	public void setSaprtm(String saprtm) {
		this.saprtm = saprtm;
	}
	
  
}