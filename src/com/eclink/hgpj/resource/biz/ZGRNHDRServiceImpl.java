package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZSHPHDRVO;
import com.eclink.hgpj.resource.vo.ZSHPITMVO;

/**
 * MenuServiceImpl.java
 *
 * @Title: 菜单资源业务实现类
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class ZGRNHDRServiceImpl implements ZGRNHDRService {

	private ZGRNHDRDao zgrnhdrDao;

	public ZGRNHDRDao getZgrnhdrDao() {
		return zgrnhdrDao;
	}

	public void setZgrnhdrDao(ZGRNHDRDao zgrnhdrDao) {
		this.zgrnhdrDao = zgrnhdrDao;
	}

	private ZSHPHDRDao zshphdrDao;


	public ZSHPHDRDao getZshphdrDao() {
		return zshphdrDao;
	}


	public void setZshphdrDao(ZSHPHDRDao zshphdrDao) {
		this.zshphdrDao = zshphdrDao;
	}

	@Override
	public void insertZgrnhdr(ZGRNHDRVO vo) throws Exception {
		this.zgrnhdrDao.insertZgrnhdr(vo);
		List<ZGRNITMVO> subList = vo.getItemsList();
		if(subList!=null && subList.size()>0){
			for(int i=0;i<subList.size();i++){
				List<ZGRNBCHVO> subList2 = subList.get(i).getItemList();
				this.zgrnhdrDao.insertZgrnitm(subList.get(i));
				if(subList.get(i).getBlcf()!=null && "1".equals(subList.get(i).getBlcf()) && subList2!=null && subList2.size()>0){
					for(int j=0;j<subList2.size();j++){
						this.zgrnhdrDao.insertZgrnbch(subList2.get(j));
					}
				}
			}			
		}
		this.zshphdrDao.updateZshphdr(vo.getShpno());
		this.zshphdrDao.updateZshpitm(vo.getShpno());
	}

	@Override
	public List<ZGRNHDRVO> queryReceiptSelf(Map map) throws Exception {
		List<ZGRNHDRVO> zgrnhdrList = zgrnhdrDao.queryReceiptSelf(map);
		List<ZGRNITMVO> list = new ArrayList<ZGRNITMVO>();
		List<ZGRNHDRVO> list2 = new ArrayList<ZGRNHDRVO>();
		ZGRNHDRVO vo = null;
		if(zgrnhdrList!=null && zgrnhdrList.size()>0){
			vo = zgrnhdrList.get(0);
			for(int i =0;i<zgrnhdrList.size();i++){
				ZGRNHDRVO vot = zgrnhdrList.get(i);
				List<ZGRNITMVO> subList = vot.getItemsList();
				if(subList!=null && subList.size()>0){
					for(int j =0;j<subList.size();j++){
						list.add(subList.get(j));
					}
				}

			}
			vo.setItemsList(list);
			list2.add(vo);
		}
		return list2;
	}

	@Override
	public int getCoutsByDt(BigDecimal gtdte) throws Exception {

		return zgrnhdrDao.getCoutsByDt(gtdte);
	}

	@Override
	public List<ZGRNBCHVO> queryZgrnBch(String grnno) throws Exception {
		return zgrnhdrDao.queryZgrnBch(grnno);
	}

	@Override
	public List<ZGRNITMVO> queryReceiptItem(ZGRNITMVO vo) throws Exception {
		return zgrnhdrDao.queryReceiptItem(vo);
	}

	@Override
	public List<ZGRNBCHVO> queryZgrnBchByln(ZGRNITMVO vo) throws Exception {
		return zgrnhdrDao.queryZgrnBchByln(vo);
	}

	@Override
	public int getCoutsByState(String state) throws Exception {
		return zgrnhdrDao.getCoutsByState(state);
	}

	@Override
	public void updateHdrStat(ZGRNHDRVO vo) throws Exception {
		zgrnhdrDao.updateHdrStat(vo);
	}

	@Override
	public void updateItemStat(ZGRNITMVO vo) throws Exception {
		zgrnhdrDao.updateItemStat(vo);
	}

	@Override
	public void updateItem(ZGRNITMVO vo) throws Exception {
		zgrnhdrDao.updateItem(vo);
		List<ZGRNBCHVO> subList = vo.getItemList();
		if(subList!=null && subList.size()>0){
			for(int i=0;i<subList.size();i++){
				ZGRNBCHVO temp = subList.get(i);
				if(temp.getGrnbn().compareTo(new BigDecimal(-1)) == 0){
					//新增的情况怎么处理
//					zgrnhdrDao.deleteBch(temp);
					Map map = new HashMap();
					map.put("shpno", vo.getShpno());
					map.put("grnln", vo.getGrnln());
					List<ZGRNITMVO> itmList = zgrnhdrDao.queryZgrnitm(map);
					ZGRNITMVO itmTemp = itmList.get(0);
					int bchcount = zgrnhdrDao.getMaxGrnbn(vo);
					temp.setBlksq(itmTemp.getBlksq());
					temp.setGrnln(itmTemp.getGrnln());
					temp.setGrnbn(BigDecimal.valueOf(bchcount+1));
					temp.setGrnno(itmTemp.getGrnno());
					temp.setHouse(itmTemp.getHouse());
					temp.setItnbr(itmTemp.getItnbr());
					temp.setOrdno(itmTemp.getOrdno());
					temp.setPoisq(itmTemp.getPoisq());
					temp.setPurum(itmTemp.getPurum());
					temp.setShpln(itmTemp.getShpln());
					temp.setShpno(itmTemp.getShpno());
					temp.setVndnr(itmTemp.getVndnr());
					temp.setSbqty(new BigDecimal(0));
					temp.setShpbn(new BigDecimal(0));
					zgrnhdrDao.insertZgrnbch(temp);
				}else{
					//删除通过设置批次信息里面的实际数量为0及设置表体状态为50来实现					
					zgrnhdrDao.updateBch(temp);
				}
			}
		}
		if("50".equals(vo.getLstat())||"60".equals(vo.getLstat())){
			Map map = new HashMap();
			map.put("shpno", vo.getShpno());
			map.put("lstat", "10,40");
			List<ZGRNITMVO> zgrnitms = zgrnhdrDao.queryZgrnitm(map);
			ZGRNHDRVO hvo = new ZGRNHDRVO();
			hvo.setShpno(vo.getShpno());
			if(zgrnitms.size()>0){
				hvo.setOstat("40");
			}else{
				hvo.setOstat("50");
			}
			zgrnhdrDao.updateHdrStat(hvo);
		}
//		vo.setLstat("50");
//		zgrnhdrDao.updateItemStat(vo);
	}

	@Override
	public ZGRNHDRVO queryZgrnByNo(String grnno) throws Exception {
		return zgrnhdrDao.queryZgrnByNo(grnno);
	}

	@Override
	public List<ZGRNHDRVO> queryReceiptList(ZGRNITMVO vo) throws Exception {
		// TODO Auto-generated method stub
		return zgrnhdrDao.queryReceiptList(vo);
	}

	@Override
	public List<ZGRNITMVO> queryReceiptItems(ZGRNITMVO vo) throws Exception {
		List<ZGRNITMVO> list = zgrnhdrDao.queryReceiptItems(vo);
		for(ZGRNITMVO zgrnitmvo:list){
			List<ZGRNBCHVO> zgrnbchList = zgrnhdrDao.queryZgrnBchByln(zgrnitmvo);
			zgrnitmvo.setItemList(zgrnbchList);
		}
		return list;
	}

	@Override
	public List<ZGRNITMVO> queryZgrnitm(Map map) throws Exception {
		return zgrnhdrDao.queryZgrnitm(map);
	}
}
