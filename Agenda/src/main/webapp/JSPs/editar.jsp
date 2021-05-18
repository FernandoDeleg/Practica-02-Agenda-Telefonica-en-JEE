<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=divice-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<title>Editar Contacto</title>
</head>
<body>
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title" id="exampleModalLabel">Editar Telefono</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      		<form action="controladorAgenda" method="post">
	        		<div class="form-group">
						<label class="control-lable" for="numero">Numero</label>			
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
</body>
</html>