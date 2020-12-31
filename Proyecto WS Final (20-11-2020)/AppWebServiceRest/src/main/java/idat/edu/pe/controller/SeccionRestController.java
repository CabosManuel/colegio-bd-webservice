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

import idat.edu.pe.mapper.EstudianteMapper;
import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.mapper.SeccionMapper;
import idat.edu.pe.model.Estudiante;
import idat.edu.pe.model.Seccion;
import idat.edu.pe.service.SeccionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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
	@GetMapping("/buscarSeccion/{seccionId}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer seccionId){
		
		Seccion seccionOb = service.findById(seccionId);
		SeccionMapper seccionMapper = MapperUtil.convertOneSeccion(seccionOb);
		
		if(seccionOb!=null) {
			return new ResponseEntity<>(seccionMapper, HttpStatus.OK);
		}
		return new ResponseEntity<>("Estudiante con el dni " + seccionId + " no existente.", HttpStatus.NOT_FOUND);
		
	}
	@GetMapping("/buscar/{gradoId}")
	public ResponseEntity<?> buscar(@PathVariable Integer gradoId){
		
		Collection<Seccion> seccionOb = service.findByGrado(gradoId);
		Collection<SeccionMapper> seccionMapper = MapperUtil.convertSeccion(seccionOb);
		
		if(seccionOb!=null) {
			return new ResponseEntity<>(seccionMapper, HttpStatus.OK);
		}
		return new ResponseEntity<>("Estudiante con el dni " + gradoId + " no existente.", HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/buscarNivel/{nivelId}")
	public ResponseEntity<?> buscarPorNivel(@PathVariable Integer nivelId){
		
		Collection<Seccion> seccionOb = service.getfindByNivel(nivelId);
		Collection<SeccionMapper> seccionMapper = MapperUtil.convertSecciones(seccionOb);
		
		if(seccionOb!=null) {
			return new ResponseEntity<>(seccionMapper, HttpStatus.OK);
		}
		return new ResponseEntity<>("Nivel con el número " + nivelId + " no existente.", HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Seccion seccion){
		
		service.insert(seccion);
		return new ResponseEntity<>("Se creó correctamente",HttpStatus.CREATED);
	
	}
}
