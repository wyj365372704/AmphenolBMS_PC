package com.eclink.hgpj.user.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.common.UserLoginInfo;
import com.eclink.hgpj.organization.biz.OrgService;
import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.resource.biz.MenuService;
import com.eclink.hgpj.resource.biz.ZBMSU01Service;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.ZBMSU01VO;
import com.eclink.hgpj.user.biz.AUserService;
import com.eclink.hgpj.user.biz.UserService;
import com.eclink.hgpj.user.vo.AUserVO;
import com.eclink.hgpj.user.vo.UserVO;

/**
 * LoginAction.java
 *
 * @Title:  用户登录Action
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 25, 2013 1:47:17 PM
 *
 */
public class LoginAction extends BaseAction {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(LoginAction.class);

	/**
	 * 用户VO对象
	 */
	private UserVO user = new UserVO();

	/**
	 * 用户业务接口
	 */
	private UserService userService;

	/**
	 * 组织业务接口
	 */
	private OrgService orgService;

	/**
	 * 菜单业务接口
	 */
	private MenuService menuService;

	private AUserService auserService;

	private ZBMSU01Service zbmsu01Service;
	
	private String env;
	
	private String password;

	/**
	 * 当前登录用户允许访问的菜单树列表
	 */
	private List<MenuVO> menus;
	

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public OrgService getOrgService() {
		return orgService;
	}


	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public void setOrgService(OrgService orgService) {
		this.orgService = orgService;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public List<MenuVO> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuVO> menus) {
		this.menus = menus;
	}

	public AUserService getAuserService() {
		return auserService;
	}

