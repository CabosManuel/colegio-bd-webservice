package idat.edu.pe.service;

import java.util.Collection;
import java.util.Map;

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

	@Transactional(readOnly = true)
	@Override
	public Collection<Apoderado> findAll() {
		return (Collection<Apoderado>)r.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Apoderado findByDniApoderado(String dniApoderado) {
		return r.findByDniApoderado(dniApoderado);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Object[]> getEstudiantesByDniApoderado(String dniApoderado) {
		return r.getEstudiantesByDniApoderado(dniApoderado);
	}

	@Transactional(readOnly = true)
	@Override
	public Map<String, ?> loginApoderado(String dniApoderado, String pass){
		return r.loginApoderado(dniApoderado, pass);
	}
	
	@Transactional(readOnly = true)
	@Override
	public String findNomApeApoderadoByDniEstudiante(String dniEstudiante) {
		return r.findNomApeApoderadoByDniEstudiante(dniEstudiante);
	}
}
