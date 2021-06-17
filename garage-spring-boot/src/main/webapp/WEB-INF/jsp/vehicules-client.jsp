<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">Liste des Vehicule client </jsp:attribute>
	
	<jsp:body>
	
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Marque</th>
					<th>Modèle</th>
					<th>Type</th>
					<th>Immatriculation</th>
			
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="vehicule" items="${ vehicules }">
					<tr>
						<td>${ vehicule.getId() }</td>
						<td>${ vehicule.marque }</td>
						<td>${ vehicule.nom }</td>
						<td>${ vehicule.type }</td>
						<td>${ vehicule.immatriculation }</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="divHeight"></div>
	</jsp:body>
</t:layout>