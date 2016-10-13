package com.eclink.hgpj.user.biz;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.eclink.hgpj.user.dao.UserDao;
import com.eclink.hgpj.user.vo.UserRoleVO;
import com.eclink.hgpj.user.vo.UserVO;

/**
 * UserServiceImpl.java
 *
 * @Title: 用户管理业务接口实现类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 17, 2013 3:36:05 PM
 *
 */
public class UserServiceImpl implements UserService {
	/**
	 * 用户数据访问接口
	 */
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void delete(UserVO user) throws Exception {
		// 更新用户状态为“DELETED”
		userDao.updateUserStatus(user);
		// 删除用户角色
		userDao.deleteUserRole(user.getUserId());
	}

	@Override
	public boolean existUserName(String userName) throws Exception {
		return (userDao.queryUserByUserName(userName)) == null ? false : true;
	}

	@Override
	public void insert(UserVO user, String[] roleIds, File photo,
			String saveFilePath) throws Exception {
		// 新增用户
		int userId = userDao.insertUser(user);
		// 新增用户角色
		if (null != roleIds && roleIds.length > 0) {
			for (String roleId : roleIds) {
				UserRoleVO userRole = new UserRoleVO();
				userRole.setUserId(userId);
				userRole.setRoleId(Integer.parseInt(roleId));
				userDao.insertUserRole(userRole);
			}
		}
		// 保存关员图片至服务器指定目录
		if (null != photo) {
			FileUtils.copyFile(photo, new File(saveFilePath));
		}
	}

	@Override
	public void modify(UserVO user, String[] roleIds, File photo,
			String saveFilePath) throws Exception {
		// 修改用户信息
		userDao.modifyUser(user);
		// 删除用户角色
		userDao.deleteUserRole(user.getUserId());
		// 新增用户角色
		if (null != roleIds && roleIds.length > 0) {
			for (String roleId : roleIds) {
				UserRoleVO userRole = new UserRoleVO();
				userRole.setUserId(user.getUserId());
				userRole.setRoleId(Integer.parseInt(roleId));
				userDao.insertUserRole(userRole);
			}
		}
		// 是否上传照片
		if (null != photo) {
			if (!StringUtils.isBlank(user.getPhoto())) {
				// 先删除历史照片在上传新照片
				File file = new File(saveFilePath);
				if (file.exists()) {
					boolean flag = file.delete();
					if(!flag) {
						throw new Exception(
						"Update user info,but delete old photo failed.");
					}
				}
			}
			// 上传新照片
			FileUtils.copyFile(photo, new File(saveFilePath));
		}
	}

	@Override
	public UserVO queryUserById(int id) throws Exception {
		return userDao.queryUserById(id);
	}

	@Override
	public List<UserVO> queryUserList(UserVO user) throws Exception {
		return userDao.queryUserList(user);
	}

	@Override
	public int queryUserListCount(UserVO user) throws Exception {
		return userDao.queryUserListCount(user);
	}

	@Override
	public UserVO queryUserByUserName(String userName) throws Exception {
		return userDao.queryUserByUserName(userName);
	}

	@Override
	public Map<String, Object> getOperAddressOfLoginUser(int userId)
			throws Exception {
		List<Map<String, Object>> operAddresses = userDao.getOperAddressOfLoginUser(userId);
		Map<String, Object> result = new HashMap<String, Object>();
		if (operAddresses != null && operAddresses.size() > 0) {
			for (Map<String, Object> map : operAddresses) {
				String url = (String) map.get("URL");
				result.put(url, null);
			}
		}
		return result;
	}

	@Override
	public Map<String, Object> getResOperOfLoginUser(int userId)
			throws Exception {
		List<Map<String,Object>> resOpers = userDao.getResOperOfLoginUser(userId);
		Map<String,Object> result = new HashMap<String,Object>();
		if (resOpers != null && resOpers.size() > 0) {
			for (Map<String, Object> map : resOpers) {
				String menuKey = (String) map.get("MENUKEY");
				String operKey = (String) map.get("OPERKEY");
				result.put(menuKey + "|" + operKey, null);
			}
		}
		return result;
	}

	@Override
	public void modifyUserInfo(UserVO user, File photo, String saveFilePath)
			throws Exception {
		// 修改用户信息
		userDao.modifyUser(user);
		// 是否上传照片
		if (null != photo) {
			if (!StringUtils.isBlank(user.getPhoto())) {
				// 先删除历史照片在上传新照片
				File file = new File(saveFilePath);
				if (file.exists()) {
					boolean flag = file.delete();
					if(!flag) {
						throw new Exception(
						"Update user info,but delete old photo failed.");
					}
				}
			}
			// 上传新照片
			FileUtils.copyFile(photo, new File(saveFilePath));
		}
	}

}
