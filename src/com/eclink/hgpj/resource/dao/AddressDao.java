package com.eclink.hgpj.resource.dao;

import java.util.List;

import com.eclink.hgpj.base.BaseDao;
import com.eclink.hgpj.resource.vo.AddressVO;

/**
 * AddressDao.java
 *
 * @Title: 操作URL地址数据访问接口
 * @Description: 
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date Mar 8, 2012 4:41:34 PM
 *
 */
public interface AddressDao extends BaseDao{
    
    /**
     * 查询操作地址
     * @param resourceId 资源ID
     * @param operationKey 操作key
     * @return 操作地址VO
     */
    public List<AddressVO> listOperationAddress(Integer resourceId, String operationKey);
    
    /**
     * 批量插入操作地址
     * @param addresses 操作地址列表
     * @throws Exception
     */
    public void batchInsertAddress(final List<AddressVO> addresses) throws Exception;

}
