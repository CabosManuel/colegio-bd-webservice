package idat.edu.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.model.HorarioCabecera;
import idat.edu.pe.model.HorarioDetalle;
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
	/**/

}
