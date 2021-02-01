package idat.edu.pe.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.mapper.HorarioDetalleMapper;
import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.model.Apoderado;
import idat.edu.pe.model.Curso;
import idat.edu.pe.model.Distrito;
import idat.edu.pe.model.Estudiante;
import idat.edu.pe.model.HorarioDetalle;
import idat.edu.pe.model.Trabajador;
import idat.edu.pe.service.CursoService;
import idat.edu.pe.service.HorarioCabeceraService;
import idat.edu.pe.service.HorarioDetalleService;
import idat.edu.pe.service.TrabajadorService;

@CrossOrigin("*")
@RestController
@RequestMapping("rest/horariodetalle")
public class HorarioDetalleRestController {
	
	@Autowired
	private HorarioCabeceraService hcservice;
	
	@Autowired
	private HorarioDetalleService hdservice;
	
	@Autowired
	private CursoService cservice;
	
	@Autowired
	private TrabajadorService tservice;
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody HorarioDetalle horarioDetalle){
		
		horarioDetalle.setHorarioCabecera(hcservice.getfindOneRegister());
		hdservice.insert(horarioDetalle);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	
	}

	@GetMapping("/buscar/{seccionId}/{trabajadorId}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer seccionId, @PathVariable Integer trabajadorId){
		
		Collection<Map<String, ?>> horarioDetalleOb = hdservice.getfindBySeccion(seccionId, trabajadorId);
		Collection<HorarioDetalleMapper> horarioDetalleMapper = MapperUtil.convertDetalleHorario(horarioDetalleOb);
		
		if(horarioDetalleOb!=null && !horarioDetalleOb.isEmpty()) {
			return new ResponseEntity<>(horarioDetalleMapper, HttpStatus.OK);
		}
		return new ResponseEntity<>("Horario con el dni " + seccionId + " no existente.", HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/buscarHorarioDetalle/{seccionId}")
	public ResponseEntity<?> buscarHorarioPorSeccion(@PathVariable Integer seccionId){
		
		Collection<Map<String, ?>> horarioDetalleOb = hdservice.buscarHorarioPorSeccion(seccionId);
		
		if(horarioDetalleOb!=null && !horarioDetalleOb.isEmpty()) {
			return new ResponseEntity<>(horarioDetalleOb, HttpStatus.OK);
		}
		return new ResponseEntity<>("Horario con la seccion con el ID " + seccionId + " no existente.", HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/consultar_horario")
	public ResponseEntity<?> buscarHorarioPorDniEstudiante(@RequestParam String dniEstudiante){
		
		Collection<Map<String,?>> horario = hdservice.findHorarioByDni(dniEstudiante);
		if(horario.isEmpty() || horario == null) {
			return new ResponseEntity<>("No existe horario.", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(horario, HttpStatus.OK);
	}
	
	@PutMapping("/editar/{horarioDetalleId}")
	public ResponseEntity<?> editar(@PathVariable Integer horarioDetalleId, @RequestBody HorarioDetalle newHorarioDetalle){
		
		HorarioDetalle horarioDetalleOb = hdservice.findById(horarioDetalleId);
		Curso curso = cservice.findById(newHorarioDetalle.getCurso().getCursoId());
		Trabajador trabajador = tservice.findById(newHorarioDetalle.getTrabajador().getTrabajadorId());
		
		if(horarioDetalleOb !=null) {
			horarioDetalleOb.setDia(newHorarioDetalle.getDia());
			horarioDetalleOb.setHoraInicio(newHorarioDetalle.getHoraInicio());
			horarioDetalleOb.setHoraFin(newHorarioDetalle.getHoraFin());
			horarioDetalleOb.setCurso(curso);
			horarioDetalleOb.setTrabajador(trabajador);
			
			hdservice.update(horarioDetalleOb);
			return new ResponseEntity<>("Horario con el ID " + horarioDetalleId + " se actualizó correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	
}
