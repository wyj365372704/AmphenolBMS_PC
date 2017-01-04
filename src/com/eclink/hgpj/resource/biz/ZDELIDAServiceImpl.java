package com.eclink.hgpj.resource.biz;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.ZDELIDADao;
import com.eclink.hgpj.resource.dao.ZDEPTDao;
import com.eclink.hgpj.resource.dao.ZEMPMSTDao;
import com.eclink.hgpj.resource.dao.ZMOJOBDao;
import com.eclink.hgpj.resource.dao.ZWHSUBDao;
import com.eclink.hgpj.resource.vo.ZDELIDAVO;
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
public class ZDELIDAServiceImpl implements ZDELIDAService {

	private ZDELIDADao zdelidaDao;

	@Override
	public List<ZDELIDAVO> queryZdelida(Map map) throws Exception {
		return zdelidaDao.queryZdelida(map);
	}
}
