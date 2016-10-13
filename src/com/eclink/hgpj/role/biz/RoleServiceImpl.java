package com.eclink.hgpj.role.biz;

import java.util.ArrayList;
import java.util.List;

import com.eclink.hgpj.role.dao.RoleDao;
import com.eclink.hgpj.role.vo.RoleResourceVO;
import com.eclink.hgpj.role.vo.RoleVO;

/**
 * RoleServiceImpl.java
 *
 * @Title: 角色业务接口实现类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 24, 2013 1:13:50 PM
 *
 */
public class RoleServiceImpl implements RoleService {
	private RoleDao roleDao;

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public void delete(int roleId) throws Exception {
		// 删除角色资源
		roleDao.deleteRoleResource(roleId);
		// 删除角色
		roleDao.deleteRole(roleId);
	}

	@Override
	public void insert(RoleVO role,List<String> orgRes) throws Exception {
		// 新增角色
		int roleId = roleDao.insertRole(role);
		
		// 批量新增角色授权
		if (orgRes != null && !orgRes.isEmpty()) {
			List<RoleResourceVO> roleResList = new ArrayList<RoleResourceVO>();
			for (String orgResStr : orgRes) {
				if(orgResStr!=null && !orgResStr.equals("")){
					RoleResourceVO rrv = new RoleResourceVO();
					rrv.setOrgId(role.getOrgId());
					rrv.setRoleId(roleId);
					String [] resOper = orgResStr.split("~");
					rrv.setMenuId(Integer.valueOf(resOper[0]));
					rrv.setOperKey(resOper[1]);
					roleResList.add(rrv);
				}
			}
			roleDao.insertRoleResource(roleResList);
		}
	}

	@Override
	public List<RoleVO> queryRoleList(RoleVO role) throws Exception {
		return roleDao.queryRoleList(role);
	}

	@Override
	public int queryRoleListCount(RoleVO role) throws Exception {
		return roleDao.queryRoleListCount(role);
	}

	@Override
	public void update(RoleVO role, List<String> orgRes) throws Exception {
		// 更新角色信息
		roleDao.updateRole(role);
		// 删除角色授权信息
		roleDao.deleteRoleResource(role.getRoleId());
		// 批量新增角色授权
		if (orgRes != null && !orgRes.isEmpty()) {
			List<RoleResourceVO> roleResList = new ArrayList<RoleResourceVO>();
			for (String orgResStr : orgRes) {
				if(orgResStr!=null && !orgResStr.equals("")){
					RoleResourceVO rrv = new RoleResourceVO();
					rrv.setOrgId(role.getOrgId());
					rrv.setRoleId(role.getRoleId());
					String [] resOper = orgResStr.split("~");
					rrv.setMenuId(Integer.valueOf(resOper[0]));
					rrv.setOperKey(resOper[1]);
					roleResList.add(rrv);
				}
			}
			roleDao.insertRoleResource(roleResList);
		}
	}

	@Override
	public RoleVO queryRoleById(int roleId) throws Exception {
		return roleDao.queryRoleById(roleId);
	}

	@Override
	public boolean exitsRoleName(RoleVO role) throws Exception {
		return roleDao.exitsRoleName(role) > 0 ? true : false;
	}

	@Override
	public boolean hasUserUserRole(int roleId) throws Exception {
		return roleDao.queryUserRoleCountByRoleId(roleId) > 0 ? true : false;
	}

	@Override
	public List<RoleVO> queryRoleByUserId(int userId) throws Exception {
		return roleDao.queryRoleByUserId(userId);
	}

	@Override
	public List<RoleVO> queryRoleByOrgId(int orgId) throws Exception {
		return roleDao.queryRoleByOrgId(orgId);
	}

}
