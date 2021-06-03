<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<t:layout>
	<jsp:attribute name="title">
		<c:if test="${ vehicule == null }">Ajouter un véhicule</c:if>
		<c:if test="${ vehicule != null }">Modifier le véhicule</c:if>
	</jsp:attribute>
	
	<jsp:body>
		<form method="POST">
			<div class="form-group">
				<label>Marque</label>
				<input class="form-control" type="text" name="marque" value="${ vehicule.marque }" />
			</div>
			<div class="form-group">
				<label>Modèle</label>
				<input class="form-control" type="text" name="nom" value="${ vehicule.nom }" />
			</div>
			<div class="form-group">
				<label>Immatriculation</label>
				<input class="form-control" type="text" name="immatriculation" value="${ vehicule.immatriculation }" />
			</div>
			
			<div class="form-group">
				<label>Type</label>
				<select class="form-control" name="type">
					<option value="VOITURE">Voiture</option>
					<option value="MOTO">Moto</option>
					<option value="CAMION">Camion</option>
				</select>
			</div>
			
			<div class="form-group">
				<label>Client</label>
				<select class="form-control" name="clientId">
					<c:forEach var="client" items="${ clients }">
						<c:if test="${ vehicule.client.id == client.id }">
							<option selected value="${ client.id }">- ${ client.prenom } ${ client.nom } - ${ client.raisonSociale }</option>
						</c:if>
						
						<c:if test="${ vehicule.client.id != client.id }">
							<option value="${ client.id }">- ${ client.prenom } ${ client.nom } - ${ client.raisonSociale }</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<c:if test="${ vehicule == null }">
				<input type="submit" class="btn btn-success" value="Ajouter" />
			</c:if>
			
			<c:if test="${ vehicule != null }">
				<input type="submit" class="btn btn-warning" value="Modifier" />
			</c:if>
			
		</form>
	</jsp:body>
</t:layout>