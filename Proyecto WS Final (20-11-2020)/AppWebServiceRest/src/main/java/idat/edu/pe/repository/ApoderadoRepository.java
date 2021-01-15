package idat.edu.pe.repository;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Apoderado;

public interface ApoderadoRepository extends CrudRepository<Apoderado, String> {

	@Query(value = "select * from apoderados where dni_apoderado = ?", nativeQuery = true)
	Apoderado findByDniApoderado(String dniApoderado);

	@Query(value = "select e.dni_estudiante, e.nombre " + "from estudiantes e "
			+ "where e.dni_apoderado like ? ", nativeQuery = true)
	Collection<Object[]> getEstudiantesByDniApoderado(String dniApoderado);

	@Query(value = "select * from apoderados a "
			+ "where a.dni_apoderado like ?1 and a.pass like ?2", nativeQuery = true)
	Map<String, ?> loginApoderado(String dniApoderado, String pass);
}
