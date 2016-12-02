<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:iterator value="itmsitList">
	<option value="<s:property value="itnot9.trim()"/>"><s:property value="itnot9.trim()"/></option>
</s:iterator>
