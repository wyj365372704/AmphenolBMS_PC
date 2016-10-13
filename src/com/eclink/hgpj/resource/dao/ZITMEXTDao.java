package com.eclink.hgpj.resource.dao;

import java.util.List;

import com.eclink.hgpj.resource.vo.ZITMEXTVO;

/**
 * MenuDao.java
 *
 * @Title: 菜单资源数据库访问接口
 * @Description: 
 
 * @version 1.0
 *
 */
public interface ZITMEXTDao {
	
	public List<ZITMEXTVO> queryItemExt(ZITMEXTVO vo) throws Exception;
	
	
}
