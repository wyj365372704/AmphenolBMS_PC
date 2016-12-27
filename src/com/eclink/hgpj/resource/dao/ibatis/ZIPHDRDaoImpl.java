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
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.ZBMSRSNVO;
import com.eclink.hgpj.resource.vo.ZGRNBCHVO;
import com.eclink.hgpj.resource.vo.ZGRNHDRVO;
import com.eclink.hgpj.resource.vo.ZGRNITMVO;
import com.eclink.hgpj.resource.vo.ZIPDTLVO;
import com.eclink.hgpj.resource.vo.ZIPHDRVO;
import com.eclink.hgpj.resource.vo.ZIPHSTVO;
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
public class ZIPHDRDaoImpl extends SqlMapClientDaoSupport implements ZIPHDRDao {

	@Override
	public int getCoutsByDt(BigDecimal gtdte) throws Exception {
		List temp = this.getSqlMapClientTemplate().queryForList("ZIPHDR.getCoutsByDt", gtdte);
		if(temp!=null){
			return (Integer)temp.get(0);
		}
		return 0;
	}

	@Override
	public void insertZipdtl(ZIPDTLVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("ZIPHDR.insertZipdtl", vo);
	}

	@Override
	public void insertZiphdr(ZIPHDRVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("ZIPHDR.insertZiphdr", vo);
	}

	@Override
	public void insertZiphst(ZIPHSTVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("ZIPHDR.insertZiphst", vo);
	}

	@Override
	public List<ZIPDTLVO> queryItems(ZIPDTLVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZIPHDR.queryItems", vo);
	}
	
	@Override
	public List<ZIPDTLVO> queryItemsWsubOrder(ZIPDTLVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZIPHDR.queryItemsWsubOrder", vo);
	}

	@Override
	public List<ZIPDTLVO> queryItemsBytype(ZIPDTLVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZIPHDR.queryItemsBytype", vo);
	}

	@Override
	public double getAllshqty(ZIPDTLVO vo) throws Exception {
		List temp = this.getSqlMapClientTemplate().queryForList("ZIPHDR.getAllshqty", vo);
		if(temp!=null){
			if(temp.get(0)!=null){
				return (Double)temp.get(0);
			}
			
		}
		return 0;
	}

	@Override
	public int getDtlCoutsBypar(Map map) throws Exception {
		List temp = this.getSqlMapClientTemplate().queryForList("ZIPHDR.getDtlCoutsBypar", map);
		if(temp!=null){
			return (Integer)temp.get(0);
		}
		return 0;
	}

	@Override
	public List<ZIPHDRVO> queryHdrs(ZIPHDRVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZIPHDR.queryHdrs", vo);
	}

	@Override
	public List<ZIPHSTVO> queryHstItems(ZIPHSTVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZIPHDR.queryHstItems", vo);
	}

	@Override
	public void updateZiphdrStat(ZIPHDRVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("ZIPHDR.updateZiphdrStat", vo);
	}
	
	@Override
	public void updateZiphdrForApproval(ZIPHDRVO vo) throws Exception{
		this.getSqlMapClientTemplate().update("ZIPHDR.updateZiphdrForApproval", vo);
	}

	@Override
	public void updateZiphdrLprt(ZIPHDRVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("ZIPHDR.updateZiphdrLprt", vo);
	}

	@Override
	public void updateZiphst(ZIPHSTVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("ZIPHDR.updateZiphst", vo);
	}

	@Override
	public void updateZiphstS(ZIPHSTVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("ZIPHDR.updateZiphstS", vo);
	}

	@Override
	public void updateZipitm(ZIPDTLVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("ZIPHDR.updateZipitm", vo);
	}

	@Override
	public void updateZipitmStat(ZIPDTLVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("ZIPHDR.updateZipitmStat", vo);
	}

	@Override
	public void deleteZipdtl(ZIPDTLVO vo) throws Exception {
		this.getSqlMapClientTemplate().delete("ZIPHDR.deleteZipdtl", vo);
	}

	@Override
	public void updateZipitmQty(ZIPDTLVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("ZIPHDR.updateZipitmQty", vo);
	}

	@Override
	public List<ZBMSRSNVO> getReason(Map rpmap) throws Exception {

		return this.getSqlMapClientTemplate().queryForList("ZIPHDR.getReason", rpmap);
	}

	@Override
	public List<ZIPHDRVO> queryHdrsByPar(Map vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZIPHDR.queryHdrsByPar", vo);
	}
	@Override
	public List<ZIPHDRVO> queryHdrsByParForApproval(Map vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("ZIPHDR.queryHdrsByParForApproval", vo);
	}

	@Override
	public void deleteZiphdr(ZIPHDRVO vo) throws Exception {
		this.getSqlMapClientTemplate().delete("ZIPHDR.deleteZiphdr", vo);
	}

	@Override
	public void deleteZiphst(ZIPHSTVO vo) throws Exception {
		this.getSqlMapClientTemplate().delete("ZIPHDR.deleteZiphst", vo);
	}

}
