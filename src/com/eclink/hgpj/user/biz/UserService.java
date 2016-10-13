package com.eclink.hgpj.user.biz;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.user.vo.UserVO;

/**
 * UserService.java
 *
 * @Title: 用户管理业务接口
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 17, 2013 3:32:21 PM
 *
 */
public interface UserService {
	/**
	 * 新增用户
	 * @param user 用户值对象
	 * @param roleIds 角色ID
	 * @param photo 图片文件
	 * @param saveFilePath 图片文件保存完整路径
	 * @throws Exception
	 */
	public void insert(UserVO user, String[] roleIds, File photo, String saveFilePath) throws Exception;
	
	/**
	 * 删除用户
	 * @param user 用户VO
	 * @throws Exception
	 */
	public void delete(UserVO user) throws Exception;
	
	/**
	 * 修改用户
	 * @param user 用户VO
	 * @param roleIds 角色ID
	 * @param photo 图片文件
	 * @param saveFilePath 图片文件保存完整路径
	 * @throws Exception
	 */
	public void modify(UserVO user, String[] roleIds, File photo, String saveFilePath) throws Exception;
	
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
	 * 检查用户名是否已经存在
	 * @param userName 用户名
	 * @return
	 * @throws Exception
	 */
	public boolean existUserName(String userName) throws Exception;
	
	/**
	 * 根据用户名查询用户
	 * @param userName 用户名
	 * @return
	 * @throws Exception
	 */
	public UserVO queryUserByUserName(String userName) throws Exception;
	
	/**
	 * 获取当前登录用户可以访问的菜单资源操作
	 * @param userId 用户ID
	 * @return 菜单资源操作Map 
	 * @throws Exception
	 */
	public Map<String, Object> getResOperOfLoginUser(int userId) throws Exception;
	
	/**
	 * 获取当前登录用户可以访问的操作URL地址
	 * @param userId 用户ID
	 * @return 操作URL地址Map
	 * @throws Exception
	 */
	public Map<String, Object> getOperAddressOfLoginUser(int userId) throws Exception;
	
	/**
	 * 修改用户信息
	 * @param user 用户VO
	 * @param photo 图片文件
	 * @param saveFilePath 保存文件路径
	 * @throws Exception
	 */
	public void modifyUserInfo(UserVO user, File photo, String saveFilePath)
			throws Exception;
}
