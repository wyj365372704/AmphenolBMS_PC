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
public class POMASTVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	

	private String ordno;
	private String vndnr;
	private BigDecimal actdt;
	private Integer foldt;
	private Integer condt;
	private Integer revdt;
	private Integer clodt;
	private Integer latdt;
	private Integer mdate;
	private Integer lindt;
	private Integer invfg;
	private String fobds;
	private String viacd;
	private String viads;
	private String trmds;
	private String shpnm;
	private String ship1;
	private String ship2;
	private String shpzp;
	private String connm;
	private String contl;
	private Double frtex;
	private Double frtac;
	private Double valex;
	private Double valin;
	private Double taxmt;
	private Integer revnb;
	private String pstts;
	private Integer spsts;
	private String prity;
	private String fobcd;
	private String trmcd;
	private String reprt;
	private String curlo;
	private String curop;
	private String wccur;
	private Short shpid;
	private String staic;
	private Integer ldbdt;
	private Integer popdt;
	private Integer lrvdt;
	private Integer vcldt;
	private Integer cocdt;
	private String buyno;
	private String house;
	private String ackfl;
	private String cltyp;
	private String tract;
	private String hldcd;
	private String orgcd;
	private String invcc;
	private Short bilid;
	private Short invsq;
	private String rvscd;
	private String porcd;
	private String upinv;
	private String inuse;
	private String trmid;
	private String turna;
	private Integer turnn;
	private String turnc;
	private Integer pgedt;
	private String curid;
	private String curds;
	private String pcuri;
	private Integer oexdt;
	private Double excrt;
	private String scntr;
	private String scity;
	private String sstac;
	private String adrft;
	private Double frtel;
	private Double frtal;
	private Double valel;
	private Double valil;
	private Double spcam;
	private Double spcal;
	private String spprt;
	private Integer hstvm;
	private String omqt;
	private String apst;
	private Double apva;
	private Double apvr;
	private Double apal;
	private Double aprl;
	private String tken;
	private Double txal;
	private String freu;
	private String fren;
	private String frec;
	private String frep;
	private String speu;
	private String spen;
	private String spec;
	private String spep;
	private String ogau;
	private String appt;
	private String ifmi;
	private String chgtp;
	private String uusapm;
	private String uusbpm;
	private String uucapm;
	private String uucbpm;
	private Double uuq1pm;
	private Double uua1pm;
	private Integer uud1pm;
	private String uu25pm;
	private String uu40pm;
	private String shld;
	private String scac;
	private String sn35;
	private String s135;
	private String s235;
	private String s335;
	private String s435;
	private String s535;
	private String admin;
	private String idtrd;
	private Integer idref;
	private String dtxt;
	private String stxt;
	private String frxf;
	private String ctxp;
	private String ismt;
	private String ntmt;
	private String ftxc;
	private String stxc;
	private Double scat;
	private Double scal;
	private String faxn;
	private String eadr;
	private String acur;
	private String altp;
	private String uuiapm;
	private String vn35;
	private String vcont;
	private String txsuf;
	private String startDate;
	private String endDate;
	private String actdts;
	
	private List<POITEMVO> poitemList;

	public String getActdts() {
		return actdts;
	}

	public void setActdts(String actdts) {
		this.actdts = actdts;
	}

	public String getOrdno() {
		return this.ordno;
	}

	public void setOrdno(String ordno) {
		this.ordno = ordno;
	}

	public String getVndnr() {
		return this.vndnr;
	}


	public String getStaic() {
		return staic;
	}

	public void setStaic(String staic) {
		this.staic = staic;
	}

	public void setVndnr(String vndnr) {
		this.vndnr = vndnr;
	}

	public BigDecimal getActdt() {
		return this.actdt;
	}

	public void setActdt(BigDecimal actdt) {
		this.actdt = actdt;
	}

	public Integer getFoldt() {
		return this.foldt;
	}

	public void setFoldt(Integer foldt) {
		this.foldt = foldt;
	}

	public Integer getCondt() {
		return this.condt;
	}

	public void setCondt(Integer condt) {
		this.condt = condt;
	}

	public Integer getRevdt() {
		return this.revdt;
	}

	public void setRevdt(Integer revdt) {
		this.revdt = revdt;
	}

	public Integer getClodt() {
		return this.clodt;
	}

	public void setClodt(Integer clodt) {
		this.clodt = clodt;
	}

	public Integer getLatdt() {
		return this.latdt;
	}

	public void setLatdt(Integer latdt) {
		this.latdt = latdt;
	}

	public Integer getMdate() {
		return this.mdate;
	}

	public void setMdate(Integer mdate) {
		this.mdate = mdate;
	}

	public Integer getLindt() {
		return this.lindt;
	}

	public void setLindt(Integer lindt) {
		this.lindt = lindt;
	}


	public String getFobds() {
		return this.fobds;
	}

	public void setFobds(String fobds) {
		this.fobds = fobds;
	}

	public String getViacd() {
		return this.viacd;
	}

	public void setViacd(String viacd) {
		this.viacd = viacd;
	}

	public String getViads() {
		return this.viads;
	}

	public void setViads(String viads) {
		this.viads = viads;
	}

	public String getTrmds() {
		return this.trmds;
	}

	public void setTrmds(String trmds) {
		this.trmds = trmds;
	}

	public String getShpnm() {
		return this.shpnm;
	}

	public void setShpnm(String shpnm) {
		this.shpnm = shpnm;
	}

	public String getShip1() {
		return this.ship1;
	}

	public void setShip1(String ship1) {
		this.ship1 = ship1;
	}

	public String getShip2() {
		return this.ship2;
	}

	public void setShip2(String ship2) {
		this.ship2 = ship2;
	}

	public String getShpzp() {
		return this.shpzp;
	}

	public void setShpzp(String shpzp) {
		this.shpzp = shpzp;
	}

	public String getConnm() {
		return this.connm;
	}

	public void setConnm(String connm) {
		this.connm = connm;
	}

	public String getContl() {
		return this.contl;
	}

	public void setContl(String contl) {
		this.contl = contl;
	}

	public Double getFrtex() {
		return this.frtex;
	}

	public void setFrtex(Double frtex) {
		this.frtex = frtex;
	}

	public Double getFrtac() {
		return this.frtac;
	}

	public void setFrtac(Double frtac) {
		this.frtac = frtac;
	}

	public Double getValex() {
		return this.valex;
	}

	public void setValex(Double valex) {
		this.valex = valex;
	}

	public Double getValin() {
		return this.valin;
	}

	public void setValin(Double valin) {
		this.valin = valin;
	}

	public Double getTaxmt() {
		return this.taxmt;
	}

	public void setTaxmt(Double taxmt) {
		this.taxmt = taxmt;
	}

	

	public String getPstts() {
		return this.pstts;
	}

	public void setPstts(String pstts) {
		this.pstts = pstts;
	}



	public String getFobcd() {
		return this.fobcd;
	}

	public void setFobcd(String fobcd) {
		this.fobcd = fobcd;
	}

	public String getTrmcd() {
		return this.trmcd;
	}

	public void setTrmcd(String trmcd) {
		this.trmcd = trmcd;
	}

	public String getReprt() {
		return this.reprt;
	}

	public void setReprt(String reprt) {
		this.reprt = reprt;
	}

	public String getCurlo() {
		return this.curlo;
	}

	public void setCurlo(String curlo) {
		this.curlo = curlo;
	}

	public String getCurop() {
		return this.curop;
	}

	public void setCurop(String curop) {
		this.curop = curop;
	}

	public String getWccur() {
		return this.wccur;
	}

	public void setWccur(String wccur) {
		this.wccur = wccur;
	}

	public Short getShpid() {
		return this.shpid;
	}

	public void setShpid(Short shpid) {
		this.shpid = shpid;
	}

	public Integer getLdbdt() {
		return this.ldbdt;
	}

	public void setLdbdt(Integer ldbdt) {
		this.ldbdt = ldbdt;
	}

	public Integer getPopdt() {
		return this.popdt;
	}

	public void setPopdt(Integer popdt) {
		this.popdt = popdt;
	}

	public Integer getLrvdt() {
		return this.lrvdt;
	}

	public void setLrvdt(Integer lrvdt) {
		this.lrvdt = lrvdt;
	}

	public Integer getVcldt() {
		return this.vcldt;
	}

	public void setVcldt(Integer vcldt) {
		this.vcldt = vcldt;
	}

	public Integer getCocdt() {
		return this.cocdt;
	}

	public void setCocdt(Integer cocdt) {
		this.cocdt = cocdt;
	}

	public String getBuyno() {
		return this.buyno;
	}

	public void setBuyno(String buyno) {
		this.buyno = buyno;
	}

	public String getHouse() {
		return this.house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getAckfl() {
		return this.ackfl;
	}

	public void setAckfl(String ackfl) {
		this.ackfl = ackfl;
	}

	public String getCltyp() {
		return this.cltyp;
	}

	public void setCltyp(String cltyp) {
		this.cltyp = cltyp;
	}

	public String getTract() {
		return this.tract;
	}

	public void setTract(String tract) {
		this.tract = tract;
	}

	public String getHldcd() {
		return this.hldcd;
	}

	public void setHldcd(String hldcd) {
		this.hldcd = hldcd;
	}

	public String getOrgcd() {
		return this.orgcd;
	}

	public void setOrgcd(String orgcd) {
		this.orgcd = orgcd;
	}

	public String getInvcc() {
		return this.invcc;
	}

	public void setInvcc(String invcc) {
		this.invcc = invcc;
	}

	public Short getBilid() {
		return this.bilid;
	}

	public void setBilid(Short bilid) {
		this.bilid = bilid;
	}

	public Short getInvsq() {
		return this.invsq;
	}

	public void setInvsq(Short invsq) {
		this.invsq = invsq;
	}

	public String getRvscd() {
		return this.rvscd;
	}

	public void setRvscd(String rvscd) {
		this.rvscd = rvscd;
	}


	public String getInuse() {
		return this.inuse;
	}

	public void setInuse(String inuse) {
		this.inuse = inuse;
	}

	public String getTrmid() {
		return this.trmid;
	}

	public void setTrmid(String trmid) {
		this.trmid = trmid;
	}


	public Integer getTurnn() {
		return this.turnn;
	}

	public void setTurnn(Integer turnn) {
		this.turnn = turnn;
	}


	public Integer getPgedt() {
		return this.pgedt;
	}

	public void setPgedt(Integer pgedt) {
		this.pgedt = pgedt;
	}

	public String getCurid() {
		return this.curid;
	}

	public void setCurid(String curid) {
		this.curid = curid;
	}

	public String getCurds() {
		return this.curds;
	}

	public void setCurds(String curds) {
		this.curds = curds;
	}

	public String getPcuri() {
		return this.pcuri;
	}

	public void setPcuri(String pcuri) {
		this.pcuri = pcuri;
	}

	public Integer getOexdt() {
		return this.oexdt;
	}

	public void setOexdt(Integer oexdt) {
		this.oexdt = oexdt;
	}

	public Double getExcrt() {
		return this.excrt;
	}

	public void setExcrt(Double excrt) {
		this.excrt = excrt;
	}

	public String getScntr() {
		return this.scntr;
	}

	public void setScntr(String scntr) {
		this.scntr = scntr;
	}

	public String getScity() {
		return this.scity;
	}

	public void setScity(String scity) {
		this.scity = scity;
	}

	public String getSstac() {
		return this.sstac;
	}

	public void setSstac(String sstac) {
		this.sstac = sstac;
	}


	public String getPrity() {
		return prity;
	}

	public void setPrity(String prity) {
		this.prity = prity;
	}

	public String getPorcd() {
		return porcd;
	}

	public void setPorcd(String porcd) {
		this.porcd = porcd;
	}

	public String getUpinv() {
		return upinv;
	}

	public void setUpinv(String upinv) {
		this.upinv = upinv;
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

	public String getAdrft() {
		return adrft;
	}

	public void setAdrft(String adrft) {
		this.adrft = adrft;
	}

	public Double getFrtel() {
		return this.frtel;
	}

	public void setFrtel(Double frtel) {
		this.frtel = frtel;
	}

	public Double getFrtal() {
		return this.frtal;
	}

	public void setFrtal(Double frtal) {
		this.frtal = frtal;
	}

	public Double getValel() {
		return this.valel;
	}

	public void setValel(Double valel) {
		this.valel = valel;
	}

	public Double getValil() {
		return this.valil;
	}

	public void setValil(Double valil) {
		this.valil = valil;
	}

	public Double getSpcam() {
		return this.spcam;
	}

	public void setSpcam(Double spcam) {
		this.spcam = spcam;
	}

	public Double getSpcal() {
		return this.spcal;
	}

	public void setSpcal(Double spcal) {
		this.spcal = spcal;
	}

	public String getSpprt() {
		return this.spprt;
	}

	public void setSpprt(String spprt) {
		this.spprt = spprt;
	}


	public String getOmqt() {
		return this.omqt;
	}

	public void setOmqt(String omqt) {
		this.omqt = omqt;
	}

	public String getApst() {
		return this.apst;
	}

	public void setApst(String apst) {
		this.apst = apst;
	}

	public Double getApva() {
		return this.apva;
	}

	public void setApva(Double apva) {
		this.apva = apva;
	}

	public Double getApvr() {
		return this.apvr;
	}

	public void setApvr(Double apvr) {
		this.apvr = apvr;
	}

	public Double getApal() {
		return this.apal;
	}

	public void setApal(Double apal) {
		this.apal = apal;
	}

	public Double getAprl() {
		return this.aprl;
	}

	public void setAprl(Double aprl) {
		this.aprl = aprl;
	}

	public String getTken() {
		return this.tken;
	}

	public void setTken(String tken) {
		this.tken = tken;
	}

	public Double getTxal() {
		return this.txal;
	}

	public void setTxal(Double txal) {
		this.txal = txal;
	}

	public String getFreu() {
		return this.freu;
	}

	public void setFreu(String freu) {
		this.freu = freu;
	}

	public String getFren() {
		return this.fren;
	}

	public void setFren(String fren) {
		this.fren = fren;
	}

	public String getFrec() {
		return this.frec;
	}

	public void setFrec(String frec) {
		this.frec = frec;
	}

	public String getFrep() {
		return this.frep;
	}

	public void setFrep(String frep) {
		this.frep = frep;
	}

	public String getSpeu() {
		return this.speu;
	}

	public void setSpeu(String speu) {
		this.speu = speu;
	}

	public String getSpen() {
		return this.spen;
	}

	public void setSpen(String spen) {
		this.spen = spen;
	}

	public String getSpec() {
		return this.spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getSpep() {
		return this.spep;
	}

	public void setSpep(String spep) {
		this.spep = spep;
	}

	public String getOgau() {
		return this.ogau;
	}

	public void setOgau(String ogau) {
		this.ogau = ogau;
	}

	public String getAppt() {
		return this.appt;
	}

	public void setAppt(String appt) {
		this.appt = appt;
	}

	public String getIfmi() {
		return this.ifmi;
	}

	public void setIfmi(String ifmi) {
		this.ifmi = ifmi;
	}

	public String getChgtp() {
		return this.chgtp;
	}

	public void setChgtp(String chgtp) {
		this.chgtp = chgtp;
	}

	public String getUusapm() {
		return this.uusapm;
	}

	public void setUusapm(String uusapm) {
		this.uusapm = uusapm;
	}

	public String getUusbpm() {
		return this.uusbpm;
	}

	public void setUusbpm(String uusbpm) {
		this.uusbpm = uusbpm;
	}

	public String getUucapm() {
		return this.uucapm;
	}

	public void setUucapm(String uucapm) {
		this.uucapm = uucapm;
	}

	public String getUucbpm() {
		return this.uucbpm;
	}

	public void setUucbpm(String uucbpm) {
		this.uucbpm = uucbpm;
	}

	public Double getUuq1pm() {
		return this.uuq1pm;
	}

	public void setUuq1pm(Double uuq1pm) {
		this.uuq1pm = uuq1pm;
	}

	public Double getUua1pm() {
		return this.uua1pm;
	}

	public void setUua1pm(Double uua1pm) {
		this.uua1pm = uua1pm;
	}

	public Integer getUud1pm() {
		return this.uud1pm;
	}

	public void setUud1pm(Integer uud1pm) {
		this.uud1pm = uud1pm;
	}

	public String getUu25pm() {
		return this.uu25pm;
	}

	public void setUu25pm(String uu25pm) {
		this.uu25pm = uu25pm;
	}

	public String getUu40pm() {
		return this.uu40pm;
	}

	public void setUu40pm(String uu40pm) {
		this.uu40pm = uu40pm;
	}

	public String getShld() {
		return this.shld;
	}

	public void setShld(String shld) {
		this.shld = shld;
	}

	public String getScac() {
		return this.scac;
	}

	public void setScac(String scac) {
		this.scac = scac;
	}

	public String getSn35() {
		return this.sn35;
	}

	public void setSn35(String sn35) {
		this.sn35 = sn35;
	}

	public String getS135() {
		return this.s135;
	}

	public void setS135(String s135) {
		this.s135 = s135;
	}

	public String getS235() {
		return this.s235;
	}

	public void setS235(String s235) {
		this.s235 = s235;
	}

	public String getS335() {
		return this.s335;
	}

	public void setS335(String s335) {
		this.s335 = s335;
	}

	public String getS435() {
		return this.s435;
	}

	public void setS435(String s435) {
		this.s435 = s435;
	}

	public String getS535() {
		return this.s535;
	}

	public void setS535(String s535) {
		this.s535 = s535;
	}

	public String getAdmin() {
		return this.admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getIdtrd() {
		return this.idtrd;
	}

	public void setIdtrd(String idtrd) {
		this.idtrd = idtrd;
	}

	public Integer getIdref() {
		return this.idref;
	}

	public void setIdref(Integer idref) {
		this.idref = idref;
	}

	public String getDtxt() {
		return this.dtxt;
	}

	public void setDtxt(String dtxt) {
		this.dtxt = dtxt;
	}

	public String getStxt() {
		return this.stxt;
	}

	public void setStxt(String stxt) {
		this.stxt = stxt;
	}

	public String getFrxf() {
		return this.frxf;
	}

	public void setFrxf(String frxf) {
		this.frxf = frxf;
	}

	public String getCtxp() {
		return this.ctxp;
	}

	public void setCtxp(String ctxp) {
		this.ctxp = ctxp;
	}

	public String getIsmt() {
		return this.ismt;
	}

	public void setIsmt(String ismt) {
		this.ismt = ismt;
	}

	public String getNtmt() {
		return this.ntmt;
	}

	public void setNtmt(String ntmt) {
		this.ntmt = ntmt;
	}

	public String getFtxc() {
		return this.ftxc;
	}

	public void setFtxc(String ftxc) {
		this.ftxc = ftxc;
	}

	public String getStxc() {
		return this.stxc;
	}

	public void setStxc(String stxc) {
		this.stxc = stxc;
	}

	public Double getScat() {
		return this.scat;
	}

	public void setScat(Double scat) {
		this.scat = scat;
	}

	public Double getScal() {
		return this.scal;
	}

	public void setScal(Double scal) {
		this.scal = scal;
	}

	public String getFaxn() {
		return this.faxn;
	}

	public void setFaxn(String faxn) {
		this.faxn = faxn;
	}

	public String getEadr() {
		return this.eadr;
	}

	public void setEadr(String eadr) {
		this.eadr = eadr;
	}

	public String getAcur() {
		return this.acur;
	}

	public void setAcur(String acur) {
		this.acur = acur;
	}

	public String getAltp() {
		return this.altp;
	}

	public void setAltp(String altp) {
		this.altp = altp;
	}

	public String getUuiapm() {
		return this.uuiapm;
	}

	public void setUuiapm(String uuiapm) {
		this.uuiapm = uuiapm;
	}

	public Integer getInvfg() {
		return invfg;
	}

	public void setInvfg(Integer invfg) {
		this.invfg = invfg;
	}

	public Integer getRevnb() {
		return revnb;
	}

	public void setRevnb(Integer revnb) {
		this.revnb = revnb;
	}

	public Integer getSpsts() {
		return spsts;
	}

	public void setSpsts(Integer spsts) {
		this.spsts = spsts;
	}

	public Integer getHstvm() {
		return hstvm;
	}

	public void setHstvm(Integer hstvm) {
		this.hstvm = hstvm;
	}

	public String getVn35() {
		return vn35;
	}

	public void setVn35(String vn35) {
		this.vn35 = vn35;
	}

	public String getVcont() {
		return vcont;
	}

	public void setVcont(String vcont) {
		this.vcont = vcont;
	}

	public String getTxsuf() {
		return txsuf;
	}

	public void setTxsuf(String txsuf) {
		this.txsuf = txsuf;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<POITEMVO> getPoitemList() {
		return poitemList;
	}

	public void setPoitemList(List<POITEMVO> poitemList) {
		this.poitemList = poitemList;
	}
	
	
	
}