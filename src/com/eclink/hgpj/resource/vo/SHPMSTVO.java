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
public class SHPMSTVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	private String house;
	private Short shpid;
	private String shpnm;
	private String ship1;
	private String ship2;
	private String shpzp;
	private String stele;
	private String scont;
	private String sabbn;
	private Integer mdate;
	private String scntr;
	private String scity;
	private String sstac;
	private String adrft;
	private String lcql;
	private String lcie;
	private String uusabj;
	private String uucabj;
	private Double uua1bj;
	private String uu25bj;
	private String uu40bj;
	private String lcqu;
	private String sn35;
	private String s135;
	private String s235;
	private String s335;
	private String s435;
	private String s535;
	private String faxn;
	private String eadr;
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public Short getShpid() {
		return shpid;
	}
	public void setShpid(Short shpid) {
		this.shpid = shpid;
	}
	public String getShpnm() {
		return shpnm;
	}
	public void setShpnm(String shpnm) {
		this.shpnm = shpnm;
	}
	public String getShip1() {
		return ship1;
	}
	public void setShip1(String ship1) {
		this.ship1 = ship1;
	}
	public String getShip2() {
		return ship2;
	}
	public void setShip2(String ship2) {
		this.ship2 = ship2;
	}
	public String getShpzp() {
		return shpzp;
	}
	public void setShpzp(String shpzp) {
		this.shpzp = shpzp;
	}
	public String getStele() {
		return stele;
	}
	public void setStele(String stele) {
		this.stele = stele;
	}
	public String getScont() {
		return scont;
	}
	public void setScont(String scont) {
		this.scont = scont;
	}
	public String getSabbn() {
		return sabbn;
	}
	public void setSabbn(String sabbn) {
		this.sabbn = sabbn;
	}
	public Integer getMdate() {
		return mdate;
	}
	public void setMdate(Integer mdate) {
		this.mdate = mdate;
	}
	public String getScntr() {
		return scntr;
	}
	public void setScntr(String scntr) {
		this.scntr = scntr;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
	public String getSstac() {
		return sstac;
	}
	public void setSstac(String sstac) {
		this.sstac = sstac;
	}
	public String getAdrft() {
		return adrft;
	}
	public void setAdrft(String adrft) {
		this.adrft = adrft;
	}
	public String getLcql() {
		return lcql;
	}
	public void setLcql(String lcql) {
		this.lcql = lcql;
	}
	public String getLcie() {
		return lcie;
	}
	public void setLcie(String lcie) {
		this.lcie = lcie;
	}
	public String getUusabj() {
		return uusabj;
	}
	public void setUusabj(String uusabj) {
		this.uusabj = uusabj;
	}
	public String getUucabj() {
		return uucabj;
	}
	public void setUucabj(String uucabj) {
		this.uucabj = uucabj;
	}
	public Double getUua1bj() {
		return uua1bj;
	}
	public void setUua1bj(Double uua1bj) {
		this.uua1bj = uua1bj;
	}
	public String getUu25bj() {
		return uu25bj;
	}
	public void setUu25bj(String uu25bj) {
		this.uu25bj = uu25bj;
	}
	public String getUu40bj() {
		return uu40bj;
	}
	public void setUu40bj(String uu40bj) {
		this.uu40bj = uu40bj;
	}
	public String getLcqu() {
		return lcqu;
	}
	public void setLcqu(String lcqu) {
		this.lcqu = lcqu;
	}
	public String getSn35() {
		return sn35;
	}
	public void setSn35(String sn35) {
		this.sn35 = sn35;
	}
	public String getS135() {
		return s135;
	}
	public void setS135(String s135) {
		this.s135 = s135;
	}
	public String getS235() {
		return s235;
	}
	public void setS235(String s235) {
		this.s235 = s235;
	}
	public String getS335() {
		return s335;
	}
	public void setS335(String s335) {
		this.s335 = s335;
	}
	public String getS435() {
		return s435;
	}
	public void setS435(String s435) {
		this.s435 = s435;
	}
	public String getS535() {
		return s535;
	}
	public void setS535(String s535) {
		this.s535 = s535;
	}
	public String getFaxn() {
		return faxn;
	}
	public void setFaxn(String faxn) {
		this.faxn = faxn;
	}
	public String getEadr() {
		return eadr;
	}
	public void setEadr(String eadr) {
		this.eadr = eadr;
	}
	
}