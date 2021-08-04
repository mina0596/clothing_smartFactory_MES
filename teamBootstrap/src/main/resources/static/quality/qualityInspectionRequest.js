/**
 * 
 */

$(function(){
	var value = '';
	var html = '';
	var searchKey = '';
	var searchValue = '';
	var searchObj = {};
	
	//계약번호 모달
	$('#bycontractNum').click(function(){
		var bindElement = $('#searchContractForm').find('input, select');
		var mainTbodyContract = $('#mainTbodyContract');		
		
			$('#searchContractModal').click(function(){	
				$('.removeTrCN').remove();
				html = '';
				searchKey = '';
				searchValue = '';
				searchObj = {};

				
				$.each(bindElement, function(){
					searchKey = $(this).attr('name');
					searchValue = $(this).val();
					
					if(searchValue != null && searchValue != undefined && searchValue != ''){
						searchObj[searchKey] = searchValue;
					}				
				});
				
				var request = $.ajax({
					url: "/quality/searchByContractNum",
					method: "POST",
					data: JSON.stringify(searchObj),
					contentType: "application/json",
					dataType: "json"
				});
				
				request.done(function( data ) {
					//console.log(data);
					if(data.length >  0){
						for(var i = 0; i<data.length; i++){						
							html += "<tr class='removeTrCN'>";
							html += "<td><input type='radio' name='check' value='" +  data[i].contractCode + "'</td>";
							html += "<td>"+ [i+1] +"</td>";
							html += "<td>"+ data[i].contractCode +"</td>";
							html += "<td>"+ data[i].clientName +"</td>";
							html += "<td>"+ data[i].contractedAmount +"</td>";
							html += "<td>"+ data[i].contractedDate +"</td>";
							html += "</tr>";					
						}						
					}else{
						html += "<tr class='removeTrCN'><td style='text-align:center;' colspan='6'>검색 결과가 없습니다.</td></tr>"
					}
					mainTbodyContract.append(html);
					
					//메인화면 input박스에 넣기
					$('input[type=radio]').click(function(){
						value = $(this).val();
						$('#contractNum').val(value);
					});
					
				});
				
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});
			});
		});
	
	//계약번호에 맞는 품목별 의뢰 코드 가져오기
	$('#saveBtn').click(function(){
		if($('#contractNum').val() != ''){
			var request = $.ajax({
				url: "/quality/searchRequestProductCode",
				method: "POST",
				data: {contractCode:$('#contractNum').val()},
				dataType: "json"
			});
			
			request.done(function( data ) {
				for(var i = 0; i < data.length; i++){
					html = '';
					html += '<option value="' + data[i].requested_product_code;
					html += '">' + data[i].requested_product_code;
					html += '</option>';				
					$('#requestedProductCode').append(html);
				}
			});
			
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});
			
			}else{
				$('#contractNum').val('buyerContract002');
			}
		})
		
	//품질검사 명 	
	var highClassCateName = $('#highClassCateName');
	var middleClassCateName = $('#middleClassCateName');
	var lowClassCateName = $('#lowClassCateName');
	var inspectionCode=[]
	//검사대분류명가지고오기
	var request = $.ajax({
		url: "/system/highClassCate",
		method: "get"

	}); 
	request.done(function( data ) {
		
		if(data != undefined || data != '' || data.length > 0){
			var html = '';
			for(var i = 0; i<data.length; i++){
				html += "<option value= '";
				html += data[i].highClassCode;
				html += "'>";
				html += data[i].highClassName;
				html +="</option>";					
			}
			highClassCateName.append(html);
			 }
		
	});
	request.fail(function( jqXHR, textStatus ) {
		alert( "Request failed: " + textStatus );
	});	
	
	//중분류가지고오기	
	//대분류명 검사를 선택하게되면  data 화면에서 선택된 키와 값으로 data를 전송
	$('#highClassCateName').change(function(){
		var highClassCateName =$('#highClassCateName option:selected').val();
			inspectionCode.push(highClassCateName);
		var request = $.ajax({
			url: "/system/mediumClassCate",
			method: "get",
			data: {highClassCateName : highClassCateName}
		}); 
		request.done(function( data ) {
			if(data != undefined && data != '' && data.length > 0){
				//셀렉트박스  첫번째옵션빼고 초기화시키기
				$('#middleClassCateName').find('option:not(:first)').remove();
				var html = '';
				for(var i = 0; i<data.length; i++){
					html += "<option  value= '";
					html += data[i].highMediumClassCode;
					html += "'>";
					html += data[i].mediumClassName;
					html += "</option>";					
				}
				middleClassCateName.append(html);
			}
			
		});
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});	
	});
	//중분류 검사를 선택하게되면  data 화면에서 선택된 키와 값으로 data를 전송
	$('#middleClassCateName').change(function(){
		var middleClassCateName = $('#middleClassCateName option:selected').val();
		inspectionCode.push(middleClassCateName);
		var request = $.ajax({
			url: "/system/lowClassCate",
			method: "get",
			data: {middleClassCateName : middleClassCateName}
		}); 
		request.done(function( data ) {
			//셀렉트박스  첫번째옵션빼고 초기화시키기
			$('#lowClassCateName').find('option:not(:first)').remove();
			if(data != undefined && data != '' && data.length > 0){
				var html = '';
				for(var i = 0; i<data.length; i++){
					html += "<option value= '";
					html += data[i].highMedLowClassCode;
					html += "'>";
					html += data[i].lowClassName;
					html += "</option>";					
				}
				lowClassCateName.append(html);
			}			
		});
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});	
	})
	$('#lowClassCateName').change(function(){
		var lowClassCateName = $('#lowClassCateName option:selected').val();
		var request = $.ajax({
			url: "/quality/subClassCate",
			method: "post",
			data: {lowClassCateName : lowClassCateName}
		}); 
		request.done(function( data ) {
			//console.log(data);
			//셀렉트박스  첫번째옵션빼고 초기화시키기
			$('#SubClassCateName').find('option:not(:first)').remove();
			if(data != undefined && data != '' && data.length > 0){
				var html = '';
				for(var i = 0; i<data.length; i++){
					html += "<option value= '";
					html += data[i].quality_inspection_code;
					html += "'>";
					html += data[i].sub_class_name;
					html += "</option>";					
				}
				$('#SubClassCateName').append(html);
			}			
		});
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});	
	});
	
		
	});