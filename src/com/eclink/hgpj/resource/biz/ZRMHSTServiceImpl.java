package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.XADATADao;
import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZITMEXTDao;
import com.eclink.hgpj.resource.dao.ZRMHSTDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.dao.ZSLLOGDao;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZITMEXTVO;
import com.eclink.hgpj.resource.vo.ZRMHSTVO;
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
public class ZRMHSTServiceImpl implements ZRMHSTService {

	
	private ZRMHSTDao zrmhstDao;

	public ZRMHSTDao getZrmhstDao() {
		return zrmhstDao;
	}

	public void setZrmhstDao(ZRMHSTDao zrmhstDao) {
		this.zrmhstDao = zrmhstDao;
	}

	@Override
	public int getCoutsByDt(BigDecimal rmdat) throws Exception {
		return zrmhstDao.getCoutsByDt(rmdat);
	}

	@Override
	public void insertZrmhst(ZRMHSTVO vo) throws Exception {
		zrmhstDao.insertZrmhst(vo);
	}

	@Override
	public void deleteZrmhst(String rmdno) throws Exception {
		zrmhstDao.deleteZrmhst(rmdno);
	}

	
}
