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
		$('.removeTr').remove();
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
					html += '<td class="processOrderNum">';
					html += productToStartResult[i].processOrderNum;			
					html += '</td>';
					if(productToStartResult[i].processStartDate == '1111-11-11 11:11:11' && productToStartResult[i].processFinishDate == '1111-11-11 11:11:11'){
						html += '<td style="font-weight: bold; font-style: italic;">공정 대기중</td>';
						html += '<td style="font-weight: bold; font-style: italic;">공정 대기중</td>';
						html += '<td><button id="startProcess" class="btn btn-success btn-xs" type="button"><i class="fa fa-power-off"></i>공정시작</button></td>'
					}else if(productToStartResult[i].processStartDate != '1111-11-11 11:11:11' && productToStartResult[i].processFinishDate == '1111-11-11 11:11:11'){
						html += '<td class="processStartDate">';
						html += formatDate(productToStartResult[i].processStartDate);					
						html += '</td>';
						html += '<td style="font-weight: bold; font-style: italic;">공정 진행중</td>';
						html += '<td><button id="completeProcess" class="btn btn-danger btn-xs" type="button"><i class="fa fa-power-off"></i>공정마침</button></td>'
					}else if(productToStartResult[i].processStartDate != '1111-11-11 11:11:11' && productToStartResult[i].processFinishDate != '1111-11-11 11:11:11'){
						html += '<td class="processStartDate">';
						html += formatDate(productToStartResult[i].processStartDate);					
						html += '</td>';
						html += '<td class="processFinishDate">';
						html += formatDate(productToStartResult[i].processFinishDate);					
						html += '</td>';
						html += '<td></td>';
					}
					html += '</tr>';
				}
			}else{
				$('.removeTr').remove();
				html += '<tr class="removeTr"><td colspan="15" style="text-align: center;"> 검색된 결과가 없습니다. </td></tr>';
			}
			$('#resultTableBody').append(html);
			
			//공정이 진행중인 공정을 완료했을때의 버튼 + 누르면 그 다음 공정이 시작될 수 있게 insert가 되는 처리과정 
			$('#completeProcess').click(function(){
				console.log('공정을 시작해볼까요?');
				
				var selectedProductCode = $(this).parent().parent().find('.productCode').text();
				var selectedProcessCode = $(this).parent().parent().find('.processCode').text();
				console.log(selectedProductCode);
				
				var selectedProductInfo={
						requestedProductCode : selectedProductCode,
						productionProcessCode : selectedProcessCode
				}
				
				var request = $.ajax({
					url: "/production/stopProcessByProduct",
					method: "post",
					traditional: true,
					data: JSON.stringify(selectedProductInfo),
					contentType: 'application/json',
					dataType: "json"
				});
				
				request.done(function(data){
					console.log(data);
					location.reload();
					
				});
				
				request.fail(function( jqXHR, textStatus ) {
					alert( "공정마침버튼을 다시 눌러주세요." + textStatus );
				});
			})
			
			
			//공정시작 버튼을 누르면 현재시간으로 시작시간이 insert되는 처리과정
			$('#startProcess').click(function(){
				var selectedProductCode = $(this).parent().parent().find('.productCode').text();
				var selectedProcessCode = $(this).parent().parent().find('.processCode').text();
				
				var selectedProductInfo={
						requestedProductCode : selectedProductCode,
						productionProcessCode : selectedProcessCode
				}
				
				var request = $.ajax({
					url: "/production/startProcessByProduct",
					method: "post",
					traditional: true,
					data: JSON.stringify(selectedProductInfo),
					contentType: 'application/json',
					dataType: "json"
				});
				
				request.done(function(data){
					console.log(data);
					location.reload();
					
				});
				
				request.fail(function( jqXHR, textStatus ) {
					alert( "공정시작버튼을 다시 눌러주세요." + textStatus );
				});
				
				
			});
			
			
			
			
		});
		
		
		
		request.fail(function( jqXHR, textStatus ) {
					alert( "검색어들을 확인해주세요. " + textStatus );
		});	
		
	});
	
	
	
	
	
	
})
