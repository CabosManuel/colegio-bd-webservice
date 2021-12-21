package com.colegio.controller;

import java.util.Collection;
import java.util.Date;
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

import com.colegio.model.Matricula;
import com.colegio.service.MatriculaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/matriculas")
public class MatriculaRestController {
	
	@Autowired
	private MatriculaService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		Collection<Matricula> itemMatricula = service.findAll();
		if(itemMatricula.isEmpty()) {
			return new ResponseEntity<>(itemMatricula, HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(itemMatricula, HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> nuevaM(@RequestBody Map<String, Object> nuevaM) {

		Date fecha = new Date();
		
		service.registrarMatricula(fecha,
				nuevaM.get("grado").toString(),
				nuevaM.get("nivel").toString(),
				nuevaM.get("seccion_id").toString(),
				nuevaM.get("dni_estudiante").toString());

		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/buscarEstudiante/{dniEstudiante}")
	public ResponseEntity<?> BuscarEstudiante(@PathVariable String dniEstudiante){
		
		Map<String,?> matriculaOb = service.findByEstudiante(dniEstudiante);
		
		if(matriculaOb != null && !matriculaOb.isEmpty()) {
			return new ResponseEntity<>(matriculaOb, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("La estudiante con el dni " + dniEstudiante + " no se encuentra matriculada.", HttpStatus.NO_CONTENT);
	}
	

}
