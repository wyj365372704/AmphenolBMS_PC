<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>到货单</title>

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
	<s:iterator value="results" id="resultMap" status="st">
		<table cellpadding="5px" width="100%" class="tb" style="page-break-after: always;">
			<tbody>
				<tr>
					<td>
						<table width="100%">
							<tbody>
								<tr>
									<td align="center" width="100%"><span
										style="font-weight: bold;font-size:18px;"><s:property value="nmchs"/></span>
									</td>
								</tr>
								<tr>
									<td align="center" width="100%"><span
										style="font-weight: bold;font-size:18px;">采购入库单</span></td>
								</tr>
								<tr>
									<td align="right" nowrap="nowrap">打印日期: <s:property
											value="mydate" />&nbsp;&nbsp;&nbsp;&nbsp;第<s:property
											value="#st.index+1" />页</td>
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
									<td>到货单号: <s:property value="#resultMap.zgrnitmvo.grnno" /></td>
									<td>到货单行号: <fmt:formatNumber value="${resultMap.zgrnitmvo.grnln}" pattern="#0" /></td>
									<td>供应商送货单: <s:property value="#resultMap.zgrnitmvo.shpno" /></td>
								</tr>
								<tr>
									<td>收货日期: <s:property value="#resultMap.grdte" /></td>
									<td>XA 采购订单: <s:property value="#resultMap.zgrnitmvo.ordno" /></td>
									<td>供应商:<s:property value="#resultMap.zgrnitmvo.vndnr" /></td>
								</tr>
								<tr>
									<td>料号: <s:property value="#resultMap.zgrnitmvo.itnbr" /></td>
									<td colspan="2">物料描述: <s:property value="#resultMap.zgrnitmvo.itdsc" /></td>
								</tr>
								<tr>
									<td>默认子库:<s:property value="#resultMap.whsub2" /></td>
									<td colspan="2">默认库位:<s:property value="#resultMap.llocn2" /></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table width="100%" border="1" cellpadding="3px"
							style="border-collapse: collapse;">
							<tbody>
								<tr>
									<td align="center" nowrap="nowrap">批次</td>
									<td align="center" nowrap="nowrap">入库数量</td>
									<td align="center" nowrap="nowrap">单重</td>
									<td align="center" nowrap="nowrap">重量</td>
								</tr>
								<s:if test="#resultMap.zgrnitmvo.blcf == 1">
									<s:iterator value="#resultMap.zgrnitmvo.itemList" id="it" status="st">
										<tr>
											<td align="center"><s:property value="#it.lbhno" /></td>
											<td align="center"><fmt:formatNumber value="${it.gbqty}" pattern="#0.0" /></td>
											<td align="center"><fmt:formatNumber value="${resultMap.zgrnitmvo.grwgt1}" pattern="#0.0000" />
											<s:if test="#resultMap.zgrnitmvo.grwum1 != KG">&nbsp;G</s:if><s:else>&nbsp;KG</s:else>
											</td>
											<td align="center">
											<fmt:formatNumber value="${it.gbqty*resultMap.zgrnitmvo.grwgt1}" pattern="#0.0000" />
											<s:if test="#resultMap.zgrnitmvo.grwum1 != KG">
											&nbsp;G
											</s:if>
											<s:else>
											&nbsp;KG
											</s:else>
											</td>
										</tr>
									</s:iterator>
								</s:if>
								<s:else>

									<tr>
										<td align="center"></td>
										<td align="center"><fmt:formatNumber value="${resultMap.zgrnitmvo.grqty}" pattern="#0.0" /></td>
										<td align="center"><fmt:formatNumber value="${resultMap.zgrnitmvo.grwgt1}" pattern="#0.0000" />
										<s:if test="#resultMap.zgrnitmvo.grwum1 != KG">&nbsp;G</s:if><s:else>&nbsp;KG</s:else>
										</td>
										<td align="center">
										<fmt:formatNumber value="${resultMap.zgrnitmvo.grqty*resultMap.zgrnitmvo.grwgt1}" pattern="#0.0000" />
										<s:if test="#resultMap.zgrnitmvo.grwum1 != KG">
											&nbsp;G
											</s:if>
											<s:else>
											&nbsp;KG
											</s:else>
									</tr>

								</s:else>

							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table width="100%">
							<tr>
								<td>接收:</td>
								<td>品管:</td>
								<td>资材:</td>
							</tr>
						</table>
					</td>
				</tr>
			<tbody>
		</table>
	</s:iterator>
</body>

</html>