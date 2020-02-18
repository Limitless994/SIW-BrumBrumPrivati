<!DOCTYPE html>
<html lang="zxx">

<head>



<style>
li {
	display: inline; ul { list-style-type : none;
	margin: 0;
	padding: 0;
}
}
</style>
<script src="//code.jquery.com/jquery-1.8.3.js"></script>

<%@ include file="include/headindex.jsp"%>
<%@ include file="include/NewHEADER.jsp"%>

<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">
<meta name="author" content="Hau Nguyen">
<meta name="keywords" content="au theme template">

<!-- Title Page-->
<title>Dashboard</title>

<!-- Fontfaces CSS-->
<link href="admin/css/font-face.css" rel="stylesheet" media="all">
<link href="admin/vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<link href="admin/vendor/font-awesome-5/css/fontawesome-all.min.css"
	rel="stylesheet" media="all">
<link
	href="admin/vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">

<!-- Bootstrap CSS-->
<link href="admin/vendor/bootstrap-4.1/bootstrap.min.css"
	rel="stylesheet" media="all">

<!-- Vendor CSS-->
<link href="admin/vendor/animsition/animsition.min.css" rel="stylesheet"
	media="all">
<link
	href="admin/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet" media="all">
<link href="admin/vendor/wow/animate.css" rel="stylesheet" media="all">
<link href="admin/vendor/css-hamburgers/hamburgers.min.css"
	rel="stylesheet" media="all">
<link href="admin/vendor/slick/slick.css" rel="stylesheet" media="all">
<link href="admin/vendor/select2/select2.min.css" rel="stylesheet"
	media="all">
<link href="admin/vendor/perfect-scrollbar/perfect-scrollbar.css"
	rel="stylesheet" media="all">

<!-- Main CSS-->
<link href="admin/css/theme.css" rel="stylesheet" media="all">

</head>


<body class="animsition">
	<form action="CaricaStatAdmin">
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
													value='${statistiche.getStoricoIncassoMese()[0]}'>
												<input type="hidden" name="incasso2" id=incasso2
													value='${statistiche.getStoricoIncassoMese()[1]}'>
												<input type="hidden" name="incasso3" id=incasso3
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
							<div class="row">
								<div class="col-lg-12">
									<h2 class="title-1 m-b-25">Storico ordini</h2>
									<div class="table-responsive table--no-card m-b-40">
										<table
											class="table table-borderless table-striped table-earning">
											<thead>
												<tr align="center">
													<th>Data Ordine</th>
													<th>Targa</th>
													<th>Marca</th>
													<th>Modello</th>
													<th>Categoria</th>
													<th>Colore</th>
													<th>Chilometri</th>
													<th>Alimentazione</th>
													<th>Cambio</th>
													<th>Tipo ordine</th>
													<th>Totale</th>

													<c:forEach items="${statistiche.getAutoAcquistate()}"
														var="automobile">
														<tr align="center">
															<td>${automobile.getData()}</td>
															<td>${automobile.getTarga()}</td>
															<td>${automobile.marca}</td>
															<td>${automobile.modello}</td>
															<td>${automobile.categoria}</td>
															<td>${automobile.colore}</td>
															<td>${automobile.km}</td>
															<td>${automobile.alimentazione}</td>
															<td>${automobile.cambio}</td>

															<c:if test="${automobile.disponibilita == 'VENDUTA'}">
																<td>Acquisto</td>
																<td>${automobile.prezzovendita}</td>
															</c:if>
															<c:if test="${automobile.disponibilita == 'NOLEGGIATA'}">
																<td>Noleggio</td>
																<td>${automobile.prezzonoleggio}</td>
															</c:if>

														</tr>

													</c:forEach>
													<c:forEach items="${statistiche.getAutoNoleggiate()}"
														var="automobile">
														<tr align="center">
															<td>${automobile.getData()}</td>
															<td>${automobile.getTarga()}</td>
															<td>${automobile.marca}</td>
															<td>${automobile.modello}</td>
															<td>${automobile.categoria}</td>
															<td>${automobile.colore}</td>
															<td>${automobile.km}</td>
															<td>${automobile.alimentazione}</td>
															<td>${automobile.cambio}</td>

															<c:if test="${automobile.disponibilita == 'VENDUTA'}">
																<td>Acquisto</td>
																<td>${automobile.prezzovendita}</td>
															</c:if>
															<c:if test="${automobile.disponibilita == 'NOLEGGIATA'}">
																<td>Noleggio</td>
																<td>${automobile.prezzonoleggio}</td>
															</c:if>

														</tr>

													</c:forEach>
											</tbody>
										</table>
									</div>
								</div>

							</div>
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
										<div class="au-task js-list-load">
											<c:forEach items="${statistiche.getListaFeedback()}"
												var="feedback">
												<div class="au-task-list js-scrollbar3">
													<div class="au-task_item au-task_item--danger">
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
								<div class="row">
									<div class="col-md-12"></div>
								</div>
							</div>
						</div>
					</div>
					<!-- END MAIN CONTENT-->
					<!-- END PAGE CONTAINER-->
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

			<!-- Main JS-->
			<script src="admin/js/main.js"></script>
	</form>



</body>

<footer>
	<%@ include file="include/TEMPLATE-FOOTER.jsp"%>
</footer>
<!-- Footer Section End -->
<script type="text/javascript">
	
</script>
<!-- Js Plugins -->
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/mixitup.min.js"></script>
<script src="js/main.js"></script>




</html>