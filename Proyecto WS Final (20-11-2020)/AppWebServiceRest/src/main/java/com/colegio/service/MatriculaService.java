package com.colegio.service;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import com.colegio.model.Matricula;

public interface MatriculaService {

	public abstract void insert(Matricula matricula);
	public abstract void update(Matricula matricula);
	public abstract void delete(Integer matriculaId);
	public abstract Matricula findById(Integer matriculaId);
	public abstract Collection<Matricula> findAll();
	
	Map<String, ?> findByEstudiante(String dniEstudiante);
	void registrarMatricula(Date fecha, String grado, String nivel, String seccionId, String dniEstudiante);
	
}
