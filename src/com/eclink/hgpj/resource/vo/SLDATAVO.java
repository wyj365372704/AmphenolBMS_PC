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
public class SLDATAVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	
	private String house;
	
	private String uucalm;

	private String llocn;
	
	private String lcod1;

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getUucalm() {
		return uucalm;
	}

	public void setUucalm(String uucalm) {
		this.uucalm = uucalm;
	}

	public String getLlocn() {
		return llocn;
	}

	public void setLlocn(String llocn) {
		this.llocn = llocn;
	}

	public String getLcod1() {
		return lcod1;
	}

	public void setLcod1(String lcod1) {
		this.lcod1 = lcod1;
	}
	

}