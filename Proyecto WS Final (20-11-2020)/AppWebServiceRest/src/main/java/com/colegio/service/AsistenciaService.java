package com.colegio.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

import com.colegio.model.Asistencia;

public interface AsistenciaService {
	Collection<Object[]> getAsistenciasByDniEstudianteFecha(String dniEstudiante, String fecha);

	Collection<Object[]> getAsistenciasByDniEstudianteMesCurso(String dniEstudiante, Integer mes, String cursoId);

	Collection<Object> getMesesByDniEstudiante(String dniEstudiante);

	void insert(Asistencia asistencia);

	void update(Asistencia asistencia);

	Asistencia findById(Integer asistenciaId);

	Collection<Map<String, ?>> buscarPorHorario(Integer horarioDetalleId);

	Map<String, ?> buscarPorId(Integer asistenciaId);

	void registrarAsistencia(LocalDateTime asistencia, Boolean estado, String dni_estudiante,
			String horario_detalle_id);

	void modificarAsistencia(LocalDateTime asistencia, Boolean estado, Integer asistenciaId);
}
