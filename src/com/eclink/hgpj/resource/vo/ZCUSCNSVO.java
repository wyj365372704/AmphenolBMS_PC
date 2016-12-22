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
public class ZCUSCNSVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private BigDecimal comno;
	
	private String cusnm;
	
	private String cnsign;
	
	private String cname;

	private String caddr1;

	private String caddr2;

	private String ccity;

	private String czip;

	private String ccntr;

	public BigDecimal getComno() {
		return comno;
	}

	public void setComno(BigDecimal comno) {
		this.comno = comno;
	}

	public String getCusnm() {
		return cusnm;
	}

	public void setCusnm(String cusnm) {
		this.cusnm = cusnm;
	}

	public String getCnsign() {
		return cnsign;
	}

	public void setCnsign(String cnsign) {
		this.cnsign = cnsign;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCaddr1() {
		return caddr1;
	}

	public void setCaddr1(String caddr1) {
		this.caddr1 = caddr1;
	}

	public String getCaddr2() {
		return caddr2;
	}

	public void setCaddr2(String caddr2) {
		this.caddr2 = caddr2;
	}

	public String getCcity() {
		return ccity;
	}

	public void setCcity(String ccity) {
		this.ccity = ccity;
	}

	public String getCzip() {
		return czip;
	}

	public void setCzip(String czip) {
		this.czip = czip;
	}

	public String getCcntr() {
		return ccntr;
	}

	public void setCcntr(String ccntr) {
		this.ccntr = ccntr;
	}

	
}