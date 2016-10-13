package com.eclink.hgpj.resource.dao;

import java.util.List;

import com.eclink.hgpj.resource.vo.ZBMSU01VO;

/**
 * MenuDao.java
 *
 * @Title: 菜单资源数据库访问接口
 * @Description: 
 
 * @version 1.0
 *
 */
public interface ZBMSU01Dao {
	
	public List<ZBMSU01VO> queryZbmsu(ZBMSU01VO vo) throws Exception;
}
