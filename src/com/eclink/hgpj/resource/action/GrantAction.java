package com.eclink.hgpj.resource.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.organization.biz.OrgService;
import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.resource.biz.MenuService;
import com.eclink.hgpj.resource.vo.MenuVO;

/**
 * GrantAction.java
 *
 * @Title: 资源授权控制类
 * @Description: 
 * @version 1.0
 * @date May 29, 2013 4:44:36 PM
 *
 */
public class GrantAction extends BaseAction {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(GrantAction.class);
	
	/**
	 * 菜单业务对象
	 */
	private MenuService menuService;
	
	/**
	 * 组织业务对象
	 */
	private OrgService orgService;
	
	/**
	 * 系统菜单
	 */
	private List<MenuVO> menus;
	
	/**
	 * 资源操作数组
	 */
	private String[] orgRes;
	
	/**
	 * 操作类型 1表示增加权限 2表示删除权限
	 */
	private Integer operate;
	
	/**
	 * 关区组织列表
	 */
	private List<OrgVO> customsOrg;
	
	/**
	 * 选择的关区
	 */
	private Integer orgId;

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public OrgService getOrgService() {
		return orgService;
	}

	public void setOrgService(OrgService orgService) {
		this.orgService = orgService;
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

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

	public List<OrgVO> getCustomsOrg() {
		return customsOrg;
	}

	public void setCustomsOrg(List<OrgVO> customsOrg) {
		this.customsOrg = customsOrg;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	/**
	 * 进入系统管理员资源授权页面
	 * @return
	 * @throws Exception
	 */
	public String toAdminGrant() throws Exception {
		try {
			// 查询所有系统的资源操作树及已经授权给根组织的资源操作
			menus = menuService.queryAdminGrantTree();
		} catch (Exception e) {
			log.error("Go to admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "toAdminGrant";
	}
	
	/**
	 * 系统管理员资源授权
	 * @return
	 * @throws Exception
	 */
	public String adminGrant() throws Exception {
		try {
			// 授权
			menuService.grantForAdmin(orgRes);
		} catch (Exception e) {
			log.error(
					"Resource operation grant to administrator occured error.",
					e);
			return ERROR;
		}
		setBackUrl("/grant/grant!toAdminGrant.action");
		return "info";
	}
	
	/**
	 * 进入分关管理员资源授权页面
	 * @return
	 * @throws Exception
	 */
	public String toChildAdminGrant() throws Exception {
		try {
			// 获取所有组织类型为分关的组织
			customsOrg = orgService.queryChildCustomsOrg();
			// 获取授权给系统根组织的菜单资源及功能操作
			menus = menuService.queryOrgMenuTree(HGPJConstant.SYSTEM_ROOT_ORG_ID);
		} catch (Exception e) {
			log.error("Go to child admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "toChildAdminGrant";
	}
	
	/**
	 * 分关管理员资源授权
	 * @return
	 * @throws Exception
	 */
	public String childAdminGrant() throws Exception {
		try {
			// 分关管理员授权
			menuService.grantForChildAdmin(operate, orgId, orgRes);
		} catch (Exception e) {
			log.error(
					"Resource operation grant to child administrator occured error.",
					e);
			return ERROR;
		}
		setBackUrl("/grant/grant!toChildAdminGrant.action");
		return "info";
	}
}
