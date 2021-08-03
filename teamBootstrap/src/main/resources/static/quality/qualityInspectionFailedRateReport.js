/**
 * 
 */
$(function(){
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
	      'rgba(255, 99, 132, 0.7)',
	      'rgba(255, 159, 64, 0.7)',
	      'rgba(255, 205, 86, 0.7)',
	      'rgba(75, 192, 192, 0.7)'
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
	    label: '불량률%',
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
		    label: '불량률%',
		    data: inputData1,
		    backgroundColor: backGroundColor,
		    borderColor: borderColorArr,
		    borderWidth: 1
		  }]
		};
		
		failedRateChartByMonth.update();
		
		console.log(failedRateChartByMonth.data);
	})
	
	
	//lables = [];
	//inputData = [];

})