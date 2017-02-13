<%@ page contentType="text/html;charset=UTF-8" %>
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
	<table cellpadding="5px" width="400" class="tb">
		<tbody>
			<tr>
				<td>
					<table width="100%">
						<tbody>
							<tr>
								<td align="center" width="100%">
									<span style="font-weight: bold;font-size:18px;">${nmchs}</span>
								</td>
							</tr>
							<tr>
								<td align="center" width="100%">
									<span style="font-weight: bold;font-size:18px;">物料识别卡</span>
								</td>
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
								<td>生产订单: <s:property value="ordno"/></td>
								<td>物料: <s:property value="fitem"/></td>
								<td rowspan="3"><img width="80px" height="80px" src="${qrcodeurl}"/></td>
							</tr>
							<tr>
								<td colspan="2">说明: <s:property value="fdesc"/></td>
							</tr>
							<tr>
								<td>数量: <s:property value="moqty"/> <s:property value="unmsr"/></td>
								<td>批号:  <s:property value="batch"/></td>
							</tr>
							<tr>
								<td>单重: <s:property value="weght"/> <s:property value="b2cqcd"/></td>
								<td>净重: <s:property value="netWeight"/> KG</td>
							</tr>
							<tr>
								<td>生产线: <s:property value="prounit"/></td>
								<td>日期: <s:property value="mydate"/></td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
		<tbody>
	</table>
</body>

</html>