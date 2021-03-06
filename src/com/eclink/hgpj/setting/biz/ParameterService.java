package com.eclink.hgpj.setting.biz;

import java.util.List;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.setting.vo.ParameterVO;

/**
 * 参数设置Service
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
public interface ParameterService {
	/**
	 * 增加
	 *  
	 * @param vo 操作值对象
	 * @return int 主键ID
	 * @throws Exception
	 */
	public int insert(BaseVO vo) throws Exception;
	/**
	 * 批量增加， 如果存在ID，则修改
	 *  
	 * @param vo 操作值数组对象
	 * @throws Exception
	 */
	public void insertList(List<ParameterVO> vos) throws Exception;
	
	/**
	 * 修改
	 *  
	 * @param vo 操作值对象
	 * @throws Exception
	 */
	public void modify(BaseVO vo) throws Exception;
	
	/**
	 * 删除
	 * 
	 * @param vo 操作值对象
	 * @throws Exception
	 */
	public void delete(BaseVO vo) throws Exception;
	/**
	 * 根据ID查询
	 *  
	 * @param id 主键ID
	 * @return ParameterVO
	 * @throws Exception
	 */
	public ParameterVO queryById(int id) throws Exception;
	
	/**
	 * 根据Name查询
	 *  
	 * @param name 常量里设置的参数名 如：HGPJConstant.PARAMETER_ID_TIME
	 * @return ParameterVO
	 * @throws Exception
	 */
	public ParameterVO queryByName(String name) throws Exception;
	
	/**
	 * 根据条件查询列表
	 *  
	 * @param ParameterVO 查询实体
	 * @return List<ParameterVO>
	 * @throws Exception
	 */
	public List<ParameterVO> queryList(ParameterVO vo) throws Exception;
	/**
	 * 根据条件查询列表总条数
	 *  
	 * @param ParameterVO 查询实体
	 * @return int 总条数
	 * @throws Exception
	 */
	public int queryListCount(ParameterVO vo) throws Exception;
}
