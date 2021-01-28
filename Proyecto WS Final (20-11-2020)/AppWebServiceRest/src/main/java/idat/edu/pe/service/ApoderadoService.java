package idat.edu.pe.service;

import java.util.Collection;
import java.util.Map;

import idat.edu.pe.model.Apoderado;

public interface ApoderadoService {

	void insert(Apoderado apoderado);

	void update(Apoderado apoderado);
	
	Collection<Apoderado> findAll();

	Apoderado findByDniApoderado(String dniApoderado);

	Collection<Object[]> getEstudiantesByDniApoderado(String dniApoderado);
	
	Map<String, ?> loginApoderado(String dniApoderado, String pass);
	
	String findNomApeApoderadoByDniEstudiante(String dniEstudiante);
}
