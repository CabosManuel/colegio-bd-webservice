package com.colegio.service;

import java.util.Collection;
import java.util.Map;

import com.colegio.model.Curso;

public interface CursoService {
	Curso findById(Integer cursoId);

	Curso findByIdCurso(Integer cursoId);

	Collection<Object[]> findByDniEstudiante(String dniEstudiante);

	Collection<Map<String, Object>> buscarPorNivelGrado(Integer nivelId, Integer gradoId);

	Map<String, ?> findByCursoId(Integer cursoId);
}
