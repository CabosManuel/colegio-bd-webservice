package idat.edu.pe.service;

import java.util.Collection;

import idat.edu.pe.model.Aula;

public interface AulaService {

	public abstract void insert(Aula aula);
	public abstract void update(Aula aula);
	public abstract void delete(Integer aulaId);
	public abstract Aula findById(Integer aulaId);
	public abstract Collection<Aula> findAll();
	
}
