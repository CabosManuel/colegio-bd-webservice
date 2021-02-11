package idat.edu.pe.service;

import java.util.Collection;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Estudiante;
import idat.edu.pe.repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService {

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
		return (Collection<Estudiante>) repository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Estudiante findById(String dni_Estudiante) {
		return repository.findById(dni_Estudiante).orElse(null);
	}

	
	@Transactional(readOnly = true)
	@Override
	public Collection<Map<String, ?>> findByDniApoderado(String dniApoderado) {
		return repository.findByDniApoderado(dniApoderado);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Map<String, ?> loginEstudiante(String dniEstudiante, String pass) {
		return repository.loginEstudiante(dniEstudiante, pass);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Map<String, ?> buscarEstudiante(String dniEstudiante) {
		return repository.buscarEstudiante(dniEstudiante);
	}

	@Transactional(readOnly = true)
	@Override
	public Map<String, Object> findInMapByDniEstudiante(String dniEstudiante) {
		return repository.findInMapByDniEstudiante(dniEstudiante);
	}

	@Transactional(readOnly = true)
	@Override	
	public Collection<Map<String, ?>> findByEstudiantes(Integer seccionId) {
		return repository.findByEstudiantes(seccionId);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Map<String, ?>> buscarEstudiantesPorCurso(Integer cursoId) {
		return repository.buscarEstudiantesPorCurso(cursoId);

	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Map<String, ?>> buscarEstudiantes() {
		return repository.buscarEstudiantes();
	}

	@Transactional
	@Override
	public void modificarEstudiante(String nombre, String apellido, String celular, String fnacimiento, String correo,
			Integer distritoId, String direccion, String dniEstudiante) {
		repository.modificarEstudiante(nombre, apellido, celular, fnacimiento, correo, distritoId, direccion, dniEstudiante);
		
	}

	@Transactional
	@Override
	public void registrarEstudiante(String dniEstudiante, String nombre, String apellido, String celular, String correo,
			String fnacimiento, String dniApoderado, Integer distritoId, String direccion, String pass, String condicion, Boolean estado) {
		repository.registrarEstudiante(dniEstudiante, nombre, apellido, celular, correo, fnacimiento, dniApoderado, 
				distritoId, direccion, pass, condicion, estado);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Map<String, ?> buscarCorreo(String correo) {
		return repository.buscarCorreo(correo);
	}
}
