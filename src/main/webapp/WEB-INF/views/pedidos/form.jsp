<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="registroPedido">
<head>


<script type="text/javascript" src="/hibernatespringtaller/resources/js/angular/angular.js"></script>
<link rel="stylesheet" type="text/css" href="/hibernatespringtaller/resources/css/bootstrap.css">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>







<script type="text/javascript">
//Declaramos el modulo de Angular

angular.module("registroPedido",[]);

//Acceder
angular.module("registroPedido").controller("pedidoController",function($scope,$http){
	
	
$scope.app="Registro de Pedido";

//funcion para registrar un pedidos via Post ,  Se debe crear un método en el controller para responder a esta petición
$scope.registrarPedido=function(pedido){
	
																	//si funciona accede a esta funcion					
	$http.post("http://localhost:8080/hibernatespringtaller/pedidos",pedido).success(function(){
		
		//despues de insertar el elimina el pedidos de la vista
		$scope.pedido=undefined;
		
		//llama a la función para cargar los pedidos
		cargarPedidos();
		
		
	});
	
	
};


	//Retorna la lista de pedidos y carga a la variable pedidos
	var cargarPedidos=function(){
		
	$http.get("http://localhost:8080/hibernatespringtaller/pedidos.json").success(function(datos){
		
		$scope.pedidos=datos.pedidos;
		
	});	
		
		
		
	};



	
	
	
	
cargarPedidos();//llamar al metodo para cargar todos los pedidos	
});




</script>



</head>

<body ng-controller="pedidoController" class="container">

{{pedidos}}
  <div>
			<ul class="nav nav-pills nav-justified"> 
			   

			   
			    	<li><a href="/hibernatespringtaller">Inicio</a></li>
					<li><a href="/hibernatespringtaller/clientes/formulario" >Registrar Cliente</a></li>
					<li class="active"><a href="/hibernatespringtaller/productos/form">Registrar Producto</a></li>
					<li><a href="/hibernatespringtaller/gerente/formulario">Registrar Gerente</a></li>
					<li><a href="/hibernatespringtaller/pedidos/formulario">Registrar Pedido</a>
					<li><a href="/hibernatespringtaller/itemPedido/formulario">Item Pedido</a>
					<li><a href="/hibernatespringtaller/departamento/formulario">Departamento</a>
					
		   </ul>

</div>

<div >

 	
<h3 ng-bind="app">{{app}}</h3>


<form ng-submit="registrarPedido(pedido)" Class="hero-unit">



<input type="number" ng-model="pedido.total" class="form-control">
<input type="date" ng-model="pedido.fechatoma" class="form-control">
<input type="date" ng-model="pedido.fechaentrega" class="form-control">


<input type="submit" value="Registrar">
</form>




<table class="table table-striped"> 

<thead>
<tr>
<th>Total</th>
<th>Fecha Toma</th>
<th>Fecha Entrega</th>
</tr>
</thead>
<tbody>

<!--                         pedidos   se carga en el controller via get -->
<tr ng-repeat="pedido in pedidos">
<td>{{pedido.total}}</td>
<td>{{pedido.fechatoma  | date:'dd/MM/yyyy'}}</td> 
<td>{{pedido.fechaentrega  | date:'dd/MM/yyyy'}}</td> 
</tr>
</tbody>



</table>









</div>

{{pedido}}


</body>
</html>