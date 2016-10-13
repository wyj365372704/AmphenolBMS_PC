package com.eclink.hgpj.user.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.role.vo.RoleVO;
import com.eclink.hgpj.user.dao.UserDao;
import com.eclink.hgpj.user.vo.UserRoleVO;
import com.eclink.hgpj.user.vo.UserVO;

/**
 * UserDaoImpl.java
 *
 * @Title: 用户数据库访问接口实现类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 16, 2013 4:49:59 PM
 *
 */
public class UserDaoImpl extends SqlMapClientDaoSupport implements UserDao {

	@Override
	public void deleteUser(int id) throws Exception {
		this.getSqlMapClientTemplate().delete("User.delete", id);
	}

	@Override
	public int insertUser(UserVO user) throws Exception {
		return ((Integer)this.getSqlMapClientTemplate().insert("User.insert", user)).intValue();
	}

	@Override
	public UserVO queryUserById(int id) throws Exception {
		return (UserVO)this.getSqlMapClientTemplate().queryForObject("User.queryUserById", id);
	}

	@Override
	public UserVO queryUserByUserName(String userName) throws Exception {
		return (UserVO)this.getSqlMapClientTemplate().queryForObject("User.queryUserByUserName", userName);
	}

	@Override
	public List<UserVO> queryUserList(UserVO user) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("User.queryUserList", user);
	}

	@Override
	public int queryUserListCount(UserVO user) throws Exception {
		return ((Integer)this.getSqlMapClientTemplate().queryForObject("User.queryUserListCount", user)).intValue();
	}

	@Override
	public void modifyUser(UserVO user) throws Exception {
		this.getSqlMapClientTemplate().update("User.update", user);
	}

	@Override
	public void deleteUserRole(int userId) throws Exception {
		this.getSqlMapClientTemplate().delete("User.deleteUserRole", userId);
	}

	@Override
	public void insertUserRole(UserRoleVO userRole) throws Exception {
		this.getSqlMapClientTemplate().insert("User.insertUserRole", userRole);
	}

	@Override
	public void updateUserStatus(UserVO user) throws Exception {
		this.getSqlMapClientTemplate().update("User.updateUserStatus", user);
	}

	@Override
	public void deleteUserRoelByOrgId(int orgId) throws Exception {
		this.getSqlMapClientTemplate().delete("User.deleteUserRoleByOrgId", orgId);
	}

	@Override
	public List<Map<String, Object>> getOperAddressOfLoginUser(int userId)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("User.getOperAddressOfLoginUser", userId);
	}

	@Override
	public List<Map<String, Object>> getResOperOfLoginUser(int userId)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("User.getResOperOfLoginUser", userId);
	}

}
