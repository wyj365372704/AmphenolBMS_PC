package com.eclink.hgpj.resource.dao;

import java.math.BigDecimal;

import com.eclink.hgpj.resource.vo.ZRMHSTVO;

/**
 * MenuDao.java
 *
 * @Title: 菜单资源数据库访问接口
 * @Description: 
 
 * @version 1.0
 *
 */
public interface ZRMHSTDao {
	
	public void insertZrmhst(ZRMHSTVO vo) throws Exception;
	
	public int getCoutsByDt(BigDecimal rmdat) throws Exception;
	
	public void deleteZrmhst(String rmdno) throws Exception;
}
