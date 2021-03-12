package com.colegio.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

import com.colegio.mapper.ApoderadoLoginMapper;
import com.colegio.mapper.EstudianteMapper;
import com.colegio.mapper.MapperUtil;
import com.colegio.service.ApoderadoService;
import com.colegio.service.EstudianteService;
import com.colegio.service.NotificacionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/apoderados")
public class ApoderadoRestController {

	@Autowired
	private ApoderadoService service;
	
	@Autowired
	private NotificacionService serviceNotificacion;
	
	@Autowired
	private EstudianteService serviceEstudiante;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		Collection<Map<String, ?>> itemsApoderado= service.buscarApoderados();
		
		if(!itemsApoderado.isEmpty() && itemsApoderado != null) {
			return new ResponseEntity<>(itemsApoderado, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/buscar/{dniApoderado}")
	public ResponseEntity<?> buscar(@PathVariable String dniApoderado){
		Map<String, ?> apoderadoDb = service.buscarApoderado(dniApoderado);
		if(apoderadoDb!=null && !apoderadoDb.isEmpty()) {
			return new ResponseEntity<>(apoderadoDb, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Apoderado con el dni " + dniApoderado + " no existente.", HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/buscarApoderado/{dniApoderado}")
	public ResponseEntity<?> buscarApoderado(@PathVariable String dniApoderado){
		
		Map<String, ?> apoderadoDb = service.buscarPorDniApoderado(dniApoderado);
		
		if(apoderadoDb!=null && !apoderadoDb.isEmpty()) {
			return new ResponseEntity<>(apoderadoDb, HttpStatus.OK);
		}
		return new ResponseEntity<>("Apoderado con el dni " + dniApoderado + " no existente.", HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/buscarPorCorreo/{correo}")
	public ResponseEntity<?> buscarPorCorreo(@PathVariable String correo){
		
		Map<String, ?> apoderadoDb = service.buscarPorCorreo(correo);
		
		if(apoderadoDb!=null && !apoderadoDb.isEmpty()) {
			return new ResponseEntity<>(apoderadoDb, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody /*Apoderado*/Map<String,Object> apoderado){
		
		service.nuevoApoderado(apoderado);
		return new ResponseEntity<>("Se creó correctamente",HttpStatus.CREATED);
	
	}
	
	@PutMapping("/editar/{dniApoderado}")
	public ResponseEntity<?> modificarEstudiante(@PathVariable String dniApoderado, @RequestBody Map<String, Object> nuevoA) {
		service.modificarApoderado(
				nuevoA.get("nombre").toString(),
				nuevoA.get("apellido").toString(),
				nuevoA.get("celular").toString(),
				nuevoA.get("correo").toString(),
				Integer.parseInt(nuevoA.get("distrito_id").toString()),
				nuevoA.get("direccion").toString(),
				dniApoderado
				);
		
		ApoderadoLoginMapper apoderadoRespuesta = MapperUtil.convertApoderadoToApoderadoLogin(nuevoA);
		apoderadoRespuesta.setEstudiantes(serviceEstudiante.findByDniApoderado(dniApoderado));
				
		return new ResponseEntity<>(apoderadoRespuesta, HttpStatus.OK);
	}
	
	
	@PutMapping("/editar_perfil/{dniApoderado}")
	public ResponseEntity<?> editarPerfil(@PathVariable String dniApoderado, @RequestBody Map<String, Object> nuevoApoderadoMap){
		Map<String, Object> rpta = new HashMap<>();
		rpta.put("rpta", false);
		rpta.put("msj", "DNI no existe.");
		ApoderadoLoginMapper apoderadoRespuesta = MapperUtil.convertApoderadoToApoderadoLogin(nuevoApoderadoMap);
		apoderadoRespuesta.setEstudiantes(serviceEstudiante.findByDniApoderado(dniApoderado));
		
		rpta.put("rpta", true);
		rpta.put("msj", "El apoderado con el dni " + dniApoderado + " se actualizó correctamente");
		rpta.put("apoderado", apoderadoRespuesta);
		return new ResponseEntity<>(rpta, HttpStatus.OK);
	}
	
	@PutMapping("/desactivar/{dniApoderado}")

	public ResponseEntity<?> DesactivarEstudiante(@PathVariable String dniApoderado, @RequestBody Map<String, Object> nuevaA) {
		
		service.cambiarApoderado(Boolean.parseBoolean(nuevaA.get("estado").toString()), dniApoderado);
				
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/nombre_estudiantes/{dniApoderado}")
	public ResponseEntity<?> getNombreEstudiantesPorDniApoderado(@PathVariable String dniApoderado){
		Collection<Object[]> estudiantes = service.getEstudiantesByDniApoderado(dniApoderado);
		return new ResponseEntity<>(MapperUtil.convertCollObjects_EstudianteMapper(estudiantes), HttpStatus.OK);
	}
	
	/** 
	 * http://localhost:8085/idat/apoderados/bandeja_entrada?dniEstudiante=61933011&tipo1=comunicado&tipo2=x&tipo3=x
	 * 
	 * En los parametros tipo1, tipo2 y tipo3 van: persmiso, comunicado o citación (pueden ir en cualquier orden y
	 * también se pueden repetir), cadata "tipo" tiene que estar lleno, por defecto desde al app lo estoy llenando 
	 * con una "x". 
	 */
	@GetMapping("/bandeja_entrada")
	public ResponseEntity<?> getNotificacionesPorDniEstudianteTipo(@RequestParam String dniEstudiante, @RequestParam String tipo1, 
			@RequestParam String tipo2, @RequestParam String tipo3){
		 System.out.println("datos a consultar: "+dniEstudiante+" "+tipo1+" "+tipo2+" "+tipo3);
		Collection<Map<String, Object>> notificaciones = serviceNotificacion.getNotificacionesByDniEstudianteTipo(dniEstudiante, tipo1, tipo2, tipo3);
		
		if(notificaciones!=null) {
			return new ResponseEntity<>(MapperUtil.convertCollMapToCollNotificacionMapper(notificaciones), HttpStatus.OK);
		}
	 	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/n_estudiantes")
	public ResponseEntity<?> getCantidadEstudiantes(@RequestParam String dniApoderado){
		
		Collection<EstudianteMapper> estudiantes = MapperUtil.convert(serviceEstudiante.findAll());
		Integer cantidadEstudaintes = 0;
		
		for(EstudianteMapper e:estudiantes) {
			if(e.getApoderado().getDniApoderado().equals(dniApoderado)) {
				cantidadEstudaintes++;
			}
		}
		
		Map<String, Object> rpta = new HashMap<>();
		rpta.put("nE", cantidadEstudaintes);
	 	return new ResponseEntity<>(rpta, HttpStatus.OK);
	}
	
	@GetMapping("/estudiantes")
	public ResponseEntity<?> getEstudiantesPorDniApoderado(@RequestParam String dniApoderado){
		Collection<?> estudiantes = serviceEstudiante.findByDniApoderado(dniApoderado);
		return new ResponseEntity<>(estudiantes, HttpStatus.OK);
	}
}
