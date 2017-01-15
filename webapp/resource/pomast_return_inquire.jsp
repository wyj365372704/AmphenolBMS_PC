<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath()%>/css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
<script src="<%=request.getContextPath()%>/js/alert/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/alert/jquery.alerts.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/common.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/js/alert/alerts.css" rel="stylesheet" type="text/css" />
</head>
	<script type="text/javascript">
		var data = "${data}";
		var vrdno = "${vrdno}";
		if(data=="success"){
			alert("退料单添加成功,退料单号:"+vrdno);
			window.close();
		}else if(data=="fail"){
			alert("退料单添加失败");
			window.close();
		}
	</script>
<script type="text/javascript">
		function radioChanged(){
	if(document.getElementById("printA").checked){
		document.getElementById("vrdno_tr").style.display="";
	}else{
		document.getElementById("vrdno_tr").style.display="none";
	}
}
</script>
<body>
	<s:form action="pomast!toPomastReturnSubmit.action" method="post">
		<div class="public_div">
		<input type="hidden" name="sctkji" value="${sctkji}">
			<div class="public_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="public_table">
					<tbody>
						<tr>
							<td class="td_w_s text_r">选择退货单：</td>
							<td><input id="printA" type="radio" name="returnType"
								value="1" onclick="radioChanged();" checked="checked" />使用已有退货单<input
								id="printB" type="radio" name="returnType" value="0"
								onclick="radioChanged();" />新创建退货单</td>
						</tr>
						<tr id="vrdno_tr">
							<td class="td_w_s text_r">退货单号：</td>
							<td>
							<s:if test="zvrhdrList==null||zvrhdrList.isEmpty()"> 	</s:if><s:else>
								<s:select list="zvrhdrList" id="sel" emptyOption="false"
									name="vrdno" m="search" class='input_w' listKey="vrdno"
									listValue="vrdno"></s:select></s:else>
						
							</td>
						</tr>
						<tr>
							<td class="td_w_s text_r">退货数量：</td>
							<td><s:textfield name="quantity" cssClass="input_w"
									cssStyle="width:120px;" /></td>
						</tr>

						<tr>

							<td align="center" colspan="2"><s:submit id="queryId"
									value="确认"></s:submit>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</s:form>
</body>
<script type="text/javascript">
radioChanged();
	</script>
</html>
