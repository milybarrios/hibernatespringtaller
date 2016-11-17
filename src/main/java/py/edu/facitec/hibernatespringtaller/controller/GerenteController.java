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
import py.edu.facitec.hibernatespringtaller.dao.GerenteDAO;
import py.edu.facitec.hibernatespringtaller.model.Gerente;

@RestController
@Transactional
@RequestMapping("/gerente")
public class GerenteController {
	@Autowired
	private GerenteDAO gerenteDAO;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Gerente> registrar(@RequestBody Gerente gerente){
		gerenteDAO.guardar(gerente, gerente.getId());
		
		return new ResponseEntity<Gerente>(gerente, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Gerente>> buscarTodos(){
		List<Gerente> gerentes=gerenteDAO.buscarTodos();
		return new ResponseEntity<List<Gerente>>(gerentes, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Gerente> buscarPorId(@PathVariable Integer id){
		Gerente gerenteBuscar=gerenteDAO.buscar(id);
		return new ResponseEntity<Gerente>(gerenteBuscar, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Gerente> eliminar(@PathVariable Integer id){
		Gerente gerenteAEliminar =gerenteDAO.buscar(id);
		if (gerenteAEliminar == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		gerenteDAO.eliminar(gerenteAEliminar);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public ModelAndView formulario(){
		return new ModelAndView("/gerente/form");
	}

}
