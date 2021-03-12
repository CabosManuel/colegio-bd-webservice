package com.colegio.service;

import java.util.Collection;

import com.colegio.model.Nivel;

public interface NivelService {

	public abstract void insert(Nivel nivel);
	public abstract void update(Nivel nivel);
	public abstract void delete(Integer nivelId);
	public abstract Nivel findById(Integer nivelId);
	public abstract Collection<Nivel> findAll();
	
}
