package com.eclink.hgpj.resource.vo;

import java.math.BigDecimal;
import java.util.List;

import com.eclink.hgpj.base.BaseVO;

/**
 * @Description: 

 * @version 1.0
 * 
 * 
 * PLANT
EMPID
EMPNM
DEPT
PLINE
STATUS

 */
public class ZEMPMSTVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String plant ;
	private String empid;
	private String empnm;
	private String dept;
	private String dname;
	private String pline;
	private String status;
	public String getPlant() {
		return plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEmpnm() {
		return empnm;
	}
	public void setEmpnm(String empnm) {
		this.empnm = empnm;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPline() {
		return pline;
	}
	public void setPline(String pline) {
		this.pline = pline;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
		
}