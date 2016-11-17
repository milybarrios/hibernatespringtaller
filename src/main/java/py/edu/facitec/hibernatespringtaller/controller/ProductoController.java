package py.edu.facitec.hibernatespringtaller.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import py.edu.facitec.hibernatespringtaller.dao.ProductoDAO;
import py.edu.facitec.hibernatespringtaller.model.Producto;
@Controller
@RestController
@Transactional
@RequestMapping("/productos")//responde para cualquier metodo dentro de esta clase
public class ProductoController {
	
	@Autowired
	private ProductoDAO productoDAO;
	
	//metodo para listar
	@RequestMapping(method=RequestMethod.GET)//se escribe directo en la URL GET
	public ModelAndView lista(){
									//direccion para JSP
		ModelAndView model=new ModelAndView();
		
		model.addObject("productos", productoDAO.buscarTodos());
		
		return model;
	}
	
	
	//metodo para registrar
	@RequestMapping(method=RequestMethod.POST)//recibe json y convierte a java
	public ResponseEntity<Producto> registrar(@RequestBody Producto producto){
		
		productoDAO.guardar(producto, producto.getId());
		
		return new ResponseEntity<Producto>(producto, HttpStatus.CREATED);
	}
	
	//método para acceder al formulario
	@RequestMapping(method=RequestMethod.GET,value="/formulario")//se escribe directo en la URL GET
	public ModelAndView formulario(){
									//direccion para JSP
		ModelAndView model=new ModelAndView("/productos/form");
		
		
		return model;
	}
	
	
	
	
	

}
