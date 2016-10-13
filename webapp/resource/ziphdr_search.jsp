<%@ page contentType="text/html;charset=UTF-8" %>
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
</script>


<body class="right_body">

<s:form action="ziphdr!toZiphdrList.action" method="post" name="queryform">

	<div class="path">您现在的位置： 首页 &gt; 生产 &gt; 领料单</div>
	
		<div class="search">
		<h2>
			<span class="fl">领料单查询</span>
			<span class="fr">
				<s:submit id="queryId" value="" cssClass="search_button" onclick="return dosubmit()"></s:submit>
				<s:reset value="" cssClass="purge_button"></s:reset>
				</span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<ul>
			
			
			
			<li><div class="w_s">领料单号：</div>
				<s:textarea  name="ipdno" cssClass="input_w" style="height:30px" ></s:textarea>
			</li>
			<li><div class="w_s">工单号：</div>
				<s:textarea  name="ordno" cssClass="input_w" style="height:30px" ></s:textarea>
			</li>
			 <li><div class="w_s">创建日期：</div>
            <s:textfield  id="startDate" name="startDate" cssClass="time_input" onclick="WdatePicker()" autocomplete="on"/>-
            <s:textfield  id="endDate" name="endDate" cssClass="time_input" onclick="WdatePicker()" autocomplete="on"/>
            </li>
            
            
			<li>
				
			</li>
		</ul>
	</div>
	
	<div class="data_list">
		<h2>
			<span class="fl">领料单单列表</span>
			<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<div class="list_inner">
			<table width="100%" border="0" cellspacing="1" cellpadding="0" class="list_table_s">
			  <tr>
				<th><input name="chkall" type="checkbox" onclick="selectall();"/> 领料单号</th>
				<th>工单</th>
				<th>类型</th>
				<th>创建人</th>
				<th>创建部门</th>
				<th>创建日期</th>
				<th>备注</th>
				<th>已打印</th>
				<th>已审批</th>
				<th>状态</th>
				<th>审批人</th>
				<th>审批日期</th>
				<th>审批时间</th> 
				<!-- -->
			  </tr>
			<s:iterator value="results" id="results" status="st">
  				 <s:if test="#st.Even">
		      		<tr class="td_bgcolor">
		      	</s:if>
		      	<s:else>
		      		<tr class="td_bgcolor2">
		      	</s:else>
	  				<td><input name="chk" type="checkbox" value="<s:property value="ipdno"/>"/><s:property value="ipdno"/></td>
	  				<td><s:property value="ordno"/></td>
	  				<td>
						<s:if test="iptyp==1">
		  					正常
		  				</s:if>
		  				<s:if test="iptyp==2">
		  					超领
		  				</s:if>
		  				<s:if test="iptyp==3">
		  					退领
		  				</s:if>
					</td>
	  				<td><s:property value="ipus1"/></td>
	  				<td><s:property value="ipdp1"/></td>
	  				<td><s:property value="sipdt1"/></td>
	  				<td><s:property value="cmmt"/></td>
	  				<td>
						<s:if test="lprt==1">
		  					是
		  				</s:if>
		  				<s:else>
		  					否
		  				</s:else>
					</td>
	  				<td>
						<s:if test="arpst==1">
		  					是
		  				</s:if>
		  				<s:else>
		  					否
		  				</s:else>
					</td>
	  				<td>
	  				<s:if test="ostat==05">
	  					创建中
	  				</s:if>
	  				<s:if test="ostat==10">
	  					已创建
	  				</s:if>
	  				<s:if test="ostat==50">
	  					已完成
	  				</s:if>
	  				<s:if test="ostat==60">
	  					已关闭
	  				</s:if>
	  				</td>
	  				<td><s:property value="aprus"/></td>
	  				<td><s:property value="saprdt"/></td>
					
	  				<td><s:property value="saprtm"/></td>
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
		  <div class="page"><page:paginator formName="queryform" nameInRequest="paginator"/>
		  </div>
		</div>
	</div>
	
</s:form>

</body>
</html>