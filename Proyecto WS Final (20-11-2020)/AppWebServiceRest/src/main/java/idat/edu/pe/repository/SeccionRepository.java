package idat.edu.pe.repository;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Seccion;

public interface SeccionRepository extends CrudRepository<Seccion, Integer>{
	
	@Query(value = "select s.seccion_id, s.nombre, g.grado_id from secciones s "
			+ "inner join grados g on s.grado_id = g.grado_id\r\n" + 
			  "where g.grado_id = ?", nativeQuery = true)
	Collection<Map<String, ?>> findByGrado(Integer gradoId);
	
	@Query(value="select s.seccion_id, g.grado_id, s.nombre from secciones s\r\n" + 
			"inner join grados g on s.grado_id = g.grado_id \r\n" + 
			"inner join niveles n on g.nivel_id = n.nivel_id\r\n" + 
			"where n.nivel_id =?", nativeQuery=true)
	Collection<Map<String, ?>> getfindByNivel(Integer nivelId);

}
