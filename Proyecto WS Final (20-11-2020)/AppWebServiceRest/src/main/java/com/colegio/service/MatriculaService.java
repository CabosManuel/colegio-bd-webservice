package com.colegio.service;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import com.colegio.model.Matricula;

public interface MatriculaService {

	void insert(Matricula matricula);

	void update(Matricula matricula);

	void delete(Integer matriculaId);

	Matricula findById(Integer matriculaId);

	Collection<Matricula> findAll();

	Map<String, ?> findByEstudiante(String dniEstudiante);

	void registrarMatricula(Date fecha, String grado, String nivel, String seccionId, String dniEstudiante);

}
