package com.eclink.hgpj.resource.dao.ibatis;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.resource.dao.MenuDao;
import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZIPHDRDao;
import com.eclink.hgpj.resource.dao.ZPLHDRDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.ZBMSRSNVO;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZIPDTLVO;
import com.eclink.hgpj.resource.vo.ZIPHDRVO;
import com.eclink.hgpj.resource.vo.ZIPHSTVO;
import com.eclink.hgpj.resource.vo.ZPLBOXVO;
import com.eclink.hgpj.resource.vo.ZPLDTLVO;
import com.eclink.hgpj.resource.vo.ZPLHDRVO;
import com.eclink.hgpj.resource.vo.ZSHPHDRVO;
import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * MenuDaoImpl.java
 *
 * @Title: 生产单数据库接口实现类
 * @Description: 

 * @version 1.0
 *
 */
public class ZPLHDRDaoImpl extends SqlMapClientDaoSupport implements ZPLHDRDao {

	@Override
	public int getCoutsByDt(BigDecimal gtdte) throws Exception {
		List temp = this.getSqlMapClientTemplate().queryForList("ZPLHDR.getCoutsByDt", gtdte);
		if(temp!=null){
			return (Integer)temp.get(0);
		}
		return 0;
	}

	@Override
	public void insertZplbox(ZPLBOXVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("ZPLHDR.insertZplbox", vo);
	}

	@Override
	public void insertZpldtl(ZPLDTLVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("ZPLHDR.insertZpldtl", vo);
	}

	@Override
	public void insertZplhdr(ZPLHDRVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("ZPLHDR.insertZplhdr", vo);
	}

	@Override
	public List<ZPLBOXVO> queryBch(ZPLBOXVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZPLHDR.queryBch", vo);
	}

	@Override
	public double queryDtlQty(ZPLDTLVO vo) throws Exception {
		List temp = this.getSqlMapClientTemplate().queryForList("ZPLHDR.queryDtlQty", vo);
		if(temp!=null){
			return (Integer)temp.get(0);
		}
		return 0;
	}

	@Override
	public List<ZPLDTLVO> queryReceipt(ZPLDTLVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZPLHDR.queryReceipt", vo);
	}

	@Override
	public List<ZPLHDRVO> queryZplhdr(ZPLHDRVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZPLHDR.queryZplhdr", vo);
	}

	@Override
	public void updateZplhdr(String pldno) throws Exception {
		this.getSqlMapClientTemplate().update("ZPLHDR.updateZplhdr", pldno);
	}

	@Override
	public void updateZplitm(ZPLDTLVO VO) throws Exception {
		this.getSqlMapClientTemplate().update("ZPLHDR.updateZplitm", VO);
	}

}
