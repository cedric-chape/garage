<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">Liste des commandes</jsp:attribute>
	
	<jsp:body>
		<c:if test="${ param.commandeAjout == true }">
			<div class="alert alert-success" role="alert">
				La commande a bien �t� ajout�e !
			</div>
		</c:if>
		<c:if test="${ param.commandeSupprime == false }">
			<div class="alert alert-warning" role="alert">
				Le commande ne peut �tre supprim�e !
			</div>
		</c:if>
				<c:if test="${ param.commandeSupprime == true }">
			<div class="alert alert-success" role="alert">
				La commande a bien �t� supprim�e !
			</div>
		</c:if>
		<c:if test="${ param.commandeModifie == true }">
			<div class="alert alert-success" role="alert">
				La commande a bien �t� modifi�e !
			</div>
		</c:if>
		
		<a href="commande/ajouter" class="btn btn-success">Ajouter une commande</a>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Date</th>
					<th>Etat</th>
					<th>Prix total</th>
					<th>Garagiste</th>
					<th>V�hicule</th>
					<th>Client</th>
					<th>Actions</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="commande" items="${ commandes }">
					<tr>
						<td>${ commande.getId() }</td>
						<td>${ commande.date }</td>
						<td>
							<c:if test="${ commande.etatCommande  == NONCOMMENCEE }">Non commenc�e</c:if></td>
							<c:if test="${ commande.etatCommande  == ENCOURS }">En cours</c:if></td>
							<c:if test="${ commande.etatCommande  == TERMINEE }">Termin�e</c:if></td>
						<td>${ commande.prixTotal }</td>
						<td>${ commande.garagiste.prenom } ${ commande.garagiste.nom }</td>
						<td>${ commande.vehicule.marque } ${ commande.vehicule.nom }</td>
						<td>${ commande.client.prenom } ${ commande.client.nom } ${ commande.client.raisonSociale }</td>
						<td>
							<a href="commande/commande-detail/detail?id=${ commande.id }" class="btn btn-warning">D�tails</a>
							<a href="commande/modifier?id=${ commande.id }" class="btn btn-warning">Modifier</a>
							<a href="commande/supprimer?id=${ commande.id }" class="btn btn-danger">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:body>
</t:layout>