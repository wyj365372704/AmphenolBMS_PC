package com.eclink.hgpj.user.dao;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.user.vo.UserRoleVO;
import com.eclink.hgpj.user.vo.UserVO;

/**
 * UserDao.java
 *
 * @Title: 用户数据库访问接口
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 16, 2013 4:28:36 PM
 *
 */
public interface UserDao {
	/**
	 * 新增用户
	 * @param user 用户值对象
	 * @return 主键ID
	 * @throws Exception
	 */
	public int insertUser(UserVO user) throws Exception;
	
	/**
	 * 删除用户
	 * @param id 用户ID
	 * @throws Exception
	 */
	public void deleteUser(int id) throws Exception;
	
	/**
	 * 修改用户
	 * @param user 用户
	 * @throws Exception
	 */
	public void modifyUser(UserVO user) throws Exception;
	
	/**
	 * 根据条件查询用户列表
	 * @param user 用户值对象
	 * @return
	 * @throws Exception
	 */
	public List<UserVO> queryUserList(UserVO user) throws Exception;
	
	/**
	 * 根据条件查询用户列表总记录数
	 * @param user 用户值对象
	 * @return
	 * @throws Exception
	 */
	public int queryUserListCount(UserVO user) throws Exception;
	
	/**
	 * 根据用户ID查询用户
	 * @param id 用户ID
	 * @return
	 * @throws Exception
	 */
	public UserVO queryUserById(int id) throws Exception;
	
	/**
	 * 根据用户名查询用户
	 * @param userName 用户名
	 * @return
	 * @throws Exception
	 */
	public UserVO queryUserByUserName(String userName) throws Exception;
	
	/**
	 * 新增用户角色
	 * @param usrRole
	 * @throws Exception
	 */
	public void insertUserRole(UserRoleVO userRole) throws Exception;
	
	/**
	 * 删除用户角色
	 * @param userId 用户ID
	 * @throws Exception
	 */
	public void deleteUserRole(int userId) throws Exception;
	
	/**
	 * 删除某组织下的所有用户角色
	 * @param orgId
	 * @throws Exception
	 */
	public void deleteUserRoelByOrgId(int orgId) throws Exception;
	
	/**
	 * 更新用户状态
	 * @param user 用户VO
	 * @throws Exception
	 */
	public void updateUserStatus(UserVO user) throws Exception;
	
	/**
	 * 获取当前登录用户可以访问的操作URL地址
	 * @param userId 用户ID
	 * @return Map列表
	 * @throws Exception
	 */
	public List<Map<String,Object>> getOperAddressOfLoginUser(int userId) throws Exception;
	
	/**
	 * 获取当前登录用户可以访问的菜单资源操作
	 * @param userId 用户ID
	 * @return Map列表 
	 * @throws Exception
	 */
	public List<Map<String,Object>> getResOperOfLoginUser(int userId) throws Exception;
}
