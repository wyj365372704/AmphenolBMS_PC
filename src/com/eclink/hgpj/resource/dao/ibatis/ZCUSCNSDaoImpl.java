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
import com.eclink.hgpj.resource.dao.ZCUSCNSDao;
import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZCUSCNSVO;
import com.eclink.hgpj.resource.vo.ZCUSMRKVO;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZSHPHDRVO;
import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * MenuDaoImpl.java
 *
 * @Title: 菜单数据库接口实现类
 * @Description: 

 * @version 1.0
 *
 */
public class ZCUSCNSDaoImpl extends SqlMapClientDaoSupport implements ZCUSCNSDao {

	@Override
	public List<ZCUSCNSVO> queryZcuscns(ZCUSCNSVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZCUSCNS.queryZcuscns",vo);
	}

	@Override
	public List<ZCUSMRKVO> queryZcusmrk(ZCUSMRKVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZCUSCNS.queryZcusmrk",vo);
	}


}
