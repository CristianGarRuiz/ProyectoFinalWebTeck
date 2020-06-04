
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="modelo.Pojo.CarritosPojo"%>
<%@ page import="modelo.Pojo.UsuariosPojo"%>
<%@ page import="modelo.Pojo.DireccionesPojo"%>
<%@ page import="modelo.Pojo.CategoriasPojo"%>
<%@ page import="modelo.Pojo.MarcasPojo"%>
<%@ page import="modelo.Pojo.CarritosPojo"%>

<!DOCTYPE html>
<html>
<head>
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
<link type="text/css" href="estilos/FichaUsuario.css" rel="stylesheet" />
</head>
</head>


<body style="background-image: url(imagenes/fondoLogin.png)">

	<%
		String error = (String) request.getParameter("error");
		CarritosPojo contarCarrito = (CarritosPojo) request.getAttribute("contarCarro");
		DireccionesPojo prod = (DireccionesPojo) request.getAttribute("direccion");
		UsuariosPojo usu = (UsuariosPojo) request.getAttribute("usuario");
	%>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
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
					<li class="nav-item"><a class="nav-link"
						href="Informacion.jsp">Informacion</a></li>
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
							<a id="Login12" class="dropdown-item" href="Login"><button
									type="submit"
									<i class='fas fa-door-open' style='font-size:18px'></i>></button>Login</a>
							<a id="Login13" class="dropdown-item" href="LogeaUsuarios"><button
									type="submit"
									<i class='fas fa-portrait' style='font-size:19px'></i>></button>Registro</a>
						</div></li>
				</ul>
		

			<div class="container-fluid col-sm-5 col-md-6">

				<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

					<form class="form-inline" action="Principal" method="post">
						<input class="form-control mr-sm-2" type="text" name="titulo" required="required"
							placeholder="Buscar...">
						<button class="btn btn-info" id="BotonBusqueda" type="submit">Buscar</button>
					</form>






				</nav>
				<nav class="navbar navbar-expand-sm bg-dark navbar-dark ">
					<!-- Brand/logo -->

					<%
						if ((usu != null) && (usu.getUsuario() != null)) {
					%>
					<div id="Datos col-sm-12 col-md-12">
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
							style="margin-left: 46%;" id="checkout_items"
							class="checkout_items"><%=contarCarrito.getIdProducto()%></span>
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
			</div>
	</nav>


	<div id="infoLog"
		style="position: relative; display: flex; margin-top: 11%; margin-bottom: -11%; margin-left: 40%; margin-right: auto"
		class="container">
		<h2 id="TextLogin">Editar Direccion</h2>
		<p>
			<i class='fa fa-address-card-o'
				style='margin-left: 44%; font-size: 58px; color: black'></i>
		</p>
	</div>

	<div id="EditarDireccion" class="container">

		<%
			if (prod == null) {
				out.println("<br/>");
				out.println("<br/>");
				out.println("<a href=\"Login\"> Login</a>");
			} else {
				out.println("<form class=\"form-horizontal\"  action=\"EditarDireccion\" method=\"post\">");

				out.println(
						"<input type=\"hidden\" name=\"emailUsuario\" value=\"" + prod.getEmailUsuario() + "\" /> ");
				out.println("<input type=\"hidden\" name=\"id\" value=\"" + prod.getId() + "\" /> ");

				out.println("<div class='form-group>'");
				out.println("<label class='control-label col-sm-2' for=\"Direccion\">Direccion:</label>");
				out.println("<div class='col-sm-10'>");
				out.println("<input  type=\"text\" name=\"Direccion\" value=\"" + prod.getDireccion() + "\" /> ");
				out.println("</div>");
				out.println("</div>");

				out.println("<div class='form-group>'");
				out.println("<label class='control-label col-sm-2' for=\"Localidad\">: Localidad</label>");
				out.println("<div class='col-sm-10'>");
				out.println("<input type=\"text\" name=\"Localidad\" value=\"" + prod.getLocalidad() + "\" /> ");
				out.println("</div>");
				out.println("</div>");

				out.println("<div class='form-group>'");
				out.println("<label class='control-label col-sm-2' for=\"Provincia\">Provincia:</label>");
				out.println("<div class='col-sm-10'>");
				out.println("<input type=\"text\" name=\"Provincia\" value=\"" + prod.getProvincia() + "\" /> ");
				out.println("</div>");
				out.println("</div>");

				out.println("<div class='form-group>'");
				out.println("<label  class='control-label col-sm-2' for=\"Vivienda\">Vivienda:</label>");
				out.println("<div class='col-sm-10'>");
				out.println("<input type=\"text\" name=\"Vivienda\" value=\"" + prod.getVivienda() + "\" /> ");
				out.println("</div>");
				out.println("</div>");

				out.println("<div class='form-group>'");
				out.println("<label class='control-label col-sm-2' for=\"CodigoPostal\">CP:</label>");
				out.println("<div class='col-sm-10'>");
				out.println(
						"<input type=\"number\" name=\"CodigoPostal\" value=\"" + prod.getCodigoPostal() + "\" /> ");
				out.println("</div>");
				out.println("</div>");
				out.print("<br><br>");
				out.print(
						"<button style=\"height: 9%;border-radius: 7px;text-decoration: none;\"  id=\"botonErrorLogin\" type=\"button\" onClick=\"window.location.replace('Principal')\">Volver a Principal</button>");
				out.println("<input type= \"submit\" value= \"Editar\" /> ");
				out.println("</form>");
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

</html>