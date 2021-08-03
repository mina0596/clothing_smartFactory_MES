/**
 * 
 */
$(function(){
	
	// ****************************연도별 불량률 ****************************/
	myFunc();
	console.log('js에서 출력하는', failedPercent.twoPastYear);
	//데이터 setup 연도별 불량률 그래프
	const data = {
	  labels: [
	    failedPercent.threePastYear+'년',
	    failedPercent.twoPastYear+'년',
	    failedPercent.pastYear+'년',
	    failedPercent.currentYear+'년'
	  ],
	  datasets: [{
	    type: 'line',
	    label: '불량률%',
	    data: [failedPercent.threePastYearFailRate
			 , failedPercent.twoPastYearFailRate
			 , failedPercent.pastYearFailRate
			 , failedPercent.curFailRate],
	    fill: false,
	    borderColor: 'rgb(170, 240, 209)'
	  }]
	};	
	//option setup for 연도별 불량률 그래프
	const config = {
	  type: 'scatter',
	  data: data,
	  options: {
	    scales: {
	      y: {
	        beginAtZero: true
	      }
	    }
	  }
	};
	
	//연도별 불량률 그래프 그리기
	var ctx = document.getElementById('failedRateChartByYear');
	var failedRateChartByYear = new Chart(ctx, {
	    data: data,
	    options: config
	});
	
	
	// ****************************월별 불량률 ****************************/	
	

})