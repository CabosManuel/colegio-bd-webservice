package idat.edu.pe.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Aula;
import idat.edu.pe.repository.AulaRepository;

@Service
public class AulaServiceImpl implements AulaService{

	@Autowired
	private AulaRepository r;
	
	@Transactional
	@Override
	public void insert(Aula aula) {
		r.save(aula);
		
	}

	@Transactional
	@Override
	public void update(Aula aula) {
		r.save(aula);
		
	}

	@Transactional
	@Override
	public void delete(Integer aulaId) {
		r.deleteById(aulaId);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Aula findById(Integer aulaId) {
		return r.findById(aulaId).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Aula> findAll() {
		return (Collection<Aula>)r.findAll();
	}
	
	

}
