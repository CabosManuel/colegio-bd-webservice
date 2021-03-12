package com.colegio.controller;

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

import com.colegio.mapper.HorarioDetalleMapper;
import com.colegio.mapper.MapperUtil;
import com.colegio.service.HorarioCabeceraService;
import com.colegio.service.HorarioDetalleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/horariodetalle")
public class HorarioDetalleRestController {
	
	@Autowired
	private HorarioCabeceraService hcservice;
	
	@Autowired
	private HorarioDetalleService hdservice;
	
	@PostMapping("/agregar")
	public ResponseEntity<?> nuevaM(@RequestBody Map<String, Object> nuevaM) {

		Map<String, ?> idHorario = hcservice.getfindOneRegister();
		System.out.println(idHorario);
		System.out.println(idHorario.get("horario_cabecera_id").toString());
		
		hdservice.registrarHorarioDetalle(
				nuevaM.get("dia").toString(),
				nuevaM.get("hora_fin").toString(),
				nuevaM.get("hora_inicio").toString(),
				nuevaM.get("curso_id").toString(),
				nuevaM.get("trabajador_id").toString(),
				idHorario.get("horario_cabecera_id").toString());

		return new ResponseEntity<>(HttpStatus.CREATED);
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
	
	@PutMapping("/editar/{horario_detalle_id}")
	public ResponseEntity<?> modificarHorarioDetalle(@PathVariable Integer horario_detalle_id,@RequestBody Map<String, Object> nuevaE) {
	
		hdservice.modificarHorarioDetalle(
				nuevaE.get("dia").toString(),
				nuevaE.get("hora_fin").toString(),
				nuevaE.get("hora_inicio").toString(),
				nuevaE.get("curso_id").toString(),
				nuevaE.get("trabajador_id").toString(),
				horario_detalle_id
				);
				
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
}
