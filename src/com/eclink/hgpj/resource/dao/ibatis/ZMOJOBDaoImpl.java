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
import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZMOJOBDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.dao.ZWHSUBDao;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
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
public class ZMOJOBDaoImpl extends SqlMapClientDaoSupport implements ZMOJOBDao {
	@Override
	public List<ZMOJOBVO> queryZmojobByMap(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZMOJOB.queryZmojobByMap",map);
	}

	@Override
	public void insertZmojob(ZMOJOBVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("ZMOJOB.insertZmojob",vo);
		
	}

	@Override
	public String queryMaxIndex(String string) throws Exception {
		List<String> zmojobList = getSqlMapClientTemplate().queryForList("ZMOJOB.queryMaxIndex",string);
		if(zmojobList!=null && zmojobList.size()>0){
			return zmojobList.get(0);
		}
		return "";
	}

	@Override
	public void updateZmojob(ZMOJOBVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("ZMOJOB.updateZmojob",vo);
	}

}
