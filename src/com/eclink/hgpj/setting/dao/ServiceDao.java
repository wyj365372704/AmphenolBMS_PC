package com.eclink.hgpj.setting.dao;

import java.util.List;

import com.eclink.hgpj.base.BaseDao;
import com.eclink.hgpj.setting.vo.ServiceVO;

/**
 * 业务管理Dao
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
public interface ServiceDao extends BaseDao {
	/**
	 * 根据ID查询
	 *  
	 * @param id 主键ID
	 * @return ServiceVO
	 * @throws Exception
	 */
	public ServiceVO queryById(int id) throws Exception;
	/**
	 * 根据条件查询列表
	 *  
	 * @param ServiceVO 查询实体
	 * @return List<ServiceVO>
	 * @throws Exception
	 */
	public List<ServiceVO> queryList(ServiceVO vo) throws Exception;
	/**
	 * 根据条件查询列表总条数
	 *  
	 * @param ServiceVO 查询实体
	 * @return int 总条数
	 * @throws Exception
	 */
	public int queryListCount(ServiceVO vo) throws Exception;
}
