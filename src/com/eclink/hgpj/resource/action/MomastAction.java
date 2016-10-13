package com.eclink.hgpj.resource.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.eclink.dfcm.paginator.common.PaginatorUtil;
import com.eclink.dfcm.paginator.tag.PageVO;
import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.resource.biz.XADATAService;
import com.eclink.hgpj.resource.biz.ZIPHDRService;
import com.eclink.hgpj.resource.biz.ZITMBXService;
import com.eclink.hgpj.resource.biz.ZMBD1REPService;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MODATAVO;
import com.eclink.hgpj.resource.vo.MOMASTVO;
import com.eclink.hgpj.resource.vo.ZBMSRSNVO;
import com.eclink.hgpj.resource.vo.ZBMSU02VO;
import com.eclink.hgpj.resource.vo.ZIPDTLVO;
import com.eclink.hgpj.resource.vo.ZIPHDRVO;
import com.eclink.hgpj.resource.vo.ZIPHSTVO;
import com.eclink.hgpj.resource.vo.ZITEMBXVO;
import com.eclink.hgpj.resource.vo.ZMBD1REPVO;
import com.eclink.hgpj.user.biz.AUserService;
import com.eclink.hgpj.util.Utils;

/**
 * GrantAction.java
 *
 * @Title: 资源授权控制类
 * @Description: 
 * @version 1.0
 * @date May 29, 2013 4:44:36 PM
 *
 */
public class MomastAction extends BaseAction {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(MomastAction.class);
	

	private XADATAService xadataService;
	
	private ZIPHDRService ziphdrService;
	
	private ZMBD1REPService zmbd1repService;
	
	private MOMASTVO momast;
	
	private AUserService auserService;
	
	private ZITMBXService zitmbxService;
	
	private String ordno;
	
	private String iptyp;
	
	private String bmsrsn;
	
	private String house;
	
	private String data;
	
	private String isdetail;
	
	private String cmmt;
	
	private String chk;
	
	private List<MOMASTVO> results;
	
	public XADATAService getXadataService() {
		return xadataService;
	}

	public void setXadataService(XADATAService xadataService) {
		this.xadataService = xadataService;
	}

	public ZITMBXService getZitmbxService() {
		return zitmbxService;
	}

	public void setZitmbxService(ZITMBXService zitmbxService) {
		this.zitmbxService = zitmbxService;
	}

	public MOMASTVO getMomast() {
		return momast;
	}

	public void setMomast(MOMASTVO momast) {
		this.momast = momast;
	}

	public List<MOMASTVO> getResults() {
		return results;
	}

	public void setResults(List<MOMASTVO> results) {
		this.results = results;
	}

	public ZIPHDRService getZiphdrService() {
		return ziphdrService;
	}

	public void setZiphdrService(ZIPHDRService ziphdrService) {
		this.ziphdrService = ziphdrService;
	}

	public String getOrdno() {
		return ordno;
	}

