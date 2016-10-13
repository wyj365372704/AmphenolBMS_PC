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
public class ZSLLOGVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String sldno;
	
	private String appl;
	
	private String sltype;

	private String datyp;
	
	private String slreq;
	
	
	private String slrsp;
	
	private String osgrp;

	private String crusr;
	
	private String crdpt;
	
	private BigDecimal crdat;
	
	private BigDecimal crtme;
	
	private String fprcs;
	
	private String eresn;
	
	
	private String house;
	
	private String itnbr;
	
	private BigDecimal trqty;
	
	private String llocn;
	
	private String nlloc;

	public String getSldno() {
		return sldno;
	}

	public void setSldno(String sldno) {
		this.sldno = sldno;
	}

	public String getAppl() {
		return appl;
	}

	public void setAppl(String appl) {
		this.appl = appl;
	}

	public String getSltype() {
		return sltype;
	}

	public void setSltype(String sltype) {
		this.sltype = sltype;
	}

	public String getDatyp() {
		return datyp;
	}

	public void setDatyp(String datyp) {
		this.datyp = datyp;
	}

	public String getSlreq() {
		return slreq;
	}

	public void setSlreq(String slreq) {
		this.slreq = slreq;
	}

	public String getSlrsp() {
		return slrsp;
	}

	public void setSlrsp(String slrsp) {
		this.slrsp = slrsp;
	}

	public String getOsgrp() {
		return osgrp;
	}

	public void setOsgrp(String osgrp) {
		this.osgrp = osgrp;
	}

	public String getCrusr() {
		return crusr;
	}

	public void setCrusr(String crusr) {
		this.crusr = crusr;
	}

	public String getCrdpt() {
		return crdpt;
	}

	public void setCrdpt(String crdpt) {
		this.crdpt = crdpt;
	}

	public BigDecimal getCrdat() {
		return crdat;
	}

	public void setCrdat(BigDecimal crdat) {
		this.crdat = crdat;
	}

	public BigDecimal getCrtme() {
		return crtme;
	}

	public void setCrtme(BigDecimal crtme) {
		this.crtme = crtme;
	}

	public String getFprcs() {
		return fprcs;
	}

	public void setFprcs(String fprcs) {
		this.fprcs = fprcs;
	}

	public String getEresn() {
		return eresn;
	}

	public void setEresn(String eresn) {
		this.eresn = eresn;
	}

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

	public BigDecimal getTrqty() {
		return trqty;
	}

	public void setTrqty(BigDecimal trqty) {
		this.trqty = trqty;
	}

	public String getLlocn() {
		return llocn;
	}

	public void setLlocn(String llocn) {
		this.llocn = llocn;
	}

	public String getNlloc() {
		return nlloc;
	}

	public void setNlloc(String nlloc) {
		this.nlloc = nlloc;
	}

	

}