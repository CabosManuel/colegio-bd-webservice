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

import idat.edu.pe.model.Malla;
import idat.edu.pe.service.MallaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/mallas")
public class MallaRestController {

	@Autowired
	private MallaService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		Collection<Malla> itemMalla = service.findAll();
		if(itemMalla.isEmpty()) {
			return new ResponseEntity<>(itemMalla, HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(itemMalla, HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Malla malla){
		
		service.insert(malla);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	
	}
}
