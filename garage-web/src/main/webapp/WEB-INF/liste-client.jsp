<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<t:layout>
	<jsp:attribute name="title">Liste des clients</jsp:attribute>
	
	<jsp:body>
		<c:if test="${ param.clientAjout == true }">
			<div class="alert alert-success" role="alert">
				Le client a bien été ajouté !
			</div>
		</c:if>
		<c:if test="${ param.clientModifie == true }">
			<div class="alert alert-success" role="alert">
				Le client a bien été modifié !
			</div>
		</c:if>
		<c:if test="${ param.clientSupprime == true }">
			<div class="alert alert-success" role="alert">
				Le client a bien été supprimé !
			</div>
		</c:if>
		
		<a href="ajouter-client" class="btn btn-success">Ajouter un client</a>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Raison sociale</th>
					<th>Type</th>
					<th>Fidélité</th>
					<th>Véhicules</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="client" items="${ clients }">
					<tr>
						<td>${ client.id }</td>
						<td>${ client.nom }</td>
						<td>${ client.prenom }</td>
						<td>${ client.raisonSociale }</td>
						<td>${ client.typeClient }</td>
						<td>${ client.fidelite }</td>
						<td>
							<a href="client-vehicules?id=${ client.id }" class="btn btn-warning">
								Voir
							</a>
						</td>
						<td><a href="modifier-client?id=${ client.id }" class="btn btn-warning">
								Modifier
							</a>
							<a href="supprimer-client?id=${ client.id }" class="btn btn-danger">
								Supprimer
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:body>
</t:layout>