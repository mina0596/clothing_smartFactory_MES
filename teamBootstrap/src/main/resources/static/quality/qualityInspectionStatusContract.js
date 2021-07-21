/**
 * 
 */
$(function(){
	$('.searchInspectionResult').hide();
	
	$('#searchBtn1').click(function(){
		var html='';
		var array={
				bySupplierValue:$('#bySupplierValue').val()
				,clientName:$('#clientName').val()
				,inspectionStartDate:$('#inspectionStartDate').val()
				,inspectionEndDate:$('#inspectionEndDate').val()
				,requestProduct:$('#requestProduct').val()
				,InspectionCode:$('#inspectionCode').val()
				,inspectionClassName:$('#inspectionClassName').val()
		};
		console.log(array)
		var request = $.ajax({
			url: "/quality/searchQualityInspection",
			method: "get"
			type: "post",
			data: array,
			dataType: "json"	

		}); 
		request.done(function( data ) {
			$('.searchInspectionResult').show();
		
		});
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});	
	});
});
