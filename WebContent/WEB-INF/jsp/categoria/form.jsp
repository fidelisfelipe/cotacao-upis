<%@include file="../taglibHeader.jsp" %>

<tiles:insertTemplate template="/WEB-INF/jsp/template/template.jsp">
	<tiles:putAttribute name="body">

<%@include file="../template/headerValidacao.jsp"%>
<script type="text/javascript">
$(document).ready(function() {
	$("#formCategoria").validate();
});
</script>

<form id="formCategoria" action="<c:url value="/${contexto}/novo" />" method="post">

	Nome:<input type="text" name="categoria.nome" id="nome" value="${categoria.nome}" class="required" /> <br />
	Descrição:<input type="text" name="categoria.descricao" id="descricao" value="${categoria.descricao}" class="required" />

	<input type="submit" title="Salvar" />

</form>

	</tiles:putAttribute>
</tiles:insertTemplate>