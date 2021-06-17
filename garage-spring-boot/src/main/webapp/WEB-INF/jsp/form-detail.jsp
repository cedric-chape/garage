<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:layout>
	<jsp:attribute name="title">
		<c:if test="${ vehicule == null || vehicule.id == 0 }">Ajouter une opération</c:if>
		<c:if test="${ vehicule != null && vehicule.id != 0 }">Modifier l'opération</c:if>
	</jsp:attribute>
	
	<jsp:body>
		<form:form method="POST" modelAttribute="commandeDetail">
			<form:errors path="*" cssClass="alert alert-danger" element="div" />
			
			<div class="form-group">
				<label>Libellé opération</label>
				<select class="form-control" name="operationId">
					<c:forEach var="operation" items="${ operations }">
						<c:if test="${ commandeDetail.id.operation.id == operation.id }">
							<option selected value="${ operation.id }">- ${ operation.libelle }</option>
						</c:if>
						
						<c:if test="${ commandeDetail.id.operation.id != operation.id }">
							<option value="${ operation.id }">- ${ operation.libelle }</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			
			<input type ="hidden" name ="commandeId" value = "${ commandeId }"/>
			
			<div class="form-group">
				<label>Quantité</label>
				<input class="form-control" type="number" name="quantite" value="${ commandeDetail.quantite  }" />
			</div>
			
			
			<c:if test="${ commandeDetail.id.operation.id  == null || commandeDetail.id.operation.id == 0 }">
				<input type="submit" class="btn btn-success" value="Ajouter" />
			</c:if>
			
			<c:if test="${ vehicule != null && vehicule.id != 0 }">
				<input type="submit" class="btn btn-warning" value="Modifier" />
			</c:if>
			<a href="/commande/commande-detail/detail/{id}" class="btn btn-outline-primary">Retour</a>
			
		</form:form>
	</jsp:body>
</t:layout>