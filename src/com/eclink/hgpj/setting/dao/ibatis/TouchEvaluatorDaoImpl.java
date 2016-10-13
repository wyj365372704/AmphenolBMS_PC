package com.eclink.hgpj.setting.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.setting.dao.TouchEvaluatorDao;
import com.eclink.hgpj.setting.vo.TouchEvaluatorVO;

/**
 * TouchEvaluatorDaoImpl.java
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
public class TouchEvaluatorDaoImpl extends SqlMapClientDaoSupport implements TouchEvaluatorDao {

	@Override
	public void delete(BaseVO vo) throws Exception {
		this.getSqlMapClientTemplate().delete("TOUCH_EVALUATOR.deleteTouchEvaluator",vo);
	}

	@Override
	public int insert(BaseVO vo) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().insert("TOUCH_EVALUATOR.insertTouchEvaluator",vo);
	}

	@Override
	public void modify(BaseVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("TOUCH_EVALUATOR.modifyTouchEvaluator",vo);
	}

	@Override
	public TouchEvaluatorVO queryById(int id) throws Exception {
		return (TouchEvaluatorVO)this.getSqlMapClientTemplate().queryForObject("TOUCH_EVALUATOR.queryById", id);
	}

	@Override
	public TouchEvaluatorVO queryByTouchNo(String touchNo) throws Exception {
		return (TouchEvaluatorVO)this.getSqlMapClientTemplate().queryForObject("TOUCH_EVALUATOR.queryByTouchNo", touchNo);
	}

	@Override
	public List<TouchEvaluatorVO> queryList(TouchEvaluatorVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("TOUCH_EVALUATOR.queryList", vo);
	}

	@Override
	public int queryListCount(TouchEvaluatorVO vo) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("TOUCH_EVALUATOR.queryListCount", vo);
	}

}
