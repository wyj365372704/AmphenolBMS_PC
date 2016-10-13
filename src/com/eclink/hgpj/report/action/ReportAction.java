package com.eclink.hgpj.report.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.eclink.dfcm.paginator.common.PaginatorUtil;
import com.eclink.dfcm.paginator.tag.PageVO;
import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.common.JsonUtil;
import com.eclink.hgpj.organization.biz.OrgService;
import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.report.biz.ReportService;
import com.eclink.hgpj.user.vo.UserVO;
/**
 * ReportAction.java
 *
 * @Title: 统计查询控制类
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author caibin
 * @version 1.0
 * @date May 17, 2013 4:12:25 PM
 *
 */
public class ReportAction extends BaseAction {
    private static final Logger log = Logger.getLogger(ReportAction.class);
    /**
     * 统计查询业务接口
     */
    private ReportService reportService;
    /**
     * 查询条件
     */
    private Map map = new HashMap();
    /**
     * 查询结果列表
     */
    private List<Map> list = new ArrayList();
    /**
     * 查询结果总计
     */
    private Map totalMap = new HashMap();
    /**
     * 评价
     */
    private Map evalMap = new HashMap();
    /**
     * 关区
     */
    private List<Map> customsList = new ArrayList();
    /**
     * 科室
     */
    private List<Map> orgList = new ArrayList();
    /**
     * 窗口
     */
    private List<Map> windowList = new ArrayList();
    /**
     * 业务类型
     */
    private List<Map> serviceList = new ArrayList();
    
    public String messageData;
    /**
     * 关区ID
     */
    private int customsId;
    /**
     * 科室ID
     */
    private int orgId;
    /**
     * 评价ID
     */
    private int evalId;
    /**
     * 组织管理业务接口
     */
    private OrgService orgService;
    
    private final static String AUTH_EXCEPTION = "没有分配报表数据访问权限，请联系管理员!";
    
    /**
     * 业务评价统计
     * @return
     * @throws Exception
     */
    public String listBiz() throws Exception {
        try {
            this.initParam();
            // 获取分页信息
            PageVO page = PaginatorUtil.getPaginator(getRequest());
            setPagination(getBaseVO(),page);
            
            // 查询总记录数
            if (page.isQueryTotal()) {
                page.setTotalRecord(reportService.queryBizCount(map));
            }
            
            // 调用业务方法查询列表
            list = reportService.queryBizList(map);
            
            // 分页对象保存至request
            getRequest().setAttribute(HGPJConstant.PAGE_KEY, page);
        } catch (Exception e) {
            if(!AUTH_EXCEPTION.equals(e.getMessage())){
                log.error("Query report list occurred error." ,e);
              }
            return ERROR;
        }
        return "listBiz";
    }

    /**
     * 业务评价统计
     * @return
     * @throws Exception
     */
    public String listWindow() throws Exception {
        try {
            this.initParam();
            // 获取分页信息
            PageVO page = PaginatorUtil.getPaginator(getRequest());
            setPagination(getBaseVO(),page);
            
            // 查询总记录数
            if (page.isQueryTotal()) {
                page.setTotalRecord(reportService.queryWindowCount(map));
            }
            
            // 调用业务方法查询列表
            list = reportService.queryWindowList(map);
            
            // 分页对象保存至request
            getRequest().setAttribute(HGPJConstant.PAGE_KEY, page);
        } catch (Exception e) {
            if(!AUTH_EXCEPTION.equals(e.getMessage())){
                log.error("Query report list occurred error." ,e);
              }
            return ERROR;
        }
        return "listWindow";
    }


