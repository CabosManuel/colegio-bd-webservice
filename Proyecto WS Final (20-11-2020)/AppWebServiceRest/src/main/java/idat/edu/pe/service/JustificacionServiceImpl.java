package idat.edu.pe.service;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Justificacion;
import idat.edu.pe.repository.JustificacionRepository;

@Service 
public class JustificacionServiceImpl  implements JustificacionService{

	@Autowired
	private JustificacionRepository repository;
	
	@Override
	@Transactional
	public void insert(Justificacion justificacion) {
		repository.save(justificacion);
		
	}

	@Override
	@Transactional
	public void update(Justificacion justificacion) {
		repository.save(justificacion);
		
	}

	@Override
	@Transactional
	public void delete(Integer justificacionId) {
		repository.deleteById(justificacionId);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Justificacion findById(Integer justificacionId) {
		return repository.findById(justificacionId).orElse(null);

	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Justificacion> findAll() {

		return (Collection<Justificacion>)repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Justificacion> findAllByFtitulo(String titulo) {
	
		return repository.findAllByFtitulo(titulo);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Justificacion> findAllByFdescripcion(String descripcion) {
	
		return repository.findAllByFdescripcion(descripcion);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Justificacion> findAllByFfecha(Date fecha) {

		return repository.findAllByFfecha(fecha);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Object[]> getJustificacionesByDniEstudiante(String dniEstudiante) {
		return repository.getJustificacionesByDniEstudiante(dniEstudiante);
	}

	@Override
	@Transactional
	public void registrarJustificacion(String dniEstudiante, String fechaEnvio, String fechaJustificacion,
					   String titulo, String descripcion){
		repository.registrarJustificacion(dniEstudiante, fechaEnvio, fechaJustificacion, titulo, descripcion);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String, Integer> getUltimoId(){
		return repository.getUltimoId();
	}
}
