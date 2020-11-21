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

import idat.edu.pe.model.Matricula;
import idat.edu.pe.service.MatriculaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/matriculas")
public class MatriculaRestController {
	
	@Autowired
	private MatriculaService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		Collection<Matricula> itemMatricula = service.findAll();
		if(itemMatricula.isEmpty()) {
			return new ResponseEntity<>(itemMatricula, HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(itemMatricula, HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Matricula matricula){
		
		service.insert(matricula);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	
	}
	

}
