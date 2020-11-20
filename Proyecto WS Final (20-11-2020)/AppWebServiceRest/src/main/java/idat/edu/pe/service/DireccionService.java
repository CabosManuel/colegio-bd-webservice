package idat.edu.pe.service;

import java.util.Collection;

import idat.edu.pe.model.Direccion;

public interface DireccionService {
	
	public abstract void insert(Direccion direccion);
	public abstract void update(Direccion direccion);
	public abstract void delete(Integer direccionId);
	public abstract Direccion findById(Integer direccionId);
	public abstract Collection<Direccion> findAll();

}
