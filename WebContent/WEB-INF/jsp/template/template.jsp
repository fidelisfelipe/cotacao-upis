<%@include file="../taglibHeader.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cotação Upis</title>

<!-- Scripts -->

<%@include file="headerJquery.jsp"%>

</head>
<body>
<div id="DivTopo">
	<c:if test="${usuario.logon}">
			<div id="DivUsuario">${usuarioWeb.nome}<br />
				<fmt:formatDate value="${agora}" dateStyle="full"/>
				<a href="<c:url value="/logout"/>">
					<img title="Sair do sistema" src="<c:url value="/imagens/logout.png"/>"/>
				</a>
			</div>
	</c:if>
</div>
<!-- MENU -->
<div id="DivMenu">
<%@include file="menus.jsp" %>
</div>
<!-- MSG -->
<c:if test="${not empty msg}">
<div id="DivMsg" >
${msg}
</div>
</c:if>
<script>
$(document).ready(function(){
	//exibe ao click
	$("#exibeNovo").click(function (){
		$("#lista").hide(500);
		$("#novo").show(500);
	});
	$("#exibeLista").click(function (){
		$("#novo").hide(500);
		$("#lista").show(500);
	});
	$("#removerForm").submit(function (){
		if(confirm("Você deseja realmente remover este registro?"))
			return true;
		
		return false;
	});
	$(".removerList").submit(function (){
		if(confirm("Você deseja realmente remover este registro?")){
			return true;
		}else{
			return false;
		}
	});
	
});

function linkEditar(id){
	location.href='<c:url value="/${contexto}/"/>'+id;
}
function linkMais(id){
	location.href='<c:url value="/${contexto}/mais/"/>'+id;
}

</script>


<!-- CONTEUDO -->
<div id="DivConteudo">
	<tiles:insertAttribute name="body" />
</div>
</body>
</html>