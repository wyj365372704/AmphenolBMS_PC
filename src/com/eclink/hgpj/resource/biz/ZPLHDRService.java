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

	public double queryDtlQty(ZPLDTLVO vo) throws Exception;

	public List<ZPLHDRVO> queryZplhdr(ZPLHDRVO vo) throws Exception;

	public List<ZPLDTLVO> queryReceipt(ZPLDTLVO vo) throws Exception;

	public List<ZPLBOXVO> queryBch(ZPLBOXVO vo) throws Exception;

	public void insertZplhdr(ZPLHDRVO vo) throws Exception;

	public void insertZpldtl(ZPLDTLVO vo) throws Exception;

	public void insertZplbox(ZPLBOXVO vo) throws Exception;

	public void updateZplhdr(String pldno) throws Exception;	
	
	public void updateZplitm(ZPLDTLVO VO) throws Exception;	
}
