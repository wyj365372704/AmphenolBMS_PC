<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物料工序流程卡</title>

<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.tb {
	border: solid 1px;
	margin-bottom: 50px;
}

.btabel tr td {
	border: 1px solid;
}
</style>
</head>

<body>

	<s:iterator value="results" var="resultMap">
		<table cellpadding="5px" width="100%" class="tb" style='page-break-after: always;'>
			<tbody>
				<tr>
					<td>
						<table width="100%">
							<tbody>
								<tr>
									<td align="center" width="100%"><span
										style="font-weight: bold;font-size:18px;"><s:property
												value="nmchs" /> </span>
									</td>
								</tr>
								<tr>
									<td align="center" width="100%"><span
										style="font-weight: bold;font-size:18px;">物料工序流程卡</span>
									</td>
									<td align="right" nowrap="nowrap">打印日期: <s:property
											value="printDate" /></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table width="100%" cellpadding="3px">
							<tbody>
								<tr>
									<td>生产订单号: <s:property value="ordno" /></td>
									<td>批量: <s:property value="branch" /></td>
									<td rowspan="3"><img src="${resultMap.qrcodeurl }"
										width="80px" height="80px" /></td>
								</tr>
								<tr>
									<td>产品编号: <s:property value="fitem" /></td>
									<td>产品规格: <s:property value="sdesc" /></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				
				<s:if test="#resultMap.morouts.size >0">
				<tr>
					<td>
						<table width="100%" border="1" cellpadding="3px"
							style="border-collapse: collapse; margin-bottom: 30px;">
							<tr>
								<td align="center" nowrap="nowrap">工序</td>
								<td align="center" nowrap="nowrap">工序说明</td>
								<td align="center" nowrap="nowrap">完成数量</td>
								<td align="center" nowrap="nowrap">機臺號</td>
								<td align="center" nowrap="nowrap">日期</td>
								<td align="center" nowrap="nowrap">操作人员</td>
								<td align="center" nowrap="nowrap">检验判定</td>
							</tr>
							<s:iterator value="#resultMap.morouts" var="morout">
								<tr>
									<td align="center"><s:property value="opseq" /></td>
									<td align="center"><s:property value="desc" escapeHtml="false"/></td>
									<td align="center"><s:property value="uugam2" /></td>
									<td align="center"><s:property value="cdesc" /></td>
									<td align="center"><s:property value="shqty" /></td>
									<td align="center"><s:property value="whsub" /></td>
									<td align="center"><s:property value="whsub" /></td>
								</tr>
							</s:iterator>

						</table></td>
				</tr>
				</s:if>
				<tr>
					<td>
						<table width="100%">
							<tr>
								<td width="100%">备注:<s:property value="cnote" /></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table width="100%">
							<tr>
								<td width="33%">核准:</td>
								<td width="33%">单位主管核准:</td>
								<td width="33%">制表人:</td>
							</tr>
						</table>
					</td>
				</tr>
			<tbody>
		</table>

	</s:iterator>
</body>
<script language=javascript>
	/* window.opener.location.href = window.opener.location.href; */
</script>
</html>