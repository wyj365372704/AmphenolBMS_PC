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
   var retdata = "<s:property value='data'/>";
   var itnbr = "<s:property value='cnote'/>";
   if(retdata=="" || retdata==null || retdata=="null"){
   	
   }else{
   		if(retdata=="success"){
   			alert("创建通知单成功！");
   			window.close();
   			//window.location.href="zplhdrs!toZplhdr.action";
   		}else{
   			if(retdata=="nol"){
   				alert("物料"+itnbr+"子库或库位信息为空，请完善");
   			}else if(retdata=="noh"){
   				alert("物料"+itnbr+"没有子库或库位信息，请完善");
   			}else{
   				alert("创建通知单失败");
   			}
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
		      		//$("#stnam").empty(); 
		      		document.getElementsByName("stnam")[0].options.length=0;
		      		document.getElementsByName("scnam")[0].options.length=0;
		      		var shiptos = (eval(json.shiptos));
		      		var zcuscns = (eval(json.zcuscns));
		      		var shiptoopts="";
		      		 document.getElementsByName("stnam")[0].options.add(new Option("",""));
		      		 document.getElementsByName("scnam")[0].options.add(new Option("",""));
		      		//$("#select_id").append("<option value='Value'>Text</option>"); 
		      		for(var i=0;i<shiptos.length;i++){
		      			//shiptoopts=shiptoopts+("<option value='"+(shiptos[i].s2cmtx+"-"+shiptos[i].s2cntx+"-"+shiptos[i].s2cptx+"-"+shiptos[i].s2cocd+"-"+shiptos[i].s2cvcd)+"'>"+shiptos[i].s2cltx+"</option>"); 
		      			 document.getElementsByName("stnam")[0].options.add(new Option(shiptos[i].s2cltx,(shiptos[i].s2cmtx+"-"+shiptos[i].s2cntx+"-"+shiptos[i].s2cptx+"-"+shiptos[i].s2cocd+"-"+shiptos[i].s2cvcd)));
		      			
		      		}
		      		//alert(zcuscns.length);
		      		for(var i=0;i<zcuscns.length;i++){
		      			//shiptoopts=shiptoopts+("<option value='"+(shiptos[i].s2cmtx+"-"+shiptos[i].s2cntx+"-"+shiptos[i].s2cptx+"-"+shiptos[i].s2cocd+"-"+shiptos[i].s2cvcd)+"'>"+shiptos[i].s2cltx+"</option>"); 
		      			 document.getElementsByName("scnam")[0].options.add(new Option(zcuscns[i].cname,(zcuscns[i].caddr1+"-"+zcuscns[i].caddr2+"-"+zcuscns[i].ccity+"-"+zcuscns[i].ccntr+"-"+zcuscns[i].czip)));
		      			
		      		}
		      		//alert(shiptoopts);
		      		//document.getElementsByName("zplhdr.stnam")[0].innerHTML="<option value='2'>dd</option>";
		      		//document.getElementsByName("zplhdr.stnam")[0].value=json.stnam;
		      		//document.getElementsByName("zplhdr.stadd1")[0].value=json.stadd1;
		      		//document.getElementsByName("zplhdr.stadd2")[0].value=json.stadd2;
		      		//document.getElementsByName("zplhdr.stcity")[0].value=json.stcity;
		      		//document.getElementsByName("zplhdr.stctr")[0].value=json.stctr;
		      		//document.getElementsByName("zplhdr.stzip")[0].value=json.stzip;
		      		
		      		//document.getElementsByName("zplhdr.scnam")[0].value=json.scnam;
		      		//document.getElementsByName("zplhdr.scadd1")[0].value=json.scadd1;
		      		//document.getElementsByName("zplhdr.scadd2")[0].value=json.scadd2;
		      		//document.getElementsByName("zplhdr.sccity")[0].value=json.sccity;
		      		//document.getElementsByName("zplhdr.scctr")[0].value=json.scctr;
		      		//document.getElementsByName("zplhdr.sczip")[0].value=json.sczip;
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
		var scnam=document.getElementsByName("zplhdr.scnam")[0].value;
		var stnam=document.getElementsByName("zplhdr.stnam")[0].value;
		var sfnam=document.getElementsByName("zplhdr.sfnam")[0].value;
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
		if(scnam==''){
			alert("请选择收货地！");
			return;
		}
		if(stnam==''){
			alert("请选择运达地！");
			return;
		}
		if(sfnam==''){
			alert("请选择发运地！");
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
	function selectadd1(){
		var val = $("#stanmid").val();
		var txt=$("#stanmid").find("option:selected").text();
		document.getElementsByName("zplhdr.stadd1")[0].value=val.split("-")[0];
		document.getElementsByName("zplhdr.stadd2")[0].value=val.split("-")[1];
		document.getElementsByName("zplhdr.stcity")[0].value=val.split("-")[2];
		document.getElementsByName("zplhdr.stctr")[0].value=val.split("-")[3];
		document.getElementsByName("zplhdr.stzip")[0].value=val.split("-")[4];
		document.getElementsByName("zplhdr.stnam")[0].value=txt;
		//alert(val.split("-"));
		//alert(txt);
	}
	function selectadd2(){
		var val = $("#scanmid").val();
		var txt=$("#scanmid").find("option:selected").text();
		document.getElementsByName("zplhdr.scadd1")[0].value=val.split("-")[0];
		document.getElementsByName("zplhdr.scadd2")[0].value=val.split("-")[1];
		document.getElementsByName("zplhdr.sccity")[0].value=val.split("-")[2];
		document.getElementsByName("zplhdr.scctr")[0].value=val.split("-")[3];
		document.getElementsByName("zplhdr.sczip")[0].value=val.split("-")[4];
		document.getElementsByName("zplhdr.scnam")[0].value=txt;
	}
	
	//zplhdr.sfnam
	function selectadd3(){
		var val = $("#sfanmid").val();
		var txt=$("#sfanmid").find("option:selected").text();
		document.getElementsByName("zplhdr.sfadd1")[0].value=val.split("-")[0];
		document.getElementsByName("zplhdr.sfadd2")[0].value=val.split("-")[1];
		document.getElementsByName("zplhdr.sfcity")[0].value=val.split("-")[2];
		document.getElementsByName("zplhdr.sfctr")[0].value=val.split("-")[3];
		document.getElementsByName("zplhdr.sfzip")[0].value=val.split("-")[4];
		//alert(val);
	}
</script>
<body>
	<table cellpadding="5px" width="100%" class="tb">
		<tbody>
			<s:form action="sales!createNotice.action" method="post" name="queryform">
			<input name="ordernos" type="hidden" value="" />
			<input name="qtys" type="hidden" value="" />
			<input name="ddlxs" type="hidden" value="" />
			<input name="ddhhs" type="hidden" value="" />
			
			<input name="wlhs" type="hidden" value="" />
			<input name="houses" type="hidden" value="" />
			<input name="kcdws" type="hidden" value="" />
			<input name="ponums" type="hidden" value="" />
			<input name="zxdhs" type="hidden" value="" />
			<input name="xss" type="hidden" value="" />
			<input name="zplhdr.stnam" type="hidden" value="" />
			<input name="zplhdr.scnam" type="hidden" value="" />
			
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
								<td>客户: <s:select name="zplhdr.cusno" id="cusno" 
						list="%{customers}" listKey="cusno" listValue="cusnm"
						cssClass="select_s_2" style="width:60%" onchange="getAddByCus();"></s:select>
						<s:hidden name="zplhdr.cusnm"></s:hidden>
						</td>
								<td>运输方式: <s:select name="zplhdr.scac"
						list="%{carriers}" listKey="atf1cd" listValue="atf1cd"
						cssClass="select_s_2" style="width:60%"></s:select></td>
								<td>国际贸易条款: <s:select name="zplhdr.incot"
						list="%{salestts}" listKey="c8bhst" listValue="c8hytx"
						cssClass="select_s_2" style="width:60%"></s:select></td>
						
							</tr>
							<tr>
								<td colspan="3"><span style="color:red">运达地</span>: 
								 <select name="stnam" id="stanmid" class="select_s_2" style="width:60%" onchange="selectadd1();"></select>					
								</td>
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
								<td colspan="3"><span style="color:red">发运地</span>: 
								<s:select name="zplhdr.sfnam" id="sfanmid" 
									list="%{sfnams}" listKey="svalue" listValue="sname"
									cssClass="select_s_2" style="width:60%" onchange="selectadd3();"></s:select>	
								</td>
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
								<td colspan="3"><span style="color:red">收货地</span>: 
								 <select name="scnam" id="scnamid" class="select_s_2" style="width:60%" onchange="selectadd2();"></select>	
								</td>
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
							
							<tr align="right">
								<td colspan="3"><input type="button" cssClass="search_button"  onclick="searchDetail();" value="查询销售订单行明细"></td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			</s:form>
			<tr>
				<td>
					<div id="info" style="height:400px; overflow:auto">
					<table width="100%" border="1" cellpadding="3px" style="border-collapse: collapse;">
						<tbody>
							
							<tr>
								<th><input type="checkbox" name="chk" onclick="selectall(this)" /></th>
								<!-- <th>客户编码</th>  -->
								<th>客户名称</th>
								<th>订单号</th>
								<th>客户PO</th>
								<th>行号</th>	
								<th>产品</th>
								<th>客户项目编码</th>
								<th>订货量</th>
								<th>已出货量</th>
								<th>库存量</th>
								<th>未出货量</th>
								<th>交货量</th>
								<th>装箱单号</th>
								<th>箱数</th>
							</tr>
							
						</tbody>
					</table>
					</div>
				</td>
			</tr>	
				<tr align="center">
				<td> 
					<table width="100%">
						<tr align="center">
							<td><input type="button" cssClass="search_button"  onclick="createNotice();" value="创建出货通知单"></td>
						</tr>
					</table>
				</td>
			</tr>	
		<tbody>
	</table>
</body>

</html>