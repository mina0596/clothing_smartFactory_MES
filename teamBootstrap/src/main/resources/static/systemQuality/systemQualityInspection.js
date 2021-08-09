/**
 * 
 */
$(function(){
	var highClassCateName = $('#highClassCateName');
	var middleClassCateName = $('#middleClassCateName');
	var lowClassCateName = $('#lowClassCateName');
	var subClassCateName = $('#subClassCateName');
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
	//상세검사에 대한 select가 없으면 실행
	
		$('#lowClassCateName').change(function(){
			
			var lowClassCateName = $('#lowClassCateName option:selected').val();
			$('#qualityinsertForm input').prop('disabled', false);
			inspectionCode.push(lowClassCateName);
			
		});
	
})
