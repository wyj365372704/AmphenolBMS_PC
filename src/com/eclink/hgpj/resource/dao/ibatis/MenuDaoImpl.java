package com.eclink.hgpj.resource.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.resource.dao.MenuDao;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * MenuDaoImpl.java
 *
 * @Title: 菜单数据库接口实现类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 21, 2013 5:11:36 PM
 *
 */
public class MenuDaoImpl extends SqlMapClientDaoSupport implements MenuDao {

	@Override
	public List<MenuVO> queryOrgMenuTreeList(int orgId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Menu.getOrgMenuTreeList", orgId);
	}

	@Override
	public List<MenuVO> queryMenuTreeList() throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Menu.getMenuTreeList");
	}

	@Override
	public MenuVO queryMenuById(int menuId) throws Exception {
		return (MenuVO)this.getSqlMapClientTemplate().queryForObject("Menu.getMenuById", menuId);
	}

	@Override
	public void delete(int menuId) throws Exception {
		this.getSqlMapClientTemplate().delete("Menu.deleteResource", menuId);
	}

	@Override
	public void insert(MenuVO menu) throws Exception {
		this.getSqlMapClientTemplate().insert("Menu.insertResource", menu);
	}

	@Override
	public int queryAssignResourceCount(MenuVO menu) throws Exception {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("Menu.getAssignResourceCount", menu);
	}

	@Override
	public MenuVO queryMenuByMenuKey(String menuKey) throws Exception {
		return (MenuVO)this.getSqlMapClientTemplate().queryForObject("Menu.getMenuByKey", menuKey);
	}

	@Override
	public int queryResourceCount(MenuVO menu) throws Exception {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("Menu.getResourceCount", menu);
	}

	@Override
	public int queryResourceCountByKey(MenuVO menu) throws Exception {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("Menu.getResourceCountByKey", menu);
	}

	@Override
	public List<MenuVO> queryResourceListByParent(MenuVO menu)
			throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Menu.getResourceList", menu);
	}

	@Override
	public void update(MenuVO menu) throws Exception {
		this.getSqlMapClientTemplate().update("Menu.updateResource", menu);
	}

	@Override
	public void updateResourceOrdert(final List<MenuVO> menus) throws Exception {
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				executor.startBatch();
				if (menus != null && menus.size() > 0) {
					for (MenuVO menu : menus) {
						executor.update("Menu.updateResource", menu);
					}
				}
				executor.executeBatch();
				return null;
			}
		});
	}

	@Override
	public List<MenuVO> queryUserMenuTreeList(int userId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Menu.getMenuTreeListForUser", userId);
	}
	
	@Override
	public List<MenuVO> queryUserMenuTreeListPDA(int userId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Menu.getMenuTreeListForUserPDA", userId);
	}

	@Override
	public List<MenuVO> queryChildMenu(int parentMenuId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("Menu.getChildMenu", parentMenuId);
	}

}
