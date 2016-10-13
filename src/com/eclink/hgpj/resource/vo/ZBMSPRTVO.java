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
public class ZBMSPRTVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	
	private String prtid;
	
	private String prtlc;

	private String ptype;
	
	private String ipadr;
	
	private String port;
	
	private String prtnm;
	
	private String pcnam;
	
	private String cmmt;

	public String getPrtid() {
		return prtid;
	}

	public void setPrtid(String prtid) {
		this.prtid = prtid;
	}

	public String getPrtlc() {
		return prtlc;
	}

	public void setPrtlc(String prtlc) {
		this.prtlc = prtlc;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getIpadr() {
		return ipadr;
	}

	public void setIpadr(String ipadr) {
		this.ipadr = ipadr;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getPrtnm() {
		return prtnm;
	}

	public void setPrtnm(String prtnm) {
		this.prtnm = prtnm;
	}

	public String getPcnam() {
		return pcnam;
	}

	public void setPcnam(String pcnam) {
		this.pcnam = pcnam;
	}

	public String getCmmt() {
		return cmmt;
	}

	public void setCmmt(String cmmt) {
		this.cmmt = cmmt;
	}

	

}