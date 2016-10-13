package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.ZITEMBXVO;
import com.eclink.hgpj.resource.vo.ZITMEXTVO;
import com.eclink.hgpj.resource.vo.ZSHPBCHVO;
import com.eclink.hgpj.resource.vo.ZSHPHDRVO;
import com.eclink.hgpj.resource.vo.ZSLLOGVO;

/**
 * MenuService.java
 *
 * @Title: 菜单业务接口
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:12:44 PM
 *
 */
public interface ZSLLOGService {
	public void insertZsllog(ZSLLOGVO vo) throws Exception;
	
	public int getCoutsByDt(BigDecimal crdat) throws Exception;
}
