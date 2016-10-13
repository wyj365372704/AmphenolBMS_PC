package com.eclink.hgpj.resource.biz;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ZMOJOBVO;
import com.eclink.hgpj.resource.vo.ZPLNMSTVO;

/**
 * MenuService.java
 *
 * @Title: 菜单业务接口
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:12:44 PM
 *
 */
public interface ZPLNMSTService {
	public List<ZPLNMSTVO> queryZplnmst(Map map) throws Exception;
	public List<ZPLNMSTVO> queryZplnmstByMap(Map map) throws Exception;
}
