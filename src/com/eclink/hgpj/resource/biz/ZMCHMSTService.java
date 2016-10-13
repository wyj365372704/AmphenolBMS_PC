package com.eclink.hgpj.resource.biz;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ZEMPMSTVO;
import com.eclink.hgpj.resource.vo.ZMCHMSTVO;
import com.eclink.hgpj.resource.vo.ZMOJOBVO;

/**
 * MenuService.java
 *
 * @Title: 菜单业务接口
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:12:44 PM
 *
 */
public interface ZMCHMSTService {
	public List<ZMCHMSTVO> queryZmchmstByMapWithDept(Map map) throws Exception;
}
