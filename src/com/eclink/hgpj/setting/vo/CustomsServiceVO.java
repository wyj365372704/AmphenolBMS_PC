package com.eclink.hgpj.setting.vo;

import java.util.List;

import com.eclink.hgpj.base.BaseVO;

/**
 * 关区业务VO
 * @Title:
 * @Description:
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司
 * @author 周灵舟
 * @version 1.0
 * @date May 16, 2013 11:12:33 AM
 * 
 */
public class CustomsServiceVO extends BaseVO{
    private Integer orgId;// 关区ID
    private Integer serviceId;// 业务ID
    
    /** 非数据字段 */
    private String orgName;// 关区名
    private String serviceName;// 业务名
    private List<CustomsServiceVO> childs;
    private Integer[] serviceIds;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getServiceName() {
		if(serviceName != null && !"".equals(serviceName))
			return serviceName;
		serviceName = "";
		List<CustomsServiceVO> cs = getChilds();
		if(cs != null && cs.size() > 0){
			for (CustomsServiceVO customsServiceVO : cs) {
				serviceName += customsServiceVO.getServiceName()+",";
			}
		}
		return serviceName.replaceAll(",$", "");
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public List<CustomsServiceVO> getChilds() {
		return childs;
	}

	public void setChilds(List<CustomsServiceVO> childs) {
		this.childs = childs;
	}

	public Integer[] getServiceIds() {
		if(serviceIds == null){
			List<CustomsServiceVO> cs = getChilds();
			if(cs != null && cs.size() > 0){
				serviceIds = new Integer[cs.size()];
				int i = 0;
				for (CustomsServiceVO customsServiceVO : cs) {
					serviceIds[i++] = customsServiceVO.getServiceId();
				}
			}
		}
		return serviceIds;
	}

	public void setServiceIds(Integer[] serviceIds) {
		this.serviceIds = serviceIds;
	}

	/**
	 * override toString
	 */
	public String toString()
	{
	    final String TAB = ",";
	
	    StringBuilder retValue = new StringBuilder();
	    
	    retValue.append("CustomsServiceVO[")
	        .append("orgId = ").append(this.orgId).append(TAB)
	        .append("orgName = ").append(this.orgName).append(TAB)
	        .append("serviceId = ").append(this.serviceId).append(TAB)
	        .append("serviceName = ").append(this.getServiceName())
	        .append("]");
	    
	    return retValue.toString();
	}
}