<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=divice-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
	<title>Login_Registro</title>
	
</head>
<body style="background-image: url('bootstrap/img/intro.jpg'); background-repeat: no-repeat; background-size: cover;">
	<form action="Login" method="post">
		<div class="container"  >
			<div class="row">
				
				<div class="col-md-4"></div>
				
				<div class="col-md-5 col-xs-20">
					<div class="jumbotron text-white" style="background: rgba(42, 156, 174, 0.612); margin-top: 30%;  ">
						<h1 class="text-center">Login</h1>
						<br>
						<p class="text-denger">${error}</p>
						<div class="form-group">
							<label class="control-lable" for="usercorreo">Correo</label>			
							<input type="text" name="usercorreo" id="validar" class="form-control" placeholder="example@gmail.com" pattern="[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}"
							title="ej: juan@gmail.com">
						</div>
						<div class="form-group">
							<label class="control-label" for="password">Password</label>
							<input type="password" name="password" class="form-control" placeholder="Password">
						</div>
						<input type="checkbox" name="remember"> Recordame ?
						<br><br>
						<div class="pull-right">
							<button type="submit" name="act" class="btn btn-outline-warning" value="Iniciar Sesion" >Iniciar Sesión</button> 
<!-- 							onclick="ValidarCorreo()" -->
							<button type="submit" name="act" class="btn btn-success" value="Registrarme">Registrarme</button>
							<button type="submit" name="act" class="btn btn-outline-warning" value="Salir" 
							onClick="location.href='/index.html'">Salir</button>
							
						</div>
					</div>
				</div>
				<div class="col-md-3"></div>										
				
			</div>
		</div>
	</form>
	
 	<script> 
		var input = document.getElementById('validar');
		input.oninvalid = function(event) { event.target.setCustomValidity('Introducir un correo válido')};
 	</script> 



	
	<script type="text/javascript" arc="bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" arc="bootstrap/js/jquery.js"></script>
</body>
</html>