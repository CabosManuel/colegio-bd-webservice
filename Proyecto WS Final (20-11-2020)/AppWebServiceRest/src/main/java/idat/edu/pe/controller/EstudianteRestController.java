package idat.edu.pe.controller;


import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
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
import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.model.Apoderado;
import idat.edu.pe.model.Distrito;
import idat.edu.pe.model.Estudiante;
import idat.edu.pe.service.ApoderadoService;
import idat.edu.pe.service.DistritoService;
import idat.edu.pe.service.EstudianteService;

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
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		Collection<Map<String, ?>> itemsEstudiante = estudianteService.buscarEstudiantes();
		
		if(!itemsEstudiante.isEmpty() && itemsEstudiante != null) {
			return new ResponseEntity<>(itemsEstudiante, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/buscar/{dniEstudiante}")
	public ResponseEntity<?> buscar(@PathVariable String dniEstudiante){
		
		Map<String, ?> estudianteDb = estudianteService.buscarEstudiante(dniEstudiante);
		//EstudianteMapper1 estudianteMapper = MapperUtil.convertEstudianteToEstudianteBuscar(estudianteDb);
		
		if(estudianteDb!=null && !estudianteDb.isEmpty()) {
			return new ResponseEntity<>(estudianteDb, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/buscarCorreo/{correo}")
	public ResponseEntity<?> buscarPorCorreo(@PathVariable String correo){
		
		Map<String, ?> estudianteOb = estudianteService.buscarCorreo(correo);
		
		if(estudianteOb!=null && !estudianteOb.isEmpty()) {
			return new ResponseEntity<>(estudianteOb, HttpStatus.OK);
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
	public ResponseEntity<?> nuevaEstudiante(@RequestBody Map<String, Object> nuevaE) {

		estudianteService.registrarEstudiante(
				nuevaE.get("dni_estudiante").toString(),
				nuevaE.get("nombre").toString(),
				nuevaE.get("apellido").toString(),
				nuevaE.get("celular").toString(),
				nuevaE.get("correo").toString(),
				nuevaE.get("fnacimiento").toString(),
				nuevaE.get("dni_apoderado").toString(),
				(Integer.parseInt(nuevaE.get("distrito_id").toString())),
				nuevaE.get("direccion").toString(),
				nuevaE.get("pass").toString(),
				nuevaE.get("condicion").toString(),
				(Boolean.parseBoolean(nuevaE.get("estado").toString())));

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	
	@PutMapping("/editar/{dniEstudiante}")
	public ResponseEntity<?> modificarEstudiante(@PathVariable String dniEstudiante,@RequestBody Map<String, Object> nuevaE) {
	
		estudianteService.modificarEstudiante(
				nuevaE.get("nombre").toString(),
				nuevaE.get("apellido").toString(),
				nuevaE.get("celular").toString(),
				nuevaE.get("fnacimiento").toString(),
				nuevaE.get("correo").toString(),
				Integer.parseInt(nuevaE.get("distrito_id").toString()),
				nuevaE.get("direccion").toString(),
				dniEstudiante
				);
				
		EstudianteLoginMapper estudianteRespuesta = 
				MapperUtil.convertEstudianteToEstudianteLoginApoderado(nuevaE);
		
		return new ResponseEntity<>(estudianteRespuesta, HttpStatus.OK);
	}
	
	@PutMapping("/desactivar/{dniEstudiante}")
	public ResponseEntity<?> DesactivarEstudiante(@PathVariable String dniEstudiante, @RequestBody Map<String, Object> nuevaE) {
		
		estudianteService.cambiarEstudiante(Boolean.parseBoolean(nuevaE.get("estado").toString()), dniEstudiante);
				
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/*@PutMapping("/editar_perfil/{dniEstudiante}")
	public ResponseEntity<?> editarPerfil(@PathVariable String dniEstudiante, @RequestBody Map<String, Object> nuevoEstudianteMap) {
		
		Estudiante estudianteDb = MapperUtil.convertMapToEstudiante(
				estudianteService.findInMapByDniEstudiante(dniEstudiante));

		// Este actualiza en la BD
		estudianteDb.setNombre(nuevoEstudianteMap.get("nombre").toString());
		estudianteDb.setApellido(nuevoEstudianteMap.get("apellido").toString());
		estudianteDb.setFnacimiento(java.sql.Date.valueOf(nuevoEstudianteMap.get("fnacimiento").toString()));
		estudianteDb.setCelular(nuevoEstudianteMap.get("celular").toString());
		estudianteDb.setCorreo(nuevoEstudianteMap.get("correo").toString());
		estudianteDb.setDireccion(nuevoEstudianteMap.get("direccion").toString());			
		estudianteDb.setDistrito(distritoService.findById((Integer) nuevoEstudianteMap.get("distrito_id")));
		estudianteService.update(estudianteDb);

		// Este estudiante se enviará como respuesta
		EstudianteLoginMapper estudianteRespuesta = 
				MapperUtil.convertEstudianteToEstudianteLoginApoderado(nuevoEstudianteMap);
		
		return new ResponseEntity<>(estudianteRespuesta, HttpStatus.OK);
	}*/
	
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
