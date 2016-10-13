package com.eclink.hgpj.base;
/**
 * BaseDao.java
 *
 * @Title: 数据访问对象基类
 * @Description: 为其它数据访问对象提供基本的增、删、改方法声明
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date Nov 9, 2011 3:09:59 PM
 *
 */
public interface BaseDao {
	
	/**
	 * 增加操作
	 *  
	 * @param vo 操作值对象
	 * @return int 主键ID
	 * @throws Exception
	 */
	public int insert(BaseVO vo) throws Exception;
	
	/**
	 * 修改操作
	 *  
	 * @param vo 操作值对象
	 * @throws Exception
	 */
	public void modify(BaseVO vo) throws Exception;
	
	/**
	 * 删除操作
	 *  
	 * @param vo 操作值对象
	 * @throws Exception
	 */
	public void delete(BaseVO vo) throws Exception;
}
