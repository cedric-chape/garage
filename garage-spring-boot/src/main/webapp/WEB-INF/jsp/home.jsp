<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">Hello ${ garagiste.prenom } ${ garagiste.nom } !</jsp:attribute>
	
	<jsp:body>
		<div class="card">
			<div class="card-body">
				<h3>Vos commandes en cours</h3>
				<c:if test="${ empty commandesEnCours }">
					<div class="divHeight"></div>
					<h4 class="text-center">Pas de commande en cours ??? Va nettoyer l'atelier, faut que ça brille !</h4>
					<div class="divHeight"></div>
				</c:if>
				<c:if test="${ not empty commandesEnCours }">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Date</th>
								<th>Etat</th>
								<th>Véhicule</th>
								<th>Client</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="commande" items="${ commandesEnCours }">
								<tr>
									<td>${ commande.date }</td>
									<td>
										<c:if test ="${ commande.etatCommande == 'NONCOMMENCEE' }">Non commencée</c:if>
										<c:if test ="${ commande.etatCommande == 'ENCOURS' }">En cours</c:if>
										<c:if test ="${ commande.etatCommande == 'TERMINEE' }">Terminée</c:if>
									</td>
									<td> ${ commande.vehicule.marque } ${ commande.vehicule.nom }</td>
									<td>${ commande.client.prenom } ${ commande.client.nom } ${ commande.client.raisonSociale }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
		<div class="divHeight"></div>
	</jsp:body>
</t:layout>