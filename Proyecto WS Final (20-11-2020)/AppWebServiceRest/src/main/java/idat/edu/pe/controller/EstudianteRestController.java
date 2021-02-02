package idat.edu.pe.controller;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.RestController;


import idat.edu.pe.mapper.EstudianteLoginMapper;
import idat.edu.pe.mapper.EstudianteMapper;
import idat.edu.pe.mapper.EstudianteMapper1;
import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.model.Apoderado;
import idat.edu.pe.model.Distrito;
import idat.edu.pe.model.Estudiante;
import idat.edu.pe.service.ApoderadoService;
import idat.edu.pe.service.DistritoService;
import idat.edu.pe.service.EstudianteService;
import idat.edu.pe.service.SeccionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/estudiante")
public class EstudianteRestController {

	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired 
	private DistritoService distritoService;
	
	@Autowired 
	private ApoderadoService apoderadoService;
	
	@Autowired
	private SeccionService SService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		Collection<Estudiante> itemsEstudiante = estudianteService.findAll();
		Collection<EstudianteMapper> itemsEstudianteMapper = MapperUtil.convert(itemsEstudiante);
		
		if(itemsEstudiante.isEmpty()) {
			return new ResponseEntity<>(itemsEstudiante, HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(itemsEstudianteMapper, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{dniEstudiante}")
	public ResponseEntity<?> buscar(@PathVariable String dniEstudiante){
		
		Map<String, ?> estudianteDb = estudianteService.buscarEstudiante(dniEstudiante);
		EstudianteMapper1 estudianteMapper = MapperUtil.convertEstudianteToEstudianteBuscar(estudianteDb);
		
		if(estudianteDb!=null && !estudianteDb.isEmpty()) {
			return new ResponseEntity<>(estudianteMapper, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/buscarCorreo/{correo}")
	public ResponseEntity<?> buscarPorCorreo(@PathVariable String correo){
		
		Estudiante estudianteOb = estudianteService.findByCorreo(correo);
		EstudianteMapper estudianteMapper = MapperUtil.convert(estudianteOb);
		
		if(estudianteOb!=null) {
			return new ResponseEntity<>(estudianteMapper, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/buscarEstudiantes/{seccionId}")
	public ResponseEntity<?> buscarEstudiantesPorSeccion(@PathVariable Integer seccionId){
		
		Collection<Map<String, ?>> estudianteDb = estudianteService.findByEstudiantes(seccionId);
		
		if(estudianteDb!=null) {
			return new ResponseEntity<>(estudianteDb, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/buscarEstudiantesPorCurso/{cursoId}")
	public ResponseEntity<?> buscarEstudiantesPorCurso(@PathVariable Integer cursoId){
		
		Collection<Map<String, ?>> estudianteDb = estudianteService.buscarEstudiantesPorCurso(cursoId);
		
		if(estudianteDb!=null) {
			return new ResponseEntity<>(estudianteDb, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Estudiante estudiante){
		
	    estudiante.setDistrito(distritoService.findById(estudiante.getDistrito().getDistritoId()));
	    estudiante.setApoderado(apoderadoService.findByDniApoderado(estudiante.getApoderado().getDniApoderado()));
		estudianteService.insert(estudiante);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	
	}
	
	@PutMapping("/editar/{dniEstudiante}")
	public ResponseEntity<?> editar(@PathVariable String dniEstudiante, @RequestBody Estudiante newEstudiante){
		
		Estudiante estudianteOb = estudianteService.findByDniEstudiante(dniEstudiante);
		Distrito distrito =distritoService.findById(newEstudiante.getDistrito().getDistritoId());
		
		if(estudianteOb!=null) {
			estudianteOb.setNombre(newEstudiante.getNombre());
			estudianteOb.setApellido(newEstudiante.getApellido());
			estudianteOb.setCelular(newEstudiante.getCelular());
			estudianteOb.setCorreo(newEstudiante.getCorreo());
			estudianteOb.setDireccion(newEstudiante.getDireccion());
			estudianteOb.setDistrito(distrito);
			estudianteOb.setDniEstudiante(newEstudiante.getDniEstudiante());
			estudianteOb.setApoderado(new Apoderado(newEstudiante.getApoderado().getDniApoderado()));
			estudianteOb.setFnacimiento(newEstudiante.getFnacimiento());
			estudianteOb.setPass(newEstudiante.getPass());
			
			estudianteService.update(estudianteOb);
			return new ResponseEntity<>("La estudiante con el dni " + dniEstudiante + " se actualizó correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/desactivar/{dniEstudiante}")
	public ResponseEntity<?> desactivar(@PathVariable String dniEstudiante){
		
		Estudiante estudianteOb = estudianteService.findByDniEstudiante(dniEstudiante);
		if(estudianteOb!=null) {
			if(estudianteOb.getEstado() == false) {
				estudianteOb.setEstado(true);
			}else {
				estudianteOb.setEstado(false);
			}
			
			estudianteService.update(estudianteOb);
			return new ResponseEntity<>("La estudiante con el dni " + dniEstudiante + " se desactivó correctamente.", HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/editar_perfil/{dniEstudiante}")
	public ResponseEntity<?> editarPerfil(@PathVariable String dniEstudiante, @RequestBody Map<String, Object> nuevoEstudianteMap) {
		
		Estudiante estudianteDb = MapperUtil.convertMapToEstudiante(
				estudianteService.findInMapByDniEstudiante(dniEstudiante));

		// Este actualiza en la BD
		estudianteDb.setNombre(nuevoEstudianteMap.get("nombre").toString());
		estudianteDb.setApellido(nuevoEstudianteMap.get("apellido").toString());
		estudianteDb.setFnacimiento(Date.valueOf(nuevoEstudianteMap.get("fnacimiento").toString()));
		estudianteDb.setCelular(nuevoEstudianteMap.get("celular").toString());
		estudianteDb.setCorreo(nuevoEstudianteMap.get("correo").toString());
		estudianteDb.setDireccion(nuevoEstudianteMap.get("direccion").toString());			
		estudianteDb.setDistrito(distritoService.findById((Integer) nuevoEstudianteMap.get("distrito_id")));
		estudianteService.update(estudianteDb);

		// Este estudiante se enviará como respuesta
		EstudianteLoginMapper estudianteRespuesta = 
				MapperUtil.convertEstudianteToEstudianteLoginApoderado(nuevoEstudianteMap);
		
		return new ResponseEntity<>(estudianteRespuesta, HttpStatus.OK);
	}
	
	@GetMapping("/buscar_estudiante/{dniEstudiante}")
	public ResponseEntity<?> buscarEstudiante(@PathVariable String dniEstudiante){
		Map<String, Object> estudianteDb = estudianteService.findInMapByDniEstudiante(dniEstudiante);
		
		if (estudianteDb != null && !estudianteDb.isEmpty()) {
			EstudianteLoginMapper estudiante = MapperUtil.convertEstudianteToEstudianteLogin(estudianteDb);
			estudiante.setApoderado(apoderadoService.findNomApeApoderadoByDniEstudiante(estudiante.getDniEstudiante()));
			return new ResponseEntity<>(estudiante, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
