/**
 * 
 */
$(function(){
	
	var request = $.ajax({
		url: "/production/getProgressBar",
		method: "post",
		dataType: "json"
	});
	
	request.don(function(progressBarPercentage){
		console.log("progressBarPercentage");
	})
	
	for(var i=0; tbodyTr.length; i++){
				var percent = $(this).children().find('.percentage');
				console.log(percent);
				$(this).children().find('.progress-bar').width(percent);				
			}

			console.log(tbodyTr);
			//$('.percentage').val();
			
			//$('.progress-bar').width(percent);

	
	
	
	
	
	
	
})		