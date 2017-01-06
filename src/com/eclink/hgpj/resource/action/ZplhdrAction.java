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
import com.eclink.hgpj.resource.biz.ZPLHDRService;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MBCDREPVO;
import com.eclink.hgpj.resource.vo.MODATAVO;
import com.eclink.hgpj.resource.vo.MOMASTVO;
import com.eclink.hgpj.resource.vo.ZBMSRSNVO;
import com.eclink.hgpj.resource.vo.ZBMSU02VO;
import com.eclink.hgpj.resource.vo.ZIPDTLVO;
import com.eclink.hgpj.resource.vo.ZIPHDRVO;
import com.eclink.hgpj.resource.vo.ZITEMBXVO;
import com.eclink.hgpj.resource.vo.ZMBD1REPVO;
import com.eclink.hgpj.resource.vo.ZPLHDRVO;
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

	private ZPLHDRVO zplhdr;
	
	private ZPLHDRService zplhdrService;
	
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
	
	private String reason;

	private String flag;
	
	private String startDate;
	
	private String endDate;
	
	private List<ZPLHDRVO> results;
	
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
	public String addZipdtl() throws Exception {
		try {
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
	public String toZiphdrList() throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if("1".equals(flag)){
				this.startDate=Utils.formateDate(null, "yyyy-MM-dd");
				this.endDate=Utils.formateDate(null, "yyyy-MM-dd");

			}else{
				
				Map map = new HashMap();
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
//				results= this.ziphdrService.queryHdrsByPar(map);
//				if(results!=null && results.size()>0){
//					for(int i=0;i<results.size();i++){
//						String d= (results.get(i).getIpdt1()==null || results.get(i).getIpdt1().doubleValue()==0.0)?"":results.get(i).getIpdt1().add(BigDecimal.valueOf(19000000)).toString().trim();
//						String d2 = (results.get(i).getAprdt()==null || results.get(i).getAprdt().doubleValue()==0.0)?"":results.get(i).getAprdt().add(BigDecimal.valueOf(19000000)).toString().trim();
//						results.get(i).setSipdt1(d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" "));
//						results.get(i).setSaprdt(d2.length()<8?d2: (d2.substring(0, 4)+"-"+d2.substring(4, 6)+"-"+d2.substring(6, 8)+" "));
//						String t = results.get(i).getAprtm()==null?"":results.get(i).getAprtm().toString().trim();
//						if(t.length()<6){
//							t="0"+t;
//						}
//						results.get(i).setSaprtm(t.length()<6?t:(t.substring(0, 2)+":"+t.substring(2, 4)+":"+t.substring(4, t.length())));
//					}
//				}
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
		try {} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "toZiphdr";
	}
	
}
