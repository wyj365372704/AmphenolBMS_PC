package com.eclink.hgpj.setting.biz;

import java.util.List;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.setting.dao.KeyEvaluatorDao;
import com.eclink.hgpj.setting.vo.KeyEvaluatorVO;

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
public class KeyEvaluatorServiceImpl implements KeyEvaluatorService {
	private KeyEvaluatorDao keyEvaluatorDao;
	
	public void setKeyEvaluatorDao(KeyEvaluatorDao keyEvaluatorDao) {
		this.keyEvaluatorDao = keyEvaluatorDao;
	}

	@Override
	public void delete(BaseVO vo) throws Exception {
		keyEvaluatorDao.delete(vo);
	}

	@Override
	public int insert(BaseVO vo) throws Exception {
		return keyEvaluatorDao.insert(vo);
	}

	@Override
	public void modify(BaseVO vo) throws Exception {
		keyEvaluatorDao.modify(vo);
	}

	@Override
	public KeyEvaluatorVO queryById(int id) throws Exception {
		return keyEvaluatorDao.queryById(id);
	}

	@Override
	public List<KeyEvaluatorVO> queryList(KeyEvaluatorVO vo) throws Exception {
		return keyEvaluatorDao.queryList(vo);
	}

	@Override
	public int queryListCount(KeyEvaluatorVO vo) throws Exception {
		return keyEvaluatorDao.queryListCount(vo);
	}

	@Override
	public KeyEvaluatorVO queryByKeyNo(String keyNo) throws Exception {
		return keyEvaluatorDao.queryByKeyNo(keyNo);
	}

}
