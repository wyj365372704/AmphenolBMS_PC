package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.XADATADao;
import com.eclink.hgpj.resource.dao.ZBMSCTLDao;
import com.eclink.hgpj.resource.dao.ZCUSCNSDao;
import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZPLHDRDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZCUSCNSVO;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZPLBOXVO;
import com.eclink.hgpj.resource.vo.ZPLDTLVO;
import com.eclink.hgpj.resource.vo.ZPLHDRVO;

/**
 * MenuServiceImpl.java
 *
 * @Title: 菜单资源业务实现类
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class ZPLHDRServiceImpl implements ZPLHDRService {

	
	private ZPLHDRDao zplhdrDao;

	

	public ZPLHDRDao getZplhdrDao() {
		return zplhdrDao;
	}

	public void setZplhdrDao(ZPLHDRDao zplhdrDao) {
		this.zplhdrDao = zplhdrDao;
	}

	@Override
	public int getCoutsByDt(BigDecimal gtdte) throws Exception {
		return zplhdrDao.getCoutsByDt(gtdte);
	}

	@Override
	public void insertZplbox(ZPLBOXVO vo) throws Exception {
		zplhdrDao.insertZplbox(vo);
	}

	@Override
	public void insertZpldtl(ZPLDTLVO vo) throws Exception {
		zplhdrDao.insertZpldtl(vo);
	}

	@Override
	public void insertZplhdr(ZPLHDRVO vo) throws Exception {
		zplhdrDao.insertZplhdr(vo);
	}

	@Override
	public List<ZPLBOXVO> queryBch(ZPLBOXVO vo) throws Exception {
		return zplhdrDao.queryBch(vo);
	}

	@Override
	public double queryDtlQty(ZPLDTLVO vo) throws Exception {
		return zplhdrDao.queryDtlQty(vo);
	}

	@Override
	public List<ZPLDTLVO> queryReceipt(ZPLDTLVO vo) throws Exception {
		return zplhdrDao.queryReceipt(vo);
	}

	@Override
	public List<ZPLHDRVO> queryZplhdr(ZPLHDRVO vo) throws Exception {
		return zplhdrDao.queryZplhdr(vo);
	}

	@Override
	public void updateZplhdr(String pldno) throws Exception {
		zplhdrDao.updateZplhdr(pldno);
	}

	@Override
	public void updateZplitm(ZPLDTLVO VO) throws Exception {
		zplhdrDao.updateZplitm(VO);
	}



}
