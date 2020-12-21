package idat.edu.pe.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.mapper.EstudianteMapper;
import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.mapper.NotaMapper;
import idat.edu.pe.model.Estudiante;
import idat.edu.pe.model.Nota;
import idat.edu.pe.service.EstudianteService;
import idat.edu.pe.service.NotaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/nota")
public class NotaRestController {
	
	@Autowired
	private NotaService s;
	
	@Autowired
	private EstudianteService es;
	
	@GetMapping("/consultar_notas")	
	public ResponseEntity<?> listarNotasDniEstudianteAnio(@RequestParam String dniEstudiante, @RequestParam String anio){
		Collection<Object[]> notas = s.findByDniEstudianteAnio(dniEstudiante, anio);
		
		if(notas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(MapperUtil.convertCollObjects_NotasMapper(notas),HttpStatus.OK);
	}
	
	@GetMapping("/anios")
	public ResponseEntity<?> listarAniosPorDniEstudiante(@RequestParam String dniEstudiante){
		Collection<Object> objs = s.getAniosByDniEstudiante(dniEstudiante);
		Collection<String> fechas = new ArrayList<>();
		
		for(Object obj:objs) {
			fechas.add(obj.toString());
		}
		
		return new ResponseEntity<>(fechas,HttpStatus.OK);
	}
	
	@GetMapping("/buscarDniEstudiante/{dni_Estudiante}")
	public ResponseEntity<?> buscarPorDniEstudiante(@PathVariable String dni_Estudiante){
		
		if(es.findByDniEstudiante(dni_Estudiante) != null) {
			Collection<Nota> notaOb = s.findByDniEstudiante(dni_Estudiante);
			Collection<NotaMapper> notaMapper = MapperUtil.convertNotas(notaOb);
			
			if(notaOb!=null) {
				return new ResponseEntity<>(notaMapper, HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<>("No existe una nota registrada para el dni " + dni_Estudiante + " .",HttpStatus.NO_CONTENT);
	}
}
