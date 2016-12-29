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
public class ZPLBOXVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String pldno;
	
	private BigDecimal pldln;
	
	private BigDecimal boxln;
	
	private String boxnm;
	
	private BigDecimal boxes;

	public String getPldno() {
		return pldno;
	}

	public void setPldno(String pldno) {
		this.pldno = pldno;
	}

	public BigDecimal getPldln() {
		return pldln;
	}

	public void setPldln(BigDecimal pldln) {
		this.pldln = pldln;
	}

	public BigDecimal getBoxln() {
		return boxln;
	}

	public void setBoxln(BigDecimal boxln) {
		this.boxln = boxln;
	}

	public String getBoxnm() {
		return boxnm;
	}

	public void setBoxnm(String boxnm) {
		this.boxnm = boxnm;
	}

	public BigDecimal getBoxes() {
		return boxes;
	}

	public void setBoxes(BigDecimal boxes) {
		this.boxes = boxes;
	}
	
	
}