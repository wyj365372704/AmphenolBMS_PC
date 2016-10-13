package com.eclink.hgpj.resource.biz;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.ZEMPMSTDao;
import com.eclink.hgpj.resource.dao.ZMCHMSTDao;
import com.eclink.hgpj.resource.dao.ZMOJOBDao;
import com.eclink.hgpj.resource.dao.ZWHSUBDao;
import com.eclink.hgpj.resource.vo.ZEMPMSTVO;
import com.eclink.hgpj.resource.vo.ZMCHMSTVO;
import com.eclink.hgpj.resource.vo.ZMOJOBVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;

/**

 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class ZMCHMSTServiceImpl implements ZMCHMSTService {

	private ZMCHMSTDao zmchmstDao;

	
	
	public ZMCHMSTDao getZmchmstDao() {
		return zmchmstDao;
	}



	public void setZmchmstDao(ZMCHMSTDao zmchmstDao) {
		this.zmchmstDao = zmchmstDao;
	}



	@Override
	public List<ZMCHMSTVO> queryZmchmstByMapWithDept(Map map) throws Exception {
		return zmchmstDao.queryZmchmstByMapWithDept(map);
	}

}
