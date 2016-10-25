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
import com.eclink.hgpj.resource.dao.ZTWHDRDao;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZSHPHDRVO;
import com.eclink.hgpj.resource.vo.ZTWBCHVO;
import com.eclink.hgpj.resource.vo.ZTWDTLVO;
import com.eclink.hgpj.resource.vo.ZTWHDRVO;
import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * MenuDaoImpl.java
 *
 * @Title: 菜单数据库接口实现类
 * @Description: 

 * @version 1.0
 *
 */
public class ZTWHDRDaoImpl extends SqlMapClientDaoSupport implements ZTWHDRDao {

	@Override
	public void insertZtwbch(ZTWBCHVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("ZTWHDR.insertZtwbch", vo);
	}

	@Override
	public void insertZtwdtl(ZTWDTLVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("ZTWHDR.insertZtwdtl", vo);
		
	}

	@Override
	public void insertZtwhdr(ZTWHDRVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("ZTWHDR.insertZtwhdr", vo);
		
	}

	@Override
	public int getCoutsByDt(BigDecimal twdt1) throws Exception {
		List temp = this.getSqlMapClientTemplate().queryForList("ZTWHDR.getCoutsByDt", twdt1);
		if(temp!=null){
			return (Integer)temp.get(0);
		}
		return 0;
	}

	@Override
	public List<ZTWBCHVO> queryZtwbch(ZTWBCHVO vo) throws Exception {
		return (List<ZTWBCHVO>)this.getSqlMapClientTemplate().queryForList("ZTWHDR.queryZtwbch", vo);
	}

	@Override
	public List<ZTWDTLVO> queryZtwdtl(ZTWDTLVO vo) throws Exception {
		return (List<ZTWDTLVO>)this.getSqlMapClientTemplate().queryForList("ZTWHDR.queryZtwdtl", vo);
	}

	@Override
	public List<ZTWHDRVO> queryZtwhdr(ZTWHDRVO vo) throws Exception {
		return (List<ZTWHDRVO>)this.getSqlMapClientTemplate().queryForList("ZTWHDR.queryZtwhdr", vo);
	}

	@Override
	public void updateHdrStat(ZTWHDRVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("ZTWHDR.updateHdrStat", vo);
	}

	@Override
	public void updateItemBch(ZTWBCHVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("ZTWHDR.updateItemBch", vo);
	}

	@Override
	public void updateItemStat(ZTWDTLVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("ZTWHDR.updateItemStat", vo);
	}
	
	@Override
	public void updateItemPrt(ZTWDTLVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("ZTWHDR.updateItemPrt", vo);
	}

	@Override
	public void updateItemDtl(ZTWDTLVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("ZTWHDR.updateItemDtl", vo);
	}

	@Override
	public List<ZTWHDRVO> queryReceiptList(Map map) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("ZTWHDR.queryZtwhdrList", map);
	}

	

}
