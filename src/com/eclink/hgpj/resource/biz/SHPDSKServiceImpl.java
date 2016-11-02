package com.eclink.hgpj.resource.biz;

import java.util.List;

import com.eclink.hgpj.resource.dao.SHPDSKDao;
import com.eclink.hgpj.resource.dao.ZWHSUBDao;
import com.eclink.hgpj.resource.vo.SHPDSKVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;

/**
 * MenuServiceImpl.java
 *
 * @Title: 菜单资源业务实现类
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class SHPDSKServiceImpl implements SHPDSKService {
	private SHPDSKDao shpdskDao;
	
	
	public SHPDSKDao getShpdskDao() {
		return shpdskDao;
	}

	public void setShpdskDao(SHPDSKDao shpdskDao) {
		this.shpdskDao = shpdskDao;
	}

	@Override
	public void createTable() throws Exception {
		shpdskDao.createTable();
	}

	@Override
	public void insertShpdsk(SHPDSKVO vo) throws Exception {
		shpdskDao.insertShpdsk(vo);
	}
}
