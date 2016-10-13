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
public class POCOMTVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String ordno;
	private String itnbr;
	private String house;
	private Short linsq;
	private Short blksq;
	private String debit;
	private Short cmseq;
	private Integer poisq;
	private String messn;
	private String cmnt1;
	private String cmnt2;
	private Short chgtx;
	private Short revnb;
	private Integer mdate;
	private String opseq;
	private String wkctr;
	private String wuflg;
	private String rtaut;
	private String usint;
	private String tract;
	private Short chgno;
	private String chgdl;
	private Integer chgdt;
	private String edsfl;
	private Integer pgedt;
	private Short hstvc;
	private String cpyi;
	private Short ctls;
	public String getOrdno() {
		return ordno;
	}
	public void setOrdno(String ordno) {
		this.ordno = ordno;
	}
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
	public Short getLinsq() {
		return linsq;
	}
	public void setLinsq(Short linsq) {
		this.linsq = linsq;
	}
	public Short getBlksq() {
		return blksq;
	}
	public void setBlksq(Short blksq) {
		this.blksq = blksq;
	}
	public String getDebit() {
		return debit;
	}
	public void setDebit(String debit) {
		this.debit = debit;
	}
	public Short getCmseq() {
		return cmseq;
	}
	public void setCmseq(Short cmseq) {
		this.cmseq = cmseq;
	}
	public Integer getPoisq() {
		return poisq;
	}
	public void setPoisq(Integer poisq) {
		this.poisq = poisq;
	}
	public String getMessn() {
		return messn;
	}
	public void setMessn(String messn) {
		this.messn = messn;
	}
	public String getCmnt1() {
		return cmnt1;
	}
	public void setCmnt1(String cmnt1) {
		this.cmnt1 = cmnt1;
	}
	public String getCmnt2() {
		return cmnt2;
	}
	public void setCmnt2(String cmnt2) {
		this.cmnt2 = cmnt2;
	}
	public Short getChgtx() {
		return chgtx;
	}
	public void setChgtx(Short chgtx) {
		this.chgtx = chgtx;
	}
	public Short getRevnb() {
		return revnb;
	}
	public void setRevnb(Short revnb) {
		this.revnb = revnb;
	}
	public Integer getMdate() {
		return mdate;
	}
	public void setMdate(Integer mdate) {
		this.mdate = mdate;
	}
	public String getOpseq() {
		return opseq;
	}
	public void setOpseq(String opseq) {
		this.opseq = opseq;
	}
	public String getWkctr() {
		return wkctr;
	}
	public void setWkctr(String wkctr) {
		this.wkctr = wkctr;
	}
	public String getWuflg() {
		return wuflg;
	}
	public void setWuflg(String wuflg) {
		this.wuflg = wuflg;
	}
	public String getRtaut() {
		return rtaut;
	}
	public void setRtaut(String rtaut) {
		this.rtaut = rtaut;
	}
	public String getUsint() {
		return usint;
	}
	public void setUsint(String usint) {
		this.usint = usint;
	}
	public String getTract() {
		return tract;
	}
	public void setTract(String tract) {
		this.tract = tract;
	}
	public Short getChgno() {
		return chgno;
	}
	public void setChgno(Short chgno) {
		this.chgno = chgno;
	}
	public String getChgdl() {
		return chgdl;
	}
	public void setChgdl(String chgdl) {
		this.chgdl = chgdl;
	}
	public Integer getChgdt() {
		return chgdt;
	}
	public void setChgdt(Integer chgdt) {
		this.chgdt = chgdt;
	}
	public String getEdsfl() {
		return edsfl;
	}
	public void setEdsfl(String edsfl) {
		this.edsfl = edsfl;
	}
	public Integer getPgedt() {
		return pgedt;
	}
	public void setPgedt(Integer pgedt) {
		this.pgedt = pgedt;
	}
	public Short getHstvc() {
		return hstvc;
	}
	public void setHstvc(Short hstvc) {
		this.hstvc = hstvc;
	}
	public String getCpyi() {
		return cpyi;
	}
	public void setCpyi(String cpyi) {
		this.cpyi = cpyi;
	}
	public Short getCtls() {
		return ctls;
	}
	public void setCtls(Short ctls) {
		this.ctls = ctls;
	}

}