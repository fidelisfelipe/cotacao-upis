<%@include file="../taglibHeader.jsp" %>

<tiles:insertTemplate template="/WEB-INF/jsp/template/template.jsp">
	<tiles:putAttribute name="body">


 <table border="1">
      <tr>
        <td colspan="2" >
          
          HTTP Request(pageContext.request.)
         
        </td>
      </tr>

      <tr>
        <td >Access Method</td>

        <td >
        <c:out value="${pageContext.request.method}" />
        </td>
      </tr>

      <tr>
        <td >Authentication Type</td>

        <td > 
        <c:out value="${pageContext.request.authType}" />
        </td>
      </tr>

      <tr>
        <td>Context Path</td>

        <td>
        <c:out value="${pageContext.request.contextPath}" />
        </td>
      </tr>

      <tr>
        <td >Path Information</td>

        <td > 
        <c:out value="${pageContext.request.pathInfo}" />
        </td>
      </tr>

      <tr>
        <td >Path Translated</td>

        <td >; 
        <c:out value="${pageContext.request.pathTranslated}" />
        </td>
      </tr>

      <tr>
        <td >Query String</td>

        <td > 
        <c:out value="${pageContext.request.queryString}" />
        </td>
      </tr>

      <tr>
        <td >Request URI</td>

        <td> 
        <c:out value="${pageContext.request.requestURI}" />
        </td>
      </tr>
    </table>

    <table border="1" >
      <tr>
        <td colspan="2" >
          HTTP Session(pageContext.session.)
        </td>
      </tr>

      <tr>
        <td >Creation Time</td>

        <td ">
        <c:out value="${pageContext.session.creationTime}" />
        </td>
      </tr>

      <tr>
        <td >Session ID</td>

        <td >
        <c:out value="${pageContext.session.id}" />
        </td>
      </tr>

      <tr>
        <td >Last Accessed Time</td>

        <td >
        <c:out value="${pageContext.session.lastAccessedTime}" />
        </td>
      </tr>

      <tr>
        <td >Max Inactive Interval</td>

        <td >
        <c:out
        value="${pageContext.session.maxInactiveInterval}" />

        seconds</td>
      </tr>

      <tr>
        <td >You have been on-line for</td>

        <td > 
        <c:out
        value="${(pageContext.session.lastAccessedTime-pageContext.session.creationTime)/1000}" />
        seconds</td>
      </tr>
    </table>


	</tiles:putAttribute>
</tiles:insertTemplate>