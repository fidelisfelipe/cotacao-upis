<%@include file="../taglibHeader.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cotação Upis</title>

<!-- Scripts -->

<%@include file="headerJquery.jsp"%>

</head>
<body>

<!-- MENU -->
<div id="DivMenu">
<%@include file="menus.jsp" %>
</div>
<!-- MSG -->
<c:if test="${not empty msg}">
<div id="DivMsg">
${msg}
</div>
</c:if>

<!-- CONTEUDO -->
<div id="DivConteudo">
	<tiles:insertAttribute name="body" />
</div>
</body>
</html>