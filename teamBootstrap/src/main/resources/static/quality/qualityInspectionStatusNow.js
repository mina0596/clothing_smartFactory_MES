/**
 * 
 */
$(function(){
	
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
						data: [50, 100],
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
						data: [50, 100],
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
					'완재품검사'
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
