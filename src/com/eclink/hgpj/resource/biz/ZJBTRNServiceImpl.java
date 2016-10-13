package com.eclink.hgpj.resource.biz;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.ZEMPMSTDao;
import com.eclink.hgpj.resource.dao.ZJBTRNDao;
import com.eclink.hgpj.resource.dao.ZJOBEMPDao;
import com.eclink.hgpj.resource.dao.ZMOJOBDao;
import com.eclink.hgpj.resource.dao.ZWHSUBDao;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZEMPMSTVO;
import com.eclink.hgpj.resource.vo.ZJBTRNVO;
import com.eclink.hgpj.resource.vo.ZJOBEMPVO;
import com.eclink.hgpj.resource.vo.ZMOJOBVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;

/**

 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class ZJBTRNServiceImpl implements ZJBTRNService {
	private ZJBTRNDao zjbtrnDao;

	
	
	public ZJBTRNDao getZjbtrnDao() {
		return zjbtrnDao;
	}



	public void setZjbtrnDao(ZJBTRNDao zjbtrnDao) {
		this.zjbtrnDao = zjbtrnDao;
	}



	@Override
	public List<ZJBTRNVO> queryZjbtrnByMap(Map map) throws Exception {
		return zjbtrnDao.queryZjbtrnByMap(map);
	}



	@Override
	public List<ZJBTRNVO> queryZjbtrnByJtdnoLike(String s) throws Exception {
		return zjbtrnDao.queryZjbtrnByJtdnoLike(s);
	}



	@Override
	public void insertZjbtrn(ZJBTRNVO vo) throws Exception {
		zjbtrnDao.insertZjbtrn(vo);
	}



	@Override
	public void updateZjbtrn(ZJBTRNVO vo) throws Exception {
		zjbtrnDao.updateZjbtrn(vo);
	}
}
