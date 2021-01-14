package idat.edu.pe.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Apoderado;
import idat.edu.pe.model.Distrito;
import idat.edu.pe.model.Estudiante;
import idat.edu.pe.repository.DistritoRepository;
import idat.edu.pe.repository.EstudianteRepository;
import idat.edu.pe.service.*;

//@Repository
@Service
public class EstudianteServiceImpl implements EstudianteService{

	@PersistenceContext
	private EntityManager em;
	
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

	@Transactional(readOnly = true)
	@Override
	public Estudiante findByDniEstudiante(String dniEstudiante) {
		return repository.findByDniEstudiante(dniEstudiante);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Estudiante> findAll() {
		return(Collection<Estudiante>)repository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Estudiante findById(String dni_Estudiante) {
		return repository.findById(dni_Estudiante).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public Estudiante findByDniEstudianteAndPass(String dniEstudiante, String pass) {
		return repository.findByDniEstudianteAndPass(dniEstudiante, pass);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Map<String, ?>> findByDniApoderado(String dniApoderado) {
		return repository.findByDniApoderado(dniApoderado);
	}

	@Override
	public Estudiante findByCorreo(String correo) {
		return repository.findByCorreo(correo);
	}

}
