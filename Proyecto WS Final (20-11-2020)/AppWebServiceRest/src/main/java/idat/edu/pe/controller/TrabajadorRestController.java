package idat.edu.pe.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.mapper.TrabajadorMapper;
import idat.edu.pe.model.Trabajador;
import idat.edu.pe.service.DistritoService;
import idat.edu.pe.service.TrabajadorService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/trabajador")
public class TrabajadorRestController {

	@Autowired
	private TrabajadorService serviceT;
	
	private DistritoService serviceD;

	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		Collection<Trabajador> trabajadores = serviceT.findAll();
		Collection<TrabajadorMapper> trabajadoresmapper = MapperUtil.convertTrabajadores(trabajadores);
		
		if(trabajadores.isEmpty()) {
			return new ResponseEntity<>("No hay trabajadores registrados.",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(trabajadoresmapper, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{trabajadorId}")
	public ResponseEntity<?> buscar(@PathVariable Integer trabajadorId){
		Trabajador trabajador = serviceT.findById(trabajadorId);
		
		if(trabajador != null) {
			return new ResponseEntity<>(trabajador,HttpStatus.OK);
		}		
		return new ResponseEntity<>("Trabajador con ID: "+trabajadorId+" no existe.",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/validar/{correo}/{pass}")
	public ResponseEntity<?> validar(@PathVariable String correo, @PathVariable String pass){
		Trabajador trabajador = serviceT.getfindByCorreoPass(correo, pass);
		TrabajadorMapper trabajadorMapper = MapperUtil.convert(trabajador);
		
		if(trabajador != null) {
			return new ResponseEntity<>(trabajadorMapper,HttpStatus.OK);
		}		
		return new ResponseEntity<>("Trabajador con esos parámetros no existe.", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscarPorCurso/{cursoId}")
	public ResponseEntity<?> buscarPorCurso(@PathVariable Integer cursoId){
		Collection<Trabajador> trabajador = serviceT.getfindByCurso(cursoId);
		Collection<TrabajadorMapper> trabajadorMapper = MapperUtil.convertTrabajadoresPorCurso(trabajador);
		
		if(trabajador != null) {
			return new ResponseEntity<>(trabajadorMapper,HttpStatus.OK);
		}		
		return new ResponseEntity<>("Curso con ID: "+ cursoId +" no existe.",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscarCursos/{trabajadorId}")
	public ResponseEntity<?> buscarCursos(@PathVariable Integer trabajadorId){
		Collection<Map<String, ?>> trabajador = serviceT.seleccionarCursos(trabajadorId);
		
		if(trabajador != null && !trabajador.isEmpty()) {
			return new ResponseEntity<>(trabajador,HttpStatus.OK);
		}		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Trabajador trabajador){
		trabajador.setDistrito(serviceD.findById(trabajador.getDistrito().getDistritoId()));
	    serviceT.insert(trabajador);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{trabajadorId}")
	public ResponseEntity<?> editar(@PathVariable Integer trabajadorId, @RequestBody Trabajador newTrabajador){
		Trabajador trabajadorDb = serviceT.findById(trabajadorId);
		
		if(trabajadorDb!=null) {
			trabajadorDb.setNombres(newTrabajador.getNombres());
			trabajadorDb.setApellidos(newTrabajador.getApellidos());
			trabajadorDb.setCargo(newTrabajador.getCargo());
			trabajadorDb.setDni(newTrabajador.getDni());
			trabajadorDb.setDistrito(newTrabajador.getDistrito());
			trabajadorDb.setDireccion(newTrabajador.getDireccion());
			trabajadorDb.setCelular(newTrabajador.getCelular());
			trabajadorDb.setCorreo(newTrabajador.getCorreo());
			trabajadorDb.setPass(newTrabajador.getPass());
			trabajadorDb.setFechaNacimiento(newTrabajador.getFechaNacimiento());
			
			serviceT.update(trabajadorDb);
			return new ResponseEntity<>(trabajadorDb,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("Trabajador con ID: "+trabajadorId+" no existe.",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/eliminar/{trabajadorId}")
	public ResponseEntity<?> eliminar(@PathVariable Integer trabajadorId){
		
		Trabajador trabajadorDb = serviceT.findById(trabajadorId);
		if(trabajadorDb != null) {
			serviceT.delete(trabajadorId);
			return new ResponseEntity<>("Trabajador eliminado.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Trabajador con ID: "+trabajadorId+" no existe.",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/listar_docentes")
	public ResponseEntity<?> buscarPorDniEstudiante(@RequestParam String dniEstudiante){
		
		Collection<Map<String,?>> docentes = serviceT.getfindByDniEstudiante(dniEstudiante);
		if(docentes.isEmpty() || docentes == null) {
			return new ResponseEntity<>("No existe dni estudiante.", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(docentes, HttpStatus.OK);
	}
}
