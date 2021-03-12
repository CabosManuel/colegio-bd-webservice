package com.colegio.service;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import com.colegio.model.Justificacion;

public interface JustificacionService {

	void insert(Justificacion justificacion);

	void update(Justificacion justificacion);

	void delete(Integer justificacionId);

	Justificacion findById(Integer justificacionId);

	Collection<Justificacion> findAll();

	Collection<Justificacion> findAllByFtitulo(String titulo);

	Collection<Justificacion> findAllByFdescripcion(String descripcion);

	Collection<Justificacion> findAllByFfecha(Date fecha);

	Collection<Object[]> getJustificacionesByDniEstudiante(String dniEstudiante);

	void registrarJustificacion(String dniEstudiante, String fechaEnvio, String fechaJustificacion, String titulo,
			String descripcion);

	Map<String, Integer> getUltimoId();
}
