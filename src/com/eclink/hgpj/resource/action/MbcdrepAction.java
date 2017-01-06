package com.eclink.hgpj.resource.action;

import java.math.BigDecimal;
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
import com.eclink.hgpj.resource.biz.ZCUSCNSService;
import com.eclink.hgpj.resource.biz.ZIPHDRService;
import com.eclink.hgpj.resource.biz.ZITMBXService;
import com.eclink.hgpj.resource.biz.ZITMEXTService;
import com.eclink.hgpj.resource.biz.ZMBD1REPService;
import com.eclink.hgpj.resource.biz.ZPLHDRService;
import com.eclink.hgpj.resource.biz.ZWHSUBService;
import com.eclink.hgpj.resource.dao.ibatis.ZITEMBXDaoImpl;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MBCDREPVO;
import com.eclink.hgpj.resource.vo.MBS2REPVO;
import com.eclink.hgpj.resource.vo.MODATAVO;
import com.eclink.hgpj.resource.vo.MOMASTVO;
import com.eclink.hgpj.resource.vo.MOPORFVO;
import com.eclink.hgpj.resource.vo.MOROUTVO;
import com.eclink.hgpj.resource.vo.POITEMVO;
import com.eclink.hgpj.resource.vo.VENNAMVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZBMSRSNVO;
import com.eclink.hgpj.resource.vo.ZBMSU02VO;
import com.eclink.hgpj.resource.vo.ZCUSCNSVO;
import com.eclink.hgpj.resource.vo.ZIPDTLVO;
import com.eclink.hgpj.resource.vo.ZIPHDRVO;
import com.eclink.hgpj.resource.vo.ZIPHSTVO;
import com.eclink.hgpj.resource.vo.ZITEMBXVO;
import com.eclink.hgpj.resource.vo.ZITMEXTVO;
import com.eclink.hgpj.resource.vo.ZMBD1REPVO;
import com.eclink.hgpj.resource.vo.ZPLBOXVO;
import com.eclink.hgpj.resource.vo.ZPLDTLVO;
import com.eclink.hgpj.resource.vo.ZPLHDRVO;
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
public class MbcdrepAction extends BaseAction {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(MbcdrepAction.class);


	private XADATAService xadataService;

	private ZIPHDRService ziphdrService;

	private ZMBD1REPService zmbd1repService;

	private MOMASTVO momast;
	
	private MBCDREPVO mbcdrep;
	
	private ZPLHDRVO zplhdr;

	private AUserService auserService;

	private ZITMBXService zitmbxService;

	private ZWHSUBService zwhsubService;

	private ZITMEXTService zitmextService;

	private ZCUSCNSService zcuscnsService;
	
	private ZPLHDRService zplhdrService;
	
	private String ordno;
	
	private String ponum;

	private String house;

	private String data;

	private String isdetail;

	private String cmmt;

	private String chk;
	
	private String startDate;

	private List<MBCDREPVO> results;

	private List<Map> carriers;
	
	private List<Map> salestts;
	
	private List<Map> customers;

	private String grnno;

	private String input1,input2;

	private String cnote;
	
	private String cusno;
	
	private String ordernos;
	
	private String qtys;
	
	private String ddlxs;
	
	private String ddhhs;
	
	private String wlhs;
	
	private String houses;
	
	private String kcdws;
	
	private String ponums;
	
	private String zxdhs;
	
	private String xss;

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

	public ZCUSCNSService getZcuscnsService() {
		return zcuscnsService;
	}

	public void setZcuscnsService(ZCUSCNSService zcuscnsService) {
		this.zcuscnsService = zcuscnsService;
	}

	public ZPLHDRService getZplhdrService() {
		return zplhdrService;
	}

