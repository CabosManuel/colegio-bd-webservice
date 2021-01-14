package idat.edu.pe.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Apoderado;

public interface ApoderadoRepository extends CrudRepository<Apoderado, String>{

	@Query(value="select * from apoderados where dni_apoderado = ?", nativeQuery = true)
	public abstract Apoderado findByDniApoderado(String dniApoderado);
	
	public abstract Apoderado findByDniApoderadoAndPass(String dniApoderado, String pass);
	
	@Query(value="select e.dni_estudiante, e.nombre " + 
			"from estudiantes e " + 
			"where e.dni_apoderado like ? ", nativeQuery=true)
	public abstract Collection<Object[]> getEstudiantesByDniApoderado(String dniApoderado);
}
