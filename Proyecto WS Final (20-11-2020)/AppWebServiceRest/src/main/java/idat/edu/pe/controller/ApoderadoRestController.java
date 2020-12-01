package idat.edu.pe.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.model.Apoderado;
import idat.edu.pe.model.Distrito;
import idat.edu.pe.service.ApoderadoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/apoderados")
public class ApoderadoRestController {

	@Autowired
	private ApoderadoService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		Collection<Apoderado> itemApoderado = service.findAll();
		if(itemApoderado.isEmpty()) {
			return new ResponseEntity<>(itemApoderado, HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(itemApoderado, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{apoderadoId}")
	public ResponseEntity<?> buscar(@PathVariable Integer apoderadoId){
		
		Apoderado apoderadoOb = service.findById(apoderadoId);
		if(apoderadoOb!=null) {
			return new ResponseEntity<>(apoderadoOb, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Apoderado apoderado){
		
		service.insert(apoderado);
		return new ResponseEntity<>("Se creó correctamente",HttpStatus.CREATED);
	
	}


}
