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
	<!-- 领料单 -->
	<table cellpadding="5px" width="100%" class="tb">
		<tbody>
			<tr>
				<td>
					<table width="100%">
						<tbody>
							<tr>
								<td align="center" width="100%">
									<span style="font-weight: bold;font-size:18px;">安费诺凯杰科技(深圳)有限公司</span>
								</td>
							</tr>
							<tr>
								<td align="center" width="100%">
									<span style="font-weight: bold;font-size:18px;">生产领料单</span>
								</td>
								<td align="right" nowrap="nowrap">打印日期: 2016/08/31  第 1 页</td>
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
								<td>领料单号: IP1608200001</td>
								<td>生产订单: M00250</td>
								<td rowspan="3"><p>****
									[二维码信息]
									****</p></td>
							</tr>
							<tr>
								<td>生产部门: CNC</td>
								<td>生产数量: 25,000.00</td>
							</tr>
							<tr>
								<td>产品编号: 903-903J-51S</td>
								<td>产品描述: DESC 903-903J-51S</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="1" cellpadding="3px" style="border-collapse: collapse; margin-bottom: 30px;">
						<tbody>
							<tr>
								<td align="center" nowrap="nowrap">序号</td>
								<td align="center" nowrap="nowrap">材料编号</td>
								<td align="center" nowrap="nowrap">位置</td>
								<td align="center" nowrap="nowrap">材料描述</td>
								<td align="center" nowrap="nowrap">申请数量</td>
								<td align="center" nowrap="nowrap">子库</td>
								<td align="center" nowrap="nowrap">实际储位 / 批次 / 数量</td>
							</tr>
							<tr>			      		
								<td align="center">1</td>
								<td align="center">AMA</td>
								<td align="center">E</td>
								<td align="center">T000102</td>
								<td align="center">200</td>
								<td align="center">P</td>
								<td align="center">P02004 / P20160726 / 1200</td>
							</tr>
							<tr>			      		
								<td align="center">2</td>
								<td align="center">RHY</td>
								<td align="center">E</td>
								<td align="center">THT30102</td>
								<td align="center">500</td>
								<td align="center">P</td>
								<td align="center">P04001 / P20160728 / 2000</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
		<tbody>
	</table>
	
	<!-- 分装标签 -->
	<table cellpadding="5px" width="400" class="tb">
		<tbody>
			<tr>
				<td>
					<table width="100%" cellpadding="3px" style="border-collapse: collapse;">
						<tbody>
							<tr>			      		
								<td align="center">54-63893496389298  (E)</td>
							</tr>
							<tr>
								<td align="center">6754565- GJFD-454554</td>
							</tr>
							<tr>
								<td align="center">999.00</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
		</tbody>
	</table>
	<table cellpadding="5px" width="400" class="tb">
		<tbody>
			<tr>
				<td>
					<table width="100%" cellpadding="3px" style="border-collapse: collapse;">
						<tbody>
							<tr>			      		
								<td align="center">M002340  / CNC  (E)</td>
							</tr>
							<tr>
								<td align="center">34-11403/BR (34-11403 Description)</td>
							</tr>
							<tr>
								<td align="center">919.00</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
		</tbody>
	</table>
	
</body>

</html>