package com.eclink.hgpj.resource.action;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSON;
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
import com.eclink.hgpj.resource.vo.MODATAVO;
import com.eclink.hgpj.resource.vo.MOMASTVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZIPDTLVO;
import com.eclink.hgpj.resource.vo.ZIPHDRVO;
import com.eclink.hgpj.util.QRcoderUtil;
import com.eclink.hgpj.util.Utils;
import com.opensymphony.xwork2.ActionContext;


/**
 * @Title: 打印领料单控制类
 * @Description: 
 * @author miao
 *
 */
public class PickListAction extends BaseAction {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(PickListAction.class);

	private String ordno;

	private String grnno;

	private String ipdno;

	private String startDate;

	private String endDate;

	private String flag;

	private String input1;

	private String input2;

	private List<ZIPHDRVO> results;

	private ZIPHDRService ziphdrService;

	private XADATAService xadataService;

	private ZBMSCTLService zbmsctlService;

	public String getOrdno() {
		return ordno;
	}

	public void setOrdno(String ordno) {
		this.ordno = ordno;
	}

	public String getIpdno() {
		return ipdno;
	}

	public void setIpdno(String ipdno) {
		this.ipdno = ipdno;
	}

	public String getStartDate() {
		return startDate;
	}

	public ZBMSCTLService getZbmsctlService() {
		return zbmsctlService;
	}

