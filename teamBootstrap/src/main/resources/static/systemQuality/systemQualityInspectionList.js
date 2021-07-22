/**
 * 
 */
$(function(){
//체크된 품질검사항목 삭제
	$('#delBtn').click(function(){
		var checkArray = new Array();
		var checkList =$('input[name= "check"]');
		//체크박스에  체크 된 체크박스의 값을 반복을 돌린다 
		//체크된체크박스의값을 checkArray에 담아준다.
		for(var i =0; i < checkList.length; i++){
			if(checkList[i].checked){
				checkArray.push(checkList[i].value);
			}
			console.log(checkArray);
		}//체크된 체크박스의 길이가 0이면 품질검사항목이없다.
		if(checkArray.length == 0){
			alert("선택된 품질검사항목이 없습니다.");
		}else{
			var chk= confirm("정말로삭제하시겠습니까?");
			var request = $.ajax({
				typ:"POST",
				url:"/system/deleteInspection",
				data:{'checkArray':checkArray}
			});
			request.done(function(data) {
				if(data = 1){
					alert("품질검사 항목이 삭제되었습니다.");
					location.replace("qualityInspectionList")
				}else{
					alret("품질검사항목 삭제 실패되었습니다.");
				}
				
			});
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});	
		}
	});
	    	    
	
//품질검사 항목조회
$('#inspectionSearchBtn').click(function(){
		var html ='';
		//id값의 value 값 Array에 담기
		var inspectionArray ={
				highClassCateName : $('#highClassCateName').val(),
				middleClassCateName : $('#middleClassCateName').val(),
				lowClassCateName : $('#lowClassCateName').val(),
				
		};
		console.log(inspectionArray);
		//검색 ajax전달
		var request = $.ajax({
			  url: "/system/searchInspectionList",
			  method: "GET",
			  type: "post",
			  data: inspectionArray,
			  dataType: "json"
			});
			 
			request.done(function( data ) {
				console.log(data);
		        $( '#list > tbody').empty();

		        if(data.length > 0){
			        for(i=0; i<data.length; i++){
				       						
					}
		        }else{
						html += "<tr><td colspan='11' style='text-align: center;'> 검색된 결과가 없습니다. </td></tr>";
					}
		        $('#mainTbody').append(html);
			});
			 
			request.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});	
		
	});	
	


})
