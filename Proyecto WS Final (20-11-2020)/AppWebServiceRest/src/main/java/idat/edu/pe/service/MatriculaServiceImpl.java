package idat.edu.pe.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Matricula;
import idat.edu.pe.repository.MatriculaRepository;

@Service
public class MatriculaServiceImpl implements MatriculaService{

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
		return (Collection<Matricula>)r.findAll();
	}
	
	
}