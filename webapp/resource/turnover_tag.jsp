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
<script type="text/javascript">
	function print(grnno, grdte) {
		//window.open('myGrn!toPrintGrn.action?grnno=' + grnno + '&grdte=' + grdte, 'newwindow', 'height=600,width=800,top=60,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	}
</script>

<body class="right_body">
	<s:form action="#" method="post" name="makeMark">

		<div class="path">您现在的位置： 首页 &gt; 仓库 &gt; 物料标签</div>
		<div class="public_div">
			<h2>
				<br> <span class="fl"></span>
			</h2>
			<h2>
				<span class="fl">标签信息</span> <span class="fr"></span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>
			<div class="public_inner" style="width:98%">
				<table border="0" cellpadding="0" cellspacing="1"
					class="public_table">
					<tr>
						<td align="right">工单：</td>
						<td><input type="text" id="worder" class="input_w" value=""
							readonly="readonly" /></td>
					</tr>
					<tr>
						<td align="right">产品：</td>
						<td><input type="text" id="product" class="input_w" value=""
							readonly="readonly" /></td>
					</tr>
					<tr>
						<td align="right">描述：</td>
						<td><input type="text" id="desc" class="input_w" value=""
							readonly="readonly" /></td>
					</tr>
					<tr>
						<td align="right">规格：</td>
						<td><input type="text" id="spec" class="input_w" value=""
							readonly="readonly" /></td>
					</tr>
					<tr>
						<td align="right">每箱数量：</td>
						<td><input type="text" id="qty" class="input_w" value=""/></td>
					</tr>
					<tr>
						<td align="right">单重：</td>
						<td><input type="text" id="pweight" class="input_w" value=""/></td>
					</tr>
					<tr>
						<td align="right">净重：</td>
						<td><input type="text" id="suttle" class="input_w" value=""
							readonly="readonly" /></td>
					</tr>
					<tr>
						<td align="right">单位：</td>
						<td><input type="text" id="unit" class="input_w" value=""
							readonly="readonly" /></td>
					</tr>
					<tr>
						<td align="right">批号：</td>
						<td><input type="text" id="batch" class="input_w" value="" disabled/></td>
					</tr>
					<tr>
						<td align="right">日期：</td>
						<td>
							<!-- <input type="text" id="mydate" class="input_w" value=""/> -->
							<s:textfield  id="mydate" cssClass="time_input" onclick="WdatePicker()" autocomplete="on"/>
						</td>
					</tr>
					<tr>
						<td align="right">部门：</td>
						<td><input type="text" id="depa" class="input_w" value=""
							readonly="readonly" /></td>
					</tr>
					<tr>
						<td align="right">生产线：</td>
						<td><input type="text" id="prounit " class="input_w" value=""/></td>
					</tr>
					<tr>
						<td align="right">打印机：</td>
						<td><select id="printer">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							</select></td>
					</tr>
					<tr align="center">
						<td></td>
						<td>
							<table style="width:100%">
								<tr>
									<td><input type="button"
										class="button_m" value="打印" onclick="show();" /></td>
									<td><s:reset value="重置" Class="button_m"></s:reset></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<div class="page"  style="display: none;">
					<page:paginator formName="queryform" nameInRequest="paginator" />
				</div>
			</div>
		</div>
	</s:form>
</body>
<script type="text/javascript">
	function show() {
		var worder = document.getElementById("worder").value; // 工单
		var product = document.getElementById("product").value; // 产品
		var desc = document.getElementById("desc").value; // 描述
		var spec = document.getElementById("spec").value; // 规格
		var qty = document.getElementById("qty").value; // 每箱数量
		var pweight = document.getElementById("pweight").value; // 单重
		var suttle = document.getElementById("suttle").value; // 净重
		var unit = document.getElementById("unit").value; // 单位
		var batch = document.getElementById("batch").value; // 批号
		var mydate = document.getElementById("mydate").value; // 日期
		var depa = document.getElementById("depa").value;  // 部门
		var prounit = document.getElementById("prounit").value; // 生产线
		var printer = document.getElementById("printer").value; // 打印机
		
		if (!worder) {
			alert("工单不能为空!");
			return;
		} else if (!product) {
			alert("产品不能为空!");
			return;
		} else if (!qty) {
			alert("每箱数量不能为空!");
			return;
		} else if (isNaN(qty)) {
			alert("每箱数量输入非法!");
			return;
		} else if (!pweight) {
			alert("单重不能为空!");
		} else if (isNaN(pweight)) {
			alert("单重输入非法!");
			return;
		} else if (!document.getElementById("batch").disabled) {
			alert("批号不能为空!");
			return;
		} else if (!mydate) {
			alert("日期不能为空!");
		} else if (!prounit) {
			alert("生产线不能为空!");
		} else if (!printer) {
			alert("打印机不能为空!");
		}
		
		window.resizeTo(900, 750);
		window.open('material!toPrintMaterialTag.action?qrcode='+ fordrji, 'newwindow', 'height=400,width=500,top=50,left=100,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	}
</script>
</html>