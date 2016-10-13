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
public class ZBMSRSNVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	
	private String bmstyp;
	
	private String bmsrsn;
	
	private String rsnnm;
	
	private String fapr;

	public String getBmstyp() {
		return bmstyp;
	}

	public void setBmstyp(String bmstyp) {
		this.bmstyp = bmstyp;
	}

	public String getBmsrsn() {
		return bmsrsn;
	}

	public void setBmsrsn(String bmsrsn) {
		this.bmsrsn = bmsrsn;
	}

	public String getRsnnm() {
		return rsnnm;
	}

	public void setRsnnm(String rsnnm) {
		this.rsnnm = rsnnm;
	}

	public String getFapr() {
		return fapr;
	}

	public void setFapr(String fapr) {
		this.fapr = fapr;
	}

	
}