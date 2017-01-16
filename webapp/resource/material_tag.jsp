<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物料标签</title>
<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/jquery.selectseach.min.js"></script>
<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />

</head>
<script type="text/javascript">
	function changeF() {
		var selVal = document.getElementById('sel').value;
		htmlobj = $
				.ajax({
					url : "resource/material!getDetail.action?itnot9=" + selVal,
					async : false,
					datatype : "json",
					type : "GET",
					contentType : "application/json",
					success : function(data) {//这里的data是由请求页面返回的数据    
						var dataJson = JSON.parse(data); // 使用json2.js中的parse方法将data转换成json格式   
						document.getElementsByName('fds40ji')[0].value = dataJson.ldesc;
						document.getElementsByName('sdesc')[0].value = dataJson.sdesc;
						document.getElementsByName('umstt9')[0].value = dataJson.umstt9;
						document.getElementsByName('fweight')[0].value = dataJson.single;
						var blcft9 = dataJson.blcft9;
						if (blcft9 == 0) {
							document.getElementsByName("fblcft9")[0].value = "";
							document.getElementsByName("fblcft9")[0].disabled = true;
						} else {
							document.getElementsByName("fblcft9")[0].disabled = false;
						}
						var b2cqcd = dataJson.single_unit;
			             if(b2cqcd == "g"){
			         	    document.getElementsByName("fweight_unit")[0].options[1].selected = false;
			          	   document.getElementsByName("fweight_unit")[0].options[0].selected = true;
			             }else{
							document.getElementsByName("fweight_unit")[0].options[0].selected = false;
			             	document.getElementsByName("fweight_unit")[0].options[1].selected = true;
			             }
					}
				});
	}
	$(document).ready(function() {
		$('select').selectseach();
	});
	function getItems() {
		//alert(document.getElementsByName("searcht")[0].value);
		var itnot9 = document.getElementsByName("searcht")[0].value;
		$.ajax({
			url : "material!searchMaterialTag.action?itnot9=" + itnot9,
			async : false,
			type : "GET",
			success : function(data) {//这里的data是由请求页面返回的数据    
				//var dataJson = JSON.parse(data); // 使用json2.js中的parse方法将data转换成json格式   
				//$("#show").html("data=" + data + " name="+dataJson.name+"  age=" + dataJson.age);  
				//alert(data);   
				document.getElementById('sel').innerHTML = data;
			}
		});
	}
</script>
<body class="right_body">
	<s:form action="material!toPrintMaterialTag.action" method="post"
		name="queryForm" target="_blank">

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
						<td align="right">物料：<font color="red">*</font>
						</td>
						<td>
							<select id="sel" name="fordrji" m='search' class='input_w' onchange="changeF();">
							<s:iterator value="itmsitList"><option value="<s:property value="itnot9.trim()"/>"><s:property value="itnot9.trim()" /></option></s:iterator>
						</select></td>
						<td rowspan="11" width="55%">
							<div id="qrtlb">
								<div id="qrcodeTable"></div>
							</div></td>
					</tr>
					<tr>
						<td align="right">描述：<font color="red"></font>
						</td>
						<td><input name=fds40ji type="text" class="input_w" value="" />
						</td>
					</tr>
					<tr>
						<td align="right">规格：<font color="red"></font>
						</td>
						<td><input name=sdesc type="text" class="input_w" value="" />
						</td>
					</tr>
					<tr>
						<td align="right">每包装数量：<font color="red">*</font>
						</td>
						<td><input name=fcout type="text" class="input_w" value="" />
						</td>
					</tr>
					<tr>
						<td align="right">库存单位：<font color="red"></font>
						</td>
						<td><input name=umstt9 type="text" class="input_w" value="" />
						</td>
					</tr>
					<tr id="blanch_tr">
						<td align="right">批号：<font color="red">*</font>
						</td>
						<td><input name=fblcft9 type="text" class="input_w" value="" />
						</td>
					</tr>
					<tr>
						<td align="right">单重：<font color="red">*</font>
						</td>
						<td><input name=fweight type="text" class="input_w" value="" />
							<select name="fweight_unit" class="input_w" style="width: 40px">
								<option value="g" selected="selected">g</option>
								<option value="kg">kg</option>
						</select>
						</td>
					</tr>
					<tr>
						<td align="right">包材重：<font color="red">*</font>
						</td>
						<td><input name="outer_weight" type="text" class="input_w"
							value="" /> <select name="outer_weight_unit" class="input_w"
							style="width: 40px">
								<option value="g">g</option>
								<option value="kg" selected="selected">kg</option>
						</select>
						</td>
					</tr>
					<tr>
						<td align="right">日期：<font color="red"></font>
						</td>
						<td><s:textfield name="fdate" cssClass="time_input"
								onclick="WdatePicker()" autocomplete="on" /></td>
					</tr>
					<tr>
						<td align="right">厂商：<font color="red"></font>
						</td>
						<td><input name=fproducter type="text" class="input_w"
							value="" />
						</td>
					</tr>
					<tr align="center">
						<td></td>
						<td>
							<table style="width:100%">
								<tr>
									<td><input name="makeMark" type="submit" class="button_m"
										value="打印" onclick="return check(this.form)" />
									</td>
									<td><s:reset value="重置" Class="button_m"></s:reset>
									</td>
								</tr>
							</table></td>
					</tr>
				</table>
			</div>
		</div>
	</s:form>
</body>
<script type="text/javascript">
	function check(form) {
		document.getElementById("qrtlb").innerHTML = "<div id='qrcodeTable'></div>";

		if (form.fordrji.value == null || form.fordrji.value == "") {
			alert("物料不能为空!");
			return false;
		}
		if (isNaN(form.fcout.value)) {
			alert("每包装数量输入非法");
			return false;
		}

		if (form.fcout.value == null || form.fcout.value == "") {
			alert("每包装数量不能为空!");
			return false;
		}
		if (form.fblcft9.disabled == "disabled") {
			if (form.fblcft9.value == null || form.fblcft9.value == "") {
				alert("批号不能为空!");
				return false;
			}
		}
		if (isNaN(form.fweight.value)) {
			alert("单重输入非法");
			return false;
		}

		if (form.fweight.value == null || form.fweight.value == "") {
			alert("单重不能为空!");
			return false;
		}
		if (isNaN(form.outer_weight.value)) {
			alert("包材重输入非法");
			return false;
		}
		if (form.outer_weight.value == null || form.outer_weight.value == "") {
			alert("包材重不能为空!");
			return false;
		}
		return true;
	}
</script>
<script language="javascript">
window.onload = changeF();
</script>
</html>
