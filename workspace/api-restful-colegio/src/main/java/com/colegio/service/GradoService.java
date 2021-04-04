package com.colegio.service;

import java.util.Collection;
import java.util.Map;

import com.colegio.model.Grado;

public interface GradoService {

	void insert(Grado grado);

	void update(Grado grado);

	void delete(Integer gradoId);

	Grado findById(Integer gradoId);

	Collection<Grado> findAll();

	Collection<Grado> findByNivel(Integer nivelId);

	Collection<Grado> getfindByNivel(Integer nivelId);

	Map<String, ?> buscarGrado(Integer gradoId);

}
