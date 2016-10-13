package com.eclink.hgpj.resource.dao;

import java.util.List;

import com.eclink.hgpj.base.BaseDao;
import com.eclink.hgpj.resource.vo.OperationVO;

/**
 * OperationDao.java
 *
 * @Title: 功能操作数据库访问接口
 * @Description: 

 * @version 1.0
 * @date May 22, 2013 2:45:32 PM
 *
 */
public interface OperationDao extends BaseDao{
	/**
	 * 通过组织ID查询对应的功能操作
	 * @param orgId 组织ID
	 * @return
	 * @throws Exception
	 */
	public List<OperationVO> queryOperListByOrgId(int orgId) throws Exception;
	
	/**
	 * 通过组织ID查询对应的功能操作并标识为已选择
	 * @param orgId 组织ID
	 * @return
	 * @throws Exception
	 */
	public List<OperationVO> querySelectedOperListByOrgId(int orgId) throws Exception;
	
	/**
	 * 通过角色ID查询对应的功能操作并标识为已选择
	 * @param roleId 角色ID
	 * @return
	 * @throws Exception
	 */
	public List<OperationVO> querySelectedOperListByRoleId(int roleId) throws Exception;
	
	/**
	 * 获取系统所有资源操作
	 * @return
	 * @throws Exception
	 */
	public List<OperationVO> queryAllOperList() throws Exception;
	
	/**
	 * 根据资源操作key获取资源操作详情信息
	 * @param oper 资源操作值对象
	 * @return
	 */
	public OperationVO queryOperationByOperKey(OperationVO oper) throws Exception;
	
	/**
	 * 根据资源ID获取操作数量
	 * @param oper 资源操作值对象
	 * @return
	 * @throws Exception
	 */
	public int getOperCountByResourceId(OperationVO oper) throws Exception;
	
	/**
	 * 根据操作KEY与资源ID获取操作数量
	 * @param oper 资源操作值对象
	 * @return
	 * @throws Exception
	 */
	public int getOperCountByOperKey(OperationVO oper) throws Exception;
	
	/**
	 * 获取已经分配给组织的操作数量
	 * @param oper 资源操作值对象
	 * @return
	 * @throws Exception
	 */
	public int getAssignOperCount(OperationVO oper) throws Exception;
	
	/**
	 * 通过资源ID获取资源操作列表
	 * @param oper 资源操作值对象
	 * @return
	 * @throws Exception
	 */
	public List<OperationVO> getOperListByResourceId(OperationVO oper) throws Exception;
	
	/**
	 * 排序资源操作
	 * @param operations
	 * @throws Exception
	 */
	public void sortOperation(final List<OperationVO> operations) throws Exception;
}
