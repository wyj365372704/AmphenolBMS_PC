package com.eclink.hgpj.user.biz;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.eclink.hgpj.resource.vo.ZBMSU02VO;
import com.eclink.hgpj.user.dao.AUserDao;
import com.eclink.hgpj.user.dao.UserDao;
import com.eclink.hgpj.user.vo.AUserVO;
import com.eclink.hgpj.user.vo.UserRoleVO;
import com.eclink.hgpj.user.vo.UserVO;

/**
 * UserServiceImpl.java
 *
 * @Title: 用户管理业务接口实现类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.

 * @version 1.0
 * @date May 17, 2013 3:36:05 PM
 *
 */
public class AUserServiceImpl implements AUserService {
	private AUserDao auserDao;
	


	public AUserDao getAuserDao() {
		return auserDao;
	}

	public void setAuserDao(AUserDao auserDao) {
		this.auserDao = auserDao;
	}

	@Override
	public AUserVO queryUserByUserName(String userName) throws Exception {
		return auserDao.queryUserByUserName(userName);
	}

	@Override
	public List<ZBMSU02VO> queryDeptByUserName(String username) throws Exception {
		return auserDao.queryDeptByUserName(username);
	}

}