    /**
     * 窗口科级评价汇总
     * @return
     * @throws Exception
     */
    public String listWindowKe() throws Exception {
        try {
            this.initParam();
            
            // 调用业务方法查询列表
            list = reportService.queryWindowKeList(map);
            totalMap = reportService.queryWindowKeListSum(map);
            
        } catch (Exception e) {
            if(!AUTH_EXCEPTION.equals(e.getMessage())){
                log.error("Query report list occurred error." ,e);
              }
            return ERROR;
        }
        return "listWindowKe";
    }
    /**
     * 窗口关级评价汇总
     * @return
     * @throws Exception
     */
    public String listWindowGuan() throws Exception {
        try {
            this.initParam();
            
            // 调用业务方法查询列表
            list = reportService.queryWindowGuanList(map);
            totalMap = reportService.queryWindowGuanListSum(map);
            
        } catch (Exception e) {
            if(!AUTH_EXCEPTION.equals(e.getMessage())){
                log.error("Query report list occurred error." ,e);
              }
            return ERROR;
        }
        return "listWindowGuan";
    }
    /**
     * 关员评价统计数量
     * @return
     * @throws Exception
     */
    public String listOfficer() throws Exception {
        try {
            this.initParam();
            // 获取分页信息
            PageVO page = PaginatorUtil.getPaginator(getRequest());
            setPagination(getBaseVO(),page);
            
            // 查询总记录数
            if (page.isQueryTotal()) {
                page.setTotalRecord(reportService.queryOfficerCount(map));
            }
            
            // 调用业务方法查询列表
            list = reportService.queryOfficerList(map);
            
            // 分页对象保存至request
            getRequest().setAttribute(HGPJConstant.PAGE_KEY, page);
        } catch (Exception e) {
            if(!AUTH_EXCEPTION.equals(e.getMessage())){
                log.error("Query report list occurred error." ,e);
              }
            return ERROR;
        }
        return "listOfficer";
    }
    /**
     * 关员科级评价汇总
     * @return
     * @throws Exception
     */
    public String listOfficerKe() throws Exception {
        try {
            this.initParam();
            // 调用业务方法查询列表
            list = reportService.queryOfficerKeList(map);
            totalMap = reportService.queryOfficerKeListSum(map);
            
        } catch (Exception e) {
            if(!AUTH_EXCEPTION.equals(e.getMessage())){
                log.error("Query report list occurred error." ,e);
              }
            return ERROR;
        }
        return "listOfficerKe";
    }
    /**
     * 关员关级评价汇总
     * @return
     * @throws Exception
     */
    public String listOfficerGuan() throws Exception {
        try {
            this.initParam();
            // 调用业务方法查询列表
            list = reportService.queryOfficerGuanList(map);
            totalMap = reportService.queryOfficerGuanListSum(map);
            
        } catch (Exception e) {
            if(!AUTH_EXCEPTION.equals(e.getMessage())){
                log.error("Query report list occurred error." ,e);
              }
            return ERROR;
        }
        return "listOfficerGuan";
    }
    /**
     * 评价明细
     * @return
     * @throws Exception
     */
    public String listEvaluation() throws Exception {
        try {
            this.initParam();
            // 获取分页信息
            PageVO page = PaginatorUtil.getPaginator(getRequest());
            setPagination(getBaseVO(),page);
            
            // 查询总记录数
            if (page.isQueryTotal()) {
                page.setTotalRecord(reportService.queryEvaluationCount(map));
            }
            
            // 调用业务方法查询列表
            list = reportService.queryEvaluationList(map);
            
            // 分页对象保存至request
            getRequest().setAttribute(HGPJConstant.PAGE_KEY, page);
        } catch (Exception e) {
            if(!AUTH_EXCEPTION.equals(e.getMessage())){
                log.error("Query report list occurred error." ,e);
              }
            return ERROR;
        }
        return "listEvaluation";
    }
    /**
     * 评价明细
     * @return
     * @throws Exception
     */
    public String viewEvaluation() throws Exception {
        try {
            // 调用业务方法查询列表
            evalMap = reportService.queryEvaluationById(evalId);
            
        } catch (Exception e) {
            if(!AUTH_EXCEPTION.equals(e.getMessage())){
                log.error("Query report list occurred error." ,e);
              }
            return ERROR;
        }
        return "viewEvaluation";
    }

