package com.eclink.hgpj.resource.dao;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.ZSHPBCHVO;
import com.eclink.hgpj.resource.vo.ZSHPHDRVO;

/**
 * MenuDao.java
 *
 * @Title: 菜单资源数据库访问接口
 * @Description: 
 
 * @version 1.0
 *
 */
public interface ZSHPHDRDao {
	
	public List<ZSHPHDRVO> queryReceipt(String shpno) throws Exception;
	
	public List<ZSHPBCHVO> queryBch(Map map) throws Exception;	
	
	public void updateZshphdr(String shpno) throws Exception;
	
	public void updateZshpitm(String shpno) throws Exception;
	
}
