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
				$(inputList).each(function(){
					idName.push($(this).attr('id'));
					idValue.push($(this).val());
				});
				console.log(idName);
				console.log(idValue);
				for(var i=0; i < idName.length; i++){
					var key = idName[i];
					param[key] = idValue[i];
				}
				console.log(param);
				
			});
			
			var jsonData = JSON.stringify(param);
			jQuery.ajaxSettings.traditional = true;

			var request = $.ajax({
				url: "/production/searchOrderProductionProcess",
				method: "POST",
				data: { param : jsonData },
				dataType: "json"
				
			}); 
			request.done(function( data ) {
				console.log(data);
				
			});
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});	
			
								
	
			
});