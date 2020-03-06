<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>.:cji cdmx:.</title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/recursos/static/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/recursos/static/css/stylelogin.css"  rel="stylesheet"/>

 
	
  <style>
	#exito { width: 500px; }
	#error { width: 600px; }
	
	</style>
</head>

<body>
<div class="main">    
    
   <div class="container">
      
  	 <sec:authorize access="!isAuthenticated()">      
  	 
			<c:if test="${not empty error}">
				<div id="error" class="alert alert-danger">
					<p>${error}</p>
				</div>
			</c:if>

        
			<c:if test="${not empty msg}">
				<div id="exito"  class="alert alert-warning" >
					<p>${msg}</p>
				</div>
			</c:if>    
			
       
		<div class="middle">
				<div id="login">
                    
					<form name="f" action="${pageContext.request.contextPath}/login" method="post" role="form">
				     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						
						<fieldset class="clearfix">
							<p>
								<span class="fa fa-user"></span>
								<input type="text" Placeholder="Usuario" required name="username" id="ipt_usuario">									
							</p>
							<!-- JS because of IE support; better: placeholder="Username" -->
							<p>
								<span class="fa fa-lock"></span>
								<input type="password" Placeholder="Contraseña" required name='password'>									
							</p>
							<!-- JS because of IE support; better: placeholder="Password" -->

							<div>
									<span
										style="width: 48%; text-align: left; display: inline-block;"><a
										class="small-text" href="#">Forgot password?</a>
									 </span> 
									 <span
										style="width: 50%; text-align: right; display: inline-block;">
										<input type="submit" value="Iniciar sesion">
									</span>
							</div>

						</fieldset>
						<div class="clearfix"></div>
					</form>
					<div class="clearfix"></div>

				</div>
				<!-- end login -->
				 <div class="logo">
    						<img src="${pageContext.request.contextPath}/recursos/static/img/LOGO_cji.png"/>
      			</div>  
          
          <div class="clearfix"></div>
          <!-- end middle -->
      </div>
      
      </sec:authorize>
      <!-- end container -->       
      
   </div>
 <!-- end del class main -->
 
</div>
    <script	src="${pageContext.request.contextPath}/recursos/static/js/jquery.js"></script>
   
   <script	src="${pageContext.request.contextPath}/recursos/static/js/bootstrap.min.js"></script>
  
   
 <script type="text/javascript">
$(document).ready(function(){
$("#ipt_usuario").click(function(){
$("#exito").hide();
});
$("#ipt_usuario").click(function(){
$("#error").hide();
});
});
</script>

 
</body>
</html>