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
 * 
 * @version 1.0
 * 
 */
public class POITEMVO extends BaseVO {

	private static final long serialVersionUID = 2317968819354022841L;
	private String ordno;
	private String itnbr;
	private String house;
	private Short linsq;
	private Integer poisq;
	private Double qtyor;
	private Double stkpr;
	private Double stkpl;
	private String umord;
	private String itdsc;
	private String blcod;
	private Integer plann;
	private String buyno;
	private String acctn;
	private String refno;
	private Integer foldt;
	private String jobno;
	private String engno;
	private String mulst;
	private String invfg;
	private String dptno;
	private String quotn;
	private String quods;
	private String whslc;
	private Double dkqty;
	private Double insqt;
	private Double qtscp;
	private Double stkqt;
	private Double qtdev;
	private Integer latdt;
	private String vclnb;
	private Double extpr;
	private Double extpl;
	private Double ltven;
	private Double ltstk;
	private Double actpr;
	private Double actpl;
	private Double actqy;
	private String invds;
	private Double ltrev;
	private Double ltsaf;
	private Integer mdate;
	private Integer recdt;
	private String packc;
	private String itcls;
	private String staic;
	private Boolean orlcd;
	private String cntrc;
	private String travl;
	private Boolean recrq;
	private Double qtyde;
	private Double tramt;
	private Integer stkdt;
	private Double taxpt;
	private Double crato;
	private Integer noday;
	private Double qtyrt;
	private Double qrtrn;
	private Integer dylde;
	private Integer dyldl;
	private String unmsr;
	private String purum;
	private Double umcnv;
	private String reqno;
	private String namer;
	private Integer prmdt;
	private Double frtam;
	private Double frtal;
	private Integer duedt;
	private Integer dokdt;
	private String dokdts;
	private String vndnr;
	private String pcuri;
	private String curid;
	private Integer cmpdt;
	private String arblt;
	private Integer lardt;
	private Double qtrel;
	private String exdsc;
	private String tract;
	private Double msdqt;
	private Integer msndd;
	private Integer msnsd;
	private String msocc;
	private Double ucorq;
	private Double curpr;
	private Double curlc;
	private Short ltexp;
	private Double ovpri;
	private Double fracd;
	private Double fracl;
	private Short ltact;
	private String viaac;
	private String viade;
	private Boolean turna;
	private Boolean turnc;
	private Integer turnn;
	private Integer pgedt;
	private Integer actdt;
	private String hstvi;
	private Boolean orrc;
	private Integer rsch;
	private Boolean msch;
	private Boolean rosd;
	private String wonb;
	private String wtsk;
	private String cosc;
	private String mroi;
	private String adpr;
	private String fxbl;
	private Double smrq;
	private Double pcrm;
	private Double qtua;
	private Double prua;
	private Double prlu;
	private String cofo;
	private String lotz;
	private Double rpam;
	private String apty;
	private String fxpr;
	private String unit;
	private String natu;
	private String char_;
	private String appt;
	private String chgtp;
	private String revnb;
	private String uusapt;
	private String uusbpt;
	private String uucapt;
	private String uucbpt;
	private Double uuq1pt;
	private Double uua1pt;
	private Integer uud1pt;
	private String uu25pt;
	private String uu40pt;
	private String qrefn;
	private Integer cnstd;
	private Integer conex;
	private String venct;
	private String licr;
	private String shld;
	private String oemn;
	private String ltxt;
	private String txcls;
	private String uuiapt;
	
	private List<POBLKTVO> poblktList;
	
	private MOPORFVO moporf;
	
	private MOROUTVO morout;
	
	private MOMASTVO momast;
	
	private ITMSITVO itmsit;
	