	public void setAuserService(AUserService auserService) {
		this.auserService = auserService;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ZBMSU01Service getZbmsu01Service() {
		return zbmsu01Service;
	}

	public void setZbmsu01Service(ZBMSU01Service zbmsu01Service) {
		this.zbmsu01Service = zbmsu01Service;
	}

	/**
	 * 用户登录
	 * @return
	 * @throws Exception
	 */
	public String userLogin() throws Exception {
		try {
			// 错误信息提示后统一返回登录页面
			setBackUrl("/login.jsp");
			// 检查用户输入
			if (StringUtils.isBlank(env)){
				setErrorMsg("请选择环境");
				return ERROR;
			}
			// 检查用户输入
			if (StringUtils.isBlank(user.getUserName())){
				setErrorMsg("请输入用户名!");
				return ERROR;
			}
			Map<String, String> envStidMap = (Map<String, String>) getSession().getServletContext().getAttribute("envStidMap");
			if(envStidMap==null || !envStidMap.containsKey(env)){
				setErrorMsg("环境错误");
				return ERROR;
			}
			ServletActionContext.getContext().getSession().put("username", user.getUserName());
			getSession().setAttribute("stid", envStidMap.get(env));
			AUserVO au = this.auserService.queryUserByUserName(user.getUserName());
			if(null==au){
				setErrorMsg("用户未在系统中备案，请联系管理员！");
				return ERROR;
			}else{
				if(!this.password.trim().equals(au.getPasswd().trim())){
					setErrorMsg("用户密码错误，请联系管理员！");
					return ERROR;
				}else{
					ZBMSU01VO vo = new ZBMSU01VO();
					vo.setBmsusr(user.getUserName());
					List<ZBMSU01VO> zbmsList = this.zbmsu01Service.queryZbmsu(vo);
					getSession().setAttribute("houses", zbmsList);
					getSession().setAttribute("username", user.getUserName());
				}
			}
			//			// 根据用户名获取用户信息
			//			UserVO loginUser = userService.queryUserByUserName(user.getUserName());
			//			if (null == loginUser) {
			//				setErrorMsg("用户未在系统中备案，请联系管理员！");
			//				return ERROR;
			//			}
			//			// 用户状态检查
			//			if (loginUser.getStatus().equals(HGPJConstant.USER_STATUS_L)) {
			//				setErrorMsg("用户已经被锁定，请联系管理员！");
			//				return ERROR;
			//			} else if (loginUser.getStatus().equals(HGPJConstant.USER_STATUS_D)) {
			//				setErrorMsg("用户已经被删除，请联系管理员！");
			//				return ERROR;
			//			}
			//			// 获取用户所属组织信息
			//			OrgVO org = orgService.queryOrgById(loginUser.getOrgId());
			//			// 获取用户所属海关信息
			//			OrgVO customs = null;
			//			if (loginUser.getOrgId().equals(loginUser.getCustomsId())) {
			//				customs = org;
			//			} else {
			//				customs = orgService.queryOrgById(loginUser.getCustomsId());
			//			}
			//			// 根据用户ID获取用户拥有的菜单资源操作
			//			Map<String, Object> resourceOpers= userService.getResOperOfLoginUser(loginUser.getUserId());
			//			if (null == resourceOpers || resourceOpers.size() < 1) {
			//				setErrorMsg("未分配系统功能权限，无法进入系统，如有需要请联系管理员！");
			//				return ERROR;
			//			}
			//			// 根据用户ID获取用户可以访问的操作URL地址
			//			Map<String, Object> urls = userService.getOperAddressOfLoginUser(loginUser.getUserId());
			//			
			//			// 保存登录用户信息至会话
			//			saveUserLoginInfo(loginUser, org, customs, resourceOpers, urls);
		} catch (Exception e) {e.printStackTrace();
		log.error("用户登录错误.", e);
		setBackUrl("/login.jsp");
		return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 保存登录用户信息UserLoginInfo至session会话
	 * @param user
	 * @param org
	 * @param customs
	 * @param resourceOpers
	 * @param urls
	 */
	private void saveUserLoginInfo(UserVO user, OrgVO org, OrgVO customs,
			Map<String, Object> resourceOpers, Map<String, Object> urls) {
		UserLoginInfo userLoginInfo = new UserLoginInfo();
		userLoginInfo.setUser(user);
		userLoginInfo.setOrg(org);
		userLoginInfo.setCustoms(customs);
		userLoginInfo.setResourceOpers(resourceOpers);
		userLoginInfo.setUrls(urls);
		// 将登录用户信息保存至会话
		getSession().setAttribute(HGPJConstant.SESSION_USER_KEY, userLoginInfo);
	}

	/**
	 * 根据系统代码、当前登录用户ID与用户默认组织ID获取菜单资源
	 * @return
	 * @throws Exception
	 */
	public String listResources() throws Exception {
		try {
			// 获取当前登录用户允许访问的菜单列表
			//menus = menuService.queryUserMenuTreeList(0);
			System.out.print("listResources");
			menus = menuService.getMenuTreeListForUserN((String)this.getSession().getAttribute("username"));
			List<MenuVO> list = new ArrayList<MenuVO>();
			
			if(menus!=null && menus.size()>0){System.out.print("menus.size"+menus.size());
				for(int i=0;i<menus.size();i++){
					MenuVO mvo=menus.get(i);
					Map menuM = new HashMap();
					if(mvo.getMenuType()!=null && mvo.getMenuType().trim().equals("2")){
						menus.remove(i);
						i--;
					}else{
						List<MenuVO> lmv=mvo.getSubMenuList();
						if(lmv!=null && lmv.size()>0){
							for(int j=0;j<lmv.size();j++){
								MenuVO cmvo=lmv.get(j);
								if(cmvo.getMenuType()!=null && cmvo.getMenuType().trim().equals("2")){
									lmv.remove(j);
									j--;
								}
//									menuM.put(cmvo.getMenuKey().trim(), cmvo.getMenuName().trim());
							}
//							list.add(menuM);
						}
					}
					
				}
				
			}
			//			menus= new ArrayList<MenuVO>();
			//			menus
		} catch (Exception e) {e.printStackTrace();
//		log.error("获取登录用户允许访问的菜单资源错误.userId=" + getLoginUser().getUserId(),
//				e);
		setBackUrl("/login.jsp");
		return ERROR;
		}
		return "listResources";
	}
}
