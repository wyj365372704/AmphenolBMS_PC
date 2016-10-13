
var errorMessge;
var menu=1;
var noSubmit=false;
$(function(){

	//input action
	
	$("form").submit(function(){
	if(noSubmit)
		return true;
	var isSubmit = true;
		errorMessge="";
		menu=1;
		$(this).find("[reg],[url]:not([reg])").each(function(){
			var value=$(this).val();
			$(this).val(value.replace(/(^\s*)|(\s*$)/g, ""));
			if($(this).attr("reg") == undefined){
				if(!ajax_validate($(this))){
					isSubmit = false;
				}
			}else{
				if(!validate($(this))){
				 	errorMessge=errorMessge+menu+"."+$(this).attr('tip')+'\n';
				 	menu++;
					isSubmit = false;
					
				}
			}
		});
		if(typeof(isExtendsValidate) != "undefined"){
		if(isExtendsValidate)
			var extendSumbit=extendsValidate();	
			if(!extendSumbit)
				isSubmit=false;			
   			if(isSubmit && extendSumbit){
		 		//用户新增和修改的时候将roleIds原本值如:111(roleId)-222(orgId)还原为111
				$("[name='roleIds']:checked").each(function(){
					var arr=$(this).val().split("-");
					$(this).val(arr[0]);
				});
				return true;
			}		
   		}
   		if(errorMessge!=""){
 			jAlert('warning', errorMessge, '提示');
 		}
		return isSubmit;
	});
	
});

function validate(obj){
	var reg = new RegExp(obj.attr("reg"));
	var objValue = obj.attr("value");
	
	if(!reg.test(objValue)){
		change_error_style(obj,"add");
		change_tip(obj,null,"remove");
		return false;
	}else{
		if(obj.attr("url") == undefined){
			change_error_style(obj,"remove");
			change_tip(obj,null,"remove");
			return true;
		}else{
			return ajax_validate(obj);
		}
	}
}

function change_tip(obj,msg,action_type){
	
	if(obj.attr("tip") == undefined){
		obj.attr("is_tip_null","yes");
	}
	if(action_type == "add"){
		if(obj.attr("is_tip_null") == "yes"){
			obj.attr("tip",msg);
		}else{
			if(msg != null){
				if(obj.attr("tip_bak") == undefined){
					obj.attr("tip_bak",obj.attr("tip"));
				}
				obj.attr("tip",msg);
			}
		}
	}else{
		if(obj.attr("is_tip_null") == "yes"){
			obj.removeAttr("tip");
			obj.removeAttr("tip_bak");
		}else{
			obj.attr("tip",obj.attr("tip_bak"));
			obj.removeAttr("tip_bak");
		}
	}
}

function change_error_style(obj,action_type){
	if(action_type == "add"){
		obj.addClass("input_validation-failed");
	}else{
		obj.removeClass("input_validation-failed");
	}
}

$.fn.validate_callback = function(msg,action_type,options){
	this.each(function(){
		if(action_type == "failed"){
			change_error_style($(this),"add");
			change_tip($(this),msg,"add");
		}else{
			change_error_style($(this),"remove");
			change_tip($(this),null,"remove");
		}
	});
};
