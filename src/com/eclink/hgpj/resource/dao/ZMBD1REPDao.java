package com.eclink.hgpj.resource.dao;

import java.util.List;

import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZMBD1REPVO;

/**
 * MenuDao.java
 *
 * @Title: 菜单资源数据库访问接口
 * @Description: 
 
 * @version 1.0
 *
 */
public interface ZMBD1REPDao {
	
	public List<ZMBD1REPVO> queryZmbd1erp(ZMBD1REPVO vo) throws Exception;
}
