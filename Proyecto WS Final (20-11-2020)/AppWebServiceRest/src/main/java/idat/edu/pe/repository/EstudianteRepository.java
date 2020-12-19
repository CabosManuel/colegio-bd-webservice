package idat.edu.pe.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Estudiante;

public interface EstudianteRepository extends CrudRepository<Estudiante, String>{
	
	public abstract Estudiante findByDniEstudiante(String dniEstudiante);
	
	/*@Query(name = "update estudiantes set estado = false where dni_estudiante =?", nativeQuery = true)
	public abstract void actualizarEstado(String dniEstudiante);*/

}
