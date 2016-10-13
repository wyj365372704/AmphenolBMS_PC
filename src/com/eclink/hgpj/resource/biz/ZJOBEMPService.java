package com.eclink.hgpj.resource.biz;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZJBTRNVO;
import com.eclink.hgpj.resource.vo.ZJOBEMPVO;
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
public interface ZJOBEMPService {
	public List<ZJOBEMPVO> queryByMapWithEmpName(Map map) throws Exception;
	public void insertZjobemp(ZJOBEMPVO vo) throws Exception;
	public void updateZjobempJstat(ZJOBEMPVO vo) throws Exception;
	
}
