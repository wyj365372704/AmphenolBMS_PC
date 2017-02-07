<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物料识别卡</title>

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
	function print(grnno, grdte) {
		//window.open('myGrn!toPrintGrn.action?grnno=' + grnno + '&grdte=' + grdte, 'newwindow', 'height=600,width=800,top=60,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	}
</script>

<body class="right_body">
	<s:form action="#" method="post" name="makeMark">
		<div class="public_div">
			<h2>
				<span class="fl">标签信息</span> <span class="fr"></span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>
			<div class="public_inner" style="width:98%">
				<table border="0" cellpadding="0" cellspacing="1"
					class="public_table">
					<tr>
						<td align="right">工单：</td>
						<td><input id="ordno" type="text" value='<s:property value='ordno'/>'
							readonly="readonly" class="input_w"></td>
					</tr>
					<tr>
						<td align="right">产品：</td>
						<td><input id="fitem" type="text" value='<s:property value='fitem'/>'
							readonly="readonly" class="input_w"></td>
					</tr>
					<tr>
						<td align="right">描述：</td>
						<td><input id="fdesc" type="text" value='<s:property value='fdesc'/>'
							readonly="readonly" class="input_w"></td>
					</tr>

					<tr>
						<td align="right">数量：</td>
						<td><input id="moqty" type="text" value='<s:property value='moqty'/>'
							class="input_w"></td>
					</tr>
					<tr>
						<td align="right">数量单位：</td>
						<td><input id="unmsr" type="text" value='<s:property value='unmsr'/>'
							readonly="readonly" class="input_w"></td>
					</tr>
					<tr>
						<td align="right">单重：</td>
						<td><input id="weght" type="text" value='<s:property value='weght'/>'
							class="input_w"></td>
					</tr>
					<tr>
						<td align="right">单重单位：</td>
						<td>
						<input id="b2cqcd" type="text" value='<s:property value='b2cqcd'/>'
							readonly="readonly" class="input_w"></td>
					</tr>
					<tr>
						<td align="right">批号：</td>
						<td><s:if test="blcft9 == 0">
								<input type="text" id="batch" class="input_w" value="" disabled />
							</s:if><s:else> <input type="text" id="batch" class="input_w" value="" /></s:else>
						</td>
					</tr>
					<tr>
						<td align="right">日期：</td>
						<td>
							<!-- <input type="text" id="mydate" class="input_w" value=""/> -->
							<s:textfield id="mydate" name="mydate" cssClass="time_input"
								onclick="WdatePicker()" autocomplete="on" />
						</td>
					</tr>

					<tr>
						<td align="right">生产线：</td>
						<td><input type="text" id="prounit" class="input_w" value="" />
						</td>
					</tr>

					<tr align="center">
						<td></td>
						<td>
							<table style="width:100%">
								<tr>
									<td><input type="button" class="button_m" value="打印"
										onclick="show();" /></td>
									<td><s:reset value="重置" Class="button_m"></s:reset></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<div class="page" style="display: none;">
					<page:paginator formName="queryform" nameInRequest="paginator" />
				</div>
			</div>
		</div>
	</s:form>
</body>
<script type="text/javascript">
	function show() {
		var ordno = document.getElementById("ordno").value; // 工单
		var fitem = document.getElementById("fitem").value; // 产品
		var fdesc = document.getElementById("fdesc").value; // 描述
		var moqty = document.getElementById("moqty").value; // 数量
		var unmsr = document.getElementById("unmsr").value; // 数量单位
		var weght = document.getElementById("weght").value; // 单重
		var b2cqcd = document.getElementById("b2cqcd").value; // 单重单位
		var batch = document.getElementById("batch").value; // 批号
		var mydate = document.getElementById("mydate").value; // 日期
		var prounit = document.getElementById("prounit").value; // 生产线

		if (!ordno) {
			alert("工单不能为空!");
			return;
		} else if (!fitem) {
			alert("产品不能为空!");
			return;
		} else if (!moqty) {
			alert("数量不能为空!");
			return;
		} else if (isNaN(moqty)) {
			alert("每箱数量输入非法!");
			return;
		} else if (!weght) {
			alert("单重不能为空!");
		} else if (isNaN(weght)) {
			alert("单重输入非法!");
			return;
		} else if (!document.getElementById("batch").disabled) {
			if (!batch) {
				alert("批号不能为空!");
				return;
			}
		} else if (!mydate) {
			alert("日期不能为空!");
			return;
		} else if (!prounit) {
			alert("生产线不能为空!");
			return;
		} 

		window
				.open(
						'turnover!toPrintTurnoverTag.action?ordno=' + ordno + '&fitem=' + fitem +'&fdesc=' + fdesc + '&moqty=' + moqty + '&unmsr=' + unmsr + '&weght=' + weght + '&b2cqcd=' + b2cqcd + '&batch=' + batch + '&mydate=' + mydate + '&prounit=' + prounit,
						'newwindow',
						'height=400,width=500,top=50,left=100,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	}
</script>
</html>