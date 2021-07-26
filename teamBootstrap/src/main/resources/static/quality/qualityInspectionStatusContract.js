/**
 * 
 */
$(function(){
	$('.searchInspectionResult').hide();
	
	var bySupplierValue = $('#bySupplierValue');
	var clientName =$('#clientName');

	
	$('#searchBtn1').click(function(){
		
			
			
		var html='';
		var array={
				bySupplierValue:$('#bySupplierValue').val()
				,clientName:$('#clientName').val()
				,requestProductName:$('#requestProductName').val()
				,inspectionStartDate:$('#inspectionStartDate').val()
				,inspectionEndDate:$('#inspectionEndDate').val()
		};
		console.log(array)
		var request = $.ajax({
			url: "/quality/searchQualityInspection",
			method: "get",
			type: "post",
			data: array,
			dataType: "json"	

		}); 
		request.done(function( data ) {
			var contractCode = data[0].contractCode;
			$('.searchInspectionResult').show();
			$('.stateContractInspectionList').hide();
			$('#searchContractInspectionList' ).empty();
			 if(data.length > 0){
				 
			        for(i=0; i<data.length; i++){
			        	html +="<tr>";
			        	html += "<th scope='row' id='mandatory'>"+[i + 1]+"</th>";
			        	html += "<td>"+ data[i].highClassName +"</td>";
			        	html += "<td>"+ data[i].lowClassName +"</td>";
			        	html += "<td>"+ data[i].subClassName +"</td>";
			        	html += "<td>"+ data[i].requestProductCode +"</td>";
			        	html += "<td>"+ data[i].detailedCateName +"</td>";
			        	html += "<td>"+ data[i].inspectionRequestDate +"</td>";
			        	html += "<td>"+ data[i].inspectionCategory +"</td>";
			        	html += "<td>"+ data[i].standardTolerance +"</td>";
			        	html += "<td>"+ data[i].minTolerance +"</td>";
			        	html += "<td>"+ data[i].maxTolerance +"</td>";
			        	html += "<td>"+ data[i].insFirst +"</td>";
			        	html += "<td>"+ data[i].insSecond +"</td>";
			        	html += "<td>"+ data[i].insThird +"</td>";
			        	html += "<td>"+ data[i].insStart +"</td>";
			        	html += "<td>"+ data[i].insEnd +"</td>";
			        	html += "<td>"+ data[i].finalPassCheck +"</td>";
			        	html +="</tr>";
			        }	
			      } else{
			        html += "<tr><td colspan='17' style='text-align: center;'> 검색된 결과가 없습니다. </td></tr>";
			        }
			       $('#searchContractInspectionList').append(html);
			       $('#contractNum').text(contractCode);
		});
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});	
	});
});
