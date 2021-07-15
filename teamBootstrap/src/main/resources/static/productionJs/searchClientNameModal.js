/**
 * 
 */
			
		
$(function(){
			$('#byClientName').click(function(){
				$('#byClientNameModal').modal("show");
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
				
				
				var jsonData = JSON.stringify(param);
				console.log("jsonData 직렬화시킨거" + jsonData);
				
				jQuery.ajaxSettings.traditional = true;
				
				var request = $.ajax({
					url: "/production/searchOrderProductionProcess",
					method: "POST",
					data: {"param":jsonData},
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
							html += '<td name="clientNameCheck">';
							html += clientNameResultList[i].clientCode;						
							html += '</td>';
							html += '<td name="clientNameCheck">';
							html += clientNameResultList[i].approvalStatus;						
							html += '</td>';
							html += '<td name="clientNameCheck">';
							html += formatDate(clientNameResultList[i].regDate);						
							html += '</td>';
							html += '<td name="clientNameCheck">';
							html += clientNameResultList[i].contractCode;						
							html += '</td>';
							html += '<td name="clientNameCheck">';
							html += clientNameResultList[i].pCode;						
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
			$('#getClientName').click(function(){
				var checkedClientName = $('[name=clientNameCheck]:checked').parent().parent().find('.clientName').text();
				$('#searchedClientName').attr('value', checkedClientName);
				$("input[type=radio]:checked").attr('checked',false);
				$('#searchClientTable').find('input[type=text]').val('');
				$('#searchClientTable').find('input[type=date]').val('');
				$('.removeTr').remove();
			});
	
			
});