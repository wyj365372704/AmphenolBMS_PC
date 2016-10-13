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
public class ZITMEXTVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String stid;
	
	private String itnbr;
	
	private String itrv;
	
	private String ldesc;
	
	private String sdesc;
	
	private String edesc;

	public String getStid() {
		return stid;
	}

	public void setStid(String stid) {
		this.stid = stid;
	}

	public String getItnbr() {
		return itnbr;
	}

	public void setItnbr(String itnbr) {
		this.itnbr = itnbr;
	}

	public String getItrv() {
		return itrv;
	}

	public void setItrv(String itrv) {
		this.itrv = itrv;
	}

	public String getLdesc() {
		return ldesc;
	}

	public void setLdesc(String ldesc) {
		this.ldesc = ldesc;
	}

	public String getSdesc() {
		return sdesc;
	}

	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}

	public String getEdesc() {
		return edesc;
	}

	public void setEdesc(String edesc) {
		this.edesc = edesc;
	}	

}