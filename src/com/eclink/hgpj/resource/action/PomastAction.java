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
import com.eclink.hgpj.resource.biz.ZDELIDAService;
import com.eclink.hgpj.resource.biz.ZIPHDRService;
import com.eclink.hgpj.resource.biz.ZITMBXService;
import com.eclink.hgpj.resource.biz.ZITMEXTService;
import com.eclink.hgpj.resource.biz.ZMBD1REPService;
import com.eclink.hgpj.resource.biz.ZVRHDRService;
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
import com.eclink.hgpj.resource.vo.SCHRCPVO;
import com.eclink.hgpj.resource.vo.SHPMSTVO;
import com.eclink.hgpj.resource.vo.VENNAMVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZBMSRSNVO;
import com.eclink.hgpj.resource.vo.ZBMSU02VO;
import com.eclink.hgpj.resource.vo.ZDELIDAVO;
import com.eclink.hgpj.resource.vo.ZIPDTLVO;
import com.eclink.hgpj.resource.vo.ZIPHDRVO;
import com.eclink.hgpj.resource.vo.ZIPHSTVO;
import com.eclink.hgpj.resource.vo.ZITEMBXVO;
import com.eclink.hgpj.resource.vo.ZITMEXTVO;
import com.eclink.hgpj.resource.vo.ZMBD1REPVO;
import com.eclink.hgpj.resource.vo.ZVRHDRVO;
import com.eclink.hgpj.resource.vo.ZVRITMVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;
import com.eclink.hgpj.user.biz.AUserService;
import com.eclink.hgpj.util.QRcoderUtil;
import com.eclink.hgpj.util.Utils;
import com.opensymphony.xwork2.ActionContext;
import com.sun.org.apache.bcel.internal.generic.NEW;

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

	private ZDELIDAService zdelidaService;

	private POMASTVO pomast;

	private SCHRCPVO schrcp;

	private ZVRHDRVO zvrhdr;

	private VENNAMVO  vennam;

	private SHPMSTVO shpmst;

	private ZBMSCTLVO zbmsctl;

	private BUYERFVO buyerf;

	private AUserService auserService;

	private ZITMBXService zitmbxService;

	private ZBMSCTLService zbmsctlService;

	private ZVRHDRService zvrhdrService;

	private String ordno;

	private int language = 0;

	private String chk01;

	private String chk02;

	private String chk03;

	private String data;

	private String isdetail;

	private String cmmt;

	private String ostat;

	private String chk;

	private String buynm;

	private String txsuf;

	private String sctkji;

	private String vndrji;

	private String vrdno;

	private String vrdln;

	private String flag;

	private String blksq;

	private String returnType;

	private String quantity;

	private List<Map> pMaps;

	private List<POMASTVO> results;

	private List<SCHRCPVO> schrcpList ;

	private List<ZVRHDRVO> zvrhdrList;

	private boolean isOutSource = false ;


	private String grnno;

	private String whidji;

	private String ordrji;

	private String pisqji;

	private String bksqji;

	private String wkdtji;

	private String allow;


	private ZITMEXTService zitmextService;

	public boolean isOutSource() {
		return isOutSource;
	}

	public void setOutSource(boolean isOutSource) {
		this.isOutSource = isOutSource;
	}

	public ZITMEXTService getZitmextService() {
		return zitmextService;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setZitmextService(ZITMEXTService zitmextService) {
		this.zitmextService = zitmextService;
	}

	public String getAllow() {
		return allow;
	}

	public void setAllow(String allow) {
		this.allow = allow;
	}

	public String getWkdtji() {
		return wkdtji;
	}

	public void setWkdtji(String wkdtji) {
		this.wkdtji = wkdtji;
	}

	public String getPisqji() {
		return pisqji;
	}

	public void setPisqji(String pisqji) {
		this.pisqji = pisqji;
	}

	public String getBksqji() {
		return bksqji;
	}

	public void setBksqji(String bksqji) {
		this.bksqji = bksqji;
	}

	public ZDELIDAService getZdelidaService() {
		return zdelidaService;
	}

	public void setZdelidaService(ZDELIDAService zdelidaService) {
		this.zdelidaService = zdelidaService;
	}

	public String getWhidji() {
		return whidji;
	}

	public void setWhidji(String whidji) {
		this.whidji = whidji;
	}

	public String getOrdrji() {
		return ordrji;
	}

	public void setOrdrji(String ordrji) {
		this.ordrji = ordrji;
	}

	public String getGrnno() {
		return grnno;
	}

	public void setGrnno(String grnno) {
		this.grnno = grnno;
	}

	public String getSctkji() {
		return sctkji;
	}

	public void setSctkji(String sctkji) {
		this.sctkji = sctkji;
	}

	public String getOstat() {
		return ostat;
	}

	public void setOstat(String ostat) {
		this.ostat = ostat;
	}

	public String getVrdln() {
		return vrdln;
	}

	public void setVrdln(String vrdln) {
		this.vrdln = vrdln;
	}

	public String getBlksq() {
		return blksq;
	}

	public void setBlksq(String blksq) {
		this.blksq = blksq;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getVndrji() {
		return vndrji;
	}

	public void setVndrji(String vndrji) {
		this.vndrji = vndrji;
	}

	public XADATAService getXadataService() {
		return xadataService;
	}

	public ZVRHDRService getZvrhdrService() {
		return zvrhdrService;
	}

	public void setZvrhdrService(ZVRHDRService zvrhdrService) {
		this.zvrhdrService = zvrhdrService;
	}

	public List<SCHRCPVO> getSchrcpList() {
		return schrcpList;
	}

	public SCHRCPVO getSchrcp() {
		return schrcp;
	}

	public void setSchrcp(SCHRCPVO schrcp) {
		this.schrcp = schrcp;
	}

	public ZVRHDRVO getZvrhdr() {
		return zvrhdr;
	}

	public List<ZVRHDRVO> getZvrhdrList() {
		return zvrhdrList;
	}

	public void setZvrhdrList(List<ZVRHDRVO> zvrhdrList) {
		this.zvrhdrList = zvrhdrList;
	}

	public void setZvrhdr(ZVRHDRVO zvrhdr) {
		this.zvrhdr = zvrhdr;
	}

	public void setSchrcpList(List<SCHRCPVO> schrcpList) {
		this.schrcpList = schrcpList;
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



	public String getVrdno() {
		return vrdno;
	}

	public void setVrdno(String vrdno) {
		this.vrdno = vrdno;
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
		Map resultMap = new HashMap();
		try{

			Map map = new HashMap();
			map.put("ordnoO", ordno);

			results = this.xadataService.queryPomast(map);
			System.out.println("result's size is "+results.size());
			if(results!=null && results.size()>0){
				pomast = results.get(0);

				resultMap.put("house", pomast.getHouse());
				resultMap.put("ordno", pomast.getOrdno());
				resultMap.put("revnb", pomast.getRevnb());
				resultMap.put("sn35", pomast.getSn35());
				resultMap.put("s135", pomast.getS135());
				resultMap.put("s235", pomast.getS235());
				resultMap.put("buyno", pomast.getBuyno());
				resultMap.put("vndnr", pomast.getVndnr());
				resultMap.put("trmds", pomast.getTrmds());
				resultMap.put("viads", pomast.getViads());


				//判断是否为外协订单
				MOPORFVO moporf = new  MOPORFVO();
				moporf.setPonr(pomast.getOrdno());
				List<MOPORFVO> moporfList = xadataService.queryMoporf(moporf);
				System.out.println("moporfList size is "+moporfList.size());
				if(moporfList!=null && moporfList.size()>0){//为外协订单
					isOutSource = true;
					resultMap.put("outSource", true);
				}else {
					resultMap.put("outSource", false);
				}

				String d= (pomast.getActdt()==null || pomast.getActdt().doubleValue()==0.0)?"":pomast.getActdt().add(BigDecimal.valueOf(19000000)).toString().trim();
				pomast.setActdts((d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" ")));
				resultMap.put("actdts", pomast.getActdts());

				zbmsctl = new ZBMSCTLVO();
				zbmsctl.setSite((String) getSession().getAttribute("stid"));
				List<ZBMSCTLVO> bmsctlList = this.zbmsctlService.queryZbmsctl(zbmsctl);
				System.out.println("bmsctlList size is "+bmsctlList.size());
				if(bmsctlList!=null && bmsctlList.size()>0){
					zbmsctl = bmsctlList.get(0);
					resultMap.put("nmchs", zbmsctl.getNmchs());
					resultMap.put("nmeng", zbmsctl.getNmeng());

					if(pomast.getCurid() == null || pomast.getCurid().trim().equals("")){
						if(zbmsctl.getCurid() == null || zbmsctl.getCurid().trim().equals("")){
							resultMap.put("curid","CNY");
						}else{
							resultMap.put("curid",zbmsctl.getCurid());
						}
					}else{
						resultMap.put("curid",pomast.getCurid());
					}
				}

				System.out.println("pomast's buyno is "+pomast.getBuyno());
				Map buynmMap = new HashMap();
				buynmMap.put("buyno", pomast.getBuyno());
				buynm = this.xadataService.queryBuyer(buynmMap);
				System.out.println("buynm is "+buynm);
				resultMap.put("buynm", buynm);

				System.out.println("pomast's house is "+pomast.getHouse());
				Map mstmap = new HashMap();
				mstmap.put("house", pomast.getHouse());
				mstmap.put("shpid", pomast.getBilid());
				List<SHPMSTVO> shpmstList = this.xadataService.queryShpmst(mstmap);
				System.out.println("shpmstList size is "+shpmstList.size());
				if(shpmstList!=null && shpmstList.size()>0){
					shpmst = shpmstList.get(0);
					System.out.println("shpmst s135 is "+shpmst.getS135());
					resultMap.put("shpnm", shpmst.getShpnm());
					resultMap.put("shpmst_s135", shpmst.getS135());
					resultMap.put("shpmst_s235", shpmst.getS235());
					resultMap.put("scont", shpmst.getScont());
				}

				Map vennamMap = new HashMap();
				vennamMap.put("vndnr", pomast.getVndnr());
				List<VENNAMVO> vennamList = this.xadataService.queryVennam(vennamMap);
				System.out.println("vennamList's size is "+vennamList.size());
				if(vennamList!=null && vennamList.size()>0){

					vennam = vennamList.get(0);
					resultMap.put("vn35", vennam.getVn35());
					resultMap.put("vcont", vennam.getVcont());
				}

				txsuf = vennam.getTxsuf().trim();
				if(!txsuf.equals(""))
					txsuf = txsuf.trim().substring(1, 3);
				else {
					txsuf = "0";
				}
				resultMap.put("txsuf",Integer.parseInt(txsuf));

				Map poitemMap = new HashMap();
				poitemMap.put("ordno", pomast.getOrdno());
				List<POITEMVO> poitemList = this.xadataService.queryPoitem(poitemMap);
				System.out.println("poitemList's size is "+poitemList.size());
				pomast.setPoitemList(poitemList);

				List<Map> item = new ArrayList<Map>();
				resultMap.put("item", item);

				for(POITEMVO poitem:poitemList){
					Map son1 = new HashMap();
					item.add(son1);
					String blcod = poitem.getBlcod().trim();
					son1.put("staic", poitem.getStaic().trim());
					son1.put("blcod", blcod.trim());//是否总括订单
					son1.put("itnbr", poitem.getItnbr());
					son1.put("itdsc", poitem.getItdsc());
					son1.put("ucorq", poitem.getUcorq());
					son1.put("curpr", poitem.getCurpr());
					if(blcod.equals("1")){//总括订单
						Map blktmap = new HashMap();
						blktmap.put("ordno", poitem.getOrdno());
						List<POBLKTVO> blktList = this.xadataService.queryPoblkt(blktmap);
						System.out.println("blktList's size is "+blktList.size());
						poitem.setPoblktList(blktList);

						List<Map> son1_ = new ArrayList<Map>();
						son1.put("son1_", son1_);

						for(POBLKTVO poblkt:blktList){
							d= (poblkt.getDokdt()==null || poblkt.getDokdt().doubleValue()==0.0)?"":new BigDecimal(poblkt.getDokdt()).add(BigDecimal.valueOf(19000000)).toString().trim();
							poblkt.setDokdts((d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" ")));

							Map son11 = new HashMap();
							son1_.add(son11);
							son11.put("staic", poblkt.getStaic().trim());
							son11.put("dokdts", poblkt.getDokdts());
							son11.put("relqt", poblkt.getRelqt());

							if(isOutSource){//如果是外协订单,配置上生产信息(根据苏老师解答,委外订单不会出现总括!!!!)
								Map son2=  new HashMap();
								son11.put("son2", son2);

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
									son2.put("monr", moporf2.getMonr());
									son2.put("opsq", moporf2.getOpsq());

									//取momast
									MOMASTVO momast = new MOMASTVO();
									momast.setOrdnoF(new String[]{moporf2.getMonr()});
									List<MOMASTVO> momastList = xadataService.queryMomast(momast);
									System.out.println("momastList size is "+momastList.size());
									if(momastList!=null && momastList.size()>0){
										MOMASTVO momastvo = momastList.get(0);
										poitem.setMomast(momastvo);
										son2.put("fitem", momastvo.getFitem());
										son2.put("fdesc", momastvo.getFdesc());
										son2.put("orqty", momastvo.getOrqty());
										son2.put("qtdev", momastvo.getQtdev());
									}

									//取morout
									Map<String,String> moroutMap = new HashMap<String, String>();
									moroutMap.put("ordno", moporf2.getMonr());
									moroutMap.put("opseq", moporf2.getOpsq());
									List<MOROUTVO> moroutList = xadataService.queryMorout(moroutMap);
									System.out.println("moroutList size is "+moroutList.size());
									if(moroutList!=null && moroutList.size()>0){
										MOROUTVO moroutvo = moroutList.get(0);
										poitem.setMorout(moroutList.get(0));
										son2.put("opdsc", moroutvo.getOpdsc());
									}

									//取itmsit
									ITMSITVO itmsitvo = new ITMSITVO();
									itmsitvo.setHouse(pomast.getHouse());
									itmsitvo.setItnot9((String) (son2.containsKey("fitem")?son2.get("fitem"):""));
									List<String> umstt9List = this.xadataService.queryUmstt9(itmsitvo);
									System.out.println("umstt9List size is "+umstt9List.size());
									if(umstt9List!=null && umstt9List.size()>0){
										itmsitvo.setUmstt9(umstt9List.get(0));
										poitem.setItmsit(itmsitvo);
										son2.put("umstt9", umstt9List.get(0));
									}



									//取modata
									MODATAVO modata = new MODATAVO();
									modata.setOrdno(moporf2.getMonr());
									List<MODATAVO> modataList = xadataService.queryModatas(modata);
									System.out.println("modataList size is "+modataList.size());
									poitem.setModataList(modataList);
									List<Map> son2_ = new ArrayList<Map>();
									son2.put("son2_", son2_);
									for(MODATAVO modatavo:modataList){
										Map son22 = new HashMap();
										son2_.add(son22);
										son22.put("citem", modatavo.getCitem());
										son22.put("cdesc", modatavo.getCdesc());
										son22.put("qtreq", modatavo.getQtreq());
										son22.put("unmsr", modatavo.getUnmsr());

										ZITEMBXVO zitembx = new ZITEMBXVO();
										zitembx.setHouse(modatavo.getCitwh());
										zitembx.setItnbr(modatavo.getCitem());
										List<ZITEMBXVO> zitembxList = zitmbxService.queryItemBx(zitembx);
										if(zitembxList!=null && zitembxList.size()>0){
											modatavo.setZitembx(zitembxList.get(0));
											son22.put("whsub2", zitembxList.get(0).getWhsub2());
										}
									}
								}
							}
						}
					}else{
						d= (poitem.getDokdt()==null || poitem.getDokdt().doubleValue()==0.0)?"":new BigDecimal(poitem.getDokdt()).add(BigDecimal.valueOf(19000000)).toString().trim();
						poitem.setDokdts((d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" ")));
						son1.put("dokdts", poitem.getDokdts());

						if(isOutSource){//如果是外协订单,配置上生产信息
							Map son2=  new HashMap();
							son1.put("son2", son2);

							MOPORFVO moporf2 = new  MOPORFVO();
							moporf2.setPonr(poitem.getOrdno());
							moporf2.setPisq(poitem.getPoisq());
							moporf2.setLseq((int)(poitem.getLinsq()));
							List<MOPORFVO> moporfList2 = xadataService.queryMoporf(moporf2);
							if(moporfList2!=null && moporfList2.size()>0){//为外协订单
								moporf2 = moporfList2.get(0);
								poitem.setMoporf(moporf2);
								son2.put("monr", moporf2.getMonr());
								son2.put("opsq", moporf2.getOpsq());

								//取momast
								MOMASTVO momast = new MOMASTVO();
								momast.setOrdno(moporf2.getMonr());
								List<MOMASTVO> momastList = xadataService.queryMomastByordno(momast);
								System.out.println("momastList size is "+momastList.size());
								if(momastList!=null && momastList.size()>0){
									MOMASTVO momastvo = momastList.get(0);
									poitem.setMomast(momastvo);
									son2.put("fitem", momastvo.getFitem());
									son2.put("fdesc", momastvo.getFdesc());
									son2.put("orqty", momastvo.getOrqty());
									son2.put("qtdev", momastvo.getQtdev());
								}

								//取morout
								Map<String,String> moroutMap = new HashMap<String, String>();
								moroutMap.put("ordno", moporf2.getMonr());
								moroutMap.put("opseq", moporf2.getOpsq());
								List<MOROUTVO> moroutList = xadataService.queryMorout(moroutMap);
								System.out.println("moroutList size is "+moroutList.size());
								if(moroutList!=null && moroutList.size()>0){
									MOROUTVO moroutvo = moroutList.get(0);
									poitem.setMorout(moroutList.get(0));
									son2.put("opdsc", moroutvo.getOpdsc());
								}

								//取itmsit
								ITMSITVO itmsitvo = new ITMSITVO();
								itmsitvo.setHouse(pomast.getHouse());
								itmsitvo.setItnot9((String) (son2.containsKey("fitem")?son2.get("fitem"):""));
								List<ITMSITVO> itmsitvos = this.xadataService.queryItrvtAll(itmsitvo);
								System.out.println("itmsitvos size is "+itmsitvos.size());
								if(itmsitvos!=null && itmsitvos.size()>0){
									poitem.setItmsit(itmsitvos.get(0));
									son2.put("umstt9", itmsitvos.get(0).getUmstt9());
								}



								//取modata
								MODATAVO modata = new MODATAVO();
								modata.setOrdno(moporf2.getMonr());
								List<MODATAVO> modataList = xadataService.queryModatas(modata);
								System.out.println("modataList size is "+modataList.size());
								poitem.setModataList(modataList);
								List<Map> son2_ = new ArrayList<Map>();
								son2.put("son2_", son2_);
								for(MODATAVO modatavo:modataList){
									Map son22 = new HashMap();
									son2_.add(son22);
									son22.put("citem", modatavo.getCitem());
									son22.put("cdesc", modatavo.getCdesc());
									son22.put("qtreq", modatavo.getQtreq());
									son22.put("unmsr", modatavo.getUnmsr());

									ZITEMBXVO zitembx = new ZITEMBXVO();
									zitembx.setHouse(modatavo.getCitwh());
									zitembx.setItnbr(modatavo.getCitem());
									List<ZITEMBXVO> zitembxList = zitmbxService.queryItemBx(zitembx);
									if(zitembxList!=null && zitembxList.size()>0){
										modatavo.setZitembx(zitembxList.get(0));
										son22.put("whsub2", zitembxList.get(0).getWhsub2());
									}
								}
							}
						}
					}


				}
			}
		}catch(Exception e){
			System.out.println(e);
			log.error("printO error", e);
			return ERROR;
		}
		ActionContext.getContext().getValueStack().set("resultMap", resultMap);
		return "printO";
	}

	public String toPomast() throws Exception {
		try {
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

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(!"1".equals(flag)){
				pomast = new POMASTVO();
				this.pomast.setStartDate(Utils.formateDate(null, "yyyy-MM-dd"));
				this.pomast.setEndDate(Utils.formateDate(null, "yyyy-MM-dd"));
			}else{
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
									temp=temp+ordnos[i].trim()+",";
								}
							}
							temp=temp.substring(0, temp.length()-1);
							map.put("ordno", ordnos);
						}else if(pomast.getOrdno().indexOf(HGPJConstant.SPLIT_1)>=0){
							String[] ordnos = pomast.getOrdno().split(HGPJConstant.SPLIT_1);
							String temp="";
							for(int i=0;i<ordnos.length;i++){
								if(!ordnos[i].trim().equals("")){
									temp=temp+ordnos[i].trim()+",";
								}
							}
							temp=temp.substring(0, temp.length()-1);
							//						pomast.setOrdnoF(temp);
							map.put("ordno", ordnos);
						}else{
							//						pomast.setOrdnoF(pomast.getOrdno());
							map.put("ordno",new String[]{pomast.getOrdno()});
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

					if(results!=null && results.size()>0){
						for(int i=0;i<results.size();i++){
							String d= (results.get(i).getActdt()==null || results.get(i).getActdt().doubleValue()==0.0)?"":results.get(i).getActdt().add(BigDecimal.valueOf(19000000)).toString().trim();
							//					String d2 = (results.get(i).getOdudt()==null || results.get(i).getOdudt().doubleValue()==0.0)?"":results.get(i).getOdudt().add(BigDecimal.valueOf(19000000)).toString().trim();
							results.get(i).setActdts(d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" "));
							//					results.get(i).setSodudt(d2.length()<8?d2: (d2.substring(0, 4)+"-"+d2.substring(4, 6)+"-"+d2.substring(6, 8)+" "));
						}
					}
				}
			}


		} catch (Exception e) {e.printStackTrace();
		log.error("Go to admin resource operation grant page occured error.", e);
		return ERROR;
		}
		return "toPomast";
	}

	public String toPomastReturn() throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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

			if(!"1".equals(flag)){
				zvrhdr = new ZVRHDRVO();
				this.zvrhdr.setStartDate(Utils.formateDate(null, "yyyy-MM-dd"));
				this.zvrhdr.setEndDate(Utils.formateDate(null, "yyyy-MM-dd"));
			}else{
				if(zvrhdr!=null){
					Map map = new HashMap();
					if(zvrhdr.getVrdno()!=null && !zvrhdr.getVrdno().trim().equals("")){
						if(zvrhdr.getVrdno().indexOf(HGPJConstant.SPLIT_0)>=0){
							String[] vrdnos = zvrhdr.getVrdno().split(HGPJConstant.SPLIT_0);
							map.put("vrdno", vrdnos);
						}else if(zvrhdr.getVrdno().indexOf(HGPJConstant.SPLIT_1)>=0){
							String[] vrdnos = zvrhdr.getVrdno().split(HGPJConstant.SPLIT_1);
							map.put("vrdno", vrdnos);
						}else{
							//						pomast.setOrdnoF(pomast.getOrdno());
							map.put("vrdno", new String[]{zvrhdr.getVrdno()});
						}
					}
					if(zvrhdr.getVndnr()!=null && !zvrhdr.getVndnr().trim().equals("")){
						if(zvrhdr.getVndnr().indexOf(HGPJConstant.SPLIT_0)>=0){
							String[] vndnrs = zvrhdr.getVndnr().split(HGPJConstant.SPLIT_0);
							map.put("vndnr", vndnrs);
						}else if(zvrhdr.getVndnr().indexOf(HGPJConstant.SPLIT_1)>=0){
							String[] vndnrs = zvrhdr.getVndnr().split(HGPJConstant.SPLIT_1);
							map.put("vndnr", vndnrs);
						}else{
							//						pomast.setOrdnoF(pomast.getOrdno());
							map.put("vndnr", new String[]{zvrhdr.getVndnr()});
						}
					}
					
					if(zvrhdr.getStartDate()!=null && !zvrhdr.getStartDate().trim().equals("")){
						//					momast.setStartDateB(BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(momast.getStartDate()), "yyMMdd"))));
						map.put("startDate", BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(zvrhdr.getStartDate()), "yyMMdd"))));
					}
					if(zvrhdr.getEndDate()!=null && !zvrhdr.getEndDate().trim().equals("")){
						//					momast.setEndDateB(BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(momast.getEndDate()), "yyMMdd"))));
						map.put("endDate", BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(zvrhdr.getEndDate()), "yyMMdd"))));
					}

					map.put("ostat", ostat);
					zvrhdrList = zvrhdrService.queryZvrhdr(map);
					List<Map> results = new ArrayList<Map>();
					for(ZVRHDRVO zvrhdrvo:zvrhdrList){
						Map result = new HashMap();
						results.add(result);
						result.put("vrdno", zvrhdrvo.getVrdno());
						result.put("vndnr", zvrhdrvo.getVndnr());
						result.put("ostat", zvrhdrvo.getOstat());
						result.put("crus", zvrhdrvo.getCrus());
						result.put("crdt", Utils.db2DateFormat(zvrhdrvo.getCrdt().add(new BigDecimal("19000000")).intValue()));
						result.put("crtm", Utils.db2TimeFormat(zvrhdrvo.getCrtm().intValue()));
						
					}
					ActionContext.getContext().getValueStack().set("results", results);
				}
			}


		} catch (Exception e) {e.printStackTrace();
		log.error("Go to admin resource operation grant page occured error.", e);
		return ERROR;
		}
		return "toPomastReturn";
	}

	public String toPomastReturnInquire() throws Exception {
		try {
			Map map = new HashMap();
			map.put("vndnr", vndrji);
			map.put("ostat", "05");

			List<ZVRHDRVO> zvrhdrList = zvrhdrService.queryZvrhdr(map);
			if(zvrhdrList.size()>0){//存在创建中的退货单,可以添加到此退货单中
				ActionContext.getContext().getValueStack().set("zvrhdrList", zvrhdrList);
			}
			ActionContext.getContext().getValueStack().set("zvrhdrList", zvrhdrList);

		} catch (Exception e) {e.printStackTrace();
		log.error("Go to admin resource operation grant page occured error.", e);
		return ERROR;
		}
		return "toPomastReturnInquire";
	}

	public String toPomastReturnSubmit() throws Exception {
		try {
			SCHRCPVO  schrcpvo = new SCHRCPVO();
			schrcpvo.setSctkji(sctkji);
			List<SCHRCPVO> schrcpList = xadataService.querySchrcp(schrcpvo);
			if(schrcpList.size()>0){
				schrcpvo = schrcpList.get(0);
				ZVRITMVO vo = new ZVRITMVO();
				vo.setVndnr(schrcpvo.getVndrji());
				vo.setHouse((String) getSession().getAttribute("stid"));
				vo.setOrdno(schrcpvo.getOrdrji());
				vo.setPoisq(schrcpvo.getPisqji());
				//				vo.setBlcod(schrcpvo.getBksqji().compareTo(new BigDecimal(0)) == 0 ? "0":"1");
				vo.setBlksq(schrcpvo.getBksqji());
				vo.setLstat("10");
				vo.setItnbr(schrcpvo.getItnoji());
				ITMSITVO itmsitvo = new ITMSITVO();
				itmsitvo.setHouse((String) getSession().getAttribute("stid"));
				itmsitvo.setItnot9(schrcpvo.getItnoji());
				List<ITMSITVO> queryItrvtAll = xadataService.queryItrvtAll(itmsitvo);
				if(queryItrvtAll.size()>0){
					vo.setBlcf(queryItrvtAll.get(0).getBlcft9());
				}else{
					vo.setBlcf("0");
				}
				vo.setStkum(schrcpvo.getUmstji());
				vo.setSctkji(sctkji);
				vo.setPlnvq(new BigDecimal(quantity));
				if(returnType.equals("0")){
					String crus = (String) ServletActionContext.getContext().getSession().get("username");
					String house = (String) getSession().getAttribute("stid");
					vrdno = zvrhdrService.insertZvritmNewHdr(vo, crus,house);
				}else if(returnType.equals("1") && vrdno!=null && !vrdno.trim().equals("")){
					vo.setVrdno(vrdno);
					zvrhdrService.insertZvritm(vo);
				}else{
					throw new RuntimeException();
				}
				data = "success";
			}else{
				throw new RuntimeException();
			}

		} catch (Exception e) {e.printStackTrace();
		data = "fail";
		log.error("Go to admin resource operation grant page occured error.", e);
		}
		return "toPomastReturnSubmit";
	}

	public String toSchrcp() throws Exception {
		try {
			SCHRCPVO vo = new SCHRCPVO();
			vo.setOrdrji(ordno);
			schrcpList = xadataService.querySchrcp(vo);
		} catch (Exception e) {e.printStackTrace();
		log.error("Go to admin resource operation grant page occured error.", e);
		return ERROR;
		}
		return "toSchrcp";
	}

	public String toZvritm() throws Exception {
		try {
			Map map = new HashMap();
			map.put("vrdno", vrdno);
			List<ZVRITMVO> zvritmList = zvrhdrService.queryZvritm(map);
			ActionContext.getContext().getValueStack().set("zvritmList", zvritmList);
		} catch (Exception e) {e.printStackTrace();
		log.error("Go to admin resource operation grant page occured error.", e);
		return ERROR;
		}
		return "toZvritm";
	}

	public String deleteZvritm() throws Exception {
		try {
			ZVRITMVO vo = new ZVRITMVO();
			vo.setVrdno(vrdno);
			vo.setVrdln(new BigDecimal(vrdln));
			vo.setBlksq(new BigDecimal(blksq));
			zvrhdrService.deleteZvritm(vo);
			data = "success";
		} catch (Throwable e) {e.printStackTrace();
		log.error("Go to admin resource operation grant page occured error.", e);
		data = "fail";
		}
		return "todata";
	}

	public String enableCreateZvritm() throws Exception {
		try {
			if(vrdno == null || vrdno.trim().equals("")){
				throw new RuntimeException();
			}else{
				zvrhdrService.enableCreateZvrhdr(vrdno);
				data = "success";
			}
		} catch (Throwable e) {e.printStackTrace();
		log.error("Go to admin resource operation grant page occured error.", e);
		data = "fail";
		}
		return "todata";
	}

	public String cancelZvritm() throws Exception {
		try {
			if(vrdno == null || vrdno.trim().equals("")){
				throw new RuntimeException();
			}else{
				zvrhdrService.cancelZvrhdr(vrdno);
				data = "success";
			}
		} catch (Throwable e) {e.printStackTrace();
		log.error("Go to admin resource operation grant page occured error.", e);
		data = "fail";
		}
		return "todata";
	}

	public String toPrintZvrhdr() throws Exception{
		try {
			List<Map> results = new ArrayList<Map>();
			JSONArray jsonArray = JSONObject.fromObject(grnno).getJSONArray("grnnos");
			for(int i = 0;i<jsonArray.size();i++){
				Map parMap = new HashMap();
//				parMap.put("vrdno", "'"+jsonArray.get(i)+"'");
				parMap.put("vrdno", new String[]{jsonArray.getString(i)});
				List<ZVRHDRVO> queryZvrhdr = zvrhdrService.queryZvrhdr(parMap);
				for(ZVRHDRVO zvrhdrvo:queryZvrhdr){
					Map zvrhdrMap = new HashMap();
					zvrhdrMap.put("vrdno", zvrhdrvo.getVrdno());
					zvrhdrMap.put("house", zvrhdrvo.getHouse());
					zvrhdrMap.put("vndnr", zvrhdrvo.getVndnr());
					zvrhdrMap.put("printDate", Utils.formateDate(null, "yyyy/MM/dd HH:mm:ss"));

					String qrMessage = "*V"+zvrhdrvo.getVrdno();
					String encoderQRCoder = QRcoderUtil.encoderQRCoder(qrMessage, ServletActionContext.getContext().getSession().get("username").toString(),getSession().getServletContext().getRealPath("/"));
					HttpServletRequest request = ServletActionContext.getRequest();
					String path = request.getContextPath(); 
					String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
					zvrhdrMap.put("qrcodeurl", basePath+"/"+encoderQRCoder);

					List<Map> zvritmList = new ArrayList<Map>();
					zvrhdrMap.put("zvritmList", zvritmList);
					Map parMap2 = new HashMap();
					parMap2.put("vrdno", jsonArray.get(i));
					List<ZVRITMVO> queryZvritm = zvrhdrService.queryZvritm(parMap2);
					for(ZVRITMVO zvritmvo:queryZvritm){
						Map zvritmMap = new HashMap();
						zvritmMap.put("ordno_poisq", zvritmvo.getOrdno()+"-"+zvritmvo.getPoisq());
						zvritmMap.put("itnbr", zvritmvo.getItnbr().trim());

						///
						String ldesc = "";
						ITMSITVO itmsitvo = new ITMSITVO();
						itmsitvo.setHouse((String) getSession().getAttribute("stid"));
						itmsitvo.setItnot9(zvritmvo.getItnbr());
						List<ITMSITVO> itrvts = this.xadataService.queryItrvtAll(itmsitvo);
						if(itrvts!=null && itrvts.size()>0){
							ZITMEXTVO extVo = new ZITMEXTVO();
							ITMSITVO itmsitvot = itrvts.get(0);
							extVo.setItnbr(zvritmvo.getItnbr());
							extVo.setStid((String) getSession().getAttribute("stid"));
							extVo.setItrv(itmsitvot.getItrvt9().trim());
							List<ZITMEXTVO> extLists = this.zitmextService.queryItemExt(extVo);
							ITMRVAVO itmrVo = new ITMRVAVO();
							itmrVo.setItnbr(zvritmvo.getItnbr());
							itmrVo.setHouse((String) getSession().getAttribute("stid"));
							itmrVo.setItrv(itmsitvot.getItrvt9().trim());
							List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
							if(extLists!=null && extLists.size()>0 && extLists.get(0).getLdesc().trim().length()>0){
								ldesc=extLists.get(0).getLdesc();
							}else{
								if(itmrLists!=null && itmrLists.size()>0){
									ldesc=itmrLists.get(0).getItdsc();
								}
							}
						}
						zvritmMap.put("ldesc", ldesc);
						///

						zvritmMap.put("plnvq", zvritmvo.getPlnvq().doubleValue());
						zvritmMap.put("stkum", zvritmvo.getStkum());
						zvritmMap.put("plloc", zvritmvo.getPlloc());
						zvritmList.add(zvritmMap);
					}
					results.add(zvrhdrMap);
				}
			}
			ActionContext.getContext().getValueStack().set("results", results);
			return "toPrintZvrhdr";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR;
		}

	}

	public String toEnsureList() throws Exception{
		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		numberFormat.setGroupingUsed(false);
		numberFormat.setRoundingMode(RoundingMode.UP);
		
		try {
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

			if(!"1".equals(flag)){
				
			}else{

				List<Map> results = new ArrayList();
				Map map = new HashMap();
				map.put("ordrji", ordrji);
				map.put("whidji", whidji);
				map.put("staus", "10");
				List<ZDELIDAVO> queryZdelida = zdelidaService.queryZdelida(map);
				for(ZDELIDAVO zdelidavo:queryZdelida){
					SCHRCPVO schrcpvo = new SCHRCPVO();
					schrcpvo.setOrdrji(zdelidavo.getOrdrji());
					schrcpvo.setPisqji(zdelidavo.getPisqji());
					schrcpvo.setBksqji(zdelidavo.getBksqji());
					List<SCHRCPVO> querySchrcp = xadataService.querySchrcp(schrcpvo);
					if(querySchrcp.size()>0){
						schrcpvo = querySchrcp.get(0);
						Map item = new HashMap();
						item.put("whidji", schrcpvo.getWhidji());
						item.put("ordrji", schrcpvo.getOrdrji());
						item.put("pisqji", schrcpvo.getPisqji().intValue());
						item.put("bksqji", schrcpvo.getBksqji().intValue());
						item.put("itnoji", schrcpvo.getItnoji());
						item.put("ds40ji", schrcpvo.getDs40ji());
						item.put("orumji", schrcpvo.getOrumji());
						numberFormat.setMaximumFractionDigits(1);
						numberFormat.setMinimumFractionDigits(1);
						item.put("ucoqji",numberFormat.format( schrcpvo.getUcoqji()));
						item.put("qtyoji", numberFormat.format(schrcpvo.getQtyoji()));
						item.put("wkdtji",Utils.db2DateFormat(zdelidavo.getWkdtji().add(new BigDecimal(19000000)).intValue()));
						item.put("dkdtji", Utils.db2DateFormat(schrcpvo.getDkdtji().add(new BigDecimal(19000000)).intValue()));
						results.add(item);
					}
				}
				ActionContext.getContext().getValueStack().set("results", results);
			}
			return "toEnsureList";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	public String auditZdelida(){
		try {
			Map parames = new HashMap();
			parames.put("sluserId", this.getSession().getServletContext().getAttribute("sluserId"));
			parames.put("slpassword", this.getSession().getServletContext().getAttribute("slpassword"));
			parames.put("slurl", this.getSession().getServletContext().getAttribute("slurl"));
			parames.put("ordrji", ordrji);
			parames.put("pisqji", pisqji);
			parames.put("bksqji", bksqji);
			SimpleDateFormat sf  = new SimpleDateFormat("yyyy-MM-dd");
			parames.put("wkdtji", new SimpleDateFormat("yyyyMMdd").format(sf.parse(wkdtji)));
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			String currentDate = dateFormat.format(new Date());
			parames.put("currentDate", currentDate);
			if(allow.equals("1")){
				parames.put("staus", "40");
			}else{
				parames.put("staus", "50");
			}
			System.out.println("wyj11");
			data = zdelidaService.auditZdelida(parames);
			return "todata";
		} catch (Throwable e) {e.printStackTrace();
		log.error("Go to admin resource operation grant page occured error.", e);
		data = "fail";
		return ERROR;
		}
	
	}
}
