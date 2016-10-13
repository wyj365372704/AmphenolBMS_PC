package com.eclink.hgpj.setting.biz;

import java.util.List;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.setting.vo.CustomsServiceVO;

/**
 * 业务设置Service
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
public interface CustomsServiceService {
	/**
	 * 增加
	 *  
	 * @param vo 操作值对象
	 * @return int 主键ID
	 * @throws Exception
	 */
	public int insert(BaseVO vo) throws Exception;
	
	/**
	 * 修改
	 *  
	 * @param vo 操作值对象
	 * @throws Exception
	 */
	public void modify(BaseVO vo) throws Exception;
	
	/**
	 * 根据关区ID删除所有设置的业务
	 * @param orgId
	 */
	public void deleteServiceByOrgId(int orgId) throws Exception;
	
	/**
	 * 根据OrgID查询
	 *  
	 * @param orgId 关区ID
	 * @return CustomsServiceVO
	 * @throws Exception
	 */
	public List<CustomsServiceVO> queryByOrgId(int id) throws Exception;
	/**
	 * 根据条件查询列表
	 *  
	 * @param CustomsServiceVO 查询实体
	 * @return List<CustomsServiceVO>
	 * @throws Exception
	 */
	public List<CustomsServiceVO> queryList(CustomsServiceVO vo) throws Exception;
	/**
	 * 根据条件查询(前台评价)
	 *  
	 * @param CustomsServiceVO 查询实体
	 * @return CustomsServiceVO
	 * @throws Exception
	 */
	public CustomsServiceVO queryEvaluationByOrgIdAndServiceId(CustomsServiceVO vo) throws Exception;
	/**
	 * 根据条件查询列表（前台评价）
	 *  
	 * @param orgId 关区ID
	 * @return List<CustomsServiceVO>
	 * @throws Exception
	 */
	public List<CustomsServiceVO> queryEvaluationList(Integer orgId) throws Exception;
	/**
	 * 根据条件查询列表总条数
	 *  
	 * @param CustomsServiceVO 查询实体
	 * @return int 总条数
	 * @throws Exception
	 */
	public int queryListCount(CustomsServiceVO vo) throws Exception;
}
