$(document).ready(function(){
		$.extend({ 
			  password: function (length, special) {
			    var iteration = 0;
			    var password = "";
			    var randomNumber;
			    if(special == undefined){
			        var special = false;
			    }
			    while(iteration < length){
			        randomNumber = (Math.floor((Math.random() * 100)) % 94) + 33;
			        if(!special){
			            if ((randomNumber >=33) && (randomNumber <=47)) { continue; }
			            if ((randomNumber >=58) && (randomNumber <=64)) { continue; }
			            if ((randomNumber >=91) && (randomNumber <=96)) { continue; }
			            if ((randomNumber >=123) && (randomNumber <=126)) { continue; }
			        }
			        iteration++;
			        password += String.fromCharCode(randomNumber);
			    }
			    return password;
			  }
			});
		$("#defaultPassInput").click(function(){
			$("[name=defaultPass]").attr("value",$.password(6,false));
			$("#upId").val($("#dfId").val());
			$("#ppId").val($("#dfId").val());
		});

		
});