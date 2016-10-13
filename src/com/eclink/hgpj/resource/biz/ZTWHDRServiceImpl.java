package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.ZTWHDRDao;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ZTWBCHVO;
import com.eclink.hgpj.resource.vo.ZTWDTLVO;
import com.eclink.hgpj.resource.vo.ZTWHDRVO;


/**
 * MenuServiceImpl.java
 *
 * @Title: 菜单资源业务实现类
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class ZTWHDRServiceImpl implements ZTWHDRService {
	
	private ZTWHDRDao ztwhdrDao;

	public ZTWHDRDao getZtwhdrDao() {
		return ztwhdrDao;
	}

	public void setZtwhdrDao(ZTWHDRDao ztwhdrDao) {
		this.ztwhdrDao = ztwhdrDao;
	}

	@Override
	public void insertZtwhdr(ZTWHDRVO vo) throws Exception {
		
		List<ZTWDTLVO> itemList = vo.getItemList();
		if(itemList!=null && itemList.size()>0){
			for(int i=0;i<itemList.size();i++){
				ZTWDTLVO vot = itemList.get(i);
				List<ZTWBCHVO> subItemList = vot.getItemList();
				if(subItemList!=null && subItemList.size()>0){
					for(int j=0;j<subItemList.size();j++){
						this.ztwhdrDao.insertZtwbch(subItemList.get(j));
					}
				}
				this.ztwhdrDao.insertZtwdtl(vot);
			}
		}
		this.ztwhdrDao.insertZtwhdr(vo);
	}

	@Override
	public int getCoutsByDt(BigDecimal twdt1) throws Exception {
		return this.ztwhdrDao.getCoutsByDt(twdt1);
	}

	@Override
	public List<ZTWBCHVO> queryZtwbch(ZTWBCHVO vo) throws Exception {
		return this.ztwhdrDao.queryZtwbch(vo);
	}

	@Override
	public List<ZTWDTLVO> queryZtwdtl(ZTWDTLVO vo) throws Exception {
		return this.ztwhdrDao.queryZtwdtl(vo);
	}

	@Override
	public ZTWHDRVO queryZtwhdr(ZTWHDRVO vo) throws Exception {
		List<ZTWHDRVO> lists = this.ztwhdrDao.queryZtwhdr(vo);
		if(lists!=null && lists.size()>0){
			ZTWHDRVO retvo = lists.get(0);
			ZTWDTLVO pvo = new ZTWDTLVO();
			pvo.setTwdno(vo.getTwdno());
			List<ZTWDTLVO> itemList = this.ztwhdrDao.queryZtwdtl(pvo);
			if(itemList!=null && itemList.size()>0){
				for(int i=0;i<itemList.size();i++){
					ZTWDTLVO item = itemList.get(i);
					
					ZTWBCHVO bvo = new ZTWBCHVO();
					bvo.setTwdno(vo.getTwdno());
					bvo.setTwdln(item.getTwdln());
					bvo.setTwdbn(BigDecimal.valueOf(1));
					List<ZTWBCHVO> subItemList = this.ztwhdrDao.queryZtwbch(bvo);
					if(subItemList!=null && subItemList.size()>0){
						item.setItemList(subItemList);
					}
				}
				retvo.setItemList(itemList);
			}
			return retvo;
		}
		return null;
	}

	@Override
	public void updateZtwhdr(Map map) throws Exception {
//		ZTWHDRVO hdrvo = (ZTWHDRVO)map.get("ztwhdr");
		ZTWDTLVO dtlvo = (ZTWDTLVO)map.get("ztwdtl");
		ZTWBCHVO bchvo = (ZTWBCHVO)map.get("ztwbch");
		this.ztwhdrDao.updateItemBch(bchvo);
		this.ztwhdrDao.updateItemDtl(dtlvo);
//		this.ztwhdrDao.updateHdrStat(hdrvo);
	}

	@Override
	public void updateHdrStat(ZTWHDRVO vo) throws Exception {
		this.ztwhdrDao.updateHdrStat(vo);
	}

	@Override
	public void updateItemBch(ZTWBCHVO vo) throws Exception {
		this.ztwhdrDao.updateItemBch(vo);
	}

	@Override
	public void updateItemDtl(ZTWDTLVO vo) throws Exception {
		this.ztwhdrDao.updateItemDtl(vo);
	}

	@Override
	public void updateItemStat(ZTWDTLVO vo) throws Exception {
		this.ztwhdrDao.updateItemStat(vo);
	}

	/**
	 * 调拨单列表
	 */
	@Override
	public List<ZTWHDRVO> queryZtwhdrList(Map map) throws Exception {
		List<ZTWHDRVO> ztwList = this.ztwhdrDao.queryReceiptList(map);
		List<ZTWHDRVO> content = new ArrayList<ZTWHDRVO>();
		ZTWHDRVO ztwVO = null;
		if(ztwList!=null && ztwList.size()>0){
			for(int i =0;i<ztwList.size();i++){
				ztwVO = ztwList.get(i);
				List<ZTWDTLVO> subList = ztwVO.getItemList();
				if(subList!=null && subList.size()>0){
					for(int j =0;j<subList.size();j++){
						String no = ztwVO.getTwdno() +"-"+ subList.get(j).getTwdln();
						subList.get(j).setTwdno(no);
						ztwVO.setTwdno(no);
					}
				}
				ztwVO.setItemList(subList);
				content.add(ztwVO);
			}
		}
		return content;
	}

}
