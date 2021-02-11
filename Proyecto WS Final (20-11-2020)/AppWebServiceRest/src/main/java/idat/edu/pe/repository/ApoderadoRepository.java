package idat.edu.pe.repository;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
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

	@Query(value = "SELECT CONCAT(a.nombre, \" \", a.apellido) AS apoderado " 
			+ "FROM apoderados a "
			+ "INNER JOIN estudiantes e ON e.dni_apoderado LIKE a.dni_apoderado "
			+ "WHERE e.dni_estudiante LIKE ?", nativeQuery = true)
	String findNomApeApoderadoByDniEstudiante(String dniEstudiante);

	@Query(value = "select a.dni_apoderado, a.nombre, a.apellido from apoderados a "
			+ "where a.correo like ?", nativeQuery = true)
	Map<String, ?> buscarPorCorreo(String correo);

	@Query(value = "select nombre, apellido, dni_apoderado "
			+ "from apoderados where dni_apoderado = ?", nativeQuery = true)
	Map<String, ?> buscarPorDniApoderado(String dniApoderado);

	@Modifying
	@Query(value = "insert into apoderados (dni_apoderado, nombre, apellido, celular, correo, pass, direccion, estado, distrito_id) "
			+ "values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9);", nativeQuery = true)
	void nuevoApoderado(String dni_apoderado, String nombre, String apellido, String celular, String correo, String pass,
			String direccion, boolean estado, int distrito_id);
}
