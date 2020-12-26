package idat.edu.pe.service;

import java.util.Collection;

public interface AsistenciaService {
	public Collection<Object[]> getAsistenciasByDniEstudianteFecha(String dniEstudiante, String fecha);
	public Collection<Object[]> getAsistenciasByDniEstudianteMesCurso(String dniEstudiante, Integer mes, String cursoId);
	public Collection<Object> getMesesByDniEstudiante(String dniEstudiante);
}