	public void setZplhdrService(ZPLHDRService zplhdrService) {
		this.zplhdrService = zplhdrService;
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

	
	public MBCDREPVO getMbcdrep() {
		return mbcdrep;
	}

	public void setMbcdrep(MBCDREPVO mbcdrep) {
		this.mbcdrep = mbcdrep;
	}

	public List<MBCDREPVO> getResults() {
		return results;
	}

	public void setResults(List<MBCDREPVO> results) {
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

	public String getOrdernos() {
		return ordernos;
	}

	public void setOrdernos(String ordernos) {
		this.ordernos = ordernos;
	}

	public String getQtys() {
		return qtys;
	}

	public void setQtys(String qtys) {
		this.qtys = qtys;
	}

	public String getDdlxs() {
		return ddlxs;
	}

	public void setDdlxs(String ddlxs) {
		this.ddlxs = ddlxs;
	}

	public String getDdhhs() {
		return ddhhs;
	}

	public void setDdhhs(String ddhhs) {
		this.ddhhs = ddhhs;
	}

	public String getWlhs() {
		return wlhs;
	}

	public void setWlhs(String wlhs) {
		this.wlhs = wlhs;
	}

	public String getHouses() {
		return houses;
	}

	public void setHouses(String houses) {
		this.houses = houses;
	}

	public String getKcdws() {
		return kcdws;
	}

	public void setKcdws(String kcdws) {
		this.kcdws = kcdws;
	}

	public String getPonums() {
		return ponums;
	}

	public void setPonums(String ponums) {
		this.ponums = ponums;
	}

	public String getZxdhs() {
		return zxdhs;
	}

	public void setZxdhs(String zxdhs) {
		this.zxdhs = zxdhs;
	}

	public String getXss() {
		return xss;
	}

	public void setXss(String xss) {
		this.xss = xss;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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

	public String getChk() {
		return chk;
	}

	public void setChk(String chk) {
		this.chk = chk;
	}

	public String getPonum() {
		return ponum;
	}

	public void setPonum(String ponum) {
		this.ponum = ponum;
	}

	public ZPLHDRVO getZplhdr() {
		return zplhdr;
	}

	public void setZplhdr(ZPLHDRVO zplhdr) {
		this.zplhdr = zplhdr;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public List<Map> getCarriers() {
		return carriers;
	}

	public void setCarriers(List<Map> carriers) {
		this.carriers = carriers;
	}

	public List<Map> getSalestts() {
		return salestts;
	}

	public void setSalestts(List<Map> salestts) {
		this.salestts = salestts;
	}

	public List<Map> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Map> customers) {
		this.customers = customers;
	}

	public String getCusno() {
		return cusno;
	}

	public void setCusno(String cusno) {
		this.cusno = cusno;
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
	 * 生成领料单
	 * @return
	 * @throws Exception
	 */
	public String toSalesList() throws Exception {
		try {
			int plant =(Integer)this.getSession().getAttribute("plant");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(mbcdrep!=null){	
				System.out.println("mbcdrep.getStartDate()="+mbcdrep.getCda3cd());
				//				Date d = sdf.parse(momast.getStartDate());
				if(mbcdrep.getStartDate()!=null && !mbcdrep.getStartDate().trim().equals("")){
					mbcdrep.setStartDateB(BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(mbcdrep.getStartDate()), "yyMMdd"))));
				}
				if(mbcdrep.getEndDate()!=null && !mbcdrep.getEndDate().trim().equals("")){
					mbcdrep.setEndDateB(BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(mbcdrep.getEndDate()), "yyMMdd"))));
				}
				mbcdrep.setCdaenb(plant+"");
				mbcdrep.setCddccd("1");
				results = this.xadataService.queryMbcdrep(mbcdrep);

			}else{
				mbcdrep = new MBCDREPVO();

				mbcdrep.setStartDate(sdf.format(new Date()));
				mbcdrep.setEndDate(sdf.format(new Date()));
			}
			if(results!=null && results.size()>0){
//				for(int i=0;i<results.size();i++){
//					String d= (results.get(i).getSstdt()==null || results.get(i).getSstdt().doubleValue()==0.0)?"":results.get(i).getSstdt().add(BigDecimal.valueOf(19000000)).toString().trim();
//					String d2 = (results.get(i).getOdudt()==null || results.get(i).getOdudt().doubleValue()==0.0)?"":results.get(i).getOdudt().add(BigDecimal.valueOf(19000000)).toString().trim();
//					results.get(i).setSsstdt(d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" "));
//					results.get(i).setSodudt(d2.length()<8?d2: (d2.substring(0, 4)+"-"+d2.substring(4, 6)+"-"+d2.substring(6, 8)+" "));
//				}
			}
			//momast.setSsstdt(ssstdt);
			// 获取分页信息
			PageVO page = PaginatorUtil.getPaginator(getRequest());
			//			setPagination(role,page);

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
		return "toMbcdrep";
	}
	public String toCreateNotice()throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {	
			String stid = (String)this.getSession().getAttribute("stid");
			// 获取分页信息
			PageVO page = PaginatorUtil.getPaginator(getRequest());
			// setPagination(role,page);
			this.zplhdr = new ZPLHDRVO();
			this.startDate=sdf.format(new Date());
			List<String> templist = this.xadataService.queryCarrier(null);
			if(templist!=null && templist.size()>0){
				this.carriers = new ArrayList<Map>();
				Map map0 = new HashMap();
				map0.put("atf1cd", "");
				map0.put("atghtx", "");
				carriers.add(map0);
				for(int i=0;i<templist.size();i++){
					Map map = new HashMap();
					String vo = templist.get(i);
					String[] sts=vo.split("-");
					map.put("atf1cd", sts[0]);
					map.put("atghtx", sts[1]);
					carriers.add(map);
				}
			}
			
			List<String> templist2 = this.xadataService.queryTransport(null);
			if(templist2!=null && templist2.size()>0){
				this.salestts = new ArrayList<Map>();
				Map map0 = new HashMap();
				map0.put("c8bhst", "");
				map0.put("c8hytx", "");
				salestts.add(map0);
				for(int i=0;i<templist2.size();i++){
					Map map = new HashMap();
					String vo = templist2.get(i);
					String[] sts=vo.split("-");
					map.put("c8bhst", sts[0]);
					map.put("c8hytx", sts[1]);
					salestts.add(map);
				}
			}
			Map parMap = new HashMap();
			parMap.put("plant", (Integer)this.getSession().getAttribute("plant"));
			List<String> templist3 = this.xadataService.queryCusnms(parMap);
			if(templist3!=null && templist3.size()>0){
				this.customers = new ArrayList<Map>();
				Map map0 = new HashMap();
				map0.put("cusno", "");
				map0.put("cusnm", "");
				customers.add(map0);
				for(int i=0;i<templist3.size();i++){
					Map map = new HashMap();
					String vo = templist3.get(i);
					String[] sts=vo.split("-");
					map.put("cusno", sts[0]);
					map.put("cusnm", sts[1]);
					customers.add(map);
				}
			}
			ZBMSCTLVO pvo = new ZBMSCTLVO();
			pvo.setSite(stid);
			List<ZBMSCTLVO> zbmsctls = this.zbmsctlService.queryZbmsctl(pvo);
			if(zbmsctls!=null && zbmsctls.size()>0){
				ZBMSCTLVO rvo = zbmsctls.get(0);
				zplhdr.setSfnam(rvo.getSfnam());
				zplhdr.setSfadd1(rvo.getSfadd1());
				zplhdr.setSfadd2(rvo.getSfadd2());
				zplhdr.setSfcity(rvo.getSfcity());
				zplhdr.setSfctr(rvo.getSfctr());
				zplhdr.setSfzip(rvo.getSfzip());
			}
			
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
		return "toCreateNotice";
	}
	public String createNotice()throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			int plant =(Integer)this.getSession().getAttribute("plant");
			String stid = (String)this.getSession().getAttribute("stid");
			if(ordernos!=null && ordernos.length()>0){
				List<ZIPHDRVO> plist = new ArrayList<ZIPHDRVO>();
				String[] ordernostrs=ordernos.split("-");
				String[] qtysstrs=qtys.split("-");
				String[] ddlxsstr=ddlxs.split("-");
				String[] ddhhsstr=ddhhs.split("-");
				String[] wlhsstr=wlhs.split("-");
				String[] housesstr=houses.split("-");
				String[] kcdwsstr=kcdws.split("-");
				String[] ponumsstr=ponums.split("-");
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

				int count = this.zplhdrService.getCoutsByDt(BigDecimal.valueOf(Long.valueOf("1"+now1)));
				String idx = "000"+(count+1);
				String hdrno = "PL"+now1+idx.substring(idx.length()-4);
//				ZPLHDRVO vo = new ZPLHDRVO();
				this.zplhdr.setPldno(hdrno);
				this.zplhdr.setPlant(""+plant);
				this.zplhdr.setOstat("05");
				this.zplhdr.setInvno(hdrno);
				this.zplhdr.setEtdate(Long.valueOf("1"+Utils.formateDate(sdf.parse(this.startDate), "yyMMdd")));
				this.zplhdr.setPlus1(username);
				this.zplhdr.setPldp1(userDept);
				this.zplhdr.setPldt1(BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(new Date(), "yyMMdd"))));
				this.zplhdr.setPltm1(BigDecimal.valueOf(Long.valueOf(Utils.formateDate(new Date(), "HHmmss"))));
				this.zplhdr.setCmmt("");
				List<ZPLDTLVO> zpldtls = new ArrayList<ZPLDTLVO>();
				List<ZPLBOXVO> zplboxs = new ArrayList<ZPLBOXVO>();
				int index = 1;
				for(int j=0;j<ordernostrs.length;j++){
					String ordnot=ordernostrs[j];
					if(!ordnot.trim().equals("")){
						ZPLDTLVO vo = new ZPLDTLVO();
						ZPLBOXVO boxvo = new ZPLBOXVO();
						vo.setPldno(hdrno);
						vo.setPldln(BigDecimal.valueOf(Long.valueOf(index)));
						vo.setC6aenb(plant+"");
						vo.setC6dccd(ddlxsstr[j]);
						vo.setC6cvnb(ordnot);
						vo.setPonum(ponumsstr[j]);
						vo.setHouse(housesstr[j]);
						vo.setCdfcnb(BigDecimal.valueOf(Long.valueOf(ddhhsstr[j])));
						Map mbadrep = new HashMap();
						mbadrep.put("cono", plant+"");
						mbadrep.put("ortp", ddlxsstr[j].trim());
						mbadrep.put("ordnc", ordnot.trim());
						mbadrep.put("itmsq", Long.valueOf(ddhhsstr[j]));
						String mbadrepstr = this.xadataService.queryMBADREPM(mbadrep);
						if(mbadrepstr!=null && mbadrepstr.trim().length()>0){
							String[] mbadreps = mbadrepstr.split("-");
							vo.setAddrnb(BigDecimal.valueOf(Long.valueOf(mbadreps[0])));
							vo.setAdaasz(BigDecimal.valueOf(Long.valueOf(mbadreps[1])));
						}else{
							vo.setAddrnb(BigDecimal.valueOf(Long.valueOf(0)));
							vo.setAdaasz(BigDecimal.valueOf(Long.valueOf(0)));
						}
						vo.setItnbr(wlhsstr[j]);
						vo.setUnmsr(kcdwsstr[j]);
						vo.setPlqty(BigDecimal.valueOf(Double.valueOf(qtysstrs[j])));
						vo.setFpost("0");
						ZITEMBXVO pvo = new ZITEMBXVO();
						pvo.setItnbr(wlhsstr[j].trim());
						pvo.setHouse(housesstr[j].trim());						
						List<ZITEMBXVO> zitembxs = zitmbxService.queryItemBx(pvo);
						if(zitembxs!=null && zitembxs.size()>0){
							vo.setPlsub(zitembxs.get(0).getWhsub2());
							vo.setPlloc(zitembxs.get(0).getLlocn2());
						}
						ITMSITVO itmsitvo = new ITMSITVO();
						itmsitvo.setHouse(stid);
						itmsitvo.setItnot9(wlhsstr[j].trim());
						String itrvt = "";
						List<String> itrvts = this.xadataService.queryItrvt(itmsitvo);
						if(itrvts!=null && itrvts.size()>0){
							itrvt=itrvts.get(0);
						}
						ITMRVAVO itmrVo = new ITMRVAVO();
						itmrVo.setItnbr(wlhsstr[j].trim());
						itmrVo.setHouse(stid);
						itmrVo.setItrv(itrvt);
						List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
						if(itmrLists!=null && itmrLists.size()>0){
							ITMRVAVO itmvo = itmrLists.get(0);
							vo.setWght1(itmvo.getWeght().multiply(BigDecimal.valueOf(Double.valueOf(qtysstrs[j]))));
							vo.setWtum1(itmvo.getB2cqcd());
							vo.setWght2(BigDecimal.valueOf(Double.valueOf(qtysstrs[j])).divide((itmvo.getB2z95t()==null || itmvo.getB2z95t().floatValue()==0)?BigDecimal.valueOf(1):itmvo.getB2z95t()).multiply(itmvo.getB2aas3()));
							vo.setWtum2(itmvo.getB2aapt());
						}
						zpldtls.add(vo);
						//System.out.println("wlhsstr="+wlhsstr[j]);
						//System.out.println("ponumsstr="+ponumsstr[j]);
						
						
						if(this.zxdhs!=null && this.zxdhs.trim().length()>0){
							String[] zxdhstrs = zxdhs.split("-");
							String[] xsstrs = xss.split("-");
							boxvo.setPldno(hdrno);
							boxvo.setPldln(BigDecimal.valueOf(Long.valueOf(index)));
							boxvo.setBoxln(BigDecimal.valueOf(Long.valueOf(1)));
							boxvo.setBoxnm(zxdhstrs[j]);
							boxvo.setBoxes(BigDecimal.valueOf(Long.valueOf(xsstrs[j])));
							zplboxs.add(boxvo);
						}
						index++;
					}

				}
				
				this.zplhdrService.insertZplhdrA(zplhdr, zpldtls,zplboxs);
				System.out.println("this.zplhdr="+this.zplhdr.getCusno());
