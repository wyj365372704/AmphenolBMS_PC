<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
 var retdata = "<s:property value='data'/>";
 if(retdata=="" || retdata==null || retdata=="null"){
   	
   }else{
   		if(retdata=="success"){
   			alert("修改通知单成功！");
   			window.close();
   			//window.location.href="zplhdrs!toZplhdr.action";
   		}else{
   			alert("修改通知单失败！");
   			window.history.back();
   		}
   }
   
	function getAddByCus(){
		var cusno=document.getElementsByName("zplhdr.cusno")[0].value;
		document.getElementsByName("zplhdr.cusnm")[0].value=$("#cusno").find("option:selected").text();
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
		var startDate=document.getElementsByName("startDate")[0].value;
		var cusno=document.getElementsByName("zplhdr.cusno")[0].value;
		var house=document.getElementsByName("zplhdr.house")[0].value;
		//alert(cusno);
		if(cusno==""){
			alert("请选择客户！");
			return;
		}
		document.getElementById("info").innerHTML="正在查询...";
		$.ajax( {  
		       url:'sales!getSalesList.action',// 跳转到 action  
		       data:{  
		                "mbcdrep.cda3cd" : house,
		                "mbcdrep.cdaayy" : cusno,
		                "mbcdrep.startDate" :startDate
		       },  
		      type:'post',  
		      cache:false,  
		      success:function(data) { 
		      	var json = $.parseJSON(data);
		        //alert(json.retStr); 
		        document.getElementById("info").innerHTML=json.retStr;
		       },  
		       error : function() {  
		            // view("异常！");  
		           // alert("删除物料失败！");  
		       }  
		  });
	}
	function createNotice(){
		var scaac=document.getElementsByName("zplhdr.scac")[0].value;
		var cusno=document.getElementsByName("zplhdr.cusno")[0].value;
		var house=document.getElementsByName("zplhdr.house")[0].value;
		var incot=document.getElementsByName("zplhdr.incot")[0].value;
		var chd="",qtys="",ddlxs="",ddhhs="",wlhs="",houses="",kcdws="",ponums="",zxdhs="",xss="";
		var sfctr=document.getElementsByName("zplhdr.sfctr")[0].value;
		if(cusno==''){
			alert("请选择客户！");
			return;
		}
		if(scaac==''){
			alert("请选择运输方式！");
			return;
		}
		if(incot==''){
			alert("请选择国际条款！");
			return;
		}
		var chds = document.getElementsByName("chk");
		for(var i=0;i<chds.length;i++){
			if(chds[i].checked){
				chd=chd+"-"+chds[i].value;
				qtys=qtys+"-"+document.getElementsByName("jh"+i)[0].value;
				ddlxs=ddlxs+"-"+document.getElementsByName("ddlx"+i)[0].value;
				ddhhs=ddhhs+"-"+document.getElementsByName("hh"+i)[0].value;
				wlhs=wlhs+"-"+document.getElementsByName("wlhs"+i)[0].value;
				houses=houses+"-"+document.getElementsByName("houses"+i)[0].value;
				kcdws=kcdws+"-"+document.getElementsByName("kcdw"+i)[0].value;
				ponums=ponums+"-"+document.getElementsByName("ponum"+i)[0].value;
				zxdhs=zxdhs+"-"+document.getElementsByName("zxdhs"+i)[0].value;
				xss=xss+"-"+document.getElementsByName("xss"+i)[0].value;
				if(new Number(document.getElementsByName("jh"+i)[0].value)>new Number(document.getElementsByName("ddwc"+i)[0].value)){
					alert("订单"+chds[i].value+"交货数量不能大于未出量！");
					return;
				}
				if(document.getElementsByName("zxdhs"+i)[0].value==''){
					alert("请输入订单"+chds[i].value+"的装箱单号！");
					return;
				}
				if(document.getElementsByName("xss"+i)[0].value==''){
					alert("请输入订单"+chds[i].value+"的箱数！");
					return;
				}else {
					var num = document.getElementsByName("xss"+i)[0].value;
					if(!(/(^[1-9]\d*$)/.test(num))){
						alert("订单"+chds[i].value+"的箱数只能是整数！");
						return;
					}
				}
			}
		}
		//alert(chd+";;"+qtys);
		//document.forms[0].submit();
		document.getElementsByName("ordernos")[0].value=chd;
		document.getElementsByName("qtys")[0].value=qtys;
		document.getElementsByName("ddlxs")[0].value=ddlxs;
		document.getElementsByName("ddhhs")[0].value=ddhhs;
		
		document.getElementsByName("wlhs")[0].value=wlhs;
		document.getElementsByName("houses")[0].value=houses;
		document.getElementsByName("kcdws")[0].value=kcdws;
		document.getElementsByName("ponums")[0].value=ponums;
		document.getElementsByName("zxdhs")[0].value=zxdhs;
		document.getElementsByName("xss")[0].value=xss;
		document.getElementsByName("queryform")[0].submit();
	}
