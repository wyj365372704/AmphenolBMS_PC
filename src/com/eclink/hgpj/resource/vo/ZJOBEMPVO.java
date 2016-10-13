package com.eclink.hgpj.resource.vo;

import java.math.BigDecimal;
import java.util.List;

import com.eclink.hgpj.base.BaseVO;

/**
 * @Description: 

 * @version 1.0
 * 
 */
public class ZJOBEMPVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String mjdno ;
	private String empid;
	private String empName ;
	private String house;
	private String ordno;
	private String opseq;
	private String pline;
	private String jstat;
	private BigDecimal clhrs;
	public String getMjdno() {
		return mjdno;
	}
	public void setMjdno(String mjdno) {
		this.mjdno = mjdno;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getHouse() {
		return house;
	}
	
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
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
	public BigDecimal getClhrs() {
		return clhrs;
	}
	public void setClhrs(BigDecimal clhrs) {
		this.clhrs = clhrs;
	}
	
	
}