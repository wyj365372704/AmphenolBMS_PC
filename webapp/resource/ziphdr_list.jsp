<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>深圳安费诺BMS系统</title>

<link href="<%=request.getContextPath() %>/css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.4.2.min.js"></script>
<script src="<%=request.getContextPath() %>/js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
<script src="<%=request.getContextPath() %>/js/alert/jquery.alerts.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/common.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/js/alert/alerts.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
	function addZiphdr(ordno,house){
		window.open("ziphdr_add.jsp?ordno="+ordno+"&house="+house,'newwindow','height=251,width=400,top='+ (window.outerHeight/3)+',left='+ (window.outerWidth/2)+',toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
		
	}
	function selectrow(idx,ipdtyp){//alert(idx);
		document.getElementsByName("ipdno")[idx].checked="true";
		var ipdno = document.getElementsByName("ipdno")[idx].value;
		document.getElementById("idx").value=idx;
		document.getElementById("ipdtyp").value=ipdtyp;
		var aj = $.ajax( {  
		       url:'resource/ziphdr!toZipdtl.action',// 跳转到 action  
		       data:{  
		                ipdno : ipdno,
		                iptyp : ipdtyp
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
	function goconfirm(ipdno){
		document.getElementsByName("ipdno")[0].value=ipdno;
		if(confirm("确定对该单据进行确认操作吗？")){
			document.getElementsByName("queryform")[0].submit();
		}
		
	}
	function goadd(ipdno,ordno,house,iptyp){
		var ref=window.open("resource/ziphdr!toAddZipdtl.action?ordno="+ordno+"&ipdno="+ipdno+"&house="+house+"&iptyp="+iptyp,'newwindow','height=251,width=400,top='+ (window.outerHeight/3)+',left='+ (window.outerWidth/2)+',toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
		
	}
	function goedit(ipdno,ipdln){
		var ipdtyp=document.getElementById("ipdtyp").value;
		var ref=window.open("resource/ziphdr!toEditZipdtl.action?ipdln="+ipdln+"&ipdno="+ipdno+"&iptyp="+ipdtyp,'newwindow','height=251,width=400,top='+ (window.outerHeight/3)+',left='+ (window.outerWidth/2)+',toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	
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

<s:form action="ziphdr!toConfirm.action" method="post" name="queryform">

	<div class="path">您现在的位置： 首页 &gt; 生产 &gt; 领料单</div>
	
		
	
	<div class="data_list">
		<h2>
			<span class="fl">领料单列表</span>
			<s:hidden name="ordno"></s:hidden>
			<input type="hidden" id="idx" />
			<input type="hidden" id="ipdtyp" />
			<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<div >
			<table width="100%"  border="0" cellspacing="1" cellpadding="0" class="list_table_s" >
			  <tr>
				<th>单号</th>
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
				<th>审批</th>
				<th>操作</th> 
				<!-- -->
			  </tr>
			<s:iterator value="results" id="results" status="st">
  				 <s:if test="#st.Even">
		      		<tr class="td_bgcolor" onclick="selectrow('<s:property value="#st.index"/>','<s:property value="iptyp"/>');">
		      	</s:if>
		      	<s:else>
		      		<tr class="td_bgcolor2" onclick="selectrow('<s:property value="#st.index"/>','<s:property value="iptyp"/>');">
		      	</s:else>
	  				<td><input name="ipdno" type="radio" value="<s:property value="ipdno"/>"/><s:property value="ipdno"/></td>
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
	  				<td><s:property value="aprus"/></td>
	  				<td><s:property value="saprdt"/></td>
	  				<td><s:property value="saprtm"/></td>
	  				<td><s:property value="cmmt"/></td>
	  				<td>
	  				<s:if test="lprt==1">
	  					是
	  				</s:if>
	  				<s:else>
	  					否
	  				</s:else>
	  				</td>
	  				<td><s:property value="aprst"/></td>
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
	  				<td>
	  				<s:if test="fapr==1">
	  					审批
	  				</s:if>
	  				<s:else>
	  					无需审批
	  				</s:else>
	  				</td>
	  				<td>
	  				<s:if test="ostat==05">
	  					<input type="button" id="addbtn" value="新增" class="gray_button" onclick="goadd('<s:property value="ipdno"/>','<s:property value="ordno"/>','<s:property value="house"/>','<s:property value="iptyp"/>');"/>
	  				</s:if>
	  				
	  				<input type="button" id="confirmbtn" value="确认" class="gray_button" onclick="goconfirm('<s:property value="ipdno"/>');"/>
	  				</td>
	  				
  			   </tr>
  			</s:iterator>
		  </table>
		</div>
		<div id="datahtml" style="margin-top: 10px">
			<table width="100%"  border="0" cellspacing="1" cellpadding="0" class="list_table_s" >
			  <tr>
				<th>单号</th>
				<th>工单</th>
				<th>行号</th>
				<th>物料</th>
				<th>描述</th>
				<th>数量</th>
				<th>单位</th>
				<th>默认仓库</th>
				<th>默认子库</th>
				<th>默认库位</th>
				<th>打印状态</th>
				<th>实发</th>
				<th>状态</th>
				<th>操作</th> 
				<!-- -->
			  </tr>
			 
			   </table>
		 
		</div>
	</div>
	
</s:form>

</body>
<script type="text/javascript">
	window.onload=function(){
		var idx = document.getElementById("idx").value;
		if(idx){
			var ipdno = document.getElementsByName("ipdno")[idx].value;
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
		
	}
</script>
</html>