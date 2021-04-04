package com.colegio.service;

import java.util.Collection;

import com.colegio.model.Malla;

public interface MallaService {

	void insert(Malla malla);

	void update(Malla malla);

	void delete(Integer mallaId);

	Malla findById(Integer mallaId);

	Collection<Malla> findAll();

}
