package com.colegio.service;

import java.util.Collection;

import com.colegio.model.Malla;

public interface MallaService {

	public abstract void insert(Malla malla);
	public abstract void update(Malla malla);
	public abstract void delete(Integer mallaId);
	public abstract Malla findById(Integer mallaId);
	public abstract Collection<Malla> findAll();
	
}
