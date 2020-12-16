package idat.edu.pe.repository;

import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Estudiante;

public interface EstudianteRepository extends CrudRepository<Estudiante, String>{
	
	public abstract Estudiante findByDniEstudiante(String dniEstudiante);

}
