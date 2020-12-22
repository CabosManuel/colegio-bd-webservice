package idat.edu.pe.controller;

import java.util.Collection;

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

import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.mapper.MatriculaMapper;
import idat.edu.pe.model.Grado;
import idat.edu.pe.model.Matricula;
import idat.edu.pe.model.Nivel;
import idat.edu.pe.service.EstudianteService;
import idat.edu.pe.service.GradoService;
import idat.edu.pe.service.MatriculaService;
import idat.edu.pe.service.NivelService;
import idat.edu.pe.service.SeccionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/matriculas")
public class MatriculaRestController {
	
	@Autowired
	private MatriculaService service;
	
	@Autowired
	private GradoService gservice;
	
	@Autowired
	private NivelService nservice;
	
	@Autowired
	private SeccionService sservice;
	
	@Autowired
	private EstudianteService eservice;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		Collection<Matricula> itemMatricula = service.findAll();
		if(itemMatricula.isEmpty()) {
			return new ResponseEntity<>(itemMatricula, HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(itemMatricula, HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Matricula matricula){
		
		matricula.setEstudiante(eservice.findById(matricula.getEstudiante().getDniEstudiante()));
	    matricula.setSeccion(sservice.findById(matricula.getSeccion().getSeccionId()));
		service.insert(matricula);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	
	}
	
	@GetMapping("/buscarEstudiante/{dniEstudiante}")
	public ResponseEntity<?> BuscarEstudiante(@PathVariable String dniEstudiante){
		
		Matricula matriculaOb = service.findByEstudiante(dniEstudiante);
		MatriculaMapper matriculaMapper = MapperUtil.convert(matriculaOb);
		Collection<Nivel> niveles = nservice.findAll();
		Collection<Grado> grados = gservice.findByNivel(matriculaMapper.getNivel());
		
		for(Nivel nivel: niveles) {
			if(nivel.getNivelId() == matriculaMapper.getNivel()) {
				matriculaMapper.setNivel(nivel.getNivelId());
				matriculaMapper.setNombrenivel(nivel.getNombre());
			}
		}
		for(Grado grado: grados) {
			Grado g = new Grado();
			if(grado.getGradoId() == matriculaMapper.getGrado()) {
				matriculaMapper.setGrado(grado.getGradoId());
				matriculaMapper.setNombregrado(grado.getNombre());
			}
		}
		
		if(matriculaOb != null) {
			return new ResponseEntity<>(matriculaMapper, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("La estudiante con el dni " + dniEstudiante + " no se encuentra matriculada.", HttpStatus.NO_CONTENT);
	}
	

}