</script>
<body>
	<table cellpadding="5px" width="100%" class="tb">
		<tbody>
			<s:form action="zplhdrs!editNotice.action" method="post" name="queryform">
			<input name="ordernos" type="hidden" value="" />
			<input name="qtys" type="hidden" value="" />
			<input name="ddlxs" type="hidden" value="" />
			<input name="ddhhs" type="hidden" value="" />
			
			<input name="wlhs" type="hidden" value="" />
			<input name="houses" type="hidden" value="" />
			<input name="kcdws" type="hidden" value="" />
			<input name="ponums" type="hidden" value="" />
			<input name="zxdhs" type="hidden" value="" />
			<input name="pldno" type="hidden" value="<s:property  value="zplhdr.pldno" />" />
			 
			<tr>
				<td> 
					<table width="100%" cellpadding="3px" border="1px" style="border-collapse: collapse;">
						<tbody>
							<tr>
								<td colspan="2">出货日期: <s:property  value="zplhdr.etdate" /></td>
									<td>仓库: <s:property  value="zplhdr.house" /><s:hidden name="zplhdr.pldno"></s:hidden></td>
									</tr>
							<tr>
								<td>客户: <s:property  value="zplhdr.cusnm" />
						</td>
								<td>运输方式:<s:property  value="zplhdr.scac" /> </td>
								<td>国际贸易条款:<s:property  value="zplhdr.incot" /> </td>
						
							</tr>
							<tr>
								<td colspan="3"><span style="color:red">运达地</span>: <s:textfield name="zplhdr.stnam" cssClass="input_s_1"/></td>
							</tr>
							<tr>
								<td colspan="2">地址1: <s:textfield name="zplhdr.stadd1" cssClass="input_s_1"/></td>
								<td>地址2: <s:textfield name="zplhdr.stadd2" cssClass="input_w"/></td>
							</tr>
							<tr>
								<td>城市: <s:textfield name="zplhdr.stcity" cssClass="input_w" maxlength="50"/></td>
								<td>国家: <s:textfield name="zplhdr.stctr" cssClass="input_w" maxlength="3"/></td>
								<td>邮编: <s:textfield name="zplhdr.stzip" cssClass="input_w" maxlength="20"/></td>
							</tr>
							<tr>
								<td colspan="3"><span style="color:red">发运地</span>: <s:textfield name="zplhdr.sfnam" cssClass="input_s_1"/></td>
							</tr>
							<tr>
								<td colspan="2">地址1: <s:textfield name="zplhdr.sfadd1" cssClass="input_s_1"/></td>
								<td>地址2: <s:textfield name="zplhdr.sfadd2" cssClass="input_w"/></td>
							</tr>
							<tr>
								<td>城市: <s:textfield name="zplhdr.sfcity" cssClass="input_w"/></td>
								<td>国家: <s:textfield name="zplhdr.sfctr" cssClass="input_w" maxlength="3"/></td>
								<td>邮编: <s:textfield name="zplhdr.sfzip" cssClass="input_w" maxlength="20"/></td>
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
								<td>国家: <s:textfield name="zplhdr.scctr" cssClass="input_w" maxlength="3"/></td>
								<td>邮编: <s:textfield name="zplhdr.sczip" cssClass="input_w" maxlength="20"/></td>
							</tr>
						
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<div id="info" style="height:400px; overflow:auto">
					<table width="100%" border="1" cellpadding="3px" style="border-collapse: collapse;">
						<tbody>
							
							<tr>
								<!--<th><input type="checkbox" name="chk" onclick="selectall(this)" /></th> -->
								<!-- <th>客户编码</th>  -->
								<th>序号</th>
								<th>订单号</th>
								<th>客户PO</th>
								<th>行号</th>	
								<th>客户料号 / 我方料号描述</th>
								<th>未出货量</th>
								<th>交货量</th>
								<th>装箱单号</th>
								<th>箱数</th>
							</tr>
							<s:iterator value="mresults" id="it" status="st">
										<tr>
											<input type="hidden" name="pldln" value="<s:property value="#it.pldln" />" />
											<td align="center"><s:property value="#it.idx" /></td>
											<td align="center"><s:property value="#it.cusodrno" /></td>
											<td align="center"><s:property value="#it.ponum" /></td>
											<td align="center"><fmt:formatNumber value="${it.cusln}" pattern="#0" /></td>
											<td align="center"><s:property value="#it.cwlms" /></td>
											<td align="center"><s:property value="#it.plqtyno" /></td>
											<td align="center"><input type="text" name="plqtys"  style="width:50px" value="<s:property value="#it.plqty"  />"> </td>
											<td align="center"><input type="text" name="xhs"  style="width:50px" value="<s:property value="#it.xhs"  />"></td>
											<td align="center"><input type="text" name="xss"  style="width:50px" value="<fmt:formatNumber value="${it.xss}" pattern="#0" />"></td></td>
										</tr>
									</s:iterator>		
						</tbody>
					</table>
					</div>
				</td>
			</tr>	
			</s:form>
				<tr align="center">
				<td> 
					<table width="100%">
						<tr align="center">
							<td><input type="button" cssClass="search_button"  onclick="domodfiy();" value="保存"></td>
							<td><input type="button" cssClass="search_button"  onclick="comfirmn();" value="确认通知单"></td>
						</tr>
					</table>
				</td>
			</tr>	
		<tbody>
	</table>
</body>
<script type="text/javascript">
	function comfirmn(){
		//document.getElementsByName("queryform")[0].action="sales!confirmNotice.action";
		//document.getElementsByName("queryform")[0].submit();
		var pldno = document.getElementsByName("pldno")[0].value;
		$.ajax( {  
		       url:'zplhdrs!toConfirm.action',// 跳转到 action  
		       data:{  
		                "ordno" : pldno
		       },  
		      type:'post',  
		      cache:false,  
		      success:function(data) {// alert(data);
		      	//var json = $.parseJSON(data);
		        //alert(json.retStr); 
		        //document.getElementById("info").innerHTML=json.retStr;
		        if($.trim(data)=="success"){
		        	alert("确认成功！");  
		        	window.close();
		        }else{
		        	alert("确认失败，请联系管理员！"); 
		        }
		       },  
		       error : function() {  
		            alert("确认失败，请联系管理员！"); 
		       }  
		  });
	}
	function domodfiy(){
		document.getElementsByName("queryform")[0].submit();
	}
</script>
</html>