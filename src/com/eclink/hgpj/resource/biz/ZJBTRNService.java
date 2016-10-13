package com.eclink.hgpj.resource.biz;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ZDEPTVO;
import com.eclink.hgpj.resource.vo.ZEMPMSTVO;
import com.eclink.hgpj.resource.vo.ZJBTRNVO;
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
public interface ZJBTRNService {
	public List<ZJBTRNVO> queryZjbtrnByMap(Map map) throws Exception;
	public List<ZJBTRNVO> queryZjbtrnByJtdnoLike(String s) throws Exception;
	public void insertZjbtrn(ZJBTRNVO vo) throws Exception;
	public void updateZjbtrn(ZJBTRNVO vo) throws Exception;
}
