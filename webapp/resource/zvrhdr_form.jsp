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

	<s:iterator value="results" var="resultMap">
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
						<table width="100%" cellpadding="3px">
							<tbody>
								<tr>
									<td>仓库: <s:property value="fitwh" /></td>
									<td>生产订单号: <s:property value="ordno" /></td>
									<td>产品编号: <s:property value="fitem" /></td>
									<td rowspan="3"><img src="${resultMap.qrcodeurl }"
										width="80px" height="80px" /></td>
								</tr>
								<tr>
									<td>开单日期: <s:property value="crdt" /></td>
									<td>产品描述: <s:property value="fdesc" /></td>
									<td>产品规格: <s:property value="sdesc" /></td>
								</tr>
								<tr>
									<td>生产部门: <s:property value="dptno" /></td>
									<td>订单数量: <s:property value="quantity" /> (<s:property value="umstt9" />)</td>
									<td>生产批号: <s:property value="productQuantity" /></td>
								</tr>
								<tr>
									<td>客户代码: <s:property value="c6canb" /></td>
									<td>客户采购订单号: <s:property value="bmcbtx" /></td>
									<td>客户名称: <s:property value="cusnm" /></td>
									<td>客户订单: <s:property value="bmcbtx" /></td>
								</tr>
								<tr>
									<td>预计开工日期: <s:property value="sstdt" /></td>
									<td>预计完工日期: <s:property value="odudt" /></td>
									<td colspan="2">客户订单备注: <s:property value="axhdtx" /></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<s:if test="#resultMap.modatas.size >0">
				<tr>
					<td>
						<table width="100%" border="1" cellpadding="3px"
							style="border-collapse: collapse; margin-bottom: 30px;">
							<tr>
								<td align="center" nowrap="nowrap">材料编号</td>
								<td align="center" nowrap="nowrap">描述 / 规格</td>
								<td align="center" nowrap="nowrap">单位</td>
								<td align="center" nowrap="nowrap">需领用量</td>
								<td align="center" nowrap="nowrap">已领用量</td>
								<td align="center" nowrap="nowrap">子库</td>
							</tr>
							<s:iterator value="#resultMap.modatas" var="modata">
								<tr>
									<td align="center"><s:property value="citem" /></td>
									<td align="center"><s:property value="cdesc" /> / <s:property value="sdesc" /></td>
									<td align="center"><s:property value="unmsr" /></td>
									<td align="center"><s:property value="qtreq" /></td>
									<td align="center"><s:property value="isqty" /></td>
									<td align="center"><s:property value="whsub2" /> <s:property value="dsp1" /></td>
								</tr>
							</s:iterator>

						</table></td>
				</tr>
				</s:if>
				<s:if test="#resultMap.morouts.size >0">
				<tr>
					<td>
						<table width="100%" border="1" cellpadding="3px"
							style="border-collapse: collapse; margin-bottom: 30px;">
							<tr>
								<td align="center" nowrap="nowrap">工序号</td>
								<td align="center" nowrap="nowrap">工序说明</td>
								<td align="center" nowrap="nowrap">实际操作机台 / 产线</td>
								<td align="center" nowrap="nowrap">实际作业人员</td>
								<td align="center" nowrap="nowrap">实际完成数量</td>
								<td align="center" nowrap="nowrap">实际耗用工时(小时)</td>
							</tr>
							<s:iterator value="#resultMap.morouts" var="morout">
								<tr>
									<td align="center"><s:property value="opseq" /></td>
									<td align="center"><s:property value="desc" escapeHtml="false"/></td>
									<td align="center"><s:property value="uugam2" /></td>
									<td align="center"><s:property value="cdesc" /></td>
									<td align="center"><s:property value="shqty" /></td>
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
	window.opener.location.href = window.opener.location.href;
</script>
</html>