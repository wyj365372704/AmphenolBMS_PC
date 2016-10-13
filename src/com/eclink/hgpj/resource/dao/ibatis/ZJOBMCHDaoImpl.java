package com.eclink.hgpj.resource.dao.ibatis;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.resource.dao.MenuDao;
import com.eclink.hgpj.resource.dao.XADATADao;
import com.eclink.hgpj.resource.dao.ZBMSCTLDao;
import com.eclink.hgpj.resource.dao.ZEMPMSTDao;
import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZJOBEMPDao;
import com.eclink.hgpj.resource.dao.ZJOBMCHDao;
import com.eclink.hgpj.resource.dao.ZMOJOBDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.dao.ZWHSUBDao;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZEMPMSTVO;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZJOBEMPVO;
import com.eclink.hgpj.resource.vo.ZJOBMCHVO;
import com.eclink.hgpj.resource.vo.ZMOJOBVO;
import com.eclink.hgpj.resource.vo.ZSHPHDRVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;
import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * MenuDaoImpl.java
 *
 * @Title: 菜单数据库接口实现类
 * @Description: 

 * @version 1.0
 *
 */
public class ZJOBMCHDaoImpl extends SqlMapClientDaoSupport implements ZJOBMCHDao {

	@Override
	public void insertZjobmch(ZJOBMCHVO vo) throws Exception {
		getSqlMapClientTemplate().insert("ZJOBMCH.insertZjobmch", vo);
	}

	@Override
	public List<ZJOBMCHVO> queryByMapWithEmpName(Map map) throws Exception {
		return getSqlMapClientTemplate().queryForList("ZJOBMCH.queryByMapWithEmpName", map);
	}

	@Override
	public void updateZjobmchJstat(ZJOBMCHVO vo) throws Exception {
		getSqlMapClientTemplate().update("ZJOBMCH.updateZjobmchJstat", vo);
	}
}
