package com.colegio.service;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colegio.model.Matricula;
import com.colegio.repository.MatriculaRepository;

@Service
public class MatriculaServiceImpl implements MatriculaService {

	@Autowired
	private MatriculaRepository r;

	@Transactional
	@Override
	public void insert(Matricula matricula) {
		r.save(matricula);

	}

	@Transactional
	@Override
	public void update(Matricula matricula) {
		r.save(matricula);

	}

	@Transactional
	@Override
	public void delete(Integer matriculaId) {
		r.deleteById(matriculaId);

	}

	@Transactional(readOnly = true)
	@Override
	public Matricula findById(Integer matriculaId) {
		return r.findById(matriculaId).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Matricula> findAll() {
		return (Collection<Matricula>) r.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Map<String, ?> findByEstudiante(String dniEstudiante) {
		return r.findByEstudiante(dniEstudiante);
	}

	@Transactional
	@Override
	public void registrarMatricula(Date fecha, String grado, String nivel, String seccionId, String dniEstudiante) {
		r.registrarMatricula(fecha, grado, nivel, seccionId, dniEstudiante);

	}

}
