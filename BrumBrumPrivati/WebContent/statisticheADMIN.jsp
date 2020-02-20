<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- Serve a cambiare in jsp -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="zxx">

<head>


<%@ include file="include/headindex.jsp"%>
<%@ include file="include/NewHEADER.jsp"%>
<%@ include file="include/adminCSSstyle.jsp"%>
</head>

<style>
{
box-sizing
:
 
border-box
;


}

input[type="checkbox"] {
	vertical-align: middle;
	color: #ffffff;
}

#myInput {
	background-image: url('/css/searchicon.png');
	background-position: 10px 12px;
	background-repeat: no-repeat;
	width: 100%;
	font-size: 16px;
	padding: 12px 20px 12px 40px;
	border: 1px solid #ddd;
	margin-bottom: 12px;
}

#myUL {
	list-style-type: none;
	padding: 0;
	margin: 0;
}

#myUL li a {
	border: 1px solid #ddd;
	margin-top: -1px; /* Prevent double borders */
	background-color: #f6f6f6;
	padding: 12px;
	text-decoration: none;
	font-size: 18px;
	color: black;
	display: block
}

#myUL
li
a
:hover
:not
 (.header ) {
	background-color: #eee;
}
</style>

<style>
li {
	display: inline; ul { list-style-type : none;
	margin: 0;
	padding: 0;
}
}
</style>

<script type="text/javascript">
	function refresh() {

		var checkBox1 = document.getElementById("valore1");
		var checkBox2 = document.getElementById("valore2");
		var checkBox3 = document.getElementById("valore3");

		if (checkBox1.checked == true)
			getData(document.getElementById("valore1").value, 1);
		if (checkBox2.checked == true)
			getData(document.getElementById("valore2").value, 2);
		if (checkBox3.checked == true)
			getData(document.getElementById("valore3").value, 3);

		if (checkBox1.checked == false && checkBox2.checked == false
				&& checkBox3.checked == false)
			resetGraph();
	}
</script>

<script>
	function myFunction() {
		var input, filter, ul, li, a, i, txtValue;
		input = document.getElementById("myInput");
		filter = input.value.toUpperCase();
		ul = document.getElementById("myUL");
		li = ul.getElementsByTagName("li");
		for (i = 0; i < li.length; i++) {
			a = li[i].getElementsByTagName("a")[0];
			txtValue = a.textContent || a.innerText;
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				li[i].style.display = "";
			} else {
				li[i].style.display = "none";
			}
		}
	}
</script>

<script src="//code.jquery.com/jquery-1.8.3.js"></script>



<!-- Title Page-->
<title>Admin Dashboard</title>


<style>
.checkbox {
	margin-right: 5px;
	margin-bottom: 5px;
	font-size: 16px;
	
	
}

input[type="checkbox"] {

	background-color: #ffffff;

}

table {
	margin-top: 10px;
}

table tr {
	border-bottom: 1px solid #ddd;
}

table tr th {
	text-transform: uppercase;
	padding: 5px 10px;
}

table tr td {
	padding: 5px 30px;
	background: #ffffff;
}

table tr:nth-child(odd) {
	background: #eee;
}

body {
  background-color: white;
}

</style>



