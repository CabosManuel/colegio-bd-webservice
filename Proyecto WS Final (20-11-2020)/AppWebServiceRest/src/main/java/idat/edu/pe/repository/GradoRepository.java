package idat.edu.pe.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Grado;

public interface GradoRepository extends CrudRepository<Grado, Integer>{
	
	@Query(value="select * from grados g\r\n" + 
			"inner join niveles n on g.nivel_id = n.nivel_id\r\n" + 
			"where n.nivel_id = ?", nativeQuery=true)
	public abstract Collection<Grado> findByNivel(Integer nivelId);

}
