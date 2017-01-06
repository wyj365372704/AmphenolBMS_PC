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
public class ITMRVAVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String house;
	
	private String itnbr;
	
	private String itrv;
	
	private String unmsr;
	
	private String itdsc;
	
	private String ittyp;
	
	private BigDecimal weght;
	
	private String b2cqcd;
	
	private BigDecimal b2z95s;
	
	private String b2z93r;
	
	private BigDecimal b2z95t;
	
	private BigDecimal b2aas3;

	private String b2aapt;
	
	private String blcf;


	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
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

	public String getUnmsr() {
		return unmsr;
	}

	public void setUnmsr(String unmsr) {
		this.unmsr = unmsr;
	}

	public String getItdsc() {
		return itdsc;
	}

	public void setItdsc(String itdsc) {
		this.itdsc = itdsc;
	}

	public String getIttyp() {
		return ittyp;
	}

	public void setIttyp(String ittyp) {
		this.ittyp = ittyp;
	}

	public BigDecimal getWeght() {
		return weght;
	}

	public void setWeght(BigDecimal weght) {
		this.weght = weght;
	}

	public String getB2cqcd() {
		return b2cqcd;
	}

	public void setB2cqcd(String b2cqcd) {
		this.b2cqcd = b2cqcd;
	}

	public BigDecimal getB2z95s() {
		return b2z95s;
	}

	public void setB2z95s(BigDecimal b2z95s) {
		this.b2z95s = b2z95s;
	}

	public String getB2z93r() {
		return b2z93r;
	}

	public void setB2z93r(String b2z93r) {
		this.b2z93r = b2z93r;
	}

	public BigDecimal getB2z95t() {
		return b2z95t;
	}

	public void setB2z95t(BigDecimal b2z95t) {
		this.b2z95t = b2z95t;
	}

	public String getBlcf() {
		return blcf;
	}

	public void setBlcf(String blcf) {
		this.blcf = blcf;
	}

	public BigDecimal getB2aas3() {
		return b2aas3;
	}

	public void setB2aas3(BigDecimal b2aas3) {
		this.b2aas3 = b2aas3;
	}

	public String getB2aapt() {
		return b2aapt;
	}

	public void setB2aapt(String b2aapt) {
		this.b2aapt = b2aapt;
	}

}