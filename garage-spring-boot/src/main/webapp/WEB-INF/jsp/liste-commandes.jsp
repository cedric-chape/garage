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
					<th>V�hicule model</th>
					<th>V�hicule marque</th>
					<th>Nom du client</th>
					<th>Pr�nom du client</th>
					<th>Raison sociale</th>
					<th>Num�ro client</th>
					<th>Actions</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="commande" items="${ commandes }">
					<tr>
						<td>${ commande.getId() }</td>
						<td>${ commande.date }</td>
						<td>
						
							<c:if test ="${ commande.etatCommande == 'NONCOMMENCEE' }">Non commenc�e</c:if>
							<c:if test ="${ commande.etatCommande == 'ENCOURS' }">En cours</c:if>
							<c:if test ="${ commande.etatCommande == 'TERMINEE' }">Termin�e</c:if>
						
						</td>
						<td>${ commande.prixTotal }</td>
						<td>${ commande.garagiste.nom }</td>
						<td>${ commande.vehicule.nom }</td>
						<td>${ commande.vehicule.marque }</td>
						<td>${ commande.client.nom }</td>
						<td>${ commande.client.prenom }</td>
						<td>${ commande.client.raisonSociale }</td>
						<td>${ commande.client.id }</td>
						<td>
							<a href="commande/modifier?id=${ commande.id }" class="btn btn-warning">Modifier</a>
							<a href="commande/supprimer?id=${ commande.id }" class="btn btn-danger">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="divHeight"></div>
	</jsp:body>
</t:layout>