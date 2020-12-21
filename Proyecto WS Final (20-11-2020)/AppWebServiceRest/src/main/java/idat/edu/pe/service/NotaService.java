package idat.edu.pe.service;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Nota;


public interface NotaService {
	public Collection<Object[]> findByDniEstudianteAnio(String dniEstudiante, String anio);
	public Collection<Object> getAniosByDniEstudiante(String dniEstudiante);
	public Collection<Nota> findByDniEstudiante(String dniEstudiante);
}
