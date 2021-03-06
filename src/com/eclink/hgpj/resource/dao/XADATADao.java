package com.eclink.hgpj.resource.dao;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MBCDREPVO;
import com.eclink.hgpj.resource.vo.MBS2REPVO;
import com.eclink.hgpj.resource.vo.MODATAVO;
import com.eclink.hgpj.resource.vo.MODESCVO;
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
 * MenuDao.java
 *
 * @Title: 菜单资源数据库访问接口
 * @Description: 
 
 * @version 1.0
 *
 */
public interface XADATADao {
	
	public List<String> queryItrvt(ITMSITVO map) throws Exception;
	
	public List<ITMRVAVO> queryItmrva(ITMRVAVO vo) throws Exception;
	
	public List<ITMSITVO> queryItrvtAll(ITMSITVO vo) throws Exception;
	
	public List<ITMSITVO> queryItmsitByItnot9Like(ITMSITVO vo) throws Exception;
	
	public List<SLQNTYVO> querySlqnty(Map map) throws Exception;
	
	public List<MOMASTVO> queryMomast(MOMASTVO vo) throws Exception;

	public List<MOMASTVO> queryMomastBystate(MOMASTVO vo) throws Exception;
	
	public List<MODATAVO> queryModatas(MODATAVO vo) throws Exception;
	
	public List<MOMASTVO> queryMomastByordno(MOMASTVO vo) throws Exception;
	
	public List<MBCDREPVO> queryMbcdrep(MBCDREPVO vo) throws Exception;
	
	public List<SLDATAVO> querySldata(Map map) throws Exception;
	
	public List<MOPORFVO> queryMoporf(MOPORFVO vo) throws Exception;

	public List<MOPORFVO> queryMoporfNormal(MOPORFVO vo) throws Exception;
	
	public List<SHPMSTVO> queryShpmst(Map map) throws Exception;
	
	public List<String> queryBuyer(Map map) throws Exception;

	public List<SLQNTYVO> querySlqntyForPickList(Map map) throws Exception;

	public List<POITEMVO> queryPoitem(Map map) throws Exception;
	
	public List<POMASTVO> queryPomast(Map map) throws Exception;
	
	public List<POBLKTVO> queryPoblkt(Map map) throws Exception;

	public List<String> queryEEKANB(Map map) throws Exception;
	public List<String> queryAXHDTX(Map map) throws Exception;
	public List<String> queryMBC6REP(Map map) throws Exception;
	public List<String> queryCusnm(Map map) throws Exception;
	public List<String> queryCusnms(Map map) throws Exception;
	public List<String> queryCarrier(Map map) throws Exception;
	public List<String> queryTransport(Map map) throws Exception;
	public List<MBS2REPVO> queryShipTo(Map map) throws Exception;
	public List<String> queryBMCBTX(Map map) throws Exception;
	public List<String> queryMBCDREP(Map map) throws Exception;
	public List<String> queryMBADREP(Map map) throws Exception;
	public List<String> queryMBADREPM(Map map) throws Exception;
	public List<String> queryMbbirep(Map map) throws Exception;
	
	public List<MOROUTVO> queryMorout(Map map) throws Exception;
	public List<MODESCVO> queryModesc(Map map) throws Exception;
	
	public List<POMASTVO> queryPomastState(Map map) throws Exception;

	public List<VENNAMVO> queryVennam(Map map);
	
	public List<SCHRCPVO> querySchrcp(SCHRCPVO vo);
}
