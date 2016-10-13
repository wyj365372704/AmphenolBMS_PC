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
public class ZMBD1REPVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	
	private String dbcqcd;
	
	private BigDecimal dbdcml;
	
	private String dbrnd;

	public String getDbcqcd() {
		return dbcqcd;
	}

	public void setDbcqcd(String dbcqcd) {
		this.dbcqcd = dbcqcd;
	}

	public BigDecimal getDbdcml() {
		return dbdcml;
	}

	public void setDbdcml(BigDecimal dbdcml) {
		this.dbdcml = dbdcml;
	}

	public String getDbrnd() {
		return dbrnd;
	}

	public void setDbrnd(String dbrnd) {
		this.dbrnd = dbrnd;
	}


}