package com.eclink.hgpj.role.dao.ibatis;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.role.dao.RoleDao;
import com.eclink.hgpj.role.vo.RoleResourceVO;
import com.eclink.hgpj.role.vo.RoleVO;
import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * RoleDaoImpl.java
 *
 * @Title: 角色数据库访问接口实现类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 23, 2013 1:41:31 PM
 *
 */
public class RoleDaoImpl extends SqlMapClientDaoSupport implements RoleDao {

	@Override
	public void deleteRole(int roleId) throws Exception {
		this.getSqlMapClientTemplate().delete("Role.deleteRole", roleId);
	}

	@Override
	public int insertRole(RoleVO role) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().insert("Role.insertRole", role);
	}

	@Override
	public RoleVO queryRoleById(int roleId) throws Exception {
		return (RoleVO)this.getSqlMapClientTemplate().queryForObject("Role.queryRoleById", roleId);
	}

	@Override
	public int queryRoleCountByRoleNameAndOrgId(RoleVO role) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("Role.exitsRoleName", role);
	}

	@Override
	public List<RoleVO> queryRoleList(RoleVO role) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Role.queryRoleList", role);
	}

	@Override
	public int queryRoleListCount(RoleVO role) throws Exception {
		return ((Integer)this.getSqlMapClientTemplate().queryForObject("Role.queryRoleListCount", role)).intValue();
	}

	@Override
	public void updateRole(RoleVO role) throws Exception {
		this.getSqlMapClientTemplate().update("Role.updateRole", role);
	}

	@Override
	public void deleteRoleResource(int roleId) throws Exception {
		this.getSqlMapClientTemplate().delete("Role.deleteRoleRes", roleId);
	}

	@Override
	public void insertRoleResource(final List<RoleResourceVO> roleResList)
			throws Exception {
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				executor.startBatch();
				if (roleResList != null && roleResList.size() > 0) {
					for (RoleResourceVO roleResource : roleResList) {
						executor.insert("Role.insertRoleRes", roleResource);
					}
				}
				executor.executeBatch();
				return null;
			}
		});
	}

	@Override
	public void deleteRoleByOrgId(int orgId) throws Exception {
		this.getSqlMapClientTemplate().delete("Role.deleteRoleByOrgId", orgId);
	}

	@Override
	public int exitsRoleName(RoleVO role) throws Exception {
		return ((Integer) this.getSqlMapClientTemplate().queryForObject(
				"Role.exitsRoleName", role)).intValue();
	}

	@Override
	public int queryUserRoleCountByRoleId(int roleId) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("Role.getUserRoleCountByRoleId", roleId);
	}

	@Override
	public List<RoleVO> queryRoleByUserId(int userId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Role.queryRoleByUserId", userId);
	}

	@Override
	public List<RoleVO> queryRoleByOrgId(int orgId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Role.queryRoleByOrgId", orgId);
	}

	@Override
	public void backupRoleResource(Map param) throws Exception {
		this.getSqlMapClientTemplate().insert("Role.backupRoleResource", param);
	}

	@Override
	public void mergeRoleResource(Map param) throws Exception {
		this.getSqlMapClientTemplate().insert("Role.mergeRoleResource", param);
	}

	@Override
	public void insertRoleResource(RoleResourceVO roleRes) throws Exception {
		this.getSqlMapClientTemplate().insert("Role.insertRoleRes", roleRes);
	}

	@Override
	public void dropRoleResTmpTable() throws Exception {
		this.getSqlMapClientTemplate().delete("Role.dropRoleResTmpTable","##ROLE_RESOURCE");
	}

	@Override
	public RoleVO queryAdminRoleByOrgId(int orgId) throws Exception {
		return (RoleVO)this.getSqlMapClientTemplate().queryForObject("Role.queryAdminRoleByOrgId", orgId);
	}

	@Override
	public boolean existRoleResource(RoleResourceVO roleRes) throws Exception {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject(
				"Role.queryRoleResourceCount", roleRes);
		return count > 0 ? true : false;
	}
	
}
