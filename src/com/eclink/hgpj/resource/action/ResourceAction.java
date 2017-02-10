package com.eclink.hgpj.resource.action;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJBizException;
import com.eclink.hgpj.resource.biz.MenuService;
import com.eclink.hgpj.resource.biz.SHPDSKService;
import com.eclink.hgpj.resource.biz.XADATAService;
import com.eclink.hgpj.resource.biz.ZBMSCTLService;
import com.eclink.hgpj.resource.biz.ZBMSU01Service;
import com.eclink.hgpj.resource.biz.ZDEPTService;
import com.eclink.hgpj.resource.biz.ZEMPMSTService;
import com.eclink.hgpj.resource.biz.ZGRNHDRService;
import com.eclink.hgpj.resource.biz.ZIPHDRService;
import com.eclink.hgpj.resource.biz.ZITMBXService;
import com.eclink.hgpj.resource.biz.ZITMEXTService;
import com.eclink.hgpj.resource.biz.ZJBTRNService;
import com.eclink.hgpj.resource.biz.ZJOBEMPService;
import com.eclink.hgpj.resource.biz.ZJOBMCHService;
import com.eclink.hgpj.resource.biz.ZMCHMSTService;
import com.eclink.hgpj.resource.biz.ZMOJOBService;
import com.eclink.hgpj.resource.biz.ZPLHDRService;
import com.eclink.hgpj.resource.biz.ZPLNMSTService;
import com.eclink.hgpj.resource.biz.ZRMHSTService;
import com.eclink.hgpj.resource.biz.ZSHPHDRService;
import com.eclink.hgpj.resource.biz.ZSLLOGService;
import com.eclink.hgpj.resource.biz.ZTWHDRService;
import com.eclink.hgpj.resource.biz.ZVRHDRService;
import com.eclink.hgpj.resource.biz.ZWHSUBService;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MODATAVO;
import com.eclink.hgpj.resource.vo.MOMASTVO;
import com.eclink.hgpj.resource.vo.MOPORFVO;
import com.eclink.hgpj.resource.vo.MOROUTVO;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.POITEMVO;
import com.eclink.hgpj.resource.vo.POMASTVO;
import com.eclink.hgpj.resource.vo.SLDATAVO;
import com.eclink.hgpj.resource.vo.SLQNTYVO;
import com.eclink.hgpj.resource.vo.VENNAMVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZBMSU01VO;
import com.eclink.hgpj.resource.vo.ZBMSU02VO;
import com.eclink.hgpj.resource.vo.ZDEPTVO;
import com.eclink.hgpj.resource.vo.ZEMPMSTVO;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZIPDTLVO;
import com.eclink.hgpj.resource.vo.ZIPHDRVO;
import com.eclink.hgpj.resource.vo.ZIPHSTVO;
import com.eclink.hgpj.resource.vo.ZITEMBXVO;
import com.eclink.hgpj.resource.vo.ZITMEXTVO;
import com.eclink.hgpj.resource.vo.ZJBTRNVO;
import com.eclink.hgpj.resource.vo.ZJOBEMPVO;
import com.eclink.hgpj.resource.vo.ZJOBMCHVO;
import com.eclink.hgpj.resource.vo.ZMCHMSTVO;
import com.eclink.hgpj.resource.vo.ZMOJOBVO;
import com.eclink.hgpj.resource.vo.ZPLBOXVO;
import com.eclink.hgpj.resource.vo.ZPLDTLVO;
import com.eclink.hgpj.resource.vo.ZPLHDRVO;
import com.eclink.hgpj.resource.vo.ZPLNMSTVO;
import com.eclink.hgpj.resource.vo.ZRMHSTVO;
import com.eclink.hgpj.resource.vo.ZSABCHVO;
import com.eclink.hgpj.resource.vo.ZSABOXVO;
import com.eclink.hgpj.resource.vo.ZSADTLVO;
import com.eclink.hgpj.resource.vo.ZSAHDRVO;
import com.eclink.hgpj.resource.vo.ZSHPBCHVO;
import com.eclink.hgpj.resource.vo.ZSHPHDRVO;
import com.eclink.hgpj.resource.vo.ZSHPITMVO;
import com.eclink.hgpj.resource.vo.ZSLLOGVO;
import com.eclink.hgpj.resource.vo.ZTWBCHVO;
import com.eclink.hgpj.resource.vo.ZTWDTLVO;
import com.eclink.hgpj.resource.vo.ZTWHDRVO;
import com.eclink.hgpj.resource.vo.ZVRHDRVO;
import com.eclink.hgpj.resource.vo.ZVRITMVO;
import com.eclink.hgpj.resource.vo.ZVRTRNVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;
import com.eclink.hgpj.user.biz.AUserService;
import com.eclink.hgpj.user.vo.AUserVO;
import com.eclink.hgpj.util.DataSourceUtil;
import com.eclink.hgpj.util.Utils;

/**
 * ResourceAction.java
 *
 * @Title: 菜单资源Action
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.

 * @version 1.0
 * @date May 28, 2013 4:41:24 PM
 *
 */
public class ResourceAction extends BaseAction {

	private static final long serialVersionUID = 1096778718956871467L;

	/**
	 * 日志对象
	 */
	private static Logger log = Logger.getLogger(ResourceAction.class);

	/**
	 * 菜单资源业务类
	 */
	private MenuService menuService;

	private AUserService auserService;

	private ZSHPHDRService zshphdrService;

	private ZGRNHDRService zgrnhdrService;

	private ZPLNMSTService zplnmstService;

	private SHPDSKService shpdskService;

	private XADATAService xadataService;

	private ZITMEXTService zitmextService;

	private ZMOJOBService zmojobService;

	private ZEMPMSTService zempmstService;

	private ZMCHMSTService zmchmstService;

	private ZDEPTService zdeptService;

	private ZITMBXService zitmbxService;

	private ZBMSCTLService zbmsctlService;

	private ZWHSUBService zwhsubService;

	private ZBMSU01Service zbmsu01Service;

	private ZTWHDRService ztwhdrService;

	private ZSLLOGService zsllogService;

	private ZIPHDRService ziphdrService;

	private ZRMHSTService zrmhstService;

	private ZJOBEMPService zjobempService;

	private ZJOBMCHService zjobmchService;

	private ZJBTRNService zjbtrnService;

	private ZPLHDRService zplhdrService;

	private String data;

	private String username;

	private String password;

	private String env;

	private String delive_code;

	private String receipt_number;

	private String receipt_line;

	private String employee_number;

	private String actual_single;

	private String actual_single_update;

	private String actual_quantity;

	private String location;

	private String branch_list;

	private String warehouse;

	private String shard;

	private String mate;

	private String mater;

	private String pldln;

	private String branch;

	private String mater_list;

	private String from_warehouse;

	private String from_shard;

	private String from_location;

	private String requisition;

	private String requisition_line; 

	private String target_warehouse ;

	private String target_shard ;

	private String target_location;

	private String update;

	private String pick_number;

	private String pick_line;

	private String work_order;

	private String quantity_each_box;

	private String quantity_box;

	private String quantity_mantissa;

	private String quantity;

	private String step_number;

	private String propr_number;

	private String begin_time;

	private String employee_list;

	private String machine_list;

	private String job_number;

	private String ia_quantity;

	private String pldno;

	private String boxnm;

	private String boxes;

	/**
	 * 菜单资源树
	 */
	private List<MenuVO> resources;

	/**
	 * 菜单资源
	 */
	private MenuVO menu;

	/**
	 * 菜单资源列表
	 */
	private List<MenuVO> menus;

	private List<ZSHPHDRVO> zshphdrs;

	private List<ZGRNHDRVO> zgrnhdrs;

	private List<ZGRNITMVO> zgrnitms;

	private String machine_number;

	private String step_quantity;

	private String artificial_hours_after;

	private String machine_hours_after;

	private String abnormal_reason;

	private String abnormal_hours;

	private String return_number;

	private ZVRHDRService zvrhdrService;

	private String return_line;

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public String getReturn_line() {
		return return_line;
	}

	public void setReturn_line(String return_line) {
		this.return_line = return_line;
	}

	public ZVRHDRService getZvrhdrService() {
		return zvrhdrService;
	}

	public void setZvrhdrService(ZVRHDRService zvrhdrService) {
		this.zvrhdrService = zvrhdrService;
	}

	public String getReturn_number() {
		return return_number;
	}

	public void setReturn_number(String return_number) {
		this.return_number = return_number;
	}

	public String getIa_quantity() {
		return ia_quantity;
	}

	public void setIa_quantity(String ia_quantity) {
		this.ia_quantity = ia_quantity;
	}

	public String getPldln() {
		return pldln;
	}

	public void setPldln(String pldln) {
		this.pldln = pldln;
	}

	public String getStep_quantity() {
		return step_quantity;
	}

	public void setStep_quantity(String step_quantity) {
		this.step_quantity = step_quantity;
	}

	public SHPDSKService getShpdskService() {
		return shpdskService;
	}

	public void setShpdskService(SHPDSKService shpdskService) {
		this.shpdskService = shpdskService;
	}

	public ZPLHDRService getZplhdrService() {
		return zplhdrService;
	}

	public void setZplhdrService(ZPLHDRService zplhdrService) {
		this.zplhdrService = zplhdrService;
	}

	public String getPldno() {
		return pldno;
	}

	public void setPldno(String pldno) {
		this.pldno = pldno;
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

	public ZDEPTService getZdeptService() {
		return zdeptService;
	}



	public String getMachine_number() {
		return machine_number;
	}

	public void setMachine_number(String machine_number) {
		this.machine_number = machine_number;
	}

	public ZJOBMCHService getZjobmchService() {
		return zjobmchService;
	}

	public void setZjobmchService(ZJOBMCHService zjobmchService) {
		this.zjobmchService = zjobmchService;
	}

	public ZJOBEMPService getZjobempService() {
		return zjobempService;
	}

	public void setZjobempService(ZJOBEMPService zjobempService) {
		this.zjobempService = zjobempService;
	}

	public void setZdeptService(ZDEPTService zdeptService) {
		this.zdeptService = zdeptService;
	}


	public ZBMSCTLService getZbmsctlService() {
		return zbmsctlService;
	}

	public void setZbmsctlService(ZBMSCTLService zbmsctlService) {
		this.zbmsctlService = zbmsctlService;
	}

	public ZWHSUBService getZwhsubService() {
		return zwhsubService;
	}

	public void setZwhsubService(ZWHSUBService zwhsubService) {
		this.zwhsubService = zwhsubService;
	}

	public ZBMSU01Service getZbmsu01Service() {
		return zbmsu01Service;
	}

	public void setZbmsu01Service(ZBMSU01Service zbmsu01Service) {
		this.zbmsu01Service = zbmsu01Service;
	}



	public String getEmployee_number() {
		return employee_number;
	}

	public void setEmployee_number(String employee_number) {
		this.employee_number = employee_number;
	}

	public String getJob_number() {
		return job_number;
	}

	public void setJob_number(String job_number) {
		this.job_number = job_number;
	}

	public ZSLLOGService getZsllogService() {
		return zsllogService;
	}

	public void setZsllogService(ZSLLOGService zsllogService) {
		this.zsllogService = zsllogService;
	}

	public ZRMHSTService getZrmhstService() {
		return zrmhstService;
	}

	public void setZrmhstService(ZRMHSTService zrmhstService) {
		this.zrmhstService = zrmhstService;
	}

	public List<MenuVO> getResources() {
		return resources;
	}

	public void setResources(List<MenuVO> resources) {
		this.resources = resources;
	}

	public MenuVO getMenu() {
		return menu;
	}

	public void setMenu(MenuVO menu) {
		this.menu = menu;
	}

	public List<MenuVO> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuVO> menus) {
		this.menus = menus;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}



	public String getBoxnm() {
		return boxnm;
	}

	public void setBoxnm(String boxnm) {
		this.boxnm = boxnm;
	}

	public String getBoxes() {
		return boxes;
	}

	public void setBoxes(String boxes) {
		this.boxes = boxes;
	}

	public String getWork_order() {
		return work_order;
	}

	public void setWork_order(String work_order) {
		this.work_order = work_order;
	}

	public String getRequisition_line() {
		return requisition_line;
	}

	public void setRequisition_line(String requisition_line) {
		this.requisition_line = requisition_line;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMater() {
		return mater;
	}

	public void setMater(String mater) {
		this.mater = mater;
	}

	public String getEnv() {
		return env;
	}

	public String getDelive_code() {
		return delive_code;
	}

	public void setDelive_code(String delive_code) {
		this.delive_code = delive_code;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public String getReceipt_number() {
		return receipt_number;
	}

	public void setReceipt_number(String receipt_number) {
		this.receipt_number = receipt_number;
	}

	public String getReceipt_line() {
		return receipt_line;
	}

	public void setReceipt_line(String receipt_line) {
		this.receipt_line = receipt_line;
	}

	public String getActual_single() {
		return actual_single;
	}

	public void setActual_single(String actual_single) {
		this.actual_single = actual_single;
	}

	public String getActual_single_update() {
		return actual_single_update;
	}

	public void setActual_single_update(String actual_single_update) {
		this.actual_single_update = actual_single_update;
	}

	public String getActual_quantity() {
		return actual_quantity;
	}

	public void setActual_quantity(String actual_quantity) {
		this.actual_quantity = actual_quantity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBranch_list() {
		return branch_list;
	}

	public void setBranch_list(String branch_list) {
		this.branch_list = branch_list;
	}

	public List<ZGRNITMVO> getZgrnitms() {
		return zgrnitms;
	}

	public void setZgrnitms(List<ZGRNITMVO> zgrnitms) {
		this.zgrnitms = zgrnitms;
	}

	public List<ZSHPHDRVO> getZshphdrs() {
		return zshphdrs;
	}

	public List<ZGRNHDRVO> getZgrnhdrs() {
		return zgrnhdrs;
	}

	public String getQuantity_each_box() {
		return quantity_each_box;
	}

	public void setQuantity_each_box(String quantity_each_box) {
		this.quantity_each_box = quantity_each_box;
	}

	public String getQuantity_box() {
		return quantity_box;
	}

	public void setQuantity_box(String quantity_box) {
		this.quantity_box = quantity_box;
	}

	public String getQuantity_mantissa() {
		return quantity_mantissa;
	}

	public void setQuantity_mantissa(String quantity_mantissa) {
		this.quantity_mantissa = quantity_mantissa;
	}



	public String getArtificial_hours_after() {
		return artificial_hours_after;
	}

	public void setArtificial_hours_after(String artificial_hours_after) {
		this.artificial_hours_after = artificial_hours_after;
	}

	public String getMachine_hours_after() {
		return machine_hours_after;
	}

	public void setMachine_hours_after(String machine_hours_after) {
		this.machine_hours_after = machine_hours_after;
	}

	public String getAbnormal_reason() {
		return abnormal_reason;
	}

	public void setAbnormal_reason(String abnormal_reason) {
		this.abnormal_reason = abnormal_reason;
	}

	public String getAbnormal_hours() {
		return abnormal_hours;
	}

	public void setAbnormal_hours(String abnormal_hours) {
		this.abnormal_hours = abnormal_hours;
	}

	public void setZgrnhdrs(List<ZGRNHDRVO> zgrnhdrs) {
		this.zgrnhdrs = zgrnhdrs;
	}

	public void setZshphdrs(List<ZSHPHDRVO> zshphdrs) {
		this.zshphdrs = zshphdrs;
	}

	public ZSHPHDRService getZshphdrService() {
		return zshphdrService;
	}

	public void setZshphdrService(ZSHPHDRService zshphdrService) {
		this.zshphdrService = zshphdrService;
	}

	public ZGRNHDRService getZgrnhdrService() {
		return zgrnhdrService;
	}

	public void setZgrnhdrService(ZGRNHDRService zgrnhdrService) {
		this.zgrnhdrService = zgrnhdrService;
	}

	public ZITMEXTService getZitmextService() {
		return zitmextService;
	}

	public void setZitmextService(ZITMEXTService zitmextService) {
		this.zitmextService = zitmextService;
	}

	public ZITMBXService getZitmbxService() {
		return zitmbxService;
	}

	public void setZitmbxService(ZITMBXService zitmbxService) {
		this.zitmbxService = zitmbxService;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public String getShard() {
		return shard;
	}

	public String getMater_list() {
		return mater_list;
	}

	public void setMater_list(String mater_list) {
		this.mater_list = mater_list;
	}

	public void setShard(String shard) {
		this.shard = shard;
	}

	public String getMate() {
		return mate;
	}

	public void setMate(String mate) {
		this.mate = mate;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public ZTWHDRService getZtwhdrService() {
		return ztwhdrService;
	}

	public String getRequisition() {
		return requisition;
	}

	public void setRequisition(String requisition) {
		this.requisition = requisition;
	}

	public void setZtwhdrService(ZTWHDRService ztwhdrService) {
		this.ztwhdrService = ztwhdrService;
	}

	public String getFrom_warehouse() {
		return from_warehouse;
	}

	public void setFrom_warehouse(String from_warehouse) {
		this.from_warehouse = from_warehouse;
	}

	public String getFrom_shard() {
		return from_shard;
	}



	public ZJBTRNService getZjbtrnService() {
		return zjbtrnService;
	}

	public void setZjbtrnService(ZJBTRNService zjbtrnService) {
		this.zjbtrnService = zjbtrnService;
	}

	public void setFrom_shard(String from_shard) {
		this.from_shard = from_shard;
	}

	public String getFrom_location() {
		return from_location;
	}

	public void setFrom_location(String from_location) {
		this.from_location = from_location;
	}

	public String getTarget_warehouse() {
		return target_warehouse;
	}

	public void setTarget_warehouse(String target_warehouse) {
		this.target_warehouse = target_warehouse;
	}

	public String getTarget_shard() {
		return target_shard;
	}

	public void setTarget_shard(String target_shard) {
		this.target_shard = target_shard;
	}

	public String getTarget_location() {
		return target_location;
	}

	public void setTarget_location(String target_location) {
		this.target_location = target_location;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getPick_number() {
		return pick_number;
	}

	public void setPick_number(String pick_number) {
		this.pick_number = pick_number;
	}

	public ZIPHDRService getZiphdrService() {
		return ziphdrService;
	}

	public void setZiphdrService(ZIPHDRService ziphdrService) {
		this.ziphdrService = ziphdrService;
	}

	public String getPick_line() {
		return pick_line;
	}

	public void setPick_line(String pick_line) {
		this.pick_line = pick_line;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getStep_number() {
		return step_number;
	}

	public void setStep_number(String step_number) {
		this.step_number = step_number;
	}



	public ZMOJOBService getZmojobService() {
		return zmojobService;
	}

	public void setZmojobService(ZMOJOBService zmojobService) {
		this.zmojobService = zmojobService;
	}



	public ZPLNMSTService getZplnmstService() {
		return zplnmstService;
	}

	public void setZplnmstService(ZPLNMSTService zplnmstService) {
		this.zplnmstService = zplnmstService;
	}



	public String getPropr_number() {
		return propr_number;
	}

	public void setPropr_number(String propr_number) {
		this.propr_number = propr_number;
	}

	public ZEMPMSTService getZempmstService() {
		return zempmstService;
	}

	public void setZempmstService(ZEMPMSTService zempmstService) {
		this.zempmstService = zempmstService;
	}



	public ZMCHMSTService getZmchmstService() {
		return zmchmstService;
	}

	public void setZmchmstService(ZMCHMSTService zmchmstService) {
		this.zmchmstService = zmchmstService;
	}



	public String getBegin_time() {
		return begin_time;
	}

	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}

	public String getEmployee_list() {
		return employee_list;
	}

	public void setEmployee_list(String employee_list) {
		this.employee_list = employee_list;
	}

	public String getMachine_list() {
		return machine_list;
	}

	public void setMachine_list(String machine_list) {
		this.machine_list = machine_list;
	}


	/**
	 * 进入菜单资源管理首页
	 * @return
	 * @throws Exception
	 */
	public String toResIndex() throws Exception {
		try {

		} catch (Exception e) {
			log.error("To menu resource index page occured error.", e);
			return ERROR;
		}
		return "toIndex";
	}

	/**
	 * 系统菜单资源树查询
	 * @return
	 * @throws Exception
	 */
	public String resourceTree() throws Exception {
		try {
			// 查询系统菜单资源
			resources = menuService.querySystemResource();
		} catch (Exception e) {
			log.error("Query menu resource tree occured error.", e);
			return ERROR;
		}
		return "resTree";
	}

	/**
	 * 查看菜单资源详情信息
	 * @return
	 * @throws Exception
	 */
	public String viewMenu() throws Exception {
		try {
			// 获取菜单资源详情
			if (null != menu) {
				//				menu = menuService.queryMenuById(menu.getMenuId());
			}
		} catch (Exception e) {
			log.error("View menu occured error.", e);
			return ERROR;
		}
		return "viewMenu";
	}

	/**
	 * 进入菜单资源新增页面
	 * @return
	 * @throws Exception
	 */
	public String toInsert() throws Exception {
		try {
			if (null != menu) {
				// 上级菜单名称转码
				String parentMenuName = menu.getParentMenuName();
				if (!StringUtils.isEmpty(parentMenuName)) {
					parentMenuName = new String(parentMenuName.getBytes("ISO-8859-1"),"UTF-8");
				} else {
					parentMenuName = "";
				}
				menu.setParentMenuName(parentMenuName);
			}
		} catch (Exception e) {
			log.error("Go to insert menu page occured error.", e);
			return ERROR;
		}
		return "toInsert";
	}

	/**
	 * 菜单资源新增保存
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		try {
			// 新增保存菜单资源
			menuService.insertMenu(menu);
		} catch (HGPJBizException he) {
			setErrorMsg(he.getMessage());
			return ERROR;
		} catch (Exception e) {
			log.error("Insert menu occured error.",e);
			return ERROR;
		}
		setBackUrl("/resource/resource!toResIndex.action");
		return "info";
	}

	public String get_env()  throws Exception {
		InputStream is =null;
		//		OutputStream os = null;
		try {
			is = new BufferedInputStream(new FileInputStream(this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties"));
			this.getSession().getServletContext().setAttribute("dbconfigurl", this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties");
			Properties properties = new Properties();
			properties.load(is);
			Enumeration e= properties.keys();
			//			JsonUtil ju = new JsonUtil();
			//			ju.append("code", 1);
			//			ju.append("dese", "ok");
			Map resultmap = new HashMap();
			while(e.hasMoreElements()){
				String key = (String)e.nextElement();
				//				ju.append(key, properties.get(key));
				resultmap.put(key, properties.get(key));
			}
			int idxs = (Integer)this.getSession().getServletContext().getAttribute("envcount");
			List list = new ArrayList();
			for(int i=0;i<idxs;i++){
				//				Map resultmap1 = new HashMap();
				//				resultmap1.put("", value);
				list.add(resultmap.get("ENVID"+i));
			}
			//			ju.
			//			JsonUtil ju = new JsonUtil();
			//			ju.append("code", 1);
			//			ju.append("dese", "ok");
			//			ju.append("env_list", resultmap);
			//			data = ju.toString();
			JSONObject jo = new JSONObject();
			jo.put("code", 1);
			jo.put("desc", "ok");
			jo.put("env_list", list);
			data=jo.toString();
			//			os=this.getResponse().getOutputStream();
			//			os.write(returnVal.getBytes());
			//			
			//			os.flush();
			//			os.close();
		}catch (Exception e) {e.printStackTrace();
		log.error("get env error.",e);
		return ERROR;
		}finally{
			if(is!=null){
				is.close();
			}
		}

		setBackUrl("/resource/resource!toResIndex.action");
		return "todata";
	}

	public String login_check()  throws Exception {
		JSONObject ju = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				ju.put("code", 2);
				ju.put("dese", "not have username");
			}else if(env==null || env.trim().equals("")){
				ju.put("code", 3);
				ju.put("dese", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				AUserVO au = this.auserService.queryUserByUserName(username);
				if(null==au){
					ju.put("code", 2);
					ju.put("desc", "do not have this user");
				}else{
					if(!this.password.trim().equals(au.getPasswd().trim())){
						ju.put("code", 2);
						ju.put("desc", "password is not correct");
					}else{
						ju.put("code", 1);
						ju.put("desc", "ok");
					}
				}
			}			

			data = ju.toString();
			//			os=this.getResponse().getOutputStream();
			//			os.write(returnVal.getBytes());
			//			
			//			os.flush();
			//			os.close();
		}catch (Exception e) {
			ju.put("code", 4);
			ju.put("desc", "other exception");
			data = ju.toString();
			//			e.printStackTrace();
			log.error("get env error.",e);
			return "todata";
		}finally{			
		}

		setBackUrl("/resource/resource!toResIndex.action");
		return "todata";
	}

	public String get_menu()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				//TODO:获取菜单接口，后续需要完善成根据用户名获取相应的菜单
				menus = menuService.getMenuTreeListForUserN(username);
				List<Map> list = new ArrayList<Map>();
				if(menus!=null && menus.size()>0){
					for(int i=0;i<menus.size();i++){
						MenuVO mvo=menus.get(i);
						Map menuM = new HashMap();
						List<MenuVO> lmv=mvo.getSubMenuList();
						if(lmv!=null && lmv.size()>0){
							for(int j=0;j<lmv.size();j++){
								MenuVO cmvo=lmv.get(j);
								if(cmvo.getMenuType()!=null && cmvo.getMenuType().trim().equals("2"))
									menuM.put(cmvo.getMenuKey().trim(), cmvo.getMenuName().trim());
							}
							list.add(menuM);
						}
					}
					jo.put("menu_list", list);
				}
				jo.put("code", 1);
				jo.put("desc", "ok");
			}
			//			jo.put("env_list", list);
			data=jo.toString();
			//			os=this.getResponse().getOutputStream();
			//			os.write(returnVal.getBytes());
			//			
			//			os.flush();
			//			os.close();
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}

		setBackUrl("/resource/resource!toResIndex.action");
		return "todata";
	}
	/**
	 * 采购收货-查询送货单
	 * @return
	 * @throws Exception
	 */
	public String query_receipt()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				//TODO:获取菜单接口，后续需要完善成根据用户名获取相应的菜单
				zshphdrs = zshphdrService.queryReceipt(delive_code);
				List<Map> list = new ArrayList<Map>();
				if(zshphdrs!=null && zshphdrs.size()>0){
					ZSHPHDRVO templ=zshphdrs.get(0);

					if(!"50".equals(templ.getOstat())){//尚未创建收货单,开始创建收货单
						System.out.println("开始创建收货单");
						ZGRNHDRVO zgrnhdrVO = new ZGRNHDRVO();
						String now1 = Utils.formateDate(null, "yyMMdd");
						String now2 = Utils.formateDate(null, "HHmmss");
						int count = this.zgrnhdrService.getCoutsByDt(BigDecimal.valueOf(Long.valueOf("1"+now1)) );
						count=count+1;
						String index = "000"+count+"";

						if(index.length()>4){
							index=index.substring(index.length()-4);
						}
						zgrnhdrVO.setGrnno("GR"+now1+index);
						zgrnhdrVO.setChdt(templ.getChdt());
						zgrnhdrVO.setChtm(templ.getChtm());
						zgrnhdrVO.setChus(templ.getChus());
						zgrnhdrVO.setCrdt(templ.getCrdt());
						zgrnhdrVO.setCrtm(templ.getCrtm());
						zgrnhdrVO.setCrus(templ.getCrus());
						zgrnhdrVO.setGrdte(BigDecimal.valueOf(Long.valueOf("1"+now1)) );
						zgrnhdrVO.setGrdtm(BigDecimal.valueOf(Long.valueOf(now2)) );
						zgrnhdrVO.setGremp(username);
						zgrnhdrVO.setLgwno(templ.getLgwno());
						zgrnhdrVO.setOstat("10");
						zgrnhdrVO.setShpno(templ.getShpno());
						zgrnhdrVO.setVndnr(templ.getVndnr());
						List<ZGRNITMVO> subItems = new ArrayList<ZGRNITMVO>();
						if(templ.getItemsList()!=null && templ.getItemsList().size()>0){
							for(int i=0;i<templ.getItemsList().size();i++){
								ZSHPITMVO mvo=templ.getItemsList().get(i);
								ITMSITVO itmsitvo = new ITMSITVO();
								itmsitvo.setHouse(mvo.getHouse().trim());
								itmsitvo.setItnot9(mvo.getItnbr().trim());
								String itrvt = "";
								List<String> itrvts = this.xadataService.queryItrvt(itmsitvo);
								if(itrvts!=null && itrvts.size()>0){
									itrvt=itrvts.get(0);
								}
								ITMRVAVO itmrVo = new ITMRVAVO();
								ITMRVAVO itmrVoT = null;
								itmrVo.setItnbr(mvo.getItnbr().trim());
								itmrVo.setHouse(mvo.getHouse().trim());
								itmrVo.setItrv(itrvt.trim());
								List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
								if(itmrLists!=null && itmrLists.size()>0){
									itmrVoT=itmrLists.get(0);
								}

								ZGRNITMVO zgrnitemVO = new ZGRNITMVO();
								zgrnitemVO.setBlcf(mvo.getBlcf());
								zgrnitemVO.setBlcod(mvo.getBlcod());
								zgrnitemVO.setBlksq(mvo.getBlksq());
								zgrnitemVO.setGrloc("");
								zgrnitemVO.setGrnln(BigDecimal.valueOf(i+1));
								zgrnitemVO.setHouse(mvo.getHouse());
								zgrnitemVO.setItnbr(mvo.getItnbr());
								zgrnitemVO.setLstat("10");
								zgrnitemVO.setOrdno(mvo.getOrdno());
								zgrnitemVO.setPoisq(mvo.getPoisq());
								zgrnitemVO.setPurum(mvo.getPurum());
								zgrnitemVO.setSctkji(mvo.getSctkji());
								zgrnitemVO.setShpic3(mvo.getShpic3());
								zgrnitemVO.setShpln(mvo.getShpln());
								zgrnitemVO.setShpno(mvo.getShpno());
								zgrnitemVO.setShqty(mvo.getShqty());
								zgrnitemVO.setTwht(mvo.getTwht());
								zgrnitemVO.setVndnr(mvo.getVndnr());
								zgrnitemVO.setVpack(mvo.getVpack());
								zgrnitemVO.setWhtum(mvo.getWhtum());
								zgrnitemVO.setIqcf("0");
								zgrnitemVO.setGrqty(BigDecimal.valueOf(0));
								if(itmrVoT!=null){
									zgrnitemVO.setGrwgt1(itmrVoT.getWeght());
									zgrnitemVO.setGrwum1(itmrVoT.getB2cqcd());
								}else{
									zgrnitemVO.setGrwgt1(BigDecimal.valueOf(0));
									zgrnitemVO.setGrwum1("");
								}

								zgrnitemVO.setGrwgt2(BigDecimal.valueOf(0));

								zgrnitemVO.setGrwum2("");
								zgrnitemVO.setGrnno(zgrnhdrVO.getGrnno());
								if(mvo.getBlcf()!=null && "1".equals(mvo.getBlcf())){
									Map map = new HashMap();
									map.put("shpno", mvo.getShpno());
									map.put("shpln", mvo.getShpln().doubleValue()+"");
									List<ZSHPBCHVO> bchList = this.zshphdrService.queryBch(map);
									List<ZGRNBCHVO> subItems2 = new ArrayList<ZGRNBCHVO>();
									if(bchList!=null && bchList.size()>0){
										mvo.setItemsList(bchList);
										for(int j=0;j<bchList.size();j++){
											ZSHPBCHVO tempv = bchList.get(j);
											ZGRNBCHVO tempg = new ZGRNBCHVO();
											tempg.setBlksq(tempv.getBlksq());
											//											tempg.setExpdt(tempv.getExpdt());
											tempg.setGrnno(zgrnitemVO.getGrnno());
											tempg.setGrnln(zgrnitemVO.getShpln());
											tempg.setGrnbn(BigDecimal.valueOf(j+1));
											tempg.setHouse(tempv.getHouse());
											tempg.setItnbr(tempv.getItnbr());
											tempg.setLbhno(tempv.getLbhno());
											//											tempg.setMfgdt(tempv.getMfgdt());
											tempg.setOrdno(tempv.getOrdno());
											tempg.setPoisq(tempv.getPoisq());
											tempg.setPurum(tempv.getPurum());
											tempg.setGbqty(BigDecimal.valueOf(0));
											tempg.setSbqty(tempv.getBhqty());
											tempg.setShpln(tempv.getShpln());
											tempg.setShpbn(tempv.getShpbn());
											tempg.setShpno(tempv.getShpno());
											tempg.setVndnr(tempv.getVndnr());
											tempg.setMfgdt(BigDecimal.valueOf(Long.valueOf("1"+now1)));
											tempg.setExpdt(BigDecimal.valueOf(Long.valueOf("1"+now1)));
											subItems2.add(tempg);
										}
										zgrnitemVO.setItemList(subItems2);
									}
								}
								subItems.add(zgrnitemVO);
							}
							zgrnhdrVO.setItemsList(subItems);
						}
						System.out.println("创建收货单完成1");
						this.zgrnhdrService.insertZgrnhdr(zgrnhdrVO);
						System.out.println("创建收货单完成2");
					}
					Map map = new HashMap();
					map.put("grnno", delive_code);
					map.put("lstat", "10");
					zgrnhdrs = this.zgrnhdrService.queryReceiptSelf(map);
					if(zgrnhdrs!=null && zgrnhdrs.size()>0){
						ZGRNHDRVO temp2 = zgrnhdrs.get(0);
						if(temp2.getItemsList()!=null && temp2.getItemsList().size()>0){
							for(int i=0;i<temp2.getItemsList().size();i++){
								ZGRNITMVO mvo=temp2.getItemsList().get(i);
								Map itemM = new HashMap();
								itemM.put("mater_po", mvo.getOrdno()+"-"+mvo.getPoisq().intValue()+"-"+mvo.getBlksq().intValue());
								if(mvo.getGrnln()!=null){
									itemM.put("number", mvo.getGrnln()+"");
								}
								if(mvo.getItnbr()!=null){
									itemM.put("mate", mvo.getItnbr());
								}
								if(mvo.getShqty()!=null){
									itemM.put("quantity", mvo.getShqty());
								}
								if(mvo.getPurum()!=null){
									itemM.put("unit", mvo.getPurum());
								}

								list.add(itemM);
							}
						}
						if(temp2.getVndnr()!=null){
							jo.put("firm", temp2.getVndnr());
						}
						if(temp2.getShpno()!=null){
							jo.put("receipt_number", temp2.getShpno());
						}
						if(temp2.getOstat()!=null){
							jo.put("status_code", temp2.getOstat());
						}

						jo.put("mater_list", list);
						jo.put("code", 1);
						jo.put("desc", "ok");
					}else{
						jo.put("code", 5);
						jo.put("desc", "no results");
					}

				}else{
					jo.put("code", 5);
					jo.put("desc", "no results");
				}

			}
			//			jo.put("env_list", list);
			data=jo.toString();
			//			os=this.getResponse().getOutputStream();
			//			os.write(returnVal.getBytes());
			//			
			//			os.flush();
			//			os.close();
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}

		setBackUrl("/resource/resource!toResIndex.action");
		return "todata";
	}

	public String query_receipt_storage()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);

				List<Map> list = new ArrayList<Map>();

				Map map = new HashMap();
				map.put("grnno", delive_code);
				map.put("lstat", "40");
				zgrnhdrs = this.zgrnhdrService.queryReceiptSelf(map);
				if(zgrnhdrs!=null && zgrnhdrs.size()>0){
					ZGRNHDRVO temp2 = zgrnhdrs.get(0);
					if(temp2.getItemsList()!=null && temp2.getItemsList().size()>0){
						for(int i=0;i<temp2.getItemsList().size();i++){
							ZGRNITMVO mvo=temp2.getItemsList().get(i);
							Map itemM = new HashMap();
							itemM.put("mater_po", mvo.getOrdno()+"-"+mvo.getPoisq().intValue()+"-"+mvo.getBlksq().intValue());
							if(mvo.getGrnln()!=null){
								itemM.put("number", mvo.getGrnln()+"");
							}
							if(mvo.getItnbr()!=null){
								itemM.put("mate", mvo.getItnbr());
							}
							if(mvo.getShqty()!=null){
								itemM.put("quantity", mvo.getDkqty());
							}
							if(mvo.getPurum()!=null){
								itemM.put("unit", mvo.getPurum());
							}

							list.add(itemM);
						}
					}
					if(temp2.getVndnr()!=null){
						jo.put("firm", temp2.getVndnr());
					}
					if(temp2.getShpno()!=null){
						jo.put("receipt_number", temp2.getShpno());
					}
					if(temp2.getOstat()!=null){
						jo.put("status_code", temp2.getOstat());
					}

					jo.put("mater_list", list);
					jo.put("code", 1);
					jo.put("desc", "ok");
				}else{
					jo.put("code", 5);
					jo.put("desc", "no results");
				}

			}
			data=jo.toString();

		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");

		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data = jo.toString();
		setBackUrl("/resource/resource!toResIndex.action");
		return "todata";
	}

