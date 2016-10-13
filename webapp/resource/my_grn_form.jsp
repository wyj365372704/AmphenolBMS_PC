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
	<s:iterator value="items" id="rs" status="st">
		<table cellpadding="5px" width="100%" class="tb">
			<tbody>
				<tr>
					<td>
						<table width="100%">
							<tbody>
								<tr>
									<td align="center" width="100%"><span
										style="font-weight: bold;font-size:18px;">安费诺凯杰科技(深圳)有限公司</span>
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
									<td>收货单: <s:property value="grnno" /></td>
									<td>收货单行号: <s:property value="grnln" /></td>
									<td>供应商送货单: <s:property value="shpno" /></td>
								</tr>
								<tr>
									<td>收货日期: <s:property value="grdte" /></td>
									<td>XA 采购订单: <s:property value="ordno" /></td>
									<td>供应商:<s:property value="vndnr" /></td>
								</tr>
								<tr>
									<td>料号: <s:property value="itnbr" /></td>
									<td colspan="2">物料描述: <s:property value="itdsc" /></td>
								</tr>
								<tr>
									<td>默认子库:<s:property value="whsub2" /></td>
									<td colspan="2">默认库位:<s:property value="llocn2" /></td>
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
								<s:if test="#rs.blcf == 1">
									<s:iterator value="#rs.itemList" id="it" status="st">
										<tr>
											<td align="center"><s:property value="#it.lbhno" /></td>
											<td align="center"><s:property value="#it.gbqty" /></td>
											<td align="center"><s:property value="#rs.grwgt1" />G</td>
											<td align="center"><s:property
													value="#it.gbqty*#rs.grwgt1" /> KG</td>
										</tr>
									</s:iterator>
								</s:if>
								<s:else>

									<tr>
										<td align="center"></td>
										<td align="center"><s:property value="#rs.grqty" /></td>
										<td align="center"><s:property value="#rs.grwgt1" /> G</td>
										<td align="center"><s:property
												value="#rs.grqty*#rs.grwgt1" /> KG</td>
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