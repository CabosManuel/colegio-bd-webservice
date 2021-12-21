package com.colegio.service;

import java.util.Collection;
import java.util.Map;

import com.colegio.model.Notas;

public interface NotaService {
	public Collection<Object[]> findByDniEstudianteAnio(String dniEstudiante, String anio);

	public Collection<Object> getAniosByDniEstudiante(String dniEstudiante);

	public Collection<Notas> findByDniEstudiante(String dniEstudiante);

	void insert(Notas nota);

	void update(Notas nota);

	Collection<Map<String, ?>> buscarNotasPorCurso(Integer cursoId, Integer seccionId);

	Map<String, ?> buscarPorId(Integer notaId);

	Notas findById(Integer notaId);

	Collection<Map<String, ?>> DniEstudiante(String dniEstudiante);

	void registrarNota(Integer seccionId, Integer cursoId, String dniEstudiante, Integer nota1, String fecha);

	void modificarNota(String fecha, Integer nota1, Integer nota2, Integer nota3, Integer notaId);

}
