package com.eclink.hgpj.setting.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.setting.dao.EvaluationDao;
import com.eclink.hgpj.setting.vo.EvaluationVO;

/**
 * KeyEvaluatorDaoImpl.java
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
public class EvaluationDaoImpl extends SqlMapClientDaoSupport implements EvaluationDao {

	@Override
	public void delete(BaseVO vo) throws Exception {
	}

	@Override
	public int insert(BaseVO vo) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().insert("EVALUATION.insertEvaluation",vo);
	}

	@Override
	public void modify(BaseVO vo) throws Exception {
	}

	@Override
	public int queryListCount(EvaluationVO vo) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("EVALUATION.queryListCount",vo);
	}

	@Override
	public List<EvaluationVO> queryList(EvaluationVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("EVALUATION.queryList", vo);
	}

	@Override
	public void insertKeyEvaluation(EvaluationVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("EVALUATION.insertKeyEvaluation", vo);
	}

}
