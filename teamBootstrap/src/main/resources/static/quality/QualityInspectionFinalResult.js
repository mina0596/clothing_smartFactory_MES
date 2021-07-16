/**
 * 
 */
$(function(){
	var param = {};
	$('#searchRequesetCode').click(function(){
		/* ajax 결과값 done (data) mymodal*/
		var request = $.ajax({
			  url: "/quality/addfinalresult",
			  method: "GET",
			  data : param,
			  type: "post",
			  dataType: "json"
			});
		var html = '';
	 request.done(function( data ) {
			$('#inspectionResultModal').modal();
				if(data.length > 0){
				for(i=0; i<data.length; i++){
					html += '<tr  class="checkTr" >';
					html += '<td><input type="checkbox" class="checkedModal" value="';
					html += '"></td>';
					html += '<td>' + [i + 1] + '</td>';	
					//계약코드
					html += '<td class="contract_code" value="';
					html +=  data[i].contract_code
					html += '">' + data[i].contract_code + '</td>';
					//거래처명
					html += '<td class="contract_name" value="';
					html +=  data[i].client_name
					html += '">' + data[i].client_name + '</td>';
					//의뢰코드
					html += '<td class="product_request_code" value="';
					html += data[i].product_request_code;
					html += '">' + data[i].product_request_code + '</td>';
					
					//중분류명
					html += '<td class="med_class_name" value="';
					html += data[i].med_class_name;
					html += '">' + data[i].med_class_name + '</td>';
					//소분류명
					html += '<td class="low_class_name" value="';
					html += data[i].low_class_name;
					html += '">' + data[i].low_class_name + '</td>';
					//상세분류명
					html += '<td class="sub_class_name" value="';
					html += data[i].sub_class_name;
					html += '">' + data[i].sub_class_name + '</td>';
					//검사회차
					html += '<td class="inspection_measurement_num" value="';
					html += data[i].inspection_measurement_num;
					html += '">' + data[i].inspection_measurement_num + '</td>';
					//검사결과 
					html += '<td class="inspection_pass_check" value="';
					html += data[i].inspection_pass_check;
					html += '">' + data[i].inspection_pass_check + '</td>';
					//검사시작시간
					html += '<td class="start_date" value="';
					html += data[i].start_date;
					html += '">' + data[i].start_Date + '</td>';
					//검사 소요시간
					html += '<td class="inspection_duration" value="';
					html += data[i].inspection_duration;
					html += '">' + data[i].inspection_duration + '</td>';
					//검사 완료시간
					html += '<td class="end_Date" value="';
					html += data[i].end_Date;
					html += '">' + data[i].end_Date + '</td>';
					//검사결과 등록시간
					html += '<td class="reg_Date" value="';
					html += data[i].reg_Date;
					html += '">' + data[i].reg_Date + '</td>';
					html += '</tr>'
				}
			}
				$('#searchTbody').append(html);
	 });			
	 
		request.fail(function( jqXHR, textStatus ) {
		  alert( "Request failed: " + textStatus );
			});	 
		});
	$('#saveBtn').click(function(){
		$('#tableTr').remove();
			//체크된 것 값 가져오기
			$('.checkedModal:checked').each(function(index,item){
				var requestCode = $(this).val();
				var qualityInspectionCode = $(this).parent().parent().find('td.quality_inspection_code').text();
				var contractCode = $(this).parent().parent().find('td.contract_code').text();
				var subClassName = $(this).parent().parent().find('td.sub_class_name').text();
				var rawMaterialName = $(this).parent().parent().find('td.raw_material_name').text();
				var insReqCode = $('.insReqCode');
				var inspectionName = $('.inspectionName');
				var materialsName = $('.materialsName');
				
				console.log($(this));
				console.log(contractCode);
				console.log(subClassName);
				console.log(rawMaterialName);
				console.log(qualityInspectionCode);

})
