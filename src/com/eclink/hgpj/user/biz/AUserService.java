package com.eclink.hgpj.user.biz;


import java.util.List;

import com.eclink.hgpj.resource.vo.ZBMSU02VO;
import com.eclink.hgpj.user.vo.AUserVO;

/**
 * UserService.java
 *
 * @Title: 用户管理业务接口
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.

 * @version 1.0
 * @date May 17, 2013 3:32:21 PM
 *
 */
public interface AUserService {
	
	
	/**
	 * 根据用户名查询用户
	 * @param userName 用户名
	 * @return
	 * @throws Exception
	 */
	public AUserVO queryUserByUserName(String userName) throws Exception;
	public List<ZBMSU02VO> queryDeptByUserName(String username) throws Exception;

}
