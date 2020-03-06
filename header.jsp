<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<html lang="en">
<head>
<!-- boostrap   -->
<link
	href="${pageContext.request.contextPath}/recursos/static/css/bootstrap.min.css" rel="stylesheet">

 
<title>Header</title>

</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="#">Consorcio CJI</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse " id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">

					<li class="nav-item active"><a class="nav-link"
						href="<%=request.getContextPath()%>/home"><span
							class="glyphicon glyphicon-home"></span> Home</a></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Cat&aacute;logos </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item"
								href="<%=request.getContextPath()%>/catalogos/listaUsuarios">Usuarios</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item"
								href="<%=request.getContextPath()%>/catalogos/listaGrupo">Grupos</a>

							<a class="dropdown-item"
								href="<%=request.getContextPath()%>/catalogos/listaRepresentante">Representantes</a>
							<a class="dropdown-item"
								href="<%=request.getContextPath()%>/catalogos/listaPatio">Patios</a>
							<a class="dropdown-item"
								href="<%=request.getContextPath()%>/catalogos/listaEmpresa">Empresas</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">IMSS</a></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Empresas </a>

						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item"
								href="<%=request.getContextPath()%>/manage/empresas">Asignar
								Acta Ctva</a> <a class="dropdown-item"
								href="<%=request.getContextPath()%>/files">Asignar Archivos</a>
							
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Reporte</a>
						</div>
					</li>
					 
				</ul>

				<form id="logoutForm" action="${pageContext.request.contextPath}/logout" method="post">
					
					<ul class="nav navbar-nav navbar-right">
						<sec:authorize access="isAuthenticated()">
							<li class="active"><a href="javascript:formSubmit()"><span
									class="glyphicon glyphicon-log-out"></span> Cerrar Sesion </a></li>
							    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								
						</sec:authorize>
					</ul>
				</form>
			</div>
		</nav>
	</div>


	<!--  <script	src="${pageContext.request.contextPath}/recursos/static/js/jquery.js"></script>	-->

	<script src="${pageContext.request.contextPath}/recursos/static/js/jquery-3.4.1.min.js"></script>		
	<script src="${pagContext.request.contexPath}/recursos/static/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/recursos/static/js/bootstrap.min.js"></script>
	
	
	<script type="text/javascript">
		function formSubmit() {
			$("#logoutForm").submit();
		}
	</script>

</body>
</html>