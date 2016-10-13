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


    <div class="path">您现在的位置： 首页 &gt; 统计查询 &gt; 评价详细信息</div>
    
    
    <div class="data_list">
        <h2>
            <span class="fl">评价详细信息</span>
            <span class="fr"></span><!--  span里无内容时，此span不能删除  -->
        </h2>
        
        <div class="list_inner">
            <table width="100%" border="0" cellspacing="1" cellpadding="0" class="public_table">
              <tr>
                <td class="td_w_s text_r">关区：&nbsp;&nbsp;</td>
                <td>&nbsp;&nbsp;<s:property value="evalMap.customsName"/></td>
              </tr>
              <tr>
                <td class="td_w_s text_r">科室：&nbsp;&nbsp;</td>
                <td>&nbsp;&nbsp;<s:if test="evalMap.customsName==evalMap.orgName">-</s:if><s:else><s:property value="evalMap.orgName"/></s:else> </td>
              </tr>
              <tr>
                <td class="td_w_s text_r">窗口：&nbsp;&nbsp;</td>
                <td>&nbsp;&nbsp;<s:property value="evalMap.windowName"/></td>
              </tr>
              <tr>
                <td class="td_w_s text_r">关员：&nbsp;&nbsp;</td>
                <td>&nbsp;&nbsp;<s:property value="evalMap.userName"/></td>
              </tr>
              <tr>
                <td class="td_w_s text_r">评价器编号：&nbsp;&nbsp;</td>
                <td>&nbsp;&nbsp;<s:property value="evalMap.evalNo"/></td>
              </tr>
              <tr>
                <td class="td_w_s text_r">评价器：&nbsp;&nbsp;</td>
                <td>&nbsp;&nbsp;
                  <s:if test="evalMap.evalType==0">按键式</s:if>
                  <s:else>触摸式</s:else>
                </td>
              </tr>
              <tr>
                <td class="td_w_s text_r">触摸式评价类型：&nbsp;&nbsp;</td>
                <td>&nbsp;&nbsp;
                  <s:if test='evalMap.touchEvalType=="P"'>关员</s:if>
                  <s:elseif test='evalMap.touchEvalType=="W"'>窗口</s:elseif>
                  <s:elseif test='evalMap.touchEvalType=="S"'>业务</s:elseif>
                </td>
              </tr>
              <tr>
                <td class="td_w_s text_r">评价结果：&nbsp;&nbsp;</td>
                <td>&nbsp;&nbsp;
                  <s:if test="evalMap.evalResult==0">未评价</s:if>
                  <s:elseif test="evalMap.evalResult==1">不满意</s:elseif>
                  <s:elseif test="evalMap.evalResult==2">基本满意</s:elseif>
                  <s:elseif test="evalMap.evalResult==3">满意</s:elseif>
                  <s:elseif test="evalMap.evalResult==4">非常满意</s:elseif>
                </td>
              </tr>
              <tr>
                <td class="td_w_s text_r">评价建议：&nbsp;&nbsp;</td>
                <td>&nbsp;&nbsp;<s:property value="evalMap.evalSuggest"/></td>
              </tr>
              <tr>
                <td class="td_w_s text_r">评价时间：&nbsp;&nbsp;</td>
                <td>&nbsp;&nbsp;<s:date name='evalMap.evalTime' format='yyyy-MM-dd HH:mm:ss'/></td>
              </tr>
              <tr>
                <td class="td_w_s text_r">评价人姓名：&nbsp;&nbsp;</td>
                <td>&nbsp;&nbsp;<s:property value="evalMap.name"/></td>
              </tr>
              <tr>
                <td class="td_w_s text_r">评价人性别：&nbsp;&nbsp;</td>
                <td>&nbsp;&nbsp;<s:property value="evalMap.sex"/></td>
              </tr>
              <tr>
                <td class="td_w_s text_r">评价人身份证号：&nbsp;&nbsp;</td>
                <td>&nbsp;&nbsp;<s:property value="evalMap.idCardNo"/></td>
              </tr>
              <tr>
                <td class="td_w_s text_r">联系电话：&nbsp;&nbsp;</td>
                <td>&nbsp;&nbsp;<s:property value="evalMap.telephone"/></td>
              </tr>
          </table>

          
        </div>
    </div>
    <div class="button_div">
    <input type="button" onclick="history.go(-1)" class="return_button" name="back">
    </div>

</body>
</html>