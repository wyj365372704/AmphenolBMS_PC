<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<link href="<%=request.getContextPath()%>/css/global.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/js/alert/alerts.css"
	rel="stylesheet" type="text/css" />

<table width="100%" border="0" cellspacing="1" cellpadding="0"
	class="list_table_s">
	<tr>
		<th>退货单号</th>
		<th>退货单行号</th>
		<th>采购单号</th>
		<th>采购单行号</th>
		<th>供应商代码</th>
		<th>退货单行状态</th>
		<th>物料</th>
		<th>批次控制</th>
		<th>库存单位</th>
		<th>计划退货数量</th>
		<th>操作</th>
		<!-- -->
	</tr>
	<s:iterator value="zvritmList" status="st">
		<s:if test="#st.Even">
			<tr class="td_bgcolor">
		</s:if>
		<s:else>
			<tr class="td_bgcolor2">
		</s:else>
		<td><s:property value="vrdno" />
		</td>
		<td><s:property value="vrdln" />
		</td>
		<td><s:property value="ordno" />
		</td>
		<td><s:property value="poisq" />
		</td>
		<td><s:property value="vndnr" />
		</td>
		<td>
		<s:if test="lstat==10">已创建,未退货</s:if> 
		<s:elseif test="lstat==50">已退货</s:elseif> 
		<s:elseif test="lstat==60">已关闭</s:elseif>
		</td>
		<td><s:property value="itnbr" />
		<td>
		<s:if test="blcf==0">否</s:if> 
		<s:elseif test="blcf==1">是</s:elseif> 
		</td>
		<td><s:property value="stkum" />
		</td>
		<td><s:property value="plnvq" />
		</td>
		<td><s:if test="lstat==10">
				<input type="button" id="editbtn" value="删除" class="gray_button"
					onclick="deleteZvritm('<s:property value="vrdno"/>','<s:property value="vrdln"/>','<s:property value="blksq"/>');" />
			</s:if></td>
		</tr>
	</s:iterator>
</table>