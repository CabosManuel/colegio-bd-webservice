package idat.edu.pe.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Grado;
import idat.edu.pe.repository.GradoRepository;

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

	
}