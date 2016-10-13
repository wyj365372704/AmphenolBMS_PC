package com.eclink.hgpj.resource.biz;

import java.util.List;

import com.eclink.hgpj.resource.vo.AddressVO;
import com.eclink.hgpj.resource.dao.AddressDao;

/**
 * AddressServiceImpl.java
 *
 * @Title:
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 28, 2013 10:19:26 PM
 *
 */
public class AddressServiceImpl implements AddressService {
	
	/**
	 * 操作地址数据访问接口
	 */
	private AddressDao addressDao;
	
	public AddressDao getAddressDao() {
		return addressDao;
	}

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	@Override
	public List<AddressVO> listOperationAddress(Integer resourceId,
			String operationKey) {
		return addressDao.listOperationAddress(resourceId, operationKey);
	}

}
