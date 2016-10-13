package com.eclink.hgpj.resource.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZTWBCHVO;
import com.eclink.hgpj.resource.vo.ZTWDTLVO;
import com.eclink.hgpj.resource.vo.ZTWHDRVO;

/**
 * MenuDao.java
 *
 * @Title: 菜单资源数据库访问接口
 * @Description: 
 
 * @version 1.0
 *
 */
public interface ZTWHDRDao {

	//调拨单列表
	public List<ZTWHDRVO> queryReceiptList(Map map) throws Exception;
	
	public int getCoutsByDt(BigDecimal twdt1) throws Exception;
	
	public void insertZtwbch(ZTWBCHVO vo) throws Exception;
	
	public void insertZtwdtl(ZTWDTLVO vo) throws Exception;
	
	public void insertZtwhdr(ZTWHDRVO vo) throws Exception;
	
	public List<ZTWHDRVO> queryZtwhdr(ZTWHDRVO vo) throws Exception;
	
	public List<ZTWDTLVO> queryZtwdtl(ZTWDTLVO vo) throws Exception;
	
	public List<ZTWBCHVO> queryZtwbch(ZTWBCHVO vo) throws Exception;
	
	public void updateItemBch(ZTWBCHVO vo) throws Exception;
	
	public void updateItemStat(ZTWDTLVO vo) throws Exception;
	
	public void updateHdrStat(ZTWHDRVO vo) throws Exception;
	
	public void updateItemDtl(ZTWDTLVO vo) throws Exception;
	
}
