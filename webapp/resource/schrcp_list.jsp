<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<link href="<%=request.getContextPath() %>/css/global.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/js/alert/alerts.css"
	rel="stylesheet" type="text/css" />

<table width="100%" border="0" cellspacing="1" cellpadding="0"
	class="list_table_s">
	<tr>
		<th>单号</th>
		<th>供应商代码</th>
		<th>行号</th>
		<th>物料</th>
		<th>物料描述</th>
		<th>订单数量</th>
		<th>未交数量</th>
		<th>已到货数量</th>
		<th>采购单位</th>
		<th>库存单位</th>
		<th>订单行状态</th>
		<th>采购员</th>
		<th>计划员</th>
		<th>操作</th>
		<!-- -->
	</tr>
	<s:iterator value="schrcpList" status="st">
		<s:if test="#st.Even">
			<tr class="td_bgcolor">
		</s:if>
		<s:else>
			<tr class="td_bgcolor2">
		</s:else>
		<td><s:property value="ordrji" /></td>
		<td><s:property value="vndrji" /></td>
		<td><s:property value="pisqji" /></td>
		<td><s:property value="itnoji" /></td>
		<td><s:property value="ds40ji" /></td>
		<td><s:property value="ucoqji" /></td>
		<td><s:property value="qtyoji" /></td>
		<td><s:property value="stkqji" /></td>
		<td><s:property value="orumji" /></td>
		<td><s:property value="umstji" /></td>
		<td><s:if test="rcpsji==05">供应商未确认</s:if>
		<s:elseif test="rcpsji==10">未收货</s:elseif>
		<s:elseif test="rcpsji==35">部分收货</s:elseif>
		<s:elseif test="rcpsji==40">收货完成</s:elseif>
		<s:elseif test="rcpsji==99">已取消</s:elseif>
		</td>
		<td><s:property value="buyrji" /></td>
		<td><s:property value="planji" /></td>
		<td><s:if test="rcpsji==40">
				<input type="button" id="editbtn" value="退货" class="gray_button"
					onclick="goreturn('<s:property value="sctkji"/>');" />
			</s:if>
		</td>
		</tr>
	</s:iterator>
</table>