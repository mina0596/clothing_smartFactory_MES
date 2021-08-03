/**
 * 
 */
$(function(){
	$('.searchInspectionResult').hide();
	
	var bySupplierValue = $('#bySupplierValue');
	var clientName =$('#clientName');

	
	$('#searchBtn1').click(function(){
		$('.searchInspectionResult').show();
		$('.stateContractInspectionList').hide();
		$('.searchState').submit();
			
			
		
	});
});
