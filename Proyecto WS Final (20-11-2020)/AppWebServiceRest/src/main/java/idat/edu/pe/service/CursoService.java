package idat.edu.pe.service;

import java.util.Collection;
import java.util.Map;

import idat.edu.pe.model.Curso;

public interface CursoService {
	public abstract Curso findById(Integer cursoId);
	public Collection<Object[]> findByDniEstudiante(String dniEstudiante);
	public Collection<Curso> getfindByNivelGrado(Integer nivelId, Integer gradoId);
	Map<String, ?> findByCursoId(Integer cursoId);
}
