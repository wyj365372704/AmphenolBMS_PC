<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>调拨单</title>

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
	<s:form action="allotted!tofindAllotted.action" method="post"
		name="queryform">

		<div class="path">您现在的位置： 首页 &gt; 仓库 &gt; 打印调拨单</div>

		<div class="search">
			<h2>
				<span class="fl">调拨单查询</span> <span class="fr"> <s:submit
						id="queryId" value="" cssClass="search_button"
						onclick="return dosubmit()"></s:submit> <s:reset value=""
						cssClass="purge_button"></s:reset> </span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>

			<ul>

				<li><div class="w_s">从仓库：</div> <s:textfield
						name="ztwdtl.frwhs" cssClass="input_w" /></li>

				<li><div class="w_s">到仓库：</div> <s:textfield
						name="ztwdtl.towhs" cssClass="input_w" /></li>

				<li><div class="w_s">调拨单号：</div> <s:textfield name="ztw.twdno"
						cssClass="input_w" /></li>

				<li><div class="w_s">从子库：</div> <s:textfield
						name="ztwdtl.frsub" cssClass="input_w" /></li>

				<li><div class="w_s">到子库：</div> <s:textfield
						name="ztwdtl.tosub" cssClass="input_w" /></li>

				<li class="mylick"><s:checkbox name="showFinished">显示已完成</s:checkbox>
				</li>

				<li class="mylick"><s:checkbox name="showPrinted">显示已打印</s:checkbox>
				</li>
			</ul>
		</div>

		<div class="data_list">
			<h2>
				<span class="fl">调拨单列表</span> <span class="fr"></span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>

			<div class="list_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="list_table_s">
					<tr>
						<th>调拨单号-项次</th>
						<th>物料</th>
						<th>描述</th>
						<th>数量</th>
						<th>状态</th>
						<th>是否打印</th>
						<th>单位</th>
						<th>从仓库</th>
						<th>从子库</th>
						<th>到仓库</th>
						<th>到子库</th>
						<th>创建人</th>
						<th>创建日期</th>
						<th>创建部门</th>
						<th>操作</th>
					</tr>
					<s:iterator value="results" id="rs" status="st">
						<s:if test="#st.Even">
							<tr class="td_bgcolor">
						</s:if>
						<s:else>
							<tr class="td_bgcolor2">
						</s:else>
						<s:iterator value="#rs.itemList" id="it" status="st">
							<td><s:property value="#it.twdno" />
							</td>
							<td><s:property value="#it.itnbr" />
							</td>
							<td><s:property value="#it.itdsc" />
							</td>
							<td><s:property value="#it.actqt" />
							</td>
							<td><s:if test="#it.lstat == '10'">已创建</s:if> <s:elseif
									test="#it.lstat == '50'">已完成</s:elseif> <s:elseif
									test="#it.lstat == '60'">已关闭</s:elseif>
							</td>
							<td><s:if test="#it.lprt == '1'">
			  						是
			  					</s:if> <s:else>
			  						否
			  					</s:else></td>
							<td><s:property value="#it.unmsr" />
							</td>
							<td><s:property value="#it.frwhs" />
							</td>
							<td><s:property value="#it.frsub" />
							</td>

							<td><s:property value="#it.towhs" />
							</td>
							<td><s:property value="#it.tosub" />
							</td>
							<td><s:property value="twus1" />
							</td>
							<td><s:property value="twdt1" />
							</td>
							<td><s:property value="twdp1" />
							</td>
							<td><input type="button" id="print" value="打印"
								class="gray_button"
								onclick="printForm('<s:property value="#rs.twdno"/>');" />
							</td>
						</s:iterator>
						</tr>
					</s:iterator>
				</table>
				<div class="page">
					<page:paginator formName="queryform" nameInRequest="paginator" />
				</div>
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
		for ( var i = 0; i < cbs.length; i++) {
			cbs[i].checked = bool;
		}
	}

	// 子选项
	function subselectall() {
		var cba = document.getElementsByName("cba")[0];
		var cbs = document.getElementsByName("cb");
		var count = cbs.length;

		var selectCount = 0;
		for ( var i = 0; i < count; i++) {
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

	function printForm(twdno) {
		window
				.open(
						"allotted!toPrintAllotted.action?ztw.twdno=" + twdno,
						'newwindow',
						'height=600,width=800,top=60,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	}
</script>
</html>
