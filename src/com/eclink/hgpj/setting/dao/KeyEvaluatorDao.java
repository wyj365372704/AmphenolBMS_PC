package com.eclink.hgpj.setting.dao;

import java.util.List;

import com.eclink.hgpj.base.BaseDao;
import com.eclink.hgpj.setting.vo.KeyEvaluatorVO;

/**
 * 按键式评价器设置Dao
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
public interface KeyEvaluatorDao extends BaseDao {
	/**
	 * 根据ID查询
	 *  
	 * @param id 主键ID
	 * @return KeyEvaluatorVO
	 * @throws Exception
	 */
	public KeyEvaluatorVO queryById(int id) throws Exception;
	/**
	 * 根据条件查询列表
	 *  
	 * @param KeyEvaluatorVO 查询实体
	 * @return List<KeyEvaluatorVO>
	 * @throws Exception
	 */
	public List<KeyEvaluatorVO> queryList(KeyEvaluatorVO vo) throws Exception;
	/**
	 * 根据条件查询列表总条数
	 *  
	 * @param KeyEvaluatorVO 查询实体
	 * @return int 总条数
	 * @throws Exception
	 */
	public int queryListCount(KeyEvaluatorVO vo) throws Exception;
	
	/**
	 * 根据keyNo查询
	 *  
	 * @param keyNo 按键式评价器编号
	 * @return KeyEvaluatorVO
	 * @throws Exception
	 */
	public KeyEvaluatorVO queryByKeyNo(String keyNo) throws Exception;
}
