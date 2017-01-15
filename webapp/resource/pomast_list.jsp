<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>深圳安费诺BMS系统</title>

<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
	function printOdr(ordno){
	//alert(house);
		window.open("pomast_pre.jsp?ordno="+ordno,'newwindow','height=251,width=400,top='+ (window.outerHeight/3)+',left='+ (window.outerWidth/2)+',toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	}
	function gtZiphdr(ordno){
		//alert(ordno);
		window.location.href="./resource/ziphdr!toZiphdr.action?ordno="+ordno;
	}
	function selectall(){
		var ischk = document.getElementsByName("chkall")[0].checked;
		//if(ischk){
			var chkall = document.getElementsByName("chk");
			for(var i=0;i<chkall.length;i++){
				chkall[i].checked=ischk;
			}
		//}
		
	}
	function addZiphdrM(){
		
		var ischk = false;
		var ordno="";
		var chkall = document.getElementsByName("chk");
		for(var i=0;i<chkall.length;i++){
			if(chkall[i].checked){
				ischk=true;
				ordno=ordno+"-"+chkall[i].value;
			};
		}
		if(!ischk){
			alert("请选择工单");
			return;
		}
		$.ajax( {  
		       url:'momast!addZiphdrM.action',// 跳转到 action  
		       data:{  
		                chk : ordno
		       },  
		      type:'post',  
		      cache:false,  
		      success:function(data) {  
		      	if(data=='success'){
		      		 alert("批量创建领料单成功");
		      	}else if(data=='fail'){
		      		 alert("批量创建领料单失败");
		      	}else {
		      		 //alert("删除物料失败！"); 
		      		 alert(data);
		      	}
		        
		        
		       },  
		       error : function() {  
		            // view("异常！");  
		            alert("删除物料失败！");  
		       }  
		  });
	}
	
		function selectrow(idx,ipdtyp){//alert(idx);
		var ordno = document.getElementsByName("chk")[idx].value;
		var aj = $.ajax( {  
		       url:'pomast!toSchrcp.action',// 跳转到 action  
		       data:{  
		                ordno : ordno,
		       },  
		      type:'post',  
		      cache:false,  
		      success:function(data) {  
		         document.getElementById("datahtml").innerHTML=data; 
		       },  
		       error : function() {  
		            // view("异常！");  
		            //alert("异常！");  
		       }  
		  });
	}
	function goreturn(sctkji){
		var ref=window.open("pomast!toPomastReturnInquire.action?sctkji="+sctkji,'newwindow','height=251,width=400,top='+ (window.outerHeight/3)+',left='+ (window.outerWidth/2)+',toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	}
	function godelete(ipdno,ipdln){//alert(idx);
		if(!confirm("确定删除该物料吗？")){
			return;
		}
		var aj = $.ajax( {  
		       url:'resource/ziphdr!toDelete.action',// 跳转到 action  
		       data:{  
		                ipdno : ipdno,
		                ipdln : ipdln
		       },  
		      type:'post',  
		      cache:false,  
		      success:function(data) {  
		      	if(data='success'){
		      		 alert("删除物料成功！"); 
			         if(idx){
			          $.ajax( {  
					       url:'resource/ziphdr!toZipdtl.action',// 跳转到 action  
					       data:{  
					                ipdno : ipdno
					       },  
					      type:'post',  
					      cache:false,  
					      success:function(data) {  
					         document.getElementById("datahtml").innerHTML=data; 
					       },  
					       error : function() {  
					            // view("异常！");  
					            //alert("异常！");  
					       }  
					  });
			         }
		      	}else{
		      		 alert("删除物料失败！"); 
		      	}
		        
		        
		       },  
		       error : function() {  
		            // view("异常！");  
		            alert("删除物料失败！");  
		       }  
		  });
	}
</script>


<body class="right_body">

	<s:form action="pomast!toPomast.action" method="post" name="queryform">
		<s:hidden name="flag" value="1"></s:hidden>
		<div class="path">您现在的位置： 首页 &gt; 生产 &gt; 采购订单</div>

		<div class="search">
			<h2>
				<span class="fl">采购订单查询</span> <span class="fr"> <s:submit
						id="queryId" value="" cssClass="search_button"
						onclick="return dosubmit()"></s:submit> <s:reset value=""
						cssClass="purge_button"></s:reset> </span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>

			<ul>

				<li><div class="w_s">仓库：</div> <s:select name="pomast.fitwh"
						list="#session.houses" listKey="house" listValue="house"
						cssClass="select_s_2" style="width:60px"></s:select>
				</li>

				<li><div class="w_s">供应商名称：</div> <s:textfield
						name="pomast.vn35" cssClass="input_w" />
				</li>
				<li><div class="w_s">采购员：</div> <s:textfield
						name="pomast.buyno" cssClass="input_w" />
				</li>
				<li><div class="w_s">创建日期：</div> <s:textfield id="startDate"
						name="pomast.startDate" cssClass="time_input"
						onclick="WdatePicker()" autocomplete="on" />- <s:textfield
						id="endDate" name="pomast.endDate" cssClass="time_input"
						onclick="WdatePicker()" autocomplete="on" />
				</li>

				<li><div class="w_s">订单：</div> <s:textarea name="pomast.ordno"
						cssClass="input_w" style="height:30px"></s:textarea>
				</li>
				<li></li>
			</ul>
		</div>

		<div class="data_list">
			<h2>
				<span class="fl">采购订单列表</span> <span class="fr"></span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>

			<div class="list_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="list_table_s">
					<tr>
						<th><input name="chkall" type="checkbox"
							onclick="selectall();" /> 单号</th>
						<th>仓库</th>
						<th>供应商</th>
						<th>币种</th>
						<th>采购员</th>
						<th>订单状态</th>
						<th>已打印</th>
						<th>创建日期</th>
						<th>操作</th>
						<!-- -->
					</tr>
					<s:iterator value="results" id="results" status="st">
						<s:if test="#st.Even">
							<tr class="td_bgcolor"
								onclick="selectrow('<s:property value="#st.index"/>','<s:property value="iptyp"/>');">
						</s:if>
						<s:else>
							<tr class="td_bgcolor2"
								onclick="selectrow('<s:property value="#st.index"/>','<s:property value="iptyp"/>');">
						</s:else>
						<td><input name="chk" type="checkbox"
							value="<s:property value="ordno"/>" /> <s:property value="ordno" />
						</td>
						<td><s:property value="house" /></td>
						<td><s:property value="vn35" /></td>
						<td><s:if test="curid!='   '">
								<s:property value="curid" />
							</s:if> <s:else>
	  					CNY
	  				</s:else>
						</td>
						<td><s:property value="buyno" /></td>
						<td><s:if test="pstts==10">
	  					需要供应商确认
	  				</s:if> <s:elseif test="pstts==20">
	  					供应商已接受
	  				</s:elseif> <s:elseif test="pstts==30">
	  					部分收货
	  				</s:elseif> <s:elseif test="pstts==35">
	  					发票完成
	  				</s:elseif> <s:elseif test="pstts==40">
	  					收货完成
	  				</s:elseif> <s:elseif test="pstts==50">
	  					发票、收货都完成
	  				</s:elseif> <s:elseif test="pstts==99">
	  					已取消
	  				</s:elseif>
						</td>
						<td><s:property value="uusapm" /></td>
						<td><s:property value="actdts" /></td>
						<td><s:if
								test='pstts=="10"||pstts=="20"||pstts=="30"||pstts=="40"||pstts=="35"'>
								<input type="button" id="printO" value="打印" class="gray_button"
									onclick="printOdr('<s:property value="ordno"/>');" />
							</s:if>
						</td>

						</tr>
					</s:iterator>
				</table>
			</div>
		</div>

		<div id="datahtml" style="margin-top: 10px" class="data_list">
			<table width="100%" border="0" cellspacing="1" cellpadding="0"
				class="list_table_s">
				<tr>
					<th>单号</th>
					<th>供应商代码</th>
					<th>行号</th>
					<th>物料</th>
					<th>物料描述</th>
					<th>订单数量</th>
					<th>未交数量</th>
					<th>已到货数量</th>
					<th>采购单位</th>
					<th>库存单位</th>
					<th>订单行状态</th>
					<th>采购员</th>
					<th>计划员</th>
					<th>操作</th>
					<!-- -->
				</tr>

			</table>

		</div>
		<div class="page">
			<page:paginator formName="queryform" nameInRequest="paginator" />
		</div>
	</s:form>

</body>
</html>