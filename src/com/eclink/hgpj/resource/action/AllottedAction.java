package com.eclink.hgpj.resource.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import com.eclink.hgpj.resource.biz.ZTWHDRService;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZTWDTLVO;
import com.eclink.hgpj.resource.vo.ZTWHDRVO;
import com.eclink.hgpj.util.QRcoderUtil;
import com.eclink.hgpj.util.Utils;
import com.opensymphony.xwork2.ActionContext;

/**
 * @Title: 打印调拨单控制类
 * @Description: 
 * @author miao
 *
 */
public class AllottedAction extends BaseAction {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(AllottedAction.class);

	private ZTWHDRService ztwhdrService;

	private ZBMSCTLService zbmsctlService;

	private XADATAService xadataService;

	private ZTWHDRVO ztw;

	private ZTWDTLVO ztwdtl;

	private ZBMSCTLVO zbmsctl;

	private List<ZTWHDRVO> results;

	private boolean showFinished;

	private boolean showPrinted;

	private String printDate;

	private String applyDate ;
	
	private String startDate;
	
	private String endDate;

	private String flag;
	
	private String twdno;

	public ZTWHDRService getZtwhdrService() {
		return ztwhdrService;
	}

	public void setZtwhdrService(ZTWHDRService ztwhdrService) {
		this.ztwhdrService = ztwhdrService;
	}

	public ZTWHDRVO getZtw() {
		return ztw;
	}

	public XADATAService getXadataService() {
		return xadataService;
	}

	public void setXadataService(XADATAService xadataService) {
		this.xadataService = xadataService;
	}

	public String getTwdno() {
		return twdno;
	}

