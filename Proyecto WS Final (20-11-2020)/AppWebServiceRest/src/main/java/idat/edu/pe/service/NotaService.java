package idat.edu.pe.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Nota;


public interface NotaService {
	public Collection<Object[]> findByDniEstudianteAnio(String dniEstudiante, String anio);
	public Collection<Object> getAniosByDniEstudiante(String dniEstudiante);
	public Collection<Nota> findByDniEstudiante(String dniEstudiante);
	public abstract void insert(Nota nota);
	public abstract void update(Nota nota);
	Collection<Map<String, ?>> buscarNotasPorCurso(Integer cursoId);
	Map<String, ?> buscarPorId(Integer notaId);
	public abstract Nota findById(Integer notaId);
}
