<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Amphenol</title>
<OBJECT ID="jatoolsPrinter"
	CLASSID="CLSID:B43D3361-D075-4BE2-87FE-057188254255"
	codebase="jatoolsPrinter.cab#version=8,6,0,0"  height="0" width="0"></OBJECT>
<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
<style type="text/css" lang="">
.tb {
	border: solid 1px;
	margin-bottom: 50px;
}

.btabel tr td {
	border: 1px solid;
}
</style>
<script type="text/javascript">
window.resizeTo(800, 800);
</script>
</head>
<body>
		<!-- 领料单 -->
		<s:iterator value="results" var="resultMap">
			 <table cellpadding='5px'width='100%' class='tb' style='page-break-after: always;'>
				<tbody>
					<tr>
						<td>
							<table width="100%">
								<tbody>
									<tr>
										<td align="center" width="100%"><span
											style="font-weight: bold;font-size:18px;"><s:property
													value="nmchs" />
										</span></td>
									</tr>
									<tr>
										<td align="center" width="100%"><span
											style="font-weight: bold;font-size:18px;">生产领料单( <s:if
													test="iptyp==1">
		  					正常
		  				</s:if> <s:if test="iptyp==2">
		  					超领
		  				</s:if> <s:if test="iptyp==3">
		  					退领
		  				</s:if> )</span></td>
										<td align="right" nowrap="nowrap">打印日期: <s:property
												value="printDate" />
										</td>
									</tr>
								</tbody>
							</table></td>
					</tr>
					<tr>
						<td>
							<table width="100%" cellpadding="3px">
								<tbody>
									<tr>
										<td>领料单号: <s:property value="ipdno" />
										</td>
										<td>生产订单: <s:property value="ordno" />
										</td>
										<td rowspan="3"><img src="${resultMap.qrcodeurl }"
											width="80px" height="80px" />
										</td>
									</tr>
									<tr>
										<td>生产部门: <s:property value="dept" />
										</td>
										<td>生产数量: <s:property value="productQuantity" />
										</td>
									</tr>
									<tr>
										<td>产品编号: <s:property value="fitem" />
										</td>
										<td>产品描述: <s:property value="fdesc" />
										</td>
									</tr>
								</tbody>
							</table></td>
					</tr>
					<tr>
						<td>
							<table width="100%" border="1" cellpadding="3px"
								style="border-collapse: collapse; margin-bottom: 30px;">
								<tr>
									<td align="center" nowrap="nowrap">序号</td>
									<td align="center" nowrap="nowrap">材料编号</td>
									<td align="center" nowrap="nowrap">位置</td>
									<td align="center" nowrap="nowrap">材料描述</td>
									<td align="center" nowrap="nowrap">申请数量</td>
									<td align="center" nowrap="nowrap">子库</td>
									<td align="center" nowrap="nowrap">实际储位 / 批次 / 数量</td>
								</tr>
								<s:iterator value="items" var="item">
									<tr>
										<td align="center"><s:property value="seqnm" />
										</td>
										<td align="center"><s:property value="citem" />
										</td>
										<td align="center"><s:property value="uugam2" />
										</td>
										<td align="center"><s:property value="cdesc" />
										</td>
										<td align="center"><s:property value="shqty" />
										</td>
										<td align="center"><s:property value="whsub" />
										</td>
										<td align="center"><s:property value="llocn" /> / <s:property
												value="lbhno" /> / <s:property value="lqnty" />
										</td>
									</tr>
								</s:iterator>

							</table>
						</td>
					</tr>
				<tbody>
			</table>
		</s:iterator>
</body>
<script language="javascript">
	window.onload = function() {
		var myDoc = {
			documents : document,
			/*
			 要打印的div 对象在本文档中，控件将从本文档中的 id 为 'page1' 的div对象，
			 作为首页打印id 为'page2'的作为第二页打印            */
			copyrights : '杰创软件拥有版权  www.jatools.com' // 版权声明,必须   
		};
		document.getElementById("jatoolsPrinter").print(myDoc, false); // 直接打印，不弹出打印机设置对话框 
		window.close();
	};
	/* window.opener.location.href = window.opener.location.href; */
</script>
</html>