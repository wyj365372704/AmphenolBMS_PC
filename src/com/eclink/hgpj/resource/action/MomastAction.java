package com.eclink.hgpj.resource.action;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.eclink.dfcm.paginator.common.PaginatorUtil;
import com.eclink.dfcm.paginator.tag.PageVO;
import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.resource.biz.XADATAService;
import com.eclink.hgpj.resource.biz.ZBMSCTLService;
import com.eclink.hgpj.resource.biz.ZIPHDRService;
import com.eclink.hgpj.resource.biz.ZITMBXService;
import com.eclink.hgpj.resource.biz.ZITMEXTService;
import com.eclink.hgpj.resource.biz.ZMBD1REPService;
import com.eclink.hgpj.resource.biz.ZWHSUBService;
import com.eclink.hgpj.resource.dao.ibatis.ZITEMBXDaoImpl;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MODATAVO;
import com.eclink.hgpj.resource.vo.MOMASTVO;
import com.eclink.hgpj.resource.vo.MOPORFVO;
import com.eclink.hgpj.resource.vo.MOROUTVO;
import com.eclink.hgpj.resource.vo.POITEMVO;
import com.eclink.hgpj.resource.vo.POMASTVO;
import com.eclink.hgpj.resource.vo.VENNAMVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZBMSRSNVO;
import com.eclink.hgpj.resource.vo.ZBMSU02VO;
import com.eclink.hgpj.resource.vo.ZIPDTLVO;
import com.eclink.hgpj.resource.vo.ZIPHDRVO;
import com.eclink.hgpj.resource.vo.ZIPHSTVO;
import com.eclink.hgpj.resource.vo.ZITEMBXVO;
import com.eclink.hgpj.resource.vo.ZITMEXTVO;
import com.eclink.hgpj.resource.vo.ZMBD1REPVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;
import com.eclink.hgpj.user.biz.AUserService;
import com.eclink.hgpj.util.QRcoderUtil;
import com.eclink.hgpj.util.Utils;
import com.opensymphony.xwork2.ActionContext;

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

	private ZWHSUBService zwhsubService;

	private ZITMEXTService zitmextService;

	private String ordno;

	private String iptyp;

	private String bmsrsn;

	private String house;

	private String data;

	private String isdetail;

	private String cmmt;

	private String chk;

	private List<MOMASTVO> results;


	private String grnno;

	private String input1,input2;

	private String cnote;

	public String getInput1() {
		return input1;
	}

	public void setInput1(String input1) {
		this.input1 = input1;
	}

	public String getInput2() {
		return input2;
	}

	public void setInput2(String input2) {
		this.input2 = input2;
	}

	private ZBMSCTLService zbmsctlService;

	public XADATAService getXadataService() {
		return xadataService;
	}

	public ZBMSCTLService getZbmsctlService() {
		return zbmsctlService;
	}

	public void setZbmsctlService(ZBMSCTLService zbmsctlService) {
		this.zbmsctlService = zbmsctlService;
	}

	public void setXadataService(XADATAService xadataService) {
		this.xadataService = xadataService;
	}

	public ZWHSUBService getZwhsubService() {
		return zwhsubService;
	}

	public void setZwhsubService(ZWHSUBService zwhsubService) {
		this.zwhsubService = zwhsubService;
	}

	public ZITMBXService getZitmbxService() {
		return zitmbxService;
	}

	public void setZitmbxService(ZITMBXService zitmbxService) {
		this.zitmbxService = zitmbxService;
	}

	public ZITMEXTService getZitmextService() {
		return zitmextService;
	}

	public void setZitmextService(ZITMEXTService zitmextService) {
		this.zitmextService = zitmextService;
	}

	public MOMASTVO getMomast() {
		return momast;
	}

	public void setMomast(MOMASTVO momast) {
		this.momast = momast;
	}

	public String getGrnno() {
		return grnno;
	}

	public void setGrnno(String grnno) {
		this.grnno = grnno;
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
						count++;
						String hdrno = "IP"+now1+idx.substring(idx.length()-4);
						hdrvo.setIpdno(hdrno);
						hdrvo.setOrdno(ordnot);
						hdrvo.setHouse(rettemp.getFitwh());
						hdrvo.setIptyp("1");
						hdrvo.setDept(rettemp.getDptno());
						hdrvo.setOstat("05");
						hdrvo.setLprt("0");
						hdrvo.setAprst("");
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
				hdrvo.setAprst("");
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
						momast.setOrdnoF(ordnos);
					}else if(momast.getOrdno().indexOf(HGPJConstant.SPLIT_1)>=0){
						String[] ordnos = momast.getOrdno().split(HGPJConstant.SPLIT_1);
						momast.setOrdnoF(ordnos);
					}else{
						momast.setOrdnoF(new String[]{momast.getOrdno()});
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
	public String momastPrint() throws Exception{
		try {	
			ActionContext.getContext().getValueStack().set("grnno", grnno);
			// 获取分页信息
			PageVO page = PaginatorUtil.getPaginator(getRequest());
			// setPagination(role,page);

			// 查询总记录数
			if (page.isQueryTotal()) {
				page.setTotalRecord(0);
			}

			// 分页对象保存至request
			getRequest().setAttribute(HGPJConstant.PAGE_KEY, page);
		} catch (Exception e) {e.printStackTrace();
		log.error("Go to admin resource operation grant page occured error.", e);
		return ERROR;
		}
		return "momastPrint";
	}

	public String toPrintMomast() throws Exception{
		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		numberFormat.setGroupingUsed(false);
		numberFormat.setRoundingMode(RoundingMode.UP);
		numberFormat.setMaximumFractionDigits(1);
		numberFormat.setMinimumFractionDigits(1);
		try {
			List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
			JSONArray jsonArray = JSONObject.fromObject(grnno).getJSONArray("grnnos");
			for(int i = 0;i<jsonArray.size();i++){
				Map<String,Object> resultMap = new HashMap<String, Object>();

				ZBMSCTLVO zbmsctl = new ZBMSCTLVO();
				zbmsctl.setSite((String) getSession().getAttribute("stid"));
				List<ZBMSCTLVO> bmsctlList = zbmsctlService.queryZbmsctl(zbmsctl);
				if(bmsctlList!=null && bmsctlList.size()>0){
					resultMap.put("nmchs", bmsctlList.get(0).getNmchs());
				}

				resultMap.put("printDate", Utils.formateDate(null, "yyyy/MM/dd"));

				MOMASTVO momastvo = new MOMASTVO();
				momastvo.setOrdno(jsonArray.getString(i));
				List<MOMASTVO> momastList = xadataService.queryMomastByordno(momastvo);

				resultMap.put("ordno", momastList.get(0).getOrdno());
				resultMap.put("fitwh", momastList.get(0).getFitwh());
				resultMap.put("fitem", momastList.get(0).getFitem());
				resultMap.put("branch", "branch");

				String qrMessage = "*W"+momastList.get(0).getOrdno();
				String encoderQRCoder = QRcoderUtil.encoderQRCoder(qrMessage, ServletActionContext.getContext().getSession().get("username").toString(),getSession().getServletContext().getRealPath("/"));
				HttpServletRequest request = ServletActionContext.getRequest();
				String path = request.getContextPath(); 
				String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
				resultMap.put("qrcodeurl", basePath+"/"+encoderQRCoder);


				String d= (momastList.get(0).getCrdt()==null || momastList.get(0).getCrdt().doubleValue()==0.0)?"":momastList.get(0).getCrdt().add(BigDecimal.valueOf(19000000)).toString().trim();
				resultMap.put("crdt", d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" "));

				resultMap.put("fdesc", momastList.get(0).getFdesc());
				resultMap.put("fdesc", momastList.get(0).getFdesc());

				ITMSITVO itmsitvo = new ITMSITVO();
				itmsitvo.setHouse((String) getSession().getAttribute("stid"));
				itmsitvo.setItnot9(momastList.get(0).getFitem());
				List<ITMSITVO> itmsitList = xadataService.queryItrvtAll(itmsitvo);
				if(itmsitList.size()>0){
					resultMap.put("umstt9", itmsitList.get(0).getUmstt9());

					ZITMEXTVO zitmextvo = new ZITMEXTVO();
					zitmextvo.setStid(itmsitList.get(0).getHouse());
					zitmextvo.setItnbr(itmsitList.get(0).getItnot9());
					zitmextvo.setItrv(itmsitList.get(0).getItrvt9());
					List<ZITMEXTVO> zitmextList = zitmextService.queryItemExt(zitmextvo);
					if(zitmextList.size()>0){
						resultMap.put("sdesc", zitmextList.get(0).getSdesc());
					}
				}

				resultMap.put("dptno", momastList.get(0).getDptno());
				resultMap.put("quantity", numberFormat.format(momastList.get(0).getOrqty().add(momastList.get(0).getQtdev()).floatValue()));

				d= (momastList.get(0).getSstdt()==null || momastList.get(0).getSstdt().doubleValue()==0.0)?"":momastList.get(0).getSstdt().add(BigDecimal.valueOf(19000000)).toString().trim();
				resultMap.put("sstdt", d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" "));

				d= (momastList.get(0).getOdudt()==null || momastList.get(0).getOdudt().doubleValue()==0.0)?"":momastList.get(0).getOdudt().add(BigDecimal.valueOf(19000000)).toString().trim();
				resultMap.put("odudt", d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" "));

				if(!momastList.get(0).getCono().equals("0")){//如果 MOMAST.CONO <> 0, 表示该生产订单由销售订单创建
					Map<String,String> mbc6repParMap = new HashMap<String, String>();
					mbc6repParMap.put("cono", momastList.get(0).getCono());
					mbc6repParMap.put("ortp", momastList.get(0).getOrtp());
					mbc6repParMap.put("ordnc", momastList.get(0).getOrdnc());
					String c6canb = xadataService.queryMBC6REP(mbc6repParMap);
					String bmcbtx = xadataService.queryBMCBTX(mbc6repParMap);
					mbc6repParMap.put("c6canb", c6canb);
					String cusnm = xadataService.queryCusnm(mbc6repParMap);
					resultMap.put("c6canb", c6canb);
					resultMap.put("bmcbtx", bmcbtx);
					resultMap.put("cusnm", cusnm);

					mbc6repParMap.put("itmsq", momastList.get(0).getItmsq());
					String axhdtx = xadataService.queryAxhdtx(mbc6repParMap);
					resultMap.put("axhdtx", axhdtx);
				}

				//组件信息
				if("1".equals(input1)){

					List<Map<String, String>> modatas = new ArrayList<Map<String,String>>();
					MODATAVO modatavo = new MODATAVO();
					modatavo.setOrdno(momastList.get(0).getOrdno());
					List<MODATAVO> modataList = xadataService.queryModatas(modatavo);
					for(MODATAVO modata:modataList){
						Map modataMap = new HashMap();
						modataMap.put("citem", modata.getCitem());
						modataMap.put("cdesc", modata.getCdesc());

						ITMSITVO itmsitvo2 = new ITMSITVO();
						itmsitvo2.setHouse((String) getSession().getAttribute("stid"));
						itmsitvo2.setItnot9(modata.getCitem());
						List<ITMSITVO> itmsitList2 = xadataService.queryItrvtAll(itmsitvo2);
						if(itmsitList2.size()>0){
							ZITMEXTVO zitmextvo = new ZITMEXTVO();
							zitmextvo.setStid(itmsitList2.get(0).getHouse());
							zitmextvo.setItnbr(itmsitList2.get(0).getItnot9());
							zitmextvo.setItrv(itmsitList2.get(0).getItrvt9());
							List<ZITMEXTVO> zitmextList = zitmextService.queryItemExt(zitmextvo);
							if(zitmextList.size()>0){
								modataMap.put("sdesc", zitmextList.get(0).getSdesc());
							}
						}

						ZITEMBXVO zitembxvo = new ZITEMBXVO();
						zitembxvo.setHouse(modata.getCitwh());
						zitembxvo.setItnbr(modata.getCitem());
						List<ZITEMBXVO> zitembxList = zitmbxService.queryItemBx(zitembxvo);
						if(zitembxList.size()>0){
							modataMap.put("whsub2", zitembxList.get(0).getWhsub2());
							ZWHSUBVO zwhsubvo = new ZWHSUBVO();
							zwhsubvo.setHouse(modata.getCitwh());
							zwhsubvo.setWhsub(zitembxList.get(0).getWhsub2());
							List<ZWHSUBVO> zwhsubList = zwhsubService.queryZwhsub(zwhsubvo);
							if(zwhsubList.size()>0){
								modataMap.put("dsp1", zwhsubList.get(0).getDsp1());
							}
						}


						modataMap.put("unmsr", modata.getUnmsr());
						modataMap.put("qtreq", numberFormat.format(modata.getQtreq().floatValue()));
						modataMap.put("isqty", numberFormat.format(modata.getIsqty().floatValue()));

						modatas.add(modataMap);
					}
					resultMap.put("modatas", modatas);

				}
				//工序信息
				if("1".equals(input2)){
					List<Map<String, String>> morouts = new ArrayList<Map<String,String>>();
					Map<String, String> moroutParMap = new HashMap<String, String>();
					moroutParMap.put("ordno", momastList.get(0).getOrdno());
					List<MOROUTVO> moroutList = xadataService.queryMorout(moroutParMap);
					for(MOROUTVO morout:moroutList){
						Map<String, String> moroutMap = new HashMap<String, String>();
						moroutMap.put("opseq", morout.getOpseq());

						String desc = morout.getOpdsc().trim();
						if(morout.getTbcde().equals("C")){//外协工序
							desc+="<br/>";
							desc+="委外订单号:";
							MOPORFVO moporfvo = new MOPORFVO();
							moporfvo.setMonr(morout.getOrdno());
							moporfvo.setOpsq(morout.getOpseq());
							List<MOPORFVO> moporfList = xadataService.queryMoporfNormal(moporfvo);
							if(moporfList.size()>0){
								desc+=moporfList.get(0).getPonr().trim();//附加上委外订单号
								if(moporfList.get(0).getPonr().trim().startsWith("P")){
									desc+="<br/>";
									desc+="委外供应商:";
									
									Map<String, String> parMap = new HashMap<String, String>();
									parMap.put("ordnoO", moporfList.get(0).getPonr());
									List<POMASTVO> queryPomast = xadataService.queryPomast(parMap);
									if(queryPomast.size()>0){
										desc+=queryPomast.get(0).getVndnr().trim();
									
										parMap.clear();
										parMap.put("vndnr", queryPomast.get(0).getVndnr());
										List<VENNAMVO> vennamList = xadataService.queryVennam(parMap);
										if(vennamList.size()>0){
											desc+=" ";
											desc+=vennamList.get(0).getVn35().trim();
										}
									}
									
									parMap.clear();
									parMap.put("ordno", moporfList.get(0).getPonr());
									parMap.put("house", moporfList.get(0).getWhid());
									parMap.put("poisq", moporfList.get(0).getPisq()+"");
									parMap.put("linsq", moporfList.get(0).getBksq()+"");
									List<POITEMVO> poitemList = xadataService.queryPoitem(parMap);
									if(poitemList.size()>0){
										desc+="<br/>";
										desc+="采购价格:";
										desc+=poitemList.get(0).getCurpr();
										desc+=" ";
										if(poitemList.get(0).getCurid().trim().isEmpty()){
											desc+="CNY";
										}else{
											desc+=poitemList.get(0).getCurid().trim();
										}
									}
//									desc+=moporfList.get(0).getVndr().trim();
								}
							}

							desc+="<br/>";
						}else{//非外协工序
							BigDecimal orderQuantity = momastList.get(0).getOrqty().add(momastList.get(0).getQtdev());
							desc+="<br/>";
							desc+="标准人工时间:";
							double time0 = 0;
							if(morout.getTbcde() == null || morout.getTbcde().equals("")){
								time0+=orderQuantity.multiply(morout.getSrlhu()).floatValue();
							}else if(morout.getTbcde().equals("1")){
								time0+=orderQuantity.multiply(morout.getSrlhu()).divide(BigDecimal.valueOf(10)).floatValue();
							}else if(morout.getTbcde().equals("2")){
								time0+=orderQuantity.multiply(morout.getSrlhu()).divide(BigDecimal.valueOf(100)).floatValue();
							}else if(morout.getTbcde().equals("3")){
								time0+=orderQuantity.multiply(morout.getSrlhu()).divide(BigDecimal.valueOf(1000)).floatValue();
							}else if(morout.getTbcde().equals("4")){
								time0+=orderQuantity.multiply(morout.getSrlhu()).divide(BigDecimal.valueOf(10000)).floatValue();
							}else if(morout.getTbcde().equals("P")){
								time0+=orderQuantity.divide(morout.getSrlhu()).floatValue();
							}else if(morout.getTbcde().equals("M")){
								time0+=orderQuantity.multiply(morout.getSrlhu()).divide(BigDecimal.valueOf(60)).floatValue();
							}
							desc+=numberFormat.format(time0);
							desc+="小时";
							desc+="<br/>";
							desc+="标准机器时间:";
							double time = 0.0;
							if(morout.getTbcde() == null || morout.getTbcde().equals("")){
								time+=orderQuantity.multiply(morout.getSrmhu()).floatValue();
							}else if(morout.getTbcde().equals("1")){
								time+=orderQuantity.multiply(morout.getSrmhu()).divide(BigDecimal.valueOf(10)).floatValue();
							}else if(morout.getTbcde().equals("2")){
								time+=orderQuantity.multiply(morout.getSrmhu()).divide(BigDecimal.valueOf(100)).floatValue();
							}else if(morout.getTbcde().equals("3")){
								time+=orderQuantity.multiply(morout.getSrmhu()).divide(BigDecimal.valueOf(1000)).floatValue();
							}else if(morout.getTbcde().equals("4")){
								time+=orderQuantity.multiply(morout.getSrmhu()).divide(BigDecimal.valueOf(10000)).floatValue();
							}else if(morout.getTbcde().equals("P")){
								time+=orderQuantity.divide(morout.getSrmhu()).floatValue();
							}else if(morout.getTbcde().equals("M")){
								time+=orderQuantity.multiply(morout.getSrmhu()).divide(BigDecimal.valueOf(60)).floatValue();
							};
							desc+=numberFormat.format(time);
							desc+="小时";
							desc+="<br/>";
						}
						desc+="工序附加说明:";
						Map<String, String> parMap = new HashMap<String, String>();
						parMap.put("ordno", morout.getOrdno());
						parMap.put("opseq", morout.getOpseq());
						String aadesc = xadataService.queryADDSC(parMap);
						desc+=aadesc;
						moroutMap.put("desc", desc);
						morouts.add(moroutMap);

						Map xamap0 = new HashMap();
						xamap0.put("sluserId", this.getSession().getServletContext().getAttribute("sluserId"));
						xamap0.put("slpassword", this.getSession().getServletContext().getAttribute("slpassword"));
						xamap0.put("slurl", this.getSession().getServletContext().getAttribute("slurl"));
						xamap0.put("order", momastList.get(0).getOrdno());

						Utils.systemLinkOrder(xamap0);
						String retStr =(String)xamap0.get("systemLinkStr");
						System.out.println("Tw:"+retStr);
						String errorStr1 = retStr.substring(retStr.indexOf("hasErrors"), retStr.indexOf("hasErrors")+17);
						String warnStr2 = retStr.substring(retStr.indexOf("hasWarnings"), retStr.indexOf("hasWarnings")+19);
						if(errorStr1.indexOf("true")>=0){
							throw new RuntimeException();
						}
					}
					resultMap.put("morouts", morouts);
					resultMap.put("cnote", cnote);
				}

				results.add(resultMap);
			}
			ActionContext.getContext().getValueStack().set("results", results);
			return "toPrintMomast";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR;
		}

	}
	
	
	
	public String toPrintMomastStep() throws Exception{
		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		numberFormat.setGroupingUsed(false);
		numberFormat.setRoundingMode(RoundingMode.UP);
		numberFormat.setMaximumFractionDigits(1);
		numberFormat.setMinimumFractionDigits(1);
		try {
			List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
			JSONArray jsonArray = JSONObject.fromObject(grnno).getJSONArray("grnnos");
			for(int i = 0;i<jsonArray.size();i++){
				Map<String,Object> resultMap = new HashMap<String, Object>();

				ZBMSCTLVO zbmsctl = new ZBMSCTLVO();
				zbmsctl.setSite((String) getSession().getAttribute("stid"));
				List<ZBMSCTLVO> bmsctlList = zbmsctlService.queryZbmsctl(zbmsctl);
				if(bmsctlList!=null && bmsctlList.size()>0){
					resultMap.put("nmchs", bmsctlList.get(0).getNmchs());
				}

				resultMap.put("printDate", Utils.formateDate(null, "yyyy/MM/dd"));

				MOMASTVO momastvo = new MOMASTVO();
				momastvo.setOrdno(jsonArray.getString(i));
				List<MOMASTVO> momastList = xadataService.queryMomastByordno(momastvo);

				resultMap.put("ordno", momastList.get(0).getOrdno());
				resultMap.put("fitwh", momastList.get(0).getFitwh());
				resultMap.put("fitem", momastList.get(0).getFitem());
				resultMap.put("branch", "branch");

				String qrMessage = "*W"+momastList.get(0).getOrdno().trim();
				qrMessage+="*M"+momastList.get(0).getFitwh().trim();
				qrMessage+="*B"+momastList.get(0).getFitwh().trim();
				String encoderQRCoder = QRcoderUtil.encoderQRCoder(qrMessage, ServletActionContext.getContext().getSession().get("username").toString(),getSession().getServletContext().getRealPath("/"));
				HttpServletRequest request = ServletActionContext.getRequest();
				String path = request.getContextPath(); 
				String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
				resultMap.put("qrcodeurl", basePath+"/"+encoderQRCoder);


				String d= (momastList.get(0).getCrdt()==null || momastList.get(0).getCrdt().doubleValue()==0.0)?"":momastList.get(0).getCrdt().add(BigDecimal.valueOf(19000000)).toString().trim();
				resultMap.put("crdt", d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" "));

				resultMap.put("fdesc", momastList.get(0).getFdesc());
				resultMap.put("fdesc", momastList.get(0).getFdesc());

				ITMSITVO itmsitvo = new ITMSITVO();
				itmsitvo.setHouse((String) getSession().getAttribute("stid"));
				itmsitvo.setItnot9(momastList.get(0).getFitem());
				List<ITMSITVO> itmsitList = xadataService.queryItrvtAll(itmsitvo);
				if(itmsitList.size()>0){
					resultMap.put("umstt9", itmsitList.get(0).getUmstt9());

					ZITMEXTVO zitmextvo = new ZITMEXTVO();
					zitmextvo.setStid(itmsitList.get(0).getHouse());
					zitmextvo.setItnbr(itmsitList.get(0).getItnot9());
					zitmextvo.setItrv(itmsitList.get(0).getItrvt9());
					List<ZITMEXTVO> zitmextList = zitmextService.queryItemExt(zitmextvo);
					if(zitmextList.size()>0){
						resultMap.put("sdesc", zitmextList.get(0).getSdesc());
					}
				}

				/*resultMap.put("dptno", momastList.get(0).getDptno());*/
				resultMap.put("quantity", numberFormat.format(momastList.get(0).getOrqty().add(momastList.get(0).getQtdev()).floatValue()));

				/*d= (momastList.get(0).getSstdt()==null || momastList.get(0).getSstdt().doubleValue()==0.0)?"":momastList.get(0).getSstdt().add(BigDecimal.valueOf(19000000)).toString().trim();
				resultMap.put("sstdt", d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" "));

				d= (momastList.get(0).getOdudt()==null || momastList.get(0).getOdudt().doubleValue()==0.0)?"":momastList.get(0).getOdudt().add(BigDecimal.valueOf(19000000)).toString().trim();
				resultMap.put("odudt", d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" "));*/

	/*			if(!momastList.get(0).getCono().equals("0")){//如果 MOMAST.CONO <> 0, 表示该生产订单由销售订单创建
					Map<String,String> mbc6repParMap = new HashMap<String, String>();
					mbc6repParMap.put("cono", momastList.get(0).getCono());
					mbc6repParMap.put("ortp", momastList.get(0).getOrtp());
					mbc6repParMap.put("ordnc", momastList.get(0).getOrdnc());
					String c6canb = xadataService.queryMBC6REP(mbc6repParMap);
					String bmcbtx = xadataService.queryBMCBTX(mbc6repParMap);
					mbc6repParMap.put("c6canb", c6canb);
					String cusnm = xadataService.queryCusnm(mbc6repParMap);
					resultMap.put("c6canb", c6canb);
					resultMap.put("bmcbtx", bmcbtx);
					resultMap.put("cusnm", cusnm);

					mbc6repParMap.put("itmsq", momastList.get(0).getItmsq());
					String axhdtx = xadataService.queryAxhdtx(mbc6repParMap);
					resultMap.put("axhdtx", axhdtx);
				}*/

			
				//工序信息
				{
					List<Map<String, String>> morouts = new ArrayList<Map<String,String>>();
					Map<String, String> moroutParMap = new HashMap<String, String>();
					moroutParMap.put("ordno", momastList.get(0).getOrdno());
					List<MOROUTVO> moroutList = xadataService.queryMorout(moroutParMap);
					for(MOROUTVO morout:moroutList){
						Map<String, String> moroutMap = new HashMap<String, String>();
						moroutMap.put("opseq", morout.getOpseq());

						String desc = morout.getOpdsc().trim();
						if(morout.getTbcde().equals("C")){//外协工序
							desc+="<br/>";
							desc+="委外订单号:";
							MOPORFVO moporfvo = new MOPORFVO();
							moporfvo.setMonr(morout.getOrdno());
							moporfvo.setOpsq(morout.getOpseq());
							List<MOPORFVO> moporfList = xadataService.queryMoporfNormal(moporfvo);
							if(moporfList.size()>0){
								desc+=moporfList.get(0).getPonr().trim();//附加上委外订单号
								if(moporfList.get(0).getPonr().trim().startsWith("P")){
									desc+="<br/>";
									desc+="委外供应商:";
									
									Map<String, String> parMap = new HashMap<String, String>();
									parMap.put("ordnoO", moporfList.get(0).getPonr());
									List<POMASTVO> queryPomast = xadataService.queryPomast(parMap);
									if(queryPomast.size()>0){
										desc+=queryPomast.get(0).getVndnr().trim();
									
										parMap.clear();
										parMap.put("vndnr", queryPomast.get(0).getVndnr());
										List<VENNAMVO> vennamList = xadataService.queryVennam(parMap);
										if(vennamList.size()>0){
											desc+=" ";
											desc+=vennamList.get(0).getVn35().trim();
										}
									}
									
									parMap.clear();
									parMap.put("ordno", moporfList.get(0).getPonr());
									parMap.put("house", moporfList.get(0).getWhid());
									parMap.put("poisq", moporfList.get(0).getPisq()+"");
									parMap.put("linsq", moporfList.get(0).getBksq()+"");
									List<POITEMVO> poitemList = xadataService.queryPoitem(parMap);
									if(poitemList.size()>0){
										desc+="<br/>";
										desc+="采购价格:";
										desc+=poitemList.get(0).getCurpr();
										desc+=" ";
										if(poitemList.get(0).getCurid().trim().isEmpty()){
											desc+="CNY";
										}else{
											desc+=poitemList.get(0).getCurid().trim();
										}
									}
//									desc+=moporfList.get(0).getVndr().trim();
								}
							}

							desc+="<br/>";
						}else{//非外协工序
							BigDecimal orderQuantity = momastList.get(0).getOrqty().add(momastList.get(0).getQtdev());
							desc+="<br/>";
							desc+="标准人工时间:";
							double time0 = 0;
							if(morout.getTbcde() == null || morout.getTbcde().equals("")){
								time0+=orderQuantity.multiply(morout.getSrlhu()).floatValue();
							}else if(morout.getTbcde().equals("1")){
								time0+=orderQuantity.multiply(morout.getSrlhu()).divide(BigDecimal.valueOf(10)).floatValue();
							}else if(morout.getTbcde().equals("2")){
								time0+=orderQuantity.multiply(morout.getSrlhu()).divide(BigDecimal.valueOf(100)).floatValue();
							}else if(morout.getTbcde().equals("3")){
								time0+=orderQuantity.multiply(morout.getSrlhu()).divide(BigDecimal.valueOf(1000)).floatValue();
							}else if(morout.getTbcde().equals("4")){
								time0+=orderQuantity.multiply(morout.getSrlhu()).divide(BigDecimal.valueOf(10000)).floatValue();
							}else if(morout.getTbcde().equals("P")){
								time0+=orderQuantity.divide(morout.getSrlhu()).floatValue();
							}else if(morout.getTbcde().equals("M")){
								time0+=orderQuantity.multiply(morout.getSrlhu()).divide(BigDecimal.valueOf(60)).floatValue();
							}
							desc+=numberFormat.format(time0);
							desc+="小时";
							desc+="<br/>";
							desc+="标准机器时间:";
							double time = 0.0;
							if(morout.getTbcde() == null || morout.getTbcde().equals("")){
								time+=orderQuantity.multiply(morout.getSrmhu()).floatValue();
							}else if(morout.getTbcde().equals("1")){
								time+=orderQuantity.multiply(morout.getSrmhu()).divide(BigDecimal.valueOf(10)).floatValue();
							}else if(morout.getTbcde().equals("2")){
								time+=orderQuantity.multiply(morout.getSrmhu()).divide(BigDecimal.valueOf(100)).floatValue();
							}else if(morout.getTbcde().equals("3")){
								time+=orderQuantity.multiply(morout.getSrmhu()).divide(BigDecimal.valueOf(1000)).floatValue();
							}else if(morout.getTbcde().equals("4")){
								time+=orderQuantity.multiply(morout.getSrmhu()).divide(BigDecimal.valueOf(10000)).floatValue();
							}else if(morout.getTbcde().equals("P")){
								time+=orderQuantity.divide(morout.getSrmhu()).floatValue();
							}else if(morout.getTbcde().equals("M")){
								time+=orderQuantity.multiply(morout.getSrmhu()).divide(BigDecimal.valueOf(60)).floatValue();
							};
							desc+=numberFormat.format(time);
							desc+="小时";
							desc+="<br/>";
						}
						desc+="工序附加说明:";
						Map<String, String> parMap = new HashMap<String, String>();
						parMap.put("ordno", morout.getOrdno());
						parMap.put("opseq", morout.getOpseq());
						String aadesc = xadataService.queryADDSC(parMap);
						desc+=aadesc;
						moroutMap.put("desc", desc);
						morouts.add(moroutMap);

						Map xamap0 = new HashMap();
						xamap0.put("sluserId", this.getSession().getServletContext().getAttribute("sluserId"));
						xamap0.put("slpassword", this.getSession().getServletContext().getAttribute("slpassword"));
						xamap0.put("slurl", this.getSession().getServletContext().getAttribute("slurl"));
						xamap0.put("order", momastList.get(0).getOrdno());

						Utils.systemLinkOrder(xamap0);
						String retStr =(String)xamap0.get("systemLinkStr");
						System.out.println("Tw:"+retStr);
						String errorStr1 = retStr.substring(retStr.indexOf("hasErrors"), retStr.indexOf("hasErrors")+17);
						String warnStr2 = retStr.substring(retStr.indexOf("hasWarnings"), retStr.indexOf("hasWarnings")+19);
						if(errorStr1.indexOf("true")>=0){
							throw new RuntimeException();
						}
					}
					resultMap.put("morouts", morouts);
					resultMap.put("cnote", cnote);
				}
				results.add(resultMap);
			}
			ActionContext.getContext().getValueStack().set("results", results);
			return "toPrintMomastStep";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR;
		}

	}

	public String getCnote() {
		return cnote;
	}

	public void setCnote(String cnote) {
		this.cnote = cnote;
	}
}
