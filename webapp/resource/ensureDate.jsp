<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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
	var pagenum = "1";
	function submit2() {
		// 

		document.getElementsByName("buyIn")[0].submit();
	}
	function first() {
		if (document.getElementsByName("pageno")[0].value == "1") {

		} else {
			document.getElementsByName("pageno")[0].value = "1";
			document.getElementsByName("buyIn")[0].submit();
		}

	}
	function pre() {
		XA
		if (parseInt(document.getElementsByName("pageno")[0].value) > 1) {
			document.getElementsByName("pageno")[0].value = parseInt(document
					.getElementsByName("pageno")[0].value) - 1;
			document.getElementsByName("buyIn")[0].submit();
		} else {
			document.getElementsByName("pageno")[0].value = "1";
		}

	}
	function next() {

		if (parseInt(pagenum)
				- parseInt(document.getElementsByName("pageno")[0].value) > 0) {
			document.getElementsByName("pageno")[0].value = parseInt(document
					.getElementsByName("pageno")[0].value) + 1;
			document.getElementsByName("buyIn")[0].submit();
		} else {
			document.getElementsByName("pageno")[0].value = pagenum;
		}

	}
	function last() {
		//alert(document.getElementsByName("pageno")[0].value==pagenum);
		if (document.getElementsByName("pageno")[0].value == pagenum) {

		} else {
			document.getElementsByName("pageno")[0].value = pagenum;
			document.getElementsByName("buyIn")[0].submit();
		}
		//document.getElementsByName("buyIn")[0].submit();
	}
	function edit(id) {
		/**
			var checkboxs=document.getElementsByName("checkbox");
			var isChecked = false;
			var count = 0;
			var id;
			for(var i=0;i<checkboxs.length;i++){
				if(checkboxs[i].checked){
					id=checkboxs[i].value;
					isChecked=true;
					count++;
				}
			}
			if(count>1){
				alert("只能选择一条记录");
				return false;
			}
			if(count==0){
				alert("请选择一条记录");
				return false;
			}
		 */
		//window.location.href="modifyBuyIn.html?id="+id;
		document.getElementsByName("buyIn")[0].action = "modifyBuyIn.jsp?id="
				+ id;
		document.getElementsByName("buyIn")[0].submit();
	}
	function editfkd(id, billid) {
		//if(null!=id && id!="null" && id!=""){
		document.getElementsByName("buyIn")[0].action = "modifyFkd.jsp?id="
				+ id + "&billid=" + billid;
		document.getElementsByName("buyIn")[0].submit();
		//}else{
		//	alert("暂无付款单！");
		//}

	}
	function editpz(id, billid) {
		//if(null!=id && id!="null" && id!=""){
		document.getElementsByName("buyIn")[0].action = "modifyFkd.jsp?id="
				+ id + "&billid=" + billid;
		document.getElementsByName("buyIn")[0].submit();
		//}else{
		//	alert("暂无付款单！");
		//}

	}
	function createfkd() {
		var checkboxs = document.getElementsByName("checkbox");
		var isChecked = false;
		var count = 0;
		var ids = "";
		for ( var i = 0; i < checkboxs.length; i++) {
			if (checkboxs[i].checked) {
				ids = ids + checkboxs[i].value + ";";
				isChecked = true;
				count++;
			}
		}

		if (count == 0) {
			alert("请选择一条记录");
			return false;
		}
		document.getElementsByName("ids")[0].value = ids;
		document.getElementsByName("operate")[0].value = "createfkd";
		document.getElementsByName("buyIn")[0].submit();
	}
	function createpz() {
		var checkboxs = document.getElementsByName("checkbox");
		var isChecked = false;
		var count = 0;
		var ids = "";
		for ( var i = 0; i < checkboxs.length; i++) {
			if (checkboxs[i].checked) {
				ids = ids + checkboxs[i].value + ";";
				isChecked = true;
				count++;
			}
		}

		if (count == 0) {
			alert("请选择一条记录");
			return false;
		}
		document.getElementsByName("ids")[0].value = ids;
		document.getElementsByName("operate")[0].value = "createpz";
		document.getElementsByName("buyIn")[0].submit();
	}
	function selectAll() {
		var checkboxs = document.getElementsByName("checkbox");
		var checkboxall = document.getElementsByName("checkboxall")[0];
		for ( var i = 0; i < checkboxs.length; i++) {
			if (checkboxall.checked) {
				checkboxs[i].checked = true;
			} else {
				checkboxs[i].checked = false;
			}

		}
	}
	function onclear() {
		//document.byInPz.reset();

		document.getElementsByName("fwarehouse")[0].value = "";
		document.getElementsByName("fordrji")[0].value = "";
		document.getElementsByName("finfoji")[0].value = "";
		document.getElementsByName("fds40ji")[0].value = "";
	}
	function selectrkd() {
		var supplier = document.getElementsByName("suppliers");
		var tempList = new Array();

		var checkboxs = document.getElementsByName("checkbox");

		var ids = "";
		for ( var i = 0; i < checkboxs.length; i++) {
			if (checkboxs[i].checked) {
				ids = ids + "'" + checkboxs[i].value + "',";
				tempList.push(supplier[i].value);
			}
		}
		var flag = "fp";

		//alert(tempList[0]);
		document.getElementsByName("ids")[0].value = ids;
		document.getElementsByName("supplierid")[0].value = tempList[0];
		if (flag == "fp") {
			if (tempList.length > 1) {
				for ( var j = 1; j < tempList.length; j++) {
					if (tempList[j - 1] != tempList[j]) {
						alert("请选择同一供应商开票！");
						return false;

					}
				}
			}
			document.getElementsByName("buyIn")[0].action = "buyInFpModify.jsp";
		} else {
			document.getElementsByName("buyIn")[0].action = "buyInFkdModify.jsp";
		}

		document.getElementsByName("buyIn")[0].submit();
	}

	function createfp() {

		var supplier = document.getElementsByName("suppliers");
		var tempList = new Array();

		var checkboxs = document.getElementsByName("checkbox");
		var isChecked = false;
		var count = 0;
		var ids = "";
		for ( var i = 0; i < checkboxs.length; i++) {
			if (checkboxs[i].checked) {
				tempList.push(supplier[i].value);

				ids = ids + "'" + checkboxs[i].value + "',";
				isChecked = true;
				count++;
			}
		}

		if (count == 0) {
			alert("请选择一条记录");
			return false;
		}
		if (tempList.length > 1) {
			for ( var j = 1; j < tempList.length; j++) {
				if (tempList[j - 1] != tempList[j]) {
					alert("请选择同一供应商开票！");
					return false;

				}
			}
		}
		//alert(tempList[0]);
		document.getElementsByName("ids")[0].value = ids;
		document.getElementsByName("supplierid")[0].value = tempList[0];
		document.getElementsByName("buyIn")[0].action = "buyInFpModify.jsp";
		document.getElementsByName("buyIn")[0].submit();
	}
	function ensureDate(flag) {
		window
				.open(
						'ensureDateModify.jsp' + encodeURI(flag),
						'newwindow',
						'height=400,width=400,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	}
	function gopage(fwarehouse, fordrji, finfoji, fds40ji) {
		var pageno = document.getElementById("gpageno").value;
		console.log("the pageno is " + parseInt(pageno));
		window.location.href = "ensureDate.jsp?page=" + parseInt(pageno)
				+ "&fwarehouse=" + fwarehouse + "&fordrji=" + fordrji
				+ "&finfoji=" + finfoji + "&fds40ji=" + fds40ji;

	}
</script>

<body class="right_body">
	<div class="path">您现在的位置： 首页 &gt; 采购 &gt; 审核交期</div>
	<form action="ensureDate.jsp" method="post" name="buyIn">
		<div class="top_button_div">

			<input name="operate" type="hidden" value="" /> <input name="ids"
				type="hidden" value="" /> <input name="supplierid" type="hidden"
				value="" />
		</div>

		<div class="search">
			<h2>
				<span class="fl">待审核采购订单查询</span> <span class="fr"><input
					name="" type="button" class="search_button" onclick="submit2();" /><input
					name="rs" type="button" class="purge_button" onclick="onclear();" />
				</span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>

			<ul>
				<li><div class="w_s">仓库：</div> <s:select name="WHIDJI"
						list="#session.houses" listKey="house" listValue="house"
						cssClass="select_s_2" style="width:60px"></s:select>
				</li>
				<li><div class="w_s">采购单号：</div> <s:textfield name="ORDRJI"
						cssClass="input_w"></s:textfield>
				</li>

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
						<s:iterator var="results" value="item">
							<tr>
								<td><s:property value="whidji" />
								</td>
								<td><s:property value="ordrji" /> - <s:property value="pisqji" /> - <s:property
										value="bksqji" />
								</td>
								<td><s:property value="itnoji" />
								</td>
								<td><s:property value="ds40ji" />
								</td>
								<td><s:property value="orumji" />
								</td>
								<td><s:property value="ucoqji" />
								</td>
								<td><s:property value="qtyoji" />
								</td>
								<td><s:property value="wkdtji" />
								</td>
								<td><s:property value="dkdtji" /></td>
								<td><input type="button" value="确认送货日期"></td>
							</tr>
						</s:iterator>
					</table>
				</div>
				<div class="page">
					<page:paginator formName="queryform" nameInRequest="paginator" />
				</div>
			</div>
	</form>
	</div>



</body>

</html>