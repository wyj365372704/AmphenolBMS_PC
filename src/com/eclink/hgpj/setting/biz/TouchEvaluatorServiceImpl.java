package com.eclink.hgpj.setting.biz;

import java.util.List;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.setting.dao.TouchEvaluatorDao;
import com.eclink.hgpj.setting.vo.TouchEvaluatorVO;

/**
 * 系统设置Service实现
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
public class TouchEvaluatorServiceImpl implements TouchEvaluatorService {
	private TouchEvaluatorDao touchEvaluatorDao;
	
	public void setTouchEvaluatorDao(TouchEvaluatorDao touchEvaluatorDao) {
		this.touchEvaluatorDao = touchEvaluatorDao;
	}

	@Override
	public void delete(BaseVO vo) throws Exception {
		touchEvaluatorDao.delete(vo);
	}

	@Override
	public int insert(BaseVO vo) throws Exception {
		return touchEvaluatorDao.insert(vo);
	}

	@Override
	public void modify(BaseVO vo) throws Exception {
		touchEvaluatorDao.modify(vo);
	}

	@Override
	public TouchEvaluatorVO queryById(int id) throws Exception {
		return touchEvaluatorDao.queryById(id);
	}

	@Override
	public TouchEvaluatorVO queryByTouchNo(String touchNo) throws Exception {
		return touchEvaluatorDao.queryByTouchNo(touchNo);
	}

	@Override
	public List<TouchEvaluatorVO> queryList(TouchEvaluatorVO vo) throws Exception {
		return touchEvaluatorDao.queryList(vo);
	}

	@Override
	public int queryListCount(TouchEvaluatorVO vo) throws Exception {
		return touchEvaluatorDao.queryListCount(vo);
	}

}
