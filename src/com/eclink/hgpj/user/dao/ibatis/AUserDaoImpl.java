package com.eclink.hgpj.user.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.resource.vo.ZBMSU02VO;
import com.eclink.hgpj.user.dao.AUserDao;
import com.eclink.hgpj.user.vo.AUserVO;
import com.eclink.hgpj.user.vo.UserVO;

/**
 * UserDaoImpl.java
 *
 * @Title: 用户数据库访问接口实现类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @version 1.0
 * @date May 16, 2013 4:49:59 PM
 *
 */
public class AUserDaoImpl extends SqlMapClientDaoSupport implements AUserDao {

	@Override
	public AUserVO queryUserByUserName(String userName) throws Exception {
		return (AUserVO)this.getSqlMapClientTemplate().queryForObject("AUser.queryUserByUserName", userName);
	}

	@Override
	public List<ZBMSU02VO> queryDeptByUserName(String username) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("AUser.queryDeptByUserName", username);
	}

}
