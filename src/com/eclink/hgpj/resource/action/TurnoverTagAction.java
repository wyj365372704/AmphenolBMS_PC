package com.eclink.hgpj.resource.action;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.eclink.dfcm.paginator.common.PaginatorUtil;
import com.eclink.dfcm.paginator.tag.PageVO;
import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.resource.biz.XADATAService;
import com.eclink.hgpj.resource.biz.ZBMSCTLService;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MOMASTVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZITMEXTVO;
import com.eclink.hgpj.util.QRcoderUtil;
import com.eclink.hgpj.util.Utils;
import com.opensymphony.xwork2.ActionContext;


/**
 * @Title: 打印周转标签控制类
 * @Description: 
 * @author miao
 *
 */
public class TurnoverTagAction extends BaseAction {
	private String ordno;
	private String fitem;
	private String fdesc;
	private String moqty;
	private String unmsr;
	private String weght;
	private String b2cqcd;
	private String mydate;
	private String prounit;
	private String batch;
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(TurnoverTagAction.class);
	
	private XADATAService xadataService;
	
	private ZBMSCTLService zbmsctlService;
	
	private MOMASTVO momast;
	
	private List<MOMASTVO> results;
	
	public XADATAService getXadataService() {
		return xadataService;
	}

	public void setXadataService(XADATAService xadataService) {
		this.xadataService = xadataService;
	}

	public MOMASTVO getMomast() {
		return momast;
	}

	public void setMomast(MOMASTVO momast) {
		this.momast = momast;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getWeght() {
		return weght;
	}

	public ZBMSCTLService getZbmsctlService() {
		return zbmsctlService;
	}

	public void setZbmsctlService(ZBMSCTLService zbmsctlService) {
		this.zbmsctlService = zbmsctlService;
	}

	public void setWeght(String weght) {
		this.weght = weght;
	}

	public String getB2cqcd() {
		return b2cqcd;
	}

	public String getMydate() {
		return mydate;
	}

	public void setMydate(String mydate) {
		this.mydate = mydate;
	}

	public String getProunit() {
		return prounit;
	}

	public void setProunit(String prounit) {
		this.prounit = prounit;
	}

	public void setB2cqcd(String b2cqcd) {
		this.b2cqcd = b2cqcd;
	}

	public List<MOMASTVO> getResults() {
		return results;
	}

	public void setResults(List<MOMASTVO> results) {
		this.results = results;
	}

	public String getOrdno() {
		return ordno;
	}

	public void setOrdno(String ordno) {
		this.ordno = ordno;
	}

	public String getFitem() {
		return fitem;
	}

	public void setFitem(String fitem) {
		this.fitem = fitem;
	}

	public String getFdesc() {
		return fdesc;
	}

	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}

	public String getMoqty() {
		return moqty;
	}

	public void setMoqty(String moqty) {
		this.moqty = moqty;
	}

	public String getUnmsr() {
		return unmsr;
	}

	public void setUnmsr(String unmsr) {
		this.unmsr = unmsr;
	}

