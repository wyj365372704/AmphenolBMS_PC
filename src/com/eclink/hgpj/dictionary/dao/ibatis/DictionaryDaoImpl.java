package com.eclink.hgpj.dictionary.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.dictionary.dao.DictionaryDao;
import com.eclink.hgpj.dictionary.vo.DictionaryVO;

/**
 * DictionaryDaoImpl.java
 *
 * @Title: 数据字典DAO实现类
 * @Description: 
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date Nov 9, 2011 8:10:05 PM
 *
 */
public class DictionaryDaoImpl extends SqlMapClientDaoSupport implements DictionaryDao {

	/**
	 * 查询所有有效的数据字典列表信息
	 * @param vo 参数类
	 * @return List<Dictionary>
	 * @throws Exception
	 */
	public List<DictionaryVO> queryDictonaryList(BaseVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Dictionary.queryDictionaryList", vo);
	}

	@Override
	public List<DictionaryVO> queryDictionaryCodeType(DictionaryVO vo)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Dictionary.queryDictionaryCodeType", vo);
	}

	@Override
	public int queryDictionaryCodeTypeCount(DictionaryVO vo) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("Dictionary.queryDictionaryCodeTypeCount", vo);
	}

}
