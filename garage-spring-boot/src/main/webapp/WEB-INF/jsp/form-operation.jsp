<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:layout>
	<jsp:attribute name="title">
		<c:if test="${ operation == null || operation.id == 0 }">Ajouter une opération</c:if>
		<c:if test="${ operation != null && operation.id != 0 }">Modifier une opération</c:if>
	</jsp:attribute>
	
	<jsp:body>
		<form:form method="POST" modelAttribute="operation">
			<form:errors path="*" cssClass="alert alert-danger" element="div" />
			<div class="form-group">
				<label>Libellé <span style="color:red;">*</span></label>
				<input type="text" name="libelle" value="${ operation.libelle }" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Description</label>
				<textarea name="prenom" class="form-control">
					${ operation.description }
				</textarea>
			</div>
			<div class="form-group">
				<label>Prix unitaire <span style="color:red;">*</span></label>
				<input type="text" name="prixUnitaire" value="${ operation.prixUnitaire }" class="form-control"/>
			</div>

			
			<c:if test="${ operation == null || operation.id == 0 }">
				<input type="submit" class="btn btn-success" value="Ajouter"/>
			</c:if>
			<c:if test="${ operation != null && operation.id != 0 }">
				<input type="submit" class="btn btn-warning" value="Modifier"/>
			</c:if>
			<a href="liste" class="btn btn-outline-primary">Retour</a>
		</form:form>
		
	</jsp:body>
</t:layout>