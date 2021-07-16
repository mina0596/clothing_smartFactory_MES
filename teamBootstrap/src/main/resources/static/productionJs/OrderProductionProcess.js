/**
 * 
 */

$(function(){
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
	var dateText = "/Date(1519794794410)/";
	var myDate = new Date(dateText.match(/\d+/) * 1);
	date = formatDate(myDate);
	
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
		
		var html = '';
		request.done(function(productToStartResult){
			console.log(productToStartResult);
			if(productToStartResult.length > 0){
				for(var i=0; i < productToStartResult.length; i++){
					html += '<tr class="removeTr">';
					html += '<td class="productCode">';
					html += productToStartResult[i].productCode;						
					html += '</td>';
					html += '<td class="suitType">';
					html += productToStartResult[i].suitType;						
					html += '</td>';
					html += '<td class="productType">';
					html += productToStartResult[i].productType;						
					html += '</td>';
					html += '<td class="clientName">';
					html += productToStartResult[i].clientName;						
					html += '</td>';
					html += '<td class="processCode">';
					html += productToStartResult[i].processCode;						
					html += '</td>';
					html += '<td class="processName">';
					html += productToStartResult[i].highClassName;						
					html += '-';						
					html += productToStartResult[i].lowClassName;						
					html += '</td>';
					html += '<td class="processStartDate">';
					html += formatDate(productToStartResult[i].processStartDate);					
					html += '</td>';
					//if(productToStartResult[i].processFinishDate == ''){}
					html += '<td class="processFinishDate">';
					html += formatDate(productToStartResult[i].processFinishDate);					
					html += '</td>';
					html += '<td class="processStatus">';
					html += productToStartResult[i].processStatus;						
					html += '</td>';
					html += '</tr>';
				}
			}else{
				$('.removeTr').remove();
				html += '<tr class="removeTr"><td colspan="15" style="text-align: center;"> 검색된 결과가 없습니다. </td></tr>';
			}
			$('#resultTableBody').append(html);
		});
		
		request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
		});	
	});
	
	
	
	
	
})
