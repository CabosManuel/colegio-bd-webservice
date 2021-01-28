package idat.edu.pe.service;

import java.util.Collection;
import java.util.Map;

import idat.edu.pe.model.Estudiante;

public interface EstudianteService {

	void insert(Estudiante estudiante);

	void update(Estudiante estudiante);

	Estudiante findById(String dni_Estudiante);

	Collection<Estudiante> findAll();

	Estudiante findByDniEstudiante(String dniEstudiante);

	Estudiante findByCorreo(String correo);	

	Collection<Map<String, ?>> findByDniApoderado(String dniApoderado);

	Map<String, ?> loginEstudiante(String dniEstudiante, String pass);
	
	Map<String, ?> buscarEstudiante(String dniEstudiante);

	Map<String, Object> findInMapByDniEstudiante(String dniEstudiante);
}
