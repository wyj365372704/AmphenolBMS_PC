package com.eclink.hgpj.resource.biz;

import java.util.List;

import com.eclink.hgpj.common.HGPJBizException;
import com.eclink.hgpj.resource.dao.AddressDao;
import com.eclink.hgpj.resource.dao.OperationDao;
import com.eclink.hgpj.resource.vo.AddressVO;
import com.eclink.hgpj.resource.vo.OperationVO;

/**
 * OperationServiceImpl.java
 *
 * @Title: 功能操作业务接口实现类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 28, 2013 10:19:48 PM
 *
 */
public class OperationServiceImpl implements OperationService {
	/**
	 * 资源操作数据访问对象
	 */
	private OperationDao operationDao;

	/**
	 * 操作地址数据访问对象
	 */
	private AddressDao addressDao;

	public OperationDao getOperationDao() {
		return operationDao;
	}

	public void setOperationDao(OperationDao operationDao) {
		this.operationDao = operationDao;
	}
	
	public AddressDao getAddressDao() {
		return addressDao;
	}

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	@Override
	public void deleteOperation(OperationVO oper)
			throws Exception {
		// 检查资源操作是否已经授权给组织
		int count = operationDao.getAssignOperCount(oper);
		if (count > 0) {
			throw new HGPJBizException("资源操作已经授权给组织，无法删除");
		}
		operationDao.delete(oper);
	}

	@Override
	public List<OperationVO> getOperListByResourceId(OperationVO oper)
			throws Exception {
		return operationDao.getOperListByResourceId(oper);
	}

	@Override
	public void insertOperation(OperationVO oper, List<AddressVO> addresses) throws Exception {
		// 检查操作KEY是否已经存在
		int count = operationDao.getOperCountByOperKey(oper);
		if (count > 0) {
			throw new HGPJBizException("操作KEY已经存在，请重新填写！");
		}
		// 新增操作顺序
		int order = operationDao.getOperCountByResourceId(oper);
		oper.setOrderKey(order+1);
		// 插入资源操作
		operationDao.insert(oper);
		if (addresses != null && addresses.size() > 0) {
			for (AddressVO address : addresses) {
				address.setMenuId(oper.getMenuId());
				address.setOperKey(oper.getOperKey());
			}
			// 批量插入资源操作
			addressDao.batchInsertAddress(addresses);
		}
	}

	@Override
	public void modifyOperation(OperationVO oper, List<AddressVO> addresses) throws Exception {
		// 修改资源操作
		operationDao.modify(oper);
		if (addresses != null && addresses.size() > 0) {
			// 删除资源操作地址
			addressDao.delete(addresses.get(0));
			// 批量插入资源操作
			addressDao.batchInsertAddress(addresses);
		}
	}

	@Override
	public OperationVO queryOperationByOperKey(OperationVO oper)
			throws Exception {
		return operationDao.queryOperationByOperKey(oper);
	}

	@Override
	public void updateOperationOrder(List<OperationVO> operations) throws Exception {
		operationDao.sortOperation(operations);
	}

}
