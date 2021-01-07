package idat.edu.pe.repository;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Estudiante;

public interface EstudianteRepository extends CrudRepository<Estudiante, String>{
	
	public abstract Estudiante findByDniEstudiante(String dniEstudiante);
	
	public Estudiante findByDniEstudianteAndPass(String dniEstudiante, String pass);
	
	@Query(value = "SELECT e.dni_estudiante, e.nombre, e.apellido " + 
			"from estudiantes e " + 
			"where e.dni_apoderado like ?", nativeQuery = true)
	Collection<Map<String, ?>> findByDniApoderado(String dniApoderado);
	
	/*@Query(name = "update estudiantes set estado = false where dni_estudiante =?", nativeQuery = true)
	public abstract void actualizarEstado(String dniEstudiante);*/

}
