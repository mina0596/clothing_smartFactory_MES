/**
 * 
 */

	$(function(){	
		
		//모달 실행
		$(document).on('click', '#requestCode, #requestCode2', function(){
			$('#requestCodeModal').modal("show");
			
			//검색조건, 체크박스 초기화
			$('#requestCodeModal').find('input[type=text]').val('');
			$("input[type=checkbox]:checked").attr('checked',false);
			//검색버튼 클릭
			$('#serchBtnModal').click(function(){
				$('.removeTr').remove();
				//검색값 넣기
				var searchValue = {
						contractCode : $('#contractCode').val()
						, qualityInspectionRequestCode: $('#qualityInspectionRequestCode').val()
						, inspectionRequestStartDate: $('#inspectionRequestStartDate').val()
						, inspectionRequestEndDate: $('#inspectionRequestEndDate').val()
						, subClassName :$('#subClassName').val()
						, rawMaterialName :$('#rawMaterialName').val()
						, clientName :$('#clientName').val()
					};
				
				//param 데이터 직렬화
				var jsonData = JSON.stringify(searchValue);
				
				var html = "";
				var request = $.ajax({
					url: "/quality/searchQualityInspectionRequest",
					method: "post",
					type: "post",
					data: {"jsonData" : jsonData},
					dataType: "json"
				});
				
				request.done(function( data ) {
					console.log(data);
					if(data.length > 0){
						for(i=0; i<data.length; i++){
							var date =  data[i].inspection_request_date;
							
							//date 포맷 변경 yyyy-MM-dd hh:mm:ss
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
							
							if(data[i].raw_material_name == undefined){
								data[i].raw_material_name = '해당없음';
							}
							
							html += '<tr class="removeTr">';
							html += '<td><input type="checkbox" class="checkedModal" value="';
							html += data[i].quality_inspection_request_code;
							html += '"></td>';
							html += '<td>' + [i + 1] + '</td>';
							
							//계약번호
							html += '<td class="contract_code" value="';
							html +=  data[i].contract_code
							html += '">' + data[i].contract_code + '</td>';
							
							//품목별의뢰번호
							html += '<td class="requested_product_code" value="';
							html += data[i].requested_product_code;
							html += '">' + data[i].requested_product_code + '</td>';
							
							//품질검사대분류명
							html += '<td class="high_class_name" value="';
							html += data[i].high_class_name;
							html += '">' + data[i].high_class_name + '</td>';
							
							//품질검사중분류명
							html += '<td class="med_class_name" value="';
							html += data[i].med_class_name;
							html += '">' + data[i].med_class_name + '</td>';						
							
							//품질검사명
							html += '<td class="sub_class_name" value="';
							html += data[i].sub_class_name;
							html += '">' + data[i].sub_class_name + '</td>';
							
							//품질검사 코드
							html += '<td style="display:none" class="quality_inspection_code" value="';
							html += data[i].quality_inspection_code;
							html += '">' + data[i].quality_inspection_code + '</td>';
							
							//원부자재 코드
							html += '<td style="display:none" class="raw_material_code" value="';
							html += data[i].raw_material_code;
							html += '">' + data[i].raw_material_code + '</td>';

							//거래처명
							html += '<td class="client_name" value="';
							html += data[i].client_name;
							html += '">' + data[i].client_name + '</td>';
							
							//원부자재명
							html += '<td class="raw_material_name" value="';
							html += data[i].raw_material_name;
							html += '">' + data[i].raw_material_name + '</td>';
							
							html += '<td>' + date + '</td>';
							html += '</tr>';						
						}
					}else{
						$('.removeTr').remove();
						html += '<tr class="removeTr"><td colspan="15" style="text-align: center;"> 검색된 결과가 없습니다. </td></tr>';
					}

					$('#mainTbody').append(html);
					
				});
				
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});
			});
			
		});
		
		//모달 save 눌렀을때
		$('#saveBtn , #saveBtn2').click(function(){
			$('#tableTr').remove();
			
				//체크된 것 값 가져오기
				$('.checkedModal:checked').each(function(index,item){
					var requestCode = $(this).val();
					var qualityInspectionCode = $(this).parent().parent().find('td.quality_inspection_code').text();
					var contractCode = $(this).parent().parent().find('td.contract_code').text();
					var subClassName = $(this).parent().parent().find('td.sub_class_name').text();
					var rawMaterialName = $(this).parent().parent().find('td.raw_material_name').text();
					var rawMaterialCode = $(this).parent().parent().find('td.raw_material_code').text();
					var insReqCode = $('.insReqCode');
					var inspectionName = $('.inspectionName');
					var materialsName = $('.materialsName');
					var cate = '';
					var cateRadio = '';
					var valueT = '';
					var valueF = '';
					
					
					//품질검사 카테고리 가져오기
					var request = $.ajax({
						  url: "/quality/getQulityInspectionCategory",
						  method: "POST",
						  data: { qualityInspectionCode : qualityInspectionCode },
						  dataType: "text"
						});
						 
						request.done(function( data ) {
							console.log(data);
							
							if(data != '' && data != undefined && data != null){
								
								if(data == '합격/불합격'){
									cate = '<input type="checkbox" name="inspectionPassCheck" value="합격">합 <input type="checkbox" name="inspectionPassCheck" value="불합격">불';
									rawMaterialName = '해당없음';
									rawMaterialCode = '해당없음';
									
								}else if(data == '수치'){
									cate = '<input type="number" name="inspectionMeasurementValue" class="form-control" placeholder="측정값">';
									rawMaterialName = '해당없음';
									rawMaterialCode = '해당없음';
									
								}else if(data == '등급')
									cate = '<input type="number" name="inspectionMeasurementValue" class="form-control" placeholder="측정값">';
								
								//체크된 수만큼 측정값 등록 행 추가
								if(index >= 0 && index !=null && index != undefined){

									var tbody = $('#tbody');
									
									for(var i = 0; i < index+2; i++){
										var innerHtml = '<tr>';
										innerHtml += '<td><input type="checkbox" class="checked"></td>';
										//품질검사요청코드
										innerHtml += '<td><div class="input-group"><input type="text" name="qualityInspectionRequestCode" class="form-control" value="';
										innerHtml += requestCode;
										innerHtml += '" placeholder="품질검사요청코드 검색"></div></td>';
										innerHtml += '<td><input type="text" class="form-control" value="' + subClassName  + '" readonly="readonly"></td>';
										//품질검사코드
										innerHtml += '<td><input type="text" name="qualityInspectionCode" class="form-control" value="' + qualityInspectionCode + '"</td>';
										//원부자재명
										innerHtml += '<td><input type="text" class="form-control" value="' + rawMaterialName  + '" readonly="readonly"></td>';
										//원부자재코드
										innerHtml += '<td><input type="text" name="rawMaterialCode" class="form-control" value="' + rawMaterialCode + '">';
										//측정값
										innerHtml += '<td>';
										innerHtml += cate;
										innerHtml += '</td>';
										//측정시간
										innerHtml += '<td><input type="text" name="inspectionStartDate" class="form-control" placeholder="yyyy-MM-dd hh:mm:ss"></td>';
										innerHtml += '<td><input type="text" name="inspectionEndDate" class="form-control" placeholder="yyyy-MM-dd hh:mm:ss"></td>';
										innerHtml += '<td><button type="button" class="addBtn">등록</button></td>';
										innerHtml += '<td><button type="button" class="removeButton">삭제</button></td>';
										innerHtml += '</tr>';
										tbody.append(innerHtml);
										break;
									}
								}
							}
						});
												 
						request.fail(function( jqXHR, textStatus ) {
						  alert( "Request failed: " + textStatus );
						});
								
				});
				//모달 닫기
				$('#requestCodeModal').modal("hide");
		});
		
		
		//모달 전체 체크
		$(document).on('click', '#checkAllModal', function(){
			if($('#checkAllModal').prop('checked')){
				$('.checkedModal').prop('checked',true);
			}else{
				$('.checkedModal').prop('checked',false);
			}
		});

		//메인 전체 체크
		$(document).on('click', '#checkAll', function(){
			if($('#checkAll').prop('checked')){
				$('.checked').prop('checked',true);
			}else{
				$('.checked').prop('checked',false);
			}
		});
		
		//다중 등록 ajax
		var addInsValueAjax = function(array){
			$.ajax({
		        url     : '/quality/addInspectionMeasurementValue',
		        type    : 'POST',
		        data    : JSON.stringify(array),
		        contentType : 'application/json; charset=UTF-8',
		        dataType: 'text',
		        success : function(data) {
		        	console.log(data);
		        	
		        	//리로드
		        	if(data) location.reload(true);
		        	else{
		        		alert('오류가 발생했습니다. 관리자에게 문의해주세요.');
		        	}
		        },
		        error : function(xhr,status,error) {
		        	console.log('오류가 발생했습니다. 관리자에게 문의해주세요.');
		        }
		    });
		}
		
		//다중 등록		
		$(document).on('click', '#addInsValue', function(){
			var insValueNum = $('input[name="inspectionMeasurementValue"]');
			var insReqCode = $('input[name="qualityInspectionRequestCode"]');
			var insValueCheck = $('input[name="inspectionPassCheck"]');
			var insStart = $('input[name="inspectionStartDate"]');
			var insEnd = $('input[name="inspectionEndDate"]');
			
			var validationCheck = false;
			
			if(insReqCode.val() == null || insReqCode.val() == undefined || insReqCode.val() == '' ){
				insReqCode.focus();
				alert('품질검사 요청 코드를 입력해주세요');
			}else if(insValueNum.val() == null || insValueNum.val() == undefined || insValueNum.val() == '' ){
				insValueNum.focus();
				alert('측정값을 입력해주세요');
			}else if(insValueCheck.val() == null || insValueCheck.val() == undefined || insValueCheck.val() == '' ){
				insStart.focus();
				alert('측정값을 입력해주세요');
			}else if(insStart.val() == null || insStart.val() == undefined || insStart.val() == '' ){
				insStart.focus();
				alert('시작시간을 입력해주세요');
			}else if(insEnd.val() == null || insEnd.val() == undefined || insEnd.val() == '' ){
				insEnd.focus();
				alert('종료시간을 입력해주세요');
			}else{
				
				var addIns = $('#tbody tr');
				var insArray = [];
				
				for(var i = 0; i < addIns.length; i ++){
					var insInfo = {};
					var bindElement = addIns.eq(i).find('input[type=text], input[type=number], input[type=checkbox]:checked');
					
					$.each(bindElement, function(){
						var insKey = $(this).attr('name');
						var insValue = $(this).val();
						console.log("key: ", insKey);
						console.log("value: ", insValue);
						
						if(insKey != null || insKey != undefined || insKey != ''){
							insInfo[insKey] = insValue;
							validationCheck = true;
						}	
						
					});
					insArray.push(insInfo);
				};
				
			}			
			console.log(JSON.stringify(insArray));
			if(validationCheck) addInsValueAjax(insArray);
			
		});
		
		
		// 체크된 행 삭제
		$(document).on('click', '#deleteBtn', function(){
			if (confirm("정말 삭제하시겠습니까?")) {
                // 확인 버튼 클릭 시 동작
				var checkObj = $('input[class="checked"]:checked');
				// 체크된 항목 수
				var checkCount = checkObj.length;
				// 전체 행의 수
				var bodyCount = $('#tbody tr').length;
				
				if(checkCount < 1){
					alert('체크된 항목이 없습니다.');
					return false;
				}
				
				if(checkCount >= bodyCount) {
					alert('모든 행을 지울 수 없습니다.');
					return false;
				}
			
				$.each(checkObj, function(){
					$(this).parent().parent().remove();
					$('#checkAll').prop('checked',false);
				});
				
				var lastTrRemoveBtnObj = $('#tbody tr:last td').find('.removeButton');
				
            } else {
                // 취소 버튼 클릭 시 동작
                alert("동작을 취소했습니다.");
            }
			
			
		});
		
		
		//행 추가 기능
		$('#addRows').click(function(){
			var count = $('#trCount').val();
			var tbody = $('#tbody');
			
			if(count != null && count != undefined && count > 0){
				
				for(var i = 0; i < count; i++){
					var lastIndex = $(tbody).find('tr:last').length;
					var innerHtml = '<tr>';
					innerHtml += '<td><input type="checkbox" class="checked"></td>';
					//품질검사 요청 코드
					innerHtml += '<td><input type="text" name="qualityInspectionRequestCode" class="form-control" placeholder="품질검사요청코드 직접입력"><div class="input-group-btn"></td>';
					//검사명
					innerHtml += '<td><input type="text" class="form-control" placeholder="검사명 직접입력"></td>';
					//품질검사 코드
					innerHtml += '<td><input type="text" name="qualityInspectionCode" class="form-control" </td>';
					//원부자재명
					innerHtml += '<td><input type="text" class="form-control" placeholder="원부자재명 직접입력"></td>';
					//원부자재코드
					innerHtml += '<td><input type="text" name="rawMaterialCode" class="form-control" placeholder="원부자재명 직접입력"></td>';
					//측정값
					innerHtml += '<td><input type="number" name="inspectionMeasurementValue" class="form-control" placeholder="측정값"></td>';
					//측정시작시간
					innerHtml += '<td><input type="text" name="inspectionStartDate" class="form-control" placeholder="yyyy-MM-dd hh:mm:ss"></td>';
					//측정종료시간
					innerHtml += '<td><input type="text" name="inspectionEndDate" class="form-control" placeholder="yyyy-MM-dd hh:mm:ss""></td>';
					//등록버튼
					innerHtml += '<td><button type="button" id="addInsValue">등록</button></td>';
					
					if(i == (count - 1)){
						innerHtml += '<td><button type="button" class="removeButton">삭제</button></td>';
					}else{
						innerHtml += '<td><button type="button" class="removeButton">삭제</button></td>';	
					}
					
					innerHtml += '</tr>';
					tbody.append(innerHtml);										
				}
			}else{
				alert('확인');
				$('#trCount').focus();
				return false;
			}
			$('#trCount').val(1);
			
		});
		
		
		
		//행 삭제
		$(document).on('click', '.removeButton', function(){
			var bodyCount = $('#tbody tr').length;
			var removeBtn = $('.removeButton').parent().parent();
			
			if(bodyCount > removeBtn.length ) {
				alert('모든 행을 지울 수 없습니다.');
				return false;
			}
			
			else if (confirm("정말 삭제하시겠습니까?")) {
                // 확인 버튼 클릭 시 동작
				var tr = $(this).parent().parent();
				tr.remove();
            } else {
                // 취소 버튼 클릭 시 동작
                alert("동작을 취소했습니다.");
            }
			$('#addMemberBody tr:last td:last button').attr('class', 'addButton');
			$('#addMemberBody tr:last td:last button').text('삭제');
		});
		
	});
	
