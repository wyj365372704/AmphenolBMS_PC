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
public class SCHRCPVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String sctkji;
	
	private String whidji;
	
	private String ordrji;
	
	private BigDecimal pisqji;
	
	private BigDecimal bksqji;
	
	private String itnoji;
	
	private BigDecimal ucoqji;
	
	private BigDecimal qtyoji;
	
	private String stkqji;
	
	private String orumji;
	
	private String umstji;

	private BigDecimal umcvji;
	
	private String ds40ji;
	
	private BigDecimal dkdtji;
	
	private String vndrji;
	
	private String rcpsji;
	
	private String buyrji;
	
	private BigDecimal planji;

	public String getSctkji() {
		return sctkji;
	}

	public void setSctkji(String sctkji) {
		this.sctkji = sctkji;
	}

	public String getWhidji() {
		return whidji;
	}

	public void setWhidji(String whidji) {
		this.whidji = whidji;
	}

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

	public String getItnoji() {
		return itnoji;
	}

	public void setItnoji(String itnoji) {
		this.itnoji = itnoji;
	}

	public BigDecimal getUcoqji() {
		return ucoqji;
	}

	public void setUcoqji(BigDecimal ucoqji) {
		this.ucoqji = ucoqji;
	}

	public BigDecimal getQtyoji() {
		return qtyoji;
	}

	public void setQtyoji(BigDecimal qtyoji) {
		this.qtyoji = qtyoji;
	}

	public String getStkqji() {
		return stkqji;
	}

	public void setStkqji(String stkqji) {
		this.stkqji = stkqji;
	}

	public String getOrumji() {
		return orumji;
	}

	public void setOrumji(String orumji) {
		this.orumji = orumji;
	}

	public String getUmstji() {
		return umstji;
	}

	public void setUmstji(String umstji) {
		this.umstji = umstji;
	}

	public BigDecimal getUmcvji() {
		return umcvji;
	}

	public void setUmcvji(BigDecimal umcvji) {
		this.umcvji = umcvji;
	}

	public String getDs40ji() {
		return ds40ji;
	}

	public void setDs40ji(String ds40ji) {
		this.ds40ji = ds40ji;
	}

	public BigDecimal getDkdtji() {
		return dkdtji;
	}

	public void setDkdtji(BigDecimal dkdtji) {
		this.dkdtji = dkdtji;
	}

	public String getVndrji() {
		return vndrji;
	}

	public void setVndrji(String vndrji) {
		this.vndrji = vndrji;
	}

	public String getRcpsji() {
		return rcpsji;
	}

	public void setRcpsji(String rcpsji) {
		this.rcpsji = rcpsji;
	}

	public String getBuyrji() {
		return buyrji;
	}

	public void setBuyrji(String buyrji) {
		this.buyrji = buyrji;
	}

	public BigDecimal getPlanji() {
		return planji;
	}

	public void setPlanji(BigDecimal planji) {
		this.planji = planji;
	}


}