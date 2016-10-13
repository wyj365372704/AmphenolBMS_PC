package com.eclink.hgpj.user.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.eclink.dfcm.paginator.common.PaginatorUtil;
import com.eclink.dfcm.paginator.tag.PageVO;
import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJConfig;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.dictionary.DictCache;
import com.eclink.hgpj.dictionary.vo.DictionaryVO;
import com.eclink.hgpj.organization.biz.OrgService;
import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.role.biz.RoleService;
import com.eclink.hgpj.role.vo.RoleVO;
import com.eclink.hgpj.user.biz.UserService;
import com.eclink.hgpj.user.vo.UserVO;
import com.eclink.hgpj.util.Utils;

/**
 * UserAction.java
 *
 * @Title: 用户管理控制类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 17, 2013 4:12:25 PM
 *
 */
public class UserAction extends BaseAction {
	
	private static final Logger log = Logger.getLogger(UserAction.class);
	
	/**
	 * 用户管理业务接口
	 */
	private UserService userService;
	
	/**
	 * 组织管理业务接口
	 */
	private OrgService orgService;
	
	/**
	 * 角色管理业务接口
	 */
	private RoleService roleService;
	
	/**
	 * 组织下拉数字符串
	 */
	private String orgTreeData = "";
	
	/**
	 * 用户值对象
	 */
	private UserVO user = new UserVO();
	
	/**
	 * 用户值列表
	 */
	private List<UserVO> userList;
	
	/**
	 * 关区组织列表
	 */
	private List<OrgVO> customsOrg;
	
	/**
	 * 科室组织列表
	 */
	private List<OrgVO> departmentOrg = new ArrayList<OrgVO>();
	
	/**
	 * 关区角色列表
	 */
	private List<RoleVO> roleList;
	
	/**
	 * 用户角色ID
	 */
	private String[] roleIds;
	
	/**
	 * 关员照片文件
	 */
	private File photo;
	
	/**
	 * 关员照片文件内容类型
	 */
	private String photoContentType;
	
	/**
	 * 关员照片文件名称
	 */
	private String photoFileName;
	
	private InputStream inputStream;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public OrgService getOrgService() {
		return orgService;
	}

