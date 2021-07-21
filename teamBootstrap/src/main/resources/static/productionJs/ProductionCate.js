/**
 * 
 */
		
		var genderCate = $('#genderCate');
		var detailCate = $('#detailCate');
		
//성별별 이름 가져오기
		var request = $.ajax({
			url: "/production/productCode",
			method: "get"
		}); 
		request.done(function( data ) {
			console.log(data);
			if(data != undefined || data != '' || data.length > 0){
				var html = '';
				for(var i = 0; i<data.length; i++){
					html += "<option value= '";
					html += data[i].gender_categorized_name;
					html += "'>";
					html += data[i].gender_categorized_name+"</option>";					
				}
				genderCate.append(html);
			}
		});
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});	
		
		//소분류 가져오기
		$('#genderCate').change(function(){
			
			var gender = $("#genderCate option:selected").val();
			//옵션 값 초기화	
			detailCate.html("<option value=''>::선택::</option>");
			
			var request = $.ajax({
				url: "/production/detailCode",
				method: "get",
				data: {gender : gender}
			}); 
			request.done(function( data ) {
				console.log(data);
				if(data != undefined && data != '' && data.length > 0){
					var html = '';
					for(var i = 0; i<data.length; i++){
						html += "<option value= '";
						html += data[i].product_code;
						html += "'>";
						html += data[i].detailed_categorized_name;
						html += "</option>";					
					}
					detailCate.append(html);
				}
				
			});
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});									
		});


			