package com.eclink.hgpj.setting.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.setting.dao.CustomsServiceDao;
import com.eclink.hgpj.setting.vo.CustomsServiceVO;

/**
 * ServiceDaoImpl.java
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
public class CustomsServiceDaoImpl extends SqlMapClientDaoSupport implements CustomsServiceDao {

	@Override
	public void delete(BaseVO vo) throws Exception {
	}

	@Override
	public void deleteServiceByOrgId(int orgId) throws Exception {
		this.getSqlMapClientTemplate().delete("CUSTOMSSERVICE.deleteServiceByOrgId", orgId);
	}

	@Override
	public int insert(BaseVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("CUSTOMSSERVICE.insertService",vo);
		return 0;
	}

	@Override
	public void modify(BaseVO vo) throws Exception {
	}

	@Override
	public List<CustomsServiceVO> queryList(CustomsServiceVO vo) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("CUSTOMSSERVICE.queryList", vo);
	}

	@Override
	public CustomsServiceVO queryEvaluationByOrgIdAndServiceId(CustomsServiceVO vo) throws Exception {
		return (CustomsServiceVO)this.getSqlMapClientTemplate().queryForObject("CUSTOMSSERVICE.queryEvaluationByOrgIdAndServiceId", vo);
	}

	@Override
	public List<CustomsServiceVO> queryEvaluationList(Integer orgId) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("CUSTOMSSERVICE.queryEvaluationList", orgId);
	}

	@Override
	public int queryListCount(CustomsServiceVO vo) throws Exception {
		return (Integer)this.getSqlMapClientTemplate().queryForObject("CUSTOMSSERVICE.queryListCount", vo);
	}

	@Override
	public List<CustomsServiceVO> queryByOrgId(int id) throws Exception {
		return this.getSqlMapClientTemplate().queryForList("CUSTOMSSERVICE.queryByOrgId", id);
	}

}
