/**
 * 
 */
			
		
$(function(){
			
			var resultList = [];
			var searchClientTable = $('#searchClientTable');
			var searchByClientCode = searchClientTable.children().find('#clientCode').val();
			var searchByContractCode = searchClientTable.children().find('#contractCode').val();
			var searchByContractAcceptCheck = searchClientTable.children().find('#contractAcceptCheck').val();
			var param = [];

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
			
			
			$('#modalSearchBtn').click(function(){
				$('.removeTr').remove();
				var thList = $(this).parents('thead').children().find('th');
				var inputList = thList.find('input');
				console.log(inputList);
				console.log($('#requestRegDateFrom').val());
				data = {
					clientCode : $('#clientCode').val(),
					clientName : $('#clientName').val(),
					requestRegDateFrom : $('#requestRegDateFrom').val(),
					requestRegDateTo : $('#requestRegDateTo').val(),
					contractCode : $('#contractCode').val(),
					contractAcceptCheck : $('#contractAcceptCheck').val()
				}
				param.push(data);
				console.log(param);
				
				var request = $.ajax({
					url: "/production/searchContractCode",
					method: "POST",
					traditional: true,
					data: JSON.stringify(data),
					contentType: 'application/json',
					dataType: "json"	
				}); 
				
				
				//ajax결과값
				var html = '';
				request.done(function( contractCodeResultList ) {
					console.log(contractCodeResultList);
					if(contractCodeResultList.length > 0){
						for(var i=0; i < contractCodeResultList.length; i++){
							html += '<tr class="removeTr">';
							html += '<td><input type="radio" name="clientNameCheck">';
							html += '</td>';
							html += '<td name="clientNameCheck" class="clientName">';
							html += contractCodeResultList[i].clientName;						
							html += '</td>';
							html += '<td name="clientNameCheck" class="clientCode">';
							html += contractCodeResultList[i].clientCode;						
							html += '</td>';
							html += '<td name="clientNameCheck">';
							html += contractCodeResultList[i].approvalStatus;						
							html += '</td>';
							html += '<td name="clientNameCheck">';
							html += formatDate(contractCodeResultList[i].regDate);						
							html += '</td>';
							html += '<td name="clientNameCheck">';
							html += contractCodeResultList[i].contractCode;						
							html += '</td>';
							html += '<td name="clientNameCheck">';
							html += contractCodeResultList[i].pCode;						
							html += '</td>';
							html += '</tr>';
						}
					}else{
						$('.removeTr').remove();
						html += '<tr class="removeTr"><td colspan="15" style="text-align: center;"> 검색된 결과가 없습니다. </td></tr>';
					}
					$('#searchResultThead').append(html);
					
				});
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});	
				
			});
			
			
			//modal에서 선택한 거래처명 주인화면으로 가져와서 입력해주기
			$('.getContractCode').click(function(){
				var checkedClientName = $('[name=clientNameCheck]:checked').parent().parent().find('.clientName').text();
				var checkedClientCode = $('[name=clientNameCheck]:checked').parent().parent().find('.clientCode').text();
				$('#searchedClientName').attr('value', checkedClientName);
				$('#searchedClientCode').attr('value', checkedClientCode);
				$("input[type=radio]:checked").attr('checked',false);
				$('#searchClientTable').find('input[type=text]').val('');
				$('#searchClientTable').find('input[type=date]').val('');
				$('.removeTr').remove();
			});
	
			
});