	private List<MODATAVO> modataList ;
	
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
	public Integer getPoisq() {
		return poisq;
	}
	public void setPoisq(Integer poisq) {
		this.poisq = poisq;
	}
	public Double getQtyor() {
		return qtyor;
	}
	public void setQtyor(Double qtyor) {
		this.qtyor = qtyor;
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
	public String getUmord() {
		return umord;
	}
	public void setUmord(String umord) {
		this.umord = umord;
	}
	public String getItdsc() {
		return itdsc;
	}
	public void setItdsc(String itdsc) {
		this.itdsc = itdsc;
	}
	public String getBlcod() {
		return blcod;
	}
	public void setBlcod(String blcod) {
		this.blcod = blcod;
	}
	public Integer getPlann() {
		return plann;
	}
	public void setPlann(Integer plann) {
		this.plann = plann;
	}
	public String getBuyno() {
		return buyno;
	}
	public void setBuyno(String buyno) {
		this.buyno = buyno;
	}
	public String getAcctn() {
		return acctn;
	}
	public void setAcctn(String acctn) {
		this.acctn = acctn;
	}
	public String getRefno() {
		return refno;
	}
	public void setRefno(String refno) {
		this.refno = refno;
	}
	public Integer getFoldt() {
		return foldt;
	}
	public void setFoldt(Integer foldt) {
		this.foldt = foldt;
	}
	public String getJobno() {
		return jobno;
	}
	public void setJobno(String jobno) {
		this.jobno = jobno;
	}
	public String getEngno() {
		return engno;
	}
	public void setEngno(String engno) {
		this.engno = engno;
	}
	public String getMulst() {
		return mulst;
	}
	public void setMulst(String mulst) {
		this.mulst = mulst;
	}
	public String getDptno() {
		return dptno;
	}
	public void setDptno(String dptno) {
		this.dptno = dptno;
	}
	public String getQuotn() {
		return quotn;
	}
	public void setQuotn(String quotn) {
		this.quotn = quotn;
	}
	public String getQuods() {
		return quods;
	}
	public void setQuods(String quods) {
		this.quods = quods;
	}
	public String getWhslc() {
		return whslc;
	}
	public void setWhslc(String whslc) {
		this.whslc = whslc;
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
	public Double getQtdev() {
		return qtdev;
	}
	public void setQtdev(Double qtdev) {
		this.qtdev = qtdev;
	}
	public Integer getLatdt() {
		return latdt;
	}
	public void setLatdt(Integer latdt) {
		this.latdt = latdt;
	}
	public String getVclnb() {
		return vclnb;
	}
	public void setVclnb(String vclnb) {
		this.vclnb = vclnb;
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
	public Integer getMdate() {
		return mdate;
	}
	public void setMdate(Integer mdate) {
		this.mdate = mdate;
	}
	public Integer getRecdt() {
		return recdt;
	}
	public void setRecdt(Integer recdt) {
		this.recdt = recdt;
	}
	public String getPackc() {
		return packc;
	}
	public void setPackc(String packc) {
		this.packc = packc;
	}
	public String getItcls() {
		return itcls;
	}
	public void setItcls(String itcls) {
		this.itcls = itcls;
	}
	public String getStaic() {
		return staic;
	}
	public void setStaic(String staic) {
		this.staic = staic;
	}
	public Boolean getOrlcd() {
		return orlcd;
	}
	public void setOrlcd(Boolean orlcd) {
		this.orlcd = orlcd;
	}
	public String getCntrc() {
		return cntrc;
	}
	public void setCntrc(String cntrc) {
		this.cntrc = cntrc;
	}
	public String getTravl() {
		return travl;
	}
	public void setTravl(String travl) {
		this.travl = travl;
	}
	public Boolean getRecrq() {
		return recrq;
	}
	public void setRecrq(Boolean recrq) {
		this.recrq = recrq;
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
	public Integer getStkdt() {
		return stkdt;
	}
	public void setStkdt(Integer stkdt) {
		this.stkdt = stkdt;
	}
	public Double getTaxpt() {
		return taxpt;
	}
	public void setTaxpt(Double taxpt) {
		this.taxpt = taxpt;
	}
	public Double getCrato() {
		return crato;
	}
	public void setCrato(Double crato) {
		this.crato = crato;
	}
	public Integer getNoday() {
		return noday;
	}
	public void setNoday(Integer noday) {
		this.noday = noday;
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
	public String getUnmsr() {
		return unmsr;
	}
	public void setUnmsr(String unmsr) {
		this.unmsr = unmsr;
	}
	public String getPurum() {
		return purum;
	}
	public void setPurum(String purum) {
		this.purum = purum;
	}
	public Double getUmcnv() {
		return umcnv;
	}
	public void setUmcnv(Double umcnv) {
		this.umcnv = umcnv;
	}
	public String getReqno() {
		return reqno;
	}
	public void setReqno(String reqno) {
		this.reqno = reqno;
	}
	public String getNamer() {
		return namer;
	}
	public void setNamer(String namer) {
		this.namer = namer;
	}
	public Integer getPrmdt() {
		return prmdt;
	}
	public void setPrmdt(Integer prmdt) {
		this.prmdt = prmdt;
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
	public Integer getDuedt() {
		return duedt;
	}
	public void setDuedt(Integer duedt) {
		this.duedt = duedt;
	}
	public Integer getDokdt() {
		return dokdt;
	}
	public void setDokdt(Integer dokdt) {
		this.dokdt = dokdt;
	}
	public String getVndnr() {
		return vndnr;
	}
	public void setVndnr(String vndnr) {
		this.vndnr = vndnr;
	}
	public String getPcuri() {
		return pcuri;
	}
	public void setPcuri(String pcuri) {
		this.pcuri = pcuri;
	}
	public String getCurid() {
		return curid;
	}
	public void setCurid(String curid) {
		this.curid = curid;
	}
	public Integer getCmpdt() {
		return cmpdt;
	}
	public void setCmpdt(Integer cmpdt) {
		this.cmpdt = cmpdt;
	}
	public String getArblt() {
		return arblt;
	}
	public void setArblt(String arblt) {
		this.arblt = arblt;
	}
	public Integer getLardt() {
		return lardt;
	}
	public void setLardt(Integer lardt) {
		this.lardt = lardt;
	}
	public Double getQtrel() {
		return qtrel;
	}
	public void setQtrel(Double qtrel) {
		this.qtrel = qtrel;
	}
	public String getExdsc() {
		return exdsc;
	}
	public void setExdsc(String exdsc) {
		this.exdsc = exdsc;
	}
	public String getTract() {
		return tract;
	}
	public void setTract(String tract) {
		this.tract = tract;
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
	public Integer getMsnsd() {
		return msnsd;
	}
	public void setMsnsd(Integer msnsd) {
		this.msnsd = msnsd;
	}
	public String getMsocc() {
		return msocc;
	}
	public void setMsocc(String msocc) {
		this.msocc = msocc;
	}
	public Double getUcorq() {
		return ucorq;
	}
	public void setUcorq(Double ucorq) {
		this.ucorq = ucorq;
	}
	public Double getCurpr() {
		return curpr;
	}
	public void setCurpr(Double curpr) {
		this.curpr = curpr;
	}
	public Double getCurlc() {
		return curlc;
	}
	public void setCurlc(Double curlc) {
		this.curlc = curlc;
	}
	public Short getLtexp() {
		return ltexp;
	}
	public void setLtexp(Short ltexp) {
		this.ltexp = ltexp;
	}
	public Double getOvpri() {
		return ovpri;
	}
	public void setOvpri(Double ovpri) {
		this.ovpri = ovpri;
	}
	public Double getFracd() {
		return fracd;
	}
	public void setFracd(Double fracd) {
		this.fracd = fracd;
	}
	public Double getFracl() {
		return fracl;
	}
	public void setFracl(Double fracl) {
		this.fracl = fracl;
	}
	public Short getLtact() {
		return ltact;
	}
	public void setLtact(Short ltact) {
		this.ltact = ltact;
	}
	public String getViaac() {
		return viaac;
	}
	public void setViaac(String viaac) {
		this.viaac = viaac;
	}
	public String getViade() {
		return viade;
	}
	public void setViade(String viade) {
		this.viade = viade;
	}
	public Boolean getTurna() {
		return turna;
	}
	public void setTurna(Boolean turna) {
		this.turna = turna;
	}
	public Boolean getTurnc() {
		return turnc;
	}
	public void setTurnc(Boolean turnc) {
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
	public Boolean getOrrc() {
		return orrc;
	}
	public void setOrrc(Boolean orrc) {
		this.orrc = orrc;
	}
	public Integer getRsch() {
		return rsch;
	}
	public void setRsch(Integer rsch) {
		this.rsch = rsch;
	}
	public Boolean getMsch() {
		return msch;
	}
	public void setMsch(Boolean msch) {
		this.msch = msch;
	}
	public Boolean getRosd() {
		return rosd;
	}
	public void setRosd(Boolean rosd) {
		this.rosd = rosd;
	}
	public String getWonb() {
		return wonb;
	}
	public void setWonb(String wonb) {
		this.wonb = wonb;
	}
	public String getCosc() {
		return cosc;
	}
	public void setCosc(String cosc) {
		this.cosc = cosc;
	}
	public String getMroi() {
		return mroi;
	}
	public void setMroi(String mroi) {
		this.mroi = mroi;
	}
	public String getAdpr() {
		return adpr;
	}
	public void setAdpr(String adpr) {
		this.adpr = adpr;
	}
	public String getFxbl() {
		return fxbl;
	}
	public void setFxbl(String fxbl) {
		this.fxbl = fxbl;
	}
	public Double getSmrq() {
		return smrq;
	}
	public void setSmrq(Double smrq) {
		this.smrq = smrq;
	}
	public Double getPcrm() {
		return pcrm;
	}
	public void setPcrm(Double pcrm) {
		this.pcrm = pcrm;
	}
	public Double getQtua() {
		return qtua;
	}
	public void setQtua(Double qtua) {
		this.qtua = qtua;
	}
	public Double getPrua() {
		return prua;
	}
	public void setPrua(Double prua) {
		this.prua = prua;
	}
	public Double getPrlu() {
		return prlu;
	}
	public void setPrlu(Double prlu) {
		this.prlu = prlu;
	}
	public String getCofo() {
		return cofo;
	}
	public void setCofo(String cofo) {
		this.cofo = cofo;
	}
	public String getLotz() {
		return lotz;
	}
	public void setLotz(String lotz) {
		this.lotz = lotz;
	}
	public Double getRpam() {
		return rpam;
	}
	public void setRpam(Double rpam) {
		this.rpam = rpam;
	}
	public String getApty() {
		return apty;
	}
	public void setApty(String apty) {
		this.apty = apty;
	}
	public String getFxpr() {
		return fxpr;
	}
	public void setFxpr(String fxpr) {
		this.fxpr = fxpr;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getNatu() {
		return natu;
	}
	public void setNatu(String natu) {
		this.natu = natu;
	}
	public String getChar_() {
		return char_;
	}
	public void setChar_(String char_) {
		this.char_ = char_;
	}
	public String getAppt() {
		return appt;
	}
	public void setAppt(String appt) {
		this.appt = appt;
	}
	public String getChgtp() {
		return chgtp;
	}
	public void setChgtp(String chgtp) {
		this.chgtp = chgtp;
	}
	public String getUusapt() {
		return uusapt;
	}
	public void setUusapt(String uusapt) {
		this.uusapt = uusapt;
	}
	public String getUusbpt() {
		return uusbpt;
	}
	public void setUusbpt(String uusbpt) {
		this.uusbpt = uusbpt;
	}
	public String getUucapt() {
		return uucapt;
	}
	public void setUucapt(String uucapt) {
		this.uucapt = uucapt;
	}
	public String getUucbpt() {
		return uucbpt;
	}
	public void setUucbpt(String uucbpt) {
		this.uucbpt = uucbpt;
	}
	public Double getUuq1pt() {
		return uuq1pt;
	}
	public void setUuq1pt(Double uuq1pt) {
		this.uuq1pt = uuq1pt;
	}
	public Double getUua1pt() {
		return uua1pt;
	}
	public void setUua1pt(Double uua1pt) {
		this.uua1pt = uua1pt;
	}
	public Integer getUud1pt() {
		return uud1pt;
	}
	public void setUud1pt(Integer uud1pt) {
		this.uud1pt = uud1pt;
	}
	public String getUu25pt() {
		return uu25pt;
	}
	public void setUu25pt(String uu25pt) {
		this.uu25pt = uu25pt;
	}
	public String getUu40pt() {
		return uu40pt;
	}
	public void setUu40pt(String uu40pt) {
		this.uu40pt = uu40pt;
	}
	public String getQrefn() {
		return qrefn;
	}
	public void setQrefn(String qrefn) {
		this.qrefn = qrefn;
	}
	public Integer getCnstd() {
		return cnstd;
	}
	public void setCnstd(Integer cnstd) {
		this.cnstd = cnstd;
	}
	public Integer getConex() {
		return conex;
	}
	public void setConex(Integer conex) {
		this.conex = conex;
	}
	public String getVenct() {
		return venct;
	}
	public void setVenct(String venct) {
		this.venct = venct;
	}
	public String getLicr() {
		return licr;
	}
	public void setLicr(String licr) {
		this.licr = licr;
	}
	public String getShld() {
		return shld;
	}
	public void setShld(String shld) {
		this.shld = shld;
	}
	public String getOemn() {
		return oemn;
	}
	public void setOemn(String oemn) {
		this.oemn = oemn;
	}
	public String getLtxt() {
		return ltxt;
	}
	public void setLtxt(String ltxt) {
		this.ltxt = ltxt;
	}
	public String getTxcls() {
		return txcls;
	}
	public void setTxcls(String txcls) {
		this.txcls = txcls;
	}
	public String getUuiapt() {
		return uuiapt;
	}
	public void setUuiapt(String uuiapt) {
		this.uuiapt = uuiapt;
	}
	public String getInvfg() {
		return invfg;
	}
	public void setInvfg(String invfg) {
		this.invfg = invfg;
	}
	public String getHstvi() {
		return hstvi;
	}
	public void setHstvi(String hstvi) {
		this.hstvi = hstvi;
	}
	public String getWtsk() {
		return wtsk;
	}
	public void setWtsk(String wtsk) {
		this.wtsk = wtsk;
	}
	public String getRevnb() {
		return revnb;
	}
	public void setRevnb(String revnb) {
		this.revnb = revnb;
	}
	public List<POBLKTVO> getPoblktList() {
		return poblktList;
	}
	public void setPoblktList(List<POBLKTVO> poblktList) {
		this.poblktList = poblktList;
	}
	public String getDokdts() {
		return dokdts;
	}
	public void setDokdts(String dokdts) {
		this.dokdts = dokdts;
	}
	public MOPORFVO getMoporf() {
		return moporf;
	}
	public void setMoporf(MOPORFVO moporf) {
		this.moporf = moporf;
	}
	public MOROUTVO getMorout() {
		return morout;
	}
	public void setMorout(MOROUTVO morout) {
		this.morout = morout;
	}
	public MOMASTVO getMomast() {
		return momast;
	}
	public void setMomast(MOMASTVO momast) {
		this.momast = momast;
	}
	public ITMSITVO getItmsit() {
		return itmsit;
	}
	public void setItmsit(ITMSITVO itmsit) {
		this.itmsit = itmsit;
	}
	public List<MODATAVO> getModataList() {
		return modataList;
	}
	public void setModataList(List<MODATAVO> modataList) {
		this.modataList = modataList;
	}

	
	
}