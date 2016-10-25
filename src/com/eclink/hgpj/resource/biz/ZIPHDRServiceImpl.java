package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.ZIPHDRDao;
import com.eclink.hgpj.resource.vo.ZBMSRSNVO;
import com.eclink.hgpj.resource.vo.ZIPDTLVO;
import com.eclink.hgpj.resource.vo.ZIPHDRVO;
import com.eclink.hgpj.resource.vo.ZIPHSTVO;

/**
 * MenuServiceImpl.java
 *
 * @Title: 生产单业务实现类
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class ZIPHDRServiceImpl implements ZIPHDRService {
	
	private ZIPHDRDao ziphdrDao;


	public ZIPHDRDao getZiphdrDao() {
		return ziphdrDao;
	}

	public void setZiphdrDao(ZIPHDRDao ziphdrDao) {
		this.ziphdrDao = ziphdrDao;
	}

	@Override
	public void insertZiphdr(ZIPHDRVO vo) throws Exception {
		this.ziphdrDao.insertZiphdr(vo);
		List<ZIPDTLVO> subList = vo.getItemList();
		if(subList!=null && subList.size()>0){
			for(int i=0;i<subList.size();i++){
				List<ZIPHSTVO> subList2 = subList.get(i).getItemList();
				this.ziphdrDao.insertZipdtl(subList.get(i));
//				if(subList.get(i).getBlcf()!=null && "1".equals(subList.get(i).getBlcf()) && subList2!=null && subList2.size()>0){
//					for(int j=0;j<subList2.size();j++){
//						this.ziphdrDao.insertZiphst(subList2.get(j));
//					}
//				}
			}			
		}
		
	}

	@Override
	public int getCoutsByDt(BigDecimal gtdte) throws Exception {
		return this.ziphdrDao.getCoutsByDt(gtdte);
	}

	@Override
	public List<ZIPDTLVO> queryItems(ZIPDTLVO vo) throws Exception {
		return this.ziphdrDao.queryItems(vo);
	}
	
	@Override
	public List<ZIPDTLVO> queryItemsWsubOrder(ZIPDTLVO vo) throws Exception {
		return this.ziphdrDao.queryItemsWsubOrder(vo);
	}

	@Override
	public List<ZIPDTLVO> queryItemsBytype(ZIPDTLVO vo) throws Exception {
		return this.ziphdrDao.queryItemsBytype(vo);
	}

	@Override
	public void insertZipdtl(ZIPDTLVO vo) throws Exception {
		this.ziphdrDao.insertZipdtl(vo);
	}

	@Override
	public void insertZiphdrO(ZIPHDRVO vo) throws Exception {
		this.ziphdrDao.insertZiphdr(vo);
	}

	@Override
	public void insertZiphst(ZIPHSTVO vo) throws Exception {
		this.ziphdrDao.insertZiphst(vo);
	}

	@Override
	public double getAllshqty(ZIPDTLVO vo) throws Exception {
		return ziphdrDao.getAllshqty(vo);
	}

	@Override
	public int getDtlCoutsBypar(Map map) throws Exception {
		return ziphdrDao.getDtlCoutsBypar(map);
	}

	@Override
	public List<ZIPHDRVO> queryHdrs(ZIPHDRVO vo) throws Exception {
		return ziphdrDao.queryHdrs(vo);
	}

	@Override
	public List<ZIPHSTVO> queryHstItems(ZIPHSTVO vo) throws Exception {
		return ziphdrDao.queryHstItems(vo);
	}

	@Override
	public void updateZiphdr(Map map) throws Exception {
		ZIPHDRVO vo = (ZIPHDRVO)map.get("ZIPHDRVO");
		ZIPDTLVO vo1 = (ZIPDTLVO)map.get("ZIPDTLVO");
//		ZIPHSTVO vo1 = (ZIPHSTVO)map.get("ZIPHSTVO");
		
		ZIPDTLVO pvo = new ZIPDTLVO();
		pvo.setIpdno(vo1.getIpdno());
		pvo.setLstat("10");
		List<ZIPDTLVO> results = this.ziphdrDao.queryItems(pvo);
		if(results==null || results.size()==0){
			this.ziphdrDao.updateZiphdrStat(vo);
		}
		this.ziphdrDao.updateZipitmStat(vo1);
		if(vo1!=null && vo1.getItemList()!=null && vo1.getItemList().size()>0){
			for(int i=0;i<vo1.getItemList().size();i++){
				ZIPHSTVO vot = vo1.getItemList().get(i);
				this.ziphdrDao.insertZiphst(vot);
			}
		}
	}

	//领料单确认
	@Override
	public void updateZiphdrS(Map map) throws Exception {
		ZIPHDRVO vo = (ZIPHDRVO)map.get("ZIPHDRVO");
		if(vo!=null && vo.getItemList()!=null && vo.getItemList().size()>0){
			this.ziphdrDao.updateZiphdrStat(vo);
			for(int i=0;i<vo.getItemList().size();i++){
				ZIPDTLVO vot = vo.getItemList().get(i);
				this.ziphdrDao.updateZipitm(vot);
//					for(int j=0;j<vot.getItemList().size();j++){
//						ZIPHSTVO vos = vot.getItemList().get(j);
//						this.ziphdrDao.updateZiphstS(vos);
//					}
			}
		}
		
	}

	@Override
	public void updateZipdtlStat(ZIPDTLVO vo) throws Exception {
		this.ziphdrDao.updateZipitmStat(vo);
	}
	
	@Override
	public void updateZiphdrStat(ZIPHDRVO vo) throws Exception {
		this.ziphdrDao.updateZiphdrStat(vo);
	}
	
	@Override
	public void updateZiphdrLprt(ZIPHDRVO vo) throws Exception {
		this.ziphdrDao.updateZiphdrLprt(vo);
	}

	@Override
	public void deleteZipdtl(ZIPDTLVO vo) throws Exception {
		this.ziphdrDao.deleteZipdtl(vo);
	}

	@Override
	public void updateZipitmQty(ZIPDTLVO vo) throws Exception {
		this.ziphdrDao.updateZipitmQty(vo);
	}

	@Override
	public List<ZBMSRSNVO> getReason(Map rpmap) throws Exception {
		return this.ziphdrDao.getReason(rpmap);
	}

	@Override
	public void insertZiphdrM(List<ZIPHDRVO> vos) throws Exception {
		if(vos!=null && vos.size()>0){
			for(int j=0;j<vos.size();j++){
				ZIPHDRVO vo = vos.get(j);
				this.ziphdrDao.insertZiphdr(vo);
				List<ZIPDTLVO> subList = vo.getItemList();
				if(subList!=null && subList.size()>0){
					for(int i=0;i<subList.size();i++){
						List<ZIPHSTVO> subList2 = subList.get(i).getItemList();
						this.ziphdrDao.insertZipdtl(subList.get(i));
					}			
				}
			}
		}
	}

	@Override
	public List<ZIPHDRVO> queryHdrsByPar(Map vo) throws Exception {
		return this.ziphdrDao.queryHdrsByPar(vo);
	}

}
