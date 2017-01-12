package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;

/**
 * MenuService.java
 *
 * @Title: 菜单业务接口
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:12:44 PM
 *
 */
public interface ZGRNHDRService {
	//收货单列表
	public List<ZGRNHDRVO> queryReceiptList(ZGRNHDRVO vo) throws Exception;
	
	//收货单信息
	public List<ZGRNITMVO> queryReceiptItems(ZGRNITMVO vo) throws Exception;
	
	public List<ZGRNHDRVO> queryReceiptSelf(Map map) throws Exception;
	public List<ZGRNBCHVO> queryZgrnBch(String grnno) throws Exception;
	public int getCoutsByDt(BigDecimal gtdte) throws Exception;
	public ZGRNHDRVO queryZgrnByNo(String grnno) throws Exception;
	public int getCoutsByState(String state) throws Exception;
	public void updateItemStat(ZGRNITMVO vo) throws Exception;
	public List<ZGRNITMVO> queryZgrnitm(Map map) throws Exception;
	public void updateHdrStat(ZGRNHDRVO vo) throws Exception;
	
	public void insertZgrnhdr(ZGRNHDRVO vo) throws Exception;
	
	public List<ZGRNBCHVO> queryZgrnBchByln(ZGRNITMVO vo) throws Exception;
	
	public List<ZGRNITMVO> queryReceiptItem(ZGRNITMVO vo) throws Exception;
	//确认物料收货操作
	public void updateItem(ZGRNITMVO vo) throws Exception;
}
