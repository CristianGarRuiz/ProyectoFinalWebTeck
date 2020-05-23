

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
<html lang="en">
<head>
<title>Webteckinfo.com</title>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<link rel="icon" type="image/png" href="favi.jpg">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script src="jquery.lazymap.js"></script>
</head>
<style>
.map {
	height: 200px;
	width: 100%;
}

#texto {
	text-align: center;
}

#Cop {
	color: white;
}

#linea {
	background-color: #003366
}
/* Make the image fully responsive */
.carousel-inner img {
	width: 100%;
	height: 10%;
}

#ImagenEscultura {
	width: 100%;
}

.modal-backdrop {
	z-index: 0;
}

#ImagenEscultura:hover {
	transform: scale(1.15);
}

.video-container {
	overflow: hidden;
	position: relative;
	width: 100%;
}

.video-container::after {
	padding-top: 56.25%;
	display: block;
	content: '';
}

.video-container iframe {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	bottom: 0;
}

#Imagen3 {
	margin-top: 14%;
}

#Con2 {
	background-color: #CED4F6;
}

.media-body:hover {
	transform: scale(1.05);
}

.media-left:hover {
	transform: scale(1.05);
}

.nav-item:hover {
	transform: scale(1.05);
}

.btn-primary:hover {
	transform: scale(1.05);
}

.Icon:hover {
	transform: scale(1.05);
}

.form-group:hover {
	transform: scale(1.05);
}

.btn-success:hover {
	transform: scale(1.05);
}

.video-container:hover {
	position: relative;
	transform: scale(1.45);
	margin-left: 35%;
	margin-top: -20%;
}

.dropdown-item:hover {
	transform: scale(1.05);
}

