package idat.edu.pe.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.apache.tomcat.jni.Time;
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

import idat.edu.pe.mapper.AsistenciaMapper;
import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.model.Apoderado;
import idat.edu.pe.model.Asistencia;
import idat.edu.pe.model.Distrito;
import idat.edu.pe.model.Estudiante;
import idat.edu.pe.service.AsistenciaService;
import idat.edu.pe.service.EstudianteService;
import idat.edu.pe.service.HorarioDetalleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/asistencia")
public class AsistenciaRestController {
	
	@Autowired
	private AsistenciaService s;
	
	@Autowired
	private HorarioDetalleService hds;
	
	@Autowired
	private EstudianteService es;
	
	@GetMapping("/consultar_asistencias_antiguo")
	public ResponseEntity<?> listarAsistenciasMes(@RequestParam String dniEstudiante, @RequestParam String fecha){
		Collection<Object[]> asistencias = s.getAsistenciasByDniEstudianteFecha(dniEstudiante, fecha);
				
		if(asistencias.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(MapperUtil.convertCollObjects_AsistenciaMapper(asistencias),HttpStatus.OK);
	}
	
	
	@GetMapping("/consultar_asistencias")
	public ResponseEntity<?> listarAsistenciasPorDniEstudianteMesCurso(@RequestParam String dniEstudiante, @RequestParam Integer mes, 
			@RequestParam String cursoId){
		Collection<Object[]> asistencias = s.getAsistenciasByDniEstudianteMesCurso(dniEstudiante, mes, cursoId);
		
		if(asistencias.isEmpty()) {
			return new ResponseEntity<>("No hay asistencias",HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(MapperUtil.convertCollObjects_AsistenciaMapper(asistencias),HttpStatus.OK);
	}
	
	@GetMapping("/meses")
	public ResponseEntity<?> listarMesesPorDniEstudiante(@RequestParam String dniEstudiante){
		Collection<Object> objs = s.getMesesByDniEstudiante(dniEstudiante);
		Collection<Integer> meses = new ArrayList<>();
		
		for(Object obj:objs) {
			meses.add((Integer)obj);
		}
		
		return new ResponseEntity<>(meses,HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Asistencia asistencia){
		
	    asistencia.setHorarioDetalleId(hds.findById(asistencia.getHorarioDetalleId().getHorarioDetalleId()));
	    asistencia.setDniEstudiante(es.findByDniEstudiante(asistencia.getDniEstudiante().getDniEstudiante()));
		s.insert(asistencia);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	
	}
	
	@GetMapping("/buscar/{horarioDetalleId}")
	public ResponseEntity<?> buscarAsistenciaPorHorario(@PathVariable Integer horarioDetalleId){
		Collection<Map<String, ?>> asistenciasOb = s.buscarPorHorario(horarioDetalleId);
		
		if(asistenciasOb != null && !asistenciasOb.isEmpty()) {
			return new ResponseEntity<>(asistenciasOb,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/editar/{asistenciaId}")
	public ResponseEntity<?> editar(@PathVariable Integer asistenciaId, @RequestBody Asistencia newAsistencia){
		
		Map<String,?> asistenciaOb = s.buscarPorId(asistenciaId);
		Asistencia asistenciaC = MapperUtil.convert(asistenciaOb);
		
		LocalDate hoy = LocalDate.now();
		LocalTime ahora = LocalTime.now();
		
		if(asistenciaOb!=null) {
			asistenciaC.setAsistencia(LocalDateTime.of(hoy, ahora));
			asistenciaC.setEstado(newAsistencia.getEstado());

			s.update(asistenciaC);
			return new ResponseEntity<>("Se actualizó correctamente.",HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
