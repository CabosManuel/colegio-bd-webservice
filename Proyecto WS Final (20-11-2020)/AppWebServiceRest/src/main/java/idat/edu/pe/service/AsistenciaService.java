package idat.edu.pe.service;

import java.util.Collection;

public interface AsistenciaService {
	public Collection<Object[]> getAsistenciasByDniEstudianteFecha(String dniEstudiante, String fecha);
}
