package idat.edu.pe.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.model.Seccion;
import idat.edu.pe.service.SeccionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/secciones")
public class SeccionRestController {

	@Autowired
	private SeccionService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		Collection<Seccion> itemSeccion = service.findAll();
		if(itemSeccion.isEmpty()) {
			return new ResponseEntity<>(itemSeccion, HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(itemSeccion, HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Seccion seccion){
		
		service.insert(seccion);
		return new ResponseEntity<>("Se creó correctamente",HttpStatus.CREATED);
	
	}
}
