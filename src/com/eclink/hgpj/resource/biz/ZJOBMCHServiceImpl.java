package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.ZEMPMSTDao;
import com.eclink.hgpj.resource.dao.ZJBTRNDao;
import com.eclink.hgpj.resource.dao.ZJOBEMPDao;
import com.eclink.hgpj.resource.dao.ZJOBMCHDao;
import com.eclink.hgpj.resource.dao.ZMOJOBDao;
import com.eclink.hgpj.resource.dao.ZWHSUBDao;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZEMPMSTVO;
import com.eclink.hgpj.resource.vo.ZJBTRNVO;
import com.eclink.hgpj.resource.vo.ZJOBEMPVO;
import com.eclink.hgpj.resource.vo.ZJOBMCHVO;
import com.eclink.hgpj.resource.vo.ZMOJOBVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;
import com.eclink.hgpj.util.Utils;

/**

 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class ZJOBMCHServiceImpl implements ZJOBMCHService {
	private ZJOBMCHDao zjobmchDao;
	private ZJBTRNService zjbtrnService;

	public ZJOBMCHDao getZjobmchDao() {
		return zjobmchDao;
	}


	public void setZjobmchDao(ZJOBMCHDao zjobmchDao) {
		this.zjobmchDao = zjobmchDao;
	}

	
	public ZJBTRNService getZjbtrnService() {
		return zjbtrnService;
	}


	public void setZjbtrnService(ZJBTRNService zjbtrnService) {
		this.zjbtrnService = zjbtrnService;
	}


	@Override
	public List<ZJOBMCHVO> queryByMapWithEmpName(Map map) throws Exception {
		return zjobmchDao.queryByMapWithEmpName(map);
	}


	@Override
	public void insertZjobmch(ZJOBMCHVO vo) throws Exception {
		zjobmchDao.insertZjobmch(vo);
		insertZjbtrn(vo);
	}


	@Override
	public void updateZjobmchJstat(ZJOBMCHVO vo) throws Exception {
		if(vo.getJstat().equals("0")){
			updateZjbtrn(vo);
			Map<String, String> zjbtrnParMap = new HashMap<String, String>();
			zjbtrnParMap.put("mjdno", vo.getMjdno());
			zjbtrnParMap.put("ordno", vo.getOrdno());
			zjbtrnParMap.put("opseq", vo.getOpseq());
			zjbtrnParMap.put("pline", vo.getPline());
			zjbtrnParMap.put("mchid", vo.getMchid());
			zjbtrnParMap.put("jstat", "50");
			List<ZJBTRNVO> zjbtrList = zjbtrnService.queryZjbtrnByMap(zjbtrnParMap);

			double cmhrs = 0d;
			SimpleDateFormat sf = new SimpleDateFormat("yyMMddHHmmss");
			for(ZJBTRNVO zjbtrnvo:zjbtrList){
				
				cmhrs+=zjbtrnvo.getMhrs1().doubleValue();
			}

			vo.setCmhrs(BigDecimal.valueOf(cmhrs));
			
			this.zjobmchDao.updateZjobmchJstat(vo);
		}else{
			insertZjbtrn(vo);
			vo.setCmhrs(BigDecimal.valueOf(0));
			this.zjobmchDao.updateZjobmchJstat(vo);
		}

	}
	
	private void insertZjbtrn(ZJOBMCHVO vo) throws Exception {
		SimpleDateFormat sf = new SimpleDateFormat("yyMMdd");
		List<ZJBTRNVO> zjbtrnvos = zjbtrnService.queryZjbtrnByJtdnoLike("JT"+sf.format(new Date()));
		String newIndex = "";
		if(zjbtrnvos.size()>0){
			newIndex = zjbtrnvos.get(0).getJtdno().trim();
			if(newIndex.length() == 14){
				int currentIndex = Integer.parseInt(newIndex.substring(8))+1;
				newIndex = String.valueOf(currentIndex);
				for(int i =newIndex.length();i<6;i++){
					newIndex = "0"+newIndex;
				}
			}else{
				newIndex  = "000001";
			}
		}else{
			newIndex  = "000001";
		}

		ZJBTRNVO zjbtrnvo = new ZJBTRNVO();
		zjbtrnvo.setJtdno("JT"+sf.format(new Date())+newIndex);
		zjbtrnvo.setMjdno(vo.getMjdno());
		zjbtrnvo.setHouse(vo.getHouse());
		zjbtrnvo.setOrdno(vo.getOrdno());
		zjbtrnvo.setOpseq(vo.getOpseq());
		zjbtrnvo.setPline(vo.getPline());
		zjbtrnvo.setJttyp("M");
		zjbtrnvo.setMchid(vo.getMchid());
		zjbtrnvo.setJstat("20");
		String nowDate = Utils.formateDate(null, "yyMMdd");
		String nowTime = Utils.formateDate(null, "HHmmss");
		zjbtrnvo.setJtsdt(BigDecimal.valueOf(Long.valueOf("1"+nowDate)));
		zjbtrnvo.setJtstm(BigDecimal.valueOf(Long.valueOf(nowTime)));
		zjbtrnService.insertZjbtrn(zjbtrnvo);
	}
	
	private void updateZjbtrn(ZJOBMCHVO vo) throws Exception{

		Map<String, String> zjbtrnParMap = new HashMap<String, String>();
		zjbtrnParMap.put("mjdno", vo.getMjdno());
		zjbtrnParMap.put("ordno", vo.getOrdno());
		zjbtrnParMap.put("opseq", vo.getOpseq());
		zjbtrnParMap.put("pline", vo.getPline());
		zjbtrnParMap.put("mchid", vo.getMchid());
		zjbtrnParMap.put("jstat", "20");
		List<ZJBTRNVO> zjbtrList = zjbtrnService.queryZjbtrnByMap(zjbtrnParMap);
		if(zjbtrList.size()>0){
			ZJBTRNVO zjbtrnvo = zjbtrList.get(0);
			zjbtrnvo.setJstat("50");
			String nowDate = Utils.formateDate(null, "yyMMdd");
			String nowTime = Utils.formateDate(null, "HHmmss");
			zjbtrnvo.setJtedt(BigDecimal.valueOf(Long.valueOf("1"+nowDate)));
			zjbtrnvo.setJtetm(BigDecimal.valueOf(Long.valueOf(nowTime)));
			SimpleDateFormat sf = new SimpleDateFormat("yyMMddHHmmss");

			String endDT = zjbtrnvo.getJtedt().toString().substring(1)+nowTime;
			String staTm = "000000"+zjbtrnvo.getJtstm().toString();
			staTm = staTm.substring(staTm.length() - 6, staTm.length());
			String staDT = zjbtrnvo.getJtsdt().toString().substring(1)+staTm;
			String lhrs1 = String.valueOf((sf.parse(endDT).getTime() - sf.parse(staDT).getTime())/(1000d*60d*60d));
			zjbtrnvo.setMhrs1(BigDecimal.valueOf(Double.parseDouble(lhrs1)));

			zjbtrnService.updateZjbtrn(zjbtrnvo);
		}else{
			throw new RuntimeException();
		}

	}
}
