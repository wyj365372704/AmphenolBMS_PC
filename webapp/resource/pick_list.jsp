<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>领料单</title>
<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
</head>
<style type="text/css">
.myli {
	width: 160px !important;
}

.mylirt {
	margin-right: 150px !important;
}

.mylick {
	width: 90px !important;
}

.mybtnsch {
	margin-left: 10px !important;
}
</style>

<body class="right_body">
	<s:form action="#" method="post"
		name="queryform">

		<div class="path">您现在的位置： 首页 &gt; 生产 &gt; 打印领料单</div>

		<div class="search">
			<h2>
				<span class="fl">领料单查询</span> <span class="fr"> <s:submit
						id="queryId" value="" cssClass="search_button"
						onclick="return dosubmit()"></s:submit> <s:reset value=""
						cssClass="purge_button"></s:reset>
						<input type="button"
					cssClass="search_button" onclick="myPrint()" value="批量打印领料单">
				</span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>

			<ul>
				<li><div class="w_s">领料单号：</div> <s:textarea name=""
						cssClass="input_w" style="height:30px"></s:textarea></li>

				<li><div class="w_s">工单号：</div> <s:textarea
						name="" cssClass="input_w" style="height:30px"></s:textarea></li>

				<li><div class="w_s">创建日期：</div> <s:textfield  id="startDate" name="startDate" cssClass="time_input" onclick="WdatePicker()" autocomplete="on"/>-
            <s:textfield  id="endDate" name="endDate" cssClass="time_input" onclick="WdatePicker()" autocomplete="on"/></li>
			</ul>
		</div>

		<div class="data_list">
			<h2>
				<span class="fl">领料单列表</span> <span class="fr"></span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>

			<div class="list_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="list_table_s">
					<tbody>
						<tr>
							<th><input type="checkbox" name="cba"
								onclick="selectall(this)" />全选</th>
							<th>领料单号</th>
							<th>工单</th>
							<th>类型</th>
							<th>创建人</th>
							<th>创建部门</th>
							<th>创建日期</th>
							<th>备注</th>
							<th>已打印</th>
							<th>已审批</th>
							<th>状态</th>
							<th>审批人</th>
							<th>审批日期</th>
							<th>审批时间</th>
						</tr>
						<tr class="td_bgcolor2">
							<th><input type="checkbox" name="cb"
								value="IP2016072200293" onclick="subselectall()" /></th>
							<th>IP2016072200293</th>
							<th>M002740</th>
							<th>正常</th>
							<th>S2122836</th>
							<th>A001</th>
							<th>2016-04-14</th>
							<th></th>
							<th>否</th>
							<th>否</th>
							<th>创建中</th>
							<th></th>
							<th>0</th>
							<th>0</th>
						</tr>
						<tr class="td_bgcolor">
							<th><input type="checkbox" name="cb"
								value="IP2016096500293" onclick="subselectall()" /></th>
							<th>IP2016096500293</th>
							<th>M002740</th>
							<th>正常</th>
							<th>S2122836</th>
							<th>A001</th>
							<th>2016-04-14</th>
							<th></th>
							<th>否</th>
							<th>否</th>
							<th>创建中</th>
							<th>S1010176</th>
							<th>2016-07-22</th>
							<th>18:51:26</th>
						</tr>
					</tbody>
				</table>
				<div class="page">
					<page:paginator formName="queryform" nameInRequest="paginator" />
				</div>
			</div>
		</div>
	</s:form>

</body>
<script type="text/javascript">
	// 全选
	function selectall(self) {
		var cba = self;
		var bool = false;
		if (self.checked) {
			bool = true;
		}

		var cbs = document.getElementsByName("cb");
		for (var i = 0; i < cbs.length; i++) {
			cbs[i].checked = bool;
		}
	}

	// 子选项
	function subselectall() {
		var cba = document.getElementsByName("cba")[0];
		var cbs = document.getElementsByName("cb");
		var count = cbs.length;

		var selectCount = 0;
		for (var i = 0; i < count; i++) {
			if (cbs[i].checked == true) {
				selectCount++;
			}
		}
		if (count == selectCount) {
			cba.checked = true;
		} else {
			cba.checked = false;
		}
	}

	// 打印
	function myPrint() {
		// 检查是否选中记录
		var cbs = document.getElementsByName("cb");
		if (!cbs) {
			alert("未选中记录！");
			return;
		}

		var gno = new Array();
		var count = 0;
		cbs.forEach(function(p) {
			if (!p.checked) {
				bool = false;
			} else {
				count++;
				gno.push(p.value);
			}
		})

		if (count <= 0) {
			alert("未选中记录！");
			return;
		}

		var grnnos = JSON.stringify({
			grnnos : gno
		});

		window.open('picklist!pickPrint.action?grnno=' + grnnos, 'newwindow', 'height=200,width=400,top=60,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	}
</script>
</html>
