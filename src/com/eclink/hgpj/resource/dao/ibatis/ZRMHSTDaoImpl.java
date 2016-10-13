package com.eclink.hgpj.resource.dao.ibatis;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.resource.dao.MenuDao;
import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZRMHSTDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.dao.ZSLLOGDao;
import com.eclink.hgpj.resource.dao.ZTWHDRDao;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZRMHSTVO;
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
public class ZRMHSTDaoImpl extends SqlMapClientDaoSupport implements ZRMHSTDao {


	public int getCoutsByDt(BigDecimal rmdat) throws Exception {
		List temp = this.getSqlMapClientTemplate().queryForList("ZRMHST.getCoutsByDt", rmdat);
		if(temp!=null){
			return (Integer)temp.get(0);
		}
		return 0;
	}

	@Override
	public void insertZrmhst(ZRMHSTVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("ZRMHST.insertZrmhst", vo);
	}

	@Override
	public void deleteZrmhst(String rmdno) throws Exception {
		this.getSqlMapClientTemplate().delete("ZRMHST.deleteZrmhst", rmdno);
	}
}
