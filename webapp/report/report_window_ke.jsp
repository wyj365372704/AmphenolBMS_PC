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
    <link href="../css/report.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="../js/report.js"></script>
<script type="text/javascript">

</script>
<title>易网通用户中心</title>

<link href="../css/global.css" rel="stylesheet" type="text/css" />
</head>

<body class="right_body">
<s:form action="listWindowKe.action" method="post" name="queryform" >


    <div class="path">您现在的位置： 首页 &gt; 统计查询 &gt; 窗口科级评价汇总</div>
    
    
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
            <li><div class="w_s">评价器类型：</div>
            <s:select name="map.evalType" cssClass="select_s_2" list="#{'0':'按键式','1':'触摸式'}" listKey="key" listValue="value"  headerKey="" headerValue="全部"></s:select>
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
                <th rowspan="2">关区</th>
                <th rowspan="2">科室</th>
                <th colspan="4">次数</th>
                <th colspan="4">占比</th>
                <th rowspan="2">评价总次数</th>
                <th rowspan="2">未评价次数</th>
                <th rowspan="2">评价率</th>
                <th rowspan="2">满意度</th>
              </tr>
              <tr>
                <th>非常满意</th>
                <th>满意</th>
                <th>基本满意</th>
                <th>不满意</th>
                <th>非常满意</th>
                <th>满意</th>
                <th>基本满意</th>
                <th>不满意</th>
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
                <td><s:property value="verysatisfied"/></td>
                <td><s:property value="satisfied"/></td>
                <td><s:property value="basicsatisfied"/></td>
                <td><s:property value="notsatisfied"/></td>
                <td><s:property value="verysatisfiedRate"/>%</td>
                <td><s:property value="satisfiedRate"/>%</td>
                <td><s:property value="basicsatisfiedRate"/>%</td>
                <td><s:property value="notsatisfiedRate"/>%</td>
                <td><s:property value="eval"/></td>
                <td><s:property value="uneval"/></td>
                <td><s:property value="evalDegree"/>%</td>
                <td><s:property value="satisfiedDegree"/>%</td>
              </tr>
              </s:iterator>
              <tr id="reporttotal">
                <td colspan="2">总计</td>
                <td><s:property value="totalMap.verysatisfied"/></td>
                <td><s:property value="totalMap.satisfied"/></td>
                <td><s:property value="totalMap.basicsatisfied"/></td>
                <td><s:property value="totalMap.notsatisfied"/></td>
                <td><s:property value="totalMap.verysatisfiedRate"/>%</td>
                <td><s:property value="totalMap.satisfiedRate"/>%</td>
                <td><s:property value="totalMap.basicsatisfiedRate"/>%</td>
                <td><s:property value="totalMap.notsatisfiedRate"/>%</td>
                <td><s:property value="totalMap.eval"/></td>
                <td><s:property value="totalMap.uneval"/></td>
                <td><s:property value="totalMap.evalDegree"/>%</td>
                <td><s:property value="totalMap.satisfiedDegree"/>%</td>
              </tr>
          </table>
          
          
    </div>
    </div>
    

</s:form>
</body>
</html>