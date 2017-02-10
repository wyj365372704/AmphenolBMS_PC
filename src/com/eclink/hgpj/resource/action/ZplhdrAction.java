package com.eclink.hgpj.resource.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.eclink.hgpj.resource.biz.ZMBD1REPService;
import com.eclink.hgpj.resource.biz.ZPLHDRService;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MBCDREPVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZBMSRSNVO;
import com.eclink.hgpj.resource.vo.ZCUSMRKVO;
import com.eclink.hgpj.resource.vo.ZIPDTLVO;
import com.eclink.hgpj.resource.vo.ZPLBOXVO;
import com.eclink.hgpj.resource.vo.ZPLDTLVO;
import com.eclink.hgpj.resource.vo.ZPLHDRVO;
import com.eclink.hgpj.user.biz.AUserService;
import com.eclink.hgpj.util.QRcoderUtil;
import com.eclink.hgpj.util.Utils;

/**
 * ZiphdrAction.java
 *
 * @Title: 领料单类
 * @Description: 
 * @version 1.0
 * @date May 29, 2013 4:44:36 PM
 *
 */
public class ZplhdrAction extends BaseAction {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(ZplhdrAction.class);
	
	
	private ZIPHDRService ziphdrService;
	
	private AUserService auserService;
	
	private ZITMBXService zitmbxService;
	
	private XADATAService xadataService;
	
	private ZMBD1REPService zmbd1repService;
	
	private ZCUSCNSService zcuscnsService;
	
	private ZBMSCTLService zbmsctlService;

	private ZPLHDRVO zplhdr;
	
	private ZPLHDRService zplhdrService;
	
	private ZIPDTLVO zipdtlvo;
	
	private String ordno;
	
	private String iptyp;
	
	private String pldno;
	
	private String pldln;
	
	private String cmmt;
	
	private String house;
	
	private String citem;
	
	private String seqnm;
	
	private String data;
	
	private String reason;

	private String flag;
	
	private String startDate;
	
	private String endDate;
	
	private String qrcodeurl;
	
	private String incots;
	
	private Float sqty = Float.valueOf(0);
	
	private Float sje= Float.valueOf(0);
	
	private Float sjz= Float.valueOf(0);
	
	private Float smz= Float.valueOf(0);
	
	private Float sxs= Float.valueOf(0);
	
	private String fmark1;
	
	private String fmark2;
	
	private String fmark3;
	
	private String fmark4;
	
	private String fmark5;
	
	private String smark1;
	
	private String smark2;
	
	private String smark3;
	
	private String smark4;
	
	private String smark5;
	
	private String companyn;
	
	private List<ZPLHDRVO> results;
	
	private List<ZIPDTLVO> dresults;
	
	private List<Map> mresults;
	
	public ZITMBXService getZitmbxService() {
		return zitmbxService;
	}

	public void setZitmbxService(ZITMBXService zitmbxService) {
		this.zitmbxService = zitmbxService;
	}

	public ZIPHDRService getZiphdrService() {
		return ziphdrService;
	}

	public void setZiphdrService(ZIPHDRService ziphdrService) {
		this.ziphdrService = ziphdrService;
	}

	public ZCUSCNSService getZcuscnsService() {
		return zcuscnsService;
	}

	public void setZcuscnsService(ZCUSCNSService zcuscnsService) {
		this.zcuscnsService = zcuscnsService;
	}

	public ZBMSCTLService getZbmsctlService() {
		return zbmsctlService;
	}

	public void setZbmsctlService(ZBMSCTLService zbmsctlService) {
		this.zbmsctlService = zbmsctlService;
	}

	public String getCompanyn() {
		return companyn;
	}

	public void setCompanyn(String companyn) {
		this.companyn = companyn;
	}

	public String getOrdno() {
		return ordno;
	}

