package idat.edu.pe.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.mapper.ApoderadoMapper;
import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.model.Apoderado;
import idat.edu.pe.service.ApoderadoService;
import idat.edu.pe.service.NotificacionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/apoderados")
public class ApoderadoRestController {

	@Autowired
	private ApoderadoService service;
	
	@Autowired
	private NotificacionService serviceNotificacion;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		Collection<Apoderado> itemApoderado = service.findAll();
		Collection<ApoderadoMapper> itemsApoderadoMapper = MapperUtil.convertApoderados(itemApoderado);
		
		if(itemApoderado.isEmpty()) {
			return new ResponseEntity<>("No hay apoderados registrados", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(itemsApoderadoMapper, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{dniApoderado}")
	public ResponseEntity<?> buscar(@PathVariable String dniApoderado){
		
		Apoderado apoderadoOb = service.findByDniApoderado(dniApoderado);
		ApoderadoMapper apoderadoMapper = MapperUtil.convert(apoderadoOb);
		
		if(apoderadoOb!=null) {
			return new ResponseEntity<>(apoderadoMapper, HttpStatus.OK);
		}
		return new ResponseEntity<>("Apoderado con el dni " + dniApoderado + " no existente.", HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Apoderado apoderado){
		
		service.insert(apoderado);
		return new ResponseEntity<>("Se creó correctamente",HttpStatus.CREATED);
	
	}
	
	@PutMapping("/editar/{dniApoderado}")
	public ResponseEntity<?> editar(@PathVariable String dniApoderado, @RequestBody Apoderado newApoderado){
		
		Apoderado apoderadoOb = service.findByDniApoderado(dniApoderado);
		if(apoderadoOb!=null) {
			apoderadoOb.setNombre(newApoderado.getNombre());
			apoderadoOb.setApellido(newApoderado.getApellido());
			apoderadoOb.setCelular(newApoderado.getCelular());
			apoderadoOb.setCorreo(newApoderado.getCorreo());
			apoderadoOb.setDistrito(newApoderado.getDistrito());
			apoderadoOb.setPass(newApoderado.getPass());
			apoderadoOb.setDniApoderado(newApoderado.getDniApoderado());
			service.update(apoderadoOb);
			return new ResponseEntity<>("El apoderado con el dni " + dniApoderado + " se actualizó correctamente",HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/desactivar/{dniApoderado}")
	public ResponseEntity<?> desactivar(@PathVariable String dniApoderado, @RequestBody Apoderado newApoderado){
		
		Apoderado apoderadoOb = service.findByDniApoderado(dniApoderado);
		if(apoderadoOb!=null) {
			apoderadoOb.setEstado(newApoderado.getEstado());
			service.update(apoderadoOb);
			return new ResponseEntity<>("El apoderado con el dni " + dniApoderado + " se desactivó correctamente", HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/nombre_estudiantes/{dniApoderado}")
	public ResponseEntity<?> getEstudiantesPorDniApoderado(@PathVariable String dniApoderado){
		Apoderado apoderadoDb = service.findByDniApoderado(dniApoderado);
		
		if(apoderadoDb!=null) {
			Collection<Object[]> estudiantes = service.getEstudiantesByDniApoderado(dniApoderado);
			return new ResponseEntity<>(MapperUtil.convertCollObjects_EstudianteMapper(estudiantes), HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/bandeja_entrada")
	public ResponseEntity<?> getNotificacionesPorDniEstudianteTipo(@RequestParam String dniEstudiante, @RequestParam String tipo1, 
			@RequestParam String tipo2, @RequestParam String tipo3){
		 System.out.println("datos a consultar: "+dniEstudiante+" "+tipo1+" "+tipo2+" "+tipo3);
		Collection<Object[]> notificaciones = serviceNotificacion.getNotificacionesByDniEstudianteTipo(dniEstudiante, tipo1, tipo2, tipo3);
		
		if(notificaciones!=null) {
			return new ResponseEntity<>(MapperUtil.convertCollObjects_NotificacionMapper(notificaciones), HttpStatus.OK);
		}
	 	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
