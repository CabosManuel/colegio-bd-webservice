package com.colegio.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.colegio.model.Distrito;

public interface DistritoService {

	void insert(Distrito distrito);

	void update(Distrito distrito);

	void delete(Integer distritoId);

	Distrito findById(Integer distritoId);

	List<Distrito> findAll();

	Collection<Map<String, ?>> all();
}
