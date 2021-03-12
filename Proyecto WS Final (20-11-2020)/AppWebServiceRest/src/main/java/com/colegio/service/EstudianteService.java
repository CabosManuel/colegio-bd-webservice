package com.colegio.service;

import java.util.Collection;
import java.util.Map;

import com.colegio.model.Estudiante;

public interface EstudianteService {

	void insert(Estudiante estudiante);

	void update(Estudiante estudiante);

	Estudiante findById(String dni_Estudiante);

	Collection<Estudiante> findAll();

	Estudiante findByDniEstudiante(String dniEstudiante);

	Map<String, ?> buscarCorreo(String correo);

	Collection<Map<String, ?>> findByDniApoderado(String dniApoderado);

	Map<String, ?> loginEstudiante(String dniEstudiante, String pass);

	Map<String, ?> buscarEstudiante(String dniEstudiante);

	Collection<Map<String, ?>> buscarEstudiantes();

	Map<String, Object> findInMapByDniEstudiante(String dniEstudiante);

	Collection<Map<String, ?>> findByEstudiantes(Integer seccionId);

	Collection<Map<String, ?>> buscarEstudiantesPorCurso(Integer cursoId);

	void modificarEstudiante(String nombre, String apellido, String celular, String fnacimiento, String correo,
			Integer distritoId, String direccion, String dniEstudiante);

	void registrarEstudiante(String dniEstudiante, String nombre, String apellido, String celular, String correo,
			String fnacimiento, String dniApoderado, Integer distritoId, String direccion, String pass,
			String condicion, Boolean estado);

	void cambiarEstudiante(Boolean estado, String dniEstudiante);
}
