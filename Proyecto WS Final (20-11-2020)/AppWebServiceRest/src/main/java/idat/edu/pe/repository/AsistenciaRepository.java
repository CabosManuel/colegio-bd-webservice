package idat.edu.pe.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Asistencia;

public interface AsistenciaRepository extends CrudRepository<Asistencia, Integer>{
	
	// Lisata si asisitió o en un més específico 
	@Query(value = "select a.estado, convert(a.asistencia,date) " + 
			"from asistencias a " + 
			"where week(a.asistencia) " + 
			"between week(?2) and (week(last_day(?2))) " + // entre semana del primer día del mes, hasta la semana  del último día de ese mes
			"and a.dni_estudiante like ?1 "+
			"group by dayofyear(convert(a.asistencia,date))",nativeQuery=true) // agrupado por día, porque en un día hay más de un curso
	public abstract Collection<Object[]> getAsistenciasByDniEstudianteFecha(String dniEstudiante, String fecha);
	
	@Query(value = "select a.estado, convert(a.asistencia,date) ,hd.curso_id " + 
			"from asistencias a " + 
			"inner join horario_detalle hd " + 
			"on hd.horario_detalle_id = a.horario_detalle_id " + 
			"where a.dni_estudiante like ?1 and month(a.asistencia) = ?2 and hd.curso_id = ?3 " +
			"order by convert(a.asistencia,date)",nativeQuery = true)
	public abstract Collection<Object[]> getAsistenciasByDniEstudianteMesCurso(String dniEstudiante, Integer mes, String cursoId);
	
	@Query(value = "select distinct month(a.asistencia) " +
			"from asistencias a "+ //todavía no empieza el año escolar por eso pongo 2020, para traer lo del año pasado
			"where a.dni_estudiante like ? and year(a.asistencia) = 2020 "/*year(now())"*/ +
			"order by month(a.asistencia)",nativeQuery = true)
	public abstract Collection<Object> getMesesByDniEstudiante(String dniEstudiante);
	
	@Query(value = "select hd.horario_detalle_id, a.asistencia_id, a.asistencia, a.estado, e.dni_estudiante, e.nombre, e.apellido \r\n"
			+ "			from asistencias a\r\n"
			+ "         inner join horario_detalle hd on a.horario_detalle_id = hd.horario_detalle_id\r\n"
			+ "			inner join estudiantes e on a.dni_estudiante = e.dni_estudiante\r\n"
			+ "			where hd.horario_detalle_id like ?", nativeQuery = true)
	Collection<Map<String, ?>> buscarPorHorario(Integer horarioDetalleId);
	
	@Query(value = "select hd.horario_detalle_id, a.asistencia_id, a.asistencia, a.estado, e.dni_estudiante, e.nombre, e.apellido \r\n"
			+ "			from asistencias a\r\n"
			+ "         inner join horario_detalle hd on a.horario_detalle_id = hd.horario_detalle_id\r\n"
			+ "			inner join estudiantes e on a.dni_estudiante = e.dni_estudiante\r\n"
			+ "			where a.asistencia_id = ?", nativeQuery = true)
	Map<String, ?> buscarPorId(Integer asistenciaId);
	
	@Modifying
	@Query(value = "insert into asistencias " +
	       "(asistencia, estado, dni_estudiante, horario_detalle_id) values " + 
	       "(?1, ?2, ?3, ?4)", nativeQuery = true)
	void registrarAsistencia(LocalDateTime asistencia, Boolean estado, String dni_estudiante, String horario_detalle_id);
	
	@Modifying
	@Query(value = "update asistencias set asistencia = ?1, estado = ?2 " + 
	       " where asistencia_id = ?3", nativeQuery = true)
	void modificarAsistencia(LocalDateTime asistencia, Boolean estado, Integer asistenciaId);
}
