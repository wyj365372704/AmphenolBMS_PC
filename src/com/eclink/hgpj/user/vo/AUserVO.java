package com.eclink.hgpj.user.vo;

import java.util.Date;
import java.util.List;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.dictionary.DictCache;

/**
 * UserVO.java
 *
 * @Title: 用户值对象类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @version 1.0
 * @date May 16, 2013 10:55:49 AM
 *
 */
public class AUserVO extends BaseVO {
	
	private static final long serialVersionUID = 1L;


	private String bmsUser;
	

	private String userName;
	

	private String passwd;
	

	private Integer plant;
	

	private String xaUser;
	

	private Integer xsBda;


	private String valid;


	public String getBmsUser() {
		return bmsUser;
	}


	public void setBmsUser(String bmsUser) {
		this.bmsUser = bmsUser;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public Integer getPlant() {
		return plant;
	}


	public void setPlant(Integer plant) {
		this.plant = plant;
	}


	public String getXaUser() {
		return xaUser;
	}


	public void setXaUser(String xaUser) {
		this.xaUser = xaUser;
	}


	public Integer getXsBda() {
		return xsBda;
	}


	public void setXsBda(Integer xsBda) {
		this.xsBda = xsBda;
	}


	public String getValid() {
		return valid;
	}


	public void setValid(String valid) {
		this.valid = valid;
	}
	
	
}