<body >
	<div class="page-wrapper" align="center">
		<!-- HEADER MOBILE-->

		<!-- END HEADER MOBILE-->

		<!-- MENU SIDEBAR-->

		<!-- END MENU SIDEBAR-->

		<!-- PAGE CONTAINER-->
		<div class="page-container">
			<!-- HEADER DESKTOP-->
			<!-- HEADER DESKTOP-->

			<!-- MAIN CONTENT-->
			<div class="main-content">

				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								<div class="overview-wrap">
									<h2 class="title-1">overview</h2>

								</div>
							</div>
						</div>
						<div class="row m-t-25">
							<div class="col-sm-6 col-lg-3">
								<div class="overview-item overview-item--c1">
									<div class="overview__inner">
										<div class="overview-box clearfix">
											<div class="icon">
												<i class="zmdi zmdi-account-o"></i>
											</div>


											<div class="text">
												<h2>${statistiche.getUtentiRegistrati()}</h2>
												<span>Utenti registrati</span>
											</div>
										</div>
										<div class="overview-chart">
											<canvas id="widgetChart1"></canvas>

											<!-- VARIABILI WIDGET 1 -->

											<input type="hidden" name="acquisto" id=acquisto
												value='${statistiche.getAutoAcquistate().size() }'>
											<input type="hidden" name="noleggio" id=noleggio
												value='${statistiche.getAutoNoleggiate().size() }'>

											<!-- VARIABILI WIDGET 1 -->

										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-lg-3">
								<div class="overview-item overview-item--c2">
									<div class="overview__inner">
										<div class="overview-box clearfix">
											<div class="icon">
												<i class="zmdi zmdi-shopping-cart"></i>
											</div>
											<div class="text">
												<h2>${statistiche.getAutoAcquistate().size()}</h2>
												<span>Ordini effettuati</span>
											</div>
										</div>
										<div class="overview-chart">
											<canvas id="widgetChart2"></canvas>

											<!-- VARIABILI WIDGET 2 -->

											<input type="hidden" name="acquistato" id=acquistato1
												value='${statistiche.getStoricoNumerAutoVendute()[0]}'>
											<input type="hidden" name="acquistato" id=acquistato2
												value='${statistiche.getStoricoNumerAutoVendute()[1]}'>
											<input type="hidden" name="acquistato" id=acquistato3
												value='${statistiche.getStoricoNumerAutoVendute()[2]}'>

											<!-- VARIABILI WIDGET 2 -->

										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-lg-3">
								<div class="overview-item overview-item--c3">
									<div class="overview__inner">
										<div class="overview-box clearfix">
											<div class="icon">
												<i class="zmdi zmdi-calendar-note"></i>
											</div>
											<div class="text">
												<h2>${statistiche.getQuestoMese()}</h2>
												<span>Questo mese</span>
											</div>
										</div>
										<div class="overview-chart"></div>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-lg-3">
								<div class="overview-item overview-item--c4">
									<div class="overview__inner">
										<div class="overview-box clearfix">
											<div class="icon">
												<i class="zmdi zmdi-money"></i>
											</div>
											<div class="text">
												<h2>${statistiche.getTotaleIncassi()}</h2>
												<span>Totale incassi</span>
											</div>
										</div>
										<div class="overview-chart">
											<canvas id="widgetChart4"></canvas>

											<!-- VARIABILI WIDGET 4 -->

											<input type="hidden" name="incasso1" id=incasso1
												value='${statistiche.getStoricoIncassoMese()[0]}'> <input
												type="hidden" name="incasso2" id=incasso2
												value='${statistiche.getStoricoIncassoMese()[1]}'> <input
												type="hidden" name="incasso3" id=incasso3
												value='${statistiche.getStoricoIncassoMese()[2]}'>


											<!-- VARIABILI WIDGET 4 -->


										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="au-card recent-report">
									<div class="au-card-inner">
										<h3 class="title-2">recent reports</h3>
										<div class="form-row"></div>
										<div class="chart-info">
											<div class="chart-info__left">
												<div class="chart-note">
													<span class="dot dot--blue"></span> <span>Acquisto</span>
												</div>
												<div class="chart-note mr-0">
													<span class="dot dot--green"></span> <span>Noleggio</span>
												</div>
											</div>
											<div class="chart-info__right">
												<div class="chart-statis">
													<span class="index incre"> </span>
												</div>
												<div class="chart-statis mr-0"></div>
											</div>
										</div>
										<div class="recent-report__chart">
											<canvas id="recent-rep-chart"></canvas>

											<!-- variabili grafico a mare -->

											<input type="hidden" name="acquisto" id=acquisto
												value='${statistiche.getAutoAcquistate().size() }'>
											<input type="hidden" name="noleggio" id=noleggio
												value='${statistiche.getAutoNoleggiate().size() }'>

											<!-- variabili grafico a mare -->
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="au-card chart-percent-card">
									<div class="au-card-inner">
										<h3 class="title-2 tm-b-5">char by %</h3>
										<div class="row no-gutters">
											<div class="col-xl-6">
												<div class="chart-note-wrap">
													<div class="chart-note mr-0 d-block">
														<span class="dot dot--blue"></span> <span>Acquisto</span>
													</div>
													<div class="chart-note mr-0 d-block">
														<span class="dot dot--red"></span> <span>Noleggio</span>
													</div>
												</div>
											</div>
											<div class="col-xl-6">
												<div class="percent-chart">
													<canvas id="percent-chart"></canvas>

													<!-- variabili grafico a torta pan di stelle -->

													<input type="hidden" name="acquisto" id=acquisto
														value='${statistiche.getAutoAcquistate().size() }'>
													<input type="hidden" name="noleggio" id=noleggio
														value='${statistiche.getAutoNoleggiate().size() }'>

													<!-- variabili grafico a torta pan di stelle -->

												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="form-row"></div>
						
						
						
						<div class="row">
							<div class="col-lg-12">
								<div class="au-card-title"
									style="background-image: url('images/bg-title-01.jpg');">
									<div class="bg-overlay bg-overlay--blue"></div>
									<h3>
										<i class="zmdi zmdi-account-calendar"></i>Storico ordini
									</h3>
								</div>
								<div class="table-responsive table--no-card m-b-40">
								<div class="form-row"></div>
									<div class="container">
										<div class="col-md-8 col-md-offset-2">
											<input type="text" id="myInput" onkeyup="myFunction()"
												placeholder="Cerca per caratteristiche...">
										</div>
										<div class="form-row"></div>
									</div>
									<table class="table table-striped">
										<ul id="myUL">
											<c:forEach items="${statistiche.getAutoAcquistate()}"
												var="automobile">
												<li><a href="#"> ${automobile.marca} |
														${automobile.modello} | ${automobile.categoria} |
														${automobile.colore} | ${automobile.alimentazione} |
														${automobile.cambio}</a></li>
											</c:forEach>
										</ul>
									</table>
								</div>
							</div>
						</div>

						<div class="form-row"></div>
						
						<div class="row">
						<div class="col-lg-12">
							<div class="au-card au-card--no-shadow au-card--no-pad m-b-40">
							<div class="au-card-title"
									style="background-image: url('images/bg-title-01.jpg');">
									<div class="bg-overlay bg-overlay--blue"></div>
									<h3>
										<i class="zmdi zmdi-account-calendar"></i>Grafico auto vendute in base ai mesi
									</h3>
									
								</div>
					<table>
					<tr>
						<td><input type="checkbox" id="valore1" name="vehicle1"
							value='${statistiche.getStoricoNumerAutoVendute()[0]}'
							onclick="refresh()"> <label for="vehicle1">Gennaio</label></td>

						<td><input type="checkbox" id="valore2" name="vehicle1"
							value='${statistiche.getStoricoNumerAutoVendute()[1]}'
							onclick="refresh()"> <label for="vehicle1">Febbraio</label></td>
						
						<td><input type="checkbox" id="valore3" name="vehicle1"
							value='${statistiche.getStoricoNumerAutoVendute()[3]}'
							onclick="refresh()"> <label for="vehicle1">Marzo</label></td>
					</tr>
					</table>
					</div>
					</div>
					</div>
						<div style="width: 50%;">
							<canvas id="mycanvas"></canvas>
						</div>
					</div>
