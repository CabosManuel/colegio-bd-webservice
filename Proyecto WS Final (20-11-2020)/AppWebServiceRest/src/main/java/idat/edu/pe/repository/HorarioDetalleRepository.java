package idat.edu.pe.repository;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.HorarioDetalle;

public interface HorarioDetalleRepository extends CrudRepository<HorarioDetalle, Integer> {

	@Query(value = "select hd.horario_detalle_id, hd.dia, hd.hora_inicio, hd.hora_fin,\r\n" +
			"c.curso_id, c.nombre as nombre_curso, t.trabajador_id from horario_detalle hd\r\n" + 
			"inner join horario_cabecera hc on hc.horario_cabecera_id = hd.horario_cabecera_id\r\n" + 
			"inner join secciones s on hc.seccion_id = s.seccion_id\r\n" + 
			"inner join cursos c on hd.curso_id = c.curso_id\r\n" +
			"inner join trabajadores t on hd.trabajador_id = t.trabajador_id\r\n" + 
			"where s.seccion_id = ? and t.trabajador_id = ?", nativeQuery = true)
	Collection<Map<String, ?>> getfindBySeccion(Integer seccionId, Integer trabajadorId);

	@Query(value = "select hd.dia, c.nombre, hd.hora_inicio, hd.hora_fin " + 
			"from horario_detalle hd " + 
			"inner join cursos c on c.curso_id = hd.curso_id " + 
			"inner join horario_cabecera hc on hc.horario_cabecera_id = hd.horario_cabecera_id " + 
			"inner join secciones s on s.seccion_id = hc.seccion_id " + 
			"inner join matriculas m on m.seccion_id = s.seccion_id " + 
			"inner join estudiantes e on e.dni_estudiante = m.dni_estudiante " + 
			"where e.dni_estudiante like ? and year(m.fecha) = 2020", nativeQuery = true)
	Collection<Map<String, ?>> findHorarioByDni(String dniEstudiante);
	
	@Query(value = "select hd.horario_detalle_id, hd.dia, hd.hora_inicio, hd.hora_fin, \r\n"
			+ "c.curso_id, hc.horario_cabecera_id, t.trabajador_id from horario_detalle hd\r\n"
			+ "inner join horario_cabecera hc on hc.horario_cabecera_id = hd.horario_cabecera_id\r\n"
			+ "inner join secciones s on hc.seccion_id = s.seccion_id\r\n"
			+ "inner join cursos c on hd.curso_id = c.curso_id\r\n"
			+ "inner join trabajadores t on hd.trabajador_id = t.trabajador_id\r\n"
			+ "where s.seccion_id like ?1", nativeQuery = true)
	Collection<Map<String, ?>> buscarHorarioPorSeccion(Integer seccionId);
	
	
	@Modifying
	@Query(value = "insert into horario_detalle " +
	       "(dia, hora_fin, hora_inicio, curso_id, trabajador_id, horario_cabecera_id) values " + 
	       "(?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
	void registrarHorarioDetalle(String dia, String horaFin, String horaInicio, String cursoId, String trabajadorId, String horario_cabecera_id);
	
	@Modifying
	@Query(value = "update horario_detalle set dia = ?1, hora_fin = ?2, hora_inicio = ?3, curso_id = ?4, trabajador_id = ?5 " + 
	       " where horario_detalle_id = ?6", nativeQuery = true)
	void modificarHorarioDetalle(String dia, String horaFin, String horaInicio, String cursoId, String trabajadorId, Integer horario_detalle_id);
}
