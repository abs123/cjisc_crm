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
			<span class="label label-primary">Detalle de Archivos Comprobante De Domicilio</span>
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
                	    <c:forEach var="file"  items="${listFilesDomicilio}">
                	        <tr>
                	            <th>${file.nombreEmpresa}</th> 
                	        	<th>${file.nombre}</th>
                	        	<th>${file.ruta}</th>
                	        
                	        
                	        </tr>             
                	    
                	    
                	    </c:forEach>
                	  
                	  
                	  </tbody>
                	
                	
                	</table>
                
                 
        </div>
    </body>
</html>