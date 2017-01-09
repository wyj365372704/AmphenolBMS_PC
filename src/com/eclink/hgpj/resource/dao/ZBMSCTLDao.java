package com.eclink.hgpj.resource.dao;

import java.util.List;

import com.eclink.hgpj.resource.vo.ZBMSCTLVO;

/**
 * MenuDao.java
 *
 * @Title: 菜单资源数据库访问接口
 * @Description: 
 
 * @version 1.0
 *
 */
public interface ZBMSCTLDao {
	
	public List<ZBMSCTLVO> queryZbmsctl(ZBMSCTLVO vo) throws Exception;
	public void updateZbmsctl(ZBMSCTLVO vo) throws Exception;
}
