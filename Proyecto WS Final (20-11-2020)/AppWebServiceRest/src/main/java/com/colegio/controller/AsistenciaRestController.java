package com.colegio.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
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
import com.colegio.service.AsistenciaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/asistencia")
public class AsistenciaRestController {
	
	@Autowired
	private AsistenciaService s;
	
	@GetMapping("/consultar_asistencias_antiguo")
	public ResponseEntity<?> listarAsistenciasMes(@RequestParam String dniEstudiante, @RequestParam String fecha){
		Collection<Object[]> asistencias = s.getAsistenciasByDniEstudianteFecha(dniEstudiante, fecha);
				
		if(asistencias.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(MapperUtil.convertCollObjects_AsistenciaMapper(asistencias),HttpStatus.OK);
	}
	
	
	@GetMapping("/consultar_asistencias")
	public ResponseEntity<?> listarAsistenciasPorDniEstudianteMesCurso(@RequestParam String dniEstudiante, @RequestParam Integer mes, 
			@RequestParam String cursoId){
		Collection<Object[]> asistencias = s.getAsistenciasByDniEstudianteMesCurso(dniEstudiante, mes, cursoId);
		
		if(asistencias.isEmpty()) {
			return new ResponseEntity<>("No hay asistencias",HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(MapperUtil.convertCollObjects_AsistenciaMapper(asistencias),HttpStatus.OK);
	}
	
	@GetMapping("/meses")
	public ResponseEntity<?> listarMesesPorDniEstudiante(@RequestParam String dniEstudiante){
		Collection<Object> objs = s.getMesesByDniEstudiante(dniEstudiante);
		Collection<Integer> meses = new ArrayList<>();
		
		for(Object obj:objs) {
			meses.add((Integer)obj);
		}
		
		return new ResponseEntity<>(meses,HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> nuevaAsistencia(@RequestBody Map<String, Object> nuevaA) {

		LocalDate hoy = LocalDate.now();
		LocalTime ahora = LocalTime.now();
		
				Boolean estado = (Boolean.parseBoolean(nuevaA.get("estado").toString()));
				String dni = nuevaA.get("dni_estudiante").toString();
				String HorarioDetalle = nuevaA.get("horario_detalle_id").toString();
		
		s.registrarAsistencia(LocalDateTime.of(hoy, ahora), estado, dni, HorarioDetalle);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{asistenciaId}")
	public ResponseEntity<?> modificarAsistencia(@PathVariable Integer asistenciaId, @RequestBody Map<String, Object> nuevaA) {
	
		LocalDate hoy = LocalDate.now();
		LocalTime ahora = LocalTime.now();
		
		Boolean estado = Boolean.parseBoolean(nuevaA.get("estado").toString());
		
		s.modificarAsistencia(LocalDateTime.of(hoy, ahora), estado, asistenciaId);
				
		return new ResponseEntity<>(HttpStatus.OK);
	}	
	
	@GetMapping("/buscar/{horarioDetalleId}")
	public ResponseEntity<?> buscarAsistenciaPorHorario(@PathVariable Integer horarioDetalleId){
		Collection<Map<String, ?>> asistenciasOb = s.buscarPorHorario(horarioDetalleId);
		
		if(asistenciasOb != null && !asistenciasOb.isEmpty()) {
			return new ResponseEntity<>(asistenciasOb,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
