package com.eclink.hgpj.organization.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.organization.biz.OrgService;
import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.resource.biz.MenuService;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.user.biz.UserService;
import com.eclink.hgpj.user.vo.UserVO;

/**
 * OrgAction.java
 *
 * @Title: 组织机构控制类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 20, 2013 4:35:36 PM
 *
 */
public class OrgAction extends BaseAction {
	private static final Logger log = Logger.getLogger(OrgAction.class);
	private OrgVO org = new OrgVO();
	private UserVO user = new UserVO();
	private List<OrgVO> listTree;
	private OrgService orgService;
	private MenuService menuService;
	private UserService userService;
	private List<MenuVO> menus;
	private String[] orgRes ;
	
	public OrgVO getOrg() {
		return org;
	}
	public void setOrg(OrgVO org) {
		this.org = org;
	}
	public UserVO getUser() {
		return user;
	}
	public void setUser(UserVO user) {
		this.user = user;
	}
	public List<OrgVO> getListTree() {
		return listTree;
	}
	public void setListTree(List<OrgVO> listTree) {
		this.listTree = listTree;
	}
	public OrgService getOrgService() {
		return orgService;
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
	public String[] getOrgRes() {
		return orgRes;
	}
	public void setOrgRes(String[] orgRes) {
		this.orgRes = orgRes;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 组织框架页查看
	 * @return
	 * @throws Exception
	 */
	public String orgindex() throws Exception{
		try {
			
		} catch (Exception e) {
			log.error("To organization index page occurred error." ,e);
			return ERROR;
		}
		return "orgindex";
	}
	
	/**
	 * 组织树查看
	 * @return
	 * @throws Exception
	 */
	public String treelist() throws Exception{
		try {
			// 总关用户查询所有机构，分关查询用户所属机构及下级机构
			int orgId = HGPJConstant.SYSTEM_ROOT_ORG_ID; 
			if (!isHeadUser()) {
				orgId = getOrgOfLoginUser().getOrgId();
			}
			listTree = orgService.queryOrgTreeById(orgId);
		} catch (Exception e) {
			log.error("treelist org error." ,e);
			return ERROR;
		}
		return "orgleft";
	}
	
	/**
	 * 组织信息查看
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception{
		try {
			// 获取组织ID
			int orgId = org.getOrgId();
			// 获取组织详情信息
			org = orgService.queryOrgById(orgId);
			// 获取上级组织授权信息并选中本组织授权信息
			menus = menuService.queryOrgMenuTree(org.getParentOrg() == -1 ? orgId
					: org.getParentOrg(), orgId);
		} catch (Exception e) {
			log.error("View organization infomation occurred error." ,e);
			return ERROR;
		}
		return "view";
	}
	
	/**
	 * 进入组织新增页面
	 * @return
	 * @throws Exception
	 */
	public String toInsert() throws Exception{
		try {
			// 获取组织ID
			int orgId = org.getOrgId();
			// 获取组织详情信息
			org = orgService.queryOrgById(orgId);
			// 获取上级组织授权信息
			menus = menuService.queryOrgMenuTree(orgId);
		} catch (Exception e) {
			log.error("View organization infomation occurred error." ,e);
			return ERROR;
		}
		return "toInsert";
	}
	
	/**
	 * 组织新增保存
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception{
		try {
			// 检查名称是否存在
			if (orgService.existOrgName(org)) {
				setErrorMsg("机构名称'" + org.getOrgName() + "'已经存在，请重新输入!");
				return ERROR;
			}
			if (HGPJConstant.ORG_TYPE_F.equals(org.getOrgType())) {
				if (userService.existUserName(user.getUserName())) {
					setErrorMsg("分关管理员用户名'" + user.getUserName() + "'已经存在，请重新输入!");
					return ERROR;
				}
			}
			// 当前登录用户
			String createUser = getLoginUser().getUserName();
			org.setCreateUser(createUser);
			user.setCreateUser(createUser);
			// 新增保存
			orgService.insert(org, user, orgRes);
		} catch (Exception e) {
			log.error("Insert save organization infomation occurred error." ,e);
			return ERROR;
		}
		setBackUrl("/org/org!orgindex.action");
		return "info";
	}
	
	/**
	 * 进入组织修改页面
	 * @return
	 * @throws Exception
	 */
	public String toModify() throws Exception {
		try {
			int orgId = org.getOrgId();
			 if(orgId==getOrgOfLoginUser().getOrgId()){
				setErrorMsg("不能修改用户自身的组织！");
				return ERROR;
			 }
			// 获取组织详情信息
			org = orgService.queryOrgById(orgId);
			// 获取上级组织授权信息并选中本组织授权信息
			menus = menuService.queryOrgMenuTree(org.getParentOrg() == -1 ? orgId
					: org.getParentOrg(), orgId);
		} catch (Exception e) {
			log.error("toModify org error." ,e);
			return ERROR;
		}
		return "toModify";
	}
	
	/**
	 * 组织修改保存
	 * @return
	 * @throws Exception
	 */
	public String modify() throws Exception {
		try {
			// 检查组织名称是否存在
			if (!org.getOldOrgName().equals(org.getOrgName())) {
				if (orgService.existOrgName(org)) {
					setErrorMsg("机构名称\""+org.getOrgName()+"\"已经存在，请重新输入！");
					return ERROR;
				}
			}
			// 修改组织
			orgService.update(org, orgRes);
		} catch (Exception e) {
			log.error("modify org error." ,e);
			return ERROR;
		}
		setBackUrl("/org/org!orgindex.action");
		return "info";
	}
	
	/**
	 * 删除组织信息
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		try {
			// 判断组织是否能被删除
			if (org.getOrgId() == HGPJConstant.SYSTEM_ROOT_ORG_ID) {
				setErrorMsg("该组织是系统根组织，不能删除！");
				return ERROR;
			}else if(orgService.hasChildOrg(org.getOrgId())){
				setErrorMsg("该组织有下级组织，不能删除！");
				return ERROR;
			}else if(getOrgOfLoginUser().getOrgId().equals(org.getOrgId())){
				setErrorMsg("不能删除用户自身所在的组织！");
				return ERROR;
			}else if (orgService.hasUserOfOrg(org.getOrgId())) {
				setErrorMsg("该组织下已经有用户，不能删除！");
				return ERROR;
			}
			orgService.delete(org);
		} catch (Exception e) {
			log.error("delete org error." ,e);
			return ERROR;
		}
		setBackUrl("/org/org!orgindex.action");
		return "info";
	}
	
	/**
	 * 根据关区获取科室
	 * @return
	 * @throws Exception
	 */
	public String getChildOrg() throws Exception {
		PrintWriter pw = null;
		try {
			HttpServletResponse response = getResponse();
			response.setContentType("text/html;charset=UTF-8");
			// 根据关区获取子组织列表
			List<OrgVO> childOrgs = null;
			StringBuffer sb = new StringBuffer();;
			if (null != org.getOrgId()) {
				if (org.getOrgId() == HGPJConstant.SYSTEM_ROOT_ORG_ID) {
					childOrgs = orgService.getHeaderDept();
				}else{
					childOrgs = orgService.queryChildOrgByOrgId(org.getOrgId());
				}
				if (childOrgs != null && !childOrgs.isEmpty()) {
					sb.append("{data:[");
					for (int i = 0; i < childOrgs.size(); i++) {
						OrgVO org = childOrgs.get(i);
						sb.append("{\"label\":\"");
						sb.append(org.getOrgName());
						sb.append("\",\"value\":");
						sb.append(org.getOrgId());
						sb.append("}");
						if (i<childOrgs.size()-1) {
							sb.append(",");
						}
					}
					sb.append("]}");
				}
			}
			pw = response.getWriter();
			pw.write(sb.toString());
			pw.flush();
		} catch (Exception e) {
			log.error("Get child organization by parent occurred error.", e);
			return ERROR;
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
		return null;
	}
}
