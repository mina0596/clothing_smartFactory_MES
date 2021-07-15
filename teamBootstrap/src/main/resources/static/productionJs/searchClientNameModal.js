/**
 * 
 */
			
		
$(function(){
	
			var searchClientTable = $('#searchClientTable');
			var searchByClientCode = searchClientTable.children().find('#clientCode').val();
			var searchByContractCode = searchClientTable.children().find('#contractCode').val();
			var searchByContractAcceptCheck = searchClientTable.children().find('#contractAcceptCheck').val();
			var param = [];
			var idName = [];
			var idValue = [];
			
			
			$('#modalSearchBtn').click(function(){
				var thList = $(this).parents('thead').children().find('th');
				var inputList = thList.find('input');
				console.log(inputList);
				
				var param = {
					clientCode : $('#clientCode').val(),
					requestRegDateFrom : $('#requestRegDateFrom').val(),
					requestRegDateTo : $('#requestRegDateTo').val(),
					contractCode : $('#contractCode').val(),
					contractAcceptCheck : $('#contractAcceptCheck').val()
				}
				
				
				console.log(param);
				var jsonData = JSON.stringify(param);
				console.log("jsonData 직렬화시킨거" + jsonData);
				var request = $.ajax({
					url: "/production/searchOrderProductionProcess",
					method: "POST",
					data: { "param" : jsonData },
					dataType: "json"
					
				}); 
				request.done(function( data ) {
					console.log(data);
					
				});
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});	
				
			});
			
			
								
	
			
});