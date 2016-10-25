package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.XADATADao;
import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.vo.BUYERFVO;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MODATAVO;
import com.eclink.hgpj.resource.vo.MODESCVO;
import com.eclink.hgpj.resource.vo.MOMASTVO;
import com.eclink.hgpj.resource.vo.MOPORFVO;
import com.eclink.hgpj.resource.vo.MOROUTVO;
import com.eclink.hgpj.resource.vo.POBLKTVO;
import com.eclink.hgpj.resource.vo.POITEMVO;
import com.eclink.hgpj.resource.vo.POMASTVO;
import com.eclink.hgpj.resource.vo.SHPMSTVO;
import com.eclink.hgpj.resource.vo.SLDATAVO;
import com.eclink.hgpj.resource.vo.SLQNTYVO;
import com.eclink.hgpj.resource.vo.VENNAMVO;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;

/**
 * MenuServiceImpl.java
 *
 * @Title: 菜单资源业务实现类
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class XADATAServiceImpl implements XADATAService {


	private XADATADao xadataDao;


	public XADATADao getXadataDao() {
		return xadataDao;
	}


	public void setXadataDao(XADATADao xadataDao) {
		this.xadataDao = xadataDao;
	}


	@Override
	public List<String> queryItrvt(ITMSITVO map) throws Exception {

		return xadataDao.queryItrvt(map);
	}

	@Override
	public List<String> queryUmstt9(ITMSITVO map) throws Exception {

		return xadataDao.queryItrvt(map);
	}


	@Override
	public List<ITMRVAVO> queryItmrva(ITMRVAVO vo) throws Exception {
		return xadataDao.queryItmrva(vo);
	}


	@Override
	public List<SLQNTYVO> querySlqnty(Map map) throws Exception {
		return xadataDao.querySlqnty(map);
	}


	@Override
	public List<MOMASTVO> queryMomast(MOMASTVO vo) throws Exception {
		return xadataDao.queryMomast(vo);
	}


	@Override
	public List<SLDATAVO> querySldata(Map map) throws Exception {
		return xadataDao.querySldata(map);
	}


	@Override
	public List<MODATAVO> queryModatas(MODATAVO vo) throws Exception {
		return xadataDao.queryModatas(vo);
	}


	@Override
	public List<MOMASTVO> queryMomastByordno(MOMASTVO vo) throws Exception {
		return xadataDao.queryMomastByordno(vo);
	}


	@Override
	public List<MOMASTVO> queryMomastBystate(MOMASTVO vo) throws Exception {
		return xadataDao.queryMomastBystate(vo);
	}


	@Override
	public List<MOPORFVO> queryMoporf(MOPORFVO vo) throws Exception {
		return xadataDao.queryMoporf(vo);
	}
	
	
	@Override
	public List<MOPORFVO> queryMoporfNormal(MOPORFVO vo) throws Exception {
		return xadataDao.queryMoporfNormal(vo);
	}


	@Override
	public String queryBuyer(Map map) throws Exception {
		List<String> list= xadataDao.queryBuyer(map);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return "";
	}


	@Override
	public List<POITEMVO> queryPoitem(Map map) throws Exception {
		return xadataDao.queryPoitem(map);
	}


	@Override
	public List<POMASTVO> queryPomast(Map map) throws Exception {
		return xadataDao.queryPomast(map);
	}


	@Override
	public List<SHPMSTVO> queryShpmst(Map map) throws Exception {
		return xadataDao.queryShpmst(map);
	}


	@Override
	public List<ITMSITVO> queryItrvtAll(ITMSITVO vo) throws Exception {
		return xadataDao.queryItrvtAll(vo);
	}


	@Override
	public List<POBLKTVO> queryPoblkt(Map map) throws Exception {
		return xadataDao.queryPoblkt(map);
	}


	@Override
	public String queryBMCBTX(Map map) throws Exception {
		List<String> list= xadataDao.queryBMCBTX(map);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return "";
	}


	@Override
	public String queryCusnm(Map map) throws Exception {
		List<String> list= xadataDao.queryCusnm(map);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return "";
	}


	@Override
	public String queryMBADREP(Map map) throws Exception {
		List<String> list= xadataDao.queryMBADREP(map);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return "";
	}


	@Override
	public String queryMBC6REP(Map map) throws Exception {
		List<String> list= xadataDao.queryMBC6REP(map);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return "";
	}


	@Override
	public String queryMBCDREP(Map map) throws Exception {
		List<String> list= xadataDao.queryMBCDREP(map);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return "";
	}
	
	@Override
	public String queryAxhdtx(Map map) throws Exception {
		List<String> list= xadataDao.queryEEKANB(map);
		String result = "";
		for(String eekanb:list){
			Map<String, String> parMap = new HashMap<String, String>();
			parMap.put("eekanb", eekanb);
			List<String> axhdtxList = xadataDao.queryAXHDTX(parMap);
			for(String axhdtx:axhdtxList){
				result+=axhdtx.trim()+",";
			}
		}
		if(result.length()>0)
			result = result.substring(0,result.length()-1);
		return result;
	}

	public String queryADDSC(Map map) throws Exception{
		List<MODESCVO> list= xadataDao.queryModesc(map);
		String result = "";
		for(MODESCVO modescvo:list){
			result+=modescvo.getAddsc().trim()+",";
		}
		if(result.length()>0)
			result = result.substring(0,result.length()-1);
		return result;
	}

	@Override
	public List<MOROUTVO> queryMorout(Map map) throws Exception {
		return xadataDao.queryMorout(map);
	}


	@Override
	public List<VENNAMVO> queryVennam(Map map) throws Exception {
		// TODO Auto-generated method stub
		return xadataDao.queryVennam(map);
	}


	@Override
	public List<MOMASTVO> queryMomastPrinted(MOMASTVO vo) throws Exception {
		return xadataDao.queryMomastPrinted(vo);
	}


	@Override
	public List<MOMASTVO> queryMomastNoCarePrint(MOMASTVO vo) throws Exception {
		return xadataDao.queryMomastNoCarePrint(vo);
	}
}
