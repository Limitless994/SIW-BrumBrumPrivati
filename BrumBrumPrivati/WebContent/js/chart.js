//used for example purposes
function getArrayElementInPosition(k) {
	
	var acquistate1 = document.getElementById("valore1");
	var acquistate2 = document.getElementById("valore1");
	var acquistate3 = document.getElementById("valore3");

	var points = [acquistate1.value, acquistate2.value, acquistate3.value];
  
  return points[k];
}



//create initial empty chart
var ctx_live = document.getElementById("mycanvas");
var myChart = new Chart(ctx_live, {
  type: "bar",
  data: {
    labels: [],
    datasets: [
      {
        data: [],
        borderWidth: 1,
        borderColor: "#00c0ef",
        label: "liveCount"
      }
    ]
  },
  options: {
    responsive: true,
    title: {
      display: true,
      text: "Chart.js - Dynamically Update Chart Via Ajax Requests"
    },
    legend: {
      display: false
    },
    scales: {
      yAxes: [
        {
          ticks: {
            beginAtZero: true
          }
        }
      ]
    }
  }
});
var empty = new Chart(ctx_live, {
	  type: "bar",
	  data: {
	    labels: [],
	    datasets: [
	      {
	        data: [],
	        borderWidth: 1,
	        borderColor: "#00c0ef",
	        label: "liveCount"
	      }
	    ]
	  },
	  options: {
	    responsive: true,
	    title: {
	      display: true,
	      text: "Chart.js - Dynamically Update Chart Via Ajax Requests"
	    },
	    legend: {
	      display: false
	    },
	    scales: {
	      yAxes: [
	        {
	          ticks: {
	            beginAtZero: true
	          }
	        }
	      ]
	    }
	  }
	});
//this post id drives the example data


//logic to get new data
var getData = function(t) {
	var postId = 1;
	myChart.destroy();
	myChart=new Chart(ctx_live, {
		  type: "bar",
		  data: {
		    labels: [],
		    datasets: [
		      {
		        data: [],
		        borderWidth: 1,
		        borderColor: "#00c0ef",
		        label: "liveCount"
		      }
		    ]
		  },
		  options: {
		    responsive: true,
		    title: {
		      display: true,
		      text: "Chart.js - Dynamically Update Chart Via Ajax Requests"
		    },
		    legend: {
		      display: false
		    },
		    scales: {
		      yAxes: [
		        {
		          ticks: {
		            beginAtZero: true
		          }
		        }
		      ]
		    }
		  }
		});
  $.ajax({
    success: function(data) {
      // process your data to pull out what you plan to use to update the chart
      // e.g. new label and a new data point

      // add new label and data point to chart's underlying data structures
      myChart.data.labels.push("Mese " + postId++);
      myChart.data.datasets[0].data.push(t);
      // re-render the chart
      myChart.update();
      
    }
  });
};

//get new data every 3 seconds