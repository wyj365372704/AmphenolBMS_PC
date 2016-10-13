package com.eclink.hgpj.setting.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.setting.dao.WindowDao;
import com.eclink.hgpj.setting.vo.WindowVO;

/**
 * WindowDaoImpl.java
 *
 * @Title:
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 周灵舟
 * @version 1.0
 * @date May 16, 2013 11:06:08 AM
 *
 */
public class WindowDaoImpl extends SqlMapClientDaoSupport implements WindowDao {

	@Override
	public void delete(BaseVO vo) throws Exception {
		this.getSqlMapClientTemplate().delete("WINDOW.deleteWindow",vo);
	}

	@Override
	public int insert(BaseVO vo) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().insert("WINDOW.insertWindow",vo);
	}

	@Override
	public void modify(BaseVO vo) throws Exception {
		this.getSqlMapClientTemplate().update("WINDOW.modifyWindow",vo);
	}

	@Override
	public WindowVO queryById(int id) throws Exception {
		return (WindowVO)this.getSqlMapClientTemplate().queryForObject("WINDOW.queryById", id);
	}

	@Override
	public List<WindowVO> queryList(WindowVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("WINDOW.queryList", vo);
	}

	@Override
	public int queryListCount(WindowVO vo) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("WINDOW.queryListCount", vo);
	}

}
