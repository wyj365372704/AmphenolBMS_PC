package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ZTWBCHVO;
import com.eclink.hgpj.resource.vo.ZTWDTLVO;
import com.eclink.hgpj.resource.vo.ZTWHDRVO;


/**
 * MenuService.java
 *
 * @Title: 菜单业务接口
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:12:44 PM
 *
 */
public interface ZTWHDRService {
	
	//调拨单列表
	public List<ZTWHDRVO> queryZtwhdrList(Map map) throws Exception;
	
	public int getCoutsByDt(BigDecimal twdt1) throws Exception;
	
	public void insertZtwhdr(ZTWHDRVO vo) throws Exception;
	
	public ZTWHDRVO queryZtwhdr(ZTWHDRVO vo) throws Exception;
	
	public List<ZTWDTLVO> queryZtwdtl(ZTWDTLVO vo) throws Exception;
	
	public List<ZTWBCHVO> queryZtwbch(ZTWBCHVO vo) throws Exception;
	
	public void updateZtwhdr(Map map) throws Exception;
	
	public void updateItemBch(ZTWBCHVO vo) throws Exception;
	
	public void updateItemStat(ZTWDTLVO vo) throws Exception;
	
	public void updateHdrStat(ZTWHDRVO vo) throws Exception;
	
	public void updateItemDtl(ZTWDTLVO vo) throws Exception;
}
