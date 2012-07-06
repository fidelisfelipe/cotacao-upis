<%@include file="../taglibHeader.jsp" %>

<tiles:insertTemplate template="/WEB-INF/jsp/template/template.jsp">
	<tiles:putAttribute name="body">

<%@include file="../template/headerValidacao.jsp"%>
<script type="text/javascript">
$(document).ready(function() {
	$("#formCategoria").validate();

<c:if test="${not empty categoria.categoriaPai}">
	$("#categoriaSelects").hide();
</c:if>

	$("#alterarCategoriaPai").click(function (){
		$("#categoriaSelects").show();
		$("#labelCategoriaPai").hide();
	});


	$("#novo").hide();
	$("#lista").hide();
	
	$("#${nameDivShow}").fadeIn();
		
});
</script>

<!-- acoes -->
	<fieldset>
		<div id="acoes">
<c:if test="${empty categoria.id}">
			<a href="#" id="exibeNovo">Novo</a>&nbsp;
</c:if>
<c:if test="${not empty categoria.id}">
			<a href="${pageContext.request.contextPath }/${contexto}/novo" >Novo</a>&nbsp;
</c:if>
			<a href="#" id="exibeLista">Listar</a>
		</div>
		<legend>${titulo}</legend>
	</fieldset>
<!-- /acoes -->

<%@ include file="../template/busca.jsp" %>

	<fieldset>
<!-- cadastro e edição -->
	<div id="novo" style="display:none;">
		<form id="formCategoria" action="<c:url value="/${contexto}/${categoria.id }" />" method="POST" enctype="multipart/form-data">
			<table class="tabela" width="100%" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td>Nome:</td>
					<td><input id="nome" type="text" name="categoria.nome" value="${categoria.nome }" class="required"/></td>
				</tr>
				<tr>
					<td>Descrição:</td>
					<td><textarea cols="50" rows="5" name="categoria.descricao" id="descricao" class="required">${categoria.descricao }</textarea></td>
				</tr>
				<tr>
					<td>
						Categoria Pai Atual:
					</td>
					<td id="alterarCategoriaPai" >
					<label id="labelCategoriaPai">${categoria.categoriaPai.nome}</label>
							<div id="categoriaSelects" >
								<select name="categoria.categoriaPai.id" >
									<option value="" <c:if test="${empty categoria.categoriaPai}">selected</c:if>>---</option>
								
								<c:if test="${not empty categoria.categoriaPai}">
									<option value="${categoria.categoriaPai.id}" selected>${categoria.categoriaPai.nome}</option>
								</c:if>
								<c:forEach var="categorias" items="${categoriasParaAssociacaoList}">
									<option value="${categorias.id}" >${categorias.nome}</option>
								</c:forEach>
								</select>
							</div>						
					</td>
				</tr>
			</table>
			<button type="submit" >Enviar</button>
		</form>
		
		<form class="removerList" action="${pageContext.request.contextPath }/${contexto}/${categoria.id}" method="POST">
				<button class="link" name="_method" value="DELETE" title="Excluir">
					<img src="${pageContext.request.contextPath }/imagens/sistema/x_fechar.png" height="16px" width="16px" />
				</button>
		</form>
	</div>
<!-- /cadastro e edição -->

<!-- lista -->
	<div id="lista" >
	<table id="tabela" >
		<tr>
			<th width="60%">Nome</th>
			<th width="10%">Pai</th>				
			<th width="15%" align="right">Remover</th>
		</tr>
<c:forEach items="${categoriaList}" var="categoria">
		<tr onclick="linkEditar(${categoria.id});">
			<td onclick="linkEditar(${categoria.id});">${categoria.nome}</td>
			<td onclick="linkEditar(${categoria.id});">
			${categoria.categoriaPai.nome}
			<c:if test="${empty categoria.categoriaPai}">
				---
			</c:if>
			</td>
			<td  width="150" align="right">
			<form class="removerList" action="${pageContext.request.contextPath }/${contexto}/${categoria.id}" method="POST">
				<button class="link" name="_method" value="DELETE" title="Excluir">
					<img src="${pageContext.request.contextPath }/imagens/sistema/x_fechar.png" height="16px" width="16px" />
				</button>
			</form>
			</td>
		</tr>
</c:forEach>
		</table>
	</div>
<!-- /lista -->

	</tiles:putAttribute>
</tiles:insertTemplate>