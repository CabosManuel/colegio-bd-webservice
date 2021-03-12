package com.colegio.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colegio.model.Grado;
import com.colegio.repository.GradoRepository;

@Service
public class GradoServiceImpl implements GradoService {

	@Autowired
	private GradoRepository r;
	
	@Transactional
	@Override
	public void insert(Grado grado) {
		r.save(grado);
	}

	@Transactional
	@Override
	public void update(Grado grado) {
		r.save(grado);
		
	}

	@Transactional
	@Override
	public void delete(Integer gradoId) {
		r.deleteById(gradoId);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Grado findById(Integer gradoId) {
		return r.findById(gradoId).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Grado> findAll() {
		return (Collection<Grado>)r.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Grado> findByNivel(Integer nivelId) {
		return (Collection<Grado>)r.findByNivel(nivelId);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Grado> getfindByNivel(Integer nivelId) {
		return r.getfindByNivel(nivelId);
	}

	@Transactional(readOnly = true)
	@Override
	public Map<String, ?> buscarGrado(Integer gradoId) {
		return r.buscarGrado(gradoId);
	}

	
}
