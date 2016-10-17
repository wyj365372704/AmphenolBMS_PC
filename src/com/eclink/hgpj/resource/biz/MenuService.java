package com.eclink.hgpj.resource.biz;

import java.util.List;

import com.eclink.hgpj.resource.vo.MenuVO;

/**
 * MenuService.java
 *
 * @Title: 菜单业务接口
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 21, 2013 5:12:44 PM
 *
 */
public interface MenuService {
	/**
	 * 获取组织所有菜单资源及操作功能
	 * @param orgId
	 * @return
	 * @throws Exception
	 */
	public List<MenuVO> queryOrgMenuTree(int orgId) throws Exception;
	
	/**
	 * 获取组织所有菜单资源及操作功能，选中下级资源操作
	 * @param orgId 组织ID
	 * @param childOrgId 子组织ID
	 * @return
	 * @throws Exception
	 */
	public List<MenuVO> queryOrgMenuTree(int orgId, int childOrgId) throws Exception;
	
	/**
	 * 获取角色所属组织的所有菜单资源及操作功能，选中角色所拥有的资源操作
	 * @param orgId 组织ID
	 * @param roleId 角色ID
	 * @return
	 * @throws Exception
	 */
	public List<MenuVO> queryRoleMenuTree(int orgId, int roleId) throws Exception;
	
	/**
	 * 获取系统所有菜单资源及操作功能 
	 * @return
	 * @throws Exception
	 */
	public List<MenuVO> querySystemResource() throws Exception;
	
	/**
	 * 通过ID获取菜单
	 * @param menuId 菜单ID
	 * @return
	 * @throws Exception
	 */
	public MenuVO queryMenuById(int menuId) throws Exception;
	
	/**
	 * 新增菜单资源
	 * @param menu 菜单资源
	 * @throws Exception
	 */
	public void insertMenu(MenuVO menu) throws Exception; 
	
	/**
	 * 修改菜单资源
	 * @param menu 菜单资源
	 * @throws Exception
	 */
	public void updateMenu(MenuVO menu) throws Exception;
	
	/**
	 * 删除菜单资源
	 * @param menu 菜单资源
	 * @throws Exception
	 */
	public void deleteMenu(MenuVO menu) throws Exception;
	
	/**
	 * 菜单资源列表查询（通过父级菜单）
	 * @param menu 菜单资源
	 * @return
	 * @throws Exception
	 */
	List<MenuVO> queryResourceListByParent(MenuVO menu) throws Exception;
	
	/**
	 * 批量更新菜单资源排序顺序
	 * @param menus 菜单资源列表
	 * @throws Exception
	 */
	public void updateResourceOrdert(List<MenuVO> menus) throws Exception;
	
	/**
	 * 系统管理员授权
	 * @param resOpers 资源操作数组
	 * @throws Exception
	 */
	public void grantForAdmin(String[] resOpers) throws Exception;
	
	/**
	 * 分关管理员授权
	 * @param operate 1-添加、2-移除
	 * @param orgId 关区ID，为-1时代表所有关区
	 * @param resOpers 资源操作数组
	 * @throws Exception
	 */
	public void grantForChildAdmin(int operate, int orgId, String[] resOpers)
			throws Exception;
	
	/**
	 * 获取系统所有菜单资源及操作功能，选中系统根组织授权功能
	 * @return
	 * @throws Exception
	 */
	public List<MenuVO> queryAdminGrantTree() throws Exception;
	
	/**
	 * 获取用户允许访问的菜单树列表
	 * @param userId 用户ID
	 * @return
	 * @throws Exception
	 */
	public List<MenuVO> queryUserMenuTreeList(int userId) throws Exception;

	public List<MenuVO> queryUserMenuTreeListPDA(int userId) throws Exception;
}
