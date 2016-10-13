package com.eclink.hgpj.resource.vo;

import java.math.BigDecimal;
import java.util.List;

import com.eclink.hgpj.base.BaseVO;

/**
 * @Description: 

 * @version 1.0
 * 
 */
public class ZJOBMCHVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String mjdno ;
	private String mchid;
	private String mchName;
	private String house;
	private String ordno;
	private String opseq;
	private String pline;
	private String jstat;
	private BigDecimal cmhrs;
	
	public String getMjdno() {
		return mjdno;
	}
	public void setMjdno(String mjdno) {
		this.mjdno = mjdno;
	}

	public String getHouse() {
		return house;
	}
	
	
	public String getMchName() {
		return mchName;
	}
	public void setMchName(String mchName) {
		this.mchName = mchName;
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
	public String getOpseq() {
		return opseq;
	}
	public void setOpseq(String opseq) {
		this.opseq = opseq;
	}
	public String getPline() {
		return pline;
	}
	public void setPline(String pline) {
		this.pline = pline;
	}
	public String getJstat() {
		return jstat;
	}
	public void setJstat(String jstat) {
		this.jstat = jstat;
	}
	public String getMchid() {
		return mchid;
	}
	public void setMchid(String mchid) {
		this.mchid = mchid;
	}
	public BigDecimal getCmhrs() {
		return cmhrs;
	}
	public void setCmhrs(BigDecimal cmhrs) {
		this.cmhrs = cmhrs;
	}
	
	
}