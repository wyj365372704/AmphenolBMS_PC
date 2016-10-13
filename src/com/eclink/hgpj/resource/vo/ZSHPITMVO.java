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
public class ZSHPITMVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String shpno;
	
	private BigDecimal shpln;
	
	private String vndnr;
	
	private String house;	
	
	private String ordno;
	
	private BigDecimal poisq;
	
	private String blcod;

	private BigDecimal blksq;
	
	private String lstat;
	
	private String itnbr;
	
	private String blcf;
	
	private BigDecimal shqty;
	
	private String purum;
	
	private String sctkji;
	
	private String shpic1;
	
	private String shpic2;
	
	private String shpic3;
	
	private BigDecimal twht;
	
	private String whtum;
	
	private String vpack;
	
	private List<ZSHPBCHVO> itemsList;

	public String getShpno() {
		return shpno;
	}

	public void setShpno(String shpno) {
		this.shpno = shpno;
	}

	public BigDecimal getShpln() {
		return shpln;
	}

	public void setShpln(BigDecimal shpln) {
		this.shpln = shpln;
	}

	public String getVndnr() {
		return vndnr;
	}

	public void setVndnr(String vndnr) {
		this.vndnr = vndnr;
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

	public BigDecimal getPoisq() {
		return poisq;
	}

	public void setPoisq(BigDecimal poisq) {
		this.poisq = poisq;
	}

	public String getBlcod() {
		return blcod;
	}

	public void setBlcod(String blcod) {
		this.blcod = blcod;
	}

	public List<ZSHPBCHVO> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ZSHPBCHVO> itemsList) {
		this.itemsList = itemsList;
	}

	public BigDecimal getBlksq() {
		return blksq;
	}

	public void setBlksq(BigDecimal blksq) {
		this.blksq = blksq;
	}

	public String getLstat() {
		return lstat;
	}

	public void setLstat(String lstat) {
		this.lstat = lstat;
	}

	public String getItnbr() {
		return itnbr;
	}

	public void setItnbr(String itnbr) {
		this.itnbr = itnbr;
	}

	public String getBlcf() {
		return blcf;
	}

	public void setBlcf(String blcf) {
		this.blcf = blcf;
	}

	public BigDecimal getShqty() {
		return shqty;
	}

	public void setShqty(BigDecimal shqty) {
		this.shqty = shqty;
	}

	public String getPurum() {
		return purum;
	}

	public void setPurum(String purum) {
		this.purum = purum;
	}

	public String getSctkji() {
		return sctkji;
	}

	public void setSctkji(String sctkji) {
		this.sctkji = sctkji;
	}

	public String getShpic1() {
		return shpic1;
	}

	public void setShpic1(String shpic1) {
		this.shpic1 = shpic1;
	}

	public String getShpic2() {
		return shpic2;
	}

	public void setShpic2(String shpic2) {
		this.shpic2 = shpic2;
	}

	public String getShpic3() {
		return shpic3;
	}

	public void setShpic3(String shpic3) {
		this.shpic3 = shpic3;
	}

	public BigDecimal getTwht() {
		return twht;
	}

	public void setTwht(BigDecimal twht) {
		this.twht = twht;
	}

	public String getWhtum() {
		return whtum;
	}

	public void setWhtum(String whtum) {
		this.whtum = whtum;
	}

	public String getVpack() {
		return vpack;
	}

	public void setVpack(String vpack) {
		this.vpack = vpack;
	}

  
}