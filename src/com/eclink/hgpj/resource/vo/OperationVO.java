package com.eclink.hgpj.resource.vo;

import java.util.List;

import com.eclink.hgpj.base.BaseVO;

/**
 * @Title: 操作值对象类
 * @Description: 
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date Mar 8, 2012 4:30:24 PM
 * 
 */
public class OperationVO extends BaseVO{

	/** 菜单ID */
	private int menuId;

    /** 操作名称 */
    private String operName;

    /** 操作KEY */
    private String operKey;

    /** 前置KEY */
    private String preKey;
    
    /** 操作显示的顺序 */
    private int orderKey;
    
    /**操作是否勾选*/
    private String selected = "N";
    
    /** 操作所属菜单 */
    private String menuName;
    
    /** 操作地址列表 */
    private List<AddressVO> addressList;
    
	public List<AddressVO> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AddressVO> addressList) {
		this.addressList = addressList;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getOperKey() {
        return operKey;
    }

    public void setOperKey(String operKey) {
        this.operKey = operKey;
    }

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getPreKey() {
		return preKey;
	}

	public void setPreKey(String preKey) {
		this.preKey = preKey;
	}

	public int getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(int orderKey) {
		this.orderKey = orderKey;
	}

	@Override
	public boolean equals(Object obj) {
		OperationVO opvo = (OperationVO)obj;
		return this.menuId==opvo.menuId && this.operKey.equals(opvo.operKey);
	}	

}