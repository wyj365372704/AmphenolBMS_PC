<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>周转标签</title>

<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
</head>
<style type="text/css">
.mybtnsch {
	margin-left: 10px !important;
}
</style>

<body class="right_body">

	<s:form action="turnover!toTurnoverList.action" method="post" name="queryform">
		<div class="path">您现在的位置： 首页 &gt; 生产 &gt; 打印物料识别卡</div>
		<div class="search">
			<h2>
				<span class="fl">周转查询</span> 
				<span class="fr"> 
				<s:submit id="queryId" value="" cssClass="search_button"
						onclick="return dosubmit()"></s:submit> <s:reset value=""
						cssClass="purge_button"></s:reset>
				</span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>
				<ul>
			
			<li><div class="w_s">仓库：</div>
			
			<s:select name="momast.fitwh" list="#session.houses" listKey="house" listValue="house"   cssClass="select_s_2" style="width:60px"></s:select>
			</li>
			
			<li><div class="w_s">产品：</div>
				<s:textfield name="momast.fitem" cssClass="input_w"/>
			</li>
			<li><div class="w_s">部门：</div>
				<s:textfield name="momast.dptno" cssClass="input_w"/>
			</li>
			 <li><div class="w_s">开工日：</div>
            <s:textfield  id="startDate" name="momast.startDate" cssClass="time_input" onclick="WdatePicker()" autocomplete="on"/>-
            <s:textfield  id="endDate" name="momast.endDate" cssClass="time_input" onclick="WdatePicker()" autocomplete="on"/>
            </li>
            
            <li><div class="w_s">工单：</div>
				<s:textarea  name="momast.ordno" cssClass="input_w" style="height:30px" ></s:textarea>
			</li>
		</ul>
		</div>
		<div class="data_list">
			<h2>
				<span class="fl">周转列表</span> 
				<span class="fr"></span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>
			<div class="list_inner">
			<table width="100%" border="0" cellspacing="1" cellpadding="0" class="list_table_s">
			  <tr>
				<th>单号</th>
				<th>产品</th>
				<th>描述</th>
				<th>数量</th>
				<th>单位</th>
				<th>部门</th>
				<th>开始日期</th>
				<th>完工日期</th>
				<th>状态</th>
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
	  				<td><s:property value="ordno"/></td>
	  				<td><s:property value="fitem"/></td>
	  				<td><s:property value="fdesc"/></td>
	  				<td><s:property value="moqty"/></td>
	  				<td><s:property value="unmsr"/></td>
	  				<td><s:property value="dptno"/></td>
	  				<td><s:property value="ssstdt"/></td>
	  				<td><s:property value="sodudt"/></td>
	  				<td>
	  				<s:if test="ostat==10">
	  					已下达
	  				</s:if>
	  				<s:elseif test="ostat==40">
	  					已开始生产
	  				</s:elseif>
	  				<s:elseif test="ostat==45">
	  					物料完成
	  				</s:elseif>
	  				<s:elseif test="ostat==50">
	  					工序完成
	  				</s:elseif>
	  				<s:elseif test="ostat==55">
	  					物料/工序完成
	  				</s:elseif>
	  				<s:elseif test="ostat==99">
	  					订单取消
	  				</s:elseif>
	  				</td>
	  				<td><s:property value="qtyrc"/></td>
	  				<td><s:property value="mounqty"/></td>
	  				<td><input type="button" Class="gray_button" value="打印"
							onclick="print('<s:property value="ordno"/>','<s:property value="fitem"/>','<s:property value="fdesc"/>'
							,'<s:property value="moqty"/>','<s:property value="unmsr"/>','<s:property value="weght"/>'
							,'<s:property value="b2cqcd"/>')"></td>
  			   </tr>
  			</s:iterator>
		  </table>
		    <div class="page"><page:paginator formName="queryform" nameInRequest="paginator"/>
		  </div>
		</div>
		</div>
	</s:form>

</body>

<script type="text/javascript">
	function print(ordno, fitem,fdesc,moqty,unmsr,weght,b2cqcd) {
		window.open('turnover!toTurnoverTag.action?ordno=' + ordno + '&fitem=' + fitem+ '&fdesc=' + fdesc+ '&moqty=' + moqty
		+ '&unmsr=' + unmsr + '&weght=' + weght+ '&b2cqcd=' + b2cqcd, 'newwindow', 'height=500,width=600,top=60,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	}
</script>
</html>