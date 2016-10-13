package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.XADATADao;
import com.eclink.hgpj.resource.dao.ZBMSCTLDao;
import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
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
public class ZBMSCTLServiceImpl implements ZBMSCTLService {

	
	private ZBMSCTLDao zbmsctlDao;

	public ZBMSCTLDao getZbmsctlDao() {
		return zbmsctlDao;
	}

	public void setZbmsctlDao(ZBMSCTLDao zbmsctlDao) {
		this.zbmsctlDao = zbmsctlDao;
	}

	@Override
	public List<ZBMSCTLVO> queryZbmsctl(ZBMSCTLVO vo) throws Exception {
		return zbmsctlDao.queryZbmsctl(vo);
	}
	
	

}
