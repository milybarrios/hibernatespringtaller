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

import py.edu.facitec.hibernatespringtaller.dao.ClienteDAO;
import py.edu.facitec.hibernatespringtaller.model.Cliente;

@RestController
@Transactional
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteDAO clienteDAO;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> registrar(@RequestBody Cliente cliente){
		clienteDAO.guardar(cliente, cliente.getId());
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> buscarTodos(){
		List<Cliente> clientes= clienteDAO.buscarTodos();
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id){
		Cliente clienteBuscar=clienteDAO.buscar(id);
		return new ResponseEntity<Cliente>(clienteBuscar, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> eliminar(@PathVariable Integer id){
		Cliente clienteAEliminar = clienteDAO.buscar(id);
		if (clienteAEliminar == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		clienteDAO.eliminar(clienteAEliminar);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public ModelAndView formulario(){
		return new ModelAndView("/cliente/form");
	}

}