	public void setOrdno(String ordno) {
		this.ordno = ordno;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getIptyp() {
		return iptyp;
	}

	public void setIptyp(String iptyp) {
		this.iptyp = iptyp;
	}

	public String getHouse() {
		if(house!=null){
			return house.trim();
		}else{
			return "";
		}
		
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getIsdetail() {
		return isdetail;
	}

	public void setIsdetail(String isdetail) {
		this.isdetail = isdetail;
	}

	public String getCmmt() {
		return cmmt;
	}

	public void setCmmt(String cmmt) {
		this.cmmt = cmmt;
	}

	public ZMBD1REPService getZmbd1repService() {
		return zmbd1repService;
	}

	public void setZmbd1repService(ZMBD1REPService zmbd1repService) {
		this.zmbd1repService = zmbd1repService;
	}

	public AUserService getAuserService() {
		return auserService;
	}

	public void setAuserService(AUserService auserService) {
		this.auserService = auserService;
	}

	public String getBmsrsn() {
		return bmsrsn;
	}

	public void setBmsrsn(String bmsrsn) {
		this.bmsrsn = bmsrsn;
	}

	public String getChk() {
		return chk;
	}

	public void setChk(String chk) {
		this.chk = chk;
	}

	public String addZiphdrM()throws Exception {
		try {
			if(chk!=null && chk.length()>0){
				List<ZIPHDRVO> plist = new ArrayList<ZIPHDRVO>();
				String[] chks=chk.split("-");
				String now1 = Utils.formateDate(null, "yyMMdd");
				String now2 = Utils.formateDate(null, "HHmmss");
				String userDept = "";
				String username = (String)this.getSession().getAttribute("username");
				List<ZBMSU02VO> dps = this.auserService.queryDeptByUserName(username);
				if(dps!=null && dps.size()>0){
					for(int i=0;i<dps.size();i++){
						ZBMSU02VO dp = dps.get(i);
						if(dp.getDflt()!=null && "1".equals(dp.getDflt().trim())){
//							vo.setPlant(dp.getPlant());
//							vo.setTwdp1(dp.getDept());
							userDept = dp.getDept();
						}
					}
				}
				
				int count = this.ziphdrService.getCoutsByDt(BigDecimal.valueOf(Long.valueOf("1"+now1)));
				for(int j=0;j<chks.length;j++){
					String ordnot=chks[j];
					if(!ordnot.trim().equals("")){
						MOMASTVO mastvo = new MOMASTVO();
						mastvo.setOrdno(ordnot.trim());
						List<MOMASTVO> resultsT = this.xadataService.queryMomastByordno(mastvo);
						MOMASTVO rettemp = resultsT.get(0);
						MODATAVO vo = new MODATAVO();
						vo.setOrdno(ordnot.trim());
						vo.setCitwh(rettemp.getFitwh());
						ZIPHDRVO hdrvo = new ZIPHDRVO();
						
						String idx = "000"+(count+1);
						String hdrno = "IP"+now1+idx.substring(idx.length()-4);
						hdrvo.setIpdno(hdrno);
						hdrvo.setOrdno(ordnot);
						hdrvo.setHouse(rettemp.getFitwh());
						hdrvo.setIptyp("1");
						hdrvo.setDept(rettemp.getDptno());
						hdrvo.setOstat("05");
						hdrvo.setLprt("0");
						hdrvo.setArpst("");
						hdrvo.setAprus("");
						hdrvo.setAprdp("");
						hdrvo.setAprdt(BigDecimal.valueOf(0));
						hdrvo.setAprtm(BigDecimal.valueOf(0));
						
						hdrvo.setIpus1(username);
						hdrvo.setIpdp1(userDept);
						hdrvo.setIpdt1(BigDecimal.valueOf(Long.valueOf("1"+now1)));
						hdrvo.setIptm1(BigDecimal.valueOf(Long.valueOf(now2)));
						hdrvo.setCmmt("批量创建");
						String striptyp="IP01";
						Map rpmap = new HashMap();
						rpmap.put("bmstyp", striptyp);
						
						List<ZBMSRSNVO> list = this.ziphdrService.getReason(rpmap);
						if(list!=null && list.size()>0){
							ZBMSRSNVO rsntemp = list.get(0);
							hdrvo.setBmstyp(striptyp);
							hdrvo.setBmsrsn(rsntemp.getBmsrsn());
							hdrvo.setFapr(rsntemp.getFapr());
						}else{
							hdrvo.setBmstyp(striptyp);
							hdrvo.setBmsrsn("");
							hdrvo.setFapr("0");
						}
						
						hdrvo.setFitem(rettemp.getFitem());
						//正常领料单在这里新增明细，超发和退料需要在领料单界面进行新增明细
						List<ZIPDTLVO> itemList = new ArrayList<ZIPDTLVO>();
//						if("1".equals(iptyp.trim())){
							List<MODATAVO> results = this.xadataService.queryModatas(vo);
							int ipdln = 0;
							for(int i=0;i<results.size();i++){
								List<ZIPHSTVO> subItemList = new ArrayList<ZIPHSTVO>(); 
								MODATAVO temp = results.get(i);
								ZIPDTLVO pvo = new ZIPDTLVO();
								pvo.setOrdno(temp.getOrdno());
								pvo.setCitem(temp.getCitem());
								//该工单该物料的所有领料单的计划数量总和
								double shqty = this.ziphdrService.getAllshqty(pvo);
//								double shqty = 0;
								BigDecimal unqty = rettemp.getOrqty().add(rettemp.getQtdev()).multiply(temp.getQtypre()).add(temp.getIsqty().negate()).add(BigDecimal.valueOf(shqty).negate());
								if(unqty.doubleValue()>0){
									ipdln++;
									ZIPDTLVO ivo = new ZIPDTLVO();
									ivo.setIpdno(hdrno);
									ivo.setIpdln(BigDecimal.valueOf(ipdln));
									ivo.setOrdno(ordnot);
									ivo.setFitem(rettemp.getFitem());
									ivo.setDept(rettemp.getDptno());
									ivo.setCitem(temp.getCitem());
									ivo.setCuom(temp.getUnmsr());
									ivo.setSeqnm(temp.getSeqnm());
									
									ITMSITVO itmsitvo = new ITMSITVO();
									itmsitvo.setHouse(rettemp.getFitwh());
									itmsitvo.setItnot9(temp.getCitem().trim());
									String itrvt = "";
									List<String> itrvts = this.xadataService.queryItrvt(itmsitvo);
									if(itrvts!=null && itrvts.size()>0){
										itrvt=itrvts.get(0);
									}
									ITMRVAVO itmrVo = new ITMRVAVO();
									ITMRVAVO itmrVoT = null;
									itmrVo.setItnbr(temp.getCitem().trim());
									itmrVo.setHouse(rettemp.getFitwh());
									itmrVo.setItrv(itrvt.trim());
									List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
									if(itmrLists!=null && itmrLists.size()>0){
										itmrVoT=itmrLists.get(0);
									}
									
									ivo.setBlcf(itmrVoT==null?"":itmrVoT.getBlcf());
									ivo.setHouse(rettemp.getFitwh());
									ZITEMBXVO bxVO = new ZITEMBXVO();
									bxVO.setHouse(rettemp.getFitwh());
									bxVO.setItnbr(temp.getCitem().trim());
									List<ZITEMBXVO> bxList = this.zitmbxService.queryItemBx(bxVO);
									if(bxList!=null && bxList.size()>0){
										ZITEMBXVO bxvo = bxList.get(0);
										ivo.setWhsub(bxvo.getWhsub1());
										ivo.setLlocn(bxvo.getLlocn1());
									}else{
										ivo.setWhsub("");
										ivo.setLlocn("");
									}
									ZMBD1REPVO prepvo = new ZMBD1REPVO();
									prepvo.setDbcqcd(temp.getUnmsr());
									List<ZMBD1REPVO> repvos = this.zmbd1repService.queryZmbd1erp(prepvo);
									if(repvos!=null && repvos.size()>0){
										ZMBD1REPVO repvo = repvos.get(0);
										ivo.setShqty(Utils.round(unqty, repvo.getDbdcml().intValue(), repvo.getDbrnd().trim()));
									}else{
										ivo.setShqty(unqty);
									}
									ivo.setAcqty(BigDecimal.valueOf(0));
									ivo.setLstat("05");
									ivo.setLprt("0");
									ivo.setLvrfy("0");
									ivo.setIpus2("");
									ivo.setIpdp2("");
									ivo.setIpdt2(BigDecimal.valueOf(0));
									ivo.setIptm2(BigDecimal.valueOf(0));
									ivo.setTurna(temp.getTurna());
									ivo.setTurnc(temp.getTurnc());
									ivo.setTurnn(temp.getTurnn());
									ivo.setUsrsq(temp.getUsrsq());
									
									ZIPHSTVO hvo = new ZIPHSTVO();
									hvo.setIpdno(hdrno);
									hvo.setIpdln(ivo.getIpdln());
									hvo.setIpddl(BigDecimal.valueOf(1));
									hvo.setOrdno(rettemp.getFitwh());
									hvo.setFitem(ivo.getFitem());
									hvo.setDept(ivo.getDept());
									hvo.setCitem(ivo.getCitem());
									hvo.setCum(ivo.getCuom());
									hvo.setHouse(ivo.getHouse());
									hvo.setDlsub("");
									hvo.setDlloc("");
									hvo.setDlqty(BigDecimal.valueOf(0));
									hvo.setDlbch("");
									hvo.setIpus2("");
									hvo.setIpdp2("");
									hvo.setIpdt2(BigDecimal.valueOf(0));
									hvo.setIptm2(BigDecimal.valueOf(0));
									hvo.setDlbch(temp.getLblot());
									
									subItemList.add(hvo);
									
									ivo.setItemList(subItemList);
									
									itemList.add(ivo);
								}else{
									data="工单："+ordnot+"中的物料"+temp.getCitem()+"已领完";
									return "todata";
								}
							}
							hdrvo.setItemList(itemList);
//						}
							plist.add(hdrvo);
					}
					
				}
				if(plist!=null && plist.size()>0){
					this.ziphdrService.insertZiphdrM(plist);
				}
				data="success";
			}
		}catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			data="fail";
			return "todata";
		}
		return "todata";
	}
	/**
	 * 进入生产订单信息页面
	 * @return
	 * @throws Exception
	 */
	public String addZiphdr() throws Exception {
		try {
			if(ordno!=null && !ordno.trim().equals("")){
				MOMASTVO mastvo = new MOMASTVO();
				mastvo.setOrdno(ordno);
				List<MOMASTVO> resultsT = this.xadataService.queryMomastByordno(mastvo);
				MOMASTVO rettemp = resultsT.get(0);
				MODATAVO vo = new MODATAVO();
				vo.setOrdno(ordno.trim());
				vo.setCitwh(house);
				ZIPHDRVO hdrvo = new ZIPHDRVO();
				String now1 = Utils.formateDate(null, "yyMMdd");
				String now2 = Utils.formateDate(null, "HHmmss");
				int count = this.ziphdrService.getCoutsByDt(BigDecimal.valueOf(Long.valueOf("1"+now1)));
				String idx = "000"+(count+1);
				String hdrno = "IP"+now1+idx.substring(idx.length()-4);
				hdrvo.setIpdno(hdrno);
				hdrvo.setOrdno(ordno);
				hdrvo.setHouse(house);
				hdrvo.setIptyp(iptyp);
				hdrvo.setDept(rettemp.getDptno());
				hdrvo.setOstat("05");
				hdrvo.setLprt("0");
				hdrvo.setArpst("");
				hdrvo.setAprus("");
				hdrvo.setAprdp("");
				hdrvo.setAprdt(BigDecimal.valueOf(0));
				hdrvo.setAprtm(BigDecimal.valueOf(0));
				String userDept = "";
				String username = (String)this.getSession().getAttribute("username");
				List<ZBMSU02VO> dps = this.auserService.queryDeptByUserName(username);
				if(dps!=null && dps.size()>0){
					for(int i=0;i<dps.size();i++){
						ZBMSU02VO dp = dps.get(i);
						if(dp.getDflt()!=null && "1".equals(dp.getDflt().trim())){
//							vo.setPlant(dp.getPlant());
//							vo.setTwdp1(dp.getDept());
							userDept = dp.getDept();
						}
					}
				}
				hdrvo.setIpus1(username);
				hdrvo.setIpdp1(userDept);
				hdrvo.setIpdt1(BigDecimal.valueOf(Long.valueOf("1"+now1)));
				hdrvo.setIptm1(BigDecimal.valueOf(Long.valueOf(now2)));
				hdrvo.setCmmt("");
				String striptyp="";
				if("1".equals(iptyp)){
					striptyp="IP01";
				}else if("2".equals(iptyp)){
					striptyp="IP02";
				}else if("3".equals(iptyp)){
					striptyp="IP03";
				}
				Map rpmap = new HashMap();
				rpmap.put("bmstyp", striptyp);
				rpmap.put("bmsrsn", bmsrsn);
				
				List<ZBMSRSNVO> list = this.ziphdrService.getReason(rpmap);
				if(list!=null && list.size()>0){
					ZBMSRSNVO rsntemp = list.get(0);
					hdrvo.setBmstyp(striptyp);
					hdrvo.setBmsrsn(bmsrsn);
					hdrvo.setFapr(rsntemp.getFapr());
				}else{
					hdrvo.setBmstyp(striptyp);
					hdrvo.setBmsrsn("");
					hdrvo.setFapr("0");
				}
				
				hdrvo.setFitem(rettemp.getFitem());
				//正常领料单在这里新增明细，超发和退料需要在领料单界面进行新增明细
				List<ZIPDTLVO> itemList = new ArrayList<ZIPDTLVO>();
				if("1".equals(iptyp.trim())){
					List<MODATAVO> results = this.xadataService.queryModatas(vo);
					int ipdln = 0;
					for(int i=0;i<results.size();i++){
						List<ZIPHSTVO> subItemList = new ArrayList<ZIPHSTVO>(); 
						MODATAVO temp = results.get(i);
						ZIPDTLVO pvo = new ZIPDTLVO();
						pvo.setOrdno(temp.getOrdno());
						pvo.setCitem(temp.getCitem());
						//该工单该物料的所有领料单的计划数量总和
						double shqty = this.ziphdrService.getAllshqty(pvo);
//						double shqty = 0;
						BigDecimal unqty = rettemp.getOrqty().add(rettemp.getQtdev()).multiply(temp.getQtypre()).add(temp.getIsqty().negate()).add(BigDecimal.valueOf(shqty).negate());
						if(unqty.doubleValue()>0){
							ipdln++;
							ZIPDTLVO ivo = new ZIPDTLVO();
							ivo.setIpdno(hdrno);
							ivo.setIpdln(BigDecimal.valueOf(ipdln));
							ivo.setOrdno(ordno);
							ivo.setFitem(rettemp.getFitem());
							ivo.setDept(rettemp.getDptno());
							ivo.setCitem(temp.getCitem());
							ivo.setCuom(temp.getUnmsr());
							ivo.setSeqnm(temp.getSeqnm());
							
							ITMSITVO itmsitvo = new ITMSITVO();
							itmsitvo.setHouse(house);
							itmsitvo.setItnot9(temp.getCitem().trim());
							String itrvt = "";
							List<String> itrvts = this.xadataService.queryItrvt(itmsitvo);
							if(itrvts!=null && itrvts.size()>0){
								itrvt=itrvts.get(0);
							}
							ITMRVAVO itmrVo = new ITMRVAVO();
							ITMRVAVO itmrVoT = null;
							itmrVo.setItnbr(temp.getCitem().trim());
							itmrVo.setHouse(house);
							itmrVo.setItrv(itrvt.trim());
							List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
							if(itmrLists!=null && itmrLists.size()>0){
								itmrVoT=itmrLists.get(0);
							}
							
							ivo.setBlcf(itmrVoT==null?"":itmrVoT.getBlcf());
							ivo.setHouse(house);
							ZITEMBXVO bxVO = new ZITEMBXVO();
							bxVO.setHouse(house);
							bxVO.setItnbr(temp.getCitem().trim());
							List<ZITEMBXVO> bxList = this.zitmbxService.queryItemBx(bxVO);
							if(bxList!=null && bxList.size()>0){
								ZITEMBXVO bxvo = bxList.get(0);
								ivo.setWhsub(bxvo.getWhsub1());
								ivo.setLlocn(bxvo.getLlocn1());
							}else{
								ivo.setWhsub("");
								ivo.setLlocn("");
							}
							ZMBD1REPVO prepvo = new ZMBD1REPVO();
							prepvo.setDbcqcd(temp.getUnmsr());
							List<ZMBD1REPVO> repvos = this.zmbd1repService.queryZmbd1erp(prepvo);
							if(repvos!=null && repvos.size()>0){
								ZMBD1REPVO repvo = repvos.get(0);
								ivo.setShqty(Utils.round(unqty, repvo.getDbdcml().intValue(), repvo.getDbrnd().trim()));
							}else{
								ivo.setShqty(unqty);
							}
							ivo.setAcqty(BigDecimal.valueOf(0));
							ivo.setLstat("05");
							ivo.setLprt("0");
							ivo.setLvrfy("0");
							ivo.setIpus2("");
							ivo.setIpdp2("");
							ivo.setIpdt2(BigDecimal.valueOf(0));
							ivo.setIptm2(BigDecimal.valueOf(0));
							ivo.setTurna(temp.getTurna());
							ivo.setTurnc(temp.getTurnc());
							ivo.setTurnn(temp.getTurnn());
							ivo.setUsrsq(temp.getUsrsq());
							
							ZIPHSTVO hvo = new ZIPHSTVO();
							hvo.setIpdno(hdrno);
							hvo.setIpdln(ivo.getIpdln());
							hvo.setIpddl(BigDecimal.valueOf(1));
							hvo.setOrdno(ordno);
							hvo.setFitem(ivo.getFitem());
							hvo.setDept(ivo.getDept());
							hvo.setCitem(ivo.getCitem());
							hvo.setCum(ivo.getCuom());
							hvo.setHouse(ivo.getHouse());
							hvo.setDlsub("");
							hvo.setDlloc("");
							hvo.setDlqty(BigDecimal.valueOf(0));
							hvo.setDlbch("");
							hvo.setIpus2("");
							hvo.setIpdp2("");
							hvo.setIpdt2(BigDecimal.valueOf(0));
							hvo.setIptm2(BigDecimal.valueOf(0));
							hvo.setDlbch(temp.getLblot());
							
							subItemList.add(hvo);
							
							ivo.setItemList(subItemList);
							
							itemList.add(ivo);
						}
					}
					hdrvo.setItemList(itemList);
				}
				if(itemList!=null && itemList.size()>0){
					this.ziphdrService.insertZiphdr(hdrvo);
					data="success";
				}else{
					//TODO:超领单和退料单处理
					if("2".equals(iptyp.trim())){
//						hdrvo.setBmstyp("IP02");
						hdrvo.setCmmt(cmmt);
						this.ziphdrService.insertZiphdr(hdrvo);
						data="success";
					}else if("3".equals(iptyp.trim())){
//						hdrvo.setBmstyp("IP03");
						hdrvo.setCmmt(cmmt);
						this.ziphdrService.insertZiphdr(hdrvo);
						data="success";
					}else{
						data="other";
					}
					
				}
				
			}
			
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			data="fail";
//			return ERROR;
		}
		return "toReuslt";
	}
	
	/**
	 * 生成领料单
	 * @return
	 * @throws Exception
	 */
	public String toMomast() throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(momast!=null){
				if(momast.getOrdno()!=null && !momast.getOrdno().trim().equals("")){
					if(momast.getOrdno().indexOf(HGPJConstant.SPLIT_2)>=0){
						String[] ordnos = momast.getOrdno().split(HGPJConstant.SPLIT_2);
						momast.setOrdnodown(ordnos[0]);
						momast.setOrdnoup(ordnos[1]);
					}else if(momast.getOrdno().indexOf(HGPJConstant.SPLIT_0)>=0){
						String[] ordnos = momast.getOrdno().split(HGPJConstant.SPLIT_0);
						String temp="";
						for(int i=0;i<ordnos.length;i++){
							if(!ordnos[i].trim().equals("")){
								temp=temp+"'"+ordnos[i].trim()+"',";
							}
						}
						momast.setOrdnoF(temp);
					}else if(momast.getOrdno().indexOf(HGPJConstant.SPLIT_1)>=0){
						String[] ordnos = momast.getOrdno().split(HGPJConstant.SPLIT_1);
						String temp="";
						for(int i=0;i<ordnos.length;i++){
							if(!ordnos[i].trim().equals("")){
								temp=temp+"'"+ordnos[i].trim()+"',";
							}
						}
						momast.setOrdnoF(temp);
					}else{
						momast.setOrdnoF(momast.getOrdno());
					}
				}
//				Date d = sdf.parse(momast.getStartDate());
				if(momast.getStartDate()!=null && !momast.getStartDate().trim().equals("")){
					momast.setStartDateB(BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(momast.getStartDate()), "yyMMdd"))));
				}
				if(momast.getEndDate()!=null && !momast.getEndDate().trim().equals("")){
					momast.setEndDateB(BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(momast.getEndDate()), "yyMMdd"))));
				}
				results = this.xadataService.queryMomast(momast);
			}else{
				momast = new MOMASTVO();
				
				momast.setStartDate(sdf.format(new Date()));
				momast.setEndDate(sdf.format(new Date()));
			}
			if(results!=null && results.size()>0){
				for(int i=0;i<results.size();i++){
					String d= (results.get(i).getSstdt()==null || results.get(i).getSstdt().doubleValue()==0.0)?"":results.get(i).getSstdt().add(BigDecimal.valueOf(19000000)).toString().trim();
					String d2 = (results.get(i).getOdudt()==null || results.get(i).getOdudt().doubleValue()==0.0)?"":results.get(i).getOdudt().add(BigDecimal.valueOf(19000000)).toString().trim();
					results.get(i).setSsstdt(d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" "));
					results.get(i).setSodudt(d2.length()<8?d2: (d2.substring(0, 4)+"-"+d2.substring(4, 6)+"-"+d2.substring(6, 8)+" "));
				}
			}
			//momast.setSsstdt(ssstdt);
			// 获取分页信息
			PageVO page = PaginatorUtil.getPaginator(getRequest());
//			setPagination(role,page);
			
			// 查询总记录数
			if (page.isQueryTotal()) {
				page.setTotalRecord(0);
			}
			
			// 调用业务方法查询列表
//			roleList = roleService.queryRoleList(role);
			
			// 分页对象保存至request
			getRequest().setAttribute(HGPJConstant.PAGE_KEY, page);
			
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "toMomast";
	}
	
}
