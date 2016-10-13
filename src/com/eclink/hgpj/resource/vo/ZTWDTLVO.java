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
public class ZTWDTLVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String twdno;
	
	private BigDecimal twdln;
	
	private String itnbr;
	
	private String blcf;
	
	private String unmsr;
	
	private String finsp;
	
	private String frwhs;
	
	private String frsub;
	
	private String frloc;
	
	private BigDecimal plnqt;
	
	private BigDecimal actqt;

	private String towhs;
	
	private String tosub;
	
	private String toloc;
	
	private String lstat;
	
	private String lprt;
	
	private String twus2;
	
	private String twdp2;
	
	private BigDecimal twdt2;
	
	private BigDecimal twtm2;
	
	private List<ZTWBCHVO> itemList;
	
	private String itdsc ; 

	public String getTwdno() {
		return twdno;
	}

	public void setTwdno(String twdno) {
		this.twdno = twdno;
	}



	public String getItdsc() {
		return itdsc;
	}

	public void setItdsc(String itdsc) {
		this.itdsc = itdsc;
	}

	public BigDecimal getTwdln() {
		return twdln;
	}

	public void setTwdln(BigDecimal twdln) {
		this.twdln = twdln;
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

	public String getUnmsr() {
		return unmsr;
	}

	public void setUnmsr(String unmsr) {
		this.unmsr = unmsr;
	}

	public String getFinsp() {
		return finsp;
	}

	public void setFinsp(String finsp) {
		this.finsp = finsp;
	}

	public String getFrwhs() {
		return frwhs;
	}

	public void setFrwhs(String frwhs) {
		this.frwhs = frwhs;
	}

	public String getFrsub() {
		return frsub;
	}

	public void setFrsub(String frsub) {
		this.frsub = frsub;
	}

	public String getFrloc() {
		return frloc;
	}

	public void setFrloc(String frloc) {
		this.frloc = frloc;
	}

	public BigDecimal getPlnqt() {
		return plnqt;
	}

	public void setPlnqt(BigDecimal plnqt) {
		this.plnqt = plnqt;
	}

	public BigDecimal getActqt() {
		return actqt;
	}

	public void setActqt(BigDecimal actqt) {
		this.actqt = actqt;
	}

	public String getTowhs() {
		return towhs;
	}

	public void setTowhs(String towhs) {
		this.towhs = towhs;
	}

	public String getTosub() {
		return tosub;
	}

	public void setTosub(String tosub) {
		this.tosub = tosub;
	}

	public String getToloc() {
		return toloc;
	}

	public void setToloc(String toloc) {
		this.toloc = toloc;
	}

	public String getLstat() {
		return lstat;
	}

	public void setLstat(String lstat) {
		this.lstat = lstat;
	}

	public String getLprt() {
		return lprt;
	}

	public void setLprt(String lprt) {
		this.lprt = lprt;
	}

	public String getTwus2() {
		return twus2;
	}

	public void setTwus2(String twus2) {
		this.twus2 = twus2;
	}

	public String getTwdp2() {
		return twdp2;
	}

	public void setTwdp2(String twdp2) {
		this.twdp2 = twdp2;
	}

	public BigDecimal getTwdt2() {
		return twdt2;
	}

	public void setTwdt2(BigDecimal twdt2) {
		this.twdt2 = twdt2;
	}

	public BigDecimal getTwtm2() {
		return twtm2;
	}

	public void setTwtm2(BigDecimal twtm2) {
		this.twtm2 = twtm2;
	}

	public List<ZTWBCHVO> getItemList() {
		return itemList;
	}

	public void setItemList(List<ZTWBCHVO> itemList) {
		this.itemList = itemList;
	}
	
	
  
}