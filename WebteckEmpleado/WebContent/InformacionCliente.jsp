<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="modelo.Pojo.UsuarioPojo"%>
<%@ page import="modelo.Pojo.VentasPojo"%>

<!DOCTYPE html>
<html>
<head>
<title>ControlEmpleados</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<link rel="icon" type="imagenes/iconIma.gif" href="iconIma.gif">
<link type="text/css" href="estilos/Principal.css" rel="stylesheet" />
<link type="text/css" href="estilos/principalEmpleados.css"
	rel="stylesheet" />
</head>
<body>


	<%
		String error = (String) request.getParameter("error");
		UsuarioPojo usu = (UsuarioPojo) request.getAttribute("usuario");
		ArrayList<VentasPojo> ventasCliente = (ArrayList<VentasPojo>) request.getAttribute("ventasCliente");
		ArrayList<UsuarioPojo> datosCliente = (ArrayList<UsuarioPojo>) request.getAttribute("datosCliente");
	%>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		<a class=" navbar-brand" href="Principal.html"> <img
			src="imagenes/iconIma.gif" alt=""
			style="height: 35px; border-radius: 4%;">
		</a> <a style="color: cyan" class="navbar-brand" href="Pagina">WebTeck</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="container-fluid  col-sm-11">
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="BuscarProducto">BuscarProducto</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="Crear">Añadir
							Producto</a></li>
					<li class="nav-item"><a class="nav-link" href="InfoVentas">InfoVentas</a>
					</li>
					<li class="nav-items dropdown"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Login</a>
						<div class="dropdown-menu">
							<a id="Login12" class="dropdown-item" href="Login"><button
									type="submit"
									<i class="fas fa-door-open" style="font-size:18px"></i>></button>Login</a>

							<a id="Login13" class="dropdown-item" href="ComprobarAdmin"><button
									type="submit"
									<i class="fas fa-portrait" style="font-size:19px"></i>></button>Registro</a>
						</div></li>
				</ul>
			</div>
	</nav>

	<div class="container-fluid bg-info col-xs-6 col-sm-12 col-md-12"
		style="margin-top: 4%;">
		<div class="row">
			<ul>
				<h5 style="margin-top: 20%">Control de Empleados</h5>

				<%
					if (usu == null) {
				%>
				<div id="Datos">
					<p
						style="color: white; margin-left: 52px; margin-bottom: -4%; margin-top: -14%;">
						No Registrado <i class='far fa-user-circle'
							style='margin-left: 48%; font-size: 28px; color: white; align-items: center; display: contents;'></i>
					</p>


				</div>
				<%
					} else {
				%>
				<div id="Datos">
					<img alt="" src="Imagenes/<%=usu.getFoto()%>"
						style="height: 35px; border-radius: 4%; margin-left: 11%;"><br />
					<br />
					<p
						style="color: white; margin-left: 100px; margin-bottom: -4%; margin-top: -14%;">
						Bienvenido :
						<%=usu.getUsuario()%></p>

					<div id="Menuopciones" class="dropdown">
						<button class="btn btn-secondary dropdown-toggle" type="button"
							id="dropdownMenuButton" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">Opciones
							Usuario</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="#"><button type='button'
									onClick='window.location.replace("cambiarImagenEmpleado")'>Cambiar
									Imagen</button></a> <a class="dropdown-item" href="#"><button
									type='button' onClick='window.location.replace("Logout")'>Cerrar
									Sesion</button></a> <a class="dropdown-item" href="#">
								<button type='button'
									onClick='window.location.replace("OpcionesEliminarusu")'>BajaEmpleado</button>
							</a>
						</div>
					</div>

				</div>
				<%
					}
				%>
			
		</div>
	</div>

	<FORM action="InformacionCliente" method="post">
		emailUsuario : <INPUT type="text" name="emailUsuario" /> <BR /> <INPUT
			type="submit" value="Buscar" />
	</FORM>


	<div class="table-responsive">

		<%
			if (datosCliente != null && usu != null) {
				out.print("<h3>Informacion Cliente :</h3>");
				out.print("<table class= table>");
				out.print("<th> Imagen:</th>");
				out.print("<th> Nombre:</th>");
				out.print("<th> Usuario:</th>");
				out.print("<th> emailUsuario:</th>");
				out.print("</tr>");

				for (UsuarioPojo usua : datosCliente) {
					out.print("<tr>");
					out.print("<td> <img src= \"Imagenes/" + usua.getFoto()
							+ "\"style='height: 30%;width: 24%;	margin-left: auto;		margin-right: auto;'' ></td>");
					out.print("<td>" + usua.getNombre() + "</td>");
					out.print("<td>" + usua.getUsuario() + "</td>");
					out.print("<td>" + usua.getEmailUsuario() + "</td>");
					out.print("</tr>");

				}
				out.print("</table>");
			}
		%>


	</div>

	<div class="table-responsive">

		<%
			if (ventasCliente != null && usu != null) {
				out.print("<h3>Compras Cliente :</h3>");
				out.print("<table class= table>");
				out.print("<th> Codigo Pedido:</th>");
				out.print("<th> Fecha:</th>");
				out.print("<th> Nombre:</th>");
				out.print("<th> Precio:</th>");
				out.print("<th> Nombre Prod:</th>");
				out.print("</tr>");

				for (VentasPojo vent : ventasCliente) {
					out.print("<tr>");
					out.print("<td>" + vent.getCodigoPedido() + "</td>");
					out.print("<td>" + vent.getFecha() + "</td>");
					out.print("<td>" + vent.getNombre() + "</td>");
					out.print("<td>" + vent.getPrecio() + "€" + "</td>");
					out.print("<td>" + vent.getTitulo() + "</td>");
					out.print("</tr>");

				}
				out.print("</table>");
			} 
		%>
	</div>

	<%
		if (usu != null) {
	%>
	<script>
		window.onload = function() {
			document.getElementById("Login12").setAttribute('href', '#');
			document.getElementById("Login13").setAttribute('href', '#');
		}
	</script>
	<%
		}
	%>


	<%
		if (error != null) {
	%>
	<h4 style="color: red;">
		<h4>Fechas sin Resultados</h4>
		<button type='button' onClick='window.location.replace("Pagina")'>VolveraIntentar</button>
		<%
			}
		%>
		<%
			if (usu == null) {
		%>
		<script>
			window.onload = function() {
				alert("No esta Logeado para esta Funcion");
				window.location = 'Pagina';
			}
		</script>
		<%
			}
		%>
	
</body>
<footer class="container-fluid text-center bg-dark">
	<h3 id="nombre">Cristian Garcia</h3>
	<i class="fa fa-copyright" style="font-size: 36px; color: cyan;">
		webteckControl</i>
</footer>
</html>