<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
 
 
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<style type="text/css">
.rowFirst { 
		     width: 88% ;background: lightgreen; border-radius: 1em ; padding: 0.1em 
		}
		
.colTitle { 
		     width: 88% ;background: lightgreen; border-radius: 1em ; padding: 0.1em 
		}	
	
			
		
</style>

<script>
	window.contextRoot = '${contextRoot}'
	
</script>

<title>Carga de Archivos</title>
<!-- Bootstrap   
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 
 <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/static/css/jquery-ui.css">
	
	 <!-- Bootstrap styles 

<link rel="stylesheet" href="${contextRoot}/recursos/static/jquery/css/style.css">-->

<!-- CSS to style the file input field as button and adjust the Bootstrap progress bars
<link rel="stylesheet" href="${contextRoot}/recursos/static/jquery/css/jquery.fileupload.css">

 -->
</head>
</head>
<body>

 
    

    <div class="container">
	<h1>Carga Documentos..</h1>
	
	 
	 
	<c:if test="${not empty titulo1}" >   
	 <h2 class="lead">Tipos de Documentos: <span  class="label label-primary"> ${titulo1} </span></h2>
    </c:if> 
    
    <c:if test="${not empty titulo2}" >   
	 <h2 class="lead">Tipos de Documentos: <span class="label label-primary"> ${titulo2} </span></h2>
    </c:if> 
    
    <c:if test="${not empty titulo3}" >   
	 <h2 class="lead">Tipos de Documentos: <span class="label label-primary"> ${titulo3} </span></h2>
    </c:if> 
    
    <hr>
     
       <c:if test="${not empty mensaje}">
				<div id="exito"  class="alert alert-success" >
					<p>${mensaje}</p>
				</div>
			</c:if>
  
  
     <ul class="nav nav-tabs">
        <li class="active"><a href="<%=request.getContextPath()%>/files">Archivos CSD </a></li>
        <li><a href="<%=request.getContextPath()%>/files/listEmp">Archivos FIEL </a></li>
        <li><a href="<%=request.getContextPath()%>/files/listasEmp">Comprobante Domicilios</a></li>
         
    </ul>
    <br>
			
	</div>
	
	
		<!-- Load only when user clicks contact -->
			<c:if test="${csd == true }">
				<%@include file="upload/tipocsd.jsp"%>
			</c:if>
			
			<!-- Load only when user clicks contact -->
			<c:if test="${fiel == true }">
				<%@include file="upload/tipofiel.jsp"%>
			</c:if>
			
			
			<!-- Load only when user clicks contact -->
			<c:if test="${domicilio == true }">
				<%@include file="upload/tipodomicilio.jsp"%>
			</c:if>

<!--  

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
-->

   <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/static/js/jquery-1.12.4.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/recursos/static/js/jquery-ui.min.js"></script>
   
   <!-- Data table Script -->
	<script src="${js}/datatables.js"></script>
	<script src="${js}/datatables.min.js"></script>


	<!-- DataTable Bootstrap Script -->
	<script src="${js}/bootbox.min.js"></script>

	<!-- Self coded javascript -->
	<script src="${js}/myTest.js"></script>
  
 
 
 
   
   </script>
 
 

</body>
</html>