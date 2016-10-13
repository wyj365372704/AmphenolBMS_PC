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
public class ZBMSU01VO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String house;
	
	private String bmsusr;
	
	private String dlft;

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getBmsusr() {
		return bmsusr;
	}

	public void setBmsusr(String bmsusr) {
		this.bmsusr = bmsusr;
	}

	public String getDlft() {
		return dlft;
	}

	public void setDlft(String dlft) {
		this.dlft = dlft;
	}

}