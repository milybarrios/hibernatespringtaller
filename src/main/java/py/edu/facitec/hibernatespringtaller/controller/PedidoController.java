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

import py.edu.facitec.hibernatespringtaller.dao.PedidoDAO;
import py.edu.facitec.hibernatespringtaller.model.Pedido;

@Controller
@RestController
@Transactional
@RequestMapping("/pedidos")//responde para cualquier metodo dentro de esta clase
public class PedidoController {
	
	@Autowired
	private PedidoDAO pedidoDAO;
	
	//metodo para listar
	@RequestMapping(method=RequestMethod.GET)//se escribe directo en la URL GET
	public ModelAndView lista(){
									//direccion para JSP
		ModelAndView model=new ModelAndView();
		
		model.addObject("pedido", pedidoDAO.buscarTodos());
		
		return model;
	}
	
	
	//metodo para registrar
	@RequestMapping(method=RequestMethod.POST)//recibe json y convierte a java
	public ResponseEntity<Pedido> registrar(@RequestBody Pedido pedido){
		pedidoDAO.guardar(pedido, pedido.getId());
		
		
		return new ResponseEntity<Pedido>(pedido, HttpStatus.CREATED);
	}
	
	//método para acceder al formulario
	@RequestMapping(method=RequestMethod.GET,value="/form")//se escribe directo en la URL GET
	public ModelAndView formulario(){
									//direccion para JSP
		ModelAndView model=new ModelAndView("/pedidos/form");
		
		
		return model;
	}
	
	
	
	
	

}