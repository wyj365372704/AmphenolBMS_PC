package com.eclink.hgpj.resource.action;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.eclink.dfcm.paginator.common.PaginatorUtil;
import com.eclink.dfcm.paginator.tag.PageVO;
import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.resource.biz.XADATAService;
import com.eclink.hgpj.resource.biz.ZITMEXTService;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.ZITMEXTVO;
import com.eclink.hgpj.util.QRcoderUtil;
import com.mysql.fabric.Response;
import com.opensymphony.xwork2.ActionContext;

/**
 * @Title 打印物料标签
 * @Description 
 * @author miao
 *
 */
public class MaterialTagAction extends BaseAction {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(MaterialTagAction.class);
	private XADATAService xadataService;
	private ZITMEXTService zitmextService;
	private String itnot9;
	private String fordrji = "";//物料
	private String fds40ji = "";//描述
	private String sdesc = "";//规格
	private String fcout = "";//每箱数量
	private String umstt9 = "";//库存单位
	private String fblcft9 = "";//批号
	private String fweight = "";//净重
	private String fTotalweight = "";//毛重
	private String fdate = "";//日期
	private String fproducter = "";//厂商
	private String fTotalweight_unit = "kg";//毛重单位
	private String fweight_unit = "g";//单重单位

	
	public XADATAService getXadataService() {
		return xadataService;
	}

	public void setXadataService(XADATAService xadataService) {
		this.xadataService = xadataService;
	}

	public String getItnot9() {
		return itnot9;
	}

	public ZITMEXTService getZitmextService() {
		return zitmextService;
	}

	public void setZitmextService(ZITMEXTService zitmextService) {
		this.zitmextService = zitmextService;
	}

	public void setItnot9(String itnot9) {
		this.itnot9 = itnot9;
	}
	
	
	public String getFordrji() {
		return fordrji;
	}

	public void setFordrji(String fordrji) {
		this.fordrji = fordrji;
	}

	public String getFds40ji() {
		return fds40ji;
	}

	public void setFds40ji(String fds40ji) {
		this.fds40ji = fds40ji;
	}


	public String getFcout() {
		return fcout;
	}

	public void setFcout(String fcout) {
		this.fcout = fcout;
	}


