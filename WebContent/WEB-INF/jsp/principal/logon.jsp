<%@include file="../taglibHeader.jsp" %>

<tiles:insertTemplate template="/WEB-INF/jsp/template/template.jsp">
	<tiles:putAttribute name="body">
<%@include file="../template/headerValidacao.jsp"%>

<script type="text/javascript">
$().ready(function() {
	// validate the comment form when it is submitted
	$("#form").validate();

	//valores iniciais das inputs
	$("#login").val("Usuario");
	$("#senha").val("Senha");

	$("#login").click(function(){
		$("#login").val("");
	});
	$("#senha").click(function(){
		$("#senha").val("");
	});	
	
});
</script>

<style type="text/css">
#commentForm { width: 500px; }
#commentForm label { width: 250px; }
#commentForm label.error, #commentForm input.submit { margin-left: 253px; }
 
</style>


<form id="form" method="get" action="<c:url value="/logon"/>" >

			<p>
				<input id="login" type="email" name="usuario.login" class="required" maxlength="15" />
			</p>
			<p>
				<input id="senha" type="text" name="usuario.senha" class="required" minlength="2" maxlength="6" />
			</p>
			<p>
				<input type="submit" title="Sign in"/>
			</p>

</form>


	</tiles:putAttribute>
</tiles:insertTemplate>