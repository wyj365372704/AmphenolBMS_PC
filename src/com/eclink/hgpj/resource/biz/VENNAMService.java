package com.eclink.hgpj.resource.biz;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.VENNAMVO;

public interface VENNAMService {
	public List<VENNAMVO> queryVennam(Map vo) throws Exception;
}
