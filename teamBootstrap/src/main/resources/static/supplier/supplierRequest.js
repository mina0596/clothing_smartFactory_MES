/**
 * 
 */
$(function(){//발주요청 클릭시  발주요청 화면 뜨기
	$('#searchSupplier').click(function(){
		$('#bySupplierModal').modal();
		$("input[type=radio]:checked").attr('checked',false);
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
		
		var selectSupplierName =$('#supplierContractName');
		
		
		$('#searchRamMeterial').click(function(){
			var selectSupplierName =$('#supplierContractName').val();
			$('#byRamMetrialModal').modal();
			$("input[type=radio]:checked").attr('checked',false);
			$('.searchlist').remove();
			var html = "";
			var request = $.ajax({
				url: "/contract/searchRawMaterial",
				method: "get",
				type: "post",
				data: {selectSupplierName : selectSupplierName},
				dataType: "json"
			});
			request.done(function( data ) {
				
				if(data.length > 0){
					for(i=0; i<data.length; i++){									
						
						html += '<tr class="searchlist">';
						html += '<td><input type="radio" name="rawmaterials" class="radioClass" value=""></td>';
						html += '<td>' + [i + 1] + '</td>';
						//원부자재코드
						html += '<td class="rawmaterialCode" value="';
						html +=  data[i].rawMatrialCode ;
						html += '">' + data[i].rawMatrialCode + '</td>';
						//원부자재 카테고리
						html += '<td class="rawmaterialCate" value="';
						html += data[i].SupplierRawMaterialCate;
						html += '">' + data[i].SupplierRawMaterialCate + '</td>';
						//원부자재이름
						html += '<td class="rawmaterialName" value="';
						html +=data[i].rawMatrialName;
						html +='">' + data[i].rawMatrialName + '</td>';
						//원부자재 색상
						html += '<td class="rawmaterialColor" value="';
						html += data[i].rawMatrialColor;
						html +=	'">' + data[i].rawMatrialColor + '</td>';
						//원부자재 특징
						html += '<td class="rawmaterialFeature" value="';
						html += data[i].rawMatrialFeature;
						html += '">' + data[i].rawMatrialFeature + '</td>';
						//원자재단위
						html += '<td class="rawmaterialUnit" value="';
						html += data[i].rawMaterialUnit;
						html += '">' + data[i].rawMaterialUnit + '</td>';
						html += '</tr>';					
					}
				}else{
					$('#seachRaWMaterialList').empty();
					html += '<tr class="searchlist"><td colspan="8" style="text-align: center;"> 검색된 결과가 없습니다. </td></tr>';
				}
				
				$('#seachRaWMaterialList').append(html);
			});
			
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});
			
		});
		$('#saveRamMeterial').click(function(){
			var check = $('input[name=rawmaterials]:checked');
			var checkTr = check.parent().parent();
			var checkRrawMaterialCode = checkTr.find('.rawmaterialCode').text();
			var checkRawMateiralName = checkTr.find('.rawmaterialName').text();
			var checkRawMaterialColor = checkTr.find('.rawmaterialColor').text();
			var rawmaterialFeature = checkTr.find('.rawmaterialFeature').text();
			var rawmaterialUnit = checkTr.find('.rawmaterialUnit').text();
			$('#rawMaterialCode').attr('value',checkRrawMaterialCode);
			$('#rawMaterialName').attr('value',checkRawMateiralName);
			$('#rawMaterialColor').attr('value',checkRawMaterialColor);
			$('#rawMateiralFeature').attr('value',rawmaterialFeature);
			$('#rawMaterialUnit').attr('value',rawmaterialUnit);
		});
	
		$('#addSupplierBtn').click(function(){
			var submitFlag =true;
			var addSupplierRequestForm=$('#addSupplierRequestForm');
			var supplierContractName =$('#supplierContractName');
			var rawMaterialName=$('#rawMaterialName');
			var rawMaterialAmount=$('#rawMaterialAmount');
			var rawMaterialOrderExpected = $('#rawMaterialOrderExpected');
			if(supplierContractName.val()==''){
				alert('거래처를 검색해주세요');
				supplierContractName.focus();
				submitFlag=false;
				return submitFlag;
			}else if(rawMaterialName.val()==''){
				alert('원부자재명을 검색해주세요');
				rawMaterialName.focus();
				submitFlag=false;
				return submitFlag;
			}else if(rawMaterialAmount.val()==''){
				alert('원부자재수량을 입력해주세요');
				rawMaterialAmount.focus();
				submitFlag=false;
				return submitFlag;
			}else if(rawMaterialOrderExpected.val()==''){
				alert('원부자재 납기일을  입력해주세요');
				rawMaterialOrderExpected.focus();
				submitFlag=false;
				return submitFlag;
			}else{
				submitFlag=true;
				if(submitFlag)addSupplierRequestForm.submit();
			}
		});
			
	});
	

	

