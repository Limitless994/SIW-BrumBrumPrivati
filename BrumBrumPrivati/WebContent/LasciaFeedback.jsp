<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- Serve a cambiare in jsp -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<%@ include file="include/headindex.jsp"%>
<%@ include file="include/NewHEADER.jsp"%>

</head>

<body>



	<!-- Header Info End -->
	<!-- Header End -->

	<!-- Page Add Section Begin -->
	<section class="page-add">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<div class="">
						<h2>
							Lascia un feedback per il tuo acquisto<span>.</span>
						</h2>
						<span class="float-right"><i
							class="text-warning fa fa-star"></i></span> <span class="float-right"><i
							class="text-warning fa fa-star"></i></span> <span class="float-right"><i
							class="text-warning fa fa-star"></i></span> <span class="float-right"><i
							class="text-warning fa fa-star"></i></span>
					</div>
				</div>
			</div>
		</div>

		<!-- Page Add Section End -->

		<!-- Contact Section Begin -->
		<div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8">
						<form method="post" action="PostaFeedback" class="contact-form">
							<div class="row">
								<textarea id="commento" name="commento"
									placeholder="Scrivi della tua esperienza con BrumBrum"></textarea>
							</div>
							<div class="col-lg-12 text-center">
								<button type="submit">Invia Feedback</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>



	<!-- Contact Section End -->


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
	<div class="form-row"></div>
	<div class="form-row"></div>
</body>

<footer>

	<%@ include file="include/TEMPLATE-FOOTER.jsp"%>

</footer>



