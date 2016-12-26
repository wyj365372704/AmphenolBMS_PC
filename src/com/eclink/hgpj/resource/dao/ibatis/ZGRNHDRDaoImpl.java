package com.eclink.hgpj.resource.dao.ibatis;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.resource.dao.MenuDao;
import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.vo.MenuVO;
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
public class ZGRNHDRDaoImpl extends SqlMapClientDaoSupport implements ZGRNHDRDao {

	@Override
	public void insertZgrnhdr(ZGRNHDRVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("ZGRNHDR.insertZgrnhdr", vo);
	}

	@Override
	public void insertZgrnitm(ZGRNITMVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("ZGRNHDR.insertZgrnitm", vo);
	}

	@Override
	public List<ZGRNHDRVO> queryReceiptSelf(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZGRNHDR.queryReceiptSelf", map);
	}

	@Override
	public int getCoutsByDt(BigDecimal gtdte) throws Exception {
		List temp = this.getSqlMapClientTemplate().queryForList("ZGRNHDR.getCoutsByDt", gtdte);
		if(temp!=null){
			return (Integer)temp.get(0);
		}
		return 0;
	}

	@Override
	public void insertZgrnbch(ZGRNBCHVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("ZGRNHDR.insertZgrnbch", vo);
	}

	@Override
	public List<ZGRNBCHVO> queryZgrnBch(String grnno) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZGRNHDR.queryZgrnBch", grnno);
	}

	@Override
	public List<ZGRNITMVO> queryReceiptItem(ZGRNITMVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZGRNHDR.queryReceiptItem", vo);
	}

	@Override
	public List<ZGRNBCHVO> queryZgrnBchByln(ZGRNITMVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZGRNHDR.queryZgrnBchByln", vo);
	}

	@Override
	public int getCoutsByState(String state) throws Exception {
		List temp = this.getSqlMapClientTemplate().queryForList("ZGRNHDR.getCoutsByState", state);
		if(temp!=null){
			return (Integer)temp.get(0);
		}
		return 0;
	}

	@Override
	public void updateHdrStat(ZGRNHDRVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("ZGRNHDR.updateHdrStat", vo);
	}

	@Override
	public void updateItemStat(ZGRNITMVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("ZGRNHDR.updateItemStat", vo);
	}

	@Override
	public void deleteBch(ZGRNBCHVO vo) throws Exception {
		this.getSqlMapClientTemplate().delete("ZGRNHDR.deleteBch", vo);
	}

	@Override
	public void updateBch(ZGRNBCHVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("ZGRNHDR.updateBch", vo);
	}

	@Override
	public void updateItem(ZGRNITMVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("ZGRNHDR.updateItem", vo);
	}

	@Override
	public int getMaxGrnbn(ZGRNITMVO vo) throws Exception {
		List temp = this.getSqlMapClientTemplate().queryForList("ZGRNHDR.getMaxGrnbn", vo);
		if(temp!=null && temp.size()>0){
			return (Integer)temp.get(0);
		}
		return 0;
	}

	@Override
	public ZGRNHDRVO queryZgrnByNo(String grnno) throws Exception {
		List<ZGRNHDRVO> list = this.getSqlMapClientTemplate().queryForList("ZGRNHDR.queryZgrnByNo", grnno);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<ZGRNHDRVO> queryReceiptList(ZGRNITMVO vo) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("ZGRNHDR.queryReceiptList", vo);
	}

	@Override
	public List<ZGRNITMVO> queryReceiptItems(ZGRNITMVO vo) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("ZGRNHDR.queryReceiptItems", vo);
	}

	@Override
	public List<ZGRNITMVO> queryZgrnitm(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZGRNHDR.queryZgrnitm", map);
	}
}
