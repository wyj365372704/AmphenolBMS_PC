package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.XADATADao;
import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZITEMBXDao;
import com.eclink.hgpj.resource.dao.ZITMEXTDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZITEMBXVO;
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
public class ZITMBXServiceImpl implements ZITMBXService {

	
	private ZITEMBXDao zitmbxDao;

	public ZITEMBXDao getZitmbxDao() {
		return zitmbxDao;
	}

	public void setZitmbxDao(ZITEMBXDao zitmbxDao) {
		this.zitmbxDao = zitmbxDao;
	}

	@Override
	public List<ZITEMBXVO> queryItemBx(ZITEMBXVO vo) throws Exception {
		return zitmbxDao.queryItemBx(vo);
	}

	
}
