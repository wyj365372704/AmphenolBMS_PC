package com.eclink.hgpj.resource.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.resource.dao.OperationDao;
import com.eclink.hgpj.resource.vo.OperationVO;
import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * OperationDaoImpl.java
 *
 * @Title:
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 22, 2013 2:47:16 PM
 *
 */
public class OperationDaoImpl extends SqlMapClientDaoSupport implements
		OperationDao {

	@Override
	public List<OperationVO> queryOperListByOrgId(int orgId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Operation.getOperListByOrgId", orgId);
	}

	@Override
	public List<OperationVO> querySelectedOperListByOrgId(int orgId)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Operation.getSelectedOperListByOrgId", orgId);
	}

	@Override
	public List<OperationVO> querySelectedOperListByRoleId(int roleId)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Operation.getOperListByRoleId", roleId);
	}

	@Override
	public List<OperationVO> queryAllOperList() throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Operation.getAllOperList");
	}

	@Override
	public int getAssignOperCount(OperationVO oper) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("Operation.getAssignOperCount", oper);
	}

	@Override
	public int getOperCountByOperKey(OperationVO oper) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("Operation.getOperCountByOperKey", oper);
	}

	@Override
	public int getOperCountByResourceId(OperationVO oper) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("Operation.getOperCountByResourceId", oper);
	}

	@Override
	public List<OperationVO> getOperListByResourceId(OperationVO oper)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Operation.getOperListByResourceId", oper);
	}

	@Override
	public OperationVO queryOperationByOperKey(OperationVO oper)
			throws Exception {
		return (OperationVO) this.getSqlMapClientTemplate().queryForObject(
				"Operation.getOperationByOperKey", oper);
	}

	@Override
	public void sortOperation(final List<OperationVO> operations) throws Exception {
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				executor.startBatch();
				if (operations != null && operations.size() > 0) {
					for (OperationVO operation : operations) {
						executor.insert("Operation.updateOper", operation);
					}
				}
				executor.executeBatch();
				return null;
			}
		});
	}

	@Override
	public void delete(BaseVO vo) throws Exception {
		this.getSqlMapClientTemplate().delete("Operation.deleteOper", vo);
	}

	@Override
	public int insert(BaseVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("Operation.insertOper", vo);
		return 0;
	}

	@Override
	public void modify(BaseVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("Operation.updateOper", vo);
	}

}
