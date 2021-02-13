package idat.edu.pe.controller;

import java.util.Collection;
import java.util.Collections;
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

import idat.edu.pe.mapper.ApoderadoLoginMapper;
import idat.edu.pe.mapper.ApoderadoMapper;
import idat.edu.pe.mapper.EstudianteMapper;
import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.model.Apoderado;
import idat.edu.pe.model.Distrito;
import idat.edu.pe.service.ApoderadoService;
import idat.edu.pe.service.DistritoService;
import idat.edu.pe.service.EstudianteService;
import idat.edu.pe.service.NotificacionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/apoderados")
public class ApoderadoRestController {

	@Autowired
	private ApoderadoService service;
	
	@Autowired
	private NotificacionService serviceNotificacion;
	
	@Autowired
	private DistritoService serviceDistrito;
	
	@Autowired
	private EstudianteService serviceEstudiante;
	
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
		
		Apoderado apoderadoDb = service.findByDniApoderado(dniApoderado);
		ApoderadoMapper apoderadoMapper = MapperUtil.convert(apoderadoDb);
		
		if(apoderadoDb!=null) {
			return new ResponseEntity<>(apoderadoMapper, HttpStatus.OK);
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
	public ResponseEntity<?> editar(@PathVariable String dniApoderado, @RequestBody Apoderado newApoderado){
		
		Apoderado apoderadoDb = service.findByDniApoderado(dniApoderado);
		if(apoderadoDb!=null) {
			apoderadoDb.setNombre(newApoderado.getNombre());
			apoderadoDb.setApellido(newApoderado.getApellido());
			apoderadoDb.setCelular(newApoderado.getCelular());
			apoderadoDb.setCorreo(newApoderado.getCorreo());
			apoderadoDb.setDistrito(newApoderado.getDistrito());
			apoderadoDb.setPass(newApoderado.getPass());
			apoderadoDb.setDniApoderado(newApoderado.getDniApoderado());
			service.update(apoderadoDb);
			return new ResponseEntity<>("El apoderado con el dni " + dniApoderado + " se actualizó correctamente",HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/editar_perfil/{dniApoderado}")
	public ResponseEntity<?> editarPerfil(@PathVariable String dniApoderado, @RequestBody Map<String, Object> nuevoApoderadoMap){
		
		Apoderado apoderadoDb = service.findByDniApoderado(dniApoderado);
		Map<String, Object> rpta = new HashMap<>();
		rpta.put("rpta", false);
		rpta.put("msj", "DNI no existe.");
		
		if(apoderadoDb!=null) {
			// Este apoderado se enviará como respuesta
			ApoderadoLoginMapper apoderadoRespuesta = MapperUtil.convertApoderadoToApoderadoLogin(nuevoApoderadoMap);
			apoderadoRespuesta.setEstudiantes(serviceEstudiante.findByDniApoderado(dniApoderado));
			
			// Este actualiza en la BD
			apoderadoDb.setNombre(nuevoApoderadoMap.get("nombre").toString());
			apoderadoDb.setApellido(nuevoApoderadoMap.get("apellido").toString());
			apoderadoDb.setCelular(nuevoApoderadoMap.get("celular").toString());
			apoderadoDb.setCorreo(nuevoApoderadoMap.get("correo").toString());
			apoderadoDb.setDireccion(nuevoApoderadoMap.get("direccion").toString());			
			apoderadoDb.setDistrito(serviceDistrito.findById((Integer) nuevoApoderadoMap.get("distrito_id")));
			service.update(apoderadoDb);
			
			rpta.put("rpta", true);
			rpta.put("msj", "El apoderado con el dni " + dniApoderado + " se actualizó correctamente");
			rpta.put("apoderado", apoderadoRespuesta);
			return new ResponseEntity<>(rpta, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(rpta,HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/desactivar/{dniApoderado}")
	public ResponseEntity<?> desactivar(@PathVariable String dniApoderado){		
		Apoderado apoderadoDb = service.findByDniApoderado(dniApoderado);
		if(apoderadoDb!=null) {
			if(apoderadoDb.getEstado() == false) {
				apoderadoDb.setEstado(true);
			}else {
				apoderadoDb.setEstado(false);
			}
			
			service.update(apoderadoDb);
			return new ResponseEntity<>("El apoderado con el dni " + dniApoderado + " se desactivó correctamente.", HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/nombre_estudiantes/{dniApoderado}")
	public ResponseEntity<?> getNombreEstudiantesPorDniApoderado(@PathVariable String dniApoderado){
		Collection<Object[]> estudiantes = serviceApoderado.getEstudiantesByDniApoderado(dniApoderado);
		return new ResponseEntity<>(MapperUtil.convertCollObjects_EstudianteMapper(estudiantes), HttpStatus.OK);
	}
	
	/** 
	 * http://localhost:8085/idat/rest/apoderados/bandeja_entrada?dniEstudiante=61933011&tipo1=comunicado&tipo2=x&tipo3=x
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
		/*Apoderado apoderadoDb = service.findByDniApoderado(dniApoderado);
		if(apoderadoDb!=null) {*/
			Collection<?> estudiantes = serviceEstudiante.findByDniApoderado(dniApoderado);
			return new ResponseEntity<>(estudiantes, HttpStatus.OK);
		/*}
				
		return new ResponseEntity<>("Apoderado \""+dniApoderado+"\", no encontrado", HttpStatus.NOT_FOUND);*/
	}
}
