package com.eclink.hgpj.resource.biz;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.VENNAMDao;
import com.eclink.hgpj.resource.vo.VENNAMVO;

public class VENNAMServiceImpl implements VENNAMService{
	private VENNAMDao vennamDao;
	
	

	public VENNAMDao getVennamDao() {
		return vennamDao;
	}



	public void setVennamDao(VENNAMDao vennamDao) {
		this.vennamDao = vennamDao;
	}



	@Override
	public List<VENNAMVO> queryVennam(Map map) throws Exception {
		// TODO Auto-generated method stub
		return vennamDao.queryVennam(map);
	}

}
