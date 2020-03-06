<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>springweb_security_hibernate_userDetailsService</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="panel panel-danger">
			<div class="panel-heading">Error: de Sesion!</div>
			<div class="panel-body">
				<p>Lo sentimos, SU sesion a caducado.</p>
				<a class="btn btn-default"
					href="${pageContext.request.contextPath}/mi_pagina_login?logout" role="button">Ir al
					inicio</a>
			</div>
		</div>
	</div>
</body>
</html>