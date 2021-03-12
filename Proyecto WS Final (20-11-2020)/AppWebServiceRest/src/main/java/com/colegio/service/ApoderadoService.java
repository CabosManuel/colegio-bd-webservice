package com.colegio.service;

import java.util.Collection;
import java.util.Map;

import com.colegio.model.Apoderado;

public interface ApoderadoService {

	void insert(Apoderado apoderado);

	void update(Apoderado apoderado);

	Collection<Apoderado> findAll();

	Apoderado findByDniApoderado(String dniApoderado);

	Collection<Object[]> getNombreEstudiantesByDniApoderado(String dniApoderado);

	Map<String, ?> loginApoderado(String dniApoderado, String pass);

	String findNomApeApoderadoByDniEstudiante(String dniEstudiante);

	Map<String, ?> buscarPorCorreo(String correo);

	Map<String, ?> buscarPorDniApoderado(String dniApoderado);

	void nuevoApoderado(Map<String, Object> apoderado);

	Collection<Map<String, ?>> buscarApoderados();

	Map<String, ?> buscarApoderado(String dniApoderado);

	void cambiarApoderado(Boolean estado, String dniApoderado);

	void modificarApoderado(String nombre, String apellido, String celular, String correo, Integer distritoId,
			String direccion, String dniApoderado);
}
