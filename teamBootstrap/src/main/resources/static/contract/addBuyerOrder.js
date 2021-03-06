/**
 * 
 */
 		function searchAddr() {
		        new daum.Postcode({
		            oncomplete: function(data) {
		                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

		                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
		                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
		                var roadAddr = data.roadAddress; // 도로명 주소 변수
		                var extraRoadAddr = ''; // 참고 항목 변수

		                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
		                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
		                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
		                    extraRoadAddr += data.bname;
		                }
		                // 건물명이 있고, 공동주택일 경우 추가한다.
		                if(data.buildingName !== '' && data.apartment === 'Y'){
		                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
		                }
		                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
		                if(extraRoadAddr !== ''){
		                    extraRoadAddr = ' (' + extraRoadAddr + ')';
		                }

		                // 주소 정보를 해당 필드에 넣는다.
		                document.getElementById("requestedDeliveryAddress").value = roadAddr;

		                var guideTextBox = document.getElementById("guide");
		                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
		                if(data.autoRoadAddress) {
		                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
		                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
		                    guideTextBox.style.display = 'block';

		                } else if(data.autoJibunAddress) {
		                    var expJibunAddr = data.autoJibunAddress;
		                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
		                    guideTextBox.style.display = 'block';
		                } else {
		                    guideTextBox.innerHTML = '';
		                    guideTextBox.style.display = 'none';
		                }
		            }
		        }).open();
		    }
 		
 		//전화번호 자동 하이폰
 		$(document).on("keyup", "#requestedDeliveryTel", function() {
 			$(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") ); 
 		});
 		
		$(function(){
			//거래처명 검색 모달
			$('#byClient').click(function(){
				var mainTbodyClient = $('#mainTbodyClient');
				
				$('#searchClientBtn').click(function(){
					$('.removeTrCL').remove();
					html = '';
					searchKey = '';
					searchValue = '';
					searchObj = {};
					
					var clientName = $('#searchClientName').val();
					
					var request = $.ajax({
						url: "/quality/searchByClientName",
						method: "POST",
						data: {"clientName":clientName},
						dataType: "json"
					});
					
					request.done(function( data ) {
						//console.log(data);
						if(data.length > 0){
							for(var i = 0; i<data.length; i++){
								html += '<tr class="removeTrCL">';
								html += "<td><input type='radio' name='check' value='" +  data[i].clientCode + "'</td>";
								html += '<td>'+ [i+1] +'</td>';
								html += '<td class="clientName">'+ data[i].clientName +'</td>';
								html += '</tr>';
							}
						}else{
							html += '<tr class="removeTrCL"><td colspan="3" style="text-align:center;">검색 결과가 없습니다</td></tr>';
						}
						mainTbodyClient.append(html);
						
						//메인화면 input박스에 넣기
						$('input[type=radio]').click(function(){
							value = $(this).parent().parent().find('.clientName').text();
							$('#clientAccountName').val(value);
							$('#clientCode').val($(this).val());
						});
					});
					
					request.fail(function( jqXHR, textStatus ) {
						alert( "Request failed: " + textStatus );
					});
				});
				
			});
			
			var genderCateCode = '';
			
			//성별별에 맞는 품목 가져오기
			$('#selectedSuitType').change(function(){
				$('#detailedCategorizedName').children().hide();
				
				var request = $.ajax({
					url: "/contract/getDetailedCategorizedName",
					method: "POST",
					data: {"genderCategorizedCode":$('#selectedSuitType').val()},
					dataType: "json"
				});
				
				request.done(function( data ) {
					//console.log(data);
					var html = '';
					if(data.length > 0){
						for(var i = 0; i < data.length; i++){
							html += '<label><input type="checkbox" name="detailedCategorizedName" value="' + data[i].detailedCategorizedCode + '">' + data[i].detailedCategorizedName + '</label>';
							genderCateCode = data[i].genderCategorizedCode;
						}
					}else{
						html += '<span>양복명을 선택해주세요.</span>';
					}
					$('#detailedCategorizedName').append(html);						
					
						//품목에 맞는 측정부위 가져오기
						$('input[name="detailedCategorizedName"]').click(function(){	
							var detailCate = $(this).val();
								
							var request = $.ajax({
								  url: "/contract/getMeasurementPart",
								  method: "POST",
								  data: { detailCate : detailCate },
								  dataType: "json"
								});
								 
								//측정값 넣는 폼 만들어주기
								request.done(function( msg ) {
									var html = '';
								  	if(msg.length > 0 ){
								  		$('.removeText').remove();
								  		//console.log(msg);
								  		html += '<tr class="' + msg[0].detailedCategorizedCode + '"><td colspan="' + msg.length + '">' + $('#selectedSuitType').val() + '/' + msg[0].detailedCategorizedCode;
								  		html += '<input type="hidden" name="productCode" class="productCode" value="' + genderCateCode + '_' + detailCate  + '">';
								  		html += '</td>';
								  		html += '</tr>';
								  		html += '<tr class="' + msg[0].detailedCategorizedCode + '">';
								  		for(var i = 0; i < msg.length; i++){
								  			html += '<td>' + msg[i].measurementPart + '</td>';
								  		}
								  		html += '</tr>';
								  		$('#measureName').append(html);
								  		
								  		var html2 = '';
								  		html2 += '<tr class="' + msg[0].detailedCategorizedCode + '">';
								  		for(var j = 0; j <msg.length; j++){
								  			html2 += '<td><input type="number" name="measuredValue" class="form-control" placeholder="' + msg[j].measurementPart + '"></tb>';
								  			html2 += '<input type="hidden" value="' + msg[j].requiredSizeCode + '" name="requiredSizeCode">';
								  			html2 += '<input type="hidden" name="productCodeVal" class="productCodeVal" value="' + genderCateCode + '_' + detailCate  + '">';
								  		}
								  		html2 += '</tr>';
								  		$('#measureName').append(html2);
								  	}
								  	
								  	$('input[name="detailedCategorizedName"]').click(function(){
								  		if($('input[name="detailedCategorizedName"]:checked')){
								  			var name = $(this).val();
								  			$('.'+name+'').remove();
								  		}else{
											
										}								  		
								  	});
								
								});
								 
								request.fail(function( jqXHR, textStatus ) {
								  alert( "Request failed: " + textStatus );
								});
						});
				});
				
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});
			});
			
			//사이즈 등록 ajax
			var addSizeAjax = function(array){
				$.ajax({
					url     : '/contract/addBuyerOrderSize',
					type    : 'POST',
					data    : JSON.stringify(array),
					traditional : true,
					contentType : 'application/json; charset=UTF-8',
					dataType: 'text',
					success : function(data) {
						console.log(data);
						//리로드
						if(data) window.location.href = '/contract/buyerOrderList';        	
					},
					error : function(xhr,status,error) {
						console.log('오류가 발생했습니다. 관리자에게 문의해주세요.');
					}
				});
			}
			
			
			//의뢰등록 ajax
			var addOrderAjax = function(array){
				$.ajax({
			        url     : '/contract/addBuyerOrder',
			        type    : 'POST',
			        data    : JSON.stringify(array),
			        traditional : true,
			        contentType : 'application/json; charset=UTF-8',
			        dataType: 'text',
			        success : function(data) {
			        	console.log(data);
			        	
			        	//성공하면 사이즈 등록
			        	if(data){	
			        		var productCodeVal = $('input[name="productCodeVal"]');
			        		var measuredValue = $('input[name="measuredValue"]');
			        		var requiredSizeCode = $('input[name="requiredSizeCode"]');
			        		var sizeobj = {};
			        		var sizeArr = [];
			        		for(var i = 0; i < measuredValue.length; i++){
			        			
			        			sizeobj = {
			        					"measuredValue" : measuredValue.eq(i).val()
			        					,"requiredSizeCode" : requiredSizeCode.eq(i).val()
			        					,"requestedProductCode" : productCodeVal.eq(i).val()
			        			}
			        			sizeArr.push(sizeobj);
			        		}
			        		console.log(sizeArr);
			        		addSizeAjax(sizeArr);
			        	}		        	
			        },
			        error : function(xhr,status,error) {
			        	console.log('오류가 발생했습니다. 관리자에게 문의해주세요.');
			        }
			    });
			}
			
			//측정값 빼고 품목별 의뢰 정보 넣기
			$(document).on('click', '#addBuyerOrder', function(){
				
				var arr = [];
				var productCode = $('input[name="productCode"]');
				
				var clientAccountName = $('#clientAccountName');
				var requestedDeliveryAddress = $('#requestedDeliveryAddress');
				var requestedDeliveryTel = $('#requestedDeliveryTel');
				var requestedDate = $('#requestedDate');
				var requestedDueDate = $('#requestedDueDate');
				var requestedSpecialNote = $('#requestedSpecialNote');
				var chargeEmployeeCode = $('#chargeEmployeeCode');
				var clientCode = $('#clientCode');
				
				var productCodeVal = $('input[name="productCodeVal"]');
        		var measuredValue = $('input[name="measuredValue"]');
        		var requiredSizeCode = $('input[name="requiredSizeCode"]');       		
				
				var orderInfoObj = {};
				var orderSize = {};
				var validationCheck = true;
				
				if(clientAccountName.val() == null || clientAccountName.val() == '' || clientAccountName.val() == undefined){
					alert('거래처 명을 입력해주세요.');
					clientAccountName.focus();
					validationCheck = false;
				}else if(requestedDeliveryAddress.val() == null || requestedDeliveryAddress.val() == '' || requestedDeliveryAddress.val() == undefined){
					alert('주소를 입력해주세요.');
					requestedDeliveryAddress.focus();
					validationCheck = false;
				}else if(requestedDeliveryTel.val() == null || requestedDeliveryTel.val() == '' || requestedDeliveryTel.val() == undefined){
					alert('전화번호를 입력해주세요.');
					requestedDeliveryTel.focus();
					validationCheck = false;
				}else if(requestedDueDate.val() == null || requestedDueDate.val() == '' || requestedDueDate.val() == undefined){
					alert('납기일자를 입력해주세요.');
					requestedDueDate.focus();
					validationCheck = false;
				}else if(requestedDate.val() == null || requestedDate.val() == '' || requestedDate.val() == undefined){
					alert('수주주문일자를 입력해주세요.');
					requestedDate.focus();
					validationCheck = false;
				}else if(productCodeVal.length <= 0){
					alert('품목을 선택해주세요.');
					$('#selectedSuitType').focus();
					validationCheck = false;
				}else if(measuredValue.val() == null || measuredValue.val() == '' || measuredValue.val() == undefined){
					alert('측정값을 입력해주세요.');
					measuredValue.focus();
					validationCheck = false;
				}else if(validationCheck){
					for(var i = 0; i< productCode.length; i++){
						orderInfoObj = {
								clientCode : clientCode.val()
								,requestedDeliveryAddress : requestedDeliveryAddress.val()
								,requestedDeliveryTel : requestedDeliveryTel.val()
								,requestedDate : requestedDate.val()
								,requestedDueDate : requestedDueDate.val()
								,requestedSpecialNote : requestedSpecialNote.val()
								,chargeEmployeeCode : chargeEmployeeCode.val()
								,productCode : productCode.eq(i).val()
						}
						arr.push(orderInfoObj)	
					}
					console.log(arr);
					addOrderAjax(arr);				
				}
				
			});
			
		});
		