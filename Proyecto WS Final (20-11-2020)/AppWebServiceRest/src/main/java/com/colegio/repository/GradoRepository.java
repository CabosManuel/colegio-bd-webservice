package com.colegio.repository;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.colegio.model.Grado;

public interface GradoRepository extends CrudRepository<Grado, Integer>{
	
	@Query(value="select n.nivel_id, g.grado_id, g.nombre, s.nombre as Seccion from grados g \r\n" + 
			"inner join secciones s on s.grado_id = g.grado_id \r\n" + 
			"inner join niveles n on g.nivel_id = n.nivel_id\r\n" + 
			"where n.nivel_id = ?", nativeQuery=true)
	public abstract Collection<Grado> findByNivel(Integer nivelId);
	
	@Query(value="select * from grados g\r\n" + 
			"inner join niveles n on g.nivel_id = n.nivel_id\r\n" + 
			"where n.nivel_id = ?", nativeQuery=true)
	public abstract Collection<Grado> getfindByNivel(Integer nivelId);
	
	@Query(value="select nombre from grados where grado_id = ?1", nativeQuery=true)
	Map<String, ?> buscarGrado(Integer gradoId);

}
