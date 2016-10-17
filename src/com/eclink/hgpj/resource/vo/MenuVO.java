package com.eclink.hgpj.resource.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.util.MenuTreeComparator;

/**
 * @Title: 菜单资源值对象类  
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date 2013-05-16 下午02:53:06
 * 
 */
public class MenuVO extends BaseVO{
	
	private static final long serialVersionUID = 2317968819354022841L;
	
    /** 菜单ID */
    private String menuId;

    /** 菜单名称 */
    private String menuName;

    /** 父菜单ID */
    private String parentMenu;

    /** 菜单KEY */
    private String menuKey;

    /** 菜单图标URL */
    private String imageUrl;

    /** 菜单入口URL */
    private String menuUrl;

    /** 菜单显示顺序 */
    private int menuOrder;
    
    private String menuType;
    
    /** 父菜单名称 */
    private String parentMenuName;
    
    /** 修改前的菜单KEY */
    private String oldMenuKey;
    
    /** 编码后的菜单访问入口URL */
    private String encoderMenuUrl;
    
    private List<OperationVO> operList = new ArrayList();

	private List<MenuVO> subMenuList =new ArrayList();//
	
    public String getOldMenuKey() {
		return oldMenuKey;
	}

	public void setOldMenuKey(String oldMenuKey) {
		this.oldMenuKey = oldMenuKey;
	}

	public String getParentMenuName() {
		return parentMenuName;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public void setParentMenuName(String parentMenuName) {
		this.parentMenuName = parentMenuName;
	}

	public List<MenuVO> getSubMenuList() {
		return subMenuList;
	}

	public void setSubMenuList(List<MenuVO> subMenuList) {
		this.subMenuList = subMenuList;
	}

	public List<OperationVO> getOperList() {
		return operList;
	}

	public void setOperList(List<OperationVO> operList) {
		this.operList = operList;
	}
	
	public void addChildMenu(MenuVO menu){
		subMenuList.add(menu);
	}
	
	public boolean hasChilds(){
		return null!=subMenuList&&!subMenuList.isEmpty();
	}

	public void sortChildMenus(Comparator comparator){
		if (hasChilds()){
			Collections.sort(subMenuList,comparator);
			for (Iterator iter = subMenuList.iterator(); iter.hasNext();){
				MenuVO child =(MenuVO)iter.next();
				child.sortChildMenus(comparator);
			}
		}
	}
	public void sortChildMenus(){
		sortChildMenus(new MenuTreeComparator());
	}
	


    public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(String parentMenu) {
        this.parentMenu = parentMenu;
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(int menuOrder) {
        this.menuOrder = menuOrder;
    }

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getEncoderMenuUrl() {
		if (StringUtils.isEmpty(this.menuUrl)) {
			return "";
		}
		String encoder;
		try {
			encoder = URLEncoder.encode(this.menuUrl, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			encoder = "";
		}
		return encoder;
	}
	
}