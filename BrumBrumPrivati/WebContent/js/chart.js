//used for example purposes
function getRandomIntInclusive(k) {
	var points = [4, 10, 1, 5, 25, 10];
	return points[k];
}

//create initial empty chart
var ctx_live = document.getElementById("mycanvas");
var myChart = new Chart(ctx_live, {
	type: 'bar',
	data: {
		labels: [],
		datasets: [{
			data: [],
			borderWidth: 1,
			borderColor:'#00c0ef',
			label: 'liveCount',
		}]
	},
	options: {
		responsive: true,
		title: {
			display: true,
			text: "Chart.js - Dynamically Update Chart Via Ajax Requests",
		},
		legend: {
			display: false
		},
		scales: {
			yAxes: [{
				ticks: {
					beginAtZero: true,
				}
			}]
		}
	}
});

//this post id drives the example data
var postId = 1;

//logic to get new data
var getData = function() {
	$.ajax({
		url: 'https://jsonplaceholder.typicode.com/posts/' + postId + '/comments',
		success: function(data) {
			// process your data to pull out what you plan to use to update the chart
			// e.g. new label and a new data point

			// add new label and data point to chart's underlying data structures
			myChart.data.labels.push("Mese " + postId++);
		      myChart.data.datasets[0].data.push(getRandomIntInclusive(postId));

			// re-render the chart
			myChart.update();
		}
	});
};

//get new data every 3 seconds
setInterval(getData, 500);