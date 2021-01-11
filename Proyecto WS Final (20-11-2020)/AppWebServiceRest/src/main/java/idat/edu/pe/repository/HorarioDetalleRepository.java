package idat.edu.pe.repository;

import java.util.Collection;

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
}
