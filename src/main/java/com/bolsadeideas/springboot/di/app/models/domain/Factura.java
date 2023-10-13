package com.bolsadeideas.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
//ya no es singleton, este beans va a durar lo que dura una peticion http por lo tanto cada usuario que se conecte va a tener una factura distinta y propia 
@RequestScope
//para que la sesion http sea persistente has que cerremos navegador
//hay que implementar serializable pq convierte objeto en secuencia de bytes
//@SessionScope

public class Factura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 946004357128146951L;

	@Value("${factura.descripcion}")
	private String descripcion;

	@Autowired

	private Cliente cliente;
	
	
	@Autowired
	//@Qualifier("itemsFacturaOficina")
	private List<ItemFactura> items;
	
	@PostConstruct
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat("Jose"));
		descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
		
	}
	
	@PreDestroy
	public void destruir() {
		
		System.out.println("Factura Destruida: ".concat(descripcion));
		
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

}
