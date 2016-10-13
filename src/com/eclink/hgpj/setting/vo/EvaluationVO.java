package com.eclink.hgpj.setting.vo;

import java.util.Date;

import com.eclink.hgpj.base.BaseVO;

/**
 * 前台评价建议VO
 * 
 * @Title:
 * @Description:
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司
 * @author 周灵舟
 * @version 1.0
 * @date May 16, 2013 11:12:33 AM
 * 
 */
public class EvaluationVO extends BaseVO {
    private Integer evalId;// 主键ID,自增长
    private Integer customsId;// 关区ID
    private Integer orgId;// 科室ID
    private Integer windowId;// 窗口ID
    private String userName;// 关员
    private String evalNo;// 评价器编号
    private String evalType;// 评价器类型：0-按键式评价器、1-触摸式评价器
    private Integer serviceId;// 业务ID
    private Integer evalResult;// 评价结果: 0-未评价、1-不满意、2-基本满意、3-满意、4-非常满意
    private String evalSuggest;// 评价建议
    private Date evalTime;// 评价时间
    private String name;// 评价人姓名
    private String sex;// 评价人性别
    private String idCardNo;// 评价人身份证号
    private String telephone;// 评价人电话
    private String touchEvalType;//触摸式评价类型：P-关员、W-窗口、S-业务
    
    public Integer getEvalId() {
        return evalId;
    }
    public void setEvalId(Integer evalId) {
        this.evalId = evalId;
    }
    public Integer getCustomsId() {
        return customsId;
    }
    public void setCustomsId(Integer customsId) {
        this.customsId = customsId;
    }
    public Integer getOrgId() {
        return orgId;
    }
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
    public Integer getWindowId() {
        return windowId;
    }
    public void setWindowId(Integer windowId) {
        this.windowId = windowId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEvalNo() {
        return evalNo;
    }
    public void setEvalNo(String evalNo) {
        this.evalNo = evalNo;
    }
    public String getEvalType() {
        return evalType;
    }
    public void setEvalType(String evalType) {
        this.evalType = evalType;
    }
    public Integer getServiceId() {
        return serviceId;
    }
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
    public Integer getEvalResult() {
        return evalResult;
    }
    public void setEvalResult(Integer evalResult) {
        this.evalResult = evalResult;
    }
    public String getEvalSuggest() {
        return evalSuggest;
    }
    public void setEvalSuggest(String evalSuggest) {
        this.evalSuggest = evalSuggest;
    }
    public Date getEvalTime() {
        return evalTime;
    }
    public void setEvalTime(Date evalTime) {
        this.evalTime = evalTime;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getIdCardNo() {
        return idCardNo;
    }
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getTouchEvalType() {
        return touchEvalType;
    }
    public void setTouchEvalType(String touchEvalType) {
        this.touchEvalType = touchEvalType;
    }
	/**
	 * override toString
	 */
	public String toString()
	{
	    final String TAB = ",";
	
	    StringBuilder retValue = new StringBuilder();
	    
	    retValue.append("EvaluationVO[")
	        .append("evalId = ").append(this.evalId).append(TAB)
	        .append("customsId = ").append(this.customsId).append(TAB)
	        .append("orgId = ").append(this.orgId).append(TAB)
	        .append("windowId = ").append(this.windowId).append(TAB)
	        .append("userName = ").append(this.userName).append(TAB)
	        .append("evalNo = ").append(this.evalNo).append(TAB)
	        .append("evalType = ").append(this.evalType).append(TAB)
	        .append("serviceId = ").append(this.serviceId).append(TAB)
	        .append("evalResult = ").append(this.evalResult).append(TAB)
	        .append("evalSuggest = ").append(this.evalSuggest).append(TAB)
	        .append("evalTime = ").append(this.evalTime).append(TAB)
	        .append("name = ").append(this.name).append(TAB)
	        .append("sex = ").append(this.sex).append(TAB)
	        .append("idCardNo = ").append(this.idCardNo).append(TAB)
	        .append("telephone = ").append(this.telephone).append(TAB)
	        .append("touchEvalType = ").append(this.touchEvalType).append(TAB)
	        .append("]");
	    
	    return retValue.toString();
	}
    
}
