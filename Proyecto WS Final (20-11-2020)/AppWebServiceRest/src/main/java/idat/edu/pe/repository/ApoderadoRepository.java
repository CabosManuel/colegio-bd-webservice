package idat.edu.pe.repository;

import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.model.Apoderado;
import idat.edu.pe.model.Estudiante;

public interface ApoderadoRepository extends CrudRepository<Apoderado, String>{

	public abstract Apoderado findByDniApoderado(String dniApoderado);
	
}
