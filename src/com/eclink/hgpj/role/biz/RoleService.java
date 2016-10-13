package com.eclink.hgpj.role.biz;

import java.util.List;

import com.eclink.hgpj.role.vo.RoleVO;

/**
 * RoleService.java
 *
 * @Title: 角色业务接口
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 24, 2013 1:13:24 PM
 *
 */
public interface RoleService {
	/**
	 * 新增角色
	 * 
	 * @param role
	 * @param orgRes
	 * @return
	 * @throws Exception
	 */
	public void insert(RoleVO role, List<String> orgRes) throws Exception;

	/**
	 * 更新角色
	 * 
	 * @param role
	 * @param orgRes
	 * @throws Exception
	 */
	public void update(RoleVO role, List<String> orgRes) throws Exception;
	
	/**
	 * 删除角色
	 * @param roleId
	 * @throws Exception
	 */
	public void delete(int roleId) throws Exception;
	
	/**
	 * 通过条件查询角色列表
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public List<RoleVO> queryRoleList(RoleVO role) throws Exception;
	
	/**
	 * 通过条件查询角色总数量
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public int queryRoleListCount(RoleVO role) throws Exception;
	
	/**
	 * 根据ID查询角色
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public RoleVO queryRoleById(int roleId) throws Exception;
	
	/**
	 * 判断某组织下是否存在相同名字的角色
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public boolean exitsRoleName(RoleVO role) throws Exception;
	
	/**
	 * 判断是否有用户使用某角色
	 * @param roleId 角色ID
	 * @return
	 * @throws Exception
	 */
	public boolean hasUserUserRole(int roleId) throws Exception;
	
	/**
	 * 根据用户ID查询角色列表
	 * @param userId 用户ID
	 * @throws Exception
	 */
	public List<RoleVO> queryRoleByUserId(int userId) throws Exception;
	
	/**
	 * 根据组织ID查询角色列表
	 * @param orgId
	 * @return
	 * @throws Exception
	 */
	public List<RoleVO> queryRoleByOrgId(int orgId) throws Exception;
}
