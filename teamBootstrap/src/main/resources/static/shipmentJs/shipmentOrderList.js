/**
 * 
 */
$(function(){
	//검색기능만들기 클래스명을로 가져오기
	var shipmentOrderCode = $('.shipmentOrderCode');
	var productName = $('.productName ');
	var clientName = $('.clientName ');
	var shipmentOrderDate = $('.shipmentOrderDate ');
	
	$('#searchShimentOrderBtn').click(function(){
		var html ='';
		var shipmentArray={
				shipmentOrderCode:$('.shipmentOrderCode').val()
				,productName:$('.productName').val()
				,clientName : $('.clientName ').val()
				,shipmentOrderDate:$('.shipmentOrderDate').val()
				
		};
		console.log(shipmentArray);
	
	var request = $.ajax({
		url: "/shipment/searchShipmentOrder",
		method: "get",
		type: "post",
		data: shipmentArray,
		dataType: "json"	

	}); 
	request.done(function( data ) {
		$('#shipmentOrderList >tbody').empty();
			 if(data.length > 0){				 
				  for(i=0; i<data.length; i++){
		        	html +="<tr>";
		        	html += "<td> <input type='checkbox' class='check'></td>";
		        	html += "<td >"+[i + 1]+"</td>";
		        	html += "<td>"+ data[i].shipmentOrderCode +"</td>";
		        	html += "<td>"+ data[i].clientName +"</td>";
		        	html += "<td>"+ data[i].productName +"</td>";
		        	html += "<td>"+ data[i].shipmentOrderDate +"</td>";
		        	html += "<td>"+ data[i].shipmentRegDate +"</td>";
		        	html += "<td> <a href='/shipment/modifyShipmentOrder?shipmentOrderCode="+data[i].shipmentOrderCode+"' class='btn btn-primary btn-xs'>수정</a></td>";
		        	html +="</tr>";
		        }	
		      } else{
		        html += "<tr><td colspan='18' style='text-align: center;'> 검색된 결과가 없습니다. </td></tr>";
		        }
		       $('#shipmentOrderList').append(html);
		      
	});
	request.fail(function( jqXHR, textStatus ) {
		alert( "Request failed: " + textStatus );
	});	
	
	});
})
