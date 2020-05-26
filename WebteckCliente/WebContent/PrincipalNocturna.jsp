<%@page import="modelo.Pojo.CarritosPojo"%>
<%@page import="modelo.Pojo.MarcasPojo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="modelo.Pojo.UsuariosPojo"%>
<%@ page import="modelo.Pojo.ProductosTiendaPojo"%>
<%@ page import="modelo.Pojo.CategoriasPojo"%>
<%@ page import="modelo.Pojo.PreguntasPojo"%>
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
<link type="text/css" href="estilos/PrincipalNocturna.css" rel="stylesheet" />
</head>
<body>


	<%
		String error = (String) request.getParameter("error");
		String emailUsuario = (String) request.getParameter("emailUsuario");

		UsuariosPojo usu = (UsuariosPojo) request.getAttribute("usuario");

		PreguntasPojo preguntas = (PreguntasPojo) request.getAttribute("preguntas");

		ArrayList<ProductosTiendaPojo> productosTienda = (ArrayList<ProductosTiendaPojo>) request
				.getAttribute("productosTienda");

		ArrayList<ProductosTiendaPojo> productosMedia = (ArrayList<ProductosTiendaPojo>) request
				.getAttribute("productosMedia");

		String titulo = (String) request.getAttribute("titulo");
		String pregunta = (String) request.getAttribute("pregunta");
		ArrayList<ProductosTiendaPojo> Busquedaproducto = (ArrayList<ProductosTiendaPojo>) request
				.getAttribute("Busquedaproducto");

		CarritosPojo contarCarrito = (CarritosPojo) request.getAttribute("contarCarro");
	%>

	<nav id="navPrinc"
		class="navbar navbar-expand-sm fixed-top" style="background-color: orange;">
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
								if (marca != null) {
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

				<nav class="navbar navbar-expand-sm" style="background-color: orange;">

					<form class="form-inline" action="Principal" method="post">
						<input class="form-control mr-sm-2" type="text" name="titulo"
							placeholder="Buscar...">
						<button class="btn btn-info" id="BotonBusqueda" type="submit">Buscar</button>
					</form>






				</nav>
				<nav class="navbar navbar-expand-sm "style="background-color: orange;">
					<!-- Brand/logo -->

					<%
						if ((usu != null) && (usu.getUsuario() != null)) {
					%>
					<div id="Datos col-sm-12 col-md-12">
						<img alt="" src=" Imagenes/<%=usu.getFoto()%> "
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
	</nav>
	</div>
	</nav>


	<div id="demo" class="carousel slide" data-ride="carousel">

		<!-- Indicators -->
		<ul class="carousel-indicators">
			<li data-target="#demo" data-slide-to="0" class="active"></li>
			<li data-target="#demo" data-slide-to="1"></li>
			<li data-target="#demo" data-slide-to="2"></li>
		</ul>

		<!-- The slideshow -->
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="imagenes/iphone11.png" alt="Iphone11" width="1000"
					height="300">
				<div class="carousel-caption">
					<h3>Nuevo Phone 11 PRO MAX</h3>
					<p>El nuevo movil de Apple</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="imagenes/lenovolegi.jpg" alt="lenovoLegion" width="700"
					height="300">
				<div class="carousel-caption">
					<h3>Lenovo LEGION</h3>
					<p>Las emociones con el GAMING</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="imagenes/samsung20.jpg" alt="Samsung" width="700px"
					height="300">
				<div class="carousel-caption">
					<h3>S20 + Nuevo</h3>
					<p>s20 MAX movil o camara !</p>
				</div>
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="carousel-control-prev" href="#demo" data-slide="prev"> <span
			class="carousel-control-prev-icon"></span>
		</a> <a class="carousel-control-next" href="#demo" data-slide="next">
			<span class="carousel-control-next-icon"></span>
		</a>
	</div>
	<div class="container-fluid col-md-8">
		<h2 class="texto">Filtro de Busqueda</h2>
		<form action="FiltroBusquedasPrincipal" method="post">
			<div class="container-fluid col-md-12">
				<div class="form-group row col-sm-5 col-md-12">
					<div class="form-group">
						<select name="Categorias" class="form-control" id="sel1"
							required="required">
							<option value="">Categorias</option>
							<%
								ArrayList<CategoriasPojo> cates = (ArrayList<CategoriasPojo>) request.getAttribute("categorias");
								if (cates != null) {
									for (CategoriasPojo d : cates) {

										out.println(" <option value=" + d.getId() + ">" + d.getNombre() + "</option>");

									}
								}
							%>
						</select>
					</div>
					<div class="form-group">
						<input type="number" name="precioIni"
							placeholder="Precio Minimo .." required="required">
					</div>
					<div class="form-group">
						<input type="number" name="precioFin"
							placeholder="Precio Maximo .." required="required">
					</div>
					<div class="form-group">
						<select name="Marcas" class="form-control" id="sel2"
							required="required">
							<option value="">Marcas</option>
							<%
								ArrayList<MarcasPojo> marcas = (ArrayList<MarcasPojo>) request.getAttribute("marcas");
								if (marcas != null) {
									for (MarcasPojo d : marcas) {

										out.println(" <option value=" + d.getId() + ">" + d.getNombre() + "</option>");

									}
								}
							%>

						</select>
					</div>

					<div class="form-group">
						<button id="BotonForm" type="submit" class="btn-success">Buscar</button>
					</div>
				</div>
			</div>
		</form>
	</div>


	<div class="best_sellers">
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<div class="section_title new_arrivals_title">
						<h2>Productos mejor Valorados</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<div class="product_slider_container"
						style="margin-bottom: 7%; margin-left: -5%;">
						<div class="owl-carousel owl-theme product_slider"
							style="display: flex; position: relative; margin-left: 9%; padding: 0%; margin-bottom: -3%; margin-block: 6%;">

							<!-- Slide 1 -->
							<%
								if (productosMedia != null) {
							%>
							<%
								for (ProductosTiendaPojo prod : productosMedia) {
							%>

							<div class="owl-item product_slider_item">
								<div class="product-item">
									<div class="product discount">
										<div class="product_image" id="prodImagen">
											<img src="Imagenes/<%=prod.getFoto()%>" alt=""
												style="height: 98%; width: 42%; margin-left: 30%; margin-top: -9%;">
										</div>
										<div class="favorite favorite_left"></div>
										<div
											class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center">
											<span><%=prod.getPrecio()%></span>
										</div>
										<div class="product_info">
											<h6 class="product_name">
												<a href="single.html"><%=prod.getTitulo()%></a>
											</h6>
											<div class="product_price">
												<span><%=prod.getPrecio()%></span>
											</div>
										</div>

										<p style="margin-top: 1%;">
											Valoracion :
											<%
											int valoracion = prod.getValoracion();

													if ((valoracion > 0) && (valoracion <= 3)) {
										%>
											<img
												style="height: 21%; position: relative; display: flex; width: 59%; margin-left: 51%; margin-bottom: 1%; margin-top: -12%;"
												id="imgValor" alt="" src="imagenes/img1Estrella.jpg">

											<%
												} else if ((valoracion >= 3) && (valoracion == 4)) {
											%>
											<img
												style="height: 21%; position: relative; display: flex; width: 59%; margin-left: 51%; margin-bottom: 1%; margin-top: -12%;"
												id="imgValor" alt="" src="imagenes/img2Estrella.jpg">
											<%
												} else if ((valoracion > 4) && (valoracion <= 6)) {
											%>
											<img
												style="height: 21%; position: relative; display: flex; width: 59%; margin-left: 51%; margin-bottom: 1%; margin-top: -12%;"
												id="imgValor" alt="" src="imagenes/img3Estrella.jpg">
											<%
												} else if (valoracion >= 6 && (valoracion <= 8)) {
											%>

											<img
												style="height: 21%; position: relative; display: flex; width: 59%; margin-left: 51%; margin-bottom: 1%; margin-top: -12%;"
												id="imgValor" alt="" src="imagenes/img4Estrella.jpg">
											<%
												} else if (valoracion > 8 && (valoracion <= 10)) {
											%>
											<img
												style="height: 21%; position: relative; display: flex; width: 59%; margin-left: 51%; margin-bottom: 1%; margin-top: -12%;"
												id="imgValor" alt="" src="imagenes/img5Estrella.jpg">


											<%
												}
											%>
										
										<div
											style="position: relative; display: flex; margin-left: auto; margin-right: auto; flex-wrap: wrap;">
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
							</div>

							<%
								}
							%>
							<%
								}
							%>

						</div>



						<!-- Slider Navigation -->

						<div
							class="product_slider_nav_left product_slider_nav d-flex align-items-center justify-content-center flex-column">
							<i class="fa fa-chevron-left" aria-hidden="true"></i>
						</div>
						<div
							class="product_slider_nav_right product_slider_nav d-flex align-items-center justify-content-center flex-column">
							<i class="fa fa-chevron-right" aria-hidden="true"></i>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<h3 style="text-align: center">Productos</h3>
	<div class="main-content  col-sm-12 col-md-12 col-lg-12">
		<div class="row">

			<%
				if (productosTienda != null) {
			%>
			<%
				for (ProductosTiendaPojo prod : productosTienda) {
			%>

			<div class='product-item'>
				<div class='product discount product_filter'>
					<div class='product_image' id="prodImagen">

						<img id="imgant" src="Imagenes/<%=prod.getFoto()%>" alt=''
							style="height: 160%; width: 27%; margin-top: -15%; margin-left: 36%;">
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
					<div style="position: relative; display: flex; flex-wrap: wrap;">

						<%
							int totalstock = prod.getStock();
									if (totalstock == 0) {
						%>

						<button id="CarritoTienda" onclick="AlertStock()">No hay
							existencias</button>

						<%
							} else if (usu == null) {
						%>

						<a id="CarritoTienda" onclick="Productoad()">Añadir a Carrito
						</a>

						<%
							} else {
						%>
						<a id="CarritoTienda" href='AñadirCarrito?id=<%=prod.getId()%>'>
							Añadir a Carrito </a>
						<%
							}
						%>

						<br> <br>
						</n>
						<br> <a id="FichaProducto" href='Ficha?id=<%=prod.getId()%>'>
							Ver Producto </a>
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

	<div class="benefit ">
		<div class="container ">
			<div class="row benefit_row">
				<div class="col-lg-3 benefit_col">
					<div class="benefit_item d-flex flex-row align-items-center">
						<div class="benefit_icon">
							<i class="fa fa-truck" aria-hidden="true"></i>
						</div>
						<div class="benefit_content">
							<h6>free shipping</h6>
							<p>Suffered Alteration in Some Form</p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 benefit_col">
					<div class="benefit_item d-flex flex-row align-items-center">
						<div class="benefit_icon">
							<i class="fa fa-money" aria-hidden="true"></i>
						</div>
						<div class="benefit_content">
							<h6>cach on delivery</h6>
							<p>The Internet Tend To Repeat</p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 benefit_col">
					<div class="benefit_item d-flex flex-row align-items-center">
						<div class="benefit_icon">
							<i class="fa fa-undo" aria-hidden="true"></i>
						</div>
						<div class="benefit_content">
							<h6>45 days return</h6>
							<p>Making it Look Like Readable</p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 benefit_col">
					<div class="benefit_item d-flex flex-row align-items-center">
						<div class="benefit_icon">
							<i class="fa fa-clock-o" aria-hidden="true"></i>
						</div>
						<div class="benefit_content">
							<h6>opening all week</h6>
							<p>8AM - 09PM</p>
						</div>
					</div>
				</div>

			</div>
		</div>

		<button type="button" id="Pregunta" class="btn btn-primary"
			data-toggle="modal" data-target="#myModal">?</button>

		<!-- The Modal -->
		<div class="modal" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">Preguntas Frecuentes ?¿</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<form action="PreguntasFrecuentes" method="post">
							Pregunta: <input name="pregunta" required=""
								placeholder="Pregunta..">
							<button type="submit">Buscar</button>
						</form>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>

				</div>
			</div>
		</div>
	</div>

	<div class="jumbotron text-center bg-dark" style="margin-bottom: 0;"
		id="Footer">

		<div class="container-fluid">
			<div class="row">

				<div class="container col-md-2">

					<h2>Informacion :</h2>
					<hr>
					<ol class="nav-item">
						<a id="" class="nav-link" href="Informacion.jsp">Sobre</a>
					</ol>
					<ol class="nav-item">
						<a id="" class="nav-link" href="Login.jsp">Acceso</a>
					</ol>
					<ol class="nav-item">
						<a id="" class="nav-link" href="Informacion.jsp">Blog</a>
					</ol>
					<ol class="nav-item">
						<a id="" class="nav-link" href="FormularioAyudaCliente">Contacto</a>
					</ol>


				</div>

				<div class="container col-md-2">

					<h2>Siguenos en :</h2>
					<hr>
					<a class="Icon" href="https://twitter.com/login">
						<button type="submit">
							<i class='fab fa-twitter' style='font-size: 36px; color: #27bcf8'></i>
						</button>
					</a> <a class="Icon" href="https://www.facebook.com/">
						<button type="submit">
							<i class='fab fa-facebook-square'
								style='font-size: 36px; color: #43c3f3'></i>
						</button>
					</a> <a class="Icon" href="https://www.youtube.com/">
						<button type="submit">
							<i class='fab fa-youtube' style='font-size: 36px; color: red'></i>
						</button>
					</a>
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

	<%
		if (error != null) {
	%>
	<h4 style="color: red;">Error en el usuario o password/o no estas
		Registrado</h4>
	<div id="contaLoginBotonesError" class="container col-sm-11 col-md-6">
		<button id="botonErrorLogin" type='button'
			onClick='window.location.replace("LogeaUsuarios")'>Registrate</button>
		<button id="botonErrorLogin" type='button'
			onClick='window.location.replace("Login")'>Reintentar</button>
		<button id="botonErrorLogin" type='button'
			onClick='window.location.replace("updateContraseña")'>Cambiar
			Contraseña</button>
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

	<!-- The Modal -->
	<div id="myModal33" class="modal56">
		<span
			style="float: right; position: relative; display: flex; font-size: 72px; color: white; cursor: pointer;"
			class="close13">&times;</span> <img
			style="position: relative; display: flex; height: 97%; width: 30%; margin-bottom: 3%; margin-top: 2%; margin-left: auto; margin-right: auto;"
			class="modal-content" id="img02">
		<div id="caption"></div>
	</div>

	<script>
		// Get the modal
		var modal = document.getElementById("myModal33");

		// Get the image and insert it inside the modal - use its "alt" text as a caption
		var img = document.getElementById("imgant");
		var modalImg = document.getElementById("img02");
		var captionText = document.getElementById("caption");
		img.onclick = function() {
			modal.style.display = "block";
			modalImg.src = this.src;
			captionText.innerHTML = this.alt;
		}

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close13")[0];

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
			modal.style.display = "none";
		}
	</script>


</body>
</html>