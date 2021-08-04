/**
 * 
 */
$(function(){
	$('.tabBtn').click(function(){
		
	});
	
	$('.yearBtn').click(function(){
		var yearText = $(this).text();
		$('.yearTabBtn').parent().removeClass('active');
		$(this).parents().find('.tab-pane').removeClass('active');
		$('#byMonths').addClass('active');
		$('.monthTabBtn').parent('li').addClass('active');
		$('.selectedYear').val(yearText).trigger('change');
		
	});
	
	
	
	
	/*******************************그래프에 관한 스크립트*************************** */
	myFunc();
	console.log('js에서 출력하는', yearlyFailInfo);
	
	//데이터 setup 연도별 불량률 그래프
	const lables = [];
	const inputData = [];
	var backGroundColor = [];
	var borderColorArr = [];
	for(var i=0; i<yearlyFailInfo.length; i++){
		lables.push(yearlyFailInfo[i].year + '년');
		inputData.push(yearlyFailInfo[i].failRate);
	}
	
	console.log(lables);
	const data = {
	  labels: lables,
	  datasets: [{
		type: 'bar',
	    label: '불량률%',
	    data: inputData,
	    backgroundColor: [
	      'rgba(255, 99, 132, 0.5)',
	      'rgba(255, 159, 64, 0.5)',
	      'rgba(255, 205, 86, 0.5)',
	      'rgba(75, 192, 192, 0.5)'
	    ],
	    borderColor: [
	      'rgb(255, 99, 132)',
	      'rgb(255, 159, 64)',
	      'rgb(255, 205, 86)',
	      'rgb(75, 192, 192)'
	    ],
	    borderWidth: 1
	  }]
	};
	//option setup for 연도별 불량률 그래프
	const config = {
	  type: 'bar',
	  data: data,
	  options: {
		animation:{
				duration:0
		},
	    scales: {
	      y: {
	        beginAtZero: true
	      }
	    }
	  },
	};
			
	//연도별 불량률 그래프 그리기
	var ctx = document.getElementById('failedRateChartByYear').getContext('2d');
	var failedRateChartByYear = new Chart(ctx, {
	    data: data,
	    options: config
	});
	
	
	
	/********************************************************************* */
	var labels1 = [];
	var inputData1 = [];
	for(var i=0; i < monthlyFailInfo.length; i++){
		if(monthlyFailInfo[i].year == '2021'){
			labels1.push(monthlyFailInfo[i].month + '월');
			inputData1.push(monthlyFailInfo[i].failRate);
			backGroundColor.push('rgba(153, 102, 255, 0.2)');
			borderColorArr.push('rgb(153, 102, 255)');
		}
	}
	
	var data1 = {
	  labels: labels1,
	  datasets: [{
		type: 'bar',
	    label: '2021년 불량률%',
	    data: inputData1,
	    backgroundColor: backGroundColor,
	    borderColor: borderColorArr,
	    borderWidth: 1
	  }]
	};
	
	var ctx1 = document.getElementById('failedRateChartByMonth').getContext('2d');
	var failedRateChartByMonth = new Chart(ctx1, {
		data: data1,
	    options: config
	});
	
	/********************   월별 불량률	********************/
	$('.selectedYear').change(function(){
		$('.removeTr').remove();
		labels1 = [];
		inputData1 = [];
		backGroundColor = [];
		gorderColorArr = [];
		data1 = {};
		failedRateChartByMonth.update();
		selectedYear = $(this).val();
		console.log('선택된 연도는 :', selectedYear);
		for(var i=0; i < monthlyFailInfo.length; i++){
			if(monthlyFailInfo[i].year == selectedYear){
				labels1.push(monthlyFailInfo[i].month + '월');
				inputData1.push(monthlyFailInfo[i].failRate);
				backGroundColor.push('rgba(153, 102, 255, 0.2)');
				borderColorArr.push('rgb(153, 102, 255)');
			}
		}
		console.log('inputData: ', inputData1);
		console.log('lables: ', labels1);
		data1 = {
		  	labels: labels1,
		  	datasets: [{
			type: 'bar',
		    label: selectedYear + '년 불량률%',
		    data: inputData1,
		    backgroundColor: backGroundColor,
		    borderColor: borderColorArr,
		    borderWidth: 1
		  }]
		};
		failedRateChartByMonth.data = data1;
		failedRateChartByMonth.update();
		
		console.log(failedRateChartByMonth);
		
		var param = {selectedYear : selectedYear};
		console.log('param으로 확인:', param);
		console.log('JSON변형으로 확인:', JSON.stringify(param));
		//아래에 테이블 결과표
		var request = $.ajax({
			  url: "/quality/addFailRank",
			  method: "POST",
			  traditional: true,
			  data : JSON.stringify(param),
			  contentType: 'application/json',
			  dataType: "json"
			});
			
		var html = '';
		request.done(function( monthlyFailRank ) {
			console.log('monthlyFailRank: ', monthlyFailRank);
			if(monthlyFailRank.length > 0){
				for(var i=0; i < monthlyFailRank.length; i++){
					html += '<tr class="removeTr">';
					html += '<td>' + monthlyFailRank[i].realRank + '</td>';
					html += '<td>' + monthlyFailRank[i].month + '</td>';
					html += '<td>' + monthlyFailRank[i].inspectionCode + '</td>';
					html += '<td>' + monthlyFailRank[i].highName + '</td>';
					html += '<td>' + monthlyFailRank[i].medName + '</td>';
					html += '<td>' + monthlyFailRank[i].lowName + '</td>';
					html += '<td>' + monthlyFailRank[i].subName + '</td>';
					html += '<td>' + monthlyFailRank[i].totalNum + '</td>';
					html += '<td>' + monthlyFailRank[i].failNum + '</td>';
					html += '<td>' + monthlyFailRank[i].failRatePercent + '</td>';
					html += '</tr>';
				}
			}else{
				$('.removeTr').remove();
				html += '<tr class="removeTr"><td colspan="15" style="text-align: center;"> 검색된 결과가 없습니다. </td></tr>';
			}
			$('#resultTableBody').append(html);	
		});
		request.fail(function( jqXHR, textStatus ) {
			alert( "연도를 다시 선택해주세요." + textStatus );
		});
		
	
	
	//lables = [];
	//inputData = [];
	});
	
	/**************************품질검사별 불량률****************************/
	$('.inspectionTabBtn').click(function(){
		console.log('확인해보자');
		
	})
})