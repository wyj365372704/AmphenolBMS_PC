package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.XADATADao;
import com.eclink.hgpj.resource.dao.ZBMSCTLDao;
import com.eclink.hgpj.resource.dao.ZCUSCNSDao;
import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZCUSCNSVO;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;

/**
 * MenuServiceImpl.java
 *
 * @Title: 菜单资源业务实现类
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class ZCUSCNSServiceImpl implements ZCUSCNSService {

	
	private ZCUSCNSDao zcuscnsDao;

	public ZCUSCNSDao getZcuscnsDao() {
		return zcuscnsDao;
	}

	public void setZcuscnsDao(ZCUSCNSDao zcuscnsDao) {
		this.zcuscnsDao = zcuscnsDao;
	}

	@Override
	public List<ZCUSCNSVO> queryZcuscns(ZCUSCNSVO vo) throws Exception {
		return zcuscnsDao.queryZcuscns(vo);
	}



}
