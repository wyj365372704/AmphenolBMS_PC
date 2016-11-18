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
	public List<ZVRHDRVO> queryZvritm(Map map) throws Exception {
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
	public void enableCreateZvritm(String vrdno) throws Exception {
		ZVRHDRVO vo = new ZVRHDRVO();
		vo.setVrdno(vrdno);
		vo.setOstat("10");
		zvrhdrDao.changeZvrhdrState(vo);
	}


	@Override
	public void cancelZvritm(String vrdno) throws Exception {
		ZVRHDRVO vo = new ZVRHDRVO();
		vo.setVrdno(vrdno);
		vo.setOstat("99");
		zvrhdrDao.changeZvrhdrState(vo);
	}
}




