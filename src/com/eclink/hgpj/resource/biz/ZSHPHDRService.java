package com.eclink.hgpj.resource.biz;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.ZSHPBCHVO;
import com.eclink.hgpj.resource.vo.ZSHPHDRVO;

/**
 * MenuService.java
 *
 * @Title: 菜单业务接口
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:12:44 PM
 *
 */
public interface ZSHPHDRService {
	
	public List<ZSHPHDRVO> queryReceipt(String shpno) throws Exception;
	
	public List<ZSHPBCHVO> queryBch(Map map) throws Exception;
	
	public void updateZshphdr(String shpno) throws Exception;
	
	public void updateZshpitm(String shpno) throws Exception;
	
}
