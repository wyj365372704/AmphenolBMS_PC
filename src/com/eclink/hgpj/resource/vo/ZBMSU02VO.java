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
public class ZBMSU02VO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	
	private String bmsusr;
	
	private BigDecimal plant;

	private String dept;
	
	private String dflt;

	public String getBmsusr() {
		return bmsusr;
	}

	public void setBmsusr(String bmsusr) {
		this.bmsusr = bmsusr;
	}

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

	public String getDflt() {
		return dflt;
	}

	public void setDflt(String dflt) {
		this.dflt = dflt;
	}


}