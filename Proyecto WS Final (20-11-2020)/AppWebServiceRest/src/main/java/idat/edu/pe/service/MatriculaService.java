package idat.edu.pe.service;

import java.util.Collection;
import java.util.Map;

import idat.edu.pe.model.Matricula;

public interface MatriculaService {

	public abstract void insert(Matricula matricula);
	public abstract void update(Matricula matricula);
	public abstract void delete(Integer matriculaId);
	public abstract Matricula findById(Integer matriculaId);
	public abstract Collection<Matricula> findAll();
	
	Map<String, ?> findByEstudiante(String dniEstudiante);
	void registrarMatricula(String grado, String nivel, String seccionId, String dniEstudiante);
	
}
