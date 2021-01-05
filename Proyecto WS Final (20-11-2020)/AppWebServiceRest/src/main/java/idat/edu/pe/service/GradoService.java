package idat.edu.pe.service;

import java.util.Collection;

import idat.edu.pe.model.Grado;

public interface GradoService {

	public abstract void insert(Grado grado);
	public abstract void update(Grado grado);
	public abstract void delete(Integer gradoId);
	public abstract Grado findById(Integer gradoId);
	public abstract Collection<Grado> findAll();
	public Collection<Grado> findByNivel(Integer nivelId);
	
	public Collection<Grado> getfindByNivel(Integer nivelId);
	
}
