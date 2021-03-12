package com.colegio.controller;

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

import com.colegio.mapper.HorarioCabeceraMapper;
import com.colegio.mapper.MapperUtil;
import com.colegio.model.HorarioCabecera;
import com.colegio.service.HorarioCabeceraService;

@CrossOrigin("*")
@RestController
@RequestMapping("/horariocabecera")
public class HorarioCabeceraRestController {
	
	@Autowired
	private HorarioCabeceraService hcservice;
	
	@GetMapping("/buscar/{horarioCabeceraId}")
	public ResponseEntity<?> buscar(@PathVariable Integer horarioCabeceraId){
		
		
		HorarioCabecera horarioOb = hcservice.findById(horarioCabeceraId);
		HorarioCabeceraMapper horarioMapper = MapperUtil.convertHorarioCabeceraId(horarioOb);
		
		if(horarioOb!=null) {
			return new ResponseEntity<>(horarioMapper, HttpStatus.OK);
		}
		return new ResponseEntity<>("Estudiante con el dni " + horarioCabeceraId + " no existente.", HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody HorarioCabecera horarioCabecera){
		
		hcservice.insert(horarioCabecera);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	
	}

}
