package com.eclink.hgpj.report.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.report.dao.ReportDao;
/**
 * ReportDaoImpl.java
 *
 * @Title: 统计查询接口实现类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author caibin
 * @version 1.0
 * @date May 16, 2013 4:49:59 PM
 *
 */
public class ReportDaoImpl extends SqlMapClientDaoSupport implements ReportDao {
    public int queryBizCount(Map map) throws Exception {
        return (Integer)this.getSqlMapClientTemplate().queryForObject("Report.queryBizCount", map);
    }
    public List<Map> queryBizList(Map map) throws Exception {
        return this.getSqlMapClientTemplate().queryForList("Report.queryBizList", map);
    }
    public int queryWindowCount(Map map) throws Exception {
        return (Integer)this.getSqlMapClientTemplate().queryForObject("Report.queryWindowCount", map);
    }
    public List<Map> queryWindowList(Map map) throws Exception {
        return this.getSqlMapClientTemplate().queryForList("Report.queryWindowList", map);
    }
    public List<Map> queryWindowKeList(Map map) throws Exception {
        return this.getSqlMapClientTemplate().queryForList("Report.queryWindowKeList", map);
    }
    public Map queryWindowKeListSum(Map map) throws Exception {
        return (Map)this.getSqlMapClientTemplate().queryForObject("Report.queryWindowKeListSum", map);
    }
    public List<Map> queryWindowGuanList(Map map) throws Exception {
        return this.getSqlMapClientTemplate().queryForList("Report.queryWindowGuanList", map);
    }
    public Map queryWindowGuanListSum(Map map) throws Exception {
        return (Map)this.getSqlMapClientTemplate().queryForObject("Report.queryWindowGuanListSum", map);
    }
    public int queryOfficerCount(Map map) throws Exception {
        return (Integer)this.getSqlMapClientTemplate().queryForObject("Report.queryOfficerCount", map);
    }
    public List<Map> queryOfficerList(Map map) throws Exception {
        return this.getSqlMapClientTemplate().queryForList("Report.queryOfficerList", map);
    }
    public List<Map> queryOfficerKeList(Map map) throws Exception {
        return this.getSqlMapClientTemplate().queryForList("Report.queryOfficerKeList", map);
    }
    public Map queryOfficerKeListSum(Map map) throws Exception {
        return (Map)this.getSqlMapClientTemplate().queryForObject("Report.queryOfficerKeListSum", map);
    }
    public List<Map> queryOfficerGuanList(Map map) throws Exception {
        return this.getSqlMapClientTemplate().queryForList("Report.queryOfficerGuanList", map);
    }
    public Map queryOfficerGuanListSum(Map map) throws Exception {
        return (Map)this.getSqlMapClientTemplate().queryForObject("Report.queryOfficerGuanListSum", map);
    }
    public int queryEvaluationCount(Map map) throws Exception {
        return (Integer)this.getSqlMapClientTemplate().queryForObject("Report.queryEvaluationCount", map);
    }
    public List<Map> queryEvaluationList(Map map) throws Exception {
        return this.getSqlMapClientTemplate().queryForList("Report.queryEvaluationList", map);
    }
    public Map queryEvaluationById(int evalId) throws Exception {
        return (Map)this.getSqlMapClientTemplate().queryForObject("Report.queryEvaluationById", evalId);
    }
    

    public List<Map> queryAllCustomsList() throws Exception {
        return this.getSqlMapClientTemplate().queryForList("Report.queryAllCustomsList");
    }
    public List<Map> queryOrgListByCustomsId(int customsId) throws Exception {
        return this.getSqlMapClientTemplate().queryForList("Report.queryOrgListByCustomsId", customsId);
    }
    public List<Map> queryWindowListByOrgId(int orgId) throws Exception {
        return this.getSqlMapClientTemplate().queryForList("Report.queryWindowListByOrgId", orgId);
    }
    public List<Map> queryServiceListByCustomsId(int customsId) throws Exception {
        return this.getSqlMapClientTemplate().queryForList("Report.queryServiceListByCustomsId", customsId);
    }
}
