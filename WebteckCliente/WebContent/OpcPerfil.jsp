<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="modelo.Pojo.UsuariosPojo"%>
<%-- <%@page import="modelo.Ejb.UsuarioEjb"%> --%>
<%-- <%@ page import="modelo.Ejb.SesionesEjb"%> --%>

<%-- <%!UsuarioEjb usuarios;%> --%>

<%-- <%!SesionesEjb sessiones;%> --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="Principal.css" />
<title>Insert title here</title>
</head>
<body>

<%-- 	<% --%>
// 		UsuariosPojo usu = (UsuariosPojo) request.getAttribute("usuario");
// 		String error = (String) request.getParameter("error");
<%-- 	%> --%>
<%-- 	<% --%>
// 		Context context = null;

// 		context = new InitialContext();
// 		usuarios = (UsuarioEjb) context.lookup("java:global/Imcmvc/UsuarioEjb");
// 		sessiones = (SesionesEjb) context.lookup("java:global/Imcmvc/SesionesEjb");
// 		UsuariosPojo usuariosP = sessiones.usuarioLogeado(session);
<%-- 	%> --%>


	<header>
		<div class="contendor">
			<img src="cuerpo.jpeg">
			<h1>IMC.org</h1>
			<input type="checkbox" id="menu-bar">

			<nav class="menu">
				<ul>
					<div class="CajaDerecha">
						<ul>
							<li><a href="Pagina">Inicio</a></li>
						</ul>
					</div>
					<li><a id="Login12" href="Login">Login</a></li>
					<li><a id="Login13" href="LogearUsuarios">Registro</a></li>
					<li><a href="Donaciones">Donaciones</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<main>
		<div id="Info">
			<h2 id="Texto2">Calculador del IMC</h2>
			<h3>Calcula tu IMC para saber como estas de saluda.</h3>
		</div>
	</main>
	<h2 id="Texto3">Calculador de IMC</h2>


	<h2>Opciones Usuario</h2>

	<ul id="ulmenu">
		<li><a href='OpcionesPerfil'>Perfil</a></li>
		<li><a href='Opcionessimulaciones'>Ver Simulaciones</a></li>
		<li><a href='OpcionesEliminarusu'>Eliminar Perfil</a></li>
	</ul>
	<h1 id='calculoHipoteca'></h1>
</body>
</html>


<h3 id='datosficha'>Ficha Usuario</h3>

<div id='CajaFicha'>
<!-- 	<h3>Nombre:</h3> -->
<!-- 	<br> -->
<%-- 	<%=usuariosP.getNombre()%> --%>
<!-- 	<br> -->
<!-- 	<h3>Correo:</h3> -->
<!-- 	<br> -->
<%-- 	<%=usuariosP.getEmailUsuario()%> --%>
<!-- 	<br> -->
<!-- 	<h3>usuario:</h3> -->
<!-- 	<br> -->
<%-- 	<%=usuariosP.getUsuario()%> --%>
<!-- 	<br> -->

	<div id='JuegosImg'>
<%-- 		<img id="juegos" src="Imagenes/<%=usuariosP.getFoto()%>"><br /> --%>
		<br />
		<button type='button' onClick='window.location.replace("Pagina")'>Volver
			a Principal</button>
		<br> <br>
	</div>
	<%
// 		if (usuariosP != null) {
	%>
	<script>
// 		window.onload = function() {
// 			document.getElementById("Login12").setAttribute('href', '#');
// 			document.getElementById("Login13").setAttribute('href', '#');
// 		}
	</script>
	<%
// 		}
	%>
	</body>
	</html>