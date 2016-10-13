package com.eclink.hgpj.resource.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.VENNAMVO;
import com.eclink.hgpj.resource.vo.ZBMSRSNVO;
import com.eclink.hgpj.resource.vo.ZIPDTLVO;
import com.eclink.hgpj.resource.vo.ZIPHDRVO;
import com.eclink.hgpj.resource.vo.ZIPHSTVO;

/**
 * MenuDao.java
 *
 * @Title: 菜单资源数据库访问接口
 * @Description: 
 
 * @version 1.0
 *
 */
public interface VENNAMDao {

	List<VENNAMVO> queryVennam(Map map) throws Exception;

	
}
