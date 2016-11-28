package com.eclink.hgpj.resource.biz;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.BUYERFVO;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MODATAVO;
import com.eclink.hgpj.resource.vo.MOMASTVO;
import com.eclink.hgpj.resource.vo.MOPORFVO;
import com.eclink.hgpj.resource.vo.MOROUTVO;
import com.eclink.hgpj.resource.vo.POBLKTVO;
import com.eclink.hgpj.resource.vo.POITEMVO;
import com.eclink.hgpj.resource.vo.POMASTVO;
import com.eclink.hgpj.resource.vo.SCHRCPVO;
import com.eclink.hgpj.resource.vo.SHPMSTVO;
import com.eclink.hgpj.resource.vo.SLDATAVO;
import com.eclink.hgpj.resource.vo.SLQNTYVO;
import com.eclink.hgpj.resource.vo.VENNAMVO;

/**
 * MenuService.java
 *
 * @Title: 菜单业务接口
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:12:44 PM
 *
 */
public interface XADATAService {
	public List<String> queryItrvt(ITMSITVO map) throws Exception;
	
	public List<String> queryUmstt9(ITMSITVO map) throws Exception;
	
	public List<ITMRVAVO> queryItmrva(ITMRVAVO vo) throws Exception;

	public List<ITMSITVO> queryItrvtAll(ITMSITVO vo) throws Exception;
	
	public List<SLQNTYVO> querySlqnty(Map map) throws Exception;
	
	public List<MOMASTVO> queryMomast(MOMASTVO vo) throws Exception;
	
	public List<MOMASTVO> queryMomastPrinted(MOMASTVO vo) throws Exception;

	public List<MOMASTVO> queryMomastNoCarePrint(MOMASTVO vo) throws Exception;
	
	public List<MOMASTVO> queryMomastBystate(MOMASTVO vo) throws Exception;
	
	public List<MODATAVO> queryModatas(MODATAVO vo) throws Exception ;
	
	public List<MOMASTVO> queryMomastByordno(MOMASTVO vo) throws Exception;
	
	public List<SLDATAVO> querySldata(Map map) throws Exception;
	
	public List<MOPORFVO> queryMoporf(MOPORFVO vo) throws Exception;
	
	public List<MOPORFVO> queryMoporfNormal(MOPORFVO vo) throws Exception;
	
	public List<SHPMSTVO> queryShpmst(Map map) throws Exception;
	
	public String queryBuyer(Map map) throws Exception;
	
	public List<POITEMVO> queryPoitem(Map map) throws Exception;
	
	public List<POMASTVO> queryPomast(Map map) throws Exception;
	
	public List<POBLKTVO> queryPoblkt(Map map) throws Exception;
	
	public String queryAxhdtx(Map map) throws Exception;
	public String queryADDSC(Map map) throws Exception;
	public String queryMBC6REP(Map map) throws Exception;
	public String queryCusnm(Map map) throws Exception;
	public String queryBMCBTX(Map map) throws Exception;
	public String queryMBCDREP(Map map) throws Exception;
	public String queryMBADREP(Map map) throws Exception;
	public List<MOROUTVO> queryMorout(Map map) throws Exception;
	
	public List<POMASTVO> queryPomastState(Map map) throws Exception;
	
	public List<VENNAMVO> queryVennam(Map map) throws Exception;
	
	public List<SCHRCPVO> querySchrcp(SCHRCPVO vo) throws Exception;
}
