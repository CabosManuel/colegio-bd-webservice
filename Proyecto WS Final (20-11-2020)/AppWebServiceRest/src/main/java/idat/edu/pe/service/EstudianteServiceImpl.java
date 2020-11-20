package idat.edu.pe.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Estudiante;
import idat.edu.pe.repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	private EstudianteRepository repository;
	
	@Transactional
	@Override
	public void insert(Estudiante estudiante) {
		repository.save(estudiante);
		
	}

	@Transactional
	@Override
	public void update(Estudiante estudiante) {
		repository.save(estudiante);
		
	}

	@Transactional
	@Override
	public void delete(Integer estudianteId) {
		repository.deleteById(estudianteId);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Estudiante findById(Integer estudianteId) {
		return repository.findById(estudianteId).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Estudiante> findAll() {
		return(Collection<Estudiante>)repository.findAll();
	}

}
