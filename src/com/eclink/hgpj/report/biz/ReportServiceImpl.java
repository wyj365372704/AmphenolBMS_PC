package com.eclink.hgpj.report.biz;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.report.dao.ReportDao;
/**
 * ReportServiceImpl.java
 *
 * @Title: 统计查询业务接口实现类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author caibin
 * @version 1.0
 * @date May 16, 2013 4:49:59 PM
 *
 */
public class ReportServiceImpl implements ReportService {
    private ReportDao reportDao;

    public int queryBizCount(Map map) throws Exception {
        return reportDao.queryBizCount(map);
    }
    public List<Map> queryBizList(Map map) throws Exception {
        return reportDao.queryBizList(map);
    }
    public int queryWindowCount(Map map) throws Exception {
        return reportDao.queryWindowCount(map);
    }
    public List<Map> queryWindowList(Map map) throws Exception {
        return reportDao.queryWindowList(map);
    }
    public List<Map> queryWindowKeList(Map map) throws Exception {
        return reportDao.queryWindowKeList(map);
    }
    public Map queryWindowKeListSum(Map map) throws Exception {
        return reportDao.queryWindowKeListSum(map);
    }
    public List<Map> queryWindowGuanList(Map map) throws Exception {
        return reportDao.queryWindowGuanList(map);
    }
    public Map queryWindowGuanListSum(Map map) throws Exception {
        return reportDao.queryWindowGuanListSum(map);
    }
    public int queryOfficerCount(Map map) throws Exception {
        return reportDao.queryOfficerCount(map);
    }
    public List<Map> queryOfficerList(Map map) throws Exception {
        return reportDao.queryOfficerList(map);
    }
    public List<Map> queryOfficerKeList(Map map) throws Exception {
        return reportDao.queryOfficerKeList(map);
    }
    public Map queryOfficerKeListSum(Map map) throws Exception {
        return reportDao.queryOfficerKeListSum(map);
    }
    public List<Map> queryOfficerGuanList(Map map) throws Exception {
        return reportDao.queryOfficerGuanList(map);
    }
    public Map queryOfficerGuanListSum(Map map) throws Exception {
        return reportDao.queryOfficerGuanListSum(map);
    }
    public int queryEvaluationCount(Map map) throws Exception {
        return reportDao.queryEvaluationCount(map);
    }
    public List<Map> queryEvaluationList(Map map) throws Exception {
        return reportDao.queryEvaluationList(map);
    }
    public Map queryEvaluationById(int evalId) throws Exception {
        return reportDao.queryEvaluationById(evalId);
    }
    

    public List<Map> queryAllCustomsList() throws Exception {
        return reportDao.queryAllCustomsList();
    }
    public List<Map> queryOrgListByCustomsId(int customsId) throws Exception {
        return reportDao.queryOrgListByCustomsId(customsId);
    }
    public List<Map> queryWindowListByOrgId(int orgId) throws Exception {
        return reportDao.queryWindowListByOrgId(orgId);
    }
    public List<Map> queryServiceListByCustomsId(int customsId) throws Exception {
        return reportDao.queryServiceListByCustomsId(customsId);
    }
    
    public ReportDao getReportDao() {
        return reportDao;
    }

    public void setReportDao(ReportDao reportDao) {
        this.reportDao = reportDao;
    }
}
