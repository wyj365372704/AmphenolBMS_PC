package com.eclink.hgpj.setting.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.eclink.dfcm.paginator.common.PaginatorUtil;
import com.eclink.dfcm.paginator.tag.PageVO;
import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.setting.biz.ServiceService;
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
public class ServiceAction extends BaseAction {
	private static final Logger log = Logger.getLogger(ServiceAction.class);
	private ServiceVO service = new ServiceVO();
	private List<ServiceVO> services;
	private ServiceService serviceService;
	
	private void setBase(ServiceVO t) {
		Date now = new Date();
		t.setCreateDate(now);
		t.setLastUpdateDate(now);
		if(getLoginUser() != null){
			t.setCreateUser(getLoginUser().getUserName());
			t.setLastUpdateUser(getLoginUser().getUserName());
		}else{
			t.setCreateUser("");
			t.setLastUpdateUser("");
		}
	}
	private void init() {
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
			setPagination(service,page);
			
			// 初始化
			init();
			// 查询总记录数
			if (page.isQueryTotal()) {
				page.setTotalRecord(serviceService.queryListCount(service));
			}
			
			// 调用业务方法查询列表
			services = serviceService.queryList(service);
			
			// 分页对象保存至request
			getRequest().setAttribute(HGPJConstant.PAGE_KEY, page);
		} catch (Exception e) {
			log.error("query service error." ,e);
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
			service = serviceService.queryById(service.getId());
		} catch (Exception e) {
			log.error("view service error." ,e);
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
			log.error("toInsert service error." ,e);
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
			ServiceVO params = new ServiceVO();
			params.setName(service.getName());
			List<ServiceVO> lists = serviceService.queryList(params);
			
			if(lists != null && lists.size() > 0){
				setErrorMsg("业务名称["+service.getName()+"]已存在，请重新输入");
				return "error";
			}
			
			setBase(service);
			serviceService.insert(service);
		} catch (Exception e) {
			log.error("insert service error." ,e);
			return ERROR;
		}
		
		setBackUrl("/setting/service!list.action");
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
			service = serviceService.queryById(service.getId());
		} catch (Exception e) {
			log.error("toModify service error." ,e);
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
			ServiceVO params = new ServiceVO();
			params.setName(service.getName());
			params.setId(service.getId());
			List<ServiceVO> lists = serviceService.queryList(params);
			
			if(lists != null && lists.size() > 0){
				setErrorMsg("业务名称["+service.getName()+"]已存在，请重新输入");
				return "error";
			}
			
			setBase(service);
			serviceService.modify(service);
		}catch(Exception e){
			log.error("modify service error." ,e);
			return ERROR;
		}
		setBackUrl("/setting/service!list.action");
		return "info";
	}
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		if(service != null && service.getId() != null){
			ServiceVO vo = serviceService.queryById(service.getId());
			vo.setStatus("0");// 逻辑删除
			serviceService.modify(vo);
		}
		setBackUrl("/setting/service!list.action");
		return "info";
	}

	public ServiceVO getService() {
		return service;
	}

	public void setService(ServiceVO service) {
		this.service = service;
	}

	public List<ServiceVO> getServices() {
		return services;
	}

	public void setServices(List<ServiceVO> services) {
		this.services = services;
	}
	public void setServiceService(ServiceService serviceService) {
		this.serviceService = serviceService;
	}
	
	
}
