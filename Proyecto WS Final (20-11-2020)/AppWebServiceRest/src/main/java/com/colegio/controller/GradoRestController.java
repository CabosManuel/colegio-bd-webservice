package com.colegio.controller;

import java.util.Collection;
import java.util.Map;

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

import com.colegio.mapper.GradoMapper;
import com.colegio.mapper.MapperUtil;
import com.colegio.model.Grado;
import com.colegio.service.GradoService;

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
	
	@GetMapping("/buscar/{gradoId}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer gradoId){
		
		Grado gradoOb = service.findById(gradoId);
		GradoMapper gradoMapper = MapperUtil.convertOneGrado(gradoOb);
		
		if(gradoOb!=null) {
			return new ResponseEntity<>(gradoMapper, HttpStatus.OK);
		}
		return new ResponseEntity<>("Estudiante con el dni " + gradoId + " no existente.", HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/buscarGrado/{gradoId}")
	public ResponseEntity<?> buscarGrado(@PathVariable Integer gradoId){
		
		Map<String, ?> grado = service.buscarGrado(gradoId);
		
		if(grado!=null && !grado.isEmpty()) {
			return new ResponseEntity<>(grado, HttpStatus.OK);
		}
		return new ResponseEntity<>("Estudiante con el dni " + gradoId + " no existente.", HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/buscarNivel/{nivelId}")
	public ResponseEntity<?> buscarPorNivel(@PathVariable Integer nivelId){
		
		Collection<Grado> gradoOb = service.getfindByNivel(nivelId);
		Collection<GradoMapper> gradoMapper = MapperUtil.convertGrados(gradoOb);
		
		if(gradoOb!=null) {
			return new ResponseEntity<>(gradoMapper, HttpStatus.OK);
		}
		return new ResponseEntity<>("Nivel con el número " + nivelId + " no existente.", HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Grado grado){
		
		service.insert(grado);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	
	}
	
}
