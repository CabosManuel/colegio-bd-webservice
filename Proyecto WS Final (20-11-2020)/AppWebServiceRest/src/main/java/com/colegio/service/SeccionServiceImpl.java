package com.colegio.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colegio.model.Seccion;
import com.colegio.repository.SeccionRepository;

@Service
public class SeccionServiceImpl implements SeccionService {

	@Autowired
	private SeccionRepository r;
	
	@Transactional
	@Override
	public void insert(Seccion seccion) {
		r.save(seccion);
		
	}

	@Transactional
	@Override
	public void update(Seccion seccion) {
		r.save(seccion);
		
	}

	@Transactional
	@Override
	public void delete(Integer seccionId) {
		r.deleteById(seccionId);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Seccion findById(Integer seccionId) {
		return r.findById(seccionId).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Seccion> findAll() {
		return (Collection<Seccion>)r.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Map<String, ?>> findByGrado(Integer gradoId) {
		return (Collection<Map<String, ?>>)r.findByGrado(gradoId);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Map<String, ?>> getfindByNivel(Integer nivelId) {
		return (Collection<Map<String, ?>>)r.getfindByNivel(nivelId);
	}

	@Transactional(readOnly = true)
	@Override
	public Map<String, ?> buscarSeccion(Integer seccionId) {
		return r.buscarSeccion(seccionId);
	}

}
