package com.eclink.hgpj.resource.action;

import java.math.BigDecimal;
import java.text.ParseException;
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
import com.eclink.hgpj.resource.biz.ZGRNHDRService;
import com.eclink.hgpj.resource.biz.ZITMBXService;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.VENNAMVO;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZITEMBXVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;
import com.eclink.hgpj.util.Utils;


/**
 * @Title: 打印收货单控制类
 * @Description: 
 * @author miao
 *
 */
public class GrnAction extends BaseAction {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(GrnAction.class);
	
	private ZGRNHDRService zgrnhdrService;
	
	private XADATAService xadataService;
	
	private ZITMBXService zitmbxService;
	
	private VENNAMVO vennamvo;
	
	private ZGRNHDRVO zgrnhdr;
	
	private String grnno;
	
	private String grdte;
	
	private List<ZGRNHDRVO> results;
	
	private List<ZGRNITMVO> items;
	
	private String mydate;
	
	private int query = 0;

	public ZGRNHDRService getZgrnhdrService() {
		return zgrnhdrService;
	}

	public void setZgrnhdrService(ZGRNHDRService zgrnhdrService) {
		this.zgrnhdrService = zgrnhdrService;
	}


	public int getQuery() {
		return query;
	}

	public void setQuery(int query) {
		this.query = query;
	}

	public ZGRNHDRVO getZgrnhdr() {
		return zgrnhdr;
	}

	public void setZgrnhdr(ZGRNHDRVO zgrnhdr) {
		this.zgrnhdr = zgrnhdr;
	}

	public List<ZGRNHDRVO> getResults() {
		return results;
	}

	public void setResults(List<ZGRNHDRVO> results) {
		this.results = results;
	}

	public static Logger getLog() {
		return log;
	}

	public String getGrnno() {
		return grnno;
	}

	public ZITMBXService getZitmbxService() {
		return zitmbxService;
	}

	public void setZitmbxService(ZITMBXService zitmbxService) {
		this.zitmbxService = zitmbxService;
	}

	public void setGrnno(String grnno) {
		this.grnno = grnno;
	}

	public List<ZGRNITMVO> getItems() {
		return items;
	}

	public void setItems(List<ZGRNITMVO> items) {
		this.items = items;
	}

	public String getGrdte() {
		return grdte;
	}

	public VENNAMVO getVennamvo() {
		return vennamvo;
	}

	public void setVennamvo(VENNAMVO vennamvo) {
		this.vennamvo = vennamvo;
	}

	public XADATAService getXadataService() {
		return xadataService;
	}

	public void setXadataService(XADATAService xadataService) {
		this.xadataService = xadataService;
	}

	public void setGrdte(String grdte) {
		if (grdte != null) {
			BigDecimal t = new BigDecimal(grdte);
			String d = t.add(new BigDecimal(19000000)).toString().trim();
			this.grdte = d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" ");
		}
		this.grdte = grdte;
	}

	public String getMydate() {
		return mydate;
	}

	public void setMydate(String mydate) {
		this.mydate = mydate;
	}

	/**
	 * 查询收货单
	 * @return
	 * @throws Exception
	 */
	public String toGrn() throws Exception {
		try {
			
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
			
			if(query==0){
				return "toGrn";
			}
			results = this.zgrnhdrService.queryReceiptList(zgrnhdr);
			
			for(ZGRNHDRVO zgrnhdrvo:results){
				String d= (zgrnhdrvo.getCrdt()==null || zgrnhdrvo.getCrdt().doubleValue()==0.0)?"":zgrnhdrvo.getCrdt().add(BigDecimal.valueOf(19000000)).toString().trim();
				zgrnhdrvo.setScrdt(d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)));
			}
			
			
		} catch (Exception e) {e.printStackTrace();
			log.error("收货单查询失败", e);
			return ERROR;
		}
		return "toGrn";
	}
	
	/**
	 * 打印收货单信息
	 * @return
	 * @throws Exception
	 */
	public String toPrintGrn() throws Exception { 
		try {
			ZGRNITMVO vo = new ZGRNITMVO();
			vo.setGrnno(grnno);
			items = this.zgrnhdrService.queryReceiptItems(vo);
			for(ZGRNITMVO zgrnitmvo:items){
				Map<String, String> vennamParMap = new HashMap<String, String>();
				vennamParMap.put("vndnr", zgrnitmvo.getVndnr());
				List<VENNAMVO> vennamList = xadataService.queryVennam(vennamParMap);
				if(vennamList.size()>0){
					zgrnitmvo.setVn35(vennamList.get(0).getVn35());
				}
				
				ITMRVAVO itmrvavo = new ITMRVAVO();
				itmrvavo.setHouse((String) getSession().getAttribute("stid"));
				itmrvavo.setItnbr(zgrnitmvo.getItnbr());
				List<ITMRVAVO> itmrvaList = xadataService.queryItmrva(itmrvavo);
				if(itmrvaList.size()>0){
					zgrnitmvo.setItdsc(itmrvaList.get(0).getItdsc());
				}
				
				ZITEMBXVO bxVO = new ZITEMBXVO();
				bxVO.setHouse((String) getSession().getAttribute("stid"));
				bxVO.setItnbr(zgrnitmvo.getItnbr());
				List<ZITEMBXVO> bxList = this.zitmbxService.queryItemBx(bxVO);
				if(bxList!=null && bxList.size()>0){
					zgrnitmvo.setWhsub2(bxList.get(0).getWhsub2());
					zgrnitmvo.setLlocn2(bxList.get(0).getLlocn2());
				}
				
			}
			Date dt = new Date();
			mydate = Utils.formateDate(dt, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {e.printStackTrace();
			log.error("收货单查询失败", e);
			return ERROR;
		}
		return "toPrintGrn";
	}
}