package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.ZJBTRNDao;
import com.eclink.hgpj.resource.dao.ZJOBEMPDao;
import com.eclink.hgpj.resource.dao.ZJOBMCHDao;
import com.eclink.hgpj.resource.dao.ZMOJOBDao;
import com.eclink.hgpj.resource.dao.ZWHSUBDao;
import com.eclink.hgpj.resource.vo.SHPDSKVO;
import com.eclink.hgpj.resource.vo.ZEMPMSTVO;
import com.eclink.hgpj.resource.vo.ZJBTRNVO;
import com.eclink.hgpj.resource.vo.ZJOBEMPVO;
import com.eclink.hgpj.resource.vo.ZJOBMCHVO;
import com.eclink.hgpj.resource.vo.ZMCHMSTVO;
import com.eclink.hgpj.resource.vo.ZMOJOBVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;
import com.eclink.hgpj.user.biz.AUserService;
import com.eclink.hgpj.user.vo.AUserVO;
import com.eclink.hgpj.util.Utils;

/**
 * MenuServiceImpl.java
 *
 * @Title: 菜单资源业务实现类
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class ZMOJOBServiceImpl implements ZMOJOBService {

	private ZMOJOBDao zmojobDao;

	private ZJOBEMPService  zjobempService;
	private ZJOBMCHService zjobmchService;
	private SHPDSKService shpdskService;
	private ZJBTRNService zjbtrnService;
	private AUserService auserService;
	public ZMOJOBDao getZmojobDao() {
		return zmojobDao;
	}

	public void setZmojobDao(ZMOJOBDao zmojobDao) {
		this.zmojobDao = zmojobDao;
	}

	public ZJOBEMPService getZjobempService() {
		return zjobempService;
	}

	public void setZjobempService(ZJOBEMPService zjobempService) {
		this.zjobempService = zjobempService;
	}

	public SHPDSKService getShpdskService() {
		return shpdskService;
	}

	public AUserService getAuserService() {
		return auserService;
	}

	public void setAuserService(AUserService auserService) {
		this.auserService = auserService;
	}

	public void setShpdskService(SHPDSKService shpdskService) {
		this.shpdskService = shpdskService;
	}

	public ZJOBMCHService getZjobmchService() {
		return zjobmchService;
	}

	public void setZjobmchService(ZJOBMCHService zjobmchService) {
		this.zjobmchService = zjobmchService;
	}

	@Override
	public List<ZMOJOBVO> queryZmojobByMap(Map map) throws Exception {
		return zmojobDao.queryZmojobByMap(map);
	}

	@Override
	public String queryMaxIndex(String string) throws Exception {
		return zmojobDao.queryMaxIndex(string);
	}

	public ZJBTRNService getZjbtrnService() {
		return zjbtrnService;
	}

	public void setZjbtrnService(ZJBTRNService zjbtrnService) {
		this.zjbtrnService = zjbtrnService;
	}

	@Override
	public void addNewJob(ZMOJOBVO vo, List<ZJOBEMPVO> zjobempList,
			List<ZJOBMCHVO> zjobmchList) throws Exception {
		zmojobDao.insertZmojob(vo);
		
		for(ZJOBEMPVO zjobempvo:zjobempList){
			zjobempService.insertZjobemp(zjobempvo);
		}
		for(ZJOBMCHVO zjobmchvo:zjobmchList){
			zjobmchService.insertZjobmch(zjobmchvo);
		}
	}

	@Override
	public void finishZmojob(ZMOJOBVO zmojobvo,String username,String step_quantity,String artificial_hours_after,String machine_hours_after,String abnormal_hours,String abnormal_reason)throws Exception{
		Map<String,String> zjobempParMap = new HashMap<String, String>();
		zjobempParMap.put("mjdno", zmojobvo.getMjdno());
		zjobempParMap.put("jstat", "1");
		List<ZJOBEMPVO>zjobempList =  zjobempService.queryByMapWithEmpName(zjobempParMap);
		for(ZJOBEMPVO zjobempvo:zjobempList){
			zjobempvo.setJstat("0");
			zjobempService.updateZjobempJstat(zjobempvo);
		}

		Map<String,String> zjobmchParMap = new HashMap<String, String>();
		zjobmchParMap.put("mjdno", zmojobvo.getMjdno());
		zjobmchParMap.put("jstat", "1");
		List<ZJOBMCHVO>zjobmchList =  zjobmchService.queryByMapWithEmpName(zjobmchParMap);
		for(ZJOBMCHVO zjobmchvo:zjobmchList){
			zjobmchvo.setJstat("0");
			zjobmchService.updateZjobmchJstat(zjobmchvo);
		}

		Map<String, String> zjbtrnParMap = new HashMap<String, String>();
		zjbtrnParMap.put("mjdno", zmojobvo.getMjdno());
		double artificial_hours = 0d,machine_hours = 0d;
		SimpleDateFormat sf = new SimpleDateFormat("yyMMddHHmmss");
		List<ZJBTRNVO> zjbtrnList = zjbtrnService.queryZjbtrnByMap(zjbtrnParMap);
		BigDecimal enddt = null,endtm = null;
		for(ZJBTRNVO zjbtrnvo:zjbtrnList){

			String staTm = "000000"+zjbtrnvo.getJtstm().toString();
			staTm = staTm.substring(staTm.length() - 6, staTm.length());
			String staDT = zjbtrnvo.getJtsdt().toString().substring(1)+staTm;

			String endTm ="";
			String endDt ="";
			endTm = "000000"+zjbtrnvo.getJtetm().toString();
			endTm = endTm.substring(endTm.length() - 6, endTm.length());
			endDt = zjbtrnvo.getJtedt().toString().substring(1)+endTm;
			enddt = zjbtrnvo.getJtedt();
			endtm = zjbtrnvo.getJtetm();

			if(zjbtrnvo.getJttyp().equals("L")){
				artificial_hours+=(sf.parse(endDt).getTime() - sf.parse(staDT).getTime())/(1000d*60d*60d);
			}else{
				machine_hours+=(sf.parse(endDt).getTime() - sf.parse(staDT).getTime())/(1000d*60d*60d);
			}
		}
		zmojobvo.setOstat("50");
		zmojobvo.setJbqty(BigDecimal.valueOf(Double.valueOf(step_quantity)));
		zmojobvo.setRlhrs1(BigDecimal.valueOf(artificial_hours));
		zmojobvo.setRlhrs2(BigDecimal.valueOf(Double.valueOf(artificial_hours_after)));
		zmojobvo.setRmhrs1(BigDecimal.valueOf(machine_hours));
		zmojobvo.setRmhrs2(BigDecimal.valueOf(Double.valueOf(machine_hours_after)));
		zmojobvo.setAbrsn(abnormal_reason);
		zmojobvo.setAblhr(BigDecimal.valueOf(Double.valueOf(abnormal_hours)));
		zmojobvo.setFshpac("1");
		if(enddt == null){
			String nowDate = Utils.formateDate(null, "yyMMdd");
			zmojobvo.setJenddt(BigDecimal.valueOf(Long.valueOf("1"+nowDate)));
		}else{
			zmojobvo.setJenddt(enddt);
		}
		if(endtm == null){
			String nowTime = Utils.formateDate(null, "HHmmss");
			zmojobvo.setJendtm(BigDecimal.valueOf(Long.valueOf(nowTime)));
		}else{
			zmojobvo.setJendtm(endtm);
		}
		zmojobDao.updateZmojob(zmojobvo);
		
		/*
		 * SHKDSP数据库操作,日志问题未能解决,暂时注释。goodluck~！
		 * 
		 * try {
			shpdskService.createTable();
		} catch (Exception e) {
		}
		SHPDSKVO shpdskvo = new SHPDSKVO();
		shpdskvo.setRcdcd("PA");
		shpdskvo.setOrdno(zmojobvo.getOrdno());
		shpdskvo.setOpseq(zmojobvo.getOpseq());
		shpdskvo.setRuncd("R");
		shpdskvo.setLbtim(zmojobvo.getRlhrs2());
		shpdskvo.setMatim(zmojobvo.getRmhrs2());
		shpdskvo.setQcomp(zmojobvo.getJbqty());
		shpdskvo.setQscrp(new BigDecimal(0));
		shpdskvo.setRfno(zmojobvo.getMjdno().substring(2, 12));
		shpdskvo.setOcmpc("0");
		
		AUserVO userVO = auserService.queryUserByUserName(username);
		
		
		shpdskvo.setEmpno(new BigDecimal(userVO.getXsBda()));
		
		shpdskvo.setShift("1");
		
		String now1 = Utils.formateDate(null, "MMddyy");
		shpdskvo.setTdate(BigDecimal.valueOf(Long.valueOf(now1)) );
		
		shpdskService.insertShpdsk(shpdskvo);*/
	}
}
