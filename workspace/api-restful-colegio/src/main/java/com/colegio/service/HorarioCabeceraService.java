package com.colegio.service;

import java.util.Collection;
import java.util.Map;

import com.colegio.model.HorarioCabecera;

public interface HorarioCabeceraService {

	void insert(HorarioCabecera horarioCabecera);

	void update(HorarioCabecera horarioCabecera);

	HorarioCabecera findById(Integer horarioCabeceraId);

	Collection<HorarioCabecera> findAll();

	Map<String, ?> getfindOneRegister();

}
