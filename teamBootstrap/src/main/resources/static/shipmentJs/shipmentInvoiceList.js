/**
 * 
 */
$(function(){
	
	//송장번호 검색하기 
		$('#invoiceCodeBtn').click(function(){
		var shipmentInvoice = $('.shipmentInvoice').val();
		
		var html ='';
		var request = $.ajax({
		url: "/shipment/searchInvoiceCode",
		method: "get",
		type: "post",
		data: {shipmentInvoice:shipmentInvoice},
		dataType: "json"	

	}); 
	request.done(function( data ) {
				
		$('#shipmentInvoicelist >tbody').empty();
			 if(data.length > 0){				 
				  for(i=0; i<data.length; i++){
		        	html +="<tr>";
		        	html += "<td> <input type='checkbox' class='check'></td>";
		        	html += "<td >"+[i + 1]+"</td>";
		        	html += "<td>"+ data[i].invoiceCode +"</td>";
		        	html += "<td>"+ data[i].shipmentOrderGroup +"</td>";
		        	html += "<td>"+ data[i].requestCode +"</td>";
		        	html += "<td>"+ data[i].reqeustAddress +"</td>";
		        	html += "<td>"+ data[i].invoiceClientName +"</td>";
		        	html += "<td>"+ data[i].invoiceRegDate +"</td>";
		        	html += "<td> <a href='/shipment/modifyShipmentInvoice?invoiceCode="+data[i].invoiceCode+"' class='btn btn-primary btn-xs'>수정</a></td>";
		        	html +="</tr>";
		        }	
		      } else{
		        html += "<tr><td colspan='9' style='text-align: center;'> 검색된 결과가 없습니다. </td></tr>";
		        }
		       $('#shipmentInvoicelist').append(html);
		      
	});
	request.fail(function( jqXHR, textStatus ) {
		alert( "Request failed: " + textStatus );
	});	
	
	});
	//거래처별 검색하기 
	$('#clientCateBtn').click(function(){
		var client = $('.client').val();
		
		var html ='';
		var request = $.ajax({
		url: "/shipment/searchClientCate",
		method: "get",
		type: "post",
		data: {client:client},
		dataType: "json"	

	}); 
	request.done(function( data ) {
		
		
		$('#shipmentInvoicelist >tbody').empty();
			 if(data.length > 0){				 
				  for(i=0; i<data.length; i++){
		        	html +="<tr>";
		        	html += "<td> <input type='checkbox' class='check'></td>";
		        	html += "<td >"+[i + 1]+"</td>";
		        	html += "<td>"+ data[i].invoiceCode +"</td>";
		        	html += "<td>"+ data[i].shipmentOrderGroup +"</td>";
		        	html += "<td>"+ data[i].requestCode +"</td>";
		        	html += "<td>"+ data[i].reqeustAddress +"</td>";
		        	html += "<td>"+ data[i].invoiceClientName +"</td>";
		        	html += "<td>"+ data[i].invoiceRegDate +"</td>";
		        	html += "<td> <a href='/shipment/modifyShipmentInvoice?invoiceCode="+data[i].invoiceCode+"' class='btn btn-primary btn-xs'>수정</a></td>";
		        	html +="</tr>";
		        }	
		      } else{
		        html += "<tr><td colspan='9' style='text-align: center;'> 검색된 결과가 없습니다. </td></tr>";
		        }
		       $('#shipmentInvoicelist').append(html);
		      
	});
	request.fail(function( jqXHR, textStatus ) {
		alert( "Request failed: " + textStatus );
	});	
	
	});
	//택배사명으로찾기
	$('#invoiceClientBtn').click(function(){
		var invoiceClient = $('.invoiceClient').val();
		
		var html ='';
		var request = $.ajax({
			url: "/shipment/searchInvoiceClient",
			method: "get",
			type: "post",
			data: {invoiceClient:invoiceClient},
			dataType: "json"	
				
		}); 
		request.done(function( data ) {
			
			
			$('#shipmentInvoicelist >tbody').empty();
			if(data.length > 0){				 
				for(i=0; i<data.length; i++){
					html +="<tr>";
					html += "<td> <input type='checkbox' class='check'></td>";
					html += "<td >"+[i + 1]+"</td>";
					html += "<td>"+ data[i].invoiceCode +"</td>";
					html += "<td>"+ data[i].shipmentOrderGroup +"</td>";
					html += "<td>"+ data[i].requestCode +"</td>";
					html += "<td>"+ data[i].reqeustAddress +"</td>";
					html += "<td>"+ data[i].invoiceClientName +"</td>";
					html += "<td>"+ data[i].invoiceRegDate +"</td>";
					html += "<td> <a href='/shipment/modifyShipmentInvoice?invoiceCode="+data[i].invoiceCode+"' class='btn btn-primary btn-xs'>수정</a></td>";
					html +="</tr>";
				}	
			} else{
				html += "<tr><td colspan='9' style='text-align: center;'> 검색된 결과가 없습니다. </td></tr>";
			}
			$('#shipmentInvoicelist').append(html);
			
		});
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});	
		
	});
	//송장등록일조회
	$('#invoiceRegDateBtn').click(function(){
		var invoiceRegDate = $('.invoiceRegDate').val();
		
		var html ='';
		var request = $.ajax({
			url: "/shipment/searchInvoiceRegDate",
			method: "get",
			type: "post",
			data: {invoiceRegDate:invoiceRegDate},
			dataType: "json"	
				
		}); 
		request.done(function( data ) {
			$('#shipmentInvoicelist >tbody').empty();
			if(data.length > 0){				 
				for(i=0; i<data.length; i++){
					html +="<tr>";
					html += "<td> <input type='checkbox' class='check'></td>";
					html += "<td >"+[i + 1]+"</td>";
					html += "<td>"+ data[i].invoiceCode +"</td>";
					html += "<td>"+ data[i].shipmentOrderGroup +"</td>";
					html += "<td>"+ data[i].requestCode +"</td>";
					html += "<td>"+ data[i].reqeustAddress +"</td>";
					html += "<td>"+ data[i].invoiceClientName +"</td>";
					html += "<td>"+ data[i].invoiceRegDate +"</td>";
					html += "<td> <a href='/shipment/modifyShipmentInvoice?invoiceCode="+data[i].invoiceCode+"' class='btn btn-primary btn-xs'>수정</a></td>";
					html +="</tr>";
				}	
			} else{
				html += "<tr><td colspan='9' style='text-align: center;'> 검색된 결과가 없습니다. </td></tr>";
			}
			$('#shipmentInvoicelist').append(html);
			
		});
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});	
		
	});
})
