<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<header>
 
</header>

<div class="container">
			<div class="panel panel-primary">
				<div class="panel-heading {background-color: red!important} ">Asignar Archivos tipo  <span style="color: red; ">Comprobante De Domicilio</span> </div>
				<div class="panel-body">
					<div class="container">					 
					 <div class="row">   
					   <div class="col">
							    <form:form modelAttribute="fileInfo" action="${contextRoot}/files/tipoDomicilio" method="post"  enctype="multipart/form-data" cssClass="form-horizontal" role="form">
							        
							        <div class="form-group row">
							        	 <div class="col-md-6">
								  		    <label for="empresa"> Empresa:</label>
								  		       <form:select  
												path="empresa_id" style="width: 500px;" cssClass="form-control">
												<form:option value="0" label="<--seleccione una empresa -->" />
													<form:options items="${emp}" itemLabel="nombre" itemValue="id" />
									           </form:select>
										  
							             </div>       
							        </div>
							      
							      <div class="form-group row">
							       	 <div class="col-md-4">
										  <label for="empresa"> Archivo tipo Comprobante Domicilio:</label>
										  <input type="file" class="form-control" name="file" id="empresa" accept=".pdf"/>
										  
							          </div>
							      </div>							     
   
							    <button type="submit" class="form-control  btn btn-success" style="width: 300px;">Enviar archivos</button>
							 </form:form>
					     </div>				
					 </div>				
			   	</div>
			</div>
		  </div>
	  
		
</div>