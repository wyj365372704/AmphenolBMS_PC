<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv=“X-UA-Compatible” content=“IE=7″>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>深圳安费诺BMS系统</title>

<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/jquery-1.4.2.min.js"></script>
<script
	src="<%=request.getContextPath() %>/js/alert/jquery.ui.draggable.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/alert/jquery.alerts.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/common.js"
	type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/js/alert/alerts.css"
	rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
	function addZiphdr(ordno,house){
	//alert(house);
		window.open("ziphdr_add.jsp?ordno="+ordno+"&house="+house,'newwindow','height=251,width=400,top='+ (window.outerHeight/3)+',left='+ (window.outerWidth/2)+',toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
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
	function deleteZvritm(vrdno,vrdln,blksq){
		$.ajax( {  
		       url:'pomast!deleteZvritm.action',// 跳转到 action  
		       data:{  
		                vrdno : vrdno,
		                vrdln : vrdln,
		                blksq : blksq
		       },  
		      type:'post',  
		      cache:false,  
		      success:function(data) {  
		      	if(data.trim()=='success'){
		      		 alert("删除成功");
		      		 location.reload();
		      	}else{
		      		 alert("删除失败");
		      	}
		       },  
		       error : function() {  
		            alert("删除失败");  
		       }  
		  });
	}
		function enableCreateZvritm(vrdno){
		$.ajax( {  
		       url:'pomast!enableCreateZvritm.action',// 跳转到 action  
		       data:{  
		                vrdno : vrdno
		       },  
		      type:'post',  
		      cache:false,  
		      success:function(data) {  
		      	if(data.trim()=='success'){
		      		 alert("操作成功");
		      		 location.reload();
		      	}else{
		      		 alert("操作失败");
		      	}
		       },  
		       error : function() {  
		            alert("操作失败");  
		       }  
		  });
	}
			function cancelZvritm(vrdno){
		$.ajax( {  
		       url:'pomast!cancelZvritm.action',// 跳转到 action  
		       data:{  
		                vrdno : vrdno
		       },  
		      type:'post',  
		      cache:false,  
		      success:function(data) {  
		      	if(data.trim()=='success'){
		      		 alert("操作成功");
		      		 location.reload();
		      	}else{
		      		 alert("操作失败");
		      	}
		       },  
		       error : function() {  
		            alert("操作失败");  
		       }  
		  });
	}
	// 打印
	function myPrint() {
		// 检查是否选中记录
		var cbs = document.getElementsByName("chk");
		if (!cbs) {
			alert("未选中记录！");
			return;
		}

		var gno = new Array();
		var count = 0;
		cbs.forEach(function(p) {
			if (!p.checked) {
				bool = false;
			} else {
				count++;
				gno.push($.trim(p.value));
			}
		});

		if (count <= 0) {
			alert("未选中记录！");
			return;
		}

		var grnnos = JSON.stringify({
			grnnos : gno
		});

		window.open('momast!momastPrint.action?grnno=' + grnnos, 'newwindow', 'height=200,width=400,top=60,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	}
	
		function selectrow(vrdno){//alert(idx);
		var aj = $.ajax( {  
		       url:'pomast!toZvritm.action',// 跳转到 action  
		       data:{  
		                vrdno : vrdno,
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
</script>


<body class="right_body">

	<s:form action="pomast!toPomastReturn.action" method="post"
		name="queryform">

		<div class="path">您现在的位置： 首页 &gt; 采购 &gt; 采购退料</div>

		<div class="search">
			<h2>
				<span class="fl">退料单查询</span> <span class="fr"> <s:submit
						id="queryId" value="" cssClass="search_button"
						onclick="return dosubmit()"></s:submit> <s:reset value=""
						cssClass="purge_button"></s:reset> <input type="button"
					id="addOperM" value="批量生成领料单" onclick="addZiphdrM();" /> <input
					type="button" cssClass="search_button" onclick="myPrint()"
					value="打印"> </span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>

			<ul>

				<li><div class="w_s">退货单号：</div> <s:textarea
						name="zvrhdr.vrdno" cssClass="input_w" style="height:30px"></s:textarea>
				</li>
				<li><div class="w_s">供应商：</div> <s:textarea name="zvrhdr.vndnr"
						cssClass="input_w" style="height:30px"></s:textarea>
				</li>
				<li><div class="w_s">创建日期：</div> <s:textfield id="startDate"
						name="zvrhdr.startDate" cssClass="time_input"
						onclick="WdatePicker()" autocomplete="on" />- <s:textfield
						id="endDate" name="zvrhdr.endDate" cssClass="time_input"
						onclick="WdatePicker()" autocomplete="on" />
				</li>
				<li><div class="w_s">退货状态：</div> <s:select
						list="#{' ':'全部','1':'创建中','2':'已创建,未退货','3':'部分退货','4':'退货完成'}"
						name="momast.uusamy" headerValue="momast.uusamy"
						style="width:80px" cssClass="select_s_2"></s:select></li>
			</ul>
		</div>

		<div class="data_list">
			<h2>
				<span class="fl">退料单列表</span> <span class="fr"></span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>

			<div class="list_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="list_table_s">
					<tr>
						<th><input name="chkall" type="checkbox"
							onclick="selectall();" /> 单号</th>
						<th>供应商</th>
						<th>退料单状态</th>
						<th>创建人</th>
						<th>创建日期</th>
						<th>创建时间</th>
						<th>操作</th>
						<!-- -->
					</tr>
					<s:iterator value="zvrhdrList" status="st">
						<s:if test="#st.Even">
							<tr class="td_bgcolor"
								onclick="selectrow('<s:property value="vrdno"/>');">
						</s:if>
						<s:else>
							<tr class="td_bgcolor2"
								onclick="selectrow('<s:property value="vrdno"/>');">
						</s:else>
						<td><input name="chk" type="checkbox"
							value="<s:property value="vrdno"/>" /> <s:property value="vrdno" />
						</td>
						<td><s:property value="vndnr" /></td>
						<td><s:if test="ostat==05">
	  					创建中
	  				</s:if> <s:elseif test="ostat==10">
	  					已创建,未退货
	  				</s:elseif> <s:elseif test="ostat==40">
	  					部分退活
	  				</s:elseif> <s:elseif test="ostat==50">
	  					退货完成
	  				</s:elseif></td>
						<td><s:property value="crus" /></td>
						<td><s:property value="crdt" /></td>
						<td><s:property value="crtm" /></td>
						<td><s:if test='ostat=="05"'>
								<input type="button" id="addOper" value="完成创建" class="gray_button"
									onclick="enableCreateZvritm('<s:property value="vrdno"/>');" />
							</s:if> <s:if test='ostat=="10"'>
								<input type="button" id="addOper" value="取消" class="gray_button"
									onclick="cancelZvritm('<s:property value="vrdno"/>');" />
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
					<th>行号</th>
					<th>供应商代码</th>
					<th>退货单行状态</th>
					<th>物料</th>
					<th>批次控制</th>
					<th>库存单位</th>
					<th>计划退货数量</th>
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