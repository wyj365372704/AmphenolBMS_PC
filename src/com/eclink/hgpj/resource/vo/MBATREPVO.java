package com.eclink.hgpj.resource.vo;

import java.math.BigDecimal;
import java.util.List;

import com.eclink.hgpj.base.BaseVO;

/**
 * @Title: 资源值对象类  
 * @Description: 

 * @version 1.0
 * 
 */
public class MBATREPVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String atf1cd;
	
	private String atghtx;

	public String getAtf1cd() {
		return atf1cd;
	}

	public void setAtf1cd(String atf1cd) {
		this.atf1cd = atf1cd;
	}

	public String getAtghtx() {
		return atghtx;
	}

	public void setAtghtx(String atghtx) {
		this.atghtx = atghtx;
	}

	
}