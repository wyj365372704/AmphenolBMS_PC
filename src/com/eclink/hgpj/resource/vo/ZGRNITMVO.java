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
public class ZGRNITMVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String grnno;
	
	private String shpno;
	
	private BigDecimal grnln;
	
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
	
	private String iqcf;
	
	private BigDecimal shqty;
	
	private BigDecimal grqty;
	
	private String purum;
	
	private String grloc;
	
	private String vn35;
	
	private BigDecimal grwgt1;
	
	private String grwum1;
	
	private BigDecimal grwgt2;
	
	private String grwum2;
	
	private String sctkji;
	
	private String shpic3;
	
	private BigDecimal twht;
	
	private String whtum;
	
	private String vpack;
	
	private String itdsc;
	
	private String whsub2;
	
	private String llocn2;
	
	
	private List<ZGRNBCHVO> itemList;

	public String getShpno() {
		return shpno;
	}

	public String getSctkji() {
		return sctkji;
	}

	public void setSctkji(String sctkji) {
		this.sctkji = sctkji;
	}

	public void setShpno(String shpno) {
		this.shpno = shpno;
	}

	public String getGrnno() {
		return grnno;
	}

	public String getVn35() {
		return vn35;
	}

	public String getItdsc() {
		return itdsc;
	}

	public void setItdsc(String itdsc) {
		this.itdsc = itdsc;
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

	public void setVn35(String vn35) {
		this.vn35 = vn35;
	}

	public void setGrnno(String grnno) {
		this.grnno = grnno;
	}

	public BigDecimal getGrnln() {
		return grnln;
	}

	public void setGrnln(BigDecimal grnln) {
		this.grnln = grnln;
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

	public String getIqcf() {
		return iqcf;
	}

	public void setIqcf(String iqcf) {
		this.iqcf = iqcf;
	}

	public BigDecimal getShqty() {
		return shqty;
	}

	public void setShqty(BigDecimal shqty) {
		this.shqty = shqty;
	}

	public BigDecimal getGrqty() {
		return grqty;
	}

	public void setGrqty(BigDecimal grqty) {
		this.grqty = grqty;
	}

	public String getPurum() {
		return purum;
	}

	public void setPurum(String purum) {
		this.purum = purum;
	}

	public String getGrloc() {
		return grloc;
	}

	public void setGrloc(String grloc) {
		this.grloc = grloc;
	}

	public BigDecimal getGrwgt1() {
		return grwgt1;
	}

	public void setGrwgt1(BigDecimal grwgt1) {
		this.grwgt1 = grwgt1;
	}

	public String getGrwum1() {
		return grwum1;
	}

	public void setGrwum1(String grwum1) {
		this.grwum1 = grwum1;
	}

	public BigDecimal getGrwgt2() {
		return grwgt2;
	}

	public void setGrwgt2(BigDecimal grwgt2) {
		this.grwgt2 = grwgt2;
	}

	public String getGrwum2() {
		return grwum2;
	}

	public void setGrwum2(String grwum2) {
		this.grwum2 = grwum2;
	}

	public BigDecimal getShpln() {
		return shpln;
	}

	public void setShpln(BigDecimal shpln) {
		this.shpln = shpln;
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

	public List<ZGRNBCHVO> getItemList() {
		return itemList;
	}

	public void setItemList(List<ZGRNBCHVO> itemList) {
		this.itemList = itemList;
	}

}