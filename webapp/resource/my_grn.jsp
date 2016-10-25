<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>到货单</title>

<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
</head>
<style type="text/css">
	.mybtnsch{
		margin-left: 10px !important;
	}
</style>
<script type="text/javascript">
	function print(grnno, grdte){
		window.open('myGrn!toPrintGrn.action?grnno='+ grnno +'&grdte='+grdte,'newwindow','height=600,width=800,top=60,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	}
</script>

<body class="right_body">

	<s:form action="myGrn!tofindGrn.action" method="post" name="queryform">

		<div class="path">您现在的位置： 首页 &gt; 仓库 &gt; 打印到货单</div>
		
			<div class="search">
			<h2>
				<span class="fl">到货单查询</span>
				<span class="fr">
					<s:submit id="queryId" value="" cssClass="search_button" onclick="return dosubmit()"></s:submit>
					<s:reset value="" cssClass="purge_button"></s:reset>
				</span><!--  span里无内容时，此span不能删除  -->
			</h2>
			
			<ul>
				
				<li><div class="w_s">送货单号码：</div>
					<s:textfield name="grnvo.grnno" cssClass="input_w"/>
				</li>
				
				<%-- <li><div class="w_s">创建日期：</div> 
					<s:textfield name="shdDate" cssClass="input_w"/>
				</li> --%>

			</ul>
		</div>
		
		<div class="data_list">
			<h2>
				<span class="fl">到货单列表</span>
				<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
			</h2>
			
			<div class="list_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0" class="list_table_s">
				  <tr>
					<th>到货单号码</th>
					<th>发票号码</th>
					<th>到货单状态</th>
					<th>创建日期</th>
					<th>操作</th> 
				  </tr>
				<s:iterator value="results" id="rs" status="st">
  				 	<s:if test="#st.Even">
			      		<tr class="td_bgcolor">
			      	</s:if>
			      	<s:else>
			      		<tr class="td_bgcolor2">
			      	</s:else>
		  				<td><s:property value="grnno"/></td>
		  				<td><s:property value="lgwno"/></td>
		  				<td>
		  					<s:if test="50 == ostat">
					      		已完成
					      	</s:if>
		  					<s:elseif test="10 == ostat">
					      		已创建
					      	</s:elseif>
					      	<s:elseif test="40 == ostat">
					      		部分收货
					      	</s:elseif>
		  				</td>
		  				<td><s:property value="scrdt"/></td>
		  				<td><input type="button" Class="gray_button" value="打印" onclick="print('<s:property value="grnno"/>','<s:property value="grdte"/>')"></td>
	  			   	</tr>
	  			</s:iterator>
			  </table>
				<div class="page">
		  			<page:paginator formName="queryform" nameInRequest="paginator"/>
				</div>
			</div>
		</div>
		
	</s:form>

</body>

</html>