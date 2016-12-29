<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>打印领料单</title>
<link href="<%=request.getContextPath() %>/css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script src="<%=request.getContextPath() %>/js/alert/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/alert/jquery.alerts.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/common.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/js/alert/alerts.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">

</script>
<body>
	<s:form action="momast!toPrintMomast.action" method="post">
		<div class="public_div">
			<input type="hidden" name="grnno" value="<s:property value='grnno'/>" />
			<div class="public_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="public_table">
					<tbody>
						<tr>
							<td class="td_w_s text_r">打印 MO组件明细：</td>
							<td><input type="checkbox" name="input1" checked="checked"
								value="1" />
							</td>
						</tr>
						<tr>
							<td class="td_w_s text_r">打印 MO工艺路线：</td>
							<td><input type="checkbox" name="input2" checked="checked"
								value="1" />
							</td>
						</tr>
						<tr>
							<td class="td_w_s text_r">备注：</td>
							<td><input type="text" name="cnote"  value=""/>
							</td>
						</tr>
						<tr>

							<td align="center" colspan="2"><s:submit id="queryId"
									value="打印" onclick="return dosubmit()"></s:submit>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="page" style="display: none;">
					<page:paginator formName="queryform" nameInRequest="paginator" />
				</div>
			</div>
		</div>
	</s:form>
</body>
<script type="text/javascript">
		function dosubmit(){
			window.resizeTo(900, 750);
		}
	</script>
</html>
