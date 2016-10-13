package com.eclink.hgpj.organization.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.organization.dao.OrgDao;
import com.eclink.hgpj.organization.vo.OrgResourceVO;
import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.role.dao.RoleDao;
import com.eclink.hgpj.role.vo.RoleResourceVO;
import com.eclink.hgpj.role.vo.RoleVO;
import com.eclink.hgpj.user.dao.UserDao;
import com.eclink.hgpj.user.vo.UserRoleVO;
import com.eclink.hgpj.user.vo.UserVO;

/**
 * OrgServiceImpl.java
 *
 * @Title: 组织机构业务接口实现类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 20, 2013 4:33:13 PM
 *
 */
public class OrgServiceImpl implements OrgService {

	/**
	 * 组织机构数据库访问接口
	 */
	private OrgDao orgDao;
	
	private UserDao userDao;
	
	private RoleDao roleDao;

	public OrgDao getOrgDao() {
		return orgDao;
	}

	public void setOrgDao(OrgDao orgDao) {
		this.orgDao = orgDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public void insert(OrgVO org, UserVO user, String[] orgRes) throws Exception {
		// 新增组织信息
		int orgId = orgDao.insertOrg(org);
		// 新增组织授权信息
		if (orgRes != null) {
			List<OrgResourceVO> orgResList = new ArrayList<OrgResourceVO>();
			for (String orgResStr : orgRes) {
				if (orgResStr != null && !orgResStr.equals("")) {
					OrgResourceVO orv = new OrgResourceVO();
					orv.setOrgId(orgId);
					String[] resOper = orgResStr.split("~");
					orv.setMenuId(Integer.parseInt(resOper[0]));
					orv.setOperKey(resOper[1]);
					orgResList.add(orv);
				}
			}
			// 批量插入组织资源
			orgDao.insertOrgResource(orgResList);
		}
		// 新增组织为分关，增加角色与用户相关信息
		if (HGPJConstant.ORG_TYPE_F.equals(org.getOrgType())) {
			// 新增角色信息
			RoleVO role = new RoleVO();
			role.setRoleName(HGPJConstant.COMPANY_ADMIN);
			role.setRoleDesc(HGPJConstant.COMPANY_ADMIN);
			role.setOrgId(orgId);
			role.setCustomsId(orgId);
			role.setCreateUser(org.getCreateUser());
			int roleId = roleDao.insertRole(role);
			
			// 新增角色授权信息
			if (orgRes != null) {
				List<RoleResourceVO> roleResList = new ArrayList<RoleResourceVO>();
				for (String orgResStr : orgRes) {
					if (orgResStr != null && !orgResStr.equals("")) {
						RoleResourceVO rrv = new RoleResourceVO();
						rrv.setRoleId(roleId);
						rrv.setOrgId(orgId);
						String[] resOper = orgResStr.split("~");
						rrv.setMenuId(Integer.parseInt(resOper[0]));
						rrv.setOperKey(resOper[1]);
						roleResList.add(rrv);
					}
				}
				// 批量插入角色资源
				roleDao.insertRoleResource(roleResList);
			}
			
			// 新增用户
			user.setIsEvaluated(HGPJConstant.IS_EVALUATED_N);
			user.setDataAccessPerm(HGPJConstant.DATA_ACCESS_PERM_P);
			user.setOrgId(orgId);
			user.setCustomsId(orgId);
			int userId = userDao.insertUser(user);
			
			// 新增用户角色
			UserRoleVO userRole = new UserRoleVO();
			userRole.setUserId(userId);
			userRole.setRoleId(roleId);
			userDao.insertUserRole(userRole);
		}
	}

	@Override
	public OrgVO queryOrgById(int orgId) throws Exception {
		return orgDao.queryOrgById(orgId);
	}

	@Override
	public List<OrgVO> queryOrgTreeById(int orgId) throws Exception {
		return orgDao.queryOrgTreeById(orgId);
	}

	@Override
	public OrgVO queryParentOrgById(int orgId) throws Exception {
		return orgDao.queryParentOrgById(orgId);
	}

	@Override
	public void update(OrgVO org, String[] orgRes) throws Exception {
		// 修改组织信息
		orgDao.updateOrg(org);
		int orgId = org.getOrgId();
		int parentOrg = org.getParentOrg();
		//根据当前组织ID获得从该组织开始的所有子组织组成字符串
		List<OrgVO> orgIdList = orgDao.queryOrgTreeById(orgId);
		String orgIdStr = "";
		if (orgIdList != null && orgIdList.size() > 0) {
			for (OrgVO orgVO : orgIdList) {
				orgIdStr += "," + orgVO.getOrgId();
			}
			orgIdStr = orgIdStr.substring(1);
		}
		
		Map<String,String> para = new HashMap<String,String>();
		para.put("orgIdStr", orgIdStr);
		// 备份组织资源和角色资源
		para.put("tableName", "##ORG_RESOURCE");
		orgDao.backUpOrgRes(para);
		para.put("tableName", "##ROLE_RESOURCE");
		orgDao.backUpRoleRes(para);
		// 级联删除组织资源和角色资源
		orgDao.deleteOrgAndRoleRes(orgIdStr);
		
		//新增当前组织组织资源
		if(orgRes!=null){
			List<OrgResourceVO> orgResList = new ArrayList<OrgResourceVO>();
			for (String orgResStr : orgRes) {
				if(orgResStr!=null && !orgResStr.equals("")){
					OrgResourceVO orv = new OrgResourceVO();
					orv.setOrgId(orgId);
					String [] resOper = orgResStr.split("~");
					orv.setMenuId(Integer.parseInt(resOper[0]));
					orv.setOperKey(resOper[1]);
					orgResList.add(orv);
				}
			}
			orgDao.insertOrgResource(orgResList);
		}
		
		//将备份的组织资源和角色资源合并过来
		orgDao.conOrgResFromBackTable(orgId);
		orgDao.conRoleResFromBackTable();
		
		//修改组织类型为分关时为分关管理员角色增加角色资源记录
		if(HGPJConstant.ORG_TYPE_F.equals(org.getOrgType())){
			orgDao.insertAdminRoleResource(orgId);
		}
		
		// 级联删除备份表中的组织资源和角色资源
//		orgDao.deleteBackupOrgAndRoleRes(orgIdStr);
		
		// 删除本地临时表
		orgDao.dropOrgResTmpTable();
		roleDao.dropRoleResTmpTable();
	}

	@Override
	public boolean existOrgName(OrgVO org) throws Exception {
		return orgDao.queryOrgByOrgNameAndParentOrg(org) > 0 ? true : false;
	}

	@Override
	public boolean hasChildOrg(int orgId) throws Exception {
		return orgDao.queryChildOrgCount(orgId) > 0 ? true : false;
	}

	@Override
	public boolean hasUserOfOrg(int orgId) throws Exception {
		return orgDao.queryUserCountOfOrg(orgId) > 0 ? true : false;
	}

	@Override
	public void delete(OrgVO org) throws Exception {
		// 删除组织资源并会级联删除角色资源
		orgDao.deleteOrgResourceByOrgId(org.getOrgId());
		
		// 删除组织下的用户角色
		userDao.deleteUserRoelByOrgId(org.getOrgId());
		
		// 通过组织ID删除该组织下的所有角色信息
		roleDao.deleteRoleByOrgId(org.getOrgId());
		
		// 更新组织状态为DELETED
		org.setOrgStatus(HGPJConstant.ORG_STATUS_D);
		orgDao.updateOrg(org);
		
		// 更新组织下所有用户的状态为DELETED
		UserVO user = new UserVO();
		user.setStatus(HGPJConstant.USER_STATUS_D);
		user.setOrgId(org.getOrgId());
		userDao.updateUserStatus(user);
	}

	@Override
	public List<OrgVO> queryCustomsOrg() throws Exception {
		return orgDao.queryCustomsOrg();
	}

	@Override
	public List<OrgVO> queryChildOrgByOrgId(int orgId) throws Exception {
		return orgDao.queryChildOrgByOrgId(orgId);
	}

	@Override
	public List<OrgVO> getHeaderDept() throws Exception {
		return orgDao.getHeaderDept();
	}

	@Override
	public List<OrgVO> queryChildCustomsOrg() throws Exception {
		return orgDao.queryChildCustomsOrg();
	}

}
