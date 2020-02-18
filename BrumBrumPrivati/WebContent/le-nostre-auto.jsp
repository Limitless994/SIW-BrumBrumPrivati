<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- Serve a cambiare in jsp -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zxx">

<head>
<%@ include file="include/headindex.jsp"%>
<%@ include file="include/NewHEADER.jsp"%>
</head>


<body>
	<section class="related-product spad">
		<div class="container">
		<section class="page-add">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<div class="page-breadcrumb">
						<h2>
							Automobili<span>.</span>
						</h2>
						<a href="index.jsp">Home</a> <a href="le-nostre-auto.jsp">Automobili</a> <a class="active"
							href="#">Vendita</a>
					</div>
				</div>
				<div class="col-lg-8">
					<img src="img/cart/autosaloon.jpg" alt="">
				</div>
			</div>
		</div>
	</section>
			<!-- Sessione per visualizzare le auto -->
			
			<form method="get" action="VisAutoSelezionata">
			<div class="gallery">
					<c:forEach items="${automobiliDisponibili}" var="autom">
					
								<figure>
									<a href="VisAutoSelezionata?targa=${autom.getTarga()}"><img
										src="${autom.immagine}" alt=""></a>
									<!--  <input type="image" name="macchina"  src="${autom.immagine}">  -->
								<!-- 	<div class="p-status">new</div> -->
									
								</figure>
								<div class="product-text">
									<a href="VisAutoSelezionata?targa=${autom.targa}"> <h6>${autom.marca} ${autom.modello}</h6></a>
									<p>vendita: ${autom.prezzovendita}</p>
									<p>noleggio: ${autom.prezzonoleggio}</p>
								</div>

				</c:forEach>
			
			</div>
			</form>
			<!-- fine sessione per visualizzare le auto -->

		</div>
	</section>
	<!-- Related Product Section End -->

	<!-- Footer Section Begin -->
	<footer>
		<%@ include file="include/TEMPLATE-FOOTER.jsp"%>
	</footer>
	<!-- Footer Section End -->

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