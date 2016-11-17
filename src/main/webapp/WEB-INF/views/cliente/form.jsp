<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  ng-app="registroCliente">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="\hibernatespringtaller\resources\materialize\css\materialize.min.css"  media="screen,projection"/>
<script type="text/javascript" src="hibernatespringtaller\resources\angular\angular.js"></script>
<title>Registro de Cliente</title>
</head>

<script type="text/javascript">
			angular.module("registroCliente",[]);
			angular.module("registroCliente").controller("clienteController", function($scope,$http){ 
				$scope.aplicativo="Registro de Cliente";
				$scope.registrarCliente=function(cliente){
					$http.post("http://localhost:8080/hibernatespringtaller/cliente", cliente).success(function(){
						delete $scope.cliente;
						cargarCliente();
				});
			};//fin registroCliente
			var cargarCliente=function(){
				$http.get("http://localhost:8080/hibernatespringtaller/cliente").success(function(clientes){  
				$scope.clientes=clientes;
				});	
			};
			cargarCliente();
			});
	</script>



<body ng-app="registroCliente">

<h1 ng-bind="aplicativo">Registro de Cliente</h1>


<div class="row">
			<div class="col s2"></div>
			
			<form class="col s8" >
				<div class="card-panel">
					<div class="row">
						<div class="input-field col s6">
							<input id="nombre" type="text" class="validate" ng-model="cliente.nombre">
					 		<label for="nombre">Nombre</label>
						</div>
						<div class="input-field col s6">
							<input id="correo" type="email" class="validate" ng-model="cliente.correo">
					 		<label for="nombre">Correo</label>
						</div>
					</div>
				</div>
				<button ng-click="registrarCliente(cliente)" class="btn waves-effect waves-light" type="submit" name="action">Registrar
   					<i class="material-icons right">save</i>
  				</button>
			</form>
			<div class="col s2"></div>
		</div>


<div class="row">
			<div class="col s12">
				<table class="responsive-table highlight">
					<thead>
						<tr>
							<th>Correo</th>
							<th>Nombre</th>
					
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="cliente in clientes">
							<td>{{cliente.correo}}</td>
							<td>{{cliente.nombre}}</td>
						</tr>
					</tbody>
				</table>
			</div>
 		</div>


</div>



<script type="text/javascript" src="\hibernatespringtaller\resources\jquery.js"></script>
<script type="text/javascript" src="\hibernatespringtaller\resources\materialize\js\materialize.min.js"></script>

<script type="text/javascript">
			$(document).ready(function() {
				$('.datepicker').pickadate();
     		});
		</script>

</body>
</html>