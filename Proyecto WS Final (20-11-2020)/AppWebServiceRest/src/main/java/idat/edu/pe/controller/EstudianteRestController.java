package idat.edu.pe.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.mapper.EstudianteMapper;
import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.model.Estudiante;
import idat.edu.pe.service.EstudianteService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/estudiante")
public class EstudianteRestController {

	@Autowired
	private EstudianteService estudianteService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		Collection<Estudiante> itemsEstudiante = estudianteService.findAll();
		Collection<EstudianteMapper> itemsEstudianteMapper = MapperUtil.convert(itemsEstudiante);
		
		if(itemsEstudiante.isEmpty()) {
			return new ResponseEntity<>(itemsEstudiante, HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(itemsEstudianteMapper, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{estudianteId}")
	public ResponseEntity<?> buscar(@PathVariable Integer estudianteId){
		
		Estudiante estudianteOb = estudianteService.findById(estudianteId);
		EstudianteMapper estudianteMapper = MapperUtil.convert(estudianteOb);
		
		if(estudianteOb!=null) {
			return new ResponseEntity<>(estudianteMapper, HttpStatus.OK);
		}
		return new ResponseEntity<>(estudianteMapper, HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Estudiante estudiante){
		
		estudianteService.insert(estudiante);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	
	}
	
	@PutMapping("/editar/{estudianteId}")
	public ResponseEntity<?> editar(@PathVariable Integer estudianteId, @RequestBody Estudiante newEstudiante){
		
		Estudiante estudianteOb = estudianteService.findById(estudianteId);
		if(estudianteOb!=null) {
			estudianteOb.setNombre(newEstudiante.getNombre());
			estudianteOb.setApellido(newEstudiante.getApellido());
			estudianteOb.setCelular(newEstudiante.getCelular());
			
			estudianteService.update(estudianteOb);
			return new ResponseEntity<>(estudianteOb, HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/eliminar/{estudianteId}")
	public ResponseEntity<?> eliminar(@PathVariable Integer estudianteId){
		
		//Estudiante estudianteOb = estudianteService.findById(estudianteId);
		if(estudianteId != null) {
			
			estudianteService.delete(estudianteId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(estudianteId, HttpStatus.NOT_FOUND);
	}
	
}
