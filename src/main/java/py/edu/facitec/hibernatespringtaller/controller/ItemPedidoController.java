package py.edu.facitec.hibernatespringtaller.controller;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import py.edu.facitec.hibernatespringtaller.dao.ItemPedidoDAO;
import py.edu.facitec.hibernatespringtaller.model.ItemPedido;

@RestController
@Transactional
@RequestMapping("/itemPedido")
public class ItemPedidoController {
	@Autowired
	private ItemPedidoDAO itemPedidoDAO;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> registrar(@RequestBody ItemPedido itemPedido){
		itemPedidoDAO.guardar(itemPedido, itemPedido.getId());
		return new ResponseEntity<ItemPedido>(itemPedido, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ItemPedido>> buscarTodos(){
		List<ItemPedido> itemPedidos=itemPedidoDAO.buscarTodos();
		return new ResponseEntity<List<ItemPedido>>(itemPedidos, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> buscarPorId(@PathVariable Integer id){
		ItemPedido itemBuscar=itemPedidoDAO.buscar(id);
		return new ResponseEntity<ItemPedido>(itemBuscar, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> eliminar(@PathVariable Integer id){
		ItemPedido itemAEliminar = itemPedidoDAO.buscar(id);
		if (itemAEliminar == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		itemPedidoDAO.eliminar(itemAEliminar);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public ModelAndView formulario(){
		return new ModelAndView("/itemPedido/form");
	}

}
