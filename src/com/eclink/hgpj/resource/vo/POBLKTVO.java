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
public class POBLKTVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String ordno;
	private String itnbr;
	private String house;
	private Short linsq;
	private Short blksq;
	private Integer poisq;
	private Integer invfg;
	private Double relqt;
	private Double stkpr;
	private Double stkpl;
	private Integer reldt;
	private Integer latdt;
	private Double dkqty;
	private Double insqt;
	private Double qtscp;
	private Double stkqt;
	private Short shpid;
	private String recrq;
	private String shpnm;
	private String ship1;
	private String ship2;
	private String scity;
	private String adrft;
	private String sstac;
	private String scntr;
	private String shpzp;
	private String stele;
	private String scont;
	private Double qtyde;
	private Double tramt;
	private String sabbn;
	private Integer recdt;
	private String staic;
	private Double qtrel;
	private Integer lardt;
	private Double exopr;
	private Double exopl;
	private Double qtyrt;
	private Double qrtrn;
	private Integer prmdt;
	private Integer dylde;
	private Integer dyldl;
	private Integer dokdt;
	private String dokdts;
	private Double actpr;
	private Double actpl;
	private Double extpr;
	private Double extpl;
	private Double frtam;
	private Double frtal;
	private Double actqy;
	private String invds;
	private String timfg;
	private String mrpfg;
	private Double rwcst;
	private String travl;
	private String tract;
	private Integer mdate;
	private Double msdqt;
	private Integer msndd;
	private String msocc;
	private Double opndv;
	private Double ucorq;
	private Double ovpri;
	private Double ovprl;
	private Short ltexp;
	private Short ltact;
	private String turna;
	private String turnc;
	private Integer turnn;
	private Integer pgedt;
	private Integer actdt;
	private Double ltven;
	private Double ltstk;
	private Double ltrev;
	private Double ltsaf;
	private Integer hstvb;
	private Integer rsch;
	private String msch;
	private String rosd;
	private Double rpam;
	private Integer revnb;
	private String reprt;
	private String uusapb;
	private String uusbpb;
	private String uucapb;
	private String uucbpb;
	private Double uuq1pb;
	private Double uua1pb;
	private Integer uud1pb;
	private String uu25pb;
	private String uu40pb;
	private String sn35;
	private String s135;
	private String s235;
	private String s335;
	private String s435;
	private String s535;
	private String faxn;
	private String eadr;
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
	public Integer getPoisq() {
		return poisq;
	}
	public void setPoisq(Integer poisq) {
		this.poisq = poisq;
	}
	public Integer getInvfg() {
		return invfg;
	}
	public void setInvfg(Integer invfg) {
		this.invfg = invfg;
	}
	public Double getRelqt() {
		return relqt;
	}
	public void setRelqt(Double relqt) {
		this.relqt = relqt;
	}
	public Double getStkpr() {
		return stkpr;
	}
	public void setStkpr(Double stkpr) {
		this.stkpr = stkpr;
	}
	public Double getStkpl() {
		return stkpl;
	}
	public void setStkpl(Double stkpl) {
		this.stkpl = stkpl;
	}
	public Integer getReldt() {
		return reldt;
	}
	public void setReldt(Integer reldt) {
		this.reldt = reldt;
	}
	public Integer getLatdt() {
		return latdt;
	}
	public void setLatdt(Integer latdt) {
		this.latdt = latdt;
	}
	public Double getDkqty() {
		return dkqty;
	}
	public void setDkqty(Double dkqty) {
		this.dkqty = dkqty;
	}
	public Double getInsqt() {
		return insqt;
	}
	public void setInsqt(Double insqt) {
		this.insqt = insqt;
	}
	public Double getQtscp() {
		return qtscp;
	}
	public void setQtscp(Double qtscp) {
		this.qtscp = qtscp;
	}
	public Double getStkqt() {
		return stkqt;
	}
	public void setStkqt(Double stkqt) {
		this.stkqt = stkqt;
	}
	public Short getShpid() {
		return shpid;
	}
	public void setShpid(Short shpid) {
		this.shpid = shpid;
	}
	public String getRecrq() {
		return recrq;
	}
	public void setRecrq(String recrq) {
		this.recrq = recrq;
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
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
	public String getAdrft() {
		return adrft;
	}
	public void setAdrft(String adrft) {
		this.adrft = adrft;
	}
	public String getSstac() {
		return sstac;
	}
	public void setSstac(String sstac) {
		this.sstac = sstac;
	}
	public String getScntr() {
		return scntr;
	}
	public void setScntr(String scntr) {
		this.scntr = scntr;
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
	public Double getQtyde() {
		return qtyde;
	}
	public void setQtyde(Double qtyde) {
		this.qtyde = qtyde;
	}
	public Double getTramt() {
		return tramt;
	}
	public void setTramt(Double tramt) {
		this.tramt = tramt;
	}
	public String getSabbn() {
		return sabbn;
	}
	public void setSabbn(String sabbn) {
		this.sabbn = sabbn;
	}
	public Integer getRecdt() {
		return recdt;
	}
	public void setRecdt(Integer recdt) {
		this.recdt = recdt;
	}
	public String getStaic() {
		return staic;
	}
	public void setStaic(String staic) {
		this.staic = staic;
	}
	public Double getQtrel() {
		return qtrel;
	}
	public void setQtrel(Double qtrel) {
		this.qtrel = qtrel;
	}
	public Integer getLardt() {
		return lardt;
	}
	public void setLardt(Integer lardt) {
		this.lardt = lardt;
	}
	public Double getExopr() {
		return exopr;
	}
	public void setExopr(Double exopr) {
		this.exopr = exopr;
	}
	public Double getExopl() {
		return exopl;
	}
	public void setExopl(Double exopl) {
		this.exopl = exopl;
	}
	public Double getQtyrt() {
		return qtyrt;
	}
	public void setQtyrt(Double qtyrt) {
		this.qtyrt = qtyrt;
	}
	public Double getQrtrn() {
		return qrtrn;
	}
	public void setQrtrn(Double qrtrn) {
		this.qrtrn = qrtrn;
	}
	public Integer getPrmdt() {
		return prmdt;
	}
	public void setPrmdt(Integer prmdt) {
		this.prmdt = prmdt;
	}
	public Integer getDylde() {
		return dylde;
	}
	public void setDylde(Integer dylde) {
		this.dylde = dylde;
	}
	public Integer getDyldl() {
		return dyldl;
	}
	public void setDyldl(Integer dyldl) {
		this.dyldl = dyldl;
	}
	public Integer getDokdt() {
		return dokdt;
	}
	public void setDokdt(Integer dokdt) {
		this.dokdt = dokdt;
	}
	public Double getActpr() {
		return actpr;
	}
	public void setActpr(Double actpr) {
		this.actpr = actpr;
	}
	public Double getActpl() {
		return actpl;
	}
	public void setActpl(Double actpl) {
		this.actpl = actpl;
	}
	public Double getExtpr() {
		return extpr;
	}
	public void setExtpr(Double extpr) {
		this.extpr = extpr;
	}
	public Double getExtpl() {
		return extpl;
	}
	public void setExtpl(Double extpl) {
		this.extpl = extpl;
	}
	public Double getFrtam() {
		return frtam;
	}
	public void setFrtam(Double frtam) {
		this.frtam = frtam;
	}
	public Double getFrtal() {
		return frtal;
	}
	public void setFrtal(Double frtal) {
		this.frtal = frtal;
	}
	public Double getActqy() {
		return actqy;
	}
	public void setActqy(Double actqy) {
		this.actqy = actqy;
	}
	public String getInvds() {
		return invds;
	}
	public void setInvds(String invds) {
		this.invds = invds;
	}
	public String getTimfg() {
		return timfg;
	}
	public void setTimfg(String timfg) {
		this.timfg = timfg;
	}
	public String getMrpfg() {
		return mrpfg;
	}
	public void setMrpfg(String mrpfg) {
		this.mrpfg = mrpfg;
	}
	public Double getRwcst() {
		return rwcst;
	}
	public void setRwcst(Double rwcst) {
		this.rwcst = rwcst;
	}
	public String getTravl() {
		return travl;
	}
	public void setTravl(String travl) {
		this.travl = travl;
	}
	public String getTract() {
		return tract;
	}
	public void setTract(String tract) {
		this.tract = tract;
	}
	public Integer getMdate() {
		return mdate;
	}
	public void setMdate(Integer mdate) {
		this.mdate = mdate;
	}
	public Double getMsdqt() {
		return msdqt;
	}
	public void setMsdqt(Double msdqt) {
		this.msdqt = msdqt;
	}
	public Integer getMsndd() {
		return msndd;
	}
	public void setMsndd(Integer msndd) {
		this.msndd = msndd;
	}
	public String getMsocc() {
		return msocc;
	}
	public void setMsocc(String msocc) {
		this.msocc = msocc;
	}
	public Double getOpndv() {
		return opndv;
	}
	public void setOpndv(Double opndv) {
		this.opndv = opndv;
	}
	public Double getUcorq() {
		return ucorq;
	}
	public void setUcorq(Double ucorq) {
		this.ucorq = ucorq;
	}
	public Double getOvpri() {
		return ovpri;
	}
	public void setOvpri(Double ovpri) {
		this.ovpri = ovpri;
	}
	public Double getOvprl() {
		return ovprl;
	}
	public void setOvprl(Double ovprl) {
		this.ovprl = ovprl;
	}
	public Short getLtexp() {
		return ltexp;
	}
	public void setLtexp(Short ltexp) {
		this.ltexp = ltexp;
	}
	public Short getLtact() {
		return ltact;
	}
	public void setLtact(Short ltact) {
		this.ltact = ltact;
	}
	public String getTurna() {
		return turna;
	}
	public void setTurna(String turna) {
		this.turna = turna;
	}
	public String getTurnc() {
		return turnc;
	}
	public void setTurnc(String turnc) {
		this.turnc = turnc;
	}
	public Integer getTurnn() {
		return turnn;
	}
	public void setTurnn(Integer turnn) {
		this.turnn = turnn;
	}
	public Integer getPgedt() {
		return pgedt;
	}
	public void setPgedt(Integer pgedt) {
		this.pgedt = pgedt;
	}
	public Integer getActdt() {
		return actdt;
	}
	public void setActdt(Integer actdt) {
		this.actdt = actdt;
	}
	public Double getLtven() {
		return ltven;
	}
	public void setLtven(Double ltven) {
		this.ltven = ltven;
	}
	public Double getLtstk() {
		return ltstk;
	}
	public void setLtstk(Double ltstk) {
		this.ltstk = ltstk;
	}
	public Double getLtrev() {
		return ltrev;
	}
	public void setLtrev(Double ltrev) {
		this.ltrev = ltrev;
	}
	public Double getLtsaf() {
		return ltsaf;
	}
	public void setLtsaf(Double ltsaf) {
		this.ltsaf = ltsaf;
	}
	public Integer getHstvb() {
		return hstvb;
	}
	public void setHstvb(Integer hstvb) {
		this.hstvb = hstvb;
	}
	public Integer getRsch() {
		return rsch;
	}
	public void setRsch(Integer rsch) {
		this.rsch = rsch;
	}
	public String getMsch() {
		return msch;
	}
	public void setMsch(String msch) {
		this.msch = msch;
	}
	public String getRosd() {
		return rosd;
	}
	public void setRosd(String rosd) {
		this.rosd = rosd;
	}
	public Double getRpam() {
		return rpam;
	}
	public void setRpam(Double rpam) {
		this.rpam = rpam;
	}
	public Integer getRevnb() {
		return revnb;
	}
	public void setRevnb(Integer revnb) {
		this.revnb = revnb;
	}
	public String getReprt() {
		return reprt;
	}
	public void setReprt(String reprt) {
		this.reprt = reprt;
	}
	public String getUusapb() {
		return uusapb;
	}
	public void setUusapb(String uusapb) {
		this.uusapb = uusapb;
	}
	public String getUusbpb() {
		return uusbpb;
	}
	public void setUusbpb(String uusbpb) {
		this.uusbpb = uusbpb;
	}
	public String getUucapb() {
		return uucapb;
	}
	public void setUucapb(String uucapb) {
		this.uucapb = uucapb;
	}
	public String getUucbpb() {
		return uucbpb;
	}
	public void setUucbpb(String uucbpb) {
		this.uucbpb = uucbpb;
	}
	public Double getUuq1pb() {
		return uuq1pb;
	}
	public void setUuq1pb(Double uuq1pb) {
		this.uuq1pb = uuq1pb;
	}
	public Double getUua1pb() {
		return uua1pb;
	}
	public void setUua1pb(Double uua1pb) {
		this.uua1pb = uua1pb;
	}
	public Integer getUud1pb() {
		return uud1pb;
	}
	public void setUud1pb(Integer uud1pb) {
		this.uud1pb = uud1pb;
	}
	public String getUu25pb() {
		return uu25pb;
	}
	public void setUu25pb(String uu25pb) {
		this.uu25pb = uu25pb;
	}
	public String getUu40pb() {
		return uu40pb;
	}
	public void setUu40pb(String uu40pb) {
		this.uu40pb = uu40pb;
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
	public String getDokdts() {
		return dokdts;
	}
	public void setDokdts(String dokdts) {
		this.dokdts = dokdts;
	}
	
}