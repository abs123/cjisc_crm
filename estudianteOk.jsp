<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="panel panel-default">
	<div class="panel-heading">Resultado Estudiante</div>
	<div class="panel-body">
		<div class="container">
			<div class="row">

				<table class="table table-striped table-hover table-bordered"
					style="width: 800px;">
					<tbody>
						<tr>
							<td>User Name:</td>
							<td>${estudianteCommand.userName}</td>
						</tr>
						<tr>
							<td>Dirección:</td>
							<td>${estudianteCommand.direccion}</td>
						</tr>
						<tr>
							<td>Password:</td>
							<td>${estudianteCommand.password}</td>
						</tr>
						<tr>
							<td>Recibe newsletter:</td>
							<td>${estudianteCommand.recibeNewsletter}</td>
						</tr>
						<tr>
							<td>Temas favoritos:</td>
							<td><c:forEach items="${estudianteCommand.temas}" var="tema">
                                        [<c:out value="${tema}" />]
                                       </c:forEach></td>
						</tr>
						<tr>
							<td>Género:</td>
							<td>${estudianteCommand.genero}</td>
						</tr>
						<tr>
							<td>Número Favorito :</td>
							<td>${estudianteCommand.numeroFavorito}</td>
						</tr>
						<tr>
							<td>País:</td>
							<td>${estudianteCommand.pais}</td>
						</tr>
						<tr>
							<td>Habilidades de Spring:</td>
							<td>${estudianteCommand.experienciaSpring}</td>
						</tr>
						<tr>
							<td>Valor Secreto :</td>
							<td>${estudianteCommand.valorSecreto}</td>
						</tr>
					</tbody>
				</table>
				<a class="btn btn-default"
					href="<%=request.getContextPath()%>/estudiante" role="button">Volver</a>

			</div>
		</div>
	</div>
</div>


