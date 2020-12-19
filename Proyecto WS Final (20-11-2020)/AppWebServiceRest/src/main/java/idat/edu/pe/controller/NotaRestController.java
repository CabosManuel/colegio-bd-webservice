package idat.edu.pe.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.mapper.NotaMapper;
import idat.edu.pe.service.NotaService;

@RestController
@RequestMapping("/rest/nota")
public class NotaRestController {
	
	@Autowired
	private NotaService s;
	
	@GetMapping("/consultar_notas")					//@RequestParam	
	public ResponseEntity<?> listarNotasDniEstudianteAnio(@RequestParam String dniEstudiante, @RequestParam String anio){
		Collection</*NotaMapper*/Object[]> notas = s.findByDniEstudianteAnio(dniEstudiante, anio);
		
		if(notas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(MapperUtil.convertCollObjects_NotasMapper(notas),HttpStatus.OK);
	}
}
