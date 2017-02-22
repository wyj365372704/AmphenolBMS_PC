package com.eclink.hgpj.resource.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.eclink.hgpj.resource.vo.ZITEMBXVO;
import com.eclink.hgpj.resource.vo.ZMBD1REPVO;
import com.eclink.hgpj.user.biz.AUserService;
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
public class ZiphdrAction extends BaseAction {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(ZiphdrAction.class);
	
	
	private ZIPHDRService ziphdrService;
	
	private AUserService auserService;
	
	private ZITMBXService zitmbxService;
	
	private XADATAService xadataService;
	
	private ZMBD1REPService zmbd1repService;
	
	private ZIPDTLVO zipdtlvo;
	
	private String ordno;
	
	private String iptyp;
	
	private String ipdno;
	
	private String ipdln;
	
	private String cmmt;
	
	private String house;
	
	private String citem;
	
	private String seqnm;
	
	private String data;
	
	private String shqty;
	
	private String reason;

	private String flag;
	
	private String startDate;
	
	private String endDate;
	
	private List<ZIPHDRVO> results;
	
	private List<ZIPDTLVO> dresults;
	
	private List<MODATAVO> mresults;
	
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

	public String getShqty() {
		return shqty;
	}

	public void setShqty(String shqty) {
		this.shqty = shqty;
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


	public String getIpdln() {
		return ipdln;
	}

	public void setIpdln(String ipdln) {
		this.ipdln = ipdln;
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

	public String getIpdno() {
		return ipdno;
	}

	public void setIpdno(String ipdno) {
		this.ipdno = ipdno;
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

	public List<ZIPHDRVO> getResults() {
		return results;
	}

	public void setResults(List<ZIPHDRVO> results) {
		this.results = results;
	}

	public List<ZIPDTLVO> getDresults() {
		return dresults;
	}

	public void setDresults(List<ZIPDTLVO> dresults) {
		this.dresults = dresults;
	}

	public List<MODATAVO> getMresults() {
		return mresults;
	}

	public void setMresults(List<MODATAVO> mresults) {
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

	/**
	 * 进入生产订单信息页面
	 * @return
	 * @throws Exception
	 */
	public String addZipdtl() throws Exception {
		try {
			MOMASTVO mastvo = new MOMASTVO();
			mastvo.setOrdno(ordno);
			List<MOMASTVO> resultsT = this.xadataService.queryMomastByordno(mastvo);
			MOMASTVO rettemp = resultsT.get(0);
			MODATAVO vo = new MODATAVO();
			vo.setOrdno(ordno.trim());
			vo.setCitwh(house);
			vo.setSeqnm(BigDecimal.valueOf(Long.valueOf(seqnm)));
			List<MODATAVO> results = this.xadataService.queryModatas(vo);
			MODATAVO temp = results.get(0);
			Map map = new HashMap();
			map.put("ipdno", ipdno);
			int count=this.ziphdrService.getDtlCoutsBypar(map);
			ZIPDTLVO ivo = new ZIPDTLVO();
			ivo.setIpdno(ipdno);
			ivo.setIpdln(BigDecimal.valueOf(count+1));
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
			if("1".equals(iptyp)){
				ZIPDTLVO pvo = new ZIPDTLVO();
				pvo.setOrdno(temp.getOrdno());
				pvo.setCitem(temp.getCitem());
				//该工单该物料的所有领料单的计划数量总和
				double shqty = this.ziphdrService.getAllshqty(pvo);
//				double shqty = 0;
				BigDecimal unqty = rettemp.getOrqty().add(rettemp.getQtdev()).multiply(temp.getQtypre()).add(temp.getIsqty().negate()).add(BigDecimal.valueOf(shqty).negate());
				
				ZMBD1REPVO prepvo = new ZMBD1REPVO();
				prepvo.setDbcqcd(temp.getUnmsr());
				List<ZMBD1REPVO> repvos = this.zmbd1repService.queryZmbd1erp(prepvo);
				if(repvos!=null && repvos.size()>0){
					ZMBD1REPVO repvo = repvos.get(0);
					ivo.setShqty(Utils.round(unqty, repvo.getDbdcml().intValue(), repvo.getDbrnd().trim()));
				}else{
					ivo.setShqty(unqty);
				}
				if("1".equals(iptyp) && unqty.doubleValue()<=0){
					data="other";
					reason="该物料已全部领完";
					return "toAddZipdtl";
				}
			}else{
				ivo.setShqty(BigDecimal.valueOf(0));
			}
			
			ivo.setAcqty(BigDecimal.valueOf(0));
			ivo.setLstat("05");
			ivo.setLprt("0");
			ivo.setLvrfy("0");
			ivo.setShqty(new BigDecimal(shqty));
			ivo.setIpus2("");
			ivo.setIpdp2("");
			ivo.setIpdt2(BigDecimal.valueOf(0));
			ivo.setIptm2(BigDecimal.valueOf(0));
			ivo.setTurna(temp.getTurna());
			ivo.setTurnc(temp.getTurnc());
			ivo.setTurnn(temp.getTurnn());
			ivo.setUsrsq(temp.getUsrsq());
			this.ziphdrService.insertZipdtl(ivo);
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			data="fail";
			reason="添加物料异常";
			return "toAddZipdtl";
		}
		data="success";
		return "toAddZipdtl";
	}
	

	/**
	 * 删除领料单物料
	 * @return
	 * @throws Exception
	 */
	public String toDelete() throws Exception {
		try {
			ZIPDTLVO pvo = new ZIPDTLVO();
			pvo.setIpdno(ipdno);
			pvo.setIpdln(BigDecimal.valueOf(Double.valueOf(ipdln).longValue()));
			this.ziphdrService.deleteZipdtl(pvo);
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
	public String toDeleteZiphdr() throws Exception {
		try {
//			ZIPDTLVO pvo = new ZIPDTLVO();
//			pvo.setIpdno(ipdno);
//			pvo.setIpdln(BigDecimal.valueOf(Double.valueOf(ipdln).longValue()));
//			this.ziphdrService.deleteZipdtl(pvo);
			ZIPHDRVO pvo = new ZIPHDRVO();
			pvo.setIpdno(ipdno);
			if(ipdno!=null && ipdno.trim().length()>0){
				this.ziphdrService.deleteZiphdr(pvo);
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
	public String toZiphdr() throws Exception {
		try {
			ZIPHDRVO vo = new ZIPHDRVO();
			vo.setOrdno(ordno==null?"":ordno);
			results= this.ziphdrService.queryHdrs(vo);
			if(results!=null && results.size()>0){
				for(int i=0;i<results.size();i++){
					String d= (results.get(i).getIpdt1()==null || results.get(i).getIpdt1().doubleValue()==0.0)?"":results.get(i).getIpdt1().add(BigDecimal.valueOf(19000000)).toString().trim();
					String d2 = (results.get(i).getAprdt()==null || results.get(i).getAprdt().doubleValue()==0.0)?"":results.get(i).getAprdt().add(BigDecimal.valueOf(19000000)).toString().trim();
					results.get(i).setSipdt1(d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" "));
					results.get(i).setSaprdt(d2.length()<8?d2: (d2.substring(0, 4)+"-"+d2.substring(4, 6)+"-"+d2.substring(6, 8)+" "));
					String t = results.get(i).getAprtm()==null?"":results.get(i).getAprtm().toString().trim();
					if(t.length()<6){
						t="0"+t;
					}
					results.get(i).setSaprtm(t.length()<6?t:(t.substring(0, 2)+":"+t.substring(2, 4)+":"+t.substring(4, t.length())));
				}
			}
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "toZiphdr";
	}
	public String toZiphdrList() throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(!"1".equals(flag)){
				this.startDate=Utils.formateDate(null, "yyyy-MM-dd");
				this.endDate=Utils.formateDate(null, "yyyy-MM-dd");
			}else{
				
				Map map = new HashMap();
				if(ordno!=null && !ordno.trim().equals("")){
					if(ordno.indexOf(HGPJConstant.SPLIT_2)>=0){
					}else if(ordno.indexOf(HGPJConstant.SPLIT_0)>=0){
						String[] ordnos = ordno.split(HGPJConstant.SPLIT_0);
						map.put("ordno", ordnos);
					}else if(ordno.indexOf(HGPJConstant.SPLIT_1)>=0){
						String[] ordnos = ordno.split(HGPJConstant.SPLIT_1);
						map.put("ordno", ordnos);
					}else{
						map.put("ordno",new String[]{ordno});
					}
				}
				if(ipdno!=null && !ipdno.trim().equals("")){
					if(ipdno.indexOf(HGPJConstant.SPLIT_2)>=0){
					}else if(ipdno.indexOf(HGPJConstant.SPLIT_0)>=0){
						String[] ipdnos = ipdno.split(HGPJConstant.SPLIT_0);
						map.put("ipdno", ipdnos);
					}else if(ipdno.indexOf(HGPJConstant.SPLIT_1)>=0){
						String[] ipdnos = ipdno.split(HGPJConstant.SPLIT_1);
						map.put("ipdno", ipdnos);
					}else{
						map.put("ipdno",new String[]{ipdno});
					}
				}
		
				if(startDate!=null && startDate.length()>0){
					map.put("startDate", BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(startDate), "yyMMdd"))));
				}
				
				if(endDate!=null && endDate.length()>0){
					map.put("endDate", BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(endDate), "yyMMdd"))));
				}
				
	//			vo.setOrdno(ordno==null?"":ordno);
				results= this.ziphdrService.queryHdrsByPar(map);
				if(results!=null && results.size()>0){
					for(int i=0;i<results.size();i++){
						String d= (results.get(i).getIpdt1()==null || results.get(i).getIpdt1().doubleValue()==0.0)?"":results.get(i).getIpdt1().add(BigDecimal.valueOf(19000000)).toString().trim();
						String d2 = (results.get(i).getAprdt()==null || results.get(i).getAprdt().doubleValue()==0.0)?"":results.get(i).getAprdt().add(BigDecimal.valueOf(19000000)).toString().trim();
						results.get(i).setSipdt1(d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" "));
						results.get(i).setSaprdt(d2.length()<8?d2: (d2.substring(0, 4)+"-"+d2.substring(4, 6)+"-"+d2.substring(6, 8)+" "));
						String t = results.get(i).getAprtm()==null?"":results.get(i).getAprtm().toString().trim();
						if(t.length()<6){
							t="0"+t;
						}
						results.get(i).setSaprtm(t.length()<6?t:(t.substring(0, 2)+":"+t.substring(2, 4)+":"+t.substring(4, t.length())));
					}
				}
			}
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
		return "toZiphdrList";
	}
	
	
	public String toZiphdrApprovalList() throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if("1".equals(flag)){
				this.startDate=Utils.formateDate(null, "yyyy-MM-dd");
				this.endDate=Utils.formateDate(null, "yyyy-MM-dd");

			}else{
				
				Map map = new HashMap();
				map.put("house", (String) getSession().getAttribute("stid"));
				
				if(ordno!=null && ordno.length()>0){
					String[] ordnos = ordno.split(";");
					String temp0="";
					if(ordnos!=null && ordnos.length>0){
						for(int j=0;j<ordnos.length;j++){
							temp0=temp0+"'"+ordnos[j]+"',";
						}
						temp0=temp0+"''";
						map.put("ordno", temp0);
					}
				}
				
				if(ipdno!=null && ipdno.length()>0){
					String[] ipdnos = ipdno.split(";");
					String temp0="";
					if(ipdnos!=null && ipdnos.length>0){
						for(int j=0;j<ipdnos.length;j++){
							temp0=temp0+"'"+ipdnos[j]+"',";
						}
						temp0=temp0+"''";
						map.put("ipdno", temp0);
					}
				}
				if(startDate!=null && startDate.length()>0){
					map.put("startDate", BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(startDate), "yyMMdd"))));
				}
				
				if(endDate!=null && endDate.length()>0){
					map.put("endDate", BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(endDate), "yyMMdd"))));
				}
				
	//			vo.setOrdno(ordno==null?"":ordno);
				results= this.ziphdrService.queryHdrsByParForApproval(map);
				if(results!=null && results.size()>0){
					for(int i=0;i<results.size();i++){
						String d= (results.get(i).getIpdt1()==null || results.get(i).getIpdt1().doubleValue()==0.0)?"":results.get(i).getIpdt1().add(BigDecimal.valueOf(19000000)).toString().trim();
						String d2 = (results.get(i).getAprdt()==null || results.get(i).getAprdt().doubleValue()==0.0)?"":results.get(i).getAprdt().add(BigDecimal.valueOf(19000000)).toString().trim();
						results.get(i).setSipdt1(d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" "));
						results.get(i).setSaprdt(d2.length()<8?d2: (d2.substring(0, 4)+"-"+d2.substring(4, 6)+"-"+d2.substring(6, 8)+" "));
						String t = results.get(i).getAprtm()==null?"":results.get(i).getAprtm().toString().trim();
						if(t.length()<6){
							t="0"+t;
						}
						results.get(i).setSaprtm(t.length()<6?t:(t.substring(0, 2)+":"+t.substring(2, 4)+":"+t.substring(4, t.length())));
					}
				}
			}
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
		return "toZiphdrApprovalList";
	}
	
	/**
	 * 领料单明细列表
	 * @return
	 * @throws Exception
	 */
	public String toZipdtl() throws Exception {
		try {
			ZIPDTLVO vo = new ZIPDTLVO();
			vo.setIpdno(ipdno);
			vo.setLstat("05,10");
			dresults= this.ziphdrService.queryItems(vo);
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "toZipdtl";
	}
	
	public String toEditZipdtl() throws Exception {
		try {
			ZIPDTLVO vo = new ZIPDTLVO();
			vo.setIpdno(ipdno);
			vo.setIpdln(BigDecimal.valueOf(Double.valueOf(ipdln).longValue()));
			vo.setLstat("05,10");
			dresults= this.ziphdrService.queryItems(vo);
			if(dresults!=null && dresults.size()>0){
				zipdtlvo=dresults.get(0);
			}
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "toEditZipdtl";
	}
	
	public String editZipdtl() throws Exception {
		try {
			if("3".equals(iptyp)){
				zipdtlvo.setShqty(zipdtlvo.getShqty().negate());
			}
			this.ziphdrService.updateZipitmQty(zipdtlvo);
			data="success";
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			data="fail";
			reason="修改数量异常";
			return "toEditZipdtl";
		}
		return "toEditZipdtl";
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
			MODATAVO vo = new MODATAVO();
			vo.setOrdno(ordno);
			vo.setCitwh(house);
			mresults=this.xadataService.queryModatas(vo);
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "toAddZipdtl";
	}
	
	public String toApproval() throws Exception{
		try {
			String userDept = "";
			String username = (String)this.getSession().getAttribute("username");
			List<ZBMSU02VO> dps = this.auserService.queryDeptByUserName(username);
			if(dps!=null && dps.size()>0){
				for(int i=0;i<dps.size();i++){
					ZBMSU02VO dp = dps.get(i);
					if(dp.getDflt()!=null && "1".equals(dp.getDflt().trim())){
//						vo.setPlant(dp.getPlant());
//						vo.setTwdp1(dp.getDept());
						userDept = dp.getDept();
					}
				}
			}
			
			String now1 = Utils.formateDate(null, "yyMMdd");
			String now2 = Utils.formateDate(null, "HHmmss");
			
			ZIPHDRVO ziphdrvo = new ZIPHDRVO();
			ziphdrvo.setIpdno(ipdno);
			ziphdrvo.setAprus(username);
			ziphdrvo.setAprdp(userDept);
			ziphdrvo.setAprdt(BigDecimal.valueOf(Long.valueOf("1"+now1)));
			ziphdrvo.setAprtm(BigDecimal.valueOf(Long.valueOf(now2)));
			ziphdrService.updateZiphdrForApproval(ziphdrvo);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "toApproval";
	}
	
	public String toConfirm() throws Exception {
		try {
			String userDept = "";
			String username = (String)this.getSession().getAttribute("username");
			List<ZBMSU02VO> dps = this.auserService.queryDeptByUserName(username);
			if(dps!=null && dps.size()>0){
				for(int i=0;i<dps.size();i++){
					ZBMSU02VO dp = dps.get(i);
					if(dp.getDflt()!=null && "1".equals(dp.getDflt().trim())){
//						vo.setPlant(dp.getPlant());
//						vo.setTwdp1(dp.getDept());
						userDept = dp.getDept();
					}
				}
			}
			String now1 = Utils.formateDate(null, "yyMMdd");
			String now2 = Utils.formateDate(null, "HHmmss");
			ZIPHDRVO pvo = new ZIPHDRVO();
			pvo.setIpdno(ipdno);
			pvo.setOstat("10");
			ZIPDTLVO pvo2 = new ZIPDTLVO();
			pvo2.setIpdno(ipdno);
			pvo2.setLstat("05");
			List<ZIPDTLVO> list=this.ziphdrService.queryItems(pvo2);
			List<ZIPDTLVO> plist = new ArrayList<ZIPDTLVO>();
			if(list!=null && list.size()>0){
				for(int j=0;j<list.size();j++){
					
					ZIPDTLVO tvo = new ZIPDTLVO();
					tvo.setIpdno(ipdno);
					tvo.setLstat("10");
					tvo.setIpus2(username);
					tvo.setIpdp2(userDept);
					tvo.setIpdt2(BigDecimal.valueOf(Long.valueOf("1"+now1)));
					tvo.setIptm2(BigDecimal.valueOf(Long.valueOf(now2)));
					tvo.setIpdln(list.get(j).getIpdln());
					plist.add(tvo);
				}
				pvo.setItemList(plist);
				Map map= new HashMap();
				map.put("ZIPHDRVO", pvo);
				this.ziphdrService.updateZiphdrS(map);
			}
			
			ZIPHDRVO vo = new ZIPHDRVO();
			vo.setOrdno(ordno==null?"":ordno);
			results= this.ziphdrService.queryHdrs(vo);
			if(results!=null && results.size()>0){
				for(int i=0;i<results.size();i++){
					String d= (results.get(i).getIpdt1()==null || results.get(i).getIpdt1().doubleValue()==0.0)?"":results.get(i).getIpdt1().add(BigDecimal.valueOf(19000000)).toString().trim();
					String d2 = (results.get(i).getAprdt()==null || results.get(i).getAprdt().doubleValue()==0.0)?"":results.get(i).getAprdt().add(BigDecimal.valueOf(19000000)).toString().trim();
					results.get(i).setSipdt1(d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" "));
					results.get(i).setSaprdt(d2.length()<8?d2: (d2.substring(0, 4)+"-"+d2.substring(4, 6)+"-"+d2.substring(6, 8)+" "));
					String t = results.get(i).getAprtm()==null?"":results.get(i).getAprtm().toString().trim();
					if(t.length()<6){
						t="0"+t;
					}
					results.get(i).setSaprtm(t.length()<6?t:(t.substring(0, 2)+":"+t.substring(2, 4)+":"+t.substring(4, t.length())));
				}
			}
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "toZiphdr";
	}
	
}
