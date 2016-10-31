package com.eclink.hgpj.resource.dao;

import java.util.List;

import com.eclink.hgpj.resource.vo.MenuVO;

/**
 * MenuDao.java
 *
 * @Title: 菜单资源数据库访问接口
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 21, 2013 3:55:10 PM
 *
 */
public interface MenuDao {
	/**
	 * 通过组织ID获取组织资源菜单树列表
	 * @param orgId
	 * @return
	 * @throws Exception
	 */
	public List<MenuVO> queryOrgMenuTreeList(int orgId) throws Exception;
	
	/**
	 * 获取系统菜单树列表
	 * @return
	 * @throws Exception
	 */
	public List<MenuVO> queryMenuTreeList() throws Exception;
	
	/**
	 * 获取用户允许访问的系统菜单树列表
	 * @param userId 用户ID
	 * @return
	 * @throws Exception
	 */
	public List<MenuVO> queryUserMenuTreeList(int userId) throws Exception;
	
	/**
	 * 通过ID获取菜单
	 * @param menuId 菜单ID
	 * @return
	 * @throws Exception
	 */
	public MenuVO queryMenuById(int menuId) throws Exception;
	
	/**
	 * 通过菜单KEY获得菜单信息
	 * @param menuKey
	 * @return
	 * @throws Exception
	 */
	MenuVO queryMenuByMenuKey(String menuKey)throws Exception;
	
	/**
	 * 根据条件查询菜单资源数量
	 * @param menu 菜单资源值对象
	 * @return
	 * @throws Exception
	 */
	int queryResourceCount(MenuVO menu) throws Exception;
	
	/**
	 * 根据菜单资源KEY获取菜单资源数量
	 * @param menu 菜单资源值对象 
	 * @return
	 * @throws Exception
	 */
	int queryResourceCountByKey(MenuVO menu) throws Exception;
	
	/**
	 * 菜单资源已经分配给组织资源的数量
	 * @param menu 菜单资源
	 * @return
	 * @throws Exception
	 */
	int queryAssignResourceCount(MenuVO menu) throws Exception;
	
	/**
	 * 菜单资源列表查询（通过父级菜单）
	 * @param menu 菜单资源
	 * @return
	 * @throws Exception
	 */
	List<MenuVO> queryResourceListByParent(MenuVO menu) throws Exception;
	
	/**
	 * 更新菜单资源排序顺序
	 * @param menus 菜单资源列表
	 * @throws Exception
	 */
	public void updateResourceOrdert(final List<MenuVO> menus) throws Exception;
	
	/**
	 * 新增菜单
	 * @param menu
	 * @throws Exception
	 */
	public void insert(MenuVO menu) throws Exception;
	
	/**
	 * 修改菜单
	 * @param menu
	 * @throws Exception
	 */
	public void update(MenuVO menu) throws Exception;
	
	/**
	 * 删除菜单
	 * @param menuId
	 * @throws Exception
	 */
	public void delete(int menuId) throws Exception;
	
	/**
	 * 根据父菜单获取子菜单
	 * @param parentMenuId 父菜单ID
	 * @return
	 * @throws Exception
	 */
	public List<MenuVO> queryChildMenu(int parentMenuId) throws Exception;

}
