package com.eclink.hgpj.organization.dao;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.organization.vo.OrgResourceVO;
import com.eclink.hgpj.organization.vo.OrgVO;

/**
 * OrgDao.java
 *
 * @Title: 组织机构数据层访问接口
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 20, 2013 4:18:57 PM
 *
 */
public interface OrgDao {
	/**
	 * 新增组织
	 * @param org 组织值对象
	 * @return
	 * @throws Exception
	 */
	public int insertOrg(OrgVO org) throws Exception;
	
	/**
	 * 修改组织
	 * @param org 组织值对象
	 * @throws Exception
	 */
	public void updateOrg(OrgVO org) throws Exception;
	
	/**
	 * 根据ID获取组织信息
	 * @param orgId 组织ID
	 * @throws Exception
	 */
	public OrgVO queryOrgById(int orgId) throws Exception;
	
	/**
	 * 根据ID获取组织树
	 * @param orgId 组织ID
	 * @throws Exception
	 */
	public List<OrgVO> queryOrgTreeById(int orgId) throws Exception;
	
	/**
	 * 根据ID获取父级组织（类型为分关或总关的组织）
	 * @param orgId 组织ID
	 * @throws Exception
	 */
	public OrgVO queryParentOrgById(int orgId) throws Exception;
	
	/**
	 * 通过父组织ID与组织名称获取组织数量
	 * @param org 组织值对象
	 * @return
	 * @throws Exception
	 */
	public int queryOrgByOrgNameAndParentOrg(OrgVO org) throws Exception; 
	
	/**
	 * 根据组织ID删除组织资源
	 * @param vo
	 */
	public void deleteOrgResourceByOrgId(int orgId) throws Exception;
	
	/**
	 * 删除指定的组织资源
	 * @param orgResource 组织资源
	 * @throws Exception
	 */
	public void deleteOrgResource(OrgResourceVO orgResource) throws Exception;
	
	/**
	 * 批量添加组织资源
	 * @param orgResList
	 * @return
	 */
	public void insertOrgResource(List<OrgResourceVO> orgResList) throws Exception;
	
	/**
	 * 添加组织资源
	 * @param orgResList
	 * @return
	 */
	public void insertOrgResource(OrgResourceVO orgRes) throws Exception;
	
	/**
	 * 通过组织ID查询组织资源集合
	 * @param vo
	 * @return
	 */
	public List queryOrgResourceList(int orgId) throws Exception;
	
	/**
	 * 备份指定组织ID关联的组织资源到备份表
	 * @param orgIdStr
	 * @throws Exception
	 */
	void backUpOrgRes(Map para)throws Exception;

	/**
	 * 备份指定组织ID关联的角色资源到备份表
	 * @param orgIdStr
	 * @throws Exception
	 */
	void backUpRoleRes(Map para)throws Exception;

	/**
	 * 根据多个组织ID级联删除组织资源和角色资源信息
	 * @param orgIdStr
	 */
	void deleteOrgAndRoleRes(String orgIdStr)throws Exception;
	
	/**
	 * 根据多个组织ID级联删除备份表中的组织资源和角色资源信息
	 * @param orgIdStr
	 */
	void deleteBackupOrgAndRoleRes(String orgIdStr)throws Exception;
	
	/**
	 * 删除组织资源本地临时表
	 * @throws Exception
	 */
	void dropOrgResTmpTable() throws Exception;

	/**
	 * 合并备份表的组织资源正式表
	 * @param orgId
	 * @throws Exception
	 */
	void conOrgResFromBackTable(int orgId)throws Exception;

	/**
	 *  合并备份表的角色资源正式表
	 * @throws Exception
	 */
	void conRoleResFromBackTable()throws Exception;
	
	/**
	 * 新增分关管理员角色资源
	 * @param orgId 组织ID
	 * @throws Exception
	 */
	public void insertAdminRoleResource(int orgId)throws Exception;
	
	/**
	 * 查询子组织数量
	 * @param orgId 组织ID
	 * @return
	 * @throws Exception
	 */
	public int queryChildOrgCount(int orgId) throws Exception;
	
	/**
	 * 查询组织下用户数量
	 * @param orgId 组织ID
	 * @return
	 * @throws Exception
	 */
	public int queryUserCountOfOrg(int orgId) throws Exception;
	
	/**
	 * 获取所有总关与分关组织
	 * @return
	 * @throws Exception
	 */
	public List<OrgVO> queryCustomsOrg() throws Exception;
	
	/**
	 * 获取所有分关组织
	 * @return
	 * @throws Exception
	 */
	public List<OrgVO> queryChildCustomsOrg() throws Exception;
	
	/**
	 * 获取某组织下的所有子组织
	 * @param orgId 组织ID
	 * @return
	 * @throws Exception
	 */
	public List<OrgVO> queryChildOrgByOrgId(int orgId) throws Exception;
	
	/**
	 * 获取总关下的所有科室
	 * @return
	 * @throws Exception
	 */
	public List<OrgVO> getHeaderDept() throws Exception;
	
	/**
	 * 获取组织资源数量
	 * @param orgRes 组织资源VO
	 * @return
	 * @throws Exception
	 */
	public int getOrgResCount(OrgResourceVO orgRes) throws Exception;
	
}
