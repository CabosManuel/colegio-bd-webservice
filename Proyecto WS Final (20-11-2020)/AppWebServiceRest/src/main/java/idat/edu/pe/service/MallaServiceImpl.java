package idat.edu.pe.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Malla;
import idat.edu.pe.repository.MallaRepository;

@Service
public class MallaServiceImpl implements MallaService{

	@Autowired
	private MallaRepository r;

	@Transactional
	@Override
	public void insert(Malla malla) {
		r.save(malla);
	}

	@Transactional
	@Override
	public void update(Malla malla) {
		r.save(malla);
		
	}

	@Transactional
	@Override
	public void delete(Integer mallaId) {
		r.deleteById(mallaId);
	}

	@Transactional(readOnly = true)
	@Override
	public Malla findById(Integer mallaId) {
		return r.findById(mallaId).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Malla> findAll() {
		return (Collection<Malla>)r.findAll();
	}
	
	
}
