package com.eclink.hgpj.common;
/**
 * HGPJConstant.java
 *
 * @Title: 常量类
 * @Description: 定义系统所使用到的常量
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date Nov 9, 2011 12:09:48 AM
 *
 */
public class HGPJConstant {
	
	/** 当前登录用户信息在session中的KEY */
	public static final String SESSION_USER_KEY = "loginInfo";
	
	/** 退出系统标识在session中的KEY */
	public static final String LOGOUT_FLAG_KEY = "logout";
	
	/** 用户主动退出 */
	public static final String USER_ACTIVE_LOGOUT = "active";
	
	/** 会话超时退出 */
	public static final String SESSION_TIMEOUT_LOGOUT = "sessiontimeout";
	
	/** 错误信息在request中的KEY */
	public static final String ERROR_MSG_KEY = "errorMsg";
	
	/** 提示信息在request中的KEY */
	public static final String INFO_MSG_KEY = "infoMsg";
	
	/** 分页信息对象保存在request中的KEY */
	public static final String PAGE_KEY = "paginator";
	
	/** 海关评价系统默认代码 */
	public static final String DEFAULT_HGPJ_SYSTEMCODE = "HGPJ";
	
	/** 数据字典类型码:用户状态 */
	public static final String DICT_USER_STATUS = "USER_STATUS";
	
	/** 数据字典类型码:是否可评价 */
	public static final String DICT_IS_EVALUATED = "IS_EVALUATED";
	
	/** 数据字典类型码:性别 */
	public static final String DICT_SEX = "SEX";
	
	/** 数据字典类型码:数据访问权限 */
	public static final String DICT_DATA_ACCESS_PERM = "DATA_ACCESS_PERM";
	
	/** 数据字典类型码:组织机构状态 */
	public static final String DICT_ORG_STATUS = "ORG_STATUS";
	
	/** 数据字典类型码:组织机构类型 */
	public static final String DICT_ORG_TYPE = "ORG_TYPE";
	
	/** 数据字典类型码:操作类型 */
	public static final String DICT_OPER_TYPE = "OPER_TYPE";
	
	/** 数据字典类型码:操作对象 */
	public static final String DICT_OPER_OBJECT = "OPER_OBJECT";
	
	/** Log4j配置文件默认刷新间隔时间,单位秒 */
	public static final int LOG4J_REFRESH_TIME = 60;
	
	/** HGPJ系统默认配置文件名 */
	public static final String DEFAULT_HGPJ_CONFIG_FILENAME = "hgpj-config.xml";	
	
	/** 组织机构状态：正常 */
	public static final String ORG_STATUS_N = "NORMAL";
	
	/** 组织机构状态：已删除 */
	public static final String ORG_STATUS_D = "DELETED";
	
	/** 用户状态：正常 */
	public static final String USER_STATUS_N = "NORMAL";
	
	/** 用户状态：锁定 */
	public static final String USER_STATUS_L = "LOCKED";
	
	/** 用户状态：已删除 */
	public static final String USER_STATUS_D = "DELETED";
	
	/** 分关管理员角色默认名称 */
	public static final String COMPANY_ADMIN = "分关管理员";
	
	/** 组织类型标识：总关 */
	public static final String ORG_TYPE_Z = "Z";
	
	/** 组织类型标识：分关 */
	public static final String ORG_TYPE_F = "F";
	
	/** 组织类型标识：科室 */
	public static final String ORG_TYPE_K = "K";
	
	/** 触摸屏评价：可评价 */
	public static final String IS_EVALUATED_Y = "Y";
	
	/** 触摸屏评价：不可评价 */
	public static final String IS_EVALUATED_N = "N";
	
	/** 数据访问权限：总关级 */
	public static final String DATA_ACCESS_PERM_A = "A";
	
	/** 数据访问权限：分关级 */
	public static final String DATA_ACCESS_PERM_P = "P";
	
	/** 数据访问权限：科室级 */
	public static final String DATA_ACCESS_PERM_O = "O";
	
	/** 数据访问权限：无 */
	public static final String DATA_ACCESS_PERM_N = "N";
	
	/** 系统根组织ID */
	public static final int SYSTEM_ROOT_ORG_ID = 1;
	
	/** 参数设置：身份识别间隔时间 */
	public static final String PARAMETER_ID_TIME = "身份证识别间隔时间";
	
	/** 参数设置：触摸评价超时时间 */
	public static final String PARAMETER_TIMEOUT_TIME = "触摸屏评价超时时间";
	
	/** 参数设置：每人每天关员评价次数 */
	public static final String PARAMETER_PERSON_COUNT = "每人每天关员评价次数";
	
	/** 参数设置：每人每天业务评价次数 */
	public static final String PARAMETER_SERVICE_COUNT = "每人每天业务评价次数";
	
	/** 参数设置：每人每天窗口评价次数 */
	public static final String PARAMETER_WINDOW_COUNT = "每人每天窗口评价次数";
	
	/** 分割符：, */
	public static final String SPLIT_0 = ",";
	
	/** 分割符：; */
	public static final String SPLIT_1 = ";";
	
	/** 分割符：-*/
	public static final String SPLIT_2 = "-";

}
