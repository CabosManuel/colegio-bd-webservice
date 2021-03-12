package com.colegio.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

import com.colegio.model.Asistencia;

public interface AsistenciaService {
	public Collection<Object[]> getAsistenciasByDniEstudianteFecha(String dniEstudiante, String fecha);
	public Collection<Object[]> getAsistenciasByDniEstudianteMesCurso(String dniEstudiante, Integer mes, String cursoId);
	public Collection<Object> getMesesByDniEstudiante(String dniEstudiante);
	public abstract void insert(Asistencia asistencia);
	public abstract void update(Asistencia asistencia);
	public abstract Asistencia findById(Integer asistenciaId);
	Collection<Map<String, ?>> buscarPorHorario(Integer horarioDetalleId);
	Map<String, ?> buscarPorId(Integer asistenciaId);
	void registrarAsistencia(LocalDateTime asistencia, Boolean estado, String dni_estudiante, String horario_detalle_id);
	void modificarAsistencia(LocalDateTime asistencia, Boolean estado, Integer asistenciaId);
}
