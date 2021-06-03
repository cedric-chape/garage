<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Connexion</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		<link rel="stylesheet" href="assets/css/style.css"/>
		
  	</head>
	<body>
		<div class="container">
			<div class="divHeight"></div>
				
			<div class="row justify-content-center">
				<div class="col-6">
					<div class="card">
						<div class="card-header">
							<h2 class="text-center">International Garage Company</h2>
							<img class="img-fluid" src="assets/img/igc.png" alt="IGC" />
						</div>
						<div class="card-body text-center form-parent">
							<c:if test="${ errorLogin == true}">
								<p style="color:red;">
									Votre email et/ou votre mot de passe sont erronés
								</p>
							</c:if>
				    		<form class="form-login" method="POST">
				        		<div class="form-group">
				            		<label>Email</label>
				            		<input type="email" name="email" class="form-control"/>
				        		</div>
				        		<div class="form-group">
				            		<label>Password</label>
				            		<input type="password" name="password" class="form-control"/>
				        		</div>
					        	<input type="submit" class="btn btn-outline-primary btn-block" value="Se connecter"/>
					    	</form>
						</div>
					</div>				
				</div>
				
			</div>
		</div>
	</body>
</html>