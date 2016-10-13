<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
String ordno = request.getParameter("ordno");
String house = request.getParameter("house");
String ipdno = request.getParameter("ipdno");
String iptyp = request.getParameter("iptyp");
 %>
	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>添加领料单明细</title>
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.4.2.min.js"></script>
		<link href="<%=request.getContextPath() %>/css/global.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/validator/easy_validator.pack.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/validator/jquery.bgiframe.min.js"></script>
		<link  href="<%=request.getContextPath() %>/css/validate.css" rel="stylesheet" type="text/css" />
		<script src="<%=request.getContextPath() %>/js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
		<script src="<%=request.getContextPath() %>/js/alert/jquery.alerts.js" type="text/javascript"></script>
		<link href="<%=request.getContextPath() %>/js/alert/alerts.css" rel="stylesheet" type="text/css" />
		
		<script type="text/javascript">
		var data = "${data}";
		var ipdno="<%=ipdno %>";
		if(data=="success"){
			//window.parent.opener.document.getElementsByName("queryform")[0].submit();
		  	alert("物料添加成功");
			window.close();
		}else if(data=="fail"){
			alert("领料单添加失败,原因：${reason}");
			window.close();
		}else if(data=="other"){
			alert("领料单添加失败,原因：${reason}");
			window.close();
		}
		function selectI(){
			var temp=document.getElementsByName("mresults.citem")[0].value;
			if(temp!=''){
				var num = new Number(temp);
				document.getElementsByName("seqnm")[0].value= (num.toFixed(0));
			}else{
				document.getElementsByName("seqnm")[0].value= '';
			}
			
		}
		function checks(){
			var seqnm=document.getElementsByName("seqnm")[0].value;
			if(seqnm==''){
				alert("请选择物料！");
				return false;
			}else{
				return true;
			}
		}
	</script>
	</head>

	<body>
	<s:form action="ziphdr!addZipdtl.action" method="post" onsubmit="return checks();">
		<div class="public_div">
			
			<div class="public_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="public_table">
					<tr>
						<td class="td_w_s text_r">领料单号：</td>
						<td>
							<input type="text" name="ipdno" class="input_s_1"
								value="<%=ipdno %>" readonly="true" />
								<input type="hidden" name="house" value="<%=house %>">
								<input type="hidden" name="iptyp" value="<%=iptyp %>">
						</td>
						
					</tr>
					<tr>
						<td class="td_w_s text_r">工单号：</td>
						<td>
							<input type="text" name="ordno" class="input_s_1"
								value="<%=ordno %>" readonly="true" />
						</td>
						
					</tr>
					<tr>
						<td class="td_w_s text_r">物料：</td>
						<td>
							<s:select name="mresults.citem" list="mresults" listKey="seqnm" listValue="citem"  headerKey="" headerValue=""  cssClass="select_s_2" style="width:60px" onclick="selectI();"></s:select>
			
						</td>
						
					</tr>
					<tr>
						<td class="td_w_s text_r">行号：</td>
						<td>
							<input type="text" name="seqnm" class="input_s_1"  readonly="true" />
						</td>
						
					</tr>
					<tr>
						<td></td>
						<td>
						<s:submit value="" cssClass="save_button"></s:submit>
						</td>
					</tr>
				</table>
			</div>
		</div>
		
	</s:form>
	</body>
	<script type="text/javascript">
		
	</script>
</html>
