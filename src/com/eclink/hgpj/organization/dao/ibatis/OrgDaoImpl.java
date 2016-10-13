package com.eclink.hgpj.organization.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.organization.dao.OrgDao;
import com.eclink.hgpj.organization.vo.OrgResourceVO;
import com.eclink.hgpj.organization.vo.OrgVO;
import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * OrgDaoImpl.java
 *
 * @Title: 组织机构数据库访问接口实现类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 20, 2013 4:27:32 PM
 *
 */
public class OrgDaoImpl extends SqlMapClientDaoSupport implements OrgDao {

	@Override
	public int insertOrg(OrgVO org) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().insert("Org.insertOrg", org);
	}

	@Override
	public OrgVO queryOrgById(int orgId) throws Exception {
		return (OrgVO)this.getSqlMapClientTemplate().queryForObject("Org.getOrgById", orgId);
	}

	@Override
	public List<OrgVO> queryOrgTreeById(int orgId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Org.getOrgListTreeByOrgId", orgId);
	}

	@Override
	public OrgVO queryParentOrgById(int orgId) throws Exception {
		return (OrgVO)this.getSqlMapClientTemplate().queryForObject("Org.getParentOrgByOrgId", orgId);
	}

	@Override
	public void updateOrg(OrgVO org) throws Exception {
		this.getSqlMapClientTemplate().update("Org.updateOrg", org);
	}

	@Override
	public int queryOrgByOrgNameAndParentOrg(OrgVO org) throws Exception {
		return ((Integer)this.getSqlMapClientTemplate().queryForObject("Org.getOrgByOrgNameAdnParentOrg", org)).intValue();
	}

	@Override
	public void deleteOrgResourceByOrgId(int orgId) throws Exception {
		this.getSqlMapClientTemplate().delete("Org.deleteOrgResByOrgId", orgId);
	}

	@Override
	public void insertOrgResource(final List<OrgResourceVO> orgResList) throws Exception {
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				executor.startBatch();
				if (orgResList != null && orgResList.size() > 0) {
					for (OrgResourceVO orgResource : orgResList) {
						executor.insert("Org.insertOrgResource", orgResource);
					}
				}
				executor.executeBatch();
				return null;
			}
		});
	}

	@Override
	public List queryOrgResourceList(int orgId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Org.getOrgResList", orgId);
	}

	@Override
	public void backUpOrgRes(Map para) throws Exception {
		this.getSqlMapClientTemplate().insert("Org.backupOrgResByOrgIdStr",para);
	}

	@Override
	public void backUpRoleRes(Map para) throws Exception {
		this.getSqlMapClientTemplate().insert("Org.backupRoleResByOrgIdStr",para);
	}

	@Override
	public void conOrgResFromBackTable(int orgId) throws Exception {
		HashMap map = new HashMap();
		map.put("bkOrgId", orgId);
		map.put("orgId", orgId);
		map.put("tableName", "##ORG_RESOURCE");
		this.getSqlMapClientTemplate().insert("Org.conOrgResFromBackUp",map);
	}

	@Override
	public void conRoleResFromBackTable() throws Exception {
		this.getSqlMapClientTemplate().insert("Org.conRoleResFromBackUp","##ROLE_RESOURCE");
	}

	@Override
	public void deleteOrgAndRoleRes(String orgIdStr) throws Exception {
		this.getSqlMapClientTemplate().delete("Org.deleteOrgAndRoleResByOrgIdStr",orgIdStr);
	}
	
	@Override
	public void deleteBackupOrgAndRoleRes(String orgIdStr) throws Exception {
		this.getSqlMapClientTemplate().delete("Org.deleteBackupOrgAndRoleResByOrgIdStr", orgIdStr);
	}

	@Override
	public void insertAdminRoleResource(int orgId) throws Exception {
		HashMap map = new HashMap();
		map.put("orgId", orgId);
		map.put("tableName", "##ROLE_RESOURCE");
		this.getSqlMapClientTemplate().insert("Org.insertRoleResrource", map);
	}

	@Override
	public int queryChildOrgCount(int orgId) throws Exception {
		return ((Integer)this.getSqlMapClientTemplate().queryForObject("Org.getChildOrgCount",orgId)).intValue();
	}

	@Override
	public int queryUserCountOfOrg(int orgId) throws Exception {
		return ((Integer)this.getSqlMapClientTemplate().queryForObject("Org.getUserCountOfOrg",orgId)).intValue();
	}

	@Override
	public List<OrgVO> queryCustomsOrg() throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Org.getCustomsOrg");
	}

	@Override
	public List<OrgVO> queryChildOrgByOrgId(int orgId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Org.getChildOrgByOrgId", orgId);
	}

	@Override
	public List<OrgVO> getHeaderDept() throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Org.getHeaderDept");
	}

	@Override
	public void insertOrgResource(OrgResourceVO orgRes) throws Exception {
		this.getSqlMapClientTemplate().insert("Org.insertOrgResource", orgRes);
	}

	@Override
	public void dropOrgResTmpTable() throws Exception {
		this.getSqlMapClientTemplate().delete("Org.dropOrgResTmpTable","##ORG_RESOURCE");
	}

	@Override
	public List<OrgVO> queryChildCustomsOrg() throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Org.getChildCustomsOrg");
	}

	@Override
	public int getOrgResCount(OrgResourceVO orgRes) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("Org.getOrgResCount", orgRes);
	}

	@Override
	public void deleteOrgResource(OrgResourceVO orgResource) throws Exception {
		this.getSqlMapClientTemplate().delete("Org.deleteOrgRes", orgResource);
	}

}
