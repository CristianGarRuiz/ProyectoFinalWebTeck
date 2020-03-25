<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="modelo.Pojo.UsuarioPojo"%>
<!DOCTYPE html>
<html>
<head>
<title>login</title>
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
<link type="text/css" href="estilos/Login.css" rel="stylesheet" />
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
					<li class="nav-item"><a class="nav-link" href="InfoVentas">InfoVentas</a>
					</li>
					<li class="nav-items dropdown"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Login</a>
					<li class="nav-items dropdown"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Login</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#"><button type="submit"
									<i class='fas fa-door-open' style='font-size:18px'></i>></button>Login</a>
							<a class="dropdown-item" href="#"><button type="submit"
									<i class='fas fa-portrait' style='font-size:19px'></i>></button>Registro</a>
						</div></li>
				</ul>
			</div>
	</nav>
	<h2 id="TextLogin">Login Usuario</h2>
	<p>
		<i class='far fa-user-circle'
			style='margin-left: 48%; font-size: 58px; color: black'></i>
	</p>

	<div id="Formulario" class="container">
		<form class="form-horizontal" action="Login" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="Usuario"><i
					class='fas fa-user' style='margin-top: 2%; font-size: 24px'></i>Usuario:</label>
				<div class="col-sm-10">
					<input type="text" required="" class="form-control" id="email"
						placeholder="Entrar Usuario" name="usuario">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd"><i
					class='fas fa-lock' style='font-size: 24px'></i> Contraseña:</label>
				<div class="col-sm-10">
					<input type="password" required="" class="form-control" id="pwd"
						placeholder="Entar password" name="password" required
						pattern="^[a-z0-9_-]{3,15}$"
						title="El número de referencia consta de 3 letras mayúsculas y 4 dígitos." />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label><input type="checkbox" name="remember">
							Recordarme</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button id="botonLogin" type="submit" class="btn btn-info">
						Login</button>
				</div>
			</div>
		</form>
		<button type='button' onClick='window.location.replace("Pagina")'>Cancelar</button>
		<%
			if (error != null) {
		%>
		<h4>errores en el usuario o password/o no estas Registrado</h4>
		<button type='button'
			onClick='window.location.replace("LogearUsuarios")'>Registrate</button>
		<button type='button' onClick='window.location.replace("Login")'>Reintentar</button>
		<img id='Dino' src='dino.gif'>
		<%
			}
		%>
	</div>


</body>
</html>