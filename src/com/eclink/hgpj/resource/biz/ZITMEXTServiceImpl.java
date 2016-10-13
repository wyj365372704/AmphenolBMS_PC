package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.XADATADao;
import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZITMEXTDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZITMEXTVO;

/**
 * MenuServiceImpl.java
 *
 * @Title: 菜单资源业务实现类
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class ZITMEXTServiceImpl implements ZITMEXTService {

	
	private ZITMEXTDao zitmextDao;

	public ZITMEXTDao getZitmextDao() {
		return zitmextDao;
	}

	public void setZitmextDao(ZITMEXTDao zitmextDao) {
		this.zitmextDao = zitmextDao;
	}

	@Override
	public List<ZITMEXTVO> queryItemExt(ZITMEXTVO vo) throws Exception {
		return zitmextDao.queryItemExt(vo);
	}
	
	
}
