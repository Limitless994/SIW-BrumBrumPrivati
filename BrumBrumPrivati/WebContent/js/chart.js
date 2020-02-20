//used for example purposes
function getArrayElementInPosition(k) {
	
	var acquistate1 = document.getElementById("valore1");
	var acquistate2 = document.getElementById("valore1");
	var acquistate3 = document.getElementById("valore3");

	var points = [acquistate1.value, acquistate2.value, acquistate3.value];
  
  return points[k];
}

function resetGraph() {
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
		        label: "Auto vendute"
		      }
		    ]
		  },
		  options: {
		    responsive: true,
		    title: {
		      display: true,
		      text: "Statistiche auto vendute in quest'anno."
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
}

function giveMeMonth(idMonth) {
	if(idMonth==1) return "Gennaio";
	if(idMonth==2) return "Febbraio";
	if(idMonth==3) return "Marzo";
	if(idMonth==4) return "Aprile";
	if(idMonth==5) return "Maggio";
	if(idMonth==6) return "Giugno";
	if(idMonth==7) return "Luglio";
	if(idMonth==8) return "Agosto";
	if(idMonth==9) return "Settembre";
	if(idMonth==10) return "Ottobre";
	if(idMonth==11) return "Novembre";
	if(idMonth==12) return "Dicembre";

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
        label: "Auto vendute"
      }
    ]
  },
  options: {
    responsive: true,
    title: {
      display: true,
      text: "Statistiche auto vendute in questo trimestre."
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

var getData = function(t,idMonth) {
	var postId = 0;
	resetGraph(); //generalizzata perché serve nel jsp per resettare in caso di tutti false sulle checkbox
  $.ajax({
    success: function(data) {
      myChart.data.labels.push(giveMeMonth(idMonth)); //funzione givememoth, dato un id restituisce la stringa con il nome del mese
      myChart.data.datasets[0].data.push(t);
      myChart.update();
      
    }
  });
};