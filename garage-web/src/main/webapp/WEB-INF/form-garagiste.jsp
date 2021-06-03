<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">
		<c:if test="${ garagiste == null }">Ajouter un garagiste</c:if>
		<c:if test="${ garagiste != null }">Modifier un garagiste</c:if>
	</jsp:attribute>
	
	<jsp:body>
	
		<c:if test="${ not empty errors }">
			<div class="alert alert-warning" role="alert">
  				<ul>
					<c:forEach var="error" items="${ errors }">
						<li><c:out value="${ error }"/></li>
					</c:forEach>
				</ul>
			</div>
			
		</c:if>
		<form method="POST">
			<div class="form-group">
				<label>Nom <span style="color:red;">*</span></label>
				<input type="text" name="nom" value="${ garagiste.nom }" class="form-control"/>
			</div class="form-group">
			<div class="form-group">
				<label>Prénom</label>
				<input type="text" name="prenom" value="${ garagiste.prenom }" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Email <span style="color:red;">*</span></label>
				<input type="email" name="email" value="${ garagiste.email }" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Mot de passe <span style="color:red;">*</span></label>
				<input type="password" name="password" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Confirmation Mot de passe <span style="color:red;">*</span></label>
				<input type="password" name="confirmPassword" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Rôle <span style="color:red;">*</span></label>
				<select name="role" class="form-control">
					<c:if test="${ garagiste.role == 'ADMIN' }">
						<option value="ADMIN" selected>Administrateur</option>
						<option value="USER">Utilisateur</option>
					</c:if>
					<c:if test="${ garagiste.role == 'USER' || garagiste.role == null}">
						<option value="ADMIN">Administrateur</option>
						<option value="USER" selected>Utilisateur</option>
					</c:if>
				</select>
			</div>
			
			<c:if test="${ garagiste == null }">
				<input type="submit" class="btn btn-success" value="Ajouter"/>
			</c:if>
			<c:if test="${ garagiste != null }">
				<input type="submit" class="btn btn-warning" value="Modifier"/>
			</c:if>
			<a href="liste-garagiste" class="btn btn-outline-primary">Retour</a>
		</form>
		
	</jsp:body>
</t:layout>