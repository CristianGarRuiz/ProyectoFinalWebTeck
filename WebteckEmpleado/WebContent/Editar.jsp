
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="modelo.Pojo.ProductoPojo"%>
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
</head>
<body style="background-image: url(imagenes/fondoLogin.png)">

	<%
		String error = (String) request.getParameter("error");
	%>

	<%
		ProductoPojo prod = (ProductoPojo) request.getAttribute("producto");
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
							<a id="Login12" class="dropdown-item" href="Login"><button
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
						style="height: 35px; border-radius: 4%;margin-left: 14%;"><br /> <br />
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
									onClick='window.location.replace("cambiarImagenEmpleado")'>Cambiar
									Imagen</button></a> <a class="dropdown-item" href="#"><button
									type='button' onClick='window.location.replace("Logout")'>Cerrar
									Sesion</button></a> <a class="dropdown-item" href="#">
								<button type='button'
									onClick='window.location.replace("OpcionesEliminarusu")'>BajaEmpleado</button>
							</a>
						</div>
					</div>

				</div>
				<%
					}
				%>
			
		</div>
	</div>

	<div id="EditarProducto" class="container">

		<%
			if (prod == null) {
				out.println("<br/>");
				out.println("<br/>");
				out.println("<a href=\"Login\"> Login</a>");
			} else {
				out.println("<form class='form-horizontal'  action=\"Editar\" method=\"post\">");

				out.println("<input type=\"hidden\" name=\"id\" value=\"" + prod.getId() + "\" /> ");

				out.println("<label for=\"Titulo\">Titulo:</label>");
				out.println("<input type=\"text\" name=\"Titulo\" value=\"" + prod.getTitulo() + "\" /> ");
				out.println("<br/>");
				out.println("<label for=\"Año\">Año:</label>");
				out.println("<input type=\"number\" name=\"Anyo\" value=\"" + prod.getAnyo() + "\" /> ");
				out.println("<br/>");
				out.println("<label for=\"Precio\">Precio:</label>");
				out.println("<input type=\"number\" name=\"Precio\" value=\"" + prod.getPrecio() + "\" /> ");
				out.println("<br/>");
				out.println("<label for=\"Stock\">Stock:</label>");
				out.println("<input type=\"number\" name=\"Stock\" value=\"" + prod.getStock() + "\" /> ");
				out.println("<br/>");
				out.println("<label for=\"Descripcion\">Descripcion:</label>");
				out.println("<input type=\"text\" name=\"Descripcion\" value=\"" + prod.getDescripcion() + "\" /> ");
				out.println("<br/>");
				out.println("<label for=\"Marca\">Marca:</label> ");
				out.println(" <select name=\"Marca\">");

				ArrayList<MarcaPojo> marc = (ArrayList<MarcaPojo>) request.getAttribute("marca");
				if (marc != null) {
					for (MarcaPojo d : marc) {

						out.print("<option value='" + d.getId() + "' ");
						if (d.getId() == prod.getIdGenero()) {
							out.println("selected");
						}
						out.println(">" + d.getNombre() + "</option>");

					}
				}

				out.println("</select>");
				out.println("<label for=\"Categoria\">Categoria:</label>");
				out.println("<select name=Categoria>");
				ArrayList<CategoriaPojo> cat = (ArrayList<CategoriaPojo>) request.getAttribute("categoria");
				if (cat != null) {
					for (CategoriaPojo d : cat) {

						out.print("<option value='" + d.getId() + "' ");
						if (d.getId() == prod.getIdPlataforma()) {
							out.println("selected");
						}
						out.println(">" + d.getNombre() + "</option>");

					}
				}
				out.print("<br><br>");
				out.print(
						"<button id='ButtonRetorno' type='button' onClick='window.location.replace('Pagina')'>Volver atras</button>");
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