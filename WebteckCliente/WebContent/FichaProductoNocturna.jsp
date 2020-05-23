<%@page import="modelo.Pojo.ValorcionesPojo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="modelo.Pojo.UsuariosPojo"%>
<%@ page import="modelo.Pojo.ProductosTiendaPojo"%>
<%@ page import="modelo.Pojo.CategoriasPojo"%>
<%@ page import="modelo.Pojo.MarcasPojo"%>
<%@ page import="modelo.Pojo.CarritosPojo"%>

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
<link type="text/css" href="estilos/BusquedaProductoNocturna.css"
	rel="stylesheet" />

</head>
<body>


	<%
		String error = (String) request.getParameter("error");
		UsuariosPojo usu = (UsuariosPojo) request.getAttribute("usuario");

		String comentario = (String) request.getParameter("comentario");
		String valoraciones = (String) request.getParameter("valoracion");

		ArrayList<ProductosTiendaPojo> productosTienda = (ArrayList<ProductosTiendaPojo>) request
				.getAttribute("productosTienda");

		ArrayList<ValorcionesPojo> comentariosProd = (ArrayList<ValorcionesPojo>) request
				.getAttribute("comentariosProd");

		ArrayList<ValorcionesPojo> valoracionesProd = (ArrayList<ValorcionesPojo>) request
				.getAttribute("valoracionesProd");

		CarritosPojo contarCarrito = (CarritosPojo) request.getAttribute("contarCarro");
	%>

