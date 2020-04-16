<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="modelo.Pojo.UsuariosPojo"%>
<%@ page import="modelo.Pojo.VentaPojo"%>
<!DOCTYPE html>
<html>
<head>
<title>Webteck</title>
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
</head>
<body>


	<%
		String error = (String) request.getParameter("error");

		UsuariosPojo usu = (UsuariosPojo) request.getAttribute("usuario");

		ArrayList<VentaPojo> ventasCliente = (ArrayList<VentaPojo>) request.getAttribute("ventasCliente");

		String emailUsuario = (String) request.getAttribute("emailUsuario");
	%>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		<a class=" navbar-brand" href="Principal.html"> <img
			src="imagenes/iconIma.gif" alt=""
			style="height: 35px; border-radius: 4%;">
		</a> <a style="color: cyan" class="navbar-brand" href="#Puestos">WebTeck</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="container-fluid  col-sm-11">
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="#texto">Informacion</a>
					</li>
					<li class="nav-items dropdown"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Categorias</a>
						<div class="dropdown-menu">
							<%-- 						<% --%>
							// ArrayList
							<CategoriasPojo> cate = (ArrayList<CategoriasPojo>)
							request.getAttribute("categorias"); // if (cate != null) { // for
							(CategoriasPojo d : cate) { // out.println("<a
								class='dropdown-item' href='#'><button type='submit'></button>"
								+ d.getNombre() // + "</a>"); // } // } <%-- 						%> --%>
						</div></li>

					</li>
					<li class="nav-item"><a class="nav-link" href="#Info">Contacto</a>
					</li>
					<li class="nav-items dropdown"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Login</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#"><button type="submit"
									<i class='fas fa-door-open' style='font-size:18px'></i>></button>Login</a>
							<a class="dropdown-item" href="#"><button type="submit"
									<i class='fas fa-portrait' style='font-size:19px'></i>></button>Registro</a>
						</div></li>
				</ul>
			</div>

			<div class="container-fluid col-sm-5 col-md-6">

				<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

					<form class="form-inline" action="Principal" method="post">
						<input class="form-control mr-sm-2" type="text" name="titulo"
							placeholder="Buscar...">
						<button class="btn btn-info" id="BotonBusqueda" type="submit">Buscar</button>
					</form>






				</nav>
				<nav class="navbar navbar-expand-sm bg-dark navbar-dark ">
					<!-- Brand/logo -->

					<%
						if (usu.getUsuario() != null) {
					%>
					<div id="Datos">
						<img alt="" src="Imagenes/<%=usu.getFoto()%>"
							style="height: 35px; border-radius: 4%;"><br /> <br />
						<p
							style="color: white; margin-left: 37px; margin-bottom: 48%; margin-top: -34%; width: 106%">
							Bienvenido :
							<%=usu.getUsuario()%></p>

						<div id="Menuopciones" class="dropdown">
							<button class="btn btn-secondary dropdown-toggle" type="button"
								id="dropdownMenuButton" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false">Opciones
								Usuario</button>
							<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
								<a class="dropdown-item" href="#"><button type='button'
										onClick='window.location.replace("cambiarImagen")'>Cambiar
										Imagen</button></a> <a class="dropdown-item" href="#"><button
										type='button' onClick='window.location.replace("Logout")'>Cerrar
										Sesion</button></a> <a class="dropdown-item" href="#">
									<button type='button'
										onClick='window.location.replace("OpcionesEliminarusu")'>BajaUsuario</button>
								</a>
							</div>
						</div>

					</div>
					<%
						} else {
					%>

					<a class="navbar-brand" href="#">
						<p>No Registrado</p>
					</a>

					<%
						}
					%>
					<ul class="checkout">
						<a style="margin-right: 2%" href="#"> <i
							class="fa fa-shopping-cart" aria-hidden="true">Carrito</i> <span
							id="checkout_items" class="checkout_items">0</span>
						</a>
					</ul>
			</div>
	</nav>

	<div class="container"
		style="position: relative; display: inline-flex; margin-top: 9%;">

		<%
			if (ventasCliente != null && emailUsuario != null && emailUsuario != "") {
				out.print("<Busqueda Producto>");
				out.print("Recuperacion de comprar del usuario : " + emailUsuario);
				out.print("<br><br>");
				out.print("<table class=table table-hover table-responsive>");
				out.print("<th> Nombre Producto :</th>");
				out.print("<th> Fecha de la Compra :</th>");
				out.print("<th> Precio Producto :</th>");
				out.print("<th> Nombre del Usuario de la Compra:</th>");
				out.print("</tr>");

				for (VentaPojo juga : ventasCliente) {

					out.print("<tr>");
					out.print("<td>" + juga.getTitulo() + "</td>");
					out.print("<td>" + juga.getFecha() + "</td>");
					out.print("<td>" + juga.getPrecio() + "$" + "</td>");
					out.print("<td>" + juga.getNombre() + "</td>");

				}
				out.print("</table>");

			} else {
				out.print("<h4>No tenemos Ventas</h4>");
			}
		%>
	</div>

	<button type='button' onClick='window.location.replace("Principal")'>Volver
		a Principal</button>

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
	
</body>
</html>