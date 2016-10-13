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
public class ZTWBCHVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String twdno;
	
	private BigDecimal twdln;
	
	private BigDecimal twdbn;
	
	private String itnbr;

	
	private String frwhs;
	
	private String frsub;
	
	private String frloc;


	private String towhs;
	
	private String tosub;
	
	private String toloc;
	
	private String actbh;
	
	private BigDecimal actqt;

	public String getTwdno() {
		return twdno;
	}

	public void setTwdno(String twdno) {
		this.twdno = twdno;
	}

	public BigDecimal getTwdln() {
		return twdln;
	}

	public void setTwdln(BigDecimal twdln) {
		this.twdln = twdln;
	}

	public BigDecimal getTwdbn() {
		return twdbn;
	}

	public void setTwdbn(BigDecimal twdbn) {
		this.twdbn = twdbn;
	}

	public String getItnbr() {
		return itnbr;
	}

	public void setItnbr(String itnbr) {
		this.itnbr = itnbr;
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

	public String getActbh() {
		return actbh;
	}

	public void setActbh(String actbh) {
		this.actbh = actbh;
	}

	public BigDecimal getActqt() {
		return actqt;
	}

	public void setActqt(BigDecimal actqt) {
		this.actqt = actqt;
	}
	
	
	
  
}