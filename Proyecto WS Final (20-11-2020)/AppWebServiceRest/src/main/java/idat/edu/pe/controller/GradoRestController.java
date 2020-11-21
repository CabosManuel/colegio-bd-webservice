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

import idat.edu.pe.model.Grado;
import idat.edu.pe.service.GradoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/grados")
public class GradoRestController {
	
	@Autowired
	private GradoService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		Collection<Grado> itemGrado = service.findAll();
		if(itemGrado.isEmpty()) {
			return new ResponseEntity<>(itemGrado, HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(itemGrado, HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Grado grado){
		
		service.insert(grado);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	
	}
	
}
