<%@include file="../taglibHeader.jsp" %>

<tiles:insertTemplate template="/WEB-INF/jsp/template/template.jsp">
	<tiles:putAttribute name="body">
	
<table border="1" >
	<tr>
		<td  colspan="2" >
		<p align="center">Formatting: 
            <fmt:formatDate value="${date}" type="both" timeStyle="long" dateStyle="long" /> 
		</p>
		</td>
	</tr>

	<tr>
		<td >Attribute : type="date"</td>

		<td >
			<fmt:formatDate type="date" value="${date}" />
		</td>
	</tr>
	<tr>
		<td >Attribute : type="time"</td>

		<td>
			<fmt:formatDate type="time" value="${date}" />
		</td>
	</tr>

	<tr>
		<td>Attribute : type="both"</td>

		<td>
			<fmt:formatDate type="both" value="${date}" />
		</td>
	</tr>

	<tr>
		<td >Attribute : type="both" dateStyle="default"
		timeStyle="default"</td>

		<td >
			<fmt:formatDate type="both" dateStyle="default" timeStyle="default" value="${date}" />
		</td>
	</tr>

	<tr>
		<td >Attribute : type="short" dateStyle="default"
		timeStyle="short"</td>

		<td >
			<fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${date}" />
		</td>
	</tr>

	<tr>
		<td >Attribute : type="both" dateStyle="medium"
		timeStyle="medium"</td>

		<td >
			<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${date}" />
		</td>
	</tr>

	<tr>
		<td >Attribute : type="both" dateStyle="long"
		timeStyle="long"</td>

		<td ><fmt:formatDate type="both" dateStyle="long"
			timeStyle="long" value="${date}" /></td>
	</tr>

	<tr>
		<td >Attribute : type="both" dateStyle="full"
		timeStyle="full"</td>

		<td >
			<fmt:formatDate type="both" dateStyle="full" timeStyle="full" value="${date}" />
		</td>
	</tr>

	<tr>
		<td >Attribute : pattern="yyyy-MM-dd"</td>

		<td >
			<fmt:formatDate pattern="yyyy-MM-dd" value="${date}" />
		</td>
	</tr>
	<tr>
		<td >Attribute : pattern="yyyy-MM-dd hh:mm:ss"</td>

		<td >
		<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${date}" />
		</td>
	</tr>
</table>



	</tiles:putAttribute>
</tiles:insertTemplate>