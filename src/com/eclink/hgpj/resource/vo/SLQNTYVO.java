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
public class SLQNTYVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String itnbr;
	
	private String house;
	
	private String llocn;

	private String lbhno;
	
	private BigDecimal fdate;
	
	private BigDecimal lqnty;
	
	private String unpurum;
	
	private String uucalm;

	public String getItnbr() {
		return itnbr;
	}

	public void setItnbr(String itnbr) {
		this.itnbr = itnbr;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getLlocn() {
		return llocn;
	}

	public void setLlocn(String llocn) {
		this.llocn = llocn;
	}

	public String getLbhno() {
		return lbhno;
	}

	public void setLbhno(String lbhno) {
		this.lbhno = lbhno;
	}

	public BigDecimal getFdate() {
		return fdate;
	}

	public void setFdate(BigDecimal fdate) {
		this.fdate = fdate;
	}

	public BigDecimal getLqnty() {
		return lqnty;
	}

	public void setLqnty(BigDecimal lqnty) {
		this.lqnty = lqnty;
	}

	public String getUnpurum() {
		return unpurum;
	}

	public void setUnpurum(String unpurum) {
		this.unpurum = unpurum;
	}

	public String getUucalm() {
		return uucalm;
	}

	public void setUucalm(String uucalm) {
		this.uucalm = uucalm;
	}

	
	

}