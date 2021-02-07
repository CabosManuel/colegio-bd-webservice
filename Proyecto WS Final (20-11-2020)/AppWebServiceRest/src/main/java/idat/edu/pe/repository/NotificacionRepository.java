package idat.edu.pe.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Notificacion;

public interface NotificacionRepository extends CrudRepository<Notificacion, Integer>{
	
	@Query(value = "select n.notificacion_id, n.titulo, n.tipo, n.fecha_envio, n.fecha_limite, n.estado, n.dni_estudiante, n.descripcion "+
			"from notificaciones n " + 
			"where n.dni_estudiante like ?1 and " + 
		    	"(n.tipo like ?2 or n.tipo like ?3 or n.tipo like ?4) " + 
			"order by n.fecha_envio desc", nativeQuery = true)
	public abstract Collection<Object[]> getNotificacionesByDniEstudianteTipo(String dniEstudiante, String tipo1, String tipo2, String tipo3);
}
