
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="registroUsuario">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registro de Usuario</title>
		<!--Import Google Icon Font-->
   		<link href="/springtaller/resources/materialize/iconos/index.css" rel="stylesheet">
    			<!--Import materialize.css-->
   		<link type="text/css" rel="stylesheet" href="/springtaller/resources/materialize/css/materialize.min.css"  media="screen,projection"/>
   			 	<!--Let browser know website is optimized for mobile-->
    	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
   		<script type="text/javascript" src="/springtaller/resources/angular/angular.js"></script>
   		
   		<script type="text/javascript">
			angular.module("registroUsuario",[]);
			angular.module("registroUsuario").controller("usuarioController", function($scope,$http){ 
				$scope.aplicativo="Registro de Usuario";
				$scope.registrarUsuario=function(usuario){
					$http.post("http://localhost:8080/springtaller/usuario", usuario).success(function(){
						delete $scope.usuario;
						cargarUsuario();
				});
			};//fin registroProducto
			var cargarUsuario=function(){
				$http.get("http://localhost:8080/springtaller/usuario").success(function(usuarios){  
				$scope.usuarios=usuarios;
				});	
			};
			cargarUsuario();
			});
	</script>
   		
	</head>

	<body ng-controller="usuarioController" >
		<h1 ng-bind="aplicativo"></h1>
		<div class="row">
			<div class="col s2"></div>
			
			<form class="col s8">
				<div class="card-panel">
					<div class="row">
						<div class="input-field col s6">
							<input id="login" type="text" class="validate" ng-model="usuario.login">
					 		<label for="login">Login</label>
						</div>
						<div class="input-field col s6">
							<input id="name" type="text" class="validate" ng-model="usuario.name">
					 		<label for="name">User Name</label>
						</div>
						<div class="input-field col s6">
							<input id="password" type="text" class="validate" ng-model="usuario.password">
					 		<label for="password">Password</label>
						</div>
					</div>
				</div>
				<button ng-click="registrarUsuario(usuario)" class="btn waves-effect waves-light" type="submit" name="action">Registrar
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
							<th>Login</th>
							<th>Name</th>
							<th>Password</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="usuario in usuarios">
							<td>{{usuario.login}}</td>
							<td>{{usuario.name}}</td>
							<td>{{usuario.password}}</td>
						</tr>
					</tbody>
				</table>
			</div>
 		</div>
 		
 		<!--Import jQuery before materialize.js-->
      	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      	<script type="text/javascript" src="/springtaller/resources/materialize/js/materialize.min.js"></script>

		<script type="text/javascript">
			$(document).ready(function() {
				$('.datepicker').pickadate();
     		});
		</script>
		
	</body>

</html>