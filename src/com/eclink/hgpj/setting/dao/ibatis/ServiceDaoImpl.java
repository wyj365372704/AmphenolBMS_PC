package com.eclink.hgpj.setting.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.setting.dao.ServiceDao;
import com.eclink.hgpj.setting.vo.ServiceVO;

/**
 * ServiceDaoImpl.java
 *
 * @Title:
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 周灵舟
 * @version 1.0
 * @date May 16, 2013 11:06:08 AM
 *
 */
public class ServiceDaoImpl extends SqlMapClientDaoSupport implements ServiceDao {

	@Override
	public void delete(BaseVO vo) throws Exception {
		this.getSqlMapClientTemplate().delete("SERVICE.deleteService",vo);
	}

	@Override
	public int insert(BaseVO vo) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().insert("SERVICE.insertService",vo);
	}

	@Override
	public void modify(BaseVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("SERVICE.modifyService",vo);
	}

	@Override
	public ServiceVO queryById(int id) throws Exception {
		return (ServiceVO)this.getSqlMapClientTemplate().queryForObject("SERVICE.queryById", id);
	}

	@Override
	public List<ServiceVO> queryList(ServiceVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("SERVICE.queryList", vo);
	}

	@Override
	public int queryListCount(ServiceVO vo) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("SERVICE.queryListCount", vo);
	}

}
