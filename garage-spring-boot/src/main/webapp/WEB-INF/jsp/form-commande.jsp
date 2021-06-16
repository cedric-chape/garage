<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:layout>
	<jsp:attribute name="title">
		<c:if test="${ commande == null || commande.id == 0 }">Ajouter une commande</c:if>
		<c:if test="${ commande != null && commande.id != 0 }">Modifier la commande</c:if>
	</jsp:attribute>
	
	<jsp:body>
		<form:form method="POST" modelAttribute="commande">
			<form:errors path="*" cssClass="alert alert-danger" element="div" />
			<div class="form-group">
				<label>Date</label>
				<input class="form-control" type="datetime-local" name="date" value="${ commande.date }" />
			</div>
			
			<div class="form-group">
				<label>Etat</label>
				<select class="form-control" name="etatCommande">
					<option value="NONCOMMENCEE">Non commencée</option>
					<option value="ENCOURS">En cours</option>
					<option value="TERMINEE">Terminée</option>
					
				</select>
			</div>	
			
			<div class="form-group">
				<label>Prix total</label>
				<input class="form-control" type="number" name="prixTotal" value="${ commande.prixTotal }" disabled/>
			</div>
			
			<div class="form-group">
				<label>Client</label>
				<select class="form-control" name="client.id">
					<c:forEach var="client" items="${ clients }">
						<c:if test="${ commande.client.id == client.id }">
							<option selected value="${ client.id }">- ${ client.prenom } ${ client.nom } - ${ client.raisonSociale }</option>
						</c:if>
						
						<c:if test="${ commande.client.id != client.id }">
							<option value="${ client.id }">- ${ client.prenom } ${ client.nom } - ${ client.raisonSociale }</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			
			<div class="form-group">
				<label>Garagiste</label>
				<select class="form-control" name="garagiste.id">
					<c:forEach var="garagiste" items="${ garagistes }">
						<c:if test="${ commande.garagiste.id == garagiste.id }">
							<option selected value="${ garagiste.id }">- ${ garagiste.prenom } ${ garagiste.nom }</option>
						</c:if>
						
						<c:if test="${ commande.garagiste.id != garagiste.id }">
							<option value="${ garagiste.id }">- ${ garagiste.prenom } ${ garagiste.nom }</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			
			<div class="form-group">
				<label>Véhicule</label>
				<select class="form-control" name="vehicule.id">
					<c:forEach var="vehicule" items="${ vehicules }">
						<c:if test="${ commande.vehicule.id == vehicule.id }">
							<option selected value="${ vehicule.id }">- ${ vehicule.marque } ${ vehicule.nom } ${ vehicule.immatriculation }</option>
						</c:if>
						
						<c:if test="${ commande.vehicule.id != vehicule.id }">
							<option value="${ vehicule.id }">- ${ vehicule.marque } ${ vehicule.nom } ${ vehicule.immatriculation }</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			
			<c:if test="${ commande == null || commande.id == 0 }">
				<input type="submit" class="btn btn-success" value="Ajouter" />
			</c:if>
			
			<c:if test="${ commande != null && commande.id != 0 }">
				<input type="submit" class="btn btn-warning" value="Modifier" />
			</c:if>
			<a href="commande/liste" class="btn btn-outline-primary">Retour</a>
			
		</form:form>
		<div class="divHeight"></div>
	</jsp:body>
</t:layout>