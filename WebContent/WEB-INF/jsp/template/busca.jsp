<script>
$(document).ready(function(){
	$("#criterio").mouseover(function(){
		$("#criterio").val("");
	});
	$("#criterio").mouseout(function(){
		$("#criterio").val("Buscar");
	});
	$("#criterio").click(function(){
		$("#criterio").val("");
	});
});
</script>
${criterio}
<c:if test="${not empty criterio or empty objectList}" >
	<!-- Nenhum registro encontrado! -->
</c:if>
<div id="busca">
<div align="left"><form action="${pageContext.request.contextPath}/${contexto}/buscar" method="post" ><input title="Pressione enter para buscar" type="text" name="criterio" id="criterio" value="Buscar" /></form></div>
</div>