//				if(plist!=null && plist.size()>0){
//					this.ziphdrService.insertZiphdrM(plist);
//				}
				data="success";
			}
		}catch (Exception e) {e.printStackTrace();
		log.error("Go to admin resource operation grant page occured error.", e);
		data="fail";
		return toCreateNotice();
		}
		return toCreateNotice();
	}
	public String getAddByCus()throws Exception {
		JSONObject jo = new JSONObject();
		try {
			int plant =(Integer)this.getSession().getAttribute("plant");
			if(this.cusno!=null && !this.cusno.trim().equals("")){
				
				Map map = new HashMap();
				map.put("cono", plant);
				map.put("c6bcanb", Long.valueOf(cusno));
				List<MBS2REPVO> shipto = this.xadataService.queryShipTo(map);
				if(shipto!=null && shipto.size()>0){
					jo.put("stnam", shipto.get(0).getS2cltx());
					jo.put("stadd1", shipto.get(0).getS2cmtx());
					jo.put("stadd2", shipto.get(0).getS2cntx());
					jo.put("stcity", shipto.get(0).getS2cptx());
					jo.put("stctr", shipto.get(0).getS2cocd());
					jo.put("stzip", shipto.get(0).getS2cvcd());
				}else{
					jo.put("stnam", "");
					jo.put("stadd1", "");
					jo.put("stadd2", "");
					jo.put("stcity", "");
					jo.put("stctr", "");
					jo.put("stzip", "");
				}
				ZCUSCNSVO pvo = new ZCUSCNSVO();
				pvo.setComno(BigDecimal.valueOf(plant) );
				pvo.setCusnm(Integer.valueOf(cusno));
				
				List<ZCUSCNSVO> zcuscns = this.zcuscnsService.queryZcuscns(pvo);
				if(zcuscns!=null && zcuscns.size()>0){
					jo.put("scnam", zcuscns.get(0).getCname());
					jo.put("scadd1", zcuscns.get(0).getCaddr1());
					jo.put("scadd2", zcuscns.get(0).getCaddr2());
					jo.put("sccity", zcuscns.get(0).getCcity());
					jo.put("scctr", zcuscns.get(0).getCcntr());
					jo.put("sczip", zcuscns.get(0).getCzip());
				}else{
					jo.put("scnam", "");
					jo.put("scadd1", "");
					jo.put("scadd2", "");
					jo.put("sccity", "");
					jo.put("scctr", "");
					jo.put("sczip", "");
				}
				jo.put("result", "success");
				data=jo.toString();
			}
		}catch (Exception e) {e.printStackTrace();
		log.error("Go to admin resource operation grant page occured error.", e);
		jo.put("result", "fail");
		return "todata";
		}
		return "todata";
	}
	public String getSalesList()throws Exception {
		JSONObject jo = new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			int plant =(Integer)this.getSession().getAttribute("plant");
//			if(this.cusno!=null && !this.cusno.trim().equals("")){

			StringBuffer strbuf = new StringBuffer();
			strbuf.append("<table width='100%' border='1' cellpadding='3px' style='border-collapse: collapse;'>");
			strbuf.append("<tbody><tr><th><input type='checkbox' name='cba' onclick='selectall(this)' /></th>");
			strbuf.append("<th>客户名称</th><th>订单号</th><th>客户PO</th><th>行号</th><th>产品</th><th>客户项目编码</th><th>订货量</th><th>已出货量</th><th>库存量</th><th>未出货量</th><th>交货量</th><th>装箱单号</th><th>箱数</th></tr>");
				if(mbcdrep.getStartDate()!=null && !mbcdrep.getStartDate().trim().equals("")){
					mbcdrep.setStartDateB(BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(mbcdrep.getStartDate()), "yyMMdd"))));
				}
				if(mbcdrep.getEndDate()!=null && !mbcdrep.getEndDate().trim().equals("")){
					mbcdrep.setEndDateB(BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(mbcdrep.getEndDate()), "yyMMdd"))));
				}
				mbcdrep.setCdaenb(plant+"");
				mbcdrep.setCddccd("1");
				results = this.xadataService.queryMbcdrep(mbcdrep);
				if(results!=null && results.size()>0){
					
					for(int i=0;i<results.size();i++){
						MBCDREPVO temp = results.get(i);
						ZPLDTLVO pvo = new ZPLDTLVO();
						pvo.setC6cvnb(temp.getCdcvnb());
						pvo.setC6dccd("1");
						pvo.setCdfcnb(BigDecimal.valueOf(Long.valueOf(temp.getCdfcnb())) );
						pvo.setC6aenb(plant+"");
						Double sumqty = this.zplhdrService.queryDtlQty(pvo);
						if(i%2==0){
							strbuf.append("<tr class='td_bgcolor' >");
						}else{
							strbuf.append("<tr class='td_bgcolor2' >");
						}
						strbuf.append("<td><input name='chk' type='checkbox' value='"+temp.getCdcvnb()+"' /> <input name='wlhs"+i+"' type='hidden' value='"+(temp.getCdaitx())+"' /><input name='houses"+i+"' type='hidden' value='"+(temp.getCda3cd())+"' />" +
								"<input name='kcdw"+i+"' type='hidden' value='"+(temp.getCddhcd())+"' />"+
								"<input name='ponum"+i+"' type='hidden' value='"+(temp.getPonum())+"' /><input name='ddwc"+i+"' type='hidden' value='"+(temp.getCdfxva().add(temp.getCdz901().negate()).doubleValue()-sumqty)+"' />" +
										"<input name='hh"+i+"' type='hidden' value='"+temp.getCdfcnb()+"' /><input name='ddlx"+i+"' type='hidden' value='"+temp.getCddccd()+"' /></td>");
						strbuf.append("<td>"+temp.getCdaayyn()+"</td>");
						strbuf.append("<td>"+temp.getCdcvnb()+"</td>");
						strbuf.append("<td>"+temp.getPonum()+"</td>");
						strbuf.append("<td>"+temp.getCdfcnb()+"</td>");
						strbuf.append("<td>"+temp.getCdaitx()+"</td>");
						//strbuf.append("<td>"+temp.getCdaltx()+"</td>");
						strbuf.append("<td>"+((temp.getBihjtx()==null || temp.getBihjtx().trim().equals("null"))?"":temp.getBihjtx())+"</td>");
						strbuf.append("<td>"+temp.getCdacqty()+"</td>");
						strbuf.append("<td>"+temp.getCdz901()+"</td>");
						strbuf.append("<td>"+temp.getCdfxva()+"</td>");
						strbuf.append("<td>"+(temp.getCdfxva().add(temp.getCdz901().negate()).doubleValue()-sumqty)+"</td>");						
						strbuf.append("<td><input type='text' name='jh"+i+"' style='width:50px' value='"+(temp.getCdfxva().add(temp.getCdz901().negate()).doubleValue()-sumqty)+"' /></td>");
						strbuf.append("<td><input type='text' name='zxdhs"+i+"' style='width:70px' value='' /></td>");
						strbuf.append("<td><input type='text' name='xss"+i+"' style='width:50px' value='' /></td>");
						strbuf.append("</tr>");
					}
				}
				strbuf.append("</tbody></table>");
				jo.put("retStr", strbuf.toString());
				jo.put("result", "success");
				data=jo.toString();
//			}
		}catch (Exception e) {e.printStackTrace();
		log.error("Go to admin resource operation grant page occured error.", e);
		jo.put("result", "fail");
		return "todata";
		}
		return "todata";
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


	public String getCnote() {
		return cnote;
	}

	public void setCnote(String cnote) {
		this.cnote = cnote;
	}
}
