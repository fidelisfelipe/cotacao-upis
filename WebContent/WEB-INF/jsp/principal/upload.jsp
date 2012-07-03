<%@include file="../taglibHeader.jsp" %>

<tiles:insertTemplate template="/WEB-INF/jsp/template/template.jsp">
	<tiles:putAttribute name="body">
		
<%@include file="../template/headerUpload.jsp"%>
		
        <script type="text/javascript">
		$(function() {
			$("#arquivos").uploadify({
				  "uploader"       : '${pageContext.request.contextPath}/scripts/jquery.uploadify-v2.1.4/uploadify.swf',
				  'script'         : '${pageContext.request.contextPath}/upar',
				  'cancelImg'      : '${pageContext.request.contextPath}/scripts/jquery.uploadify-v2.1.4/cancel.png',
				  'buttonText'	   : 'Selecionar arquivos',
				  'folder'         : '${pageContext.request.contextPath}/upload',
				  'fileDataName'   : 'arquivos',
				  'scriptData'     :   'sessionId:${pageContext.request.session.id}', 
				  'multi'          : true,
				  'auto'           : false,
				  'fileExt'        : '*.jpg;*.pdf;',
				  'onError'        : function(event, queueID, fileObj, errorObj){  
                      alert('Houve um erro ao submeter suas imagens, o administrador já foi informado: Code='+errorObj.info);
				  }
			});
			
			$("#envio").click(function(){
				$("#arquivos").uploadifyUpload();
			});
		});
		</script>

        <style type="text/css">
            #basic-demo .uploadifyQueueItem {
                background-color: #F5F5F5;
                border: 2px solid #E5E5E5;
                font: 11px Verdana, Geneva, sans-serif;
                margin-top: 5px;
                padding: 10px;
                width: 350px;
            }
            #basic-demo .uploadifyError {
                background-color: #FDE5DD !important;
                border: 2px solid #FBCBBC !important;
            }
            #basic-demo .uploadifyQueueItem .cancel {
                float: right;
            }
            #basic-demo .uploadifyQueue .completed {
                background-color: #E5E5E5;
            }
            #basic-demo .uploadifyProgress {
                background-color: #E5E5E5;
                margin-top: 10px;
                width: 100%;
            }
            #basic-demo .uploadifyProgressBar {
                background-color: #0099FF;
                height: 3px;
                width: 1px;
            }
        </style>

    </head>
    <body>
       <form enctype="multipart/form-data" method="post" >

		<fieldset>
			<input type="file" id="arquivos" name="arquivos" />
			<a href="#" id="envio">Enviar</a>
		</fieldset>

		</form>
    </body>
    </tiles:putAttribute>
</tiles:insertTemplate>