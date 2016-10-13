package com.eclink.hgpj.resource.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJBizException;
import com.eclink.hgpj.resource.biz.AddressService;
import com.eclink.hgpj.resource.biz.OperationService;
import com.eclink.hgpj.resource.vo.AddressVO;
import com.eclink.hgpj.resource.vo.OperationVO;

/**
 * OperationAction.java
 *
 * @Title: 资源操作Action类
 * @Description: 
 * @version 1.0
 * @date May 28, 2013 10:10:26 PM
 *
 */
public class OperationAction extends BaseAction {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(OperationAction.class);
	
	/**
	 * 资源操作VO对象
	 */
	private OperationVO oper = new OperationVO();
	
	/**
	 * 资源操作地址列表
	 */
	private List<AddressVO> addresses;
	
	/**
	 * 资源操作列表
	 */
	private List<OperationVO> operations;
	
	/**
	 * 资源操作业务接口
	 */
	private OperationService operationService;
	
	/**
	 * 操作地址业务接口
	 */
	private AddressService addressService;

	public OperationVO getOper() {
		return oper;
	}

	public void setOper(OperationVO oper) {
		this.oper = oper;
	}

	public List<AddressVO> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressVO> addresses) {
		this.addresses = addresses;
	}

	public List<OperationVO> getOperations() {
		return operations;
	}

	public void setOperations(List<OperationVO> operations) {
		this.operations = operations;
	}

	public OperationService getOperationService() {
		return operationService;
	}

	public void setOperationService(OperationService operationService) {
		this.operationService = operationService;
	}

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	
	/**
	 * 查看资源操作详情信息
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception {
		try {
			// 查询资源操作详情信息
			oper = operationService.queryOperationByOperKey(oper);
			// 查询资源操作下的URL地址
			List<AddressVO> addresses = addressService.listOperationAddress(oper.getMenuId(), oper.getOperKey());
			oper.setAddressList(addresses);
		} catch (Exception e) {
			log.error("View operation occured error.resourceId="
					+ oper.getMenuId() + ", operKey=" + oper.getOperKey(),
					e);
			return ERROR;
		}
		return "view";
	}
	
	/**
	 * 进入资源操作修改页面
	 * @return
	 * @throws Exception
	 */
	public String toModify() throws Exception {
		try {
			// 查询资源操作详情信息
			oper = operationService.queryOperationByOperKey(oper);
			// 查询资源操作下的URL地址
			List<AddressVO> addresses = addressService.listOperationAddress(oper.getMenuId(), oper.getOperKey());
			oper.setAddressList(addresses);
		} catch (Exception e) {
			log.error("Go to operation modify page occured error.menuId="
					+ oper.getMenuId() + ", operKey=" + oper.getOperKey(),
					e);
			return ERROR;
		}
		return "toModify";
	}
	
	/**
	 * 资源操作修改保存
	 * @return
	 * @throws Exception
	 */
	public String modify() throws Exception {
		try {
			// 修改资源操作及操作地址
			operationService.modifyOperation(oper, addresses);
		} catch (Exception e) {
			log.error("Operation modify occured error.menuId="
					+ oper.getMenuId() + ", operKey=" + oper.getOperKey(),
					e);
			return ERROR;
		}
		setBackUrl("/resource/resource!toResIndex.action");
		return "info";
	}
	
	/**
	 * 进入资源操作新增页面
	 * @return
	 * @throws Exception
	 */
	public String toInsert() throws Exception {
		try {
			// 菜单名称转码
			String menuName = oper.getMenuName();
			if (!StringUtils.isEmpty(menuName)) {
				menuName = new String(menuName.getBytes("ISO-8859-1"),"UTF-8");
			} else {
				menuName = "";
			}
			oper.setMenuName(menuName);
		} catch (Exception e) {
			log.error("Go to insert operation page occured error.", e);
			return ERROR;
		}
		return "toInsert";
	}
	
	/**
	 * 资源操作新增保存
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		try {
			// 插入资源操作及操作地址
			operationService.insertOperation(oper, addresses);
		} catch (HGPJBizException he){
			setErrorMsg(he.getMessage());
			return ERROR;
		} catch (Exception e) {
			log.error("Insert save operation occured error.menuId="
					+ oper.getMenuId() + ", operKey=" + oper.getOperKey(),
					e);
			return ERROR;
		}
		setBackUrl("/resource/resource!toResIndex.action");
		return "info";
	}
	
	/**
	 * 删除资源操作
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		try {
			// 删除资源操作
			operationService.deleteOperation(oper);
		} catch (HGPJBizException he){
			setErrorMsg(he.getMessage());
			return ERROR; 
		} catch (Exception e) {
			log.error("Delete operation occured error.menuId="
							+ oper.getMenuId() + ",operKey="
							+ oper.getOperKey(), e);
			return ERROR;
		}
		setBackUrl("/resource/resource!toResIndex.action");
		return "info";
	}
	
	/**
	 * 进入资源操作排序页面
	 * @return
	 * @throws Exception
	 */
	public String toSort() throws Exception {
		try {
			// 查询资源操作列表
			operations = operationService.getOperListByResourceId(oper);
		} catch (Exception e) {
			log.error("Go to operation sort page occured error.", e);
			return ERROR;
		}
		return "toSort";
	}
	
	/**
	 * 资源操作排序保存
	 * @return
	 * @throws Exception
	 */
	public String sort() throws Exception {
		try {
			if (operations != null && operations.size() > 0) {
				// 资源操作排序
				operationService.updateOperationOrder(operations);
			}
		} catch (Exception e) {
			log.error("Operation sort save occured error.", e);
			return ERROR;
		}
		setBackUrl("/resource/resource!toResIndex.action");
		return "info";
	}
}
