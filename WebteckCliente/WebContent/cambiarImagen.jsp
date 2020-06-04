<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="modelo.Pojo.UsuariosPojo"%>


<%!UsuariosPojo usuario;%>
<!DOCTYPE html>
<html>
<head>
<title>RegistroCliente</title>
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
		UsuariosPojo usu = (UsuariosPojo) request.getAttribute("usuario");
	%>

	<h2 id="TextLogin">Cambiar Imagen Usuario</h2>
	<p>
		<i class='fas fa-user-cog' style='font-size: 58px; margin-left: 49%;'></i></i>
	</p>

	<div id="Formulario" class="container">
		<form class="form-horizontal" action="cambiarImagenUsuario" method="post"
			enctype="multipart/form-data">
			
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
					<button id="botonLogin" type="submit" value="LogeaUsuarios"
						class="btn btn-info">CambiarImagen</button>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type='button' onClick='window.location.replace("Principal")'>Cancelar</button>
				</div>
			</div>
		</form>
	</div>


	<%
		if (error != null) {
	%>
	<h3 id="errorLogear">Hay errores en cambiar la imagen
		los campos !!</h3>
	<div id="botLog">
		<button type='button' onClick='window.location.replace("Principal")'>VolverPrincipal</button>
	</div>

	<%
		}
	%>

</body>
</html>