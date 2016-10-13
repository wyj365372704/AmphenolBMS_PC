package com.eclink.hgpj.role.dao;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.role.vo.RoleResourceVO;
import com.eclink.hgpj.role.vo.RoleVO;

/**
 * RoleDao.java
 *
 * @Title: 角色数据库访问接口
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 23, 2013 1:40:48 PM
 *
 */
public interface RoleDao {
	/**
	 * 新增角色
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public int insertRole(RoleVO role) throws Exception;
	
	/**
	 * 更新角色
	 * @param role
	 * @throws Exception
	 */
	public void updateRole(RoleVO role) throws Exception;
	
	/**
	 * 删除角色
	 * @param roleId
	 * @throws Exception
	 */
	public void deleteRole(int roleId) throws Exception;
	
	/**
	 * 删除某组织下的所有角色
	 * @param orgId 组织ID
	 * @throws Exception
	 */
	public void deleteRoleByOrgId(int orgId) throws Exception;
	
	/**
	 * 根据ID查询角色
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public RoleVO queryRoleById(int roleId) throws Exception;
	
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
	 * 根据角色名称与组织ID查询角色数量
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public int queryRoleCountByRoleNameAndOrgId(RoleVO role) throws Exception;
	
	/**
	 * 批量新增角色资源
	 * @param roleResList 角色资源列表
	 * @throws Exception
	 */
	public void insertRoleResource(List<RoleResourceVO> roleResList) throws Exception;
	
	/**
	 * 新增角色资源
	 * @param roleRes 角色资源
	 * @throws Exception
	 */
	public void insertRoleResource(RoleResourceVO roleRes) throws Exception;
	
	/**
	 * 删除角色资源
	 * @param roleId 角色ID
	 * @throws Exception
	 */
	public void deleteRoleResource(int roleId) throws Exception;
	
	/**
	 * 判断某组织下是否存在相同名字的角色
	 * @param roleName
	 * @return
	 * @throws Exception
	 */
	public int exitsRoleName(RoleVO role) throws Exception;
	
	/**
	 * 获取角色被用户关联的数量
	 * @param roleId 角色ID
	 * @return
	 * @throws Exception
	 */
	public int queryUserRoleCountByRoleId(int roleId) throws Exception;
	
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
	
	/**
	 * 备份历史角色资源记录
	 * @param param 封装组织ID、角色ID
	 */
	public void backupRoleResource(Map param) throws Exception;
	
	/**
	 * 将备份表中角色资源记录合并到正式表
	 * @param orgId 组织ID
	 */
	public void mergeRoleResource(Map param) throws Exception;
	
	/**
	 * 删除角色资源本地临时表
	 * @throws Exception
	 */
	public void dropRoleResTmpTable() throws Exception;
	
	/**
	 * 根据组织ID获取分关管理员角色
	 * @param orgId 组织ID
	 * @return
	 * @throws Exception
	 */
	public RoleVO queryAdminRoleByOrgId(int orgId) throws Exception;
	
	/**
	 * 判断角色资源是否存在
	 * @param roleRes 角色资源
	 * @return
	 * @throws Exception
	 */
	public boolean existRoleResource(RoleResourceVO roleRes) throws Exception;
}
