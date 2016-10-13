package com.eclink.hgpj.resource.dao.ibatis;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.resource.dao.MenuDao;
import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.dao.ZSLLOGDao;
import com.eclink.hgpj.resource.dao.ZTWHDRDao;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZSHPHDRVO;
import com.eclink.hgpj.resource.vo.ZSLLOGVO;
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
public class ZSLLOGDaoImpl extends SqlMapClientDaoSupport implements ZSLLOGDao {

	@Override
	public void insertZsllog(ZSLLOGVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("ZSLLOG.insertZsllog", vo);
	}

	public int getCoutsByDt(BigDecimal crdat) throws Exception {
		List temp = this.getSqlMapClientTemplate().queryForList("ZSLLOG.getCoutsByDt", crdat);
		if(temp!=null){
			return (Integer)temp.get(0);
		}
		return 0;
	}
}
