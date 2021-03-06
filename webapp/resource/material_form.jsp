<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/global.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>物料标签</title>
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
	<table cellpadding="5px" width="400" height="250" class="tb" align="center"
		style='page-break-after: always;border-collapse: collapse;'>
		<tbody>
			<tr>
				<td>
					<table width="100%">
						<tbody>
							<tr>
								<td align="center" width="100%"><span
									style="font-weight: bold;font-size:18px;">${nmchs}</span>
								</td>
							</tr>
							<tr>
								<td align="center" width="100%"><span
									style="font-weight: bold;font-size:18px;">物料标签</span>
								</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" height="100%" cellpadding="3px" border="0">
						<tbody>
							<tr>
								<td>物料:${fordrji}</td>
								<td rowspan="3" align="left" valign="middle"><img
									src="${qrcodeurl}" width="80px" />
								</td>
							</tr>
							<tr>
								<td>描述:<s:property value="fds40ji" />
								</td>
							</tr>
							<tr>
								<td>批号:${fblcft9}</td>
							</tr>
							<tr>
								<td>数量:${fcout }</td>
								<td>单重:${fweight }${fweight_unit}</td>
							</tr>
							<tr>
								<td>净重:${fcout*fweight }${fweight_unit}</td>
								<td>毛重:${totalweight }g</td>
							</tr>
							<tr>
								<td>日期:${fdate }</td>
								<td>厂商:${fproducter}</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>