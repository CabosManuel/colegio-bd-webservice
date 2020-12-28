package idat.edu.pe.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Trabajador;
import idat.edu.pe.repository.TrabajadorRepository;

@Service
public class TrabajadorServiceIml implements TrabajadorService{
	
	@Autowired
	private TrabajadorRepository r;

	@Transactional
	@Override
	public void insert(Trabajador trabajador) {
		r.save(trabajador);		
	}

	@Transactional
	@Override
	public void update(Trabajador trabajador) {
		r.save(trabajador);
	}

	@Transactional
	@Override
	public void delete(Integer trabajadorId) {
		r.deleteById(trabajadorId);
	}

	@Transactional(readOnly = true)
	@Override
	public Trabajador findById(Integer trabajadorId) {
		return r.findById(trabajadorId).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Trabajador> findAll() {
		return (Collection<Trabajador>) r.findAll();
	}

	@Override
	public Collection<Trabajador> getfindByCurso(Integer cursoId) {
		return (Collection<Trabajador>)r.getfindByCurso(cursoId);
	}
}