	public void setOrgService(OrgService orgService) {
		this.orgService = orgService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public List<UserVO> getUserList() {
		return userList;
	}

	public void setUserList(List<UserVO> userList) {
		this.userList = userList;
	}
	
	public String getOrgTreeData() {
		return orgTreeData;
	}

	public void setOrgTreeData(String orgTreeData) {
		this.orgTreeData = orgTreeData;
	}

	public List<OrgVO> getCustomsOrg() {
		return customsOrg;
	}

	public void setCustomsOrg(List<OrgVO> customsOrg) {
		this.customsOrg = customsOrg;
	}

	public List<RoleVO> getRoleList() {
		return roleList;
	}
	
	public List<OrgVO> getDepartmentOrg() {
		return departmentOrg;
	}

	public void setDepartmentOrg(List<OrgVO> departmentOrg) {
		this.departmentOrg = departmentOrg;
	}

	public void setRoleList(List<RoleVO> roleList) {
		this.roleList = roleList;
	}

	public String[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	/**
	 * 用户列表查询
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		try {
			// 获取分关信息
			customsOrg = orgService.queryCustomsOrg();
			// 判断用户类型，总关查询所有数据，分关根据用户所属组织进行数据查询控制
			if (!isHeadUser()) {
				user.setCustomsId(getCustomsOfLoginUser().getOrgId());
				// 分关根组织查询本关所有，非分关根组织查询本组织及下级组织数据
				if (!getOrgOfLoginUser().getOrgId().equals(getCustomsOfLoginUser().getOrgId())) {
					user.setOrgId(getOrgOfLoginUser().getOrgId());
					departmentOrg = orgService.queryChildOrgByOrgId(getOrgOfLoginUser().getOrgId());
					if (null != departmentOrg && !departmentOrg.isEmpty()) {
						StringBuilder sb = new StringBuilder();
						for (OrgVO org : departmentOrg) {
							sb.append(org.getOrgId()).append(",");
						}
						sb.append(getOrgOfLoginUser().getOrgId());
						user.setOrgIds(sb.toString());
					}
				}
			}
			
			// 获取分页信息
			PageVO page = PaginatorUtil.getPaginator(getRequest());
			setPagination(user,page);
			
			// 查询总记录数
			if (page.isQueryTotal()) {
				page.setTotalRecord(userService.queryUserListCount(user));
			}
			
			// 调用业务方法查询列表
			userList = userService.queryUserList(user);
			
			// 分页对象保存至request
			getRequest().setAttribute(HGPJConstant.PAGE_KEY, page);
		} catch (Exception e) {
			log.error("Query user list occurred error." ,e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 用户详情信息查看
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception {
		try {
			// 调用业务方法获取用户详情信息
			user = userService.queryUserById(user.getUserId());
			user.setDataAccessPermList(DictCache.getInstance().getValidDictList(HGPJConstant.DICT_DATA_ACCESS_PERM));
			// 获取用户角色列表
			roleList = roleService.queryRoleByUserId(user.getUserId());
		} catch (Exception e) {
			log.error("View user information occurred error." ,e);
			return ERROR;
		}
		return "view";
	}
	
	/**
	 * 进入用户新增页面
	 * @return
	 * @throws Exception
	 */
	public String toInsert() throws Exception {
		try {
			// 获取当前登录用户所属关区组织
			int orgId = getCustomsOfLoginUser().getOrgId();
			// 获取当前用户所属关区及所有下级组织机构
			List<OrgVO> list = orgService.queryOrgTreeById(orgId);
			if (null != list && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					OrgVO org = list.get(i);
					orgTreeData +="{id:"+org.getOrgId()+",pId:"+org.getParentOrg()+",name:\""+org.getOrgName()+"\"}";
					if (i<list.size()-1)
						orgTreeData += ",";
				}
			}
			// 控制用户报表数据访问权限，取当前登录用户的为基准
			String dataAccessPerm = getLoginUser().getDataAccessPerm();
			user.setDataAccessPermList(processDataAccessPermList(dataAccessPerm));
		} catch (Exception e) {
			log.error("Into user add page occurred error." ,e);
			return ERROR;
		}
		return "toInsert";
	}
	
	/**
	 * ajax动态获取组织角色列表
	 * @return
	 * @throws Exception
	 */
	public String roleList() throws Exception {
		try {
			// 获取指定组织下的所有角色
			roleList = roleService.queryRoleByOrgId(user.getOrgId());
		} catch (Exception e) {
			log.error("Ajax get role list occurred error.", e);
			return ERROR;
		}
		return "roleList";
	}
	
	/**
	 * 用户新增
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		try {
			// 检查用户名是否已经存在
			boolean isExist = userService.existUserName(user.getUserName());
			if (isExist) {
				setErrorMsg("用户名'"+user.getUserName()+"'已经存在，请重新输入！"); 
				return ERROR;
			}
			// 根据用户所属组织获取所属关区
			OrgVO customs = orgService.queryParentOrgById(user.getOrgId());
			user.setCustomsId(customs.getOrgId());
			user.setCreateUser(getLoginUser().getUserName());
			// 关员照片完整路径
			String saveFilePath = null;
			if (!StringUtils.isBlank(this.photoFileName)) {
				String fileName = user.getEmployeeNumber()
						+ this.photoFileName.substring(photoFileName
								.lastIndexOf("."));
				user.setPhoto(fileName);
				// 关员照片文件保存路径
				saveFilePath = Utils.getUserPath()
						+ File.separator
						+ HGPJConstant.DEFAULT_HGPJ_SYSTEMCODE
						+ File.separator
						+ "photo"
						+ File.separator
						+ fileName;
			}
			// 调用业务方法新增用户
			userService.insert(user, roleIds, photo, saveFilePath);
		} catch (Exception e) {
			log.error("Insert user occurred error." ,e);
			return ERROR;
		}
		setBackUrl("user!list.action");
		return "info";
	}
	
	/**
	 * 进入用户修改页面
	 * @return
	 * @throws Exception
	 */
	public String toModify() throws Exception {
		try {
			// 调用业务方法获取用户详情信息
			user = userService.queryUserById(user.getUserId());
			// 获取用户所属组织的所有角色
			List<RoleVO> roleListOfOrg = roleService.queryRoleByOrgId(user.getOrgId());
			// 获取用户角色列表
			roleList = roleService.queryRoleByUserId(user.getUserId());
			if (null != roleList && !roleList.isEmpty()) {
				for (RoleVO role : roleList) {
					role.setIsSelected("Y");
				}
			}
			roleList = Utils.mergerList(roleListOfOrg, roleList);
			// 获取当前登录用户所属关区组织
			int orgId = getCustomsOfLoginUser().getOrgId();
			// 获取当前用户所属关区及所有下级组织机构
			List<OrgVO> list = orgService.queryOrgTreeById(orgId);
			if (null != list && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					OrgVO org = list.get(i);
					orgTreeData +="{id:"+org.getOrgId()+",pId:"+org.getParentOrg()+",name:\""+org.getOrgName()+"\"}";
					if (i<list.size()-1)
						orgTreeData += ",";
				}
			}
			// 控制用户报表数据访问权限，取被修改用户与当前登录用户较大的为基准
			String modifyUser = user.getDataAccessPerm();
			String loginUser = getLoginUser().getDataAccessPerm();
			user.setDataAccessPermList(processDataAccessPermList(permEqual(
					modifyUser, loginUser)));
		} catch (Exception e) {
			log.error("Into user modify page occurred error." ,e);
			return ERROR;
		}
		return "toModify";
	}
	
