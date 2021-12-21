package idat.edu.pe.repository;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Notificacion;

public interface NotificacionRepository extends CrudRepository<Notificacion, Integer>{
	
	@Query(value = "select n.notificacion_id, n.titulo, n.tipo, n.fecha_envio, n.fecha_limite, n.estado, n.dni_estudiante, n.descripcion "+
			"from notificaciones n " + 
			"where n.dni_estudiante like ?1 and " + 
		    	"(n.tipo like ?2 or n.tipo like ?3 or n.tipo like ?4) " + 
			"order by n.fecha_envio desc", nativeQuery = true)
	Collection<Object[]> getNotificacionesByDniEstudianteTipo(String dniEstudiante, String tipo1, String tipo2, String tipo3);
	
	@Modifying
	@Query(value = "update notificaciones set estado = :estado " +
						"where notificacion_id = :notificacionId", nativeQuery = true)
	void confirmarCitacion(@Param("estado")Character estado, @Param("notificacionId") Integer notificacionId);
	
	@Query(value = "select * from notificaciones where notificacion_id = ?", nativeQuery = true)
	Map<String, Object> buscarPorId(Integer notificacionId);
}
