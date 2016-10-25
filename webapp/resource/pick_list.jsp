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
	<s:form action="picklist!toPickList.action" method="post"
		name="queryform">

		<div class="path">您现在的位置： 首页 &gt; 生产 &gt; 打印领料单</div>

		<div class="search">
			<h2>
				<span class="fl">领料单查询</span> <span class="fr"> <s:submit
						id="queryId" value="" cssClass="search_button"
						onclick="return dosubmit()"></s:submit> <s:reset value=""
						cssClass="purge_button"></s:reset>
						<input type="button"
					cssClass="search_button" onclick="myPrint()" value="打印">
				
				</span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>

			<ul>
				<li><div class="w_s">领料单号：</div> <s:textarea name="ipdno"
						cssClass="input_w" style="height:30px"></s:textarea></li>

				<li><div class="w_s">工单号：</div> <s:textarea
						name="ordno" cssClass="input_w" style="height:30px"></s:textarea></li>

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
				<s:iterator value="results" id="results" status="st">
  				 <s:if test="#st.Even">
		      		<tr class="td_bgcolor">
		      	</s:if>
		      	<s:else>
		      		<tr class="td_bgcolor2">
		      	</s:else>
	  				<td>	<input type="checkbox" name="cb" value="<s:property value="ipdno"/>" onclick="subselectall()" /></td>
	  				<td><s:property value="ipdno"/></td>
	  				<td><s:property value="ordno"/></td>
	  				<td>
						<s:if test="iptyp==1">
		  					正常
		  				</s:if>
		  				<s:if test="iptyp==2">
		  					超领
		  				</s:if>
		  				<s:if test="iptyp==3">
		  					退领
		  				</s:if>
					</td>
	  				<td><s:property value="ipus1"/></td>
	  				<td><s:property value="ipdp1"/></td>
	  				<td><s:property value="sipdt1"/></td>
	  				<td><s:property value="cmmt"/></td>
	  				<td>
						<s:if test="lprt==1">
		  					是
		  				</s:if>
		  				<s:else>
		  					否
		  				</s:else>
					</td>
	  				<td>
						<s:if test="arpst==1">
		  					是
		  				</s:if>
		  				<s:else>
		  					否
		  				</s:else>
					</td>
	  				<td>
	  				<s:if test="ostat==05">
	  					创建中
	  				</s:if>
	  				<s:if test="ostat==10">
	  					已创建
	  				</s:if>
	  				<s:if test="ostat==50">
	  					已完成
	  				</s:if>
	  				<s:if test="ostat==60">
	  					已关闭
	  				</s:if>
	  				</td>
	  				<td><s:property value="aprus"/></td>
	  				<td><s:property value="saprdt"/></td>
					
	  				<td><s:property value="saprtm"/></td>
  			   </tr>
  			</s:iterator>
					
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
				gno.push($.trim(p.value));
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
