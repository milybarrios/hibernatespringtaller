<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="registroGerente">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link type="text/css" rel="stylesheet" href="\hibernatespringtaller\resources\materialize\css\materialize.min.css"  media="screen,projection"/>
 <script type="text/javascript"  src="\hibernatespringtaller\resources\js\angular\angular.js"></script>
<link rel="stylesheet" type="text/css" href="/hibernatespringtaller/resources/css/bootstrap.css">
<title>Registro de Gerente</title>
</head>


<script type="text/javascript">
			angular.module("registroGerente",[]);
			angular.module("registroGerente").controller("gerenteController", function($scope,$http){ 
				$scope.aplicativo="Registro de Gerente";
				$scope.registrarGerente=function(gerente){
					$http.post("http://localhost:8080/hibernatespringtaller/gerente", gerente).success(function(){
						delete $scope.gerente;
						cargarGerente();
				});
			};//fin registroProducto
			var cargarGerente=function(){
				$http.get("http://localhost:8080/hibernatespringtaller/gerente").success(function(gerentes){  
				$scope.gerentes=gerentes;
				});	
			};
			cargarGerente();
			});
	</script>


<body class="container"   ng-controller="gerenteController">


{{gerente}}


<h4 ng-bin="app">Registro de Gerente</h4>




<div>
			<ul class="nav nav-pills nav-justified"> 
			   

			   
			    	<li><a href="/hibernatespringtaller">Inicio</a></li>
					<li><a href="/hibernatespringtaller/clientes/formulario" >Registrar Cliente</a></li>
					<li><a href="/hibernatespringtaller/productos/formulario">Registrar Producto</a></li>
					<li Class="active"><a href="/hibernatespringtaller/gerente/formulario">Registrar Gerente</a></li>
					<li><a href="/hibernatespringtaller/pedidos/formulario">Registrar Pedido</a>
					<li><a href="/hibernatespringtaller/itemPedido/formulario">Item Pedido</a>
					<li><a href="/hibernatespringtaller/departamento/formulario">Departamento</a>
					
		   </ul>

</div>

<form action="/hibernatespringtaller/gerente" method="post" class="hero-unit">
       
      <label for="ci">Cedula de Identidad</label>
      <input type="text" name="ci" id="ci">
      
      <label for="nombre">Nombre</label>
      <input type="text" name="nombre" id="nombre">
      
      <input type="submit" value="Guardar">
</form>


<div class="row">
			<div class="col s12">
				<table class="responsive-table highlight">
					<thead>
						<tr>
							<th>Cedula</th>
							<th>Nombre</th>
							
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="gerente in gerentes">
							<td>{{gerente.ci}}</td>
							<td>{{gerente.nombre}}</td>
						</tr>
					</tbody>
				</table>
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