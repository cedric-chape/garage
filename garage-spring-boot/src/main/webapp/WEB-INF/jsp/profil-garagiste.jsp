<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<t:layout>
	<jsp:attribute name="title">Mon Espace</jsp:attribute>
	
	<jsp:body>
		<br/>
		
		<c:if test="${ param.garagisteModifie == true }">
			<div class="alert alert-success" role="alert">
						Données mis à jour !
			</div>
		</c:if>
		<br/>
		
		<div class="card">
  			<h5 class="card-header">Vos informations</h5>
  			<div class="card-body">
    			<form>
  					<div class="form-group row">
    					<p class="col-sm-2 col-form-label">Nom</p>
      					<p class="col-sm-10 col-form-label">${ garagiste.nom }</p>
    					
  					</div>
  					<div class="form-group row">
    					<p  class="col-sm-2 col-form-label">Prénom</p>
    					<p class="col-sm-10 col-form-label">${ garagiste.prenom }</p>
  					</div>
  					<div class="form-group row">
    					<p class="col-sm-2 col-form-label">Email</p>
      					<p class="col-sm-10 col-form-label">${ garagiste.email }</p>
  					</div>
  					<div class="form-group row">
    					<p class="col-sm-2 col-form-label">Rôle</p>
      					<p class="col-sm-10 col-form-label">
      						<c:if test="${ garagiste.admin == true }">Administrateur</c:if>
      						<c:if test="${ garagiste.admin == false }">Utilisateur</c:if>
      					</p>
    					
  					</div>
				</form>
    			<a href="profil/modifier?id=${ garagiste.id }" class="btn btn-warning">Modifier vos informations</a>
  			</div>
		</div>
		
		<div class="divHeight"></div>
		
	</jsp:body>
	
</t:layout>	