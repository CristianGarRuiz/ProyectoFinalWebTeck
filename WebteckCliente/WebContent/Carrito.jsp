<%@page import="modelo.Pojo.DireccionesPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ page import="modelo.Pojo.UsuariosPojo"%>
<%@ page import="modelo.Pojo.CategoriasPojo"%>
<%@page import="modelo.Pojo.CarritosPojo"%>
<%@page import="modelo.Pojo.MarcasPojo"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<title>Carrito</title>
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
<link type="text/css" href="estilos/ProductoCarro.css" rel="stylesheet" />
</head>
<body style="background-image: url('imagenes/made.jpg');">


	<%
		String error = (String) request.getParameter("error");
		String emailUsuario = (String) request.getParameter("emailUsuario");

		UsuariosPojo usu = (UsuariosPojo) request.getAttribute("usuario");

		ArrayList<CarritosPojo> productosCarrito = (ArrayList<CarritosPojo>) request
				.getAttribute("productosCarrito");

		CarritosPojo contarCarrito = (CarritosPojo) request.getAttribute("contarCarro");

		CarritosPojo totalCarro = (CarritosPojo) request.getAttribute("totalCarro");

		ArrayList<DireccionesPojo> direccionesUsuarios = (ArrayList<DireccionesPojo>) request
				.getAttribute("direccionesUsuarios");
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
						if ((usu != null) && (usu.getEmailUsuario() != null)) {
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
							id="checkout_items" class="checkout_items">Registrate o
								Logeate</span>
						</a>
					</ul>


					<%
						}
					%>
				
			</div>
	</nav>
	</div>
	</nav>

	<div class="container col-xs-10 col-md-9  col-xl-10"
		style="margin-top: 16%;">
		<div class="row">
			<div class="col-sm-7 col-md-7 col-xl-7" id="idCarrito">
				<h2>Carrito</h2>
				<div class="Carrito ">
					<h4>
						Subtotal(<%=contarCarrito.getIdProducto()%>
						Productos)
					</h4>

					<%
						if (contarCarrito.getIdProducto() == 0) {
					%>

					<h4>No tienes nada en el carrito</h4>
					<%
						} else {
					%>

					<%
						if (productosCarrito != null) {
					%>
					<%
						for (CarritosPojo prod : productosCarrito) {
					%>
					<div class="container mt-3 ">
						<div class="media border p-3">
							<img src="Imagenes/<%=prod.getFoto()%>" alt=""
								class="mr-3 mt-3 rounded-circle" style="width: 60px;">
							<div class="media-body">
								<h4>
									Producto :
									<%=prod.getTitulo()%></h4>
								<p>
									Stock :
									<%=prod.getStock()%></p>
								<p>
									Precio :
									<%=prod.getPrecio()%></p>
								<div id="OpcionesCarrito">
									<a id="CarritoProd"
										href='EliminarCarrito?id=<%=prod.getIdProducto()%>'>
										Eliminar </a> <a id="PagarProducto"
										href='PagarCarrito?id=<%=prod.getIdProducto()%>'>Tramitar
										Pedido </a>
								</div>
							</div>
						</div>
					</div>
					<%
						}
					%>

					<%
						if (totalCarro != null) {
					%>


					<h5>
						Total :
						<%=totalCarro.getPrecio()%></h5>

					<%
						} else {
					%>
					<h6></h6>

					<%
						}
					%>

					<%
						}
					%>



					<%
						}
					%>
				</div>
			</div>



			<%
				if ((direccionesUsuarios != null) && (direccionesUsuarios.size() > 0)) {
			%>
			<div class="container  col-sm-4 col-md-4 col-xl-4" id="TituloDire">


				<h3>Direccion del Usuario :</h3>


				<%
					for (DireccionesPojo prod : direccionesUsuarios) {
				%>
				<div class="Direccion_Usuarios">
					<div class="Direccion_Item">
						<div class="Datos_Item">
							<div class="Direccion ">
								<span> Calle : <%=prod.getDireccion()%></span>
							</div>
							<div class="Localidad_Item"></div>
							<div class=" Provincia_Item flex-column align-items-center">
								<span> Provincia : <%=prod.getProvincia()%></span>
							</div>
							<div class="Vivienda_Item">
								<h6 class="product_name">
									<span> Vivienda : <%=prod.getVivienda()%></span>
								</h6>
								<div class="CodigoPostal_Item">
									<span> CP: <%=prod.getCodigoPostal()%></span>
								</div>
								<div class="Localidad_Item">
									<span> Localidad : <%=prod.getLocalidad()%></span>
								</div>
							</div>
							<div id="OpcionesDireccion">
								<a style="text-decoration: none;" class="bestSellerProd"
									href='EditarDireccion'> Editar Direccion </a> <a
									style="text-decoration: none;" class="bestSellerProd"
									href='EliminarDireccion'> Eliminar Direccion </a>
							</div>
						</div>
					</div>
				</div>
			</div>


			<%
				}

				} else {
			%>

			<div class="container col-sm-4 col-md-4 col-xl-4">
				<div class="row">
					<div id="SinDatosDireccion">
						<h4>No tiene Direccion Añadida</h4>
						<p>*Pulsa Aqui Para Añadir una</p>
						<button id="botonErrorLogin" type='button'
							onClick='window.location.replace("FichaUsuario")'>Perfil
							Usuario</button>
					</div>
				</div>
			</div>


			<%
				}
			%>

		</div>
	</div>



	<%
		if (error != null) {
	%>
	<h4 style="color: red;">Error No tienes Una Direccion de Entrega
		Registrado</h4>
	<div id="contaLoginBotonesError" class="container col-sm-11 col-md-6">
	</div>
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