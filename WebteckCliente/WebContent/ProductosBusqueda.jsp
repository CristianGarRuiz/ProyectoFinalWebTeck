<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="modelo.Pojo.UsuariosPojo"%>
<%@ page import="modelo.Pojo.CategoriasPojo" %>
<%@ page import="modelo.Pojo.MarcasPojo" %>
<%@ page import="modelo.Pojo.ProductosTiendaPojo"%>
<%@ page import="modelo.Pojo.CarritosPojo" %>

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
<link type="text/css" href="estilos/BusquedaProducto.css" rel="stylesheet" />

</head>
<body>


	<%
		String error = (String) request.getParameter("error");
		UsuariosPojo usu = (UsuariosPojo) request.getAttribute("usuario");

		ArrayList<ProductosTiendaPojo> productosTienda = (ArrayList<ProductosTiendaPojo>) request
				.getAttribute("productosTienda");
		String titulo = (String) request.getAttribute("titulo");
		ArrayList<ProductosTiendaPojo> Busquedaproducto = (ArrayList<ProductosTiendaPojo>) request
				.getAttribute("Busquedaproducto");
		
		CarritosPojo contarCarrito = (CarritosPojo) request.getAttribute("contarCarro");
	%>

		<nav id="navPrinc" class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		<a class=" navbar-brand" href="Principal.html"> <img
			src="imagenes/iconIma.gif" alt=""
			style="height: 35px; border-radius: 4%;">
		</a> <a style="color: cyan" class="navbar-brand" href="Principal">WebTeck</a>
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
							<%
								ArrayList<CategoriasPojo> cate = (ArrayList<CategoriasPojo>) request.getAttribute("categorias");
								if (cate != null) {
									for (CategoriasPojo d : cate) {

										out.println("<a class='dropdown-item' href='porCategoria?id=" + d.getId()
												+ "'><button type='submit'></button>" + d.getNombre() + "</a>");

									}
								}
							%>
						</div></li>
						<li class="nav-items dropdown"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Marcas</a>
						<div class="dropdown-menu">
							<%
								ArrayList<MarcasPojo> marca = (ArrayList<MarcasPojo>) request.getAttribute("marcas");
								if (cate != null) {
									for (MarcasPojo d : marca) {

										out.println("<a class='dropdown-item' href='porMarca?id=" + d.getId()
												+ "'><button type='submit'></button>" + d.getNombre() + "</a>");

									}
								}
							%>
						</div></li>

					</li>
					<li class="nav-item"><a class="nav-link" href="#Info">Contacto</a>
					</li>
					<li class="nav-items dropdown"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Login</a>
						<div class="dropdown-menu">
							<a id="Login12" class="dropdown-item" href="Login"><button type="submit"
									<i class='fas fa-door-open' style='font-size:18px'></i>></button>Login</a>
							<a  id="Login13" class="dropdown-item" href="LogeaUsuarios"><button type="submit"
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
						if ((usu != null) && (usu.getUsuario() != null)) {
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
										onClick='window.location.replace("cambiarImagenUsuario")'>Cambiar
										Imagen</button></a> <a class="dropdown-item" href="#"><button
										type='button' onClick='window.location.replace("Logout")'>Cerrar
										Sesion</button></a> <a class="dropdown-item" href="#">
									<button type='button'
										onClick='window.location.replace("OpcUsuarioEliminar")'>BajaUsuario</button>
									<a class="dropdown-item" href="#"><button type='button'
											onClick='window.location.replace("comprasUsuarios")'>Ver
											compras realizadas</button> </a> <a class="dropdown-item" href="#"><button
											type='button'
											onClick='window.location.replace("FichaUsuario")'>Datos
											Usuario</button> </a> <a class="dropdown-item" href="#"><button
											type='button'
											onClick='window.location.replace("cambioPantalla")'>Cambiar
											Pantalla</button> </a>
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
					<%
						if (usu != null) {
					%>

					<ul class="checkout">
						<a style="margin-right: 2%" href="VerCarrito"> <i
							class="fa fa-shopping-cart" aria-hidden="true">Carrito</i> <span
							id="checkout_items" class="checkout_items"><%=contarCarrito.getIdProducto()%></span>
						</a>
					</ul>

					<%
						} else {
					%>
					<ul class="checkout">
						<a style="margin-right: 2%" href="#"> <i
							class="fa fa-shopping-cart" aria-hidden="true">Carrito</i> <span
							id="checkout_items" class="checkout_items">Logeate</span>
						</a>
					</ul>


					<%
						}
					%>
			</div>
	</nav>
	</div>
	</nav>


	<div class="main-content  col-sm-5 col-md-12 col-lg-12">

		<h3  id="BusquedaTitulo" style="text-align: center">
			Busqueda Producto por : <%=titulo%></h3>
		<div class="row"></div>

		<%
			if (Busquedaproducto != null && titulo != null && titulo != "") {
				out.print("<Busqueda Producto>");
				out.print("<br><br>");
				out.print("<table class=table table-hover table-responsive>");
				out.print("<th> Nombre Producto :</th>");
				out.print("<th> Año Producto :</th>");
				out.print("<th> Precio Producto :</th>");
				out.print("<th> Descripcion Producto:</th>");
				out.print("<th> Marca Producto :</th>");
				out.print("<th> Plataforma Producto:</th>");
				out.print("<th> Modificar :</th>");
				out.print("<th> Eliminar : Producto:</th>");
				out.print("</tr>");

				for (ProductosTiendaPojo juga : Busquedaproducto) {

					out.print("<tr>");
					out.print("<td>" + juga.getTitulo() + "</td>");
					out.print("<td>" + juga.getAnyo() + "$" + "</td>");
					out.print("<td>" + juga.getPrecio() + "</td>");
					out.print("<td>" + juga.getDescripcion() + "</td>");
					out.print("<td>" + juga.getGenero() + "</td>");
					out.print("<td>" + juga.getPlataforma() + "</td>");
					out.print("<td><a href=\"AñadirCarrito?id=" + juga.getId() + "\"> Añadir al Carrito </a></td>");
					out.print("<td><a href=\"Ficha?id=" + juga.getId() + "\"> Ver Producto </a></td>");

				}
				out.print("</table>");

			} else {
				out.print("<h4>Buscar Productos</h4>");
			}
		%>

	</div>

	<div class="jumbotron text-center bg-dark" style="margin-bottom: 0;"
		id="Footer">

		<div class="container-fluid">
			<div class="row">

				<div class="container col-md-2">

					<h2>Informacion :</h2>
					<hr>
					<ol class="nav-item">
						<a id="" class="nav-link" href="#Habilidades">Sobre</a>
					</ol>
					<ol class="nav-item">
						<a id="" class="nav-link" href="#Habilidades">Acceso</a>
					</ol>
					<ol class="nav-item">
						<a id="" class="nav-link" href="#Habilidades">Blog</a>
					</ol>
					<ol class="nav-item">
						<a id="" class="nav-link" href="#Habilidades">Contacto</a>
					</ol>


				</div>

				<div class="container col-md-2">

					<h2>Siguenos en :</h2>
					<hr>
					<a class="Icon" href="https://twitter.com/login"
						<button type="submit"> <i class='fab fa-twitter' style='font-size:36px; '> </i></button>></a>
					<a class="Icon" href="https://www.facebook.com/"
						<button type="submit"> <i class='fab fa-facebook-square' style='font-size:36px'></i></button>></a>
					<a class="Icon" href="https://www.youtube.com/"
						<button type="submit"><i class='fab fa-youtube' style='font-size:36px;color: red'></i> </button>></a>
				</div>

				<div class="container col-md-2">

					<h2>Contactanos :</h2>
					<hr>
					<p style="color: white">Contactos</p>
					<p style="color: white">
						<i class='fas fa-location-arrow'></i> 1234 walstres ,Australia
					</p>
					<p style="color: white">
						<i class='fas fa-mail-bulk'></i> hello@gmail.com
					</p>
					<p style="color: white">
						<i class='fas fa-phone-alt'></i>tel:(123)4556+5646
					</p>
				</div>
			</div>

		</div>
	</div>
</body>

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
</html>