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
public class ZWHSUBVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String house;
	
	private String whsub;
	
	private String dsp1;
	
	private String dsp2;
	
	private String grloc;	
	
	private String nrloc;
	
	
	private String subtype;
	
	private String flabel;

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getWhsub() {
		return whsub;
	}

	public void setWhsub(String whsub) {
		this.whsub = whsub;
	}

	public String getDsp1() {
		return dsp1;
	}

	public void setDsp1(String dsp1) {
		this.dsp1 = dsp1;
	}

	public String getDsp2() {
		return dsp2;
	}

	public void setDsp2(String dsp2) {
		this.dsp2 = dsp2;
	}

	public String getGrloc() {
		return grloc;
	}

	public void setGrloc(String grloc) {
		this.grloc = grloc;
	}

	public String getNrloc() {
		return nrloc;
	}

	public void setNrloc(String nrloc) {
		this.nrloc = nrloc;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getFlabel() {
		return flabel;
	}

	public void setFlabel(String flabel) {
		this.flabel = flabel;
	}


}