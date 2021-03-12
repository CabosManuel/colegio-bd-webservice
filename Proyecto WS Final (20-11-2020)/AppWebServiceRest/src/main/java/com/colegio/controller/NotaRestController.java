package com.colegio.controller;

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
import com.colegio.mapper.NotaMapper;
import com.colegio.model.Nota;
import com.colegio.service.EstudianteService;
import com.colegio.service.NotaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/nota")
public class NotaRestController {

	@Autowired
	private NotaService s;

	@Autowired
	private EstudianteService e;

	@GetMapping("/consultar_notas")
	public ResponseEntity<?> listarNotasDniEstudianteAnio(@RequestParam String dniEstudiante,
			@RequestParam String anio) {
		Collection<Object[]> notas = s.findByDniEstudianteAnio(dniEstudiante, anio);

		if (notas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(MapperUtil.convertCollObjects_NotasMapper(notas), HttpStatus.OK);
	}

	@GetMapping("/anios")
	public ResponseEntity<?> listarAniosPorDniEstudiante(@RequestParam String dniEstudiante) {
		Collection<Object> objs = s.getAniosByDniEstudiante(dniEstudiante);
		Collection<String> fechas = new ArrayList<>();

		for (Object obj : objs) {
			fechas.add(obj.toString());
		}

		return new ResponseEntity<>(fechas, HttpStatus.OK);
	}

	@GetMapping("/buscarDniEstudiante/{dni_Estudiante}")
	public ResponseEntity<?> buscarPorDniEstudiante(@PathVariable String dni_Estudiante) {

		if (e.findByDniEstudiante(dni_Estudiante) != null) {
			Collection<Nota> notaOb = s.findByDniEstudiante(dni_Estudiante);
			Collection<NotaMapper> notaMapper = MapperUtil.convertNotas(notaOb);

			if (notaOb != null) {
				return new ResponseEntity<>(notaMapper, HttpStatus.OK);
			}
		}

		return new ResponseEntity<>("No existe una nota registrada para el dni " + dni_Estudiante + " .",
				HttpStatus.NO_CONTENT);
	}

	@GetMapping("/buscarPorEstudiante/{dni_Estudiante}")
	public ResponseEntity<?> buscarPorEstudiante(@PathVariable String dni_Estudiante) {

		Collection<Map<String, ?>> NotasOb = s.DniEstudiante(dni_Estudiante);

		if (NotasOb != null && !NotasOb.isEmpty()) {
			return new ResponseEntity<>(NotasOb, HttpStatus.OK);
		}

		return new ResponseEntity<>("No existe una nota registrada para el dni " + dni_Estudiante + " .",
				HttpStatus.NO_CONTENT);
	}

	@GetMapping("/buscarNotas/{cursoId}/{seccionId}")
	public ResponseEntity<?> buscarNotasPorCurso(@PathVariable Integer cursoId, @PathVariable Integer seccionId) {

		Collection<Map<String, ?>> NotasOb = s.buscarNotasPorCurso(cursoId, seccionId);
		if (NotasOb != null && !NotasOb.isEmpty()) {
			return new ResponseEntity<>(NotasOb, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PostMapping("/agregar")
	public ResponseEntity<?> nuevaNota(@RequestBody Map<String, Object> nuevaNota) {

		s.registrarNota((Integer.parseInt(nuevaNota.get("seccion_id").toString())),
				(Integer.parseInt(nuevaNota.get("curso_id").toString())), nuevaNota.get("dni_estudiante").toString(),
				(Integer.parseInt(nuevaNota.get("nota1").toString())), nuevaNota.get("fecha").toString());

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/*
	 * @PutMapping("/editar/{notaId}") public ResponseEntity<?> editar(@PathVariable
	 * Integer notaId, @RequestBody Nota newNota) {
	 * 
	 * Nota NotaDb = s.findById(notaId); // NotaMapper NotaMapper =
	 * MapperUtil.convert(NotaDb); Curso curso =
	 * c.findById(newNota.getCurso().getCursoId()); Estudiante estudiante =
	 * e.findByDniEstudiante(newNota.getDniEstudiante().getDniEstudiante());
	 * 
	 * if (NotaDb != null) { NotaDb.setCurso(curso);
	 * NotaDb.setDniEstudiante(estudiante); NotaDb.setNota1(newNota.getNota1());
	 * NotaDb.setNota2(newNota.getNota2()); NotaDb.setNota3(newNota.getNota3());
	 * s.update(NotaDb); return new ResponseEntity<>("La nota con el id " + notaId +
	 * " se actualizó correctamente.", HttpStatus.OK); }
	 * 
	 * return new ResponseEntity<>("Nota con ID: " + notaId + " no existe.",
	 * HttpStatus.NOT_FOUND); }
	 */

	@PutMapping("/editar/{notaId}")
	public ResponseEntity<?> modificarNota(@PathVariable Integer notaId,@RequestBody Map<String, Object> nuevaNota) {
	
				Integer not1, not2, not3 = null;
				String fecha = nuevaNota.get("fecha").toString();
				if(nuevaNota.get("nota1").toString() != "") {
					not1 = Integer.parseInt(nuevaNota.get("nota1").toString()); 
				}else {
					not1 = null;
				}
				
				if(nuevaNota.get("nota2").toString() != "") {
					not2 = Integer.parseInt(nuevaNota.get("nota2").toString()); 
				}else {
					not2 = null;
				}
				
				if(nuevaNota.get("nota3") != null) {
					if(!nuevaNota.get("nota3").toString().isEmpty()) {
					not3 = Integer.parseInt(nuevaNota.get("nota3").toString()); 
					}
				}
				
				s.modificarNota(fecha, not1, not2, not3, notaId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
