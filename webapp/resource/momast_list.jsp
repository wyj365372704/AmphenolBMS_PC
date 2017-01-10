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
<script type="text/javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.4.2.min.js"></script>
<script src="<%=request.getContextPath() %>/js/alert/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/alert/jquery.alerts.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/common.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/js/alert/alerts.css" rel="stylesheet" type="text/css" />
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
		for(var i=0;i<cbs.length;i++){
			if (!cbs[i].checked) {
				bool = false;
			} else {
				count++;
				gno.push($.trim(cbs[i].value));
			}
		}
	/* 	cbs.forEach(function(p) {
			if (!p.checked) {
				bool = false;
			} else {
				count++;
				gno.push($.trim(p.value));
			}
		}) */

		if (count <= 0) {
			alert("未选中记录！");
			return;
		}

		var grnnos = JSON.stringify({
			grnnos : gno
		});

		window.open('momast!momastPrint.action?grnno=' + grnnos, 'newwindow', 'height=200,width=400,top=60,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	}
</script>


<body class="right_body">

	<s:form action="momast!toMomast.action" method="post" name="queryform">

		<div class="path">您现在的位置： 首页 &gt; 生产 &gt; 生产订单</div>

		<div class="search">
			<h2>
				<span class="fl">生产订单查询</span> <span class="fr"> <s:submit
						id="queryId" value="" cssClass="search_button"
						onclick="return dosubmit()"></s:submit> <s:reset value=""
						cssClass="purge_button"></s:reset> <input type="button"
					id="addOperM" value="批量生成领料单" onclick="addZiphdrM();" /> <input type="button"
					cssClass="search_button" onclick="myPrint()" value="打印"></span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>

			<ul>

				<li><div class="w_s">仓库：</div> <s:select name="momast.fitwh"
						list="#session.houses" listKey="house" listValue="house"
						cssClass="select_s_2" style="width:60px"></s:select></li>

				<li><div class="w_s">产品：</div> <s:textfield name="momast.fitem"
						cssClass="input_w" /></li>
				<li><div class="w_s">部门：</div> <s:textfield name="momast.dptno"
						cssClass="input_w" /></li>
				<li><div class="w_s">计划开始日期：</div> <s:textfield id="startDate"
						name="momast.startDate" cssClass="time_input"
						onclick="WdatePicker()" autocomplete="on" />- <s:textfield
						id="endDate" name="momast.endDate" cssClass="time_input"
						onclick="WdatePicker()" autocomplete="on" /></li>

				<li><div class="w_s">工单：</div> <s:textarea name="momast.ordno"
						cssClass="input_w" style="height:30px"></s:textarea></li>
				<li><div class="w_s">打印状态：</div> 
			
				<s:select list="#{'':'全部','1':'已打印',' ':'未打印'}" name="momast.uusamy"
				headerValue="momast.uusamy" style="width:80px" cssClass="select_s_2" ></s:select>
				</li>
			</ul>
		</div>

		<div class="data_list">
			<h2>
				<span class="fl">生产订单列表</span> <span class="fr"></span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>

			<div class="list_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="list_table_s">
					<tr>
						<th><input name="chkall" type="checkbox"
							onclick="selectall();" /> 单号</th>
						<th>产品</th>
						<th>描述</th>
						<th>数量</th>
						<th>单位</th>
						<th>部门</th>
						<th>计划开始日期</th>
						<th>计划完工日期</th>
						<th>状态</th>
						<th>已打印</th>
						<th>已完工</th>
						<th>未完工</th>
						<th>操作</th>
						<!-- -->
					</tr>
					<s:iterator value="results" id="results" status="st">
						<s:if test="#st.Even">
							<tr class="td_bgcolor">
						</s:if>
						<s:else>
							<tr class="td_bgcolor2">
						</s:else>
						<td><input name="chk" type="checkbox"
							value="<s:property value="ordno"/>" />
						<s:property value="ordno" />
						</td>
						<td><s:property value="fitem" />
						</td>
						<td><s:property value="fdesc" />
						</td>
						<td><s:property value="moqty" />
						</td>
						<td><s:property value="unmsr" />
						</td>
						<td><s:property value="dptno" />
						</td>
						<td><s:property value="ssstdt" />
						</td>
						<td><s:property value="sodudt" />
						</td>
						<td><s:if test="ostat==10">
	  					已下达
	  				</s:if> <s:elseif test="ostat==40">
	  					已开始生产
	  				</s:elseif> <s:elseif test="ostat==45">
	  					物料完成
	  				</s:elseif> <s:elseif test="ostat==50">
	  					工序完成
	  				</s:elseif> <s:elseif test="ostat==55">
	  					物料/工序完成
	  				</s:elseif> <s:elseif test="ostat==99">
	  					订单取消
	  				</s:elseif></td>
	  					<td><s:if test="uusamy==1">
	  					已打印
	  				</s:if> <s:else>
	  					未打印
	  				</s:else> </td>
						<td><s:property value="qtyrc" />
						</td>
						<td><s:property value="mounqty" />
						</td>
						<td><s:if test='ostat=="10"||ostat=="40"||ostat=="50"'>
								<input type="button" id="addOper" value="新增领料单"
									class="gray_button"
									onclick="addZiphdr('<s:property value="ordno"/>','<s:property value="fitwh"/>');" />
							</s:if> <input type="button" id="goZiphdr" value="领料单"
							class="gray_button"
							onclick="gtZiphdr('<s:property value="ordno"/>');" /></td>
						<!--<td>
	  					<s:if test="customsName==orgName">-</s:if>
						<s:else>
							<s:property value="orgName"/>
						</s:else>
	  				</td>
  					<td><s:property value="roleName"/></td>
	  				<td><s:date name="createDate" format="yyyy-MM-dd HH:mm:ss" /></td>
	  			<td>
	  				<hgpj:operation resourceKey="ROLE_MANAGER" operKey="VIEW" styleCss="button_userlook2"><input name="" type="button" class="button_userlook" title="查看" onclick=javascript:location.href="role!view.action?role.roleId=<s:property value='roleId'/>" /></hgpj:operation>
				    <hgpj:operation resourceKey="ROLE_MANAGER" operKey="MODIFY" styleCss="button_useredit2"><input name="" type="button" class="button_useredit" title="修改"  onclick=javascript:location.href="role!toModify.action?role.roleId=<s:property value='roleId'/>" /></hgpj:operation>
	  				<s:if test='#role.roleId==1||#role.roleName=="分关管理员"'>
	  					<input name="" type="button" class="button_userdelete2" title="删除" />
	  				</s:if>
	  				<s:else>
					    <hgpj:operation resourceKey="ROLE_MANAGER" operKey="DELETE" styleCss="button_userdelete2"><input name="" type="button" class="button_userdelete" title="删除" onclick="del(<s:property value='roleId'/>,'<s:property value='roleName'/>')" /></hgpj:operation>
	  				</s:else>
				</td> -->
						</tr>
					</s:iterator>
				</table>
				<div class="page">
					<page:paginator formName="queryform" nameInRequest="paginator" />
				</div>
			</div>
		</div>

	</s:form>

</body>
</html>