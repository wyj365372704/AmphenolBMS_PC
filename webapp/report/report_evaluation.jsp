<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="../js/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
    <script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
    <script src="../js/common.js" type="text/javascript"></script>
    <link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
    <link href="../css/global.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="../js/report.js"></script>
<script type="text/javascript">

</script>
<title>易网通用户中心</title>

<link href="../css/global.css" rel="stylesheet" type="text/css" />
</head>

<body class="right_body">
<s:form action="listEvaluation.action" method="post" name="queryform" >


    <div class="path">您现在的位置： 首页 &gt; 统计查询 &gt; 评价明细列表查询</div>
    
    
    <div class="search">
        <h2>
            <span class="fl">统计查询</span>
            <span class="fr"><s:submit id="queryId" value="" cssClass="search_button" onclick="return checkSubmit()"></s:submit> <s:reset value="" cssClass="purge_button"></s:reset></span><!--  span里无内容时，此span不能删除  -->
        </h2>
        
        <ul>
            <li><div class="w_s">关区：</div>
                <s:select id="customsId" name="map.customsId" cssClass="select_s_2" list="customsList" listKey="orgId" listValue="orgName"  headerKey="" headerValue="全部"></s:select>
                </li>
            <li><div class="w_s">科室：</div>
            <s:select id="orgId" name="map.orgId" cssClass="select_s_2" list="orgList" listKey="orgId" listValue="orgName"  headerKey="" headerValue="全部"></s:select>
                </li>
            <li><div class="w_s">窗口：</div>
            <s:select id="windowId" name="map.windowId" cssClass="select_s_2" list="windowList" listKey="id" listValue="name"  headerKey="" headerValue="全部"></s:select>
                </li>
            <li><div class="w_s">评价结果：</div>
            <s:select name="map.evalResult" cssClass="select_s_2" list="#{'0':'未评价','1':'不满意','2':'基本满意','3':'满意','4':'非常满意'}" listKey="key" listValue="value"  headerKey="" headerValue="全部"></s:select>
                </li>
            <li><div class="w_s">评价器：</div>
            <s:select name="map.evalType" cssClass="select_s_2" list="#{'0':'按键式','1':'触摸式'}" listKey="key" listValue="value"  headerKey="" headerValue="全部"></s:select>
                </li>
            <li><div class="w_s">触摸式评价类型：</div>
            <s:select name="map.touchEvalType" cssClass="select_s_2" list="#{'P':'关员','W':'窗口','S':'业务'}" listKey="key" listValue="value"  headerKey="" headerValue="全部"></s:select>
                </li>
            <li><div class="w_s">统计时间：</div>
            <s:textfield  id="startDate" name="map.startDate" cssClass="time_input" onclick="WdatePicker()" autocomplete="off"/>-
            <s:textfield  id="endDate" name="map.endDate" cssClass="time_input" onclick="WdatePicker()" autocomplete="off"/>
            </li>
        </ul>
    </div>
    
    <div class="data_list">
        <h2>
            <span class="fl">统计结果</span>
            <span class="fr"></span><!--  span里无内容时，此span不能删除  -->
        </h2>
        
        <div class="list_inner">
            <table width="100%" border="0" cellspacing="1" cellpadding="0" class="list_table_s">
              <tr>
                <th>关区</th>
                <th>科室</th>
                <th>窗口</th>
                <th>关员</th>
                <th>评价器</th>
                <th>触摸式评价类型</th>
                <th>评价结果</th>
                <th>评价时间</th>
                <th>操作</th>
              </tr>
              <s:iterator value="list" status="st">
                <s:if test="#st.Even">
                    <tr class="td_bgcolor">
                </s:if>
                <s:else>
                    <tr class="td_bgcolor2">
                </s:else>
                <td><s:property value="customsName"/></td>
                <td><s:if test="customsName==orgName">-</s:if><s:else><s:property value="orgName"/></s:else></td>
                <td><s:property value="windowName"/></td>
                <td><s:property value="userName"/></td>
                <td>
                  <s:if test="evalType==0">按键式</s:if>
                  <s:else>触摸式</s:else>
                </td>
                <td>
                  <s:if test='touchEvalType=="P"'>关员</s:if>
                  <s:elseif test='touchEvalType=="W"'>窗口</s:elseif>
                  <s:elseif test='touchEvalType=="S"'>业务</s:elseif>
                </td>
                <td>
                  <s:if test="evalResult==0">未评价</s:if>
                  <s:elseif test="evalResult==1">不满意</s:elseif>
                  <s:elseif test="evalResult==2">基本满意</s:elseif>
                  <s:elseif test="evalResult==3">满意</s:elseif>
                  <s:elseif test="evalResult==4">非常满意</s:elseif>
                </td>
                <td><s:date name='evalTime' format='yyyy-MM-dd HH:mm:ss'/></td>
                <td><input name="" type="button" class="button_userlook" title="查看" onclick="javascript:location.href='viewEvaluation.action?evalId=<s:property value="evalId"/>'"/></td>
              </tr>
              </s:iterator>
              
          </table>
          
          <div class="page"><div class="page"><page:paginator formName="queryform" nameInRequest="paginator"/>
          </div>
          
        </div>
    </div>
    </div>
    

</s:form>
</body>
</html>