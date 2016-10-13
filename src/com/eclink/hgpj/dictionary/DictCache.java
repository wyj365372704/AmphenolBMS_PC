package com.eclink.hgpj.dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.eclink.hgpj.dictionary.service.DictionaryService;
import com.eclink.hgpj.dictionary.vo.DictionaryVO;
import com.eclink.hgpj.init.SystemInitServlet;

/**
 * DictCache.java
 *
 * @Title: 数据字典缓存
 * @Description: 在系统启动时加载数据字典内容至内存，提供方法供外部调用
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date Nov 10, 2011 10:29:30 AM
 *
 */
public class DictCache {
	
	private static final Logger log = Logger.getLogger(DictCache.class);
	
	/** 数据字典缓存Map，key为类型码，value为DictionaryVO对象List列表*/
	private static Map<String,List<DictionaryVO>> dictMap;
	
	/** 唯一实例 */
	private static DictCache instance;
	
	/**
	 * 私有构造函数
	 */
	private DictCache() {
		dictMap = new HashMap<String,List<DictionaryVO>>();
		loadDictionary();
	}
	
	/**
	 * 获取数据字典缓存实例方法
	 *  
	 * @return
	 */
	public static DictCache getInstance() {
		if (null == instance) {
			instance = new DictCache();
		}
		return instance;
	}
	
	/**
	 * 加载所有数据字典至hash缓存（包括可见与不可见）
	 */
	private void loadDictionary() {
		System.out.println("### [Load dictionary to cache...]");
		// 获取数据字典业务接口
		DictionaryService service = (DictionaryService)SystemInitServlet.WAC.getBean("dictionaryService");
		try {
			List<DictionaryVO> list = service.queryDictonaryList(new DictionaryVO());
			if (list != null && list.size() > 0) {
				for (DictionaryVO dictionary : list) {
					String codeType = dictionary.getCodeType();
					List<DictionaryVO> dictList = dictMap.get(codeType);
					if (null == dictList) {
						dictList = new ArrayList<DictionaryVO>();
					}
					dictList.add(dictionary);
					dictMap.put(codeType, dictList);
				}
			}
			System.out.println("  dictionary types：" + dictMap.keySet());
			System.out.println("Loaded dictionary data to cache success...");
		} catch (Exception e) {
			log.error("Load dictionary data to cache error.", e);
			System.out.println("Loaded dictionary data to cache error...");
		}
	}
	
	/**
	 * 根据类型码获取有效数据字典列表
	 *  
	 * @param codeType 类型码
	 * @return List 有效数据字典列表
	 */
	public List<DictionaryVO> getValidDictList(String codeType) {
		if (StringUtils.isBlank(codeType)) {
			return null;
		}
		// 根据代码类型，获取所有数据字典
		List<DictionaryVO> dictList = dictMap.get(codeType);
		if (dictList == null || dictList.size() == 0) {
			return new ArrayList<DictionaryVO>();
		}
		// 过滤无效的数据字典列表，即不可见的
		List<DictionaryVO> validList = new ArrayList<DictionaryVO>();
		for (DictionaryVO dictionaryVO : dictList) {
			if (!DictionaryVO.VALID_FLAG_NO.equals(dictionaryVO.getIsValid())) {
				validList.add(dictionaryVO);
			}
		}
		return validList;
	}
	
	/**
	 * 根据类型码获取所有数据字典列表(有效+无效)
	 *  
	 * @param codeType 类型码
	 * @return List 所有数据字典列表
	 */
	public List<DictionaryVO> getDictList(String codeType) {
		if (StringUtils.isBlank(codeType)) {
			return null;
		}
		// 根据代码类型，获取所有数据字典列表
		return dictMap.get(codeType);
	}
	
