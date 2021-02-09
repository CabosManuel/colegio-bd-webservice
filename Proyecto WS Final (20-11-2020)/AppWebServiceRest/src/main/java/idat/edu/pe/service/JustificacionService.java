package idat.edu.pe.service;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import idat.edu.pe.model.Justificacion;


public interface JustificacionService {

	
	public abstract void insert(Justificacion justificacion);
	
	public abstract void update(Justificacion justificacion);
	
	public abstract void delete(Integer justificacionId);

	public abstract Justificacion findById(Integer justificacionId);
	
	public abstract Collection<Justificacion>findAll();
	
	public abstract Collection<Justificacion> findAllByFtitulo(String titulo);
	
	public abstract Collection<Justificacion> findAllByFdescripcion(String descripcion);
	
	public abstract Collection<Justificacion> findAllByFfecha(Date fecha);
	
	Collection<Object[]> getJustificacionesByDniEstudiante(String dniEstudiante);
	
	void registrarJustificacion(String dniEstudiante, String fechaEnvio, String fechaJustificacion, String titulo, String descripcion);
	
	Map<String, Integer> getUltimoId();
}
