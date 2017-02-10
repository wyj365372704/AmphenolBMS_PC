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
import com.eclink.hgpj.resource.vo.ZSABCHVO;
import com.eclink.hgpj.resource.vo.ZSABOXVO;
import com.eclink.hgpj.resource.vo.ZSADTLVO;
import com.eclink.hgpj.resource.vo.ZSAHDRVO;

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

	@Override
	public void insertZplhdrA(ZPLHDRVO vo, List<ZPLDTLVO> vos, List<ZPLBOXVO> bvos) throws Exception {
		if(vo!=null){
			zplhdrDao.insertZplhdr(vo);
			if(vos!=null && vos.size()>0){
				for(int i=0;i<vos.size();i++){
					zplhdrDao.insertZpldtl(vos.get(i));
				}
			}
			if(bvos!=null && bvos.size()>0){
				for(int i=0;i<bvos.size();i++){
					zplhdrDao.insertZplbox(bvos.get(i));
				}
			}
		}
		
	}

	@Override
	public List<ZPLHDRVO> queryZplhdrByPar(Map vo) throws Exception {
		return zplhdrDao.queryZplhdrByPar(vo);
	}

	@Override
	public void deleteZplhdr(String pldno) throws Exception {
		zplhdrDao.deleteZplhdr(pldno);
	}

	@Override
	public void updateZplboxByPar(ZPLBOXVO vo) throws Exception {
		zplhdrDao.updateZplboxByPar(vo);
	}

	@Override
	public void updateZpldtlByPar(ZPLDTLVO vo) throws Exception {
		zplhdrDao.updateZpldtlByPar(vo);
	}

	@Override
	public void updateZplhdrByPar(ZPLHDRVO vo) throws Exception {
		zplhdrDao.updateZplhdrByPar(vo);
	}

	@Override
	public void insertZsabch(ZSABCHVO vo) throws Exception {
		zplhdrDao.insertZsabch(vo);
	}

	@Override
	public void insertZsabox(ZSABOXVO vo) throws Exception {
		zplhdrDao.insertZsabox(vo);
	}

	@Override
	public void insertZsadtl(ZSADTLVO vo) throws Exception {
		zplhdrDao.insertZsadtl(vo);
	}

	@Override
	public void insertZsahdr(ZSAHDRVO vo) throws Exception {
		zplhdrDao.insertZsahdr(vo);
	}

	@Override
	public void insertZsahdrs(Map map) throws Exception {
		if(map!=null){
			if(map.get("zsahdr")!=null){
				zplhdrDao.insertZsahdr((ZSAHDRVO)map.get("zsahdr"));
			}
			if(map.get("zsadtls")!=null){
				List<ZSADTLVO> zsadtls = (List<ZSADTLVO>)map.get("zsadtls");
				if(zsadtls.size()>0){
					for(int i=0;i<zsadtls.size();i++){
						zplhdrDao.insertZsadtl(zsadtls.get(i));
					}
				}
			}
			if(map.get("zsabchs")!=null){
				List<ZSABCHVO> zsabchs = (List<ZSABCHVO>)map.get("zsabchs");
				if(zsabchs.size()>0){
					for(int i=0;i<zsabchs.size();i++){
						zplhdrDao.insertZsabch(zsabchs.get(i));
					}
				}
			}
			if(map.get("zsabboxes")!=null){
				List<ZSABOXVO> zsabboxes = (List<ZSABOXVO>)map.get("zsabboxes");
				if(zsabboxes.size()>0){
					for(int i=0;i<zsabboxes.size();i++){
						zplhdrDao.insertZsabox(zsabboxes.get(i));
					}
				}
			}
		}
	}

	@Override
	public int getZsaCoutsByDt(BigDecimal gtdte) throws Exception {
		return zplhdrDao.getZsaCoutsByDt(gtdte);
	}

	@Override
	public List<ZSAHDRVO> queryZsahdrByPar(ZSAHDRVO vo) throws Exception {
		return zplhdrDao.queryZsahdrByPar(vo);
	}

	@Override
	public int getZsadtlCouts(ZSADTLVO vo) throws Exception {
		return zplhdrDao.getZsadtlCouts(vo);
	}

	@Override
	public List<String> queryC6cvnb(ZPLDTLVO vo) throws Exception {
		return zplhdrDao.queryC6cvnb(vo);
	}

	@Override
	public List<ZSABCHVO> queryZsabchs(ZSABCHVO vo) throws Exception {
		return zplhdrDao.queryZsabchs(vo);
	}

	@Override
	public List<ZSADTLVO> queryZsadtls(ZSADTLVO vo) throws Exception {
		return zplhdrDao.queryZsadtls(vo);
	}

	@Override
	public void updateZplhdrA(ZPLHDRVO vo, List<ZPLDTLVO> vos,
			List<ZPLBOXVO> bvos) throws Exception {
		if(vo!=null){
			zplhdrDao.updateZplhdrByPar(vo);
			if(vos!=null && vos.size()>0){
				for(int i=0;i<vos.size();i++){
					zplhdrDao.updateZpldtlByPar(vos.get(i));
				}
			}
			if(bvos!=null && bvos.size()>0){
				for(int i=0;i<bvos.size();i++){
					zplhdrDao.updateZplboxByPar(bvos.get(i));
				}
			}
		}
	}



}
