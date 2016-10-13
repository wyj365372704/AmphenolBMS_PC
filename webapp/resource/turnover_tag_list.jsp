<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>周转标签</title>

<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
</head>
<style type="text/css">
.mybtnsch {
	margin-left: 10px !important;
}
</style>

<body class="right_body">

	<s:form action="turnover!toTurnoverList.action" method="post" name="queryform">
		<div class="path">您现在的位置： 首页 &gt; 生产 &gt; 打印周转标签</div>
		<div class="search">
			<h2>
				<span class="fl">周转查询</span> 
				<span class="fr"> 
				<s:submit id="queryId" value="" cssClass="search_button"
						onclick="return dosubmit()"></s:submit> <s:reset value=""
						cssClass="purge_button"></s:reset>
				</span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>
			<ul>
				<li><div class="w_s">仓库：</div> <select id="select1"
					style="width: 60px;">
						<option value="">-</option>
						<option value="A">A</option>
						<option value="A">B</option>
				</select></li>

				<li><div class="w_s">生产订单号：</div> <s:textfield name=""
						cssClass="input_w" /></li>

				<li><div class="w_s">部门号：</div> <s:textfield name=""
						cssClass="input_w" /></li>
			</ul>
		</div>
		<div class="data_list">
			<h2>
				<span class="fl">周转列表</span> 
				<span class="fr"></span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>
			<div class="list_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="list_table_s">
					<tr>
						<th>单号</th>
						<th>产品</th>
						<th>描述</th>
						<th>数量</th>
						<th>单位</th>
						<th>部门</th>
						<th>开始日期</th>
						<th>完工日期</th>
						<th>状态</th>
						<th>已完工</th>
						<th>未完工</th>
						<th>操作</th>
					</tr>
					<tr class="td_bgcolor2">
						<td>M508440</td>
						<td>T35-0046GU</td>
						<td>3001-455C-WWW MEGALTSG</td>
						<td>138.0</td>
						<td>PC</td>
						<td>B003</td>
						<td>2016-07-06</td>
						<td>2016-07-13</td>
						<td>已下单</td>
						<td>0.000</td>
						<td>138.0</td>
						<td><input type="button" Class="gray_button" value="打印"
							onclick="print('<s:property value="grnno"/>','<s:property value="grdte"/>')"></td>
					</tr>
					<tr class="td_bgcolor2">
						<td>M50788440</td>
						<td>T35-0046GU</td>
						<td>3001-455C-WWW MEGALTSG</td>
						<td>138.0</td>
						<td>PC</td>
						<td>B003</td>
						<td>2016-07-06</td>
						<td>2016-07-13</td>
						<td>已下单</td>
						<td>0.000</td>
						<td>138.0</td>
						<td><input type="button" Class="gray_button" value="打印"
							onclick="print('<s:property value="grnno"/>','<s:property value="grdte"/>')"></td>
					</tr>
				</table>
				<div class="page">
					<page:paginator formName="queryform" nameInRequest="paginator" />
				</div>
			</div>
		</div>
	</s:form>

</body>

<script type="text/javascript">
	function print(grnno, grdte) {
		window.open('turnover!toTurnoverTag.action?grnno=' + grnno + '&grdte=' + grdte, 'newwindow', 'height=600,width=800,top=60,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	}
</script>
</html>