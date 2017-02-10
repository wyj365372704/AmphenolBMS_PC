<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>销售出货通知单</title>

<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
</head>
<style type="text/css">
	.myli{
		width: 160px !important;
	}
	.mylirt{
		margin-right: 150px !important;
	}
	.mylick{
	    width: 90px !important;
	}
	.mybtnsch{
		margin-left: 10px !important;
	}
</style>

<body class="right_body">
	<s:form action="zplhdrs!toZplhdr.action" method="post" name="queryform">

		<div class="path">您现在的位置： 首页 &gt; 销售 &gt; 销售出货通知单</div>
		
			<div class="search">
			<h2>
				<span class="fl">销售出货通知单查询</span>
				<span class="fr">
					<s:submit id="queryId" value="" cssClass="search_button" onclick="return dosubmit()"></s:submit>
					<s:reset value="" cssClass="purge_button"></s:reset>
				</span><!--  span里无内容时，此span不能删除  -->
			</h2>
			
			<ul>
				
				<li class="myli"><div class="w_s">仓库：</div>
					<s:select name="zplhdr.house"
						list="#session.houses" listKey="house" listValue="house"
						cssClass="select_s_2" style="width:60px"></s:select>					
				</li>
				
				<li class="mylirt"><div class="w_s">客户：</div>
					<s:textfield name="zplhdr.cusnm" cssClass="input_w"/>
				</li>
				
				<li><div class="w_s">通知单号：</div>
	            	<s:textfield name="zplhdr.pldno" cssClass="input_w"/>
	            </li>
	        
	            <li><div class="w_s">出货日期：</div> 
	            	<s:textfield  name="startDate" cssClass="time_input" onclick="WdatePicker()" autocomplete="on"/>
	            	-
            		<s:textfield  name="endDate" cssClass="time_input" onclick="WdatePicker()" autocomplete="on"/>
            	</li>
			</ul>
		</div>
		
		<div class="data_list">
			<h2>
				<span class="fl">出货通知单列表</span>
				<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
			</h2>
			
			<div class="list_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0" class="list_table_s">
				  <tr>
					<th><input type="checkbox" name="cba" onclick="selectall(this)" />选择</th>
					<th>通知单号</th>
					<th>客户名称</th>
					<th>仓库</th>
					<th>运输方式</th>	
					<th>预计出货日期</th>
					<th>状态</th>
					<th>备注</th>
					<th>操作</th>
				  </tr>
				  <s:iterator value="results" id="results" status="st">
						<s:if test="#st.Even">
							<tr class="td_bgcolor" >
						</s:if>
						<s:else>
							<tr class="td_bgcolor2" >
						</s:else>
						<td><input name="chk" type="checkbox"
							value="" />
						</td>
						<td>
							<s:property value="pldno"/>
						</td>
						<td><s:property value="cusnm"/>
						</td>
						<td>
							<s:property value="house"/>	
						</td>
						<td><s:property value="scac"/>	
						</td>
						<td>
							<s:property value="etdate"/>	
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
						</td>
						<td>
							<s:property value="cmmt"/>
						</td>
						<td>
							<s:if test="ostat==05">
			  					<input type="button" id="editbtn" value="编辑" class="gray_button" onclick="goedit('<s:property value="pldno"/>');"/>
			  					<input type="button" id="deletebtn" value="删除" class="gray_button" onclick="godelete('<s:property value="pldno"/>');"/>
			  				
			  				</s:if>
			  				<s:else>
			  					<input type="button" id="printbtn" value="打印" class="gray_button" onclick="goPrint('<s:property value="pldno"/>');"/>
			  				</s:else>
						</td>
							
						</tr>
					</s:iterator>
					
			  </table>
			  <div class="page">
		  			<page:paginator formName="queryform" nameInRequest="paginator"/>
				</div>
			  </div>
			</div>
		</div>
		
	</s:form>

</body>
<script type="text/javascript">
	// 全选
	function selectall(self){
		var cba = self;
		var bool = false;
		if (self.checked) {
			bool = true;
		}
		
		var cbs = document.getElementsByName("cb");
		for(var i=0;i<cbs.length;i++){
			cbs[i].checked = bool;
		}
	}
	
	// 子选项
	function subselectall(){
		var cba = document.getElementsByName("cba")[0];
		var cbs = document.getElementsByName("cb");
		var count = cbs.length;
		
	    var selectCount = 0;
	    for (var i = 0; i < count; i++) {
	        if (cbs[i].checked == true) {
	            selectCount++;
	        }
	    }
	    if (count == selectCount) {
	       	cba.checked = true;
	    } else {
        	cba.checked = false;
	    }
	}
	function createNotice(){
		window.open("sales!toCreateNotice.action",'newwindow','height=900, width=1044, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
	
	}
	function godelete(pldno){
		//alert(pldno);
		$.ajax( {  
		       url:'zplhdrs!toDeleteZplhdr.action',// 跳转到 action  
		       data:{  
		                pldno : pldno
		       },  
		      type:'post',  
		      cache:false,  
		      success:function(data) { 
		      	//var json = $.parseJSON(data);
		        //alert(data); 
		       // document.getElementById("info").innerHTML=json.retStr;
		       //	if(data=="success"){
		       		alert("删除通知单成功");
		       		document.forms[0].submit();
		       //	}else{
		       	//	alert("删除通知单失败！");  
		       	//}
		       },  
		       error : function() {  
		            // view("异常！");  
		            alert("删除通知单失败！");  
		       }  
		  });
	}
	// 打印
	function goPrint(pldno){//alert(pldno);
		window.open("zplhdrs!toPrintOne.action?pldno="+ pldno,"newwindow","height=600,width=1024,top=60,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no");
	}
	// 编辑
	function goedit(pldno){//alert(pldno);
		window.open("zplhdrs!toEditZplhdr.action?pldno="+ pldno,"newwindow","height=600,width=1024,top=60,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no");
	}
</script>
</html>
