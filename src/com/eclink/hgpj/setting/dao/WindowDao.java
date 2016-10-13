package com.eclink.hgpj.setting.dao;

import java.util.List;

import com.eclink.hgpj.base.BaseDao;
import com.eclink.hgpj.setting.vo.WindowVO;

/**
 * 窗口设置Dao
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
public interface WindowDao extends BaseDao {
	/**
	 * 根据ID查询
	 *  
	 * @param id 主键ID
	 * @return WindowVO
	 * @throws Exception
	 */
	public WindowVO queryById(int id) throws Exception;
	/**
	 * 根据条件查询列表
	 *  
	 * @param WindowVO 查询实体
	 * @return List<WindowVO>
	 * @throws Exception
	 */
	public List<WindowVO> queryList(WindowVO vo) throws Exception;
	/**
	 * 根据条件查询列表总条数
	 *  
	 * @param WindowVO 查询实体
	 * @return int 总条数
	 * @throws Exception
	 */
	public int queryListCount(WindowVO vo) throws Exception;
}
