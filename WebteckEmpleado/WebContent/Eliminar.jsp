<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="modelo.Ejb.UsuarioEjb"%>
<%@ page import="modelo.Pojo.UsuarioPojo"%>
<%@ page import="modelo.Ejb.SesionEjb"%>


<%!UsuarioEjb usuarios;%>

<%!SesionEjb sessiones;%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eliminar</title>
</head>
<body>

	<%
		String error = (String) request.getParameter("error");
		UsuarioPojo usu = (UsuarioPojo) request.getAttribute("usuario");
	%>

	<%
		Context context = null;

		context = new InitialContext();

		usuarios = (UsuarioEjb) context.lookup("java:global/WebteckEmpleado/UsuarioEjb");
		sessiones = (SesionEjb) context.lookup("java:global/WebteckEmpleado/SesionEjb");

		UsuarioPojo usuariosP = sessiones.usuariosLogeado(session);
		usuariosP = (UsuarioPojo) request.getAttribute("usuario");
	%>


	Eliminar Usuario
	<button type='button' onClick='window.location.replace("Pagina")'>Volver
		a Principal</button>

	<button id="eliminar" type='button' onClick='eliminarUsuario()'>Eliminar</button>



	<%
		if (error != null) {
	%>
	<h4>Hay errores en el usuario o password/o no estas Registrado</h4>
	<button type='button'
		onClick='window.location.replace("LogearUsuarios")'>Registrate</button>
	<button type='button' onClick='window.location.replace("Login")'>Reintentar</button>
	<%
		}
	%>
	<script>
		function eliminarUsuario() {
			console.log("eliminarUsuario -----------------------------------------------");
			if(confirm(" Seguro que deseas eliminar la Cuenta?¿")) {
				window.location.replace("DarBajaEmpleado?emailUsuario=<%=usuariosP.getEmailUsuario()%>");
			}
		}
	</script>
</body>
</html>