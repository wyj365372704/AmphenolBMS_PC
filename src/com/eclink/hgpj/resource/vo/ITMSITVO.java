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
public class ITMSITVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String itnot9;
	
	private String house;
	
	private String itrvt9;
	
	private String umstt9;
	
	private String blcft9;

	public String getItnot9() {
		return itnot9;
	}

	public void setItnot9(String itnot9) {
		this.itnot9 = itnot9;
	}



	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getItrvt9() {
		return itrvt9;
	}

	public void setItrvt9(String itrvt9) {
		this.itrvt9 = itrvt9;
	}



	public String getUmstt9() {
		return umstt9;
	}

	public void setUmstt9(String umstt9) {
		this.umstt9 = umstt9;
	}

	public String getBlcft9() {
		return blcft9;
	}

	public void setBlcft9(String blcft9) {
		this.blcft9 = blcft9;
	}
	

}