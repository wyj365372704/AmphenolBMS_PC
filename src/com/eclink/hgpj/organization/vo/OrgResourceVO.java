package com.eclink.hgpj.organization.vo;

import com.eclink.hgpj.base.BaseVO;

/**
 * OrgResourceVO.java
 *
 * @Title: 组织资源VO类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date May 23, 2013 11:47:44 AM
 *
 */
public class OrgResourceVO extends BaseVO {
	/** 组织ID */
    private int orgId;

    /** 资源ID */
    private int menuId;
    
	/**操作KEY*/
    private String operKey;
    
    /**用于删除**/
    private String ids;

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getOperKey() {
		return operKey;
	}

	public void setOperKey(String operKey) {
		this.operKey = operKey;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
}
