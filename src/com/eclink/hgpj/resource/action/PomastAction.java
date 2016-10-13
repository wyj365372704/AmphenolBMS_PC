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
import com.eclink.hgpj.resource.biz.ZBMSCTLService;
import com.eclink.hgpj.resource.biz.ZIPHDRService;
import com.eclink.hgpj.resource.biz.ZITMBXService;
import com.eclink.hgpj.resource.biz.ZMBD1REPService;
import com.eclink.hgpj.resource.vo.BUYERFVO;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MODATAVO;
import com.eclink.hgpj.resource.vo.MOMASTVO;
import com.eclink.hgpj.resource.vo.MOPORFVO;
import com.eclink.hgpj.resource.vo.MOROUTVO;
import com.eclink.hgpj.resource.vo.POBLKTVO;
import com.eclink.hgpj.resource.vo.POITEMVO;
import com.eclink.hgpj.resource.vo.POMASTVO;
import com.eclink.hgpj.resource.vo.SHPMSTVO;
import com.eclink.hgpj.resource.vo.VENNAMVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
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
public class PomastAction extends BaseAction {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(PomastAction.class);


	private XADATAService xadataService;

	private ZIPHDRService ziphdrService;

	private ZMBD1REPService zmbd1repService;

	private POMASTVO pomast;

	private VENNAMVO  vennam;

	private SHPMSTVO shpmst;

	private ZBMSCTLVO zbmsctl;

	private BUYERFVO buyerf;

	private AUserService auserService;

	private ZITMBXService zitmbxService;

	private ZBMSCTLService zbmsctlService;

	private String ordno;

	private int language = 0;

	private String chk01;

	private String chk02;

	private String chk03;

	private String data;

	private String isdetail;

	private String cmmt;

	private String chk;

	private String buynm;

	private String txsuf;

	private List<Map> pMaps;

	private List<POMASTVO> results;

	private boolean isOutSource = false ;

	public boolean isOutSource() {
		return isOutSource;
	}

	public void setOutSource(boolean isOutSource) {
		this.isOutSource = isOutSource;
	}

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



	public ZBMSCTLService getZbmsctlService() {
		return zbmsctlService;
	}

	public void setZbmsctlService(ZBMSCTLService zbmsctlService) {
		this.zbmsctlService = zbmsctlService;
	}

	public POMASTVO getPomast() {
		return pomast;
	}

	public void setPomast(POMASTVO pomast) {
		this.pomast = pomast;
	}

	public List<POMASTVO> getResults() {
		return results;
	}

