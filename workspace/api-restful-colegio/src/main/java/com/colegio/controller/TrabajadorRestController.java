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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.mapper.MapperUtil;
import com.colegio.model.Trabajador;
import com.colegio.service.TrabajadorService;

@CrossOrigin("*")
@RestController
@RequestMapping("/trabajador")
public class TrabajadorRestController {

	@Autowired
	private TrabajadorService serviceT;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		Collection<Map<String, ?>> trabajadores = serviceT.buscarTrabajadores();
		//Collection<TrabajadorMapper> trabajadoresmapper = MapperUtil.convertTrabajadores(trabajadores);
		
		if(!trabajadores.isEmpty() && trabajadores != null) {
			return new ResponseEntity<>(trabajadores, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/buscar/{dni}")
	public ResponseEntity<?> buscar(@PathVariable String dni){
		Map<String, ?> trabajador = serviceT.buscarTrabajador(dni);
		
		if(trabajador != null && !trabajador.isEmpty()) {
			return new ResponseEntity<>(trabajador,HttpStatus.OK);
		}		
		return new ResponseEntity<>("Trabajador con dni: "+dni+" no existe.",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/validar/{correo}/{pass}")
	public ResponseEntity<?> validar(@PathVariable String correo, @PathVariable String pass){
		Map<String, ?> trabajador = serviceT.obtenerPorCorreoPass(correo, pass);
		
		if(trabajador != null && !trabajador.isEmpty()) {
			return new ResponseEntity<>(trabajador,HttpStatus.OK);
		}		
		return new ResponseEntity<>("Trabajador con esos parámetros no existe.", HttpStatus.NOT_FOUND);
	}
	
//	@GetMapping("/buscarPorCurso/{cursoId}")
//	public ResponseEntity<?> buscarPorCurso(@PathVariable Integer cursoId){
//		Collection</*Trabajador*/Map<String,Object>> trabajador = serviceT.getfindByCurso(cursoId);
//		//Collection<TrabajadorMapper> trabajadorMapper = MapperUtil.convertTrabajadoresPorCurso(trabajador);
//		
//		if(trabajador != null) {
//			return new ResponseEntity<>(MapperUtil.convertCollMapToCollTrabajadorMapper(trabajador)/*trabajadorMapper*/,HttpStatus.OK);
//		}		
//		return new ResponseEntity<>("Curso con ID: "+ cursoId +" no existe.",HttpStatus.NOT_FOUND);
//	}
	
	@GetMapping("/buscarCursos/{trabajadorId}")
	public ResponseEntity<?> buscarCursos(@PathVariable Integer trabajadorId){
		Collection<Map<String, ?>> trabajador = serviceT.seleccionarCursos(trabajadorId);
		
		if(trabajador != null && !trabajador.isEmpty()) {
			return new ResponseEntity<>(trabajador,HttpStatus.OK);
		}		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> nuevoTrabajador(@RequestBody Map<String, Object> nuevaE) {

		serviceT.registrarTrabajador(
				nuevaE.get("dni").toString(),
				nuevaE.get("nombres").toString(),
				nuevaE.get("apellidos").toString(),
				nuevaE.get("celular").toString(),
				nuevaE.get("correo").toString(),
				nuevaE.get("fecha_nacimiento").toString(),
				(Integer.parseInt(nuevaE.get("distrito_id").toString())),
				nuevaE.get("direccion").toString(),
				nuevaE.get("pass").toString(),
				(Boolean.parseBoolean(nuevaE.get("estado").toString())),
				nuevaE.get("cargo").toString(),
				nuevaE.get("sexo").toString());

		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{trabajadorId}")
	public ResponseEntity<?> editar(@PathVariable Integer trabajadorId, @RequestBody Trabajador newTrabajador){
		Trabajador trabajadorDb = serviceT.findById(trabajadorId);
		
		if(trabajadorDb!=null) {
			trabajadorDb.setNombres(newTrabajador.getNombres());
			trabajadorDb.setApellidos(newTrabajador.getApellidos());
			trabajadorDb.setCargo(newTrabajador.getCargo());
			trabajadorDb.setDni(newTrabajador.getDni());
			trabajadorDb.setDistrito(newTrabajador.getDistrito());
			trabajadorDb.setDireccion(newTrabajador.getDireccion());
			trabajadorDb.setCelular(newTrabajador.getCelular());
			trabajadorDb.setCorreo(newTrabajador.getCorreo());
//			trabajadorDb.setPass(newTrabajador.getPass());
			trabajadorDb.setFechaNacimiento(newTrabajador.getFechaNacimiento());
			
			serviceT.update(trabajadorDb);
			return new ResponseEntity<>(trabajadorDb,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("Trabajador con ID: "+trabajadorId+" no existe.",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/desactivar/{dni}")
	public ResponseEntity<?> DesactivarEstudiante(@PathVariable String dni, @RequestBody Map<String, Object> nuevoT) {
		
		serviceT.cambiarTrabajador(Boolean.parseBoolean(nuevoT.get("estado").toString()), dni);
				
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("/listar_docentes")
	public ResponseEntity<?> buscarPorDniEstudiante(@RequestParam String dniEstudiante){
		
		Collection<Map<String,?>> docentes = serviceT.getfindByDniEstudiante(dniEstudiante);
		if(docentes.isEmpty() || docentes == null) {
			return new ResponseEntity<>("No existe dni estudiante.", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(docentes, HttpStatus.OK);
	}
}
