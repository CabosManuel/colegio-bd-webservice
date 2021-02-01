package idat.edu.pe.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.mapper.ApoderadoMapper;
import idat.edu.pe.mapper.CursoMapper;
import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.model.Apoderado;
import idat.edu.pe.model.Curso;
import idat.edu.pe.service.CursoService;

@CrossOrigin("*")
@RestController
@RequestMapping("rest/curso")
public class CursoRestController {
	
	@Autowired
	private CursoService s;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarCursoPorDniEstudiante(@RequestParam String dniEstudiante){
		Collection<Object[]> objetosCurso = s.findByDniEstudiante(dniEstudiante);
		
		if(objetosCurso.isEmpty()) {
			return new ResponseEntity<>("No hay cursos",HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(MapperUtil.convertCollObjects_CursoMapper(objetosCurso), HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{nivelId}/{gradoId}")
	public ResponseEntity<?> buscar(@PathVariable Integer nivelId, @PathVariable Integer gradoId){
		
		Collection<Curso> cursoOb = s.getfindByNivelGrado(nivelId, gradoId);
		Collection<CursoMapper> cursoMapper = MapperUtil.convertCursosPorNivelGrado(cursoOb);
		
		if(cursoOb!=null) {
			return new ResponseEntity<>(cursoMapper, HttpStatus.OK);
		}
		return new ResponseEntity<>("No existen cursos para el nivel " + nivelId + " y grado " + gradoId+ "." , HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/buscarCurso/{cursoId}")
	public ResponseEntity<?> buscar(@PathVariable Integer cursoId){
		
		Map<String, ?> curso = s.findByCursoId(cursoId);
		
		if(curso!=null) {
			return new ResponseEntity<>(curso, HttpStatus.OK);
		}
		return new ResponseEntity<>("No existen cursos para el id " + cursoId, HttpStatus.NOT_FOUND);
		
	}
}
