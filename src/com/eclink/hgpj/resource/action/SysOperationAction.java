package com.eclink.hgpj.resource.action;


import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.resource.biz.ZBMSCTLService;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.opensymphony.xwork2.ActionContext;

public class SysOperationAction extends BaseAction {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(SysOperationAction.class);
	
	private String prslmt;
	
	private String data;
	
	private ZBMSCTLService zbmsctlService;
	
	public ZBMSCTLService getZbmsctlService() {
		return zbmsctlService;
	}

	public void setZbmsctlService(ZBMSCTLService zbmsctlService) {
		this.zbmsctlService = zbmsctlService;
	}

	public String getPrslmt() {
		return prslmt;
	}

	public void setPrslmt(String prslmt) {
		this.prslmt = prslmt;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	/**
	 * 生产入库限制修改界面
	 * @return
	 * @throws Exception
	 */
	public String toPrslmt() throws Exception {
		try {
			ZBMSCTLVO vo = new ZBMSCTLVO();
			vo.setSite((String) getSession().getAttribute("stid"));
			List<ZBMSCTLVO> queryZbmsctl = zbmsctlService.queryZbmsctl(vo);
			BigDecimal prslmt;
			if(queryZbmsctl.size()>0){
				prslmt = queryZbmsctl.get(0).getPrslmt();
			}else{
				prslmt = BigDecimal.valueOf(0);
			}
			ActionContext.getContext().getValueStack().set("prslmt", prslmt);
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "toPrslmt";
	}
	
	public String toModify() throws Exception {
		try {
			System.out.println("aaaa");
			BigDecimal newPrslmt = BigDecimal.valueOf(Double.parseDouble(prslmt));
			ZBMSCTLVO vo = new ZBMSCTLVO();
			vo.setSite((String) getSession().getAttribute("stid"));
			vo.setPrslmt(newPrslmt);
			zbmsctlService.updateZbmsctl(vo);
			data = "success";
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			System.out.println(e);
			data = "fail";
		}
		return "todata";
	}
		
}