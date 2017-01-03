package com.eclink.hgpj.resource.vo;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.util.MenuTreeComparator;

/**
 * @Title: 资源值对象类  
 * @Description: 

 * @version 1.0
 * 
 */
public class ZBMSCTLVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String site;
	
	private String rprsn;
	
	private String rmrsn;
	
	private String iprsn;
	
	private String iarsn;

	private String twrsn;	
	
	private String isrsn;
	
	private String nmchs;
	
	private String nmeng;
	
	private String rcrsn;
	
	private String fnqty;

	private String curid;
	
	private String fasun;
	
	private String sfnam;
	
	private String sfadd1;
	
	private String sfadd2;
	
	private String sfcity;
	
	private String sfctr;
	
	private String sfzip;

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getRprsn() {
		return rprsn;
	}

	public void setRprsn(String rprsn) {
		this.rprsn = rprsn;
	}

	public String getCurid() {
		return curid;
	}

	public void setCurid(String curid) {
		this.curid = curid;
	}

	public String getRmrsn() {
		return rmrsn;
	}

	public void setRmrsn(String rmrsn) {
		this.rmrsn = rmrsn;
	}

	public String getIprsn() {
		return iprsn;
	}

	public String getIarsn() {
		return iarsn;
	}

	public void setIarsn(String iarsn) {
		this.iarsn = iarsn;
	}

	public void setIprsn(String iprsn) {
		this.iprsn = iprsn;
	}

	public String getTwrsn() {
		return twrsn;
	}

	public void setTwrsn(String twrsn) {
		this.twrsn = twrsn;
	}

	public String getIsrsn() {
		return isrsn;
	}

	public void setIsrsn(String isrsn) {
		this.isrsn = isrsn;
	}

	public String getRcrsn() {
		return rcrsn;
	}

	public void setRcrsn(String rcrsn) {
		this.rcrsn = rcrsn;
	}

	public String getFnqty() {
		return fnqty;
	}

	public void setFnqty(String fnqty) {
		this.fnqty = fnqty;
	}

	public String getFasun() {
		return fasun;
	}

	public void setFasun(String fasun) {
		this.fasun = fasun;
	}

	public String getNmchs() {
		return nmchs;
	}

	public void setNmchs(String nmchs) {
		this.nmchs = nmchs;
	}

	public String getNmeng() {
		return nmeng;
	}

	public void setNmeng(String nmeng) {
		this.nmeng = nmeng;
	}

	public String getSfnam() {
		return sfnam;
	}

	public void setSfnam(String sfnam) {
		this.sfnam = sfnam;
	}

	public String getSfadd1() {
		return sfadd1;
	}

	public void setSfadd1(String sfadd1) {
		this.sfadd1 = sfadd1;
	}

	public String getSfadd2() {
		return sfadd2;
	}

	public void setSfadd2(String sfadd2) {
		this.sfadd2 = sfadd2;
	}

	public String getSfcity() {
		return sfcity;
	}

	public void setSfcity(String sfcity) {
		this.sfcity = sfcity;
	}

	public String getSfctr() {
		return sfctr;
	}

	public void setSfctr(String sfctr) {
		this.sfctr = sfctr;
	}

	public String getSfzip() {
		return sfzip;
	}

	public void setSfzip(String sfzip) {
		this.sfzip = sfzip;
	}
	

}