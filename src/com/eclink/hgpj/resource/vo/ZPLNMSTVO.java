package com.eclink.hgpj.resource.vo;

import java.math.BigDecimal;
import java.util.List;

import com.eclink.hgpj.base.BaseVO;

/**
 * @Title: 资源值对象类  
 * @Description: 

 * @version 1.0
 */
public class ZPLNMSTVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	private String plant;
	private String pline;
	private String plnnm;
	private String dept;
	private String status;

	
	
	public String getPlant() {
		return plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public String getPline() {
		return pline;
	}
	public void setPline(String pline) {
		this.pline = pline;
	}
	public String getPlnnm() {
		return plnnm;
	}
	public void setPlnnm(String plnnm) {
		this.plnnm = plnnm;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}