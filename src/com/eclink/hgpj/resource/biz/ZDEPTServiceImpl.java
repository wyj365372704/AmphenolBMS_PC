package com.eclink.hgpj.resource.biz;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.ZDEPTDao;
import com.eclink.hgpj.resource.dao.ZEMPMSTDao;
import com.eclink.hgpj.resource.dao.ZMOJOBDao;
import com.eclink.hgpj.resource.dao.ZWHSUBDao;
import com.eclink.hgpj.resource.vo.ZDEPTVO;
import com.eclink.hgpj.resource.vo.ZEMPMSTVO;
import com.eclink.hgpj.resource.vo.ZMOJOBVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;

/**

 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class ZDEPTServiceImpl implements ZDEPTService {

	private ZDEPTDao zdeptDao;


	public ZDEPTDao getZdeptDao() {
		return zdeptDao;
	}


	public void setZdeptDao(ZDEPTDao zdeptDao) {
		this.zdeptDao = zdeptDao;
	}

	@Override
	public List<ZDEPTVO> queryZdeptByMap(Map map) throws Exception {
		return zdeptDao.queryZdeptByMap(map);
	}

}
