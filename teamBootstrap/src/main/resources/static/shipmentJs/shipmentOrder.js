/**
 * 
 */
$(function(){//완제품목록 가져오는 모달
	$('#searchCompleteBtn').click(function(){
		$('#byCompletedProductList').modal("show");
		$('#byCompletedProductList').find('input[type=text]').val('');
		$("input[type=radio]:checked").attr('checked',false);
		//모달에서 save버튼 클릭시
	});

	 $('[data-popup-close]').on('click', function(e)  {
	        var targeted_popup_class = jQuery(this).attr('data-popup-close');
	        $('[data-popup="' + targeted_popup_class + '"]').fadeOut(350);

	        e.preventDefault();
	    });
		$('#byCompletedProductList').find('input[type=text]').val('');
		
		
		$('#contractCodeBtn').click(function(){
			$('.searchlist').remove();
			
			var contractCode = $('.contractCode').val();
			var html = "";
			var request = $.ajax({
				url: "/shipment/searchCompletContract",
				method: "get",
				type: "post",
				data: {"contractCode" : contractCode},
				dataType: "json"
			});
			
			request.done(function( data ) {
				
				if(data.length > 0){
					for(i=0; i<data.length; i++){									
												
						html += '<tr class="searchlist">';
						html += '<td><input type="radio" name="completeList" class="radioClass" value=""></td>';
						html += '<td>' + [i + 1] + '</td>';
						//의뢰코드
						html += '<td class="requestCode" value="';
						html +=  data[i].requestCode ;
						html += '">' + data[i].requestCode + '</td>';
						//품목별의뢰코드
						html += '<td class="productCode" value="';
						html += data[i].requestProductCode;
						html += '">' + data[i].requestProductCode + '</td>';
						//계약번호
						html += '<td class="contrcatNumber" value="';
						html +=data[i].contractCode;
						html +='">' + data[i].contractCode + '</td>';
						//거래처명
						html += '<td class="clientName" value="';
						html += data[i].clientName;
						html +=	'">' + data[i].clientName + '</td>';
						//품목명
						html += '<td class="productName" value="';
						html += data[i].productName;
						html += '">' + data[i].productName + '</td>';
						
						//완제품등록일
						html += '<td class="" value="';
						html += data[i].completeRegDate;
						html += '">' + data[i].completeRegDate + '</td>';
						
						html += '</tr>';						
					}
				}else{
					$('#searchCompletelist').empty();
					html += '<tr class="searchlist"><td colspan="13" style="text-align: center;"> 검색된 결과가 없습니다. </td></tr>';
				}

				$('#completeList').append(html);
				
			});
			
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});
		});
		//거래처명으로 조회
		$('#clientCateBtn').click(function(){
			$('.searchlist').remove();
			
			var clientName = $('.clientName').val();
			var html = "";
			var request = $.ajax({
				url: "/shipment/searchCompletClientName",
				method: "get",
				type: "post",
				data: {"clientName" : clientName},
				dataType: "json"
			});
			
			request.done(function( data ) {
				
				if(data.length > 0){
					for(i=0; i<data.length; i++){									
						
						html += '<tr class="searchlist">';
						html += '<td><input type="radio" name="completeList" class="radioClass" value=""></td>';
						html += '<td>' + [i + 1] + '</td>';
						//의뢰코드
						html += '<td class="requestCode" value="';
						html +=  data[i].requestCode ;
						html += '">' + data[i].requestCode + '</td>';
						//품목별의뢰코드
						html += '<td class="productCode" value="';
						html += data[i].requestProductCode;
						html += '">' + data[i].requestProductCode + '</td>';
						//계약번호
						html += '<td class="contrcatNumber" value="';
						html +=data[i].contractCode;
						html +='">' + data[i].contractCode + '</td>';
						//거래처명
						html += '<td class="clientName" value="';
						html += data[i].clientName;
						html +=	'">' + data[i].clientName + '</td>';
						//품목명
						html += '<td class="productName" value="';
						html += data[i].productName;
						html += '">' + data[i].productName + '</td>';
						
						//완제품등록일
						html += '<td class="" value="';
						html += data[i].completeRegDate;
						html += '">' + data[i].completeRegDate + '</td>';
						
						html += '</tr>';					
					}
				}else{
					$('#searchCompletelist').empty();
					html += '<tr class="searchlist"><td colspan="13" style="text-align: center;"> 검색된 결과가 없습니다. </td></tr>';
				}
				
				$('#completeList').append(html);
				
			});
			
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});
		});
		$('#sendCompleteProductListBtn').click(function(){
			var check = $('input[name=completeList]:checked');
			var checkTr = check.parent().parent();
			var checkRequestCode = checkTr.find('.requestCode').text();
			var checkProductCode = checkTr.find('.productCode').text();
			var checkedContractCode =checkTr.find('.contrcatNumber').text();
			var checkedClientName = checkTr.find('.clientName').text();
			var checkedProductName= checkTr.find('.productName').text();
			var checkedContractCode = checkTr.find('.contrcatNumber').text();
			var checkedAddress = checkTr.find('.address').text();
			var checkedTel = checkTr.find('.tel').text();
			$('#shipmentOrderRequestCode').attr('value', checkRequestCode);
			$('#shipmentOrderProduectCode').attr('value', checkProductCode);
			$('#shimpemtContractNumber').attr('value', checkedContractCode);
			$('#shipmentOrderClient').attr('value', checkedClientName);
			$('#shipmentOrderProductName').attr('value', checkedProductName);
			$('#shipmentOrderAdress').attr('value', checkedAddress);
			$('#shipmentOrderTel').attr('value', checkedTel);
			
		}) ;
		
		//출하지시등록전 의뢰품목코드 중복체크
		var productk = 0;
		$('#checkProduct').click(function(){
			//shipmentOrderProduectCode 을 param
		var shipmentOrderProduectCode=	$('#shipmentOrderProduectCode').val();
		
		if(shipmentOrderProduectCode != '' && shipmentOrderProduectCode != undefined && shipmentOrderProduectCode != null){
			var request = $.ajax({
				async:true,
				url: "/shipment/checkProduct",
				method: "POST", 
				data:  {shipmentOrderProduectCode:shipmentOrderProduectCode},
				dataType: "json" 
			    
			});
			request.done(function( data ) {
				if(data.cnt > 0){
					alert("이미등록된 품목코드입니다 완제품목록다시검색해주세요");
					$('#shipmentOrderRequestCode').focus();
				}else {
					alert("등록가능한 품목코드입니다.");
					productk=1;
					$('#shipmentOrderBtn').attr("disabled", false);
				}
			
			}); 
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});	
		}
		})
		// 출하지시등록 버튼 클릭시 유효성검사
		$('#shipmentOrderBtn').click(function(){
			
			var submitFlag =true;
			var shipmentOrderForm= $('#shipmentOrderForm');
			var shipmentOrderRequestCode= $('#shipmentOrderRequestCode');
			var shipmentOrderProduectCode= $('#shipmentOrderProduectCode');
			var shimpemtContractNumber= $('#shimpemtContractNumber');
			var shipmentOrderClient= $('#shipmentOrderClient');
			var shipmentOrderProductName= $('#shipmentOrderProductName');
			var contractState= $('#contractState');
			var shipmentOrderDate= $('#shipmentOrderDate');
			var inputOb = shipmentOrderForm.find('input[name=contractState]');
			if(shipmentOrderRequestCode.val()==''||shipmentOrderRequestCode.val()== null||shipmentOrderRequestCode.val()==undefined ){
				alert('완제품목록을 검색하세요');
				shipmentOrderRequestCode.focus();
				submitFlag=false;
				return submitFlag;
				
			}else if(contractState.val()==''||contractState.val()== null||contractState.val()==undefined ){
				alert('계약상태를입력해주세요');
				contractState.focus();
				submitFlag=false;
				return submitFlag;
			}else if(shipmentOrderDate.val()==''||shipmentOrderDate.val()== null||shipmentOrderDate.val()==undefined ){
				alert('출하지시날짜를 입력해주세요');
				shipmentOrderDate.focus();
				submitFlag=false;
				return submitFlag;
			}else{
				if(submitFlag)$('#shipmentOrderForm').submit();
			}
		});
		
		
		
		
	});
	

	