	/**
	 * 根据类型码与数据键获取数据值名称
	 * 
	 * @param codeType 类型码名称
	 * @param key 数据键
	 * @return 数据键对应的名称，当codeType或key为null或空时返回空字符串
	 */
	public String getAlias(String codeType, String key) {
		String alias = "";
		if (StringUtils.isBlank(codeType) || StringUtils.isBlank(key)) {
			return alias;
		}
		List<DictionaryVO> list = getDictList(codeType);
		if (list != null && list.size() > 0) {
			for (DictionaryVO dictionaryVO : list) {
				if (key.equals(dictionaryVO.getKey())) {
					alias = dictionaryVO.getValue();
					break;
				}
			}
		}
		return alias;
	}
	
	/**
	 * 根据类型码获取下拉框选项字符串，主要用于新增操作或查询操作的jsp页面中
	 * 在类型码对应的所有选项中，额外增加其他选项，例如"全部"、"请选择"下拉选项
	 * 
	 * @param codeType 类型码名称
	 * @param otherValue 额外选项值
	 * @param otherName 额外选项名称
	 * @return 下拉框选项字符串
	 */
	public String getSelectListString(String codeType,
			String otherValue, String otherName) {
		StringBuffer optionStr = new StringBuffer();
		optionStr.append("<option value=\"");
		optionStr.append(otherValue);
		optionStr.append("\">");
		optionStr.append(otherName);
		optionStr.append("</option>");
		if (codeType == null || "".equals(codeType)) {
			return optionStr.toString();
		}
		List<DictionaryVO> list = getValidDictList(codeType);
		if (list != null && list.size() > 0) {
			for (DictionaryVO dictionaryVO : list) {
				optionStr.append("<option value=\"");
				optionStr.append(dictionaryVO.getKey());
				optionStr.append("\">");
				optionStr.append(dictionaryVO.getValue());
				optionStr.append("</option>");
			}
		}
		return optionStr.toString();
	}
	
	/**
	 * 根据类别代码获取下拉框选项字符串，如果isSelecte为true，默认将code值选中
	 * 例如:<option value="0">新单</option><option value="1">已申报</option>
	 * 下拉框选项按照代码值升序排列
	 * @param codeType 类型码名称
	 * @param isSelected 是否选中默认值
	 * @param key 默认选中的数据键
	 * @return 下拉框选项字符串
	 */
	private String getSelectListString(String codeType,
			boolean isSelected, String key) {
		StringBuffer optionStr = new StringBuffer();
		if (StringUtils.isBlank(codeType)) {
			return optionStr.toString();
		}
		List<DictionaryVO> list = getValidDictList(codeType);
		if (list != null && list.size() > 0) {
			for (DictionaryVO dictionaryVO : list) {
				optionStr.append("<option value=\"");
				optionStr.append(dictionaryVO.getKey());
				if (isSelected && !StringUtils.isBlank(codeType)
						&& codeType.equals(dictionaryVO.getCodeType())) {
					optionStr.append("\" selected=\"selected\">");
				} else {
					optionStr.append("\">");
				}
				optionStr.append(dictionaryVO.getValue());
				optionStr.append("</option>");
			}
		}
		return optionStr.toString();
	}
	
	/**
	 * 根据类别代码获取下拉框选项字符串，主要用于查询jsp页面中
	 * 例如:<option value="NORMAL">正常</option><option value="LOCKED">锁定</option>
	 * 下拉框选项按照代码值升序排列
	 * @param codeType 类型码名称
	 * @return 下拉框选项字符串
	 */
	public String getSelectListString(String codeType) {
		return getSelectListString(codeType, false, null);
	}
	
	/**
	 * 根据类别代码获取下拉框选项字符串，并默认选中指定值，主要用于修改操作的jsp页面中
	 * 例如:<option value="NORMAL">正常</option><option value="LOCKED">锁定</option>
	 * 下拉框选项按照代码值升序排列
	 * @param codeType 类型码名称
	 * @param key 默认选中的数据键
	 * @return 下拉框选项字符串
	 */
	public String getSelectListString(String codeType, String key) {
		return getSelectListString(codeType, true, key);
	}
	
	/**
	 * 获取所有数据字典Map
	 * 其中key为类型码，value为DictionaryVO对象List列表
	 *  
	 * @return Map
	 */
	public Map<String,List<DictionaryVO>> getMap() {
		return dictMap;
	}
	

}
