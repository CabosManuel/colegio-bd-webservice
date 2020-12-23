package idat.edu.pe.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.service.CursoService;

@RestController
@RequestMapping("rest/curso")
public class CursoRestController {
	
	@Autowired
	private CursoService s;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarCursoPorDniEstudiante(@RequestParam String dniEstudiante){
		Collection<Object[]> objetosCurso = s.findByDniEstudiante(dniEstudiante);
		
		if(objetosCurso.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(MapperUtil.convertCollObjects_CursoMapper(objetosCurso), HttpStatus.OK);
	}
}
