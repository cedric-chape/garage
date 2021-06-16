<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<t:layout>
	<jsp:attribute name="title">Liste des garagistes</jsp:attribute>
	
	<jsp:body>
		<br/>
		<c:if test="${ param.garagisteAjoute == true }">
			<div class="alert alert-success" role="alert">
						Garagiste ajouté !
			</div>
		</c:if>
		<c:if test="${ param.garagisteModifie == true }">
			<div class="alert alert-success" role="alert">
						Garagiste modifié !
			</div>
		</c:if>
		<c:if test="${ param.garagisteSupprime == true }">
			<div class="alert alert-success" role="alert">
						Garagiste supprimé !
			</div>
		</c:if>
				<c:if test="${ param.garagisteSupprime == false }">
			<div class="alert alert-warning" role="alert">
						Vous ne pouvez pas vous supprimer !
			</div>
		</c:if>
		<br/>
		<a href="garagiste/ajouter" class="btn btn-success">Ajouter</a> 
		<table class="table table-striped">
					<thead>
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Nom</th>
			      <th scope="col">Prénom</th>
			      <th scope="col">Email</th>
			      <th scope="col">Rôle</th>
			      <th scope="col">Actions</th>
			    </tr>
					</thead>
			<tbody>
				<c:forEach var="garagiste" items="${ garagistes }">
			    	<tr>
						<td>${ garagiste.getId() }</td>
						<td>${ garagiste.nom }</td>
						<td>${ garagiste.prenom }</td>
						<td>${ garagiste.email }</td>
						<td>
							<c:if test="${ garagiste.admin == true}">
								Administrateur
							</c:if>
							<c:if test="${ garagiste.admin == false}">
								Utilisateur
							</c:if>
						</td>
			      		<td>
			      			<a href="garagiste/modifier?id=${ garagiste.id }" class="btn btn-warning">Modifier</a> 
			      			
			      			<c:if test="${ garagiste.email != userPrincipal }">
			      				<a href="garagiste/supprimer?id=${ garagiste.id }" class="btn btn-danger">Supprimer</a>
			      			</c:if>
			      		</td>
			    	</tr>
			    </c:forEach>
			</tbody>
		</table>
	</jsp:body>
	
</t:layout>
