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
public class ZBMSU05VO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
	
	private String usrgrp;
	
	private String grpnm;

	public String getUsrgrp() {
		return usrgrp;
	}

	public void setUsrgrp(String usrgrp) {
		this.usrgrp = usrgrp;
	}

	public String getGrpnm() {
		return grpnm;
	}

	public void setGrpnm(String grpnm) {
		this.grpnm = grpnm;
	}


}