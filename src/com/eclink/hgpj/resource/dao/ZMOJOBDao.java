package com.eclink.hgpj.resource.dao;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZMOJOBVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;

/**
 * MenuDao.java
 *
 * @Title: 菜单资源数据库访问接口
 * @Description: 
 
 * @version 1.0
 *
 */
public interface ZMOJOBDao {
	
	public List<ZMOJOBVO> queryZmojobByMap(Map map) throws Exception;

	public void insertZmojob(ZMOJOBVO vo) throws Exception;
	public void updateZmojob(ZMOJOBVO vo) throws Exception;
	
	public String queryMaxIndex(String string) throws Exception ;
}
