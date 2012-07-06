<%@include file="../taglibHeader.jsp" %>

<tiles:insertTemplate template="/WEB-INF/jsp/template/template.jsp">
	<tiles:putAttribute name="body">

<%@include file="../template/headerValidacao.jsp"%>
<script type="text/javascript">
$(document).ready(function() {
	$("#formMarca").validate();
});
</script>

<form id="formMarca" action="<c:url value="/${contexto}/novo" />" method="post">

	Nome:<input type="text" name="marca.nome" id="nome" value="${marca.nome}" class="required" /> <br />
	Descri��o:<input type="text" name="marca.descricao" id="descricao" value="${marca.descricao}" class="required" />

	<input type="submit" title="Salvar" />

</form>

	</tiles:putAttribute>
</tiles:insertTemplate>