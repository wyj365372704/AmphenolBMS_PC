package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.SHPDSKVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZPLBOXVO;
import com.eclink.hgpj.resource.vo.ZPLDTLVO;
import com.eclink.hgpj.resource.vo.ZPLHDRVO;
import com.eclink.hgpj.resource.vo.ZSABCHVO;
import com.eclink.hgpj.resource.vo.ZSABOXVO;
import com.eclink.hgpj.resource.vo.ZSADTLVO;
import com.eclink.hgpj.resource.vo.ZSAHDRVO;
import com.eclink.hgpj.resource.vo.ZSHPBCHVO;
import com.eclink.hgpj.resource.vo.ZSHPHDRVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;

/**
 * MenuService.java
 *
 * @Title: 菜单业务接口
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:12:44 PM
 *
 */
public interface ZPLHDRService {
	public int getCoutsByDt(BigDecimal gtdte) throws Exception;
	
	public int getZsaCoutsByDt(BigDecimal gtdte) throws Exception;
	
	public double queryDtlQty(ZPLDTLVO vo) throws Exception;

	public List<ZPLHDRVO> queryZplhdr(ZPLHDRVO vo) throws Exception;

	public int getZsadtlCouts(ZSADTLVO vo) throws Exception;

	public List<ZSAHDRVO> queryZsahdrByPar(ZSAHDRVO vo) throws Exception;
	
	public List<ZPLHDRVO> queryZplhdrByPar(Map vo) throws Exception;

	public List<ZPLDTLVO> queryReceipt(ZPLDTLVO vo) throws Exception;

	public List<ZPLBOXVO> queryBch(ZPLBOXVO vo) throws Exception;
	
public List<ZSADTLVO> queryZsadtls(ZSADTLVO vo) throws Exception;
	
	public List<ZSABCHVO> queryZsabchs(ZSABCHVO vo)  throws Exception;
	
	public List<String> queryC6cvnb(ZPLDTLVO vo)   throws Exception;

	public void insertZplhdr(ZPLHDRVO vo) throws Exception;

	public void insertZplhdrA(ZPLHDRVO vo,List<ZPLDTLVO> vos, List<ZPLBOXVO> bvos) throws Exception;

	public void insertZpldtl(ZPLDTLVO vo) throws Exception;

	public void insertZplbox(ZPLBOXVO vo) throws Exception;

	public void updateZplhdr(String pldno) throws Exception;	
	
	public void updateZplitm(ZPLDTLVO VO) throws Exception;	
	
	public void updateZplhdrByPar(ZPLHDRVO vo) throws Exception;

	public void updateZpldtlByPar(ZPLDTLVO vo) throws Exception;

	public void updateZplboxByPar(ZPLBOXVO vo) throws Exception;

	public void deleteZplhdr(String pldno) throws Exception;
	
	public void insertZsahdr(ZSAHDRVO vo) throws Exception;

	public void insertZsadtl(ZSADTLVO vo) throws Exception;

	public void insertZsabch(ZSABCHVO vo) throws Exception;

	public void insertZsabox(ZSABOXVO vo) throws Exception;

	public void insertZsahdrs(Map map) throws Exception;
}
