package com.eclink.hgpj.resource.dao;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZEMPMSTVO;
import com.eclink.hgpj.resource.vo.ZJOBEMPVO;
import com.eclink.hgpj.resource.vo.ZMOJOBVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;

/**
 *
 * @Description: 
 
 * @version 1.0
 *
 */
public interface ZJOBEMPDao {
	
	public void updateZjobempJstat(ZJOBEMPVO vo) throws Exception;
	public void insertZjobemp(ZJOBEMPVO vo) throws Exception;
	public List<ZJOBEMPVO>  queryByMapWithEmpName(Map map) throws Exception;
}
