<%@ attribute name="title" fragment="true" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<title><jsp:invoke fragment="title" /></title>
		
		<meta charset="UTF-8" />
		<base href="/" />
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		<link rel="stylesheet" href="assets/css/style.css" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Monoton&display=swap" rel="stylesheet">
	</head>
	<body>
		<!-- <sec:authorize access="isAuthenticated()">-->
			<nav class="navbar navbar-expand-lg">
	 			<a class="navbar-brand" href="/">
	 				<img src="assets/img/igc-cube.png" width="50" height="50" alt="IGC"/>
	 			</a>
	 			<button class="navbar-toggler custom-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    				<span class="navbar-toggler-icon"></span>
  				</button>
	
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item">
							<a class="nav-link" href="profil/monEspace">Mon Espace</a>
						</li>
						
						<li class="nav-item">
							<a class="nav-link" href="vehicule/liste">Liste des véhicules</a>
						</li>
						
						<li class="nav-item">
							<a class="nav-link" href="client/liste">Nos clients</a>
						</li>
												
						<li class="nav-item">
							<a class="nav-link" href="commande/liste">Commandes</a>
						</li>
						
						<sec:authorize access="hasRole('ADMIN')">
							<li class="nav-item">
								<a class="nav-link" href="garagiste/liste">Notre équipe</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="operation/liste">Opérations</a>
							</li>
						</sec:authorize>
						
						

					</ul>
						
					<form class="form-inline my-2 my-lg-0" method="POST" action="perform_logout">
						<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" />
						<input type="submit" value="Déconnexion" class="btn btn-outline-danger my-2 my-sm-0" />
					</form>
				</div>
			</nav>
		<!-- </sec:authorize>-->
		
		<div class="divHeight"></div>
		<div class="container rel">
			<h1>
				<jsp:invoke fragment="title"></jsp:invoke>
			</h1>
			
			<jsp:doBody/>
		</div>
		
		
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
	
</html>