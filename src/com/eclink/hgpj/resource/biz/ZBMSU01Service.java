package com.eclink.hgpj.resource.biz;

import java.util.List;

import com.eclink.hgpj.resource.vo.ZBMSU01VO;


/**
 * MenuService.java
 *
 * @Title: 菜单业务接口
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:12:44 PM
 *
 */
public interface ZBMSU01Service {
	public List<ZBMSU01VO> queryZbmsu(ZBMSU01VO vo) throws Exception;
}
