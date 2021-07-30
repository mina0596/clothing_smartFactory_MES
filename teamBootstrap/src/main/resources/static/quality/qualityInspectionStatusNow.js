/**
 * 
 */
$(function(){
	var value = '';
	var html = '';
	var searchKey = '';
	var searchValue = '';
	var searchObj = {};
	
	//계약번호 모달
	$('#bycontractNum').click(function(){
		var bindElement = $('#searchContractForm').find('input, select');
		var mainTbodyContract = $('#mainTbodyContract');		
		
			$('#searchContractModal').click(function(){	
				$('.removeTrCN').remove();
				html = '';
				searchKey = '';
				searchValue = '';
				searchObj = {};

				
				$.each(bindElement, function(){
					searchKey = $(this).attr('name');
					searchValue = $(this).val();
					
					if(searchValue != null && searchValue != undefined && searchValue != ''){
						searchObj[searchKey] = searchValue;
					}				
				});
				
				var request = $.ajax({
					url: "/quality/searchByContractNum",
					method: "POST",
					data: JSON.stringify(searchObj),
					contentType: "application/json",
					dataType: "json"
				});
				
				request.done(function( data ) {
					//console.log(data);
					if(data.length >  0){
						for(var i = 0; i<data.length; i++){						
							html += "<tr class='removeTrCN'>";
							html += "<td><input type='radio' name='check' value='" +  data[i].contractCode + "'</td>";
							html += "<td>"+ [i+1] +"</td>";
							html += "<td>"+ data[i].contractCode +"</td>";
							html += "<td>"+ data[i].clientName +"</td>";
							html += "<td>"+ data[i].contractedAmount +"</td>";
							html += "<td>"+ data[i].contractedDate +"</td>";
							html += "</tr>";					
						}						
					}else{
						html += "<tr class='removeTrCN'><td style='text-align:center;' colspan='6'>검색 결과가 없습니다.</td></tr>"
					}
					mainTbodyContract.append(html);
					
					//메인화면 input박스에 넣기
					$('input[type=radio]').click(function(){
						value = $(this).val();
						$('#contractNum').val(value);
					});
					
				});
				
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});
			});
		});
	
	
	//거래처 검색 모달
	$('#byClient').click(function(){
		var mainTbodyClient = $('#mainTbodyClient');
		
		$('#searchClientBtn').click(function(){
			$('.removeTrCL').remove();
			html = '';
			searchKey = '';
			searchValue = '';
			searchObj = {};
			
			var clientName = $('#searchClientName').val();
			
			var request = $.ajax({
				url: "/quality/searchByClientName",
				method: "POST",
				data: {"clientName":clientName},
				dataType: "json"
			});
			
			request.done(function( data ) {
				//console.log(data);
				if(data.length > 0){
					for(var i = 0; i<data.length; i++){
						html += '<tr class="removeTrCL">';
						html += "<td><input type='radio' name='check' value='" +  data[i].clientName + "'</td>";
						html += '<td>'+ [i+1] +'</td>';
						html += '<td>'+ data[i].clientName +'</td>';
						html += '</tr>';
					}
				}else{
					html += '<tr class="removeTrCL"><td colspan="3" style="text-align:center;">검색 결과가 없습니다</td></tr>';
				}
				mainTbodyClient.append(html);
				
				//메인화면 input박스에 넣기
				$('input[type=radio]').click(function(){
					value = $(this).val();
					$('#clientName').val(value);
				});
			});
			
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});
		});
		
	});
	
	//품질검사 코드 검색 모달
	$('#byInspectionCode').click(function(){
		var mainTbodyInsCode = $('#mainTbodyInsCode');
		var bindElement = $('#searchInsCodeForm').find('select');
		
		$('#searchInsCodeModal').click(function(){
			$('.removeTrIns').remove();
			html = '';
			searchKey = '';
			searchValue = '';
			searchObj = {};
			
			$.each(bindElement, function(){
				searchKey = $(this).attr('name');
				searchValue = $(this).val();
				
				if(searchKey != null && searchKey != undefined && searchKey != ''){
					searchObj[searchKey] = searchValue;
				}				
			});
			
			var request = $.ajax({
				url: "/quality/searchInspectionCode",
				method: "POST",
				data: JSON.stringify(searchObj),
				contentType: "application/json",
				dataType: "json"
			});
			
			request.done(function( data ) {
				//console.log(data);
				if(data.length > 0){
					for(var i = 0; i<data.length; i++){
						html += '<tr class="removeTrIns">';
						html += "<td><input type='radio' name='check' value='" +  data[i].qualityInspectionCode + "'</td>";
						html += '<td>'+ [i+1] +'</td>';
						html += '<td>'+ data[i].highClassificationName +'</td>';
						html += '<td>'+ data[i].mediumClassificationName +'</td>';
						html += '<td>'+ data[i].lowClassificationName +'</td>';
						html += '<td>'+ data[i].subClassificationName +'</td>';
						html += '</tr>';
					}
				}else{
					html += '<tr class="removeTrIns"><td colspan="3" style="text-align:center;">검색 결과가 없습니다</td></tr>';
				}
				mainTbodyInsCode.append(html);
				
				//메인화면 input박스에 넣기
				$('input[type=radio]').click(function(){
					value = $(this).val();
					$('#inspectionCode').val(value);
				});
			});
			
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});
		});
	});
	
	//수주계약번호		
	var contractCode = '';
	//품질검사 요청 총갯수
	var requestCount = 0;
	//최종 불합격 총갯수
	var finalFailCount = 0;
	//최종 합격 총갯수
	var finalPassCount = 0;
	//최종 완료 갯수
	var finalCompleteCount = 0;
	//완료율
	var completeRate = 0;
	//진행건수
	var progressRate = 0;
	//최종 합격 건수
	var allPassCount = 0;
	//최종 불합격 건수
	var allFailCount = 0;
	//공정별 불합격-수입검사
	var A01 = 0;
	//공정별 불합격-공정검사
	var A02 = 0;
	//공정별 불합격-완제품검사
	var A03 = 0;
	
	//그래프
	var ctx1 = document.getElementById('satateChart').getContext('2d');
	var chart1 = new Chart(ctx1, {
		type: 'doughnut',
		data: {
			labels: ['완료','진행율'],
			datasets: [{
				label: 'My First Dataset',
				data: [50, 50],
				backgroundColor: [
					'rgb(54, 162, 235)',
					'rgb(255, 205, 86)'
					],
					hoverOffset: 4
				}]
			},
		});
	
	var ctx2 = document.getElementById('finalPassChart').getContext('2d');
	var chart2 = new Chart(ctx2, {
		type: 'doughnut',
		data: {
			labels: ['합격','불합격'],
			datasets: [{
				label: 'My First Dataset',
				data: [50, 50],
				backgroundColor: [
					'rgb(54, 162, 235)',
					'rgb(255, 205, 86)'
					],
					hoverOffset: 4
				}]
			},
		});
	
	var ctx3 = document.getElementById('inspectionPass').getContext('2d');			
	var chart3 = new Chart(ctx3, {
		type: 'doughnut',
		data: {
			labels: ['수입검사','공정검사','완제품검사'],
			datasets: [{
				label: 'My First Dataset',
				data: [30, 30, 40],
				backgroundColor: [
					'rgb(54, 162, 235)',
					'rgb(255, 205, 86)',
					'rgb(120, 205, 86)'
					],
					hoverOffset: 4
				}]
			},
		});
	
	
	//품질검사 현황 조회
	$(document).on('click','#searchBtn',function(){
		
		//완료율 바
		var progressBar = '';
		var statusElement = $('#statusElement').find('input, select');
		html = '';
		
		//계약번호 필수 입력사항
		if($('#contractNum').val()==''){
			alert('계약번호를 입력해주세요.');
			$('#contractNum').focus();
			$('#contractNum').val('buyerContract002');
		}else{
			
			$.each(statusElement,function(){
				searchkey = $(this).attr('name');
				searchValue = $(this).val();
				
				if(searchValue != null && searchValue != undefined && searchValue != ''){
					searchObj[searchkey] = searchValue;
				}
				//console.log(searchObj);
			});
			

			var request = $.ajax({
				url: "/quality/qualityInspectionStatusNow",
				data: JSON.stringify(searchObj),
				contentType: "application/json",
				method: "POST",
				dataType: "json"
			});
			
			request.done(function( data ) {
				console.log(data);
				
				
				var request = $.ajax({
					  url: "script.php",
					  method: "POST",
					  data: { id : menuId },
					  dataType: "html"
					});
					 
					request.done(function( msg ) {
						
					});
					 
					request.fail(function( jqXHR, textStatus ) {
					  alert( "Request failed: " + textStatus );
					});
				
				$('.removeTr').remove();
				//원래 있던 progressBar 지우기
				$('#originalProgressBar').remove();
				//새로 생성된 progressBar 리셋
				$('.progress-bar').remove();
				
				if(data.length > 0){
					var html = '';
					for(var i = 0; i<data.length; i++){
						var requestDate = data[i].inspectionRequestDate;					
										
						//date 포맷 변경 yyyy-MM-dd hh:mm:ss
						function formatDate(requestDate) {
							var d = new Date(requestDate),
							month = '' + (d.getMonth() + 1),
							day = '' + d.getDate(),
							year = d.getFullYear(),
							hour = d.getHours(),
							min = d.getMinutes(),
							sec = d.getSeconds();
							
							if (month.length < 2) month = '0' + month;
							if (day.length < 2) day = '0' + day;
							
							return [year, month, day].join('-') + ' ' + [hour, min, sec].join(':');
						}
						
						var dateText = "/Date(1519794794410)/";
						var myDate = new Date(dateText.match(/\d+/) * 1);
						date = formatDate(myDate);
						
						//List
						html += '<tr class="removeTr">';
						html += '<th scope="row">'+ [i+1] + '</th>';
						html += '<td>'+ data[i].highClassName + '</td>';
						html += '<td>'+ data[i].lowClassName + '</td>';
						html += '<td>'+ data[i].subClassName + '</td>';
						html += '<td>'+ data[i].requestProductCode + '</td>';
						html += '<td>'+ data[i].detailedCateName + '</td>';
						html += '<td>'+ date + '</td>';
						html += '<td>'+ data[i].inspectionCategory + '</td>';
						html += '<td>'+ data[i].insFirst + '</td>';
						html += '<td>'+ data[i].insSecond + '</td>';
						html += '<td>'+ data[i].insThird + '</td>';
						html += '<td>'+ data[i].insStart + '</td>';
						html += '<td>'+ data[i].insEnd + '</td>';
						html += '<td>'+ data[i].finalPassCheck + '</td>';
						html += '</tr>';

						
					}
				}else{
					html += '<tr class="removeTr"><td colspan="15" style="text-align:center;">조회 결과가 없습니다.</td></tr>';
				}
				$('#mainTbody').append(html);
				
				//1번째 차트
				chart1.data.datasets[0].data=[progressRate, completeRate];
				chart1.data.labels=['완료 : '+progressRate,'진행율 : '+completeRate];
				chart1.update();
				
				//2번째 차트
				chart2.data.datasets[0].data=[allPassCount, allFailCount];
				chart2.data.labels=['합격 : '+allPassCount,'불합격 : '+allFailCount];
				chart2.update();
				
				//3번째 차트
				chart3.data.datasets[0].data=[A01, A02, A03];
				chart3.data.labels=['수입검사 : '+A01,'공정검사 : '+A02,'완제품검사 : '+A03];
				chart3.update();
			});
			
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});
		}
		
	});

	

	

	

	
});