    /**
     * 获取关区下的科室
     * @return
     * @throws Exception
     */
    public String listOrgByCustomsId() throws Exception {
        try {
            // 调用业务方法查询列表
            customsList = reportService.queryOrgListByCustomsId(customsId);
            messageData = JsonUtil.list2Json(customsList);
        } catch (Exception e) {
            if(!AUTH_EXCEPTION.equals(e.getMessage())){
                log.error("Query report list occurred error." ,e);
              }
            messageData = "failure";
        }
        return "messageData";
    }
    /**
     * 获取科室下的窗口
     * @return
     * @throws Exception
     */
    public String listWindowListByOrgId() throws Exception {
        try {
            // 调用业务方法查询列表
            orgList = reportService.queryWindowListByOrgId(orgId);
            messageData = JsonUtil.list2Json(orgList);
        } catch (Exception e) {
            if(!AUTH_EXCEPTION.equals(e.getMessage())){
                log.error("Query report list occurred error." ,e);
              }
            messageData = "failure";
        }
        return "messageData";
    }
    /**
     * 获取关区下的业务
     * @return
     * @throws Exception
     */
    public String listServiceListByCustomsId() throws Exception {
        try {
            // 调用业务方法查询列表
            serviceList = reportService.queryServiceListByCustomsId(customsId);
            messageData = JsonUtil.list2Json(serviceList);
        } catch (Exception e) {
            if(!AUTH_EXCEPTION.equals(e.getMessage())){
              log.error("Query report list occurred error." ,e);
            }
            messageData = "failure";
        }
        return "messageData";
    }
    private void initParam()  throws Exception {
        map.put("BaseVO", new BaseVO());
        this.setParam("customsId");
        this.setParam("orgId");
        this.setParam("windowId");
        this.setParam("userName");
        this.setParam("evalResult");
        this.setParam("evalMethod");
        this.setParam("evalType");
        this.setParam("touchEvalType");
        this.setParam("serviceId");
        this.setParam("startDate");
        this.setParam("endDate");
        this.initDataAccessPerm();
    }
    private void setParam(String key) {
        if(map.get(key)!=null){
            map.put(key, ((String[])map.get(key))[0]);
        }
    }
    private BaseVO getBaseVO() {
        return (BaseVO)map.get("BaseVO");
    }
    private void initDataAccessPerm() throws Exception {
        UserVO user = this.getLoginUser();
        
        
        if(user!=null){
            if(HGPJConstant.DATA_ACCESS_PERM_A.equals(user.getDataAccessPerm())) {
                //-总关级
                //this.customsList = reportService.queryAllCustomsList();
                this.customsList = this.getAllCustomsList();
            }else if(HGPJConstant.DATA_ACCESS_PERM_P.equals(user.getDataAccessPerm())) {
                //-分关级
                map.put("customsId", user.getCustomsId()==null?null:user.getCustomsId().toString());
                this.customsList.add(this.getUserCustoms(user));
            }else if(HGPJConstant.DATA_ACCESS_PERM_O.equals(user.getDataAccessPerm())) {
                //-科室级
                map.put("orgId", user.getOrgId()==null?null:user.getOrgId().toString());
                this.customsList.add(this.getUserCustoms(user));
                this.orgList.add(this.getUserOrg(user));
            }else{
                setErrorMsg(AUTH_EXCEPTION);
                throw new Exception(AUTH_EXCEPTION);
            }
        }
        
        if (map.get("customsId")!=null&&!"".equals(map.get("customsId"))){
            //this.orgList = reportService.queryOrgListByCustomsId(Integer.parseInt((String)map.get("customsId")));
            this.orgList = this.getChildCustomsList(Integer.parseInt((String)map.get("customsId")));
            this.serviceList = reportService.queryServiceListByCustomsId(Integer.parseInt((String)map.get("customsId")));
            if (map.get("orgId")!=null&&!"".equals(map.get("orgId"))){
                this.windowList = reportService.queryWindowListByOrgId(Integer.parseInt((String)map.get("orgId")));
            }
        }
    }
    private List<Map> getAllCustomsList() throws Exception {
        List<OrgVO> list = orgService.queryCustomsOrg();
        return getOrgMapList(list);
    }
    private List<Map> getChildCustomsList(int orgId) throws Exception {
        List<OrgVO> list = orgService.queryChildOrgByOrgId(orgId);
        return getOrgMapList(list);
    }
    private List<Map> getOrgMapList(List<OrgVO> list) throws Exception {
        List<Map> mapList = new ArrayList();
        if (list !=null){
            for(OrgVO org:list){
                Map m = new HashMap();
                m.put("orgId", org.getOrgId());
                m.put("orgName", org.getOrgName());
                mapList.add(m);
            }
        }
        return mapList;
    }
    /**
     * 用户关区
     * @param user
     * @return
     */
    private Map getUserCustoms(UserVO user) {
        Map m = new HashMap();
        m.put("orgId", user.getCustomsId());
        m.put("orgName", user.getCustomsName());
        return m;
    }
    /**
     * 用户科室
     * @param user
     * @return
     */
    private Map getUserOrg(UserVO user) {
        Map m = new HashMap();
        m.put("orgId", user.getOrgId());
        m.put("orgName", user.getOrgName());
        return m;
    }

    public ReportService getReportService() {
        return reportService;
    }

    public void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List<Map> getList() {
        return list;
    }

    public void setList(List<Map> list) {
        this.list = list;
    }

    public List<Map> getCustomsList() {
        return customsList;
    }

    public void setCustomsList(List<Map> customsList) {
        this.customsList = customsList;
    }

    public List<Map> getOrgList() {
        return orgList;
    }

    public void setOrgList(List<Map> orgList) {
        this.orgList = orgList;
    }

    public List<Map> getWindowList() {
        return windowList;
    }

    public void setWindowList(List<Map> windowList) {
        this.windowList = windowList;
    }

    public List<Map> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Map> serviceList) {
        this.serviceList = serviceList;
    }

    public int getCustomsId() {
        return customsId;
    }

    public void setCustomsId(int customsId) {
        this.customsId = customsId;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getMessageData() {
        return messageData;
    }

    public void setMessageData(String messageData) {
        this.messageData = messageData;
    }

    public Map getTotalMap() {
        return totalMap;
    }

    public void setTotalMap(Map totalMap) {
        this.totalMap = totalMap;
    }

    public int getEvalId() {
        return evalId;
    }

    public void setEvalId(int evalId) {
        this.evalId = evalId;
    }

    public Map getEvalMap() {
        return evalMap;
    }

    public void setEvalMap(Map evalMap) {
        this.evalMap = evalMap;
    }

    public OrgService getOrgService() {
        return orgService;
    }

    public void setOrgService(OrgService orgService) {
        this.orgService = orgService;
    }
}
