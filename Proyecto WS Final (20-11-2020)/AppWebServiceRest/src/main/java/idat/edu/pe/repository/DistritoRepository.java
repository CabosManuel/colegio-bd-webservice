package idat.edu.pe.repository;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Distrito;

public interface DistritoRepository extends CrudRepository<Distrito, Integer>{
	
	@Query(value = "select * from distritos", nativeQuery = true)
	Collection<Map<String,?>> all();
}