<div class="form-row">
</div><div class="form-row"></div>
					<div class="row">
						<div class="col-lg-12">
							<div class="au-card au-card--no-shadow au-card--no-pad m-b-40">
								<div class="au-card-title"
									style="background-image: url('images/bg-title-01.jpg');">
									<div class="bg-overlay bg-overlay--blue"></div>
									<h3>
										<i class="zmdi zmdi-account-calendar"></i>Feedback
									</h3>
								</div>
								<div>
									<c:forEach items="${statistiche.getListaFeedback()}"
										var="feedback">
										<div>
											<div>
												<div class="au-task__item-inner">
													<h5 class="task">
														<a href="#">${feedback.getCommento()}</a>
													</h5>

													<span>${feedback.getData()}</span> <span>by
														${feedback.getUser()}</span>

												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12"></div>
					</div>

				</div>
			</div>
		</div>

	</div>

	<!-- Jquery JS-->
	<script src="admin/vendor/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap JS-->
	<script src="admin/vendor/bootstrap-4.1/popper.min.js"></script>
	<script src="admin/vendor/bootstrap-4.1/bootstrap.min.js"></script>
	<!-- Vendor JS       -->
	<script src="admin/vendor/slick/slick.min.js">
		
	</script>
	<script src="admin/vendor/wow/wow.min.js"></script>
	<script src="admin/vendor/animsition/animsition.min.js"></script>
	<script
		src="admin/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
		
	</script>
	<script src="admin/vendor/counter-up/jquery.waypoints.min.js"></script>
	<script src="admin/vendor/counter-up/jquery.counterup.min.js">
		
	</script>
	<script src="admin/vendor/circle-progress/circle-progress.min.js"></script>
	<script src="admin/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
	<script src="admin/vendor/chartjs/Chart.bundle.min.js"></script>
	<script src="admin/vendor/select2/select2.min.js">
		
	</script>

	<script src="admin/js/main.js"></script>
</body>

<footer>
	<%@ include file="include/TEMPLATE-FOOTER.jsp"%>
</footer>
<!-- Footer Section End -->



<script type="text/javascript"></script>

<!-- Js Plugins -->
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/mixitup.min.js"></script>
<script src="js/main.js"></script>

<script
	src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js'></script>
<script src="js/chart.js"></script>

</html>