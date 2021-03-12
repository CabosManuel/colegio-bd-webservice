package com.colegio.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colegio.model.Nivel;
import com.colegio.repository.NivelRepository;

@Service
public class NivelServiceImpl implements NivelService {

	@Autowired
	private NivelRepository r;
	
	@Transactional
	@Override
	public void insert(Nivel nivel) {
		r.save(nivel);
	}

	@Transactional
	@Override
	public void update(Nivel nivel) {
		r.save(nivel);
	}

	@Transactional
	@Override
	public void delete(Integer nivelId) {
		r.deleteById(nivelId);
	}

	@Transactional(readOnly = true)
	@Override
	public Nivel findById(Integer nivelId) {
		return r.findById(nivelId).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Nivel> findAll() {
		return (Collection<Nivel>)r.findAll();
	}

}
