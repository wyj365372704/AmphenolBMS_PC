package com.eclink.hgpj.resource.dao;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZEMPMSTVO;
import com.eclink.hgpj.resource.vo.ZMCHMSTVO;
import com.eclink.hgpj.resource.vo.ZMOJOBVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;

/**
 *
 * @Description: 
 
 * @version 1.0
 *
 */
public interface ZMCHMSTDao {
	
	public List<ZMCHMSTVO> queryZmchmstByMapWithDept(Map map) throws Exception;
}
