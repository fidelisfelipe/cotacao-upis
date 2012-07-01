<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<c:if test="${usuarioWeb.logon}">
	Você está Logado
</c:if>
<c:if test="${not usuarioWeb.logon}">
	Você não está Logado
</c:if>
<br />
<c:if test="${not usuarioWeb.logon}">
	<a href="<c:url value="/logon"/>" title="Esta função criada apenas para ambiente de desenvolvimento e testes">Força Logon</a>|
	<a href="<c:url value="/sign-in"/>" title="Acessar o sistema? Clique aqui!">Sign in</a>
</c:if>
<c:if test="${usuarioWeb.logon}">
	<a href="<c:url value="/logout"/>" title="Sair do sistema" >Sign out</a>
</c:if>
<br />    
<a href="<c:url value="/"/>">Home</a>|
<a href="<c:url value="/datas"/>">Datas</a>|
<a href="<c:url value="/info"/>">Info</a>



