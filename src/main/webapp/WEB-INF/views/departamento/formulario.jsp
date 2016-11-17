<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/hibernatespringtaller/resources/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body class="container">

<div>
			<ul class="nav nav-pills nav-justified"> 
			   

			   
			    	<li><a href="/hibernatespringtaller">Inicio</a></li>
					<li><a href="/hibernatespringtaller/clientes/formulario" >Registrar Cliente</a></li>
					<li><a href="/hibernatespringtaller/productos/formulario">Registrar Producto</a></li>
					<li><a href="/hibernatespringtaller/gerente/formulario">Registrar Gerente</a></li>
					<li><a href="/hibernatespringtaller/pedidos/formulario">Registrar Pedido</a>
					<li><a href="/hibernatespringtaller/itemPedido/formulario">Item Pedido</a>
					<li Class="active"><a href="/hibernatespringtaller/departamento/formulario">Departamento</a>
					
		   </ul>

</div>

		<form action="hibernatespringtaller/departamento" method="POST" class="hero-unit">
		
		<label for="descripcion">Descripcion</label>
		<input type="text" name="descripcion" id="descripcion"> 
		<input type="submit" value="Guardar">
	
		</form>


</body>
</html>