package com.eclink.hgpj.dictionary;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eclink.hgpj.dictionary.service.DictionaryService;
import com.eclink.hgpj.dictionary.vo.DictionaryVO;

/**
 * Test.java
 * 
 * @Title:
 * @Description:
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.
 * @Company: 易网通公司
 * @author 张万根
 * @version 1.0
 * @date Nov 10, 2011 9:53:01 AM
 * 
 */
public class Test {
	public static void main(String[] args) throws Exception {
		// 获取applicationContext
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config-*.xml");
		// 获取业务接口
		DictionaryService dictionaryService = (DictionaryService) ac.getBean("dictionaryService");
		// 调用业务方法
		List<DictionaryVO> list = dictionaryService.queryDictonaryList(new DictionaryVO());
		// 结果输出
		if (null != list && list.size() > 0) {
			for (DictionaryVO dictionaryVO : list) {
				System.out.println(dictionaryVO.getCodeType() + ","
						+ dictionaryVO.getTypeDesc() + ","
						+ dictionaryVO.getKey() + "," + dictionaryVO.getValue()
						+ "," + dictionaryVO.getIsValid() + ","
						+ dictionaryVO.getOrderId());
			}
		}
	}
}
