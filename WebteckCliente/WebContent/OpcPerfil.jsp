<%@page import="java.util.ArrayList"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="modelo.Pojo.UsuariosPojo"%>
<%@ page import="modelo.Pojo.DireccionesPojo"%>
<%@ page import="modelo.Pojo.CategoriasPojo"%>
<%@ page import="modelo.Pojo.MarcasPojo"%>
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
<link type="text/css" href="estilos/Principal.css" rel="stylesheet" />
<link type="text/css" href="estilos/FichaUsuario.css" rel="stylesheet" />
</head>
<body style="background-image: url('imagenes/imagenTienda.jpg');">


	<%
		String error = (String) request.getParameter("error");

		UsuariosPojo usu = (UsuariosPojo) request.getAttribute("usuario");

		ArrayList<UsuariosPojo> datosUsuario = (ArrayList<UsuariosPojo>) request.getAttribute("datosUsuario");

		ArrayList<DireccionesPojo> direccionesUsuarios = (ArrayList<DireccionesPojo>) request
				.getAttribute("direccionesUsuarios");
		
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
							<a  id="Login12" class="dropdown-item" href="Logins"><button type="submit"
									<i class='fas fa-door-open' style='font-size:18px'></i>></button>Login</a>
							<a  id="Login13" class="dropdown-item" href="LogeaUsuarios"><button
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

	<div id="CajaGlobalPerfil" class="container col-xs-10 col-md-9  col-xl-10" style="margin-top: 16%;">
		<div class="row">
			<div id="cajaDatosUSU" class="col-sm-7 col-md-7 col-xl-7">
				<h2>Datos del Usuario : </h2>
				<div class="Datos_usuarios">

					<!-- Slide 1 -->
					<%
						if (datosUsuario != null) {
					%>
					<%
						for (UsuariosPojo prod : datosUsuario) {
					%>

					<div class="cajaDatosUsuario">
						<div class="usuarioDatos">
							<div class="FotoUsuario">
								<div class="product_image">
									<img src="Imagenes/" <%=prod.getFoto()%> alt="">
								</div>
								<div class="favorite favorite_left"></div>
								<div class="email_Usuario">
									<h4>
										Email Cliente :
										<%=prod.getEmailUsuario()%></h4>
								</div>
								<div class="nombre_Usuario">
									<h4 class="product_name">
										<h4>
											Nombre Usuario :
											<%=prod.getUsuario()%></h4>
									</h4>
								</div>
								<div class="nombre_Cliente">
									<h4 class="product_name">
										<h4>
											Nombre Cliente :
											<%=prod.getNombre()%></h4>
									</h4>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
			<%
				}
				}
			%>

			<!-- Slide 2 -->
			<%
				if ((direccionesUsuarios != null) && (direccionesUsuarios.size() > 0)) {
			%>
			<div class="container  col-sm-4 col-md-4 col-xl-4 " id="TituloDire">


				<h3>Direccion del Usuario : </h3>


				<%
					for (DireccionesPojo prod : direccionesUsuarios) {
				%>

				<div class="Direccion_Usuarios">
					<div class="Direccion_Item">
						<div class="Datos_Item">
							<div class="Direccion">
								<h4>
									Calle :
									<%=prod.getDireccion()%></h4>
							</div>
							<div class="Localidad_Item"></div>
							<div class=" Provincia_Item flex-column align-items-center">
								<h4>
									Provincia :
									<%=prod.getProvincia()%></h4>
							</div>
							<div class="Vivienda_Item">
								<h4 class="product_name">
									<h4>
										Vivienda :
										<%=prod.getVivienda()%></h4>
								</h4>
								<div class="CodigoPostal_Item">
									<h4>
										CP:
										<%=prod.getCodigoPostal()%></h4>
								</div>
								<div class="Localidad_Item">
									<h4>
										Localidad :
										<%=prod.getLocalidad()%></h4>
								</div>
							</div>
							<div id="OpcionesDireccion" class="OpcionesDireccion">
								<a  style="text-decoration: none;" class="bestSellerProd" href='EditarDireccion'> Editar
									Direccion </a> <a  style="text-decoration: none;" class="bestSellerProd" href='EliminarDireccion'>
									Eliminar Direccion </a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
		}

		} else {
	%>

	<div id="cajaSinDirecc" class="container col-sm-4 col-md-4 col-xl-4">
		<div class="row">
			<div class="SinDatosDireccion">
				<h4>No tiene Direccion Añadida</h4>
				<p>Pulsa Aqui Para Añadir Una</p>
				<button type="button" id="DatosDirrecion" class="btn btn-primary"
					data-toggle="modal" data-target="#myModal">Añadir
					Direccion</button>
			</div>
		</div>
		<!-- The Modal -->
		<div class="modal" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">añadir Direccion</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<form action="InsertarDireccion" class="needs-validation"
							novalidate method="post">
							<div class="form-group">
								<label for="uname">Direccion:</label> <input type="text"
									class="form-control" id="direccion"
									placeholder="Enter Direccion" name="direccion" required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<div class="form-group">
								<label for="pwd">Vivienda:</label> <input type="text"
									class="form-control" id="vivienda" placeholder="Enter Vivienda"
									name="vivienda" required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>

							<div class="form-group">
								<label for="pwd">Localidad:</label> <input type="text"
									class="form-control" id="localidad"
									placeholder="Enter Localidad" name="localidad" required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>

							<div class="form-group">
								<label for="pwd">Provincia:</label> <input type="text"
									class="form-control" id="provincia"
									placeholder="Enter provincia" name="provincia" required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>

							<div class="form-group">
								<label for="pwd">Codigo Postal :</label> <input type="number"
									class="form-control" id="codigoPostal" placeholder="Enter CP"
									name="codigoPostal" required>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>

							<div class="form-group form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="checkbox" name="remember"
									required> Acepta los Terminos de Nuestra Pagina.
									<div class="valid-feedback">Valid.</div>
									<div class="invalid-feedback">Check this checkbox to
										continue.</div>
								</label>
							</div>
							<button type="submit" class="btn btn-primary">Guardar
								Direccion</button>
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
	</div>
	</div>
	</div>
	<%
		}
	%>


	<script>
		window.onload = function() {
			document.getElementById("Login12").setAttribute('href', '#');
			document.getElementById("Login13").setAttribute('href', '#');
		}
	</script>

	<script>
		// Disable form submissions if there are invalid fields
		(
				function() {
					'use strict';
					window.addEventListener('load', function() {
						// Get the forms we want to add validation styles to
						var forms = document
								.getElementsByClassName('needs-validation');
						// Loop over them and prevent submission
						var validation = Array.prototype.filter.call(forms,
								function(form) {
									form.addEventListener('submit', function(
											event) {
										if (form.checkValidity() === false) {
											event.preventDefault();
											event.stopPropagation();
										}
										form.classList.add('was-validated');
									}, false);
								});
					}, false);
				})();
	</script>
</body>
</html>