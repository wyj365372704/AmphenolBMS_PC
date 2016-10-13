package com.eclink.hgpj.setting.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.setting.dao.ParameterDao;
import com.eclink.hgpj.setting.vo.ParameterVO;

/**
 * ParameterDaoImpl.java
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
public class ParameterDaoImpl extends SqlMapClientDaoSupport implements ParameterDao {

	@Override
	public void delete(BaseVO vo) throws Exception {
		this.getSqlMapClientTemplate().delete("PARAMETER.deleteParameter",vo);
	}

	@Override
	public int insert(BaseVO vo) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().insert("PARAMETER.insertParameter",vo);
	}

	@Override
	public void modify(BaseVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("PARAMETER.modifyParameter",vo);
	}

	@Override
	public ParameterVO queryById(int id) throws Exception {
		return (ParameterVO)this.getSqlMapClientTemplate().queryForObject("PARAMETER.queryById", id);
	}

	@Override
	public ParameterVO queryByName(String name) throws Exception {
		return (ParameterVO)this.getSqlMapClientTemplate().queryForObject("PARAMETER.queryByName", name);
	}

	@Override
	public List<ParameterVO> queryList(ParameterVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("PARAMETER.queryList", vo);
	}

	@Override
	public int queryListCount(ParameterVO vo) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("PARAMETER.queryListCount", vo);
	}

}
