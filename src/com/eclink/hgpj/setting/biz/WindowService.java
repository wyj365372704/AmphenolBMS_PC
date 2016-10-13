package com.eclink.hgpj.setting.biz;

import java.util.List;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.setting.vo.WindowVO;

/**
 * 窗口设置Window
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
public interface WindowService {
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