	/**
	 * 周转标签查询
	 * @return
	 * @throws Exception
	 */
	public String toTurnoverList() throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(momast!=null){
				if(momast.getOrdno()!=null && !momast.getOrdno().trim().equals("")){
					if(momast.getOrdno().indexOf(HGPJConstant.SPLIT_2)>=0){
						String[] ordnos = momast.getOrdno().split(HGPJConstant.SPLIT_2);
						momast.setOrdnodown(ordnos[0]);
						momast.setOrdnoup(ordnos[1]);
					}else if(momast.getOrdno().indexOf(HGPJConstant.SPLIT_0)>=0){
						String[] ordnos = momast.getOrdno().split(HGPJConstant.SPLIT_0);
						String temp="";
						for(int i=0;i<ordnos.length;i++){
							if(!ordnos[i].trim().equals("")){
								temp=temp+"'"+ordnos[i].trim()+"',";
							}
						}
						momast.setOrdnoF(temp);
					}else if(momast.getOrdno().indexOf(HGPJConstant.SPLIT_1)>=0){
						String[] ordnos = momast.getOrdno().split(HGPJConstant.SPLIT_1);
						String temp="";
						for(int i=0;i<ordnos.length;i++){
							if(!ordnos[i].trim().equals("")){
								temp=temp+"'"+ordnos[i].trim()+"',";
							}
						}
						momast.setOrdnoF(temp);
					}else{
						momast.setOrdnoF("'"+momast.getOrdno()+"'");
					}
				}
//				Date d = sdf.parse(momast.getStartDate());
				if(momast.getStartDate()!=null && !momast.getStartDate().trim().equals("")){
					momast.setStartDateB(BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(momast.getStartDate()), "yyMMdd"))));
				}
				if(momast.getEndDate()!=null && !momast.getEndDate().trim().equals("")){
					momast.setEndDateB(BigDecimal.valueOf(Long.valueOf("1"+Utils.formateDate(sdf.parse(momast.getEndDate()), "yyMMdd"))));
				}
				results = this.xadataService.queryMomast(momast);
			}else{
				momast = new MOMASTVO();
				
				momast.setStartDate(sdf.format(new Date()));
				momast.setEndDate(sdf.format(new Date()));
			}
			if(results!=null && results.size()>0){
				for(int i=0;i<results.size();i++){
					String d= (results.get(i).getSstdt()==null || results.get(i).getSstdt().doubleValue()==0.0)?"":results.get(i).getSstdt().add(BigDecimal.valueOf(19000000)).toString().trim();
					String d2 = (results.get(i).getOdudt()==null || results.get(i).getOdudt().doubleValue()==0.0)?"":results.get(i).getOdudt().add(BigDecimal.valueOf(19000000)).toString().trim();
					results.get(i).setSsstdt(d.length()<8?d: (d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" "));
					results.get(i).setSodudt(d2.length()<8?d2: (d2.substring(0, 4)+"-"+d2.substring(4, 6)+"-"+d2.substring(6, 8)+" "));
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
		return "toTurnoverList";
	}
	
	/**
	 * 周转标签基础信息
	 * @return
	 * @throws Exception
	 */
	public String toTurnoverTag() throws Exception {
		try {
			
			fdesc = new String(fdesc.getBytes(
					"ISO8859-1"), "utf-8");
			
			ITMSITVO itmsitvo = new ITMSITVO();
			itmsitvo.setHouse((String) getSession().getAttribute("stid"));
			itmsitvo.setItnot9(fitem);
			String itrvt = "";
			List<ITMSITVO> itrvts = this.xadataService.queryItrvtAll(itmsitvo);
			if(itrvts!=null && itrvts.size()>0){
				ZITMEXTVO extVo = new ZITMEXTVO();
				ITMSITVO itmsitvot = itrvts.get(0);
//				jo.put("blcft9", itmsitvot.getBlcft9().trim());//批次控制标识
				ActionContext.getContext().getValueStack().set("blcft9", itmsitvot.getBlcft9().trim());
			}
			
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
		return "toTurnoverTag";
	}
	
	/**
	 * 打印周转标签
	 * @return
	 * @throws Exception
	 */
	public String toPrintTurnoverTag() throws Exception {
		try {
			ZBMSCTLVO zbmsctlvo = new ZBMSCTLVO();
			zbmsctlvo.setSite((String) getSession().getAttribute("stid"));
			zbmsctlService.queryZbmsctl(zbmsctlvo);
			
			fdesc = new String(fdesc.getBytes(
					"ISO8859-1"), "utf-8");
			BigDecimal netWeight = new BigDecimal(0);
			if(b2cqcd.trim().equalsIgnoreCase("GM")||b2cqcd.trim().equalsIgnoreCase("G")){
				netWeight = BigDecimal.valueOf(Double.parseDouble(moqty)).multiply(BigDecimal.valueOf(Double.parseDouble(weght)).divide(BigDecimal.valueOf(1000)));
			}else if(b2cqcd.trim().equalsIgnoreCase("KG")){
				netWeight = BigDecimal.valueOf(Double.parseDouble(moqty)).multiply(BigDecimal.valueOf(Double.parseDouble(weght)));
			}
			ActionContext.getContext().getValueStack().set("netWeight", netWeight.toString());
			
			
			StringBuffer resultBuffer =new StringBuffer();
			resultBuffer.append("*W"+ordno).append("*M"+fitem).append("*Q"+moqty).append("*B"+batch);
			
			String encoderQRCoder = QRcoderUtil.encoderQRCoder(resultBuffer.toString(), ServletActionContext.getContext().getSession().get("username").toString(),getSession().getServletContext().getRealPath("/"));
			System.out.println("encoderQRCoder is "+encoderQRCoder);
			
			
			HttpServletRequest request = ServletActionContext.getRequest();
			String path = request.getContextPath(); 
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			
			ServletActionContext.getRequest().setAttribute("qrcodeurl", basePath+"/"+encoderQRCoder);
			
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
		return "toPrintTurnoverTag";
	}
	
}