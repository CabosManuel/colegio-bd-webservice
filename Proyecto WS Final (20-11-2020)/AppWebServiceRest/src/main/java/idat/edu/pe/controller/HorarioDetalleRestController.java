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

import idat.edu.pe.mapper.HorarioDetalleMapper;
import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.mapper.SeccionMapper;
import idat.edu.pe.model.HorarioCabecera;
import idat.edu.pe.model.HorarioDetalle;
import idat.edu.pe.model.Seccion;
import idat.edu.pe.service.HorarioCabeceraService;
import idat.edu.pe.service.HorarioDetalleService;

@CrossOrigin("*")
@RestController
@RequestMapping("rest/horariodetalle")
public class HorarioDetalleRestController {
	
	@Autowired
	private HorarioCabeceraService hcservice;
	
	@Autowired
	private HorarioDetalleService hdservice;
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody HorarioDetalle horarioDetalle){
		
		horarioDetalle.setHorarioCabecera(hcservice.getfindOneRegister());
		hdservice.insert(horarioDetalle);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	
	}
	
	@GetMapping("/buscar/{seccionId}/{trabajadorId}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer seccionId, @PathVariable Integer trabajadorId){
		
		Collection<HorarioDetalle> horarioDetalleOb = hdservice.getfindBySeccion(seccionId, trabajadorId);
		Collection<HorarioDetalleMapper> horarioDetalleMapper = MapperUtil.convertHorariosD(horarioDetalleOb);
		
		if(horarioDetalleOb!=null) {
			return new ResponseEntity<>(horarioDetalleMapper, HttpStatus.OK);
		}
		return new ResponseEntity<>("Estudiante con el dni " + seccionId + " no existente.", HttpStatus.NOT_FOUND);
		
	}

}
