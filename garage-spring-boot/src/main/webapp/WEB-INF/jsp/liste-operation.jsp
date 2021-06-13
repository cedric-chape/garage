<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<t:layout>
	<jsp:attribute name="title">Liste des opérations</jsp:attribute>
	
	<jsp:body>
		<br/>
		<c:if test="${ param.operationAjoute == true }">
			<div class="alert alert-success" role="alert">
						Opération ajoutée !
			</div>
		</c:if>
		<c:if test="${ param.operationModifie == true }">
			<div class="alert alert-success" role="alert">
						Opération modifiée !
			</div>
		</c:if>
		<c:if test="${ param.operationSupprime == true }">
			<div class="alert alert-success" role="alert">
						Opération supprimée !
			</div>
		</c:if>
		<br/>
		<a href="ajouter" class="btn btn-success">Ajouter</a> 
		<table class="table table-striped">
					<thead>
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Libellé</th>
			      <th scope="col">Prix unitaire</th>
			      <th scope="col">Actions</th>
			    </tr>
					</thead>
			<tbody>
				<c:forEach var="operation" items="${ operations }">
			    	<tr>
						<td>${ operation.getId() }</td>
						<td>${ operation.libelle }</td>
						<td>${ operation.prixUnitaire }</td>
			      		<td>
			      			<a href="modifier?id=${ operation.id }" class="btn btn-warning">Modifier</a> 
			      			<a href="supprimer?id=${ operation.id }" class="btn btn-danger">Supprimer</a>
			      		</td>
			    	</tr>
			    </c:forEach>
			</tbody>
		</table>
	</jsp:body>
	
</t:layout>
