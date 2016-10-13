package com.eclink.hgpj.setting.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.setting.dao.KeyEvaluatorDao;
import com.eclink.hgpj.setting.vo.KeyEvaluatorVO;

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
public class KeyEvaluatorDaoImpl extends SqlMapClientDaoSupport implements KeyEvaluatorDao {

	@Override
	public void delete(BaseVO vo) throws Exception {
		this.getSqlMapClientTemplate().delete("KEY_EVALUATOR.deleteKeyEvaluator",vo);
	}

	@Override
	public int insert(BaseVO vo) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().insert("KEY_EVALUATOR.insertKeyEvaluator",vo);
	}

	@Override
	public void modify(BaseVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("KEY_EVALUATOR.modifyKeyEvaluator",vo);
	}

	@Override
	public KeyEvaluatorVO queryById(int id) throws Exception {
		return (KeyEvaluatorVO)this.getSqlMapClientTemplate().queryForObject("KEY_EVALUATOR.queryById", id);
	}

	@Override
	public List<KeyEvaluatorVO> queryList(KeyEvaluatorVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("KEY_EVALUATOR.queryList", vo);
	}

	@Override
	public int queryListCount(KeyEvaluatorVO vo) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("KEY_EVALUATOR.queryListCount", vo);
	}

	@Override
	public KeyEvaluatorVO queryByKeyNo(String keyNo) throws Exception {
		return (KeyEvaluatorVO) this.getSqlMapClientTemplate().queryForObject(
				"KEY_EVALUATOR.queryByKeyNo", keyNo);
	}

}
