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
public class ZDELIDAVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String ordrji;
	
	private BigDecimal pisqji;
	
	private BigDecimal bksqji;
	
	private BigDecimal ordseq;
	
	private BigDecimal wkdtji;
	
	private BigDecimal staus;

	private String vndrji;
	
	private String whidji;

	public String getOrdrji() {
		return ordrji;
	}

	public void setOrdrji(String ordrji) {
		this.ordrji = ordrji;
	}

	public BigDecimal getPisqji() {
		return pisqji;
	}

	public void setPisqji(BigDecimal pisqji) {
		this.pisqji = pisqji;
	}

	public BigDecimal getBksqji() {
		return bksqji;
	}

	public void setBksqji(BigDecimal bksqji) {
		this.bksqji = bksqji;
	}

	public BigDecimal getOrdseq() {
		return ordseq;
	}

	public void setOrdseq(BigDecimal ordseq) {
		this.ordseq = ordseq;
	}

	public BigDecimal getWkdtji() {
		return wkdtji;
	}

	public void setWkdtji(BigDecimal wkdtji) {
		this.wkdtji = wkdtji;
	}

	public BigDecimal getStaus() {
		return staus;
	}

	public void setStaus(BigDecimal staus) {
		this.staus = staus;
	}

	public String getVndrji() {
		return vndrji;
	}

	public void setVndrji(String vndrji) {
		this.vndrji = vndrji;
	}

	public String getWhidji() {
		return whidji;
	}

	public void setWhidji(String whidji) {
		this.whidji = whidji;
	}
	
	

}