package com.eclink.hgpj.resource.dao.ibatis;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.resource.dao.MenuDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.ZSHPBCHVO;
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
public class ZSHPHDRDaoImpl extends SqlMapClientDaoSupport implements ZSHPHDRDao {



	@Override
	public List<ZSHPHDRVO> queryReceipt(String shpno) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZSHPHDR.queryReceipt", shpno);
	}

	@Override
	public void updateZshphdr(String shpno) throws Exception {
		this.getSqlMapClientTemplate().update("ZSHPHDR.updateZshphdr", shpno);
	}

	@Override
	public void updateZshpitm(String shpno) throws Exception {
		this.getSqlMapClientTemplate().update("ZSHPHDR.updateZshpitm", shpno);
	}

	@Override
	public List<ZSHPBCHVO> queryBch(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZSHPHDR.queryBch", map);
	}

}
