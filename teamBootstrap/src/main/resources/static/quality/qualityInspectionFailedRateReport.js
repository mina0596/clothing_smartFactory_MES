/**
 * 
 */
$(function(){
	myFunc();
	console.log('js에서 출력하는', failedPercent.twoPastYear);
	//데이터 setup 연도별 불량률 그래프
	const DATA_COUNT = 4;
	const NUMBER_CFG = {count: DATA_COUNT, min: 0, max: 100};
	const labels = [failedPercent.threePastYear+'년', failedPercent.twoPastYear+'년', failedPercent.pastYear+'년',failedPercent.currentYear+'년'];
	
	const data = {
	  labels: labels,
	  datasets: [{
	    type: 'line',
	    label: '불량률%',
	    data: [ {
	        label: 'Dataset 1',
	        data: failedPercent.threePastYearFailRate + '%',
	        backgroundColor: 'rgb(170, 240, 209)',
	      },
	      {
	        label: 'Dataset 2',
	        data: failedPercent.twoPastYearFailRate + '%',
	        backgroundColor: 'rgb(62, 180, 137)',
	      },
	      {
	        label: 'Dataset 3',
	        data: failedPercent.pastYearFailRate + '%',
	        backgroundColor: 'rgb(192, 255, 238)',
	      },
	      {
	    	label: 'Dataset 4',
	    	data: failedPercent.currentYearFailRate + '%',
	    	backgroundColor: 'rgb(42, 193, 188)',
	      }],
	    fill: false,
	    borderColor: 'rgb(170, 240, 209)'
	  }]
	};	
	//option setup for 연도별 불량률 그래프
	const config = {
	  type: 'bar',
	  data: data,
	  options: {
		  plugins: {
		    title: {
		        display: true,
		        text: 'Chart.js Bar Chart - Stacked'
		      },
		    },
		    responsive: true,
		    scales: {
		      x: {
		        stacked: true,
		      },
		      y: {
		        stacked: true
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
	
	
		

})