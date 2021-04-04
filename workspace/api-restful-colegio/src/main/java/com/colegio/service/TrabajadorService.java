package com.colegio.service;

import java.util.Collection;
import java.util.Map;

import com.colegio.model.Trabajador;

public interface TrabajadorService {
	void insert(Trabajador trabajador);

	void update(Trabajador trabajador);

	void delete(Integer trabajadorId);

	Trabajador findById(Integer trabajadorId);

	Collection<Trabajador> findAll();

	Collection<Map<String, Object>> getfindByCurso(Integer cursoId);

	Trabajador getfindByCorreoPass(String correo, String pass);

	Collection<Map<String, ?>> getfindByDniEstudiante(String dniEstudiante);

	Collection<Map<String, ?>> seleccionarCursos(Integer trabajadorId);

	Map<String, ?> obtenerPorCorreoPass(String correo, String pass);

	Trabajador findByUsername(String username);

	Map<String, ?> buscarTrabajador(String dniApoderado);

	Collection<Map<String, ?>> buscarTrabajadores();

	void cambiarTrabajador(Boolean estado, String dni);

	void registrarTrabajador(String dni, String nombre, String apellido, String celular, String correo,
			String fnacimiento, Integer distrito_id, String direccion, String pass, Boolean estado, String cargo,
			String sexo);
}
