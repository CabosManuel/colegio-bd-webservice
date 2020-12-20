package idat.edu.pe.service;

import java.util.Collection;


public interface NotaService {
	public Collection<Object[]> findByDniEstudianteAnio(String dniEstudiante, String anio);
	public Collection<Object> getAniosByDniEstudiante(String dniEstudiante);
}
