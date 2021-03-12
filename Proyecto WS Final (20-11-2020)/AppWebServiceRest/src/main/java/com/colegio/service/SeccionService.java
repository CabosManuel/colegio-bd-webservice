package com.colegio.service;

import java.util.Collection;
import java.util.Map;

import com.colegio.model.Seccion;

public interface SeccionService {

	void insert(Seccion seccion);

	void update(Seccion seccion);

	void delete(Integer seccionId);

	Seccion findById(Integer seccionId);

	Collection<Seccion> findAll();

	Collection<Map<String, ?>> findByGrado(Integer gradoId);

	Collection<Map<String, ?>> getfindByNivel(Integer nivelId);

	Map<String, ?> buscarSeccion(Integer seccionId);
}
