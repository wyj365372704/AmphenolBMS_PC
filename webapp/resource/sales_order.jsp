<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>销售出货单</title>

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
	<s:form action="allotted!tofindAllotted.action" method="post" name="queryform">

		<div class="path">您现在的位置： 首页 &gt; 仓库 &gt; 销售出货单</div>
		
			<div class="search">
			<h2>
				<span class="fl">销售订单查询</span>
				<span class="fr">
					<s:submit id="queryId" value="" cssClass="search_button" onclick="return dosubmit()"></s:submit>
					<s:reset value="" cssClass="purge_button"></s:reset>
				</span><!--  span里无内容时，此span不能删除  -->
			</h2>
			
			<ul>
				
				<li class="myli"><div class="w_s">仓库：</div>
					<select id="warehouse" style="width:60px">
						<option value="">-</option>
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
					</select>					
				</li>
				
				<li class="mylirt"><div class="w_s">客户：</div>
					<s:textfield name="customer" cssClass="input_w"/>
				</li>
				
				<li><div class="w_s">订单号：</div>
	            	<s:textfield name="orderno" cssClass="input_w"/>
	            </li>
	        
	            <li><div class="w_s">计划出货日期：</div> 
	            	<s:textfield  id="startDate" name="startDate" cssClass="time_input" onclick="WdatePicker()" autocomplete="on"/>
	            	-
            		<s:textfield  id="endDate" name="endDate" cssClass="time_input" onclick="WdatePicker()" autocomplete="on"/>
            	</li>
            	
            	
				
				<li><div class="w_s">客户PO：</div>
	            	<s:textfield name="customerpo" cssClass="input_w"/>
	            </li>
            
				<li class="mybtnsch">
					<input type="button" cssClass="search_button"  onclick="myPrint()" value="生产销售出货通知单">
				</li>
			</ul>
		</div>
		
		<div class="data_list">
			<h2>
				<span class="fl">销售订单列表</span>
				<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
			</h2>
			
			<div class="list_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0" class="list_table_s">
				  <tr>
					<th><input type="checkbox" name="cba" onclick="selectall(this)" />选择</th>
					<th>客户编码</th>
					<th>客户名称</th>
					<th>计划员</th>
					<th>订单号</th>
					<th>行号</th>	
					<th>产品</th>
					<th>产品描述</th>
					<th>订货量</th>
					<th>已出货量</th>
					<th>库存量</th>
					<th>未出货量</th>
				  </tr>
  				 <tr class="td_bgcolor">
		      		<td><input type="checkbox" name="cb" value="123" onclick="subselectall()" /></td>
	  				<td>AMCU00340</td>
	  				<td>TCL（深圳）</td>
	  				<td>Jack</td>
	  				<td>T00052400</td>
	  				<td>1</td>
	  				<td>CGT903456</td>
	  				<td>YG63446654</td>
	  				<td>2000</td>
	  				<td>1000</td>
	  				<td>30000</td>
	  				<td>29000</td>
  			   </tr>
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
	
	// 打印
	function myPrint(){
		// 检查是否选中记录
		var cbs = document.getElementsByName("cb");
		if( !cbs ){
			alert("未选中记录！");
			return;
		}
		
		var gno = new Array();
		var count = 0;
		cbs.forEach(function(p) {
			if( !p.checked){
				bool = false;
			} else {
				count ++;
				var str = p.value.substring(0,p.value.indexOf('-'));
				gno.push($.trim(str));
			}
		})
		
		if( count <= 0 ){
			alert("未选中记录！");
			return;
		}

		var grnnos = JSON.stringify({
			grnnos: gno
		});
		
		window.open('allotted!toPrintAllotted.action?grnno='+ grnnos,'newwindow','height=600,width=800,top=60,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	}
</script>
</html>
