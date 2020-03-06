<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Archivos</title>
      
	 <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
    </head>
    <body>
        <div class="container">
          <div class="page-header">
			<h2>Archivos cargados al Sistema</h2>
		</div>
        
             <h2>
			<span class="label label-primary">Detalle de Archivos FIEL</span>
		    </h2>
             
                	<table class="table table-striped table-hover">
                	  
                	  <thead>
                	   <tr>
                	     <th> Empresa</th>
                	     <th> Nombre Archivo  </th>
                	     <th> Ruta Archivo</th>
                	   </tr>
                	  </thead>
                	
                	  <tbody>
                	    <c:forEach var="fileList"  items="${fileFile}">
                	        <tr>
                	            <th>${fileList.nombreEmpresa}</th> 
                	        	<th>${fileList.nombre}</th>
                	        	<th>${fileList.ruta}</th>
                	        
                	        
                	        </tr>             
                	    
                	    
                	    </c:forEach>
                	  
                	  
                	  </tbody>
                	
                	
                	</table>
                
                 
        </div>
    </body>
</html>