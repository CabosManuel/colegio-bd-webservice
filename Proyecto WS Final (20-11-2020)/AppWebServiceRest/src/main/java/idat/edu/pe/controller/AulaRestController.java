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

import idat.edu.pe.model.Aula;
import idat.edu.pe.service.AulaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/aulas")
public class AulaRestController {
	
	@Autowired
	private AulaService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		Collection<Aula> itemAula = service.findAll();
		if(itemAula.isEmpty()) {
			return new ResponseEntity<>(itemAula, HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(itemAula, HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Aula aula){
		
		service.insert(aula);
		return new ResponseEntity<>("Se creó correctamente",HttpStatus.CREATED);
	
	}

}