	public String getSdesc() {
		return sdesc;
	}

	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}

	public String getUmstt9() {
		return umstt9;
	}

	public void setUmstt9(String umstt9) {
		this.umstt9 = umstt9;
	}

	public String getFblcft9() {
		return fblcft9;
	}

	public void setFblcft9(String fblcft9) {
		this.fblcft9 = fblcft9;
	}

	public String getFweight() {
		return fweight;
	}

	public void setFweight(String fweight) {
		this.fweight = fweight;
	}

	public String getFTotalweight() {
		return fTotalweight;
	}

	public void setFTotalweight(String fTotalweight) {
		this.fTotalweight = fTotalweight;
	}

	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}

	public String getFproducter() {
		return fproducter;
	}

	public void setFproducter(String fproducter) {
		this.fproducter = fproducter;
	}

	public String getfTotalweight_unit() {
		return fTotalweight_unit;
	}

	public void setfTotalweight_unit(String fTotalweight_unit) {
		this.fTotalweight_unit = fTotalweight_unit;
	}

	public String getFweight_unit() {
		return fweight_unit;
	}

	public void setFweight_unit(String fweight_unit) {
		this.fweight_unit = fweight_unit;
	}

	/**
	 * 物料标签
	 * @return
	 * @throws Exception
	 */
	public String toMaterialTag() throws Exception {
		ITMSITVO itmsitvo = new ITMSITVO();
		itmsitvo.setHouse((String) getSession().getAttribute("stid"));
		itmsitvo.setItnot9(itnot9);
		List<ITMSITVO> itmsitList = this.xadataService.queryItrvtAll(itmsitvo);
		System.out.println("itmsitList's size is "+itmsitList.size());
		ActionContext.getContext().getValueStack().set("itmsitList", itmsitList);
		
		return "toMaterialTag";
	}
	/**
	 * 打印物料标签
	 * @return
	 * @throws Exception
	 */
	public String toPrintMaterialTag() throws Exception {
		try{
			fordrji = 	new String(fordrji.getBytes(
					"ISO8859-1"), "utf-8");
			fds40ji = 	new String(fds40ji.getBytes(
					"ISO8859-1"), "utf-8");
			sdesc = 	new String(sdesc.getBytes(
					"ISO8859-1"), "utf-8");
			fcout = new String(fcout.getBytes(
					"ISO8859-1"), "utf-8");
			umstt9 =  new String(umstt9.getBytes(
					"ISO8859-1"), "utf-8");
			fblcft9 = new String(fblcft9.getBytes(
					"ISO8859-1"), "utf-8");
			fweight = new String(fweight.getBytes(
					"ISO8859-1"), "utf-8");
			fTotalweight = new String(fTotalweight.getBytes(
					"ISO8859-1"), "utf-8");
			fdate = new String(fdate.getBytes(
					"ISO8859-1"), "utf-8");
			fproducter = new String(fproducter.getBytes(
					"ISO8859-1"), "utf-8");
			fweight_unit = new String(fweight_unit.getBytes(
					"ISO8859-1"), "utf-8");
			fTotalweight_unit = new String(fTotalweight_unit.getBytes(
					"ISO8859-1"), "utf-8");
			
			String result = "*M"+fordrji;
			result += "*B"+fblcft9;
			result+="*Q"+fcout;
			
			String encoderQRCoder = QRcoderUtil.encoderQRCoder(result, ServletActionContext.getContext().getSession().get("username").toString(),getSession().getServletContext().getRealPath("/"));
			System.out.println("encoderQRCoder is "+encoderQRCoder);
			
			
			HttpServletRequest request = ServletActionContext.getRequest();
			String path = request.getContextPath(); 
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


			ServletActionContext.getRequest().setAttribute("fordrji", fordrji);
			ServletActionContext.getRequest().setAttribute("fds40ji", fds40ji);
			ServletActionContext.getRequest().setAttribute("sdesc", sdesc);
			ServletActionContext.getRequest().setAttribute("fcout", fcout);
			ServletActionContext.getRequest().setAttribute("umstt9", umstt9);
			ServletActionContext.getRequest().setAttribute("fblcft9", fblcft9);
			ServletActionContext.getRequest().setAttribute("fweight", fweight);
			ServletActionContext.getRequest().setAttribute("fTotalweight", fTotalweight);
			ServletActionContext.getRequest().setAttribute("fdate", fdate);
			ServletActionContext.getRequest().setAttribute("fproducter", fproducter);
			ServletActionContext.getRequest().setAttribute("qrcodeurl", basePath+"/"+encoderQRCoder);
			ServletActionContext.getRequest().setAttribute("fTotalweight_unit", fTotalweight_unit);
			ServletActionContext.getRequest().setAttribute("fweight_unit", fweight_unit);
			return "toPrintMaterialTag";
		}catch (Throwable e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}

	public void getDetail() throws Exception{
		try {
			if(itnot9 == null|| itnot9.equals("")){
				
			}else{
//				{"ldesc":"<%=ldesc.trim() %>","guige":"<%=guige.trim() %>","kcdw":"<%=kcdw.trim() %>","blcft9":"<%=BLCFT9.trim() %>"}
				JSONObject jo = new JSONObject();
				ITMSITVO itmsitvo = new ITMSITVO();
				itmsitvo.setHouse((String) getSession().getAttribute("stid"));
				itmsitvo.setItnot9(itnot9);
				String itrvt = "";
				List<ITMSITVO> itrvts = this.xadataService.queryItrvtAll(itmsitvo);
				if(itrvts!=null && itrvts.size()>0){
					ZITMEXTVO extVo = new ZITMEXTVO();
					ITMSITVO itmsitvot = itrvts.get(0);
					jo.put("blcft9", itmsitvot.getBlcft9().trim());//批次控制标识
					jo.put("umstt9", itmsitvot.getUmstt9().trim());
					extVo.setItnbr(itnot9);
					extVo.setStid((String) getSession().getAttribute("stid"));
					extVo.setItrv(itmsitvot.getItrvt9().trim());
					List<ZITMEXTVO> extLists = this.zitmextService.queryItemExt(extVo);
					String ldesc = "";
					ITMRVAVO itmrVo = new ITMRVAVO();
					itmrVo.setItnbr(itnot9);
					itmrVo.setHouse((String) getSession().getAttribute("stid"));
					itmrVo.setItrv(itmsitvot.getItrvt9().trim());
					List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
					if(itmrLists!=null && itmrLists.size()>0){
						ITMRVAVO itmrvavo = itmrLists.get(0);
						jo.put("single", itmrvavo.getWeght());
						jo.put("single_unit", itmrvavo.getB2cqcd().trim());
					}
					if(extLists!=null && extLists.size()>0 && extLists.get(0).getLdesc().trim().length()>0){
						ldesc=extLists.get(0).getLdesc();
						jo.put("ldesc", ldesc.trim());
						jo.put("sdesc", extLists.get(0).getSdesc().trim());
					}else{

						if(itmrLists!=null && itmrLists.size()>0){
							ldesc=itmrLists.get(0).getItdsc();
							jo.put("ldesc", ldesc.trim());
							jo.put("sdesc", "");
						}else{
							jo.put("ldesc", "");
							jo.put("sdesc", "");
						}

					}
				}
				HttpServletResponse response = getResponse();
				response.setCharacterEncoding("utf-8");
				PrintWriter pw = response.getWriter();
				pw.write(jo.toString());
				pw.flush();
				pw.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
