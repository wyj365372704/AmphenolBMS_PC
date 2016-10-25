package com.eclink.hgpj.resource.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
public interface ZIPHDRDao {
	
	
	public int getCoutsByDt(BigDecimal gtdte) throws Exception;
	
	public int getDtlCoutsBypar(Map map) throws Exception;
	
	public double getAllshqty(ZIPDTLVO vo) throws Exception;
	
	public List<ZIPDTLVO> queryItemsBytype(ZIPDTLVO vo) throws Exception;
	
	public List<ZBMSRSNVO> getReason(Map rpmap) throws Exception;	
	
	public List<ZIPDTLVO> queryItems(ZIPDTLVO vo) throws Exception;
	
	public List<ZIPDTLVO> queryItemsWsubOrder(ZIPDTLVO vo) throws Exception;

	public List<ZIPHDRVO> queryHdrs(ZIPHDRVO vo) throws Exception;
	
	public List<ZIPHDRVO> queryHdrsByPar(Map vo) throws Exception;	

	public List<ZIPHSTVO> queryHstItems(ZIPHSTVO vo) throws Exception;
	
	public void insertZiphdr(ZIPHDRVO vo) throws Exception;
	
	public void insertZipdtl(ZIPDTLVO vo) throws Exception;
	
	public void insertZiphst(ZIPHSTVO vo) throws Exception;
	
	public void updateZiphdrStat(ZIPHDRVO VO) throws Exception;	

	public void updateZiphdrLprt(ZIPHDRVO VO) throws Exception;	
	
	public void updateZipitmStat(ZIPDTLVO vo) throws Exception;	
	
	public void updateZipitm(ZIPDTLVO vo) throws Exception;
	
	public void updateZiphstS(ZIPHSTVO vo) throws Exception;
	
	public void updateZiphst(ZIPHSTVO vo) throws Exception;
	
	public void updateZipitmQty(ZIPDTLVO vo) throws Exception;
	
	public void deleteZipdtl(ZIPDTLVO vo) throws Exception;
	
	 
	
}
