package com.eclink.hgpj.resource.vo;

import java.math.BigDecimal;
import java.util.List;

import com.eclink.hgpj.base.BaseVO;

/**
 * @Title: 资源值对象类  
 * @Description: 

 * @version 1.0
 * 
 */
public class MOMASTVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String ordno;
	
	private String ordnc;
	
	private String cono;
	
	private String ortp;

	private String itmsq;

	private String rlnb;

	private String ktrl;
	
	private String ordnoF;
	
	private String ordnoup;
	
	private String ordnodown;
	
	private BigDecimal orqty;
	
	private BigDecimal qtdev;
	
	private String ostat;
	
	private String jobno;
	
	private String refno;
	
	private BigDecimal sstdt;
	
	private BigDecimal ssttm;
	
	private BigDecimal qtyrc;
	
	private BigDecimal astdt;
	
	private BigDecimal odudt;
	
	private BigDecimal odutm;
	
	private String fdesc;
	
	private String fitem;
		
	private String fitwh;
	
	private BigDecimal plann;
	
	private String dptno;
	
	private String unmsr;
	
	private String uusamy;

	private String startDate;
	
	private String endDate;
	
	private BigDecimal startDateB;
	
	private BigDecimal endDateB;
	
	private BigDecimal moqty;
	
	private BigDecimal mounqty;
	
	private String sodudt;
	
	private String ssstdt;
	
	public String getOrdno() {
		return ordno;
	}

	public void setOrdno(String ordno) {
		this.ordno = ordno;
	}

	public BigDecimal getOrqty() {
		return orqty;
	}

	public void setOrqty(BigDecimal orqty) {
		this.orqty = orqty;
	}

	public BigDecimal getQtdev() {
		return qtdev;
	}

	public void setQtdev(BigDecimal qtdev) {
		this.qtdev = qtdev;
	}

	public String getOstat() {
		return ostat;
	}

	public void setOstat(String ostat) {
		this.ostat = ostat;
	}

	public String getJobno() {
		return jobno;
	}

	public void setJobno(String jobno) {
		this.jobno = jobno;
	}

	public String getRefno() {
		return refno;
	}

	public String getOrdnc() {
		return ordnc;
	}

	public void setOrdnc(String ordnc) {
		this.ordnc = ordnc;
	}

	public String getCono() {
		return cono;
	}

	public void setCono(String cono) {
		this.cono = cono;
	}

	public String getOrtp() {
		return ortp;
	}

	public void setOrtp(String ortp) {
		this.ortp = ortp;
	}

	public String getItmsq() {
		return itmsq;
	}

	public void setItmsq(String itmsq) {
		this.itmsq = itmsq;
	}

	public String getRlnb() {
		return rlnb;
	}

	public void setRlnb(String rlnb) {
		this.rlnb = rlnb;
	}

	public String getKtrl() {
		return ktrl;
	}

	public void setKtrl(String ktrl) {
		this.ktrl = ktrl;
	}

	public void setRefno(String refno) {
		this.refno = refno;
	}

	public BigDecimal getSstdt() {
		return sstdt;
	}

	public void setSstdt(BigDecimal sstdt) {
		this.sstdt = sstdt;
	}

	public BigDecimal getQtyrc() {
		return qtyrc;
	}

	public void setQtyrc(BigDecimal qtyrc) {
		this.qtyrc = qtyrc;
	}

	public BigDecimal getAstdt() {
		return astdt;
	}

	public void setAstdt(BigDecimal astdt) {
		this.astdt = astdt;
	}

	public BigDecimal getOdudt() {
		return odudt;
	}

	public void setOdudt(BigDecimal odudt) {
		this.odudt = odudt;
	}

	public BigDecimal getSsttm() {
		return ssttm;
	}

	public void setSsttm(BigDecimal ssttm) {
		this.ssttm = ssttm;
	}

	public BigDecimal getOdutm() {
		return odutm;
	}

	public void setOdutm(BigDecimal odutm) {
		this.odutm = odutm;
	}

	public String getFdesc() {
		return fdesc;
	}

	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}

	public String getFitem() {
		return fitem;
	}

	public void setFitem(String fitem) {
		this.fitem = fitem;
	}

	public String getFitwh() {
		return fitwh;
	}

	public void setFitwh(String fitwh) {
		this.fitwh = fitwh;
	}

	public BigDecimal getPlann() {
		return plann;
	}

	public void setPlann(BigDecimal plann) {
		this.plann = plann;
	}

	public String getDptno() {
		return dptno;
	}

	public void setDptno(String dptno) {
		this.dptno = dptno;
	}

	public String getUnmsr() {
		return unmsr;
	}

	public void setUnmsr(String unmsr) {
		this.unmsr = unmsr;
	}

	public String getUusamy() {
		return uusamy;
	}

	public void setUusamy(String uusamy) {
		this.uusamy = uusamy;
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

	public BigDecimal getMoqty() {
		return moqty;
	}

	public void setMoqty(BigDecimal moqty) {
		this.moqty = moqty;
	}

	public BigDecimal getMounqty() {
		return mounqty;
	}

	public void setMounqty(BigDecimal mounqty) {
		this.mounqty = mounqty;
	}

	public String getOrdnoup() {
		return ordnoup;
	}

	public void setOrdnoup(String ordnoup) {
		this.ordnoup = ordnoup;
	}

	public String getOrdnodown() {
		return ordnodown;
	}

	public void setOrdnodown(String ordnodown) {
		this.ordnodown = ordnodown;
	}

	public String getOrdnoF() {
		return ordnoF;
	}

	public void setOrdnoF(String ordnoF) {
		this.ordnoF = ordnoF;
	}

	public BigDecimal getStartDateB() {
		return startDateB;
	}

	public void setStartDateB(BigDecimal startDateB) {
		this.startDateB = startDateB;
	}

	public BigDecimal getEndDateB() {
		return endDateB;
	}

	public void setEndDateB(BigDecimal endDateB) {
		this.endDateB = endDateB;
	}

	public String getSodudt() {
		return sodudt;
	}

	public void setSodudt(String sodudt) {
		this.sodudt = sodudt;
	}

	public String getSsstdt() {
		return ssstdt;
	}

	public void setSsstdt(String ssstdt) {
		this.ssstdt = ssstdt;
	}
	
  
}