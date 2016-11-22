package com.eclink.hgpj.resource.biz;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZSHPBCHVO;
import com.eclink.hgpj.resource.vo.ZSHPHDRVO;
import com.eclink.hgpj.resource.vo.ZVRHDRVO;
import com.eclink.hgpj.resource.vo.ZVRITMVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;

/**
 * MenuService.java
 *
 * @Title: 菜单业务接口
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:12:44 PM
 *
 */
public interface ZVRHDRService {
	public List<ZVRHDRVO> queryZvrhdr(Map map) throws Exception;
	public List<ZVRITMVO> queryZvritm(Map map) throws Exception;
	public String insertZvritmNewHdr(ZVRITMVO vo,String crus,String house) throws Exception;
	public void insertZvritm(ZVRITMVO vo) throws Exception;
	
	public void deleteZvritm(ZVRITMVO vo) throws Exception;
	
	public void enableCreateZvritm(String vrdno) throws Exception;
	
	public void cancelZvritm(String vrdno) throws Exception;
}
