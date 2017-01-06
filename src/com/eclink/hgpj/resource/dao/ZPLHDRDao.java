package com.eclink.hgpj.resource.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ZBMSRSNVO;
import com.eclink.hgpj.resource.vo.ZIPDTLVO;
import com.eclink.hgpj.resource.vo.ZIPHDRVO;
import com.eclink.hgpj.resource.vo.ZIPHSTVO;
import com.eclink.hgpj.resource.vo.ZPLBOXVO;
import com.eclink.hgpj.resource.vo.ZPLDTLVO;
import com.eclink.hgpj.resource.vo.ZPLHDRVO;

/**
 * MenuDao.java
 *
 * @Title: 菜单资源数据库访问接口
 * @Description: 

 * @version 1.0
 *
 */
public interface ZPLHDRDao {


	public int getCoutsByDt(BigDecimal gtdte) throws Exception;

	public double queryDtlQty(ZPLDTLVO vo) throws Exception;

	public List<ZPLHDRVO> queryZplhdr(ZPLHDRVO vo) throws Exception;
	
	public List<ZPLHDRVO> queryZplhdrByPar(Map vo) throws Exception;

	public List<ZPLDTLVO> queryReceipt(ZPLDTLVO vo) throws Exception;

	public List<ZPLBOXVO> queryBch(ZPLBOXVO vo) throws Exception;

	public void insertZplhdr(ZPLHDRVO vo) throws Exception;

	public void insertZpldtl(ZPLDTLVO vo) throws Exception;

	public void insertZplbox(ZPLBOXVO vo) throws Exception;

	public void updateZplhdr(String pldno) throws Exception;	
	
	public void updateZplitm(ZPLDTLVO VO) throws Exception;	

	public void updateZplhdrByPar(ZPLHDRVO vo) throws Exception;

	public void updateZpldtlByPar(ZPLDTLVO vo) throws Exception;

	public void updateZplboxByPar(ZPLBOXVO vo) throws Exception;

	public void deleteZplhdr(String pldno) throws Exception;
	
	
}
