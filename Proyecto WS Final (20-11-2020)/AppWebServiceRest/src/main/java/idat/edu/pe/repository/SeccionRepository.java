package idat.edu.pe.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Seccion;

public interface SeccionRepository extends CrudRepository<Seccion, Integer>{
	
	@Query(value = "select s.seccion_id, s.nombre, g.grado_id from secciones s inner join grados g on s.grado_id = g.grado_id\r\n" + 
			"where g.grado_id = ?", nativeQuery = true)
	public abstract Collection<Seccion> findByGrado(Integer gradoId);

}
