<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<style type="text/css">
	.tb{
	    border: solid 1px;
        margin-bottom: 50px;
	}
	.btabel tr td{ 
		border:1px solid;
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
								<td align="center" width="100%">
									<span style="font-weight: bold;font-size:18px;"><s:property value="zbmsctl.nmchs"/></span>
								</td>
							</tr>
							<tr>
								<td align="center" width="100%">
									<span style="font-weight: bold;font-size:18px;">调拨单</span>
								</td>
								<td align="right" nowrap="nowrap">打印日期: <s:property value="printDate"/></td>
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
								<td>调拨单号: <s:property value="ztw.twdno"/></td>
								<td>调拨申请日期: <s:property value="applyDate"/></td>
							</tr>
							<tr>
								<td>调拨申请人: <s:property value="ztw.twus1"/> </td>
								<td>调拨申请部门: <s:property value="ztw.twdp1"/></td>
							</tr>
							<tr>
								<td>备注: <s:property value="ztw.cmmt"/></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="1" cellpadding="3px" style="border-collapse: collapse;">
						<tbody>
							<tr>
								<td align="center" nowrap="nowrap">序号</td>
								<td align="center" nowrap="nowrap">料号 / 描述</td>
								<td align="center" nowrap="nowrap">单位</td>
								<td align="center" nowrap="nowrap">调拨数量</td>
								<td align="center" nowrap="nowrap">调出仓库  / 子库 / 库位</td>
								<td align="center" nowrap="nowrap">调入仓库  / 子库 / 库位</td>
							</tr>
							<s:iterator value="ztw.itemList" id="it">
							<tr>			      		
								<td align="center">
								<fmt:formatNumber value="${it.twdln}" pattern="#0" />
								</td>
								<td align="center"><s:property value="itnbr"/> / <s:property value="itdsc"/></td>
								<td align="center"><s:property value="unmsr"/></td>
								<td align="center"><s:property value="plnqt"/></td>
								<td align="center"><s:property value="frwhs"/> / <s:property value="frsub"/> / <s:property value="frloc"/></td>
								<td align="center"><s:property value="towhs"/> / <s:property value="tosub"/> / <s:property value="toloc"/></td>
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
							<td>仓库主管:</td>
							<td>仓库(转出仓):</td>
							<td>仓库(转入仓):</td>
						</tr>
					</table>
				</td>
			</tr>
		<tbody>
	</table>
	
</body>

</html>