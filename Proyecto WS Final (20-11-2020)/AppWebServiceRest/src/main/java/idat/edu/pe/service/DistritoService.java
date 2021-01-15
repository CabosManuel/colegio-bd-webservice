package idat.edu.pe.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import idat.edu.pe.model.Distrito;

public interface DistritoService {
	
	public abstract void insert(Distrito distrito);
	public abstract void update(Distrito distrito);
	public abstract void delete(Integer distritoId);
	public abstract Distrito findById(Integer distritoId);
	public abstract List<Distrito> findAll();

	Collection<Map<String,?>> all();
}
