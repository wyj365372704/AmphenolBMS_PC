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
	
	private String twrsn;	
	
	private String isrsn;
	
	private String nmchs;
	
	private String nmeng;
	
	private String rcrsn;
	
	private String fnqty;

	private String fasun;

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

	public String getRmrsn() {
		return rmrsn;
	}

	public void setRmrsn(String rmrsn) {
		this.rmrsn = rmrsn;
	}

	public String getIprsn() {
		return iprsn;
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
	

}