	public void setOrdno(String ordno) {
		this.ordno = ordno;
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



	public String getCmmt() {
		return cmmt;
	}

	public void setCmmt(String cmmt) {
		this.cmmt = cmmt;
	}

	public ZIPDTLVO getZipdtlvo() {
		return zipdtlvo;
	}

	public void setZipdtlvo(ZIPDTLVO zipdtlvo) {
		this.zipdtlvo = zipdtlvo;
	}



	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCitem() {
		return citem;
	}

	public void setCitem(String citem) {
		this.citem = citem;
	}

	public String getSeqnm() {
		return seqnm;
	}

	public void setSeqnm(String seqnm) {
		this.seqnm = seqnm;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPldno() {
		return pldno;
	}

	public void setPldno(String pldno) {
		this.pldno = pldno;
	}

	public String getPldln() {
		return pldln;
	}

	public void setPldln(String pldln) {
		this.pldln = pldln;
	}

	public String getQrcodeurl() {
		return qrcodeurl;
	}

	public void setQrcodeurl(String qrcodeurl) {
		this.qrcodeurl = qrcodeurl;
	}

	public String getIncots() {
		return incots;
	}

	public void setIncots(String incots) {
		this.incots = incots;
	}

	public String getFmark1() {
		return fmark1;
	}

	public void setFmark1(String fmark1) {
		this.fmark1 = fmark1;
	}

	public String getFmark2() {
		return fmark2;
	}

	public void setFmark2(String fmark2) {
		this.fmark2 = fmark2;
	}

	public String getFmark3() {
		return fmark3;
	}

	public void setFmark3(String fmark3) {
		this.fmark3 = fmark3;
	}

	public String getFmark4() {
		return fmark4;
	}

	public void setFmark4(String fmark4) {
		this.fmark4 = fmark4;
	}

	public String getFmark5() {
		return fmark5;
	}

	public void setFmark5(String fmark5) {
		this.fmark5 = fmark5;
	}

	public String getSmark1() {
		return smark1;
	}

	public void setSmark1(String smark1) {
		this.smark1 = smark1;
	}

	public String getSmark2() {
		return smark2;
	}

	public void setSmark2(String smark2) {
		this.smark2 = smark2;
	}

	public String getSmark3() {
		return smark3;
	}

	public void setSmark3(String smark3) {
		this.smark3 = smark3;
	}

	public String getSmark4() {
		return smark4;
	}

	public void setSmark4(String smark4) {
		this.smark4 = smark4;
	}

	public String getSmark5() {
		return smark5;
	}

	public void setSmark5(String smark5) {
		this.smark5 = smark5;
	}

	public Float getSqty() {
		return sqty;
	}

	public void setSqty(Float sqty) {
		this.sqty = sqty;
	}

	public Float getSje() {
		return sje;
	}

	public void setSje(Float sje) {
		this.sje = sje;
	}

	public Float getSjz() {
		return sjz;
	}

	public void setSjz(Float sjz) {
		this.sjz = sjz;
	}

	public Float getSmz() {
		return smz;
	}

	public void setSmz(Float smz) {
		this.smz = smz;
	}

	public Float getSxs() {
		return sxs;
	}

	public void setSxs(Float sxs) {
		this.sxs = sxs;
	}

	public List<ZPLHDRVO> getResults() {
		return results;
	}

	public void setResults(List<ZPLHDRVO> results) {
		this.results = results;
	}

	public List<ZIPDTLVO> getDresults() {
		return dresults;
	}

	public void setDresults(List<ZIPDTLVO> dresults) {
		this.dresults = dresults;
	}

	public List<Map> getMresults() {
		return mresults;
	}

	public void setMresults(List<Map> mresults) {
		this.mresults = mresults;
	}

	public AUserService getAuserService() {
		return auserService;
	}

	public void setAuserService(AUserService auserService) {
		this.auserService = auserService;
	}

	public XADATAService getXadataService() {
		return xadataService;
	}

	public void setXadataService(XADATAService xadataService) {
		this.xadataService = xadataService;
	}

	public ZMBD1REPService getZmbd1repService() {
		return zmbd1repService;
	}

	public void setZmbd1repService(ZMBD1REPService zmbd1repService) {
		this.zmbd1repService = zmbd1repService;
	}

	public ZPLHDRVO getZplhdr() {
		return zplhdr;
	}

	public void setZplhdr(ZPLHDRVO zplhdr) {
		this.zplhdr = zplhdr;
	}

	public ZPLHDRService getZplhdrService() {
		return zplhdrService;
	}

	public void setZplhdrService(ZPLHDRService zplhdrService) {
		this.zplhdrService = zplhdrService;
	}

	/**
	 * 进入生产订单信息页面
	 * @return
	 * @throws Exception
	 */
	public String addZplhdr() throws Exception {
		try {
			
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			data="fail";
			reason="添加物料异常";
			return "toAddZipdtl";
		}
		data="success";
		return "todata";
	}
	

	/**
	 * 删除领料单物料
	 * @return
	 * @throws Exception
	 */
	public String toDelete() throws Exception {
		try {
//			ZIPDTLVO pvo = new ZIPDTLVO();
//			pvo.setIpdno(ipdno);
//			pvo.setIpdln(BigDecimal.valueOf(Double.valueOf(ipdln).longValue()));
//			this.ziphdrService.deleteZipdtl(pvo);
			data="success";
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			data="fail";
			return "todata";
		}
		return "todata";
	}
	/**
	 * 删除领料单
	 * @return
	 * @throws Exception
	 */
	public String toDeleteZplhdr() throws Exception {
		try {
//			ZIPDTLVO pvo = new ZIPDTLVO();
//			pvo.setIpdno(ipdno);
//			pvo.setIpdln(BigDecimal.valueOf(Double.valueOf(ipdln).longValue()));
//			this.ziphdrService.deleteZipdtl(pvo);
//			ZIPHDRVO pvo = new ZIPHDRVO();
//			pvo.setIpdno(ipdno);
			System.out.println("pldno="+pldno);
			if(pldno!=null && pldno.trim().length()>0){
//				this.ziphdrService.deleteZiphdr(pvo);
				this.zplhdrService.deleteZplhdr(pldno);
				data="success";
			}else{
				data="fail";
			}
			
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			data="fail";
			return "todata";
		}
		return "todata";
	}
	/**
	 * 领料单列表
	 * @return
	 * @throws Exception
	 */
	public String toZplhdr() throws Exception {
		try {
			int plant =(Integer)this.getSession().getAttribute("plant");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(zplhdr!=null){	
				//				Date d = sdf.parse(momast.getStartDate());
				Map map = new HashMap();
				if(startDate!=null && startDate.trim().length()>0){
					map.put("startDateB", BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(startDate), "yyMMdd"))));
				}
				if(endDate!=null && endDate.trim().length()>0){
					map.put("endDateB", BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(endDate), "yyMMdd"))));
				}
				map.put("pldno", zplhdr.getPldno());
				map.put("house", zplhdr.getHouse());
				map.put("cusnm", zplhdr.getCusnm());
				map.put("ostat", "99");
				List<ZPLHDRVO> tresults=this.zplhdrService.queryZplhdrByPar(map);
				if(tresults!=null && tresults.size()>0){
					results = new ArrayList<ZPLHDRVO>();
					for(int i=0;i<tresults.size();i++){
						ZPLHDRVO vo = tresults.get(i);
						vo.setEtdate(vo.getEtdate()+Long.valueOf(19000000));
						results.add(vo);
					}
				}
			}else{
				zplhdr = new ZPLHDRVO();
				this.startDate=sdf.format(new Date());
				this.endDate=sdf.format(new Date());
//				mbcdrep.setStartDate(sdf.format(new Date()));
//				mbcdrep.setEndDate(sdf.format(new Date()));
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
		return "toZplhdr";
	}
	
	public String toPrintOne() throws Exception {
		try {
			int plant =(Integer)this.getSession().getAttribute("plant");
			String stid = (String)this.getSession().getAttribute("stid");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			ZBMSCTLVO zbmsctl = new ZBMSCTLVO();
			zbmsctl.setSite(stid);
			List<ZBMSCTLVO> bmsctlList = this.zbmsctlService.queryZbmsctl(zbmsctl);
			if(bmsctlList!=null && bmsctlList.size()>0){
				zbmsctl = bmsctlList.get(0);
				this.companyn=zbmsctl.getNmchs();
			}
			if(this.pldno!=null && pldno.trim().length()>0){
				this.pldno=pldno.trim();
				ZPLHDRVO pvo = new ZPLHDRVO();
				pvo.setPldno(pldno);
				List<ZPLHDRVO> zplhdrs  = this.zplhdrService.queryZplhdr(pvo);
				if(zplhdrs!=null && zplhdrs.size()>0){
					this.zplhdr = zplhdrs.get(0);
					String qrMessage = "*V"+zplhdr.getPldno();
					String encoderQRCoder = QRcoderUtil.encoderQRCoder(qrMessage, ServletActionContext.getContext().getSession().get("username").toString(),getSession().getServletContext().getRealPath("/"));
					HttpServletRequest request = ServletActionContext.getRequest();
					String path = request.getContextPath(); 
					String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
					qrcodeurl = basePath+"/"+encoderQRCoder;
					Map pmap = new HashMap();
					pmap.put("c8bhst", zplhdr.getIncot());
					List<String> templist2 = this.xadataService.queryTransport(pmap);
					if(templist2!=null && templist2.size()>0){
						String transsport = templist2.get(0);
						this.incots = transsport.split("-")[1];
					}
					
					startDate = (zplhdr.getEtdate()+19000000)+"" ;
					ZPLDTLVO dpvo = new ZPLDTLVO();
					dpvo.setPldno(pldno);
					List<ZPLDTLVO> zpldtls = this.zplhdrService.queryReceipt(dpvo);
					ZPLBOXVO bpvo = new ZPLBOXVO();
					bpvo.setPldno(pldno);
					List<ZPLBOXVO> zplboxes = this.zplhdrService.queryBch(bpvo);
					
					if(zpldtls!=null && zpldtls.size()>0){
						this.mresults = new ArrayList<Map>();
						for(int i=0;i<zpldtls.size();i++){
							ZPLDTLVO tvo = zpldtls.get(i);
							Map reusltmap = new HashMap();
							reusltmap.put("idx", i+1);
							reusltmap.put("cusodrno", tvo.getC6aenb()+(tvo.getC6dccd().trim().equals("1")?"CO":"CM")+"-"+tvo.getC6cvnb());
							reusltmap.put("cusln", tvo.getCdfcnb());
							reusltmap.put("ponum", tvo.getPonum());
							reusltmap.put("plqty", tvo.getPlqty());
							reusltmap.put("plqty", tvo.getPlqty());
							Map bpmap = new HashMap();
							bpmap.put("biaitx", tvo.getItnbr());
							bpmap.put("bicanb", zplhdr.getCusno().longValue());
							List<String> bicresults = this.xadataService.queryMbbirep(bpmap);
							String cusitnr = "";
							if(bicresults!=null && bicresults.size()>0){
								cusitnr = bicresults.get(0);
							}
							
							if(zplboxes!=null && zplboxes.size()>0){
								ZPLBOXVO bvo = zplboxes.get(i);
								reusltmap.put("xhxs", bvo.getBoxnm()+"/"+(bvo.getBoxes()==null?0:bvo.getBoxes().floatValue()));
								this.sxs=sxs+(bvo.getBoxes()==null?0:bvo.getBoxes().floatValue());
							}
							MBCDREPVO mbcdrep = new MBCDREPVO();
							mbcdrep.setCdaenb(plant+"");
							mbcdrep.setCddccd("1");
							mbcdrep.setCdcvnb(tvo.getC6cvnb());
							mbcdrep.setCdfcnb(tvo.getCdfcnb()+"");
							List<MBCDREPVO> tresults = this.xadataService.queryMbcdrep(mbcdrep);
							if(tresults!=null && tresults.size()>0){
								MBCDREPVO tresult = tresults.get(0);
								ZPLDTLVO pvo2 = new ZPLDTLVO();
								pvo2.setC6cvnb(tvo.getC6cvnb());
								pvo2.setC6dccd("1");
								pvo2.setCdfcnb(tvo.getCdfcnb());
								pvo2.setC6aenb(plant+"");
								Double sumqty = this.zplhdrService.queryDtlQty(pvo2);
								
								reusltmap.put("plqtyno", (tresult.getCdfxva().add(tresult.getCdz901().negate()).doubleValue()-sumqty));
							}else{
								reusltmap.put("plqtyno", 0);
							}
							ITMSITVO itmsitvo = new ITMSITVO();
							itmsitvo.setHouse(stid);
							itmsitvo.setItnot9(tvo.getItnbr().trim());
							String itrvt = "";
							List<String> itrvts = this.xadataService.queryItrvt(itmsitvo);
							if(itrvts!=null && itrvts.size()>0){
								itrvt=itrvts.get(0);
							}
							ITMRVAVO itmrVo = new ITMRVAVO();
							itmrVo.setItnbr(tvo.getItnbr().trim());
							itmrVo.setHouse(stid);
							itmrVo.setItrv(itrvt);
							List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
							if(itmrLists!=null && itmrLists.size()>0){
								ITMRVAVO itmvo = itmrLists.get(0);
//								vo.setWght1(itmvo.getWeght().multiply(BigDecimal.valueOf(Double.valueOf(qtysstrs[j]))));
//								vo.setWtum1(itmvo.getB2cqcd());
//								vo.setWght2(BigDecimal.valueOf(Double.valueOf(qtysstrs[j])).divide((itmvo.getB2z95t()==null || itmvo.getB2z95t().floatValue()==0)?BigDecimal.valueOf(1):itmvo.getB2z95t()).multiply(itmvo.getB2aas3()));
//								vo.setWtum2(itmvo.getB2aapt());
								reusltmap.put("b2z95t", itmvo.getB2z95t());

								reusltmap.put("cwlms", cusitnr+"/"+itmvo.getItdsc());
								reusltmap.put("jzsl", itmvo.getWeght()+"/"+itmvo.getB2aas3());
							}
							reusltmap.put("plsub", tvo.getPlsub());
							reusltmap.put("plloc", tvo.getPlloc());
							mresults.add(reusltmap);
							this.sqty=sqty+tvo.getPlqty().floatValue();
							this.sjz=sjz+tvo.getWght1().floatValue();
							this.smz=smz+tvo.getWght2().floatValue();
							
//							reusltmap.put("xhxs", tvo.get)
						}
					}
					ZCUSMRKVO mvo = new ZCUSMRKVO();
					mvo.setComno(Integer.valueOf(zplhdr.getPlant()));
					mvo.setCusnm(zplhdr.getCusno().intValue());
					List<ZCUSMRKVO> mrkresults = this.zcuscnsService.queryZcusmrk(mvo);
					if(mrkresults!=null && mrkresults.size()>0){
						ZCUSMRKVO mrkresult = mrkresults.get(0);
						this.fmark1= mrkresult.getFmark1();
						this.fmark2= mrkresult.getFmark2();
						this.fmark3= mrkresult.getFmark3();
						this.fmark4= mrkresult.getFmark4();
						this.fmark5= mrkresult.getFmark5();
						
						this.smark1=mrkresult.getSmark1();
						this.smark2=mrkresult.getSmark2();
						this.smark3=mrkresult.getSmark3();
						this.smark4=mrkresult.getSmark4();
						this.smark5=mrkresult.getSmark5();
					}
					
				}
			}
		} catch (Exception e) {e.printStackTrace();
		log.error("Go to admin resource operation grant page occured error.", e);
		return ERROR;
		}
		return "toPrintOne";
	}
	
	public String confirmNotice() throws Exception {
		try {
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "toZiphdrList";
	}
	
	
	public String toZiphdrApprovalList() throws Exception {
		try {
			
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "toZiphdrApprovalList";
	}
	
	/**
	 * 领料单明细列表
	 * @return
	 * @throws Exception
	 */
	public String toZipdtl() throws Exception {
		try {
//			ZIPDTLVO vo = new ZIPDTLVO();
//			vo.setIpdno(ipdno);
//			vo.setLstat("05,10");
//			dresults= this.ziphdrService.queryItems(vo);
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "toZipdtl";
	}
	
	public String toEditZplhdr() throws Exception {
		try {
			int plant =(Integer)this.getSession().getAttribute("plant");
			String stid = (String)this.getSession().getAttribute("stid");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			ZBMSCTLVO zbmsctl = new ZBMSCTLVO();
//			zbmsctl.setSite(stid);
//			List<ZBMSCTLVO> bmsctlList = this.zbmsctlService.queryZbmsctl(zbmsctl);
//			if(bmsctlList!=null && bmsctlList.size()>0){
//				zbmsctl = bmsctlList.get(0);
//				this.companyn=zbmsctl.getNmchs();
//			}
			if(this.pldno!=null && pldno.trim().length()>0){
				this.pldno=pldno.trim();
				ZPLHDRVO pvo = new ZPLHDRVO();
				pvo.setPldno(pldno);
				List<ZPLHDRVO> zplhdrs  = this.zplhdrService.queryZplhdr(pvo);
				if(zplhdrs!=null && zplhdrs.size()>0){
					this.zplhdr = zplhdrs.get(0);
//					String qrMessage = "*V"+zplhdr.getPldno();
//					String encoderQRCoder = QRcoderUtil.encoderQRCoder(qrMessage, ServletActionContext.getContext().getSession().get("username").toString(),getSession().getServletContext().getRealPath("/"));
//					HttpServletRequest request = ServletActionContext.getRequest();
//					String path = request.getContextPath(); 
//					String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//					qrcodeurl = basePath+"/"+encoderQRCoder;
					Map pmap = new HashMap();
					pmap.put("c8bhst", zplhdr.getIncot());
					List<String> templist2 = this.xadataService.queryTransport(pmap);
					if(templist2!=null && templist2.size()>0){
						String transsport = templist2.get(0);
						this.incots = transsport.split("-")[1];
					}
					
					startDate = (zplhdr.getEtdate()+19000000)+"" ;
					ZPLDTLVO dpvo = new ZPLDTLVO();
					dpvo.setPldno(pldno);
					List<ZPLDTLVO> zpldtls = this.zplhdrService.queryReceipt(dpvo);
					ZPLBOXVO bpvo = new ZPLBOXVO();
					bpvo.setPldno(pldno);
					List<ZPLBOXVO> zplboxes = this.zplhdrService.queryBch(bpvo);
					
					if(zpldtls!=null && zpldtls.size()>0){
						this.mresults = new ArrayList<Map>();
						for(int i=0;i<zpldtls.size();i++){
							ZPLDTLVO tvo = zpldtls.get(i);
							Map reusltmap = new HashMap();
							reusltmap.put("idx", i+1);
							reusltmap.put("cusodrno", tvo.getC6aenb()+(tvo.getC6dccd().trim().equals("1")?"CO":"CM")+"-"+tvo.getC6cvnb());
							reusltmap.put("cusln", tvo.getCdfcnb());
							reusltmap.put("ponum", tvo.getPonum());
							reusltmap.put("plqty", tvo.getPlqty());
							reusltmap.put("plqty", tvo.getPlqty());
							reusltmap.put("pldln", tvo.getPldln()==null?0:tvo.getPldln().intValue());
							Map bpmap = new HashMap();
							bpmap.put("biaitx", tvo.getItnbr());
							bpmap.put("bicanb", zplhdr.getCusno().longValue());
							List<String> bicresults = this.xadataService.queryMbbirep(bpmap);
							String cusitnr = "";
							if(bicresults!=null && bicresults.size()>0){
								cusitnr = bicresults.get(0);
							}
							
							if(zplboxes!=null && zplboxes.size()>0){
								ZPLBOXVO bvo = zplboxes.get(i);
								reusltmap.put("xhs", bvo.getBoxnm());
								reusltmap.put("xss",(bvo.getBoxes()==null?0:bvo.getBoxes().floatValue()));
//								this.sxs=sxs+(bvo.getBoxes()==null?0:bvo.getBoxes().floatValue());
							}
							MBCDREPVO mbcdrep = new MBCDREPVO();
							mbcdrep.setCdaenb(plant+"");
							mbcdrep.setCddccd("1");
							mbcdrep.setCdcvnb(tvo.getC6cvnb());
							mbcdrep.setCdfcnb(tvo.getCdfcnb()+"");
							List<MBCDREPVO> tresults = this.xadataService.queryMbcdrep(mbcdrep);
							if(tresults!=null && tresults.size()>0){
								MBCDREPVO tresult = tresults.get(0);
								ZPLDTLVO pvo2 = new ZPLDTLVO();
								pvo2.setC6cvnb(tvo.getC6cvnb());
								pvo2.setC6dccd("1");
								pvo2.setCdfcnb(tvo.getCdfcnb());
								pvo2.setC6aenb(plant+"");
								Double sumqty = this.zplhdrService.queryDtlQty(pvo2);
								
								reusltmap.put("plqtyno", (tresult.getCdfxva().add(tresult.getCdz901().negate()).doubleValue()-sumqty));
							}else{
								reusltmap.put("plqtyno", 0);
							}
							ITMSITVO itmsitvo = new ITMSITVO();
							itmsitvo.setHouse(stid);
							itmsitvo.setItnot9(tvo.getItnbr().trim());
							String itrvt = "";
							List<String> itrvts = this.xadataService.queryItrvt(itmsitvo);
							if(itrvts!=null && itrvts.size()>0){
								itrvt=itrvts.get(0);
							}
							ITMRVAVO itmrVo = new ITMRVAVO();
							itmrVo.setItnbr(tvo.getItnbr().trim());
							itmrVo.setHouse(stid);
							itmrVo.setItrv(itrvt);
							List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
							if(itmrLists!=null && itmrLists.size()>0){
								ITMRVAVO itmvo = itmrLists.get(0);
//								vo.setWght1(itmvo.getWeght().multiply(BigDecimal.valueOf(Double.valueOf(qtysstrs[j]))));
//								vo.setWtum1(itmvo.getB2cqcd());
//								vo.setWght2(BigDecimal.valueOf(Double.valueOf(qtysstrs[j])).divide((itmvo.getB2z95t()==null || itmvo.getB2z95t().floatValue()==0)?BigDecimal.valueOf(1):itmvo.getB2z95t()).multiply(itmvo.getB2aas3()));
//								vo.setWtum2(itmvo.getB2aapt());
								reusltmap.put("b2z95t", itmvo.getB2z95t());

								reusltmap.put("cwlms", cusitnr+"/"+itmvo.getItdsc());
								reusltmap.put("jzsl", itmvo.getWeght()+"/"+itmvo.getB2aas3());
							}
//							reusltmap.put("plsub", tvo.getPlsub());
//							reusltmap.put("plloc", tvo.getPlloc());
							mresults.add(reusltmap);
							
						}
					}
					
					
				}
			}
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "toEditZplhdr";
	}
	
	public String editNotice() throws Exception {
		try {
			System.out.println("this.zplhdr.getPldno()"+pldno+"-"+this.zplhdr.getStnam());
			String[] pldlns = this.getRequest().getParameterValues("pldln");
			String[] plqtys = this.getRequest().getParameterValues("plqtys");
			String[] xhs = this.getRequest().getParameterValues("xhs");
			String[] xss = this.getRequest().getParameterValues("xss");
			System.out.println(plqtys.length);
			if(pldlns!=null && pldlns.length>0){
				List<ZPLDTLVO> pzpldtls = new ArrayList<ZPLDTLVO>();
				List<ZPLBOXVO> pzplboxs = new ArrayList<ZPLBOXVO>();
 				for(int i=0;i<pldlns.length;i++){System.out.println("pldlns"+i+"="+pldlns[i]+";"+xss[i]);
 					ZPLDTLVO tvo = new ZPLDTLVO();
 					tvo.setPldno(pldno);
 					tvo.setPldln(BigDecimal.valueOf(Long.valueOf(pldlns[i])));
 					tvo.setPlqty(BigDecimal.valueOf(Float.valueOf(plqtys[i])));
 					pzpldtls.add(tvo);
 					ZPLBOXVO xvo = new ZPLBOXVO();
 					xvo.setPldno(pldno);
 					xvo.setPldln(BigDecimal.valueOf(Long.valueOf(pldlns[i])));
 					xvo.setBoxln(BigDecimal.valueOf(Long.valueOf(1)));
 					xvo.setBoxes(BigDecimal.valueOf(Long.valueOf(xss[i])));
 					xvo.setBoxnm(xhs[i]);
 					pzplboxs.add(xvo);
				}
 				this.zplhdrService.updateZplhdrA(zplhdr, pzpldtls, pzplboxs);
			}
			//this.ziphdrService.updateZipitmQty(zipdtlvo);
			data="success";
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			data="fail";
			reason="修改数量异常";
			return "toEditZplhdr";
		}
		return "toEditZplhdr";
	}
	public String getBmsReason() throws Exception {
		try {
			StringBuffer sbf = new StringBuffer();
			if("1".equals(iptyp)){
				iptyp="IP01";
			}else if("2".equals(iptyp)){
				iptyp="IP02";
			}else if("3".equals(iptyp)){
				iptyp="IP03";
			}
			Map rpmap = new HashMap();
			rpmap.put("bmstyp", iptyp);
			List<ZBMSRSNVO> list = this.ziphdrService.getReason(rpmap);
			if(list!=null && list.size()>0){
				for(int i=0;i<list.size();i++){
					ZBMSRSNVO temp = list.get(i);
					if(i==0){
						sbf.append("<option value='");
						sbf.append(temp.getBmsrsn());
						sbf.append("' selected > ");
					}else{
						sbf.append("<option value='");
						sbf.append(temp.getBmsrsn());
						sbf.append("' >");
					}
					sbf.append(temp.getRsnnm());
					sbf.append("</option>");
				}
			}
			data=sbf.toString();
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			data="fail";			
		}
		return "todata";
	}
	
	public String toAddZipdtl() throws Exception {
		try {
//			MODATAVO vo = new MODATAVO();
//			vo.setOrdno(ordno);
//			vo.setCitwh(house);
//			mresults=this.xadataService.queryModatas(vo);
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "toAddZipdtl";
	}
	
	public String toApproval() throws Exception{
		try {
//			String userDept = "";
//			String username = (String)this.getSession().getAttribute("username");
//			List<ZBMSU02VO> dps = this.auserService.queryDeptByUserName(username);
//			if(dps!=null && dps.size()>0){
//				for(int i=0;i<dps.size();i++){
//					ZBMSU02VO dp = dps.get(i);
//					if(dp.getDflt()!=null && "1".equals(dp.getDflt().trim())){
////						vo.setPlant(dp.getPlant());
////						vo.setTwdp1(dp.getDept());
//						userDept = dp.getDept();
//					}
//				}
//			}
//			
//			String now1 = Utils.formateDate(null, "yyMMdd");
//			String now2 = Utils.formateDate(null, "HHmmss");
//			
//			ZIPHDRVO ziphdrvo = new ZIPHDRVO();
//			ziphdrvo.setIpdno(ipdno);
//			ziphdrvo.setAprus(username);
//			ziphdrvo.setAprdp(userDept);
//			ziphdrvo.setAprdt(BigDecimal.valueOf(Long.valueOf("1"+now1)));
//			ziphdrvo.setAprtm(BigDecimal.valueOf(Long.valueOf(now2)));
//			ziphdrService.updateZiphdrForApproval(ziphdrvo);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "toApproval";
	}
	
	public String toConfirm() throws Exception {
		try {
			if(this.ordno!=null && this.ordno.trim().length()>0){
				ZPLHDRVO pvo = new ZPLHDRVO();
				pvo.setPldno(this.ordno);
				pvo.setOstat("10");
				this.zplhdrService.updateZplhdrByPar(pvo);
				data="success";
			}else{
				data="fail";
			}
			
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "todata";
	}
	
}
