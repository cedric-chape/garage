<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<t:layout>
	<jsp:attribute name="title">
		<c:if test="${ client == null }">Ajouter un client</c:if>
		<c:if test="${ client != null }">Modifier un client</c:if>
	</jsp:attribute>
	
	<jsp:body>
		<form method="POST">
			<div class="form-group">
				<label>Nom</label>
				<input class="form-control" type="text" name="nom" value="${ client.nom }" />
			</div>
			<div class="form-group">
				<label>Prénom</label>
				<input class="form-control" type="text" name="prenom" value="${ client.prenom }" />
			</div>
			<div class="form-group">
				<label>Raison sociale</label>
				<input class="form-control" type="text" name="raisonSociale" value="${ client.raisonSociale }" />
			</div>
			<div class="form-group">
				<label>Type</label>
				<select class="form-control" name="typeClient">
					<c:if test="${ client.typeClient == 'PARTICULIER' || client.typeClient == null }">
						<option value="PARTICULIER" selected>Particulier</option>
						<option value="PROFESSIONNEL">Professionnel</option>
					</c:if>
					<c:if test="${ client.typeClient == 'PROFESSIONNEL' }">
						<option value="PARTICULIER">Particulier</option>
						<option value="PROFESSIONNEL" selected>Professionnel</option>
					</c:if>
				</select>
			</div>
			<div class="form-group">
				<label>fidelite</label>
				<select class="form-control" name="fidelite">
					<c:if test="${ client.fidelite == 'CLASSIQUE' || client.fidelite == null }">
						<option value="CLASSIQUE" selected>Classique</option>
						<option value="PREMIUM">Premium</option>
					</c:if>
					<c:if test="${ client.fidelite == 'PREMIUM' }">
						<option value="CLASSIQUE">Classique</option>
						<option value="PREMIUM" selected>Premium</option>
					</c:if>
				</select>
			</div>
			<c:if test="${ client == null }">
				<input type="submit" class="btn btn-success" value="Ajouter"/>
			</c:if>
		<c:if test="${ client != null }">
			<input type="submit" class="btn btn-warning" value="Modifier"/>
		</c:if>
		<a href="liste-client" class="btn btn-outline-primary">Retour</a>
		</form>
	</jsp:body>

</t:layout>