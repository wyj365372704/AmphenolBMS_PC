package com.eclink.hgpj.setting.biz;

import java.util.List;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.setting.dao.EvaluationDao;
import com.eclink.hgpj.setting.vo.EvaluationVO;

/**
 * 按键式Service实现
 *
 * @Title:
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 周灵舟
 * @version 1.0
 * @date May 16, 2013 11:02:57 AM
 *
 */
public class EvaluationServiceImpl implements EvaluationService {
	private EvaluationDao evaluationDao;

	public void setEvaluationDao(EvaluationDao evaluationDao) {
		this.evaluationDao = evaluationDao;
	}

	@Override
	public int insert(BaseVO vo) throws Exception {
		return evaluationDao.insert(vo);
	}

	@Override
	public int queryListCount(EvaluationVO vo) throws Exception {
		return evaluationDao.queryListCount(vo);
	}

	@Override
	public List<EvaluationVO> queryList(EvaluationVO vo) throws Exception {
		return evaluationDao.queryList(vo);
	}

	@Override
	public void insertKeyEvaluation(EvaluationVO vo) throws Exception {
		evaluationDao.insertKeyEvaluation(vo);
	}

}
