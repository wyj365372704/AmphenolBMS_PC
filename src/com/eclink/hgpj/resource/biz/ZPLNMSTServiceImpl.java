package com.eclink.hgpj.resource.biz;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.ZPLNMSTDao;
import com.eclink.hgpj.resource.vo.ZPLNMSTVO;

public class ZPLNMSTServiceImpl implements ZPLNMSTService{
	private ZPLNMSTDao zplnmstDao;
	
	
	
	public ZPLNMSTDao getZplnmstDao() {
		return zplnmstDao;
	}



	public void setZplnmstDao(ZPLNMSTDao zplnmstDao) {
		this.zplnmstDao = zplnmstDao;
	}



	@Override
	public List<ZPLNMSTVO> queryZplnmst(Map map) throws Exception {
		// TODO Auto-generated method stub
		return zplnmstDao.queryZplnmst(map);
	}
	@Override
	public List<ZPLNMSTVO> queryZplnmstByMap(Map map) throws Exception {
		// TODO Auto-generated method stub
		return zplnmstDao.queryZplnmstByMap(map);
	}

}
