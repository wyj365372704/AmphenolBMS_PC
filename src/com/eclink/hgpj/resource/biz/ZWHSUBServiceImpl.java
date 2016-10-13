package com.eclink.hgpj.resource.biz;

import java.util.List;

import com.eclink.hgpj.resource.dao.ZWHSUBDao;
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
public class ZWHSUBServiceImpl implements ZWHSUBService {

	
	private ZWHSUBDao zwhsubDao;

	public ZWHSUBDao getZwhsubDao() {
		return zwhsubDao;
	}

	public void setZwhsubDao(ZWHSUBDao zwhsubDao) {
		this.zwhsubDao = zwhsubDao;
	}

	@Override
	public List<ZWHSUBVO> queryZwhsub(ZWHSUBVO vo) throws Exception {
		return zwhsubDao.queryZwhsub(vo);
	}

	
	
	

}