<nav  id="navPrinc" class="navbar navbar-expand-sm   fixed-top" style="background-color: orange;">
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
							<a id="Login12" class="dropdown-item" href="Login"><button
									type="submit"
									<i class='fas fa-door-open' style='font-size:18px'></i>></button>Login</a>
							<a id="Login13" class="dropdown-item" href="LogeaUsuarios"><button
									type="submit"
									<i class='fas fa-portrait' style='font-size:19px'></i>></button>Registro</a>
						</div></li>
				</ul>
			</div>

			<div class="container-fluid col-sm-5 col-md-6">

				<nav class="navbar navbar-expand-sm " style="background-color: orange;">

					<form class="form-inline" action="Principal" method="post">
						<input class="form-control mr-sm-2" type="text" name="titulo"
							placeholder="Buscar...">
						<button class="btn btn-info" id="BotonBusqueda" type="submit">Buscar</button>
					</form>






				</nav>
				<nav class="navbar navbar-expand-sm" style="background-color: orange;">
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


	<div class="main-content  col-sm-5 col-md-12 col-lg-12">

		<h3 style="text-align: center">Productos</h3>
		<div class="row">

			<%
				if (productosTienda != null) {
			%>
			<%
				for (ProductosTiendaPojo prod : productosTienda) {
			%>

			<div id="fichaProd" class='product-item'>
				<div class='product discount product_filter'>
					<div class='product_image'>

						<img style="text-align: center;" src='Imagenes/'
							<%=prod.getFoto()%> alt=''>
					</div>
					<div class='favorite favorite_left'></div>
					<div
						class='product_bubble product_bubble_right product_bubble_red
						d-flex flex-column align-items-center'>

						<%
							int productosZero = prod.getStock();

									if (prod.getStock() > 10) {
						%>
						<span style="color: green;"> Disponibles: <%=prod.getStock()%></span>

						<%
							} else if (prod.getStock() <= 5) {
						%>
						<span style="color: red;"> Disponibles: <%=prod.getStock()%></span>
						<%
							} else if (productosZero == 0) {
						%>
						<span style="color: red"> No Disponibles : <%=prod.getStock()%></span>
						<%
							} else {
						%>

						<span style="color: green;"> Disponibles: <%=prod.getStock()%></span>
						<%
							}
						%>
					</div>
					<div class='product_info'>
						<h6 class='product_name'>
							<a
								style="text-align: center; text-align: center; font-size: x-large; margin-left: auto; margin-right: auto; margin-left: 27%;">
								<%=prod.getTitulo()%></a>
						</h6>
						<div class='product_price'>
							<span style="font-size: large;"> Precio : <%=prod.getPrecio()%></span>
						</div>
						<button type="button" class="btn btn-primary"
							data-toggle="collapse" data-target="#demo">Descripcion</button>
						<div id="demo" class="collapse"><%=prod.getDescripcion()%></div>
					</div>
				</div>

				<a id="CarritoTienda" href='Editar?id=<%=prod.getId()%>'> Añadir
					a Carrito </a> <a id="FichaProducto" href='Pricnipal'>Volver a
					Principal </a>


			</div>
		</div>
	</div>

	<div class="container">
		<h2>Comentarios y Valoraciones</h2>
		<ul class="nav nav-tabs">
			<ul id="Coments" class="tabs">
				<li class="nav-item"><a class="nav-link active" href="#tab1">Valoraciones</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#tab2">Comentarios</a>
				</li>
			</ul>
		</ul>
	</div>

	<div class="secciones">

		<article id="tab1">
			<div class="container-fluid">
				<div class="container mt-3">
					<h3>Valoraciones</h3>
					<%
						if (usu != null) {
					%>
					<button type="button" id="botonValor" class="btn btn-primary"
						data-toggle="modal" data-target="#myModal">Valorar</button>
					<%
						} else {
					%>
					<h5>*Debes logearte para poder valorar este producto !</h5>
					<%
						}
					%>
					<!-- The Modal Valoracion -->
					<div class="modal" id="myModal">
						<div class="modal-dialog">
							<div class="modal-content">

								<!-- Modal Header -->
								<div class="modal-header">
									<h4 class="modal-title">Añadir Valoracion</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>

								<!-- Modal body -->
								<div class="modal-body">

									<form action="Ficha" method="post">
										<input type="hidden" name="id" value="<%=prod.getId()%>">
										Valora de 1 a 10 este Producto : <select
											class="browser-default custom-select" name="valoraciones">
											<option selected>Puntuacion</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
										</select>
										<button class="añadirValor" type="submit" name="ComentButton">Comentar</button>

									</form>
								</div>


								<!-- Modal footer -->
								<div class="modal-footer">
									<button type="button" class="btn btn-danger"
										data-dismiss="modal">Close</button>
								</div>

							</div>
						</div>
					</div>






					<%
						if (valoracionesProd != null) {
					%>
					<%
						for (ValorcionesPojo prods : valoracionesProd) {
					%>


					<div class="media border p-3">
						<img src="Imagenes/" <%=prods.getFoto()%>>
						<div class="media-body">
							<h7> Usuario : <%=prods.getEmailUsuario()%> </h7>
							<p style="margin-top: 1%;">
								Valoracion :
								<%
								int valoracion = prods.getValoraciones();

												if ((valoracion > 0) && (valoracion <= 3)) {
							%>

								<img
									style="height: 21%; position: relative; display: flex; width: 11%; margin-left: 9%; margin-bottom: 1%; margin-top: -2%;"
									id="imgValor" alt="" src="imagenes/img1Estrella.jpg">

								<%
									} else if ((valoracion >= 3) && (valoracion == 4)) {
								%>
								<img
									style="height: 21%; position: relative; display: flex; width: 11%; margin-left: 9%; margin-bottom: 1%; margin-top: -2%;"
									id="imgValor" alt="" src="imagenes/img2Estrella.jpg">
								<%
									} else if ((valoracion > 4) && (valoracion <= 6)) {
								%>
								<img
									style="height: 21%; position: relative; display: flex; width: 11%; margin-left: 9%; margin-bottom: 1%; margin-top: -2%;"
									id="imgValor" alt="" src="imagenes/img3Estrella.jpg">
								<%
									} else if (valoracion >= 6 && (valoracion <= 8)) {
								%>

								<img
									style="height: 21%; position: relative; display: flex; width: 11%; margin-left: 9%; margin-bottom: 1%; margin-top: -2%;"
									id="imgValor" alt="" src="imagenes/img4Estrella.jpg">
								<%
									} else if (valoracion > 8 && (valoracion <= 10)) {
								%>
								<img
									style="height: 21%; position: relative; display: flex; width: 11%; margin-left: 9%; margin-bottom: 1%; margin-top: -2%;"
									id="imgValor" alt="" src="imagenes/img5Estrella.jpg">


								<%
									}
								%>
							
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


		</article>






		<article id="tab2">
			<div class="container-fluid">
				<div class="container mt-3">
					<h3>Comentarios</h3>
					<%
						if (usu != null) {
					%>
					<button type="button" id="botonComent" class="btn btn-primary"
						data-toggle="modal" data-target="#myModal1">Comentar</button>
					<%
						} else {
					%>
					<h5>*Debes logearte para poder comentar este producto !</h5>
					<%
						}
					%>
					<!-- The Modal Comentario -->
					<div class="modal" id="myModal1">
						<div class="modal-dialog">
							<div class="modal-content">

								<!-- Modal Header -->
								<div class="modal-header">
									<h4 class="modal-title">Añadir Comentario</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>

								<!-- Modal body -->
								<div id="cuerpoModal" class="modal-body">
									<form action="Ficha" method="post">
										<input type="hidden" name="id" value="<%=prod.getId()%>">
										Comentario:
										<textarea type="text" name="comentario" id="comen"></textarea>
										<button class="añadirValor" type="submit" name="ComentButton">Comentar</button>

									</form>
								</div>

								<!-- Modal footer -->
								<div class="modal-footer">
									<button type="button" class="btn btn-danger"
										data-dismiss="modal">Close</button>
								</div>

							</div>
						</div>
					</div>



					<%
						if (comentariosProd != null) {
					%>
					<%
						for (ValorcionesPojo prods : comentariosProd) {
					%>

					<div class="media border p-3">
						<img src="Imagenes/" <%=prods.getFoto()%> alt="">
						<div class="media-body">
							<h7> Usuario : <%=prods.getEmailUsuario()%> </h7>
							<p>
								Comentario :
								<%=prods.getComentarios()%></p>
						</div>
					</div>

					<%
						}
					%>
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
		</article>
	</div>
	<script>
		$(document).ready(function() {
			$('ul.tabs li a:first').addClass('active');
			$('.secciones article').hide();
			$('.secciones article:first').show();

			$('ul.tabs li a').click(function() {
				$('ul.tabs li a').removeClass('active');
				$(this).addClass('active');
				$('.secciones article').hide();

				var activeTab = $(this).attr('href');
				$(activeTab).show();
				return false;
			});
		});
	</script>


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