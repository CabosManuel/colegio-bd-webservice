package idat.edu.pe.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.service.NotaService;

@RestController
@RequestMapping("/rest/nota")
public class NotaRestController {
	
	@Autowired
	private NotaService s;
	
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
}