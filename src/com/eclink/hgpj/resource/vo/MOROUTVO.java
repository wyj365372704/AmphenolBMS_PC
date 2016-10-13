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
public class MOROUTVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	
	private String ordno;
	
	private String opseq;

	private String opdsc;

	private String tbcde;

	private String rlhtd;
	
	private BigDecimal srlhu;
	
	public String getOrdno() {
		return ordno;
	}

	public void setOrdno(String ordno) {
		this.ordno = ordno;
	}

	public String getOpseq() {
		return opseq;
	}

	public void setOpseq(String opseq) {
		this.opseq = opseq;
	}

	public String getOpdsc() {
		return opdsc;
	}

	public void setOpdsc(String opdsc) {
		this.opdsc = opdsc;
	}

	public String getTbcde() {
		return tbcde;
	}

	public void setTbcde(String tbcde) {
		this.tbcde = tbcde;
	}

	public BigDecimal getSrlhu() {
		return srlhu;
	}

	public void setSrlhu(BigDecimal srlhu) {
		this.srlhu = srlhu;
	}

	public String getRlhtd() {
		return rlhtd;
	}

	public void setRlhtd(String rlhtd) {
		this.rlhtd = rlhtd;
	}
	
}