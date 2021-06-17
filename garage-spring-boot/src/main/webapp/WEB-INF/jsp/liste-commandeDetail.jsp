<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">Liste des op�rations de la commande</jsp:attribute>
	
	<jsp:body>
		<c:if test="${ param.operationAjout == true }">
			<div class="alert alert-success" role="alert">
				L'op�ration a bien �t� ajout�e !
			</div>
		</c:if>
		<c:if test="${ param.operationSupprime == false }">
			<div class="alert alert-warning" role="alert">
				L'op�ration ne peut �tre supprim�e !
			</div>
		</c:if>
				<c:if test="${ param.operationSupprime == true }">
			<div class="alert alert-success" role="alert">
				L'op�ration a bien �t� supprim�e !
			</div>
		</c:if>
		<c:if test="${ param.operationModifie == true }">
			<div class="alert alert-success" role="alert">
				L'op�ration a bien �t� modifi�e !
			</div>
		</c:if>
		
	<a href="commande/commande-detail/detail/${ commande.id }/ajouter" class="btn btn-success">Ajouter op�ration</a>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Libell� op�ration</th>
					<th>Quantit�</th>
					<th>Prix unitaire</th>
					<th>Prix total</th>
					<th>Actions</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="commandeDetail" items="${ commandesDetails }">
					<tr>
						<td>${ commandeDetail.id.operation.libelle }</td>
						<td>${ commandeDetail.quantite }</td>
						<td>${ commandeDetail.id.operation.prixUnitaire }</td>
						<td>${ commandeDetail.id.operation.prixUnitaire *  commandeDetail.quantite }</td>
						<td>
							<!-- <a href="commande/commande-detail/detail/${ commande.id }/modifier?operationId=${ commandeDetail.id.operation.id }" class="btn btn-warning">Modifier</a>-->
							<a href="commande/commande-detail/detail/${ commande.id }/supprimer?operationId=${ commandeDetail.id.operation.id }" class="btn btn-danger">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			
			<thead>
				<tr>
					<th>Prix total des op�rations</th>
					<th></th>
					<th></th>
					<th>${ commande.prixTotal} </th>
								
				</tr>
			</thead>
		</table>
		<div class="divHeight"></div>
	</jsp:body>
</t:layout>