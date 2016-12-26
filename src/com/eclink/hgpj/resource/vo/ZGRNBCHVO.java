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
public class ZGRNBCHVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String grnno;
	
	private BigDecimal grnln;
	
	private BigDecimal grnbn;
	
	private String shpno;
	
	private BigDecimal shpln;
	
	private BigDecimal shpbn;
	
	
	private String vndnr;
	
	private String house;	
	
	private String ordno;
	
	private BigDecimal poisq;
	
//	private String blcod;

	private BigDecimal blksq;
	
//	private String lstat;
	
	private String itnbr;
	
	private String purum;
	
//	private String blcf;
	
	private BigDecimal sbqty;
	
	private BigDecimal gbqty;
	
	
	private String lbhno;
	
	
	
	private BigDecimal mfgdt;
	
	private BigDecimal expdt;

	public String getGrnno() {
		return grnno;
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

	public BigDecimal getGrnbn() {
		return grnbn;
	}

	public BigDecimal getShpbn() {
		return shpbn;
	}

	public void setShpbn(BigDecimal shpbn) {
		this.shpbn = shpbn;
	}

	public void setGrnbn(BigDecimal grnbn) {
		this.grnbn = grnbn;
	}

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

	public BigDecimal getBlksq() {
		return blksq;
	}

	public void setBlksq(BigDecimal blksq) {
		this.blksq = blksq;
	}

	public String getItnbr() {
		return itnbr;
	}

	public void setItnbr(String itnbr) {
		this.itnbr = itnbr;
	}

	public String getPurum() {
		return purum;
	}

	public void setPurum(String purum) {
		this.purum = purum;
	}

	public BigDecimal getSbqty() {
		return sbqty;
	}

	public void setSbqty(BigDecimal sbqty) {
		this.sbqty = sbqty;
	}

	public BigDecimal getGbqty() {
		return gbqty;
	}

	public void setGbqty(BigDecimal gbqty) {
		this.gbqty = gbqty;
	}

	public String getLbhno() {
		return lbhno;
	}

	public void setLbhno(String lbhno) {
		this.lbhno = lbhno;
	}

	public BigDecimal getMfgdt() {
		return mfgdt;
	}

	public void setMfgdt(BigDecimal mfgdt) {
		this.mfgdt = mfgdt;
	}

	public BigDecimal getExpdt() {
		return expdt;
	}

	public void setExpdt(BigDecimal expdt) {
		this.expdt = expdt;
	}

}