	public void setZbmsctlService(ZBMSCTLService zbmsctlService) {
		this.zbmsctlService = zbmsctlService;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<ZIPHDRVO> getResults() {
		return results;
	}

	public void setResults(List<ZIPHDRVO> results) {
		this.results = results;
	}

	public ZIPHDRService getZiphdrService() {
		return ziphdrService;
	}

	public void setZiphdrService(ZIPHDRService ziphdrService) {
		this.ziphdrService = ziphdrService;
	}

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

	public String getGrnno() {
		return grnno;
	}

	public void setGrnno(String grnno) {
		this.grnno = grnno;
	}

	public XADATAService getXadataService() {
		return xadataService;
	}

	public void setXadataService(XADATAService xadataService) {
		this.xadataService = xadataService;
	}

	/**
	 * 领料单查询
	 * @return
	 * @throws Exception
	 */
	public String toPickList() throws Exception {
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
		return "toPickList";
	}

	public String pickPrint() throws Exception {
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
		return "pickPrint";
	}

	public String toPrintPick() throws Exception {
		String result = "toPrintPick";
		try {
			List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
			JSONArray jsonArray = JSONObject.fromObject(grnno).getJSONArray("grnnos");
			for(int i = 0;i<jsonArray.size();i++){
				if("0".equals(input1)){//打印领料单
					ZIPHDRVO ziphdrvo = new ZIPHDRVO();
					ziphdrvo.setIpdno(jsonArray.getString(i));
					ziphdrvo.setLprt("1");
					ziphdrService.updateZiphdrLprt(ziphdrvo);
					List<ZIPHDRVO> hdrs = ziphdrService.queryHdrs(ziphdrvo);
					if(hdrs.size()>0){
						Map<String ,Object> resultMap = new HashMap<String, Object>();
						resultMap.put("ipdno", hdrs.get(0).getIpdno());
						resultMap.put("ordno", hdrs.get(0).getOrdno());
						resultMap.put("dept", hdrs.get(0).getDept());
						resultMap.put("fitem", hdrs.get(0).getFitem());
						MOMASTVO momastvo = new MOMASTVO();
						momastvo.setOrdno(hdrs.get(0).getOrdno());
						List<MOMASTVO> momasts = xadataService.queryMomastByordno(momastvo);
						if(momasts.size()>0){
							float floatValue = momasts.get(0).getOrqty().add(momasts.get(0).getQtdev()).floatValue();
							resultMap.put("productQuantity", floatValue+"");
							resultMap.put("fdesc", momasts.get(0).getFdesc());
						}

						String qrMessage = "*I"+hdrs.get(0).getIpdno();
						qrMessage += "*W"+hdrs.get(0).getOrdno();
						String encoderQRCoder = QRcoderUtil.encoderQRCoder(qrMessage, ServletActionContext.getContext().getSession().get("username").toString(),getSession().getServletContext().getRealPath("/"));
						HttpServletRequest request = ServletActionContext.getRequest();
						String path = request.getContextPath(); 
						String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
						resultMap.put("qrcodeurl", basePath+"/"+encoderQRCoder);
						
						resultMap.put("printDate", Utils.formateDate(null, "yyyy/MM/dd"));

						ZBMSCTLVO zbmsctl = new ZBMSCTLVO();
						zbmsctl.setSite((String) getSession().getAttribute("stid"));
						List<ZBMSCTLVO> bmsctlList = zbmsctlService.queryZbmsctl(zbmsctl);
						if(bmsctlList!=null && bmsctlList.size()>0){
							resultMap.put("nmchs", bmsctlList.get(0).getNmchs());
						}
						
						List<ZIPDTLVO> zipdtlvos;
						if("1".equals(input2)){//分仓打印
							ZIPDTLVO zipdtlPar = new ZIPDTLVO();
							zipdtlPar.setIpdno(jsonArray.getString(i));
							zipdtlvos = ziphdrService.queryItemsWsubOrder(zipdtlPar);
							
						}else{
							ZIPDTLVO zipdtlPar = new ZIPDTLVO();
							zipdtlPar.setIpdno(jsonArray.getString(i));
							zipdtlvos = ziphdrService.queryItems(zipdtlPar);
						}
						
						List<Map<String, String>> items = new ArrayList<Map<String,String>>();
						for(ZIPDTLVO zipdtl:zipdtlvos){
							Map<String, String> map = new HashMap<String, String>();
							map.put("seqnm", zipdtl.getSeqnm().intValue()+"");

							map.put("citem", zipdtl.getCitem());

							MODATAVO modatavo = new MODATAVO();
							modatavo.setOrdno(zipdtl.getOrdno());
							modatavo.setSeqnm(zipdtl.getSeqnm());
							List<MODATAVO> modatas = xadataService.queryModatas(modatavo);
							if(modatas.size()>0){
								map.put("uugam2", modatas.get(0).getUugam2());
								map.put("cdesc", modatas.get(0).getCdesc());
							}

							map.put("shqty", zipdtl.getShqty().floatValue()+"");

							map.put("whsub", zipdtl.getWhsub());

							/////////!!!!!!!!!!!!!1

							items.add(map);
						}
						resultMap.put("items", items);
						results.add(resultMap);
					}
				}else{//打印分仓标签

					ZIPDTLVO zipdtlvo = new ZIPDTLVO();
					zipdtlvo.setIpdno(jsonArray.getString(i));
					List<ZIPDTLVO> zipdtlvos = ziphdrService.queryItems(zipdtlvo);
					for(ZIPDTLVO zipdtlvo2:zipdtlvos){
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("ordno", zipdtlvo2.getOrdno());
						map.put("dept", zipdtlvo2.getDept());
						map.put("citem", zipdtlvo2.getCitem());
						map.put("shqty", zipdtlvo2.getShqty().floatValue()+"");
						MODATAVO modatavo = new MODATAVO();
						modatavo.setOrdno(zipdtlvo2.getOrdno());
						modatavo.setSeqnm(zipdtlvo2.getSeqnm());
						List<MODATAVO> modatas = xadataService.queryModatas(modatavo);
						if(modatas.size()>0){
							map.put("uugam2", modatas.get(0).getUugam2());
							map.put("cdesc", modatas.get(0).getCdesc());
						}
						results.add(map);
					}
					result = "toPrintLable";
				}
			}
			ActionContext.getContext().getValueStack().set("results", results);
			// 获取分页信息
			PageVO page = PaginatorUtil.getPaginator(getRequest());
			// setPagination(role,page);

			// 查询总记录数
			if (page.isQueryTotal()) {
				page.setTotalRecord(0);
			}

			// 分页对象保存至request
			getRequest().setAttribute(HGPJConstant.PAGE_KEY, page);
		} catch (Throwable e) {e.printStackTrace();
		log.error("Go to admin resource operation grant page occured error.", e);
		return ERROR;
		}
		return result;
	}
}