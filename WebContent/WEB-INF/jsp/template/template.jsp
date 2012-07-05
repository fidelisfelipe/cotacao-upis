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
<div id="DivMsg" >
${msg}
</div>

<script>
$(document).ready(function(){
	$("#DivMsg").css("background","yellow");
	$("#DivMsg").hide();
	$("#DivMsg").show(1000);
	$("#DivMsg").hide(2000);
});
</script>

</c:if>

<!-- CONTEUDO -->
<div id="DivConteudo">
	<tiles:insertAttribute name="body" />
</div>
</body>
</html>