package com.colegio.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.mapper.EstudianteLoginMapper;
import com.colegio.mapper.MapperUtil;
import com.colegio.service.ApoderadoService;
import com.colegio.service.EstudianteService;

@RestController
@RequestMapping("")
public class LoginController {

	@Autowired
	ApoderadoService apoderadoService;

	@Autowired
	EstudianteService estudianteService;

//	@PostMapping("/login")
//	public ResponseEntity<?> LoginTest(@RequestBody Map<String, String> usuario) {
//		String dni = usuario.get("dni");
//		String pass = usuario.get("pass");	
//		
//		Map<String, Object> respuesta = new HashMap<>();
//		respuesta.put("rpta", false);
//		respuesta.put("mensaje", "DNI y/o contraseña incorrectas.");
//		
//		Map<String, ?> apoderadoDb = apoderadoService.loginApoderado(dni, pass);
//		
//		if(apoderadoDb != null && !apoderadoDb.isEmpty()) {
//			ApoderadoLoginMapper apoderado = MapperUtil.convertApoderadoToApoderadoLogin(apoderadoDb);
//			apoderado.setEstudiantes(estudianteService.findByDniApoderado(apoderado.getDniApoderado()));
//			
//			respuesta.put("rpta", true);
//			respuesta.put("mensaje", "¡Bienvenido(a) " + apoderado.getNombre() + "!");
//			respuesta.put("apoderado", apoderado);
//			respuesta.put("tipo", "apoderado");
//			
//			return new ResponseEntity<>(respuesta, HttpStatus.OK);
//		} else {
//			Map<String, ?> estudianteDb = estudianteService.loginEstudiante(dni, pass);
//			if (estudianteDb != null && !estudianteDb.isEmpty()) {
//				EstudianteLoginMapper estudiante = MapperUtil.convertEstudianteToEstudianteLogin(estudianteDb);
//				estudiante.setApoderado(apoderadoService.findNomApeApoderadoByDniEstudiante(estudiante.getDniEstudiante()));
//				
//				respuesta.put("rpta", true);
//				respuesta.put("mensaje", "¡Bienvenida " + estudiante.getNombre() + "!");
//				respuesta.put("estudiante", estudiante);
//				respuesta.put("tipo", "estudiante");
//				
//				return new ResponseEntity<>(respuesta, HttpStatus.OK);
//			}
//		}
//		
//		return new ResponseEntity<>(respuesta, HttpStatus.OK);
//	}
}
