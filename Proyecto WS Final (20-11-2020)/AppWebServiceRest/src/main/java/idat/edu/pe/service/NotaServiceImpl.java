package idat.edu.pe.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.repository.NotaRepository;

@Service
public class NotaServiceImpl implements NotaService{

	@Autowired
	private NotaRepository r;
	
	@Override
	@Transactional(readOnly = true)
	public Collection<Object[]> findByDniEstudianteAnio(String dniEstudiante, String anio) {
		return r.findByDniEstudianteAnio(dniEstudiante, anio);
	}

	@Override
	public Collection<Object> getAniosByDniEstudiante(String dniEstudiante) {
		return r.getAniosByDniEstudiante(dniEstudiante);
	}
}
