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
import com.eclink.hgpj.util.Utils;
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
	private String outer_weight = "";//包材重
	private String fdate = "";//日期
	private String fproducter = "";//厂商
	private String outer_weight_unit = "kg";//包材重单位
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



	public String getOuter_weight() {
		return outer_weight;
	}

	public void setOuter_weight(String outer_weight) {
		this.outer_weight = outer_weight;
	}

	public String getOuter_weight_unit() {
		return outer_weight_unit;
	}

	public void setOuter_weight_unit(String outer_weight_unit) {
		this.outer_weight_unit = outer_weight_unit;
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
		List<ITMSITVO> itmsitList = this.xadataService.queryItmsitByItnot9Like(itmsitvo);
		ActionContext.getContext().getValueStack().set("itmsitList", itmsitList);
		fdate = Utils.formateDate(null, "yyyy-MM-dd");
		return "toMaterialTag";
	}

	public String searchMaterialTag() throws Exception {
		ITMSITVO itmsitvo = new ITMSITVO();
		itmsitvo.setHouse((String) getSession().getAttribute("stid"));
		itmsitvo.setItnot9(itnot9);
		List<ITMSITVO> itmsitList = this.xadataService.queryItmsitByItnot9Like(itmsitvo);
		ActionContext.getContext().getValueStack().set("itmsitList", itmsitList);

		return "searchMaterialTag";
	}


	/**
	 * 打印物料标签
	 * @return
	 * @throws Exception
	 */
	public String toPrintMaterialTag() throws Exception {
		try{
			String result = "*M"+fordrji;
			result += "*B"+fblcft9;
			result+="*Q"+fcout;

			String encoderQRCoder = QRcoderUtil.encoderQRCoder(result, ServletActionContext.getContext().getSession().get("username").toString(),getSession().getServletContext().getRealPath("/"));
			System.out.println("encoderQRCoder is "+encoderQRCoder);


			HttpServletRequest request = ServletActionContext.getRequest();
			String path = request.getContextPath(); 
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

			ServletActionContext.getRequest().setAttribute("qrcodeurl", basePath+"/"+encoderQRCoder);
			double totalweight = Double.parseDouble(fweight)*Double.parseDouble(fcout);
			if(!"g".equals(fweight_unit)){//单重单位
				totalweight *=1000;
			}
			if(!"g".equals(outer_weight_unit)){//包材单位
				totalweight +=Double.parseDouble(outer_weight)*1000;
			}else{
				totalweight +=Double.parseDouble(outer_weight);
			}
			ServletActionContext.getRequest().setAttribute("totalweight", totalweight);
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
					jo.put("umstt9", itmsitvot.getUmstt9().trim());//库存单位
					extVo.setItnbr(itnot9);
					extVo.setStid((String) getSession().getAttribute("stid"));
					extVo.setItrv(itmsitvot.getItrvt9().trim());
					List<ZITMEXTVO> extLists = this.zitmextService.queryItemExt(extVo);
					ITMRVAVO itmrVo = new ITMRVAVO();
					itmrVo.setItnbr(itnot9);
					itmrVo.setHouse((String) getSession().getAttribute("stid"));
					itmrVo.setItrv(itmsitvot.getItrvt9().trim());
					List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
					if(itmrLists!=null && itmrLists.size()>0){
						ITMRVAVO itmrvavo = itmrLists.get(0);
						jo.put("single", itmrvavo.getWeght());//单重

						String B2CQCD = itmrvavo.getB2cqcd().trim();
						if("KG".equals(B2CQCD)||"kg".equals(B2CQCD)){
							B2CQCD = "kg";
						}else{
							B2CQCD = "g";
						}
						jo.put("single_unit", B2CQCD);//单重单位
					}
					if(extLists!=null && extLists.size()>0){
						jo.put("ldesc", extLists.get(0).getLdesc().trim());
						jo.put("sdesc", extLists.get(0).getSdesc().trim());
					}
					if(itmrLists!=null && itmrLists.size()>0 && jo.getString("ldesc").trim().equals("")){
						jo.put("ldesc", itmrLists.get(0).getItdsc().trim());
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
