<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">Liste des vehicules</jsp:attribute>
	
	<jsp:body>
		<c:if test="${ param.vehiculeAjout == true }">
			<div class="alert alert-success" role="alert">
				Le v�hicule a bien �t� ajout� !
			</div>
		</c:if>
		<c:if test="${ param.vehiculeSupprime == false }">
			<div class="alert alert-warning" role="alert">
				Le v�hicule ne peut �tre supprim� car il est rattach� � une commande !
			</div>
		</c:if>
				<c:if test="${ param.vehiculeSupprime == true }">
			<div class="alert alert-success" role="alert">
				Le v�hicule a bien �t� supprim� !
			</div>
		</c:if>
		<c:if test="${ param.vehiculeModifie == true }">
			<div class="alert alert-success" role="alert">
				Le v�hicule a bien �t� modifi� !
			</div>
		</c:if>
		
		<a href="vehicule/ajouter" class="btn btn-success">Ajouter un v�hicule</a>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Marque</th>
					<th>Mod�le</th>
					<th>Type</th>
					<th>Immatriculation</th>
					<th>Modifier</th>
					<th>Supprimer</th>
					<th>Nom du client</th>
					<th>Pr�nom du client</th>
					<th>Raison sociale</th>
					<th>Type client</th>
					<th>Fidelit�</th>
					<th>Num�ro client</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="vehicule" items="${ vehicules }">
					<tr>
						<td>${ vehicule.getId() }</td>
						<td>${ vehicule.marque }</td>
						<td>${ vehicule.nom }</td>
						<td>${ vehicule.type }</td>
						<td>${ vehicule.immatriculation }</td>
						<td><a href="vehicule/modifier?id=${ vehicule.id }" class="btn btn-warning">Modifier</a></td>
						<td><a href="vehicule/supprimer?id=${ vehicule.id }" class="btn btn-danger">Supprimer</a></td>
						<td><c:out value="${ vehicule.client.nom }" /></td>
						<td><c:out value="${ vehicule.client.prenom }" /></td>
						<td><c:out value="${ vehicule.client.raisonSociale }" /></td>
						<td><c:out value="${ vehicule.client.typeClient }" /></td>
						<td><c:out value="${ vehicule.client.fidelite }" /></td>
						<td><c:out value="${ vehicule.client.id }" /></td>
						<td>
							
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:body>
</t:layout>