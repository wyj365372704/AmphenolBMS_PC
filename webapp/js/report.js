function viewEvaluation(evalId) {
	window.open('viewEvaluation.action?evalId='+evalId,'','dialogWidth=400px,dialogHeight=60000px,toolbar=no,menubar=no,scrollbars=no, location=no, status=no');
}
function checkSubmit(){
    var dateStart = strDateTime($("#startDate").val());
    var dateEnd =   strDateTime($("#endDate").val());
    if(dateStart && dateEnd){
        if(!dataCheck($("#startDate").val(),$("#endDate").val())) {
           jAlert('warning', '开始日期不能晚于结束日期！', '提示');
           return false;
         } else{
        	 if($("[name=pageSize]").length > 0){
                 return dosubmit();
        	 }else{
        		 return true;
        	 }
         }
    }else{
        jAlert('warning', '日期格式不合法,请重新输入!', '提示');
        return false;
    }
}
function dataCheck(starttime,endtime){
    var starttimes = starttime.split("-");
    var endtimes = endtime.split("-");
    var starttimeTemp = starttimes[0] + "/" + starttimes[1] + "/" + starttimes[2];
    var endtimesTemp = endtimes[0] + "/" + endtimes[1] + "/" + endtimes[2];

    if(Date.parse(new Date(starttimeTemp))>Date.parse(new Date(endtimesTemp))) {
      return false;
    } 
    return true;
}
function strDateTime(str)
{   
   if(str=='') return true;
   var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
   if(r==null)return false;
   var d= new Date(r[1], r[3]-1, r[4]);
   return (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]);
}
function ajaxCommit(url, obj) {
    var rtnobj;
    $.ajax({
                url : url,
                type : 'post',
                data : obj,
                async : false,
                dataType : 'json',
                cache : false,
                error : function() {
                    return '';
                },
                success : function(data) {
                    rtnobj = data;
    
                }
            });
    return rtnobj;
}
function listOrgByCustomsId() {
    $("#orgId").empty();
    $("#orgId").append("<option value=''>全部</option>");
    $("#windowId").empty();
    $("#windowId").append("<option value=''>全部</option>");
    if($("#customsId").val()!="") {
		$.ajax({
        	type: "POST",
        	url: "../org/org!getChildOrg.action",
        	data: {"org.orgId":$('#customsId').val()},
        	success:function(data){
        		if(data!=""&&data!=null){
	        		var dataObj = eval("("+data+")");
	        		$.each(dataObj.data,function(idx,item){
	        			var value = item.value;
	                    var label = item.label;
	                    $("#orgId").append("<option value='"+value +"'>"+label +"</option>");
	        		});
        		}
        	},
        	cache: false
        });
    	
        
    }
}
function listOrgByCustomsId_bak() {
    $("#orgId").empty();
    $("#orgId").append("<option value=''>全部</option>");
    $("#windowId").empty();
    $("#windowId").append("<option value=''>全部</option>");
    if($("#customsId").val()!="") {
        var param={"customsId":$('#customsId').val()};
        var obj=ajaxCommit('../report/listOrgByCustomsId.action',param);
        for(var i=0;i<obj.length;i++){
            if(obj[i].orgId!=null){
                $("#orgId").append("<option value='"+obj[i].orgId +"'>"+obj[i].orgName +"</option>");
            }
        }
        
    }
}
function listWindowListByOrgId() {
    $("#windowId").empty();
    $("#windowId").append("<option value=''>全部</option>");
    if($("#orgId").val()!="") {
        var param={"orgId":$('#orgId').val()};
        var obj=ajaxCommit('../report/listWindowListByOrgId.action',param);
        for(var i=0;i<obj.length;i++){
            if(obj[i].id!=null){
                $("#windowId").append("<option value='"+obj[i].id +"'>"+obj[i].name +"</option>");
            }
        }
        
    }
}
function listServiceListByCustomsId() {
    $("#serviceId").empty();
    $("#serviceId").append("<option value=''>全部</option>");
    var customsId = $("#customsId").val();
    if(customsId==""){
    	customsId="0";
    }
    //if($("#customsId").val()!="") {
        var param={"customsId":customsId};
        var obj=ajaxCommit('../report/listServiceListByCustomsId.action',param);
        for(var i=0;i<obj.length;i++){
            if(obj[i].id!=null){
                $("#serviceId").append("<option value='"+obj[i].id +"'>"+obj[i].name +"</option>");
            }
        }
        
    //}
}
$(function(){
    $("#customsId").change(function(){
    	var ddd = $("#orgId");
    	if($("#orgId").length > 0){
        	listOrgByCustomsId();
    	}
    	if($("#serviceId").length > 0){
    		listServiceListByCustomsId();
    	}
    });
    $("#orgId").change(function(){
    	listWindowListByOrgId();
    });
    
    
	if($("#customsId option").length == 2){
		$("#customsId option:first").remove();
	}
	if($("#orgId option").length == 2){
		$("#orgId option:first").remove();
	}
	if($("#serviceId").length > 0){
		var serviceIdValue = $("#serviceIdValue").val();
		listServiceListByCustomsId();
		$("#serviceId").val(serviceIdValue);
	}
});