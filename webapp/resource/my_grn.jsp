<%@ page contentType="text/html;charset=UTF-8"%>
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
.mybtnsch {
	margin-left: 10px !important;
}
</style>
<script type="text/javascript">
	function selectall(){
		var ischk = document.getElementsByName("chkall")[0].checked;
		//if(ischk){
			var chkall = document.getElementsByName("chk");
			for(var i=0;i<chkall.length;i++){
				chkall[i].checked=ischk;
			}
		//}
		
	}
	// 打印
	function toPrint() {
		// 检查是否选中记录
		var cbs = document.getElementsByName("chk");
		if (!cbs) {
			alert("未选中记录！");
			return;
		}

		var gno = new Array();
		var count = 0;
		for(var i=0;i<cbs.length;i++){
			if (!cbs[i].checked) {
				bool = false;
			} else {
				count++;
				gno.push($.trim(cbs[i].value));
			}
		}

		if (count <= 0) {
			alert("未选中记录！");
			return;
		}

		var grnnos = JSON.stringify({
			grnnos : gno
		});

		window.open('myGrn!toPrintGrn.action?grnno=' + grnnos, 'newwindow','height=600,width=800,top=60,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	}
</script>
<body class="right_body">


	<div class="path">您现在的位置： 首页 &gt; 仓库 &gt; 打印到货单</div>
	<s:form action="myGrn!toGrn.action" method="post" name="queryform">
		<s:hidden name="query" value="1"></s:hidden>
		<div class="search">
			<h2>
				<span class="fl">到货单查询</span> <span class="fr"> <s:submit
						id="queryId" value="" cssClass="search_button"
						onclick="return dosubmit()"></s:submit> <s:reset value=""
						cssClass="purge_button"></s:reset>  <input type="button"
					onclick="toPrint()" value="打印"></span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>

			<ul>

				<li><div class="w_s">到货单号：</div> <s:textfield
						name="zgrnhdr.grnno" cssClass="input_w" /></li>
				<li><div class="w_s">送货单号：</div> <s:textfield
						name="zgrnhdr.shpno" cssClass="input_w" /></li>
						
					<li><div class="w_s">创建日期：</div> <s:textfield id="startDate"
						name="startDate" cssClass="time_input"
						onclick="WdatePicker()" autocomplete="on" /> - <s:textfield
						id="endDate" name="endDate" cssClass="time_input"
						onclick="WdatePicker()" autocomplete="on" /></li>
						
				<li><div class="w_s">到货单状态：</div> 
				<s:select list="#{'':'全部','40':'部分收货','50':'已完成'}" name="zgrnhdr.ostat"
				headerValue="zgrnhdr.ostat" style="width:80px" cssClass="select_s_2" ></s:select>
				</li>

			</ul>
		</div>
	</s:form>
	<div class="data_list">
		<h2>
			<span class="fl">到货单列表</span> <span class="fr"></span>
			<!--  span里无内容时，此span不能删除  -->
		</h2>

		<div class="list_inner">
			<table width="100%" border="0" cellspacing="1" cellpadding="0"
				class="list_table_s">
				<tr>
					<th><input name="chkall" type="checkbox"
							onclick="selectall();" /> 到货单号</th>
					<th>送货单号</th>
					<th>发票号</th>
					<th>到货单状态</th>
					<th>创建日期</th>
				
				</tr>
				<s:iterator value="results" id="rs" status="st">
					<s:if test="#st.Even">
						<tr class="td_bgcolor">
					</s:if>
					<s:else>
						<tr class="td_bgcolor2">
					</s:else>
					<td><input name="chk" type="checkbox"
							value="<s:property value="grnno"/>" />
					<s:property value="grnno" />
					<td><s:property value="shpno" />
					</td>
					<td><s:property value="lgwno" />
					</td>
					<td><s:if test="50 == ostat">
					      		已完成
					      	</s:if> <s:elseif test="10 == ostat">
					      		已创建
					      	</s:elseif> <s:elseif test="40 == ostat">
					      		部分收货
					      	</s:elseif></td>
					<td><s:property value="scrdt" />
					</td>
					</tr>
				</s:iterator>
			</table>
			<div class="page">
				<page:paginator formName="queryform" nameInRequest="paginator" />
			</div>

		</div>
	</div>

</body>

</html>