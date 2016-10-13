package com.eclink.hgpj.resource.biz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.eclink.hgpj.common.HGPJBizException;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.organization.dao.OrgDao;
import com.eclink.hgpj.organization.vo.OrgResourceVO;
import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.resource.dao.MenuDao;
import com.eclink.hgpj.resource.dao.OperationDao;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.OperationVO;
import com.eclink.hgpj.role.dao.RoleDao;
import com.eclink.hgpj.role.vo.RoleResourceVO;
import com.eclink.hgpj.role.vo.RoleVO;
import com.eclink.hgpj.util.MenuTreeComparator;
import com.eclink.hgpj.util.OperationComparator;
import com.eclink.hgpj.util.Utils;

/**
 * MenuServiceImpl.java
 *
 * @Title: 菜单资源业务实现类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class MenuServiceImpl implements MenuService {
	
	private MenuDao menuDao;
	private OperationDao operationDao;
	private RoleDao roleDao;
	private OrgDao orgDao;

	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public OperationDao getOperationDao() {
		return operationDao;
	}

	public void setOperationDao(OperationDao operationDao) {
		this.operationDao = operationDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public OrgDao getOrgDao() {
		return orgDao;
	}

	public void setOrgDao(OrgDao orgDao) {
		this.orgDao = orgDao;
	}

	@Override
	public List<MenuVO> queryOrgMenuTree(int orgId) throws Exception {
		return queryOrgMenuTree(orgId, -1);
	}

	@Override
	public List<MenuVO> queryOrgMenuTree(int orgId, int childOrgId)
			throws Exception {
		// 获取授权给组织的菜单资源
		List<MenuVO> menus = menuDao.queryOrgMenuTreeList(orgId);
		// 转换菜单成节点与子节点关联的形式并排序
		converAndSortMenuTree(menus);
		// 获得组织相应的操作
		List<OperationVO> operList = getOrgOperationList(orgId, childOrgId);
		// 将操作添加到相应的菜单中
		addOperToChildRes(menus, getOperationMap(operList));
		return menus;
	}
	
	@Override
	public List<MenuVO> queryRoleMenuTree(int orgId, int roleId)
			throws Exception {
		// 获取授权给组织的菜单资源
		List<MenuVO> menus = menuDao.queryOrgMenuTreeList(orgId);
		// 转换菜单成节点与子节点关联的形式并排序
		converAndSortMenuTree(menus);
		// 获得角色相应的操作
		List<OperationVO> operList = getRoleOperationList(orgId, roleId);
		// 将操作添加到相应的菜单中
		addOperToChildRes(menus, getOperationMap(operList));
		return menus;
	}
	
	@Override
	public List<MenuVO> querySystemResource() throws Exception {
		// 获取系统所有菜单资源
		List<MenuVO> menus = menuDao.queryMenuTreeList();
		// 转换菜单成节点与子节点关联的形式并排序
		converAndSortMenuTree(menus);
		// 获取系统所有资源操作
		List<OperationVO> operList = operationDao.queryAllOperList();
		// 将操作添加到相应的菜单中
		addOperToChildRes(menus, getOperationMap(operList));
		return menus;
	}
	
	@Override
	public List<MenuVO> queryAdminGrantTree() throws Exception {
		// 获取系统所有菜单资源
		List<MenuVO> menus = menuDao.queryMenuTreeList();
		// 转换菜单成节点与子节点关联的形式并排序
		converAndSortMenuTree(menus);
		// 获取系统所有资源操作
		List<OperationVO> operList = operationDao.queryAllOperList();
		// 获取已经授权给组织的操作
		List<OperationVO> opMergList = operationDao.querySelectedOperListByOrgId(HGPJConstant.SYSTEM_ROOT_ORG_ID);
		operList = Utils.mergerList(operList, opMergList);
		addOperToChildRes(menus,getOperationMap(operList));
		return menus;
	}
	
	/**
	 * 将菜单资源转换成父子结构并排序
	 * @param resources
	 */
	private void converAndSortMenuTree(List<MenuVO> menus) {
		if (null != menus && !menus.isEmpty()) {
			List<MenuVO> parentMenus = new ArrayList<MenuVO>();
			for (Iterator iter = menus.iterator(); iter.hasNext();) {
				MenuVO info = (MenuVO) iter.next();
				if (info.getParentMenu() == null || "".equals(info.getParentMenu().trim())) {
					parentMenus.add(info);
				} else {
					String parentMenu = info.getParentMenu();
					for (MenuVO menuVO : parentMenus) {
						if (menuVO.getMenuId().equals(parentMenu)) {
							menuVO.addChildMenu(info);
							menuVO.sortChildMenus();
							iter.remove();
							break;
						}
					}
				}
			}
			menus = parentMenus;
			Collections.sort(menus, new MenuTreeComparator());
		}
	}
	
	/**
	 * 获得指定组织的操作集合
	 * @return
	 * @throws Exception
	 */
	private List<OperationVO> getOrgOperationList(int orgId,int orgChildId) throws Exception{
		List<OperationVO> operList = new ArrayList<OperationVO>();
		operList = operationDao.queryOperListByOrgId(orgId);
		if(orgChildId != -1){
			List<OperationVO> opMergList = operationDao.querySelectedOperListByOrgId(orgChildId);
			operList = Utils.mergerList(operList, opMergList);
		}
		return operList;
	}
	
	/**
	 * 获得角色操作集合
	 * @param orgId
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	private  List<OperationVO> getRoleOperationList(int orgId,int roleId) throws Exception{
		List<OperationVO> operList = new ArrayList<OperationVO>();
		operList = operationDao.queryOperListByOrgId(orgId);
		List<OperationVO> opMergList = operationDao.querySelectedOperListByRoleId(roleId);
		operList = Utils.mergerList(operList, opMergList);
		return operList;
	}
	
	/**
	 * 将查询出来的操作封装成以menuId为KEY的MAP
	 * @param operList
	 * @return
	 */
	private Map<Integer,Set<OperationVO>> getOperationMap(List<OperationVO> operList){
		Map<Integer,Set<OperationVO>> menuOperMap = null;
		if(operList!=null && operList.size()>0){
			menuOperMap = new HashMap();
			for(OperationVO vo : operList){
				int menuId = vo.getMenuId();
				Set operSet = menuOperMap.get(menuId);
				if(operSet==null){
					operSet = new HashSet();
					menuOperMap.put(menuId, operSet);
				}
				operSet.add(vo);
			}
		}
		return menuOperMap;
	}
	
	/**
	 * 将操作信息添加到菜单资源的子节点
	 * @param menus
	 * @param operationMap
	 */
	private void addOperToChildRes(List<MenuVO> menus,
			Map<Integer, Set<OperationVO>> operMap) {
		if(menus!=null && menus.size()>0 && operMap!=null){
			for(MenuVO menu : menus){
				Set<OperationVO> operSet = operMap.get(menu.getMenuId());
				if(operSet!=null && operSet.size()>0){
					List<OperationVO> operList = new ArrayList<OperationVO>();
					for(OperationVO operVO : operSet){
						operList.add(operVO);
					}
					//对list排序
					Collections.sort(operList,new OperationComparator());
					menu.setOperList(operList);
				}
				if(menu.hasChilds() && null != menu.getSubMenuList()){
					addOperToChildRes(menu.getSubMenuList(),operMap);
				}
			}
		}
	}

	@Override
	public MenuVO queryMenuById(int menuId) throws Exception {
		return menuDao.queryMenuById(menuId);
	}

	@Override
	public void insertMenu(MenuVO menu) throws Exception {
		// 检查菜单KEY是否存在
		int count = menuDao.queryResourceCountByKey(menu);
		if (count > 0) {
			throw new HGPJBizException("菜单KEY已经存在，请重新填写！");
		}
		// 获取菜单资源数量，计算排序顺序
		int menuOrder = menuDao.queryResourceCount(menu);
		menu.setMenuOrder(menuOrder + 1);
		// 新增保存菜单资源
		menuDao.insert(menu);
	}

	@Override
	public void updateMenu(MenuVO menu) throws Exception {
		// 检查菜单KEY是否改变，如果改变则检查新菜单KEY是否已经存在
		if (!menu.getOldMenuKey().equals(menu.getMenuKey())) {
			int count = menuDao.queryResourceCountByKey(menu);
			if (count > 0) {
				throw new HGPJBizException("菜单KEY已经存在，请重新填写！");
			}
		}
		// 更新菜单资源
		menuDao.update(menu);
	}

	@Override
	public void deleteMenu(MenuVO menu) throws Exception {
//		// 获取菜单资源详情信息
//		menu = menuDao.queryMenuById(menu.getMenuId());
//		if (menu == null) {
//			throw new HGPJBizException("菜单资源不存在，无法删除！");
//		}
//		// 检查被删除的菜单资源是否已经被组织关联
//		int count = menuDao.queryAssignResourceCount(menu);
//		if (count > 0) {
//			throw new HGPJBizException("菜单资源已经授权给组织，无法删除！");
//		}
//		// 如果被删除的是一级菜单，同时删除该菜单下的所有二级菜单
//		if (null == menu.getParentMenu()) {
//			List<MenuVO> childMenus = menuDao.queryChildMenu(menu.getMenuId());
//			if (null != childMenus && !childMenus.isEmpty()) {
//				for (MenuVO menuVO : childMenus) {
//					// 删除子菜单
//					menuDao.delete(menuVO.getMenuId());
//				}
//			}
//		}
//		// 删除菜单资源
//		menuDao.delete(menu.getMenuId());
	}

	@Override
	public List<MenuVO> queryResourceListByParent(MenuVO menu) throws Exception {
		return menuDao.queryResourceListByParent(menu);
	}

	@Override
	public void updateResourceOrdert(List<MenuVO> menus) throws Exception{
		menuDao.updateResourceOrdert(menus);
	}

	@Override
	public void grantForAdmin(String[] resOpers) throws Exception {
		// 备份系统根组织（深圳海关）下的角色资源，其中系统管理员角色ID不做备份
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("orgId", HGPJConstant.SYSTEM_ROOT_ORG_ID);
		param.put("roleId", 1);
		param.put("tableName", "##ROLE_RESOURCE");
		roleDao.backupRoleResource(param);
		
		// 删除系统根组织原有的组织资源，同时会级联删除角色资源数据
		orgDao.deleteOrgResourceByOrgId(HGPJConstant.SYSTEM_ROOT_ORG_ID);
		
		// 新增组织资源与角色资源
		if(resOpers!=null){
			for (String resOperStr : resOpers) {
				OrgResourceVO orv = null;
				RoleResourceVO rrv = null;
				if(resOperStr!=null && !resOperStr.equals("")){
					orv = new OrgResourceVO();
					orv.setOrgId(HGPJConstant.SYSTEM_ROOT_ORG_ID);
					String[] resOper = resOperStr.split("~");
					orv.setMenuId(Integer.parseInt(resOper[0]));
					orv.setOperKey(resOper[1]);
					// 新增组织资源
					orgDao.insertOrgResource(orv);
					rrv = new RoleResourceVO();
					rrv.setOrgId(HGPJConstant.SYSTEM_ROOT_ORG_ID);
					rrv.setRoleId(1);
					rrv.setMenuId(Integer.parseInt(resOper[0]));
					rrv.setOperKey(resOper[1]);
					// 新增角色资源
					roleDao.insertRoleResource(rrv);
				}
			}
		}
		
		// 将角色资源备份表中的数据合并回正式表
		roleDao.mergeRoleResource(param);
		
		// 删除本地临时表
		roleDao.dropRoleResTmpTable();
	}

	@Override
	public List<MenuVO> queryUserMenuTreeList(int userId) throws Exception {
		List<MenuVO> list = menuDao.queryUserMenuTreeList(userId);
		//转换resources成节点与子节点关联的形式并排
		converAndSortMenuTree(list);
		return list;
	}

	@Override
	public void grantForChildAdmin(int operate, int orgId, String[] resOpers)
			throws Exception {
		if (resOpers != null) {
			// 关区列表
			List<OrgVO> customs = new ArrayList<OrgVO>();
			if (orgId == -1) {
				// 针对所有关区，获取分关组织列表
				customs = orgDao.queryChildCustomsOrg();
			} else { 
				// 针对指定分关
				OrgVO org = new OrgVO();
				org.setOrgId(orgId);
				customs.add(org);
			}
			for (String resOperStr : resOpers) {
				if (resOperStr != null && !resOperStr.equals("")) {
					String[] resOper = resOperStr.split("~");
					if (operate == 1) { // 批量添加权限
						List<OrgResourceVO> orgResList = new ArrayList<OrgResourceVO>();
						List<RoleResourceVO> roleResList = new ArrayList<RoleResourceVO>();
						if (customs != null && !customs.isEmpty()) {
							for (OrgVO orgVO : customs) {
								OrgResourceVO orv = new OrgResourceVO();
								orv.setMenuId(Integer.parseInt(resOper[0]));
								orv.setOperKey(resOper[1]);
								orv.setOrgId(orgVO.getOrgId());
								// 判断组织是否已经有该权限,有不重复添加
								if (orgDao.getOrgResCount(orv) < 1) {
									orgResList.add(orv);
								}
								// 获取分关管理员角色
								RoleVO role = roleDao.queryAdminRoleByOrgId(orgVO.getOrgId());
								RoleResourceVO rrv = new RoleResourceVO();
								rrv.setMenuId(Integer.parseInt(resOper[0]));
								rrv.setOperKey(resOper[1]);
								rrv.setOrgId(orgVO.getOrgId());
								rrv.setRoleId(role.getRoleId());
								// 判断角色是否已经有该权限，有不重复添加
								if (!roleDao.existRoleResource(rrv)) {
									roleResList.add(rrv);
								}
							}
						}
						// 为分关组织添加权限
						if (!orgResList.isEmpty()) {
							orgDao.insertOrgResource(orgResList);
						}
						// 为分关管理员角色添加权限
						if (!roleResList.isEmpty()) {
							roleDao.insertRoleResource(roleResList);
						}
					} else { // 批量移除权限
						if (customs != null && !customs.isEmpty()) {
							for (OrgVO orgVO : customs) {
								// 获取海关下的所有子组织
								List<OrgVO> childOrgs = orgDao.queryChildOrgByOrgId(orgVO.getOrgId());
								StringBuffer sb = new StringBuffer();
								if (childOrgs != null && !childOrgs.isEmpty()) {
									for (OrgVO childOrg : childOrgs) {
										sb.append(childOrg.getOrgId());
										sb.append(",");
									}
								}
								sb.append(orgVO.getOrgId());
								OrgResourceVO orv = new OrgResourceVO();
								orv.setMenuId(Integer.parseInt(resOper[0]));
								orv.setOperKey(resOper[1]);
								orv.setIds(sb.toString());
								// 删除组织资源并级联删除角色资源
								orgDao.deleteOrgResource(orv);
							}
						}
					}
				}
			}
		}
	}
}
