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
<script type="text/javascript">
	function getAddByCus(){
		var cusno=document.getElementsByName("zplhdr.cusno")[0].value;
		if(cusno==""){
			//alert("");
			return;
		}
		$.ajax( {  
		       url:'sales!getAddByCus.action',// 跳转到 action  
		       data:{  
		                cusno : cusno
		       },  
		      type:'post',  
		      cache:false,  
		      success:function(data) {// alert(data); 
		      	var json = $.parseJSON(data); 
		      	if(json.result=='success'){
		      		//   
		      		document.getElementsByName("zplhdr.stnam")[0].value=json.stnam;
		      		document.getElementsByName("zplhdr.stadd1")[0].value=json.stadd1;
		      		document.getElementsByName("zplhdr.stadd2")[0].value=json.stadd2;
		      		document.getElementsByName("zplhdr.stcity")[0].value=json.stcity;
		      		document.getElementsByName("zplhdr.stctr")[0].value=json.stctr;
		      		document.getElementsByName("zplhdr.stzip")[0].value=json.stzip;
		      		
		      		document.getElementsByName("zplhdr.scnam")[0].value=json.scnam;
		      		document.getElementsByName("zplhdr.scadd1")[0].value=json.scadd1;
		      		document.getElementsByName("zplhdr.scadd2")[0].value=json.scadd2;
		      		document.getElementsByName("zplhdr.sccity")[0].value=json.sccity;
		      		document.getElementsByName("zplhdr.scctr")[0].value=json.scctr;
		      		document.getElementsByName("zplhdr.sczip")[0].value=json.sczip;
		      		 //alert("批量创建领料单成功");
		      	}else if(json.result=='fail'){
		      		 //alert("批量创建领料单失败");
		      	}else {
		      		 //alert("删除物料失败！"); 
		      		// alert(data);
		      	}
		        
		        
		       },  
		       error : function() {  
		            // view("异常！");  
		            alert("删除物料失败！");  
		       }  
		  });
	}
	function searchDetail(){
		
	}
</script>
<body>
	<table cellpadding="5px" width="100%" class="tb">
		<tbody>
			
			<tr>
				<td> 
					<table width="100%" cellpadding="3px" border="1px" style="border-collapse: collapse;">
						<tbody>
							<tr>
								<td colspan="2">出货日期: <s:textfield  name="startDate" cssClass="time_input" onclick="WdatePicker()" autocomplete="on"/></td>
									<td>仓库: <s:select name="zplhdr.house"
						list="#session.houses" listKey="house" listValue="house"
						cssClass="select_s_2" style="width:60px"></s:select></td>
									</tr>
							<tr>
								<td>客户: <s:select name="zplhdr.cusno"
						list="%{customers}" listKey="cusno" listValue="cusnm"
						cssClass="select_s_2" style="width:60%" onchange="getAddByCus();"></s:select></td>
								<td>运输方式: <s:select name="zplhdr.scaac"
						list="%{carriers}" listKey="atf1cd" listValue="atghtx"
						cssClass="select_s_2" style="width:60%"></s:select></td>
								<td>国际贸易条款: <s:select name="zplhdr.incot"
						list="%{salestts}" listKey="c8bhst" listValue="c8hytx"
						cssClass="select_s_2" style="width:60%"></s:select></td>
						
							</tr>
							<tr>
								<td colspan="3"><span style="color:red">运达地</span>: <s:textfield name="zplhdr.stnam" cssClass="input_s_1"/></td>
							</tr>
							<tr>
								<td colspan="2">地址1: <s:textfield name="zplhdr.stadd1" cssClass="input_s_1"/></td>
								<td>地址2: <s:textfield name="zplhdr.stadd2" cssClass="input_w"/></td>
							</tr>
							<tr>
								<td>城市: <s:textfield name="zplhdr.stcity" cssClass="input_w"/></td>
								<td>国家: <s:textfield name="zplhdr.stctr" cssClass="input_w"/></td>
								<td>邮编: <s:textfield name="zplhdr.stzip" cssClass="input_w"/></td>
							</tr>
							<tr>
								<td colspan="3"><span style="color:red">发运地</span>: <s:textfield name="zplhdr.sfnam" cssClass="input_s_1"/></td>
							</tr>
							<tr>
								<td colspan="2">地址1: <s:textfield name="zplhdr.sfadd1" cssClass="input_s_1"/></td>
								<td>地址2: <s:textfield name="zplhdr.sfadd2" cssClass="input_w"/></td>
							</tr>
							<tr>
								<td>城市: <s:textfield name="zplhdr.sfctiy" cssClass="input_w"/></td>
								<td>国家: <s:textfield name="zplhdr.sfctr" cssClass="input_w"/></td>
								<td>邮编: <s:textfield name="zplhdr.sfzip" cssClass="input_w"/></td>
							</tr>
							<tr>
								<td colspan="3"><span style="color:red">收货地</span>: <s:textfield name="zplhdr.scnam" cssClass="input_s_1"/></td>
							</tr>
							<tr>
								<td colspan="2">地址1: <s:textfield name="zplhdr.scadd1" cssClass="input_s_1"/></td>
								<td>地址2: <s:textfield name="zplhdr.scadd2" cssClass="input_w"/></td>
							</tr>
							<tr>
								<td>城市: <s:textfield name="zplhdr.sccity" cssClass="input_w"/></td>
								<td>国家: <s:textfield name="zplhdr.scctr" cssClass="input_w"/></td>
								<td>邮编: <s:textfield name="zplhdr.sczip" cssClass="input_w"/></td>
							</tr>
							
							<tr align="right">
								<td colspan="3"><input type="button" cssClass="search_button"  onclick="searchDetail();" value="查询销售订单行明细"></td>
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
								<th><input type="checkbox" name="cba" onclick="selectall(this)" />选择</th>
								<th>客户编码</th>
								<th>客户名称</th>
								<th>订单号</th>
								<th>行号</th>	
								<th>产品</th>
								<th>产品描述</th>
								<th>订货量</th>
								<th>已出货量</th>
								<th>库存量</th>
								<th>未出货量</th>
							</tr>
							
						</tbody>
					</table>
				</td>
			</tr>	
				<tr align="right">
				<td> 
					<table width="100%">
						<tr>
							<td><input type="button" cssClass="search_button"  onclick="" value="创建出货通知单"></td>
						</tr>
					</table>
				</td>
			</tr>	
		<tbody>
	</table>
</body>

</html>