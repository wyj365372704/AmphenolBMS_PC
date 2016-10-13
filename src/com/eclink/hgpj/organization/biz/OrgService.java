package com.eclink.hgpj.organization.biz;

import java.util.List;

import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.user.vo.UserVO;

/**
 * OrgService.java
 *
 * @Title: 组织机构业务接口
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 20, 2013 4:32:19 PM
 *
 */
public interface OrgService {
	/**
	 * 新增组织
	 * @param org 组织VO
	 * @param user 用户VO
	 * @param orgRes 组织授权
	 * @return
	 * @throws Exception
	 */
	public void insert(OrgVO org, UserVO user, String[] orgRes) throws Exception;
	
	/**
	 * 修改组织
	 * @param org 组织值对象
	 * @param orgRes 组织授权
	 * @throws Exception
	 */
	public void update(OrgVO org, String[] orgRes) throws Exception;
	
	/**
	 * 删除组织
	 * @param org 组织VO
	 * @throws Exception
	 */
	public void delete(OrgVO org) throws Exception;
	
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
	 * 同级组织下是否存在相同名称的组织
	 * @param org
	 * @return
	 * @throws Exception
	 */
	public boolean existOrgName(OrgVO org) throws Exception;
	
	/**
	 * 是否有下级组织
	 * @param orgId 组织ID
	 * @return
	 * @throws Exception
	 */
	public boolean hasChildOrg(int orgId) throws Exception;
	
	/**
	 * 组织下是否有用户
	 * @param orgId
	 * @return
	 * @throws Exception
	 */
	public boolean hasUserOfOrg(int orgId) throws Exception;
	
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

}
