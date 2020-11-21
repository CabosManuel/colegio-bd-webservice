package idat.edu.pe.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Apoderado;
import idat.edu.pe.repository.ApoderadoRepository;

@Service
public class ApoderadoServiceImpl implements ApoderadoService{

	@Autowired
	private ApoderadoRepository r;
	
	@Transactional
	@Override
	public void insert(Apoderado apoderado) {
		r.save(apoderado);
	}

	@Transactional
	@Override
	public void update(Apoderado apoderado) {
		r.save(apoderado);		
	}

	@Transactional
	@Override
	public void delete(Integer apoderadoId) {
		r.deleteById(apoderadoId);		
	}

	@Transactional(readOnly = true)
	@Override
	public Apoderado findById(Integer apoderadoId) {
		return r.findById(apoderadoId).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Apoderado> findAll() {
		return (Collection<Apoderado>)r.findAll();
	}

}
