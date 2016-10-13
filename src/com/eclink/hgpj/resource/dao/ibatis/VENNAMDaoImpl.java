package com.eclink.hgpj.resource.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.resource.dao.VENNAMDao;
import com.eclink.hgpj.resource.vo.VENNAMVO;

public class VENNAMDaoImpl extends SqlMapClientDaoSupport implements VENNAMDao{

	@Override
	public List<VENNAMVO> queryVennam(Map map) throws Exception{
		return this.getSqlMapClientTemplate().queryForList("VENNAM.queryVennam", map);
	}

}
