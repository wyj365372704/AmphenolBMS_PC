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
<s:iterator value="items" id="rs" status="st">
	<table cellpadding="5px" width="100%" class="tb">
		<tbody>
			
			<tr>
				<td> 
					<table width="100%" cellpadding="3px">
						<tbody>
							<tr>
								<td>客户: <s:select name="mbcdrep.cda3cd"
						list="#session.houses" listKey="house" listValue="house"
						cssClass="select_s_2" style="width:60px"></s:select></td>
								<td>运输方式: <s:select name="mbcdrep.cda3cd"
						list="#session.houses" listKey="house" listValue="house"
						cssClass="select_s_2" style="width:60px"></s:select></td>
								<td>国际贸易条款: <s:select name="mbcdrep.cda3cd"
						list="#session.houses" listKey="house" listValue="house"
						cssClass="select_s_2" style="width:60px"></s:select></td>
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
								<td align="center" nowrap="nowrap">批次</td>
								<td align="center" nowrap="nowrap">入库数量</td>
								<td align="center" nowrap="nowrap">单重</td>
								<td align="center" nowrap="nowrap">重量</td>
							</tr>
							
						</tbody>
					</table>
				</td>
			</tr>			
		<tbody>
	</table>
</s:iterator>
</body>

</html>