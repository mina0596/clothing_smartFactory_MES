/**
 * 
 */
$(function(){
	var clientCate = $('#clientCate');
	var requestCate = $('#requestCate');
	var productCate = $('#productCate');

//거래처명가지고오기
	var request = $.ajax({
		url: "/quality/clientName",
		method: "get"
	}); 
	request.done(function( data ) {
		console.log(data[0].client_name);
		if(data != undefined || data != '' || data.length > 0){
			var html = '';
			for(var i = 0; i<data.length; i++){
				html += "<option value= '";
				html += data[i].client_name;
				html += "'>";
				html += data[i].client_name+"</option>";					
			}
			clientCate.append(html);
		}
	});
	request.fail(function( jqXHR, textStatus ) {
		alert( "Request failed: " + textStatus );
	});	
	
//의뢰코드가지고오기			
	$('#clientCate').change(function(){
		var client =$('#clientCate option:selected').val();
		requestCate.html("<option value=''>::선택::</option>");
		
		var request = $.ajax({
			url: "/quality/requestCode",
			method: "get",
			data: {client : client}
		}); 
		request.done(function( data ) {
			console.log(data);
			if(data != undefined && data != '' && data.length > 0){
				var html = '';
				for(var i = 0; i<data.length; i++){
					html += "<option value= '";
					html += data[i].requested_product_code;
					html += "'>";
					html += data[i].requested_product_code;
					html += "</option>";					
				}
				requestCate.append(html);
			}
			
		});
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});	
	});
	$('#requestCate').change(function(){
		var requestNum = $('#requestCate option:selected').val();
		var request = $.ajax({
			url: "/quality/requestName",
			method: "get",
			data: {requestNum : requestNum}
		}); 
		request.done(function( data ) {
			console.log(data);
			if(data != undefined && data != '' && data.length > 0){
				var html = '';
				for(var i = 0; i<data.length; i++){
					html += "<option value= '";
					html += data[i].detailed_categorized_name;
					html += "'>";
					html += data[i].detailed_categorized_name;
					html += "</option>";					
				}
				productCate.append(html);
			}
			
		});
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});	
	})
})
