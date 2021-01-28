package idat.edu.pe.repository;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Estudiante;

public interface EstudianteRepository extends CrudRepository<Estudiante, String> {

	@Query(value = "select * from estudiantes where dni_estudiante = ?", nativeQuery = true)
	Estudiante findByDniEstudiante(String dniEstudiante);
	
	@Query(value = "select e.dni_estudiante, e.apellido, e.nombre, e.fnacimiento,"
			+ " e.correo, e.celular, e.pass, e.estado, e.direccion, d.distrito_id,"
			+ " d.distrito_id as distritoId, d.nombre as nomdistrito, "
			+ " a.dni_apoderado as dniApoderado, e.condicion from estudiantes e "
			+ " inner join apoderados a on e.dni_apoderado = a.dni_apoderado"
			+ " inner join distritos d on e.distrito_id = d.distrito_id "
			+ " where e.dni_estudiante = ?", nativeQuery = true)
	Map<String, ?> buscarEstudiante(String dniEstudiante);

	@Query(value = "select * from estudiantes where correo = ?", nativeQuery = true)
	Estudiante findByCorreo(String correo);

	@Query(value = "select * from estudiantes e\r\n"
			+ "inner join matriculas m on e.dni_estudiante = m.dni_estudiante\r\n"
			+ "inner join secciones s on m.seccion_id = s.seccion_id\r\n"
			+ "where s.seccion_id = ?", nativeQuery = true)
	Collection<Estudiante> getfindByEstudianteSeccion(Integer seccionId);

	@Query(value = "SELECT e.dni_estudiante, e.nombre, e.apellido " 
			+ "from estudiantes e "
			+ "where e.dni_apoderado like ?", nativeQuery = true)
	Collection<Map<String, ?>> findByDniApoderado(String dniApoderado);

	@Query(value = "select * from estudiantes e "
			+ "where e.dni_estudiante like ?1 and e.pass like ?2", nativeQuery = true)
	Map<String, ?> loginEstudiante(String dniEstudiante, String pass);

	/*
	 * @Query(name =
	 * "update estudiantes set estado = false where dni_estudiante =?", nativeQuery
	 * = true) void actualizarEstado(String dniEstudiante);
	 */
}
