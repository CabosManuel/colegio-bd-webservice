package idat.edu.pe.service;

import java.util.Collection;

import idat.edu.pe.model.Estudiante;

public interface EstudianteService {
	
	public abstract void insert(Estudiante estudiante);
	public abstract void update(Estudiante estudiante);
	//public abstract void delete(String dni_Estudiante);
	//public abstract Estudiante findById(String dni_Estudiante);
	public abstract Collection<Estudiante> findAll();
	
	public Estudiante findByDniEstudiante(String dniEstudiante);

}
