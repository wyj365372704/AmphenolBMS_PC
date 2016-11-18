package com.eclink.hgpj.resource.dao.ibatis;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.resource.dao.MenuDao;
import com.eclink.hgpj.resource.dao.XADATADao;
import com.eclink.hgpj.resource.dao.ZBMSCTLDao;
import com.eclink.hgpj.resource.dao.ZGRNHDRDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.dao.ZVRHDRDao;
import com.eclink.hgpj.resource.dao.ZWHSUBDao;
import com.eclink.hgpj.resource.vo.ITMRVAVO;
import com.eclink.hgpj.resource.vo.ITMSITVO;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.ZBMSCTLVO;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZSHPHDRVO;
import com.eclink.hgpj.resource.vo.ZVRHDRVO;
import com.eclink.hgpj.resource.vo.ZVRITMVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;
import com.eclink.hgpj.util.Utils;
import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * MenuDaoImpl.java
 *
 * @Title: 菜单数据库接口实现类
 * @Description: 

 * @version 1.0
 *
 */
public class ZVRHDRDaoImpl extends SqlMapClientDaoSupport implements ZVRHDRDao {
	@Override
	public List<ZVRHDRVO> queryZvrhdr(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZVRHDR.queryZvrhdr",map);
	}

	@Override
	public List<ZVRHDRVO> queryZvrhdrDesc(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZVRHDR.queryZvrhdrDesc",map);
	}

	@Override
	public List<ZVRHDRVO> queryZvritm(Map map) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZVRHDR.queryZvritm",map);
	}
	
	public String insertZvrhdr(ZVRHDRVO vo) throws Exception {
		String result = "";
		List<ZVRHDRVO> queryForList = queryZvrhdrDesc(new HashMap());
		if(queryForList.size()>0){
			result = queryForList.get(0).getVrdno().substring(8,12);
			result = "0000"+(Integer.parseInt(result)+1);
			result = result.substring(result.length() - 4,result.length());
			result = queryForList.get(0).getVrdno().substring(0,8)+result;
		}else{
			result = "VR"+Utils.formateDate(null, "yyMMdd")+"0001";
		}
		vo.setVrdno(result);
		/*vo.setVndnr(vndnr);
		vo.setOstat("10");
		vo.setCrus(crus);
		vo.setCrdt(new BigDecimal("1"+Utils.formateDate(null, "yyMMdd")));
		vo.setCrtm(new BigDecimal(Utils.formateDate(null, "HHmmss")));*/
		this.getSqlMapClientTemplate().insert("ZVRHDR.insertZvrhdr",vo);
		return result;
	}
	
	public void insertZvritm(ZVRITMVO vo) throws Exception{
		String enableNewVrdln = "";
		List<ZVRITMVO> queryForList = this.getSqlMapClientTemplate().queryForList("ZVRHDR.queryZvritmOBVrdlnDesc",vo.getVrdno());
		if(queryForList.size()>0){
			enableNewVrdln = String.valueOf(queryForList.get(0).getVrdln().intValue()+1);
		}else{
			enableNewVrdln = "1";
		}
		vo.setVrdln(new BigDecimal(enableNewVrdln));
		this.getSqlMapClientTemplate().insert("ZVRHDR.insertZvritm",vo);
	}

	@Override
	public void deleteZvritm(ZVRITMVO vo) throws Exception {
		this.getSqlMapClientTemplate().delete("ZVRHDR.deleteZvritm",vo);
	}

	@Override
	public void changeZvrhdrState(ZVRHDRVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("ZVRHDR.changeZvrhdrState",vo);
	}

}












