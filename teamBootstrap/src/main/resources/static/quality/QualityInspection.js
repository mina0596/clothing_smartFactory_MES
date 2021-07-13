/**
 * 
 */

			var clientCate = $('#clientCate');
			var requestCate = $('#requestCate');

//거래처명가지고오기
			var request = $.ajax({
				url: "/clientName",
				method: "get"
			}); 
			request.done(function( data ) {
				console.log(data);
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
			
			