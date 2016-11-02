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
public class SHPDSKVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String rcdcd;
	
	private String ordno;
	
	private String opseq;
	
	private String runcd;
	
	private BigDecimal lbtim;
	
	private BigDecimal matim;
	
	private BigDecimal qcomp;
	
	private BigDecimal qscrp;
	
	private BigDecimal resn;
	
	private String rfno;

	private String ocmpc;
	
	private String awkct;
	
	private BigDecimal empno;
	
	private BigDecimal erate;
	
	private String shift;
	
	private BigDecimal tcost;
	
	private BigDecimal tdate;

	public String getRcdcd() {
		return rcdcd;
	}

	public void setRcdcd(String rcdcd) {
		this.rcdcd = rcdcd;
	}

	public String getOrdno() {
		return ordno;
	}

	public void setOrdno(String ordno) {
		this.ordno = ordno;
	}

	public String getOpseq() {
		return opseq;
	}

	public void setOpseq(String opseq) {
		this.opseq = opseq;
	}

	public String getRuncd() {
		return runcd;
	}

	public void setRuncd(String runcd) {
		this.runcd = runcd;
	}

	public BigDecimal getLbtim() {
		return lbtim;
	}

	public void setLbtim(BigDecimal lbtim) {
		this.lbtim = lbtim;
	}

	public BigDecimal getMatim() {
		return matim;
	}

	public void setMatim(BigDecimal matim) {
		this.matim = matim;
	}

	public BigDecimal getQcomp() {
		return qcomp;
	}

	public void setQcomp(BigDecimal qcomp) {
		this.qcomp = qcomp;
	}

	public BigDecimal getQscrp() {
		return qscrp;
	}

	public void setQscrp(BigDecimal qscrp) {
		this.qscrp = qscrp;
	}

	public BigDecimal getResn() {
		return resn;
	}

	public void setResn(BigDecimal resn) {
		this.resn = resn;
	}

	public String getRfno() {
		return rfno;
	}

	public void setRfno(String rfno) {
		this.rfno = rfno;
	}

	public String getOcmpc() {
		return ocmpc;
	}

	public void setOcmpc(String ocmpc) {
		this.ocmpc = ocmpc;
	}

	public String getAwkct() {
		return awkct;
	}

	public void setAwkct(String awkct) {
		this.awkct = awkct;
	}

	public BigDecimal getEmpno() {
		return empno;
	}

	public void setEmpno(BigDecimal empno) {
		this.empno = empno;
	}

	public BigDecimal getErate() {
		return erate;
	}

	public void setErate(BigDecimal erate) {
		this.erate = erate;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public BigDecimal getTcost() {
		return tcost;
	}

	public void setTcost(BigDecimal tcost) {
		this.tcost = tcost;
	}

	public BigDecimal getTdate() {
		return tdate;
	}

	public void setTdate(BigDecimal tdate) {
		this.tdate = tdate;
	}
	
	

}