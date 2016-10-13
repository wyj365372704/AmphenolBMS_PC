package com.eclink.hgpj.resource.dao;

import java.math.BigDecimal;
import java.util.List;

import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZSLLOGVO;

/**
 * MenuDao.java
 *
 * @Title: 菜单资源数据库访问接口
 * @Description: 
 
 * @version 1.0
 *
 */
public interface ZSLLOGDao {
	
	public void insertZsllog(ZSLLOGVO vo) throws Exception;
	
	public int getCoutsByDt(BigDecimal crdat) throws Exception;
}
