package idat.edu.pe.service;

import java.util.Collection;

import idat.edu.pe.model.Apoderado;

public interface ApoderadoService {
	
	public abstract void insert(Apoderado apoderado);
	public abstract void update(Apoderado apoderado);
	public abstract void delete(Integer apoderadoId);
	public abstract Apoderado findById(Integer apoderadoId);
	public abstract Collection<Apoderado> findAll();
	

}