	public String query_receipt_item()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				//				zgrnhdrs = this.zgrnhdrService.queryReceiptSelf(receipt_number);
				//				ZGRNHDRVO temp2 = zgrnhdrs.get(0);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				ZGRNITMVO vo = new ZGRNITMVO();
				vo.setShpno(this.receipt_number);
				vo.setGrnln(BigDecimal.valueOf(Long.valueOf(this.receipt_line)));
				zgrnitms = this.zgrnhdrService.queryReceiptItem(vo);
				List<Map> list = new ArrayList<Map>();
				if(zgrnitms!=null && zgrnitms.size()>0){
					ZGRNITMVO itmVo =  zgrnitms.get(0);
					jo.put("mate_number", itmVo.getItnbr());
					jo.put("purchase_unit", itmVo.getPurum());
					jo.put("plan_quantity", itmVo.getShqty());
					jo.put("actual_quantity", itmVo.getShqty());///
					jo.put("branch_control", itmVo.getBlcf());
					jo.put("status", itmVo.getLstat());
					jo.put("actual_single", itmVo.getGrwgt1());
					jo.put("actual_unit", itmVo.getGrwum1());

					//					Map map = new HashMap();
					//					map.put("stidt9", itmVo.getHouse().trim());
					//					map.put("itnot9", itmVo.getItnbr().trim());
					ITMSITVO itmsitvo = new ITMSITVO();
					itmsitvo.setHouse(stid.trim());
					itmsitvo.setItnot9(itmVo.getItnbr().trim());
					String itrvt = "";
					List<String> itrvts = this.xadataService.queryItrvt(itmsitvo);
					if(itrvts!=null && itrvts.size()>0){
						itrvt=itrvts.get(0);
					}
					ZITMEXTVO extVo = new ZITMEXTVO();
					extVo.setItnbr(itmVo.getItnbr().trim());
					extVo.setStid(stid.trim());
					extVo.setItrv(itrvt);
					List<ZITMEXTVO> extLists = this.zitmextService.queryItemExt(extVo);
					String ldesc = "";
					if(extLists!=null && extLists.size()>0 && extLists.get(0).getLdesc().trim().length()>0){
						ldesc=extLists.get(0).getLdesc();
					}else{
						ITMRVAVO itmrVo = new ITMRVAVO();
						itmrVo.setItnbr(itmVo.getItnbr().trim());
						itmrVo.setHouse(stid.trim());
						itmrVo.setItrv(itrvt.trim());
						List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
						if(itmrLists!=null && itmrLists.size()>0){
							ldesc=itmrLists.get(0).getItdsc();
						}
					}
					jo.put("mate_desc", ldesc);

					ZITEMBXVO bxVO = new ZITEMBXVO();
					bxVO.setHouse(itmVo.getHouse().trim());
					bxVO.setItnbr(itmVo.getItnbr().trim());
					List<ZITEMBXVO> bxList = this.zitmbxService.queryItemBx(bxVO);
					if(bxList!=null && bxList.size()>0){
						jo.put("shard", bxList.get(0).getWhsub1());
						if(bxList.get(0).getLlocn1()==null || bxList.get(0).getLlocn1().trim().equals("")){
							ZWHSUBVO zwhsubVO  = new ZWHSUBVO();
							zwhsubVO.setHouse(itmVo.getHouse().trim());
							zwhsubVO.setWhsub(bxList.get(0).getWhsub1());
							List<ZWHSUBVO> zwhsubList = this.zwhsubService.queryZwhsub(zwhsubVO);
							if(zwhsubList!=null && zwhsubList.size()>0){
								jo.put("location", zwhsubList.get(0).getGrloc());
							}else{
								jo.put("location", "");
							}
						}else{
							jo.put("location", bxList.get(0).getLlocn1());
						}

					}
					if(itmVo.getBlcf()!=null && "1".equals(itmVo.getBlcf())){
						ZGRNBCHVO bchvo = new ZGRNBCHVO();
						bchvo.setShpno(itmVo.getShpno());
						bchvo.setGrnln(itmVo.getGrnln());
						bchvo.setGrnno(itmVo.getGrnno());
						List<ZGRNBCHVO> bchLists = this.zgrnhdrService.queryZgrnBchByln(vo);
						if(bchLists!=null && bchLists.size()>0){
							List<Map> bchList = new ArrayList<Map>();
							for(int k=0;k<bchLists.size();k++){
								Map bchmap = new HashMap();
								ZGRNBCHVO temp = bchLists.get(k);
								bchmap.put("branch_number", temp.getGrnbn()==null?"":temp.getGrnbn());
								bchmap.put("branch_desc", temp.getLbhno()==null?"":temp.getLbhno());
								bchmap.put("plan_quantity", temp.getSbqty()==null?0:temp.getSbqty());
								bchmap.put("actual_quantity", temp.getGbqty()==null?0:temp.getGbqty());
								bchList.add(bchmap);
							}
							jo.put("branch_list", bchList);
						}
					}
					jo.put("code", 1);
					jo.put("desc", "ok");
				}else{
					jo.put("code", 5);
					jo.put("desc", "no results");
				}

			}
			//			jo.put("env_list", list);
			data=jo.toString();
			//			os=this.getResponse().getOutputStream();
			//			os.write(returnVal.getBytes());
			//			
			//			os.flush();
			//			os.close();
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}

		setBackUrl("/resource/resource!toResIndex.action");
		return "todata";
	}

	public String query_receipt_storage_item()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				//				zgrnhdrs = this.zgrnhdrService.queryReceiptSelf(receipt_number);
				//				ZGRNHDRVO temp2 = zgrnhdrs.get(0);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				ZGRNITMVO vo = new ZGRNITMVO();
				vo.setShpno(this.receipt_number);
				vo.setGrnln(BigDecimal.valueOf(Long.valueOf(this.receipt_line)));
				zgrnitms = this.zgrnhdrService.queryReceiptItem(vo);
				List<Map> list = new ArrayList<Map>();
				if(zgrnitms!=null && zgrnitms.size()>0){
					ZGRNITMVO itmVo =  zgrnitms.get(0);
					jo.put("mate_number", itmVo.getItnbr());
					jo.put("purchase_unit", itmVo.getPurum());
					jo.put("plan_quantity", itmVo.getShqty());
					jo.put("actual_quantity", itmVo.getShqty());///
					jo.put("branch_control", itmVo.getBlcf());
					jo.put("status", itmVo.getLstat());
					jo.put("actual_single", itmVo.getGrwgt1());
					jo.put("actual_unit", itmVo.getGrwum1());
					jo.put("actual_quantity", itmVo.getDkqty());

					//					Map map = new HashMap();
					//					map.put("stidt9", itmVo.getHouse().trim());
					//					map.put("itnot9", itmVo.getItnbr().trim());
					ITMSITVO itmsitvo = new ITMSITVO();
					itmsitvo.setHouse(stid.trim());
					itmsitvo.setItnot9(itmVo.getItnbr().trim());
					String itrvt = "";
					List<String> itrvts = this.xadataService.queryItrvt(itmsitvo);
					if(itrvts!=null && itrvts.size()>0){
						itrvt=itrvts.get(0);
					}
					ZITMEXTVO extVo = new ZITMEXTVO();
					extVo.setItnbr(itmVo.getItnbr().trim());
					extVo.setStid(stid.trim());
					extVo.setItrv(itrvt);
					List<ZITMEXTVO> extLists = this.zitmextService.queryItemExt(extVo);
					String ldesc = "";
					if(extLists!=null && extLists.size()>0 && extLists.get(0).getLdesc().trim().length()>0){
						ldesc=extLists.get(0).getLdesc();
					}else{
						ITMRVAVO itmrVo = new ITMRVAVO();
						itmrVo.setItnbr(itmVo.getItnbr().trim());
						itmrVo.setHouse(stid.trim());
						itmrVo.setItrv(itrvt.trim());
						List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
						if(itmrLists!=null && itmrLists.size()>0){
							ldesc=itmrLists.get(0).getItdsc();
						}
					}
					jo.put("mate_desc", ldesc);
					jo.put("location", itmVo.getGrloc());


					/*ZITEMBXVO bxVO = new ZITEMBXVO();
					bxVO.setHouse(itmVo.getHouse().trim());
					bxVO.setItnbr(itmVo.getItnbr().trim());
					List<ZITEMBXVO> bxList = this.zitmbxService.queryItemBx(bxVO);
					if(bxList!=null && bxList.size()>0){
						jo.put("shard", bxList.get(0).getWhsub1());
						if(bxList.get(0).getLlocn1()==null || bxList.get(0).getLlocn1().trim().equals("")){
							ZWHSUBVO zwhsubVO  = new ZWHSUBVO();
							zwhsubVO.setHouse(itmVo.getHouse().trim());
							zwhsubVO.setWhsub(bxList.get(0).getWhsub1());
							List<ZWHSUBVO> zwhsubList = this.zwhsubService.queryZwhsub(zwhsubVO);
							if(zwhsubList!=null && zwhsubList.size()>0){
								jo.put("location", zwhsubList.get(0).getGrloc());
							}else{
								jo.put("location", "");
							}
						}else{
							jo.put("location", bxList.get(0).getLlocn1());
						}

					}*/


					if(itmVo.getBlcf()!=null && "1".equals(itmVo.getBlcf())){
						ZGRNBCHVO bchvo = new ZGRNBCHVO();
						bchvo.setShpno(itmVo.getShpno());
						bchvo.setGrnln(itmVo.getGrnln());
						bchvo.setGrnno(itmVo.getGrnno());
						List<ZGRNBCHVO> bchLists = this.zgrnhdrService.queryZgrnBchByln(vo);
						if(bchLists!=null && bchLists.size()>0){
							List<Map> bchList = new ArrayList<Map>();
							for(int k=0;k<bchLists.size();k++){
								Map bchmap = new HashMap();
								ZGRNBCHVO temp = bchLists.get(k);
								if(temp.getGbqty().compareTo(new BigDecimal(0))<=0)
									continue;
								bchmap.put("branch_number", temp.getGrnbn()==null?"":temp.getGrnbn());
								bchmap.put("branch_desc", temp.getLbhno()==null?"":temp.getLbhno());
								bchmap.put("plan_quantity", temp.getGbqty()==null?0:temp.getGbqty());
								bchList.add(bchmap);
							}
							jo.put("branch_list", bchList);
						}
					}
					jo.put("code", 1);
					jo.put("desc", "ok");
				}else{
					jo.put("code", 5);
					jo.put("desc", "no results");
				}

			}
			//			jo.put("env_list", list);
			data=jo.toString();
			//			os=this.getResponse().getOutputStream();
			//			os.write(returnVal.getBytes());
			//			
			//			os.flush();
			//			os.close();
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}

		setBackUrl("/resource/resource!toResIndex.action");
		return "todata";
	}
	public String mate_receipt_close()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				ZGRNITMVO vo = new ZGRNITMVO();
				vo.setShpno(this.receipt_number);
				vo.setGrnln(BigDecimal.valueOf(Long.valueOf(this.receipt_line)));
				vo.setLstat("60");
				this.zgrnhdrService.updateItemStat(vo);
				int count = this.zgrnhdrService.getCoutsByState("60");
				if(count==0){
					ZGRNHDRVO hvo = new ZGRNHDRVO();
					hvo.setShpno(this.receipt_number);
					hvo.setOstat("60");
					this.zgrnhdrService.updateHdrStat(hvo);
				}
				jo.put("code", 1);
				jo.put("desc", "ok");
			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String mate_receipt_confirm()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				ZGRNITMVO vo = new ZGRNITMVO();
				vo.setShpno(this.receipt_number);
				vo.setGrnln(BigDecimal.valueOf(Long.valueOf(this.receipt_line==null?"0":receipt_line)));
				vo.setGrwgt2(BigDecimal.valueOf(Float.valueOf(this.actual_single==null?"0":actual_single) * Float.valueOf(this.actual_quantity==null?"0":actual_quantity)));
				vo.setDkqty(BigDecimal.valueOf(Float.valueOf(this.actual_quantity==null?"0":actual_quantity)));
				vo.setGrloc(this.location);
				vo.setLstat("40");
				List<ZGRNITMVO> tempList = this.zgrnhdrService.queryReceiptItem(vo);
				List<ZGRNBCHVO> bchList = new ArrayList<ZGRNBCHVO>();
				//				JSONObject json = JSONObject.fromObject(this.branch_list);
				if(this.branch_list!=null && this.branch_list.length()>0){
					JSONObject json = JSONObject.fromObject(this.branch_list);
					JSONArray jsonArr = JSONArray.fromObject(json.get("branch_list"));
					String now1 = Utils.formateDate(null, "yyMMdd");
					String now2 = Utils.formateDate(null, "HHmmss");
					if(jsonArr!=null && jsonArr.size()>0){
						for(int i = 0;i<jsonArr.size();i++){
							ZGRNBCHVO temp = new ZGRNBCHVO();
							Map map = (Map)jsonArr.get(i);
							temp.setShpno(vo.getShpno());
							temp.setGrnln(vo.getGrnln());
							temp.setMfgdt(BigDecimal.valueOf(Long.valueOf("1"+now1)));
							temp.setGrnbn(BigDecimal.valueOf(Integer.valueOf((String)map.get("branch_number"))));
							temp.setLbhno((String)map.get("branch_desc"));
							temp.setSbqty(BigDecimal.valueOf(((Integer)map.get("plan_quantity"))));
							temp.setGbqty(BigDecimal.valueOf(((Integer)map.get("actual_quantity"))));
							temp.setExpdt(BigDecimal.valueOf(Long.valueOf("1"+now1)));
							bchList.add(temp);
						}
						vo.setItemList(bchList);
					}
				}
				boolean slRet = true;
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				System.out.println("tempList="+tempList.size());
				String userDept = "";
				List<ZBMSU02VO> dps = this.auserService.queryDeptByUserName(username);
				if(dps!=null && dps.size()>0){
					for(int i=0;i<dps.size();i++){
						ZBMSU02VO dp = dps.get(i);
						if(dp.getDflt()!=null && "1".equals(dp.getDflt().trim())){
							//							vo.setPlant(dp.getPlant());
							//							vo.setTwdp1(dp.getDept());
							userDept = dp.getDept();
						}
					}
				}
				if(actual_single_update !=null && actual_single_update.trim().equals("1")){
					if(tempList!=null && tempList.size()>0){
						ZGRNITMVO tempvo =tempList.get(0);
						ITMRVAVO rvavo = new ITMRVAVO();

						rvavo.setHouse(stid);
						rvavo.setItnbr(tempvo.getItnbr());
						List<ITMRVAVO> itmrvaList = this.xadataService.queryItmrva(rvavo); 
						if(itmrvaList!=null && itmrvaList.size()>0 ){
							for(int k = 0 ;k<itmrvaList.size();k++){
								ITMRVAVO itmrva = itmrvaList.get(k);
								Map parames = new HashMap();
								parames.put("sluserId", this.getSession().getServletContext().getAttribute("sluserId"));
								parames.put("slpassword", this.getSession().getServletContext().getAttribute("slpassword"));
								parames.put("slurl", this.getSession().getServletContext().getAttribute("slurl"));
								parames.put("site", stid);
								parames.put("item", tempvo.getItnbr().trim());
								if(itmrva.getB2cqcd()==null || itmrva.getB2cqcd().trim().equals("")){
									parames.put("weightUm", "GM");
								}else{
									parames.put("weightUm", "");
								}								
								parames.put("unitWeight",actual_single);
								parames.put("revision", itmrva.getItrv().trim());
								//								String retVal = Utils.systemLinkUw(parames);
								String xaret0 = Utils.systemLinkUw(parames);
								String retVal = (String)parames.get("systemLinkStr");

								System.out.println("um:"+retVal);
								String errorStr1 = retVal.substring(retVal.indexOf("hasErrors"), retVal.indexOf("hasErrors")+17);
								String warnStr2 = retVal.substring(retVal.indexOf("hasWarnings"), retVal.indexOf("hasWarnings")+19);
								if(errorStr1.indexOf("true")>=0){
									jo.put("code", 6);
									jo.put("desc", "systemlink error:XA更新物料单重错误！");
									data=jo.toString();
									ZSLLOGVO sysliklog = new ZSLLOGVO();
									String now1 = Utils.formateDate(null, "yyyyMMdd");
									String now3 = Utils.formateDate(null, "yyMMdd");
									String now2 = Utils.formateDate(null, "HHmmss");
									int count = this.zsllogService.getCoutsByDt(BigDecimal.valueOf(Long.valueOf("1"+now3)))+1;
									String index = "0000"+count;
									sysliklog.setSldno("SL"+now3+index.substring(index.length()-4));
									sysliklog.setAppl("A");
									sysliklog.setSltype("11");
									sysliklog.setDatyp("12");
									//									sysliklog.setSlreq(xaret0);
									//									sysliklog.setSlrsp(retVal);
									sysliklog.setSlreq("");
									sysliklog.setSlrsp("");
									sysliklog.setCrdpt(userDept);
									sysliklog.setCrusr(username);
									sysliklog.setCrdat(BigDecimal.valueOf(Long.valueOf("1"+now3)));
									sysliklog.setCrtme(BigDecimal.valueOf(Long.valueOf(now2)));
									sysliklog.setFprcs("0");
									sysliklog.setHouse("");
									sysliklog.setOsgrp("");
									sysliklog.setItnbr("");
									sysliklog.setTrqty(BigDecimal.valueOf(0));
									sysliklog.setLlocn("");
									sysliklog.setNlloc("");
									//									this.zsllogService.insertZsllog(sysliklog);

									return "todata";
								}
							}
						}
					}
				}
				this.zgrnhdrService.updateItem(vo);
				jo.put("code", 1);
				jo.put("desc", "ok");
			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String mate_receipt_storage_confirm()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				ZGRNITMVO vo = new ZGRNITMVO();
				vo.setShpno(this.receipt_number);
				vo.setGrnln(BigDecimal.valueOf(Long.valueOf(this.receipt_line==null?"0":receipt_line)));
				vo.setGrwgt2(BigDecimal.valueOf(Float.valueOf(this.actual_single==null?"0":actual_single) * Float.valueOf(this.actual_quantity==null?"0":actual_quantity)));
				vo.setGrqty(BigDecimal.valueOf(Float.valueOf(this.actual_quantity==null?"0":actual_quantity)));
				vo.setGrloc(this.location);
				vo.setLstat("50");
				List<ZGRNITMVO> tempList = this.zgrnhdrService.queryReceiptItem(vo);
				List<ZGRNBCHVO> bchList = new ArrayList<ZGRNBCHVO>();
				//				JSONObject json = JSONObject.fromObject(this.branch_list);
				if(this.branch_list!=null && this.branch_list.length()>0){
					JSONObject json = JSONObject.fromObject(this.branch_list);
					JSONArray jsonArr = JSONArray.fromObject(json.get("branch_list"));
					String now1 = Utils.formateDate(null, "yyMMdd");
					String now2 = Utils.formateDate(null, "HHmmss");
					if(jsonArr!=null && jsonArr.size()>0){
						for(int i = 0;i<jsonArr.size();i++){
							ZGRNBCHVO temp = new ZGRNBCHVO();
							Map map = (Map)jsonArr.get(i);						
							temp.setShpno(vo.getShpno());
							temp.setGrnln(vo.getGrnln());
							temp.setMfgdt(BigDecimal.valueOf(Long.valueOf("1"+now1)));
							temp.setGrnbn(BigDecimal.valueOf(Integer.valueOf((String)map.get("branch_number"))));
							temp.setLbhno((String)map.get("branch_desc"));
							temp.setSbqty(BigDecimal.valueOf(((Integer)map.get("plan_quantity"))));
							temp.setGbqty(BigDecimal.valueOf(((Integer)map.get("actual_quantity"))));
							temp.setExpdt(BigDecimal.valueOf(Long.valueOf("1"+now1)));
							bchList.add(temp);
						}
						vo.setItemList(bchList);

					}
				}
				boolean slRet = true;
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				System.out.println("tempList="+tempList.size());
				String userDept = "";
				List<ZBMSU02VO> dps = this.auserService.queryDeptByUserName(username);
				if(dps!=null && dps.size()>0){
					for(int i=0;i<dps.size();i++){
						ZBMSU02VO dp = dps.get(i);
						if(dp.getDflt()!=null && "1".equals(dp.getDflt().trim())){
							//							vo.setPlant(dp.getPlant());
							//							vo.setTwdp1(dp.getDept());
							userDept = dp.getDept();
						}
					}
				}
				if(actual_single_update !=null && actual_single_update.trim().equals("1")){
					if(tempList!=null && tempList.size()>0){
						ZGRNITMVO tempvo =tempList.get(0);
						ITMRVAVO rvavo = new ITMRVAVO();

						rvavo.setHouse(stid);
						rvavo.setItnbr(tempvo.getItnbr());
						List<ITMRVAVO> itmrvaList = this.xadataService.queryItmrva(rvavo); 
						if(itmrvaList!=null && itmrvaList.size()>0 ){
							for(int k = 0 ;k<itmrvaList.size();k++){
								ITMRVAVO itmrva = itmrvaList.get(k);
								Map parames = new HashMap();
								parames.put("sluserId", this.getSession().getServletContext().getAttribute("sluserId"));
								parames.put("slpassword", this.getSession().getServletContext().getAttribute("slpassword"));
								parames.put("slurl", this.getSession().getServletContext().getAttribute("slurl"));
								parames.put("site", stid);
								parames.put("item", tempvo.getItnbr().trim());
								if(itmrva.getB2cqcd()==null || itmrva.getB2cqcd().trim().equals("")){
									parames.put("weightUm", "GM");
								}else{
									parames.put("weightUm", "");
								}								
								parames.put("unitWeight",actual_single);
								parames.put("revision", itmrva.getItrv().trim());
								//								String retVal = Utils.systemLinkUw(parames);
								String xaret0 = Utils.systemLinkUw(parames);
								String retVal = (String)parames.get("systemLinkStr");

								System.out.println("um:"+retVal);
								String errorStr1 = retVal.substring(retVal.indexOf("hasErrors"), retVal.indexOf("hasErrors")+17);
								String warnStr2 = retVal.substring(retVal.indexOf("hasWarnings"), retVal.indexOf("hasWarnings")+19);
								if(errorStr1.indexOf("true")>=0){
									jo.put("code", 6);
									jo.put("desc", "systemlink error:XA更新物料单重错误！");
									data=jo.toString();
									ZSLLOGVO sysliklog = new ZSLLOGVO();
									String now1 = Utils.formateDate(null, "yyyyMMdd");
									String now3 = Utils.formateDate(null, "yyMMdd");
									String now2 = Utils.formateDate(null, "HHmmss");
									int count = this.zsllogService.getCoutsByDt(BigDecimal.valueOf(Long.valueOf("1"+now3)))+1;
									String index = "0000"+count;
									sysliklog.setSldno("SL"+now3+index.substring(index.length()-4));
									sysliklog.setAppl("A");
									sysliklog.setSltype("11");
									sysliklog.setDatyp("12");
									//									sysliklog.setSlreq(xaret0);
									//									sysliklog.setSlrsp(retVal);
									sysliklog.setSlreq("");
									sysliklog.setSlrsp("");
									sysliklog.setCrdpt(userDept);
									sysliklog.setCrusr(username);
									sysliklog.setCrdat(BigDecimal.valueOf(Long.valueOf("1"+now3)));
									sysliklog.setCrtme(BigDecimal.valueOf(Long.valueOf(now2)));
									sysliklog.setFprcs("0");
									sysliklog.setHouse("");
									sysliklog.setOsgrp("");
									sysliklog.setItnbr("");
									sysliklog.setTrqty(BigDecimal.valueOf(0));
									sysliklog.setLlocn("");
									sysliklog.setNlloc("");
									//									this.zsllogService.insertZsllog(sysliklog);

									return "todata";
								}
							}

						}

					}
				}
				ZGRNHDRVO hdrVo = this.zgrnhdrService.queryZgrnByNo(this.receipt_number);
				ZBMSCTLVO bmsctlVO = new ZBMSCTLVO();
				bmsctlVO.setSite(stid);
				List<ZBMSCTLVO> bmsctlList = this.zbmsctlService.queryZbmsctl(bmsctlVO);
				if(bchList!=null && bchList.size()>0){
					String syslinkResult = "";
					if(tempList!=null && tempList.size()>0){
						ZGRNITMVO tempvo =tempList.get(0);
						for(int h=0;h<bchList.size();h++){
							Map parames = new HashMap();
							ZGRNBCHVO bchtemp =( ZGRNBCHVO )bchList.get(h);
							if(bchtemp.getGbqty().intValue()>0){
								parames.put("sluserId", this.getSession().getServletContext().getAttribute("sluserId"));
								parames.put("slpassword", this.getSession().getServletContext().getAttribute("slpassword"));
								parames.put("slurl", this.getSession().getServletContext().getAttribute("slurl"));
								parames.put("site", stid);

								parames.put("scheduledReceiptToken", tempvo.getSctkji().trim());

								parames.put("grnInvoiceFlag","true");
								parames.put("batchLot", bchtemp.getLbhno().trim());

								parames.put("receivedToStockWarehouseLocation",this.location);
								parames.put("reference", tempvo.getGrnno().trim().substring(tempvo.getGrnno().trim().length()-10));

								parames.put("unitOfMeasure",tempvo.getPurum().trim());
								parames.put("setScheduledReceiptStatus", "");

								parames.put("transactionDate",Utils.formateDate(null, "yyyyMMdd"));
								parames.put("receivedToStockFlag", "true");

								parames.put("goodsReceivedNote",hdrVo.getLgwno().trim());
								//parames.put("setScheduledReceiptStatus", hdrVo.getLgwno().trim());

								parames.put("receivedToStockQuantity",bchtemp.getGbqty());
								if(bmsctlList!=null && bmsctlList.size()>0){
									parames.put("receivedToStockReason", bmsctlList.get(0).getRprsn().trim());
								}else{
									parames.put("receivedToStockReason", "");
								}


								//							String retVal = Utils.systemLinkRp(parames);
								String xaret0 = Utils.systemLinkRp(parames);
								String retVal = (String)parames.get("systemLinkStr");
								System.out.println("rp:"+retVal);

								String errorStr1 = retVal.substring(retVal.indexOf("hasErrors"), retVal.indexOf("hasErrors")+17);
								String warnStr2 = retVal.substring(retVal.indexOf("hasWarnings"), retVal.indexOf("hasWarnings")+19);
								if(errorStr1.indexOf("true")>=0){
									jo.put("code", 6);
									jo.put("desc", "systemlink error:XA批次入库错误！已入库批次号："+syslinkResult);
									//								break;
									data=jo.toString();

									ZSLLOGVO sysliklog = new ZSLLOGVO();
									String now1 = Utils.formateDate(null, "yyMMdd");

									String now2 = Utils.formateDate(null, "HHmmss");
									int count = this.zsllogService.getCoutsByDt(BigDecimal.valueOf(Long.valueOf("1"+now1)))+1;
									String index = "0000"+count;
									sysliklog.setSldno("SL"+now1+index.substring(index.length()-4));
									sysliklog.setAppl("A");
									sysliklog.setSltype("01");
									sysliklog.setDatyp("01");
									//								sysliklog.setSlreq(xaret0);
									//								sysliklog.setSlrsp(retVal);
									sysliklog.setSlreq("");
									sysliklog.setSlrsp("");
									sysliklog.setCrdpt(userDept);
									sysliklog.setCrusr(username);
									sysliklog.setCrdat(BigDecimal.valueOf(Long.valueOf("1"+now1)));
									sysliklog.setCrtme(BigDecimal.valueOf(Long.valueOf(now2)));
									sysliklog.setFprcs("0");
									sysliklog.setOsgrp("");
									sysliklog.setHouse(bchtemp.getHouse());
									sysliklog.setItnbr(bchtemp.getItnbr());
									sysliklog.setTrqty(bchtemp.getGbqty());
									sysliklog.setLlocn(tempvo.getGrloc());
									sysliklog.setNlloc("");
									//								this.zsllogService.insertZsllog(sysliklog);

									return "todata";
								}else{
									syslinkResult=syslinkResult+bchtemp.getLbhno().trim()+";";
								}
							}

						}
					}
				}else{
					if(tempList!=null && tempList.size()>0){
						ZGRNITMVO tempvo =tempList.get(0);
						Map parames = new HashMap();
						//						ZGRNBCHVO bchtemp =( ZGRNBCHVO )bchList.get(h);
						parames.put("sluserId", this.getSession().getServletContext().getAttribute("sluserId"));
						parames.put("slpassword", this.getSession().getServletContext().getAttribute("slpassword"));
						parames.put("slurl", this.getSession().getServletContext().getAttribute("slurl"));
						parames.put("site", stid);

						parames.put("scheduledReceiptToken", tempvo.getSctkji().trim());

						parames.put("grnInvoiceFlag","true");
						parames.put("batchLot", "");
						//						System.out.println("tempvo.getGrnno(): "+tempvo.getGrnno());
						parames.put("receivedToStockWarehouseLocation",this.location);
						parames.put("reference", tempvo.getGrnno().trim().substring(tempvo.getGrnno().trim().length()-10));

						parames.put("unitOfMeasure",tempvo.getPurum().trim());
						parames.put("setScheduledReceiptStatus", "");

						parames.put("transactionDate",Utils.formateDate(null, "yyyyMMdd"));
						parames.put("receivedToStockFlag", "true");

						parames.put("goodsReceivedNote",hdrVo.getLgwno().trim());
						//parames.put("setScheduledReceiptStatus", hdrVo.getLgwno().trim());

						parames.put("receivedToStockQuantity",Float.valueOf(this.actual_quantity==null?"0":actual_quantity));
						if(bmsctlList!=null && bmsctlList.size()>0){
							parames.put("receivedToStockReason", bmsctlList.get(0).getRprsn().trim());
						}else{
							parames.put("receivedToStockReason", "");
						}


						//						String retVal = Utils.systemLinkRp(parames);

						String xaret0 = Utils.systemLinkRp(parames);
						String retVal = (String)parames.get("systemLinkStr");
						System.out.println("rp:"+retVal);
						String errorStr1 = retVal.substring(retVal.indexOf("hasErrors"), retVal.indexOf("hasErrors")+17);
						String warnStr2 = retVal.substring(retVal.indexOf("hasWarnings"), retVal.indexOf("hasWarnings")+19);
						if(errorStr1.indexOf("true")>=0){
							jo.put("code", 6);
							jo.put("desc", "systemlink error:XA物料入库错误！");
							data=jo.toString();

							ZSLLOGVO sysliklog = new ZSLLOGVO();
							//							String now1 = Utils.formateDate(null, "yyyyMMdd");
							String now3 = Utils.formateDate(null, "yyMMdd");

							String now2 = Utils.formateDate(null, "HHmmss");
							int count = this.zsllogService.getCoutsByDt(BigDecimal.valueOf(Long.valueOf("1"+now3)))+1;
							String index = "0000"+count;
							sysliklog.setSldno("SL"+now3+index.substring(index.length()-4));
							sysliklog.setAppl("A");
							sysliklog.setSltype("01");
							sysliklog.setDatyp("01");
							//							sysliklog.setSlreq(xaret0);
							//							sysliklog.setSlrsp(retVal);
							sysliklog.setSlreq("");
							sysliklog.setSlrsp("");
							sysliklog.setCrdpt(userDept);
							sysliklog.setCrusr(username);
							sysliklog.setCrdat(BigDecimal.valueOf(Long.valueOf("1"+now3)));
							sysliklog.setCrtme(BigDecimal.valueOf(Long.valueOf(now2)));
							sysliklog.setFprcs("0");
							sysliklog.setOsgrp("");
							sysliklog.setHouse(tempvo.getHouse());
							sysliklog.setItnbr(tempvo.getItnbr());
							sysliklog.setTrqty(tempvo.getGrqty());
							sysliklog.setLlocn(tempvo.getGrloc());
							sysliklog.setNlloc("");
							//							this.zsllogService.insertZsllog(sysliklog);
							return "todata";
						}
					}

				}
				//如果需要更新单重，则要去调用systemlink更新XA的数据
				//将收货单行状态改为已收货, 同时调用SystemLink完成XA采购入库
				//调用完systemlink后才会更新开发表
				this.zgrnhdrService.updateItem(vo);
				jo.put("code", 1);
				jo.put("desc", "ok");
			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String inventory_update_submit()  throws Exception {
		JSONObject jo = new JSONObject();
		try {
			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				Map xamap0 = new HashMap();

				xamap0.put("sluserId", this.getSession().getServletContext().getAttribute("sluserId"));
				xamap0.put("slpassword", this.getSession().getServletContext().getAttribute("slpassword"));
				xamap0.put("slurl", this.getSession().getServletContext().getAttribute("slurl"));
				xamap0.put("warehouse", warehouse);
				xamap0.put("item", mater.trim());
				xamap0.put("postedDate", "0000000");
				xamap0.put("postedTime", "999999");
				xamap0.put("location", location.trim());
				xamap0.put("batchlot", branch.trim());
				xamap0.put("transactionQuantity", ia_quantity.trim());
				xamap0.put("referenceNumber", "PDA");

				ZBMSCTLVO zbmsctlvo = new ZBMSCTLVO();
				List<ZBMSCTLVO> zbmsctlList = zbmsctlService.queryZbmsctl(zbmsctlvo);
				if(zbmsctlList.size()>0){
					xamap0.put("reason", zbmsctlList.get(0).getIarsn().trim());
				}else{
					xamap0.put("reason", "");
				}

				xamap0.put("transactionDate", Utils.formateDate(null, "yyyyMMdd"));

				Utils.systemLinkIA(xamap0);
				String retStr = (String)xamap0.get("systemLinkStr");
				System.out.println("Tw:"+retStr);
				String errorStr1 = retStr.substring(retStr.indexOf("hasErrors"), retStr.indexOf("hasErrors")+17);
				String warnStr2 = retStr.substring(retStr.indexOf("hasWarnings"), retStr.indexOf("hasWarnings")+19);
				if(errorStr1.indexOf("true")>=0){
					if(retStr.contains("warehouse location does not exist")){
						jo.put("code", 5);
						jo.put("desc", "待入库位不存在");
					}else{
						jo.put("code", 6);
						jo.put("desc", "systemlink error:XA更新项目仓库默认子库和库位错误！");
					}
				}else{
					jo.put("code", 1);
					jo.put("desc", "OK");
				}
			}
		}catch (Throwable e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		log.error("get env error.",e);
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String inventory_add_query()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				ZITMEXTVO zitmextvo = new ZITMEXTVO();
				zitmextvo.setItnbr(mater);
				List<ZITMEXTVO> list = zitmextService.queryItemExt(zitmextvo);
				if(list.size()>0){
					ZITMEXTVO vo = list.get(0);
					if(vo.getLdesc().trim().isEmpty()){
						ITMRVAVO itmrvavo = new ITMRVAVO();
						itmrvavo.setHouse(warehouse);
						itmrvavo.setItnbr(mater);
						itmrvavo.setItrv(vo.getItrv());
						List<ITMRVAVO> itmrvaList = xadataService.queryItmrva(itmrvavo);
						if(itmrvaList.size()>0){
							jo.put("mater_desc", itmrvaList.get(0).getItdsc());
						}else{
							jo.put("mater_desc", "");
						}
					}else{
						jo.put("mater_desc", vo.getLdesc());
					}

					jo.put("mater_format", vo.getSdesc());

					ITMSITVO itmsitvo = new ITMSITVO();
					itmsitvo.setHouse(warehouse);
					itmsitvo.setItnot9(mater);
					List<ITMSITVO> itrvtAll = xadataService.queryItrvtAll(itmsitvo);
					if(itrvtAll.size()>0){
						if(itrvtAll.get(0).getBlcft9().equals("1")){
							jo.put("branched", "1");
						}else{
							jo.put("branched", "0");
						}
						jo.put("unit", itrvtAll.get(0).getUmstt9());
					}else{
						jo.put("branched", "0");
						jo.put("unit", "");
					}

					jo.put("code", "1");
					jo.put("desc", "OK");
				}else{
					jo.put("code", "6");
					jo.put("desc", "未找到该物料");
				}

			}
		}catch (Throwable e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		log.error("get env error.",e);
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String query_warehouse()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				ZBMSU01VO vo = new ZBMSU01VO();
				vo.setBmsusr(username);
				List<ZBMSU01VO> zbmsList = this.zbmsu01Service.queryZbmsu(vo);
				String defaultHouse ="";
				if(zbmsList!=null && zbmsList.size()>0){
					List<Map> map = new ArrayList<Map>();

					for(int i=0;i<zbmsList.size();i++){
						ZBMSU01VO temp = zbmsList.get(i);
						Map tm = new HashMap();
						tm.put("name", temp.getHouse());
						if("1".equals(temp.getDlft())){
							defaultHouse = temp.getHouse();
						}
						map.add(tm);
					}
					jo.put("warehouse_list", map);
					jo.put("warehouse", defaultHouse);
					jo.put("code", 1);
					jo.put("desc", "ok");
				}else{
					jo.put("code", 5);
					jo.put("desc", "no houses");
				}				
			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String query_shard_list()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				ZWHSUBVO vo = new ZWHSUBVO();
				vo.setHouse(warehouse);
				List<ZWHSUBVO> zwhsubList = this.zwhsubService.queryZwhsub(vo);
				String defaultHouse ="";
				if(zwhsubList!=null && zwhsubList.size()>0){
					List<Map> map = new ArrayList<Map>();

					for(int i=0;i<zwhsubList.size();i++){
						ZWHSUBVO temp = zwhsubList.get(i);
						Map tm = new HashMap();
						tm.put("name", temp.getWhsub());

						map.add(tm);
					}
					jo.put("shard_list", map);
					jo.put("code", 1);
					jo.put("desc", "ok");
				}else{
					jo.put("code", 5);
					jo.put("desc", "no houses");
				}				
			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String create_requisition_get_mater_list()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				Map map = new HashMap();
				map.put("warehouse", warehouse);
				map.put("shard", shard);
				map.put("stid", stid);
				if(this.location!=null && !location.trim().equals("")){
					map.put("location", location);
				}
				if(this.mate!=null && !mate.trim().equals("")){
					map.put("itnbr", mate);
				}
				List<SLQNTYVO> results = this.xadataService.querySlqnty(map);
				if(results!=null && results.size()>0){
					List<Map> resultmap = new ArrayList<Map>();
					for(int i=0;i<results.size();i++){
						SLQNTYVO temp = results.get(i);
						Map tm = new HashMap();
						//						this.xadataService.q
						tm.put("shard", temp.getUucalm());
						tm.put("mate", temp.getItnbr());
						tm.put("location", temp.getLlocn());
						tm.put("branch", temp.getLbhno());
						tm.put("quantity", temp.getLqnty());
						tm.put("unit", temp.getUnpurum());

						ZITEMBXVO vo2 = new ZITEMBXVO();
						vo2.setHouse(warehouse);
						vo2.setItnbr(temp.getItnbr());
						List<ZITEMBXVO> bxresults=this.zitmbxService.queryItemBx(vo2);

						if(bxresults!=null && bxresults.size()>0){
							//							jo.put("target_shard", bxresults.get(0).getWhsub2());
							//							jo.put("target_location", bxresults.get(0).getLlocn2());
							tm.put("target_shard", bxresults.get(0).getWhsub2());
							tm.put("target_location", bxresults.get(0).getLlocn2());
						}else{
							jo.put("code", 5);
							jo.put("desc", "no results");

						}

						resultmap.add(tm);
					}
					jo.put("mater_list", resultmap);
					jo.put("code", 1);
					jo.put("desc", "ok");
				}else{
					jo.put("code", 5);
					jo.put("desc", "no results");
				}
			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String create_requisition_get_mater()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				ITMSITVO itmsitvo = new ITMSITVO();
				itmsitvo.setHouse(stid.trim());
				itmsitvo.setItnot9(mate.trim());
				String itrvt = "";
				List<String> itrvts = this.xadataService.queryItrvt(itmsitvo);
				if(itrvts!=null && itrvts.size()>0){
					itrvt=itrvts.get(0);
				}
				ZITMEXTVO extVo = new ZITMEXTVO();
				extVo.setItnbr(mate.trim());
				extVo.setStid(stid.trim());
				extVo.setItrv(itrvt.trim());
				List<ZITMEXTVO> extLists = this.zitmextService.queryItemExt(extVo);
				String ldesc = "";
				if(extLists!=null && extLists.size()>0 && extLists.get(0).getLdesc().trim().length()>0){
					ldesc=extLists.get(0).getLdesc();
					jo.put("mater_desc", ldesc);
					jo.put("mater_format", extLists.get(0).getSdesc());
				}else{
					ITMRVAVO itmrVo = new ITMRVAVO();
					itmrVo.setItnbr(mate.trim());
					itmrVo.setHouse(stid.trim());
					itmrVo.setItrv(itrvt.trim());
					List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
					if(itmrLists!=null && itmrLists.size()>0){
						ldesc=itmrLists.get(0).getItdsc();
						jo.put("mater_desc", ldesc);
						jo.put("mater_format", "");
					}else{
						jo.put("mater_desc", "");
						jo.put("mater_format", "");
					}

				}
				ZITEMBXVO vo2 = new ZITEMBXVO();
				vo2.setHouse(warehouse);
				vo2.setItnbr(mate);
				List<ZITEMBXVO> results=this.zitmbxService.queryItemBx(vo2);

				if(results!=null && results.size()>0){
					jo.put("target_shard", results.get(0).getWhsub2());
					jo.put("target_location", results.get(0).getLlocn2());

				}else{
					jo.put("target_shard", "");
					jo.put("target_location", "");
				}
				jo.put("code", 1);
				jo.put("desc", "ok");
			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String create_requisition_commit()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				System.out.println("this.mater_list 0="+this.mater_list);
				ZTWHDRVO vo = new ZTWHDRVO();
				String now1 = Utils.formateDate(null, "yyMMdd");
				String now2 = Utils.formateDate(null, "HHmmss");
				BigDecimal dbnow=BigDecimal.valueOf(Long.valueOf("1"+now1));
				String serial = "0000"+(this.ztwhdrService.getCoutsByDt(dbnow)+1);
				List<ZBMSU02VO> dps = this.auserService.queryDeptByUserName(username);
				if(dps!=null && dps.size()>0){
					for(int i=0;i<dps.size();i++){
						ZBMSU02VO dp = dps.get(i);
						if(dp.getDflt()!=null && "1".equals(dp.getDflt().trim())){
							vo.setPlant(dp.getPlant());
							vo.setTwdp1(dp.getDept());
						}
					}
				}
				String number = "TW"+now1+serial.substring(serial.length()-4);
				vo.setTwtyp("1");
				vo.setTwus1(username);
				vo.setTwdt1(dbnow);
				vo.setTwtm1(BigDecimal.valueOf(Long.valueOf(now2)));
				vo.setOstat("10");
				vo.setTwdno(number);
				vo.setTwsrc("");
				vo.setTwlin(BigDecimal.valueOf(0));
				vo.setCmmt("");
				System.out.println("this.mater_list 1="+this.mater_list);
				List<ZTWDTLVO> itemList = new ArrayList<ZTWDTLVO>();

				if(this.mater_list!=null && this.mater_list.length()>0){
					JSONObject json = JSONObject.fromObject(this.mater_list);
					JSONArray jsonArr = JSONArray.fromObject(json.get("mater_list"));

					if(jsonArr!=null && jsonArr.size()>0){

						for(int i = 0;i<jsonArr.size();i++){
							ZTWDTLVO temp = new ZTWDTLVO();
							ZTWBCHVO temp2 = new ZTWBCHVO();
							List<ZTWBCHVO> itemList2 = new ArrayList<ZTWBCHVO>();
							Map map = (Map)jsonArr.get(i);
							//							ZITEMBXVO bxvo = new ZITEMBXVO();
							//							bxvo.setHouse((String)map.get("target_warehouse"));
							//							bxvo.setItnbr((String)map.get("mater"));
							//							bxvo.setLlocn2((String)map.get("target_location"));
							//							List<ZITEMBXVO> bxvos = this.zitmbxService.queryItemBx(bxvo);
							//							if(bxvos==null || bxvos.size()==0){
							//								jo.put("code", "6");
							//								jo.put("desc", "目标库位："+(String)map.get("target_location")+"不存在");
							//								data=jo.toString();
							//								return "todata";
							//							}
							temp.setTwdno(number);
							temp2.setTwdno(number);							
							temp.setTwdln(BigDecimal.valueOf(i+1));
							temp2.setTwdln(BigDecimal.valueOf(i+1));
							temp2.setTwdbn(BigDecimal.valueOf(1));
							temp.setItnbr((String)map.get("mater"));
							temp2.setItnbr((String)map.get("mater"));
							//							temp
							ITMSITVO itmsitvo = new ITMSITVO();
							itmsitvo.setHouse(stid.trim());
							itmsitvo.setItnot9((String)map.get("mater"));
							String itrvt = "";
							List<String> itrvts = this.xadataService.queryItrvt(itmsitvo);
							if(itrvts!=null && itrvts.size()>0){
								itrvt=itrvts.get(0);
							}
							ITMRVAVO itmrVo = new ITMRVAVO();
							itmrVo.setItnbr((String)map.get("mater"));
							itmrVo.setHouse(stid.trim());
							itmrVo.setItrv(itrvt.trim());
							List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
							if(itmrLists!=null && itmrLists.size()>0){
								temp.setBlcf(itmrLists.get(0).getBlcf());
								temp.setUnmsr(itmrLists.get(0).getUnmsr());
							}
							temp.setFrwhs((String)map.get("from_warehouse"));
							temp.setFrsub((String)map.get("from_shard"));
							temp.setFrloc((String)map.get("from_location"));
							temp.setPlnqt(BigDecimal.valueOf(Double.valueOf(map.get("quantity")!=null?(map.get("quantity").toString()):"0")));
							temp.setTowhs((String)map.get("target_warehouse"));
							temp.setTosub((String)map.get("target_shard"));
							temp.setToloc((String)map.get("target_location"));
							temp.setLstat("10");
							temp.setLprt("0");
							temp.setTwus2("");
							temp.setTwdp2("");
							temp.setFinsp("0");
							temp.setActqt(BigDecimal.valueOf(0));
							temp.setTwdt2(BigDecimal.valueOf(0));
							temp.setTwtm2(BigDecimal.valueOf(0));
							temp2.setActbh((String)map.get("branch"));
							temp2.setFrwhs((String)map.get("from_warehouse"));
							temp2.setFrsub((String)map.get("from_shard"));
							temp2.setFrloc((String)map.get("from_location"));
							temp2.setTowhs((String)map.get("target_warehouse"));
							temp2.setTosub((String)map.get("target_shard"));
							temp2.setToloc((String)map.get("target_location"));
							temp2.setActbh((String)map.get("branch"));
							temp2.setActqt(BigDecimal.valueOf(0));
							itemList2.add(temp2);
							temp.setItemList(itemList2);
							itemList.add(temp);

						}
						vo.setItemList(itemList);
						this.ztwhdrService.insertZtwhdr(vo);
					}
				}
				jo.put("code", "1");
				jo.put("desc", "ok");
				jo.put("number", number);
			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String check_requisition_get_mater_list()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				ZTWHDRVO pvo = new ZTWHDRVO();
				pvo.setTwdno(this.requisition);
				ZTWHDRVO vo = this.ztwhdrService.queryZtwhdr(pvo);
				if(vo!=null){
					jo.put("state", vo.getOstat());
					jo.put("founder", vo.getTwus1());
					jo.put("department", vo.getTwdp1());
					String retDate = "";
					if(vo.getTwdt1()!=null){
						String d = vo.getTwdt1().add(BigDecimal.valueOf(19000000)).toString();

						retDate=d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" ";
						if(vo.getTwtm1()!=null){
							String t = vo.getTwtm1().toString();
							if(t.length()<6){
								t="0"+t;
							}
							retDate=retDate+t.substring(0, 2)+":"+t.substring(2, 4)+":"+t.substring(4, t.length());
						}

					}
					jo.put("date", retDate);
					List<ZTWDTLVO> itemList = vo.getItemList();
					if(itemList!=null){
						List<Map> results = new ArrayList<Map>();
						for(int i=0;i<itemList.size();i++){
							ZTWDTLVO tvo = itemList.get(i);
							Map temp = new HashMap();
							temp.put("requisition_line", tvo.getTwdln());
							temp.put("mater", tvo.getItnbr());
							temp.put("branch", tvo.getItemList().get(0).getActbh());
							temp.put("quantity", tvo.getPlnqt());
							temp.put("unit", tvo.getUnmsr());
							results.add(temp);
						}
						jo.put("mater_list", results);
					}
					//					Map map = new HashMap();
					//					map.put("warehouse", warehouse);
					//					map.put("shard", shard);
					//					map.put("stid", stid);
					//					if(this.location!=null && !location.trim().equals("")){
					//						map.put("location", location);
					//					}
					//					if(this.mate!=null && !mate.trim().equals("")){
					//						map.put("itnbr", mate);
					//					}
					//					List<SLQNTYVO> results = this.xadataService.querySlqnty(map);

					jo.put("code", 1);
					jo.put("desc", "ok");
				}else{
					jo.put("code", 5);
					jo.put("desc", "no results");
				}

			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String check_requisition_get_mater_detail()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				ZTWDTLVO pvo = new ZTWDTLVO();
				pvo.setTwdno(this.requisition);
				pvo.setTwdln(BigDecimal.valueOf(Integer.valueOf(this.requisition_line)));

				List<ZTWDTLVO> itemList = this.ztwhdrService.queryZtwdtl(pvo);
				if(itemList!=null){
					ZTWDTLVO vo = itemList.get(0);
					//					Map temp = new HashMap();
					ITMSITVO itmsitvo = new ITMSITVO();
					itmsitvo.setHouse(stid.trim());
					itmsitvo.setItnot9(vo.getItnbr().trim());
					String itrvt = "";
					List<String> itrvts = this.xadataService.queryItrvt(itmsitvo);
					if(itrvts!=null && itrvts.size()>0){
						itrvt=itrvts.get(0);
					}
					ZITMEXTVO extVo = new ZITMEXTVO();
					extVo.setItnbr(vo.getItnbr().trim());
					extVo.setStid(stid.trim());
					extVo.setItrv(itrvt.trim());
					List<ZITMEXTVO> extLists = this.zitmextService.queryItemExt(extVo);
					String ldesc = "";
					if(extLists!=null && extLists.size()>0 && extLists.get(0).getLdesc().trim().length()>0){
						ldesc=extLists.get(0).getLdesc();
						jo.put("mater_desc", ldesc);
						jo.put("mater_format", extLists.get(0).getSdesc());
					}else{
						ITMRVAVO itmrVo = new ITMRVAVO();
						itmrVo.setItnbr(vo.getItnbr().trim());
						itmrVo.setHouse(stid.trim());
						itmrVo.setItrv(itrvt.trim());
						List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
						if(itmrLists!=null && itmrLists.size()>0){
							ldesc=itmrLists.get(0).getItdsc();
							jo.put("mater_desc", ldesc);
							jo.put("mater_format", "");
						}else{
							jo.put("mater_desc", "");
							jo.put("mater_format", "");
						}

					}	
					jo.put("from_warehouse",vo.getFrwhs());
					jo.put("form_shard",vo.getFrsub());
					jo.put("form_location",vo.getFrloc());

					jo.put("target_shard",vo.getTosub());
					jo.put("target_location",vo.getToloc());
					//					jo.put("form_location",vo.getFrloc());
					ZWHSUBVO vo2 = new ZWHSUBVO();
					vo2.setHouse(vo.getFrwhs());
					//					vo2.setItnbr(mate);
					List<ZWHSUBVO> results=this.zwhsubService.queryZwhsub(vo2);
					if(results!=null && results.size()>0){
						List<Map> retList = new ArrayList<Map>();
						for(int i = 0;i<results.size();i++){
							ZWHSUBVO tvo = results.get(i);
							Map map = new HashMap();
							if(tvo.getWhsub()!=null && !tvo.getWhsub().trim().equals("")){
								map.put("shard", tvo.getWhsub());
								retList.add(map);
							}

						}

						jo.put("target_shard_list",retList);
					}

					jo.put("code", 1);
					jo.put("desc", "ok");
				}else{
					jo.put("code", 5);
					jo.put("desc", "no results");
				}

			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String fast_requisition_commit()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				System.out.println("this.mater_list 0="+this.mater_list);
				ZTWHDRVO vo = new ZTWHDRVO();
				String now1 = Utils.formateDate(null, "yyMMdd");
				String now2 = Utils.formateDate(null, "HHmmss");
				BigDecimal dbnow=BigDecimal.valueOf(Long.valueOf("1"+now1));
				String serial = "0000"+(this.ztwhdrService.getCoutsByDt(dbnow)+1);
				List<ZBMSU02VO> dps = this.auserService.queryDeptByUserName(username);
				String userDept="";
				if(dps!=null && dps.size()>0){
					for(int i=0;i<dps.size();i++){
						ZBMSU02VO dp = dps.get(i);
						if(dp.getDflt()!=null && "1".equals(dp.getDflt().trim())){
							userDept=dp.getDept();
							vo.setPlant(dp.getPlant());
							vo.setTwdp1(userDept);

						}
					}
				}
				String number = "TW"+now1+serial.substring(serial.length()-4);
				vo.setTwtyp("3");
				vo.setTwus1(username);
				vo.setTwdt1(dbnow);
				vo.setTwtm1(BigDecimal.valueOf(Long.valueOf(now2)));
				vo.setOstat("10");
				vo.setTwdno(number);
				vo.setTwsrc("");
				vo.setTwlin(BigDecimal.valueOf(0));
				vo.setCmmt("");
				System.out.println("this.mater_list 1="+this.mater_list);
				List<ZTWDTLVO> itemList = new ArrayList<ZTWDTLVO>();

				if(this.mater_list!=null && this.mater_list.length()>0){
					JSONObject json = JSONObject.fromObject(this.mater_list);
					JSONArray jsonArr = JSONArray.fromObject(json.get("mater_list"));

					if(jsonArr!=null && jsonArr.size()>0){

						for(int i = 0;i<jsonArr.size();i++){
							ZTWDTLVO temp = new ZTWDTLVO();
							ZTWBCHVO temp2 = new ZTWBCHVO();
							List<ZTWBCHVO> itemList2 = new ArrayList<ZTWBCHVO>();
							Map map = (Map)jsonArr.get(i);
							//							ZITEMBXVO bxvo = new ZITEMBXVO();
							//							bxvo.setHouse((String)map.get("target_warehouse"));
							//							bxvo.setItnbr((String)map.get("mater"));
							//							bxvo.setLlocn2((String)map.get("target_location"));
							//							List<ZITEMBXVO> bxvos = this.zitmbxService.queryItemBx(bxvo);
							//							if(bxvos==null || bxvos.size()==0){
							//								jo.put("code", "6");
							//								jo.put("desc", "目标库位："+(String)map.get("target_location")+"不存在");
							//								data=jo.toString();
							//								return "todata";
							//							}
							temp.setTwdno(number);
							temp2.setTwdno(number);							
							temp.setTwdln(BigDecimal.valueOf(i+1));
							temp2.setTwdln(BigDecimal.valueOf(i+1));
							temp2.setTwdbn(BigDecimal.valueOf(1));
							temp.setItnbr((String)map.get("mater"));
							temp2.setItnbr((String)map.get("mater"));
							//							temp
							ITMSITVO itmsitvo = new ITMSITVO();
							itmsitvo.setHouse(stid.trim());
							itmsitvo.setItnot9((String)map.get("mater"));
							String itrvt = "";
							List<String> itrvts = this.xadataService.queryItrvt(itmsitvo);
							if(itrvts!=null && itrvts.size()>0){
								itrvt=itrvts.get(0);
							}
							ITMRVAVO itmrVo = new ITMRVAVO();
							itmrVo.setItnbr((String)map.get("mater"));
							itmrVo.setHouse(stid.trim());
							itmrVo.setItrv(itrvt.trim());
							List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
							if(itmrLists!=null && itmrLists.size()>0){
								temp.setBlcf(itmrLists.get(0).getBlcf());
								temp.setUnmsr(itmrLists.get(0).getUnmsr());
							}
							temp.setFrwhs((String)map.get("from_warehouse"));
							temp.setFrsub((String)map.get("from_shard"));
							temp.setFrloc((String)map.get("from_location"));
							//							temp.setPlnqt(BigDecimal.valueOf((Double)map.get("quantity")));
							temp.setPlnqt(BigDecimal.valueOf(Double.valueOf(map.get("quantity")!=null?(map.get("quantity").toString()):"0")));
							temp.setTowhs((String)map.get("target_warehouse"));
							temp.setTosub((String)map.get("target_shard"));
							temp.setToloc((String)map.get("target_location"));
							temp.setLstat("10");
							temp.setLprt("0");
							temp.setTwus2("");
							temp.setTwdp2("");
							temp.setFinsp("0");
							temp.setActqt(BigDecimal.valueOf(Double.valueOf(map.get("quantity")!=null?(map.get("quantity").toString()):"0")));
							temp.setTwdt2(dbnow);
							temp.setTwtm2(BigDecimal.valueOf(Long.valueOf(now2)));
							temp2.setActbh((String)map.get("branch"));
							temp2.setFrwhs((String)map.get("from_warehouse"));
							temp2.setFrsub((String)map.get("from_shard"));
							temp2.setFrloc((String)map.get("from_location"));
							temp2.setTowhs((String)map.get("target_warehouse"));
							temp2.setTosub((String)map.get("target_shard"));
							temp2.setToloc((String)map.get("target_location"));
							temp2.setActbh((String)map.get("branch"));
							//							temp2.setActqt(BigDecimal.valueOf((Double)map.get("quantity")));
							temp2.setActqt(BigDecimal.valueOf(Double.valueOf(map.get("quantity")!=null?(map.get("quantity").toString()):"0")));
							itemList2.add(temp2);
							temp.setItemList(itemList2);
							itemList.add(temp);

						}
						vo.setItemList(itemList);
						this.ztwhdrService.insertZtwhdr(vo);
						//调SYSTEMLINK更新，然后更新状态
						String now3 = Utils.formateDate(null, "yyyyMMdd");
						//						ubchvo.setTowhs(target_warehouse);
						//						ubchvo.setTosub(target_shard);
						//						ubchvo.setToloc(target_location);
						if(itemList!=null && itemList.size()>0){
							for(int k=0;k<itemList.size();k++){
								ZTWDTLVO temp = itemList.get(k);
								Map map0 = new HashMap();
								map0.put("warehouse", temp.getTowhs());
								map0.put("location", temp.getToloc());
								map0.put("stid", stid);
								List<SLDATAVO> sldatas = this.xadataService.querySldata(map0);
								if(sldatas==null || sldatas.size()<1){
									jo.put("code", 5);
									jo.put("desc", "目标库位不存在");
									data=jo.toString();
									return "todata";
								}
								ZTWDTLVO pvo = new ZTWDTLVO();
								//								pvo.setTwdno(this.requisition);
								//								pvo.setTwdln(BigDecimal.valueOf(Integer.valueOf(this.requisition_line)));
								//								List<ZTWDTLVO> items = this.ztwhdrService.queryZtwdtl(vo);
								//								ZTWDTLVO item = items.get(0);
								//调拨数量是否小于来源库位(From Location)的实际库存数量
								Map map = new HashMap();
								map.put("warehouse", temp.getFrwhs());
								map.put("shard", temp.getFrsub());
								map.put("stid", stid);

								map.put("location", temp.getFrloc());

								//								if(this.mate!=null && !mate.trim().equals("")){
								map.put("itnbr", temp.getItnbr());
								//								}
								//									ZBMSU01VO suvo = new ZBMSU01VO();
								//									suvo.setBmsusr(username);
								//									suvo.setDlft("1");
								//									List<ZBMSU01VO>  suvos = this.zbmsu01Service.queryZbmsu(suvo);
								//如果用户选择更新 项目仓库默认子库和库位, 调用SystemLink执行更新

								List<SLQNTYVO> results = this.xadataService.querySlqnty(map);
								if(results!=null && results.size()>0){
									SLQNTYVO result = results.get(0);
									if(result.getLqnty().add(temp.getActqt().negate()).floatValue()>=0.0){
										Map xamap = new HashMap();
										xamap.put("sluserId", this.getSession().getServletContext().getAttribute("sluserId"));
										xamap.put("slpassword", this.getSession().getServletContext().getAttribute("slpassword"));
										xamap.put("slurl", this.getSession().getServletContext().getAttribute("slurl"));
										xamap.put("site", stid);


										//										if(suvos!=null && suvos.size()>0){
										xamap.put("fromWarehouse", temp.getFrwhs().trim());
										//										}else{
										//											xamap.put("fromWarehouse", "");
										//										}
										//										ZTWBCHVO pvo = new ZTWBCHVO();
										//										pvo.setTwdno(this.requisition);
										//										pvo.setTwdln(BigDecimal.valueOf(Integer.valueOf(this.requisition_line)));
										//										pvo.setTwdbn(BigDecimal.valueOf(1));

										List<ZTWBCHVO> bchvo = temp.getItemList();
										if(bchvo!=null && bchvo.size()>0){
											if(bchvo.get(0).getActbh()!=null && !bchvo.get(0).getActbh().trim().equals("") && !bchvo.get(0).getActbh().trim().equals("null")){
												xamap.put("batchlot", bchvo.get(0).getActbh().trim());
											}else{
												xamap.put("batchlot", "");
											}

										}else{
											xamap.put("batchlot", "");
										}
										xamap.put("item", temp.getItnbr().trim());
										xamap.put("postedDate", now3);
										xamap.put("scheduledReceipt", "false");
										xamap.put("postedTime", now2);
										xamap.put("token", "");
										xamap.put("fromLocation", temp.getFrloc().trim());
										xamap.put("toWarehouse", temp.getTowhs());
										xamap.put("toLocation", temp.getToloc());
										xamap.put("quantity", temp.getActqt());
										xamap.put("reference", temp.getTwdno().substring(temp.getTwdno().length()-10));
										ZBMSCTLVO bmsctlVO = new ZBMSCTLVO();
										bmsctlVO.setSite(stid);
										List<ZBMSCTLVO> bmsctlList = this.zbmsctlService.queryZbmsctl(bmsctlVO);
										if(bmsctlList!=null && bmsctlList.size()>0 && !bmsctlList.get(0).getTwrsn().trim().equals("")){
											xamap.put("reason", bmsctlList.get(0).getTwrsn().trim());
										}else{
											xamap.put("reason", "");
										}
										xamap.put("transactionDate", now3);
										xamap.put("inTransitOption", 1);
										xamap.put("inspectOnReceipt", 2);
										StringBuffer reqstr=null;
										String xaret0 = Utils.systemLinkTw(xamap);
										String xaret = (String)xamap.get("systemLinkStr");
										//										System.out.println("systemLinkStr:"+(String)xamap.get("systemLinkStr"));
										//										System.out.println("retStr:"+xaret);
										String errorStr1 = xaret.substring(xaret.indexOf("hasErrors"), xaret.indexOf("hasErrors")+17);
										String warnStr2 = xaret.substring(xaret.indexOf("hasWarnings"), xaret.indexOf("hasWarnings")+19);
										if(errorStr1.indexOf("true")>=0){
											jo.put("code", 6);
											jo.put("desc", "systemlink error:XA移库错误！");
											data=jo.toString();


											ZTWDTLVO udtlvo = new ZTWDTLVO();
											ZTWBCHVO ubchvo = new ZTWBCHVO();
											udtlvo.setTwdno(temp.getTwdno());
											udtlvo.setTwdln(temp.getTwdln());
											udtlvo.setLstat("60");
											udtlvo.setTwus2(username);
											udtlvo.setTwdt2(dbnow);
											udtlvo.setTwtm2(BigDecimal.valueOf(Long.valueOf(now2)));
											udtlvo.setTwdp2(userDept);
											udtlvo.setTwdp2(userDept);
											ubchvo.setTwdno(temp.getTwdno());
											ubchvo.setTwdln(temp.getTwdln());
											ubchvo.setTwdbn(BigDecimal.valueOf(1));
											ubchvo.setTowhs(temp.getTowhs());
											ubchvo.setTosub(temp.getTosub());
											ubchvo.setToloc(temp.getToloc());
											ubchvo.setActqt(BigDecimal.valueOf(Double.valueOf(0)));
											Map pmap = new HashMap();
											//											pmap.put("ztwhdr", uhdrvo);
											pmap.put("ztwdtl", udtlvo);
											pmap.put("ztwbch", ubchvo);
											this.ztwhdrService.updateZtwhdr(pmap);

											ZTWHDRVO uhdrvo = new ZTWHDRVO();
											uhdrvo.setTwdno(vo.getTwdno());
											uhdrvo.setOstat("60");
											this.ztwhdrService.updateHdrStat(uhdrvo);

											ZSLLOGVO sysliklog = new ZSLLOGVO();
											int count = this.zsllogService.getCoutsByDt(BigDecimal.valueOf(Long.valueOf("1"+now1)))+1;
											String index = "0000"+count;
											sysliklog.setSldno("SL"+now1+index.substring(index.length()-4));
											sysliklog.setAppl("A");
											sysliklog.setSltype("02");
											sysliklog.setDatyp("01");
											//											sysliklog.setSlreq(xaret0.replaceAll("'", "").replaceAll("'", "").replaceAll("\"", ""));
											//											sysliklog.setSlrsp(xaret.replaceAll("'", "").replaceAll("'", "").replaceAll("\"", ""));
											sysliklog.setSlreq("");
											sysliklog.setSlrsp("");
											sysliklog.setCrdpt(userDept);
											sysliklog.setCrusr(username);
											sysliklog.setCrdat(dbnow);
											sysliklog.setCrtme(BigDecimal.valueOf(Long.valueOf(now2)));
											sysliklog.setFprcs("0");
											sysliklog.setOsgrp("");
											sysliklog.setHouse(temp.getFrwhs());
											sysliklog.setItnbr(temp.getItnbr());
											sysliklog.setTrqty(temp.getActqt());
											sysliklog.setLlocn(temp.getFrloc());
											sysliklog.setNlloc(temp.getToloc());
											//											this.zsllogService.insertZsllog(sysliklog);


											return "todata";
										}

										ZTWDTLVO udtlvo = new ZTWDTLVO();
										ZTWBCHVO ubchvo = new ZTWBCHVO();

										udtlvo.setTwdno(temp.getTwdno());
										udtlvo.setTwdln(temp.getTwdln());
										udtlvo.setLstat("50");
										udtlvo.setTwus2(username);
										udtlvo.setTwdt2(dbnow);
										udtlvo.setTwtm2(BigDecimal.valueOf(Long.valueOf(now2)));
										udtlvo.setTwdp2(userDept);
										udtlvo.setTwdp2(userDept);
										ubchvo.setTwdno(temp.getTwdno());
										ubchvo.setTwdln(temp.getTwdln());
										ubchvo.setTwdbn(BigDecimal.valueOf(1));
										ubchvo.setTowhs(temp.getTowhs());
										ubchvo.setTosub(temp.getTosub());
										ubchvo.setToloc(temp.getToloc());
										ubchvo.setActqt(temp.getActqt());
										Map pmap = new HashMap();
										//										pmap.put("ztwhdr", uhdrvo);
										pmap.put("ztwdtl", udtlvo);
										pmap.put("ztwbch", ubchvo);
										this.ztwhdrService.updateZtwhdr(pmap);

									}else{
										jo.put("code", 6);
										jo.put("desc", "库存数量不足！");
										data=jo.toString();
										return "todata";
									}

								}else{
									jo.put("code", 5);
									jo.put("desc", "物料没有库存数据");
								}
							}							
						}
						ZTWHDRVO uhdrvo = new ZTWHDRVO();
						uhdrvo.setTwdno(vo.getTwdno());
						uhdrvo.setOstat("50");
						ZTWDTLVO tempvo = new ZTWDTLVO();
						tempvo.setTwdno(vo.getTwdno());
						//						tempvo.setTwdln(BigDecimal.valueOf(Integer.valueOf(this.requisition_line)));
						List<ZTWDTLVO> tempList = this.ztwhdrService.queryZtwdtl(tempvo);
						if(tempList==null || tempList.size()==0){
							this.ztwhdrService.updateHdrStat(uhdrvo);
						}
						jo.put("code", 1);
						jo.put("desc", "ok");		
					}


				}
				//				
				//				jo.put("code", "1");
				//				jo.put("desc", "ok");
			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String check_requisition_sure()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				String now1 = Utils.formateDate(null, "yyyyMMdd");
				String now2 = Utils.formateDate(null, "HHmmss");
				String now3 = Utils.formateDate(null, "yyMMdd");
				String userDept="";
				List<ZBMSU02VO> dps = this.auserService.queryDeptByUserName(username);
				if(dps!=null && dps.size()>0){
					for(int i=0;i<dps.size();i++){
						ZBMSU02VO dp = dps.get(i);
						if(dp.getDflt()!=null && "1".equals(dp.getDflt().trim())){
							//							vo.setPlant(dp.getPlant());
							userDept = (dp.getDept());
						}
					}
				} 
				//				ubchvo.setTowhs(target_warehouse);
				//				ubchvo.setTosub(target_shard);
				//				ubchvo.setToloc(target_location);
				Map map0 = new HashMap();
				map0.put("warehouse", target_warehouse);
				map0.put("shard", target_shard);
				map0.put("location", target_location);
				map0.put("stid", stid);
				List<SLDATAVO> sldatas = this.xadataService.querySldata(map0);
				if(sldatas==null || sldatas.size()<1){
					jo.put("code", 5);
					jo.put("desc", "目标子库和库位组合不匹配");
					data=jo.toString();
					return "todata";
				}
				ZTWDTLVO vo = new ZTWDTLVO();
				vo.setTwdno(this.requisition);
				vo.setTwdln(BigDecimal.valueOf(Integer.valueOf(this.requisition_line)));
				List<ZTWDTLVO> items = this.ztwhdrService.queryZtwdtl(vo);
				ZTWDTLVO item = items.get(0);
				//调拨数量是否小于来源库位(From Location)的实际库存数量
				Map map = new HashMap();
				map.put("warehouse", item.getFrwhs());
				map.put("shard", item.getFrsub());
				map.put("stid", stid);

				map.put("location", item.getFrloc());

				//				if(this.mate!=null && !mate.trim().equals("")){
				map.put("itnbr", item.getItnbr());
				//				}
				ZBMSU01VO suvo = new ZBMSU01VO();
				suvo.setBmsusr(username);
				suvo.setDlft("1");
				List<ZBMSU01VO>  suvos = this.zbmsu01Service.queryZbmsu(suvo);
				//如果用户选择更新 项目仓库默认子库和库位, 调用SystemLink执行更新
				if(this.update!=null && this.update.equals("1")){
					Map xamap0 = new HashMap();

					xamap0.put("sluserId", this.getSession().getServletContext().getAttribute("sluserId"));
					xamap0.put("slpassword", this.getSession().getServletContext().getAttribute("slpassword"));
					xamap0.put("slurl", this.getSession().getServletContext().getAttribute("slurl"));
					xamap0.put("site", stid);
					if(suvos!=null && suvos.size()>0){
						xamap0.put("warehouse", suvos.get(0).getHouse());
					}else{
						xamap0.put("warehouse", "");
					}
					xamap0.put("item", item.getItnbr());
					xamap0.put("whsub2", target_shard );
					xamap0.put("llocn2", target_location );
					Utils.systemLinkHouse(xamap0);
					String retStr = (String)xamap0.get("systemLinkStr");
					System.out.println("Tw:"+retStr);
					String errorStr1 = retStr.substring(retStr.indexOf("hasErrors"), retStr.indexOf("hasErrors")+17);
					String warnStr2 = retStr.substring(retStr.indexOf("hasWarnings"), retStr.indexOf("hasWarnings")+19);
					if(errorStr1.indexOf("true")>=0){
						jo.put("code", 6);
						jo.put("desc", "systemlink error:XA更新项目仓库默认子库和库位错误！");
						data=jo.toString();

						ZSLLOGVO sysliklog = new ZSLLOGVO();
						int count = this.zsllogService.getCoutsByDt(BigDecimal.valueOf(Long.valueOf("1"+now3)))+1;
						String index = "0000"+count;
						sysliklog.setSldno("SL"+now3+index.substring(index.length()-4));
						sysliklog.setAppl("A");
						sysliklog.setSltype("12");
						sysliklog.setDatyp("12");
						//							sysliklog.setSlreq((String)xamap0.get("systemLinkStr"));
						//							sysliklog.setSlrsp(retStr);
						sysliklog.setSlreq("");
						sysliklog.setSlrsp("");
						sysliklog.setCrdpt(userDept);
						sysliklog.setCrusr(username);
						sysliklog.setCrdat(BigDecimal.valueOf(Long.valueOf("1"+now3)));
						sysliklog.setCrtme(BigDecimal.valueOf(Long.valueOf(now2)));
						sysliklog.setFprcs("0");
						sysliklog.setHouse("");
						sysliklog.setItnbr("");
						sysliklog.setOsgrp("");
						sysliklog.setTrqty(BigDecimal.valueOf(0));
						sysliklog.setLlocn("");
						sysliklog.setNlloc("");
						//							this.zsllogService.insertZsllog(sysliklog);

						return "todata";
					}
				}
				List<SLQNTYVO> results = this.xadataService.querySlqnty(map);
				if(results!=null && results.size()>0){
					SLQNTYVO result = results.get(0);
					if(result.getLqnty().add(BigDecimal.valueOf(-Double.valueOf(actual_quantity))).floatValue()>0.0){
						Map xamap = new HashMap();
						xamap.put("sluserId", this.getSession().getServletContext().getAttribute("sluserId"));
						xamap.put("slpassword", this.getSession().getServletContext().getAttribute("slpassword"));
						xamap.put("slurl", this.getSession().getServletContext().getAttribute("slurl"));
						xamap.put("site", stid);


						if(suvos!=null && suvos.size()>0){
							xamap.put("fromWarehouse", suvos.get(0).getHouse().trim());
						}else{
							xamap.put("fromWarehouse", "");
						}
						ZTWBCHVO pvo = new ZTWBCHVO();
						pvo.setTwdno(this.requisition);
						pvo.setTwdln(BigDecimal.valueOf(Integer.valueOf(this.requisition_line)));
						pvo.setTwdbn(BigDecimal.valueOf(1));
						List<ZTWBCHVO> bchvo = this.ztwhdrService.queryZtwbch(pvo);
						if(bchvo!=null && bchvo.size()>0){
							if(bchvo.get(0).getActbh()!=null && !bchvo.get(0).getActbh().trim().equals("") && !bchvo.get(0).getActbh().trim().equals("null")){
								xamap.put("batchlot", bchvo.get(0).getActbh().trim());
							}else{
								xamap.put("batchlot", "");
							}

						}else{
							xamap.put("batchlot", "");
						}
						xamap.put("item", item.getItnbr().trim());
						xamap.put("postedDate", now1);
						xamap.put("scheduledReceipt", "false");
						xamap.put("postedTime", now2);
						xamap.put("token", "");
						xamap.put("fromLocation", item.getFrloc().trim());
						xamap.put("toWarehouse", this.target_warehouse);
						xamap.put("toLocation", this.target_location);
						xamap.put("quantity", this.actual_quantity);
						xamap.put("reference", this.requisition.substring(this.requisition.length()-10));
						ZBMSCTLVO bmsctlVO = new ZBMSCTLVO();
						bmsctlVO.setSite(stid);
						List<ZBMSCTLVO> bmsctlList = this.zbmsctlService.queryZbmsctl(bmsctlVO);
						if(bmsctlList!=null && bmsctlList.size()>0 && !bmsctlList.get(0).getTwrsn().trim().equals("")){
							xamap.put("reason", bmsctlList.get(0).getTwrsn().trim());
						}else{
							xamap.put("reason", "");
						}
						xamap.put("transactionDate", now1);
						xamap.put("inTransitOption", 1);
						xamap.put("inspectOnReceipt", 2);
						String xaret0 = Utils.systemLinkTw(xamap);
						String xaret = (String)xamap.get("systemLinkStr");
						System.out.println("Tw:"+xaret);
						String errorStr1 = xaret.substring(xaret.indexOf("hasErrors"), xaret.indexOf("hasErrors")+17);
						String warnStr2 = xaret.substring(xaret.indexOf("hasWarnings"), xaret.indexOf("hasWarnings")+19);
						if(errorStr1.indexOf("true")>=0){
							jo.put("code", 6);
							jo.put("desc", "systemlink error:XA移库错误！");
							data=jo.toString();

							ZSLLOGVO sysliklog = new ZSLLOGVO();
							int count = this.zsllogService.getCoutsByDt(BigDecimal.valueOf(Long.valueOf("1"+now3)))+1;
							String index = "0000"+count;
							sysliklog.setSldno("SL"+now3+index.substring(index.length()-4));
							sysliklog.setAppl("A");
							sysliklog.setSltype("02");
							sysliklog.setDatyp("01");
							//							sysliklog.setSlreq(xaret0);
							//							sysliklog.setSlrsp(xaret);
							sysliklog.setSlreq("");
							sysliklog.setSlrsp("");
							sysliklog.setCrdpt(userDept);
							sysliklog.setCrusr(username);
							sysliklog.setCrdat(BigDecimal.valueOf(Long.valueOf("1"+now3)));
							sysliklog.setCrtme(BigDecimal.valueOf(Long.valueOf(now2)));
							sysliklog.setFprcs("0");
							sysliklog.setOsgrp("");
							sysliklog.setHouse(item.getFrwhs());
							sysliklog.setItnbr(item.getItnbr());
							sysliklog.setTrqty(item.getActqt());
							sysliklog.setLlocn(item.getFrloc());
							sysliklog.setNlloc(item.getToloc());
							//							this.zsllogService.insertZsllog(sysliklog);

							return "todata";
						}
						ZTWHDRVO uhdrvo = new ZTWHDRVO();
						ZTWDTLVO udtlvo = new ZTWDTLVO();
						ZTWBCHVO ubchvo = new ZTWBCHVO();
						uhdrvo.setTwdno(this.requisition);
						uhdrvo.setOstat("50");
						udtlvo.setTwdno(this.requisition);
						udtlvo.setTwdln(BigDecimal.valueOf(Integer.valueOf(this.requisition_line)));
						udtlvo.setLstat("50");
						udtlvo.setTwus2(username);
						udtlvo.setTwdt2(BigDecimal.valueOf(Long.valueOf("1"+now3)));
						udtlvo.setTwtm2(BigDecimal.valueOf(Long.valueOf(now2)));
						udtlvo.setTwdp2("");
						//						List<ZBMSU02VO> dps = this.auserService.queryDeptByUserName(username);
						//						if(dps!=null && dps.size()>0){
						//							for(int i=0;i<dps.size();i++){
						//								ZBMSU02VO dp = dps.get(i);
						//								if(dp.getDflt()!=null && "1".equals(dp.getDflt().trim())){
						////									vo.setPlant(dp.getPlant());
						//									udtlvo.setTwdp2(dp.getDept());
						//								}
						//							}
						//						}
						udtlvo.setTwdp2(userDept);
						ubchvo.setTwdno(requisition);
						ubchvo.setTwdln(BigDecimal.valueOf(Integer.valueOf(this.requisition_line)));
						ubchvo.setTwdbn(BigDecimal.valueOf(1));
						ubchvo.setTowhs(target_warehouse);
						ubchvo.setTosub(target_shard);
						ubchvo.setToloc(target_location);
						ubchvo.setActqt(BigDecimal.valueOf(Double.valueOf(actual_quantity)));
						Map pmap = new HashMap();
						//						pmap.put("ztwhdr", uhdrvo);
						pmap.put("ztwdtl", udtlvo);
						pmap.put("ztwbch", ubchvo);
						this.ztwhdrService.updateZtwhdr(pmap);
						ZTWDTLVO tempvo = new ZTWDTLVO();
						tempvo.setTwdno(this.requisition);
						//						tempvo.setTwdln(BigDecimal.valueOf(Integer.valueOf(this.requisition_line)));
						List<ZTWDTLVO> tempList = this.ztwhdrService.queryZtwdtl(tempvo);
						if(tempList==null || tempList.size()==0){
							this.ztwhdrService.updateHdrStat(uhdrvo);
						}
					}else{
						jo.put("code", 6);
						jo.put("desc", "库存数量不足！");
						data=jo.toString();
						return "todata";
					}
					jo.put("code", 1);
					jo.put("desc", "ok");
				}else{
					jo.put("code", 5);
					jo.put("desc", "物料没有库存数据");
				}


			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String check_requisition_cancel()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				ZTWDTLVO udtlvo = new ZTWDTLVO();
				udtlvo.setTwdno(this.requisition);
				udtlvo.setTwdln(BigDecimal.valueOf(Integer.valueOf(this.requisition_line)));
				udtlvo.setLstat("60");
				this.ztwhdrService.updateItemStat(udtlvo);

				ZTWDTLVO tempvo = new ZTWDTLVO();
				tempvo.setTwdno(this.requisition);
				//				tempvo.setTwdln(BigDecimal.valueOf(Integer.valueOf(this.requisition_line)));
				List<ZTWDTLVO> tempList = this.ztwhdrService.queryZtwdtl(tempvo);
				if(tempList==null || tempList.size()==0){
					ZTWHDRVO uhdrvo = new ZTWHDRVO();
					uhdrvo.setTwdno(this.requisition);
					uhdrvo.setOstat("60");
					this.ztwhdrService.updateHdrStat(uhdrvo);
				}

				jo.put("code", 1);
				jo.put("desc", "ok");
			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}
	public String hair_mater_get_pick_list()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				ZIPHDRVO pvo = new ZIPHDRVO();
				pvo.setIpdno(pick_number);
				List<ZIPHDRVO> vos = this.ziphdrService.queryHdrs(pvo);
				if(vos!=null && vos.size()>0){
					ZIPHDRVO vo = vos.get(0);
					ZIPDTLVO pvo2 = new ZIPDTLVO();
					pvo2.setIpdno(pick_number);
					pvo2.setLstat("10");
					List<ZIPDTLVO> itemList = this.ziphdrService.queryItems(pvo2);

					jo.put("work_order", vo.getOrdno());
					jo.put("founder", vo.getIpus1());
					jo.put("department", vo.getIpdp1());
					//					
					String retDate = "";
					if(vo.getIpdt1()!=null){
						String d = vo.getIpdt1().add(BigDecimal.valueOf(19000000)).toString();

						retDate=d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" ";
						if(vo.getIptm1()!=null){
							String t = vo.getIptm1().toString();
							if(t.length()<6){
								t="0"+t;
							}
							retDate=retDate+t.substring(0, 2)+":"+t.substring(2, 4)+":"+t.substring(4, t.length());
						}

					}
					jo.put("date", retDate);
					jo.put("type", vo.getIptyp());
					jo.put("state", vo.getOstat());

					if(itemList!=null && itemList.size()>0){
						List<Map> results = new ArrayList<Map>();
						for(int i=0;i<itemList.size();i++){
							Map map = new HashMap();
							ZIPDTLVO temp = itemList.get(i);
							map.put("pick_line", temp.getIpdln());
							map.put("sequence", temp.getSeqnm());
							map.put("mater", temp.getCitem());
							map.put("quantity", temp.getShqty());
							map.put("unit", temp.getCuom());
							map.put("warehouse", temp.getHouse());
							map.put("shard", temp.getWhsub());
							map.put("location", temp.getLlocn());
							map.put("state", temp.getLstat());
							map.put("branched", temp.getBlcf());
							results.add(map);
						}
						jo.put("picking_list", results);
					}
					jo.put("code", 1);
					jo.put("desc", "ok");
				}else{
					jo.put("code", 5);
					jo.put("desc", "no results");
				}

			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String hair_mater_get_mater_list()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				ZIPDTLVO pvo2 = new ZIPDTLVO();
				pvo2.setIpdno(pick_number);
				pvo2.setIpdln(BigDecimal.valueOf(Integer.valueOf(pick_line)));
				pvo2.setLstat("10");
				List<ZIPDTLVO> itemList = this.ziphdrService.queryItems(pvo2);
				if(itemList!=null && itemList.size()>0){
					ZIPDTLVO vo = itemList.get(0);

					ZWHSUBVO subvo = new ZWHSUBVO();
					subvo.setHouse(warehouse);
					List<ZWHSUBVO> zwhsubList = this.zwhsubService.queryZwhsub(subvo);
					String defaultHouse ="";
					if(zwhsubList!=null && zwhsubList.size()>0){
						List<Map> lmap = new ArrayList<Map>();

						for(int i=0;i<zwhsubList.size();i++){
							ZWHSUBVO temp = zwhsubList.get(i);
							Map tm = new HashMap();
							tm.put("shard", temp.getWhsub());

							lmap.add(tm);
						}
						jo.put("shard_list", lmap);
					}

					ITMSITVO itmsitvo = new ITMSITVO();
					itmsitvo.setHouse(stid.trim());
					itmsitvo.setItnot9(vo.getCitem().trim());
					String itrvt = "";
					List<String> itrvts = this.xadataService.queryItrvt(itmsitvo);
					if(itrvts!=null && itrvts.size()>0){
						itrvt=itrvts.get(0);
					}
					ZITMEXTVO extVo = new ZITMEXTVO();
					extVo.setItnbr(vo.getCitem().trim().trim());
					extVo.setStid(stid.trim());
					extVo.setItrv(itrvt.trim());
					List<ZITMEXTVO> extLists = this.zitmextService.queryItemExt(extVo);
					String ldesc = "";
					if(extLists!=null && extLists.size()>0 && extLists.get(0).getLdesc().trim().length()>0){
						ldesc=extLists.get(0).getLdesc();
						jo.put("mater_dese", ldesc);
						jo.put("mater_format", extLists.get(0).getSdesc());
					}else{
						ITMRVAVO itmrVo = new ITMRVAVO();
						itmrVo.setItnbr(vo.getCitem().trim().trim());
						itmrVo.setHouse(stid.trim());
						itmrVo.setItrv(itrvt.trim());
						List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
						if(itmrLists!=null && itmrLists.size()>0){
							ldesc=itmrLists.get(0).getItdsc();
							jo.put("mater_desc", ldesc);
							jo.put("mater_format", "");
						}else{
							jo.put("mater_desc", "");
							jo.put("mater_format", "");
						}

					}

					Map map = new HashMap();
					map.put("warehouse", warehouse);
					map.put("stid", stid);
					map.put("shard", shard);
					map.put("location", location);
					map.put("lbhno", branch);
					map.put("itnbr", vo.getCitem().trim());
					List<SLQNTYVO> slqntyList = this.xadataService.querySlqnty(map);
					if(slqntyList!=null && slqntyList.size()>0){
						List<Map> slqntyrets = new ArrayList<Map>();
						for(int i=0;i<slqntyList.size();i++){
							SLQNTYVO tvo = slqntyList.get(i);
							Map rmap = new HashMap();
							rmap.put("branch", tvo.getLbhno());
							rmap.put("shard", tvo.getUucalm());
							rmap.put("location", tvo.getLlocn());
							rmap.put("quantity", tvo.getLqnty());
							rmap.put("unit", tvo.getUnpurum());
							rmap.put("fifo_date", tvo.getFdate());
							slqntyrets.add(rmap);
						}
						jo.put("mater_list", slqntyrets);
					}


					jo.put("code", 1);
					jo.put("desc", "ok");
				}else{
					jo.put("code", 5);
					jo.put("desc", "no results");
				}

			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String hair_mater_submit()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				String lib = Utils.getDataSourceS(dbconfigurl, "AMTLIB"+idx);
				String lib1 = Utils.getDataSourceS(dbconfigurl, "AMPHLIB"+idx);


				String now1 = Utils.formateDate(null, "yyyyMMdd");
				String now2 = Utils.formateDate(null, "HHmmss");
				String now3 = Utils.formateDate(null, "yyMMdd");


				ZIPDTLVO pvo2 = new ZIPDTLVO();
				pvo2.setIpdno(pick_number);
				pvo2.setIpdln(BigDecimal.valueOf(Integer.valueOf(pick_line)));
				pvo2.setLstat("10");
				List<ZIPDTLVO> itemList = this.ziphdrService.queryItems(pvo2);
				AUserVO au = this.auserService.queryUserByUserName(username);
				List<Map> lists = new ArrayList<Map>();
				Utils util = new Utils();
				ZIPHDRVO phdrvo = new ZIPHDRVO();
				phdrvo.setIpdno(pick_number);
				phdrvo.setOstat("50");
				ZIPDTLVO pdtlvo = new ZIPDTLVO();
				pdtlvo.setIpdno(pick_number);
				pdtlvo.setIpdln(BigDecimal.valueOf(Integer.valueOf(pick_line)));
				pdtlvo.setLstat("50");
				pdtlvo.setAcqty(BigDecimal.valueOf(Double.valueOf((actual_quantity==null || "".equals(actual_quantity.trim()))?"0":actual_quantity)));
				String userDept = "";
				//				String username = (String)this.getSession().getAttribute("username");
				List<ZBMSU02VO> dps = this.auserService.queryDeptByUserName(username);
				if(dps!=null && dps.size()>0){
					for(int i=0;i<dps.size();i++){
						ZBMSU02VO dp = dps.get(i);
						if(dp.getDflt()!=null && "1".equals(dp.getDflt().trim())){
							//							vo.setPlant(dp.getPlant());
							//							vo.setTwdp1(dp.getDept());
							userDept = dp.getDept();
						}
					}
				}
				List<ZIPHSTVO> subItemList = new ArrayList<ZIPHSTVO>();

				if(itemList!=null && itemList.size()>0){
					ZIPDTLVO vo = itemList.get(0);

					MOMASTVO tempvo = new MOMASTVO();
					tempvo.setOrdno(vo.getOrdno());
					List<MOMASTVO> results = this.xadataService.queryMomastByordno(tempvo);
					if(results!=null && results.size()>0){
						MOMASTVO result =results.get(0);
						if("10,40,50".indexOf(result.getOstat())<0){
							jo.put("code", 7);
							jo.put("desc", "该生产工单状态异常！");
							data=jo.toString();
							return "todata";
						}
					}else{
						jo.put("code", 5);
						jo.put("desc", "该生产工单不存在");
						data=jo.toString();
						return "todata";
					}

					if(this.mater_list!=null && this.mater_list.length()>0){
						JSONObject json = JSONObject.fromObject(this.mater_list);
						JSONArray jsonArr = JSONArray.fromObject(json.get("mater_list"));

						if(jsonArr!=null && jsonArr.size()>0){
							for(int j=0;j<jsonArr.size();j++){
								Map rmap = (Map)jsonArr.get(j);
								Map map = new HashMap();
								map.put("badge", au.getXsBda());
								map.put("hdept", vo.getDept());
								map.put("iploc", vo.getHouse());
								map.put("itnbr", vo.getCitem());
								map.put("lbhno", rmap.get("branch"));
								map.put("lloc", rmap.get("location"));
								map.put("ordno", vo.getOrdno());
								map.put("reasn", "");//TODO:需要根据类型从ZBMSRSN表中取值
								map.put("seqnm", vo.getSeqnm());
								map.put("tdate", BigDecimal.valueOf(Long.valueOf("1"+now3)));
								map.put("trqty", BigDecimal.valueOf(Double.valueOf(rmap.get("quantity")==null?"0":rmap.get("quantity").toString())));
								map.put("ttime", BigDecimal.valueOf(Long.valueOf(now2)));
								map.put("wsid", username);
								map.put("usrsq", vo.getUsrsq());
								map.put("turna", vo.getTurna());
								map.put("turnn", vo.getTurnn());
								map.put("turnc", vo.getTurnc());
								map.put("refno", vo.getIpdno().trim().substring(2,vo.getIpdno().trim().length()));

								ZIPHSTVO hvo = new ZIPHSTVO();
								hvo.setIpdno(pick_number);
								hvo.setIpdln(BigDecimal.valueOf(Long.valueOf(pick_line)));
								hvo.setIpddl(BigDecimal.valueOf(j+1));
								hvo.setOrdno(vo.getOrdno());
								hvo.setFitem(vo.getFitem());
								hvo.setDept(vo.getDept());
								hvo.setCitem(vo.getCitem());
								hvo.setCum(vo.getCuom());
								hvo.setHouse(vo.getHouse());
								hvo.setDlsub((String)rmap.get("shard"));
								hvo.setDlloc((String)rmap.get("location"));
								hvo.setDlqty(BigDecimal.valueOf(Double.valueOf(rmap.get("quantity")==null?"0":rmap.get("quantity").toString())));
								hvo.setDlbch((String)rmap.get("branch"));
								hvo.setIpus2(username);
								hvo.setIpdp2(userDept);
								hvo.setIpdt2(BigDecimal.valueOf(Long.valueOf("1"+now3)));
								hvo.setIptm2(BigDecimal.valueOf(Long.valueOf(now2)));
								subItemList.add(hvo);
								lists.add(map);
							}
							pdtlvo.setItemList(subItemList);
						}
					}

					if(lists!=null && lists.size()>0){
						boolean issuccuess = util.insertTrdata(lib,env, lists,lib1);
						if(issuccuess){
							Map map1 = new HashMap();
							map1.put("ZIPHDRVO", phdrvo);
							map1.put("ZIPDTLVO", pdtlvo);
							this.ziphdrService.updateZiphdr(map1);
							jo.put("code", 1);
							jo.put("desc", "ok");
						}else{throw new RuntimeException();}
					}else{throw new RuntimeException();}

				}else{throw new RuntimeException();}
			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String hair_mater_return_submit()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				String lib = Utils.getDataSourceS(dbconfigurl, "AMTLIB"+idx);
				String lib1 = Utils.getDataSourceS(dbconfigurl, "AMPHLIB"+idx);

				//*******

				String now1 = Utils.formateDate(null, "yyyyMMdd");
				String now2 = Utils.formateDate(null, "HHmmss");
				String now3 = Utils.formateDate(null, "yyMMdd");


				ZIPDTLVO pvo2 = new ZIPDTLVO();//根据传入的表身号,构建表身
				pvo2.setIpdno(pick_number);
				pvo2.setIpdln(BigDecimal.valueOf(Integer.valueOf(pick_line)));
				pvo2.setLstat("10");
				List<ZIPDTLVO> itemList = this.ziphdrService.queryItems(pvo2);//所有的表身信息集合
				AUserVO au = this.auserService.queryUserByUserName(username);
				List<Map> lists = new ArrayList<Map>();
				Utils util = new Utils();
				ZIPHDRVO phdrvo = new ZIPHDRVO();//根据传入的领料单号自定义出的表头,设置状态为已完成,这个表头最后进行更新
				phdrvo.setIpdno(pick_number);
				phdrvo.setOstat("50");
				ZIPDTLVO pdtlvo = new ZIPDTLVO(); //要提交更新的表身信息,把参数设置好
				pdtlvo.setIpdno(pick_number);
				pdtlvo.setIpdln(BigDecimal.valueOf(Integer.valueOf(pick_line)));
				pdtlvo.setLstat("50");
				pdtlvo.setAcqty(BigDecimal.valueOf(Double.valueOf((actual_quantity==null || "".equals(actual_quantity.trim()))?"0":actual_quantity)));
				String userDept = "";
				//				String username = (String)this.getSession().getAttribute("username");
				List<ZBMSU02VO> dps = this.auserService.queryDeptByUserName(username);
				if(dps!=null && dps.size()>0){
					for(int i=0;i<dps.size();i++){
						ZBMSU02VO dp = dps.get(i);
						if(dp.getDflt()!=null && "1".equals(dp.getDflt().trim())){
							//							vo.setPlant(dp.getPlant());
							//							vo.setTwdp1(dp.getDept());
							userDept = dp.getDept();
						}
					}
				}
				List<ZIPHSTVO> subItemList = new ArrayList<ZIPHSTVO>();//表身明细集合

				if(itemList!=null && itemList.size()>0){
					ZIPDTLVO vo = itemList.get(0);

					MOMASTVO tempvo = new MOMASTVO();
					tempvo.setOrdno(vo.getOrdno());
					List<MOMASTVO> results = this.xadataService.queryMomastByordno(tempvo);
					if(results!=null && results.size()>0){
						MOMASTVO result =results.get(0);
						if("10,40,50".indexOf(result.getOstat())<0){
							jo.put("code", 7);
							jo.put("desc", "该生产工单状态异常！");
							data=jo.toString();
							return "todata";
						}
					}else{
						jo.put("code", 5);
						jo.put("desc", "该生产工单不存在");
						data=jo.toString();
						return "todata";
					}

					if(this.branch_list!=null && this.branch_list.length()>0){
						JSONObject json = JSONObject.fromObject(this.branch_list);
						JSONArray jsonArr = JSONArray.fromObject(json.get("branch_list"));

						if(jsonArr!=null && jsonArr.size()>0){
							for(int j=0;j<jsonArr.size();j++){
								Map rmap = (Map)jsonArr.get(j);
								Map map = new HashMap();
								map.put("badge", au.getXsBda());
								map.put("hdept", vo.getDept());
								map.put("iploc", vo.getHouse());
								map.put("itnbr", vo.getCitem());
								map.put("lbhno", rmap.get("branch_number"));
								map.put("lloc", location);
								map.put("ordno", vo.getOrdno());
								map.put("reasn", "");//TODO:需要根据类型从ZBMSRSN表中取值
								map.put("seqnm", vo.getSeqnm());
								map.put("tdate", BigDecimal.valueOf(Long.valueOf("1"+now3)));
								map.put("trqty", BigDecimal.valueOf(Double.valueOf(rmap.get("branch_quantity")==null?"0":rmap.get("branch_quantity").toString())));
								map.put("ttime", BigDecimal.valueOf(Long.valueOf(now2)));
								map.put("wsid", username);
								map.put("usrsq", vo.getUsrsq());
								map.put("turna", vo.getTurna());
								map.put("turnn", vo.getTurnn());
								map.put("turnc", vo.getTurnc());

								ZIPHSTVO hvo = new ZIPHSTVO();
								hvo.setIpdno(pick_number);
								hvo.setIpdln(BigDecimal.valueOf(Long.valueOf(pick_line)));
								hvo.setIpddl(BigDecimal.valueOf(j+1));
								hvo.setOrdno(vo.getOrdno());
								hvo.setFitem(vo.getFitem());
								hvo.setDept(vo.getDept());
								hvo.setCitem(vo.getCitem());
								hvo.setCum(vo.getCuom());
								hvo.setHouse(vo.getHouse());
								hvo.setDlsub(shard);
								hvo.setDlloc(location);
								hvo.setDlqty(BigDecimal.valueOf(Double.valueOf(rmap.get("branch_quantity")==null?"0":rmap.get("branch_quantity").toString())));
								hvo.setDlbch((String)rmap.get("branch_number"));
								hvo.setIpus2(username);
								hvo.setIpdp2(userDept);
								hvo.setIpdt2(BigDecimal.valueOf(Long.valueOf("1"+now3)));
								hvo.setIptm2(BigDecimal.valueOf(Long.valueOf(now2)));
								subItemList.add(hvo);
								lists.add(map);
							}
							pdtlvo.setItemList(subItemList);
						}
					}else{
						Map map = new HashMap();
						map.put("badge", au.getXsBda());
						map.put("hdept", vo.getDept());
						map.put("iploc", vo.getHouse());
						map.put("itnbr", vo.getCitem());
						map.put("lbhno", "");
						map.put("lloc", location);
						map.put("ordno", vo.getOrdno());
						map.put("reasn", "");//TODO:需要根据类型从ZBMSRSN表中取值
						map.put("seqnm", vo.getSeqnm());
						map.put("tdate", BigDecimal.valueOf(Long.valueOf("1"+now3)));
						map.put("trqty", BigDecimal.valueOf(Double.valueOf(actual_quantity ==null?"0":actual_quantity )));
						map.put("ttime", BigDecimal.valueOf(Long.valueOf(now2)));
						map.put("wsid", username);
						map.put("usrsq", vo.getUsrsq());
						map.put("turna", vo.getTurna());
						map.put("turnn", vo.getTurnn());
						map.put("turnc", vo.getTurnc());
						map.put("refno", vo.getIpdno().trim().substring(2,vo.getIpdno().trim().length()));

						ZIPHSTVO hvo = new ZIPHSTVO();
						hvo.setIpdno(pick_number);
						hvo.setIpdln(BigDecimal.valueOf(Long.valueOf(pick_line)));
						hvo.setIpddl(BigDecimal.valueOf(1));
						hvo.setOrdno(vo.getOrdno());
						hvo.setFitem(vo.getFitem());
						hvo.setDept(vo.getDept());
						hvo.setCitem(vo.getCitem());
						hvo.setCum(vo.getCuom());
						hvo.setHouse(vo.getHouse());
						hvo.setDlsub(shard);
						hvo.setDlloc(location);
						hvo.setDlqty(BigDecimal.valueOf(Double.valueOf(Double.valueOf(actual_quantity ==null?"0":actual_quantity ))));
						hvo.setDlbch("");
						hvo.setIpus2(username);
						hvo.setIpdp2(userDept);
						hvo.setIpdt2(BigDecimal.valueOf(Long.valueOf("1"+now3)));
						hvo.setIptm2(BigDecimal.valueOf(Long.valueOf(now2)));
						subItemList.add(hvo);
						lists.add(map);
						pdtlvo.setItemList(subItemList);
					}

					boolean issuccuess = util.insertTrdata(lib,env, lists,lib1);
					if(issuccuess){
						Map map1 = new HashMap();
						map1.put("ZIPHDRVO", phdrvo);
						map1.put("ZIPDTLVO", pdtlvo);
						this.ziphdrService.updateZiphdr(map1);
						jo.put("code", 1);
						jo.put("desc", "ok");
					}else{
						jo.put("code", 4);
						jo.put("desc", "other exception");
					}
				}else{
					jo.put("code", 4);
					jo.put("desc", "other exception");
				}
			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}


	public String hair_mater_cancel()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				ZIPDTLVO vo = new ZIPDTLVO();
				vo.setIpdno(pick_number);
				vo.setIpdln(BigDecimal.valueOf(Long.valueOf(pick_line)));
				vo.setLstat("60");
				vo.setAcqty(BigDecimal.valueOf(0));
				this.ziphdrService.updateZipdtlStat(vo);

				ZIPDTLVO vo2 = new ZIPDTLVO();
				vo2.setIpdno(pick_number);
				vo2.setLstat("10");
				List<ZIPDTLVO> results = this.ziphdrService.queryItems(vo2);
				if(results==null || results.size()==0){
					ZIPHDRVO vo3= new ZIPHDRVO();
					vo3.setIpdno(pick_number);
					vo3.setOstat("60");
					this.ziphdrService.updateZiphdrStat(vo3);
				}

				jo.put("code", 1);
				jo.put("desc", "ok");
			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String production_storage_inquire()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				MOMASTVO pvo = new MOMASTVO();
				pvo.setOrdno(work_order);
				pvo.setFitwh(warehouse);
				List<MOMASTVO> results = this.xadataService.queryMomastBystate(pvo);
				if(results!=null && results.size()>0){
					MOMASTVO vo = results.get(0);
					jo.put("order_state", vo.getOstat());
					jo.put("product_desc", vo.getFdesc());
					jo.put("product", vo.getFitem());
					jo.put("quantity_order", vo.getMoqty());
					jo.put("quantity_storaged", vo.getQtyrc());

					ITMSITVO itmsitvo = new ITMSITVO();
					itmsitvo.setHouse(stid.trim());
					itmsitvo.setItnot9(vo.getFitem().trim());
					List<ITMSITVO> listS = this.xadataService.queryItrvtAll(itmsitvo);
					if(listS!=null && listS.size()>0){
						ITMSITVO tempvo = listS.get(0);

						jo.put("branched", tempvo.getBlcft9()==null?"":tempvo.getBlcft9());
						jo.put("unit", tempvo.getUmstt9()==null?"":tempvo.getUmstt9());
					}else{
						jo.put("branched", "");
						jo.put("unit", "");
					}
					ZITEMBXVO bxvo = new ZITEMBXVO();
					bxvo.setHouse(vo.getFitwh().trim());
					bxvo.setItnbr(vo.getFitem().trim());
					List<ZITEMBXVO> bxvos = this.zitmbxService.queryItemBx(bxvo);
					if(bxvos!=null && bxvos.size()>0){
						ZITEMBXVO zbxvo = bxvos.get(0);
						jo.put("shard", zbxvo.getWhsub2());
						jo.put("location", zbxvo.getLlocn2());
					}else{
						jo.put("shard", "");
						jo.put("location", "");
					}
					jo.put("code", 1);
					jo.put("desc", "ok");
				}else{
					jo.put("code", 5);
					jo.put("desc", "该生产工单不存在");
				}


			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String production_storage_submit()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				String now1 = Utils.formateDate(null, "yyyyMMdd");
				String now2 = Utils.formateDate(null, "HHmmss");
				String now3 = Utils.formateDate(null, "yyMMdd");

				String userDept = "";
				//				String username = (String)this.getSession().getAttribute("username");
				List<ZBMSU02VO> dps = this.auserService.queryDeptByUserName(username);
				if(dps!=null && dps.size()>0){
					for(int i=0;i<dps.size();i++){
						ZBMSU02VO dp = dps.get(i);
						if(dp.getDflt()!=null && "1".equals(dp.getDflt().trim())){
							userDept = dp.getDept();
						}
					}
				}

				MOMASTVO pvo = new MOMASTVO();
				pvo.setOrdno(work_order);
				pvo.setFitwh(warehouse);
				List<MOMASTVO> results = this.xadataService.queryMomastBystate(pvo);
				ZBMSCTLVO bmsctlVO = new ZBMSCTLVO();
				bmsctlVO.setSite(stid);
				List<ZBMSCTLVO> bmsctlList = this.zbmsctlService.queryZbmsctl(bmsctlVO);

				if(results!=null && results.size()>0){
					MOMASTVO vo = results.get(0);
					if("10, 40, 50".indexOf(vo.getOstat())>=0){
						double rax = 1;
						if(bmsctlList.size()>0){
							rax +=bmsctlList.get(0).getPrslmt().doubleValue()*0.01f;
						}
						if(vo.getMoqty().multiply(new BigDecimal(Double.valueOf(rax))).compareTo(vo.getQtyrc().add(new BigDecimal(Double.parseDouble(quantity))))<0){
							jo.put("code", 7);
							jo.put("desc", "入库数量超过上限");
							NumberFormat  numberFormat = NumberFormat.getNumberInstance();
							numberFormat.setMaximumFractionDigits(1);
							numberFormat.setGroupingUsed(false);
							numberFormat.setRoundingMode(RoundingMode.DOWN);
							jo.put("max_remain", numberFormat.format(vo.getMoqty().multiply(new BigDecimal(Double.valueOf(rax))).subtract(vo.getQtyrc()).doubleValue()));
							data=jo.toString();
							return "todata";
						}


						Map map0 = new HashMap();
						map0.put("warehouse", warehouse);
						map0.put("shard", shard);
						map0.put("location", location);
						map0.put("stid", stid);
						List<SLDATAVO> sldatas = this.xadataService.querySldata(map0);
						if(sldatas==null || sldatas.size()<1){
							jo.put("code", 5);
							jo.put("desc", "目标子库和库位组合不匹配");
							data=jo.toString();
							return "todata";
						}


						int count = this.zrmhstService.getCoutsByDt(BigDecimal.valueOf(Long.valueOf("1"+now3)))+1;
						String index = "0000"+count;
						ZRMHSTVO zrmhstvo = new ZRMHSTVO();
						zrmhstvo.setRmdno("RM"+now3+index.substring(index.length()-4));
						zrmhstvo.setHouse(warehouse);
						zrmhstvo.setOrdno(vo.getOrdno());
						zrmhstvo.setDept(vo.getDptno());
						zrmhstvo.setFitem(vo.getFitem());
						zrmhstvo.setRmsub(shard);
						zrmhstvo.setRmloc(location);
						zrmhstvo.setRmbch(branch==null?"":branch);
						zrmhstvo.setRmqty(BigDecimal.valueOf(Double.valueOf(quantity)));
						zrmhstvo.setFqcd("0");
						zrmhstvo.setRmusr(username);
						zrmhstvo.setRmdat(BigDecimal.valueOf(Long.valueOf("1"+now3)));
						zrmhstvo.setRmtme(BigDecimal.valueOf(Long.valueOf(now2)));
						zrmhstvo.setRmdpt(userDept);
						this.zrmhstService.insertZrmhst(zrmhstvo);
						Map map = new HashMap();
						map.put("sluserId", this.getSession().getServletContext().getAttribute("sluserId"));
						map.put("slpassword", this.getSession().getServletContext().getAttribute("slpassword"));
						map.put("slurl", this.getSession().getServletContext().getAttribute("slurl"));
						map.put("site", stid);
						map.put("item", vo.getFitem());
						map.put("warehouse", vo.getFitwh());
						map.put("order", vo.getOrdno());
						map.put("reference", zrmhstvo.getRmdno().substring(zrmhstvo.getRmdno().length()-10));
						map.put("location", location);
						map.put("batchLot", branch==null?"":branch);
						map.put("transactionDate", now1);

						if(bmsctlList!=null && bmsctlList.size()>0 && !bmsctlList.get(0).getRmrsn().trim().equals("")){
							map.put("reason", bmsctlList.get(0).getRmrsn().trim());
						}else{
							map.put("reason", "");
						}
						map.put("transactionQuantity", quantity);
						String xaVal = Utils.systemLinkRm(map);
						String retVal = (String)map.get("systemLinkStr");
						String errorStr1 = retVal.substring(retVal.indexOf("hasErrors"), retVal.indexOf("hasErrors")+17);
						String warnStr2 = retVal.substring(retVal.indexOf("hasWarnings"), retVal.indexOf("hasWarnings")+19);
						if(errorStr1.indexOf("true")>=0){
							jo.put("code", 6);
							jo.put("desc", "systemlink error:XA入库错误！");
							data=jo.toString();
							//删除ZRMHST刚插入的记录
							this.zrmhstService.deleteZrmhst(zrmhstvo.getRmdno());
							ZSLLOGVO sysliklog = new ZSLLOGVO();
							int countt = this.zsllogService.getCoutsByDt(BigDecimal.valueOf(Long.valueOf("1"+now3)))+1;
							String indext = "0000"+countt;
							sysliklog.setSldno("SL"+now3+indext.substring(indext.length()-4));
							sysliklog.setAppl("A");
							sysliklog.setSltype("04");
							sysliklog.setDatyp("01");
							//							sysliklog.setSlreq(xaret0);
							//							sysliklog.setSlrsp(xaret);
							sysliklog.setSlreq("");
							sysliklog.setSlrsp("");
							sysliklog.setCrdpt(userDept);
							sysliklog.setCrusr(username);
							sysliklog.setCrdat(BigDecimal.valueOf(Long.valueOf("1"+now3)));
							sysliklog.setCrtme(BigDecimal.valueOf(Long.valueOf(now2)));
							sysliklog.setFprcs("0");
							sysliklog.setOsgrp("");
							sysliklog.setHouse(warehouse);
							sysliklog.setItnbr(vo.getFitem());
							sysliklog.setTrqty(zrmhstvo.getRmqty());
							sysliklog.setLlocn(location);
							sysliklog.setNlloc("");
							this.zsllogService.insertZsllog(sysliklog);


							return "todata";
						}else{
							MOPORFVO fpvo = new MOPORFVO();
							fpvo.setMonr(vo.getOrdno());
							List<MOPORFVO> list = this.xadataService.queryMoporf(fpvo);
							if(list!=null && list.size()>0){
								Map parames = new HashMap();

								MOPORFVO ftvo = list.get(0);
								parames.put("sluserId", this.getSession().getServletContext().getAttribute("sluserId"));
								parames.put("slpassword", this.getSession().getServletContext().getAttribute("slpassword"));
								parames.put("slurl", this.getSession().getServletContext().getAttribute("slurl"));
								parames.put("site", stid);

								parames.put("scheduledReceiptToken", ftvo.getSctkji().trim());

								parames.put("grnInvoiceFlag","false");
								//								parames.put("batchLot", "");
								//								System.out.println("tempvo.getGrnno(): "+tempvo.getGrnno());
								//								parames.put("receivedToStockWarehouseLocation",this.location);
								parames.put("reference", "");

								//								parames.put("transactionDate",now1);
								//								parames.put("setScheduledReceiptStatus", "");

								parames.put("transactionDate",Utils.formateDate(null, "yyyyMMdd"));
								parames.put("receivedToStockFlag", "true");

								parames.put("goodsReceivedNote","");
								//parames.put("setScheduledReceiptStatus", hdrVo.getLgwno().trim());

								parames.put("receivedToStockQuantity",Float.valueOf(this.quantity==null?"0":quantity));
								if(bmsctlList!=null && bmsctlList.size()>0){
									parames.put("receivedToStockReason", bmsctlList.get(0).getRprsn().trim());
								}else{
									parames.put("receivedToStockReason", "");
								}

								Utils.systemLinkRpo(parames);
								String retVal1 = (String)map.get("systemLinkStr");
								String terrorStr1 = retVal1.substring(retVal1.indexOf("hasErrors"), retVal1.indexOf("hasErrors")+17);
								String twarnStr2 = retVal1.substring(retVal1.indexOf("hasWarnings"), retVal1.indexOf("hasWarnings")+19);
								//								if(terrorStr1.indexOf("true")>=0){
								//									jo.put("code", 6);
								//									jo.put("desc", "systemlink error:XA外协入库错误！");
								//									data=jo.toString();
								//									
								//									ZSLLOGVO sysliklog = new ZSLLOGVO();
								//									int countt = this.zsllogService.getCoutsByDt(BigDecimal.valueOf(Long.valueOf("1"+now3)))+1;
								//									String indext = "0000"+countt;
								//									sysliklog.setSldno("SL"+now3+indext.substring(indext.length()-4));
								//									sysliklog.setAppl("A");
								//									sysliklog.setSltype("02");
								//									sysliklog.setDatyp("01");
								////									sysliklog.setSlreq(xaret0);
								////									sysliklog.setSlrsp(xaret);
								//									sysliklog.setSlreq("");
								//									sysliklog.setSlrsp("");
								//									sysliklog.setCrdpt(userDept);
								//									sysliklog.setCrusr(username);
								//									sysliklog.setCrdat(BigDecimal.valueOf(Long.valueOf("1"+now3)));
								//									sysliklog.setCrtme(BigDecimal.valueOf(Long.valueOf(now2)));
								//									sysliklog.setFprcs("0");
								//									sysliklog.setOsgrp("");
								//									sysliklog.setHouse(warehouse);
								//									sysliklog.setItnbr(vo.getFitem());
								//									sysliklog.setTrqty(zrmhstvo.getRmqty());
								//									sysliklog.setLlocn(location);
								//									sysliklog.setNlloc("");
								//									this.zsllogService.insertZsllog(sysliklog);
								//									//TODO:删除ZRMHST刚插入的记录
								//									
								//									return "todata";
								//								}
							}
						}
						jo.put("code", 1);
						jo.put("desc", "ok");
					}else{
						jo.put("code", 5);
						jo.put("desc", "该生产工单不存在");
					}

				}else{
					jo.put("code", 6);
					jo.put("desc", "该生产工单不允许入库");
				}


			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String production_order_inquire()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				MOMASTVO pvo = new MOMASTVO();
				pvo.setOrdno(work_order);
				pvo.setFitwh(warehouse);
				List<MOMASTVO> results = this.xadataService.queryMomastBystate(pvo);
				if(results!=null && results.size()>0){
					MOMASTVO vo = results.get(0);
					ITMSITVO itmsitvo = new ITMSITVO();
					itmsitvo.setHouse(stid);
					itmsitvo.setItnot9(vo.getFitem());
					String itrvt = "";
					List<String> itrvts = this.xadataService.queryItrvt(itmsitvo);
					if(itrvts!=null && itrvts.size()>0){
						itrvt=itrvts.get(0);
					}
					ZITMEXTVO extVo = new ZITMEXTVO();
					extVo.setItnbr(vo.getFitem());
					extVo.setStid(stid);
					extVo.setItrv(itrvt);
					List<ZITMEXTVO> extLists = this.zitmextService.queryItemExt(extVo);
					String ldesc = "";
					if(extLists!=null && extLists.size()>0 && extLists.get(0).getLdesc().trim().length()>0){
						ldesc=extLists.get(0).getLdesc();
						jo.put("product_desc", ldesc);
						jo.put("product_form", extLists.get(0).getSdesc());
					}else{
						ITMRVAVO itmrVo = new ITMRVAVO();
						itmrVo.setItnbr(vo.getFitem());
						itmrVo.setHouse(stid);
						itmrVo.setItrv(itrvt);
						List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
						if(itmrLists!=null && itmrLists.size()>0){
							ldesc=itmrLists.get(0).getItdsc();
							jo.put("product_desc", ldesc);
							jo.put("product_form", "");
						}else{
							jo.put("product_desc", "");
							jo.put("product_form", "");
						}

					}

					jo.put("department", vo.getDptno());
					jo.put("order_state", vo.getOstat());
					jo.put("product_name", vo.getFitem());
					jo.put("product_desc", vo.getFdesc());
					jo.put("quantity_order_product", vo.getMoqty());
					jo.put("quantity_finished_product", vo.getQtyrc());
					jo.put("quantity_remain_product", vo.getMounqty());

					String retDate = "";
					if(vo.getSstdt()!=null){
						String d = vo.getSstdt().add(BigDecimal.valueOf(19000000)).toString();

						retDate=d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" ";
						if(vo.getSsttm()!=null){
							String t = vo.getSsttm().toString();
							while(t.length()<6){
								t="0"+t;
							}
							retDate=retDate+t.substring(0, 2)+":"+t.substring(2, 4)+":"+t.substring(4, t.length());
						}

					}

					jo.put("plain_start_date", retDate);

					if(vo.getOdudt()!=null){
						String d = vo.getOdudt().add(BigDecimal.valueOf(19000000)).toString();

						retDate=d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" ";
						if(vo.getOdutm()!=null){
							String t = vo.getOdutm().toString();
							while(t.length()<6){
								t="0"+t;
							}
							retDate=retDate+t.substring(0, 2)+":"+t.substring(2, 4)+":"+t.substring(4, t.length());
						}

					}

					jo.put("plain_finish_date", retDate);

					if(vo.getAstdt()!=null){
						String d = vo.getAstdt().add(BigDecimal.valueOf(19000000)).toString();

						retDate=d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" ";
						//						if(vo.getOdutm()!=null){
						String t = "0";
						while(t.length()<6){
							t="0"+t;
						}
						retDate=retDate+t.substring(0, 2)+":"+t.substring(2, 4)+":"+t.substring(4, t.length());
						//						}

					}

					jo.put("actual_start_date", retDate);

					if("1".equals(vo.getOrtp())){
						jo.put("sale_order_number", "CO"+vo.getOrdnc());
					}else if("4".equals(vo.getOrtp())){
						jo.put("sale_order_number", "CM"+vo.getOrdnc());
					}
					if(vo.getCono()!=null && vo.getCono().trim().length()>0){
						Map c6map = new HashMap();
						c6map.put("cono", vo.getCono());
						c6map.put("ortp", vo.getOrtp());
						c6map.put("ordnc", vo.getOrdnc());

						String customercode = xadataService.queryMBC6REP(c6map);
						jo.put("customer_code", customercode);
						Map cmap = new HashMap();
						cmap.put("c6bcanb", customercode.equals("")?0:Long.valueOf(customercode) );
						cmap.put("cono", vo.getCono());
						jo.put("customer_name", xadataService.queryCusnm(cmap));

						Map mbmap = new HashMap();
						mbmap.put("cono", vo.getCono());
						mbmap.put("ortp", vo.getOrtp());
						mbmap.put("ordnc", vo.getOrdnc());

						jo.put("customer_purchase_order_number", xadataService.queryBMCBTX(mbmap));

						Map mbcdmap = new HashMap();
						mbcdmap.put("cono", vo.getCono());
						mbcdmap.put("ortp", vo.getOrtp());
						mbcdmap.put("ordnc", vo.getOrdnc());
						mbcdmap.put("itmsq", vo.getItmsq());

						String qtys = xadataService.queryMBCDREP(mbcdmap);
						if(qtys!=null && qtys.trim().length()>0){
							String[] qty = qtys.split("-");
							jo.put("quantity_order_sale", qty[0]);
							jo.put("quantity_shipmented_sale", qty[1]);
							jo.put("quantity_remain_sale", Double.valueOf(qty[0])-Double.valueOf(qty[1]));

						}else{
							jo.put("quantity_order_sale", 0);
							jo.put("quantity_shipmented_sale", 0);
							jo.put("quantity_remain_sale", 0);
						}

						Map cpldmap = new HashMap();
						cpldmap.put("cono", vo.getCono());
						cpldmap.put("ortp", vo.getOrtp());
						cpldmap.put("ordnc", vo.getOrdnc());
						cpldmap.put("itmsq", vo.getItmsq());
						String dtemp = xadataService.queryMBADREP(cpldmap);

						if(dtemp!=null && dtemp.trim().length()>0){
							BigDecimal tep = BigDecimal.valueOf(Long.valueOf(dtemp));
							String d = tep.add(BigDecimal.valueOf(19000000)).toString();

							retDate=d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" ";

						}
						jo.put("compliance_date", retDate);
					}
					MODATAVO dpvo = new MODATAVO();
					dpvo.setOrdno(work_order);
					dpvo.setCitwh(vo.getFitwh());
					dpvo.setFitem(vo.getFitem());

					List<MODATAVO> dataList = this.xadataService.queryModatas(dpvo);
					if(dataList!=null && dataList.size()>0){
						List<Map> retList = new ArrayList<Map>();
						for(int i=0;i<dataList.size();i++){
							MODATAVO tdata = dataList.get(i);
							Map datam = new HashMap();
							datam.put("mater_number", tdata.getSeqnm());
							datam.put("mater_name", tdata.getCitem());
							datam.put("mater_desc", tdata.getCdesc());
							datam.put("mater_form", "");
							datam.put("plan_usage_amount", tdata.getQtreq());
							datam.put("actual_usage_amount", tdata.getIsqty());
							datam.put("mater_unit", tdata.getUnmsr());

							if(tdata.getListd()!=null){
								String d = tdata.getListd().add(BigDecimal.valueOf(19000000)).toString();

								retDate=d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" ";
								//								if(vo.getOdutm()!=null){
								String t = "0";
								while(t.length()<6){
									t="0"+t;
								}
								retDate=retDate+t.substring(0, 2)+":"+t.substring(2, 4)+":"+t.substring(4, t.length());
								//								}

							}
							datam.put("last_hair_mater_date", retDate);

							retList.add(datam);
						}
						jo.put("mater_list", retList);
					}
					Map outmap = new HashMap();
					outmap.put("ordno", work_order);
					List<MOROUTVO> outList = xadataService.queryMorout(outmap);
					if(outList!=null && outList.size()>0){
						List<Map> stepList = new ArrayList<Map>();
						for(int j=0;j<outList.size();j++){
							MOROUTVO outvo = outList.get(j);
							Map stepm = new HashMap();
							stepm.put("step_number", outvo.getOpseq());
							stepm.put("step_name", outvo.getOpdsc());
							stepm.put("actual_working_hours", outvo.getRlhtd());
							if(outvo.getTbcde()==null || outvo.getTbcde().trim().equals("")){
								stepm.put("standard_working_hours", vo.getMoqty().multiply(outvo.getSrlhu()));
							}else if(outvo.getTbcde().trim().equals("1")){
								stepm.put("standard_working_hours", vo.getMoqty().multiply(outvo.getSrlhu()).divide(BigDecimal.valueOf(10)));
							}else if(outvo.getTbcde().trim().equals("2")){
								stepm.put("standard_working_hours", vo.getMoqty().multiply(outvo.getSrlhu()).divide(BigDecimal.valueOf(100)));
							}else if(outvo.getTbcde().trim().equals("3")){
								stepm.put("standard_working_hours", vo.getMoqty().multiply(outvo.getSrlhu()).divide(BigDecimal.valueOf(1000)));
							}else if(outvo.getTbcde().trim().equals("4")){
								stepm.put("standard_working_hours", vo.getMoqty().multiply(outvo.getSrlhu()).divide(BigDecimal.valueOf(10000)));
							}else if(outvo.getTbcde().trim().equals("P")){
								stepm.put("standard_working_hours", vo.getMoqty().divide(outvo.getSrlhu()));
							}else if(outvo.getTbcde().trim().equals("M")){
								stepm.put("standard_working_hours", vo.getMoqty().multiply(outvo.getSrlhu()).divide(BigDecimal.valueOf(60)));
							}else if(outvo.getTbcde().trim().equals("C")){
								stepm.put("standard_working_hours", 0);
							}

							stepm.put("tbc", outvo.getTbcde());

							stepm.put("outsourcing_costs", "");
							stepm.put("outsourcing_supplier", "");
							stepm.put("outsourcing_purchase_order_number", "");

							stepList.add(stepm);
						}
						jo.put("step_list", stepList);
					}
					jo.put("code", 1);
					jo.put("desc", "ok");
				}else{
					jo.put("code", 5);
					jo.put("desc", "该生产工单不存在");
				}


			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}


	public String production_order_inquire_get_step_outsource_info()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				String lib = Utils.getDataSourceS(dbconfigurl, "AMTLIB"+idx);

				MOPORFVO pMoporfvo = new MOPORFVO();
				pMoporfvo.setMonr(work_order);
				pMoporfvo.setOpsq(step_number);
				List<MOPORFVO> list = this.xadataService.queryMoporf(pMoporfvo);
				if(list!=null && list.size()>0){
					Map parames = new HashMap();

					MOPORFVO ftvo = list.get(0);//步骤一获得的对象
					jo.put("outsourcing_purchase_order_number", ftvo.getPonr());
					String ponr = ftvo.getPonr();
					if(null!= ponr && ponr.indexOf("P") == 0 && ponr.length()>1){
						Map<String, String> map = new HashMap<String, String>();
						map.put("vndnr", ftvo.getVndr());
						List<VENNAMVO> vennamvos = this.xadataService.queryVennam(map);
						if(vennamvos != null && vennamvos.size()>0){
							VENNAMVO vennamvo = vennamvos.get(0);
							jo.put("outsourcing_supplier", vennamvo.getVn35());
						}

						Map<String, String> map2 = new HashMap<String, String>();
						map2.put("ordno", ftvo.getPonr());
						map2.put("house", ftvo.getWhid());
						map2.put("poisq", ftvo.getPisq()+"");
						map2.put("linsq", ftvo.getBksq()+"");
						List<POITEMVO> queryPoitem = this.xadataService.queryPoitem(map2);
						if(queryPoitem!=null && queryPoitem.size()>0){
							POITEMVO poitemvo = queryPoitem.get(0);
							jo.put("outsourcing_costs", poitemvo.getCurpr());
							jo.put("outsourcing_costs_unit", poitemvo.getCurid());
						}
					}

				}
				jo.put("code", 1);
				jo.put("desc", "ok");
			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}


	public String print_mater_label_inquire()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				ITMSITVO itmsitvo = new ITMSITVO();
				itmsitvo.setHouse(stid.trim());
				itmsitvo.setItnot9(mater.trim());
				String itrvt = "";
				List<ITMSITVO> itrvts = this.xadataService.queryItrvtAll(itmsitvo);
				if(itrvts!=null && itrvts.size()>0){
					ZITMEXTVO extVo = new ZITMEXTVO();
					ITMSITVO itmsitvot = itrvts.get(0);
					jo.put("storage_unit", itmsitvot.getUmstt9());//数量(单位)
					jo.put("branched", Integer.parseInt(itmsitvot.getBlcft9()));

					extVo.setItnbr(mater.trim());
					extVo.setStid(stid.trim());
					extVo.setItrv(itmsitvot.getItrvt9().trim());
					List<ZITMEXTVO> extLists = this.zitmextService.queryItemExt(extVo);
					String ldesc = "";
					ITMRVAVO itmrVo = new ITMRVAVO();
					itmrVo.setItnbr(mater.trim());
					itmrVo.setHouse(stid.trim());
					itmrVo.setItrv(itmsitvot.getItrvt9().trim());
					List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
					if(itmrLists!=null && itmrLists.size()>0){
						ITMRVAVO itmrvavo = itmrLists.get(0);
						jo.put("single", itmrvavo.getWeght());
						jo.put("single_unit", itmrvavo.getB2cqcd());
					}
					if(extLists!=null && extLists.size()>0 && extLists.get(0).getLdesc().trim().length()>0){
						ldesc=extLists.get(0).getLdesc();
						jo.put("mater_desc", ldesc);
						jo.put("mater_format", extLists.get(0).getSdesc());
					}else{

						if(itmrLists!=null && itmrLists.size()>0){
							ldesc=itmrLists.get(0).getItdsc();
							jo.put("mater_desc", ldesc);
							jo.put("mater_format", "");
						}else{
							jo.put("mater_desc", "");
							jo.put("mater_format", "");
						}

					}
				}

				jo.put("code", 1);
				jo.put("desc", "ok");
			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 4);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	/**
	 * 生产报工-新增作业-生产订单号查询
	 * @return
	 * @throws Exception
	 */
	public String production_report_add_new_job_work_order_inquire() throws Exception{
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				MOMASTVO momastvo=  new MOMASTVO();
				momastvo.setOrdno(work_order);
				List<MOMASTVO> momastList = xadataService.queryMomastByordno(momastvo);
				if(momastList.size() == 0){
					jo.put("code", 7);
					jo.put("desc", "该订单不存在");
				}else{
					Map<String, String> moroutMap = new HashMap<String, String>();
					moroutMap.put("ordno", work_order);
					List<MOROUTVO> moroutList = xadataService.queryMorout(moroutMap);//生产工序集合

					if(moroutList.size() == 0){
						jo.put("code", 5);
						jo.put("desc", "该订单不存在工序信息");
					}else{
						JSONArray stepListJsonArray = new JSONArray();
						for(MOROUTVO moroutvo:moroutList){
							JSONObject moroutJsonObject = new JSONObject();
							moroutJsonObject.put("step_number", moroutvo.getOpseq());
							moroutJsonObject.put("step_name", moroutvo.getOpdsc());
							stepListJsonArray.add(moroutJsonObject);
						}
						Map<String,String> map = new HashMap<String, String>();
						map.put("bmsusr", username);
						List<ZPLNMSTVO> zplnmstList = zplnmstService.queryZplnmst(map);//生产线集合
						if(zplnmstList.size() == 0){
							jo.put("code", 6);
							jo.put("desc", "不存在生产线");
						}else{
							JSONArray proprListJsonArray = new JSONArray();
							for(ZPLNMSTVO zplnmstvo:zplnmstList){
								JSONObject zplnmstJsonObject = new JSONObject();
								zplnmstJsonObject.put("propr_number", zplnmstvo.getPline());
								zplnmstJsonObject.put("propr_name", zplnmstvo.getPlnnm());
								proprListJsonArray.add(zplnmstJsonObject);
							}

							jo.put("step_list", stepListJsonArray.toString());
							jo.put("propr_list", proprListJsonArray.toString());
							jo.put("code", 1);
							jo.put("desc", "ok");
						}

					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			jo.put("code", 4);
			jo.put("desc", "other exception");
			data = jo.toString();
			log.error("get env error.",e);
			return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	/**
	 * 生产报工-新增作业-获取员工列表
	 * @return
	 * @throws Exception
	 */
	public String production_report_add_new_job_employee_inquire() throws Exception{
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				Map<String, String> map = new HashMap<String, String>();
				map.put("ordno", work_order);
				map.put("pline", propr_number);
				map.put("opseq", step_number);
				map.put("ostat", "20");
				List<ZMOJOBVO> zmojobList = zmojobService.queryZmojobByMap(map);
				if(zmojobList.size()!=0){
					jo.put("code", 5);
					jo.put("desc", "已创建了该类型的作业状态为10/20");
				}else{
					Map<String,String> map2 = new HashMap<String, String>();
					map2.put("pline", propr_number);
					map2.put("status", "1");
					map2.put("bmsusr", username);
					List<ZEMPMSTVO> zempmstList = zempmstService.queryZempmstByMapWithDept(map2);//员工集合
					JSONArray zempmstJsonArray = new JSONArray();
					for(ZEMPMSTVO zempmst:zempmstList){
						JSONObject zempmstJsonObject = new JSONObject();
						zempmstJsonObject.put("employee_number", zempmst.getEmpid());
						zempmstJsonObject.put("employee_name", zempmst.getEmpnm());
						zempmstJsonObject.put("employee_dept", zempmst.getDname());
						zempmstJsonArray.add(zempmstJsonObject);
					}
					jo.put("employee_list", zempmstJsonArray.toString());
					jo.put("code", 1);
					jo.put("desc", "OK");
				}

			}
		}catch (Exception e) {
			e.printStackTrace();
			jo.put("code", 4);
			jo.put("desc", "other exception");
			data = jo.toString();
			log.error("get env error.",e);
			return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	/**
	 * 生产报工-新增作业-获取设备列表
	 * @return
	 * @throws Exception
	 */
	public String production_report_add_new_job_machine_inquire() throws Exception{
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				Map<String, String> map = new HashMap<String, String>();
				map.put("ordno", work_order);
				map.put("pline", propr_number);
				map.put("opseq", step_number);
				map.put("ostat", "20");
				List<ZMOJOBVO> zmojobList = zmojobService.queryZmojobByMap(map);
				if(zmojobList.size()!=0){
					jo.put("code", 5);
					jo.put("desc", "已创建了该类型的作业状态为20");
				}else{
					Map<String,String> map2 = new HashMap<String, String>();
					map2.put("pline", propr_number);
					map2.put("status", "1");
					map2.put("bmsusr", username);
					List<ZMCHMSTVO> zmchmstList = zmchmstService.queryZmchmstByMapWithDept(map2);//设备集合
					JSONArray zmchmstJsonArray = new JSONArray();
					for(ZMCHMSTVO zmchmst:zmchmstList){
						JSONObject zmchmstJsonObject = new JSONObject();
						zmchmstJsonObject.put("machine_number", zmchmst.getMchid());
						zmchmstJsonObject.put("machine_name", zmchmst.getMchnm());
						zmchmstJsonObject.put("machine_dept", zmchmst.getDname());
						zmchmstJsonArray.add(zmchmstJsonObject);
					}
					jo.put("machine_list", zmchmstJsonArray.toString());
					jo.put("code", 1);
					jo.put("desc", "OK");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			jo.put("code", 4);
			jo.put("desc", "other exception");
			data = jo.toString();
			log.error("get env error.",e);
			return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	/**
	 * 生产报工-新增作业-提交
	 * @return
	 * @throws Exception
	 */
	public String production_report_add_new_job_submit() throws Exception{
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else if(begin_time==null || begin_time.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "begin_time is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				//查询当前的生产订单、工序、生产线是否创建了
				Map<String, String> zmojobParMap = new HashMap<String, String>();
				zmojobParMap.put("ordno", work_order);
				zmojobParMap.put("opseq", step_number);
				zmojobParMap.put("pline", propr_number);
				zmojobParMap.put("ostat", "20");
				List<ZMOJOBVO> zmojobList = zmojobService.queryZmojobByMap(zmojobParMap);
				if(zmojobList.size()!=0){
					jo.put("code", 5);
					jo.put("desc", "已添加了该订单+工序+生产线 的作业任务");
				}else{
					//查询出当前日期的最高序号
					SimpleDateFormat sf = new SimpleDateFormat("yyMMdd");
					String formedDate = sf.format(new Date());
					formedDate = "MJ"+formedDate;
					String newIndex = zmojobService.queryMaxIndex(formedDate).trim();
					if(newIndex.length() == 12){
						int currentIndex = Integer.parseInt(newIndex.substring(8))+1;
						newIndex = String.valueOf(currentIndex);
						for(int i =newIndex.length();i<4;i++){
							newIndex = "0"+newIndex;
						}
					}else{
						newIndex = "0001";
					}
					ZMOJOBVO zmojobvo = new ZMOJOBVO();
					zmojobvo.setMjdno("MJ"+sf.format(new Date())+newIndex);
					MOMASTVO momastvo = new MOMASTVO();
					momastvo.setOrdno(work_order);
					List<MOMASTVO> momastList = xadataService.queryMomastByordno(momastvo);
					if(momastList.size()>0){
						zmojobvo.setHouse(momastList.get(0).getFitwh());
						zmojobvo.setOrdno(momastList.get(0).getOrdno());
						zmojobvo.setOpseq(step_number);
						zmojobvo.setPline(propr_number);
						zmojobvo.setOstat("20");
						zmojobvo.setFcls("0");
						zmojobvo.setFitem(momastList.get(0).getFitem());
						zmojobvo.setDptno(momastList.get(0).getDptno());
						BigDecimal jstrdt=BigDecimal.valueOf(Long.valueOf("1"+begin_time.substring(2,4)+begin_time.substring(5,7)+begin_time.substring(8,10)) );
						zmojobvo.setJstrdt(jstrdt);
						BigDecimal jstrtm=BigDecimal.valueOf(Long.valueOf(begin_time.substring(11,13)+begin_time.substring(14,16)+begin_time.substring(17,19)) );
						zmojobvo.setJstrtm(jstrtm);
						//						zmojobvo.setJenddt(jstrdt);
						//						zmojobvo.setJendtm(jstrtm);
						zmojobvo.setCrus(username);
						String nowDay = Utils.formateDate(null, "yyMMdd");
						zmojobvo.setCrdt(BigDecimal.valueOf(Long.valueOf("1"+nowDay)));
						String nowTime = Utils.formateDate(null, "HHmmss");
						zmojobvo.setCrtm(BigDecimal.valueOf(Long.valueOf(nowTime)));

						List<ZJOBEMPVO> zjobempList = new ArrayList<ZJOBEMPVO>();
						JSONObject json = JSONObject.fromObject(this.employee_list);
						JSONArray employeeJsonArray = JSONArray.fromObject(json.get("employee_list"));
						for(int i =0;i<employeeJsonArray.size();i++){
							JSONObject zempmstJsonObject = employeeJsonArray.getJSONObject(i);
							ZJOBEMPVO zjobempvo = new ZJOBEMPVO();
							zjobempvo.setMjdno(zmojobvo.getMjdno());
							zjobempvo.setEmpid(zempmstJsonObject.optString("employee_number"));
							zjobempvo.setHouse(momastList.get(0).getFitwh());
							zjobempvo.setOrdno(momastList.get(0).getOrdno());
							zjobempvo.setOpseq(step_number);
							zjobempvo.setPline(propr_number);
							zjobempvo.setJstat("1");
							zjobempvo.setClhrs(new BigDecimal(0));
							zjobempList.add(zjobempvo);
						}

						List<ZJOBMCHVO> zjobmchList = new ArrayList<ZJOBMCHVO>();
						json = JSONObject.fromObject(this.machine_list);
						JSONArray machineJsonArray = JSONArray.fromObject(json.get("machine_list"));
						for(int i =0;i<machineJsonArray.size();i++){
							JSONObject zmchmstJsonObject = machineJsonArray.getJSONObject(i);
							ZJOBMCHVO zjobmchvo = new ZJOBMCHVO();
							zjobmchvo.setMjdno(zmojobvo.getMjdno());
							zjobmchvo.setMchid(zmchmstJsonObject.optString("machine_number"));
							zjobmchvo.setHouse(momastList.get(0).getFitwh());
							zjobmchvo.setOrdno(momastList.get(0).getOrdno());
							zjobmchvo.setOpseq(step_number);
							zjobmchvo.setPline(propr_number);
							zjobmchvo.setJstat("1");
							zjobmchvo.setCmhrs(new BigDecimal(0));
							zjobmchList.add(zjobmchvo);
						}
						zmojobService.addNewJob(zmojobvo, zjobempList, zjobmchList);
						jo.put("code", 1);
						jo.put("desc", "OK");
					}else{
						jo.put("code", 6);
						jo.put("desc", "生产订单不存在");
					}
				}

			}
		}catch (Throwable e) {
			e.printStackTrace();
			jo.put("code", 4);
			jo.put("desc", "other exception");
			data = jo.toString();
			log.error("get env error.",e);
			return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}


	/**
	 * 生产报工-获取作业列表
	 * @return
	 * @throws Exception
	 */
	public String production_report_get_job_list() throws Exception{
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				Map<String, String> zmojobParMap = new HashMap<String, String>();
				zmojobParMap.put("house", stid);
				zmojobParMap.put("crus", username);
				zmojobParMap.put("ostat", "20");
				List<ZMOJOBVO> zmojobList = zmojobService.queryZmojobByMap(zmojobParMap);
				JSONArray zmojobJsonArray = new JSONArray();
				for(ZMOJOBVO zmojobvo:zmojobList){
					JSONObject zmojobJsonObject = new JSONObject();
					zmojobJsonObject.put("job_number", zmojobvo.getMjdno());
					zmojobJsonObject.put("work_order", zmojobvo.getOrdno());

					Map<String, String> moroutParMap = new HashMap<String, String>();
					moroutParMap.put("ordno", zmojobvo.getOrdno());
					moroutParMap.put("opseq", zmojobvo.getOpseq());
					List<MOROUTVO> moroutList = xadataService.queryMorout(moroutParMap);
					if(moroutList.size()!=0){
						zmojobJsonObject.put("step_name", moroutList.get(0).getOpdsc());
						zmojobJsonObject.put("step_number", moroutList.get(0).getOpseq());
					}
					Map<String, String> zplnmstParMap = new HashMap();
					zplnmstParMap.put("plant", warehouse);
					zplnmstParMap.put("pline", zmojobvo.getPline());
					List<ZPLNMSTVO> zplnmstList = zplnmstService.queryZplnmstByMap(zplnmstParMap);
					if(zplnmstList.size()!=0){
						zmojobJsonObject.put("proper_name", zplnmstList.get(0).getPlnnm());
						zmojobJsonObject.put("proper_number", zplnmstList.get(0).getPline());
					}
					zmojobJsonArray.add(zmojobJsonObject);
				}
				jo.put("job_list", zmojobJsonArray.toString());
				jo.put("code", 1);
				jo.put("desc", "OK");
			}
		}catch (Throwable e) {
			e.printStackTrace();
			jo.put("code", 4);
			jo.put("desc", "other exception");
			data = jo.toString();
			log.error("get env error.",e);
			return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	/**
	 * 生产报工-获取作业详细
	 * @return
	 * @throws Exception
	 */
	public String production_report_get_job_detail() throws Exception{
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else if(job_number==null || job_number.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "job_number is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				Map<String, String> zmojobParMap = new HashMap<String, String>();
				zmojobParMap.put("mjdno", job_number);
				zmojobParMap.put("ostat", "20");
				List<ZMOJOBVO> zmojobList = zmojobService.queryZmojobByMap(zmojobParMap);
				if(zmojobList.size() == 0){
					jo.put("code", 5);
					jo.put("desc", "作业不存在");
				}else{
					ZMOJOBVO zmojobvo = zmojobList.get(0);
					jo.put("work_order", zmojobvo.getOrdno());

					Map<String, String> zdeptParMap = new HashMap<String, String>();

					List<ZBMSU02VO> dps = this.auserService.queryDeptByUserName(username);
					if(dps!=null && dps.size()>0){
						zdeptParMap.put("plant",String.valueOf(dps.get(0).getPlant()));
					}

					//					原方案,ZDEPT.DEPT 关联查询出ZDEPT.DNAME
					/*zdeptParMap.put("dept", zmojobvo.getDptno());
					List<ZDEPTVO> zdeptList = zdeptService.queryZdeptByMap(zdeptParMap);
					if(zdeptList.size()>0){
						jo.put("department", zdeptList.get(0).getDname());
					}*/
					jo.put("department", zmojobvo.getDptno());

					String createDate = "";
					if(zmojobvo.getCrdt()!=null){
						String d = zmojobvo.getCrdt().add(BigDecimal.valueOf(19000000)).toString();
						createDate=d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" ";
						if(zmojobvo.getCrtm()!=null){
							String t = zmojobvo.getCrtm().toString();
							if(t.length()<6){
								t="0"+t;
							}
							createDate=createDate+t.substring(0, 2)+":"+t.substring(2, 4)+":"+t.substring(4, t.length());
						}
					}
					jo.put("create_time", createDate);

					Map<String, String> zjobempParMap = new HashMap<String, String>();
					zjobempParMap.put("mjdno", zmojobvo.getMjdno());
					zjobempParMap.put("jstat", "1");
					List<ZJOBEMPVO> zjobempList = zjobempService.queryByMapWithEmpName(zjobempParMap);
					JSONArray zjobempJsonArray = new JSONArray();
					for(ZJOBEMPVO zjobempvo : zjobempList){
						JSONObject zjobempJsonObject = new JSONObject();
						zjobempJsonObject.put("employee_number", zjobempvo.getEmpid());
						zjobempJsonObject.put("employee_name", zjobempvo.getEmpName());

						Map<String,String> zjbtrnParMap = new HashMap<String, String>();
						zjbtrnParMap.put("mjdno", zmojobvo.getMjdno());
						zjbtrnParMap.put("ordno", zmojobvo.getOrdno());
						zjbtrnParMap.put("opseq", zmojobvo.getOpseq());
						zjbtrnParMap.put("pline", zmojobvo.getPline());
						zjbtrnParMap.put("empid", zjobempvo.getEmpid());
						zjbtrnParMap.put("jttyp", "L");
						zjbtrnParMap.put("jstat", "20");
						List<ZJBTRNVO> zjbtrnList = zjbtrnService.queryZjbtrnByMap(zjbtrnParMap);
						if(zjbtrnList.size()>0){
							ZJBTRNVO zjbtrnvo = zjbtrnList.get(0);
							String begin_time = "";
							if(zjbtrnvo.getJtsdt()!=null){
								String d = zjbtrnvo.getJtsdt().add(BigDecimal.valueOf(19000000)).toString();
								begin_time=d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" ";
								if(zjbtrnvo.getJtstm()!=null){
									String t = zjbtrnvo.getJtstm().toString();
									if(t.length()<6){
										t="0"+t;
									}
									begin_time=begin_time+t.substring(0, 2)+":"+t.substring(2, 4)+":"+t.substring(4, t.length());
								}
							}
							zjobempJsonObject.put("begin_time", begin_time);
						}
						zjobempJsonArray.add(zjobempJsonObject);
					}
					jo.put("employee_list", zjobempJsonArray.toString());

					Map<String, String> zjobmchParMap = new HashMap<String, String>();
					zjobmchParMap.put("mjdno", zmojobvo.getMjdno());
					zjobmchParMap.put("jstat", "1");
					List<ZJOBMCHVO> zjobmchList = zjobmchService.queryByMapWithEmpName(zjobmchParMap);
					JSONArray zjobmchJsonArray = new JSONArray();
					for(ZJOBMCHVO zjobmchvo : zjobmchList){
						JSONObject zjobmchJsonObject = new JSONObject();
						zjobmchJsonObject.put("machine_number", zjobmchvo.getMchid());
						zjobmchJsonObject.put("machine_name", zjobmchvo.getMchName());

						Map<String,String> zjbtrnParMap = new HashMap<String, String>();
						zjbtrnParMap.put("mjdno", zmojobvo.getMjdno());
						zjbtrnParMap.put("ordno", zmojobvo.getOrdno());
						zjbtrnParMap.put("opseq", zmojobvo.getOpseq());
						zjbtrnParMap.put("pline", zmojobvo.getPline());
						zjbtrnParMap.put("mchid", zjobmchvo.getMchid());
						zjbtrnParMap.put("jttyp", "M");
						zjbtrnParMap.put("jstat", "20");
						List<ZJBTRNVO> zjbtrnList = zjbtrnService.queryZjbtrnByMap(zjbtrnParMap);
						if(zjbtrnList.size()>0){
							ZJBTRNVO zjbtrnvo = zjbtrnList.get(0);
							String begin_time = "";
							if(zjbtrnvo.getJtsdt()!=null){
								String d = zjbtrnvo.getJtsdt().add(BigDecimal.valueOf(19000000)).toString();
								begin_time=d.substring(0, 4)+"-"+d.substring(4, 6)+"-"+d.substring(6, 8)+" ";
								if(zjbtrnvo.getJtstm()!=null){
									String t = zjbtrnvo.getJtstm().toString();
									if(t.length()<6){
										t="0"+t;
									}
									begin_time=begin_time+t.substring(0, 2)+":"+t.substring(2, 4)+":"+t.substring(4, t.length());
								}
							}
							zjobmchJsonObject.put("begin_time", begin_time);
						}
						zjobmchJsonArray.add(zjobmchJsonObject);
					}
					jo.put("machine_list", zjobmchJsonArray.toString());
					jo.put("code", 1);
					jo.put("desc", "OK");
				}
			}
		}catch (Throwable e) {
			e.printStackTrace();
			jo.put("code", 4);
			jo.put("desc", "other exception");
			data = jo.toString();
			log.error("get env error.",e);
			return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	/**
	 * 生产报工-查询员工信息
	 * @return
	 * @throws Exception
	 */
	public String production_report_employee_inquire() throws Exception{
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else if(job_number==null || job_number.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "job_number is needed");
			}else if(propr_number==null || propr_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "propr_number is needed");
			}else if(step_number==null || step_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "step_number is needed");
			}else if(employee_number==null || employee_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "employee_number is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				//看查询的员工是否在生产线上
				Map<String,String> map2 = new HashMap<String, String>();
				map2.put("pline", propr_number);
				map2.put("status", "1");
				map2.put("bmsusr", username);
				map2.put("empid", employee_number);
				List<ZEMPMSTVO> zempmstList = zempmstService.queryZempmstByMapWithDept(map2);//员工集合
				if(zempmstList.size()>0){
					ZEMPMSTVO zempmstvo = zempmstList.get(0);
					if(zempmstvo.getPline().trim().equals(propr_number)){
						//判断当前的空闲状态
						boolean isFree = true;
						Map<String,String> zjobempParMap = new HashMap<String, String>();
						zjobempParMap.put("mjdno", job_number);
						zjobempParMap.put("empid", employee_number);
						List<ZJOBEMPVO> zjobempList = zjobempService.queryByMapWithEmpName(zjobempParMap);
						if(zjobempList.size()>0){
							ZJOBEMPVO zjobempvo = zjobempList.get(0);
							if(zjobempvo.getJstat().trim().equals("1")){
								isFree = false;
							}else{
								isFree = true;	
							}
						}else{//还没有加入到jobemp中,是空闲的
							isFree = true;
						}

						jo.put("code", 1);
						jo.put("name", zempmstvo.getEmpnm());
						jo.put("state", isFree?0:1);
						jo.put("department", zempmstvo.getDname());
					}else{
						jo.put("code", 6);
						jo.put("desc", "该员工不在当前作业可支配范围");
					}
				}else{
					jo.put("code", 5);
					jo.put("desc", "无该员工信息");
				}
			}
		}catch (Throwable e) {
			e.printStackTrace();
			jo.put("code", 4);
			jo.put("desc", "other exception");
			data = jo.toString();
			log.error("get env error.",e);
			return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	/**
	 * 生产报工-查询设备信息
	 * @return
	 * @throws Exception
	 */
	public String production_report_machine_inquire() throws Exception{
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else if(job_number==null || job_number.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "job_number is needed");
			}else if(propr_number==null || propr_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "propr_number is needed");
			}else if(step_number==null || step_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "step_number is needed");
			}else if(machine_number==null || machine_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "machine_number is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				//看查询的设备是否在生产线上
				Map<String,String> map2 = new HashMap<String, String>();
				map2.put("pline", propr_number);
				map2.put("status", "1");
				map2.put("bmsusr", username);
				map2.put("mchid", machine_number);
				List<ZMCHMSTVO> zmchmstList = zmchmstService.queryZmchmstByMapWithDept(map2);//设备集合
				if(zmchmstList.size()>0){
					ZMCHMSTVO zmchmstvo = zmchmstList.get(0);
					if(zmchmstvo.getPline().trim().equals(propr_number)){
						//判断当前的空闲状态
						boolean isFree = true;
						Map<String,String> zjobmchParMap = new HashMap<String, String>();
						zjobmchParMap.put("mjdno", job_number);
						zjobmchParMap.put("mchid", machine_number);
						List<ZJOBMCHVO> zjobmchList = zjobmchService.queryByMapWithEmpName(zjobmchParMap);
						if(zjobmchList.size()>0){
							ZJOBMCHVO zjobmchvo = zjobmchList.get(0);
							if(zjobmchvo.getJstat().trim().equals("1")){
								isFree = false;
							}else{
								isFree = true;	
							}
						}else{//还没有加入到jobemp中,是空闲的
							isFree = true;
						}

						jo.put("code", 1);
						jo.put("name", zmchmstvo.getMchnm());
						jo.put("state", isFree?0:1);
						jo.put("department", zmchmstvo.getDname());
					}else{
						jo.put("code", 6);
						jo.put("desc", "该设备不在当前作业可支配范围");
					}
				}else{
					jo.put("code", 5);
					jo.put("desc", "无该设备信息");
				}
			}
		}catch (Throwable e) {
			e.printStackTrace();
			jo.put("code", 4);
			jo.put("desc", "other exception");
			data = jo.toString();
			log.error("get env error.",e);
			return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	/**
	 * 生产报工-中途加入员工
	 * @return
	 * @throws Exception
	 */
	public String production_report_employee_add() throws Exception{
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else if(job_number==null || job_number.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "job_number is needed");
			}else if(propr_number==null || propr_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "propr_number is needed");
			}else if(step_number==null || step_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "step_number is needed");
			}else if(employee_number==null || employee_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "employee_number is needed");
			}else if(warehouse==null || warehouse.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "warehouse is needed");
			}else if(work_order==null || work_order.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "work_order is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				//看查询的员工是否在生产线上
				Map<String,String> map2 = new HashMap<String, String>();
				map2.put("pline", propr_number);
				map2.put("status", "1");
				map2.put("bmsusr", username);
				map2.put("empid", employee_number);
				List<ZEMPMSTVO> zempmstList = zempmstService.queryZempmstByMapWithDept(map2);//员工集合
				if(zempmstList.size()>0){
					ZEMPMSTVO zempmstvo = zempmstList.get(0);
					if(zempmstvo.getPline().trim().equals(propr_number)){
						//判断当前的空闲状态
						boolean isFree = true;
						Map<String,String> zjobempParMap = new HashMap<String, String>();
						zjobempParMap.put("mjdno", job_number);
						zjobempParMap.put("empid", employee_number);
						List<ZJOBEMPVO> zjobempList = zjobempService.queryByMapWithEmpName(zjobempParMap);
						if(zjobempList.size()>0){
							ZJOBEMPVO zjobempvo = zjobempList.get(0);
							if(zjobempvo.getJstat().trim().equals("1")){
								isFree = false;
							}else{
								isFree = true;	
							}
						}else{//还没有加入到jobemp中,是空闲的
							isFree = true;
						}
						if(isFree){
							if(zjobempList.size()>0){
								ZJOBEMPVO zjobempvo = zjobempList.get(0);
								zjobempvo.setJstat("1");
								zjobempService.updateZjobempJstat(zjobempvo);
								jo.put("code", 1);
								jo.put("desc", "OK");
							}else{
								ZJOBEMPVO zjobempvo = new ZJOBEMPVO();
								zjobempvo.setMjdno(job_number);
								zjobempvo.setHouse(warehouse);
								zjobempvo.setOrdno(work_order);
								zjobempvo.setOpseq(step_number);
								zjobempvo.setPline(propr_number);
								zjobempvo.setEmpid(employee_number);
								zjobempvo.setJstat("1");
								zjobempvo.setClhrs(BigDecimal.valueOf(0));
								zjobempService.insertZjobemp(zjobempvo);
								jo.put("code", 1);
								jo.put("desc", "OK");
							}
						}else{
							jo.put("code", 7);
							jo.put("desc", "该员工当前忙碌");
						}
					}else{
						jo.put("code", 6);
						jo.put("desc", "该员工不在当前作业可支配范围");
					}
				}else{
					jo.put("code", 5);
					jo.put("desc", "无该员工信息");
				}
			}
		}catch (Throwable e) {
			e.printStackTrace();
			jo.put("code", 4);
			jo.put("desc", "other exception");
			data = jo.toString();
			log.error("get env error.",e);
			return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	/**
	 * 生产报工-中途加入设备
	 * @return
	 * @throws Exception
	 */
	public String production_report_machine_add() throws Exception{
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else if(job_number==null || job_number.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "job_number is needed");
			}else if(propr_number==null || propr_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "propr_number is needed");
			}else if(step_number==null || step_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "step_number is needed");
			}else if(machine_number==null || machine_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "machine_number is needed");
			}else if(warehouse==null || warehouse.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "warehouse is needed");
			}else if(work_order==null || work_order.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "work_order is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				//看查询的设备是否在生产线上
				Map<String,String> map2 = new HashMap<String, String>();
				map2.put("pline", propr_number);
				map2.put("status", "1");
				map2.put("bmsusr", username);
				map2.put("mchid", machine_number);
				List<ZMCHMSTVO> zmchmstList = zmchmstService.queryZmchmstByMapWithDept(map2);//员工集合
				if(zmchmstList.size()>0){
					ZMCHMSTVO zmchmstvo = zmchmstList.get(0);
					if(zmchmstvo.getPline().trim().equals(propr_number)){
						//判断当前的空闲状态
						boolean isFree = true;
						Map<String,String> zjobmchParMap = new HashMap<String, String>();
						zjobmchParMap.put("mjdno", job_number);
						zjobmchParMap.put("mchid", machine_number);
						List<ZJOBMCHVO> zjobmchList = zjobmchService.queryByMapWithEmpName(zjobmchParMap);
						if(zjobmchList.size()>0){
							ZJOBMCHVO zjobmchvo = zjobmchList.get(0);
							if(zjobmchvo.getJstat().trim().equals("1")){
								isFree = false;
							}else{
								isFree = true;	
							}
						}else{//还没有加入到jobmch中,是空闲的
							isFree = true;
						}
						if(isFree){
							if(zjobmchList.size()>0){
								ZJOBMCHVO zjobmchvo = zjobmchList.get(0);
								zjobmchvo.setJstat("1");
								zjobmchService.updateZjobmchJstat(zjobmchvo);
								jo.put("code", 1);
								jo.put("desc", "OK");
							}else{
								ZJOBMCHVO zjobmchvo = new ZJOBMCHVO();
								zjobmchvo.setMjdno(job_number);
								zjobmchvo.setHouse(warehouse);
								zjobmchvo.setOrdno(work_order);
								zjobmchvo.setOpseq(step_number);
								zjobmchvo.setPline(propr_number);
								zjobmchvo.setMchid(machine_number);
								zjobmchvo.setJstat("1");
								zjobmchvo.setCmhrs(BigDecimal.valueOf(0));
								zjobmchService.insertZjobmch(zjobmchvo);
								jo.put("code", 1);
								jo.put("desc", "OK");
							}
						}else{
							jo.put("code", 7);
							jo.put("desc", "该设备当前忙碌");
						}
					}else{
						jo.put("code", 6);
						jo.put("desc", "该设备不在当前作业可支配范围");
					}
				}else{
					jo.put("code", 5);
					jo.put("desc", "无该设备信息");
				}
			}
		}catch (Throwable e) {
			e.printStackTrace();
			jo.put("code", 4);
			jo.put("desc", "other exception");
			data = jo.toString();
			log.error("get env error.",e);
			return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	/**
	 * 生产报工-中途离开员工
	 * @return
	 * @throws Exception
	 */
	public String production_report_employee_remove() throws Exception{
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else if(job_number==null || job_number.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "job_number is needed");
			}else if(propr_number==null || propr_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "propr_number is needed");
			}else if(step_number==null || step_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "step_number is needed");
			}else if(employee_number==null || employee_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "employee_number is needed");
			}else if(work_order==null || work_order.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "work_order is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				//看查询的员工是否在生产线上
				Map<String,String> map2 = new HashMap<String, String>();
				map2.put("pline", propr_number);
				map2.put("status", "1");
				map2.put("bmsusr", username);
				map2.put("empid", employee_number);
				List<ZEMPMSTVO> zempmstList = zempmstService.queryZempmstByMapWithDept(map2);//员工集合
				if(zempmstList.size()>0){
					ZEMPMSTVO zempmstvo = zempmstList.get(0);
					if(zempmstvo.getPline().trim().equals(propr_number)){
						//判断当前的空闲状态
						Map<String,String> zjobempParMap = new HashMap<String, String>();
						zjobempParMap.put("mjdno", job_number);
						zjobempParMap.put("empid", employee_number);
						List<ZJOBEMPVO> zjobempList = zjobempService.queryByMapWithEmpName(zjobempParMap);
						if(zjobempList.size()>0){
							ZJOBEMPVO zjobempvo = zjobempList.get(0);
							if(zjobempvo.getJstat().trim().equals("1")){
								zjobempvo.setJstat("0");
								zjobempService.updateZjobempJstat(zjobempvo);
								jo.put("code", 1);
								jo.put("desc", "OK");
							}else{
								jo.put("code", 7);
								jo.put("desc", "该员工当前空闲");
							}
						}else{//还没有加入到jobemp中,是空闲的
							jo.put("code", 4);
							jo.put("desc", "该员未加入作业该作业任务");
						}
					}else{
						jo.put("code", 6);
						jo.put("desc", "该员工不在当前作业可支配范围");
					}
				}else{
					jo.put("code", 5);
					jo.put("desc", "无该员工信息");
				}
			}
		}catch (Throwable e) {
			e.printStackTrace();
			jo.put("code", 4);
			jo.put("desc", "other exception");
			data = jo.toString();
			log.error("get env error.",e);
			return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}


	/**
	 * 生产报工-中途离开设备
	 * @return
	 * @throws Exception
	 */
	public String production_report_machine_remove() throws Exception{
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else if(job_number==null || job_number.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "job_number is needed");
			}else if(propr_number==null || propr_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "propr_number is needed");
			}else if(step_number==null || step_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "step_number is needed");
			}else if(machine_number==null || machine_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "machine_number is needed");
			}else if(work_order==null || work_order.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "work_order is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				//看查询的员工是否在生产线上
				Map<String,String> map2 = new HashMap<String, String>();
				map2.put("pline", propr_number);
				map2.put("status", "1");
				map2.put("bmsusr", username);
				map2.put("mchid", machine_number);
				List<ZMCHMSTVO> zmchmstList = zmchmstService.queryZmchmstByMapWithDept(map2);//员工集合
				if(zmchmstList.size()>0){
					ZMCHMSTVO zmchmstvo = zmchmstList.get(0);
					if(zmchmstvo.getPline().trim().equals(propr_number)){
						//判断当前的空闲状态
						Map<String,String> zjobmchParMap = new HashMap<String, String>();
						zjobmchParMap.put("mjdno", job_number);
						zjobmchParMap.put("mchid", machine_number);
						List<ZJOBMCHVO> zjobmchList = zjobmchService.queryByMapWithEmpName(zjobmchParMap);
						if(zjobmchList.size()>0){
							ZJOBMCHVO zjobmchvo = zjobmchList.get(0);
							if(zjobmchvo.getJstat().trim().equals("1")){
								zjobmchvo.setJstat("0");
								zjobmchService.updateZjobmchJstat(zjobmchvo);
								jo.put("code", 1);
								jo.put("desc", "OK");
							}else{
								jo.put("code", 7);
								jo.put("desc", "该设备当前空闲");
							}
						}else{//还没有加入到jobemp中,是空闲的
							jo.put("code", 4);
							jo.put("desc", "该设备未加入作业该作业任务");
						}
					}else{
						jo.put("code", 6);
						jo.put("desc", "该设备不在当前作业可支配范围");
					}
				}else{
					jo.put("code", 5);
					jo.put("desc", "无该设备信息");
				}
			}
		}catch (Throwable e) {
			e.printStackTrace();
			jo.put("code", 4);
			jo.put("desc", "other exception");
			data = jo.toString();
			log.error("get env error.",e);
			return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}


	/**
	 * 生产报工-结束作业-计算公式查询
	 * @return
	 * @throws Exception
	 */
	public String production_report_job_finish_inquire() throws Exception{
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else if(job_number==null || job_number.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "job_number is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				//查询作业信息是否存在
				Map<String,String> zmojobParMap =  new HashMap<String, String>();
				zmojobParMap.put("mjdno", job_number);
				List<ZMOJOBVO> zmojobLsit =  zmojobService.queryZmojobByMap(zmojobParMap);
				if(zmojobLsit.size() == 0){
					jo.put("code", 5);
					jo.put("desc", "该作业不存在");
				}else{
					ZMOJOBVO zmojobvo = zmojobLsit.get(0);
					if(zmojobvo.getOstat().equals("20")){

						Map<String, String> zjbtrnParMap = new HashMap<String, String>();
						zjbtrnParMap.put("mjdno", job_number);
						//						zjbtrnParMap.put("jttyp", "L");
						double artificial_hours = 0d,machine_hours = 0d;
						SimpleDateFormat sf = new SimpleDateFormat("yyMMddHHmmss");
						List<ZJBTRNVO> zjbtrnList = zjbtrnService.queryZjbtrnByMap(zjbtrnParMap);
						for(ZJBTRNVO zjbtrnvo:zjbtrnList){

							String staTm = "000000"+zjbtrnvo.getJtstm().toString();
							staTm = staTm.substring(staTm.length() - 6, staTm.length());
							String staDT = zjbtrnvo.getJtsdt().toString().substring(1)+staTm;

							String endTm ="";
							String endDt ="";
							if(zjbtrnvo.getJstat().equals("50")){
								endTm = "000000"+zjbtrnvo.getJtetm().toString();
								endTm = endTm.substring(endTm.length() - 6, endTm.length());
								endDt = zjbtrnvo.getJtedt().toString().substring(1)+endTm;
							}else{
								endDt = Utils.formateDate(null, "yyMMdd")+Utils.formateDate(null, "HHmmss");
								endTm = Utils.formateDate(null, "HHmmss");
							}

							if(zjbtrnvo.getJttyp().equals("L")){
								artificial_hours+=(sf.parse(endDt).getTime() - sf.parse(staDT).getTime())/(1000d*60d*60d);
							}else{
								machine_hours+=(sf.parse(endDt).getTime() - sf.parse(staDT).getTime())/(1000d*60d*60d);
							}

						}
						DecimalFormat df = new java.text.DecimalFormat("#.00");
						jo.put("artificial_hours", df.format(artificial_hours));
						jo.put("machine_hours", df.format(machine_hours));
						jo.put("code", 1);
						jo.put("desc", "OK");

					}else{
						jo.put("code", 6);
						jo.put("desc", "作业状态错误");
					}
				}

			}
		}catch (Throwable e) {
			e.printStackTrace();
			jo.put("code", 4);
			jo.put("desc", "other exception");
			data = jo.toString();
			log.error("get env error.",e);
			return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}


	/**
	 * 生产报工-结束作业-计算公式查询
	 * @return
	 * @throws Exception
	 */
	public String production_report_job_finish_submit() throws Exception{
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else if(job_number==null || job_number.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "job_number is needed");
			}else if(step_quantity==null || step_quantity.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "step_quantity is needed");
			}else if(artificial_hours_after==null || artificial_hours_after.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "artificial_hours_after is needed");
			}else if(machine_hours_after==null || machine_hours_after.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "machine_hours_after is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				String lib = Utils.getDataSourceS(dbconfigurl, "AMTLIB"+idx);
				String lib1 = Utils.getDataSourceS(dbconfigurl, "AMPHLIB"+idx);


				//查询作业信息是否存在
				Map<String,String> zmojobParMap =  new HashMap<String, String>();
				zmojobParMap.put("mjdno", job_number);
				List<ZMOJOBVO> zmojobLsit =  zmojobService.queryZmojobByMap(zmojobParMap);
				if(zmojobLsit.size() == 0){
					jo.put("code", 5);
					jo.put("desc", "该作业不存在");
				}else{
					ZMOJOBVO zmojobvo = zmojobLsit.get(0);
					if(zmojobvo.getOstat().equals("20")){
						/*
						 * SHKDSP数据库操作
						 * 
						 */
						try {
							new Utils().createShpdsk(lib, dbconfigurl, lib1);
						} catch (Exception e) {
							e.printStackTrace();
							throw new Exception("创建shpdsk失败");
						}

						zmojobService.finishZmojob(zmojobvo,username,step_quantity,artificial_hours_after,machine_hours_after,abnormal_hours,abnormal_reason);
						jo.put("code", 1);
						jo.put("desc", "OK");
					}else{
						jo.put("code", 6);
						jo.put("desc", "作业状态错误");
					}
				}

			}
		}catch (Throwable e) {
			e.printStackTrace();
			jo.put("code", 4);
			jo.put("desc", "other exception");
			data = jo.toString();
			log.error("get env error.",e);
			return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}


	/**
	 * 查询退货单
	 * @return
	 * @throws Exception
	 */
	public String query_return() throws Exception{
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else if(return_number==null || return_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "return_number is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				Map parMap = new HashMap();
				parMap.put("vrdno", new String[]{return_number});
				parMap.put("house", warehouse);
				parMap.put("ostat", "10,40,50");
				List<ZVRHDRVO> zvrhdr = zvrhdrService.queryZvrhdr(parMap);
				if(zvrhdr.size()>0){
					jo.put("firm", zvrhdr.get(0).getVndnr());
					jo.put("status_code", zvrhdr.get(0).getOstat());
					parMap.put("lstat", "10");
					parMap.put("vrdno", return_number);
					List<ZVRITMVO> queryZvritm = zvrhdrService.queryZvritm(parMap);
					JSONArray zvritmJsonArray = new JSONArray();
					for(ZVRITMVO zvritmvo:queryZvritm){
						JSONObject zvritmJsonObject = new JSONObject();
						zvritmJsonObject.put("mater_po", zvritmvo.getOrdno()+"-"+zvritmvo.getPoisq());
						zvritmJsonObject.put("number", zvritmvo.getVrdln());
						zvritmJsonObject.put("mater", zvritmvo.getItnbr());
						zvritmJsonObject.put("quantity", zvritmvo.getPlnvq().doubleValue());
						zvritmJsonObject.put("unit", zvritmvo.getStkum());
						zvritmJsonArray.add(zvritmJsonObject);
					}
					jo.put("mater_list", zvritmJsonArray.toString());
					jo.put("code", 1);
					jo.put("desc", "OK");
				}else{
					jo.put("code", 6);
					jo.put("desc", "查无退货单");
				}
			}
		}catch (Throwable e) {
			e.printStackTrace();
			jo.put("code", 4);
			jo.put("desc", "other exception");
			data = jo.toString();
			log.error("get env error.",e);
			return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	/**
	 * 退货-查询物料明细
	 * @return
	 * @throws Exception
	 */
	public String query_return_item() throws Exception{
		JSONObject jo = new JSONObject();
		try {
			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else if(mater==null || mater.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "mater is needed");
			}else if(warehouse==null || warehouse.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "warehouse is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				Map map = new HashMap();
				map.put("warehouse", warehouse);
				map.put("stid", stid);
				map.put("itnbr", mater);
				List<SLQNTYVO> results = this.xadataService.querySlqnty(map);
				if(results!=null && results.size()>0){
					///
					String ldesc = "";
					ITMSITVO itmsitvo = new ITMSITVO();
					itmsitvo.setHouse(warehouse);
					itmsitvo.setItnot9(mater);
					List<ITMSITVO> itrvts = this.xadataService.queryItrvtAll(itmsitvo);
					if(itrvts!=null && itrvts.size()>0){
						ZITMEXTVO extVo = new ZITMEXTVO();
						ITMSITVO itmsitvot = itrvts.get(0);
						extVo.setItnbr(mater);
						extVo.setStid(warehouse);
						extVo.setItrv(itmsitvot.getItrvt9().trim());
						List<ZITMEXTVO> extLists = this.zitmextService.queryItemExt(extVo);
						ITMRVAVO itmrVo = new ITMRVAVO();
						itmrVo.setItnbr(mater);
						itmrVo.setHouse(warehouse);
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
					jo.put("mate_desc", ldesc);
					///


					List<Map> resultmap = new ArrayList<Map>();
					for(int i=0;i<results.size();i++){
						SLQNTYVO temp = results.get(i);
						Map tm = new HashMap();
						tm.put("shard", temp.getUucalm());
						tm.put("location", temp.getLlocn());
						tm.put("branch", temp.getLbhno());
						tm.put("quantity", temp.getLqnty());
						tm.put("unit", temp.getUnpurum());
						resultmap.add(tm);
					}
					jo.put("location_list", resultmap);
					jo.put("code", 1);
					jo.put("desc", "ok");
				}else{
					jo.put("code", 5);
					jo.put("desc", "no results");
				}
			}
		}catch (Throwable e) {
			e.printStackTrace();
			jo.put("code", 4);
			jo.put("desc", "other exception");
			data = jo.toString();
			log.error("get env error.",e);
			return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	/**
	 * 退货-关闭物料退货
	 * @return
	 * @throws Exception
	 */
	public String mater_return_close() throws Exception{
		JSONObject jo = new JSONObject();
		try {
			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else if(return_number==null || return_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "return_number is needed");
			}else if(return_line==null || return_line.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "return_line is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				ZVRITMVO zvritmvo = new ZVRITMVO();
				zvritmvo.setVrdno(return_number);
				zvritmvo.setVrdln(new BigDecimal(return_line));
				zvrhdrService.closePurchaseReturn(zvritmvo);

				jo.put("code", 1);
				jo.put("desc", "ok");
			}
		}catch (Throwable e) {
			e.printStackTrace();
			jo.put("code", 4);
			jo.put("desc", "other exception");
			log.error("get env error.",e);
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	/**
	 * 退货-确认物料退货
	 * @return
	 * @throws Exception
	 */
	public String mater_return_confirm() throws Exception{
		JSONObject jo = new JSONObject();
		try {
			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else if(return_number==null || return_number.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "return_number is needed");
			}else if(return_line==null || return_line.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "return_line is needed");
			}else if(mater_list==null || mater_list.trim().equals("")){
				jo.put("code", 3);
				jo.put("desc", "mater_list is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				Map map = new HashMap();
				map.put("vrdno", return_number);
				List<ZVRHDRVO> queryZvrhdr = zvrhdrService.queryZvrhdr(map);
				if(queryZvrhdr.size()>0){
					ZVRHDRVO zvrhdrvo = queryZvrhdr.get(0);
					String ostat = zvrhdrvo.getOstat().trim();
					if(ostat.equals("10")||ostat.equals("40")){
						map.put("vrdln", return_line);
						List<ZVRITMVO> queryZvritm = zvrhdrService.queryZvritm(map);
						if(queryZvritm.size()>0){
							ZVRITMVO zvritmvo = queryZvritm.get(0);
							String lstat = zvritmvo.getLstat().trim();
							if(lstat.equals("10")){
								map.put("ordno", zvritmvo.getOrdno());
								map.put("poisq", zvritmvo.getPoisq());
								List<POMASTVO> queryPomastState = xadataService.queryPomastState(map);
								if(queryPomastState.size()>0){
									POMASTVO pomastvo = queryPomastState.get(0);
									String pstts = pomastvo.getPstts().trim();
									String staic =  pomastvo.getStaic().trim();
									if((pstts.equals("20")
											||pstts.equals("30")
											||pstts.equals("35"))
											&&(staic.equals("10")
													||staic.equals("20")
													||staic.equals("30")
													||staic.equals("40"))){

										ZBMSCTLVO bmsctlVO = new ZBMSCTLVO();
										bmsctlVO.setSite(stid);
										List<ZBMSCTLVO> bmsctlList = this.zbmsctlService.queryZbmsctl(bmsctlVO);

										JSONObject json = JSONObject.fromObject(mater_list);
										JSONArray jsonArr = JSONArray.fromObject(json.get("mater_list"));
										if(jsonArr!=null && jsonArr.size()>0){
											for(int i = 0;i<jsonArr.size();i++){
												JSONObject branchJsonObject = jsonArr.getJSONObject(i);
												String location = branchJsonObject.optString("location");
												String branch_desc = branchJsonObject.optString("branch_desc");
												String return_quantity = branchJsonObject.optString("return_quantity");

												Map parames = new HashMap();
												parames.put("sluserId", this.getSession().getServletContext().getAttribute("sluserId"));
												parames.put("slpassword", this.getSession().getServletContext().getAttribute("slpassword"));
												parames.put("slurl", this.getSession().getServletContext().getAttribute("slurl"));
												parames.put("scheduledReceiptToken", zvritmvo.getSctkji() == null?"":zvritmvo.getSctkji());
												parames.put("batchLot", branch_desc == null?"":branch_desc);
												parames.put("receivedToStockWarehouseLocation", location == null?"":location);
												parames.put("reference", zvritmvo.getVrdno().substring(2,zvritmvo.getVrdno().length()));
												parames.put("unitofMeasure", zvritmvo.getStkum() == null?"":zvritmvo.getStkum());
												parames.put("transactionDate", Utils.formateDate(null, "yyyyMMdd"));
												parames.put("receivedToStockQuantity", return_quantity == null?"":Double.parseDouble(return_quantity)*-1);


												if(bmsctlList!=null && bmsctlList.size()>0){
													parames.put("receivedToStockReason", bmsctlList.get(0).getRprsn().trim());
												}else{
													parames.put("receivedToStockReason", "");
												}



												String xaret0 = Utils.systemLinkPurchaseReturn(parames);
												String retVal = (String)parames.get("systemLinkStr");

												System.out.println("xaret0:"+xaret0);
												System.out.println("um:"+retVal);
												String errorStr1 = retVal.substring(retVal.indexOf("hasErrors"), retVal.indexOf("hasErrors")+17);
												String warnStr2 = retVal.substring(retVal.indexOf("hasWarnings"), retVal.indexOf("hasWarnings")+19);
												if(errorStr1.indexOf("true")>=0){
													String now1 = Utils.formateDate(null, "yyyyMMdd");
													String now3 = Utils.formateDate(null, "yyMMdd");
													String now2 = Utils.formateDate(null, "HHmmss");

													String userDept="";
													List<ZBMSU02VO> dps = this.auserService.queryDeptByUserName(username);
													if(dps!=null && dps.size()>0){
														for(ZBMSU02VO dp:dps){
															if(dp.getDflt()!=null && "1".equals(dp.getDflt().trim())){
																//							vo.setPlant(dp.getPlant());
																userDept = (dp.getDept());
															}
														}
													} 

													ZSLLOGVO sysliklog = new ZSLLOGVO();
													int count = this.zsllogService.getCoutsByDt(BigDecimal.valueOf(Long.valueOf("1"+now3)))+1;
													String index = "0000"+count;
													sysliklog.setSldno("SL"+now3+index.substring(index.length()-4));
													sysliklog.setAppl("A");
													sysliklog.setSltype("12");
													sysliklog.setDatyp("12");
													//							sysliklog.setSlreq((String)xamap0.get("systemLinkStr"));
													//							sysliklog.setSlrsp(retStr);
													sysliklog.setSlreq("");
													sysliklog.setSlrsp("");
													sysliklog.setCrdpt(userDept);
													sysliklog.setCrusr(username);
													sysliklog.setCrdat(BigDecimal.valueOf(Long.valueOf("1"+now3)));
													sysliklog.setCrtme(BigDecimal.valueOf(Long.valueOf(now2)));
													sysliklog.setFprcs("0");
													sysliklog.setHouse("");
													sysliklog.setItnbr("");
													sysliklog.setOsgrp("");
													sysliklog.setTrqty(BigDecimal.valueOf(0));
													sysliklog.setLlocn("");
													sysliklog.setNlloc("");
													//							this.zsllogService.insertZsllog(sysliklog);

													throw new RuntimeException("systemlink 错误");
												}else{
													ZVRTRNVO zvrtrnvo = new ZVRTRNVO();
													zvrtrnvo.setVrdno(zvritmvo.getVrdno());
													zvrtrnvo.setVrdln(zvritmvo.getVrdln());
													zvrtrnvo.setVndnr(zvritmvo.getVndnr());
													zvrtrnvo.setHouse(zvritmvo.getHouse());
													zvrtrnvo.setOrdno(zvritmvo.getOrdno());
													zvrtrnvo.setPoisq(zvritmvo.getPoisq());
													zvrtrnvo.setBlksq(zvritmvo.getBlksq());
													zvrtrnvo.setItnbr(zvritmvo.getItnbr());
													zvrtrnvo.setStkum(zvritmvo.getStkum());
													zvrtrnvo.setVrloc(location);
													zvrtrnvo.setActvq(new BigDecimal(return_quantity).setScale(3));
													zvrhdrService.insertZvrtrn(zvrtrnvo);
												}
											}
											zvrhdrService.ensurePurchaseReturn(zvritmvo);
											jo.put("code", 1);
											jo.put("desc", "ok");
										}else{
											throw new RuntimeException("mater_list 错误");
										}
									}else{
										throw new RuntimeException("采购单状态异常 错误");
									}
								}else{
									throw new RuntimeException("xa采购单不存在 错误");
								}
							}else{
								throw new RuntimeException("zvritm 状态 错误");
							}
						}else{
							throw new RuntimeException("不存在zvritm 状态 错误");
						}
					}else{
						throw new RuntimeException("zvrhdr 状态 错误");
					}
				}else{
					throw new RuntimeException("不存在zvrhdr 状态 错误");
				}
			}
		}catch (Throwable e) {
			e.printStackTrace();
			jo.put("code", 4);
			jo.put("desc", e.getMessage());
			log.error("get env error.",e);
		}finally{
		}
		data=jo.toString();
		return "todata";
	}
	public String sale_shipment_query_header()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);

				ZPLHDRVO zplhdr = new ZPLHDRVO();
				zplhdr.setHouse(warehouse);
				zplhdr.setPldno(pldno);
				List<ZPLHDRVO> results = this.zplhdrService.queryZplhdr(zplhdr);

				if(results!=null && results.size()>0){
					ZPLHDRVO vo = results.get(0);
					if(vo.getOstat()!=null && vo.getOstat().trim().equals("10")){
						jo.put("client_number", vo.getCusno().longValue());
						jo.put("client_name", vo.getCusnm());
						jo.put("department", vo.getPldp1());
						String etdate=(vo.getEtdate()+19000000)+"";
						jo.put("expected_data", etdate.substring(0, 4)+"-"+etdate.substring(4, 6)+"-"+etdate.substring(6, 8)+" ");

						ZPLDTLVO zpldtl = new ZPLDTLVO();
						zpldtl.setPldno(pldno);
						zpldtl.setFpost("0");
						List<ZPLDTLVO> dataList = this.zplhdrService.queryReceipt(zpldtl);
						if(dataList!=null && dataList.size()>0){
							List<Map> retList = new ArrayList<Map>();
							for(int i=0;i<dataList.size();i++){
								ZPLDTLVO tdata = dataList.get(i);
								Map datam = new HashMap();
								datam.put("pldln", tdata.getPldln().longValue());
								datam.put("c6cvnb", tdata.getC6cvnb());
								datam.put("cdfcnb", tdata.getCdfcnb()==null?0:tdata.getCdfcnb().longValue());
								datam.put("mater", tdata.getItnbr());
								datam.put("shard", tdata.getPlsub());
								datam.put("location", tdata.getPlloc());
								datam.put("plan_quantity", tdata.getPlqty());
								datam.put("plan_quantity_unit", tdata.getUnmsr());
								ITMSITVO itmsitvo = new ITMSITVO();
								itmsitvo.setHouse(stid);
								itmsitvo.setItnot9(tdata.getItnbr());
								String itrvt = "";
								List<String> itrvts = this.xadataService.queryItrvt(itmsitvo);
								if(itrvts!=null && itrvts.size()>0){
									itrvt=itrvts.get(0);
								}
								ZITMEXTVO extVo = new ZITMEXTVO();
								extVo.setItnbr(tdata.getItnbr());
								extVo.setStid(stid);
								extVo.setItrv(itrvt);
								List<ZITMEXTVO> extLists = this.zitmextService.queryItemExt(extVo);
								String ldesc = "";
								if(extLists!=null && extLists.size()>0 && extLists.get(0).getLdesc().trim().length()>0){
									ldesc=extLists.get(0).getLdesc();
									datam.put("mater_dese", ldesc);
									datam.put("mater_format", extLists.get(0).getSdesc());
								}else{
									ITMRVAVO itmrVo = new ITMRVAVO();
									itmrVo.setItnbr(tdata.getItnbr());
									itmrVo.setHouse(stid);
									itmrVo.setItrv(itrvt);
									List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
									if(itmrLists!=null && itmrLists.size()>0){
										ldesc=itmrLists.get(0).getItdsc();
										datam.put("mater_dese", ldesc);
										datam.put("mater_format", "");
									}else{
										datam.put("mater_dese", "");
										datam.put("mater_format", "");
									}

								}

								retList.add(datam);
							}
							jo.put("zpldtl_list", retList);
						}
					}else{
						jo.put("code", 5);
						jo.put("desc", "该出货通知单不存在");
					}



					jo.put("code", 1);
					jo.put("desc", "ok");
				}else{
					jo.put("code", 5);
					jo.put("desc", "该出货通知单不存在");
				}


			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 400);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	public String sale_shipment_query_item()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);


				ZPLDTLVO zpldtl = new ZPLDTLVO();
				zpldtl.setPldno(pldno);
				zpldtl.setPldln(BigDecimal.valueOf(Long.valueOf(pldln)) );
				zpldtl.setFpost("0");
				List<ZPLDTLVO> results = this.zplhdrService.queryReceipt(zpldtl);
				if(results!=null && results.size()>0){
					ZPLDTLVO vo = results.get(0);
					ZPLBOXVO zplbox = new ZPLBOXVO();
					zplbox.setPldno(pldno);
					zplbox.setPldln(BigDecimal.valueOf(Long.valueOf(pldln)) );
					List<ZPLBOXVO> resultbs = this.zplhdrService.queryBch(zplbox);
					if(resultbs!=null && resultbs.size()>0){
						ZPLBOXVO boxvo = resultbs.get(0);
						jo.put("boxln", boxvo.getBoxln()==null?0:boxvo.getBoxln().longValue());
						jo.put("boxnm", boxvo.getBoxnm());
						jo.put("boxes", boxvo.getBoxes()==null?0:boxvo.getBoxes().longValue());
						//						Map map = new HashMap();
						//						map.put("warehouse", warehouse);
						//						map.put("stid", stid);
						////						map.put("itnbr", mater);
						//						List<SLQNTYVO> resultsls = this.xadataService.querySlqnty(map);
						//						if(resultsls!=null && ){
						//							
						//						}
						ZWHSUBVO subvo = new ZWHSUBVO();
						subvo.setHouse(warehouse);
						List<ZWHSUBVO> zwhsubList = this.zwhsubService.queryZwhsub(subvo);
						if(zwhsubList!=null && zwhsubList.size()>0){
							List<Map> map = new ArrayList<Map>();

							for(int i=0;i<zwhsubList.size();i++){
								ZWHSUBVO temp = zwhsubList.get(i);
								Map tm = new HashMap();
								tm.put("shard", temp.getWhsub());

								map.add(tm);
							}
							jo.put("shard_list", map);

						}
						Map map = new HashMap();
						map.put("warehouse", warehouse);
						map.put("stid", stid);
						map.put("shard", shard);
						map.put("location", location);
						//						map.put("lbhno", branch);
						map.put("itnbr", mater );
						List<SLQNTYVO> slqntyList = this.xadataService.querySlqnty(map);
						if(slqntyList!=null && slqntyList.size()>0){
							List<Map> slqntyrets = new ArrayList<Map>();
							for(int i=0;i<slqntyList.size();i++){
								SLQNTYVO tvo = slqntyList.get(i);
								Map rmap = new HashMap();
								rmap.put("branch", tvo.getLbhno());
								rmap.put("shard", tvo.getUucalm());
								rmap.put("location", tvo.getLlocn());
								rmap.put("quantity", tvo.getLqnty());
								rmap.put("unit", tvo.getUnpurum());
								rmap.put("fifo_date", tvo.getFdate());
								slqntyrets.add(rmap);
							}
							jo.put("mater_list", slqntyrets);
						}

					}else{
						jo.put("code", 5);
						jo.put("desc", "该出货通知单明细不存在");
					}

					jo.put("code", 1);
					jo.put("desc", "ok");
				}else{
					jo.put("code", 5);
					jo.put("desc", "该出货通知单不存在");
				}


			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 400);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}
	public String sale_shipment_cancel()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);


				ZPLDTLVO zpldtl = new ZPLDTLVO();
				zpldtl.setPldno(pldno);
				zpldtl.setPldln(BigDecimal.valueOf(Long.valueOf(pldln)) );
				zpldtl.setFpost("9");
				zplhdrService.updateZpldtlByPar(zpldtl);
				jo.put("code", 1);
				jo.put("desc", "ok");

			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 400);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}
	public String sale_shipment_ensure()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				String lib = Utils.getDataSourceS(dbconfigurl, "AMTLIB"+idx);
				String lib1 = Utils.getDataSourceS(dbconfigurl, "AMPHLIB"+idx);
				String userDept="";
				List<ZBMSU02VO> dps = this.auserService.queryDeptByUserName(username);
				if(dps!=null && dps.size()>0){
					for(ZBMSU02VO dp:dps){
						if(dp.getDflt()!=null && "1".equals(dp.getDflt().trim())){
							//							vo.setPlant(dp.getPlant());
							userDept = (dp.getDept());
						}
					}
				} 
				ZPLHDRVO zplhdr = new ZPLHDRVO();
				zplhdr.setPldno(pldno);
				List<ZPLHDRVO> zplhdrrets = this.zplhdrService.queryZplhdr(zplhdr);
				ZPLHDRVO zplhdrret= zplhdrrets.get(0);
				String now1 = Utils.formateDate(null, "yyMMdd");
				String now2 = Utils.formateDate(null, "HHmmss");

				String hdrno = "";
				ZSAHDRVO zsahdr = new ZSAHDRVO();
				zsahdr.setPldno(pldno);
				zsahdr.setCusno(zplhdrret.getCusno());
				List<ZSAHDRVO> zsahdrrets = this.zplhdrService.queryZsahdrByPar(zsahdr);
				ZSAHDRVO zsahdrvo = null;
				if(zsahdrrets==null || zsahdrrets.size()==0){
					int count = this.zplhdrService.getZsaCoutsByDt(BigDecimal.valueOf(Long.valueOf("1"+now1)));
					String idex = "000"+(count+1);
					hdrno = "SA"+now1+idex.substring(idex.length()-4);
					zsahdrvo = new ZSAHDRVO();
					zsahdrvo.setSadno(hdrno);
					zsahdrvo.setPldno(pldno);
					zsahdrvo.setPlant(zplhdrret.getPlant());
					zsahdrvo.setCusno(zplhdrret.getCusno());
					zsahdrvo.setCusnm(zplhdrret.getCusnm());
					zsahdrvo.setHouse(zplhdrret.getHouse());
					zsahdrvo.setScac(zplhdrret.getScac());
					zsahdrvo.setIncot(zplhdrret.getIncot());
					zsahdrvo.setOstat("10");
					zsahdrvo.setInvno(zplhdrret.getInvno());
					zsahdrvo.setStnam(zplhdrret.getStnam());
					zsahdrvo.setStadd1(zplhdrret.getStadd1());
					zsahdrvo.setStadd2(zplhdrret.getStadd2());
					zsahdrvo.setStcity(zplhdrret.getStcity());
					zsahdrvo.setStctr(zplhdrret.getStctr());
					zsahdrvo.setStzip(zplhdrret.getStzip());
					zsahdrvo.setSfnam(zplhdrret.getSfnam());
					zsahdrvo.setSfadd1(zplhdrret.getSfadd1());
					zsahdrvo.setSfadd2(zplhdrret.getSfadd2());
					zsahdrvo.setSfcity(zplhdrret.getSfcity());
					zsahdrvo.setSfctr(zplhdrret.getSfctr());
					zsahdrvo.setSfzip(zplhdrret.getSfzip());
					zsahdrvo.setScnam(zplhdrret.getScnam());
					zsahdrvo.setScadd1(zplhdrret.getScadd1());
					zsahdrvo.setScadd2(zplhdrret.getScadd2());
					zsahdrvo.setSccity(zplhdrret.getSccity());
					zsahdrvo.setScctr(zplhdrret.getScctr());
					zsahdrvo.setSczip(zplhdrret.getSczip());
					zsahdrvo.setSaus1(username);
					zsahdrvo.setSadp1(userDept);
					zsahdrvo.setSadt1(BigDecimal.valueOf(Long.valueOf("1"+now1)));
					zsahdrvo.setSatm1(BigDecimal.valueOf(Long.valueOf(now2)));
					zsahdrvo.setCmmt("");
				}else{
					hdrno=zsahdrrets.get(0).getSadno();
				}


				Map zsadtlMap = new HashMap();
				zsadtlMap.put("zsahdr", zsahdrvo);
				ZPLDTLVO zpldtl = new ZPLDTLVO();
				zpldtl.setPldno(pldno);
				zpldtl.setPldln(BigDecimal.valueOf(Long.valueOf(pldln)) );
				zpldtl.setFpost("0");
				List<ZPLDTLVO> results = this.zplhdrService.queryReceipt(zpldtl);
				if(results!=null && results.size()>0){
					ZPLDTLVO vo = results.get(0);
					ZSADTLVO zsadtlvo = new  ZSADTLVO();
					zsadtlvo.setSadno(hdrno);
					zsadtlvo.setPldno(pldno);
					int countsa = this.zplhdrService.getZsadtlCouts(zsadtlvo);
					zsadtlvo.setSadln(BigDecimal.valueOf(countsa+1));
					zsadtlvo.setPldln(vo.getPldln());
					zsadtlvo.setC6aenb(vo.getC6aenb());
					zsadtlvo.setC6dccd(vo.getC6dccd());
					zsadtlvo.setC6cvnb(vo.getC6cvnb());
					zsadtlvo.setPonum(vo.getPonum());
					zsadtlvo.setHouse(vo.getHouse());
					zsadtlvo.setCdfcnb(vo.getCdfcnb());
					zsadtlvo.setAddrnb(vo.getAddrnb());
					zsadtlvo.setAdaasz(vo.getAdaasz());
					zsadtlvo.setItnbr(vo.getItnbr());
					zsadtlvo.setUnmsr(vo.getUnmsr());
					zsadtlvo.setSasub1(vo.getPlsub());
					zsadtlvo.setSaloc1(vo.getPlloc());
					zsadtlvo.setSaqty1(vo.getPlqty());
					zsadtlvo.setSqqty2(BigDecimal.valueOf(Double.valueOf(this.actual_quantity)) );
					ITMSITVO itmsitvo = new ITMSITVO();
					itmsitvo.setHouse(stid);
					itmsitvo.setItnot9(vo.getItnbr().trim());
					String itrvt = "";
					List<String> itrvts = this.xadataService.queryItrvt(itmsitvo);
					if(itrvts!=null && itrvts.size()>0){
						itrvt=itrvts.get(0);
					}
					ITMRVAVO itmrVo = new ITMRVAVO();
					itmrVo.setItnbr(vo.getItnbr().trim());
					itmrVo.setHouse(stid);
					itmrVo.setItrv(itrvt);
					List<ITMRVAVO> itmrLists = this.xadataService.queryItmrva(itmrVo);
					if(itmrLists!=null && itmrLists.size()>0){
						ITMRVAVO itmvo = itmrLists.get(0);
						zsadtlvo.setWght1(itmvo.getWeght().multiply(BigDecimal.valueOf(Double.valueOf(this.actual_quantity))));
						zsadtlvo.setWtum1(itmvo.getB2cqcd());
						zsadtlvo.setWght2(BigDecimal.valueOf(Double.valueOf(this.actual_quantity)).divide((itmvo.getB2z95t()==null || itmvo.getB2z95t().floatValue()==0)?BigDecimal.valueOf(1):itmvo.getB2z95t()).multiply(itmvo.getB2aas3()));
						zsadtlvo.setWtum2(itmvo.getB2aapt());
					}
					zsadtlvo.setSaus2(this.username);
					zsadtlvo.setSadp2(userDept);
					zsadtlvo.setSadt2(BigDecimal.valueOf(Long.valueOf("1"+now1)));
					zsadtlvo.setSatm2(BigDecimal.valueOf(Long.valueOf(now2)));
					List zsadtlvos = new ArrayList();
					zsadtlvos.add(zsadtlvo);

					zsadtlMap.put("zsadtls", zsadtlvos);

					ZPLBOXVO zplbox = new ZPLBOXVO();
					zplbox.setPldno(pldno);
					zplbox.setPldln(BigDecimal.valueOf(Long.valueOf(pldln)) );
					List<ZPLBOXVO> resultbs = this.zplhdrService.queryBch(zplbox);
					if(resultbs!=null && resultbs.size()>0){
						ZPLBOXVO boxvo = resultbs.get(0);
						jo.put("boxln", boxvo.getBoxln()==null?0:boxvo.getBoxln().longValue());
						jo.put("boxnm", boxvo.getBoxnm());
						jo.put("boxes", boxvo.getBoxes()==null?0:boxvo.getBoxes().longValue());
						ZSABOXVO zsaboxvo = new ZSABOXVO();
						zsaboxvo.setSadno(hdrno);
						zsaboxvo.setSadln(BigDecimal.valueOf(countsa+1));
						zsaboxvo.setPldno(pldno);
						zsaboxvo.setPldln(boxvo.getPldln());
						zsaboxvo.setBoxln(boxvo.getBoxln());
						zsaboxvo.setBoxnm(boxnm);
						zsaboxvo.setBoxes(BigDecimal.valueOf(Double.valueOf(boxes)));
						List zsaboxvos = new ArrayList();
						zsaboxvos.add(zsaboxvo);
						zsadtlMap.put("zsabboxes", zsaboxvos);
					}
					if(mater_list!=null && mater_list.trim().length()>0){
						JSONObject json = JSONObject.fromObject(mater_list);
						JSONArray jsonArr = JSONArray.fromObject(json.get("mater_list"));
						if(jsonArr!=null && jsonArr.size()>0){
							List zsabchvos = new ArrayList();
							for(int i = 0;i<jsonArr.size();i++){
								JSONObject branchJsonObject = jsonArr.getJSONObject(i);
								ZSABCHVO zsabchvo = new ZSABCHVO();
								zsabchvo.setSadno(hdrno);
								zsabchvo.setSadln(BigDecimal.valueOf(countsa+1));
								zsabchvo.setSadbn(BigDecimal.valueOf(Long.valueOf(i+1)));
								zsabchvo.setPldno(pldno);
								zsabchvo.setPldln(BigDecimal.valueOf(Long.valueOf(pldln)) );
								zsabchvo.setC6aenb(zsadtlvo.getC6aenb());
								zsabchvo.setC6dccd(zsadtlvo.getC6dccd());
								zsabchvo.setC6cvnb(zsadtlvo.getC6cvnb());
								zsabchvo.setHouse(zsadtlvo.getHouse());
								zsabchvo.setCdfcnb(zsadtlvo.getCdfcnb());
								zsabchvo.setAddrnb(zsadtlvo.getAddrnb());
								zsabchvo.setAdaasz(zsadtlvo.getAdaasz());
								zsabchvo.setItnbr(zsadtlvo.getItnbr());
								zsabchvo.setUnmsr(zsadtlvo.getUnmsr());
								zsabchvo.setSabch2(branchJsonObject.optString("branch"));
								zsabchvo.setSasub2(branchJsonObject.optString("shard"));
								zsabchvo.setSaloc2(branchJsonObject.optString("location"));
								zsabchvo.setSaqty2(BigDecimal.valueOf(Double.valueOf(branchJsonObject.optString("quantity"))));
								zsabchvo.setSaus2(this.username);
								zsabchvo.setSadp2(userDept);
								zsabchvo.setSadt2(BigDecimal.valueOf(Long.valueOf("1"+now1)));
								zsabchvo.setSatm2(BigDecimal.valueOf(Long.valueOf(now2)));
								zsabchvos.add(zsabchvo);
							}
							zsadtlMap.put("zsabchs", zsabchvos);
						}
					}
					this.zplhdrService.insertZsahdrs(zsadtlMap);
					//XA过账部分

					jo.put("code", 1);
					jo.put("desc", "ok");
				}else{
					jo.put("code", 5);
					jo.put("desc", "该出货通知单不存在");
				}


			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 400);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}

	
	public String sale_shipment_commit()  throws Exception {
		JSONObject jo = new JSONObject();
		try {

			if(username==null || username.trim().equals("")){
				jo.put("code", 2);
				jo.put("desc", "not have username");
			}else if(env==null || env.trim().equals("")){

				jo.put("code", 3);
				jo.put("desc", "env is needed");
			}else{
				int idx = (Integer)this.getSession().getServletContext().getAttribute(env);
				String dbconfigurl=(String)this.getSession().getServletContext().getAttribute("dbconfigurl");
				if(dbconfigurl==null || dbconfigurl.trim().equals("")){
					dbconfigurl=this.getSession().getServletContext().getRealPath("/WEB-INF")+ "/classes/com/eclink/hgpj/util/dbconfig.properties";
					this.getSession().getServletContext().setAttribute("dbconfigurl",dbconfigurl);
				}
				DataSourceUtil.setDataSource(dbconfigurl, idx);
				String stid =Utils.getDataSourceS(dbconfigurl, "STID"+idx);
				String lib = Utils.getDataSourceS(dbconfigurl, "AMFLIB"+idx);
				String lib1 = Utils.getDataSourceS(dbconfigurl, "AMPHLIB"+idx);
//				String userDept="";
//				List<ZBMSU02VO> dps = this.auserService.queryDeptByUserName(username);
//				if(dps!=null && dps.size()>0){
//					for(ZBMSU02VO dp:dps){
//						if(dp.getDflt()!=null && "1".equals(dp.getDflt().trim())){
//							//							vo.setPlant(dp.getPlant());
//							userDept = (dp.getDept());
//						}
//					}
//				} 
				ZPLHDRVO zplhdr = new ZPLHDRVO();
				zplhdr.setPldno(pldno);
				
				List<ZPLHDRVO> zplhdrrets = this.zplhdrService.queryZplhdr(zplhdr);
				ZPLHDRVO zplhdrret= zplhdrrets.get(0);
				String now1 = Utils.formateDate(null, "yyMMdd");
				String now2 = Utils.formateDate(null, "HHmmss");
				
				
				ZPLDTLVO zpldtl = new ZPLDTLVO();
				zpldtl.setPldno(pldno);
				zpldtl.setFpost("8");
				List<String> zplhdrretss = this.zplhdrService.queryC6cvnb(zpldtl);
				if(zplhdrretss!=null && zplhdrretss.size()>0){//每个销售订单做一个Ship Number,同一个GROUP ID
					List<Map> plist = new ArrayList<Map>();
					for(int j=0;j<zplhdrretss.size();j++){
						String c6cvnb = zplhdrretss.get(j);
						Map pmap = new HashMap();
						Map osaarep = new HashMap();
						osaarep.put("company", Long.valueOf(zplhdrret.getPlant()));
						osaarep.put("house", zplhdrret.getHouse());
						osaarep.put("orderno",c6cvnb);
						pmap.put("osaarep", osaarep);
						zpldtl.setC6cvnb(c6cvnb);
						List<ZPLDTLVO> results = this.zplhdrService.queryReceipt(zpldtl);
						if(results!=null && results.size()>0){
							List<Map> osabccp = new ArrayList<Map>();
							for(int i=0;i<results.size();i++){
								ZPLDTLVO vo = results.get(i);
								ZSADTLVO zsapvo = new ZSADTLVO();
								
								zsapvo.setPldno(vo.getPldno());
								zsapvo.setPldln(vo.getPldln());
								List<ZSADTLVO> zsadtlrets = this.zplhdrService.queryZsadtls(zsapvo);
								if(zsadtlrets!=null && zsadtlrets.size()>0){
									ZSADTLVO zsadtlret = zsadtlrets.get(0); 
									Map zsapmap = new HashMap();
									zsapmap.put("myx2nb", i+1);
									zsapmap.put("mycvnb", zsadtlret.getC6cvnb());
									zsapmap.put("myfcnb", zsadtlret.getCdfcnb()==null?0L:zsadtlret.getCdfcnb().longValue());
									zsapmap.put("mydrnb", zsadtlret.getAddrnb()==null?0L:zsadtlret.getAddrnb().longValue());
									zsapmap.put("myaitx", zsadtlret.getItnbr());
									zsapmap.put("myaayn", "1");
									zsapmap.put("myarqt", zsadtlret.getSqqty2()==null?0L:zsadtlret.getSqqty2().longValue());
									Map mbadrep = new HashMap();
									mbadrep.put("cono", vo.getC6aenb()+"");
									mbadrep.put("ortp", vo.getC6dccd());
									mbadrep.put("ordnc", vo.getC6cvnb());
									mbadrep.put("itmsq", vo.getCdfcnb().longValue());
									String mbadrepstr = this.xadataService.queryMBADREPM(mbadrep);
									if(mbadrepstr!=null && mbadrepstr.trim().length()>0){
										String[] mbadreps = mbadrepstr.split("-");
										zsapmap.put("myaafx", Float.valueOf(mbadreps[3]));
									}else{
										zsapmap.put("myaafx", 0);
									}
									
									ZSABCHVO zsabch = new ZSABCHVO();
									zsabch.setPldno(vo.getPldno());
									zsabch.setPldln(vo.getPldln());
									zsabch.setSadno(zsadtlret.getSadno());
									zsabch.setSadln(zsabch.getSadln());
									List<ZSABCHVO> zsabchrets = this.zplhdrService.queryZsabchs(zsabch);
									if(zsabchrets!=null && zsabchrets.size()>0){
										List<Map> zsabchs = new ArrayList<Map>();
										for(int k=0;k<zsabchrets.size();k++){
											ZSABCHVO zsabcht = zsabchrets.get(k);
											Map zsabchmap = new HashMap();
											zsabchmap.put("aaaasz", zsabcht.getAdaasz());
											zsabchmap.put("aadqnb", k+1);
											zsabchmap.put("aadccd", "1");
											zsabchmap.put("aacvnb", zsabcht.getC6cvnb());
											zsabchmap.put("aafcnb", zsabcht.getCdfcnb());
											zsabchmap.put("aadrnb", zsabcht.getAddrnb());
											zsabchmap.put("aacktx", zsabcht.getSaloc2());
											zsabchmap.put("aacrcd", zsabcht.getSabch2());
											zsabchmap.put("aaf3va", zsabcht.getSaqty2());
											
											zsabchs.add(zsabchmap);
										}
										zsapmap.put("osaccpp", zsabchs);
									}
									
									osabccp.add(zsapmap);
								}
								
							}
							pmap.put("osabccp", osabccp);
							plist.add(pmap);
							
						}else{
							jo.put("code", 5);
							jo.put("desc", "该出货通知单不存在");
							data=jo.toString();
							return "todata";
						}
					}
					//XA过账部分
					try {
						new Utils().insertOffShip(lib, env, plist, lib1);
					} catch (Exception e) {
						e.printStackTrace();
						throw new Exception("过账失败");
					}
					jo.put("code", 1);
					jo.put("desc", "ok");
				}else{
					jo.put("code", 5);
					jo.put("desc", "该出货通知单明细不存在或已经过账");
				}
				
			}
		}catch (Exception e) {e.printStackTrace();
		jo.put("code", 400);
		jo.put("desc", "other exception");
		data = jo.toString();
		log.error("get env error.",e);
		return "todata";
		}finally{
		}
		data=jo.toString();
		return "todata";
	}
	

	/**
	 * 菜单资源排序页面
	 * @return
	 * @throws Exception
	 */
	public String mlService() throws Exception {
		try {
			//			Map mp = this.getRequest().getParameterMap();
			//			String[] pars = (String[] )mp.keySet().toArray();
			//			for(int i=0;i<pars.length;i++ ){
			//				System.out.println("pars "+ i+"="+pars[i]);
			//			}
			Enumeration paramNames = this.getRequest().getParameterNames();  
			while (paramNames.hasMoreElements()) {  
				String paramName = (String) paramNames.nextElement();  
				System.out.println(paramName);
				System.out.println(this.getRequest().getParameter(paramName));
			}  
		} catch (Exception e) {e.printStackTrace();
		log.error("Sort menu occured error.", e);
		return ERROR;
		}
		return "info";
	}

	/**
	 * 进入菜单资源修改页面
	 * @return
	 * @throws Exception
	 */
	public String toModify() throws Exception {
		try {
			// 获取菜单资源详情
			//			menu = menuService.queryMenuById(menu.getMenuId());
		} catch (Exception e) {
			log.error("To modify menu page occured error.", e);
			return ERROR;
		}
		return "toModify";
	}

	/**
	 * 菜单资源修改保存
	 * @return
	 * @throws Exception
	 */
	public String modify() throws Exception {
		try {
			// 菜单资源修改
			menuService.updateMenu(menu);
		} catch (HGPJBizException he) {
			setErrorMsg(he.getMessage());
			return ERROR;
		} catch (Exception e) {
			log.error("Modify save menu occured error.menuId="
					+ menu.getMenuId(), e);
			return ERROR;
		}
		setBackUrl("/resource/resource!toResIndex.action");
		return "info";
	}

	/**
	 * 菜单资源删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		try {
			// 菜单资源删除
			menuService.deleteMenu(menu);
		} catch (HGPJBizException he) {
			setErrorMsg(he.getMessage());
			return ERROR;
		} catch (Exception e) {
			log.error("Delete menu occured error. menuId="
					+ menu.getMenuId(), e);
			return ERROR;
		}
		setBackUrl("/resource/resource!toResIndex.action");
		return "info";
	}

	/**
	 * 进入菜单资源排序页面
	 * @return
	 * @throws Exception
	 */
	public String toSort() throws Exception {
		try {
			// 根据父级菜单获取菜单资源列表
			menus = menuService.queryResourceListByParent(menu);
		} catch (Exception e) {
			log.error("Go to menu sort page occured error. parentMenu="
					+ menu.getParentMenu(), e);
			return ERROR;
		}
		return "toSort";
	}

	/**
	 * 菜单资源排序页面
	 * @return
	 * @throws Exception
	 */
	public String sort() throws Exception {
		try {
			if (menus != null && menus.size() > 0) {
				// 批量更新菜单资源顺序
				menuService.updateResourceOrdert(menus);
			}
		} catch (Exception e) {
			log.error("Sort menu occured error.", e);
			return ERROR;
		}
		setBackUrl("/resource/resource!toResIndex.action");
		return "info";
	}
}
