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

import idat.edu.pe.mapper.GradoMapper;
import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.mapper.SeccionMapper;
import idat.edu.pe.model.Grado;
import idat.edu.pe.model.Seccion;
import idat.edu.pe.model.Trabajador;
import idat.edu.pe.service.GradoService;
import idat.edu.pe.service.SeccionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/grados")
public class GradoRestController {
	
	@Autowired
	private GradoService service;
	
	@Autowired
	private SeccionService sservice;

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
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Grado grado){
		
		service.insert(grado);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	
	}
	
}