	/**
	 * 用户修改
	 * @return
	 * @throws Exception
	 */
	public String modify() throws Exception {
		try {
			// 根据用户所属组织获取所属关区
			OrgVO customs = orgService.queryParentOrgById(user.getOrgId());
			user.setCustomsId(customs.getOrgId());
			user.setLastUpdateUser(getLoginUser().getUserName());
			// 关员照片完整路径
			String saveFilePath = null;
			if (!StringUtils.isBlank(this.photoFileName)) {
				String fileName = user.getEmployeeNumber()
						+ this.photoFileName.substring(photoFileName
								.lastIndexOf("."));
				user.setPhoto(fileName);
				// 关员照片文件保存路径
				saveFilePath = Utils.getUserPath()
						+ File.separator
						+ HGPJConstant.DEFAULT_HGPJ_SYSTEMCODE
						+ File.separator
						+ "photo"
						+ File.separator
						+ fileName;
			}
			// 调用业务方法修改用户
			userService.modify(user, roleIds, photo, saveFilePath);
		} catch (Exception e) {
			log.error("Modify user occurred error." ,e);
			return ERROR;
		}
		setBackUrl("user!list.action");
		return "info";
	}
	
	/**
	 * 用户删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		try {
			if (user.getUserId().equals(getLoginUser().getUserId())) {
				setErrorMsg("不允许删除自己账户！");
				return ERROR;
			}
			// 设置用户基础信息
			user.setStatus(HGPJConstant.USER_STATUS_D);
			user.setLastUpdateUser(getLoginUser().getUserName());
			// 调用业务方法删除用户
			userService.delete(user);
		} catch (Exception e) {
			log.error("Delete user occurred error." ,e);
			return ERROR;
		}
		setBackUrl("user!list.action");
		return "info";
	}
	
	/**
	 * 查看关员图片
	 * @return
	 * @throws Exception
	 */
	public String viewPhoto() throws Exception {
		try {
			// 获取用户详细信息
			user = userService.queryUserById(user.getUserId());
			String photoPath;
			if (StringUtils.isBlank(user.getPhoto())) {
				// 获取默认图片显示路径
				photoPath = getSession().getServletContext().getRealPath(
						"images")
						+ File.separator + "user_picture.jpg";
			} else {
				// 获取关员图片详细路径信息（保存在$TOMCAT_HOME/bin/HGPJ/photo下）
				photoPath = Utils.getUserPath() + File.separator
						+ HGPJConstant.DEFAULT_HGPJ_SYSTEMCODE + File.separator
						+ "photo" + File.separator + user.getPhoto();
			}
			// 检查文件是否在本应用服务器上，如果不在则使用代理访问其他应用服务器
			File photoFile = new File(photoPath);
			if (photoFile.exists()) {
				// 响应关员图片文件流
				inputStream = new FileInputStream(photoFile);
			} else {
				// 获取应用部署的另外一台服务器
				String server = HGPJConfig.getInstance().getDeployServers();
				if (log.isDebugEnabled()) {
					log.debug("关员图片" + user.getPhoto() + "未保存在本应用服务器上，从服务器【 "
							+ server + "】上获取。");
				}
				if (!StringUtils.isBlank(server)) {
					StringBuffer httpUrl = new StringBuffer();
					httpUrl.append("http://");
					httpUrl.append(server);
					httpUrl.append(getRequest().getContextPath());
					httpUrl.append("/photoProxy?photoName=");
					httpUrl.append(user.getPhoto());
					if (log.isDebugEnabled()) {
						log.debug("发送HTTP请求: " + httpUrl.toString());
					}
					HttpURLConnection httpConn = null;
					try {
						URL url = new URL(httpUrl.toString());
						httpConn = (HttpURLConnection) url.openConnection();
						httpConn.setUseCaches(false);
						httpConn.setDoInput(true);
						httpConn.setDoOutput(true);
						httpConn.setRequestMethod("POST");
						int responseCode = httpConn.getResponseCode();
						if (responseCode == 200) {
							if (log.isDebugEnabled()) {
								log.debug("关员图片" + user.getPhoto() + "读取成功。");
							}
							inputStream = httpConn.getInputStream();
						}
					} catch (Exception e) {
						log.error("发送HTTP请求至" + httpUrl + "发生错误.", e);
					}
				}
			}
		} catch (Exception e) {
			log.error("View photo occured error.", e);
		}
		return "img";
	}
	
