package com.eclink.hgpj.user.dao;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ZBMSU02VO;
import com.eclink.hgpj.user.vo.AUserVO;
import com.eclink.hgpj.user.vo.UserRoleVO;
import com.eclink.hgpj.user.vo.UserVO;

/**
 * UserDao.java
 *
 * @Title: 用户数据库访问接口
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @version 1.0
 * @date May 16, 2013 4:28:36 PM
 *
 */
public interface AUserDao {
	
	
	/**
	 * 根据用户名查询用户
	 * @param userName 用户名
	 * @return
	 * @throws Exception
	 */
	public AUserVO queryUserByUserName(String userName) throws Exception;
	
	public List<ZBMSU02VO> queryDeptByUserName(String username) throws Exception;
	
}
