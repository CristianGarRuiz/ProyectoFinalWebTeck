<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="modelo.Pojo.UsuarioPojo"%>


<%!UsuarioPojo usuario;%>
<!DOCTYPE html>
<html>
<head>
<title>RegistroEmpleado</title>
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
<link type="text/css" href="estilos/Registro.css" rel="stylesheet" />
</head>
<body style="background-image: url(imagenes/fondoLogin.png)">
	<%
		String error = (String) request.getParameter("error");
			UsuarioPojo usu = (UsuarioPojo) request.getAttribute("usuario");
	%>

	<h2 id="TextLogin">Registro Empleado</h2>
	<p>
		<i class='fas fa-user-cog' style='font-size: 58px; margin-left: 49%;'></i></i>
	</p>

	<div id="Formulario" class="container">
		<form class="form-horizontal" action="LogearUsuarios" method="post"
			enctype="multipart/form-data">
			<div class="form-group">
				<label class="control-label col-sm-2" for="emailUsuario"><i
					class='fas fa-user' style='margin-top: 2%; font-size: 24px'></i>Email:</label>
				<div class="col-sm-10">
					<input type="email" required="" class="form-control" id="emailUsuario"
						placeholder="Entrar email" name="emailUsuario">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="nombre"><i
					class='fas fa-lock' style='font-size: 24px'></i> Nombre:</label>
				<div class="col-sm-10">
					<input type="text" required="" class="form-control" id="nombre"
						placeholder="Entar nombre" name="nombre">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd"><i
					class='fas fa-lock' style='font-size: 24px'></i> Contraseña:</label>
				<div class="col-sm-10">
					<input type="password" required="" class="form-control" id="pwd"
						placeholder="Entar password" name="password">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd"><i
					class='fas fa-user' style='font-size: 24px'></i> Usuario:</label>
				<div class="col-sm-10">
					<input type="text" required="" class="form-control" id="usuario"
						placeholder="Entar usuario" name="usuario">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd"><i
					class='far fa-image' style='font-size: 24px'></i>Imagen:</label>
				<div class="col-sm-10">
					<input type="file" required="" class="form-control" id="pwd"
						placeholder="Entar Imagen" name="foto">
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
					<button id="botonLogin" type="submit" value="LogearUsuarios"
						class="btn btn-info">Registrar</button>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type='button' onClick='window.location.replace("Pagina")'>Cancelar</button>
				</div>
			</div>
		</form>
	</div>


	<%
		if (error != null) {
	%>
	<h3 id="errorLogear">Hay errores en registrar al usuario ,revisa
		los campos !!</h3>
	<div id="botLog">
		<button type='button' onClick='window.location.replace("Pagina")'>VolverPrincipal</button>
		<button type='button' onClick='window.location.replace("Logear")'>Reintentar</button>
	</div>

	<%
		}
	%>

</body>
</html>