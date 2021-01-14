package idat.edu.pe.repository;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.HorarioDetalle;

public interface HorarioDetalleRepository extends CrudRepository<HorarioDetalle, Integer> {

	@Query(value = "select * from horario_cabecera hc\r\n" + 
			"inner join horario_detalle hd on hc.horario_cabecera_id = hd.horario_cabecera_id\r\n" + 
			"inner join secciones s on hc.seccion_id = s.seccion_id\r\n" + 
			"inner join trabajadores t on hd.trabajador_id = t.trabajador_id\r\n" + 
			"where s.seccion_id = ? and t.trabajador_id = ?", nativeQuery = true)
	public abstract Collection<HorarioDetalle> getfindBySeccion(Integer seccionId, Integer trabajadorId);

	@Query(value = "select hd.dia, c.nombre, hd.hora_inicio, hd.hora_fin " + 
			"from horario_detalle hd " + 
			"inner join cursos c on c.curso_id = hd.curso_id " + 
			"inner join horario_cabecera hc on hc.horario_cabecera_id = hd.horario_cabecera_id " + 
			"inner join secciones s on s.seccion_id = hc.seccion_id " + 
			"inner join matriculas m on m.seccion_id = s.seccion_id " + 
			"inner join estudiantes e on e.dni_estudiante = m.dni_estudiante " + 
			"where e.dni_estudiante like ? and year(m.fecha) = 2020", nativeQuery = true)
	Collection<Map<String, ?>> findHorarioByDni(String dniEstudiante);
}
