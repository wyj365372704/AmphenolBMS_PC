package com.eclink.hgpj.resource.dao;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZEMPMSTVO;
import com.eclink.hgpj.resource.vo.ZJBTRNVO;
import com.eclink.hgpj.resource.vo.ZJOBEMPVO;
import com.eclink.hgpj.resource.vo.ZMOJOBVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;

/**
 *
 * @Description: 
 
 * @version 1.0
 *
 */
public interface ZJBTRNDao {
	
	public void insertZjbtrn(ZJBTRNVO vo) throws Exception;
	public void updateZjbtrn(ZJBTRNVO vo) throws Exception;
	
	public List<ZJBTRNVO> queryZjbtrnByMap(Map map) throws Exception;
	public List<ZJBTRNVO> queryZjbtrnByJtdnoLike(String s) throws Exception;
}
