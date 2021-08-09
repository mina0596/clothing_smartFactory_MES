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
			
		}//체크된 체크박스의 길이가 0이면 품질검사항목이없다.
		if(checkArray.length == 0){
			alert("선택된 품질검사항목이 없습니다.");
		}else{
			var chk= confirm("정말로삭제하시겠습니까?");
			var request = $.ajax({
				type:"POST",
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
	
		//검색 ajax전달
		var request = $.ajax({
			  url: "/system/searchInspectionList",
			  method: "GET",
			  type: "post",
			  data: inspectionArray,
			  dataType: "json"
			});
			 
			request.done(function( data ) {
				
		        $( '#inspectionList > tbody').empty();
		        //검색성공시 검사목록리시트를 tbody아래는 비우고 반복을돌려서 검색된 결과값을가지고오기

		        if(data.length > 0){
			        for(i=0; i<data.length; i++){
			        	html +="<tr>";
			        	html +="<td> <input type='checkbox' class='check' name='check' value="+ data[i].quality_inspection_code +"></td>";
			        	html +="<td>"+[i + 1]+"</td>";
			        	html +="<td>"+ data[i].quality_inspection_code+"</td>";
			        	html +="<td>"+ data[i].high_class_name+"</td>";
			        	html +="<td>"+ data[i].med_class_name+"</td>";
			        	html +="<td>"+ data[i].low_class_name+"</td>";
			        	html +="<td>"+ data[i].sub_class_name+"</td>";
			        	html +="<td>"+ data[i].inspection_reg_date+"</td>";
			           	html +="<td><a href='/quality/addStandardTable' class='btn btn-warning btn-xs'><i class='fa fa-pencil'></i>기준표등록</a></td>";
			        	html +="<td><a href='/system/modifyQualityInspection?qualityInspectionCode="+data[i].quality_inspection_code+"' class='btn btn-primary btn-xs'><i class='fa fa-pencil'></i>수정</a></td>";
				       						
					}
		        }else{
						html += "<tr><td colspan='11' style='text-align: center;'> 검색된 결과가 없습니다. </td></tr>";
					}
		        $('#inspectionTbody').append(html);
			});
			 
			request.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});	
		
	});	
	


})
