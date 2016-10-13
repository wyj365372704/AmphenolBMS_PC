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
public class ZDEPTVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private BigDecimal plant;
	
	private String dept;
	
	private String dname;

	private String dtype;
	
	private String moiss;
	
	private String house;
	
	private String dploc;
	
	private String pphse;

	public BigDecimal getPlant() {
		return plant;
	}

	public void setPlant(BigDecimal plant) {
		this.plant = plant;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getMoiss() {
		return moiss;
	}

	public void setMoiss(String moiss) {
		this.moiss = moiss;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getDploc() {
		return dploc;
	}

	public void setDploc(String dploc) {
		this.dploc = dploc;
	}

	public String getPphse() {
		return pphse;
	}

	public void setPphse(String pphse) {
		this.pphse = pphse;
	}
	

}