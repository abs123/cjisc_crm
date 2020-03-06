<%@page import="org.springframework.context.annotation.Import"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

 
<html lang="en">
<head>
 
    <!-- Responsive CSS-->  
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/static/assets/css/icofont.css"/>
		<!-- Main style CSS --> 
 
 
    <!-- Iconfont CSS--> 
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/static/assets/css/style.css"/>
    
		
		
		
		
		
    <title>Home</title>
    
    
</head>
<body>
  <br>
    <section class="hero-area breadcrumb-area">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="hero-area-content">
							<h1>Bienvenido!  NUESTRA FIRMA CJI</h1>
							                          
						</div>
						<div class="">
							<h5 style="color:ghostwhite">Presta servicios a diferentes empresas con las siguientes actividades..</h5>
							                          
						</div>
					</div>
				</div>
			</div>
		</section><!-- breadcrumb area end -->
		<sec:authorize access="isAuthenticated()">      
		<h6>Bienvenido!     <strong>${pageContext.request.userPrincipal.name}  </strong></h6> 
        </sec:authorize>
        
        <section class="blog-detail" id="blog">
			<div class="container">
				<div class="row">
					<div class="col-lg-8">
					    <div class="blog-details">
							<img src="${pageContext.request.contextPath}/recursos/static/img/LOGO_cji.png" alt="blog-details">
						</div>
					    
					</div>
					<div class="col-lg-4">
					    <div class="sidebar">
							<div class="widget">
								
							</div>
							<div class="widget">
								<h4>Servicios</h4>
								<ul>
									<li><a href="#">Consultoria de Negocios</a></li>
									<li><a href="#">Servicios Legales</a></li>
									<li><a href="#">Administracion de RH</a></li>
									<li><a href="#">Tributacion</a></li>
								</ul>
							</div>
							<div class="widget">
								<h4>Categorias</h4>
								<ul>
									<li><a href="#">Gubernamental</a></li>
									<li><a href="#">Petrolero</a></li>
									<li><a href="#">Financiero</a></li>
									<li><a href="#">Construcción</a></li>
									<li><a href="#">Salud</a></li>
									
								</ul>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</section> 
    
    
    
    
    	<!-- Bootstrap JS 
		<script src="/recursos/static/js/bootstrap.js"></script>
		<script src="/recursos/static/js/jquery.js"></script>
	 -->
		 
    
</body>
</html>