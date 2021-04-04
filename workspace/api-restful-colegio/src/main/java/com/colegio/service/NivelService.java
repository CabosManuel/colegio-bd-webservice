package com.colegio.service;

import java.util.Collection;

import com.colegio.model.Nivel;

public interface NivelService {

	void insert(Nivel nivel);

	void update(Nivel nivel);

	void delete(Integer nivelId);

	Nivel findById(Integer nivelId);

	Collection<Nivel> findAll();

}
