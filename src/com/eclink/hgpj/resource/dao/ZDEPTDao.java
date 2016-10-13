package com.eclink.hgpj.resource.dao;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZDEPTVO;
import com.eclink.hgpj.resource.vo.ZEMPMSTVO;
import com.eclink.hgpj.resource.vo.ZMOJOBVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;

/**
 *
 * @Description: 
 
 * @version 1.0
 *
 */
public interface ZDEPTDao {
	
	public List<ZDEPTVO> queryZdeptByMap(Map map) throws Exception;
}
