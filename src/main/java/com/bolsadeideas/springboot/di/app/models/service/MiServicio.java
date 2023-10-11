package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.stereotype.Component;

//@Primary //para elegir entre ambos servicios el prioritario

//@Component("miServicioSimple")


public class MiServicio implements IServicio {
	
	@Override
	public String operacion() {
		
		
		return "ejecutando proceso simple";
	}

}
