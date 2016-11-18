package com.eclink.hgpj.resource.dao.ibatis;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.resource.dao.MenuDao;
import com.eclink.hgpj.resource.dao.XADATADao;
import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MODATAVO;
import com.eclink.hgpj.resource.vo.MODESCVO;
import com.eclink.hgpj.resource.vo.MOMASTVO;
import com.eclink.hgpj.resource.vo.MOPORFVO;
import com.eclink.hgpj.resource.vo.MOROUTVO;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.POBLKTVO;
import com.eclink.hgpj.resource.vo.POITEMVO;
import com.eclink.hgpj.resource.vo.POMASTVO;
import com.eclink.hgpj.resource.vo.SCHRCPVO;
import com.eclink.hgpj.resource.vo.SHPMSTVO;
import com.eclink.hgpj.resource.vo.SLDATAVO;
import com.eclink.hgpj.resource.vo.SLQNTYVO;
import com.eclink.hgpj.resource.vo.VENNAMVO;
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
public class XADATADaoImpl extends SqlMapClientDaoSupport implements XADATADao {

	@Override
	public List<String> queryItrvt(ITMSITVO map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryItrvt",map);
	}

	@Override
	public List<ITMRVAVO> queryItmrva(ITMRVAVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryItmrva",vo);
	}

	@Override
	public List<SLQNTYVO> querySlqnty(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.querySlqnty",map);
	}

	@Override
	public List<MOMASTVO> queryMomast(MOMASTVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryMomast",vo);
	}

	@Override
	public List<SLDATAVO> querySldata(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.querySldata",map);
	}

	@Override
	public List<MODATAVO> queryModatas(MODATAVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryModatas",vo);
	}

	@Override
	public List<MOMASTVO> queryMomastByordno(MOMASTVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryMomastByordno",vo);
	}

	@Override
	public List<MOMASTVO> queryMomastBystate(MOMASTVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryMomastBystate",vo);
	}

	@Override
	public List<MOPORFVO> queryMoporf(MOPORFVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryMoporf",vo);
	}
	
	@Override
	public List<MOPORFVO> queryMoporfNormal(MOPORFVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryMoporfNormal",vo);
	}

	@Override
	public List<String> queryBuyer(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryBuyer",map);
	}

	@Override
	public List<POITEMVO> queryPoitem(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryPoitem",map);
	}

	@Override
	public List<POMASTVO> queryPomast(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryPomast",map);
	}

	@Override
	public List<SHPMSTVO> queryShpmst(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryShpmst",map);
	}

	@Override
	public List<ITMSITVO> queryItrvtAll(ITMSITVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryItrvtAll",vo);
	}

	@Override
	public List<POBLKTVO> queryPoblkt(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryPoblkt",map);
	}

	@Override
	public List<String> queryBMCBTX(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryBMCBTX",map);
	}

	@Override
	public List<String> queryCusnm(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryCusnm",map);
	}

	@Override
	public List<String> queryMBADREP(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryMBADREP",map);
	}

	@Override
	public List<String> queryMBC6REP(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryMBC6REP",map);
	}
	
	@Override
	public List<String> queryEEKANB(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryEekanb",map);
	}
	
	@Override
	public List<String> queryAXHDTX(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryAxhdtx",map);
	}

	@Override
	public List<String> queryMBCDREP(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryMBCDREP",map);
	}

	@Override
	public List<MOROUTVO> queryMorout(Map map) throws Exception {
		return  this.getSqlMapClientTemplate().queryForList("XADATA.queryMorout",map);
	}

	@Override
	public List<VENNAMVO> queryVennam(Map map) {
		return  this.getSqlMapClientTemplate().queryForList("XADATA.queryVennam",map);
	}

	@Override
	public List<MOMASTVO> queryMomastPrinted(MOMASTVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryMomastPrinted",vo);
	}

	@Override
	public List<MOMASTVO> queryMomastNoCarePrint(MOMASTVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryMomastNoCarePrint",vo);
	}

	@Override
	public List<MODESCVO> queryModesc(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("XADATA.queryModesc",map);
	}

	@Override
	public List<SCHRCPVO> querySchrcp(SCHRCPVO vo) {
		return this.getSqlMapClientTemplate().queryForList("XADATA.querySchrcp",vo);
	}


}
