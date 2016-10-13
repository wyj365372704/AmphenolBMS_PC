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
public class ZRMHSTVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String rmdno;
	
	private String house;

	private String ordno;
	
	private String dept;
	
	private String fitem;
	
	private String rmsub;
	
	private String rmloc;

	private String rmbch;
	
	private BigDecimal rmqty;
	
	private String fqcd;
	
	private String rmusr;
	
	private String rmdpt;
	
	private BigDecimal rmdat;
	
	private BigDecimal rmtme;

	public String getRmdno() {
		return rmdno;
	}

	public void setRmdno(String rmdno) {
		this.rmdno = rmdno;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getOrdno() {
		return ordno;
	}

	public void setOrdno(String ordno) {
		this.ordno = ordno;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getFitem() {
		return fitem;
	}

	public void setFitem(String fitem) {
		this.fitem = fitem;
	}

	public String getRmsub() {
		return rmsub;
	}

	public void setRmsub(String rmsub) {
		this.rmsub = rmsub;
	}

	public String getRmloc() {
		return rmloc;
	}

	public void setRmloc(String rmloc) {
		this.rmloc = rmloc;
	}

	public String getRmbch() {
		return rmbch;
	}

	public void setRmbch(String rmbch) {
		this.rmbch = rmbch;
	}

	public BigDecimal getRmqty() {
		return rmqty;
	}

	public void setRmqty(BigDecimal rmqty) {
		this.rmqty = rmqty;
	}

	public String getFqcd() {
		return fqcd;
	}

	public void setFqcd(String fqcd) {
		this.fqcd = fqcd;
	}

	public String getRmusr() {
		return rmusr;
	}

	public void setRmusr(String rmusr) {
		this.rmusr = rmusr;
	}

	public String getRmdpt() {
		return rmdpt;
	}

	public void setRmdpt(String rmdpt) {
		this.rmdpt = rmdpt;
	}

	public BigDecimal getRmdat() {
		return rmdat;
	}

	public void setRmdat(BigDecimal rmdat) {
		this.rmdat = rmdat;
	}

	public BigDecimal getRmtme() {
		return rmtme;
	}

	public void setRmtme(BigDecimal rmtme) {
		this.rmtme = rmtme;
	}
	
	
}