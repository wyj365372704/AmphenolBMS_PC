package com.eclink.hgpj.resource.biz;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.ZEMPMSTDao;
import com.eclink.hgpj.resource.dao.ZMOJOBDao;
import com.eclink.hgpj.resource.dao.ZWHSUBDao;
import com.eclink.hgpj.resource.vo.ZEMPMSTVO;
import com.eclink.hgpj.resource.vo.ZMOJOBVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;

/**

 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class ZEMPMSTServiceImpl implements ZEMPMSTService {

	private ZEMPMSTDao zempmstDao;

	
	
	public ZEMPMSTDao getZempmstDao() {
		return zempmstDao;
	}



	public void setZempmstDao(ZEMPMSTDao zempmstDao) {
		this.zempmstDao = zempmstDao;
	}



	@Override
	public List<ZEMPMSTVO> queryZempmstByMapWithDept(Map map) throws Exception {
		return zempmstDao.queryZempmstByMapWithDept(map);
	}



	@Override
	public List<ZEMPMSTVO> queryZempmstByMap(Map map) throws Exception {
		return zempmstDao.queryZempmstByMap(map);
	}

}
