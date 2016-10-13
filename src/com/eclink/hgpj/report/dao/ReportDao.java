package com.eclink.hgpj.report.dao;

import java.util.List;
import java.util.Map;

/**
 * ReportDao.java
 *
 * @Title: 统计查询接口
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author caibin
 * @version 1.0
 * @date May 16, 2013 4:49:59 PM
 *
 */
public interface ReportDao {
    /**
     * 业务评价统计数量
     * @param map
     * @return
     * @throws Exception
     */
    public int queryBizCount(Map map) throws Exception;
    /**
     * 业务评价统计
     * @param map
     * @return
     * @throws Exception
     */
    public List<Map> queryBizList(Map map) throws Exception;
    /**
     * 窗口评价统计数量
     * @param map
     * @return
     * @throws Exception
     */
    public int queryWindowCount(Map map) throws Exception;
    /**
     * 窗口评价统计
     * @param map
     * @return
     * @throws Exception
     */
    public List<Map> queryWindowList(Map map) throws Exception;
    /**
     * 窗口科级评价汇总
     * @param map
     * @return
     * @throws Exception
     */
    public List<Map> queryWindowKeList(Map map) throws Exception;
    /**
     * 窗口科级评价汇总总计
     * @param map
     * @return
     * @throws Exception
     */
    public Map queryWindowKeListSum(Map map) throws Exception;
    /**
     * 窗口关级评价汇总
     * @param map
     * @return
     * @throws Exception
     */
    public List<Map> queryWindowGuanList(Map map) throws Exception;
    /**
     * 窗口关级评价汇总总计
     * @param map
     * @return
     * @throws Exception
     */
    public Map queryWindowGuanListSum(Map map) throws Exception;
    /**
     * 关员评价统计数量
     * @param map
     * @return
     * @throws Exception
     */
    public int queryOfficerCount(Map map) throws Exception;
    /**
     * 关员评价统计
     * @param map
     * @return
     * @throws Exception
     */
    public List<Map> queryOfficerList(Map map) throws Exception;
    /**
     * 关员科级评价汇总
     * @param map
     * @return
     * @throws Exception
     */
    public List<Map> queryOfficerKeList(Map map) throws Exception;
    /**
     * 关员科级评价汇总总计
     * @param map
     * @return
     * @throws Exception
     */
    public Map queryOfficerKeListSum(Map map) throws Exception;
    /**
     * 关员关级评价汇总
     * @param map
     * @return
     * @throws Exception
     */
    public List<Map> queryOfficerGuanList(Map map) throws Exception;
    /**
     * 关员关级评价汇总总计
     * @param map
     * @return
     * @throws Exception
     */
    public Map queryOfficerGuanListSum(Map map) throws Exception;
    /**
     * 评价明细数量
     * @param map
     * @return
     * @throws Exception
     */
    public int queryEvaluationCount(Map map) throws Exception;
    /**
     * 评价明细
     * @param map
     * @return
     * @throws Exception
     */
    public List<Map> queryEvaluationList(Map map) throws Exception;
    /**
     * 获取评价
     * @param map
     * @return
     * @throws Exception
     */
    public Map queryEvaluationById(int evalId) throws Exception;
    
    
    /**
     * 获取所有关区
     * @param map
     * @return
     * @throws Exception
     */
    public List<Map> queryAllCustomsList() throws Exception;
    /**
     * 获取关区下的科室
     * @param map
     * @return
     * @throws Exception
     */
    public List<Map> queryOrgListByCustomsId(int customsId) throws Exception;
    /**
     * 获取科室下的窗口
     * @param map
     * @return
     * @throws Exception
     */
    public List<Map> queryWindowListByOrgId(int orgId) throws Exception;
    /**
     * 获取关区下的业务
     * @param map
     * @return
     * @throws Exception
     */
    public List<Map> queryServiceListByCustomsId(int customsId) throws Exception;
}
