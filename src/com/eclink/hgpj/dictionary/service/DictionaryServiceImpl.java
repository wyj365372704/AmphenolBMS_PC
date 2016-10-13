package com.eclink.hgpj.dictionary.service;

import java.util.List;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.dictionary.dao.DictionaryDao;
import com.eclink.hgpj.dictionary.vo.DictionaryVO;

/**
 * DictionaryServiceImpl.java
 *
 * @Title: 数据字典业务实现类
 * @Description: 
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date Nov 10, 2011 9:49:57 AM
 *
 */
public class DictionaryServiceImpl implements DictionaryService {
	
	/** 数据字典Dao */
	private DictionaryDao dictionaryDao;	

	public DictionaryDao getDictionaryDao() {
		return dictionaryDao;
	}

	public void setDictionaryDao(DictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}

	/**
	 * 查询所有有效的数据字典列表信息
	 * @param vo 参数类
	 * @return List<Dictionary>
	 * @throws Exception
	 */
	public List<DictionaryVO> queryDictonaryList(BaseVO vo) throws Exception {
		return dictionaryDao.queryDictonaryList(vo);
	}

	@Override
	public List<DictionaryVO> queryDictionaryCodeType(DictionaryVO vo)
			throws Exception {
		return dictionaryDao.queryDictionaryCodeType(vo);
	}

	@Override
	public int queryDictionaryCodeTypeCount(DictionaryVO vo) throws Exception {
		return dictionaryDao.queryDictionaryCodeTypeCount(vo);
	}

}