	public void setResults(List<POMASTVO> results) {
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

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public String getChk01() {
		return chk01;
	}

	public void setChk01(String chk01) {
		this.chk01 = chk01;
	}

	public String getChk02() {
		return chk02;
	}

	public void setChk02(String chk02) {
		this.chk02 = chk02;
	}

	public String getChk03() {
		return chk03;
	}

	public void setChk03(String chk03) {
		this.chk03 = chk03;
	}

	public List<Map> getPMaps() {
		return pMaps;
	}

	public void setPMaps(List<Map> maps) {
		pMaps = maps;
	}

	public VENNAMVO getVennam() {
		return vennam;
	}

	public void setVennam(VENNAMVO vennam) {
		this.vennam = vennam;
	}


	public SHPMSTVO getShpmst() {
		return shpmst;
	}

	public void setShpmst(SHPMSTVO shpmst) {
		this.shpmst = shpmst;
	}


	public ZBMSCTLVO getZbmsctl() {
		return zbmsctl;
	}

	public void setZbmsctl(ZBMSCTLVO zbmsctl) {
		this.zbmsctl = zbmsctl;
	}



	public BUYERFVO getBuyerf() {
		return buyerf;
	}

	public void setBuyerf(BUYERFVO buyerf) {
		this.buyerf = buyerf;
	}



	public String getBuynm() {
		return buynm;
	}

	public void setBuynm(String buynm) {
		this.buynm = buynm;
	}




	public String getTxsuf() {
		return txsuf;
	}

	public void setTxsuf(String txsuf) {
		this.txsuf = txsuf;
	}



	public String printO()throws Exception {
		try{
			Map map = new HashMap();
			map.put("ordnoO", ordno);

			results = this.xadataService.queryPomast(map);
			System.out.println("result's size is "+results.size());
			if(results!=null && results.size()>0){
				pomast = results.get(0);

				//判断是否为外协订单
				MOPORFVO moporf = new  MOPORFVO();
				moporf.setPonr(pomast.getOrdno());
				List<MOPORFVO> moporfList = xadataService.queryMoporf(moporf);
				System.out.println("moporfList size is "+moporfList.size());
				if(moporfList!=null && moporfList.size()>0){//为外协订单
					isOutSource = true;
				}

				String d= (pomast.getActdt()==null || pomast.getActdt().doubleValue()==0.0)?"":pomast.getActdt().add(BigDecimal.valueOf(19000000)).toString().trim();
				pomast.setActdts((d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" ")));

				zbmsctl = new ZBMSCTLVO();
				zbmsctl.setSite((String) getSession().getAttribute("stid"));
				List<ZBMSCTLVO> bmsctlList = this.zbmsctlService.queryZbmsctl(zbmsctl);
				System.out.println("bmsctlList size is "+bmsctlList.size());
				if(bmsctlList!=null && bmsctlList.size()>0){
					zbmsctl = bmsctlList.get(0);
					System.out.println("zbmsctl's nmchs is "+zbmsctl.getNmchs());
				}

				System.out.println("pomast's buyno is "+pomast.getBuyno());
				Map buynmMap = new HashMap();
				buynmMap.put("buyno", pomast.getBuyno());
				buynm = this.xadataService.queryBuyer(buynmMap);
				System.out.println("buynm is "+buynm);

				System.out.println("pomast's house is "+pomast.getHouse());
				Map mstmap = new HashMap();
				mstmap.put("house", pomast.getHouse());
				mstmap.put("shpid", pomast.getBilid());
				List<SHPMSTVO> shpmstList = this.xadataService.queryShpmst(mstmap);
				System.out.println("shpmstList size is "+shpmstList.size());
				if(shpmstList!=null && shpmstList.size()>0){

					shpmst = shpmstList.get(0);
					System.out.println("shpmst s135 is "+shpmst.getS135());
				}

				Map vennamMap = new HashMap();
				vennamMap.put("vndnr", pomast.getVndnr());
				List<VENNAMVO> vennamList = this.xadataService.queryVennam(vennamMap);
				System.out.println("vennamList's size is "+vennamList.size());
				if(vennamList!=null && vennamList.size()>0){

					vennam = vennamList.get(0);
					System.out.println("vennam's vn35 is "+vennam.getVn35());
				}

				txsuf = vennam.getTxsuf().trim();
				if(!txsuf.equals(""))
					txsuf = txsuf.substring(1, 3)+"%";

				Map poitemMap = new HashMap();
				poitemMap.put("ordno", pomast.getOrdno());
				List<POITEMVO> poitemList = this.xadataService.queryPoitem(poitemMap);
				System.out.println("poitemList's size is "+poitemList.size());
				pomast.setPoitemList(poitemList);
				for(POITEMVO poitem:poitemList){
					String blcod = poitem.getBlcod().trim();
					System.out.println("blcod is "+blcod);
					if(blcod.equals("1")){//总括订单
						Map blktmap = new HashMap();
						blktmap.put("ordno", poitem.getOrdno());
						List<POBLKTVO> blktList = this.xadataService.queryPoblkt(blktmap);
						System.out.println("blktList's size is "+blktList.size());
						poitem.setPoblktList(blktList);
						for(POBLKTVO poblkt:blktList){
							d= (poblkt.getDokdt()==null || poblkt.getDokdt().doubleValue()==0.0)?"":new BigDecimal(poblkt.getDokdt()).add(BigDecimal.valueOf(19000000)).toString().trim();
							poblkt.setDokdts((d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" ")));

							if(isOutSource){//如果是外协订单,配置上生产信息
								MOPORFVO moporf2 = new  MOPORFVO();
								moporf2.setPonr(poblkt.getOrdno());
								moporf2.setPisq(poblkt.getPoisq());
								moporf2.setLseq((int)(poblkt.getLinsq()));
								moporf2.setBksq((int)poblkt.getBlksq());
								List<MOPORFVO> moporfList2 = xadataService.queryMoporf(moporf2);
								System.out.println("moporfList2 size is "+moporfList2.size());
								if(moporfList2!=null && moporfList2.size()>0){//为外协订单
									moporf2 = moporfList2.get(0);
									poitem.setMoporf(moporf2);

									//取momast
									MOMASTVO momast = new MOMASTVO();
									momast.setOrdno(moporf2.getMonr());
									List<MOMASTVO> momastList = xadataService.queryMomast(momast);
									System.out.println("momastList size is "+momastList.size());
									if(momastList!=null && momastList.size()>0){
										poitem.setMomast(momastList.get(0));
									}

									//取morout
									Map<String,String> moroutMap = new HashMap<String, String>();
									moroutMap.put("ordno", moporf2.getMonr());
									moroutMap.put("opseq", moporf2.getOpsq());
									List<MOROUTVO> moroutList = xadataService.queryMorout(moroutMap);
									System.out.println("moroutList size is "+moroutList.size());
									if(moroutList!=null && moroutList.size()>0){
										poitem.setMorout(moroutList.get(0));
									}
									
									//取itmsit
									ITMSITVO itmsitvo = new ITMSITVO();
									itmsitvo.setHouse(pomast.getHouse());
									itmsitvo.setItnot9(momast.getFitem());
									List<String> umstt9List = this.xadataService.queryUmstt9(itmsitvo);
									System.out.println("umstt9List size is "+umstt9List.size());
									if(umstt9List!=null && umstt9List.size()>0){
										itmsitvo.setUmstt9(umstt9List.get(0));
										poitem.setItmsit(itmsitvo);
									}
									
									//取modata
									MODATAVO modata = new MODATAVO();
									modata.setOrdno(moporf2.getMonr());
									List<MODATAVO> modataList = xadataService.queryModatas(modata);
									System.out.println("modataList size is "+modataList.size());
									poitem.setModataList(modataList);
									
									//配置ZITEMBX
									for(MODATAVO modataP:modataList){
										ZITEMBXVO zitembx = new ZITEMBXVO();
										zitembx.setHouse(modataP.getCitwh());
										zitembx.setItnbr(modataP.getCitem());
										List<ZITEMBXVO> zitembxList = zitmbxService.queryItemBx(zitembx);
										System.out.println("zitembxList size is "+zitembxList.size());
										if(zitembxList!=null && zitembxList.size()>0){
											modataP.setZitembx(zitembxList.get(0));
										}
									}
								}
							}

						}
					}else{
						d= (poitem.getDokdt()==null || poitem.getDokdt().doubleValue()==0.0)?"":new BigDecimal(poitem.getDokdt()).add(BigDecimal.valueOf(19000000)).toString().trim();
						poitem.setDokdts((d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" ")));
					}
				}
			}
		}catch(Exception e){
			System.out.println(e);
			log.error("printO error", e);
			return ERROR;
		}
		return "printO";
	}
	/**
	 * 生成领料单
	 * @return
	 * @throws Exception
	 */
	public String toPomast() throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(pomast!=null){
				Map map = new HashMap();
				if(pomast.getOrdno()!=null && !pomast.getOrdno().trim().equals("")){
					if(pomast.getOrdno().indexOf(HGPJConstant.SPLIT_2)>=0){
						//						String[] ordnos = pomast.getOrdno().split(HGPJConstant.SPLIT_2);
						//						pomast.setOrdnodown(ordnos[0]);
						//						pomast.setOrdnoup(ordnos[1]);
					}else if(pomast.getOrdno().indexOf(HGPJConstant.SPLIT_0)>=0){
						String[] ordnos = pomast.getOrdno().split(HGPJConstant.SPLIT_0);
						String temp="";
						for(int i=0;i<ordnos.length;i++){
							if(!ordnos[i].trim().equals("")){
								temp=temp+"'"+ordnos[i].trim()+"',";
							}
						}
						//						pomast.setOrdnoF(temp);
						map.put("ordno", temp);
					}else if(pomast.getOrdno().indexOf(HGPJConstant.SPLIT_1)>=0){
						String[] ordnos = pomast.getOrdno().split(HGPJConstant.SPLIT_1);
						String temp="";
						for(int i=0;i<ordnos.length;i++){
							if(!ordnos[i].trim().equals("")){
								temp=temp+"'"+ordnos[i].trim()+"',";
							}
						}
						//						pomast.setOrdnoF(temp);
						map.put("ordno", temp);
					}else{
						//						pomast.setOrdnoF(pomast.getOrdno());
						map.put("ordno", pomast.getOrdno());
					}
				}
				//				Date d = sdf.parse(pomast.getStartDate());
				//				if(pomast.getStartDate()!=null && !pomast.getStartDate().trim().equals("")){
				//					pomast.setStartDateB(BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(pomast.getStartDate()), "yyMMdd"))));
				//				}
				//				if(pomast.getEndDate()!=null && !pomast.getEndDate().trim().equals("")){
				//					pomast.setEndDateB(BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(pomast.getEndDate()), "yyMMdd"))));
				//				}
				map.put("house", pomast.getHouse());
				map.put("vn35", pomast.getVn35());
				map.put("buyno", pomast.getBuyno());
				if(pomast.getStartDate()!=null && !pomast.getStartDate().trim().equals("")){
					//					momast.setStartDateB(BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(momast.getStartDate()), "yyMMdd"))));
					map.put("startDateB", BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(pomast.getStartDate()), "yyMMdd"))));
				}
				if(pomast.getEndDate()!=null && !pomast.getEndDate().trim().equals("")){
					//					momast.setEndDateB(BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(momast.getEndDate()), "yyMMdd"))));
					map.put("endDateB", BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(pomast.getEndDate()), "yyMMdd"))));
				}

				results = this.xadataService.queryPomast(map);
			}else{
				pomast = new POMASTVO();

				pomast.setStartDate(sdf.format(new Date()));
				pomast.setEndDate(sdf.format(new Date()));
			}
			if(results!=null && results.size()>0){
				for(int i=0;i<results.size();i++){
					String d= (results.get(i).getActdt()==null || results.get(i).getActdt().doubleValue()==0.0)?"":results.get(i).getActdt().add(BigDecimal.valueOf(19000000)).toString().trim();
					//					String d2 = (results.get(i).getOdudt()==null || results.get(i).getOdudt().doubleValue()==0.0)?"":results.get(i).getOdudt().add(BigDecimal.valueOf(19000000)).toString().trim();
					results.get(i).setActdts(d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" "));
					//					results.get(i).setSodudt(d2.length()<8?d2: (d2.substring(0, 4)+"-"+d2.substring(4, 6)+"-"+d2.substring(6, 8)+" "));
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
		return "toPomast";
	}

}
