$(function(){
	//表格多选框全选
	$(".cba").on("click", function() {
		console.log($(this));
	    if ($(this).prop("checked")) {
	        $(".cb").prop("checked", true);
	    } else {
	        $(".cb").prop("checked", false);
	    }
	});
	
	//当选中所有的时候，全选按钮会勾上
	$(".cb").on("click", function() {
		console.log($(this));
	    var obj = $('.cb');
	    var count = obj.length;
	    var selectCount = 0;
	    for (var i = 0; i < count; i++) {
	        if (obj[i].checked == true) {
	            selectCount++;
	        }
	    }
	    if (count == selectCount) {
	        $(".cba").prop("checked", true);
	    } else {
	        $(".cba").prop("checked", false);
	    }
	});
});