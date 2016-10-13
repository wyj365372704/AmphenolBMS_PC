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
public class ZITEMBXVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String house;
	
	private String itnbr;
	
	private BigDecimal iptol;
	
	private String whsub1;
	
	private String llocn1;
	
	private String whsub2;
	
	private String llocn2;
	
	private String whsub3;
	
	private String llocn3;
	
	private String whsub4;
	
	private String llocn4;

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

	public BigDecimal getIptol() {
		return iptol;
	}

	public void setIptol(BigDecimal iptol) {
		this.iptol = iptol;
	}

	public String getWhsub1() {
		return whsub1;
	}

	public void setWhsub1(String whsub1) {
		this.whsub1 = whsub1;
	}

	public String getLlocn1() {
		return llocn1;
	}

	public void setLlocn1(String llocn1) {
		this.llocn1 = llocn1;
	}

	public String getWhsub2() {
		return whsub2;
	}

	public void setWhsub2(String whsub2) {
		this.whsub2 = whsub2;
	}

	public String getLlocn2() {
		return llocn2;
	}

	public void setLlocn2(String llocn2) {
		this.llocn2 = llocn2;
	}

	public String getWhsub3() {
		return whsub3;
	}

	public void setWhsub3(String whsub3) {
		this.whsub3 = whsub3;
	}

	public String getLlocn3() {
		return llocn3;
	}

	public void setLlocn3(String llocn3) {
		this.llocn3 = llocn3;
	}

	public String getWhsub4() {
		return whsub4;
	}

	public void setWhsub4(String whsub4) {
		this.whsub4 = whsub4;
	}

	public String getLlocn4() {
		return llocn4;
	}

	public void setLlocn4(String llocn4) {
		this.llocn4 = llocn4;
	}
	

}