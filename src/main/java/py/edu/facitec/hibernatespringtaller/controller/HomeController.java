package py.edu.facitec.hibernatespringtaller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Indicamos que la clase gestionara las peticiones del navegador o cliente
@Controller
public class HomeController {
	//Responde a la ULR / que es la raiz del proyecto
	@RequestMapping("/")
	public String index(){
		
		System.out.println("Cargando la página de Bienvenida Nuevo");
		ModelAndView model=new ModelAndView();
		System.out.println("NOmbre "+model.getViewName()+"nom "+model.getView());
		
		return "hello-world";
	}
}
