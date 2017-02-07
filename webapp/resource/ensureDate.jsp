<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
	function submit2() {
		document.getElementsByName("queryform")[0].submit();
	}

	function onclear() {
		document.getElementsByName("ordrji")[0].value = "";
	}
	function allow(ordrji,pisqji,bksqji,wkdtji){
			$.ajax( {  
		       url:'pomast!auditZdelida.action',// 跳转到 action  
		       data:{  
		                ordrji : ordrji,
		                pisqji : pisqji,
		                bksqji : bksqji,
		                wkdtji : wkdtji,
		                allow : "1"
		       },  
		      type:'post',  
		      cache:false,  
		      success:function(data) {  
		      	if($.trim(data) == 'success'){
		      		 alert("操作成功");
		      		 location.reload();
		      	}else{
		      		 alert("操作失败");
		      	}
		       },  
		       error : function() {  
		            alert("操作失败");  
		       }  
		  });
	}
	function refuse(ordrji,pisqji,bksqji){
			$.ajax( {  
		       url:'pomast!auditZdelida.action',// 跳转到 action  
		       data:{  
		                ordrji : ordrji,
		                pisqji : pisqji,
		                bksqji : bksqji,
		                allow : "0"
		       },  
		      type:'post',  
		      cache:false,  
		      success:function(data) {  
		      	if($.trim(data) == 'success'){
		      		 alert("操作成功");
		      		 location.reload();
		      	}else{
		      		 alert("操作失败");
		      	}
		       },  
		       error : function() {  
		            alert("操作失败");  
		       }  
		  });
	}

</script>

<body class="right_body">
	<div class="path">您现在的位置： 首页 &gt; 采购 &gt; 审核交期</div>
	<s:form action="pomast!toEnsureList.action" method="post"
		name="queryform">
		<s:hidden name="flag" value="1"></s:hidden>
		<div class="search">
			<h2>
				<span class="fl">待审核采购订单查询</span> <span class="fr"><input
					name="" type="button" class="search_button" onclick="submit2();" /><input
					name="rs" type="button" class="purge_button" onclick="onclear();" />
				</span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>

			<ul>
				<li><div class="w_s">仓库：</div> <s:select name="whidji"
						list="#session.houses" listKey="house" listValue="house"
						cssClass="select_s_2" style="width:60px"></s:select></li>
				<li><div class="w_s">采购单号：</div> <s:textfield name="ordrji"
						cssClass="input_w"></s:textfield></li>

			</ul>
		</div>

		<div class="data_list">
			<h2>
				<span class="fl">待审核采购订单列表</span> <span class="fr"></span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>

			<div class="list_inner">
				<div class="verflow_s">
					<table width="100%" border="0" cellspacing="1" cellpadding="0"
						class="list_table_s">
						<tr>
							<th>工厂</th>
							<th>采购单号 项次</th>
							<th>物料</th>
							<th>描述</th>
							<th>采购单位</th>
							<th>采购量</th>
							<th>未交量(采购单位)</th>
							<th>期望交期</th>
							<th>采购交期</th>
							<th>操作</th>
						</tr>
						<s:iterator value="results" status="st" var="item">
							<s:if test="#st.Even">
								<tr class="td_bgcolor">
							</s:if>
							<s:else>
								<tr class="td_bgcolor2">
							</s:else>
							<td><s:property value="whidji" /></td>
							<td><s:property value="ordrji" /> - <s:property
									value="pisqji" /> - <s:property value="bksqji" /></td>
							<td><s:property value="itnoji" /></td>
							<td><s:property value="ds40ji" /></td>
							<td><s:property value="orumji" /></td>
							<td><s:property value="ucoqji" /></td>
							<td><s:property value="qtyoji" /></td>
							<td><s:property value="wkdtji" /></td>
							<td><s:property value="dkdtji" /></td>
							<td><input type="button" value="通过"
								onclick="allow('${item.ordrji}','${item.pisqji}','${item.bksqji}','${item.wkdtji }');"/>
								<input type="button" value="拒绝"
								onclick="refuse('${item.ordrji}','${item.pisqji}','${item.bksqji}');"/>
							</td>
							</tr>
						</s:iterator>
					</table>
				</div>
			</div>
		</div>
		<div class="page">
			<page:paginator formName="queryform" nameInRequest="paginator" />
		</div>
	</s:form>
</body>

</html>