	/**
	 * 进入修改用户个人信息页面
	 * @return
	 * @throws Exception
	 */
	public String toModifyUserInfo()throws Exception {
		try {
			// 获取当前登录用户信息
			user = userService.queryUserById(getLoginUser().getUserId());
			user.setDataAccessPermList(DictCache.getInstance().getValidDictList(HGPJConstant.DICT_DATA_ACCESS_PERM));
		} catch (Exception e) {
			log.error("toModifyUserInfo user error." ,e);
			return ERROR;
		}
		return "userInfo";
	}
	
	/**
	 * 修改用户个人信息
	 * @return
	 * @throws Exception
	 */
	public String modifyUserInfo()throws Exception {
		try {
			// 根据用户所属组织获取所属关区
			OrgVO customs = orgService.queryParentOrgById(user.getOrgId());
			user.setCustomsId(customs.getOrgId());
			user.setLastUpdateUser(getLoginUser().getUserName());
			// 关员照片完整路径
			String saveFilePath = null;
			if (!StringUtils.isBlank(this.photoFileName)) {
				String fileName = user.getEmployeeNumber()
						+ this.photoFileName.substring(photoFileName
								.lastIndexOf("."));
				user.setPhoto(fileName);
				// 关员照片文件保存路径
				saveFilePath = Utils.getUserPath()
						+ File.separator
						+ HGPJConstant.DEFAULT_HGPJ_SYSTEMCODE
						+ File.separator
						+ "photo"
						+ File.separator
						+ fileName;
			}
			// 修改用户信息
			userService.modifyUserInfo(user, photo, saveFilePath);
		} catch (Exception e) {
			log.error("modifyUserInfo error.",e);
		}
		return "info";
	}
	
	/**
	 * 根据数据访问权限字符串，控制数据访问权限下拉选项
	 * @param dataAccessPerm
	 * @return
	 */
	private List processDataAccessPermList(String dataAccessPerm) {
		List<DictionaryVO> dataAccessPermList = DictCache.getInstance().getValidDictList(HGPJConstant.DICT_DATA_ACCESS_PERM);
		if (!dataAccessPermList.isEmpty()) {
			Iterator it = dataAccessPermList.iterator();
			if (HGPJConstant.DATA_ACCESS_PERM_P.equals(dataAccessPerm)) {
				while (it.hasNext()) {
					DictionaryVO vo = (DictionaryVO)it.next();
					if(vo.getKey().equals(HGPJConstant.DATA_ACCESS_PERM_A)) {
						it.remove();
					}
				}
			} else if (HGPJConstant.DATA_ACCESS_PERM_O.equals(dataAccessPerm)) {
				while (it.hasNext()) {
					DictionaryVO vo = (DictionaryVO)it.next();
					if (vo.getKey().equals(HGPJConstant.DATA_ACCESS_PERM_A)
							|| vo.getKey().equals(
									HGPJConstant.DATA_ACCESS_PERM_P)) {
						it.remove();
					}
				}
			} else if (HGPJConstant.DATA_ACCESS_PERM_N.equals(dataAccessPerm)) {
				while (it.hasNext()) {
					DictionaryVO vo = (DictionaryVO) it.next();
					if (vo.getKey().equals(HGPJConstant.DATA_ACCESS_PERM_A)
							|| vo.getKey().equals(
									HGPJConstant.DATA_ACCESS_PERM_P)
							|| vo.getKey().equals(
									HGPJConstant.DATA_ACCESS_PERM_O)) {
						it.remove();
					}
				}
			}
		}
		return dataAccessPermList;
	}
	
	/**
	 * 比较数据访问权限，返回较大的数据访问权限字符串
	 * @param one
	 * @param two
	 * @return
	 */
	private String permEqual(String one, String two) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put(HGPJConstant.DATA_ACCESS_PERM_A, 4);
		map.put(HGPJConstant.DATA_ACCESS_PERM_P, 3);
		map.put(HGPJConstant.DATA_ACCESS_PERM_O, 2);
		map.put(HGPJConstant.DATA_ACCESS_PERM_N, 1);
		Integer num1 = map.get(one);
		Integer num2 = map.get(two);
		return num1 > num2 ? one : two;
	}
}
