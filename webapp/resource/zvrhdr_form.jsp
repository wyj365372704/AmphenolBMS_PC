<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Amphenol</title>

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

	<s:iterator value="results" var="zvrhdrMap">
		<table cellpadding="5px" width="100%" class="tb">
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
										style="font-weight: bold;font-size:18px;">生产订单</span>
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
						<table width="100%" cellpadding="3px" border="0">
							<tbody>
								<tr >
									<td colspan="2">退货单号: <s:property value="vrdno" /></td>
									<td rowspan="2"><img src="${zvrhdrMap.qrcodeurl }"
										width="80px" height="80px" /></td>
								</tr>
								<tr>
									<td>仓库: <s:property value="house" /></td>
									<td>供应商: <s:property value="vndnr" /></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table width="100%" border="1" cellpadding="3px"
							style="border-collapse: collapse; margin-bottom: 30px;">
							<tr>
								<td align="center" nowrap="nowrap">采购订单-项次</td>
								<td align="center" nowrap="nowrap">料号 / 描述</td>
								<td align="center" nowrap="nowrap">退货数量</td>
								<td align="center" nowrap="nowrap">库存单位</td>
								<td align="center" nowrap="nowrap">计划退货库位</td>
							</tr>
							<s:iterator value="#zvrhdrMap.zvritmList">
								<tr>
									<td align="center"><s:property value="ordno_poisq" /></td>
									<td align="center"><s:property value="itnbr"/> / <s:property value="ldesc"/></td>
									<td align="center"><s:property value="plnvq" /></td>
									<td align="center"><s:property value="stkum" /></td>
									<td align="center"><s:property value="ploc" /></td>
								</tr>
							</s:iterator>

						</table></td>
				</tr>
				<tr>
					<td>
						<table width="100%">
							<tr>
								<td width="50%" align="center">品管:</td>
								<td width="50%" align="center">资材:</td>
							</tr>
						</table>
					</td>
				</tr>
			<tbody>
		</table>

	</s:iterator>
</body>
<script language=javascript>
	window.opener.location.href = window.opener.location.href;
</script>
</html>