package idat.edu.pe.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.mapper.AsistenciaMapper;
import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.service.AsistenciaService;

@RestController
@RequestMapping("/rest/asistencia")
public class AsistenciaRestController {
	
	@Autowired
	private AsistenciaService s;
	
	@GetMapping("/consultar_asistencias")
	public ResponseEntity<?> listarAsistenciasMes(@RequestParam String dniEstudiante, @RequestParam String fecha){
		Collection<Object[]> asistencias = s.getAsistenciasByDniEstudianteFecha(dniEstudiante, fecha);
		
		System.out.println("primera fecha: "+asistencias);
		
		if(asistencias.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(MapperUtil.convertCollObjects_AsistenciaMapper(asistencias),HttpStatus.OK);
	}
}
