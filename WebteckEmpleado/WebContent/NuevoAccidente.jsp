<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="modelo.Pojo.UsuarioPojo"%>
<%@ page import="modelo.Pojo.MarcaPojo"%>
<%@ page import="modelo.Pojo.CategoriaPojo"%>
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
<link type="text/css" href="estilos/AñadirProducto.css" rel="stylesheet" />
</head>
<body style="background-image: url(imagenes/fondoLogin.png)">

	<%
		String error = (String) request.getParameter("error");
		UsuarioPojo usu = (UsuarioPojo) request.getAttribute("usuario");
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
					<li class="nav-item"><a class="nav-link"
						href="InformacionCliente">InformacionCliente</a></li>
					<li class="nav-item"><a class="nav-link" href="InfoVentas">InfoVentas</a>

					</li>
					<li class="nav-items dropdown"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Login</a>
						<div class="dropdown-menu">
							<a id="Login12" class="dropdown-item" id="Login12" href="Login"><button
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
						style="color: white; margin-left: 100px; margin-bottom: -4%; margin-top: -14%;">No
						Registrado</p>
				</div>
				<%
					} else {
				%>
				<div id="Datos">
					<img alt="" src="Imagenes/<%=usu.getFoto()%>"
						style="height: 35px; border-radius: 4%;"><br /> <br />
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
									onClick='window.location.replace("cambiarImagen")'>Cambiar
									Imagen</button></a> <a class="dropdown-item" href="#"><button
									type='button' onClick='window.location.replace("Logout")'>Cerrar
									Sesion</button></a> <a class="dropdown-item" href="#">
								<button type='button'
									onClick='window.location.replace("OpcionesUsuario")'>Opciones</button>
							</a>
						</div>
					</div>

				</div>
				<%
					}
				%>
			
		</div>
	</div>

	<h2 id='TextoProducto'>Añadir un nuevo Producto</h2>
	<br>
	<br>
	<br>
	<br>
	<div id="Formulario" class="container">
		<form class="form-horizontal" action="Crear" method="post">
			<label for="Titulo">Titulo:</label> <input type="text" name="Titulo"
				required="required" placeholder="Titulo.." /> <br /> <label
				for="Año">Año:</label> <input type="number" name="Anyo"
				required="required" placeholder="Año" /> <br /> <br /> <label
				for="Precio">Precio:</label> <input type="number" name="Precio"
				required="required" placeholder="Precio" /> <br /> <br /> <label
				for="Precio">Stock:</label> <input type="number" name="Stock"
				required="required" placeholder="Stock" /> <br /> <br /> <label
				for="Descripcion">Descripcion:</label> <input type="text"
				name="Descripcion" required="required" placeholder="Descripcion.." />
			<br /> <label for="Descripcion">Foto:</label> <input type="File"
				name="Imagen" required="required" placeholder="Imagen .." /> <br />

			<br /> <label for="marca">Marca:</label> <select name="Marca">
				<%
					ArrayList<MarcaPojo> mar = (ArrayList<MarcaPojo>) request.getAttribute("marca");
					if (mar != null) {
						for (MarcaPojo d : mar) {
							out.print("<option value='" + d.getId() + "'>" + d.getNombre() + "</option>");
						}
					}
				%>
			</select> <label for="categoria">Categoria:</label> <select name=Categoria>
				<%
					ArrayList<CategoriaPojo> cate = (ArrayList<CategoriaPojo>) request.getAttribute("categoria");
					if (cate != null) {
						for (CategoriaPojo d : cate) {
							out.print("<option value='" + d.getId() + "'>" + d.getNombre() + "</option>");
						}
					}
				%>

			</select> <br /> <br /> <input id="Crear" type="submit" value="Crear" />
			<button id='CancelarProd' type='button'
				onClick='window.location.replace("Pagina")'>Cancelar</button>
		</form>
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