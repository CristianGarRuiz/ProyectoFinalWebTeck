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
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="Principal.css" />
<title>Insert title here</title>
</head>
<body>
	<%
		String error = (String) request.getParameter("error");
		UsuariosPojo usu = (UsuariosPojo) request.getAttribute("usuario");
		String Calculo= (String)request.getAttribute("calculoImc");
	%>

	<%
// 		Context context = null;

// 		context = new InitialContext();
		
// 		usuarios = (UsuarioEjb) context.lookup("java:global/Imcmvc/UsuarioEjb");
// 		sessiones = (SesionesEjb) context.lookup("java:global/Imcmvc/SesionesEjb");
		
// 		UsuariosPojo usuariosP = sessiones.usuarioLogeado(session);
// 		usuariosP = (UsuariosPojo)request.getAttribute("usuario");
	%>

	<header>
		<div class="contendor">
			<img src="cuerpo.jpeg" />
			<h1>Imc.org</h1>
			<input type="checkbox" id="menu-bar" />
			<nav class="menu">
				<ul>
					<div class="CajaDerecha">
						<ul>
							<li><a href="Pagina">Inicio</a></li>
						</ul>
					</div>
					<li><a id="Login12" href="Login">Login</a></li>

					<li><a>Simulaciones</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<main>
		<div id="Info">
			<h2>Simulaciones de Usuario</h2>

			<h3>Registrate para optimizar tus datos para la proxima vez</h3>

		</div>

	</main>

	<h2 id="Texto2">Recuperar Simulaciones</h2>
	<div id="InfoCorreo">
		<form action="Opcionessimulaciones" method="post">
			<br /> Email:<br /> <input type="text" name="emailUsuario" required
				placeholder="Introduce correo"> <br /> <br />
			<button id="Simu" type="submit" value="submit">Recuperar</button>
			<button id="CancelarSimu" type='button'
				onClick='window.location.replace("Pagina")'>Cancelar</button>
		</form>
	</div>


<%-- 	<% --%>
// 		if (usuariosP!=null) {
<%-- 	%> --%>
<!-- 	<script> -->
// 		window.onload = function() {
// 			document.getElementById("Login12").setAttribute('href', '#');
// 			document.getElementById("Login13").setAttribute('href', '#');
// 		}
<!-- 	</script> -->
<%-- 	<% --%>
// 		}
<%-- 	%> --%>

</body>
</html>