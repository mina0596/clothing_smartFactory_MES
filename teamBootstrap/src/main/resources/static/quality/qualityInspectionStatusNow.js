/**
 * 
 */
$(function(){
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
	//완료율 바
	var progressBar = '';
	
	$('#searchBtn').click(function(){	
		$('#removeTr').remove();
		$('#originalProgressBar').remove();
		var request = $.ajax({
			url: "/quality/qualityInspectionStatusNow",
			method: "POST",
			dataType: "json"
		});
		
		request.done(function( data ) {
			console.log(data);
			
			//수주계약번호		
			contractCode = data[0].contractCode;
			//품질검사 요청 총갯수
			requestCount = data[0].requestCount;
			//최종 불합격 총갯수
			finalFailCount = data[0].finalFailCount;
			//최종 합격 총갯수
			finalPassCount = data[0].finalPassCount;
			//최종 완료 갯수
			finalCompleteCount = data[0].finalCompleteCount;
			//완료율
			completeRate = requestCount/finalCompleteCount;
			//진행건수
			progressRate = data[0].progressRate;
			//완료율바
			progressBar += '<div class="progress-bar" role="progressbar" aria-valuenow="' + completeRate +'" aria-valuemin="0"'; 
			progressBar += 'aria-valuemax="100" style="width: ' + completeRate +'%"><span class="sr-only">' + completeRate +'% Complete</span>';
			
			$('#stateMain').val(contractCode);
			$('#requestCount').val(requestCount);
			$('#finalCompleteCount').val(finalCompleteCount);
			$('#completeRate').val(completeRate);
			$('#progressRate').val(progressRate);
			$('#progressBar').append(progressBar);
			
			var html = '';
			var j = 1;
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
				html += '<tr>';
				html += '<th scope="row">'+ j++ + '</th>';
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
				html += '<td>없음</td>';
				html += '</tr>';
			}
			$('#mainTbody').append(html);
		});
		
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});
	});
	
	//그래프
	var ctx = document.getElementById('myChart0').getContext('2d');
	var data  = {
			type: 'doughnut',
			data: {
				labels: [
					'완료',
					'진행율'
					],
					datasets: [{
						label: 'My First Dataset',
						data: [37, 3],
						backgroundColor: [
							'rgb(54, 162, 235)',
							'rgb(255, 205, 86)'
							],
							hoverOffset: 4
					}]
			},
	};
	
	var chart = new Chart(ctx, data);
	
	
	var ctx = document.getElementById('myChart').getContext('2d');
	var data  = {
			type: 'doughnut',
			data: {
				labels: [
					'합격',
					'불합격'
					],
					datasets: [{
						label: 'My First Dataset',
						data: ['20', '1'],
						backgroundColor: [
							'rgb(54, 162, 235)',
							'rgb(255, 205, 86)'
							],
							hoverOffset: 4
					}]
			},
	};
	
	var chart = new Chart(ctx, data);
	
	var ctx2 = document.getElementById('myChart2').getContext('2d');
	var data2  = {
			type: 'doughnut',
			data: {
				labels: [
					'수입검사',
					'공정검사',
					'완제품검사'
					],
					datasets: [{
						label: 'My First Dataset',
						data: [20, 30, 10],
						backgroundColor: [
							'rgb(54, 162, 235)',
							'rgb(255, 205, 86)',
							'rgb(120, 205, 86)'
							],
							hoverOffset: 4
					}]
			},
	};
	
	var chart2 = new Chart(ctx2, data2);
	
});
