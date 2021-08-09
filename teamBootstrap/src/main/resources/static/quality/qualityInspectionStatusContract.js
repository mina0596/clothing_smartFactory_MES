/**
 * 
 */
$(function(){
	
	var searchStateInspectionForm = $('#searchState');
	var contactNumber =$('#contactNumber');
	var contactCode =$('#contactNumber').val();
	var clientName =$('#clientName');
	
	 
	
	$('#searchBtn1').click(function(){
		
		if(contactNumber.val()==''){
			alert('계약번호를입력해주세요');
			contactNumber.focus();
			
		}else if(clientName.val()==''){
			alert('거래처명을 입력해주세요');
			clientName.focus();
			submitFlag=false;
			return submitFlag;
		}else{
			submitFlag= true;
			if(submitFlag)searchStateInspectionForm.submit();
		}
		
		
	});
	
});
