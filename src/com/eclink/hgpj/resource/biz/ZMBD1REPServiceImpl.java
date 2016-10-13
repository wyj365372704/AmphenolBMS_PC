package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.XADATADao;
import com.eclink.hgpj.resource.dao.ZBMSCTLDao;
import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZMBD1REPDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZMBD1REPVO;

/**
 * MenuServiceImpl.java
 *
 * @Title: 菜单资源业务实现类
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class ZMBD1REPServiceImpl implements ZMBD1REPService {

	
	private ZMBD1REPDao zmbd1repDao;

	public ZMBD1REPDao getZmbd1repDao() {
		return zmbd1repDao;
	}

	public void setZmbd1repDao(ZMBD1REPDao zmbd1repDao) {
		this.zmbd1repDao = zmbd1repDao;
	}

	@Override
	public List<ZMBD1REPVO> queryZmbd1erp(ZMBD1REPVO vo) throws Exception {
		return zmbd1repDao.queryZmbd1erp(vo);
	}

	
	

}
