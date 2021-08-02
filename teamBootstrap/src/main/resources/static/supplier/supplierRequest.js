/**
 * 
 */
$(function(){//발주요청 클릭시  발주요청 화면 뜨기
	$('#supplierRequstBtn').click(function(){
		$('#supplierRequest').show();
		
		//모달에서 save버튼 클릭시
	});
	$('#searchSupplier').click(function(){
		$('#bySupplierModal').modal();
		$('#byCompletedProductList').find('input[type=text]').val('');
		$("input[type=radio]:checked").attr('checked',false);
	});
	 $('[data-popup-close]').on('click', function(e)  {
	        var targeted_popup_class = jQuery(this).attr('data-popup-close');
	        $('[data-popup="' + targeted_popup_class + '"]').fadeOut(350);

	        e.preventDefault();
	    });

	 
	//거래처명 검색 모달 
		$('#clientCateBtn').click(function(){			
			
			var clientName = $('.clientName').val();
			var html = "";
			var request = $.ajax({
				url: "/contract/searchSupplierClientCate",
				method: "get",
				type: "post",
				data: {"clientName" : clientName},
				dataType: "json"
			});
			
			request.done(function( data ) {
				console.log(data);
				if(data.length > 0){
					for(i=0; i<data.length; i++){									
						
						html += '<tr class="searchlist">';
						html += '<td><input type="radio" name="supplierClient" class="radioClass" value=""></td>';
						html += '<td>' + [i + 1] + '</td>';
						//거래처코드
						html += '<td class="supplierCode" value="';
						html +=  data[i].supplierCode ;
						html += '">' + data[i].supplierCode + '</td>';
						//거래처명
						html += '<td class="supplierClientName" value="';
						html += data[i].supplierClientName;
						html += '">' + data[i].supplierClientName + '</td>';
						//거래처담당자
						html += '<td class="supplierClientEmployee" value="';
						html +=data[i].supplierClientEmployee;
						html +='">' + data[i].supplierClientEmployee + '</td>';
						//거래처연락처
						html += '<td class="supplierClientTel" value="';
						html += data[i].supplierClientTel;
						html +=	'">' + data[i].supplierClientTel + '</td>';
						//거래처 자재구분
						html += '<td class="SupplierRawMaterialCate" value="';
						html += data[i].supplierRawMaterialCateName;
						html += '">' + data[i].supplierRawMaterialCate + '</td>';
						html += '</tr>';					
					}
				}else{
					$('#seachSupplier').empty();
					html += '<tr class="searchlist"><td colspan="13" style="text-align: center;"> 검색된 결과가 없습니다. </td></tr>';
				}
				
				$('#seachSupplier').append(html);
				
			});
			
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});
			
			
			
			
			
		$('#saveSupplier').click(function(){
			var check = $('input[name=supplierClient]:checked');
			var checkTr = check.parent().parent();
			var supplierCode = checkTr.find('.supplierCode').text();
			var supplierName = checkTr.find('.supplierClientName').text();
			var supplierEmployee = checkTr.find('.supplierClientEmployee').text();
			var supplierTel=  checkTr.find('.supplierClientTel').text();
			$('#supplierContractCode').attr('value',supplierCode);
			$('#supplierContractName').attr('value',supplierName);
			$('#supplierEmployee').attr('value', supplierEmployee);
			$('#supplierPhone').attr('value',supplierTel);
		});
		});
		
		$('#searchRamMeterial').click(function(){
			$('#byRamMetrialModal').modal("show");
		$('#saveRamMeterial').click(function(){
			var check = $('input[name=byRamMetrialModal]:checked');
			var checkTr = check.parent().parent();
			var rawMaterialCode1 = checkTr.find('.rawMaterialCode1').text();
			var rawMateiralName1 = checkTr.find('.rawMateiralName1').text();
			var rawMaterialColor = checkTr.find('.rawMaterialColor').text();
			$('#rawMaterialCode').attr('value',rawMaterialCode1);
			$('#rawMaterialName').attr('value',rawMateiralName1);
			$('#rawMaterialColor').attr('value',rawMaterialColor);
			});
		});
		
		
		//거래처명으로 조회
		$('#clientCateBtn').click(function(){
			$('.searchlist').remove();
			
			
		});
		$('#saveSupplier').click(function(){
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
		
		
		
		
	});
	

	

