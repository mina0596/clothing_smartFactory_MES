/**
 * 
 */

$(function(){
	
	$('#searchBtn').click(function(){
		var suitType = $('#suitType').children(':selected');
		var productType = $('#productType').children(':selected');
		var dateType = $('#dateType').children(':selected');

		var selectedFromDate = $('#fromDate').val();
		var selectedToDate = $('#toDate').val();
		
		if(selectedToDate != null && selectedToDate != undefined && selectedToDate != "" && selectedToDate < selectedFromDate){
			alert('뒤의 날짜가 더 빠릅니다. 날짜를 확인해주세요');
		}
		
		//검색창에서 입력받은 값들
		var searchKeyAndValue = {
			suitType : suitType.val(),
			productType : productType.val(),
			DateType : dateType.val(),
			fromDate : selectedFromDate,
			toDate : selectedToDate,
			clientName : $('#searchedClientName').val(),
			clientCode : $('#searchedClientCode').val()
		}
		console.log(searchKeyAndValue);
		
		var request = $.ajax({
			url: "/production/searchProductToStart",
			method: "post",
			traditional: true,
			data: JSON.stringify(searchKeyAndValue),
			contentType: 'application/json',
			dataType: "json"
		});
		
		request.done(function(productToStartResult){
			console.log(productToStartResult);
			if(productToStartResult.length > 0){
				for(var i=0; i < productToStartResult.length; i++){
					
				}
			}
		});
		
		request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
		});	
	});
	
	
	
	
	
})
