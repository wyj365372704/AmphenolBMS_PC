<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
String ordno = request.getParameter("ordno");
String house = request.getParameter("house");

 %>
	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>添加领料单</title>
		<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
		<link href="../css/global.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/validator/easy_validator.pack.js"></script>
		<script type="text/javascript" src="../js/validator/jquery.bgiframe.min.js"></script>
		<link  href="../css/validate.css" rel="stylesheet" type="text/css" />
		<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
		<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
		<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
		
		<script type="text/javascript">
		var data = "${data}";
		if(data=="success"){
			alert("领料单添加成功");
			
			window.close();
		}else if(data=="fail"){
			alert("领料单添加失败,原因：领料单添加过程中程序异常");
			window.close();
		}else if(data=="other"){
			alert("领料单添加失败,原因：该工单物料已领完");
			window.close();
		}
		
	</script>
	</head>

	<body>
	<s:form action="momast!addZiphdr.action" method="post">
		<div class="public_div">
			
			<div class="public_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="public_table">
					
					<tr>
						<td class="td_w_s text_r">工单号：</td>
						<td>
							<input type="text" name="ordno" class="input_s_1"
								value="<%=ordno %>" readonly="true" />
								<input type="hidden" name="house" value="<%=house %>">
						</td>
						<td>
							<select name="iptyp" >
								<option value="1" selected >正常</option>
								<option value="2">超领</option>
								<option value="3" >退料</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="td_w_s text_r">领料原因：</td>						
						<td>
							<select name="bmsrsn" >
							</select>
						</td>
					</tr>
					<tr id="notetr" style="display:none">
						<td class="td_w_s text_r">备注栏：</td>
						<td>
							<input type="text" name="cmmt" class="input_s_1"/>
							
						</td>
					</tr>
					
				</table>
			</div>
		</div>
		
		<div class="button_div">
		<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="public_table">
					
				<tr>
				<td><span id="detail" style="display:none"> 不产生物料明细<input type="checkbox" name="isdetail" /></span></td>
				<td><s:submit value="" cssClass="add_button"></s:submit></td>
				</tr>
		</table>
		  
		</div>
	</s:form>
	</body>
	<script type="text/javascript">
		window.onload=function(){
			$.ajax( {  
			       url:'resource/ziphdr!getBmsReason.action',// 跳转到 action  
			       data:{  
			                iptyp : '1'
			       },  
			      type:'post',  
			      cache:false,  
			      success:function(data) {
			      		 document.getElementsByName("bmsrsn")[0].innerHTML=data;
			      	
			       },  
			       error : function() {  
			              
			       }  
			  });
		}
		//window.onload=function(){
			 document.getElementsByName("iptyp")[0].onclick=function(){	         	
	         	var val = document.getElementsByName("iptyp")[0].value;
	         	//alert(val);    
	         	if(val=='3' || val=='2'){//alert(val);  
	         		document.getElementById("detail").style.display="";
	         		document.getElementById("notetr").style.display="";
	         		
	         	}else{
	         		document.getElementById("detail").style.display="none";
	         		document.getElementById("notetr").style.display="none";
	         	}
	         	$.ajax( {  
			       url:'resource/ziphdr!getBmsReason.action',// 跳转到 action  
			       data:{  
			                iptyp : val
			       },  
			      type:'post',  
			      cache:false,  
			      success:function(data) {
			      		 document.getElementsByName("bmsrsn")[0].innerHTML=data;
			      	
			        
			       },  
			       error : function() {  
			              
			       }  
			  });
		     }
		//}
	</script>
</html>
