package com.eclink.hgpj.resource.biz;

import java.util.List;

import com.eclink.hgpj.resource.vo.AddressVO;
import com.eclink.hgpj.resource.vo.OperationVO;

/**
 * OperationService.java
 *
 * @Title: 功能操作业务接口
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 22, 2013 2:51:18 PM
 *
 */
public interface OperationService {
	/**
	 *  根据资源操作key获取资源操作详情信息
	 * @param oper 资源操作值对象
	 * @return
	 */
	public OperationVO queryOperationByOperKey(OperationVO oper) throws Exception;
	
	/**
	 * 修改资源操作
	 * @param oper 资源操作对象
	 * @param addresses 操作地址列表
	 * @return
	 * @throws Exception
	 */
	public void modifyOperation(OperationVO oper,
			List<AddressVO> addresses) throws Exception;
	
	/**
	 * 插入资源操作
	 * @param oper 资源操作对象
	 * @param addresses 操作地址列表
	 * @param log 业务操作日志
	 * @return
	 * @throws Exception
	 */
	public void insertOperation(OperationVO oper,
			List<AddressVO> addresses) throws Exception;
	
	/**
	 * 删除资源操作
	 * @param oper 资源操作对象
	 * @param log 业务操作日志
	 * @return
	 * @throws Exception
	 */
	public void deleteOperation(OperationVO oper)
			throws Exception;
	
	/**
	 * 通过资源ID获取资源操作列表
	 * @param oper 资源操作值对象
	 * @return
	 * @throws Exception
	 */
	public List<OperationVO> getOperListByResourceId(OperationVO oper) throws Exception;
	
	/**
	 * 修改资源操作排序顺序
	 * @param operations 资源操作列表
	 * @param log 业务操作日志
	 * @throws Exception
	 */
	public void updateOperationOrder(List<OperationVO> operations) throws Exception;
}
