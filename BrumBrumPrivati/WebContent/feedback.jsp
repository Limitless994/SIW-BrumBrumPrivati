<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<div class="container">
	<h2 class="text-center">Recensioni dei clienti che hanno
		acquistato quest'auto:</h2>
	<div class="card">
		<div class="card-body">

			 <!-- <div class="row">
				<div class="col-md-2">
					<img src="https://image.ibb.co/jw55Ex/def_face.jpg"
						class="img img-rounded img-fluid" />
					<p class="text-secondary text-center">15 Minutes Ago</p>
				</div>
				<div class="col-md-10">
					<p>
						<a class="float-left"><strong>Giuls-Cap87036</strong></a> <span
							class="float-right"><i class="text-warning fa fa-star"></i></span>
						<span class="float-right"><i
							class="text-warning fa fa-star"></i></span> <span class="float-right"><i
							class="text-warning fa fa-star"></i></span> <span class="float-right"><i
							class="text-warning fa fa-star"></i></span>

					</p>
					<div class="clearfix"></div>
					<p>Bella ma puzzava di gatto morto.</p>
				</div>
			</div>-->

			 <c:forEach items="${listaFeedback}" var="feedback">
				<div class="row">
					<div class="col-md-2">
						<img src="https://image.ibb.co/jw55Ex/def_face.jpg"
							class="img img-rounded img-fluid" />
						<p class="text-secondary text-center">${feedback.getData()}</p>
					</div>
					<div class="col-md-10">
						<p>
							<a class="float-left"><strong>${feedback.getUser()}</strong></a> <span
								class="float-right"><i class="text-warning fa fa-star"></i></span>
							<span class="float-right"><i
								class="text-warning fa fa-star"></i></span> <span class="float-right"><i
								class="text-warning fa fa-star"></i></span> <span class="float-right"><i
								class="text-warning fa fa-star"></i></span>

						</p>
						<div class="clearfix"></div>
						<p>${feedback.getCommento()}</p>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
</div>