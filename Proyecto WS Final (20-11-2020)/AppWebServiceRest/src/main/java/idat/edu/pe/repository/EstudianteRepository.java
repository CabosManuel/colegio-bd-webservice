package idat.edu.pe.repository;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Estudiante;
import idat.edu.pe.model.Matricula;

public interface EstudianteRepository extends CrudRepository<Estudiante, String> {

	@Query(value = "select * from estudiantes where dni_estudiante = ?", nativeQuery = true)
	Estudiante findByDniEstudiante(String dniEstudiante);
	
	@Query(value = "select e.dni_estudiante, e.apellido, e.nombre, e.fnacimiento,"
			+ " e.correo, e.celular, e.pass, e.estado, e.direccion, d.distrito_id,"
			+ " d.nombre as nomdistrito, "
			+ " a.dni_apoderado as dniApoderado, e.condicion from estudiantes e "
			+ " inner join apoderados a on e.dni_apoderado = a.dni_apoderado"
			+ " inner join distritos d on e.distrito_id = d.distrito_id "
			+ " where e.dni_estudiante = ?", nativeQuery = true)
	Map<String, ?> buscarEstudiante(String dniEstudiante);
	
	@Query(value = "select e.dni_estudiante, e.apellido, e.nombre, e.fnacimiento,"
			+ " e.correo, e.celular, e.pass, e.estado, e.direccion, d.distrito_id,"
			+ " d.nombre as nomdistrito, "
			+ " a.dni_apoderado, e.condicion from estudiantes e "
			+ " inner join apoderados a on e.dni_apoderado = a.dni_apoderado"
			+ " inner join distritos d on e.distrito_id = d.distrito_id", nativeQuery = true)
	Collection<Map<String, ?>> buscarEstudiantes();

	@Query(value = "select correo from estudiantes where correo = ?1", nativeQuery = true)
	Map<String, ?> buscarCorreo(String correo);	

	@Query(value = "SELECT e.dni_estudiante, e.nombre, e.apellido " 
			+ "from estudiantes e "
			+ "where e.dni_apoderado like ?", nativeQuery = true)
	Collection<Map<String, ?>> findByDniApoderado(String dniApoderado);
	
	@Query(value = "select e.dni_estudiante, e.nombre, e.apellido from estudiantes e\r\n"
			+ "inner join matriculas m on e.dni_estudiante = m.dni_estudiante\r\n"
			+ "inner join secciones s on m.seccion_id = s.seccion_id\r\n"
			+ "where s.seccion_id like ?", nativeQuery = true)
	Collection<Map<String, ?>> findByEstudiantes(Integer seccionId);

	@Query(value = "select * from estudiantes e "
			+ "where e.dni_estudiante like ?1 and e.pass like ?2", nativeQuery = true)
	Map<String, ?> loginEstudiante(String dniEstudiante, String pass);

	@Query(value = "select * from estudiantes where dni_estudiante = ?", nativeQuery = true)
	Map<String, Object> findInMapByDniEstudiante(String dniEstudiante);

	/*
	 * @Query(name =
	 * "update estudiantes set estado = false where dni_estudiante =?", nativeQuery
	 * = true) void actualizarEstado(String dniEstudiante);
	 */

	@Query(value="select e.dni_estudiante, e.nombre, e.apellido from estudiantes e\r\n"
			+ "			inner join matriculas m on e.dni_estudiante = m.dni_estudiante\r\n"
			+ "            inner join horario_cabecera hc on m.seccion_id = hc.seccion_id\r\n"
			+ "            inner join horario_detalle hd on hc.horario_cabecera_id = hd.horario_cabecera_id\r\n"
			+ "            inner join cursos c on hd.curso_id = c.curso_id\r\n"
			+ "			where c.curso_id like ?", nativeQuery=true)
	Collection<Map<String, ?>> buscarEstudiantesPorCurso(Integer cursoId);

	@Modifying
	@Query(value = "update estudiantes set nombre = ?1, apellido = ?2, celular = ?3, " +
				   "fnacimiento = ?4, correo = ?5, distrito_id = ?6, direccion = ?7 where dni_estudiante = ?8", 
				   nativeQuery = true)
	void modificarEstudiante(String nombre, String apellido, String celular,  String fnacimiento, String correo, Integer distritoId
			, String direccion, String dniEstudiante);
	
	@Modifying
	@Query(value = "insert into estudiantes" +
	       "(dni_estudiante, nombre, apellido, celular, correo, fnacimiento, dni_apoderado, distrito_id, direccion, pass, condicion, estado) values " + 
	       "(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12)", nativeQuery = true)
	void registrarEstudiante(String dniEstudiante, String nombre, String apellido, String celular, String correo, String fnacimiento, 
			String dniApoderado, Integer distritoId, String direccion, String pass, String condicion, Boolean estado);

	
}
