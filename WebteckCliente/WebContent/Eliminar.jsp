<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@page import="modelo.Ejb.UsuarioEjb"%> --%>
<%@ page import="modelo.Pojo.UsuariosPojo"%>
<%@ page import="modelo.Ejb.SesionesEjb"%>


<%-- <%!UsuarioEjb usuarios;%> --%>

<%!SesionesEjb sessiones;%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eliminar Cuenta</title>
</head>
<body>

	<%
		String error = (String) request.getParameter("error");
		UsuariosPojo usu = (UsuariosPojo) request.getAttribute("usuario");
		String Calculo = (String) request.getAttribute("calculoImc");
	%>

	<%
		Context context = null;

		context = new InitialContext();

		// 		usuarios = (UsuarioEjb) context.lookup("java:global/Imcmvc/UsuarioEjb");
		// 		sessiones = (SesionesEjb) context.lookup("java:global/Imcmvc/SesionesEjb");

		// 		UsuariosPojo usuariosP = sessiones.usuarioLogeado(session);
		// 		usuariosP = (UsuariosPojo) request.getAttribute("usuario");
	%>


	Eliminar esta Cuenta ?¿
	<button type='button' onClick='window.location.replace("Principal")'>Volver
		a Principal</button>

	<button id="eliminar" type='button' onClick='eliminarUsuario()'>Eliminar</button>



	<%
		if (error != null) {
	%>
	<h4>Hay errores en el usuario o password/o no estas Registrado</h4>
	<button type='button'
		onClick='window.location.replace("LogearUsuarios\)'>Registrate</button>
	<button type='button' onClick='window.location.replace(\Login")'>Reintentar</button>
	<%
		}
	%>
	<script>
 		function eliminarUsuario() {
 			console.log("eliminarUsuario -----------------------------------------------");
 			if(confirm(" Seguro que deseas eliminar la Cuenta?¿")) {
				window.location.replace("DarBajaUsuario?emailUsuario=<%=usu.getEmailUsuario()%>"); 

			}
 		}
	</script>
</body>
</html>