package com.eclink.hgpj.setting.dao;

import java.util.List;

import com.eclink.hgpj.base.BaseDao;
import com.eclink.hgpj.setting.vo.EvaluationVO;

/**
 * 前台评价建议Dao
 *
 * @Title:
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 周灵舟
 * @version 1.0
 * @date May 16, 2013 11:05:21 AM
 *
 */
public interface EvaluationDao extends BaseDao {
	/**
	 * 根据条件查询列表总条数
	 *  
	 * @param EvaluationVO 查询实体
	 * @return int 总条数
	 * @throws Exception
	 */
	public int queryListCount(EvaluationVO vo) throws Exception;
	/**
	 * 根据条件查询列表
	 *  
	 * @param EvaluationVO 查询实体
	 * @return int 总条数
	 * @throws Exception
	 */
	public List<EvaluationVO> queryList(EvaluationVO vo) throws Exception;
	
	/**
	 * 新增按键式评价数据
	 * @param vo 数据实体类
	 * @throws Exception
	 */
	public void insertKeyEvaluation(EvaluationVO vo) throws Exception;
}
