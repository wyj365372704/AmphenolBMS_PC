package com.eclink.hgpj.setting.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.eclink.dfcm.paginator.common.PaginatorUtil;
import com.eclink.dfcm.paginator.tag.PageVO;
import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.organization.biz.OrgService;
import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.setting.biz.CustomsServiceService;
import com.eclink.hgpj.setting.biz.ServiceService;
import com.eclink.hgpj.setting.vo.CustomsServiceVO;
import com.eclink.hgpj.setting.vo.ServiceVO;

/**
 * 业务设置Action
 *
 * @Title:
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 周灵舟
 * @version 1.0
 * @date May 16, 2013 11:00:40 AM
 *
 */
public class CustomsServiceAction extends BaseAction {
	private static final Logger log = Logger.getLogger(CustomsServiceAction.class);
	private CustomsServiceVO customsService = new CustomsServiceVO();
	private List<CustomsServiceVO> customsServices;
	private CustomsServiceService customsServiceService;
	private ServiceService serviceService;
	private OrgService orgService;
	
	private void init() throws Exception{
		// 根据当前用户权限取出能设置的所属关区
		List<OrgVO> orgs = orgService.queryCustomsOrg();
		// 判断用户类型，总关查询所有数据，分关只能查询本关数据
		if (!isHeadUser()) {
			customsService.setOrgId(getCustomsOfLoginUser().getOrgId());
		}
		
		getRequest().setAttribute("orgs", orgs);
		
		ServiceVO serviceVO = new ServiceVO();
		serviceVO.setStatus("1");// 过滤掉已删除的业务类型
		List<ServiceVO> services = serviceService.queryList(serviceVO);
		getRequest().setAttribute("services", services);
	}
	/**
	 * 列表查询
	 *  
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {

		try {
			// 获取分页信息
			PageVO page = PaginatorUtil.getPaginator(getRequest());
			setPagination(customsService,page);
			
			// 初始化
			init();
			// 查询总记录数
			if (page.isQueryTotal()) {
				page.setTotalRecord(customsServiceService.queryListCount(customsService));
			}
			
			// 调用业务方法查询列表
			customsServices = customsServiceService.queryList(customsService);
			
			// 分页对象保存至request
			getRequest().setAttribute(HGPJConstant.PAGE_KEY, page);
		} catch (Exception e) {
			log.error("query customsService error." ,e);
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 查看
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception{
		try {
			customsServices = customsServiceService.queryByOrgId(customsService.getOrgId());
			customsService = customsServices.get(0);
		} catch (Exception e) {
			log.error("view customsService error." ,e);
			return ERROR;
		}
		return "view";
	}
	/**
	 * 进入新增页面
	 * @return
	 * @throws Exception
	 */
	public String toInsert() throws Exception{
		try {
			// 初始化，所属关区
			init();
		} catch (Exception e) {
			log.error("toInsert customsService error." ,e);
			return ERROR;
		}
		return "new";
	}
	/**
	 * 增加
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception{
		
		try {
			CustomsServiceVO params = new CustomsServiceVO();
			params.setOrgId(customsService.getOrgId());
			List<CustomsServiceVO> lists = customsServiceService.queryList(params);
			
			if(lists != null && lists.size() > 0){
				setErrorMsg("关区["+lists.get(0).getOrgName()+"]已设置业务项，请重新选择");
				return "error";
			}
			
			customsServiceService.insert(customsService);
		} catch (Exception e) {
			log.error("insert customsService error." ,e);
			return ERROR;
		}
		
		setBackUrl("/setting/customsService!list.action");
		return "info";
	}
	/**
	 * 进入修改页面
	 * @return
	 * @throws Exception
	 */
	public String toModify() throws Exception{
		try {
			// 初始化，所属关区
			init();
			customsServices = customsServiceService.queryByOrgId(customsService.getOrgId());
			customsService = customsServices.get(0);
		} catch (Exception e) {
			log.error("toModify customsService error." ,e);
			return ERROR;
		}
		return "modify";
	}
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	public String modify() throws Exception{
		try{
			customsServiceService.modify(customsService);
		}catch(Exception e){
			log.error("modify customsService error." ,e);
			return ERROR;
		}
		setBackUrl("/setting/customsService!list.action");
		return "info";
	}
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		if(customsService != null && customsService.getOrgId() != null){
			customsServiceService.deleteServiceByOrgId(customsService.getOrgId());
		}
		setBackUrl("/setting/customsService!list.action");
		return "info";
	}

	public CustomsServiceVO getCustomsService() {
		return customsService;
	}

	public void setCustomsService(CustomsServiceVO customsService) {
		this.customsService = customsService;
	}

	public List<CustomsServiceVO> getCustomsServices() {
		return customsServices;
	}

	public void setCustomsServices(List<CustomsServiceVO> customsServices) {
		this.customsServices = customsServices;
	}
	public void setCustomsServiceService(CustomsServiceService customsServiceService) {
		this.customsServiceService = customsServiceService;
	}
	public void setServiceService(ServiceService serviceService) {
		this.serviceService = serviceService;
	}
	public OrgService getOrgService() {
		return orgService;
	}
	public void setOrgService(OrgService orgService) {
		this.orgService = orgService;
	}
	
}
