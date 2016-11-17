<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="registroProducto">
<head>


<script type="text/javascript" src="/hibernatespringtaller/resources/js/angular/angular.js"></script>
<link rel="stylesheet" type="text/css" href="/hibernatespringtaller/resources/css/bootstrap.css">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>







<script type="text/javascript">
//Declaramos el modulo de Angular

angular.module("registroProducto",[]);

//Acceder
angular.module("registroProducto").controller("productoController",function($scope,$http){
	
	
$scope.app="Registro de Producto";

//funcion para registrar un producto via Post ,  Se debe crear un método en el controller para responder a esta petición
$scope.registrarProducto=function(producto){
	
																	//si funciona accede a esta funcion					
	$http.post("http://localhost:8080/hibernatespringtaller/productos",producto).success(function(){
		
		//despues de insertar el elimina el producto de la vista
		$scope.producto=undefined;
		
		//llama a la función para cargar los productos
		cargarProductos();
		
		
	});
	
	
};


	//Retorna la lista de productos y carga a la variable productos
	var cargarProductos=function(){
		
	$http.get("http://localhost:8080/hibernatespringtaller/productos.json").success(function(datos){
		
		$scope.productos=datos.productos;
		
	});	
		
		
		
	};



	
	
	
	
cargarProductos();//llamar al metodo para cargar todos los productos	
});




</script>



</head>

<body ng-controller="productoController" class="container">
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


<form ng-submit="registrarProducto(producto)" Class="hero-unit">


<input type="text" ng-model="producto.id" placeholder="Codigo" class="form-control">
<input type="text" ng-model="producto.descripcion" placeholder="Descripcion" class="form-control">
<input type="date" ng-model="producto.fechaVencimiento" placeholder="Fecha Vencimiento" class="form-control">
<input type="number" ng-model="producto.precio" placeholder="Precio" class="form-control">
<input type="number" ng-model="producto.cantidad" placeholder="Cantidad" class="form-control">


<input type="submit" value="Registrar">
</form>




<table class="table table-striped"> 

<thead>
<tr>
<th>#</th>
<th>Descripción</th>
<th>Fecha Vencimiento</th>
<th>Precio</th>
<th>Cantidad</th>
</tr>
</thead>
<tbody>

<!--                         productos   se carga en el controller via get -->
<tr ng-repeat="producto in productos">
<td>{{producto.id}}</td>
<td>{{producto.descripcion}}</td>
<td>{{producto.fechaVencimiento  | date:'dd/MM/yyyy'}}</td> 
<td>{{producto.precio}}</td>
<td>{{producto.cantidad}}</td>
</tr>
</tbody>



</table>









</div>

{{producto}}


</body>
</html>