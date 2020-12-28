package idat.edu.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.service.CursoService;
import idat.edu.pe.service.TrabajadorService;

@CrossOrigin("*")
@RestController
@RequestMapping("rest/trabajadorcurso")
public class TrabajadorCursoRestController {

	@Autowired
	private CursoService cservice;
	
	@Autowired
	private TrabajadorService tservice;
	
	
}
