/**
 * 
 */

	$(function(){	
		
		//새로고침 방지(새로고침하면 탭이 넘어가버려서 막아놓을까 생각중입니다.)
// 		function noEvent() { // 새로 고침 방지
// 		    if (event.keyCode == 116) {
// 		        alert("새로고침을 할 수 없습니다.");
// 		        event.keyCode = 2;
// 		        return false;
// 		    } else if (event.ctrlKey
// 		            && (event.keyCode == 78 || event.keyCode == 82)) {
// 		        return false;
// 		    }
// 		}
// 		document.onkeydown = noEvent;
		
		
		
		//모달 실행
		$(document).on('click', '#requestCode', function(){
			$('#requestCodeModal').modal("show");
		});
		
		// 전체 체크
		$(document).on('click', '#checkAllSubSize', function(){
			if($('#checkAllSubSize').prop('checked')){
				$('.checkedSubSize').prop('checked',true);
			}else{
				$('.checkedSubSize').prop('checked',false);
			}
		});
		
		// 체크된 행 삭제
		$(document).on('click', '#deleteBtnSubSize', function(){
			if (confirm("정말 삭제하시겠습니까?")) {
                // 확인 버튼 클릭 시 동작
				var checkObj = $('input[class="checkedSubSize"]:checked');
				// 체크된 항목 수
				var checkCount = checkObj.length;
				// 전체 행의 수
				var bodyCount = $('#tbodySubSize tr').length;
				
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
				
				var lastTrRemoveBtnObj = $('#tbodySubSize tr:last td').find('.removeButtonSubSize');
				
// 				lastTrRemoveBtnObj.attr('class', 'addButton');
// 				lastTrRemoveBtnObj.text('추가');
            } else {
                // 취소 버튼 클릭 시 동작
                alert("동작을 취소했습니다.");
            }
			
			
		});
		
		
		//행 추가
		$('#addRowsSubSize').click(function(){
			var count = $('#trCountSubSize').val();
			var tbody = $('#tbodySubSize');
			
			if(count != null && count != undefined && count > 0){
// 				$('#tbody tr:last td:last button').attr('class', 'removeButton');
// 				$('#tbody tr:last td:last button').text('삭제');
				
				for(var i = 0; i < count; i++){
					var lastIndex = $(tbody).find('tr:last').length;
					var innerHtml = '<tr>';
					innerHtml += '<td><input type="checkbox" class="checkedSubSize"></td>';
					
					if(i == (count - 1)){
						innerHtml += '<td><div class="input-group"><input type="text" class="form-control" placeholder="품질검사요청코드 검색"><div class="input-group-btn"><button id="addRows" class="btn btn-default">검색</button></div></div></td>';
						innerHtml += '<td>검사명</td>';
						innerHtml += '<td><select class="form-control"><option>1회차</option><option>2회차</option><option>3회차</option></select></td>';
						innerHtml += '<td><input type="number" class="form-control" placeholder="측정값"></td>';
						innerHtml += '<td><select class="form-control"><option>mm</option><option>cm</option><option>직접입력</option></select></td>';
						innerHtml += '<td><input type="text" class="form-control" placeholder="공란일시 등록시간"></td>';
						innerHtml += '<td><input type="text" class="form-control" placeholder="공란일시 등록시간"></td>';
						innerHtml += '<td><button type="button">등록</button></td>';
						innerHtml += '<td><button type="button" class="removeButtonSubSize">삭제</button></td>';
						
					}else{
						innerHtml += '<td><button type="button" class="removeButtonSubSize">삭제</button></td>';	
					}
					
					innerHtml += '</tr>';
					tbody.append(innerHtml);	
					
					
				}
			}else{
				alert('확인');
				$('#trCountSubSize').focus();
				return false;
			}
			$('#trCountSubSize').val(1);
			
		});
		
		
		
		//행 삭제
		$(document).on('click', '.removeButtonSubSize', function(){
			var bodyCount = $('#tbodySubSize tr').length;
			var removeBtn = $('.removeButtonSubSize').parent().parent();
			
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
	
