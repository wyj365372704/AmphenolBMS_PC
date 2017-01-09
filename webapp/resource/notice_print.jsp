<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	
		<table cellpadding="5px" width="100%" class="tb">
			<tbody>
				<tr>
					<td>
						<table width="100%">
							<tbody>
								<tr>
									<td align="center" width="100%"><span
										style="font-weight: bold;font-size:18px;"><s:property value="companyn"/></span>
									</td>
								</tr>
								<tr>
									<td align="center" width="100%"><span
										style="font-weight: bold;font-size:18px;">销售出货通知单</span></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table width="100%" cellpadding="3px">
							<tbody>
								<tr >
									<td valign="bottom">公司: <s:property value="zplhdr.plant" /></td>
									<td valign="bottom" colspan="2">出货通知单号:<img width="80px" height="80px" src="<s:property value="qrcodeurl" />" />   </td>
									<td valign="bottom">出货日期: <s:property value="startDate" /></td>
								</tr>
								<tr>
									<td>仓库: <s:property value="zplhdr.house" /></td>
									<td>发票号: <s:property value="zplhdr.invno" /></td>
									<td>运输方式:<s:property value="zplhdr.scac" /></td>
									<td>运输条款:<s:property value="incots" /></td>
								</tr>
								<tr>
									<td colspan="2">客户代码:<fmt:formatNumber value="${zplhdr.cusno}" pattern="#0" /></td>
									<td colspan="2">客户名称: <s:property value="zplhdr.cusnm" /></td>
								</tr>
								<tr>
									<td colspan="4">备注:<s:property value="cmmt" /></td>
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
									<td align="center" nowrap="nowrap">序号</td>
									<td align="center" nowrap="nowrap">客户订单号</td>
									<td align="center" nowrap="nowrap">行号</td>
									<td align="center" nowrap="nowrap">客户采购订单号</td>
									<td align="center" nowrap="nowrap">客户料号 / 我方料号描述</td>
									<td align="center" nowrap="nowrap">未交数量</td>
									<td align="center" nowrap="nowrap">出货数量</td>
									<td align="center" nowrap="nowrap">每箱数量</td>
									<td align="center" nowrap="nowrap">净重/毛重 (KG)</td>
									<td align="center" nowrap="nowrap">箱号/箱数</td>
									<td align="center" nowrap="nowrap">计划出货子库/库位</td>
								</tr>
									<s:iterator value="mresults" id="it" status="st">
										<tr>
											<td align="center"><s:property value="#it.idx" /></td>
											<td align="center"><s:property value="#it.cusodrno" /></td>
											<td align="center"><fmt:formatNumber value="${it.cusln}" pattern="#0" /></td>
											<td align="center"><s:property value="#it.ponum" /></td>
											<td align="center"></td>
											<td align="center"><s:property value="#it.plqtyno" /></td>
											<td align="center"><s:property value="#it.plqty" /></td>
											<td align="center"><s:property value="#it.b2z95t" /></td>
											<td align="center"><s:property value="#it.jzsl" /></td>
											<td align="center"><s:property value="#it.xhxs" /></td>
											<td align="center"><s:property value="#it.plsub" />/<s:property value="#it.plloc" /></td>
										</tr>
									</s:iterator>								

							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table width="100%">
							<tr>
								<td>合计：<s:property value="sqty" /></td>
								<td> <s:property value="fmark1" /></td>
								<td>PART&nbsp;NUMBER</td>
							</tr>
							<tr>
								<td>合计：<s:property value="sjz" /></td>
								<td> <s:property value="fmark2" /></td>
								<td>QUANTITY&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PCS</td>
							</tr>
							<tr>
								<td>合计：<s:property value="smz" /></td>
								<td> <s:property value="fmark3" /></td>
								<td>NW&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;KGS</td>
							</tr>
							<tr>
								<td>合计：<s:property value="sxs" /></td>
								<td> <s:property value="fmark4" /></td>
								<td>GW &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;KGS</td>
							</tr>
							<tr>
								<td> </td>
								<td> <s:property value="fmark5" /></td>
								<td>C/NO</td>
							</tr>
						</table>
					</td>
				</tr>
			<tbody>
		</table>
</body>

</html>