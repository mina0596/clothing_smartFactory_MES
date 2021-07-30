	
$(function(){
	$('.searchContractCode').click(function(){
		$('#contractCodeModal').modal("show");
	});
	$('[data-popup-open]').on('click', function(e)  {
        var targeted_popup_class = jQuery(this).attr('data-popup-open');
        $('[data-popup="' + targeted_popup_class + '"]').fadeIn(350);

        e.preventDefault();
    });

    //----- CLOSE
    $('[data-popup-close]').on('click', function(e)  {
        var targeted_popup_class = jQuery(this).attr('data-popup-close');
        $('[data-popup="' + targeted_popup_class + '"]').fadeOut(350);

        e.preventDefault();
    });
			
	//날짜 포맷변경하는 함수
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
			
	var tbl = $('#searchContractTable');
	var param = [];
			
	//모달에서 검색버튼
	$('#searchContractCodeBtn').click(function(){
		$('.removeTr').remove();
		var thList = $(this).parents('thead').children().find('th');
		var inputList = thList.find('input');
		
		var data = {
					clientCode : $('#clientCode').val(),
					clientName : $('#clientName').val(),
					requestRegDateFrom : $('#requestRegDateFrom').val(),
					requestRegDateTo : $('#requestRegDateTo').val(),
					contractCode : $('#contractCode').val(),
					contractAcceptCheck : $('#contractAcceptCheck').val()
				}
		
		
		var request = $.ajax({
			url: "/production/searchContractCodeModal",
			method: "POST",
			traditional: true,
			data: JSON.stringify(data),
			contentType: 'application/json',
			dataType: "json"	
		}); 
		
		//ajax결과값
		var html = '';
		request.done(function( clientNameResultList ) {
			console.log(clientNameResultList);
			if(clientNameResultList.length > 0){
				for(var i=0; i < clientNameResultList.length; i++){
					html += '<tr class="removeTr">';
					html += '<td><input type="radio" name="clientNameCheck">';
					html += '</td>';
					html += '<td name="clientNameCheck" class="clientName">';
					html += clientNameResultList[i].clientName;						
					html += '</td>';
					html += '<td name="clientNameCheck" class="clientCode">';
					html += clientNameResultList[i].clientCode;						
					html += '</td>';
					html += '<td name="clientNameCheck">';
					html += clientNameResultList[i].approvalStatus;						
					html += '</td>';
					html += '<td name="clientNameCheck">';
					html += formatDate(clientNameResultList[i].regDate);						
					html += '</td>';
					html += '<td name="clientNameCheck" class="contractCode">';
					html += clientNameResultList[i].contractCode;						
					html += '</td>';
					html += '<td name="clientNameCheck" class="pCode">';
					html += clientNameResultList[i].pCode;						
					html += '</td>';
					html += '</tr>';
				}
			}else{
				$('.removeTr').remove();
				html += '<tr class="removeTr"><td colspan="15" style="text-align: center;"> 검색된 결과가 없습니다. </td></tr>';
			}
			$('#searchResultTbody').append(html);
			
		});
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});	

	});
	
	//modal에서 선택한 거래처명 주인화면으로 가져와서 입력해주기
	$('.getContractCode').click(function(){
		var checkedClientName = $('[name=clientNameCheck]:checked').parent().parent().find('.clientName').text();
		var checkedContractCode = $('[name=clientNameCheck]:checked').parent().parent().find('.contractCode').text();
		var checkedPCode = $('[name=clientNameCheck]:checked').parent().parent().find('.pCode').text();
		$('#searchedClientName').attr('value', checkedClientName);
		$('#searchedContractCode').attr('value', checkedContractCode);
		$('#searchedPCode').attr('value', checkedPCode);
		$("input[type=radio]:checked").attr('checked',false);
		$('#searchContractTable').find('input[type=text]').val('');
		$('#searchContractTable').find('input[type=date]').val('');
		$('.removeTr').remove();
	});

			
});