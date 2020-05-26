<%@page import="modelo.Pojo.ProductosTiendaPojo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="modelo.Pojo.UsuariosPojo"%>
<%@ page import="modelo.Pojo.MarcasPojo"%>
<%@ page import="modelo.Pojo.CategoriasPojo"%>
<%@page import="modelo.Pojo.CarritosPojo"%>
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
<link type="text/css" href="estilos/PrincipalNocturna.css"
	rel="stylesheet" />
</head>
<body>
	<%
		String error = (String) request.getParameter("error");

		UsuariosPojo usu = (UsuariosPojo) request.getAttribute("usuario");

		ArrayList<MarcasPojo> MarcasID = (ArrayList<MarcasPojo>) request.getAttribute("MarcasID");

		ArrayList<ProductosTiendaPojo> productosMarcaid = (ArrayList<ProductosTiendaPojo>) request
				.getAttribute("productosMarcaid");

		ProductosTiendaPojo contarProds = (ProductosTiendaPojo) request.getAttribute("contarProds");
		CarritosPojo contarCarrito = (CarritosPojo) request.getAttribute("contarCarro");
	%>

<nav  id="navPrinc" class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
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
					<li class="nav-item"><a class="nav-link" href="Informacion.jsp">Informacion</a>
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
							<a id="Login12" class="dropdown-item" href="Logins"><button
									type="submit"
									<i class='fas fa-door-open' style='font-size:18px'></i>></button>Login</a>
							<a id="Login13" class="dropdown-item" href="LogeaUsuarios"><button
									type="submit"
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
							class="fa fa-shopping-cart" aria-hidden="true">Carrito</i> <span style="margin-left: 46%;"
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




	<h3 style="text-align: center; margin-top: 9%;">Productos de
		categoria</h3>
	<h5>
		Total Productos :
		<%=contarProds.getTitulo()%></h5>
	<div class="main-content  col-sm-5 col-md-12 col-lg-12">
		<div class="row">

			<%
				if (productosMarcaid != null) {
			%>


			<%
				for (ProductosTiendaPojo prod : productosMarcaid) {
			%>

			<div class='product-item'>
				<div class='product discount product_filter'>
					<div class='product_image'>

					<img src="Imagenes/<%=prod.getFoto()%>" alt=""
												style="height: 98%; width: 42%; margin-left: 30%; margin-top: -9%;">
					</div>
					<div class='favorite favorite_left'></div>
					<div
						class='product_bubble product_bubble_right product_bubble_red
						d-flex flex-column align-items-center'>
						<span> <%
 	int productosZero = prod.getStock();

 			if (prod.getStock() > 10) {
 %> <span style="color: green;"> Disponibles: <%=prod.getStock()%></span>
							<%
								} else if (prod.getStock() <= 5) {
							%> <span style="color: red;"> Disponibles: <%=prod.getStock()%></span>
							<%
								} else if (productosZero == 0) {
							%> <span style="color: red"> No Disponibles : <%=prod.getStock()%></span>
							<%
								} else {
							%> <span style="color: green;"> Disponibles: <%=prod.getStock()%></span>
							<%
								}
							%></span>
					</div>
					<div class='product_info'>
						<h6 class='product_name'>
							<a> <%=prod.getTitulo()%></a>
						</h6>
						<div class='product_price'>
							<span> <%=prod.getPrecio()%> $
							</span>
						</div>
					</div>
					<div
						style="position: relative; display: flex; margin-left: -14%; height: 23%; width: 132%; padding: 0%; flex-wrap: wrap;">
						<%
												if (usu == null) {
											%>

											<a id="CarritoTienda" onclick="Productoad()">Añadir a
												Carrito </a>

											<%
												} else {
											%>
											<a id="CarritoTienda"
												href='AñadirCarrito?id=<%=prod.getId()%>'> Añadir a
												Carrito </a>
											<%
												}
											%>

											<br> <br>
											</n>
											<br> <a id="FichaProducto"
												href='Ficha?id=<%=prod.getId()%>'> Ver Producto </a>
					</div>
				</div>




			</div>
			<%
				}
			%>
			<%
				}
			%>

		</div>
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
	<script>
		function AlertStock() {
			alert("lo sentimos , No hay existencias !");
		}
	</script>


	<script>
		function Productoad() {
			alert("lo sentimos , Logeate o Registrate para poder Comprar !");
		}
	</script>
</body>
</html>