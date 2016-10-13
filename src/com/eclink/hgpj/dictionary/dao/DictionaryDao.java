package com.eclink.hgpj.dictionary.dao;

import java.util.List;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.dictionary.vo.DictionaryVO;

/**
 * DictionaryDao.java
 *
 * @Title: 数据字典DAO接口
 * @Description: 
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date Nov 9, 2011 7:40:12 PM
 *
 */
public interface DictionaryDao {
	
	
	/**
	 * 查询所有有效的数据字典列表信息
	 * @param vo 参数类
	 * @return List<Dictionary>
	 * @throws Exception
	 */
	public List<DictionaryVO> queryDictonaryList(BaseVO vo) throws Exception;
	
	/**
	 * 查询数据字典代码类列列表
	 * @param vo 数据字典vo对象
	 * @return
	 * @throws Exception
	 */
	public List<DictionaryVO> queryDictionaryCodeType(DictionaryVO vo) throws Exception;
	
	/**
	 * 查询数据字典代码类列总记录数
	 * @param vo 数据字典vo对象
	 * @return
	 * @throws Exception
	 */
	public int queryDictionaryCodeTypeCount(DictionaryVO vo) throws Exception;
}
