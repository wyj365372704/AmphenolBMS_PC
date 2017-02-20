package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.batik.bridge.TextUtilities;

import com.eclink.hgpj.resource.dao.ZVRHDRDao;
import com.eclink.hgpj.resource.dao.ZWHSUBDao;
import com.eclink.hgpj.resource.vo.ZVRHDRVO;
import com.eclink.hgpj.resource.vo.ZVRITMVO;
import com.eclink.hgpj.resource.vo.ZVRTRNVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;
import com.eclink.hgpj.util.Utils;

/**
 * MenuServiceImpl.java
 *
 * @Title: 菜单资源业务实现类
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class ZVRHDRServiceImpl implements ZVRHDRService {
	private ZVRHDRDao zvrhdrDao;


	public ZVRHDRDao getZvrhdrDao() {
		return zvrhdrDao;
	}


	public void setZvrhdrDao(ZVRHDRDao zvrhdrDao) {
		this.zvrhdrDao = zvrhdrDao;
	}

	@Override
	public List<ZVRHDRVO> queryZvrhdr(Map map) throws Exception {
		return zvrhdrDao.queryZvrhdr(map);
	}

	@Override
	public List<ZVRITMVO> queryZvritm(Map map) throws Exception {
		return zvrhdrDao.queryZvritm(map);
	}

	@Override
	public String insertZvritmNewHdr(ZVRITMVO vo,String crus,String house) throws Exception {
		ZVRHDRVO zvrhdrvo = new ZVRHDRVO();
		zvrhdrvo.setVndnr(vo.getVndnr());
		zvrhdrvo.setHouse(house);
		zvrhdrvo.setOstat("05");
		zvrhdrvo.setCrus(crus);
		zvrhdrvo.setCrdt(new BigDecimal("1"+Utils.formateDate(null, "yyMMdd")));
		zvrhdrvo.setCrtm(new BigDecimal(Utils.formateDate(null, "HHmmss")));
		String vrdno = zvrhdrDao.insertZvrhdr(zvrhdrvo);
		vo.setVrdno(vrdno);
		zvrhdrDao.insertZvritm(vo);
		return vrdno;
	}

	@Override
	public void insertZvritm(ZVRITMVO vo) throws Exception {
		zvrhdrDao.insertZvritm(vo);
	}


	@Override
	public void deleteZvritm(ZVRITMVO vo) throws Exception {
		zvrhdrDao.deleteZvritm(vo);
	}

	@Override
	public void closePurchaseReturn(ZVRITMVO vo) throws Exception {
		vo.setLstat("60");
		zvrhdrDao.changeZvritmState(vo);
		Map parMap = new HashMap();
		parMap.put("vrdno", vo.getVrdno());
		parMap.put("lstat", "10");
		List<ZVRITMVO> queryZvritm = zvrhdrDao.queryZvritm(parMap);
		if(queryZvritm.size() == 0){//zvrhdr ostat 修改为 50 全部完成退货
			ZVRHDRVO zvrhdrvo =new ZVRHDRVO();
			zvrhdrvo.setVrdno(vo.getVrdno());
			zvrhdrvo.setOstat("50");
			zvrhdrDao.changeZvrhdrState(zvrhdrvo);
		}
	}
	
	@Override
	public void enableCreateZvrhdr(String vrdno) throws Exception {
		ZVRHDRVO vo = new ZVRHDRVO();
		vo.setVrdno(vrdno);
		vo.setOstat("10");
		zvrhdrDao.changeZvrhdrState(vo);
	}


	@Override
	public void cancelZvrhdr(String vrdno) throws Exception {
		ZVRHDRVO vo = new ZVRHDRVO();
		vo.setVrdno(vrdno);
		vo.setOstat("99");
		zvrhdrDao.changeZvrhdrState(vo);
	}

/**
 * 确认退料业务
 * 1.插入zvrtrn数据
 * 2.修改zvritm状态为50 已退货
 * 3.若该退货单下面没有状态为10未退货的子栏目,zvrhdr ostat 修改为50
 */
	@Override
	public void insertZvrtrn(ZVRTRNVO vo) throws Exception {	
		zvrhdrDao.insertZvrtrn(vo);
	}
	
	@Override
	public void ensurePurchaseReturn(ZVRITMVO vo) throws Exception{
		ZVRITMVO zvritmvo =new ZVRITMVO();
		zvritmvo.setVrdno(vo.getVrdno());
		zvritmvo.setVrdln(vo.getVrdln());
		zvritmvo.setLstat("50");
		zvrhdrDao.changeZvritmState(zvritmvo);
		Map parMap = new HashMap();
		parMap.put("vrdno", vo.getVrdno());
		parMap.put("lstat", "10");
		List<ZVRITMVO> queryZvritm = zvrhdrDao.queryZvritm(parMap);
		if(queryZvritm.size() == 0){//zvrhdr ostat 修改为 50 全部完成退货
			ZVRHDRVO zvrhdrvo =new ZVRHDRVO();
			zvrhdrvo.setVrdno(vo.getVrdno());
			zvrhdrvo.setOstat("50");
			zvrhdrDao.changeZvrhdrState(zvrhdrvo);
		}else{
			ZVRHDRVO zvrhdrvo = new ZVRHDRVO();
			zvrhdrvo.setVrdno(vo.getVrdno());
			zvrhdrvo.setOstat("40");
			zvrhdrDao.changeZvrhdrState(zvrhdrvo);
		}
	}

}