	public void setTwdno(String twdno) {
		this.twdno = twdno;
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

	public void setZtw(ZTWHDRVO ztw) {
		this.ztw = ztw;
	}

	public List<ZTWHDRVO> getResults() {
		return results;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setResults(List<ZTWHDRVO> results) {
		this.results = results;
	}

	public ZBMSCTLService getZbmsctlService() {
		return zbmsctlService;
	}

	public void setZbmsctlService(ZBMSCTLService zbmsctlService) {
		this.zbmsctlService = zbmsctlService;
	}

	public ZBMSCTLVO getZbmsctl() {
		return zbmsctl;
	}

	public String getPrintDate() {
		return printDate;
	}

	public void setPrintDate(String printDate) {
		this.printDate = printDate;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public void setZbmsctl(ZBMSCTLVO zbmsctl) {
		this.zbmsctl = zbmsctl;
	}

	public boolean isShowFinished() {
		return showFinished;
	}

	public void setShowFinished(boolean showFinished) {
		this.showFinished = showFinished;
	}

	public boolean isShowPrinted() {
		return showPrinted;
	}

	public void setShowPrinted(boolean showPrinted) {
		this.showPrinted = showPrinted;
	}

	public ZTWDTLVO getZtwdtl() {
		return ztwdtl;
	}

	public void setZtwdtl(ZTWDTLVO ztwdtl) {
		this.ztwdtl = ztwdtl;
	}
	/**
	 * 查询调拨单
	 * @return
	 * @throws Exception
	 */
	public String toAllotted() throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(!"1".equals(flag)){
				this.startDate=Utils.formateDate(null, "yyyy-MM-dd");
				this.endDate=Utils.formateDate(null, "yyyy-MM-dd");

			}else{
				Map parMap = new HashMap();
				if(twdno!=null && !twdno.trim().equals("")){
					if(twdno.indexOf(HGPJConstant.SPLIT_2)>=0){
					}else if(twdno.indexOf(HGPJConstant.SPLIT_0)>=0){
						String[] ordnos = twdno.split(HGPJConstant.SPLIT_0);
						parMap.put("twdno", ordnos);
					}else if(twdno.indexOf(HGPJConstant.SPLIT_1)>=0){
						String[] ordnos = twdno.split(HGPJConstant.SPLIT_1);
						parMap.put("twdno", ordnos);
					}else{
						parMap.put("twdno",new String[]{twdno});
					}
				}
		
				if(ztwdtl!=null){
					parMap.put("frwhs", ztwdtl.getFrwhs());
					parMap.put("frsub", ztwdtl.getFrsub());
					parMap.put("towhs", ztwdtl.getTowhs());
					parMap.put("tosub", ztwdtl.getTosub());
				}
				if(showFinished){
					parMap.put("showFinished", "yes");
				}
				if(showPrinted){
					parMap.put("showPrinted", "yes");
				}
				
				if(startDate!=null && startDate.length()>0){
					parMap.put("startDate", BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(startDate), "yyMMdd"))));
				}
				
				if(endDate!=null && endDate.length()>0){
					parMap.put("endDate", BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(endDate), "yyMMdd"))));
				}
				
				results = this.ztwhdrService.queryZtwhdrList(parMap);

				for(ZTWHDRVO ztwhdrvo:results){
					for(ZTWDTLVO ztwdtlvo:ztwhdrvo.getItemList()){
						ITMRVAVO itmrVo = new ITMRVAVO();
						itmrVo.setItnbr(ztwdtlvo.getItnbr());
						itmrVo.setHouse((String) getSession().getAttribute("stid"));
						List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
						if(itmrLists!=null && itmrLists.size()>0){
							ztwdtlvo.setItdsc(itmrLists.get(0).getItdsc());
						}
					}
					String d= (ztwhdrvo.getTwdt1()==null || ztwhdrvo.getTwdt1().doubleValue()==0.0)?"":ztwhdrvo.getTwdt1().add(BigDecimal.valueOf(19000000)).toString().trim();
					ztwhdrvo.setCreatedTime(d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)));
				}
			}

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
		log.error("调拨单查询失败", e);
		return ERROR;
		}
		return "toAllotted";
	}

	/**
	 * 打印调拨单
	 * @return
	 * @throws Exception
	 */
	public String toPrintAllotted() throws Exception {
		try {
			if(ztw!=null){
				ztw = ztwhdrService.queryZtwhdr(ztw,"10,50,60");

				for(ZTWDTLVO ztwdtlvo:ztw.getItemList()){
					ITMRVAVO itmrVo = new ITMRVAVO();
					itmrVo.setItnbr(ztwdtlvo.getItnbr());
					itmrVo.setHouse((String) getSession().getAttribute("stid"));
					List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
					if(itmrLists!=null && itmrLists.size()>0){
						ztwdtlvo.setItdsc(itmrLists.get(0).getItdsc());
					}
					ztwdtlvo.setLprt("1");
					ztwhdrService.updateItemPrt(ztwdtlvo);
				}
				ZBMSCTLVO zbmsctlvo = new ZBMSCTLVO();
				zbmsctlvo.setSite((String) getSession().getAttribute("stid"));
				List<ZBMSCTLVO> zbmsctlList = zbmsctlService.queryZbmsctl(zbmsctlvo);
				if(zbmsctlList.size()>0)
					zbmsctl = zbmsctlList.get(0);
				SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
				printDate = sf.format(new Date());
				String day = ztw.getTwdt1().toBigInteger().toString().substring(1);
				String time = ztw.getTwtm1().toBigInteger().toString();
				time = "0000"+time;
				time = time.substring(time.length() - 6,time.length());
				sf = new SimpleDateFormat("yyMMddHHmmss");
				Date date = sf.parse(day+time);
				applyDate = Utils.formateDate(date, "yyyy/MM/dd HH:mm:ss");
				
				String qrMessage = "*F"+ztw.getTwdno().trim();
				String encoderQRCoder = QRcoderUtil.encoderQRCoder(qrMessage, ServletActionContext.getContext().getSession().get("username").toString(),getSession().getServletContext().getRealPath("/"));
				HttpServletRequest request = ServletActionContext.getRequest();
				String path = request.getContextPath(); 
				String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
				String qrcodeurl = basePath+"/"+encoderQRCoder;
				ActionContext.getContext().getValueStack().set("qrcodeurl", qrcodeurl);
			}else{
				return ERROR;
			}
		} catch (Exception e) {e.printStackTrace();
		log.error("调拨单查询失败", e);
		return ERROR;
		}
		return "toPrintAllotted";
	}

}
