package com.bolsadeideas.springboot.di.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;

@Controller
public class IndexController {
	
	 //para inyectar objeto guardado en el contenedor Spring
	
	// desacoplamos "new" private MiServicio servicio = new MiServicio();
	// descoplamos la implementacion
	
	
	@Autowired
	//@Qualifier("miServicioPrincipal")
	
	private IServicio servicio;
	

	


	@GetMapping({"/","","/index"})
	
	public String index(Model model) {
		
		model.addAttribute("objeto", servicio.operacion());
		
		
		return "index";
	}
	
	

}