body {
	background-color: white;
}
</style>
<script>
	$(document).ready(function() {
		$('[data-toggle="popover"]').popover();
	});

	$(document).punt(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
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
				<img src="imagenes/img31.jpg" alt="img1" width="1100" height="500">
				<div class="carousel-caption">
					<h3>Calidad de Servicio</h3>
					<p>Intentamos servir servicion de calidad !</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="imagenes/img21.jpg" alt="img2" width="1100" height="500">
				<div class="carousel-caption">
					<h3>Pedidos Seguros</h3>
					<p>Vuestros pedidos atendidos desde el primer momento</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="imagenes/img3.jpg" alt="img3" width="1100" height="500">
				<div class="carousel-caption">
					<h3>Somos un EQUIPO</h3>
					<p>Pensamos en Nuestro Trabajadores</p>
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


	<div class="container-fluid " style="margin-top: 1%;" id="Con1">
		<div class="row">
			<div class=" col-sm-5 col-md-3 " id="Imagen3">

				<img src="imagenes/iconIma.gif" id="ImagenEscultura"> <br>
				<a href="#demo1" class="btn btn-primary" data-toggle="collapse">Mas
					informacion</a>

				<div id="demo1" class="collapse">Nuestra Tienda Se creo en
					2019 , en españa .Este logo fue el emplema de nuestra pagina en
					insipacion a la tecnologia del futuro.</div>
			</div>

			<div class="col-sm-6 col-md-6" id="Texto4">

				<h1 id="texto">
					Informacion <i class="fa fa-align-justify" style="font-size: 36px;"></i>
				</h1>
				<p>WEBTECK, Inc. es una compañía Española de comercio
					electrónico y servicios de computación en la nube a todos los
					niveles con sede en la ciudad Palma de Mallora , En España. Su lema
					es: From A to Z (traducido al español: «De la A a la Z»). Fue una
					de las primeras grandes compañías en vender bienes a través de
					Internet. Amazon también posee Alexa Internet, a9.com, Shopbop,
					Internet Movie Database (IMDb), Zappos.com, DPreview.com y Twitch​
					en Irlanda, Canadá, Australia, Alemania, Austria, Francia, China,
					Japón, Italia, España, Países Bajos, Brasil, India y México para
					poder ofrecer los productos de esos países. Amazon también está
					presente en otros países, donde realiza funciones de soporte, como
					en Costa Rica, desde donde centraliza la atención al cliente de
					Latinoamérica y con 7500 empleados es una de las mayores empresas
					del país. En la actualidad está totalmente diversificada y
					catalogada en diferentes líneas de productos, ofreciendo DVD, CD de
					música, software, videojuegos, electrónica. Es la marca de venta al
					por menor más valiosa del mundo según el índice Brand.​</p>
			</div>



			<div class="container-fluid col-sm-5 col-md-2">
				<button style="margin-bottom: 1%;" type="button"
					class="btn btn-primary" data-toggle="modal" data-target="#myModal">
					Informacion</button>

				<!-- The Modal -->
				<div class="modal fade" id="myModal">
					<div class="modal-dialog">
						<div class="modal-content">

							<!-- Modal Header -->
							<div class="modal-header">
								<h4 class="modal-title">Atencion Cliente</h4>
								<button type="button" class="close" data-dismiss="modal">×</button>
							</div>

							<!-- Modal body -->
							<div class="modal-body">Nuestra Pagina tiene un servicio
								atencion al cliente ,en caso de pedido perdido,seguimiento no le
								llega o culquier fallo relacionado con nuestra pagina
								,contactenos abajo . Gracias</div>

							<!-- Modal footer -->
							<div class="modal-footer">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Close</button>
							</div>

						</div>
					</div>
				</div>
				<!-- --------------------------------------------------------------------------------------------------- -->
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#myModal1">Contactanos</button>
				<!-- The Modal -->
				<div class="modal fade" id="myModal1">
					<div class="modal-dialog">
						<div class="modal-content">

							<!-- Modal Header -->
							<div class="modal-heade">
								<h4 class="modal-title">Contacta con Nosotros</h4>
								<button type="button" class="close" data-dismiss="modal">×</button>
							</div>

							<!-- Modal body -->
							<div class="modal-body">
								<h4>Nombre:</h4>
								<p>Cristian Garcia Ruiz</p>
								<h4>Telefono:</h4>
								<p>
									<a href=" tel:5643535545">5643535545</a>
								</p>
								<h4>Email</h4>
								<p>
									<a href="mailto:Roberto@gmail.com">Roberto@gmail.com</a>
								</p>

							</div>

							<!-- Modal footer -->
							<div class="modal-footer">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>

				<div class=" col-sm-12 col-md-12 " id="Imagen3"
					style="margin-top: 93%;">

					<img src="imagenes/tt1.png" id="ImagenEscultura"> <br>

				</div>
			</div>
		</div>


		<hr id="hr1">
		<div class="container-fluid col-sm-5 col-md-12 " id="Con2">
			<div class="row">
				<div class="container-fluid col-sm-5 col-md-3">
					<h1 class="texto">
						Segurencias de Clientes <span class=" subtitle text-secondary">AQUI
							!</span>
					</h1>
					<form action="/action_page.php">

						<div class="form-group row">
							<div class='col-6'>
								<input type="text" class="form-control" id="Firtsname"
									placeholder="Nombre" name="Firtsname">
							</div>
							<div class='col-6'>
								<input type="text" class="form-control" id="Secondname"
									placeholder="Apellidos" name="Secondname">
							</div>
						</div>
						<div class="form-group">

							<input type="text" class="form-control" id="email1"
								placeholder="Email" name="name">

						</div>

						<div class="form-group">
							<input type="email" class="form-control" id="email"
								placeholder="Comentari" name="email">
						</div>
						<div class='row'>
							<div class='col-9'>
								<button id="Comentar" type="button"
									class="btn btn-success boton" name="button2">Comentar</button>
							</div>

						</div>
					</form>
				</div>

				<div class="col-sm-4 col-md-6" id="Texto4 "
					style="background-color: white">

					<h1 id="puestos">
						Como trabajamos ?¿ <i class="fa fa-map" style="font-size: 36px"></i>
					</h1>
					<p>CONCEPTOS BÁSICOS DE Webteck.COM Webteck.com vende un montón
						de cosas. El enfoque de ventas directas de Webteck al comprador no
						es realmente diferente de lo que sucede en la mayoría de los
						grandes minoristas en línea, excepto por su gama de productos.
						Puedes encontrar artículos CDs, DVDs, computadoras, m cualquier
						otra cosa eletronica que quieras comprar. Lo que hace de Webteck
						un gigante está en los detalles. Además de su enorme gama de
						productos, Webteck hace todo lo posible para personalizar la
						experiencia del comprador. que e-commerce utiliza Webteck Cuando
						llegas a la página de inicio, no sólo encontrarás ofertas
						especiales y productos destacados, sino que si has estado en
						Webetck.com antes, también encontrarás algunas recomendaciones
						sólo para ti. Webteck te conoce por tu nombre y trata de ser tu
						comprador personal. Las técnicas de marketing integrado que Amazon
						emplea para personalizar su experiencia son probablemente el mejor
						ejemplo del enfoque general de la empresa a las ventas: «conoce a
						tu cliente muy, muy bien». El seguimiento de los clientes es una
						fortaleza de Webteck. Si dejas que el sitio web ponga una cookie
						en tu disco duro, te encontrarás todo tipo de características
						útiles que hacen que tu experiencia de compra sea muy agradable,
						como recomendaciones basadas en compras anteriores y listas de
						revisiones y guías escritas por usuarios que compraron los
						productos que estás mirando. La otra característica principal que
						coloca a Webteck.com en otro nivel es la estrategia de comercio
						electrónico multinivel que emplea. Webteck.com permite a casi
						cualquier persona vender casi cualquier cosa usando su plataforma.
						Se pueden encontrar ventas directas de mercancía vendida
						directamente por Webteck.</p>
				</div>
				<div class="container-fluid col-sm-4 col-md-2">
					<h2>Repartimos a toda España !</h2>
					<ul class="list-group">
						<li class="list-group-item active">Peninsula</li>
						<li class="list-group-item">Ceuta y Melilla</li>
						<li class="list-group-item">Islas Baleares y Canarias</li>
					</ul>
				</div>
			</div>
		</div>
		<hr id="linea">
		<div class="container-fluid col-md-12">
			<h2 id="Info">Experiencia de Compras de clientes</h2>
			<div class="row">

				<div class="media col-sm-4 col-md-8">
					<div class="media-left">
						<img src="avatar.jfif" class="media-object" style="width: 45px">
					</div>
					<div class="media-body">
						<h4 class="media-heading">
							Matias Lopez <small><i>Posteado en Febrero 19, 2016</i></small>
						</h4>
						<p>Increible ,Atencion muy decente y te ayudan en cualquier
							caso</p>
						<!-- Nested media object -->
						<div class="media">
							<div class="media-left">
								<img src="ava.jfif" class="media-object" style="width: 45px">
							</div>
							<div class="media-body">
								<h4 class="media-heading">
									Marta Diaz <small><i>Posteado en Marzo 30, 2017</i></small>
								</h4>
								<p>Muy bien ,tube un problemas con un producto y se
									soluciono</p>
							</div>
						</div>
						<!-- Nested media object -->
						<div class="media">
							<div class="media-left">
								<img src="avatar.jfif" class="media-object" style="width: 45px">
							</div>
							<div class="media-body">
								<h4 class="media-heading">
									Ramon Dominguez <small><i>Posteado en Dicembre 22,
											2019</i></small>
								</h4>
								<p>Tuve un problemas con un producto y me lo arreglaro al
									momento , y me llego en la fecha esperada</p>
							</div>
						</div>

					</div>
				</div>

				<div class="video-container col-sm-4 col-md-4">
					<iframe src="https://www.youtube.com/embed/QVkOvk_DeWs"
						frameborder="0"
						allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe>
				</div>
				<div class="spacer"></div>
				<h3 style="color: wheat">Mapa:</h3>
				<div class="map" data-zoom="11"
					data-locations="[39.5693893, 2.6502399], [39.5693893, 2.6502399]"></div>

				<script>
					$('.map').lazymap({
						apiKey : '',
						culture : 'it'
					});
				</script>
			</div>
		</div>
		<hr>

	</div>

	<div class="jumbotron text-center bg-dark" style="margin-bottom: 0"
		id="Footer">
		<p id="Cop">&copy; WEBTECK.com
		<p>
			<a class="Icon" href="https://twitter.com/login"
				<button type="submit"> <i class='fab fa-twitter' style='font-size:36px; '></i></button>></a>
			<a class="Icon" href="https://www.facebook.com/"
				<button type="submit"> <i class='fab fa-facebook-square' style='font-size:36px'></i></button>></a>
			<a class="Icon" href="https://www.youtube.com/"
				<button type="submit"><i class='fab fa-youtube' style='font-size:36px;color: red'></i> </button>></a>
	</div>
</body>
</html>