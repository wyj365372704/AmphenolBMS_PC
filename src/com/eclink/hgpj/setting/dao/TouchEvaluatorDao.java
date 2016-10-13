package com.eclink.hgpj.setting.dao;

import java.util.List;

import com.eclink.hgpj.base.BaseDao;
import com.eclink.hgpj.setting.vo.TouchEvaluatorVO;

/**
 * 触摸式设置Dao
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
public interface TouchEvaluatorDao extends BaseDao {
	/**
	 * 根据ID查询
	 *  
	 * @param id 主键ID
	 * @return TouchEvaluatorVO
	 * @throws Exception
	 */
	public TouchEvaluatorVO queryById(int id) throws Exception;
	/**
	 * 根据触摸式评价器编号（IP）查询
	 *  
	 * @param id 主键ID
	 * @return TouchEvaluatorVO
	 * @throws Exception
	 */
	public TouchEvaluatorVO queryByTouchNo(String touchNo) throws Exception;
	/**
	 * 根据条件查询列表
	 *  
	 * @param TouchEvaluatorVO 查询实体
	 * @return List<TouchEvaluatorVO>
	 * @throws Exception
	 */
	public List<TouchEvaluatorVO> queryList(TouchEvaluatorVO vo) throws Exception;
	/**
	 * 根据条件查询列表总条数
	 *  
	 * @param TouchEvaluatorVO 查询实体
	 * @return int 总条数
	 * @throws Exception
	 */
	public int queryListCount(TouchEvaluatorVO vo) throws Exception;
}
