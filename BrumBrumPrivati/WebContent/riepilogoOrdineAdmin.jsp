<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zxx">

<head>
<%@ include file="include/headindex.jsp"%>
<%@ include file="include/NewHEADER.jsp"%>
</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Search model -->
	<div class="search-model">
		<div class="h-100 d-flex align-items-center justify-content-center">
			<div class="search-close-switch">+</div>
			<form class="search-model-form">
				<input type="text" id="search-input" placeholder="Search here.....">
			</form>
		</div>
	</div>
	<!-- Search model end -->


	<script> String nome=${nome};</script>
	<!-- TITLE -->
	<form method="post" action="CompraAuto">
		<section class="page-add">
			<h2 align="center">
				<b>RIEPOLOGO ORDINE ADMIN </b>
			</h2>
		</section>
		<!-- End  title-->


		<!--Dati Utente-->
		<section>
			<div class="row justify-content-between">
				<div class="col-4">
					<b>Dati acquirente </b>
					<p>${DR.nome}
						${DR.cognome} <br> ${DR.indirizzo} <br> ${DR.email}
					</p>
				</div>
				<div class="col-4">
					<b>Dati pagamento </b>
					<p>${DR.pagamento}</p>
				</div>
			</div>
		</section>
		<!--fine Dati Utente-->

		<div style='margin-top: 25px;'></div>

		<section>
			<!--dati automobile-->
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">PRODOTTO</th>
						<th scope="col">DETTAGLI</th>
						<th scope="col">PREZZO</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td><img src="${DR.getImmagine()}" height=15% width=22%></td>
						<td>${DR.getMarca()}${DR.getModello()} ${DR.getColore()}</td>
						<td>${DR.getPrezzovendita()}</td>
					</tr>

					<tr>
						<td colspan="3"><strong> Prezzo Totale</strong></td>

						<td>${DR.getPrezzovendita()}</td>
					</tr>
				</tbody>
			</table>
			<!-- fine dati automobile-->
		</section>
	</form>

	<!-- bottone conferma ordine -->
	<section>
		<div align="center">
			<form method="post" action="statisticheADMIN.jsp">
				<button class="btn btn--radius-2 btn--red">Indietro</button>
			</form>
			<div class="form-row"></div>
		</div>
	</section>
	<div class="form-row"></div>

	<!-- Footer -->
	<footer>
		<%@ include file="include/TEMPLATE-FOOTER.jsp"%>
	</footer>
	<!-- Footer END -->

	<!-- Js Plugins -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/mixitup.min.js"></script>
	<script src="js/main.js"></script>
</body>

</html>