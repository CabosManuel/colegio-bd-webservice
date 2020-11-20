package idat.edu.pe.service;

import java.util.Collection;

import idat.edu.pe.model.Estudiante;

public interface EstudianteService {
	
	public abstract void insert(Estudiante estudiante);
	public abstract void update(Estudiante estudiante);
	public abstract void delete(Integer estudianteId);
	public abstract Estudiante findById(Integer estudianteId);
	public abstract Collection<Estudiante> findAll();
	

}
