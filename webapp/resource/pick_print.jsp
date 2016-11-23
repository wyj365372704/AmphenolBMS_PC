<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>打印领料单</title>
<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
function radioChanged(){
	if(document.getElementById("printA").checked){
		document.getElementById("printA_type").disabled =  false;
	}else{
	document.getElementById("printA_type").disabled = true;
	}
}
</script>
<body>
	<s:form action="picklist!toPrintPick.action" method="post">
		<div class="public_div">
			<input type="hidden" name="grnno" value="<s:property value='grnno'/>" />
			<div class="public_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="public_table">
					<tbody>
						<tr>
							<td class="td_w_s text_r">打印类型：</td>
							<td><input id="printA" type="radio" name="input1" value="0"
								onclick="radioChanged();" checked="checked" />打印领料单 <input
								id="printB" type="radio" name="input1" value="1"
								onclick="radioChanged();" />打印分装标签</td>
						</tr>
						<tr>
							<td class="td_w_s text_r">分仓打印：</td>
							<td><input id="printA_type" type="checkbox" name="input2"
								value="1" />
							</td>
						</tr>

						<tr>

							<td align="center"  ><s:submit id="queryId"
									value="打印" onclick="return dosubmit()"></s:submit>
							</td>
							<td align="center"  ><input id="printid" type="button"  class="gray_button" 
									value="批量打印" onclick="mulprint()" />
							</td>
						</tr>
					</tbody>
				</table>
				<div class="page" style="display: none;">
					<page:paginator formName="queryform" nameInRequest="paginator" />
				</div>
			</div>
		</div>
	</s:form>
</body>
<script type="text/javascript">
		function dosubmit(){
			window.resizeTo(900, 750);
		}
		function mulprint(){
			var temp = document.getElementsByName("grnno")[0].value;
			var input2 = document.getElementsByName("input2")[0].value;
			var input1 = document.getElementsByName("input1")[0].value;
			var grnno = eval("(" + temp + ")");
			//alert(grnno.grnnos);
			for(var i=0;i<grnno.grnnos.length;i++){
				var gno = new Array();
				gno.push(grnno.grnnos[i]);
				var grnnos = JSON.stringify({
					grnnos : gno
				});
				window.open("picklist!toPrintPick.action?grnno="+grnnos+"&input2="+input2+"&input1="+input1);
			}
			
		}
	</script>
</html>
