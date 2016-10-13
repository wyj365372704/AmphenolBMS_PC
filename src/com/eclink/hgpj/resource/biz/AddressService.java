package com.eclink.hgpj.resource.biz;

import java.util.List;

import com.eclink.hgpj.resource.vo.AddressVO;

/**
 * AddressService.java
 *
 * @Title: 操作地址业务接口
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 28, 2013 10:13:25 PM
 *
 */
public interface AddressService {
	/**
     * 查询操作地址
     * @param resourceId 资源ID
     * @param operationKey 操作key
     * @return 操作地址VO
     */
    public List<AddressVO> listOperationAddress(Integer resourceId, String operationKey);
}
