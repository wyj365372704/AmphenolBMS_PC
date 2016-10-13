package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.XADATADao;
import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZITMEXTDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.dao.ZSLLOGDao;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZITMEXTVO;
import com.eclink.hgpj.resource.vo.ZSLLOGVO;

/**
 * MenuServiceImpl.java
 *
 * @Title: 菜单资源业务实现类
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class ZSLLOGServiceImpl implements ZSLLOGService {

	
	private ZSLLOGDao zsllogDao;

	public ZSLLOGDao getZsllogDao() {
		return zsllogDao;
	}

	public void setZsllogDao(ZSLLOGDao zsllogDao) {
		this.zsllogDao = zsllogDao;
	}

	@Override
	public void insertZsllog(ZSLLOGVO vo) throws Exception {
		this.zsllogDao.insertZsllog(vo);
	}

	@Override
	public int getCoutsByDt(BigDecimal crdat) throws Exception {
		return zsllogDao.getCoutsByDt(crdat);
	}


	
	
}
