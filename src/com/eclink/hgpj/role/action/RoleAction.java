package com.eclink.hgpj.role.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.eclink.dfcm.paginator.common.PaginatorUtil;
import com.eclink.dfcm.paginator.tag.PageVO;
import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.organization.biz.OrgService;
import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.resource.biz.MenuService;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.role.biz.RoleService;
import com.eclink.hgpj.role.vo.RoleVO;

/**
 * RoleAction.java
 *
 * @Title: 角色控制类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 24, 2013 1:17:19 PM
 *
 */
public class RoleAction extends BaseAction {
	
	private static final Logger log = Logger.getLogger(RoleAction.class);
	
	private RoleService roleService;
	private OrgService orgService;
	private MenuService menuService;
	private RoleVO role = new RoleVO();
	private List<RoleVO> roleList;
	private List<OrgVO> customsOrg;
	private List<MenuVO> menus;
	private String orgTreeData = "";
	private List<String> orgRes;
	/**
	 * 科室组织列表
	 */
	private List<OrgVO> departmentOrg = new ArrayList<OrgVO>();
	
	public RoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
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
	public RoleVO getRole() {
		return role;
	}
	public void setRole(RoleVO role) {
		this.role = role;
	}
	public List<RoleVO> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<RoleVO> roleList) {
		this.roleList = roleList;
	}
	public List<OrgVO> getCustomsOrg() {
		return customsOrg;
	}
	public void setCustomsOrg(List<OrgVO> customsOrg) {
		this.customsOrg = customsOrg;
	}
	public List<MenuVO> getMenus() {
		return menus;
	}
	public void setMenus(List<MenuVO> menus) {
		this.menus = menus;
	}
	public String getOrgTreeData() {
		return orgTreeData;
	}
	public void setOrgTreeData(String orgTreeData) {
		this.orgTreeData = orgTreeData;
	}
	public List<String> getOrgRes() {
		return orgRes;
	}
	public void setOrgRes(List<String> orgRes) {
		this.orgRes = orgRes;
	}
	public List<OrgVO> getDepartmentOrg() {
		return departmentOrg;
	}
	public void setDepartmentOrg(List<OrgVO> departmentOrg) {
		this.departmentOrg = departmentOrg;
	}
	/**
	 * 角色列表查询
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		try {
			// 获取所有分关组织
			customsOrg = orgService.queryCustomsOrg();
			
			// 判断用户类型，总关查询所有数据，分关根据用户所属组织进行数据查询控制
			if (!isHeadUser()) {
				role.setCustomsId(getCustomsOfLoginUser().getOrgId());
				// 分关根组织查询本关所有，非分关根组织查询本组织及下级组织数据
				if (!getOrgOfLoginUser().getOrgId().equals(getCustomsOfLoginUser().getOrgId())) {
					role.setOrgId(getOrgOfLoginUser().getOrgId());
					departmentOrg = orgService.queryChildOrgByOrgId(getOrgOfLoginUser().getOrgId());
					if (null != departmentOrg && !departmentOrg.isEmpty()) {
						StringBuilder sb = new StringBuilder();
						for (OrgVO org : departmentOrg) {
							sb.append(org.getOrgId()).append(",");
						}
						sb.append(getOrgOfLoginUser().getOrgId());
						role.setOrgIds(sb.toString());
					}
				}
			}
			
			// 获取分页信息
			PageVO page = PaginatorUtil.getPaginator(getRequest());
			setPagination(role,page);
			
			// 查询总记录数
			if (page.isQueryTotal()) {
				page.setTotalRecord(roleService.queryRoleListCount(role));
			}
			
			// 调用业务方法查询列表
			roleList = roleService.queryRoleList(role);
			
			// 分页对象保存至request
			getRequest().setAttribute(HGPJConstant.PAGE_KEY, page);
		} catch (Exception e) {
			log.error("Query role list occurred error." ,e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 角色详情查看
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception {
		try {
			// 获取角色信息
			role = roleService.queryRoleById(role.getRoleId());
			// 获取上级组织授权信息并选中本角色授权信息
			menus = menuService.queryRoleMenuTree(role.getOrgId(), role.getRoleId());
		} catch (Exception e) {
			log.error("View role occurred error." ,e);
			return ERROR;
		}
		return "view";
	}
	
	/**
	 * 角色选择组织
	 * @return
	 * @throws Exception
	 */
	public String roleSelectOrg() throws Exception {
		try {
			// 获取当前登录用户所属关区组织
			int orgId = getCustomsOfLoginUser().getOrgId();
			// 获取当前用户所属组织机构及所有下级组织机构
			List<OrgVO> list = orgService.queryOrgTreeById(orgId);
			if (null != list && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					OrgVO org = list.get(i);
					orgTreeData +="{id:"+org.getOrgId()+",pId:"+org.getParentOrg()+",name:\""+org.getOrgName()+"\"}";
					if (i<list.size()-1)
						orgTreeData += ",";
				}
			}
		} catch (Exception e) {
			log.error("Into role select org page occurred error." ,e);
			return ERROR;
		}
		return "selectOrg";
	}
	
	/**
	 * 获取某组织下的菜单功能权限树
	 * @return
	 * @throws Exception
	 */
	public String menuTree()throws Exception {
		try {
			// 获取组织授权信息
			menus = menuService.queryOrgMenuTree(role.getOrgId());
		} catch (Exception e) {
			log.error("menuTree error." ,e);
			return ERROR;
		}
		return "menuTree";
	}
	
	/**
	 * 进入角色新增页面
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
		} catch (Exception e) {
			log.error("toInsert role error." ,e);
			return ERROR;
		}
		return "toInsert";
	}
	
	/**
	 * 角色新增保存
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		try {
			// 判断角色名称是否存在
			if (!role.getOldRoleName().equals(role.getRoleName())) {
				if (roleService.exitsRoleName(role)) {
					setErrorMsg("角色名称'"+role.getRoleName()+"'已经存在，请重新输入！");
					return ERROR;
				}
			}
			// 获取角色所属关区
			OrgVO customs = orgService.queryParentOrgById(role.getOrgId());
			role.setCustomsId(customs.getOrgId());
			role.setCreateUser(getLoginUser().getUserName());
			roleService.insert(role,orgRes);
		} catch (Exception e) {
			log.error("insert role error." ,e);
			return ERROR;
		}
		setBackUrl("/role/role!list.action");
		return "info";
	}
	
	/**
	 * 进入角色修改页面
	 * @return
	 * @throws Exception
	 */
	public String toModify() throws Exception {
		try {
			// 获取角色信息
			role = roleService.queryRoleById(role.getRoleId());
			// 判断角色是否被用户关联，未关联则可以修改组织
			if (!roleService.hasUserUserRole(role.getRoleId())) {
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
			}
			// 获取上级组织授权信息并选中本角色授权信息
			menus = menuService.queryRoleMenuTree(role.getOrgId(), role.getRoleId());
		} catch (Exception e) {
			log.error("Into role modify page occurred error.", e);
			return ERROR;
		}
		return "toModify";
	}
	
	/**
	 * 角色修改保存
	 * @return
	 * @throws Exception
	 */
	public String modify() throws Exception {
		try {
			// 判断角色名称是否存在
			if (!role.getOldRoleName().equals(role.getRoleName())) {
				if (roleService.exitsRoleName(role)) {
					setErrorMsg("角色名称'"+role.getRoleName()+"'已经存在，请重新输入！");
					return ERROR;
				}
			}
			// 获取角色所属关区
			OrgVO customs = orgService.queryParentOrgById(role.getOrgId());
			role.setCustomsId(customs.getOrgId());
			role.setLastUpdateUser(getLoginUser().getUserName());
			// 更新角色
			roleService.update(role, orgRes);
		} catch (Exception e) {
			log.error("Role modify save occurred error.", e);
			return ERROR;
		}
		setBackUrl("/role/role!list.action");
		return "info";
	}
	
	/**
	 * 角色删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		try {
			// 判断角色是否被用户关联，未关联则可以删除
			if (!roleService.hasUserUserRole(role.getRoleId())) {
				roleService.delete(role.getRoleId());
			} else {
				setErrorMsg("角色已经被用户关联，请联消关联后再删除！");
				return ERROR;
			}
		} catch (Exception e) {
			log.error("Role delete occurred error.", e);
			return ERROR;
		}
		setBackUrl("/role/role!list.action");
		return "info";
	}
}
