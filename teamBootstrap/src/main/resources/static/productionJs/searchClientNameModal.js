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
				jQuery.ajaxSettings.traditional = true;

				console.log("jsonData 직렬화시킨거" + jsonData);
				var request = $.ajax({
					url: "/production/searchOrderProductionProcess",
					method: "POST",
					data: { "param" : jsonData },
					dataType: "json"
					
				}); 
				request.done(function( data ) {
					console.log(data);
					for(i=0; i<data.length; i++){
						var date =  data[i].inspection_request_date;
						//date 포맷 변경 yyyy-MM-dd hh:mm:ss
						function formatDate(date) {
							var d = new Date(date),
							month = '' + (d.getMonth() + 1),
							day = '' + d.getDate(),
							year = d.getFullYear(),
							hour = d.getHours(),
							min = d.getMinutes(),
							sec = d.getSeconds();
							
							if (month.length < 2) month = '0' + month;
							if (day.length < 2) day = '0' + day;
							
							return [year, month, day].join('-') + ' ' + [hour, min, sec].join(':');
						}
						
						var dateText = "/Date(1519794794410)/";
						var myDate = new Date(dateText.match(/\d+/) * 1);
						date = formatDate(myDate);
						
				});
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});	
				
			});
			
			
								
	
			
});