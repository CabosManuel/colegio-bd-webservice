package idat.edu.pe.service;

import java.util.Collection;

public interface CursoService {
	public Collection<Object[]> findByDniEstudiante(String dniEstudiante);
}
