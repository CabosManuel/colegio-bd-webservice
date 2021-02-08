package idat.edu.pe.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Justificacion;

public interface JustificacionRepository extends CrudRepository<Justificacion, Integer> {

	@Query(value = "select * from justificaciones where titulo=?", nativeQuery = true)
	public abstract Collection<Justificacion> findAllByFtitulo(String titulo);

	@Query(value = "select * from justificaciones where descripcion=?", nativeQuery = true)
	public abstract Collection<Justificacion> findAllByFdescripcion(String descripcion);

	@Query(value = "select * from justificaciones where fecha=?", nativeQuery = true)
	public abstract Collection<Justificacion> findAllByFfecha(Date fecha);
	
	@Query(value = "select j.justificacion_id, j.titulo, j.fecha_envio, j.fecha_justificacion, j.dni_estudiante, j.descripcion " + 
			"from justificaciones j " + 
			"where j.dni_estudiante like ? " +
			"order by j.fecha_envio desc", nativeQuery = true)
	Collection<Object[]> getJustificacionesByDniEstudiante(String dniEstudiante);
	
	@Query(value = "insert into justificaciones" +
	       "(titulo, fecha_envio, fecha_justificacion, dni_estudiante, descripcion) values " + 
	       "(?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
	void registrarJustificacion(String dniEstudiante, Date fechaEnvio, Date fechaJustificacion, String titulo, String descripcion);
}
