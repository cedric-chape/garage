<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:layout>
	<jsp:attribute name="title">Hello ${ garagiste.prenom } ${ garagiste.nom } !</jsp:attribute>
	
	<jsp:body></jsp:body>
</t:layout>