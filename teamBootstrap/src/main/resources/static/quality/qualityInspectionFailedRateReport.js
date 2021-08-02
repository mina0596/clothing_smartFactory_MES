/**
 * 
 */
$(function(){
	myFunc();
	console.log('js에서 출력하는', failedPercent.twoPastYear);
	console.log('js에서 출력하는', failRateDetail);
	//데이터 setup 연도별 불량률 그래프
	const DATA_COUNT = 4;
	const NUMBER_CFG = {count: DATA_COUNT, min: 0, max: 100};
	const labels = [failedPercent.threePastYear+'년', failedPercent.twoPastYear+'년', failedPercent.pastYear+'년',failedPercent.currentYear+'년'];
	
	var fistPlaceObj = {subName: [],
						failRate: []};
	var secondPlaceObj = {subName: [],
						  failRate: []};
	var thirdPlaceObj = {subName: [],
						failRate: []};
	var forthPlaceObj = {subName: [],
						failRate: []};
	var fifthPlaceObj = {subName: [],
						failRate: []};
	
	for(var i=0; i<failRateDetail.length; i++){
		if(failRateDetail[i].realRank == '1위'){
			console.log(failRateDetail[i]);
			fistPlaceObj.subName.push(failRateDetail[i].subName);
			fistPlaceObj.failRate.push(failRateDetail[i].failRate);
		}else if(failRateDetail[i].realRank == '2위'){
			secondPlaceObj.subName.push(failRateDetail[i].subName);
			secondPlaceObj.failRate.push(failRateDetail[i].failRate);
		}else if(failRateDetail[i].realRank == '3위'){
			thirdPlaceObj.subName.push(failRateDetail[i].subName);
			thirdPlaceObj.failRate.push(failRateDetail[i].failRate);
		}else if(failRateDetail[i].realRank == '4위'){
			forthPlaceObj.subName.push(failRateDetail[i].subName);
			forthPlaceObj.failRate.push(failRateDetail[i].failRate);
		}else if(failRateDetail[i].realRank == '5위'){
			fifthPlaceObj.subName.push(failRateDetail[i].subName);
			fifthPlaceObj.failRate.push(failRateDetail[i].failRate);
		}
	}
	console.log('obejct에 담은 1위 정보들:', fistPlaceObj);
	console.log(JSON.stringify(fistPlaceObj.subName));
	const data = {
			  labels: labels,
			  datasets: [
				  {
			        label: '1위', 
			        data: fistPlaceObj.subName,
			        backgroundColor: 'rgb(170, 240, 209)'
			      },
			      {
			        label: '2위',
			        data: secondPlaceObj.subName,
			        backgroundColor: 'rgb(62, 180, 137)',
			      },
			      {
			        label: '3위',
			        data: thirdPlaceObj.subName,
			        backgroundColor: 'rgb(192, 255, 238)',
			      },
			      {
			    	label: '4위',
			    	data: forthPlaceObj.subName,
			    	backgroundColor: 'rgb(42, 193, 188)',
			      },
			      {
			    	label: '5위',
			    	data: fifthPlaceObj.subName,
			    	backgroundColor: 'rgb(42, 193, 188)',
			      }],
			    borderColor: 'rgb(170, 240, 209)'
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