package idat.edu.pe.service;

import java.util.Collection;
import java.util.Map;

import idat.edu.pe.model.Asistencia;

public interface AsistenciaService {
	public Collection<Object[]> getAsistenciasByDniEstudianteFecha(String dniEstudiante, String fecha);
	public Collection<Object[]> getAsistenciasByDniEstudianteMesCurso(String dniEstudiante, Integer mes, String cursoId);
	public Collection<Object> getMesesByDniEstudiante(String dniEstudiante);
	public abstract void insert(Asistencia asistencia);
	public abstract void update(Asistencia asistencia);
	public abstract Asistencia findById(Integer asistenciaId);
	Collection<Map<String, ?>> buscarPorHorario(Integer horarioDetalleId);
	Map<String, ?> buscarPorId(Integer asistenciaId);
}
