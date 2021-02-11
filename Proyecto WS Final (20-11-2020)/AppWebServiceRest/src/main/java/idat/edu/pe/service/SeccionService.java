package idat.edu.pe.service;

import java.util.Collection;
import java.util.Map;

import idat.edu.pe.model.Seccion;

public interface SeccionService {

	public abstract void insert(Seccion seccion);
	public abstract void update(Seccion seccion);
	public abstract void delete(Integer seccionId);
	public abstract Seccion findById(Integer seccionId);
	public abstract Collection<Seccion> findAll();
	
	Collection<Map<String, ?>> findByGrado(Integer gradoId);
	
	Collection<Map<String, ?>> getfindByNivel(Integer nivelId);
	Map<String, ?> buscarSeccion(Integer seccionId);
}
