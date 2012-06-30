<%@include file="../taglibHeader.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cotação Upis</title>
</head>
<body>

<!-- Login -->
<a href="<c:url value="/logon"/>">Logon</a>|
<a href="<c:url value="/logout"/>">Logout</a>
<c:if test="${usuario.logon}">
	Logado
</c:if>

<!-- MENU -->
<div id="DivMenu">
<%@include file="menus.jsp" %>
</div>
<!-- CONTEUDO -->
<div id="DivConteudo">
	<tiles:insertAttribute name="body" />
</div>
</body>
</html>