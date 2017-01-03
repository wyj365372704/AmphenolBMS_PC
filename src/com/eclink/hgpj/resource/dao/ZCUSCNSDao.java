package com.eclink.hgpj.resource.dao;

import java.util.List;

import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZCUSCNSVO;

/**
 * MenuDao.java
 *
 * @Title: 菜单资源数据库访问接口
 * @Description: 
 
 * @version 1.0
 *
 */
public interface ZCUSCNSDao {
	
	public List<ZCUSCNSVO> queryZcuscns(ZCUSCNSVO vo) throws Exception;
}
