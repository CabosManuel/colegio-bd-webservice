package idat.edu.pe.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.model.Estudiante;
import idat.edu.pe.model.Nivel;
import idat.edu.pe.service.NivelService;

@RestController
@RequestMapping("/rest/niveles")
public class NivelRestController {
	
	@Autowired
	private NivelService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		Collection<Nivel> itemNivel = service.findAll();
		if(itemNivel.isEmpty()) {
			return new ResponseEntity<>(itemNivel, HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(itemNivel, HttpStatus.OK);
	}

	@GetMapping("/buscar/{nivelId}")
	public ResponseEntity<?> buscar(@PathVariable Integer nivelId){
		
		Nivel nivelOb = service.findById(nivelId);
		if(nivelOb!=null) {
			return new ResponseEntity<>(nivelOb, HttpStatus.OK);
		}
		return new ResponseEntity<>(nivelOb, HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Nivel nivel){
		
		service.insert(nivel);
		return new ResponseEntity<>("Se creó correctamente",HttpStatus.CREATED);
	
	}
}