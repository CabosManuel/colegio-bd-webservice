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
import idat.edu.pe.service.ApoderadoService;
import idat.edu.pe.service.DistritoService;
import idat.edu.pe.service.DistritoServiceImpl;
import idat.edu.pe.service.EstudianteService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/estudiante")
public class EstudianteRestController {

	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired 
	private DistritoService DService;
	
	@Autowired 
	private ApoderadoService AService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		Collection<Estudiante> itemsEstudiante = estudianteService.findAll();
		Collection<EstudianteMapper> itemsEstudianteMapper = MapperUtil.convert(itemsEstudiante);
		
		if(itemsEstudiante.isEmpty()) {
			return new ResponseEntity<>(itemsEstudiante, HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(itemsEstudianteMapper, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{dniEstudiante}")
	public ResponseEntity<?> buscar(@PathVariable String dniEstudiante){
		
		Estudiante estudianteOb = estudianteService.findByDniEstudiante(dniEstudiante);
		EstudianteMapper estudianteMapper = MapperUtil.convert(estudianteOb);
		
		if(estudianteOb!=null) {
			return new ResponseEntity<>(estudianteMapper, HttpStatus.OK);
		}
		return new ResponseEntity<>("Estudiante con el dni " + dniEstudiante + " no existente.", HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Estudiante estudiante){
		
		//EstudianteMapper est = MapperUtil.convertm(estudiante);
	    estudiante.setDistrito(DService.findById(estudiante.getDistrito().getDistritoId()));
	    estudiante.setApoderado(AService.findByDniApoderado(estudiante.getApoderado().getDniApoderado()));
		estudianteService.insert(estudiante);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	
	}
	
	@PutMapping("/editar/{dniEstudiante}")
	public ResponseEntity<?> editar(@PathVariable String dniEstudiante, @RequestBody Estudiante newEstudiante){
		
		Estudiante estudianteOb = estudianteService.findByDniEstudiante(dniEstudiante);
		if(estudianteOb!=null) {
			estudianteOb.setNombre(newEstudiante.getNombre());
			estudianteOb.setApellido(newEstudiante.getApellido());
			estudianteOb.setCelular(newEstudiante.getCelular());
			estudianteOb.setCorreo(newEstudiante.getCorreo());
			estudianteOb.setDireccion(newEstudiante.getDireccion());
			estudianteOb.setDistrito(newEstudiante.getDistrito());
			estudianteOb.setDniEstudiante(newEstudiante.getDniEstudiante());
			estudianteOb.setApoderado(newEstudiante.getApoderado());
			estudianteOb.setFnacimiento(newEstudiante.getFnacimiento());
			estudianteOb.setPass(newEstudiante.getPass());
			
			estudianteService.update(estudianteOb);
			return new ResponseEntity<>("La estudiante con el dni " + dniEstudiante + " se actualizó correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/desactivar/{dniEstudiante}")
	public ResponseEntity<?> desactivar(@PathVariable String dniEstudiante, @RequestBody Estudiante newEstudiante){
		
		Estudiante estudianteOb = estudianteService.findByDniEstudiante(dniEstudiante);
		if(estudianteOb!=null) {
			estudianteOb.setEstado(newEstudiante.getEstado());
			
			estudianteService.update(estudianteOb);
			return new ResponseEntity<>("La estudiante con el dni " + dniEstudiante + " se desactivó correctamente.", HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	/*@DeleteMapping("/eliminar/{dniEstudiante}")
	public ResponseEntity<?> eliminar(@PathVariable Integer estudianteId){
		
		//Estudiante estudianteOb = estudianteService.findById(estudianteId);
		if(estudianteId != null) {
			
			estudianteService.dele(estudianteId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Estudiante no encontrado", HttpStatus.NOT_FOUND);
	}
	*/
}
