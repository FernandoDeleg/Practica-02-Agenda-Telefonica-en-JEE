<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ec.edu.ups.modelo.Telefono, java.util.*,ec.edu.ups.DAO.TelefonoDao,ec.edu.ups.DAO.DAOFactory,ec.edu.ups.DAO.UsuarioDao" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=divice-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<title>Agenda</title>
</head>
<body style="background-image: url('bootstrap/img/agenda.jpg'); background-repeat: no-repeat; background-size: cover;">
  
	<form action="CerrarSesion" method="post">
		<div class="pull-right text-white">
			<button type="submit" class="btn btn-dark">Cerrar Sesion</button>
		</div>
	</form>
	<h1 class="text-white">Bienvenido: ${usercorreo}</h1>
	<br>
	<br>
	<form action="BuscarContactos" method="post">
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"> Nuevo Teléfono</button>
		<button type="submit" class="btn btn-primary" name="listar" value="listar"> Listar mis Números</button>
	</form>
	<!-- Modal    Agregar telefonos -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title" id="exampleModalLabel">Nuevo Telefono</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      		<form action="controladorAgenda" method="post">
	        		<div class="form-group">
						<label class="control-lable" for="numero">Número</label>			
						<input type="text" name="numero" class="form-control" placeholder="Ingresar Nª Celular/telefono ">
					</div>	
					<div class="form-group">
				        <label for="tipo">Tipo</label>                                                 
				            <select name="tipo" id="tipo"  placeholder="- Seleccione tipo -"
				             class="form-control chosenTipo" onchange="change(this.id, 'tipo')">
				              	<option value="Convencional">Convencional</option>
				              	<option value="Celular">Celular</option>
				        	</select>
				    </div>
					<div class="form-group">
				        <label for="operadora">Operadora</label>                                                 
				            <select name="operadora" id="operadora"  placeholder="- Seleccione Operadora -"
				             class="form-control chosenOperadora" onchange="change(this.id, 'operadora')">
				              	<option value="Claro">Claro</option>
				              	<option value="Movistar">Movistar</option>
				              	<option value="CNT">CNT</option>
				              	<option value="CNT">ETAPA</option>
				        	</select>
				    </div>
					
					<div class="pull-right">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	       				<button type="submit" class="btn btn-primary" name="act" value="guardar">Guardar</button>
					</div>
				</form>	
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- Modal Actualizar Telefono -->
	<%
		
	%>
	<div class="modal fade" id="actualizar" tabindex="-1" aria-labelledby="actualizarl" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header " >
	        <h3 class="modal-title" id="actualizarl">Actualizar Telefono</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      		<form action="controladorAgenda" method="post">
	      			<div class="form-group">
						<label class="control-lable" for="cod">Codigo</label>			
						<input type="text" name="cod" class="form-control" id="cod" readonly>
					</div>	
	        		<div class="form-group">
						<label class="control-lable" for="numero">Numero</label>			
						<input type="text" name="numero" class="form-control" placeholder="Ingresar Nª Celular/telefono " id="numero" >
					</div>	
					<div class="form-group">
				        <label for="tipo">Tipo</label>                                                 
				            <select name="tipo" id="tipo"  placeholder="- Seleccione tipo -"
				             class="form-control chosenTipo" onchange="change(this.id, 'tipo')">
				              	<option value="Convencional">Convencional</option>
				              	<option value="Celular">Celular</option>
				        	</select>
				    </div>
					<div class="form-group">
				        <label for="operadora">Operadora</label>                                                 
				            <select name="operadora" id="operadora"  placeholder="- Seleccione Operadora -"
				             class="form-control chosenOperadora" onchange="change(this.id, 'operadora')">
				              	<option value="Claro">Claro</option>
				              	<option value="Movistar">Movistar</option>
				              	<option value="CNT">CNT</option>
				        	</select>
				    </div>
					
					<div class="pull-right">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	       				<button type="submit" class="btn btn-primary" name="act" value="actualizar" >Actualizar</button>
					</div>
				</form>	
	      </div>
	    </div>
	  </div>
	</div>
	
	
	<div class="container">
		<h1 class="text-white">Mis Números</h1>
		<table class="col-md-4 table table-striped table-bordered dt-responsive table-hover table-condensed" style="width: 70%; margin-left: 10%; background:rgba(255, 255, 255, 0.68);">
		  	<tr>
			    <th class="bg-primary">Numero</th>
			    <th class="bg-primary">Tipo</th>
			    <th class="bg-primary">Operadora</th>
			    <th class="bg-primary">Acciones</th>
		  	</tr>
		  	<c:forEach items="${listar}" var="t">
			    <tr>
			        <td>${t.numero}</td>
			        <td>${t.tipo}</td>
			        <td>${t.operadora}</td>
		        	<td class="text-center">
		        		<button  type="button" class="btn btn-primary" data-toggle="modal" data-target="#actualizar" onclick="$('#numero').val(${t.numero});$('#cod').val(${t.id})"> Editar </butto>
		        		<a href="controladorAgenda?id=${t.id}"><button type="submit" class="btn btn-danger btn-sm btnEliminar" name="act" value="eliminar">Eliminar</button></a> 
		      		</tr>
		     </c:forEach>
		</table>
	</div>
	
	<div class="container">
	<h1 class="text-white">Agenda de contactos</h1>
	<form action="BuscarContactos" method="post">
		<div class="container">
				<div class="form-group">
					<input type="text" name="buscar" class="form-control" placeholder="Para Buscar ingresar cedula o correo electronico">
				</div>	
		</div>
	</form>
	
	
		<table class="table table-striped table-bordered dt-responsive table-hover table-condensed" style="background:rgba(255, 255, 255, 0.68);">
		  	<tr>
		  	  	<th class="bg-primary">Codigo</th>
			    <th class="bg-primary">Numero</th>
			    <th class="bg-primary">Tipo</th>
			    <th class="bg-primary">Operadora</th>
			    <th class="bg-primary">Acciones</th>
		  	</tr>
		  	<c:forEach items="${listarO}" var="t">
			    <tr>
			    	<td>${t.id}</td>
			        <td>${t.numero}</td>
			        <td>${t.tipo}</td>
			        <td>${t.operadora}</td>
		        	<td class="text-center">
		        		
		        		<a href="tel:+593${t.numero}"><button class="btn btn-primary btn-sm btnedit" name="act" value="llamar">llamar</button> </a>
		        		<a href="mailto:robertsonam1993@gmail.com"><button type="submit" class="btn btn-success"  name="act" value="msj">Enviar  gmail</button></a>
		        		
		        	</td>
		      	</tr>
		     </c:forEach>	
		</table>
		</div>
</body>
</html>