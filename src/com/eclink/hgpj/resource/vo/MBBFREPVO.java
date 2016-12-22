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
public class MBBFREPVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	private String cusno;
	
	private String cusnm;

	public String getCusno() {
		return cusno;
	}

	public void setCusno(String cusno) {
		this.cusno = cusno;
	}

	public String getCusnm() {
		return cusnm;
	}

	public void setCusnm(String cusnm) {
		this.cusnm = cusnm;
	}
	
}