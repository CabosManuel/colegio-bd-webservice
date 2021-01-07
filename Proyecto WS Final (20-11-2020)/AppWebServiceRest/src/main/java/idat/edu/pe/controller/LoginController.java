package idat.edu.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.status.Status;
import idat.edu.pe.mapper.ApoderadoRespuestaMapper;
import idat.edu.pe.mapper.EstudianteRespuestaMapper;
import idat.edu.pe.mapper.MapperUtil;
import idat.edu.pe.model.Apoderado;
import idat.edu.pe.model.Estudiante;
import idat.edu.pe.service.ApoderadoService;
import idat.edu.pe.service.EstudianteService;

@RestController
@RequestMapping("/rest")
public class LoginController {
	
	@Autowired
	ApoderadoService apoderadoService;

	@Autowired
	EstudianteService estudianteService;
	
	@PostMapping("/login")
	public ResponseEntity<?> Login(@RequestBody Login usuario){
		String dni = usuario.getDni();
		String pass = usuario.getPass();
		
		Apoderado apoderado = apoderadoService.findByDniApoderadoAndPass(dni, pass);
		Estudiante estudiante = estudianteService.findByDniEstudianteAndPass(dni, pass);
		
		ApoderadoRespuestaMapper respuestaA = new ApoderadoRespuestaMapper();
		respuestaA.setRpta(false);
		respuestaA.setMensaje("DNI y/o contraseña incorrectas.");
		
		if(apoderado!=null) {
			respuestaA = MapperUtil.convertApoderadoToRespuesta(apoderado);
			respuestaA.setRpta(true);
			respuestaA.setTipo("apoderado");
			respuestaA.setMensaje("¡Bienvenido(a) "+respuestaA.getApoderado().getNombre()+"!");
			
			return new ResponseEntity<>(respuestaA,HttpStatus.OK);
		}else if(estudiante!=null){
			EstudianteRespuestaMapper respuestaE = MapperUtil.convertEstudianteToRespuesta(estudiante);
			respuestaE.setRpta(true);
			respuestaE.setTipo("estudiante");
			respuestaE.setMensaje("¡Bienvenida "+respuestaE.getEstudiante().getNombre()+"!");
			
			return new ResponseEntity<>(respuestaE,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(respuestaA, HttpStatus.OK);
	}

	// Clase interna para recibir dni y contraseña en formato JSON del login
	static class Login {
		private String dni;
		private String pass;

		public Login(String dni, String pass) {
			this.dni = dni;
			this.pass = pass;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}
		
	}
}
