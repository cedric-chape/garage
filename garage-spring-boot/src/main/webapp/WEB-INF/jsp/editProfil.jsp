<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:layout>
	<jsp:attribute name="title" >
		<c:if test="${ garagiste != null && garagiste.id != 0 }">Modifier mes informations</c:if>
	</jsp:attribute>
	
	<jsp:body>
		<form:form method="POST" modelAttribute="garagiste">
			<form:errors path="*" cssClass="alert alert-danger" element="div" />
			<div class="form-group">
				<label>Nom <span style="color:red;">*</span></label>
				<input type="text" name="nom" value="${ garagiste.nom }" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Prénom</label>
					<input type="text" name="prenom" value="${ garagiste.prenom }" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Email <span style="color:red;">*</span></label>
				<input type="email" name="email" value="${ garagiste.email }" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Mot de passe <span style="color:red;">*</span></label>
				<input type="password" name="password" class="form-control"/>
			</div>
			<input type="hidden" name="admin" value="${ garagiste.admin }" />

			<c:if test="${ garagiste != null && garagiste.id != 0 }">
				<input type="submit" class="btn btn-warning" value="Modifier"/>
			</c:if>
			<a href="monEspace?id=1" class="btn btn-outline-primary">Retour</a>
		</form:form>
		
	</jsp:body>
</t:layout>