package com.eclink.hgpj.resource.dao;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZVRHDRVO;
import com.eclink.hgpj.resource.vo.ZVRITMVO;
import com.eclink.hgpj.resource.vo.ZVRTRNVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;

/**
 * MenuDao.java
 *
 * @Title: 菜单资源数据库访问接口
 * @Description: 
 
 * @version 1.0
 *
 */
public interface ZVRHDRDao {
	
	public List<ZVRHDRVO> queryZvrhdr(Map map) throws Exception;
	public List<ZVRITMVO> queryZvritm(Map map) throws Exception;

	
	/**
	 * 插入一条表头记录
	 * @return
	 * @throws Exception
	 */
	public String insertZvrhdr(ZVRHDRVO vo) throws Exception;
	
	public void insertZvritm(ZVRITMVO vo) throws Exception;

	public void insertZvrtrn(ZVRTRNVO vo) throws Exception;
	
	public void deleteZvritm(ZVRITMVO vo) throws Exception;
	
	public void changeZvritmState(ZVRITMVO vo) throws Exception;
	
	public void changeZvrhdrState(ZVRHDRVO vo) throws Exception;
}
