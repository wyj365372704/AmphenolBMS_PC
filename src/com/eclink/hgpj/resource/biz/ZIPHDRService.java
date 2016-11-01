package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ZBMSRSNVO;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZIPDTLVO;
import com.eclink.hgpj.resource.vo.ZIPHDRVO;
import com.eclink.hgpj.resource.vo.ZIPHSTVO;

/**
 * MenuService.java
 *
 * @Title: 生产单业务接口
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:12:44 PM
 *
 */
public interface ZIPHDRService {
	
	public int getCoutsByDt(BigDecimal gtdte) throws Exception;	

	public int getDtlCoutsBypar(Map map) throws Exception;
	
	public double getAllshqty(ZIPDTLVO vo) throws Exception;
	
	public List<ZIPDTLVO> queryItemsBytype(ZIPDTLVO vo) throws Exception;
	
	public List<ZIPDTLVO> queryItems(ZIPDTLVO vo) throws Exception;

	public List<ZIPDTLVO> queryItemsWsubOrder(ZIPDTLVO vo) throws Exception;
	
	public List<ZBMSRSNVO> getReason(Map rpmap) throws Exception;	
	
	public List<ZIPHDRVO> queryHdrs(ZIPHDRVO vo) throws Exception;
	
	public List<ZIPHDRVO> queryHdrsByPar(Map vo) throws Exception;
	
	public List<ZIPHDRVO> queryHdrsByParForApproval(Map vo) throws Exception ;

	public List<ZIPHSTVO> queryHstItems(ZIPHSTVO vo) throws Exception;
	
	public void insertZiphdr(ZIPHDRVO vo) throws Exception;
	
	public void insertZiphdrM(List<ZIPHDRVO> vos) throws Exception;
	
	public void insertZiphdrO(ZIPHDRVO vo) throws Exception;
	
	public void insertZipdtl(ZIPDTLVO vo) throws Exception;
	
	public void insertZiphst(ZIPHSTVO vo) throws Exception;
	
	public void updateZiphdr(Map map) throws Exception;
	public void updateZiphdrS(Map map) throws Exception;
	public void updateZiphdrStat(ZIPHDRVO vo) throws Exception;
	public void updateZiphdrForApproval(ZIPHDRVO vo) throws Exception;
	public void updateZiphdrLprt(ZIPHDRVO vo) throws Exception;
	public void updateZipdtlStat(ZIPDTLVO vo) throws Exception;

	
	public void updateZipitmQty(ZIPDTLVO vo) throws Exception;
	
	public void deleteZipdtl(ZIPDTLVO vo) throws Exception;
}
